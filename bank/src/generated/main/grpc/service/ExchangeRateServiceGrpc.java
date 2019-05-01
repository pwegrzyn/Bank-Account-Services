package service;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.12.0)",
    comments = "Source: currency_service.proto")
public final class ExchangeRateServiceGrpc {

  private ExchangeRateServiceGrpc() {}

  public static final String SERVICE_NAME = "ExchangeRateService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetExchangeRateStreamMethod()} instead. 
  public static final io.grpc.MethodDescriptor<service.ExchangeRateRequest,
      service.ExchangeRateSequence> METHOD_GET_EXCHANGE_RATE_STREAM = getGetExchangeRateStreamMethodHelper();

  private static volatile io.grpc.MethodDescriptor<service.ExchangeRateRequest,
      service.ExchangeRateSequence> getGetExchangeRateStreamMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<service.ExchangeRateRequest,
      service.ExchangeRateSequence> getGetExchangeRateStreamMethod() {
    return getGetExchangeRateStreamMethodHelper();
  }

  private static io.grpc.MethodDescriptor<service.ExchangeRateRequest,
      service.ExchangeRateSequence> getGetExchangeRateStreamMethodHelper() {
    io.grpc.MethodDescriptor<service.ExchangeRateRequest, service.ExchangeRateSequence> getGetExchangeRateStreamMethod;
    if ((getGetExchangeRateStreamMethod = ExchangeRateServiceGrpc.getGetExchangeRateStreamMethod) == null) {
      synchronized (ExchangeRateServiceGrpc.class) {
        if ((getGetExchangeRateStreamMethod = ExchangeRateServiceGrpc.getGetExchangeRateStreamMethod) == null) {
          ExchangeRateServiceGrpc.getGetExchangeRateStreamMethod = getGetExchangeRateStreamMethod = 
              io.grpc.MethodDescriptor.<service.ExchangeRateRequest, service.ExchangeRateSequence>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ExchangeRateService", "getExchangeRateStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.ExchangeRateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.ExchangeRateSequence.getDefaultInstance()))
                  .setSchemaDescriptor(new ExchangeRateServiceMethodDescriptorSupplier("getExchangeRateStream"))
                  .build();
          }
        }
     }
     return getGetExchangeRateStreamMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetInitialExchangeRatesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<service.ExchangeRateRequest,
      service.ExchangeRateSequence> METHOD_GET_INITIAL_EXCHANGE_RATES = getGetInitialExchangeRatesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<service.ExchangeRateRequest,
      service.ExchangeRateSequence> getGetInitialExchangeRatesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<service.ExchangeRateRequest,
      service.ExchangeRateSequence> getGetInitialExchangeRatesMethod() {
    return getGetInitialExchangeRatesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<service.ExchangeRateRequest,
      service.ExchangeRateSequence> getGetInitialExchangeRatesMethodHelper() {
    io.grpc.MethodDescriptor<service.ExchangeRateRequest, service.ExchangeRateSequence> getGetInitialExchangeRatesMethod;
    if ((getGetInitialExchangeRatesMethod = ExchangeRateServiceGrpc.getGetInitialExchangeRatesMethod) == null) {
      synchronized (ExchangeRateServiceGrpc.class) {
        if ((getGetInitialExchangeRatesMethod = ExchangeRateServiceGrpc.getGetInitialExchangeRatesMethod) == null) {
          ExchangeRateServiceGrpc.getGetInitialExchangeRatesMethod = getGetInitialExchangeRatesMethod = 
              io.grpc.MethodDescriptor.<service.ExchangeRateRequest, service.ExchangeRateSequence>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ExchangeRateService", "getInitialExchangeRates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.ExchangeRateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.ExchangeRateSequence.getDefaultInstance()))
                  .setSchemaDescriptor(new ExchangeRateServiceMethodDescriptorSupplier("getInitialExchangeRates"))
                  .build();
          }
        }
     }
     return getGetInitialExchangeRatesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ExchangeRateServiceStub newStub(io.grpc.Channel channel) {
    return new ExchangeRateServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExchangeRateServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ExchangeRateServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ExchangeRateServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ExchangeRateServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ExchangeRateServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getExchangeRateStream(service.ExchangeRateRequest request,
        io.grpc.stub.StreamObserver<service.ExchangeRateSequence> responseObserver) {
      asyncUnimplementedUnaryCall(getGetExchangeRateStreamMethodHelper(), responseObserver);
    }

    /**
     */
    public void getInitialExchangeRates(service.ExchangeRateRequest request,
        io.grpc.stub.StreamObserver<service.ExchangeRateSequence> responseObserver) {
      asyncUnimplementedUnaryCall(getGetInitialExchangeRatesMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetExchangeRateStreamMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                service.ExchangeRateRequest,
                service.ExchangeRateSequence>(
                  this, METHODID_GET_EXCHANGE_RATE_STREAM)))
          .addMethod(
            getGetInitialExchangeRatesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                service.ExchangeRateRequest,
                service.ExchangeRateSequence>(
                  this, METHODID_GET_INITIAL_EXCHANGE_RATES)))
          .build();
    }
  }

  /**
   */
  public static final class ExchangeRateServiceStub extends io.grpc.stub.AbstractStub<ExchangeRateServiceStub> {
    private ExchangeRateServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ExchangeRateServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExchangeRateServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ExchangeRateServiceStub(channel, callOptions);
    }

    /**
     */
    public void getExchangeRateStream(service.ExchangeRateRequest request,
        io.grpc.stub.StreamObserver<service.ExchangeRateSequence> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetExchangeRateStreamMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getInitialExchangeRates(service.ExchangeRateRequest request,
        io.grpc.stub.StreamObserver<service.ExchangeRateSequence> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetInitialExchangeRatesMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ExchangeRateServiceBlockingStub extends io.grpc.stub.AbstractStub<ExchangeRateServiceBlockingStub> {
    private ExchangeRateServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ExchangeRateServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExchangeRateServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ExchangeRateServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<service.ExchangeRateSequence> getExchangeRateStream(
        service.ExchangeRateRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetExchangeRateStreamMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public service.ExchangeRateSequence getInitialExchangeRates(service.ExchangeRateRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetInitialExchangeRatesMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ExchangeRateServiceFutureStub extends io.grpc.stub.AbstractStub<ExchangeRateServiceFutureStub> {
    private ExchangeRateServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ExchangeRateServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExchangeRateServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ExchangeRateServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.ExchangeRateSequence> getInitialExchangeRates(
        service.ExchangeRateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetInitialExchangeRatesMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_EXCHANGE_RATE_STREAM = 0;
  private static final int METHODID_GET_INITIAL_EXCHANGE_RATES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ExchangeRateServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ExchangeRateServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_EXCHANGE_RATE_STREAM:
          serviceImpl.getExchangeRateStream((service.ExchangeRateRequest) request,
              (io.grpc.stub.StreamObserver<service.ExchangeRateSequence>) responseObserver);
          break;
        case METHODID_GET_INITIAL_EXCHANGE_RATES:
          serviceImpl.getInitialExchangeRates((service.ExchangeRateRequest) request,
              (io.grpc.stub.StreamObserver<service.ExchangeRateSequence>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ExchangeRateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExchangeRateServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return service.CurrencyServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ExchangeRateService");
    }
  }

  private static final class ExchangeRateServiceFileDescriptorSupplier
      extends ExchangeRateServiceBaseDescriptorSupplier {
    ExchangeRateServiceFileDescriptorSupplier() {}
  }

  private static final class ExchangeRateServiceMethodDescriptorSupplier
      extends ExchangeRateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ExchangeRateServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ExchangeRateServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ExchangeRateServiceFileDescriptorSupplier())
              .addMethod(getGetExchangeRateStreamMethodHelper())
              .addMethod(getGetInitialExchangeRatesMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
