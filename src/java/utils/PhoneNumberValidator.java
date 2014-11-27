/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author son
 */
public class PhoneNumberValidator {
    public static final String PHONE_FORMAT = "\\d{8,11}";
    
    public static boolean validate(String str){
         Pattern pattern = Pattern.compile(PHONE_FORMAT);
         Matcher matcher = pattern.matcher(str);
         if(matcher.matches())
             return true;
         return false;
    }
}
