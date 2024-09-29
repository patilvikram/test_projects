package com.example.vikram;

import java.io.File;
import java.io.IOException;

import com.example.vikram.pdf.PDFImageWriter;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World! - POC -pDF " + System.getProperty("user.dir"));
        PDFImageWriter writer = new PDFImageWriter(new File(System.getProperty("user.dir")+"/poc-pdf/input/"+"sample.pdf"),System.getProperty("user.dir")+"/poc-pdf/output/");
        writer.write(
          0  
        );
    }
}
