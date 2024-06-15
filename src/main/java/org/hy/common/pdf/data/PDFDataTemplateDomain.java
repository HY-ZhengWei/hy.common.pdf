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
import org.hy.common.pdf.enums.DataTypeEnum;
import org.hy.common.pdf.enums.ImageTypeEnum;





/**
 * PDF文本数据模板的领域模型。
 * 将数据与数据格式分离，形成数据与数据模板
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-14
 * @version     v1.0
 */
@SuppressWarnings("rawtypes")
public class PDFDataTemplateDomain<D extends PDFDataTemplate> extends BaseDomain<D> implements Serializable
{

    private static final long serialVersionUID = -8592559297561051249L;
    
    
    
    /** 数据类型（文本、图片、线段） */
    private DataTypeEnum  dataTypeEnum;
    
    /** 字体名称的枚举类型 */
    private FontName      fontNameType;
    
    /** 字体对象 */
    private PDFont        pdFont;
    
    /** 字体颜色对象 */
    private PDColor       pdColor;
    
    /** 图片类型 */
    private ImageTypeEnum imageTypeEnum;
    
    
    
    public PDFDataTemplateDomain()
    {
        this(new PDFDataTemplate<>());
    }
    
    
    
    @SuppressWarnings("unchecked")
    public PDFDataTemplateDomain(PDFDataTemplate i_PDFDataTemplate)
    {
        this.data = (D) i_PDFDataTemplate;
        
        // 转换数据类型
        this.dataTypeEnum = DataTypeEnum.get(this.getDataType());
                
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
        
        // 转换图片类型
        this.imageTypeEnum = ImageTypeEnum.get(this.getImageType());
    }
    
    
    
    /**
     * 获取：数据类型（文本、图片、线段）
     */
    public DataTypeEnum getDataTypeEnum()
    {
        return dataTypeEnum;
    }

    
    /**
     * 设置：数据类型（文本、图片、线段）
     * 
     * @param i_DataTypeEnum 数据类型（文本、图片、线段）
     */
    public void setDataTypeEnum(DataTypeEnum i_DataTypeEnum)
    {
        this.dataTypeEnum = i_DataTypeEnum;
    }


    /**
     * 获取：数据类型（文本、图片、线段）。参考 DataTypeEnum 枚举
     */
    public String getDataType()
    {
        return this.data.getDataType();
    }

    
    /**
     * 设置：数据类型（文本、图片、线段）。参考 DataTypeEnum 枚举
     * 
     * @param i_DataType 数据类型（文本、图片、线段）。参考 DataTypeEnum 枚举
     */
    public void setDataType(String i_DataType)
    {
        this.data.setDataType(i_DataType);
    }
    
    
    /**
     * 获取：模板占位符变量名称
     */
    public String getName()
    {
        return this.data.getName();
    }


    /**
     * 设置：模板占位符变量名称
     * 
     * @param i_Name 模板占位符变量名称
     */
    public void setName(String i_Name)
    {
        this.data.setName(i_Name);
    }

    
    /**
     * 获取：位置 x 轴
     */
    public Float getX()
    {
        return this.data.getX();
    }

    
    /**
     * 设置：位置 x 轴
     * 
     * @param i_X 位置 x 轴
     */
    public void setX(Float i_X)
    {
        this.data.setX(i_X);
    }

    
    /**
     * 获取：位置 y 轴
     */
    public Float getY()
    {
        return this.data.getY();
    }

    
    /**
     * 设置：位置 y 轴
     * 
     * @param i_Y 位置 y 轴
     */
    public void setTextY(Float i_Y)
    {
        this.data.setY(i_Y);
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
    

    /**
     * 获取：图片宽度
     */
    public Float getImageWidth()
    {
        return this.data.getImageWidth();
    }
    
    
    /**
     * 获取：图片格式。没有直接从图片路径中解析，原因是：网络图片路径很可能不包括扩展名
     */
    public String getImageType()
    {
        return this.data.getImageType();
    }

    
    /**
     * 设置：图片格式。没有直接从图片路径中解析，原因是：网络图片路径很可能不包括扩展名
     * 
     * @param i_ImageType 图片格式。没有直接从图片路径中解析，原因是：网络图片路径很可能不包括扩展名
     */
    public void setImageType(String i_ImageType)
    {
        this.data.setImageType(i_ImageType);
    }

    
    /**
     * 获取：图片类型
     */
    public ImageTypeEnum getImageTypeEnum()
    {
        return imageTypeEnum;
    }

    
    /**
     * 设置：图片类型
     * 
     * @param i_ImageTypeEnum 图片类型
     */
    public void setImageTypeEnum(ImageTypeEnum i_ImageTypeEnum)
    {
        this.imageTypeEnum = i_ImageTypeEnum;
    }


    /**
     * 设置：图片宽度
     * 
     * @param i_ImageWidth 图片宽度
     */
    public void setImageWidth(Float i_ImageWidth)
    {
        this.data.setImageWidth(i_ImageWidth);
    }

    
    /**
     * 获取：图片高度
     */
    public Float getImageHeight()
    {
        return this.data.getImageHeight();
    }


    /**
     * 设置：图片高度
     * 
     * @param i_ImageHeight 图片高度
     */
    public void setImageHeight(Float i_ImageHeight)
    {
        this.data.setImageHeight(i_ImageHeight);
    }


    /**
     * 获取：图片宽度缩放比例
     */
    public Float getImageWidthScale()
    {
        return this.data.getImageWidthScale();
    }

    
    /**
     * 设置：图片宽度缩放比例
     * 
     * @param i_ImageWidthScale 图片宽度缩放比例
     */
    public void setImageWidthScale(Float i_ImageWidthScale)
    {
        this.data.setImageWidthScale(i_ImageWidthScale);
    }


    /**
     * 获取：图片高度缩放比例
     */
    public Float getImageHeightScale()
    {
        return this.data.getImageHeightScale();
    }


    /**
     * 设置：图片高度缩放比例
     * 
     * @param i_ImageHeightScale 图片高度缩放比例
     */
    public void setImageHeightScale(Float i_ImageHeightScale)
    {
        this.data.setImageHeightScale(i_ImageHeightScale);
    }
    
    
    /**
     * 获取：线段宽度
     */
    public Float getLineWidth()
    {
        return this.data.getLineWidth();
    }

    
    /**
     * 设置：线段宽度
     * 
     * @param i_LineWidth 线段宽度
     */
    public void setLineWidth(Float i_LineWidth)
    {
        this.data.setLineWidth(i_LineWidth);
    }
    
}
