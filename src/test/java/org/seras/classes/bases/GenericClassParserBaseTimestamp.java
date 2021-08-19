package org.seras.classes.bases;

import org.junit.Before;
import org.junit.Test;
import org.seras.Classes.DestinationClass;
import org.seras.GenericClassParser;
import org.seras.interfaces.IGenericClassParserTestTimestamp;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class GenericClassParserBaseTimestamp implements IGenericClassParserTestTimestamp {

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
    public void testLongNumber() {

    }

    @Test
    @Override
    public void testLongNumberWithDot() throws ParseException {

    }

    @Test
    @Override
    public void testLongNumberWithComma() throws ParseException {

    }

    @Test
    @Override
    public void testNormalDateStartYearWithTimeSlashFormat() throws ParseException {

    }

    @Test
    @Override
    public void testNormalDateStartYearWithTimeDotFormat() throws ParseException {

    }

    @Test
    @Override
    public void testNormalDateStartYearWithTimeCommaFormat() throws ParseException {

    }

    @Test
    @Override
    public void testNormalDateStartDayWithTimeSlashFormat() throws ParseException {

    }

    @Test
    @Override
    public void testNormalDateStartDayWithTimeDotFormat() throws ParseException {

    }

    @Test
    @Override
    public void testNormalDAteStartDayWithTimeCommaFormat() throws ParseException {

    }

    @Test
    @Override
    public void testNormalDateStartYearWithoutTimeSlashFormat() throws ParseException {

    }

    @Test
    @Override
    public void testNormalDateStartYearWithoutTimeDotFormat() throws ParseException {

    }

    @Test
    @Override
    public void testNormalDateStartYearWithoutTimeCommaFormat() throws ParseException {

    }

    @Test
    @Override
    public void testNormalDateStartDayWithoutTimeSlashFormat() throws ParseException {

    }

    @Test
    @Override
    public void testNormalDateStartDayWithoutTimeDotFormat() throws ParseException {

    }

    @Test
    @Override
    public void testNormalDateStartDayWithoutTimeCommaFormat() throws ParseException {

    }

    @Test
    @Override
    public void testExcelDateWithDot() throws ParseException {

    }

    @Test
    @Override
    public void testExcelDateWithComma() throws ParseException {

    }

    @Test
    @Override
    public void testEmptyString() {

    }

    @Test
    @Override
    public void testFullAlphaNumeric() {

    }

    @Test
    @Override
    public void testMultipleDots() {

    }

    @Test
    @Override
    public void testMultipleCommas() {

    }

    @Test
    @Override
    public void testSpecialChars() {

    }

    @Test
    @Override
    public void testNullInput() {

    }

    @Test
    @Override
    public void testStartWithSpaces() {

    }

    @Test
    @Override
    public void testEndWithSpaces() {

    }

    @Test
    @Override
    public void testIncludeMultipleSpaces() {

    }
}
