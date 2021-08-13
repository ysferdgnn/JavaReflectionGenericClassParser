package org.seras.interfaces;

import java.text.ParseException;

public interface IGenericClassParserTestDate {

    void initDestinationClass();
    void testNormal() throws ParseException;
    void testEmptyString();
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


    void testReversedString();

    void testStartWithDot();
    void testEndWithDot();
    void testStartWithDotAndEndWithDot();

    void testStartWithComma();
    void testEndWithComma();
    void testStartWithCommaAndEndWithComma();





}
