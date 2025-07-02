package ktminithteam.service;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;
import ktminithteam.domain.Publish;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class PdfService {

    private static final String UPLOAD_DIR = "./pdfs/";

    public String createPdf(Publish publish) throws IOException {
        
        Files.createDirectories(Paths.get(UPLOAD_DIR));
        String title = publish.getTitle();
        String fileName = title + ".pdf";
        Path pdfPath = Paths.get(UPLOAD_DIR + fileName);

        PdfWriter writer = new PdfWriter(pdfPath.toString());
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

            
        String image = publish.getCoverUrl();
        String content = publish.getContent();
        Image coverImage = new Image(ImageDataFactory.create(new URL(image)));
        document.add(new Paragraph(title));
        document.add(coverImage);
        document.add(new Paragraph(content));
        document.add(new Paragraph("\n\nKT"));
        document.close();

        return "/pdfs/" + fileName;
    }
}
