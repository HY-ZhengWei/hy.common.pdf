package org.hy.common.pdf.junit;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.Overlay;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.junit.Test;





/**
 * PDF测试单元
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-05
 * @version     v1.0
 */
public class JU_PDF
{
    
    /**
     * 创建一个PDF文件
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-05
     * @version     v1.0
     *
     */
    @Test
    public void test001()
    {
        // 创建一个空的PDF文档
        PDDocument document = new PDDocument();

        try {
            // 创建页面对象
            PDPage page = new PDPage();
            document.addPage(page);

            // 开始在页面上写入内容
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();

            // 设置字体和字号
            PDType1Font v_PDFont = new PDType1Font(FontName.HELVETICA_BOLD);
            contentStream.setFont(v_PDFont, 14);

            // 设置文本起始位置
            contentStream.newLineAtOffset(200, 700);

            // 写入文本
            contentStream.showText("Hello, PDF!");

            // 结束写入内容
            contentStream.endText();
            contentStream.close();

            // 保存PDF文件
            document.save(new File("D:\\example.pdf"));
            document.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    
    
    /**
     * 两个PDF文件合并成一个PDF文件，用追加的方式合并。
     * 即A有2页、B有3页，合并后的文件有5页。
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-05
     * @version     v1.0
     */
    @Test
    public void test002()
    {
        try {
            // 创建一个 PDFMergerUtility 实例
            PDFMergerUtility pdfMerger = new PDFMergerUtility();

            // 添加要合并的PDF文件
            pdfMerger.addSource("D:\\WorkSpace\\hy.common.pdf\\src\\test\\java\\org\\hy\\common\\pdf\\junit\\helloWorld.pdf");
            pdfMerger.addSource("D:\\WorkSpace\\hy.common.pdf\\src\\test\\java\\org\\hy\\common\\pdf\\junit\\helloPDF.pdf");

            // 合并PDF文件
            pdfMerger.setDestinationFileName("D:\\example02.pdf");
            pdfMerger.mergeDocuments(null);

            System.out.println("PDF 合并完成。");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    
    
    /**
     * 将两个PDF文件叠加在一起。
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-12
     * @version     v1.0
     *
     */
    @Test
    public void test003()
    {
        Overlay    v_Overlay = null;
        PDDocument v_SaveDoc = null;
        try {
            // 加载需要叠加的源文件和叠加文件
            PDDocument v_SourceDoc  = Loader.loadPDF(new File("D:\\WorkSpace\\hy.common.pdf\\src\\test\\java\\org\\hy\\common\\pdf\\junit\\helloWorld.pdf"));
            PDDocument v_OverlayDoc = Loader.loadPDF(new File("D:\\WorkSpace\\hy.common.pdf\\src\\test\\java\\org\\hy\\common\\pdf\\junit\\helloPDF.pdf"));

            // 创建 Overlay 实例并执行叠加操作
            v_Overlay = new Overlay();
            v_Overlay.setInputPDF(v_SourceDoc);
            v_Overlay.setOverlayPosition(Overlay.Position.FOREGROUND);
            v_Overlay.setAllPagesOverlayPDF(v_OverlayDoc);
            v_SaveDoc = v_Overlay.overlay(new HashMap<Integer ,String>());

            // 保存叠加后的结果文档
            v_SaveDoc.save("D:\\example_overlay.pdf");

            System.out.println("PDF 叠加完成。");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if ( v_Overlay != null )
            {
                try
                {
                    v_Overlay.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                v_Overlay = null;
            }
            
            if ( v_SaveDoc != null )
            {
                try
                {
                    v_SaveDoc.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                v_SaveDoc = null;
            }
        }
    }
    
}
