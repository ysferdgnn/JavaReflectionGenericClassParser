package org.seras.Classes;

public class Constants {

    private static final Constants _constants = new Constants();

    private Constants(){};

    public static  Constants getInstance(){
        return _constants;
    }

    public  String regexSpecialChars="/[-._!\"`'#%&,:;<>=@{}~\\$\\(\\)\\*\\+\\/\\\\\\?\\[\\]\\^\\|]+/";
    public  String regexNumeric ="^[a-zA-Z]+$";

}
