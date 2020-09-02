// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/protobuf/RequestOrder.proto

package com.app.pay.protobuf;

public final class RequestOrder {
  private RequestOrder() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface PayOrderInfoOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.app.pay.PayOrderInfo)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required int32 requestId = 1;</code>
     */
    boolean hasRequestId();
    /**
     * <code>required int32 requestId = 1;</code>
     */
    int getRequestId();

    /**
     * <code>required string checkBit = 2;</code>
     */
    boolean hasCheckBit();
    /**
     * <code>required string checkBit = 2;</code>
     */
    java.lang.String getCheckBit();
    /**
     * <code>required string checkBit = 2;</code>
     */
    com.google.protobuf.ByteString
        getCheckBitBytes();

    /**
     * <code>required string bizContent = 3;</code>
     */
    boolean hasBizContent();
    /**
     * <code>required string bizContent = 3;</code>
     */
    java.lang.String getBizContent();
    /**
     * <code>required string bizContent = 3;</code>
     */
    com.google.protobuf.ByteString
        getBizContentBytes();
  }
  /**
   * Protobuf type {@code com.app.pay.PayOrderInfo}
   */
  public  static final class PayOrderInfo extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.app.pay.PayOrderInfo)
      PayOrderInfoOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use PayOrderInfo.newBuilder() to construct.
    private PayOrderInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private PayOrderInfo() {
      checkBit_ = "";
      bizContent_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new PayOrderInfo();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private PayOrderInfo(
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
            case 8: {
              bitField0_ |= 0x00000001;
              requestId_ = input.readInt32();
              break;
            }
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000002;
              checkBit_ = bs;
              break;
            }
            case 26: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000004;
              bizContent_ = bs;
              break;
            }
            default: {
              if (!parseUnknownField(
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
      return com.app.pay.protobuf.RequestOrder.internal_static_com_app_pay_PayOrderInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.app.pay.protobuf.RequestOrder.internal_static_com_app_pay_PayOrderInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.app.pay.protobuf.RequestOrder.PayOrderInfo.class, com.app.pay.protobuf.RequestOrder.PayOrderInfo.Builder.class);
    }

    private int bitField0_;
    public static final int REQUESTID_FIELD_NUMBER = 1;
    private int requestId_;
    /**
     * <code>required int32 requestId = 1;</code>
     */
    public boolean hasRequestId() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required int32 requestId = 1;</code>
     */
    public int getRequestId() {
      return requestId_;
    }

    public static final int CHECKBIT_FIELD_NUMBER = 2;
    private volatile java.lang.Object checkBit_;
    /**
     * <code>required string checkBit = 2;</code>
     */
    public boolean hasCheckBit() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>required string checkBit = 2;</code>
     */
    public java.lang.String getCheckBit() {
      java.lang.Object ref = checkBit_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          checkBit_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string checkBit = 2;</code>
     */
    public com.google.protobuf.ByteString
        getCheckBitBytes() {
      java.lang.Object ref = checkBit_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        checkBit_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int BIZCONTENT_FIELD_NUMBER = 3;
    private volatile java.lang.Object bizContent_;
    /**
     * <code>required string bizContent = 3;</code>
     */
    public boolean hasBizContent() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>required string bizContent = 3;</code>
     */
    public java.lang.String getBizContent() {
      java.lang.Object ref = bizContent_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          bizContent_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string bizContent = 3;</code>
     */
    public com.google.protobuf.ByteString
        getBizContentBytes() {
      java.lang.Object ref = bizContent_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        bizContent_ = b;
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

      if (!hasRequestId()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasCheckBit()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasBizContent()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) != 0)) {
        output.writeInt32(1, requestId_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, checkBit_);
      }
      if (((bitField0_ & 0x00000004) != 0)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, bizContent_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, requestId_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, checkBit_);
      }
      if (((bitField0_ & 0x00000004) != 0)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, bizContent_);
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
      if (!(obj instanceof com.app.pay.protobuf.RequestOrder.PayOrderInfo)) {
        return super.equals(obj);
      }
      com.app.pay.protobuf.RequestOrder.PayOrderInfo other = (com.app.pay.protobuf.RequestOrder.PayOrderInfo) obj;

      if (hasRequestId() != other.hasRequestId()) return false;
      if (hasRequestId()) {
        if (getRequestId()
            != other.getRequestId()) return false;
      }
      if (hasCheckBit() != other.hasCheckBit()) return false;
      if (hasCheckBit()) {
        if (!getCheckBit()
            .equals(other.getCheckBit())) return false;
      }
      if (hasBizContent() != other.hasBizContent()) return false;
      if (hasBizContent()) {
        if (!getBizContent()
            .equals(other.getBizContent())) return false;
      }
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (hasRequestId()) {
        hash = (37 * hash) + REQUESTID_FIELD_NUMBER;
        hash = (53 * hash) + getRequestId();
      }
      if (hasCheckBit()) {
        hash = (37 * hash) + CHECKBIT_FIELD_NUMBER;
        hash = (53 * hash) + getCheckBit().hashCode();
      }
      if (hasBizContent()) {
        hash = (37 * hash) + BIZCONTENT_FIELD_NUMBER;
        hash = (53 * hash) + getBizContent().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.app.pay.protobuf.RequestOrder.PayOrderInfo parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.app.pay.protobuf.RequestOrder.PayOrderInfo parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.app.pay.protobuf.RequestOrder.PayOrderInfo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.app.pay.protobuf.RequestOrder.PayOrderInfo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.app.pay.protobuf.RequestOrder.PayOrderInfo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.app.pay.protobuf.RequestOrder.PayOrderInfo parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.app.pay.protobuf.RequestOrder.PayOrderInfo parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.app.pay.protobuf.RequestOrder.PayOrderInfo parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.app.pay.protobuf.RequestOrder.PayOrderInfo parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.app.pay.protobuf.RequestOrder.PayOrderInfo parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.app.pay.protobuf.RequestOrder.PayOrderInfo parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.app.pay.protobuf.RequestOrder.PayOrderInfo parseFrom(
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
    public static Builder newBuilder(com.app.pay.protobuf.RequestOrder.PayOrderInfo prototype) {
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
     * Protobuf type {@code com.app.pay.PayOrderInfo}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.app.pay.PayOrderInfo)
        com.app.pay.protobuf.RequestOrder.PayOrderInfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.app.pay.protobuf.RequestOrder.internal_static_com_app_pay_PayOrderInfo_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.app.pay.protobuf.RequestOrder.internal_static_com_app_pay_PayOrderInfo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.app.pay.protobuf.RequestOrder.PayOrderInfo.class, com.app.pay.protobuf.RequestOrder.PayOrderInfo.Builder.class);
      }

      // Construct using com.app.pay.protobuf.RequestOrder.PayOrderInfo.newBuilder()
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
        requestId_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        checkBit_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        bizContent_ = "";
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.app.pay.protobuf.RequestOrder.internal_static_com_app_pay_PayOrderInfo_descriptor;
      }

      @java.lang.Override
      public com.app.pay.protobuf.RequestOrder.PayOrderInfo getDefaultInstanceForType() {
        return com.app.pay.protobuf.RequestOrder.PayOrderInfo.getDefaultInstance();
      }

      @java.lang.Override
      public com.app.pay.protobuf.RequestOrder.PayOrderInfo build() {
        com.app.pay.protobuf.RequestOrder.PayOrderInfo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.app.pay.protobuf.RequestOrder.PayOrderInfo buildPartial() {
        com.app.pay.protobuf.RequestOrder.PayOrderInfo result = new com.app.pay.protobuf.RequestOrder.PayOrderInfo(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          result.requestId_ = requestId_;
          to_bitField0_ |= 0x00000001;
        }
        if (((from_bitField0_ & 0x00000002) != 0)) {
          to_bitField0_ |= 0x00000002;
        }
        result.checkBit_ = checkBit_;
        if (((from_bitField0_ & 0x00000004) != 0)) {
          to_bitField0_ |= 0x00000004;
        }
        result.bizContent_ = bizContent_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.app.pay.protobuf.RequestOrder.PayOrderInfo) {
          return mergeFrom((com.app.pay.protobuf.RequestOrder.PayOrderInfo)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.app.pay.protobuf.RequestOrder.PayOrderInfo other) {
        if (other == com.app.pay.protobuf.RequestOrder.PayOrderInfo.getDefaultInstance()) return this;
        if (other.hasRequestId()) {
          setRequestId(other.getRequestId());
        }
        if (other.hasCheckBit()) {
          bitField0_ |= 0x00000002;
          checkBit_ = other.checkBit_;
          onChanged();
        }
        if (other.hasBizContent()) {
          bitField0_ |= 0x00000004;
          bizContent_ = other.bizContent_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        if (!hasRequestId()) {
          return false;
        }
        if (!hasCheckBit()) {
          return false;
        }
        if (!hasBizContent()) {
          return false;
        }
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.app.pay.protobuf.RequestOrder.PayOrderInfo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.app.pay.protobuf.RequestOrder.PayOrderInfo) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int requestId_ ;
      /**
       * <code>required int32 requestId = 1;</code>
       */
      public boolean hasRequestId() {
        return ((bitField0_ & 0x00000001) != 0);
      }
      /**
       * <code>required int32 requestId = 1;</code>
       */
      public int getRequestId() {
        return requestId_;
      }
      /**
       * <code>required int32 requestId = 1;</code>
       */
      public Builder setRequestId(int value) {
        bitField0_ |= 0x00000001;
        requestId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 requestId = 1;</code>
       */
      public Builder clearRequestId() {
        bitField0_ = (bitField0_ & ~0x00000001);
        requestId_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object checkBit_ = "";
      /**
       * <code>required string checkBit = 2;</code>
       */
      public boolean hasCheckBit() {
        return ((bitField0_ & 0x00000002) != 0);
      }
      /**
       * <code>required string checkBit = 2;</code>
       */
      public java.lang.String getCheckBit() {
        java.lang.Object ref = checkBit_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            checkBit_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string checkBit = 2;</code>
       */
      public com.google.protobuf.ByteString
          getCheckBitBytes() {
        java.lang.Object ref = checkBit_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          checkBit_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string checkBit = 2;</code>
       */
      public Builder setCheckBit(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        checkBit_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string checkBit = 2;</code>
       */
      public Builder clearCheckBit() {
        bitField0_ = (bitField0_ & ~0x00000002);
        checkBit_ = getDefaultInstance().getCheckBit();
        onChanged();
        return this;
      }
      /**
       * <code>required string checkBit = 2;</code>
       */
      public Builder setCheckBitBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        checkBit_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object bizContent_ = "";
      /**
       * <code>required string bizContent = 3;</code>
       */
      public boolean hasBizContent() {
        return ((bitField0_ & 0x00000004) != 0);
      }
      /**
       * <code>required string bizContent = 3;</code>
       */
      public java.lang.String getBizContent() {
        java.lang.Object ref = bizContent_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            bizContent_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string bizContent = 3;</code>
       */
      public com.google.protobuf.ByteString
          getBizContentBytes() {
        java.lang.Object ref = bizContent_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          bizContent_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string bizContent = 3;</code>
       */
      public Builder setBizContent(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        bizContent_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string bizContent = 3;</code>
       */
      public Builder clearBizContent() {
        bitField0_ = (bitField0_ & ~0x00000004);
        bizContent_ = getDefaultInstance().getBizContent();
        onChanged();
        return this;
      }
      /**
       * <code>required string bizContent = 3;</code>
       */
      public Builder setBizContentBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        bizContent_ = value;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:com.app.pay.PayOrderInfo)
    }

    // @@protoc_insertion_point(class_scope:com.app.pay.PayOrderInfo)
    private static final com.app.pay.protobuf.RequestOrder.PayOrderInfo DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.app.pay.protobuf.RequestOrder.PayOrderInfo();
    }

    public static com.app.pay.protobuf.RequestOrder.PayOrderInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<PayOrderInfo>
        PARSER = new com.google.protobuf.AbstractParser<PayOrderInfo>() {
      @java.lang.Override
      public PayOrderInfo parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new PayOrderInfo(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<PayOrderInfo> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PayOrderInfo> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.app.pay.protobuf.RequestOrder.PayOrderInfo getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_app_pay_PayOrderInfo_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_app_pay_PayOrderInfo_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\037src/protobuf/RequestOrder.proto\022\013com.a" +
      "pp.pay\"G\n\014PayOrderInfo\022\021\n\trequestId\030\001 \002(" +
      "\005\022\020\n\010checkBit\030\002 \002(\t\022\022\n\nbizContent\030\003 \002(\tB" +
      "$\n\024com.app.pay.protobufB\014RequestOrder"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_app_pay_PayOrderInfo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_app_pay_PayOrderInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_app_pay_PayOrderInfo_descriptor,
        new java.lang.String[] { "RequestId", "CheckBit", "BizContent", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}