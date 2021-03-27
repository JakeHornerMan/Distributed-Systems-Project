// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: bmi.proto

package grpc.jake.bmi;

/**
 * Protobuf type {@code grpcheart.BmiReply}
 */
public  final class BmiReply extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpcheart.BmiReply)
    BmiReplyOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BmiReply.newBuilder() to construct.
  private BmiReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BmiReply() {
    bmi_ = 0D;
    bmimessage_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BmiReply(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 9: {

            bmi_ = input.readDouble();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            bmimessage_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.jake.bmi.BmiServiceImpl.internal_static_grpcheart_BmiReply_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.jake.bmi.BmiServiceImpl.internal_static_grpcheart_BmiReply_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.jake.bmi.BmiReply.class, grpc.jake.bmi.BmiReply.Builder.class);
  }

  public static final int BMI_FIELD_NUMBER = 1;
  private double bmi_;
  /**
   * <code>double bmi = 1;</code>
   */
  public double getBmi() {
    return bmi_;
  }

  public static final int BMIMESSAGE_FIELD_NUMBER = 2;
  private volatile java.lang.Object bmimessage_;
  /**
   * <code>string bmimessage = 2;</code>
   */
  public java.lang.String getBmimessage() {
    java.lang.Object ref = bmimessage_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      bmimessage_ = s;
      return s;
    }
  }
  /**
   * <code>string bmimessage = 2;</code>
   */
  public com.google.protobuf.ByteString
      getBmimessageBytes() {
    java.lang.Object ref = bmimessage_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      bmimessage_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (bmi_ != 0D) {
      output.writeDouble(1, bmi_);
    }
    if (!getBmimessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, bmimessage_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (bmi_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(1, bmi_);
    }
    if (!getBmimessageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, bmimessage_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof grpc.jake.bmi.BmiReply)) {
      return super.equals(obj);
    }
    grpc.jake.bmi.BmiReply other = (grpc.jake.bmi.BmiReply) obj;

    boolean result = true;
    result = result && (
        java.lang.Double.doubleToLongBits(getBmi())
        == java.lang.Double.doubleToLongBits(
            other.getBmi()));
    result = result && getBmimessage()
        .equals(other.getBmimessage());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + BMI_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getBmi()));
    hash = (37 * hash) + BMIMESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getBmimessage().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.jake.bmi.BmiReply parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.jake.bmi.BmiReply parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.jake.bmi.BmiReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.jake.bmi.BmiReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.jake.bmi.BmiReply parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.jake.bmi.BmiReply parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.jake.bmi.BmiReply parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.jake.bmi.BmiReply parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.jake.bmi.BmiReply parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.jake.bmi.BmiReply parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.jake.bmi.BmiReply parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.jake.bmi.BmiReply parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(grpc.jake.bmi.BmiReply prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code grpcheart.BmiReply}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpcheart.BmiReply)
      grpc.jake.bmi.BmiReplyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.jake.bmi.BmiServiceImpl.internal_static_grpcheart_BmiReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.jake.bmi.BmiServiceImpl.internal_static_grpcheart_BmiReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.jake.bmi.BmiReply.class, grpc.jake.bmi.BmiReply.Builder.class);
    }

    // Construct using grpc.jake.bmi.BmiReply.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bmi_ = 0D;

      bmimessage_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.jake.bmi.BmiServiceImpl.internal_static_grpcheart_BmiReply_descriptor;
    }

    @java.lang.Override
    public grpc.jake.bmi.BmiReply getDefaultInstanceForType() {
      return grpc.jake.bmi.BmiReply.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.jake.bmi.BmiReply build() {
      grpc.jake.bmi.BmiReply result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.jake.bmi.BmiReply buildPartial() {
      grpc.jake.bmi.BmiReply result = new grpc.jake.bmi.BmiReply(this);
      result.bmi_ = bmi_;
      result.bmimessage_ = bmimessage_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.jake.bmi.BmiReply) {
        return mergeFrom((grpc.jake.bmi.BmiReply)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.jake.bmi.BmiReply other) {
      if (other == grpc.jake.bmi.BmiReply.getDefaultInstance()) return this;
      if (other.getBmi() != 0D) {
        setBmi(other.getBmi());
      }
      if (!other.getBmimessage().isEmpty()) {
        bmimessage_ = other.bmimessage_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      grpc.jake.bmi.BmiReply parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.jake.bmi.BmiReply) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private double bmi_ ;
    /**
     * <code>double bmi = 1;</code>
     */
    public double getBmi() {
      return bmi_;
    }
    /**
     * <code>double bmi = 1;</code>
     */
    public Builder setBmi(double value) {
      
      bmi_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double bmi = 1;</code>
     */
    public Builder clearBmi() {
      
      bmi_ = 0D;
      onChanged();
      return this;
    }

    private java.lang.Object bmimessage_ = "";
    /**
     * <code>string bmimessage = 2;</code>
     */
    public java.lang.String getBmimessage() {
      java.lang.Object ref = bmimessage_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        bmimessage_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string bmimessage = 2;</code>
     */
    public com.google.protobuf.ByteString
        getBmimessageBytes() {
      java.lang.Object ref = bmimessage_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        bmimessage_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string bmimessage = 2;</code>
     */
    public Builder setBmimessage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      bmimessage_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string bmimessage = 2;</code>
     */
    public Builder clearBmimessage() {
      
      bmimessage_ = getDefaultInstance().getBmimessage();
      onChanged();
      return this;
    }
    /**
     * <code>string bmimessage = 2;</code>
     */
    public Builder setBmimessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      bmimessage_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:grpcheart.BmiReply)
  }

  // @@protoc_insertion_point(class_scope:grpcheart.BmiReply)
  private static final grpc.jake.bmi.BmiReply DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.jake.bmi.BmiReply();
  }

  public static grpc.jake.bmi.BmiReply getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BmiReply>
      PARSER = new com.google.protobuf.AbstractParser<BmiReply>() {
    @java.lang.Override
    public BmiReply parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new BmiReply(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BmiReply> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BmiReply> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.jake.bmi.BmiReply getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

