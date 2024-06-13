package org.hy.common.pdf;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.Overlay;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.hy.common.Help;
import org.hy.common.pdf.data.PDFText;
import org.hy.common.pdf.data.PDFTextDomain;
import org.hy.common.xml.log.Logger;





/**
 * PDF 工具类型
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-12
 * @version     v1.0
 */
public class PDFHelp
{
    
    private static final Logger $Logger = new Logger(PDFHelp.class);
    
    
    
    /**
     * 创建纯文本的PDF文件
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_SaveFile  PDF保存路径
     * @param i_Texts     PDF数据
     * @return
     */
    public static boolean create(String i_SaveFile ,List<PDFText> i_Texts)
    {
        if ( Help.isNull(i_SaveFile) )
        {
            return false;
        }
        if ( Help.isNull(i_Texts) )
        {
            return false;
        }
        
        // 创建一个空的PDF文档
        PDDocument          v_Doc           = new PDDocument();
        PDPageContentStream v_ContentStream = null;

        try {
            // 创建页面对象
            PDPage v_Page = new PDPage();
            v_Doc.addPage(v_Page);

            // 开始在页面上写入内容
            v_ContentStream = new PDPageContentStream(v_Doc, v_Page);
            PDFont v_LastFont     = null;
            Float  v_LastFontSize = null;
            for (PDFText v_Text : i_Texts)
            {
                PDFTextDomain v_TextDomain = new PDFTextDomain(v_Text);
                
                // 是否延用上次的字体
                if ( v_TextDomain.getPdFont() != null )
                {
                    v_LastFont = v_TextDomain.getPdFont();
                }
                
                // 开始写入内容
                v_ContentStream.beginText();
                
                // 设置字体和字号
                if ( v_TextDomain.getFontSize() != null && v_LastFont != null )
                {
                    v_LastFontSize = v_TextDomain.getFontSize();
                    v_ContentStream.setFont(v_LastFont, v_LastFontSize);
                }
                else if ( v_TextDomain.getPdFont() != null && v_LastFontSize != null )
                {
                    // 延用上次的字体大小
                    v_ContentStream.setFont(v_LastFont, v_LastFontSize);
                }
                
                // 设置文本起始位置
                if ( v_TextDomain.getTextX() != null && v_TextDomain.getTextY() != null )
                {
                    v_ContentStream.newLineAtOffset(v_TextDomain.getTextX(), v_TextDomain.getTextY());
                }
                else
                {
                    v_ContentStream.newLine();
                }
                
                // 写入文本
                v_ContentStream.showText(v_TextDomain.getText());
                // 结束写入内容
                v_ContentStream.endText();
            }
            
            
            v_ContentStream.close();

            // 保存PDF文件
            v_Doc.save(i_SaveFile ,CompressParameters.DEFAULT_COMPRESSION);
            
            return true;
        }
        catch (IOException exce)
        {
            $Logger.error(exce);
        }
        finally
        {
            if ( v_ContentStream != null )
            {
                try
                {
                    v_ContentStream.close();
                }
                catch (IOException exce)
                {
                    $Logger.error(exce);
                }
                
                v_ContentStream = null;
            }
            
            if ( v_Doc != null )
            {
                try
                {
                    v_Doc.close();
                }
                catch (IOException exce)
                {
                    $Logger.error(exce);
                }
                
                v_Doc = null;
            }
        }
        
        return false;
    }
    
    
    
    /**
     * 将两个PDF文件叠加（重叠&覆盖）在一起
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-12
     * @version     v1.0
     *
     * @param i_TemplatePDF  模板PDF文件
     * @param i_DataPDF      数据PDF文件
     * @param i_SaveFile     保存路径。全路径（包含扩展名）。覆盖式保存
     * @return
     */
    public static boolean overlay(String i_TemplatePDF ,String i_DataPDF ,String i_SaveFile)
    {
        if ( Help.isNull(i_TemplatePDF) )
        {
            return false;
        }
        if ( Help.isNull(i_DataPDF) )
        {
            return false;
        }
        
        return overlay(new File(i_TemplatePDF) ,new File(i_DataPDF) ,i_SaveFile);
    }
    
    
    
    /**
     * 将两个PDF文件叠加（重叠&覆盖）在一起
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-12
     * @version     v1.0
     *
     * @param i_TemplatePDF  模板PDF文件
     * @param i_DataPDF      数据PDF文件
     * @param i_SaveFile     保存路径。全路径（包含扩展名）。覆盖式保存
     * @return
     */
    public static boolean overlay(File i_TemplatePDF ,File i_DataPDF ,String i_SaveFile)
    {
        if ( i_TemplatePDF == null || !i_TemplatePDF.exists() )
        {
            return false;
        }
        
        if ( i_DataPDF == null || !i_DataPDF.exists() )
        {
            return false;
        }
        
        Overlay    v_Overlay     = null;
        PDDocument v_SaveDoc     = null;
        PDDocument v_TemplateDoc = null;
        PDDocument v_DataDoc     = null;
        try {
            // 加载需要叠加的源文件和叠加文件
            v_TemplateDoc = Loader.loadPDF(i_TemplatePDF);
            v_DataDoc     = Loader.loadPDF(i_DataPDF);
            
            // 创建 Overlay 实例并执行叠加操作
            v_Overlay = new Overlay();
            v_Overlay.setInputPDF(v_TemplateDoc);
            v_Overlay.setOverlayPosition(Overlay.Position.FOREGROUND);
            v_Overlay.setAllPagesOverlayPDF(v_DataDoc);
            v_SaveDoc = v_Overlay.overlay(new HashMap<Integer ,String>());

            // 保存叠加后的结果文档
            v_SaveDoc.save(i_SaveFile);
            return true;
        }
        catch (Exception exce)
        {
            $Logger.error(exce);
        }
        finally
        {
            if ( v_TemplateDoc != null )
            {
                try
                {
                    v_TemplateDoc.close();
                }
                catch (IOException exce)
                {
                    $Logger.error(exce);
                }
                v_TemplateDoc = null;
            }
            
            if ( v_DataDoc != null )
            {
                try
                {
                    v_DataDoc.close();
                }
                catch (IOException exce)
                {
                    $Logger.error(exce);
                }
                v_DataDoc = null;
            }
            
            if ( v_Overlay != null )
            {
                try
                {
                    v_Overlay.close();
                }
                catch (IOException exce)
                {
                    $Logger.error(exce);
                }
                v_Overlay = null;
            }
            
            if ( v_SaveDoc != null )
            {
                try
                {
                    v_SaveDoc.close();
                }
                catch (IOException exce)
                {
                    $Logger.error(exce);
                }
                v_SaveDoc = null;
            }
        }
        
        return false;
    }
    
    
    
    private PDFHelp()
    {
        // 不允许new
    }
    
}
