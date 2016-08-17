package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/*
 * Created by Ahmed on 14-Aug-16.
 */
public class FixFile {

    public FixFile(String readFile, String writeFile) {
        fixRegFile(readFile, writeFile);
    }

    private void fixRegFile(String readFile, String writeFile) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(readFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(writeFile));

            String strLine;
            int id = 1;
            while ((strLine = bufferedReader.readLine()) != null) {
                String[] result = strLine.split(",");
                Record newRecord = new Record(result[1], result[2], result[3], Integer.toString(id), "false");
                bufferedWriter.write(newRecord.toString());
                id++;
            }
            bufferedWriter.close();
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

}
