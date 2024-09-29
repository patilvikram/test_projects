package com.example.vikram.pdf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.imageio.ImageIO;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.rendering.PDFRenderer;

public class PDFImageWriter {
    private PDDocument document;

    private PDFRenderer pdfRenderer;;
    private String outputDir;
    // private PDPageTree pages;

    public PDFImageWriter(File inputFile, String outputDir) throws IOException {

        document = Loader.loadPDF(inputFile);
        pdfRenderer = new PDFRenderer(document);
        this.outputDir = outputDir;
        Files.createDirectories(Paths.get(outputDir));

    }

    public boolean write(int pageIndex) throws IOException {

        PDPage pdPage = document.getPage(pageIndex);

        BufferedImage bim = pdfRenderer.renderImage(pageIndex);
        ImageIO.write(bim, "png", new File(outputDir+"/"+document.getDocumentInformation().getTitle() + "-" + pageIndex + ".png"));
        return true;
    }

    public void close() throws IOException {
        document.close();
    }
}
