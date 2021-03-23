package grpc.jake.bmi;

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
    comments = "Source: bmi.proto")
public final class BMIGrpc {

  private BMIGrpc() {}

  public static final String SERVICE_NAME = "grpcheart.BMI";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.jake.bmi.BmiRequest,
      grpc.jake.bmi.BmiReply> getBmiCalculationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "bmiCalculation",
      requestType = grpc.jake.bmi.BmiRequest.class,
      responseType = grpc.jake.bmi.BmiReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.jake.bmi.BmiRequest,
      grpc.jake.bmi.BmiReply> getBmiCalculationMethod() {
    io.grpc.MethodDescriptor<grpc.jake.bmi.BmiRequest, grpc.jake.bmi.BmiReply> getBmiCalculationMethod;
    if ((getBmiCalculationMethod = BMIGrpc.getBmiCalculationMethod) == null) {
      synchronized (BMIGrpc.class) {
        if ((getBmiCalculationMethod = BMIGrpc.getBmiCalculationMethod) == null) {
          BMIGrpc.getBmiCalculationMethod = getBmiCalculationMethod = 
              io.grpc.MethodDescriptor.<grpc.jake.bmi.BmiRequest, grpc.jake.bmi.BmiReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grpcheart.BMI", "bmiCalculation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.jake.bmi.BmiRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.jake.bmi.BmiReply.getDefaultInstance()))
                  .setSchemaDescriptor(new BMIMethodDescriptorSupplier("bmiCalculation"))
                  .build();
          }
        }
     }
     return getBmiCalculationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.jake.bmi.Empty,
      grpc.jake.bmi.BmiAdvice> getBmiAdviceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "bmiAdvice",
      requestType = grpc.jake.bmi.Empty.class,
      responseType = grpc.jake.bmi.BmiAdvice.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.jake.bmi.Empty,
      grpc.jake.bmi.BmiAdvice> getBmiAdviceMethod() {
    io.grpc.MethodDescriptor<grpc.jake.bmi.Empty, grpc.jake.bmi.BmiAdvice> getBmiAdviceMethod;
    if ((getBmiAdviceMethod = BMIGrpc.getBmiAdviceMethod) == null) {
      synchronized (BMIGrpc.class) {
        if ((getBmiAdviceMethod = BMIGrpc.getBmiAdviceMethod) == null) {
          BMIGrpc.getBmiAdviceMethod = getBmiAdviceMethod = 
              io.grpc.MethodDescriptor.<grpc.jake.bmi.Empty, grpc.jake.bmi.BmiAdvice>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grpcheart.BMI", "bmiAdvice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.jake.bmi.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.jake.bmi.BmiAdvice.getDefaultInstance()))
                  .setSchemaDescriptor(new BMIMethodDescriptorSupplier("bmiAdvice"))
                  .build();
          }
        }
     }
     return getBmiAdviceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BMIStub newStub(io.grpc.Channel channel) {
    return new BMIStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BMIBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BMIBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BMIFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BMIFutureStub(channel);
  }

  /**
   */
  public static abstract class BMIImplBase implements io.grpc.BindableService {

    /**
     */
    public void bmiCalculation(grpc.jake.bmi.BmiRequest request,
        io.grpc.stub.StreamObserver<grpc.jake.bmi.BmiReply> responseObserver) {
      asyncUnimplementedUnaryCall(getBmiCalculationMethod(), responseObserver);
    }

    /**
     */
    public void bmiAdvice(grpc.jake.bmi.Empty request,
        io.grpc.stub.StreamObserver<grpc.jake.bmi.BmiAdvice> responseObserver) {
      asyncUnimplementedUnaryCall(getBmiAdviceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBmiCalculationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.jake.bmi.BmiRequest,
                grpc.jake.bmi.BmiReply>(
                  this, METHODID_BMI_CALCULATION)))
          .addMethod(
            getBmiAdviceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.jake.bmi.Empty,
                grpc.jake.bmi.BmiAdvice>(
                  this, METHODID_BMI_ADVICE)))
          .build();
    }
  }

  /**
   */
  public static final class BMIStub extends io.grpc.stub.AbstractStub<BMIStub> {
    private BMIStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BMIStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BMIStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BMIStub(channel, callOptions);
    }

    /**
     */
    public void bmiCalculation(grpc.jake.bmi.BmiRequest request,
        io.grpc.stub.StreamObserver<grpc.jake.bmi.BmiReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBmiCalculationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bmiAdvice(grpc.jake.bmi.Empty request,
        io.grpc.stub.StreamObserver<grpc.jake.bmi.BmiAdvice> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBmiAdviceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BMIBlockingStub extends io.grpc.stub.AbstractStub<BMIBlockingStub> {
    private BMIBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BMIBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BMIBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BMIBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.jake.bmi.BmiReply bmiCalculation(grpc.jake.bmi.BmiRequest request) {
      return blockingUnaryCall(
          getChannel(), getBmiCalculationMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.jake.bmi.BmiAdvice bmiAdvice(grpc.jake.bmi.Empty request) {
      return blockingUnaryCall(
          getChannel(), getBmiAdviceMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BMIFutureStub extends io.grpc.stub.AbstractStub<BMIFutureStub> {
    private BMIFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BMIFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BMIFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BMIFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.jake.bmi.BmiReply> bmiCalculation(
        grpc.jake.bmi.BmiRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBmiCalculationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.jake.bmi.BmiAdvice> bmiAdvice(
        grpc.jake.bmi.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getBmiAdviceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BMI_CALCULATION = 0;
  private static final int METHODID_BMI_ADVICE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BMIImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BMIImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BMI_CALCULATION:
          serviceImpl.bmiCalculation((grpc.jake.bmi.BmiRequest) request,
              (io.grpc.stub.StreamObserver<grpc.jake.bmi.BmiReply>) responseObserver);
          break;
        case METHODID_BMI_ADVICE:
          serviceImpl.bmiAdvice((grpc.jake.bmi.Empty) request,
              (io.grpc.stub.StreamObserver<grpc.jake.bmi.BmiAdvice>) responseObserver);
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

  private static abstract class BMIBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BMIBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.jake.bmi.BmiServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BMI");
    }
  }

  private static final class BMIFileDescriptorSupplier
      extends BMIBaseDescriptorSupplier {
    BMIFileDescriptorSupplier() {}
  }

  private static final class BMIMethodDescriptorSupplier
      extends BMIBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BMIMethodDescriptorSupplier(String methodName) {
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
      synchronized (BMIGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BMIFileDescriptorSupplier())
              .addMethod(getBmiCalculationMethod())
              .addMethod(getBmiAdviceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
