package grpc.jake.bloodp;

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
    comments = "Source: bloodp.proto")
public final class BloodpGrpc {

  private BloodpGrpc() {}

  public static final String SERVICE_NAME = "grpcheart.Bloodp";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.jake.bloodp.BloodpRequest,
      grpc.jake.bloodp.BloodpReply> getBloodpCalculationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BloodpCalculation",
      requestType = grpc.jake.bloodp.BloodpRequest.class,
      responseType = grpc.jake.bloodp.BloodpReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.jake.bloodp.BloodpRequest,
      grpc.jake.bloodp.BloodpReply> getBloodpCalculationMethod() {
    io.grpc.MethodDescriptor<grpc.jake.bloodp.BloodpRequest, grpc.jake.bloodp.BloodpReply> getBloodpCalculationMethod;
    if ((getBloodpCalculationMethod = BloodpGrpc.getBloodpCalculationMethod) == null) {
      synchronized (BloodpGrpc.class) {
        if ((getBloodpCalculationMethod = BloodpGrpc.getBloodpCalculationMethod) == null) {
          BloodpGrpc.getBloodpCalculationMethod = getBloodpCalculationMethod = 
              io.grpc.MethodDescriptor.<grpc.jake.bloodp.BloodpRequest, grpc.jake.bloodp.BloodpReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grpcheart.Bloodp", "BloodpCalculation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.jake.bloodp.BloodpRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.jake.bloodp.BloodpReply.getDefaultInstance()))
                  .setSchemaDescriptor(new BloodpMethodDescriptorSupplier("BloodpCalculation"))
                  .build();
          }
        }
     }
     return getBloodpCalculationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.jake.bloodp.Empty,
      grpc.jake.bloodp.BloodpAnswer> getBloodpAdviceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BloodpAdvice",
      requestType = grpc.jake.bloodp.Empty.class,
      responseType = grpc.jake.bloodp.BloodpAnswer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.jake.bloodp.Empty,
      grpc.jake.bloodp.BloodpAnswer> getBloodpAdviceMethod() {
    io.grpc.MethodDescriptor<grpc.jake.bloodp.Empty, grpc.jake.bloodp.BloodpAnswer> getBloodpAdviceMethod;
    if ((getBloodpAdviceMethod = BloodpGrpc.getBloodpAdviceMethod) == null) {
      synchronized (BloodpGrpc.class) {
        if ((getBloodpAdviceMethod = BloodpGrpc.getBloodpAdviceMethod) == null) {
          BloodpGrpc.getBloodpAdviceMethod = getBloodpAdviceMethod = 
              io.grpc.MethodDescriptor.<grpc.jake.bloodp.Empty, grpc.jake.bloodp.BloodpAnswer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grpcheart.Bloodp", "BloodpAdvice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.jake.bloodp.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.jake.bloodp.BloodpAnswer.getDefaultInstance()))
                  .setSchemaDescriptor(new BloodpMethodDescriptorSupplier("BloodpAdvice"))
                  .build();
          }
        }
     }
     return getBloodpAdviceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BloodpStub newStub(io.grpc.Channel channel) {
    return new BloodpStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BloodpBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BloodpBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BloodpFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BloodpFutureStub(channel);
  }

  /**
   */
  public static abstract class BloodpImplBase implements io.grpc.BindableService {

    /**
     */
    public void bloodpCalculation(grpc.jake.bloodp.BloodpRequest request,
        io.grpc.stub.StreamObserver<grpc.jake.bloodp.BloodpReply> responseObserver) {
      asyncUnimplementedUnaryCall(getBloodpCalculationMethod(), responseObserver);
    }

    /**
     */
    public void bloodpAdvice(grpc.jake.bloodp.Empty request,
        io.grpc.stub.StreamObserver<grpc.jake.bloodp.BloodpAnswer> responseObserver) {
      asyncUnimplementedUnaryCall(getBloodpAdviceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBloodpCalculationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.jake.bloodp.BloodpRequest,
                grpc.jake.bloodp.BloodpReply>(
                  this, METHODID_BLOODP_CALCULATION)))
          .addMethod(
            getBloodpAdviceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.jake.bloodp.Empty,
                grpc.jake.bloodp.BloodpAnswer>(
                  this, METHODID_BLOODP_ADVICE)))
          .build();
    }
  }

  /**
   */
  public static final class BloodpStub extends io.grpc.stub.AbstractStub<BloodpStub> {
    private BloodpStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BloodpStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BloodpStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BloodpStub(channel, callOptions);
    }

    /**
     */
    public void bloodpCalculation(grpc.jake.bloodp.BloodpRequest request,
        io.grpc.stub.StreamObserver<grpc.jake.bloodp.BloodpReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBloodpCalculationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bloodpAdvice(grpc.jake.bloodp.Empty request,
        io.grpc.stub.StreamObserver<grpc.jake.bloodp.BloodpAnswer> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBloodpAdviceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BloodpBlockingStub extends io.grpc.stub.AbstractStub<BloodpBlockingStub> {
    private BloodpBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BloodpBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BloodpBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BloodpBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.jake.bloodp.BloodpReply bloodpCalculation(grpc.jake.bloodp.BloodpRequest request) {
      return blockingUnaryCall(
          getChannel(), getBloodpCalculationMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.jake.bloodp.BloodpAnswer bloodpAdvice(grpc.jake.bloodp.Empty request) {
      return blockingUnaryCall(
          getChannel(), getBloodpAdviceMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BloodpFutureStub extends io.grpc.stub.AbstractStub<BloodpFutureStub> {
    private BloodpFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BloodpFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BloodpFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BloodpFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.jake.bloodp.BloodpReply> bloodpCalculation(
        grpc.jake.bloodp.BloodpRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBloodpCalculationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.jake.bloodp.BloodpAnswer> bloodpAdvice(
        grpc.jake.bloodp.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getBloodpAdviceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BLOODP_CALCULATION = 0;
  private static final int METHODID_BLOODP_ADVICE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BloodpImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BloodpImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BLOODP_CALCULATION:
          serviceImpl.bloodpCalculation((grpc.jake.bloodp.BloodpRequest) request,
              (io.grpc.stub.StreamObserver<grpc.jake.bloodp.BloodpReply>) responseObserver);
          break;
        case METHODID_BLOODP_ADVICE:
          serviceImpl.bloodpAdvice((grpc.jake.bloodp.Empty) request,
              (io.grpc.stub.StreamObserver<grpc.jake.bloodp.BloodpAnswer>) responseObserver);
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

  private static abstract class BloodpBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BloodpBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.jake.bloodp.BloodpServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Bloodp");
    }
  }

  private static final class BloodpFileDescriptorSupplier
      extends BloodpBaseDescriptorSupplier {
    BloodpFileDescriptorSupplier() {}
  }

  private static final class BloodpMethodDescriptorSupplier
      extends BloodpBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BloodpMethodDescriptorSupplier(String methodName) {
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
      synchronized (BloodpGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BloodpFileDescriptorSupplier())
              .addMethod(getBloodpCalculationMethod())
              .addMethod(getBloodpAdviceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
