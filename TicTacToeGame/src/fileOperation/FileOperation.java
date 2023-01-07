/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author AhmedWard
 */
public class FileOperation {
    
    public boolean saveFile(byte[] bytes, File file){
        FileOutputStream fos;
        if (file != null) {
            try {
                fos = new FileOutputStream(file);
                fos.write(bytes);
                fos.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return true; 
        }else{
            return false;
        }
    }
    
    public String getFileData(File file){
        FileInputStream fis;
        String fileData = "";
        if (file != null) {
            try {
                fis = new FileInputStream(file);
                int size = fis.available();
                byte[] b = new byte[size];
                fis.read(b);
                fileData = new String(b);
                fis.close();

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return fileData;
    }
}
