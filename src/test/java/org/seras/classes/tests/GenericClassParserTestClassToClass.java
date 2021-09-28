package org.seras.classes.tests;

import org.junit.Assert;
import org.seras.Classes.Exceptions.NullClassException;
import org.seras.Classes.Exceptions.NullClassFieldException;
import org.seras.Classes.Exceptions.NullFieldMatchMapException;
import org.seras.Classes.Pojos.*;
import org.seras.GenericClassParser;
import org.seras.classes.bases.GenericClassParserBaseClassToClass;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class GenericClassParserTestClassToClass extends GenericClassParserBaseClassToClass {


    @Override
    public void initDestinationClass() {
        super.initDestinationClass();
    }

    @Override
    public void testStringToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {

        this.fieldMatchMap.put("stringVal", "stringVal");
        genericClassParser.parseClassToClass(this.sourceClass,this.destinationClass,this.fieldMatchMap);
        Assert.assertEquals(destinationClass.getStringVal(), sourceClass.getStringVal());

    }

    @Override
    public void testNullToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setStringVal(null);
        this.fieldMatchMap.put("stringVal", "stringVal");
        genericClassParser.parseClassToClass(this.sourceClass,this.destinationClass,this.fieldMatchMap);
        Assert.assertNull(destinationClass.getStringVal());
    }

    @Override
    public void testIntegerToInteger() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {

        this.fieldMatchMap.put("integerValue", "integerValue");
        genericClassParser.parseClassToClass(this.sourceClass,this.destinationClass,this.fieldMatchMap);
        Assert.assertEquals(destinationClass.getIntegerValue(), sourceClass.getIntegerValue());
    }

    @Override
    public void testNullToInteger() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setIntegerValue(null);
        this.fieldMatchMap.put("integerValue", "integerValue");
        genericClassParser.parseClassToClass(this.sourceClass,this.destinationClass,this.fieldMatchMap);
        Assert.assertNull(destinationClass.getIntegerValue());
    }

    @Override
    public void testIntegerToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {

        this.fieldMatchMap.put("integerValue", "stringVal");
        genericClassParser.parseClassToClass(this.sourceClass,this.destinationClass,this.fieldMatchMap);
        Assert.assertEquals(destinationClass.getStringVal(),sourceClass.getIntegerValue().toString());
    }

    @Override
    public void testStringToInteger() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
       sourceClass.setStringVal("50");
       fieldMatchMap.put("stringVal", "integerValue");
       genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
       Assert.assertEquals(destinationClass.getIntegerValue(), new Integer(50));
    }

    @Override
    public void testBigDecimalToBigDecimal() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
       fieldMatchMap.put("decimal","decimal");
       genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
       Assert.assertEquals(sourceClass.getDecimal(),destinationClass.getDecimal());
    }

    @Override
    public void testNullToBigDecimal() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setDecimal(null);
        fieldMatchMap.put("decimal","decimal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.getDecimal());
    }

    @Override
    public void testBigDecimalToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("decimal","stringVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getStringVal(),sourceClass.getDecimal().toString());
    }

    @Override
    public void testStringToBigDecimal() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setStringVal("50");
        fieldMatchMap.put("stringVal","decimal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getDecimal(),new BigDecimal("50"));
    }

    @Override
    public void testLongToLong() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("longVal","longVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getLongVal(),sourceClass.getLongVal());
    }

    @Override
    public void testNullToLong() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setLongVal(null);
        fieldMatchMap.put("longVal","longVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.getLongVal());
    }

    @Override
    public void testLongToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("longVal","stringVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getStringVal(),sourceClass.getLongVal().toString());
    }

    @Override
    public void testStringToLong() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setStringVal("50");
        fieldMatchMap.put("stringVal","longVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getLongVal(), new Long(50L));
    }

    @Override
    public void testFloatToFloat() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("floatVal","floatVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getFloatVal(),sourceClass.getFloatVal());
    }

    @Override
    public void testNullToFloat() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
       sourceClass.setFloatVal(null);
       fieldMatchMap.put("floatVal","floatVal");
       genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
       Assert.assertNull(destinationClass.getFloatVal());
    }

    @Override
    public void testFloatToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setFloatVal(60f);
        fieldMatchMap.put("floatVal","stringVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getStringVal(),"60.0");
    }

    @Override
    public void testStringToFloat() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setStringVal("10");
        fieldMatchMap.put("stringVal","floatVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getFloatVal(),new Float(10f));
    }

    @Override
    public void testByteToByte() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("byteVal","byteVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getByteVal(),sourceClass.getByteVal());
    }

    @Override
    public void testNullToByte() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setByteVal(null);
        fieldMatchMap.put("byteVal","byteVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.getByteVal());
    }

    @Override
    public void testByteToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("byteVal","stringVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getStringVal(),sourceClass.getByteVal().toString());
    }

    @Override
    public void testStringToByte() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setStringVal("10");
        fieldMatchMap.put("stringVal","byteVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getByteVal(),new Byte("10"));
    }

    @Override
    public void testDoubleToDouble() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("doubleVal","doubleVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getDoubleVal(),sourceClass.getDoubleVal());
    }

    @Override
    public void testNullToDouble() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setDoubleVal(null);
        fieldMatchMap.put("doubleVal","doubleVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.getDoubleVal());
    }

    @Override
    public void testDoubleToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("doubleVal","stringVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getStringVal(),sourceClass.getDoubleVal().toString());
    }

    @Override
    public void testStringToDouble() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setStringVal("50");
        fieldMatchMap.put("stringVal","doubleVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getDoubleVal(),new Double("50"));
    }

    @Override
    public void testCharacterToCharacter() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("charVal","charVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getCharVal(),sourceClass.getCharVal());
    }

    @Override
    public void testNullToCharacter() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setCharVal(null);
        fieldMatchMap.put("charVal","charVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.getCharVal());
    }

    @Override
    public void testCharacterToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
       fieldMatchMap.put("charVal","stringVal");
       genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
       Assert.assertEquals(destinationClass.getStringVal(),sourceClass.getCharVal().toString());
    }

    @Override
    public void testStringToCharacter() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setStringVal("C");
        fieldMatchMap.put("stringVal","charVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getCharVal(),new Character('C'));
    }

    @Override
    public void testBooleanToBoolean() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("boolVal","boolVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getBoolVal(),sourceClass.getBoolVal());
    }

    @Override
    public void testNullToBoolean() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setBoolVal(null);
        fieldMatchMap.put("boolVal","boolVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.getBoolVal());
    }

    @Override
    public void testBooleanToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setBoolVal(Boolean.TRUE);
        fieldMatchMap.put("boolVal","stringVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getStringVal(),"true");
    }

    @Override
    public void testStringToBoolean() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setStringVal("true");
        fieldMatchMap.put("stringVal","boolVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getBoolVal(),Boolean.TRUE);
    }

    @Override
    public void testUtilDateToUtilDate() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("dateUtil","dateUtil");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getDateUtil(),sourceClass.getDateUtil());
    }

    @Override
    public void testNullToUtilDate() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setDateUtil(null);
        fieldMatchMap.put("dateUtil","dateUtil");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.getDateUtil());
    }

    @Override
    public void testUtilDateToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("dateUtil","stringVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getStringVal(),sourceClass.getDateUtil().toString());
    }

    @Override
    public void testStringToUtilDate() throws ParseException, NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setStringVal("2021-01-01");
        fieldMatchMap.put("stringVal","dateUtil");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getDateUtil(), new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01"));
    }

    @Override
    public void testSqlDateToSqlDate() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
       fieldMatchMap.put("dateSql", "dateSql");
       genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
       Assert.assertEquals(destinationClass.getDateSql(),sourceClass.getDateSql());
    }

    @Override
    public void testNullToSqlDate() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setDateSql(null);
        fieldMatchMap.put("dateSql","dateSql");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.getDateSql());
    }

    @Override
    public void testSqlDateToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("dateSql","stringVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getStringVal(),sourceClass.getDateSql().toString());
    }

    @Override
    public void testStringToSqlDate() throws ParseException, NullClassException, NullClassFieldException, NullFieldMatchMapException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateAsString="2021-01-01";

        Date dateToBeParsed = simpleDateFormat.parse(dateAsString );
//        Timestamp timestampForSqlDate = new Timestamp(dateToBeParsed.getTime());
        java.sql.Date dateSql = new java.sql.Date(dateToBeParsed.getTime());

        sourceClass.setStringVal(dateAsString);
        fieldMatchMap.put("stringVal","dateSql");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getDateSql(),dateSql);
    }

    @Override
    public void testTimestampToTimestamp() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("timestamp","timestamp");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getTimestamp(),sourceClass.getTimestamp());
    }

    @Override
    public void testNullToTimestamp() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setTimestamp(null);
        fieldMatchMap.put("timestamp","timestamp");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.getTimestamp());
    }

    @Override
    public void testTimestampToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("timestamp","stringVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getStringVal(),sourceClass.getTimestamp().toString());
    }

    @Override
    public void testStringToTimestamp() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.setStringVal("11111");
        fieldMatchMap.put("stringVal","timestamp");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getTimestamp(), new Timestamp(11111));
    }

    @Override
    public void testNullFieldList() {
        fieldMatchMap=null;
        Assert.assertThrows(NullFieldMatchMapException.class,()->genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap));

    }

    @Override
    public void testNullDestinationClass() {
        destinationClass=null;
        Assert.assertThrows(NullClassException.class,()-> genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap)  );

    }

    @Override
    public void testNullSourceClass() {
        sourceClass=null;

        Assert.assertThrows(NullClassException.class,()-> genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap));
    }



    @Override
    public void testNotDeclaredFieldInSourceClass() {
      GenericClassParser<NullFieldSourceClass, DestinationClass>  genericClassParser
              = new GenericClassParser<>();


      Assert.assertThrows(NullClassFieldException.class,()->genericClassParser.parseClassToClass(nullFieldSourceClass,destinationClass,fieldMatchMap));

    }

    @Override
    public void testNotDeclaredFieldInDestinationClass() {
        GenericClassParser<SourceClass, NullFieldDestinationClass>  genericClassParser = new GenericClassParser<>();


        Assert.assertThrows(NullClassFieldException.class,()->genericClassParser.parseClassToClass(sourceClass,nullFieldDestinationClass,fieldMatchMap));

    }

    @Override
    public void testMultipleFieldMatchList() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("stringVal","stringVal");
        fieldMatchMap.put("integerValue","integerValue");
        fieldMatchMap.put("decimal","decimal");
        fieldMatchMap.put("floatVal","floatVal");
        fieldMatchMap.put("boolVal","boolVal");

        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);

        Assert.assertEquals(sourceClass.getStringVal(),destinationClass.getStringVal());
        Assert.assertEquals(sourceClass.getIntegerValue(),destinationClass.getIntegerValue());
        Assert.assertEquals(sourceClass.getDecimal(),destinationClass.getDecimal());
        Assert.assertEquals(sourceClass.getFloatVal(),destinationClass.getFloatVal());
        Assert.assertEquals(sourceClass.getBoolVal(),destinationClass.getBoolVal());
    }

    @Override
    public void testPrivateFieldSourceClassToPublicFieldDestinationClass() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        GenericClassParser<PrivateFieldSourceClass,DestinationClass> genericClassParser
                = new GenericClassParser<PrivateFieldSourceClass, DestinationClass>();
        fieldMatchMap.put("stringVal","stringVal");
        fieldMatchMap.put("integerValue","integerValue");
        fieldMatchMap.put("timestamp","timestamp");

        PrivateFieldSourceClass privateFieldSourceClass = new PrivateFieldSourceClass();

        genericClassParser.parseClassToClass(privateFieldSourceClass,destinationClass,fieldMatchMap);

        Assert.assertEquals(privateFieldSourceClass.getStringVal(),destinationClass.getStringVal());
        Assert.assertEquals(privateFieldSourceClass.getIntegerValue(),destinationClass.getIntegerValue());
        Assert.assertEquals(privateFieldSourceClass.getTimestamp(),destinationClass.getTimestamp());

    }

    @Override
    public void testPublicFieldSourceClassToPrivateFieldDestinationClass() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        GenericClassParser<SourceClass,PrivateFieldDestinationClass> genericClassParser
                = new GenericClassParser<SourceClass,PrivateFieldDestinationClass>();
        fieldMatchMap.put("stringVal","stringVal");
        fieldMatchMap.put("integerValue","integerValue");
        fieldMatchMap.put("timestamp","timestamp");

       PrivateFieldDestinationClass privateFieldDestinationClass=new PrivateFieldDestinationClass();

        genericClassParser.parseClassToClass(sourceClass,privateFieldDestinationClass,fieldMatchMap);

        Assert.assertEquals(sourceClass.getStringVal(),privateFieldDestinationClass.getStringVal());
        Assert.assertEquals(sourceClass.getIntegerValue(),privateFieldDestinationClass.getIntegerValue());
        Assert.assertEquals(sourceClass.getTimestamp(),privateFieldDestinationClass.getTimestamp());
    }

    @Override
    public void testPrivateFieldSourceClassToPrivateFieldDestinationClass() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        GenericClassParser<PrivateFieldSourceClass,PrivateFieldDestinationClass> genericClassParser
                = new GenericClassParser<PrivateFieldSourceClass,PrivateFieldDestinationClass>();

        fieldMatchMap.put("stringVal","stringVal");
        fieldMatchMap.put("integerValue","integerValue");
        fieldMatchMap.put("timestamp","timestamp");

        PrivateFieldSourceClass privateFieldSourceClass=new PrivateFieldSourceClass();
        PrivateFieldDestinationClass privateFieldDestinationClass = new PrivateFieldDestinationClass();

        genericClassParser.parseClassToClass(privateFieldSourceClass,privateFieldDestinationClass,fieldMatchMap);

        Assert.assertEquals(privateFieldSourceClass.getStringVal(),privateFieldDestinationClass.getStringVal() );
        Assert.assertEquals(privateFieldSourceClass.getIntegerValue(),privateFieldDestinationClass.getIntegerValue());
        Assert.assertEquals(privateFieldSourceClass.getTimestamp(),privateFieldDestinationClass.getTimestamp());

    }
}
