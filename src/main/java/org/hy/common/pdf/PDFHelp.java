package org.hy.common.pdf;

import java.awt.Shape;
import java.awt.geom.PathIterator;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.Overlay;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.hy.common.Help;
import org.hy.common.file.FileHelp;
import org.hy.common.pdf.data.PDFDataTemplate;
import org.hy.common.pdf.data.PDFDataTemplateDomain;
import org.hy.common.pdf.data.PDFText;
import org.hy.common.pdf.data.PDFTextDomain;
import org.hy.common.pdf.enums.DataTypeEnum;
import org.hy.common.pdf.enums.ImageTypeEnum;
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
     * @createDate  2024-06-14
     * @version     v1.0
     *
     * @param i_SaveFile      PDF保存路径
     * @param i_DataTemplates PDF数据样式的模板
     * @param i_Datas         PDF数据
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static boolean create(String i_SaveFile ,List<PDFDataTemplate> i_DataTemplates ,Map<String ,Object> i_Datas)
    {
        if ( Help.isNull(i_SaveFile) )
        {
            return false;
        }
        if ( Help.isNull(i_DataTemplates) )
        {
            return false;
        }
        if ( Help.isNull(i_Datas) )
        {
            return false;
        }
        
        // 创建一个空的PDF文档
        PDDocument          v_Doc           = new PDDocument();
        PDPageContentStream v_Content = null;
        boolean             v_IsClose       = false;

        try {
            // 创建页面对象
            PDPage v_Page = new PDPage();
            v_Doc.addPage(v_Page);

            // 开始在页面上写入内容
            v_Content = new PDPageContentStream(v_Doc, v_Page);
            
            PDFDataTemplateDomain v_LastStyle = new PDFDataTemplateDomain();  // 最近一次的格式
            for (PDFDataTemplate v_Item : i_DataTemplates)
            {
                PDFDataTemplateDomain v_DataTemplate = new PDFDataTemplateDomain(v_Item);
                pageContent(v_Doc ,v_Content ,v_DataTemplate ,i_Datas.get(v_DataTemplate.getName()) ,v_LastStyle);
            }
            
            v_Content.close();
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
            if ( v_Content != null && !v_IsClose )
            {
                try
                {
                    v_Content.close();
                }
                catch (IOException exce)
                {
                    $Logger.error(exce);
                }
            }
            v_Content = null;
            
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
        PDDocument          v_Doc     = new PDDocument();
        PDPageContentStream v_Content = null;
        boolean             v_IsClose = false;

        try {
            // 创建页面对象
            PDPage v_Page = new PDPage();
            v_Doc.addPage(v_Page);

            // 开始在页面上写入内容
            v_Content = new PDPageContentStream(v_Doc, v_Page);
            
            PDFTextDomain v_LastStyle = new PDFTextDomain();  // 最近一次的格式
            for (PDFText v_Item : i_Texts)
            {
                PDFTextDomain v_Text = new PDFTextDomain(v_Item);
                pageContent(v_Doc ,v_Content ,v_Text ,v_Text.getText() ,v_LastStyle);
            }
            
            v_Content.close();
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
            if ( v_Content != null && !v_IsClose )
            {
                try
                {
                    v_Content.close();
                }
                catch (IOException exce)
                {
                    $Logger.error(exce);
                }
            }
            v_Content = null;
            
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
     * @createDate  2024-06-14
     * @version     v1.0
     *
     * @param i_SaveFile      PDF保存路径
     * @param i_DataTemplates PDF数据样式的模板
     * @param i_Datas         PDF数据
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static boolean edit(File i_SaveFile ,List<PDFDataTemplate> i_DataTemplates ,Map<String ,Object> i_Datas)
    {
        if ( i_SaveFile == null || !i_SaveFile.exists() )
        {
            return false;
        }
        if ( Help.isNull(i_DataTemplates) )
        {
            return false;
        }
        if ( Help.isNull(i_Datas) )
        {
            return false;
        }
        
        // 创建一个空的PDF文档
        PDDocument          v_Doc     = null;
        PDPageContentStream v_Content = null;
        boolean             v_IsClose = false;

        try {
            v_Doc = Loader.loadPDF(i_SaveFile);
            
            // 获取页面对象
            PDPage v_Page = v_Doc.getPage(0); // 获取第一页（索引从0开始）

            // 开始在页面上写入内容
            v_Content = new PDPageContentStream(v_Doc, v_Page ,PDPageContentStream.AppendMode.APPEND, true);
            PDFDataTemplateDomain v_LastStyle = new PDFDataTemplateDomain();  // 最近一次的格式
            for (PDFDataTemplate v_Item : i_DataTemplates)
            {
                PDFDataTemplateDomain v_DataTemplate = new PDFDataTemplateDomain(v_Item);
                pageContent(v_Doc ,v_Content ,v_DataTemplate ,i_Datas.get(v_DataTemplate.getName()) ,v_LastStyle);
            }
            
            v_Content.close();
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
            if ( v_Content != null && !v_IsClose )
            {
                try
                {
                    v_Content.close();
                }
                catch (IOException exce)
                {
                    $Logger.error(exce);
                }
            }
            v_Content = null;
            
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
        PDDocument          v_Doc     = null;
        PDPageContentStream v_Content = null;
        boolean             v_IsClose = false;

        try {
            v_Doc = Loader.loadPDF(i_SaveFile);
            
            // 获取页面对象
            PDPage v_Page = v_Doc.getPage(0); // 获取第一页（索引从0开始）

            // 开始在页面上写入内容
            v_Content = new PDPageContentStream(v_Doc, v_Page ,PDPageContentStream.AppendMode.APPEND, true);
            
            PDFTextDomain v_LastStyle = new PDFTextDomain();  // 最近一次的格式
            for (PDFText v_Item : i_Texts)
            {
                PDFTextDomain v_Text = new PDFTextDomain(v_Item);
                pageContent(v_Doc ,v_Content ,v_Text ,v_Text.getText() ,v_LastStyle);
            }
            
            v_Content.close();
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
            if ( v_Content != null && !v_IsClose )
            {
                try
                {
                    v_Content.close();
                }
                catch (IOException exce)
                {
                    $Logger.error(exce);
                }
            }
            v_Content = null;
            
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
     * @createDate  2024-06-14
     * @version     v1.0
     *
     * @param io_Doc         PDF文件
     * @param io_Content     PDF页
     * @param i_DataTemplate 数据模板
     * @param i_Data         数据
     * @param io_LastStyle   最后一次的数据样式
     * @throws IOException
     */
    @SuppressWarnings("rawtypes")
    private static void pageContent(PDDocument io_Doc ,PDPageContentStream io_Content ,PDFDataTemplateDomain i_DataTemplate ,Object i_Data ,PDFDataTemplateDomain io_LastStyle) throws IOException
    {
        if ( i_Data == null )
        {
            // 数据为NULL不操作PDF
            return;
        }
        
        if ( DataTypeEnum.TEXT == i_DataTemplate.getDataTypeEnum() )
        {
            pageContentByText(io_Doc ,io_Content ,i_DataTemplate ,i_Data ,io_LastStyle);
        }
        else if ( DataTypeEnum.IMAGE == i_DataTemplate.getDataTypeEnum() )
        {
            pageContentByImage(io_Doc ,io_Content ,i_DataTemplate ,i_Data ,io_LastStyle);
        }
        else if ( DataTypeEnum.PATH == i_DataTemplate.getDataTypeEnum() )
        {
            pageContentByPath(io_Doc ,io_Content ,i_DataTemplate ,i_Data ,io_LastStyle);
        }
        // 容错判定
        else if ( !Help.isNull(i_DataTemplate.getImageType()) )
        {
            pageContentByImage(io_Doc ,io_Content ,i_DataTemplate ,i_Data ,io_LastStyle);
        }
        // 容错判定
        else if ( !Help.isNull(i_DataTemplate.getLineWidth()) )
        {
            pageContentByPath(io_Doc ,io_Content ,i_DataTemplate ,i_Data ,io_LastStyle);
        }
        else
        {
            pageContentByText(io_Doc ,io_Content ,i_DataTemplate ,i_Data ,io_LastStyle);
        }
    }
    
    
    
    /**
     * 处理PDF页内容（SVG Path对象）
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-14
     * @version     v1.0
     *
     * @param io_Doc         PDF文件
     * @param io_Content     PDF页
     * @param i_DataTemplate 数据模板
     * @param i_Data         数据
     * @param io_LastStyle   最后一次的数据样式
     * @throws IOException
     */
    @SuppressWarnings("rawtypes")
    private static void pageContentByPath(PDDocument io_Doc ,PDPageContentStream io_Content ,PDFDataTemplateDomain i_DataTemplate ,Object i_Data ,PDFDataTemplateDomain io_LastStyle) throws IOException
    {
        io_Content.setStrokingColor(0, 0, 255);   // 设置绘制颜色为蓝色
        io_Content.setLineWidth(2);               // 设置线宽

        // drawShape(io_Content, shape);

        // 执行描边操作
        io_Content.stroke();
    }
    
    
    
    private static void drawShape(PDPageContentStream io_Content, Shape i_SvgShape) throws IOException
    {
        PathIterator v_PathIterator = i_SvgShape.getPathIterator(null);
        float [] v_Coordinates = new float[6];

        while ( !v_PathIterator.isDone() )
        {
            int type = v_PathIterator.currentSegment(v_Coordinates);

            switch (type)
            {
                // 将画笔移动到指定的坐标位置
                case PathIterator.SEG_MOVETO:
                    io_Content.moveTo(v_Coordinates[0], v_Coordinates[1]);
                    break;
                    
                // 从当前点绘制一条直线到指定的坐标
                case PathIterator.SEG_LINETO:
                    io_Content.lineTo(v_Coordinates[0], v_Coordinates[1]);
                    break;
                
                // 使用两个坐标点绘制二次贝塞尔曲线
                case PathIterator.SEG_QUADTO:
                    io_Content.curveTo1(v_Coordinates[0], v_Coordinates[1], v_Coordinates[2], v_Coordinates[3]);
                    break;
                    
                // 使用三个坐标点绘制贝塞尔曲线
                case PathIterator.SEG_CUBICTO:
                    io_Content.curveTo(v_Coordinates[0], v_Coordinates[1], v_Coordinates[2], v_Coordinates[3], v_Coordinates[4], v_Coordinates[5]);
                    break;
                    
                // 关闭路径，绘制一条从当前点到起始点的直线
                case PathIterator.SEG_CLOSE:
                    io_Content.closePath();
                    break;
                    
                default:
                    throw new IllegalArgumentException("Unsupported PathIterator segment type.");
            }

            v_PathIterator.next();
        }
    }
    
    
    
    /**
     * 处理PDF页内容（图片的处理）
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-14
     * @version     v1.0
     *
     * @param io_Doc         PDF文件
     * @param io_Content     PDF页
     * @param i_DataTemplate 数据模板
     * @param i_Data         数据
     * @param io_LastStyle   最后一次的数据样式
     * @throws IOException
     */
    @SuppressWarnings("rawtypes")
    private static void pageContentByImage(PDDocument io_Doc ,PDPageContentStream io_Content ,PDFDataTemplateDomain i_DataTemplate ,Object i_Data ,PDFDataTemplateDomain io_LastStyle) throws IOException
    {
        String         v_ImagePath   = i_Data.toString();
        BufferedImage  v_ImageBuffer = FileHelp.getContentImage(v_ImagePath);
        ImageTypeEnum  v_ImageType   = i_DataTemplate.getImageTypeEnum() == null ? ImageTypeEnum.PNG : i_DataTemplate.getImageTypeEnum();
        byte []        v_ImageBytes  = FileHelp.toBytes(v_ImageBuffer ,v_ImageType.getDesc());
        PDImageXObject v_PDImage     = PDImageXObject.createFromByteArray(io_Doc ,v_ImageBytes ,v_ImagePath);
        
        Float v_Width = 0F;
        if ( i_DataTemplate.getImageWidth() != null )
        {
            v_Width = i_DataTemplate.getImageWidth();
        }
        else
        {
            v_Width = v_ImageBuffer.getWidth() * 1.0F;
        }
        if ( i_DataTemplate.getImageWidthScale() != null )
        {
            v_Width = v_Width * i_DataTemplate.getImageWidthScale();
        }
        
        Float v_Height = 0F;
        if ( i_DataTemplate.getImageHeight() != null )
        {
            v_Height = i_DataTemplate.getImageHeight();
        }
        else
        {
            v_Height = v_ImageBuffer.getHeight() * 1.0F;
        }
        if ( i_DataTemplate.getImageHeightScale() != null )
        {
            v_Height = v_Height * i_DataTemplate.getImageHeightScale();
        }
        
        io_Content.drawImage(v_PDImage ,i_DataTemplate.getX() ,i_DataTemplate.getY() ,v_Width ,v_Height);
    }
    
    
    
    /**
     * 处理PDF页内容（文本的处理）
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-14
     * @version     v1.0
     *
     * @param io_Doc         PDF文件
     * @param io_Content     PDF页
     * @param i_DataTemplate 数据模板
     * @param i_Data         数据
     * @param io_LastStyle   最后一次的数据样式
     * @throws IOException
     */
    @SuppressWarnings("rawtypes")
    private static void pageContentByText(PDDocument io_Doc ,PDPageContentStream io_Content ,PDFDataTemplateDomain i_DataTemplate ,Object i_Data ,PDFDataTemplateDomain io_LastStyle) throws IOException
    {
        // 开始写入内容
        io_Content.beginText();
        
        // 设置字体
        if ( i_DataTemplate.getPdFont() != null )
        {
            io_LastStyle.setPdFont(i_DataTemplate.getPdFont());
        }
        else if ( !Help.isNull(i_DataTemplate.getFontName()) )
        {
            // 可加载支持中文的字体
            io_LastStyle.setPdFont(PDType0Font.load(io_Doc, new File(i_DataTemplate.getFontName())));
        }
        
        // 设置字号
        if ( i_DataTemplate.getFontSize() != null )
        {
            io_LastStyle.setFontSize(i_DataTemplate.getFontSize());
        }
        if ( io_LastStyle.getFontSize() != null && io_LastStyle.getPdFont() != null )
        {
            // 延用上次的字体与字号
            io_Content.setFont(io_LastStyle.getPdFont(), io_LastStyle.getFontSize());
        }
        
        // 设置字体颜色。设置非描边颜色（即填充颜色）
        if ( i_DataTemplate.getPdColor() != null )
        {
            io_LastStyle.setPdColor(i_DataTemplate.getPdColor());
        }
        if ( io_LastStyle.getPdColor() != null )
        {
            // 延用上次的字体颜色
            io_Content.setNonStrokingColor(io_LastStyle.getPdColor());
        }
        
        // 设置字间距
        if ( i_DataTemplate.getFontSpacing() != null )
        {
            io_LastStyle.setFontSpacing(i_DataTemplate.getFontSpacing());
        }
        if ( i_DataTemplate.getFontSpacing() != null )
        {
            // 延用上次的字间距
            io_Content.setCharacterSpacing(i_DataTemplate.getFontSpacing());
        }
        
        // 设置字间距
        if ( i_DataTemplate.getWordSpacing() != null )
        {
            io_LastStyle.setWordSpacing(i_DataTemplate.getWordSpacing());
        }
        if ( i_DataTemplate.getWordSpacing() != null )
        {
            // 延用上次的字间距
            io_Content.setWordSpacing(i_DataTemplate.getWordSpacing());
        }
        
        // 设置行间距
        if ( i_DataTemplate.getLeading() != null )
        {
            io_LastStyle.setLeading(i_DataTemplate.getLeading());
        }
        if ( i_DataTemplate.getLeading() != null )
        {
            // 延用上次的行间距
            io_Content.setLeading(i_DataTemplate.getLeading());
        }
        
        // 设置文本的水平缩放比例
        if ( i_DataTemplate.getHorizontalScaling() != null )
        {
            io_LastStyle.setHorizontalScaling(i_DataTemplate.getHorizontalScaling());
        }
        if ( i_DataTemplate.getHorizontalScaling() != null )
        {
            // 延用上次的文本的水平缩放比例
            io_Content.setHorizontalScaling(i_DataTemplate.getHorizontalScaling());
        }
        
        // 设置文本的上标与下标
        if ( i_DataTemplate.getTextRise() != null )
        {
            io_LastStyle.setTextRise(i_DataTemplate.getTextRise());
        }
        if ( i_DataTemplate.getTextRise() != null )
        {
            // 延用上次的文本的上标与下标
            io_Content.setTextRise(i_DataTemplate.getTextRise());
        }
        
        // 设置文本起始位置
        if ( i_DataTemplate.getX() != null && i_DataTemplate.getY() != null )
        {
            io_Content.newLineAtOffset(i_DataTemplate.getX(), i_DataTemplate.getY());
        }
        else
        {
            io_Content.newLine();
        }
        
        // 写入文本
        io_Content.showText(i_Data.toString());
        // 结束写入内容
        io_Content.endText();
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
