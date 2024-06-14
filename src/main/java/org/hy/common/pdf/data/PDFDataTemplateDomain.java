package org.hy.common.pdf.data;

import java.awt.Color;
import java.io.Serializable;

import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.hy.common.Help;
import org.hy.common.pdf.common.BaseDomain;





/**
 * PDF文本数据模板的领域模型
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-14
 * @version     v1.0
 */
@SuppressWarnings("rawtypes")
public class PDFDataTemplateDomain<D extends PDFDataTemplate> extends BaseDomain<D> implements Serializable
{

    private static final long serialVersionUID = -8592559297561051249L;
    
    /** 字体名称的枚举类型 */
    private FontName fontNameType;
    
    /** 字体对象 */
    private PDFont   pdFont;
    
    /** 字体颜色对象 */
    private PDColor  pdColor;
    
    
    
    public PDFDataTemplateDomain()
    {
        this(new PDFDataTemplate<>());
    }
    
    
    
    @SuppressWarnings("unchecked")
    public PDFDataTemplateDomain(PDFDataTemplate i_PDFDataTemplate)
    {
        this.data = (D) i_PDFDataTemplate;
        
        // 转换字体
        if ( !Help.isNull(this.data.getFontName()) )
        {
            if ( Standard14Fonts.containsName(this.data.getFontName()) )
            {
                this.fontNameType = Standard14Fonts.getMappedFontName(this.data.getFontName());
                this.pdFont       = new PDType1Font(this.fontNameType);
            }
            else
            {
                // 自定字体在 PDFHelp 中加载
            }
        }
        
        // 转换字体颜色
        if ( !Help.isNull(this.data.getFontColor()) )
        {
            Color v_Color = Color.decode(this.data.getFontColor());
            this.pdColor = new PDColor(new float[]{v_Color.getRed() / 255F ,v_Color.getGreen() / 255F ,v_Color.getBlue() / 255F}, PDDeviceRGB.INSTANCE);
        }
    }

    
    
    /**
     * 获取：文本位置 x 轴
     */
    public Float getTextX()
    {
        return this.data.getTextX();
    }

    
    /**
     * 设置：文本位置 x 轴
     * 
     * @param i_TextX 文本位置 x 轴
     */
    public void setTextX(Float i_TextX)
    {
        this.data.setTextX(i_TextX);
    }

    
    /**
     * 获取：文本位置 y 轴
     */
    public Float getTextY()
    {
        return this.data.getTextY();
    }

    
    /**
     * 设置：文本位置 y 轴
     * 
     * @param i_TextY 文本位置 y 轴
     */
    public void setTextY(Float i_TextY)
    {
        this.data.setTextY(i_TextY);
    }

    
    /**
     * 获取：字体大小
     */
    public Float getFontSize()
    {
        return this.data.getFontSize();
    }

    
    /**
     * 设置：字体大小
     * 
     * @param i_FontSize 字体大小
     */
    public void setFontSize(Float i_FontSize)
    {
        this.data.setFontSize(i_FontSize);
    }

    
    /**
     * 获取：字体名称的枚举类型
     */
    public FontName getFontNameType()
    {
        return fontNameType;
    }

    
    /**
     * 设置：字体名称的枚举类型
     * 
     * @param i_FontNameType 字体名称
     */
    public void setFontName(FontName i_FontNameType)
    {
        this.fontNameType = i_FontNameType;
    }
    
    
    /**
     * 获取：字体名称
     */
    public String getFontName()
    {
        return this.data.getFontName();
    }

    
    /**
     * 设置：字体名称
     * 
     * @param i_FontName 字体名称
     */
    public void setFontName(String i_FontName)
    {
        this.data.setFontName(i_FontName);
    }

    
    /**
     * 获取：字体对象
     */
    public PDFont getPdFont()
    {
        return pdFont;
    }

    
    /**
     * 设置：字体对象
     * 
     * @param i_PdFont 字体对象
     */
    public void setPdFont(PDFont i_PdFont)
    {
        this.pdFont = i_PdFont;
    }
    
    
    /**
     * 获取：文本颜色
     */
    public String getFontColor()
    {
        return this.data.getFontColor();
    }

    
    /**
     * 设置：文本颜色
     * 
     * @param i_FontColor 文本颜色
     */
    public void setFontColor(String i_FontColor)
    {
        this.data.setFontColor(i_FontColor);
    }

    
    /**
     * 获取：字体颜色对象
     */
    public PDColor getPdColor()
    {
        return pdColor;
    }

    
    /**
     * 设置：字体颜色对象
     * 
     * @param i_PdColor 字体颜色对象
     */
    public void setPdColor(PDColor i_PdColor)
    {
        this.pdColor = i_PdColor;
    }
    
    
    /**
     * 获取：字间距
     */
    public Float getFontSpacing()
    {
        return this.data.getFontSpacing();
    }


    /**
     * 设置：字间距
     * 
     * @param i_FontSpacing 字间距
     */
    public void setFontSpacing(Float i_FontSpacing)
    {
        this.data.setFontSpacing(i_FontSpacing);
    }
    
    
    /**
     * 获取：行间距
     */
    public Float getLeading()
    {
        return this.data.getLeading();
    }

    
    /**
     * 设置：行间距
     * 
     * @param i_Leading 行间距
     */
    public void setLeading(Float i_Leading)
    {
        this.data.setLeading(i_Leading);
    }
    
    
    /**
     * 获取：文本的水平缩放比例
     */
    public Float getHorizontalScaling()
    {
        return this.data.getHorizontalScaling();
    }

    
    /**
     * 设置：文本的水平缩放比例
     * 
     * @param i_HorizontalScaling 文本的水平缩放比例
     */
    public void setHorizontalScaling(Float i_HorizontalScaling)
    {
        this.data.setHorizontalScaling(i_HorizontalScaling);
    }
    
    
    /**
     * 获取：文本的垂直偏移量，可实现上标与下标的功能
     */
    public Float getTextRise()
    {
        return this.data.getTextRise();
    }

    
    /**
     * 设置：文本的垂直偏移量，可实现上标与下标的功能
     * 
     * @param i_TextRise 文本的垂直偏移量，可实现上标与下标的功能
     */
    public void setTextRise(Float i_TextRise)
    {
        this.data.setTextRise(i_TextRise);
    }
    
    
    /**
     * 获取：单词间距
     */
    public Float getWordSpacing()
    {
        return this.data.getWordSpacing();
    }

    
    /**
     * 设置：单词间距
     * 
     * @param i_WordSpacing 单词间距
     */
    public void setWordSpacing(Float i_WordSpacing)
    {
        this.data.setWordSpacing(i_WordSpacing);
    }
    
}