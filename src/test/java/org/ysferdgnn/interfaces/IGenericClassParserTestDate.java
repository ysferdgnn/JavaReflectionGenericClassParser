package org.ysferdgnn.interfaces;

import java.text.ParseException;

public interface IGenericClassParserTestDate {

    void initDestinationClass();
    void testNormal() throws ParseException;
    void testEmptyString() throws ParseException;
    void testStartWithSpaces() throws ParseException;
    void testEndWithSpaces() throws ParseException;
    void testMultipleSpaces() throws ParseException;

    void testStartWithYearDottedWithTime() throws ParseException;
    void testStartWithYearCommaWithTime() throws ParseException;
    void testStartWithYearSlashedWithTime() throws ParseException;
    void testStartWithYearHyphenWithTime() throws ParseException;
    void testStartWithDayDottedWithTime() throws ParseException;
    void testStartWithDayCommaWithTime() throws ParseException;
    void testStartWithDaySlashedWithTime() throws ParseException;
    void testStartWithDayHyphenWithTime() throws ParseException;

    void testStartWithYearDottedWithoutTime() throws ParseException;
    void testStartWithYearCommaWithoutTime() throws ParseException;
    void testStartWithYearSlashedWithoutTime() throws ParseException;
    void testStartWithYearHyphenWithoutTime() throws ParseException;
    void testStartWithDayDottedWithoutTime() throws ParseException;
    void testStartWithDayCommaWithoutTime() throws ParseException;
    void testStartWithDaySlashedWithoutTime() throws ParseException;
    void testStartWithDayHyphenWithoutTime() throws ParseException;


    void testReversedString() throws ParseException;

    void testStartWithDot() throws ParseException;
    void testEndWithDot() throws ParseException;
    void testStartWithDotAndEndWithDot() throws ParseException;

    void testStartWithComma() throws ParseException;
    void testEndWithComma() throws ParseException;
    void testStartWithCommaAndEndWithComma() throws ParseException;

    void testStartWithYearHypenWithTimeWithoutSecs() throws  ParseException;
    void testStartWithYearDotWithTimeWithoutSecs() throws  ParseException;
    void testStartWithYearSlashWithTimeWithoutSecs() throws  ParseException;

    void testStartWithDayHypenWithTimeWithoutSecs() throws  ParseException;
    void testStartWithDaySlashWithTimeWithoutSecs() throws  ParseException;
    void testStartWithDayDotWithTimeWithoutSecs() throws  ParseException;
    void testExcelDatetime() throws ParseException;
    void testNull();





}
