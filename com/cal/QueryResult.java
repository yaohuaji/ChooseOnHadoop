// ORM class for table 'null'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Thu Oct 26 11:39:19 CST 2017
// For connector: org.apache.sqoop.manager.MySQLManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class QueryResult extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  protected ResultSet __cur_result_set;
  private Integer choose_no;
  public Integer get_choose_no() {
    return choose_no;
  }
  public void set_choose_no(Integer choose_no) {
    this.choose_no = choose_no;
  }
  public QueryResult with_choose_no(Integer choose_no) {
    this.choose_no = choose_no;
    return this;
  }
  private String student_no;
  public String get_student_no() {
    return student_no;
  }
  public void set_student_no(String student_no) {
    this.student_no = student_no;
  }
  public QueryResult with_student_no(String student_no) {
    this.student_no = student_no;
    return this;
  }
  private Integer course_no;
  public Integer get_course_no() {
    return course_no;
  }
  public void set_course_no(Integer course_no) {
    this.course_no = course_no;
  }
  public QueryResult with_course_no(Integer course_no) {
    this.course_no = course_no;
    return this;
  }
  private Integer score;
  public Integer get_score() {
    return score;
  }
  public void set_score(Integer score) {
    this.score = score;
  }
  public QueryResult with_score(Integer score) {
    this.score = score;
    return this;
  }
  private java.sql.Timestamp choose_time;
  public java.sql.Timestamp get_choose_time() {
    return choose_time;
  }
  public void set_choose_time(java.sql.Timestamp choose_time) {
    this.choose_time = choose_time;
  }
  public QueryResult with_choose_time(java.sql.Timestamp choose_time) {
    this.choose_time = choose_time;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof QueryResult)) {
      return false;
    }
    QueryResult that = (QueryResult) o;
    boolean equal = true;
    equal = equal && (this.choose_no == null ? that.choose_no == null : this.choose_no.equals(that.choose_no));
    equal = equal && (this.student_no == null ? that.student_no == null : this.student_no.equals(that.student_no));
    equal = equal && (this.course_no == null ? that.course_no == null : this.course_no.equals(that.course_no));
    equal = equal && (this.score == null ? that.score == null : this.score.equals(that.score));
    equal = equal && (this.choose_time == null ? that.choose_time == null : this.choose_time.equals(that.choose_time));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof QueryResult)) {
      return false;
    }
    QueryResult that = (QueryResult) o;
    boolean equal = true;
    equal = equal && (this.choose_no == null ? that.choose_no == null : this.choose_no.equals(that.choose_no));
    equal = equal && (this.student_no == null ? that.student_no == null : this.student_no.equals(that.student_no));
    equal = equal && (this.course_no == null ? that.course_no == null : this.course_no.equals(that.course_no));
    equal = equal && (this.score == null ? that.score == null : this.score.equals(that.score));
    equal = equal && (this.choose_time == null ? that.choose_time == null : this.choose_time.equals(that.choose_time));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.choose_no = JdbcWritableBridge.readInteger(1, __dbResults);
    this.student_no = JdbcWritableBridge.readString(2, __dbResults);
    this.course_no = JdbcWritableBridge.readInteger(3, __dbResults);
    this.score = JdbcWritableBridge.readInteger(4, __dbResults);
    this.choose_time = JdbcWritableBridge.readTimestamp(5, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.choose_no = JdbcWritableBridge.readInteger(1, __dbResults);
    this.student_no = JdbcWritableBridge.readString(2, __dbResults);
    this.course_no = JdbcWritableBridge.readInteger(3, __dbResults);
    this.score = JdbcWritableBridge.readInteger(4, __dbResults);
    this.choose_time = JdbcWritableBridge.readTimestamp(5, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(choose_no, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(student_no, 2 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeInteger(course_no, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(score, 4 + __off, -6, __dbStmt);
    JdbcWritableBridge.writeTimestamp(choose_time, 5 + __off, 93, __dbStmt);
    return 5;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(choose_no, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(student_no, 2 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeInteger(course_no, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(score, 4 + __off, -6, __dbStmt);
    JdbcWritableBridge.writeTimestamp(choose_time, 5 + __off, 93, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.choose_no = null;
    } else {
    this.choose_no = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.student_no = null;
    } else {
    this.student_no = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.course_no = null;
    } else {
    this.course_no = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.score = null;
    } else {
    this.score = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.choose_time = null;
    } else {
    this.choose_time = new Timestamp(__dataIn.readLong());
    this.choose_time.setNanos(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.choose_no) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.choose_no);
    }
    if (null == this.student_no) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, student_no);
    }
    if (null == this.course_no) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.course_no);
    }
    if (null == this.score) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.score);
    }
    if (null == this.choose_time) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.choose_time.getTime());
    __dataOut.writeInt(this.choose_time.getNanos());
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.choose_no) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.choose_no);
    }
    if (null == this.student_no) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, student_no);
    }
    if (null == this.course_no) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.course_no);
    }
    if (null == this.score) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.score);
    }
    if (null == this.choose_time) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.choose_time.getTime());
    __dataOut.writeInt(this.choose_time.getNanos());
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 1, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(choose_no==null?"\\N":"" + choose_no, delimiters));
    __sb.append(fieldDelim);
    // special case for strings hive, replacing delimiters \n,\r,\01 with '\\t' from strings
    __sb.append(FieldFormatter.hiveStringReplaceDelims(student_no==null?"\\N":student_no, "\\t", delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(course_no==null?"\\N":"" + course_no, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(score==null?"\\N":"" + score, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(choose_time==null?"\\N":"" + choose_time, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(choose_no==null?"\\N":"" + choose_no, delimiters));
    __sb.append(fieldDelim);
    // special case for strings hive, replacing delimiters \n,\r,\01 with '\\t' from strings
    __sb.append(FieldFormatter.hiveStringReplaceDelims(student_no==null?"\\N":student_no, "\\t", delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(course_no==null?"\\N":"" + course_no, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(score==null?"\\N":"" + score, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(choose_time==null?"\\N":"" + choose_time, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 1, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.choose_no = null; } else {
      this.choose_no = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.student_no = null; } else {
      this.student_no = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.course_no = null; } else {
      this.course_no = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.score = null; } else {
      this.score = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.choose_time = null; } else {
      this.choose_time = java.sql.Timestamp.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.choose_no = null; } else {
      this.choose_no = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.student_no = null; } else {
      this.student_no = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.course_no = null; } else {
      this.course_no = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.score = null; } else {
      this.score = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.choose_time = null; } else {
      this.choose_time = java.sql.Timestamp.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    QueryResult o = (QueryResult) super.clone();
    o.choose_time = (o.choose_time != null) ? (java.sql.Timestamp) o.choose_time.clone() : null;
    return o;
  }

  public void clone0(QueryResult o) throws CloneNotSupportedException {
    o.choose_time = (o.choose_time != null) ? (java.sql.Timestamp) o.choose_time.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new TreeMap<String, Object>();
    __sqoop$field_map.put("choose_no", this.choose_no);
    __sqoop$field_map.put("student_no", this.student_no);
    __sqoop$field_map.put("course_no", this.course_no);
    __sqoop$field_map.put("score", this.score);
    __sqoop$field_map.put("choose_time", this.choose_time);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("choose_no", this.choose_no);
    __sqoop$field_map.put("student_no", this.student_no);
    __sqoop$field_map.put("course_no", this.course_no);
    __sqoop$field_map.put("score", this.score);
    __sqoop$field_map.put("choose_time", this.choose_time);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if ("choose_no".equals(__fieldName)) {
      this.choose_no = (Integer) __fieldVal;
    }
    else    if ("student_no".equals(__fieldName)) {
      this.student_no = (String) __fieldVal;
    }
    else    if ("course_no".equals(__fieldName)) {
      this.course_no = (Integer) __fieldVal;
    }
    else    if ("score".equals(__fieldName)) {
      this.score = (Integer) __fieldVal;
    }
    else    if ("choose_time".equals(__fieldName)) {
      this.choose_time = (java.sql.Timestamp) __fieldVal;
    }
    else {
      throw new RuntimeException("No such field: " + __fieldName);
    }
  }
  public boolean setField0(String __fieldName, Object __fieldVal) {
    if ("choose_no".equals(__fieldName)) {
      this.choose_no = (Integer) __fieldVal;
      return true;
    }
    else    if ("student_no".equals(__fieldName)) {
      this.student_no = (String) __fieldVal;
      return true;
    }
    else    if ("course_no".equals(__fieldName)) {
      this.course_no = (Integer) __fieldVal;
      return true;
    }
    else    if ("score".equals(__fieldName)) {
      this.score = (Integer) __fieldVal;
      return true;
    }
    else    if ("choose_time".equals(__fieldName)) {
      this.choose_time = (java.sql.Timestamp) __fieldVal;
      return true;
    }
    else {
      return false;    }
  }
}
