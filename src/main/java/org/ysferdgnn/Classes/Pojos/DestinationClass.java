package org.ysferdgnn.Classes.Pojos;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class DestinationClass {
    private String stringVal;
    private Integer integerValue ;
    private BigDecimal decimal ;
    private Long longVal;
    private Float floatVal;
    private Byte byteVal ;
    private Double doubleVal ;
    private Character charVal ;
    private Boolean boolVal ;
    private Date dateUtil;
    private java.sql.Date dateSql;
    private Timestamp timestamp;

    @Override
    public String toString() {
        return "DestinationClass{" +
                "stringVal='" + stringVal + '\'' +
                ", integerValue=" + integerValue +
                ", decimal=" + decimal +
                ", longval=" + longVal +
                ", floatVal=" + floatVal +
                ", byteVal=" + byteVal +
                ", doubleVal=" + doubleVal +
                ", charVal=" + charVal +
                ", boolVal=" + boolVal +
                ", dateUtil=" + dateUtil +
                ", dateSql=" + dateSql +
                ", timestamp=" + timestamp +
                '}';
    }

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
