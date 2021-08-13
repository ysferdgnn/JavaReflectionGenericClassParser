package org.seras.classes.bases;

import org.junit.Before;
import org.junit.Test;
import org.seras.Classes.DestinationClass;
import org.seras.GenericClassParser;
import org.seras.interfaces.IGenericClassParserTestDate;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class GenericClassParserBaseDate implements IGenericClassParserTestDate {


    public GenericClassParser<Map<String, String>, DestinationClass> genericClassParser = null;
    public DestinationClass destinationClass = null;
    public Map<String, String> valuesMap = null;
    public Map<String, String> fieldMatchMap = null;

    @Before
    @Override
    public void initDestinationClass() {
        destinationClass = new DestinationClass();
        valuesMap = new HashMap<>();
        fieldMatchMap = new HashMap<>();


        genericClassParser = new GenericClassParser<>();
    }

    @Test
    @Override
    public void testNormal() throws ParseException {

    }

    @Test
    @Override
    public void testEmptyString() {

    }

    @Test
    @Override
    public void testStartWithSpaces() throws ParseException {

    }

    @Test
    @Override
    public void testEndWithSpaces() throws ParseException {

    }

    @Test
    @Override
    public void testMultipleSpaces() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithYearDottedWithTime() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithYearCommaWithTime() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithYearSlashedWithTime() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithYearHyphenWithTime() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithDayDottedWithTime() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithDayCommaWithTime() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithDaySlashedWithTime() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithDayHyphenWithTime() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithYearDottedWithoutTime() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithYearCommaWithoutTime() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithYearSlashedWithoutTime() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithYearHyphenWithoutTime() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithDayDottedWithoutTime() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithDayCommaWithoutTime() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithDaySlashedWithoutTime() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithDayHyphenWithoutTime() throws ParseException {

    }

    @Override
    public void testReversedString() {

    }

    @Test
    @Override
    public void testStartWithDot() {

    }

    @Test
    @Override
    public void testEndWithDot() {

    }

    @Test
    @Override
    public void testStartWithDotAndEndWithDot() {

    }

    @Test
    @Override
    public void testStartWithComma() {

    }

    @Test
    @Override
    public void testEndWithComma() {

    }

    @Test
    @Override
    public void testStartWithCommaAndEndWithComma() {

    }
}
