package org.seras.Classes;

import java.util.Arrays;
import java.util.List;

public class Constants {

    private static final Constants _constants = new Constants();

    private Constants(){};

    public static  Constants getInstance(){
        return _constants;
    }

    public  String regexSpecialChars="/[-._!\"`'#%&,:;<>=@{}~\\$\\(\\)\\*\\+\\/\\\\\\?\\[\\]\\^\\|]+/";

    public  String regexNumeric ="^[a-zA-Z]+$";

    public List<String> dayListENG = Arrays.asList("Sat","Sun","Mon","Tue","Wed","Thu","Fri");

}
