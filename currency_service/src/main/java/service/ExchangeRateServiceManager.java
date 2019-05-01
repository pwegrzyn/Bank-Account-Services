package service;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import io.vavr.Tuple2;

import java.io.IOException;
import java.util.List;

public class ExchangeRateServiceManager {

    private final int serverPort;
    private Server server;
    private ExchangeRateMarket exchangeRateMarket;
    private int fluctuationTime;

    public ExchangeRateServiceManager(int serverPort) {
        this.serverPort = serverPort;
        this.exchangeRateMarket = new ExchangeRateMarket();
        this.fluctuationTime = 7000;
    }

    private void stop() {
        if (this.server != null) {
            this.server.shutdown();
        }
    }

    public void start() throws IOException, InterruptedException {
        this.server = ServerBuilder.forPort(this.serverPort)
                .addService(new ExchangeRateServiceImpl())
                .build()
                .start();
        System.out.println("Listening for clients on port " + this.serverPort + "...");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("Shutting down.");
                ExchangeRateServiceManager.this.stop();
            }
        });
        if (this.server != null) {
            this.server.awaitTermination();
        }
    }

    private class ExchangeRateServiceImpl extends ExchangeRateServiceGrpc.ExchangeRateServiceImplBase {

        @Override
        public void getExchangeRateStream(ExchangeRateRequest request,
                                                  StreamObserver<ExchangeRateSequence> responseObserver) {
            System.out.println("The client has initialized a stream of exchange rate updates.");
            List<CurrencyEntity> oldRates = null;
            while (true) {
                ExchangeRateSequence.Builder exchangeRateSequenceBuilder = ExchangeRateSequence.newBuilder();
                Tuple2<List<CurrencyEntity>, List<CurrencyEntity>> result = ExchangeRateServiceManager.this.exchangeRateMarket
                        .getChangedRates(request, oldRates);
                oldRates = result._1;
                List<CurrencyEntity> currencyEntities = result._2;
                if (currencyEntities.size() > 0) {
                    for(CurrencyEntity entity : currencyEntities) {
                        ExchangeRateInfo info = ExchangeRateInfo.newBuilder()
                                .setCurrency(entity.getType())
                                .setRate(entity.getRate())
                                .build();
                        exchangeRateSequenceBuilder.addExchangeRateInfo(info);
                    }
                    ExchangeRateSequence exchangeRateSequence = exchangeRateSequenceBuilder.build();
                    responseObserver.onNext(exchangeRateSequence);
                }
                try {
                    Thread.sleep(ExchangeRateServiceManager.this.fluctuationTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void getInitialExchangeRates(ExchangeRateRequest request,
                                            StreamObserver<ExchangeRateSequence> responseObserver) {
            System.out.println("A client has requested an initial currency exchange rates list.");
            System.out.println("The client is interested in the following currencies:");
            for (Currency currency : request.getCurrencyTypeList()) {
                System.out.println(" - " + currency.toString());
            }
            ExchangeRateSequence.Builder exchangeRateSequenceBuilder = ExchangeRateSequence.newBuilder();
            List<CurrencyEntity> currencyEntities = ExchangeRateServiceManager.this.exchangeRateMarket
                    .getAllRates(request);
            if (currencyEntities.size() == 0) {
                responseObserver.onCompleted();
                return;
            }
            for(CurrencyEntity entity : currencyEntities) {
                ExchangeRateInfo info = ExchangeRateInfo.newBuilder()
                        .setCurrency(entity.getType())
                        .setRate(entity.getRate())
                        .build();
                exchangeRateSequenceBuilder.addExchangeRateInfo(info);
            }
            ExchangeRateSequence exchangeRateSequence = exchangeRateSequenceBuilder.build();
            responseObserver.onNext(exchangeRateSequence);
            responseObserver.onCompleted();
        }

    }

}
