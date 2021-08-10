package org.example;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.lang.reflect.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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
                    Integer value ;

                    if(!isNumeric(expectedValue)){
                        // return 0 is value alphanumeric
                        value=0;
                    }else{
                        try{
                            int intvalprimitive = Integer.decode(sourceMap.get(sourceField));
                            logger.info("decoded int value ->"+intvalprimitive);
                            value = Integer.valueOf(intvalprimitive);

                        }catch (NumberFormatException e){
                            value =0;
                        }
                    }







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
                    BigDecimal value = new BigDecimal(sourceMap.get(sourceField));
                    destinationField.set(destinationClazz,value);
                }
                /* end BigDecimal*/

                /* start Long */
                else if (Long.class.equals(destinationClassType)){
                    Long value = Long.valueOf(sourceMap.get(sourceField));
                    destinationField.set(destinationClazz,value);
                }
                /* end Long */

                /* start Float*/
                else if (Float.class.equals(destinationClassType)){
                    Float value =Float.valueOf(sourceMap.get(sourceField));
                    destinationField.set(destinationClazz,value);
                }
                /* end Float */
//
                /* start Byte */
                else if (Byte.class.equals(destinationClassType)){
                    Byte value =Byte.valueOf(sourceMap.get(sourceField));
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
                    Character value = Character.valueOf(sourceMap.get(sourceField).charAt(0));
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

    public  Boolean isNumeric(String value){
       if(value.matches("[a-zA-Z]")){
          return  false;
       }
       return  true;
    }
}
