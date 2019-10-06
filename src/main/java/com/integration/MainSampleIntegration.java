/*
 * Sample class Integration Pentafile SDK Java 6+
 */
package com.integration;

import com.pentafile.sdk.PentafileAPI;
import com.pentafile.sdk.bean.ObjectFile;
import com.pentafile.sdk.exception.PentafileException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author user
 */
public class MainSampleIntegration {

    public static PentafileAPI API = null;

    static {

        /**
         * Pentafile Cloud 
         * AppKey=xxxxxxxxxxxxxxxxxxxxxxxx
         * API = PentafileFactory.newInstance("AppKey");
         */
    }

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

    }

    /**
     * Carga de archivo a Pentafile
     */
    public static void uploadFile() {
        try {
            File archivo = new File("G:\\storage\\pentafile\\sanrafael.jpg");
            ObjectFile file = API.uploadFile(UUID.randomUUID().toString().replace("-", "") + archivo.getName(), new FileInputStream(archivo));
            System.out.println("key :" + file.getKey());
            System.out.println("type : " + file.getType());
            System.out.println("size : " + file.getSize());
            System.out.println("id: " + file.getId());
            System.out.println("url : " + file.getUrl());
        } catch (FileNotFoundException e) {
            System.out.println("IO " + e.getMessage());
        } catch (PentafileException e) {
            System.out.println("Pentafile Error " + e.getMessage());
        }
    }

    /**
     * downloadFile
     */
    public static void downloadFile() {
        try {
            String fileId = "eca7a26d2a4d4baaa78fbbab9627b27asanrafael.jpg";
            InputStream is = API.downloadFile(fileId);
            /**
             * Save file
             */
            File out_file = new File("G:\\folder\\info_2_1.jpg");
            FileOutputStream fos = new FileOutputStream(out_file);
            IOUtils.copy(is, fos);
            fos.flush();
        } catch (IOException e) {
            System.out.println("IO " + e.getMessage());
        } catch (PentafileException e) {
            System.out.println("Pentafile Error " + e.getMessage());

        }
    }

    /**
     * Obtener información de archivo en Pentafile
     */
    public static void infoFile() {
        try {
            String fileId = "8e3377fa-a1a2-4b65-b886-73b95286ae83-doc.pdf";
            ObjectFile file = API.infoFile(fileId);
            /**
             * Save file
             */
            System.out.println("key :" + file.getKey());
            System.out.println("type : " + file.getType());
            System.out.println("size : " + file.getSize());
            System.out.println("url : " + file.getUrl());
        } catch (PentafileException e) {
            System.out.println("Pentafile Error " + e.getMessage());

        }
    }

    /**
     * Eliminar archivo en Pentafile
     */
    public static void deleteFile() {
        try {
            String fileId = "5220147b9ac94092ac6415a556c000a1";
            API.deleteFile(fileId);
            System.out.println("file deleted OK");
        } catch (PentafileException e) {
            System.out.println("Pentafile Error " + e.getMessage());
        }
    }

}
