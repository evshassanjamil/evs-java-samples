package evs.labs.w4lab.fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

class FileIOHelper {

    private String mPath;

    FileIOHelper(String filePath) {
        setFilePath(filePath);
    }

    public void setFilePath(String filePath) {
        this.mPath = filePath;
    }

    public String getFilePath() {
        return mPath;
    }

    public void writeFile(byte[] bytes) {
        try {
            OutputStream os = new FileOutputStream(mPath);
            os.write(bytes);   // writes the bytes
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] readFile() {
        byte[] outBytes;
        try {
            InputStream is = new FileInputStream(getFilePath());
            outBytes = new byte[is.available()];
            is.read(outBytes);
            //System.out.println("Total Bytes = " + totalBytes);
            is.close();
            return outBytes;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new byte[0];
        }
    }
}
