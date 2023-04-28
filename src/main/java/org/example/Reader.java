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

    public static List<String> getLinesByOffsets(ArrayList<Long> offsets, String filename) {
        var results = new ArrayList<String>();
        try {
            var file = new RandomAccessFile(filename, "r");

            String line = null;
            for (var offset : offsets) {
                file.seek(offset);
                line = file.readLine();
                results.add(line);
            }

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

}
