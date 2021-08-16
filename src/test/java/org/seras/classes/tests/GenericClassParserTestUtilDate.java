package org.seras.classes.tests;

import org.junit.Assert;
import org.seras.classes.bases.GenericClassParserBaseDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenericClassParserTestUtilDate extends GenericClassParserBaseDate {
    @Override
    public void initDestinationClass() {
        super.initDestinationClass();
    }



    @Override
    public void testNormal() throws ParseException {
        String dateAsString ="2021-01-01 13:06:06";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(dateAsString);
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testEmptyString() {
        String dateAsString ="";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        Assert.assertNull(destinationClass.dateUtil);
    }

    @Override
    public void testStartWithSpaces() throws ParseException {
        String dateAsString ="     2021-01-01 13:06:06";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(dateAsString);
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testEndWithSpaces() throws ParseException {
        String dateAsString ="2021-01-01 13:06:06      ";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(dateAsString);
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testMultipleSpaces() throws ParseException {
        String dateAsString ="    2 0 2 1- 01-      01 1 3 :0 6 :0 6      ";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("2021-01-01 13:06:06");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testStartWithYearDottedWithTime() throws ParseException {
        String dateAsString ="2021.08.13 17:10:10";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date date = sdf.parse("2021.08.13 17:10:10");
        Assert.assertEquals(destinationClass.dateUtil,date);

    }

    @Override
    public void testStartWithYearCommaWithTime() throws ParseException {
        String dateAsString ="2021,08,13 17:10:10";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date date = sdf.parse("2021.08.13 17:10:10");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testStartWithYearSlashedWithTime() throws ParseException {
        String dateAsString ="2021/08/13 17:10:10";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = sdf.parse("2021/08/13 17:10:10");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testStartWithYearHyphenWithTime() throws ParseException {
        String dateAsString ="2021-08-13 17:10:10";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("2021-08-13 17:10:10");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testStartWithDayDottedWithTime() throws ParseException {
        String dateAsString ="13-08-2021 17:10:10";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = sdf.parse("13-08-2021 17:10:10");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testStartWithDayCommaWithTime() throws ParseException {
        String dateAsString ="13,08,2021 17:10:10";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date date = sdf.parse("13.08.2021 17:10:10");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testStartWithDaySlashedWithTime() throws ParseException {
        String dateAsString ="13/08/2021 17:10:10";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = sdf.parse("13/08/2021 17:10:10");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testStartWithDayHyphenWithTime() throws ParseException {
        String dateAsString ="13-08-2021 17:10:10";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = sdf.parse("13-08-2021 17:10:10");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testStartWithYearDottedWithoutTime() throws ParseException {
        String dateAsString ="2021-08-13";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2021-08-13");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testStartWithYearCommaWithoutTime() throws ParseException {
        String dateAsString ="2021,08,13";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        Date date = sdf.parse("2021.08.13");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testStartWithYearSlashedWithoutTime() throws ParseException {
        String dateAsString ="2021/08/13";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = sdf.parse("2021/08/13");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testStartWithYearHyphenWithoutTime() throws ParseException {
        String dateAsString ="2021-08-13";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2021-08-13");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testStartWithDayDottedWithoutTime() throws ParseException {
        String dateAsString ="13.08.2021";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date date = sdf.parse("13.08.2021");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testStartWithDayCommaWithoutTime() throws ParseException {
        String dateAsString ="13,08,2021";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date date = sdf.parse("13.08.2021");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testStartWithDaySlashedWithoutTime() throws ParseException {
        String dateAsString ="13/08/2021";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse("13/08/2021");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testStartWithDayHyphenWithoutTime() throws ParseException {
        String dateAsString ="13-08-2021";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse("13-08-2021");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testStartWithDot() throws ParseException {
        String dateAsString ="..13-08-2021";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse("13-08-2021");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testEndWithDot() throws ParseException {
        String dateAsString ="13-08-2021....";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse("13-08-2021");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testStartWithDotAndEndWithDot() throws ParseException {
        String dateAsString ="....13-08-2021....";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse("13-08-2021");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testStartWithComma() throws ParseException {
        String dateAsString =",,13-08-2021";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse("13-08-2021");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testEndWithComma() throws ParseException {
        String dateAsString ="13-08-2021,,,";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse("13-08-2021");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testStartWithCommaAndEndWithComma() throws ParseException {
        String dateAsString =",,,,,13-08-2021,,,";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse("13-08-2021");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }

    @Override
    public void testReversedString() throws ParseException {


        String dateAsString ="Fri Aug 13 00:00:00 EET 2021";
        this.valuesMap.put("date",dateAsString);
        this.fieldMatchMap.put("date","dateUtil");
        this.genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse("13-08-2021");
        Assert.assertEquals(destinationClass.dateUtil,date);
    }
}
