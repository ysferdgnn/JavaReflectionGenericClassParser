package org.seras.classes.tests;

import org.junit.Assert;
import org.seras.classes.bases.GenericClassParserBaseTimestamp;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenericClassParserTestTimestamp extends GenericClassParserBaseTimestamp {
    @Override
    public void initDestinationClass() {
        super.initDestinationClass();
    }

    @Override
    public void testLongNumber() {
        valuesMap.put("tmp", "1454444");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        Timestamp timestamp=new Timestamp(1454444);
        Assert.assertEquals(timestamp,destinationClass.timestamp);

    }

    @Override
    public void testLongNumberWithDot() throws ParseException {
        valuesMap.put("tmp", "43706.4856597222");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        //2019-08-29 11:39:21.0

        String dateAsString ="2019-08-29 11:39:21";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(dateAsString);
        Timestamp timestamp = new Timestamp(date.getTime());

        Assert.assertEquals(timestamp,destinationClass.timestamp);
    }

    @Override
    public void testLongNumberWithComma() throws ParseException {
        valuesMap.put("tmp", "43706,4856597222");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        //2019-08-29 11:39:21.0

        String dateAsString ="2019-08-29 11:39:21";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(dateAsString);
        Timestamp timestamp = new Timestamp(date.getTime());

        Assert.assertEquals(timestamp,destinationClass.timestamp);
    }



    @Override
    public void testNormalDateStartYearWithTimeSlashFormat() throws ParseException {
        valuesMap.put("tmp", "2021/01/01 15:00:00");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        //2021-01-01 15:00:00

        String dateAsString ="2021/01/01 15:00:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = simpleDateFormat.parse(dateAsString);
        Timestamp timestamp = new Timestamp(date.getTime());

        Assert.assertEquals(timestamp,destinationClass.timestamp);
    }

    @Override
    public void testNormalDateStartYearWithTimeDotFormat() throws ParseException {
        valuesMap.put("tmp", "2021.01.01 15:00:00");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        //2021-01-01 15:00:00

        String dateAsString ="2021.01.01 15:00:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date date = simpleDateFormat.parse(dateAsString);
        Timestamp timestamp = new Timestamp(date.getTime());

        Assert.assertEquals(timestamp,destinationClass.timestamp);
    }

    @Override
    public void testNormalDateStartYearWithTimeCommaFormat() throws ParseException {
        valuesMap.put("tmp", "2021,01,01 15:00:00");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        //2021-01-01 15:00:00

        String dateAsString ="2021,01,01 15:00:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy,MM,dd HH:mm:ss");
        Date date = simpleDateFormat.parse(dateAsString);
        Timestamp timestamp = new Timestamp(date.getTime());

        Assert.assertEquals(timestamp,destinationClass.timestamp);
    }

    @Override
    public void testNormalDateStartDayWithTimeSlashFormat() throws ParseException {
        valuesMap.put("tmp", "01/01/2021 15:00:00");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        //2021-01-01 15:00:00

        String dateAsString ="2021/01/01 15:00:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = simpleDateFormat.parse(dateAsString);
        Timestamp timestamp = new Timestamp(date.getTime());

        Assert.assertEquals(timestamp,destinationClass.timestamp);
    }

    @Override
    public void testNormalDateStartDayWithTimeDotFormat() throws ParseException {
        valuesMap.put("tmp", "01.01.2021 15:00:00");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        //2021-01-01 15:00:00

        String dateAsString ="2021.01.01 15:00:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date date = simpleDateFormat.parse(dateAsString);
        Timestamp timestamp = new Timestamp(date.getTime());

        Assert.assertEquals(timestamp,destinationClass.timestamp);
    }

    @Override
    public void testNormalDAteStartDayWithTimeCommaFormat() throws ParseException {
        valuesMap.put("tmp", "01,01,2021 15:00:00");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        //2021-01-01 15:00:00

        String dateAsString ="2021,01,01 15:00:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy,MM,dd HH:mm:ss");
        Date date = simpleDateFormat.parse(dateAsString);
        Timestamp timestamp = new Timestamp(date.getTime());

        Assert.assertEquals(timestamp,destinationClass.timestamp);
    }

    @Override
    public void testNormalDateStartYearWithoutTimeSlashFormat() throws ParseException {
        valuesMap.put("tmp", "2021/01/01");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        //2021-01-01 15:00:00

        String dateAsString ="2021/01/01";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = simpleDateFormat.parse(dateAsString);
        Timestamp timestamp = new Timestamp(date.getTime());

        Assert.assertEquals(timestamp,destinationClass.timestamp);
    }

    @Override
    public void testNormalDateStartYearWithoutTimeDotFormat() throws ParseException {
        valuesMap.put("tmp", "2021.01.01");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        //2021-01-01 15:00:00

        String dateAsString ="2021.01.01";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Date date = simpleDateFormat.parse(dateAsString);
        Timestamp timestamp = new Timestamp(date.getTime());

        Assert.assertEquals(timestamp,destinationClass.timestamp);
    }

    @Override
    public void testNormalDateStartYearWithoutTimeCommaFormat() throws ParseException {
        valuesMap.put("tmp", "2021,01,01");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        //2021-01-01 15:00:00

        String dateAsString ="2021,01,01";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy,MM,dd");
        Date date = simpleDateFormat.parse(dateAsString);
        Timestamp timestamp = new Timestamp(date.getTime());

        Assert.assertEquals(timestamp,destinationClass.timestamp);
    }

    @Override
    public void testNormalDateStartDayWithoutTimeSlashFormat() throws ParseException {
        valuesMap.put("tmp", "01/01/2021");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        //2021-01-01 15:00:00

        String dateAsString ="01/01/2021";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = simpleDateFormat.parse(dateAsString);
        Timestamp timestamp = new Timestamp(date.getTime());

        Assert.assertEquals(timestamp,destinationClass.timestamp);
    }

    @Override
    public void testNormalDateStartDayWithoutTimeDotFormat() throws ParseException {
        valuesMap.put("tmp", "01.01.2021");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        //2021-01-01 15:00:00

        String dateAsString ="01.01.2021";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = simpleDateFormat.parse(dateAsString);
        Timestamp timestamp = new Timestamp(date.getTime());

        Assert.assertEquals(timestamp,destinationClass.timestamp);
    }

    @Override
    public void testNormalDateStartDayWithoutTimeCommaFormat() throws ParseException {
        valuesMap.put("tmp", "01,01,2021");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        //2021-01-01 15:00:00

        String dateAsString ="01,01,2021";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd,MM,yyyy");
        Date date = simpleDateFormat.parse(dateAsString);
        Timestamp timestamp = new Timestamp(date.getTime());

        Assert.assertEquals(timestamp,destinationClass.timestamp);
    }

    @Override
    public void testExcelDateWithDot() throws ParseException {
        valuesMap.put("tmp", "43706.4856597222");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        //2019-08-29 11:39:21.0

        String dateAsString ="2019-08-29 11:39:21";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(dateAsString);
        Timestamp timestamp = new Timestamp(date.getTime());

        Assert.assertEquals(timestamp,destinationClass.timestamp);
    }

    @Override
    public void testExcelDateWithComma() throws ParseException {
        valuesMap.put("tmp", "43706,4856597222");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        //2019-08-29 11:39:21.0

        String dateAsString ="2019-08-29 11:39:21";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(dateAsString);
        Timestamp timestamp = new Timestamp(date.getTime());

        Assert.assertEquals(timestamp,destinationClass.timestamp);
    }

    @Override
    public void testEmptyString()  {
        valuesMap.put("tmp", "");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        Assert.assertNull(destinationClass.timestamp);

    }

    @Override
    public void testFullAlphaNumeric() {
        valuesMap.put("tmp", "SARUMAN!");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        Assert.assertNull(destinationClass.timestamp);
    }

    @Override
    public void testMultipleDots() {
        valuesMap.put("tmp", "123.453.213123.3434.");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        Assert.assertNull(destinationClass.timestamp);
    }

    @Override
    public void testMultipleCommas() {
        valuesMap.put("tmp", "123,123,1");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        Assert.assertNull(destinationClass.timestamp);
    }

    @Override
    public void testSpecialChars() {
        valuesMap.put("tmp", "!&?._-123.");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        Assert.assertNull(destinationClass.timestamp);
    }

    @Override
    public void testNullInput() {
        valuesMap.put("tmp", "");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        Assert.assertNull(destinationClass.timestamp);
    }

    @Override
    public void testStartWithSpaces() {
        valuesMap.put("tmp", "   1454444");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        Timestamp timestamp=new Timestamp(1454444);
        Assert.assertEquals(timestamp,destinationClass.timestamp);
    }

    @Override
    public void testEndWithSpaces() {
        valuesMap.put("tmp", "1454444     ");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        Timestamp timestamp=new Timestamp(1454444);
        Assert.assertEquals(timestamp,destinationClass.timestamp);
    }

    @Override
    public void testIncludeMultipleSpaces() {
        valuesMap.put("tmp", "1 4 54 4 4 4 ");
        fieldMatchMap.put("tmp","timestamp" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);

        Timestamp timestamp=new Timestamp(1454444);
        Assert.assertEquals(timestamp,destinationClass.timestamp);
    }
}
