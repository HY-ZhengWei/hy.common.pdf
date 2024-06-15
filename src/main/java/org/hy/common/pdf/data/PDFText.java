package org.hy.common.pdf.data;

import java.io.Serializable;





/**
 * PDF文本数据
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-12
 * @version     v1.0
 */
public class PDFText extends PDFDataTemplate<PDFText> implements Serializable
{
    
    private static final long serialVersionUID = -7056084904618985647L;

    /** 文本信息 */
    private String text;
    
    /**
     * 图片路径
     * 支持格式：JPG、JPEG、TIF、TIFF、GIF、BMP和PNG
     * 支持路径：1.本地路径的图片
     *          2.file:// 开头的图片
     *          3.http:// 开头的网络图片，支持 https:// 的网络图片
     */
    private String imagePath;
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     */
    public PDFText()
    {
        
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_Text      文本信息
     */
    public PDFText(String i_Text)
    {
        this(i_Text ,null ,null ,null ,null);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_Text      文本信息
     * @param i_FontName  字体名称
     */
    public PDFText(String i_Text ,String i_FontName)
    {
        this(i_Text ,null ,null ,null ,i_FontName);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_Text      文本信息
     * @param i_FontSize  字体大小
     */
    public PDFText(String i_Text ,Float i_FontSize)
    {
        this(i_Text ,null ,null ,i_FontSize ,null);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_Text      文本信息
     * @param i_FontSize  字体大小
     * @param i_FontName  字体名称
     */
    public PDFText(String i_Text ,Float i_FontSize ,String i_FontName)
    {
        this(i_Text ,null ,null ,i_FontSize ,i_FontName);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_Text      文本信息
     * @param i_X         位置 x 轴
     * @param i_Y         位置 y 轴
     */
    public PDFText(String i_Text ,Float i_X ,Float i_Y)
    {
        this(i_Text ,i_X ,i_Y ,null ,null);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_Text      文本信息
     * @param i_X         位置 x 轴
     * @param i_Y         位置 y 轴
     * @param i_FontSize  字体大小
     */
    public PDFText(String i_Text ,Float i_X ,Float i_Y ,Float i_FontSize)
    {
        this(i_Text ,i_X ,i_Y ,i_FontSize ,null);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_Text      文本信息
     * @param i_X         位置 x 轴
     * @param i_Y         位置 y 轴
     * @param i_FontName  字体名称
     */
    public PDFText(String i_Text ,Float i_X ,Float i_Y ,String i_FontName)
    {
        this(i_Text ,i_X ,i_Y ,null ,i_FontName);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_Text      文本信息
     * @param i_X         位置 x 轴
     * @param i_Y         位置 y 轴
     * @param i_FontSize  字体大小
     * @param i_FontName  字体名称
     */
    public PDFText(String i_Text ,Float i_X ,Float i_Y ,Float i_FontSize ,String i_FontName)
    {
        super("" ,i_X ,i_Y ,i_FontSize ,i_FontName);
        this.text = i_Text;
    }

    
    
    /**
     * 获取：文本信息
     */
    public String getText()
    {
        return text;
    }

    
    /**
     * 设置：文本信息
     * 
     * @param i_Text 文本信息
     */
    public PDFText setText(String i_Text)
    {
        this.text = i_Text;
        return this;
    }
    
    
    /**
     * 获取：图片路径
     * 
     * 支持格式：JPG、JPEG、TIF、TIFF、GIF、BMP和PNG
     * 支持路径：1.本地路径的图片
     *          2.file:// 开头的图片
     *          3.http:// 开头的网络图片，支持 https:// 的网络图片
     */
    public String getImagePath()
    {
        return imagePath;
    }


    /**
     * 设置：图片路径
     * 
     * 支持格式：JPG、JPEG、TIF、TIFF、GIF、BMP和PNG
     * 支持路径：1.本地路径的图片
     *          2.file:// 开头的图片
     *          3.http:// 开头的网络图片，支持 https:// 的网络图片
     * 
     * @param i_ImagePath 图片路径
     */
    public PDFText setImagePath(String i_ImagePath)
    {
        this.imagePath = i_ImagePath;
        return this;
    }

}
