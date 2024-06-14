package org.hy.common.pdf.data;

import java.io.Serializable;





/**
 * PDF文本数据的模板
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-14
 * @version     v1.0
 */
public class PDFDataTemplate<I extends PDFDataTemplate<I>> implements Serializable
{
    
    private static final long serialVersionUID = 578154708824103744L;
    
    
    /** 文本位置 x 轴 */
    private Float  textX;
    
    /** 文本位置 y 轴 */
    private Float  textY;
    
    /** 字体大小 */
    private Float  fontSize;
    
    /** 字体名称 */
    private String fontName;
    
    /** 文本颜色。支持 #FFFFFF 格式的颜色 */
    private String fontColor;
    
    /** 字间距 */
    private Float  fontSpacing;
    
    /** 单词间距 */
    private Float  wordSpacing;
    
    /** 行间距 */
    private Float  leading;
    
    /** 文本的水平缩放比例 */
    private Float  horizontalScaling;
    
    /** 文本的垂直偏移量，可实现上标与下标的功能 */
    private Float  textRise;
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     */
    public PDFDataTemplate()
    {
        
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_FontName  字体名称
     */
    public PDFDataTemplate(String i_FontName)
    {
        this(null ,null ,null ,i_FontName);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_FontSize  字体大小
     */
    public PDFDataTemplate(Float i_FontSize)
    {
        this(null ,null ,i_FontSize ,null);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_FontSize  字体大小
     * @param i_FontName  字体名称
     */
    public PDFDataTemplate(Float i_FontSize ,String i_FontName)
    {
        this(null ,null ,i_FontSize ,i_FontName);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_TextX     文本位置 x 轴
     * @param i_TextY     文本位置 y 轴
     */
    public PDFDataTemplate(Float i_TextX ,Float i_TextY)
    {
        this(i_TextX ,i_TextY ,null ,null);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_TextX     文本位置 x 轴
     * @param i_TextY     文本位置 y 轴
     * @param i_FontSize  字体大小
     */
    public PDFDataTemplate(Float i_TextX ,Float i_TextY ,Float i_FontSize)
    {
        this(i_TextX ,i_TextY ,i_FontSize ,null);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_TextX     文本位置 x 轴
     * @param i_TextY     文本位置 y 轴
     * @param i_FontName  字体名称
     */
    public PDFDataTemplate(Float i_TextX ,Float i_TextY ,String i_FontName)
    {
        this(i_TextX ,i_TextY ,null ,i_FontName);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_TextX     文本位置 x 轴
     * @param i_TextY     文本位置 y 轴
     * @param i_FontSize  字体大小
     * @param i_FontName  字体名称
     */
    public PDFDataTemplate(Float i_TextX ,Float i_TextY ,Float i_FontSize ,String i_FontName)
    {
        this.textX    = i_TextX;
        this.textY    = i_TextY;
        this.fontSize = i_FontSize;
        this.fontName = i_FontName;
    }
    
    
    
    /**
     * 获取：文本位置 x 轴
     */
    public Float getTextX()
    {
        return textX;
    }

    
    /**
     * 设置：文本位置 x 轴
     * 
     * @param i_TextX 文本位置 x 轴
     */
    @SuppressWarnings("unchecked")
    public I setTextX(Float i_TextX)
    {
        this.textX = i_TextX;
        return (I) this;
    }

    
    /**
     * 获取：文本位置 y 轴
     */
    public Float getTextY()
    {
        return textY;
    }

    
    /**
     * 设置：文本位置 y 轴
     * 
     * @param i_TextY 文本位置 y 轴
     */
    @SuppressWarnings("unchecked")
    public I setTextY(Float i_TextY)
    {
        this.textY = i_TextY;
        return (I) this;
    }

    
    /**
     * 获取：字体大小
     */
    public Float getFontSize()
    {
        return fontSize;
    }

    
    /**
     * 设置：字体大小
     * 
     * @param i_FontSize 字体大小
     */
    @SuppressWarnings({"unchecked"})
    public I setFontSize(Float i_FontSize)
    {
        this.fontSize = i_FontSize;
        return (I) this;
    }

    
    /**
     * 获取：字体名称
     */
    public String getFontName()
    {
        return fontName;
    }

    
    /**
     * 设置：字体名称
     * 
     * @param i_FontName 字体名称
     */
    @SuppressWarnings("unchecked")
    public I setFontName(String i_FontName)
    {
        this.fontName = i_FontName;
        return (I) this;
    }

    
    /**
     * 获取：文本颜色。支持 #FFFFFF 格式的颜色
     */
    public String getFontColor()
    {
        return fontColor;
    }

    
    /**
     * 设置：文本颜色
     * 
     * @param i_FontColor 文本颜色。支持 #FFFFFF 格式的颜色
     */
    @SuppressWarnings("unchecked")
    public I setFontColor(String i_FontColor)
    {
        this.fontColor = i_FontColor;
        return (I) this;
    }

    
    /**
     * 获取：字间距
     */
    public Float getFontSpacing()
    {
        return fontSpacing;
    }


    /**
     * 设置：字间距
     * 
     * @param i_FontSpacing 字间距
     */
    @SuppressWarnings("unchecked")
    public I setFontSpacing(Float i_FontSpacing)
    {
        this.fontSpacing = i_FontSpacing;
        return (I) this;
    }

    
    /**
     * 获取：行间距
     */
    public Float getLeading()
    {
        return leading;
    }

    
    /**
     * 设置：行间距
     * 
     * @param i_Leading 行间距
     */
    @SuppressWarnings("unchecked")
    public I setLeading(Float i_Leading)
    {
        this.leading = i_Leading;
        return (I) this;
    }


    /**
     * 获取：文本的水平缩放比例
     */
    public Float getHorizontalScaling()
    {
        return horizontalScaling;
    }

    
    /**
     * 设置：文本的水平缩放比例
     * 
     * @param i_HorizontalScaling 文本的水平缩放比例
     */
    @SuppressWarnings("unchecked")
    public I setHorizontalScaling(Float i_HorizontalScaling)
    {
        this.horizontalScaling = i_HorizontalScaling;
        return (I) this;
    }

    
    /**
     * 获取：文本的垂直偏移量，可实现上标与下标的功能
     */
    public Float getTextRise()
    {
        return textRise;
    }

    
    /**
     * 设置：文本的垂直偏移量，可实现上标与下标的功能
     * 
     * @param i_TextRise 文本的垂直偏移量，可实现上标与下标的功能
     */
    @SuppressWarnings("unchecked")
    public I setTextRise(Float i_TextRise)
    {
        this.textRise = i_TextRise;
        return (I) this;
    }

    
    /**
     * 获取：单词间距
     */
    public Float getWordSpacing()
    {
        return wordSpacing;
    }

    
    /**
     * 设置：单词间距
     * 
     * @param i_WordSpacing 单词间距
     */
    @SuppressWarnings("unchecked")
    public I setWordSpacing(Float i_WordSpacing)
    {
        this.wordSpacing = i_WordSpacing;
        return (I) this;
    }
    
}
