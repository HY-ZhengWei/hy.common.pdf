package org.hy.common.pdf.data;

import java.io.Serializable;





/**
 * PDF文本数据
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-12
 * @version     v1.0
 */
public class PDFText implements Serializable
{
    
    private static final long serialVersionUID = -7056084904618985647L;

    /** 文本信息 */
    private String text;
    
    /** 文本位置 x 轴 */
    private Float  textX;
    
    /** 文本位置 y 轴 */
    private Float  textY;
    
    /** 字体大小 */
    private Float  fontSize;
    
    /** 字体名称 */
    private String fontName;
    
    
    
    public PDFText()
    {
        
    }
    
    
    
    public PDFText(String i_Text)
    {
        this(i_Text ,null ,null ,null ,null);
    }
    
    
    
    public PDFText(String i_Text ,String i_FontName)
    {
        this(i_Text ,null ,null ,null ,i_FontName);
    }
    
    
    
    public PDFText(String i_Text ,Float i_FontSize)
    {
        this(i_Text ,null ,null ,i_FontSize ,null);
    }
    
    
    
    public PDFText(String i_Text ,Float i_FontSize ,String i_FontName)
    {
        this(i_Text ,null ,null ,i_FontSize ,i_FontName);
    }
    
    
    
    public PDFText(String i_Text ,Float i_TextX ,Float i_TextY)
    {
        this(i_Text ,i_TextX ,i_TextY ,null ,null);
    }
    
    
    
    public PDFText(String i_Text ,Float i_TextX ,Float i_TextY ,Float i_FontSize)
    {
        this(i_Text ,i_TextX ,i_TextY ,i_FontSize ,null);
    }
    
    
    
    public PDFText(String i_Text ,Float i_TextX ,Float i_TextY ,String i_FontName)
    {
        this(i_Text ,i_TextX ,i_TextY ,null ,i_FontName);
    }
    
    
    
    public PDFText(String i_Text ,Float i_TextX ,Float i_TextY ,Float i_FontSize ,String i_FontName)
    {
        this.text     = i_Text;
        this.textX    = i_TextX;
        this.textY    = i_TextY;
        this.fontSize = i_FontSize;
        this.fontName = i_FontName;
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
    public void setText(String i_Text)
    {
        this.text = i_Text;
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
    public void setTextX(Float i_TextX)
    {
        this.textX = i_TextX;
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
    public void setTextY(Float i_TextY)
    {
        this.textY = i_TextY;
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
    public void setFontSize(Float i_FontSize)
    {
        this.fontSize = i_FontSize;
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
    public void setFontName(String i_FontName)
    {
        this.fontName = i_FontName;
    }
    
}
