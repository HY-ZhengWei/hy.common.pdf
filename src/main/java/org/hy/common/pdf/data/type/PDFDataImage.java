package org.hy.common.pdf.data.type;

import java.io.Serializable;

import org.hy.common.pdf.data.PDFDataTemplate;
import org.hy.common.pdf.enums.DataTypeEnum;





/**
 * PDF文本数据的模板。（图片类型的模板）
 * 将数据与数据格式分离，形成数据与数据模板
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-15
 * @version     v1.0
 */
public class PDFDataImage extends PDFDataTemplate<PDFDataImage> implements Serializable
{

    private static final long serialVersionUID = -3859216863957384980L;
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-15
     * @version     v1.0
     */
    public PDFDataImage()
    {
        this.setDataType(DataTypeEnum.IMAGE.getValue());
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-15
     * @version     v1.0
     * 
     * @param i_Name      模板占位符变量名称
     * @param i_X         位置 x 轴
     * @param i_Y         位置 y 轴
     */
    public PDFDataImage(String i_Name)
    {
        this(i_Name ,null ,null);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-15
     * @version     v1.0
     * 
     * @param i_Name      模板占位符变量名称
     * @param i_X         位置 x 轴
     * @param i_Y         位置 y 轴
     */
    public PDFDataImage(String i_Name ,Float i_X ,Float i_Y)
    {
        this(i_Name ,i_X ,i_Y ,null ,null ,null);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-15
     * @version     v1.0
     * 
     * @param i_Name        模板占位符变量名称
     * @param i_X           位置 x 轴
     * @param i_Y           位置 y 轴
     * @param i_ImageType   图片格式。参考 ImageTypeEnum 枚举。没有直接从图片路径中解析，原因是：网络图片路径很可能不包括扩展名
     */
    public PDFDataImage(String i_Name ,Float i_X ,Float i_Y ,String i_ImageType)
    {
        this(i_Name ,i_X ,i_Y ,null ,null ,i_ImageType);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-15
     * @version     v1.0
     * 
     * @param i_Name        模板占位符变量名称
     * @param i_X           位置 x 轴
     * @param i_Y           位置 y 轴
     * @param i_ImageWidth  图片宽度。为NULL时自动取图片原始大小
     * @param i_ImageHeight 图片高度。为NULL时自动取图片原始大小
     */
    public PDFDataImage(String i_Name ,Float i_X ,Float i_Y ,Float i_ImageWidth ,Float i_ImageHeight)
    {
        this(i_Name ,i_X ,i_Y ,null ,null ,null);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-15
     * @version     v1.0
     * 
     * @param i_Name        模板占位符变量名称
     * @param i_X           位置 x 轴
     * @param i_Y           位置 y 轴
     * @param i_ImageWidth  图片宽度。为NULL时自动取图片原始大小
     * @param i_ImageHeight 图片高度。为NULL时自动取图片原始大小
     * @param i_ImageType   图片格式。参考 ImageTypeEnum 枚举。没有直接从图片路径中解析，原因是：网络图片路径很可能不包括扩展名
     */
    public PDFDataImage(String i_Name ,Float i_X ,Float i_Y ,Float i_ImageWidth ,Float i_ImageHeight ,String i_ImageType)
    {
        super(i_Name ,i_X ,i_Y ,null ,null);
        this.setDataType(DataTypeEnum.IMAGE.getValue());
        this.setImageWidth(i_ImageWidth);
        this.setImageHeight(i_ImageHeight);
        this.setImageType(i_ImageType);
    }
    
}
