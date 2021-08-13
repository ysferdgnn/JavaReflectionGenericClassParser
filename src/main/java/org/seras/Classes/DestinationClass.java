package org.seras.Classes;

import java.math.BigDecimal;

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
