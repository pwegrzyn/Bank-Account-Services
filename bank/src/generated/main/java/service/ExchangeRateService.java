// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: currency_service.proto

package service;

/**
 * Protobuf service {@code ExchangeRateService}
 */
public  abstract class ExchangeRateService
    implements com.google.protobuf.Service {
  protected ExchangeRateService() {}

  public interface Interface {
    /**
     * <code>rpc getExchangeRateStream(.ExchangeRateRequest) returns (stream .ExchangeRateSequence);</code>
     */
    public abstract void getExchangeRateStream(
        com.google.protobuf.RpcController controller,
        service.ExchangeRateRequest request,
        com.google.protobuf.RpcCallback<service.ExchangeRateSequence> done);

    /**
     * <code>rpc getInitialExchangeRates(.ExchangeRateRequest) returns (.ExchangeRateSequence);</code>
     */
    public abstract void getInitialExchangeRates(
        com.google.protobuf.RpcController controller,
        service.ExchangeRateRequest request,
        com.google.protobuf.RpcCallback<service.ExchangeRateSequence> done);

  }

  public static com.google.protobuf.Service newReflectiveService(
      final Interface impl) {
    return new ExchangeRateService() {
      @java.lang.Override
      public  void getExchangeRateStream(
          com.google.protobuf.RpcController controller,
          service.ExchangeRateRequest request,
          com.google.protobuf.RpcCallback<service.ExchangeRateSequence> done) {
        impl.getExchangeRateStream(controller, request, done);
      }

      @java.lang.Override
      public  void getInitialExchangeRates(
          com.google.protobuf.RpcController controller,
          service.ExchangeRateRequest request,
          com.google.protobuf.RpcCallback<service.ExchangeRateSequence> done) {
        impl.getInitialExchangeRates(controller, request, done);
      }

    };
  }

  public static com.google.protobuf.BlockingService
      newReflectiveBlockingService(final BlockingInterface impl) {
    return new com.google.protobuf.BlockingService() {
      public final com.google.protobuf.Descriptors.ServiceDescriptor
          getDescriptorForType() {
        return getDescriptor();
      }

      public final com.google.protobuf.Message callBlockingMethod(
          com.google.protobuf.Descriptors.MethodDescriptor method,
          com.google.protobuf.RpcController controller,
          com.google.protobuf.Message request)
          throws com.google.protobuf.ServiceException {
        if (method.getService() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "Service.callBlockingMethod() given method descriptor for " +
            "wrong service type.");
        }
        switch(method.getIndex()) {
          case 0:
            return impl.getExchangeRateStream(controller, (service.ExchangeRateRequest)request);
          case 1:
            return impl.getInitialExchangeRates(controller, (service.ExchangeRateRequest)request);
          default:
            throw new java.lang.AssertionError("Can't get here.");
        }
      }

      public final com.google.protobuf.Message
          getRequestPrototype(
          com.google.protobuf.Descriptors.MethodDescriptor method) {
        if (method.getService() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "Service.getRequestPrototype() given method " +
            "descriptor for wrong service type.");
        }
        switch(method.getIndex()) {
          case 0:
            return service.ExchangeRateRequest.getDefaultInstance();
          case 1:
            return service.ExchangeRateRequest.getDefaultInstance();
          default:
            throw new java.lang.AssertionError("Can't get here.");
        }
      }

      public final com.google.protobuf.Message
          getResponsePrototype(
          com.google.protobuf.Descriptors.MethodDescriptor method) {
        if (method.getService() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "Service.getResponsePrototype() given method " +
            "descriptor for wrong service type.");
        }
        switch(method.getIndex()) {
          case 0:
            return service.ExchangeRateSequence.getDefaultInstance();
          case 1:
            return service.ExchangeRateSequence.getDefaultInstance();
          default:
            throw new java.lang.AssertionError("Can't get here.");
        }
      }

    };
  }

  /**
   * <code>rpc getExchangeRateStream(.ExchangeRateRequest) returns (stream .ExchangeRateSequence);</code>
   */
  public abstract void getExchangeRateStream(
      com.google.protobuf.RpcController controller,
      service.ExchangeRateRequest request,
      com.google.protobuf.RpcCallback<service.ExchangeRateSequence> done);

  /**
   * <code>rpc getInitialExchangeRates(.ExchangeRateRequest) returns (.ExchangeRateSequence);</code>
   */
  public abstract void getInitialExchangeRates(
      com.google.protobuf.RpcController controller,
      service.ExchangeRateRequest request,
      com.google.protobuf.RpcCallback<service.ExchangeRateSequence> done);

  public static final
      com.google.protobuf.Descriptors.ServiceDescriptor
      getDescriptor() {
    return service.CurrencyServiceProto.getDescriptor().getServices().get(0);
  }
  public final com.google.protobuf.Descriptors.ServiceDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }

  public final void callMethod(
      com.google.protobuf.Descriptors.MethodDescriptor method,
      com.google.protobuf.RpcController controller,
      com.google.protobuf.Message request,
      com.google.protobuf.RpcCallback<
        com.google.protobuf.Message> done) {
    if (method.getService() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "Service.callMethod() given method descriptor for wrong " +
        "service type.");
    }
    switch(method.getIndex()) {
      case 0:
        this.getExchangeRateStream(controller, (service.ExchangeRateRequest)request,
          com.google.protobuf.RpcUtil.<service.ExchangeRateSequence>specializeCallback(
            done));
        return;
      case 1:
        this.getInitialExchangeRates(controller, (service.ExchangeRateRequest)request,
          com.google.protobuf.RpcUtil.<service.ExchangeRateSequence>specializeCallback(
            done));
        return;
      default:
        throw new java.lang.AssertionError("Can't get here.");
    }
  }

  public final com.google.protobuf.Message
      getRequestPrototype(
      com.google.protobuf.Descriptors.MethodDescriptor method) {
    if (method.getService() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "Service.getRequestPrototype() given method " +
        "descriptor for wrong service type.");
    }
    switch(method.getIndex()) {
      case 0:
        return service.ExchangeRateRequest.getDefaultInstance();
      case 1:
        return service.ExchangeRateRequest.getDefaultInstance();
      default:
        throw new java.lang.AssertionError("Can't get here.");
    }
  }

  public final com.google.protobuf.Message
      getResponsePrototype(
      com.google.protobuf.Descriptors.MethodDescriptor method) {
    if (method.getService() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "Service.getResponsePrototype() given method " +
        "descriptor for wrong service type.");
    }
    switch(method.getIndex()) {
      case 0:
        return service.ExchangeRateSequence.getDefaultInstance();
      case 1:
        return service.ExchangeRateSequence.getDefaultInstance();
      default:
        throw new java.lang.AssertionError("Can't get here.");
    }
  }

  public static Stub newStub(
      com.google.protobuf.RpcChannel channel) {
    return new Stub(channel);
  }

  public static final class Stub extends service.ExchangeRateService implements Interface {
    private Stub(com.google.protobuf.RpcChannel channel) {
      this.channel = channel;
    }

    private final com.google.protobuf.RpcChannel channel;

    public com.google.protobuf.RpcChannel getChannel() {
      return channel;
    }

    public  void getExchangeRateStream(
        com.google.protobuf.RpcController controller,
        service.ExchangeRateRequest request,
        com.google.protobuf.RpcCallback<service.ExchangeRateSequence> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(0),
        controller,
        request,
        service.ExchangeRateSequence.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          service.ExchangeRateSequence.class,
          service.ExchangeRateSequence.getDefaultInstance()));
    }

    public  void getInitialExchangeRates(
        com.google.protobuf.RpcController controller,
        service.ExchangeRateRequest request,
        com.google.protobuf.RpcCallback<service.ExchangeRateSequence> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(1),
        controller,
        request,
        service.ExchangeRateSequence.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          service.ExchangeRateSequence.class,
          service.ExchangeRateSequence.getDefaultInstance()));
    }
  }

  public static BlockingInterface newBlockingStub(
      com.google.protobuf.BlockingRpcChannel channel) {
    return new BlockingStub(channel);
  }

  public interface BlockingInterface {
    public service.ExchangeRateSequence getExchangeRateStream(
        com.google.protobuf.RpcController controller,
        service.ExchangeRateRequest request)
        throws com.google.protobuf.ServiceException;

    public service.ExchangeRateSequence getInitialExchangeRates(
        com.google.protobuf.RpcController controller,
        service.ExchangeRateRequest request)
        throws com.google.protobuf.ServiceException;
  }

  private static final class BlockingStub implements BlockingInterface {
    private BlockingStub(com.google.protobuf.BlockingRpcChannel channel) {
      this.channel = channel;
    }

    private final com.google.protobuf.BlockingRpcChannel channel;

    public service.ExchangeRateSequence getExchangeRateStream(
        com.google.protobuf.RpcController controller,
        service.ExchangeRateRequest request)
        throws com.google.protobuf.ServiceException {
      return (service.ExchangeRateSequence) channel.callBlockingMethod(
        getDescriptor().getMethods().get(0),
        controller,
        request,
        service.ExchangeRateSequence.getDefaultInstance());
    }


    public service.ExchangeRateSequence getInitialExchangeRates(
        com.google.protobuf.RpcController controller,
        service.ExchangeRateRequest request)
        throws com.google.protobuf.ServiceException {
      return (service.ExchangeRateSequence) channel.callBlockingMethod(
        getDescriptor().getMethods().get(1),
        controller,
        request,
        service.ExchangeRateSequence.getDefaultInstance());
    }

  }

  // @@protoc_insertion_point(class_scope:ExchangeRateService)
}

