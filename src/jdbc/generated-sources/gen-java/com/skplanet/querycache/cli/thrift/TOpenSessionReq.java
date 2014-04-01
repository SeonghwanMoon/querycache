/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.skplanet.querycache.cli.thrift;

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

public class TOpenSessionReq implements org.apache.thrift.TBase<TOpenSessionReq, TOpenSessionReq._Fields>, java.io.Serializable, Cloneable, Comparable<TOpenSessionReq> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TOpenSessionReq");

  private static final org.apache.thrift.protocol.TField CLIENT_PROTOCOL_FIELD_DESC = new org.apache.thrift.protocol.TField("clientProtocol", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField URL_FIELD_DESC = new org.apache.thrift.protocol.TField("url", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField USERNAME_FIELD_DESC = new org.apache.thrift.protocol.TField("username", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField PASSWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("password", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField CONFIGURATION_FIELD_DESC = new org.apache.thrift.protocol.TField("configuration", org.apache.thrift.protocol.TType.MAP, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TOpenSessionReqStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TOpenSessionReqTupleSchemeFactory());
  }

  /**
   * 
   * @see TProtocolVersion
   */
  public TProtocolVersion clientProtocol; // required
  public String url; // required
  public String username; // optional
  public String password; // optional
  public Map<String,String> configuration; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see TProtocolVersion
     */
    CLIENT_PROTOCOL((short)1, "clientProtocol"),
    URL((short)2, "url"),
    USERNAME((short)3, "username"),
    PASSWORD((short)4, "password"),
    CONFIGURATION((short)5, "configuration");

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
        case 1: // CLIENT_PROTOCOL
          return CLIENT_PROTOCOL;
        case 2: // URL
          return URL;
        case 3: // USERNAME
          return USERNAME;
        case 4: // PASSWORD
          return PASSWORD;
        case 5: // CONFIGURATION
          return CONFIGURATION;
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
  private _Fields optionals[] = {_Fields.USERNAME,_Fields.PASSWORD,_Fields.CONFIGURATION};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CLIENT_PROTOCOL, new org.apache.thrift.meta_data.FieldMetaData("clientProtocol", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, TProtocolVersion.class)));
    tmpMap.put(_Fields.URL, new org.apache.thrift.meta_data.FieldMetaData("url", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.USERNAME, new org.apache.thrift.meta_data.FieldMetaData("username", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PASSWORD, new org.apache.thrift.meta_data.FieldMetaData("password", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CONFIGURATION, new org.apache.thrift.meta_data.FieldMetaData("configuration", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TOpenSessionReq.class, metaDataMap);
  }

  public TOpenSessionReq() {
    this.clientProtocol = com.skplanet.querycache.cli.thrift.TProtocolVersion.QUERYCACHE_CLI_PROTOCOL_V1;

  }

  public TOpenSessionReq(
    TProtocolVersion clientProtocol,
    String url)
  {
    this();
    this.clientProtocol = clientProtocol;
    this.url = url;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TOpenSessionReq(TOpenSessionReq other) {
    if (other.isSetClientProtocol()) {
      this.clientProtocol = other.clientProtocol;
    }
    if (other.isSetUrl()) {
      this.url = other.url;
    }
    if (other.isSetUsername()) {
      this.username = other.username;
    }
    if (other.isSetPassword()) {
      this.password = other.password;
    }
    if (other.isSetConfiguration()) {
      Map<String,String> __this__configuration = new HashMap<String,String>(other.configuration);
      this.configuration = __this__configuration;
    }
  }

  public TOpenSessionReq deepCopy() {
    return new TOpenSessionReq(this);
  }

  @Override
  public void clear() {
    this.clientProtocol = com.skplanet.querycache.cli.thrift.TProtocolVersion.QUERYCACHE_CLI_PROTOCOL_V1;

    this.url = null;
    this.username = null;
    this.password = null;
    this.configuration = null;
  }

  /**
   * 
   * @see TProtocolVersion
   */
  public TProtocolVersion getClientProtocol() {
    return this.clientProtocol;
  }

  /**
   * 
   * @see TProtocolVersion
   */
  public TOpenSessionReq setClientProtocol(TProtocolVersion clientProtocol) {
    this.clientProtocol = clientProtocol;
    return this;
  }

  public void unsetClientProtocol() {
    this.clientProtocol = null;
  }

  /** Returns true if field clientProtocol is set (has been assigned a value) and false otherwise */
  public boolean isSetClientProtocol() {
    return this.clientProtocol != null;
  }

  public void setClientProtocolIsSet(boolean value) {
    if (!value) {
      this.clientProtocol = null;
    }
  }

  public String getUrl() {
    return this.url;
  }

  public TOpenSessionReq setUrl(String url) {
    this.url = url;
    return this;
  }

  public void unsetUrl() {
    this.url = null;
  }

  /** Returns true if field url is set (has been assigned a value) and false otherwise */
  public boolean isSetUrl() {
    return this.url != null;
  }

  public void setUrlIsSet(boolean value) {
    if (!value) {
      this.url = null;
    }
  }

  public String getUsername() {
    return this.username;
  }

  public TOpenSessionReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public void unsetUsername() {
    this.username = null;
  }

  /** Returns true if field username is set (has been assigned a value) and false otherwise */
  public boolean isSetUsername() {
    return this.username != null;
  }

  public void setUsernameIsSet(boolean value) {
    if (!value) {
      this.username = null;
    }
  }

  public String getPassword() {
    return this.password;
  }

  public TOpenSessionReq setPassword(String password) {
    this.password = password;
    return this;
  }

  public void unsetPassword() {
    this.password = null;
  }

  /** Returns true if field password is set (has been assigned a value) and false otherwise */
  public boolean isSetPassword() {
    return this.password != null;
  }

  public void setPasswordIsSet(boolean value) {
    if (!value) {
      this.password = null;
    }
  }

  public int getConfigurationSize() {
    return (this.configuration == null) ? 0 : this.configuration.size();
  }

  public void putToConfiguration(String key, String val) {
    if (this.configuration == null) {
      this.configuration = new HashMap<String,String>();
    }
    this.configuration.put(key, val);
  }

  public Map<String,String> getConfiguration() {
    return this.configuration;
  }

  public TOpenSessionReq setConfiguration(Map<String,String> configuration) {
    this.configuration = configuration;
    return this;
  }

  public void unsetConfiguration() {
    this.configuration = null;
  }

  /** Returns true if field configuration is set (has been assigned a value) and false otherwise */
  public boolean isSetConfiguration() {
    return this.configuration != null;
  }

  public void setConfigurationIsSet(boolean value) {
    if (!value) {
      this.configuration = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CLIENT_PROTOCOL:
      if (value == null) {
        unsetClientProtocol();
      } else {
        setClientProtocol((TProtocolVersion)value);
      }
      break;

    case URL:
      if (value == null) {
        unsetUrl();
      } else {
        setUrl((String)value);
      }
      break;

    case USERNAME:
      if (value == null) {
        unsetUsername();
      } else {
        setUsername((String)value);
      }
      break;

    case PASSWORD:
      if (value == null) {
        unsetPassword();
      } else {
        setPassword((String)value);
      }
      break;

    case CONFIGURATION:
      if (value == null) {
        unsetConfiguration();
      } else {
        setConfiguration((Map<String,String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CLIENT_PROTOCOL:
      return getClientProtocol();

    case URL:
      return getUrl();

    case USERNAME:
      return getUsername();

    case PASSWORD:
      return getPassword();

    case CONFIGURATION:
      return getConfiguration();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CLIENT_PROTOCOL:
      return isSetClientProtocol();
    case URL:
      return isSetUrl();
    case USERNAME:
      return isSetUsername();
    case PASSWORD:
      return isSetPassword();
    case CONFIGURATION:
      return isSetConfiguration();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TOpenSessionReq)
      return this.equals((TOpenSessionReq)that);
    return false;
  }

  public boolean equals(TOpenSessionReq that) {
    if (that == null)
      return false;

    boolean this_present_clientProtocol = true && this.isSetClientProtocol();
    boolean that_present_clientProtocol = true && that.isSetClientProtocol();
    if (this_present_clientProtocol || that_present_clientProtocol) {
      if (!(this_present_clientProtocol && that_present_clientProtocol))
        return false;
      if (!this.clientProtocol.equals(that.clientProtocol))
        return false;
    }

    boolean this_present_url = true && this.isSetUrl();
    boolean that_present_url = true && that.isSetUrl();
    if (this_present_url || that_present_url) {
      if (!(this_present_url && that_present_url))
        return false;
      if (!this.url.equals(that.url))
        return false;
    }

    boolean this_present_username = true && this.isSetUsername();
    boolean that_present_username = true && that.isSetUsername();
    if (this_present_username || that_present_username) {
      if (!(this_present_username && that_present_username))
        return false;
      if (!this.username.equals(that.username))
        return false;
    }

    boolean this_present_password = true && this.isSetPassword();
    boolean that_present_password = true && that.isSetPassword();
    if (this_present_password || that_present_password) {
      if (!(this_present_password && that_present_password))
        return false;
      if (!this.password.equals(that.password))
        return false;
    }

    boolean this_present_configuration = true && this.isSetConfiguration();
    boolean that_present_configuration = true && that.isSetConfiguration();
    if (this_present_configuration || that_present_configuration) {
      if (!(this_present_configuration && that_present_configuration))
        return false;
      if (!this.configuration.equals(that.configuration))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_clientProtocol = true && (isSetClientProtocol());
    builder.append(present_clientProtocol);
    if (present_clientProtocol)
      builder.append(clientProtocol.getValue());

    boolean present_url = true && (isSetUrl());
    builder.append(present_url);
    if (present_url)
      builder.append(url);

    boolean present_username = true && (isSetUsername());
    builder.append(present_username);
    if (present_username)
      builder.append(username);

    boolean present_password = true && (isSetPassword());
    builder.append(present_password);
    if (present_password)
      builder.append(password);

    boolean present_configuration = true && (isSetConfiguration());
    builder.append(present_configuration);
    if (present_configuration)
      builder.append(configuration);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(TOpenSessionReq other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetClientProtocol()).compareTo(other.isSetClientProtocol());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetClientProtocol()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.clientProtocol, other.clientProtocol);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUrl()).compareTo(other.isSetUrl());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUrl()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.url, other.url);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUsername()).compareTo(other.isSetUsername());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUsername()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.username, other.username);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPassword()).compareTo(other.isSetPassword());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPassword()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.password, other.password);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetConfiguration()).compareTo(other.isSetConfiguration());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetConfiguration()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.configuration, other.configuration);
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
    StringBuilder sb = new StringBuilder("TOpenSessionReq(");
    boolean first = true;

    sb.append("clientProtocol:");
    if (this.clientProtocol == null) {
      sb.append("null");
    } else {
      sb.append(this.clientProtocol);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("url:");
    if (this.url == null) {
      sb.append("null");
    } else {
      sb.append(this.url);
    }
    first = false;
    if (isSetUsername()) {
      if (!first) sb.append(", ");
      sb.append("username:");
      if (this.username == null) {
        sb.append("null");
      } else {
        sb.append(this.username);
      }
      first = false;
    }
    if (isSetPassword()) {
      if (!first) sb.append(", ");
      sb.append("password:");
      if (this.password == null) {
        sb.append("null");
      } else {
        sb.append(this.password);
      }
      first = false;
    }
    if (isSetConfiguration()) {
      if (!first) sb.append(", ");
      sb.append("configuration:");
      if (this.configuration == null) {
        sb.append("null");
      } else {
        sb.append(this.configuration);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (clientProtocol == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'clientProtocol' was not present! Struct: " + toString());
    }
    if (url == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'url' was not present! Struct: " + toString());
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

  private static class TOpenSessionReqStandardSchemeFactory implements SchemeFactory {
    public TOpenSessionReqStandardScheme getScheme() {
      return new TOpenSessionReqStandardScheme();
    }
  }

  private static class TOpenSessionReqStandardScheme extends StandardScheme<TOpenSessionReq> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TOpenSessionReq struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CLIENT_PROTOCOL
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.clientProtocol = TProtocolVersion.findByValue(iprot.readI32());
              struct.setClientProtocolIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // URL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.url = iprot.readString();
              struct.setUrlIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // USERNAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.username = iprot.readString();
              struct.setUsernameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PASSWORD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.password = iprot.readString();
              struct.setPasswordIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // CONFIGURATION
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map8 = iprot.readMapBegin();
                struct.configuration = new HashMap<String,String>(2*_map8.size);
                for (int _i9 = 0; _i9 < _map8.size; ++_i9)
                {
                  String _key10;
                  String _val11;
                  _key10 = iprot.readString();
                  _val11 = iprot.readString();
                  struct.configuration.put(_key10, _val11);
                }
                iprot.readMapEnd();
              }
              struct.setConfigurationIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, TOpenSessionReq struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.clientProtocol != null) {
        oprot.writeFieldBegin(CLIENT_PROTOCOL_FIELD_DESC);
        oprot.writeI32(struct.clientProtocol.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.url != null) {
        oprot.writeFieldBegin(URL_FIELD_DESC);
        oprot.writeString(struct.url);
        oprot.writeFieldEnd();
      }
      if (struct.username != null) {
        if (struct.isSetUsername()) {
          oprot.writeFieldBegin(USERNAME_FIELD_DESC);
          oprot.writeString(struct.username);
          oprot.writeFieldEnd();
        }
      }
      if (struct.password != null) {
        if (struct.isSetPassword()) {
          oprot.writeFieldBegin(PASSWORD_FIELD_DESC);
          oprot.writeString(struct.password);
          oprot.writeFieldEnd();
        }
      }
      if (struct.configuration != null) {
        if (struct.isSetConfiguration()) {
          oprot.writeFieldBegin(CONFIGURATION_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.configuration.size()));
            for (Map.Entry<String, String> _iter12 : struct.configuration.entrySet())
            {
              oprot.writeString(_iter12.getKey());
              oprot.writeString(_iter12.getValue());
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TOpenSessionReqTupleSchemeFactory implements SchemeFactory {
    public TOpenSessionReqTupleScheme getScheme() {
      return new TOpenSessionReqTupleScheme();
    }
  }

  private static class TOpenSessionReqTupleScheme extends TupleScheme<TOpenSessionReq> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TOpenSessionReq struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.clientProtocol.getValue());
      oprot.writeString(struct.url);
      BitSet optionals = new BitSet();
      if (struct.isSetUsername()) {
        optionals.set(0);
      }
      if (struct.isSetPassword()) {
        optionals.set(1);
      }
      if (struct.isSetConfiguration()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetUsername()) {
        oprot.writeString(struct.username);
      }
      if (struct.isSetPassword()) {
        oprot.writeString(struct.password);
      }
      if (struct.isSetConfiguration()) {
        {
          oprot.writeI32(struct.configuration.size());
          for (Map.Entry<String, String> _iter13 : struct.configuration.entrySet())
          {
            oprot.writeString(_iter13.getKey());
            oprot.writeString(_iter13.getValue());
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TOpenSessionReq struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.clientProtocol = TProtocolVersion.findByValue(iprot.readI32());
      struct.setClientProtocolIsSet(true);
      struct.url = iprot.readString();
      struct.setUrlIsSet(true);
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.username = iprot.readString();
        struct.setUsernameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.password = iprot.readString();
        struct.setPasswordIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TMap _map14 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.configuration = new HashMap<String,String>(2*_map14.size);
          for (int _i15 = 0; _i15 < _map14.size; ++_i15)
          {
            String _key16;
            String _val17;
            _key16 = iprot.readString();
            _val17 = iprot.readString();
            struct.configuration.put(_key16, _val17);
          }
        }
        struct.setConfigurationIsSet(true);
      }
    }
  }

}

