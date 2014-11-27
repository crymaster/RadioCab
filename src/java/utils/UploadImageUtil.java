/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author son
 */
public class UploadImageUtil {

    public static boolean upload(String fileName, String path,byte[] fileData) {
        File newFile = new File(path, fileName);
        if (!newFile.exists()) {
            try {
                FileOutputStream fos = new FileOutputStream(newFile);
                fos.write(fileData);
                fos.flush();
                fos.close();
            } catch( IOException ex){
                ex.printStackTrace();
            }
        }
        return true;
    }
}
