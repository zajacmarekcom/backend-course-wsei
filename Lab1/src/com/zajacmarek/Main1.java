package com.zajacmarek;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main1 {

    public static void main(String[] args) {
        try {
            FileInputStream stream = new FileInputStream(new File("file.txt"));

            InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);

            char[] buffer = new char[100];
            while(true){
                int readBytes = reader.read(buffer, 0, buffer.length);

                if (readBytes == -1) {
                    break;
                }

                String text = new String(buffer, 0, buffer.length);
                System.out.print(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
