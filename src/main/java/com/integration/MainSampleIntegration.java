/*
 * Sample class Integration Pentafile SDK Java 6+
 */
package com.integration;

import com.pentafile.sdk.PentafileAPI;
import com.pentafile.sdk.PentafileFactory;
import com.pentafile.sdk.bean.ObjectFile;
import com.pentafile.sdk.exception.PentafileException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author user
 */
public class MainSampleIntegration {

    public static PentafileAPI API = null;

    static {
        /**
         * AppKey=xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx //key de la aplicación
         * Url=http://IP:8080/pentafile  // Url del servidor de pentafile
         */
        API = PentafileFactory.newInstance("AppKey", "Url");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

    }

    /**
     * uploadFile
     */
    public static void uploadFile() {
        try {
            File archivo = new File("D:\\cloud\\Report2.pdf");
            ObjectFile file = API.uploadFile(archivo.getName(), new FileInputStream(archivo));
            /**
             * View object file return
             */
            System.out.println("key :" + file.getKey());
            System.out.println("filename : " + file.getFilename());
            System.out.println("type : " + file.getType());
            System.out.println("size : " + file.getSize());
            System.out.println("url : " + file.getUrl());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        } catch (PentafileException e) {
            System.out.println("PentafileException " + e.getMessage());
        }
    }

    /**
     * downloadFile
     */
    public static void downloadFile() {
        try {
            String key_file = "24dd0e08b5f84b13802007f1cfe161d3";
            InputStream is = API.downloadFile(key_file);
            /**
             * Save file
             */
            File out_file = new File("D:\\cloud\\upload\\info_1.csv");
            FileOutputStream fos = new FileOutputStream(out_file);
            IOUtils.copy(is, fos);
            fos.flush();
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        } catch (PentafileException e) {
            System.out.println("PentafileException " + e.getMessage());
        }
    }

    /**
     * deleteFile
     */
    public static void deleteFile() {
        try {
            String key_file = "5220147b9ac94092ac6415a556c000a1";
            API.deleteFile(key_file);
            System.out.println("file deleted OK");
        } catch (PentafileException e) {
            System.out.println("PentafileException " + e.getMessage());

        }
    }

    /**
     * infoFile
     */
    public static void infoFile() {
        try {
            String key_file = "24dd0e08b5f84b13802007f1cfe161d3";
            ObjectFile file = API.infoFile(key_file);
            /**
             * View object file
             */
            System.out.println("key :" + file.getKey());
            System.out.println("filename : " + file.getFilename());
            System.out.println("type : " + file.getType());
            System.out.println("size : " + file.getSize());
            System.out.println("url : " + file.getUrl());
        } catch (PentafileException e) {
            System.out.println("PentafileException " + e.getMessage());
        }
    }

}
