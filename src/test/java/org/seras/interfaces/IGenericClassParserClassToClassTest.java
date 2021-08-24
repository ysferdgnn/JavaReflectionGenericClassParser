package org.seras.interfaces;

import org.seras.Classes.Exceptions.NullClassException;
import org.seras.Classes.Exceptions.NullClassFieldException;
import org.seras.Classes.Exceptions.NullFieldMatchMapException;

import java.text.ParseException;

@SuppressWarnings("unused")
public interface IGenericClassParserClassToClassTest {


    void initDestinationClass();
    void testStringToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testNullToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;

    void testIntegerToInteger() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testNullToInteger() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testIntegerToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testStringToInteger() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;

    void testBigDecimalToBigDecimal() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testNullToBigDecimal() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testBigDecimalToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testStringToBigDecimal() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;

    void testLongToLong() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testNullToLong() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testLongToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testStringToLong() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;

    void testFloatToFloat() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testNullToFloat() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testFloatToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testStringToFloat() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;

    void testByteToByte() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testNullToByte() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testByteToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testStringToByte() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;

    void testDoubleToDouble() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testNullToDouble() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testDoubleToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testStringToDouble() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;

    void testCharacterToCharacter() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testNullToCharacter() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testCharacterToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testStringToCharacter() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;

    void testBooleanToBoolean() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testNullToBoolean() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testBooleanToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testStringToBoolean() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;

    void testUtilDateToUtilDate() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testNullToUtilDate() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testUtilDateToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testStringToUtilDate() throws ParseException, NullClassException, NullClassFieldException, NullFieldMatchMapException;

    void testSqlDateToSqlDate() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testNullToSqlDate() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testSqlDateToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testStringToSqlDate() throws ParseException, NullClassException, NullClassFieldException, NullFieldMatchMapException;

    void testTimestampToTimestamp() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testNullToTimestamp() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testTimestampToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testStringToTimestamp() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;

    void testNullFieldList() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testNullDestinationClass() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testNullSourceClass() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;

    void testNotDeclaredFieldInSourceClass() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testNotDeclaredFieldInDestinationClass();

    void testMultipleFieldMatchList() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testPrivateFieldSourceClassToPublicFieldDestinationClass() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testPublicFieldSourceClassToPrivateFieldDestinationClass() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;
    void testPrivateFieldSourceClassToPrivateFieldDestinationClass() throws NullClassException, NullClassFieldException, NullFieldMatchMapException;




}
