package org.hy.common.pdf.data.type;

import java.io.Serializable;

import org.hy.common.pdf.data.PDFDataTemplate;
import org.hy.common.pdf.enums.DataTypeEnum;





/**
 * PDF文本数据的模板。（线段路径类型的模板）
 * 将数据与数据格式分离，形成数据与数据模板
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-15
 * @version     v1.0
 */
public class PDFDataPath extends PDFDataTemplate<PDFDataPath> implements Serializable
{
    
    private static final long serialVersionUID = -7398955646666845706L;



    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     */
    public PDFDataPath()
    {
        this.setDataType(DataTypeEnum.IMAGE.getValue());
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
    public PDFDataPath(String i_Name ,String i_FontName)
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
    public PDFDataPath(String i_Name ,Float i_FontSize)
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
    public PDFDataPath(String i_Name ,Float i_FontSize ,String i_FontName)
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
     * @param i_Name      模板占位符变量名称
     * @param i_X         位置 x 轴
     * @param i_Y         位置 y 轴
     */
    public PDFDataPath(String i_Name ,Float i_X ,Float i_Y)
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
     * @param i_X         位置 x 轴
     * @param i_Y         位置 y 轴
     * @param i_FontSize  字体大小
     */
    public PDFDataPath(String i_Name ,Float i_X ,Float i_Y ,Float i_FontSize)
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
     * @param i_X         位置 x 轴
     * @param i_Y         位置 y 轴
     * @param i_FontName  字体名称
     */
    public PDFDataPath(String i_Name ,Float i_X ,Float i_Y ,String i_FontName)
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
    public PDFDataPath(String i_Name ,Float i_X ,Float i_Y ,Float i_FontSize ,String i_FontName)
    {
        super(i_Name ,i_X ,i_Y ,i_FontSize ,i_FontName);
        this.setDataType(DataTypeEnum.IMAGE.getValue());
    }
    
}
