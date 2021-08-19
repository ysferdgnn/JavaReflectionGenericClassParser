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
    public void testEmptyString() throws ParseException {

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

    @Test
    @Override
    public void testReversedString() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithDot() throws ParseException {

    }

    @Test
    @Override
    public void testEndWithDot() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithDotAndEndWithDot() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithComma() throws ParseException {

    }

    @Test
    @Override
    public void testEndWithComma() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithCommaAndEndWithComma() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithYearHypenWithTimeWithoutSecs() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithYearDotWithTimeWithoutSecs() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithYearSlashWithTimeWithoutSecs() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithDayHypenWithTimeWithoutSecs() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithDaySlashWithTimeWithoutSecs() throws ParseException {

    }

    @Test
    @Override
    public void testStartWithDayDotWithTimeWithoutSecs() throws ParseException {

    }

    @Test
    @Override
    public void testExcelDatetime() throws ParseException {

    }
}
