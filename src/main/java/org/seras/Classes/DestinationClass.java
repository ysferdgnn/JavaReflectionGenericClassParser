package org.seras.Classes;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.zip.DataFormatException;

public class DestinationClass {
    public String ad;
    public Integer integerValue ;
    public BigDecimal decimal ;
    public Long longval ;
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
                "ad='" + ad + '\'' +
                ", integerValue=" + integerValue +
                ", decimal=" + decimal +
                ", longval=" + longval +
                ", floatVal=" + floatVal +
                ", byteVal=" + byteVal +
                ", doubleVal=" + doubleVal +
                ", char1=" + charVal +
                ", boolVal=" + boolVal +
                '}';
    }
}
