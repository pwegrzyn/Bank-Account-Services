// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: interface/proto/currency_service.proto

package service;

/**
 * Protobuf type {@code ExchangeRateSequence}
 */
public  final class ExchangeRateSequence extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ExchangeRateSequence)
    ExchangeRateSequenceOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ExchangeRateSequence.newBuilder() to construct.
  private ExchangeRateSequence(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ExchangeRateSequence() {
    exchangeRateInfo_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ExchangeRateSequence(
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
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              exchangeRateInfo_ = new java.util.ArrayList<service.ExchangeRateInfo>();
              mutable_bitField0_ |= 0x00000001;
            }
            exchangeRateInfo_.add(
                input.readMessage(service.ExchangeRateInfo.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        exchangeRateInfo_ = java.util.Collections.unmodifiableList(exchangeRateInfo_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return service.CurrencyServiceProto.internal_static_ExchangeRateSequence_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return service.CurrencyServiceProto.internal_static_ExchangeRateSequence_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            service.ExchangeRateSequence.class, service.ExchangeRateSequence.Builder.class);
  }

  public static final int EXCHANGERATEINFO_FIELD_NUMBER = 1;
  private java.util.List<service.ExchangeRateInfo> exchangeRateInfo_;
  /**
   * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
   */
  public java.util.List<service.ExchangeRateInfo> getExchangeRateInfoList() {
    return exchangeRateInfo_;
  }
  /**
   * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
   */
  public java.util.List<? extends service.ExchangeRateInfoOrBuilder> 
      getExchangeRateInfoOrBuilderList() {
    return exchangeRateInfo_;
  }
  /**
   * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
   */
  public int getExchangeRateInfoCount() {
    return exchangeRateInfo_.size();
  }
  /**
   * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
   */
  public service.ExchangeRateInfo getExchangeRateInfo(int index) {
    return exchangeRateInfo_.get(index);
  }
  /**
   * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
   */
  public service.ExchangeRateInfoOrBuilder getExchangeRateInfoOrBuilder(
      int index) {
    return exchangeRateInfo_.get(index);
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
    for (int i = 0; i < exchangeRateInfo_.size(); i++) {
      output.writeMessage(1, exchangeRateInfo_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < exchangeRateInfo_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, exchangeRateInfo_.get(i));
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
    if (!(obj instanceof service.ExchangeRateSequence)) {
      return super.equals(obj);
    }
    service.ExchangeRateSequence other = (service.ExchangeRateSequence) obj;

    if (!getExchangeRateInfoList()
        .equals(other.getExchangeRateInfoList())) return false;
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
    if (getExchangeRateInfoCount() > 0) {
      hash = (37 * hash) + EXCHANGERATEINFO_FIELD_NUMBER;
      hash = (53 * hash) + getExchangeRateInfoList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static service.ExchangeRateSequence parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.ExchangeRateSequence parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.ExchangeRateSequence parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.ExchangeRateSequence parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.ExchangeRateSequence parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.ExchangeRateSequence parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.ExchangeRateSequence parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static service.ExchangeRateSequence parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static service.ExchangeRateSequence parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static service.ExchangeRateSequence parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static service.ExchangeRateSequence parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static service.ExchangeRateSequence parseFrom(
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
  public static Builder newBuilder(service.ExchangeRateSequence prototype) {
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
   * Protobuf type {@code ExchangeRateSequence}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ExchangeRateSequence)
      service.ExchangeRateSequenceOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return service.CurrencyServiceProto.internal_static_ExchangeRateSequence_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return service.CurrencyServiceProto.internal_static_ExchangeRateSequence_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              service.ExchangeRateSequence.class, service.ExchangeRateSequence.Builder.class);
    }

    // Construct using service.ExchangeRateSequence.newBuilder()
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
        getExchangeRateInfoFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (exchangeRateInfoBuilder_ == null) {
        exchangeRateInfo_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        exchangeRateInfoBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return service.CurrencyServiceProto.internal_static_ExchangeRateSequence_descriptor;
    }

    @java.lang.Override
    public service.ExchangeRateSequence getDefaultInstanceForType() {
      return service.ExchangeRateSequence.getDefaultInstance();
    }

    @java.lang.Override
    public service.ExchangeRateSequence build() {
      service.ExchangeRateSequence result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public service.ExchangeRateSequence buildPartial() {
      service.ExchangeRateSequence result = new service.ExchangeRateSequence(this);
      int from_bitField0_ = bitField0_;
      if (exchangeRateInfoBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          exchangeRateInfo_ = java.util.Collections.unmodifiableList(exchangeRateInfo_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.exchangeRateInfo_ = exchangeRateInfo_;
      } else {
        result.exchangeRateInfo_ = exchangeRateInfoBuilder_.build();
      }
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
      if (other instanceof service.ExchangeRateSequence) {
        return mergeFrom((service.ExchangeRateSequence)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(service.ExchangeRateSequence other) {
      if (other == service.ExchangeRateSequence.getDefaultInstance()) return this;
      if (exchangeRateInfoBuilder_ == null) {
        if (!other.exchangeRateInfo_.isEmpty()) {
          if (exchangeRateInfo_.isEmpty()) {
            exchangeRateInfo_ = other.exchangeRateInfo_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureExchangeRateInfoIsMutable();
            exchangeRateInfo_.addAll(other.exchangeRateInfo_);
          }
          onChanged();
        }
      } else {
        if (!other.exchangeRateInfo_.isEmpty()) {
          if (exchangeRateInfoBuilder_.isEmpty()) {
            exchangeRateInfoBuilder_.dispose();
            exchangeRateInfoBuilder_ = null;
            exchangeRateInfo_ = other.exchangeRateInfo_;
            bitField0_ = (bitField0_ & ~0x00000001);
            exchangeRateInfoBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getExchangeRateInfoFieldBuilder() : null;
          } else {
            exchangeRateInfoBuilder_.addAllMessages(other.exchangeRateInfo_);
          }
        }
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
      service.ExchangeRateSequence parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (service.ExchangeRateSequence) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<service.ExchangeRateInfo> exchangeRateInfo_ =
      java.util.Collections.emptyList();
    private void ensureExchangeRateInfoIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        exchangeRateInfo_ = new java.util.ArrayList<service.ExchangeRateInfo>(exchangeRateInfo_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        service.ExchangeRateInfo, service.ExchangeRateInfo.Builder, service.ExchangeRateInfoOrBuilder> exchangeRateInfoBuilder_;

    /**
     * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
     */
    public java.util.List<service.ExchangeRateInfo> getExchangeRateInfoList() {
      if (exchangeRateInfoBuilder_ == null) {
        return java.util.Collections.unmodifiableList(exchangeRateInfo_);
      } else {
        return exchangeRateInfoBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
     */
    public int getExchangeRateInfoCount() {
      if (exchangeRateInfoBuilder_ == null) {
        return exchangeRateInfo_.size();
      } else {
        return exchangeRateInfoBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
     */
    public service.ExchangeRateInfo getExchangeRateInfo(int index) {
      if (exchangeRateInfoBuilder_ == null) {
        return exchangeRateInfo_.get(index);
      } else {
        return exchangeRateInfoBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
     */
    public Builder setExchangeRateInfo(
        int index, service.ExchangeRateInfo value) {
      if (exchangeRateInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureExchangeRateInfoIsMutable();
        exchangeRateInfo_.set(index, value);
        onChanged();
      } else {
        exchangeRateInfoBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
     */
    public Builder setExchangeRateInfo(
        int index, service.ExchangeRateInfo.Builder builderForValue) {
      if (exchangeRateInfoBuilder_ == null) {
        ensureExchangeRateInfoIsMutable();
        exchangeRateInfo_.set(index, builderForValue.build());
        onChanged();
      } else {
        exchangeRateInfoBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
     */
    public Builder addExchangeRateInfo(service.ExchangeRateInfo value) {
      if (exchangeRateInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureExchangeRateInfoIsMutable();
        exchangeRateInfo_.add(value);
        onChanged();
      } else {
        exchangeRateInfoBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
     */
    public Builder addExchangeRateInfo(
        int index, service.ExchangeRateInfo value) {
      if (exchangeRateInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureExchangeRateInfoIsMutable();
        exchangeRateInfo_.add(index, value);
        onChanged();
      } else {
        exchangeRateInfoBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
     */
    public Builder addExchangeRateInfo(
        service.ExchangeRateInfo.Builder builderForValue) {
      if (exchangeRateInfoBuilder_ == null) {
        ensureExchangeRateInfoIsMutable();
        exchangeRateInfo_.add(builderForValue.build());
        onChanged();
      } else {
        exchangeRateInfoBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
     */
    public Builder addExchangeRateInfo(
        int index, service.ExchangeRateInfo.Builder builderForValue) {
      if (exchangeRateInfoBuilder_ == null) {
        ensureExchangeRateInfoIsMutable();
        exchangeRateInfo_.add(index, builderForValue.build());
        onChanged();
      } else {
        exchangeRateInfoBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
     */
    public Builder addAllExchangeRateInfo(
        java.lang.Iterable<? extends service.ExchangeRateInfo> values) {
      if (exchangeRateInfoBuilder_ == null) {
        ensureExchangeRateInfoIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, exchangeRateInfo_);
        onChanged();
      } else {
        exchangeRateInfoBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
     */
    public Builder clearExchangeRateInfo() {
      if (exchangeRateInfoBuilder_ == null) {
        exchangeRateInfo_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        exchangeRateInfoBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
     */
    public Builder removeExchangeRateInfo(int index) {
      if (exchangeRateInfoBuilder_ == null) {
        ensureExchangeRateInfoIsMutable();
        exchangeRateInfo_.remove(index);
        onChanged();
      } else {
        exchangeRateInfoBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
     */
    public service.ExchangeRateInfo.Builder getExchangeRateInfoBuilder(
        int index) {
      return getExchangeRateInfoFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
     */
    public service.ExchangeRateInfoOrBuilder getExchangeRateInfoOrBuilder(
        int index) {
      if (exchangeRateInfoBuilder_ == null) {
        return exchangeRateInfo_.get(index);  } else {
        return exchangeRateInfoBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
     */
    public java.util.List<? extends service.ExchangeRateInfoOrBuilder> 
         getExchangeRateInfoOrBuilderList() {
      if (exchangeRateInfoBuilder_ != null) {
        return exchangeRateInfoBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(exchangeRateInfo_);
      }
    }
    /**
     * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
     */
    public service.ExchangeRateInfo.Builder addExchangeRateInfoBuilder() {
      return getExchangeRateInfoFieldBuilder().addBuilder(
          service.ExchangeRateInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
     */
    public service.ExchangeRateInfo.Builder addExchangeRateInfoBuilder(
        int index) {
      return getExchangeRateInfoFieldBuilder().addBuilder(
          index, service.ExchangeRateInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .ExchangeRateInfo exchangeRateInfo = 1;</code>
     */
    public java.util.List<service.ExchangeRateInfo.Builder> 
         getExchangeRateInfoBuilderList() {
      return getExchangeRateInfoFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        service.ExchangeRateInfo, service.ExchangeRateInfo.Builder, service.ExchangeRateInfoOrBuilder> 
        getExchangeRateInfoFieldBuilder() {
      if (exchangeRateInfoBuilder_ == null) {
        exchangeRateInfoBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            service.ExchangeRateInfo, service.ExchangeRateInfo.Builder, service.ExchangeRateInfoOrBuilder>(
                exchangeRateInfo_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        exchangeRateInfo_ = null;
      }
      return exchangeRateInfoBuilder_;
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


    // @@protoc_insertion_point(builder_scope:ExchangeRateSequence)
  }

  // @@protoc_insertion_point(class_scope:ExchangeRateSequence)
  private static final service.ExchangeRateSequence DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new service.ExchangeRateSequence();
  }

  public static service.ExchangeRateSequence getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ExchangeRateSequence>
      PARSER = new com.google.protobuf.AbstractParser<ExchangeRateSequence>() {
    @java.lang.Override
    public ExchangeRateSequence parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ExchangeRateSequence(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ExchangeRateSequence> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ExchangeRateSequence> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public service.ExchangeRateSequence getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

