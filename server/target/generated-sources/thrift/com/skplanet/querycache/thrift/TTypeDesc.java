/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.skplanet.querycache.thrift;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TTypeDesc implements org.apache.thrift.TBase<TTypeDesc, TTypeDesc._Fields>, java.io.Serializable, Cloneable, Comparable<TTypeDesc> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TTypeDesc");

  private static final org.apache.thrift.protocol.TField TYPES_FIELD_DESC = new org.apache.thrift.protocol.TField("types", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TTypeDescStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TTypeDescTupleSchemeFactory());
  }

  public List<TTypeEntry> types; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TYPES((short)1, "types");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TYPES
          return TYPES;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TYPES, new org.apache.thrift.meta_data.FieldMetaData("types", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TTypeEntry.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TTypeDesc.class, metaDataMap);
  }

  public TTypeDesc() {
  }

  public TTypeDesc(
    List<TTypeEntry> types)
  {
    this();
    this.types = types;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TTypeDesc(TTypeDesc other) {
    if (other.isSetTypes()) {
      List<TTypeEntry> __this__types = new ArrayList<TTypeEntry>(other.types.size());
      for (TTypeEntry other_element : other.types) {
        __this__types.add(new TTypeEntry(other_element));
      }
      this.types = __this__types;
    }
  }

  public TTypeDesc deepCopy() {
    return new TTypeDesc(this);
  }

  @Override
  public void clear() {
    this.types = null;
  }

  public int getTypesSize() {
    return (this.types == null) ? 0 : this.types.size();
  }

  public java.util.Iterator<TTypeEntry> getTypesIterator() {
    return (this.types == null) ? null : this.types.iterator();
  }

  public void addToTypes(TTypeEntry elem) {
    if (this.types == null) {
      this.types = new ArrayList<TTypeEntry>();
    }
    this.types.add(elem);
  }

  public List<TTypeEntry> getTypes() {
    return this.types;
  }

  public TTypeDesc setTypes(List<TTypeEntry> types) {
    this.types = types;
    return this;
  }

  public void unsetTypes() {
    this.types = null;
  }

  /** Returns true if field types is set (has been assigned a value) and false otherwise */
  public boolean isSetTypes() {
    return this.types != null;
  }

  public void setTypesIsSet(boolean value) {
    if (!value) {
      this.types = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TYPES:
      if (value == null) {
        unsetTypes();
      } else {
        setTypes((List<TTypeEntry>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TYPES:
      return getTypes();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TYPES:
      return isSetTypes();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TTypeDesc)
      return this.equals((TTypeDesc)that);
    return false;
  }

  public boolean equals(TTypeDesc that) {
    if (that == null)
      return false;

    boolean this_present_types = true && this.isSetTypes();
    boolean that_present_types = true && that.isSetTypes();
    if (this_present_types || that_present_types) {
      if (!(this_present_types && that_present_types))
        return false;
      if (!this.types.equals(that.types))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_types = true && (isSetTypes());
    builder.append(present_types);
    if (present_types)
      builder.append(types);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(TTypeDesc other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetTypes()).compareTo(other.isSetTypes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTypes()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.types, other.types);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TTypeDesc(");
    boolean first = true;

    sb.append("types:");
    if (this.types == null) {
      sb.append("null");
    } else {
      sb.append(this.types);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (types == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'types' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TTypeDescStandardSchemeFactory implements SchemeFactory {
    public TTypeDescStandardScheme getScheme() {
      return new TTypeDescStandardScheme();
    }
  }

  private static class TTypeDescStandardScheme extends StandardScheme<TTypeDesc> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TTypeDesc struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TYPES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list20 = iprot.readListBegin();
                struct.types = new ArrayList<TTypeEntry>(_list20.size);
                for (int _i21 = 0; _i21 < _list20.size; ++_i21)
                {
                  TTypeEntry _elem22;
                  _elem22 = new TTypeEntry();
                  _elem22.read(iprot);
                  struct.types.add(_elem22);
                }
                iprot.readListEnd();
              }
              struct.setTypesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TTypeDesc struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.types != null) {
        oprot.writeFieldBegin(TYPES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.types.size()));
          for (TTypeEntry _iter23 : struct.types)
          {
            _iter23.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TTypeDescTupleSchemeFactory implements SchemeFactory {
    public TTypeDescTupleScheme getScheme() {
      return new TTypeDescTupleScheme();
    }
  }

  private static class TTypeDescTupleScheme extends TupleScheme<TTypeDesc> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TTypeDesc struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      {
        oprot.writeI32(struct.types.size());
        for (TTypeEntry _iter24 : struct.types)
        {
          _iter24.write(oprot);
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TTypeDesc struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TList _list25 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.types = new ArrayList<TTypeEntry>(_list25.size);
        for (int _i26 = 0; _i26 < _list25.size; ++_i26)
        {
          TTypeEntry _elem27;
          _elem27 = new TTypeEntry();
          _elem27.read(iprot);
          struct.types.add(_elem27);
        }
      }
      struct.setTypesIsSet(true);
    }
  }

}

