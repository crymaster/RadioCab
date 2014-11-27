/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static utils.PhoneNumberValidator.PHONE_FORMAT;

/**
 *
 * @author son
 */
public class EmailValidator {
    public static final String EMAIL_PATTERN = 
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static boolean validate(String email){
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
         Matcher matcher = pattern.matcher(email);
         if(matcher.matches())
             return true;
         return false;
    }
}
