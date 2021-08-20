package org.seras;


import  org.seras.Classes.Constants;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.*;
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
        List<String> sourceClazzFieldList = new ArrayList<>(sourceMap.keySet());
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
                    Double value = parseDouble(expectedValue);
                    destinationField.set(destinationClazz,value);
                }
                /* end Double */

                /* start Character */
                else if (Character.class.equals(destinationClassType)) {
                    Character value = parseCharacter(expectedValue);
                    destinationField.set(destinationClazz,value);
                }
                /* end Character */
                /* start Boolean */
                else if (Boolean.class.equals(destinationClassType)){
                    Boolean value = parseBoolean(expectedValue);
                    destinationField.set(destinationClazz,value);
                }
                /* end Boolean */

                /*start utilDate*/
                else if(java.util.Date.class.equals(destinationClassType)){

                    java.util.Date value =parseUtilDate(expectedValue);
                    destinationField.set(destinationClazz,value);
                }

                /*end utilDate*/

                /*start sqlDate*/
                else if (java.sql.Date.class.equals(destinationClassType)){
                    java.sql.Date value =parseSqlDate(expectedValue);
                    destinationField.set(destinationClazz,value);
                }
                /*end sqlDate*/

                /*start timestamp*/

                else if (java.sql.Timestamp.class.equals(destinationClassType)){
                    java.sql.Timestamp value =parseTimetamp(expectedValue);
                    destinationField.set(destinationClazz,value);
                }
                /*end timestamp*/


            }catch (IllegalAccessException exception){
                exception.printStackTrace();
            }
        });



    }

    private Timestamp parseTimetamp(String expectedValue) {


        String expectedValueAsStringForDotCount=String.valueOf(expectedValue);

        expectedValueAsStringForDotCount=expectedValueAsStringForDotCount
                .replace(",",".")
                .trim();
        long dotCount = expectedValueAsStringForDotCount.chars().filter(s->s=='.').count();

        String valueASString = String.valueOf(expectedValue);

        valueASString= clearStringForNumericCheck(valueASString);

        if(isNumeric(valueASString)){

            if(dotCount==0){
                long timestampAsLong = parseLong(expectedValue);

                return timestampAsLong==0 ? null : new Timestamp(timestampAsLong);
            }

            if(dotCount==1){
                expectedValue =expectedValue.replace(",", ".");
                LocalDateTime localDateTime = parseExcelDate(expectedValue);
                return Timestamp.valueOf(localDateTime);
            }else{

                try{
                    Date date= parseUtilDate(expectedValue);

                    return date ==null ? null : new Timestamp(date.getTime());
                }catch (Exception exception){
                    return null;
                }
            }

        }else{
            try{
                Date date= parseUtilDate(expectedValue);
                return date ==null ? null : new Timestamp(date.getTime());
            }catch (Exception exception){
                return null;
            }
        }

    }

    private LocalDateTime parseExcelDate(String s)
    {
        long days = Long.parseLong(s.split("\\.")[0]); // Get days from epoch as long
        double seconds = (Double.parseDouble(s) - days) * 86400; // Get time fraction and convert to seconds
        if (days >= 59)
        {
            days--; // Shave extra day if days push date past erroneous leap day in 1900
        }
        // Construct and return LocalDateTime object
        return LocalDateTime.of(1899, 12, 31, 0, 0, 0).plusDays(days).plusSeconds((long) Math.ceil(seconds));
    }

    private java.sql.Date parseSqlDate(String expectedValue) {

        java.util.Date dateUtil = parseUtilDate(expectedValue);
        logger.info(String.format("Value: %s parsed to java.util.date -> %s", expectedValue,dateUtil));
        if(dateUtil ==null){
            return null;
        }
        return new java.sql.Date(dateUtil.getTime());
    }

    private Date parseUtilDate( String expectedValue) {

        if (Optional.ofNullable(expectedValue).orElse("").contentEquals("")) {
            return  null;
        }



        expectedValue=clearSpacesDate(expectedValue);
        expectedValue = clearMultipleDotsFromStringForDates(expectedValue);


        return parseUtilDateFromStringMultipleFormats(expectedValue);

    }

    private Boolean parseBoolean(String expectedValue) {
        boolean value;
        if(Optional.ofNullable(expectedValue).orElse("").contentEquals("")){
            logger.info(String.format("Value: %s is null return false default",expectedValue));
            return  null;
        }
        expectedValue=clearSpaces(expectedValue);

        if(!isNumeric(expectedValue)){
            logger.info(String.format("Value: %s is not numeric ",expectedValue));
            expectedValue=clearSpecialChars(expectedValue);
            value= Boolean.parseBoolean(expectedValue);

            return value;
        }else{
            logger.info(String.format("Value: %s parsing double value..",expectedValue));
            Double d=parseDouble(expectedValue);
            return  d>0 ?Boolean.TRUE :Boolean.FALSE;
        }


    }

    private Character parseCharacter(String expectedValue) {
        char value ;

        if (expectedValue ==null || expectedValue =="")
        {
            return null;
        }
        expectedValue=clearSpaces(expectedValue);
        value = expectedValue.charAt(0);


        return value;
    }

    private Double parseDouble(String expectedValue) {
        double value=0d;

        String valueForNumericCheck=clearStringForNumericCheck(expectedValue);

        if(isNumeric(valueForNumericCheck)){
            expectedValue = clearSpaces(expectedValue);

            if(isContainsDotOrComma(expectedValue)){
                expectedValue=clearDotsAndCommasFromString(expectedValue);
            }
            try{
                value=Double.parseDouble(expectedValue);

            }catch (NumberFormatException exception){
                logger.warning(String.format("Value: %s Double Number Format Exception",value));
                value=0d;
            }


        }else
        {
            value=0d;
        }
        return value;
    }

    private Byte parseByte(String expectedValue) {
        byte value=0;
        String valueForNumericCheck=clearStringForNumericCheck(expectedValue);

        if(isNumeric(valueForNumericCheck)){
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

        }
        return value;
    }

    private Float parseFloat(String expectedValue) {
        float value =0f;

        String valueForNumericCheck=clearStringForNumericCheck(expectedValue);
        if(isNumeric(valueForNumericCheck)){

            expectedValue=clearSpaces(expectedValue);
            if(isContainsDotOrComma(expectedValue)){
                logger.info(String.format("Value: %s is contains dot",expectedValue));
                expectedValue=clearDotsAndCommasFromString(expectedValue);

            }
            try{
                logger.info(String.format("Value: %s is expected value",expectedValue));
                value=Float.parseFloat(expectedValue);

                logger.info(String.format("Value: %s is %s",expectedValue, Float.isInfinite(value) ? "infinite it must be 0" : "finite"));

                value = Float.isInfinite(value) ? 0f :value;
            }catch (NumberFormatException exception){
                logger.warning(String.format("Value: %s Float Number Format Exception",value));
                value=0F;
            }
        }else{
            logger.info("Value: %s is not Numeric!");
        }
        return value;
    }
    public String clearStringForNumericCheck(String str){
        str=String.valueOf(str)
                .replace(".","")
                .replace(",","")
                .replace(" ","")
                .trim();
        return  str;
    }

    private Long parseLong(String expectedValue) {
        long value =0L;

        String valueForNumericCheck=clearStringForNumericCheck(expectedValue);

        if(isNumeric(valueForNumericCheck)){
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
        String expectedValueClearedForNumeric =
                String.valueOf(expectedValue)
                        .replace(".","")
                        .replace(",","")
                        .replace(" ", "")
                        .trim();

        if(isNumeric(expectedValueClearedForNumeric)){
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
        int value =0;
        expectedValue = clearSpaces(expectedValue);

        String valueForNumericCheck=clearStringForNumericCheck(expectedValue);

        if(isNumeric(valueForNumericCheck)){
            try{
                if (isContainsDotOrComma(expectedValue)){
                    expectedValue = clearDotsAndCommasFromString(expectedValue);

                    double doubleValue = Double.parseDouble(expectedValue);
                    value = (int) doubleValue;
                }else{
                    value = Integer.parseInt(expectedValue);
                }

            }catch (NumberFormatException e){
                logger.warning(String.format("Value: %s Integer Number Format Exception", expectedValue));
            }
        }else{
            logger.info(String.format("Value: %s is not Numeric!", expectedValue));
            value=0;
        }
        return value;
    }

    public  Boolean isNumeric(String value){
        String regex =Constants.getInstance().regexNumeric;
        return value.matches(regex) ;
    }
    public Boolean isContainsDotOrComma(String value){
        logger.info(String.format("Value: %s containing dot or comma",value));
        return value.contains(".") || value.contains(",");
    }
    public String changeCommasAsDot(String value){
        logger.info(String.format("Value: %s changing commas as dot..",value));
        value = value.replace(',','.');
        logger.info(String.format("Value: %s changed commas as dots",value));
        return  value;
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

    public String clearMultipleDotsFromStringForDates(String value){
        while(value.charAt(0)=='.'){
            StringBuilder sb = new StringBuilder(value);
            sb.deleteCharAt(0);
            value=sb.toString();
        }

        while(value.charAt(value.length()-1)=='.'){
            StringBuilder sb = new StringBuilder(value);
            sb.deleteCharAt(value.length()-1);
            value=sb.toString();
        }

        for (int i =0; i<value.length(); i++){
            if(value.charAt(i)=='.'){
                if(value.charAt(Math.min(value.length(),i+1))=='.'){
                    StringBuilder sb = new StringBuilder(value);
                    sb.deleteCharAt(i);
                    value=sb.toString();
                }
            }
        }

        return value;
    }
    public String clearSpacesDate(String value){

        logger.info(String.format("Value: %s includes spaces working trim",value));
        value=value.trim();
        logger.info(String.format("Value : %s trim has  applied. spaces replacing",value));

        if(value.contains(" ")){
            logger.info(String.format("Value: %s includes Spaces after trim.Divide and clear in progress..",value));
            String [] splitArray = value.split(" ");
            List<String> splitList = Arrays.asList(splitArray);

            if(Optional.of(splitList).map(List::size).orElse(0).equals(2)){
                logger.info(String.format("Value %s includes 2 pieces. Dividing..",value));
                String firstPiece = splitList.get(0);
                String secondPiece = splitList.get(1);

                logger.info(String.format("Value: %s  first piece -> %s , second piece -> %s",value,firstPiece,secondPiece));

                firstPiece = clearSpaces(firstPiece);
                secondPiece=clearSpaces(secondPiece);

                logger.info(String.format("Value: %s cleared. Being combined pieces",value));
                value = String.format("%s %s",firstPiece,secondPiece);
                logger.info(String.format("Value: %s new value",value));

            }
            else if (Optional.of(splitList).map(List::size).orElse(0)>2){
                logger.info(String.format("Value: %s includes multiple spaces.",value));

              value=  splitList.stream().map(this::clearSpaces).collect(Collectors.joining(""));

            }


        }
       if(value.contains(",")){
           logger.info(String.format("Value: %s contains comma. Changing with dots",value));
           value=value.replace(",",".");
       }

        return value;


    }

    public String clearSpecialChars(String value){
        String regex = Constants.getInstance().regexSpecialChars;
        if (value.matches(regex)){
            logger.info(String.format("Value: %s includes special characters",value));
            value =value.replaceAll(regex,"");
            return  value;
        }
       return  value;
    }
    public  java.util.Date parseUtilDateFromStringMultipleFormats(String value){
        logger.info(String.format("Value: %s parsing..",value));

        if(value.length()>20) {
            logger.info(String.format("Value: %s length(%s) overflow, Trim in progress",value,value.length()));
            try {

               boolean isEng= Constants.getInstance().dayListENG.stream().anyMatch(value::contains);
               if (isEng){
                   logger.info(String.format("Value: %s contains english words. being adjusted locale and date format as 'EEEMMMddHH:mm:sszzzyyyy' ",value));
                   Locale locale = Locale.ENGLISH;
                   SimpleDateFormat formatReverse = new SimpleDateFormat("EEEMMMddHH:mm:sszzzyyyy",locale);
                   return formatReverse.parse(value );
               }

            }catch (ParseException exception){
                logger.warning(String.format("Value : %s can't parsed! ",value));
            }

        }


        DateTimeFormatter dateTimeFormatter= new DateTimeFormatterBuilder()

                //with time and space
                .appendOptional(DateTimeFormatter.ofPattern("dd.MM.yyyy H:mm:ss"))
                .appendOptional(DateTimeFormatter.ofPattern("dd/MM/yyyy H:mm:ss"))
                .appendOptional(DateTimeFormatter.ofPattern("dd-MM-yyyy H:mm:ss"))
                .appendOptional(DateTimeFormatter.ofPattern("yyy-MM-dd H:mm:ss"))
                .appendOptional(DateTimeFormatter.ofPattern("yyy/MM/dd H:mm:ss"))
                .appendOptional(DateTimeFormatter.ofPattern("yyy.MM.dd H:mm:ss"))
                //with time and without space
                .appendOptional(DateTimeFormatter.ofPattern("dd.MM.yyyyH:mm:ss"))
                .appendOptional(DateTimeFormatter.ofPattern("dd/MM/yyyyH:mm:ss"))
                .appendOptional(DateTimeFormatter.ofPattern("dd-MM-yyyyH:mm:ss"))
                .appendOptional(DateTimeFormatter.ofPattern("yyy-MM-ddH:mm:ss"))
                .appendOptional(DateTimeFormatter.ofPattern("yyy/MM/ddH:mm:ss"))
                .appendOptional(DateTimeFormatter.ofPattern("yyy.MM.ddH:mm:ss"))
                .appendOptional(DateTimeFormatter.ofPattern("yyy.MM.ddH:mm:ss"))
                //without seconds and space
                .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                .appendOptional(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"))
                .appendOptional(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"))
                .appendOptional(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))
                .appendOptional(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"))
                .appendOptional(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
                //without seconds and without space
                .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm"))
                .appendOptional(DateTimeFormatter.ofPattern("yyyy.MM.ddHH:mm"))
                .appendOptional(DateTimeFormatter.ofPattern("yyyy/MM/ddHH:mm"))
                .appendOptional(DateTimeFormatter.ofPattern("dd-MM-yyyyHH:mm"))
                .appendOptional(DateTimeFormatter.ofPattern("dd.MM.yyyyHH:mm"))
                .appendOptional(DateTimeFormatter.ofPattern("dd/MM/yyyyHH:mm"))
                //without time
                .appendOptional(DateTimeFormatter.ofPattern("yyy.MM.dd"))
                .appendOptional(DateTimeFormatter.ofPattern("yyy-MM-dd"))
                .appendOptional(DateTimeFormatter.ofPattern("yyy/MM/dd"))
                .appendOptional(DateTimeFormatter.ofPattern("dd/MM/yyy"))
                .appendOptional(DateTimeFormatter.ofPattern("dd.MM.yyy"))
                .appendOptional(DateTimeFormatter.ofPattern("dd-MM-yyy"))
                .toFormatter();

        LocalDate localDate;

        LocalTime localTime=null;

        try{
            localDate=LocalDate.parse(value,dateTimeFormatter);
        }catch (Exception e ){
            logger.info(String.format("Value: %s cant parsed return null",value));
            return null;
        }

        try{
            localTime= LocalTime.parse(value,dateTimeFormatter);
        }catch (DateTimeParseException exception){
            logger.warning(String.format("Value: %s can't parsed!",value));
        }

        logger.info(String.format("Value: %s parsed localdate ->%s",value,localDate.toString()));
        Timestamp t = Timestamp.valueOf(localTime !=null ? localDate.atTime(localTime) : localDate.atStartOfDay());
        logger.info(String.format("Value %s parsed Timestamp ->%s",value,t));
        Date d = new Date(t.getTime());
        logger.info(String.format("Value: %s parsed Date ->%s",value,d));
        return d;
    }



}
