package com.hillt;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by thill on 5/9/16.
 */

@SuppressWarnings("ResultOfMethodCallIgnored")
public class Utilities {

    /**
     * Quick and dirty text-file creator.
     *
     * @param aStringFileName       The String with the filename.
     * @param aString               The String to put into the file.
     */
    public void createTextFile(String aStringFileName, String aString) {
        File fFile;
        BufferedWriter fBufferedWriter = null;
        try {
            fFile = new File (aStringFileName );
            if (!fFile.exists ()) {
                fFile.createNewFile();
            }
            FileWriter fFileWriter = new FileWriter(fFile.getAbsoluteFile());
            fBufferedWriter = new BufferedWriter (fFileWriter);
            fBufferedWriter.write(aString);

            fBufferedWriter.close();
            fFileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (fBufferedWriter!=null) try {fBufferedWriter.close();} catch(Exception ignored) {}
        }
    }

    /**
     * File diff for testing.
     *
     * @param aFile1        The String with the filename.
     * @param aFile2        The String with the other filename.
     * @return boolean      If the files diff or not.
     */
    public boolean fileDiff(String aFile1, String aFile2) {
        byte[] file1 = new byte[0];
        byte[] file2 = new byte[0];
        try {
            file1 = Files.readAllBytes(Paths.get(aFile1));
            file2 = Files.readAllBytes(Paths.get(aFile2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Arrays.equals(file1,file2);
    }
}
