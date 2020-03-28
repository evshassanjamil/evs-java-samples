/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evs.labs.w4lab.fileio;

/**
 * @author hassanjamil
 */
public class TestFileIO {

    public static void main(String[] args) {
        // Setting file path
        String path = "C:/Users/hassanjamil/Desktop/sample.txt";
        // Initializing FileStreamHandler object to call File IO functions from it
        FileIOHelper fsh = new FileIOHelper(path);
        // Writing Custom String bytes to the file
        String write = "Hello World!";
        System.out.println("Write Data: " + write);
        fsh.writeFile(write.getBytes());
        System.out.println("Wrote file successfully, path: " + fsh.getFilePath());
        // Reading bytes from the file written
        for(byte b : fsh.readFile()) {
            System.out.println("Read Data Bytes: " + b);
        }

        System.out.println("Read Data: " + new String(fsh.readFile()));
        System.out.println("Read file successfully, path:" + fsh.getFilePath());
    }
}
