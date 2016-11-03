package name.guke.pdf.itext;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by GUKE on 2016/4/2.
 */
public class TextPDFTest {

    public static void main(String[] args) throws Exception{
        String DEST = new File(TextPDFTest.class.getResource("").toURI()).toString()+"/results/objects/chapter_title.pdf";
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new TextPDFTest().createPdf(DEST);
    }

    //http://developers.itextpdf.com/examples
    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC);
        Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
        Chunk chunk = new Chunk("This is the title", chapterFont);
        Chapter chapter = new Chapter(new Paragraph(chunk), 1);
        chapter.setNumberDepth(0);
        chapter.add(new Paragraph("This is the paragraph", paragraphFont));
        document.add(chapter);
        document.close();
        System.out.println("pdf 创建成功");
    }
}
