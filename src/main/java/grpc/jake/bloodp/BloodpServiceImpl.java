// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: bloodp.proto

package grpc.jake.bloodp;

public final class BloodpServiceImpl {
  private BloodpServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpcheart_BloodpRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpcheart_BloodpRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpcheart_BloodpReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpcheart_BloodpReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpcheart_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpcheart_Empty_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpcheart_BloodpAnswer_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpcheart_BloodpAnswer_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014bloodp.proto\022\tgrpcheart\"4\n\rBloodpReque" +
      "st\022\020\n\010systolic\030\001 \001(\005\022\021\n\tdiastolic\030\002 \001(\005\"" +
      ",\n\013BloodpReply\022\n\n\002bp\030\001 \001(\t\022\021\n\tbpmessage\030" +
      "\002 \001(\t\"\007\n\005Empty\"4\n\014BloodpAnswer\022\021\n\thelpli" +
      "nk1\030\003 \001(\t\022\021\n\thelplink2\030\004 \001(\t2\212\001\n\006Bloodp\022" +
      "E\n\021BloodpCalculation\022\030.grpcheart.BloodpR" +
      "equest\032\026.grpcheart.BloodpReply\0229\n\014Bloodp" +
      "Advice\022\020.grpcheart.Empty\032\027.grpcheart.Blo" +
      "odpAnswerB\'\n\020grpc.jake.bloodpB\021BloodpSer" +
      "viceImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_grpcheart_BloodpRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_grpcheart_BloodpRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpcheart_BloodpRequest_descriptor,
        new java.lang.String[] { "Systolic", "Diastolic", });
    internal_static_grpcheart_BloodpReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_grpcheart_BloodpReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpcheart_BloodpReply_descriptor,
        new java.lang.String[] { "Bp", "Bpmessage", });
    internal_static_grpcheart_Empty_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_grpcheart_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpcheart_Empty_descriptor,
        new java.lang.String[] { });
    internal_static_grpcheart_BloodpAnswer_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_grpcheart_BloodpAnswer_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpcheart_BloodpAnswer_descriptor,
        new java.lang.String[] { "Helplink1", "Helplink2", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
