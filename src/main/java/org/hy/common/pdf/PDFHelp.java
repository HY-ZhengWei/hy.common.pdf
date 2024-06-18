package org.hy.common.pdf;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.batik.parser.AWTPathProducer;
import org.apache.batik.parser.PathParser;
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
 * PDF 工具类
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-12
 * @version     v1.0
 */
public class PDFHelp
{
    
    private static final Logger $Logger = new Logger(PDFHelp.class);
    
    
    
    /**
     * 创建纯文本的PDF文件（内存字节流）
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-16
     * @version     v1.0
     *
     * @param i_DataTemplates PDF数据样式的模板
     * @param i_Datas         PDF数据
     * @return  异常时返回NULL。成功时返回对象，请再使用完成后释放内存。
     */
    @SuppressWarnings("rawtypes")
    public static ByteArrayOutputStream create(List<PDFDataTemplate> i_DataTemplates ,Map<String ,Object> i_Datas)
    {
        if ( Help.isNull(i_DataTemplates) )
        {
            return null;
        }
        if ( Help.isNull(i_Datas) )
        {
            return null;
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
            ByteArrayOutputStream v_SaveFile = new ByteArrayOutputStream();
            v_Doc.save(v_SaveFile ,CompressParameters.DEFAULT_COMPRESSION);
            
            return v_SaveFile;
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
        
        return null;
    }
    
    
    
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
        // 设置线段颜色
        if ( i_DataTemplate.getPdLineColor() != null )
        {
            io_LastStyle.setPdLineColor(i_DataTemplate.getPdLineColor());
            io_LastStyle.setPdLineFillColor(null);   // 填充与描边互斥
        }
        if ( io_LastStyle.getPdLineColor() != null )
        {
            // 延用上次的线段颜色
            io_Content.setStrokingColor(io_LastStyle.getPdLineColor());
        }
        
        // 设置线段填充颜色
        if ( i_DataTemplate.getPdLineFillColor() != null )
        {
            io_LastStyle.setPdLineColor(null);       // 填充与描边互斥
            io_LastStyle.setPdLineFillColor(i_DataTemplate.getPdLineFillColor());
        }
        if ( io_LastStyle.getPdLineFillColor() != null )
        {
            // 延用上次的线段填充颜色
            io_Content.setNonStrokingColor(io_LastStyle.getPdLineFillColor());
        }
        
        // 设置线段宽度
        if ( i_DataTemplate.getLineWidth() != null )
        {
            io_LastStyle.setLineWidth(i_DataTemplate.getLineWidth());
        }
        if ( io_LastStyle.getLineWidth() != null )
        {
            // 延用上次的线段宽度
            io_Content.setLineWidth(io_LastStyle.getLineWidth());
        }
        
        // 设置线段虚线样式
        if ( i_DataTemplate.getLineDashPatternArr() != null )
        {
            io_LastStyle.setLineDashPatternArr(i_DataTemplate.getLineDashPatternArr());
        }
        if ( io_LastStyle.getLineDashPatternArr() != null )
        {
            // 延用上次的线段虚线样式
            io_Content.setLineDashPattern(io_LastStyle.getLineDashPatternArr() ,0F);
        }
        
        // 设置线段路径宽度缩放比例
        float v_WidthScale = 1F;
        if ( i_DataTemplate.getLineWidthScale() != null )
        {
            io_LastStyle.setLineWidthScale(i_DataTemplate.getLineWidthScale());
        }
        if ( io_LastStyle.getLineWidthScale() != null )
        {
            // 延用上次的线段路径宽度缩放比例
            v_WidthScale = io_LastStyle.getLineWidthScale();
        }
        
        // 设置线段路径高度缩放比例
        float v_HeightScale = 1F;
        if ( i_DataTemplate.getLineHeightScale() != null )
        {
            io_LastStyle.setLineHeightScale(i_DataTemplate.getLineHeightScale());
        }
        if ( io_LastStyle.getLineHeightScale() != null )
        {
            // 延用上次的线段路径高度缩放比例
            v_HeightScale = io_LastStyle.getLineHeightScale();
        }
        
        // 设置线段原点坐标X
        float v_OriginX = 0;
        if ( i_DataTemplate.getX() != null )
        {
            io_LastStyle.setX(i_DataTemplate.getX());
        }
        if ( io_LastStyle.getX() != null )
        {
            // 延用上次的线段原点坐标X
            v_OriginX = io_LastStyle.getX();
        }
        
        // 设置线段原点坐标Y
        float v_OriginY = 0;
        if ( i_DataTemplate.getY() != null )
        {
            io_LastStyle.setY(i_DataTemplate.getY());
        }
        if ( io_LastStyle.getY() != null )
        {
            // 延用上次的线段原点坐标Y
            v_OriginY = io_LastStyle.getY();
        }

        drawShape(v_OriginX ,v_OriginY ,io_Content, parserPath(i_Data.toString() ,v_WidthScale ,v_HeightScale));

        if ( io_LastStyle.getPdLineColor() != null )
        {
            // 执行描边操作
            io_Content.stroke();
        }
        else if ( io_LastStyle.getPdLineFillColor() != null )
        {
            // 执行填充形状操作
            io_Content.fill();
        }
    }
    
    
    
    /**
     * 解释路径数据
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-18
     * @version     v1.0
     *
     * @param i_Datas
     * @param i_WidthScale
     * @param i_HeightScale
     * @return
     */
    private static Shape parserPath(String i_Datas ,float i_WidthScale ,float i_HeightScale)
    {
        AWTPathProducer v_Pandler = new AWTPathProducer();
        
        PathParser v_PathParser = new PathParser();
        v_PathParser.setPathHandler(v_Pandler);
        v_PathParser.parse(i_Datas);
        
        Shape v_Shape = v_Pandler.getShape();
        
        if ( i_WidthScale != 1F || i_HeightScale != 1F )
        {
            // 创建缩放变换
            AffineTransform transform = AffineTransform.getScaleInstance(i_WidthScale ,i_HeightScale);
            // 对路径进行缩放
            Shape v_ScaledShape = transform.createTransformedShape(v_Shape);
            return v_ScaledShape;
        }
        else
        {
            return v_Shape;
        }
    }
    
    
    
    /**
     * 绘制路径
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-18
     * @version     v1.0
     *
     * @param i_OriginX    原点坐标X
     * @param io_Content   原点坐标Y
     * @param i_SvgShape
     * @throws IOException
     */
    private static void drawShape(float i_OriginX ,float i_OriginY ,PDPageContentStream io_Content, Shape i_SvgShape) throws IOException
    {
        PathIterator v_PathIterator = i_SvgShape.getPathIterator(null);
        float []     v_Coordinates  = new float[6];

        while ( !v_PathIterator.isDone() )
        {
            int type = v_PathIterator.currentSegment(v_Coordinates);

            switch (type)
            {
                // 将画笔移动到指定的坐标位置
                case PathIterator.SEG_MOVETO:
                    io_Content.moveTo(v_Coordinates[0] + i_OriginX ,v_Coordinates[1] + i_OriginY);
                    break;
                    
                // 从当前点绘制一条直线到指定的坐标
                case PathIterator.SEG_LINETO:
                    io_Content.lineTo(v_Coordinates[0] + i_OriginX ,v_Coordinates[1] + i_OriginY);
                    break;
                
                // 使用两个坐标点绘制二次贝塞尔曲线
                case PathIterator.SEG_QUADTO:
                    io_Content.curveTo1(v_Coordinates[0] + i_OriginX ,v_Coordinates[1] + i_OriginY
                                       ,v_Coordinates[2] + i_OriginX ,v_Coordinates[3] + i_OriginY);
                    break;
                    
                // 使用三个坐标点绘制贝塞尔曲线
                case PathIterator.SEG_CUBICTO:
                    io_Content.curveTo(v_Coordinates[0] + i_OriginX ,v_Coordinates[1]  + i_OriginY
                                      ,v_Coordinates[2] + i_OriginX ,v_Coordinates[3]  + i_OriginY
                                      ,v_Coordinates[4] + i_OriginX ,v_Coordinates[5]  + i_OriginY);
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
        // 设置图片类型
        ImageTypeEnum v_ImageType = null;
        if ( i_DataTemplate.getImageTypeEnum() != null )
        {
            io_LastStyle.setImageTypeEnum(i_DataTemplate.getImageTypeEnum());
        }
        if ( io_LastStyle.getImageTypeEnum() != null )
        {
            // 延用上次的图片类型
            v_ImageType = io_LastStyle.getImageTypeEnum();
        }
        
        String         v_ImagePath   = i_Data.toString();
        BufferedImage  v_ImageBuffer = FileHelp.getContentImage(v_ImagePath);
        byte []        v_ImageBytes  = FileHelp.toBytes(v_ImageBuffer ,(v_ImageType == null ? ImageTypeEnum.PNG : v_ImageType).getDesc());
        PDImageXObject v_PDImage     = PDImageXObject.createFromByteArray(io_Doc ,v_ImageBytes ,v_ImagePath);
        
        // 图片宽度
        Float v_Width = 0F;
        if ( i_DataTemplate.getImageWidth() != null )
        {
            io_LastStyle.setImageWidth(i_DataTemplate.getImageWidth());
        }
        if ( io_LastStyle.getImageWidth() != null )
        {
            // 延用上次的图片宽度
            v_Width = io_LastStyle.getImageWidth();
        }
        else
        {
            // 否则取图片自身尺寸
            v_Width = v_ImageBuffer.getWidth() * 1.0F;
        }
        
        // 图片宽度缩放比例
        if ( i_DataTemplate.getImageWidthScale() != null )
        {
            io_LastStyle.setImageWidthScale(i_DataTemplate.getImageWidthScale());
        }
        if ( io_LastStyle.getImageWidthScale() != null )
        {
            // 延用上次的图片宽度缩放比例
            v_Width = v_Width * io_LastStyle.getImageWidthScale();
        }
        
        // 图片高度
        Float v_Height = 0F;
        if ( i_DataTemplate.getImageHeight() != null )
        {
            io_LastStyle.setImageHeight(i_DataTemplate.getImageHeight());
        }
        if ( io_LastStyle.getImageHeight() != null )
        {
            // 延用上次的图片宽度
            v_Height = io_LastStyle.getImageHeight();
        }
        else
        {
            // 否则取图片自身尺寸
            v_Height = v_ImageBuffer.getHeight() * 1.0F;
        }
        
        // 图片高度缩放比例
        if ( i_DataTemplate.getImageHeightScale() != null )
        {
            io_LastStyle.setImageHeightScale(i_DataTemplate.getImageHeightScale());
        }
        if ( io_LastStyle.getImageHeightScale() != null )
        {
            // 延用上次的图片高度缩放比例
            v_Height = v_Height * io_LastStyle.getImageHeightScale();
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
        if ( i_DataTemplate.getPdFontColor() != null )
        {
            io_LastStyle.setPdFontColor(i_DataTemplate.getPdFontColor());
        }
        if ( io_LastStyle.getPdFontColor() != null )
        {
            // 延用上次的字体颜色
            io_Content.setNonStrokingColor(io_LastStyle.getPdFontColor());
        }
        
        // 设置字间距
        if ( i_DataTemplate.getFontSpacing() != null )
        {
            io_LastStyle.setFontSpacing(i_DataTemplate.getFontSpacing());
        }
        if ( io_LastStyle.getFontSpacing() != null )
        {
            // 延用上次的字间距
            io_Content.setCharacterSpacing(io_LastStyle.getFontSpacing());
        }
        
        // 设置字间距
        if ( i_DataTemplate.getWordSpacing() != null )
        {
            io_LastStyle.setWordSpacing(i_DataTemplate.getWordSpacing());
        }
        if ( io_LastStyle.getWordSpacing() != null )
        {
            // 延用上次的字间距
            io_Content.setWordSpacing(io_LastStyle.getWordSpacing());
        }
        
        // 设置行间距
        if ( i_DataTemplate.getLeading() != null )
        {
            io_LastStyle.setLeading(i_DataTemplate.getLeading());
        }
        if ( io_LastStyle.getLeading() != null )
        {
            // 延用上次的行间距
            io_Content.setLeading(io_LastStyle.getLeading());
        }
        
        // 设置文本的水平缩放比例
        if ( i_DataTemplate.getHorizontalScaling() != null )
        {
            io_LastStyle.setHorizontalScaling(i_DataTemplate.getHorizontalScaling());
        }
        if ( io_LastStyle.getHorizontalScaling() != null )
        {
            // 延用上次的文本的水平缩放比例
            io_Content.setHorizontalScaling(io_LastStyle.getHorizontalScaling());
        }
        
        // 设置文本的上标与下标
        if ( i_DataTemplate.getTextRise() != null )
        {
            io_LastStyle.setTextRise(i_DataTemplate.getTextRise());
        }
        if ( io_LastStyle.getTextRise() != null )
        {
            // 延用上次的文本的上标与下标
            io_Content.setTextRise(io_LastStyle.getTextRise());
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
     * 将两个PDF文件叠加（重叠&覆盖）在一起（内存字节流）
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-16
     * @version     v1.0
     *
     * @param i_TemplatePDF  模板PDF文件
     * @param io_DataPDF     数据PDF文件（内存字节流）（会在方法中释放内存）
     * @return  异常时返回NULL。成功时返回对象，请再使用完成后释放内存。
     */
    public static ByteArrayOutputStream overlay(File i_TemplatePDF ,ByteArrayOutputStream io_DataPDF)
    {
        try
        {
            return overlay(i_TemplatePDF ,io_DataPDF.toByteArray());
        }
        finally
        {
            io_DataPDF.reset();
        }
    }
    
    
    
    /**
     * 将两个PDF文件叠加（重叠&覆盖）在一起（内存字节流）
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-16
     * @version     v1.0
     *
     * @param i_TemplatePDF  模板PDF文件
     * @param i_DataPDF      数据PDF文件（内存字节流）
     * @return  异常时返回NULL。成功时返回对象，请再使用完成后释放内存。
     */
    public static ByteArrayOutputStream overlay(File i_TemplatePDF ,byte[] i_DataPDF)
    {
        if ( i_TemplatePDF == null || !i_TemplatePDF.exists() )
        {
            return null;
        }
        
        if ( i_DataPDF == null || i_DataPDF.length <= 0 )
        {
            return null;
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
            ByteArrayOutputStream v_SaveFile = new ByteArrayOutputStream();
            v_SaveDoc.save(v_SaveFile ,CompressParameters.DEFAULT_COMPRESSION);
            return v_SaveFile;
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
        
        return null;
    }
    
    
    
    /**
     * 将两个PDF文件叠加（重叠&覆盖）在一起（内存字节流）
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-16
     * @version     v1.0
     *
     * @param i_TemplatePDF  模板PDF文件
     * @param i_DataPDF      数据PDF文件
     * @return  异常时返回NULL。成功时返回对象，请再使用完成后释放内存。
     */
    public static ByteArrayOutputStream overlay(File i_TemplatePDF ,File i_DataPDF)
    {
        if ( i_TemplatePDF == null || !i_TemplatePDF.exists() )
        {
            return null;
        }
        
        if ( i_DataPDF == null || !i_DataPDF.exists() )
        {
            return null;
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
            ByteArrayOutputStream v_SaveFile = new ByteArrayOutputStream();
            v_SaveDoc.save(v_SaveFile ,CompressParameters.DEFAULT_COMPRESSION);
            return v_SaveFile;
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
        
        return null;
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
     * 将两个PDF文件叠加（重叠&覆盖）在一起（内存字节流）
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-16
     * @version     v1.0
     *
     * @param i_TemplatePDF  模板PDF文件
     * @param io_DataPDF     数据PDF文件（内存字节流）（会在方法中释放内存）
     * @param i_SaveFile     保存路径。全路径（包含扩展名）。覆盖式保存
     * @return  异常时返回NULL。成功时返回对象，请再使用完成后释放内存。
     */
    public boolean overlay(File i_TemplatePDF ,ByteArrayOutputStream io_DataPDF ,String i_SaveFile)
    {
        try
        {
            return overlay(i_TemplatePDF ,io_DataPDF.toByteArray() ,i_SaveFile);
        }
        finally
        {
            io_DataPDF.reset();
        }
    }
    
    
    
    /**
     * 将两个PDF文件叠加（重叠&覆盖）在一起
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-16
     * @version     v1.0
     *
     * @param i_TemplatePDF  模板PDF文件
     * @param i_DataPDF      数据PDF文件（内存字节流）
     * @param i_SaveFile     保存路径。全路径（包含扩展名）。覆盖式保存
     * @return
     */
    public static boolean overlay(File i_TemplatePDF ,byte[] i_DataPDF ,String i_SaveFile)
    {
        if ( i_TemplatePDF == null || !i_TemplatePDF.exists() )
        {
            return false;
        }
        
        if ( i_DataPDF == null || i_DataPDF.length <= 0 )
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
            v_SaveDoc.save(i_SaveFile ,CompressParameters.DEFAULT_COMPRESSION);
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
            v_SaveDoc.save(i_SaveFile ,CompressParameters.DEFAULT_COMPRESSION);
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
