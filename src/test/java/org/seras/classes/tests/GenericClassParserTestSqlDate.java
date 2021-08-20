package org.seras.classes.tests;

import org.junit.Assert;
import org.seras.classes.bases.GenericClassParserBaseDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenericClassParserTestSqlDate extends GenericClassParserBaseDate {
    @Override
    public void initDestinationClass() {
        super.initDestinationClass();
    }

    @Override
    public void testNormal() throws ParseException {
        String dateAsString ="2021-01-01";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateUtil = sdf.parse(dateAsString);
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testEmptyString() throws ParseException {
        String dateAsString ="";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        Assert.assertNull(destinationClass.dateSql);
    }

    @Override
    public void testStartWithSpaces() throws ParseException {
        String dateAsString ="      2021-01-01";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateUtil = sdf.parse(dateAsString);
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testEndWithSpaces() throws ParseException {
        String dateAsString ="2021-01-01 ";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        Date dateUtil = sdf.parse(dateAsString);
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testMultipleSpaces() throws ParseException {
        String dateAsString ="20 2 1- 01-01 13 :0 6:0 6";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateUtil = sdf.parse("2021-01-01 13:06:06");
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithYearDottedWithTime() throws ParseException {
        String dateAsString ="2021.01.01 13:06:06";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date dateUtil = sdf.parse(dateAsString);
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithYearCommaWithTime() throws ParseException {
        String dateAsString ="2021,01,01 13:06:06";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd HH:mm:ss");
        Date dateUtil = sdf.parse(dateAsString);
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithYearSlashedWithTime() throws ParseException {
        String dateAsString ="2021/01/01 13:06:06";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date dateUtil = sdf.parse(dateAsString);
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithYearHyphenWithTime() throws ParseException {
        String dateAsString ="2021-01-01 13:06:06";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateUtil = sdf.parse(dateAsString);
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithDayDottedWithTime() throws ParseException {
        String dateAsString ="2021.01.01 13:06:06";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date dateUtil = sdf.parse(dateAsString);
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithDayCommaWithTime() throws ParseException {
        String dateAsString ="01,01,2021 13:00:00";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd,MM,yyyy HH:mm:ss");
        Date dateUtil = sdf.parse(dateAsString);
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithDaySlashedWithTime() throws ParseException {
        String dateAsString ="01/01/2021 13:00:00";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dateUtil = sdf.parse(dateAsString);
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithDayHyphenWithTime() throws ParseException {
        String dateAsString ="01-01-2021 13:00:00";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date dateUtil = sdf.parse(dateAsString);
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithYearDottedWithoutTime() throws ParseException {
        String dateAsString ="2021.01.01";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        Date dateUtil = sdf.parse(dateAsString);
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithYearCommaWithoutTime() throws ParseException {
        String dateAsString ="2021,01,01";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd");
        Date dateUtil = sdf.parse(dateAsString);
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithYearSlashedWithoutTime() throws ParseException {
        String dateAsString ="2021/01/01";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date dateUtil = sdf.parse(dateAsString);
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithYearHyphenWithoutTime() throws ParseException {
        String dateAsString ="2021-01-01";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateUtil = sdf.parse(dateAsString);
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithDayDottedWithoutTime() throws ParseException {
        String dateAsString ="01.01.2021";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date dateUtil = sdf.parse(dateAsString);
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithDayCommaWithoutTime() throws ParseException {
        String dateAsString ="01,01,2021";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd,MM,yyyy");
        Date dateUtil = sdf.parse(dateAsString);
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithDaySlashedWithoutTime() throws ParseException {
        String dateAsString ="01/01/2021";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dateUtil = sdf.parse(dateAsString);
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithDayHyphenWithoutTime() throws ParseException {
        String dateAsString ="01-01-2021";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dateUtil = sdf.parse(dateAsString);
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testReversedString() throws ParseException {
        String dateAsString ="Fri Aug 13 00:00:00 EET 2021";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse("13-08-2021");
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Assert.assertEquals(destinationClass.dateSql,sqlDate);
    }

    @Override
    public void testStartWithDot() throws ParseException {
        String dateAsString =".....01-01-2021";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dateUtil = sdf.parse("01-01-2021");
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testEndWithDot() throws ParseException {
        String dateAsString ="01-01-2021....";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dateUtil = sdf.parse("01-01-2021");
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithDotAndEndWithDot() throws ParseException {
        String dateAsString ="......01-01-2021....";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dateUtil = sdf.parse("01-01-2021");
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithComma() throws ParseException {
        String dateAsString =",,,,01-01-2021";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dateUtil = sdf.parse("01-01-2021");
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testEndWithComma() throws ParseException {
        String dateAsString ="01-01-2021,,,,,";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dateUtil = sdf.parse("01-01-2021");
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithCommaAndEndWithComma() throws ParseException {
        String dateAsString =",,,,01-01-2021,,,,,,,";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dateUtil = sdf.parse("01-01-2021");
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithYearHypenWithTimeWithoutSecs() throws ParseException {
        String dateAsString ="2021-01-01 15:00";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date dateUtil = sdf.parse("2021-01-01 15:00");
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithYearDotWithTimeWithoutSecs() throws ParseException {
        String dateAsString ="2021.01.01 15:00";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        Date dateUtil = sdf.parse("2021.01.01 15:00");
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());


        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithYearSlashWithTimeWithoutSecs() throws ParseException {
        String dateAsString ="2021/01/01 15:00";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date dateUtil = sdf.parse("2021/01/01 15:00");
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());

        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithDayHypenWithTimeWithoutSecs() throws ParseException {
        String dateAsString ="17-08-2021 15:00";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date dateUtil = sdf.parse("17-08-2021 15:00");
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());

        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithDaySlashWithTimeWithoutSecs() throws ParseException {
        String dateAsString ="17/08/2021 15:00";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date dateUtil = sdf.parse("17/08/2021 15:00");
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());

        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testStartWithDayDotWithTimeWithoutSecs() throws ParseException {
        String dateAsString ="17.08.2021 15:00";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateSql");

        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date dateUtil = sdf.parse("17.08.2021 15:00");
        java.sql.Date date= new java.sql.Date(dateUtil.getTime());

        Assert.assertEquals(destinationClass.dateSql,date);
    }

    @Override
    public void testExcelDatetime() throws ParseException {
        valuesMap.put("date", "43706,4856597222");
        fieldMatchMap.put("date","dateSql" );
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.dateSql);
    }

    @Override
    public void testNull() {
        valuesMap.put("date",null);
        fieldMatchMap.put("date","dateSql");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.dateSql);
    }
}
