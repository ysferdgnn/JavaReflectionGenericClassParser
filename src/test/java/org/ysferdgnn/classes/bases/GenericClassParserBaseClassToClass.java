package org.ysferdgnn.classes.bases;

import org.junit.Before;
import org.junit.Test;
import org.ysferdgnn.Classes.Pojos.DestinationClass;
import org.ysferdgnn.Classes.Exceptions.NullClassException;
import org.ysferdgnn.Classes.Exceptions.NullClassFieldException;
import org.ysferdgnn.Classes.Exceptions.NullFieldMatchMapException;
import org.ysferdgnn.Classes.Pojos.NullFieldDestinationClass;
import org.ysferdgnn.Classes.Pojos.NullFieldSourceClass;
import org.ysferdgnn.Classes.Pojos.SourceClass;
import org.ysferdgnn.GenericClassParser;
import org.ysferdgnn.interfaces.IGenericClassParserClassToClassTest;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;


public class GenericClassParserBaseClassToClass implements IGenericClassParserClassToClassTest {


    public GenericClassParser<SourceClass,DestinationClass> genericClassParser          = null;
    public DestinationClass destinationClass                                            = null;
    public SourceClass sourceClass                                                      = null;
    public Map<String, String> fieldMatchMap                                            = null;
    public NullFieldSourceClass nullFieldSourceClass                                    = null;
    public NullFieldDestinationClass nullFieldDestinationClass                          = null;

    @Before
    @Override
    public void initDestinationClass() {
        destinationClass            = new DestinationClass();
        sourceClass                 = new SourceClass();
        fieldMatchMap               = new HashMap<>();
        genericClassParser          = new GenericClassParser<>();
        nullFieldSourceClass        = new NullFieldSourceClass();
        nullFieldDestinationClass   = new NullFieldDestinationClass();
    }

    @Test
    @Override
    public void testStringToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testNullToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException { throw new NotImplementedException();}

    @Test
    @Override
    public void testIntegerToInteger() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testNullToInteger() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testIntegerToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testStringToInteger() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testBigDecimalToBigDecimal() throws NullClassException, NullClassFieldException, NullFieldMatchMapException { throw new NotImplementedException();}

    @Test
    @Override
    public void testNullToBigDecimal() throws NullClassException, NullClassFieldException, NullFieldMatchMapException { throw new NotImplementedException();}

    @Test
    @Override
    public void testBigDecimalToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testStringToBigDecimal() throws NullClassException, NullClassFieldException, NullFieldMatchMapException { throw new NotImplementedException();}

    @Test
    @Override
    public void testLongToLong() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testNullToLong() throws NullClassException, NullClassFieldException, NullFieldMatchMapException { throw new NotImplementedException();}

    @Test
    @Override
    public void testLongToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException { throw new NotImplementedException();}

    @Test
    @Override
    public void testStringToLong() throws NullClassException, NullClassFieldException, NullFieldMatchMapException { throw new NotImplementedException();}

    @Test
    @Override
    public void testFloatToFloat() throws NullClassException, NullClassFieldException, NullFieldMatchMapException { throw new NotImplementedException();}

    @Test
    @Override
    public void testNullToFloat() throws NullClassException, NullClassFieldException, NullFieldMatchMapException { throw new NotImplementedException();}

    @Test
    @Override
    public void testFloatToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testStringToFloat() throws NullClassException, NullClassFieldException, NullFieldMatchMapException { throw new NotImplementedException();}

    @Test
    @Override
    public void testByteToByte() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testNullToByte() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testByteToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testStringToByte() throws NullClassException, NullClassFieldException, NullFieldMatchMapException { throw new NotImplementedException();}

    @Test
    @Override
    public void testDoubleToDouble() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testNullToDouble() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testDoubleToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException { throw new NotImplementedException();}

    @Test
    @Override
    public void testStringToDouble() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testCharacterToCharacter() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testNullToCharacter() throws NullClassException, NullClassFieldException, NullFieldMatchMapException { throw new NotImplementedException();}

    @Test
    @Override
    public void testCharacterToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException { throw new NotImplementedException();}

    @Test
    @Override
    public void testStringToCharacter() throws NullClassException, NullClassFieldException, NullFieldMatchMapException { throw new NotImplementedException();}

    @Test
    @Override
    public void testBooleanToBoolean() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testNullToBoolean() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testBooleanToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testStringToBoolean() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testUtilDateToUtilDate() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testNullToUtilDate() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testUtilDateToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException { throw new NotImplementedException();}

    @Test
    @Override
    public void testStringToUtilDate() throws ParseException, NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testSqlDateToSqlDate() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testNullToSqlDate() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testSqlDateToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testStringToSqlDate() throws ParseException, NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testTimestampToTimestamp() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testNullToTimestamp() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testTimestampToString() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testStringToTimestamp() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testNullFieldList()   {throw new NotImplementedException(); }

    @Test
    @Override
    public void testNullDestinationClass()   {throw new NotImplementedException(); }

    @Test
    @Override
    public void testNullSourceClass() {throw new NotImplementedException();}

    @Test
    @Override
    public void testNotDeclaredFieldInSourceClass()  { throw new NotImplementedException(); }

    @Test
    @Override
    public void testNotDeclaredFieldInDestinationClass() { throw new NotImplementedException();}

    @Test
    @Override
    public void testMultipleFieldMatchList() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testPrivateFieldSourceClassToPublicFieldDestinationClass() throws NullClassException, NullClassFieldException, NullFieldMatchMapException { throw new NotImplementedException();}

    @Test
    @Override
    public void testPublicFieldSourceClassToPrivateFieldDestinationClass() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException(); }

    @Test
    @Override
    public void testPrivateFieldSourceClassToPrivateFieldDestinationClass() throws NullClassException, NullClassFieldException, NullFieldMatchMapException {throw new NotImplementedException();}
}
