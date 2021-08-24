package org.seras.Classes.Pojos;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class DestinationClass {
    public String stringVal;
    public Integer integerValue ;
    public BigDecimal decimal ;
    public Long longVal;
    public Float floatVal;
    public Byte byteVal ;
    public Double doubleVal ;
    public Character charVal ;
    public Boolean boolVal ;
    public Date dateUtil;
    public java.sql.Date dateSql;
    public Timestamp timestamp;

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
}