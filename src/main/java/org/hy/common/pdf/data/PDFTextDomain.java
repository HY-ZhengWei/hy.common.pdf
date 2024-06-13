package org.hy.common.pdf.data;

import java.io.Serializable;

import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.hy.common.Help;
import org.hy.common.pdf.common.BaseDomain;





/**
 * PDF文本数据的领域模型
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-12
 * @version     v1.0
 */
public class PDFTextDomain extends BaseDomain<PDFText> implements Serializable
{

    private static final long serialVersionUID = 965838833191988043L;
    

    
    /** 字体名称的枚举类型 */
    private FontName fontName;
    
    /** 字体对象 */
    private PDFont   pdFont;
    
    
    
    public PDFTextDomain()
    {
        this(new PDFText());
    }
    
    
    
    public PDFTextDomain(PDFText i_PDFText)
    {
        this.data = i_PDFText;
        
        // 转换为领域模型
        if ( !Help.isNull(this.data.getFontName()) )
        {
            if ( Standard14Fonts.containsName(this.data.getFontName()) )
            {
                this.fontName = Standard14Fonts.getMappedFontName(this.data.getFontName());
                this.pdFont   = new PDType1Font(this.fontName);
            }
        }
    }

    
    
    /**
     * 获取：文本信息
     */
    public String getText()
    {
        return this.data.getText();
    }

    
    /**
     * 设置：文本信息
     * 
     * @param i_Text 文本信息
     */
    public void setText(String i_Text)
    {
        this.data.setText(i_Text);
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
    public FontName getFontName()
    {
        return fontName;
    }

    
    /**
     * 设置：字体名称的枚举类型
     * 
     * @param i_FontName 字体名称
     */
    public void setFontName(FontName i_FontName)
    {
        this.fontName = i_FontName;
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
    
}
