/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author son
 */
public class ImageValidator {
    public static boolean validate(String filename){
        String extension = FilenameUtils.getExtension(filename);
        if(extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png"))
            return true;
        return false;
    }
}
