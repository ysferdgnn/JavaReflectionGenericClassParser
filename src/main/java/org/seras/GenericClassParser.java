package org.seras;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.lang.reflect.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/*
* @author Yusuf Erdoğan
* @version 1.0
*
* */

public class GenericClassParser<T,V> {

    Logger logger = Logger.getLogger(GenericClassParser.class.getName());

    public GenericClassParser(){
        logger.log(Level.INFO,"GenericClassParser has been initiated");

    }

   public void parseClassToClass(T sourceClazz, V destinationClazz, Map<String,String> fieldMap){

       List<Field> sourceClazzFieldList = Arrays.asList(sourceClazz.getClass().getDeclaredFields());
       List<Field> destinationClazzFieldList = Arrays.asList(destinationClazz.getClass().getDeclaredFields());


       fieldMap.forEach( (key,val)->{
        try {
            Field sourceCField = sourceClazzFieldList.stream().filter(s -> s.getName().contentEquals(key)).findFirst().get();
            Field destinationField = destinationClazzFieldList.stream().filter(s -> s.getName().contentEquals(val)).findFirst().get();

            destinationField.set(destinationClazz, sourceCField.get(sourceClazz));
        }catch (IllegalAccessException exception){
            exception.printStackTrace();
        }
       });



    }

    public void parseMapToClass(Map<String,String> sourceMap, V destinationClazz, Map<String,String> fieldMap){

        logger.info("Starting ParseMap To Class...");
        List<String> sourceClazzFieldList = sourceMap.keySet().stream().collect(Collectors.toList());
        List<Field> destinationClazzFieldList = Arrays.asList(destinationClazz.getClass().getDeclaredFields());


        logger.info(String.format("Source Class Field Count -> %s",sourceClazzFieldList.size() ));
        logger.info(String.format("Destination Class Field Count -> %s",destinationClazzFieldList.size()));
        logger.info(String.format("Field Map Size -> %s",fieldMap.size()));
        logger.info("Starting Field Parse And Match...");
        fieldMap.forEach( (key,val)->{
            try {
                logger.info(String.format("Field Map ->  Key : %s , Value: %s",key,val));
                String sourceField = sourceClazzFieldList.stream().filter(s -> s.contentEquals(key)).findFirst().get();
                Field destinationField = destinationClazzFieldList.stream().filter(s -> s.getName().contentEquals(val)).findFirst().get();
                String expectedValue = sourceMap.get(sourceField);

                Type destinationClassType = destinationField.getType();

                logger.info(String.format("Source Field Type -> %s",String.class));
                logger.info(String.format("Source Field Type -> %s, Destination Field Type -> %s",String.class,destinationClassType));

                logger.info(String.format("Expected Value -> %s",expectedValue));
                /* begin Integer*/
                if (Integer.class.equals(destinationClassType)) {
                    Integer value = parseInteger(expectedValue);

                    destinationField.set(destinationClazz, value);
                }
                /* end Integer*/

                /* begin String*/
                else if (String.class.equals(destinationClassType)){
                    String value=sourceMap.get(sourceField);
                    destinationField.set(destinationClazz,value);
                }
                /* end String*/
                /* start BigDecimal*/
                else if (BigDecimal.class.equals(destinationClassType)){
                    BigDecimal value = parseBigDecimal(expectedValue);
                    destinationField.set(destinationClazz, value);

                }
                /* end BigDecimal*/

                /* start Long */
                else if (Long.class.equals(destinationClassType)){
                    Long value = parseLong(expectedValue);
                    destinationField.set(destinationClazz,value);
                }
                /* end Long */

                /* start Float*/
                else if (Float.class.equals(destinationClassType)){
                    Float value = parseFloat(expectedValue);
                    destinationField.set(destinationClazz,value);
                }
                /* end Float */
//
                /* start Byte */
                else if (Byte.class.equals(destinationClassType)){

                    Byte value = parseByte(expectedValue);
                    destinationField.set(destinationClazz,value);
                }
                /* end Byte */

                /* start Double */
                else if (Double.class.equals(destinationClassType)){
                    Double value =Double.valueOf(sourceMap.get(sourceField));
                    destinationField.set(destinationClazz,value);
                }
                /* end Double */

                /* start Character */
                else if (Character.class.equals(destinationClassType)) {
                    Character value = sourceMap.get(sourceField).charAt(0);
                    destinationField.set(destinationClazz,value);
                }
                /* end Character */
                /* start Boolean */
                else if (Boolean.class.equals(destinationClassType)){
                    Boolean value = Boolean.valueOf(sourceMap.get(sourceField));
                    destinationField.set(destinationClazz,value);
                }
                /* end Boolean */



            }catch (IllegalAccessException exception){
                exception.printStackTrace();
            }
        });



    }

    private Byte parseByte(String expectedValue) {
        Byte value=0;
        if(isNumeric(expectedValue)){
            expectedValue = clearSpaces(expectedValue);
            if(isContainsDotOrComma(expectedValue)){
                logger.info(String.format("Value: %s is contains dot",expectedValue));
                expectedValue=clearDotsAndCommasFromString(expectedValue);
            }
            try{
                logger.info(String.format("Value: %s is expected value",expectedValue));
                value=Byte.parseByte(expectedValue);

            }catch (NumberFormatException exception){
                logger.warning(String.format("Value: %s Byte Number Format Exception",value));
                value=0;
            }

        }else{
            value=0;
        }


        return value;
    }

    private Float parseFloat(String expectedValue) {
        Float value =0f;

        if(isNumeric(expectedValue)){
            expectedValue=clearSpaces(expectedValue);
            if(isContainsDotOrComma(expectedValue)){
                logger.info(String.format("Value: %s is contains dot",expectedValue));
                expectedValue=clearDotsAndCommasFromString(expectedValue);

            }
            try{
                logger.info(String.format("Value: %s is expected value",expectedValue));
                value=Float.parseFloat(expectedValue);

                logger.info(String.format("Value: %s is %s",expectedValue,value.isInfinite() ? "infinite it must be 0" : "finite"));

                value = value.isInfinite() ? 0f :value;
            }catch (NumberFormatException exception){
                logger.warning(String.format("Value: %s Float Number Format Exception",value));
                value=0F;
            }
        }else{
            logger.info("Value: %s is not Numeric!");
        }
        return value;
    }

    private Long parseLong(String expectedValue) {
        Long value =0L;
        if(isNumeric(expectedValue)){
            expectedValue = clearSpaces(expectedValue);
            if(isContainsDotOrComma(expectedValue)){
                logger.info(String.format("Value: %s is contains dot",expectedValue));
                expectedValue =clearDotsAndCommasFromString(expectedValue);
                expectedValue= expectedValue.split("\\.")[0];
                logger.info(String.format("Value %s changed.",expectedValue));

            }
            try{
                logger.info(String.format("Value: %s is expected value",expectedValue));

                value= Long.parseLong(expectedValue,10);
            }catch (NumberFormatException exception){
                logger.warning(String.format("Value: %s Long Number Format Exception",value));
                value=0L;
            }

        }else {
            logger.info("Value: %s is not Numeric!");
            value=0L;
        }
        return value;
    }

    private BigDecimal parseBigDecimal(String expectedValue) {
        BigDecimal value =BigDecimal.ZERO;
        if(isNumeric(expectedValue)){
            try {
                expectedValue = clearSpaces(expectedValue);
                if(isContainsDotOrComma(expectedValue)){
                    expectedValue =clearDotsAndCommasFromString(expectedValue);

                    value=new BigDecimal(expectedValue);
                    logger.info(String.format("Value: %s has been parsed BigDecimal",value));
                }else {
                    value = new BigDecimal(expectedValue);
                }


            }catch (NumberFormatException exception){
                logger.warning(String.format("Value: %s BigDecimal  Number Format Exception", expectedValue));
                value=BigDecimal.ZERO;
            }

        }else{
            logger.info(String.format("Value: %s is not Numeric!", expectedValue));
        }
        return value;
    }

    private Integer parseInteger(String expectedValue) {
        Integer value =0;
        expectedValue = clearSpaces(expectedValue);
        if(isNumeric(expectedValue)){
            try{
                if (isContainsDotOrComma(expectedValue)){
                    expectedValue = clearDotsAndCommasFromString(expectedValue);

                    Double doubleValue = Double.valueOf(expectedValue);
                    value = doubleValue.intValue();
                }else{
                    value = Integer.valueOf(expectedValue);
                }

            }catch (NumberFormatException e){
                logger.warning(String.format("Value: %s Integer Number Format Exception", expectedValue));
                value =0;
            }
        }else{
            logger.info(String.format("Value: %s is not Numeric!", expectedValue));
            value=0;
        }
        return value;
    }

    public  Boolean isNumeric(String value){
       if(value.matches("[a-zA-Z]")){
          return  false;
       }
       return  true;
    }
    public Boolean isContainsDotOrComma(String value){
        logger.info(String.format("Value: %s containing dot or comma",value));
        if(value.contains(".") || value.contains(",")){
            return true;
        }
        return  false;
    }
    public String changeCommasAsDot(String value){
        logger.info(String.format("Value: %s changing commas as dot..",value));
        value = value.replace(',','.');
        logger.info(String.format("Value: %s changed commas as dots",value));
        return  value;
    }
    public String changeDotsAsComma(String value){
        logger.info(String.format("Value: %s changing dots as comma..",value));
        value=value.replace(".",",");
        logger.info(String.format("Value: %s changed dots as commas",value));
        return value;
    }
    public int calculateDotCount(String value){
        value = changeCommasAsDot(value);
       int commaCount = (int)value.codePoints().filter(s->s =='.').count();

        logger.info(String.format("Value: %s containing %s comma",value,commaCount));

       return  commaCount;
    }
    public String clearDotsAndCommasFromString(String value){
        logger.info(String.format("Value: %s clearing commas",value));
        value = changeCommasAsDot(value);
        int dotCount = calculateDotCount(value);
        int changedDotCount =0;
        if(dotCount>1){
            for (int i=0; i<value.length();i++){

                if(value.charAt(i) =='.' && changedDotCount <dotCount-1){
                    StringBuilder sb = new StringBuilder(value);
                    sb.deleteCharAt(i);
                    value =sb.toString();
                    changedDotCount++;
                }

            }
        }
        logger.info(String.format("Value: %s has been cleared.",value));
        return  value;

    }

    public String clearSpaces(String value){
        logger.info(String.format("Value : %s includes spaces working trim.",value));
        value = value.trim();
        logger.info(String.format("Value : %s trim has  applied. spaces replacing",value));
        value=value.replace(" ","");
        logger.info(String.format("Value: %s spaces replaced",value));
        return  value;
    }



}
