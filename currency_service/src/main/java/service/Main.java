package service;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        int serverPort = 50001;

        ExchangeRateServiceManager exchangeRateServiceManager = new ExchangeRateServiceManager(serverPort);
        exchangeRateServiceManager.start();

    }

}
