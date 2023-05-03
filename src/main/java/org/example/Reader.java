package org.example;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public static ArrayList<Pair<String, Long>> readAllLines(String filename) {
        var pairList = new ArrayList<Pair<String, Long>>();
        try {
            var file = new RandomAccessFile(filename, "r");
            long byteOffset = 0;
            file.seek(byteOffset);

            String line = null;
            while ((line = file.readLine()) != null) {
                pairList.add(new Pair<>(line, byteOffset));
                byteOffset += line.length() + 1;
                file.seek(byteOffset);
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pairList;
    }

    public static String [] getLinesByOffsets(long [] offsets, String filename) {
        var results = new String[offsets.length];
        try {
            var file = new RandomAccessFile(filename, "r");

            String line = null;
            for (var i = 0; i < offsets.length; i++) {
                file.seek(offsets[i]);
                line = file.readLine();
                results[i] = line;
            }

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

}
