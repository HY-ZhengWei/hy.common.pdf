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
import org.apache.pdfbox.pdmodel.font.PDType0Font;
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
        boolean             v_IsClose       = false;

        try {
            // 创建页面对象
            PDPage v_Page = new PDPage();
            v_Doc.addPage(v_Page);

            // 开始在页面上写入内容
            v_ContentStream = new PDPageContentStream(v_Doc, v_Page);
            pageContent(v_Doc ,v_ContentStream ,i_Texts);
            
            v_ContentStream.close();
            v_IsClose = true;

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
            if ( v_ContentStream != null && !v_IsClose )
            {
                try
                {
                    v_ContentStream.close();
                }
                catch (IOException exce)
                {
                    $Logger.error(exce);
                }
            }
            v_ContentStream = null;
            
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
     * 修改PDF文件。很可能造成原文件上的图片丢失
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_SaveFile  PDF保存路径
     * @param i_Texts     PDF数据
     * @return
     */
    public static boolean edit(File i_SaveFile ,List<PDFText> i_Texts)
    {
        if ( i_SaveFile == null || !i_SaveFile.exists() )
        {
            return false;
        }
        if ( Help.isNull(i_Texts) )
        {
            return false;
        }
        
        // 创建一个空的PDF文档
        PDDocument          v_Doc           = null;
        PDPageContentStream v_ContentStream = null;
        boolean             v_IsClose       = false;

        try {
            v_Doc = Loader.loadPDF(i_SaveFile);
            
            // 获取页面对象
            PDPage v_Page = v_Doc.getPage(0); // 获取第一页（索引从0开始）

            // 开始在页面上写入内容
            v_ContentStream = new PDPageContentStream(v_Doc, v_Page ,PDPageContentStream.AppendMode.APPEND, true);
            pageContent(v_Doc ,v_ContentStream ,i_Texts);
            
            v_ContentStream.close();
            v_IsClose = true;

            // 保存PDF文件
            v_Doc.save(i_SaveFile);
            
            return true;
        }
        catch (IOException exce)
        {
            $Logger.error(exce);
        }
        finally
        {
            if ( v_ContentStream != null && !v_IsClose )
            {
                try
                {
                    v_ContentStream.close();
                }
                catch (IOException exce)
                {
                    $Logger.error(exce);
                }
            }
            v_ContentStream = null;
            
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
     * 处理PDF页内容
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param io_Doc            PDF文件
     * @param io_ContentStream  PDF页
     * @param i_Texts           文本数据
     * @throws IOException
     */
    private static void pageContent(PDDocument io_Doc ,PDPageContentStream io_ContentStream ,List<PDFText> i_Texts) throws IOException
    {
        PDFTextDomain v_LastFormat = new PDFTextDomain();  // 最近一次的格式
        for (PDFText v_Text : i_Texts)
        {
            PDFTextDomain v_TextDomain = new PDFTextDomain(v_Text);
            
            // 开始写入内容
            io_ContentStream.beginText();
            
            // 设置字体
            if ( v_TextDomain.getPdFont() != null )
            {
                v_LastFormat.setPdFont(v_TextDomain.getPdFont());
            }
            else if ( !Help.isNull(v_TextDomain.getFontName()) )
            {
                // 可加载支持中文的字体
                v_LastFormat.setPdFont(PDType0Font.load(io_Doc, new File(v_TextDomain.getFontName())));
            }
            
            // 设置字号
            if ( v_TextDomain.getFontSize() != null )
            {
                v_LastFormat.setFontSize(v_TextDomain.getFontSize());
            }
            if ( v_LastFormat.getFontSize() != null && v_LastFormat.getPdFont() != null )
            {
                // 延用上次的字体与字号
                io_ContentStream.setFont(v_LastFormat.getPdFont(), v_LastFormat.getFontSize());
            }
            
            // 设置字体颜色。设置非描边颜色（即填充颜色）
            if ( v_TextDomain.getPdColor() != null )
            {
                v_LastFormat.setPdColor(v_TextDomain.getPdColor());
            }
            if ( v_LastFormat.getPdColor() != null )
            {
                // 延用上次的字体颜色
                io_ContentStream.setNonStrokingColor(v_LastFormat.getPdColor());
            }
            
            // 设置字间距
            if ( v_TextDomain.getFontSpacing() != null )
            {
                v_LastFormat.setFontSpacing(v_TextDomain.getFontSpacing());
            }
            if ( v_TextDomain.getFontSpacing() != null )
            {
                // 延用上次的字间距
                io_ContentStream.setCharacterSpacing(v_TextDomain.getFontSpacing());
            }
            
            // 设置行间距
            if ( v_TextDomain.getLeading() != null )
            {
                v_LastFormat.setLeading(v_TextDomain.getLeading());
            }
            if ( v_TextDomain.getLeading() != null )
            {
                // 延用上次的行间距
                io_ContentStream.setLeading(v_TextDomain.getLeading());
            }
            
            // 设置文本起始位置
            if ( v_TextDomain.getTextX() != null && v_TextDomain.getTextY() != null )
            {
                io_ContentStream.newLineAtOffset(v_TextDomain.getTextX(), v_TextDomain.getTextY());
            }
            else
            {
                io_ContentStream.newLine();
            }
            
            // 写入文本
            io_ContentStream.showText(v_TextDomain.getText());
            // 结束写入内容
            io_ContentStream.endText();
        }
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
