package com.epam.mjc.nio;

import java.io.*;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        if (file == null) {
            return new Profile();
        }
        StringBuilder def = new StringBuilder();
        try (java.io.FileReader fr = new java.io.FileReader(file))
        {
            int content;
            while ((content = fr.read()) != -1) {
                if (content != 13) {
                    def.append((char) content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        def = new StringBuilder(def.toString().replace("Name: ", ""));
        def = new StringBuilder(def.toString().replace("Age: ", ""));
        def = new StringBuilder(def.toString().replace("Email: ", ""));
        def = new StringBuilder(def.toString().replace("Phone: ", ""));
        String[] result = def.toString().split("\n");
        return new Profile(result[0], Integer.valueOf(result[1]), result[2], Long.valueOf(result[3]));
    }

    public static void main(String[] args) {
        FileReader f = new FileReader();
        f.getDataFromFile(new File("src/main/resources/Profile.txt"));
    }
}
