package org.seras.classes.tests;

import org.junit.Assert;
import org.seras.Classes.Exceptions.NullClassException;
import org.seras.Classes.Exceptions.NullClassFieldException;
import org.seras.Classes.Exceptions.NullFieldMatchMapException;
import org.seras.Classes.Pojos.DestinationClass;
import org.seras.Classes.Pojos.NullFieldDestinationClass;
import org.seras.Classes.Pojos.NullFieldSourceClass;
import org.seras.Classes.Pojos.SourceClass;
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
        Assert.assertEquals(destinationClass.stringVal, sourceClass.stringVal);

    }

    @Override
    public void testNullToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.stringVal=null;
        this.fieldMatchMap.put("stringVal", "stringVal");
        genericClassParser.parseClassToClass(this.sourceClass,this.destinationClass,this.fieldMatchMap);
        Assert.assertNull(destinationClass.stringVal);
    }

    @Override
    public void testIntegerToInteger() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {

        this.fieldMatchMap.put("integerValue", "integerValue");
        genericClassParser.parseClassToClass(this.sourceClass,this.destinationClass,this.fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, sourceClass.integerValue);
    }

    @Override
    public void testNullToInteger() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.integerValue=null;
        this.fieldMatchMap.put("integerValue", "integerValue");
        genericClassParser.parseClassToClass(this.sourceClass,this.destinationClass,this.fieldMatchMap);
        Assert.assertNull(destinationClass.integerValue);
    }

    @Override
    public void testIntegerToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {

        this.fieldMatchMap.put("integerValue", "stringVal");
        genericClassParser.parseClassToClass(this.sourceClass,this.destinationClass,this.fieldMatchMap);
        Assert.assertEquals(destinationClass.stringVal,sourceClass.integerValue.toString());
    }

    @Override
    public void testStringToInteger() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
       sourceClass.stringVal="50";
       fieldMatchMap.put("stringVal", "integerValue");
       genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
       Assert.assertEquals(destinationClass.integerValue, new Integer(50));
    }

    @Override
    public void testBigDecimalToBigDecimal() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
       fieldMatchMap.put("decimal","decimal");
       genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
       Assert.assertEquals(sourceClass.decimal,destinationClass.decimal);
    }

    @Override
    public void testNullToBigDecimal() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.decimal=null;
        fieldMatchMap.put("decimal","decimal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.decimal);
    }

    @Override
    public void testBigDecimalToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("decimal","stringVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.stringVal,sourceClass.decimal.toString());
    }

    @Override
    public void testStringToBigDecimal() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.stringVal="50";
        fieldMatchMap.put("stringVal","decimal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.decimal,new BigDecimal("50"));
    }

    @Override
    public void testLongToLong() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("longVal","longVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.longVal,sourceClass.longVal);
    }

    @Override
    public void testNullToLong() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.longVal=null;
        fieldMatchMap.put("longVal","longVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.longVal);
    }

    @Override
    public void testLongToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("longVal","stringVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.stringVal,sourceClass.longVal.toString());
    }

    @Override
    public void testStringToLong() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.stringVal="50";
        fieldMatchMap.put("stringVal","longVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.longVal, new Long(50L));
    }

    @Override
    public void testFloatToFloat() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("floatVal","floatVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,sourceClass.floatVal);
    }

    @Override
    public void testNullToFloat() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
       sourceClass.floatVal=null;
       fieldMatchMap.put("floatVal","floatVal");
       genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
       Assert.assertNull(destinationClass.floatVal);
    }

    @Override
    public void testFloatToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.floatVal=60f;
        fieldMatchMap.put("floatVal","stringVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.stringVal,"60.0");
    }

    @Override
    public void testStringToFloat() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.stringVal="10";
        fieldMatchMap.put("stringVal","floatVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,new Float(10f));
    }

    @Override
    public void testByteToByte() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("byteVal","byteVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.byteVal,sourceClass.byteVal);
    }

    @Override
    public void testNullToByte() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.byteVal=null;
        fieldMatchMap.put("byteVal","byteVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.byteVal);
    }

    @Override
    public void testByteToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("byteVal","stringVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.stringVal,sourceClass.byteVal.toString());
    }

    @Override
    public void testStringToByte() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.stringVal="10";
        fieldMatchMap.put("stringVal","byteVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.byteVal,new Byte("10"));
    }

    @Override
    public void testDoubleToDouble() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("doubleVal","doubleVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.doubleVal,sourceClass.doubleVal);
    }

    @Override
    public void testNullToDouble() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.doubleVal=null;
        fieldMatchMap.put("doubleVal","doubleVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.doubleVal);
    }

    @Override
    public void testDoubleToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("doubleVal","stringVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.stringVal,sourceClass.doubleVal.toString());
    }

    @Override
    public void testStringToDouble() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.stringVal="50";
        fieldMatchMap.put("stringVal","doubleVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.doubleVal,new Double("50"));
    }

    @Override
    public void testCharacterToCharacter() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("charVal","charVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.charVal,sourceClass.charVal);
    }

    @Override
    public void testNullToCharacter() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.charVal=null;
        fieldMatchMap.put("charVal","charVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.charVal);
    }

    @Override
    public void testCharacterToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
       fieldMatchMap.put("charVal","stringVal");
       genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
       Assert.assertEquals(destinationClass.stringVal,sourceClass.charVal.toString());
    }

    @Override
    public void testStringToCharacter() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.stringVal="C";
        fieldMatchMap.put("stringVal","charVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.charVal,new Character('C'));
    }

    @Override
    public void testBooleanToBoolean() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("boolVal","boolVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.boolVal,sourceClass.boolVal);
    }

    @Override
    public void testNullToBoolean() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.boolVal=null;
        fieldMatchMap.put("boolVal","boolVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.boolVal);
    }

    @Override
    public void testBooleanToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.boolVal=Boolean.TRUE;
        fieldMatchMap.put("boolVal","stringVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.stringVal,"true");
    }

    @Override
    public void testStringToBoolean() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.stringVal="true";
        fieldMatchMap.put("stringVal","boolVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.boolVal,Boolean.TRUE);
    }

    @Override
    public void testUtilDateToUtilDate() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("dateUtil","dateUtil");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.dateUtil,sourceClass.dateUtil);
    }

    @Override
    public void testNullToUtilDate() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.dateUtil=null;
        fieldMatchMap.put("dateUtil","dateUtil");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.dateUtil);
    }

    @Override
    public void testUtilDateToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("dateUtil","stringVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.stringVal,sourceClass.dateUtil.toString());
    }

    @Override
    public void testStringToUtilDate() throws ParseException, NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.stringVal="2021-01-01";
        fieldMatchMap.put("stringVal","dateUtil");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.dateUtil, new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01"));
    }

    @Override
    public void testSqlDateToSqlDate() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
       fieldMatchMap.put("dateSql", "dateSql");
       genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
       Assert.assertEquals(destinationClass.dateSql,sourceClass.dateSql);
    }

    @Override
    public void testNullToSqlDate() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.dateSql=null;
        fieldMatchMap.put("dateSql","dateSql");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.dateSql);
    }

    @Override
    public void testSqlDateToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("dateSql","stringVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.stringVal,sourceClass.dateSql.toString());
    }

    @Override
    public void testStringToSqlDate() throws ParseException, NullClassException, NullClassFieldException, NullFieldMatchMapException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateAsString="2021-01-01";

        Date dateToBeParsed = simpleDateFormat.parse(dateAsString );
//        Timestamp timestampForSqlDate = new Timestamp(dateToBeParsed.getTime());
        java.sql.Date dateSql = new java.sql.Date(dateToBeParsed.getTime());

        sourceClass.stringVal=dateAsString;
        fieldMatchMap.put("stringVal","dateSql");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.dateSql,dateSql);
    }

    @Override
    public void testTimestampToTimestamp() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("timestamp","timestamp");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.timestamp,sourceClass.timestamp);
    }

    @Override
    public void testNullToTimestamp() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.timestamp=null;
        fieldMatchMap.put("timestamp","timestamp");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.timestamp);
    }

    @Override
    public void testTimestampToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        fieldMatchMap.put("timestamp","stringVal");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.stringVal,sourceClass.timestamp.toString());
    }

    @Override
    public void testStringToTimestamp() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {
        sourceClass.stringVal= "11111";
        fieldMatchMap.put("stringVal","timestamp");
        genericClassParser.parseClassToClass(sourceClass,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.timestamp, new Timestamp(11111));
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
              = new GenericClassParser<NullFieldSourceClass, DestinationClass>();


      Assert.assertThrows(NullClassFieldException.class,()->genericClassParser.parseClassToClass(nullFieldSourceClass,destinationClass,fieldMatchMap));

    }

    @Override
    public void testNotDeclaredFieldInDestinationClass() {
        GenericClassParser<SourceClass, NullFieldDestinationClass>  genericClassParser = new GenericClassParser<SourceClass, NullFieldDestinationClass>();


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

        Assert.assertEquals(sourceClass.stringVal,destinationClass.stringVal);
        Assert.assertEquals(sourceClass.integerValue,destinationClass.integerValue);
        Assert.assertEquals(sourceClass.decimal,destinationClass.decimal);
        Assert.assertEquals(sourceClass.floatVal,destinationClass.floatVal);
        Assert.assertEquals(sourceClass.boolVal,destinationClass.boolVal);


    }
}
