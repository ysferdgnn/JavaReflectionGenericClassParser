package org.seras.Classes.Pojos;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class SourceClass {

    public String stringVal="SKYWALKER";
    public Integer integerValue =10;
    public BigDecimal decimal =new BigDecimal("18");
    public Long longVal =50L;
    public Float floatVal=30f;
    public Byte byteVal =17;
    public Double doubleVal =78d;
    public Character charVal ='C';
    public Boolean boolVal =Boolean.TRUE;
    public Date dateUtil=new Date();
    public java.sql.Date dateSql=new java.sql.Date(new Date().getTime());
    public Timestamp timestamp=new Timestamp(new Date().getTime());
}
