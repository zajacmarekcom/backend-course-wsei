package com.zajacmarek;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class Main2 {
    public static void main(String[] args) {
        try (
                OutputStream stream = new FileOutputStream(new File("lab1-1.txt"));
                )
        {
            String text = "Lab 1.1 - TEXT";

            byte b[] = text.getBytes(StandardCharsets.UTF_8);

            stream.write(b);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
