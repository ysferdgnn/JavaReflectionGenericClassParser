package org.ysferdgnn.Classes.Pojos;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class SourceClass {

    private String stringVal="SKYWALKER";
    private Integer integerValue =10;
    private BigDecimal decimal =new BigDecimal("18");
    private Long longVal =50L;
    private Float floatVal=30f;
    private Byte byteVal =17;
    private Double doubleVal =78d;
    private Character charVal ='C';
    private Boolean boolVal =Boolean.TRUE;
    private Date dateUtil=new Date();
    private java.sql.Date dateSql=new java.sql.Date(new Date().getTime());
    private Timestamp timestamp=new Timestamp(new Date().getTime());


    public String getStringVal() {
        return stringVal;
    }

    public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
    }

    public Integer getIntegerValue() {
        return integerValue;
    }

    public void setIntegerValue(Integer integerValue) {
        this.integerValue = integerValue;
    }

    public BigDecimal getDecimal() {
        return decimal;
    }

    public void setDecimal(BigDecimal decimal) {
        this.decimal = decimal;
    }

    public Long getLongVal() {
        return longVal;
    }

    public void setLongVal(Long longVal) {
        this.longVal = longVal;
    }

    public Float getFloatVal() {
        return floatVal;
    }

    public void setFloatVal(Float floatVal) {
        this.floatVal = floatVal;
    }

    public Byte getByteVal() {
        return byteVal;
    }

    public void setByteVal(Byte byteVal) {
        this.byteVal = byteVal;
    }

    public Double getDoubleVal() {
        return doubleVal;
    }

    public void setDoubleVal(Double doubleVal) {
        this.doubleVal = doubleVal;
    }

    public Character getCharVal() {
        return charVal;
    }

    public void setCharVal(Character charVal) {
        this.charVal = charVal;
    }

    public Boolean getBoolVal() {
        return boolVal;
    }

    public void setBoolVal(Boolean boolVal) {
        this.boolVal = boolVal;
    }

    public Date getDateUtil() {
        return dateUtil;
    }

    public void setDateUtil(Date dateUtil) {
        this.dateUtil = dateUtil;
    }

    public java.sql.Date getDateSql() {
        return dateSql;
    }

    public void setDateSql(java.sql.Date dateSql) {
        this.dateSql = dateSql;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
