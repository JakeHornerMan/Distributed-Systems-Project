package grpc.jake.cholesterol;

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
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: cholesterol.proto")
public final class CholesterolGrpc {

  private CholesterolGrpc() {}

  public static final String SERVICE_NAME = "grpcheart.Cholesterol";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.jake.cholesterol.CholesterolRequest,
      grpc.jake.cholesterol.CholesterolReply> getCholesterolCalculationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CholesterolCalculation",
      requestType = grpc.jake.cholesterol.CholesterolRequest.class,
      responseType = grpc.jake.cholesterol.CholesterolReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.jake.cholesterol.CholesterolRequest,
      grpc.jake.cholesterol.CholesterolReply> getCholesterolCalculationMethod() {
    io.grpc.MethodDescriptor<grpc.jake.cholesterol.CholesterolRequest, grpc.jake.cholesterol.CholesterolReply> getCholesterolCalculationMethod;
    if ((getCholesterolCalculationMethod = CholesterolGrpc.getCholesterolCalculationMethod) == null) {
      synchronized (CholesterolGrpc.class) {
        if ((getCholesterolCalculationMethod = CholesterolGrpc.getCholesterolCalculationMethod) == null) {
          CholesterolGrpc.getCholesterolCalculationMethod = getCholesterolCalculationMethod = 
              io.grpc.MethodDescriptor.<grpc.jake.cholesterol.CholesterolRequest, grpc.jake.cholesterol.CholesterolReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grpcheart.Cholesterol", "CholesterolCalculation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.jake.cholesterol.CholesterolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.jake.cholesterol.CholesterolReply.getDefaultInstance()))
                  .setSchemaDescriptor(new CholesterolMethodDescriptorSupplier("CholesterolCalculation"))
                  .build();
          }
        }
     }
     return getCholesterolCalculationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.jake.cholesterol.Empty,
      grpc.jake.cholesterol.CholesterolAnswer> getCholesterolAdviceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CholesterolAdvice",
      requestType = grpc.jake.cholesterol.Empty.class,
      responseType = grpc.jake.cholesterol.CholesterolAnswer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.jake.cholesterol.Empty,
      grpc.jake.cholesterol.CholesterolAnswer> getCholesterolAdviceMethod() {
    io.grpc.MethodDescriptor<grpc.jake.cholesterol.Empty, grpc.jake.cholesterol.CholesterolAnswer> getCholesterolAdviceMethod;
    if ((getCholesterolAdviceMethod = CholesterolGrpc.getCholesterolAdviceMethod) == null) {
      synchronized (CholesterolGrpc.class) {
        if ((getCholesterolAdviceMethod = CholesterolGrpc.getCholesterolAdviceMethod) == null) {
          CholesterolGrpc.getCholesterolAdviceMethod = getCholesterolAdviceMethod = 
              io.grpc.MethodDescriptor.<grpc.jake.cholesterol.Empty, grpc.jake.cholesterol.CholesterolAnswer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grpcheart.Cholesterol", "CholesterolAdvice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.jake.cholesterol.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.jake.cholesterol.CholesterolAnswer.getDefaultInstance()))
                  .setSchemaDescriptor(new CholesterolMethodDescriptorSupplier("CholesterolAdvice"))
                  .build();
          }
        }
     }
     return getCholesterolAdviceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CholesterolStub newStub(io.grpc.Channel channel) {
    return new CholesterolStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CholesterolBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CholesterolBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CholesterolFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CholesterolFutureStub(channel);
  }

  /**
   */
  public static abstract class CholesterolImplBase implements io.grpc.BindableService {

    /**
     */
    public void cholesterolCalculation(grpc.jake.cholesterol.CholesterolRequest request,
        io.grpc.stub.StreamObserver<grpc.jake.cholesterol.CholesterolReply> responseObserver) {
      asyncUnimplementedUnaryCall(getCholesterolCalculationMethod(), responseObserver);
    }

    /**
     */
    public void cholesterolAdvice(grpc.jake.cholesterol.Empty request,
        io.grpc.stub.StreamObserver<grpc.jake.cholesterol.CholesterolAnswer> responseObserver) {
      asyncUnimplementedUnaryCall(getCholesterolAdviceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCholesterolCalculationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.jake.cholesterol.CholesterolRequest,
                grpc.jake.cholesterol.CholesterolReply>(
                  this, METHODID_CHOLESTEROL_CALCULATION)))
          .addMethod(
            getCholesterolAdviceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.jake.cholesterol.Empty,
                grpc.jake.cholesterol.CholesterolAnswer>(
                  this, METHODID_CHOLESTEROL_ADVICE)))
          .build();
    }
  }

  /**
   */
  public static final class CholesterolStub extends io.grpc.stub.AbstractStub<CholesterolStub> {
    private CholesterolStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CholesterolStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CholesterolStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CholesterolStub(channel, callOptions);
    }

    /**
     */
    public void cholesterolCalculation(grpc.jake.cholesterol.CholesterolRequest request,
        io.grpc.stub.StreamObserver<grpc.jake.cholesterol.CholesterolReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCholesterolCalculationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cholesterolAdvice(grpc.jake.cholesterol.Empty request,
        io.grpc.stub.StreamObserver<grpc.jake.cholesterol.CholesterolAnswer> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCholesterolAdviceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CholesterolBlockingStub extends io.grpc.stub.AbstractStub<CholesterolBlockingStub> {
    private CholesterolBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CholesterolBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CholesterolBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CholesterolBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.jake.cholesterol.CholesterolReply cholesterolCalculation(grpc.jake.cholesterol.CholesterolRequest request) {
      return blockingUnaryCall(
          getChannel(), getCholesterolCalculationMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.jake.cholesterol.CholesterolAnswer cholesterolAdvice(grpc.jake.cholesterol.Empty request) {
      return blockingUnaryCall(
          getChannel(), getCholesterolAdviceMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CholesterolFutureStub extends io.grpc.stub.AbstractStub<CholesterolFutureStub> {
    private CholesterolFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CholesterolFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CholesterolFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CholesterolFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.jake.cholesterol.CholesterolReply> cholesterolCalculation(
        grpc.jake.cholesterol.CholesterolRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCholesterolCalculationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.jake.cholesterol.CholesterolAnswer> cholesterolAdvice(
        grpc.jake.cholesterol.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getCholesterolAdviceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHOLESTEROL_CALCULATION = 0;
  private static final int METHODID_CHOLESTEROL_ADVICE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CholesterolImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CholesterolImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHOLESTEROL_CALCULATION:
          serviceImpl.cholesterolCalculation((grpc.jake.cholesterol.CholesterolRequest) request,
              (io.grpc.stub.StreamObserver<grpc.jake.cholesterol.CholesterolReply>) responseObserver);
          break;
        case METHODID_CHOLESTEROL_ADVICE:
          serviceImpl.cholesterolAdvice((grpc.jake.cholesterol.Empty) request,
              (io.grpc.stub.StreamObserver<grpc.jake.cholesterol.CholesterolAnswer>) responseObserver);
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

  private static abstract class CholesterolBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CholesterolBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.jake.cholesterol.CholesterolServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Cholesterol");
    }
  }

  private static final class CholesterolFileDescriptorSupplier
      extends CholesterolBaseDescriptorSupplier {
    CholesterolFileDescriptorSupplier() {}
  }

  private static final class CholesterolMethodDescriptorSupplier
      extends CholesterolBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CholesterolMethodDescriptorSupplier(String methodName) {
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
      synchronized (CholesterolGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CholesterolFileDescriptorSupplier())
              .addMethod(getCholesterolCalculationMethod())
              .addMethod(getCholesterolAdviceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
