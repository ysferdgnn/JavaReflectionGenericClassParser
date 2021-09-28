package org.seras.classes.tests;


import org.junit.Assert;
import org.seras.classes.bases.GenericClassParserBaseNumeric;

/*Test Generic Class Parser for Float Parse
 * @author Yusuf Erdoğan
 * @version 1.0
 *
 * test normal
 * test big number
 * test alphanumeric
 * test floating point
 * test dot
 * test multiple dots
 * test comma
 * test multiple commas
 * test start with zeros
 * test start with zeros and dots
 * test end with zeros
 * test start with zeros and end with zeros
 * test start with negative number
 * test start with negative number and contains multiple dots
 * start with negative number and contains alphanumeric and contains multiple dots
 * contains spaces
 * contains spaces and dots
 *
 * */
public class GenericClassParserTestByte extends GenericClassParserBaseNumeric {


    @Override
    public void initDestinationClass() {
        super.initDestinationClass();
    }

    @Override
    public void testNormal() {
        valuesMap.put("byte", "1");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getByteVal(), 1, 0);
    }

    @Override
    public void testBigNumber() {
        valuesMap.put("byte", "999");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getByteVal(), 0, 0);
    }

    @Override
    public void testAlphanumeric() {
        valuesMap.put("byte", "14abc");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getByteVal(), 0, 0);
    }

    @Override
    public void testFloatingPoint() {
        valuesMap.put("byte", "14.4");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getByteVal(), 0, 0);
    }

    @Override
    public void testDot() {
        valuesMap.put("byte", "14.4");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getByteVal(), 0, 0);
    }

    @Override
    public void testMultipleDots() {
        valuesMap.put("byte", "14.4.4.4");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getByteVal(), 0, 0);
    }

    @Override
    public void testComma() {
        valuesMap.put("byte", "14,4");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getByteVal(), 0, 0);
    }

    @Override
    public void testMultipleCommas() {
        valuesMap.put("byte", "14,4");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getByteVal(), 0, 0);
    }

    @Override
    public void testStartWithZeros() {
        valuesMap.put("byte", "0000000014");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getByteVal(), 14, 0);
    }

    @Override
    public void testStartWithZerosAndDots() {
        valuesMap.put("byte", "000000..0014");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getByteVal(), 0, 0);
    }

    @Override
    public void testEndWithZeros() {
        valuesMap.put("byte", "1400000");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getByteVal(), 0, 0);
    }

    @Override
    public void testStartWithZerosAndEndWithZeros() {
        valuesMap.put("byte", "000000001400000");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getByteVal(), 0, 0);
    }

    @Override
    public void testStartWithNegativeNumber() {
        valuesMap.put("byte", "-15");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getByteVal(), -15, 0);
    }

    @Override
    public void testStartWithNegativeNumberAndContainsMultipleDots() {
        valuesMap.put("byte", "-15.1.1.1");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getByteVal(), 0, 0);
    }

    @Override
    public void testStartWithNegativeNumberAndContainsAlphanumericAndContainsMultipleDots() {
        valuesMap.put("byte", "-15.1adads.1.1");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getByteVal(), 0, 0);
    }

    @Override
    public void testContainsSpaces() {
        valuesMap.put("byte", "1        1");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getByteVal(), 11, 0);
    }

    @Override
    public void testContainsSpacesAndDots() {
        valuesMap.put("byte", "1     .   1");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getByteVal(), 0, 0);
    }

    @Override
    public void testNull() {
        valuesMap.put("byteVal",null);
        fieldMatchMap.put("byteVal","byteVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.getByteVal());
    }

    @Override
    public void testEmptyString() {
        valuesMap.put("byteVal","");
        fieldMatchMap.put("byteVal","byteVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.getByteVal());
    }
}
