package org.seras;

import org.seras.Classes.DestinationClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


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
public class GenericClassParserTestBigDecimal {

    GenericClassParser<Map<String, String>, DestinationClass> genericClassParser;
    DestinationClass destinationClass;
    Map<String, String> valuesMap;
    Map<String, String> fieldMatchMap;


    @Before
    public void initDestinationClass() {
        destinationClass = new DestinationClass();
        valuesMap = new HashMap<>();
        fieldMatchMap = new HashMap<>();


        genericClassParser = new GenericClassParser<Map<String, String>, DestinationClass>();
    }




    @Test
    public void testMapToClassBigDecimalNormal() {
        valuesMap.put("decimalValue", "11111");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("11111")) == 0);
    }

    @Test
    public void testMapToClassBigDecimalBigNumber() {
        valuesMap.put("decimalValue", "9999999999999999999999999999999999999999999999999999999,99999999999999999999999999999999999");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("9999999999999999999999999999999999999999999999999999999.99999999999999999999999999999999999")) == 0);
    }

    @Test
    public void testMapToClassBigDecimalAlphanumeric() {
        valuesMap.put("decimalValue", "111.111112313aaaa33123");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(BigDecimal.ZERO) == 0);
    }


    @Test
    public void testMapToClassBigDecimalWithDot() {
        valuesMap.put("decimalValue", "111.11111231333123");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("111.11111231333123")) == 0);
    }

    @Test
    public void testMapToClassBigDecimalWithMultipleDots() {
        valuesMap.put("decimalValue", "111.1.1.111231333123");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("11111.111231333123")) == 0);
    }

    @Test
    public void testMapToClassBigDecimalWithComma() {
        valuesMap.put("decimalValue", "111.11111,231333123");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("11111111.231333123")) == 0);
    }

    @Test
    public void testMapToClassBigDecimalWithMultipleCommas() {
        valuesMap.put("decimalValue", "1.1.1.1.1.1.1.1,231333123");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("11111111.231333123")) == 0);
    }


    @Test
    public void testMapToClassBigDecimalWithStartWithZeros() {
        valuesMap.put("decimalValue", "0000000015,95444");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("15.95444")) == 0);
    }

    @Test
    public void testMapToClassBigDecimalWithStartWithZerosAndDots() {
        valuesMap.put("decimalValue", "000.00,00.015,9544400");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("15.95444")) == 0);
    }

    @Test
    public void testMapToClassBigDecimalEndWithZeros() {
        valuesMap.put("decimalValue", "1500,0000000");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("1500")) == 0);
    }

    @Test
    public void testMapToClassBigDecimalStartWithZerosEndWithZeros() {
        valuesMap.put("decimalValue", "0001500,0000000");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("1500")) == 0);
    }

    @Test
    public void testMapToClassBigDecimalWithNegativeNumber() {
        valuesMap.put("decimalValue", "-1.000");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("-1")) == 0);
    }
    @Test
    public void testMapToClassBigDecimalWithNegativeNumberAndContainsMultipleDots() {
        valuesMap.put("decimalValue", "-1.0.0.0");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("-100")) == 0);
    }

    @Test
    public void testMapToClassBigDecimalWithNegativeNumberAndContainsMultipleDotsAndAlphaNumeric() {
        valuesMap.put("decimalValue", "-1.0.0.ggggg0");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(BigDecimal.ZERO) == 0);
    }
    @Test
    public void testMapToClassBigDecimalContainsSpaces() {
        valuesMap.put("decimalValue", "  1   2  ");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("12")) == 0);
    }

    @Test
    public void testMapToClassBigDecimalContainsSpacesAndDots() {
        valuesMap.put("decimalValue", "  1.   2  ");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("1.2")) == 0);
    }
}
