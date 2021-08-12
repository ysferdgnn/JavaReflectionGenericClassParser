package org.seras;

import org.seras.Classes.DestinationClass;
import org.seras.Classes.SourceClass;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SourceClass sourceClass = new SourceClass();
        DestinationClass destinationClass = new DestinationClass();

        Map<String,String> _mapper= new HashMap<String,String>();
        _mapper.put("ad","tc");
        _mapper.put("decimal","decimal");


        Map<String,String> mapForInsert= new HashMap<String,String>();
        mapForInsert.put("ad","1656");
        mapForInsert.put("decimal","1433");

        mapForInsert.keySet().stream().collect(Collectors.toList()).stream().forEach(s-> System.out.println(s));


        GenericClassParser genericClassParser = new GenericClassParser();

//        genericClassParser.parseClassToClass(sourceClass,destinationClass,_mapper);
        genericClassParser.parseMapToClass(mapForInsert,destinationClass,_mapper);

        System.out.println(destinationClass.toString());




    }
}
