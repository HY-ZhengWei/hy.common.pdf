package org.hy.common.pdf.data;

import java.io.Serializable;





/**
 * PDF文本数据的模板。
 * 将数据与数据格式分离，形成数据与数据模板。
 * 
 * 位置量x、y与相对偏移量x、y的关系说明
 *   1. 位置x有值时（不等于NULL），偏移量x无效。反之，偏移量x有效；
 *   2. 位置y有值时（不等于NULL），偏移量y无效。反之，偏移量y有效；
 * 
 *   3. 当偏移量x有值而有效时，偏移量x是对上个文本数据位置x的相对偏移。
 *   4. 当偏移量y有值而有效时，偏移量y是对上个文本数据位置y的相对偏移。
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-14
 * @version     v1.0
 */
public class PDFDataTemplate<I extends PDFDataTemplate<I>> implements Serializable
{
    
    private static final long serialVersionUID = 578154708824103744L;
    
    
    /** 数据类型（文本、图片、线段）。参考 DataTypeEnum 枚举 */
    private String dataType;
    
    /** 模板占位符变量名称 */
    private String name;
    
    /** 位置 x 轴 */
    private Float  x;
    
    /** 位置 y 轴 */
    private Float  y;
    
    /** 相对 x 轴偏移量 */
    private Float  offsetX;
    
    /** 相对 y 轴偏移量 */
    private Float  offsetY;
    
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
   
    
    
    /** 图片格式。参考 ImageTypeEnum 枚举。没有直接从图片路径中解析，原因是：网络图片路径很可能不包括扩展名 */
    private String imageType;
    
    /** 图片宽度。为NULL时自动取图片原始大小 */
    private Float  imageWidth;
    
    /** 图片高度。为NULL时自动取图片原始大小 */
    private Float  imageHeight;
    
    /** 图片宽度缩放比例 */
    private Float  imageWidthScale;
    
    /** 图片高度缩放比例 */
    private Float  imageHeightScale;
    
    
    
    /** 线段宽度 */
    private Float  lineWidth;
    
    /** 线段颜色。支持 #FFFFFF 格式的颜色 */
    private String lineColor;
    
    /** 线段填充颜色（闭合形状）。支持 #FFFFFF 格式的颜色 */
    private String lineFillColor;
    
    /**
     * 线段虚线样式。
     * 由数字组成的用英文逗号分隔。
     *   奇数位上的数字表示：实线单位占比
     *   偶数位上的数字表示：虚线单位占比
     * 
     * 格式举例：
     *   5,3       表示5单位实线，3单位空白：
     *   10,5,3,5  表示10单位实线，5单位空白，3单位实线，5单位空白
     *   空字符串   表示绘制实线
     */
    private String lineDashPattern;
    
    /** 线段路径宽度缩放比例 */
    private Float  lineWidthScale;
    
    /** 线段路径高度缩放比例 */
    private Float  lineHeightScale;
    
    /** 线段旋转角度 */
    private Float  lineRotationAngle;
    
    /** 线段旋转点的X坐标 */
    private Float  lineRotationX;
    
    /** 线段旋转点的Y坐标 */
    private Float  lineRotationY;
    
    /** 线段是否要转换坐标系（SVG坐标转PDF坐标） */
    private Boolean lineTranslateXY;
    
    
    
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
     * @param i_Name      模板占位符变量名称
     * @param i_FontName  字体名称
     */
    public PDFDataTemplate(String i_Name ,String i_FontName)
    {
        this(i_Name ,null ,null ,null ,i_FontName);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_Name      模板占位符变量名称
     * @param i_FontSize  字体大小
     */
    public PDFDataTemplate(String i_Name ,Float i_FontSize)
    {
        this(i_Name ,null ,null ,i_FontSize ,null);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_Name      模板占位符变量名称
     * @param i_FontSize  字体大小
     * @param i_FontName  字体名称
     */
    public PDFDataTemplate(String i_Name ,Float i_FontSize ,String i_FontName)
    {
        this(i_Name ,null ,null ,i_FontSize ,i_FontName);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     * 
     * @param i_Name  模板占位符变量名称
     * @param i_X     文本位置 x 轴
     * @param i_Y     文本位置 y 轴
     */
    public PDFDataTemplate(String i_Name ,Float i_X ,Float i_Y)
    {
        this(i_Name ,i_X ,i_Y ,null ,null);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_Name      模板占位符变量名称
     * @param i_X         文本位置 x 轴
     * @param i_Y         文本位置 y 轴
     * @param i_FontSize  字体大小
     */
    public PDFDataTemplate(String i_Name ,Float i_X ,Float i_Y ,Float i_FontSize)
    {
        this(i_Name ,i_X ,i_Y ,i_FontSize ,null);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_Name      模板占位符变量名称
     * @param i_X         文本位置 x 轴
     * @param i_Y         文本位置 y 轴
     * @param i_FontName  字体名称
     */
    public PDFDataTemplate(String i_Name ,Float i_X ,Float i_Y ,String i_FontName)
    {
        this(i_Name ,i_X ,i_Y ,null ,i_FontName);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @param i_Name      模板占位符变量名称
     * @param i_X         位置 x 轴
     * @param i_Y         位置 y 轴
     * @param i_FontSize  字体大小
     * @param i_FontName  字体名称
     */
    public PDFDataTemplate(String i_Name ,Float i_X ,Float i_Y ,Float i_FontSize ,String i_FontName)
    {
        this.name     = i_Name;
        this.x        = i_X;
        this.y        = i_Y;
        this.fontSize = i_FontSize;
        this.fontName = i_FontName;
    }
    
    
    /**
     * 设置偏移量
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-07-05
     * @version     v1.0
     *
     * @param i_OffsetX  相对 x 轴偏移量
     * @param i_OffsetY  相对 y 轴偏移量
     */
    public void offset(Float i_OffsetX ,Float i_OffsetY)
    {
        this.offsetX = i_OffsetX;
        this.offsetY = i_OffsetY;
    }
    
    
    
    /**
     * 获取：数据类型（文本、图片、线段）。参考 DataTypeEnum 枚举
     */
    public String getDataType()
    {
        return dataType;
    }

    
    /**
     * 设置：数据类型（文本、图片、线段）。参考 DataTypeEnum 枚举
     * 
     * @param i_DataType 数据类型（文本、图片、线段）。参考 DataTypeEnum 枚举
     */
    @SuppressWarnings("unchecked")
    public I setDataType(String i_DataType)
    {
        this.dataType = i_DataType;
        return (I) this;
    }


    /**
     * 获取：模板占位符变量名称
     */
    public String getName()
    {
        return name;
    }


    /**
     * 设置：模板占位符变量名称
     * 
     * @param i_Name 模板占位符变量名称
     */
    public void setName(String i_Name)
    {
        this.name = i_Name;
    }


    /**
     * 获取：位置 x 轴
     */
    public Float getX()
    {
        return x;
    }

    
    /**
     * 设置：位置 x 轴
     * 
     * @param i_X 位置 x 轴
     */
    @SuppressWarnings("unchecked")
    public I setX(Float i_X)
    {
        this.x = i_X;
        return (I) this;
    }

    
    /**
     * 获取：位置 y 轴
     */
    public Float getY()
    {
        return y;
    }

    
    /**
     * 设置：位置 y 轴
     * 
     * @param i_Y 位置 y 轴
     */
    @SuppressWarnings("unchecked")
    public I setY(Float i_Y)
    {
        this.y = i_Y;
        return (I) this;
    }
    
    
    /**
     * 获取：相对 x 轴偏移量
     */
    public Float getOffsetX()
    {
        return this.offsetX;
    }

    
    /**
     * 设置：相对 x 轴偏移量
     * 
     * @param i_OffsetX 相对 x 轴偏移量
     */
    @SuppressWarnings("unchecked")
    public I setOffsetX(Float i_OffsetX)
    {
        this.offsetX = i_OffsetX;
        return (I) this;
    }
    
    
    /**
     * 获取：相对 y 轴偏移量
     */
    public Float getOffsetY()
    {
        return this.offsetY;
    }
    
    
    /**
     * 设置：相对 y 轴偏移量
     * 
     * @param i_OffsetY 相对 y 轴偏移量
     */
    @SuppressWarnings("unchecked")
    public I setOffsetY(Float i_OffsetY)
    {
        this.offsetY = i_OffsetY;
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


    /**
     * 获取：图片格式。参考 ImageTypeEnum 枚举。没有直接从图片路径中解析，原因是：网络图片路径很可能不包括扩展名
     */
    public String getImageType()
    {
        return imageType;
    }

    
    /**
     * 设置：图片格式。参考 ImageTypeEnum 枚举。没有直接从图片路径中解析，原因是：网络图片路径很可能不包括扩展名
     * 
     * @param i_ImageType 图片格式。参考 ImageTypeEnum 枚举。没有直接从图片路径中解析，原因是：网络图片路径很可能不包括扩展名
     */
    @SuppressWarnings("unchecked")
    public I setImageType(String i_ImageType)
    {
        this.imageType = i_ImageType;
        return (I) this;
    }


    /**
     * 获取：图片宽度。为NULL时自动取图片原始大小
     */
    public Float getImageWidth()
    {
        return imageWidth;
    }


    /**
     * 设置：图片宽度。为NULL时自动取图片原始大小
     * 
     * @param i_ImageWidth 图片宽度
     */
    @SuppressWarnings("unchecked")
    public I setImageWidth(Float i_ImageWidth)
    {
        this.imageWidth = i_ImageWidth;
        return (I) this;
    }

    
    /**
     * 获取：图片高度。为NULL时自动取图片原始大小
     */
    public Float getImageHeight()
    {
        return imageHeight;
    }


    /**
     * 设置：图片高度。为NULL时自动取图片原始大小
     * 
     * @param i_ImageHeight 图片高度。为NULL时自动取图片原始大小
     */
    @SuppressWarnings("unchecked")
    public I setImageHeight(Float i_ImageHeight)
    {
        this.imageHeight = i_ImageHeight;
        return (I) this;
    }


    /**
     * 获取：图片宽度缩放比例
     */
    public Float getImageWidthScale()
    {
        return imageWidthScale;
    }

    
    /**
     * 设置：图片宽度缩放比例
     * 
     * @param i_ImageWidthScale 图片宽度缩放比例
     */
    @SuppressWarnings("unchecked")
    public I setImageWidthScale(Float i_ImageWidthScale)
    {
        this.imageWidthScale = i_ImageWidthScale;
        return (I) this;
    }


    /**
     * 获取：图片高度缩放比例
     */
    public Float getImageHeightScale()
    {
        return imageHeightScale;
    }


    /**
     * 设置：图片高度缩放比例
     * 
     * @param i_ImageHeightScale 图片高度缩放比例
     */
    @SuppressWarnings("unchecked")
    public I setImageHeightScale(Float i_ImageHeightScale)
    {
        this.imageHeightScale = i_ImageHeightScale;
        return (I) this;
    }

    
    /**
     * 获取：线段宽度
     */
    public Float getLineWidth()
    {
        return lineWidth;
    }

    
    /**
     * 设置：线段宽度
     * 
     * @param i_LineWidth 线段宽度
     */
    @SuppressWarnings("unchecked")
    public I setLineWidth(Float i_LineWidth)
    {
        this.lineWidth = i_LineWidth;
        return (I) this;
    }

    
    /**
     * 获取：线段颜色。支持 #FFFFFF 格式的颜色
     */
    public String getLineColor()
    {
        return lineColor;
    }

    
    /**
     * 设置：线段颜色。支持 #FFFFFF 格式的颜色
     * 
     * @param i_LineColor 线段颜色。支持 #FFFFFF 格式的颜色
     */
    @SuppressWarnings("unchecked")
    public I setLineColor(String i_LineColor)
    {
        this.lineColor = i_LineColor;
        return (I) this;
    }
    
    
    /**
     * 获取：线段填充颜色（闭合形状）。支持 #FFFFFF 格式的颜色
     */
    public String getLineFillColor()
    {
        return lineFillColor;
    }

    
    /**
     * 设置：线段填充颜色（闭合形状）。支持 #FFFFFF 格式的颜色
     * 
     * @param i_LineFillColor 线段填充颜色（闭合形状）。支持 #FFFFFF 格式的颜色
     */
    @SuppressWarnings("unchecked")
    public I setLineFillColor(String i_LineFillColor)
    {
        this.lineFillColor = i_LineFillColor;
        return (I) this;
    }


    /**
     * 获取：线段虚线样式。
     * 由数字组成的用英文逗号分隔。
     *   奇数位上的数字表示：实线单位占比
     *   偶数位上的数字表示：虚线单位占比
     * 
     * 格式举例：
     *   5,3       表示5单位实线，3单位空白：
     *   10,5,3,5  表示10单位实线，5单位空白，3单位实线，5单位空白
     *   空字符串   表示绘制实线
     */
    public String getLineDashPattern()
    {
        return lineDashPattern;
    }

    
    /**
     * 设置：线段虚线样式。
     * 由数字组成的用英文逗号分隔。
     *   奇数位上的数字表示：实线单位占比
     *   偶数位上的数字表示：虚线单位占比
     * 
     * 格式举例：
     *   5,3       表示5单位实线，3单位空白：
     *   10,5,3,5  表示10单位实线，5单位空白，3单位实线，5单位空白
     *   空字符串   表示绘制实线
     * 
     * @param i_LineDashPattern 线段虚线样式。
     */
    @SuppressWarnings("unchecked")
    public I setLineDashPattern(String i_LineDashPattern)
    {
        this.lineDashPattern = i_LineDashPattern;
        return (I) this;
    }

    
    /**
     * 获取：线段路径宽度缩放比例
     */
    public Float getLineWidthScale()
    {
        return lineWidthScale;
    }

    
    /**
     * 设置：线段路径宽度缩放比例
     * 
     * @param i_LineWidthScale 线段路径宽度缩放比例
     */
    @SuppressWarnings("unchecked")
    public I setLineWidthScale(Float i_LineWidthScale)
    {
        this.lineWidthScale = i_LineWidthScale;
        return (I) this;
    }

    
    /**
     * 获取：线段路径高度缩放比例
     */
    public Float getLineHeightScale()
    {
        return lineHeightScale;
    }

    
    /**
     * 设置：线段路径高度缩放比例
     * 
     * @param i_LineHeightScale 线段路径高度缩放比例
     */
    @SuppressWarnings("unchecked")
    public I setLineHeightScale(Float i_LineHeightScale)
    {
        this.lineHeightScale = i_LineHeightScale;
        return (I) this;
    }


    /**
     * 获取：线段旋转角度
     */
    public Float getLineRotationAngle()
    {
        return lineRotationAngle;
    }

    
    /**
     * 设置：线段旋转角度
     * 
     * @param i_LineRotationAngle 线段旋转角度
     */
    @SuppressWarnings("unchecked")
    public I setLineRotationAngle(Float i_LineRotationAngle)
    {
        this.lineRotationAngle = i_LineRotationAngle;
        return (I) this;
    }
    
    
    /**
     * 获取：线段旋转点的X坐标
     */
    public Float getLineRotationX()
    {
        return lineRotationX;
    }
    
    
    /**
     * 设置：线段旋转点的X坐标
     * 
     * @param i_LineRotationX 线段旋转点的X坐标
     */
    @SuppressWarnings("unchecked")
    public I setLineRotationX(Float i_LineRotationX)
    {
        this.lineRotationX = i_LineRotationX;
        return (I) this;
    }
    
    
    /**
     * 获取：线段旋转点的Y坐标
     */
    public Float getLineRotationY()
    {
        return lineRotationY;
    }
    
    
    /**
     * 设置：线段旋转点的Y坐标
     * 
     * @param i_LineRotationY 线段旋转点的Y坐标
     */
    @SuppressWarnings("unchecked")
    public I setLineRotationY(Float i_LineRotationY)
    {
        this.lineRotationY = i_LineRotationY;
        return (I) this;
    }

    
    /**
     * 获取：线段是否要转换坐标系（SVG坐标转PDF坐标）
     */
    public Boolean getLineTranslateXY()
    {
        return lineTranslateXY;
    }

    
    /**
     * 设置：线段是否要转换坐标系（SVG坐标转PDF坐标）
     * 
     * @param i_LineTranslateXY 线段是否要转换坐标系（SVG坐标转PDF坐标）
     */
    @SuppressWarnings("unchecked")
    public I setLineTranslateXY(Boolean i_LineTranslateXY)
    {
        this.lineTranslateXY = i_LineTranslateXY;
        return (I) this;
    }
    
}
