package org.example.Classes;

import java.math.BigDecimal;

public class DestinationClass {
    public String ad;
    public Integer integerValue ;
    public BigDecimal decimal ;
    public Long longval ;
    public Float floatVal;
    public Byte byteVal ;
    public Double doubleVal ;
    public Character char1 ;
    public Boolean boolVal ;

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
                ", char1=" + char1 +
                ", boolVal=" + boolVal +
                '}';
    }
}
