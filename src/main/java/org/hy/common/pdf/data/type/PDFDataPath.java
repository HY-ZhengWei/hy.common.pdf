package org.hy.common.pdf.data.type;

import java.io.Serializable;

import org.hy.common.pdf.data.PDFDataTemplate;
import org.hy.common.pdf.enums.DataTypeEnum;





/**
 * PDF文本数据的模板。（线段路径类型的模板）
 * 将数据与数据格式分离，形成数据与数据模板
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-18
 * @version     v1.0
 */
public class PDFDataPath extends PDFDataTemplate<PDFDataPath> implements Serializable
{
    
    private static final long serialVersionUID = -7398955646666845706L;



    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-18
     * @version     v1.0
     */
    public PDFDataPath()
    {
        this.setDataType(DataTypeEnum.PATH.getValue());
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-18
     * @version     v1.0
     *
     * @param i_Name             模板占位符变量名称
     */
    public PDFDataPath(String i_Name)
    {
        this(i_Name ,null ,null ,null ,null ,null);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-18
     * @version     v1.0
     *
     * @param i_Name             模板占位符变量名称
     * @param i_LineColor        线段颜色。支持 #FFFFFF 格式的颜色
     */
    public PDFDataPath(String i_Name ,String i_LineColor)
    {
        this(i_Name ,null ,null ,null ,i_LineColor ,null);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-18
     * @version     v1.0
     *
     * @param i_Name             模板占位符变量名称
     * @param i_LineColor        线段颜色。支持 #FFFFFF 格式的颜色
     * @param i_LineDashPattern  线段虚线样式。由数字组成的用英文逗号分隔
     */
    public PDFDataPath(String i_Name ,String i_LineColor ,String i_LineDashPattern)
    {
        this(i_Name ,null ,null ,null ,i_LineColor ,i_LineDashPattern);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-18
     * @version     v1.0
     *
     * @param i_Name             模板占位符变量名称
     * @param i_LineWidth        线段宽度
     */
    public PDFDataPath(String i_Name ,Float i_LineWidth)
    {
        this(i_Name ,null ,null ,i_LineWidth ,null ,null);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-18
     * @version     v1.0
     *
     * @param i_Name             模板占位符变量名称
     * @param i_LineWidth        线段宽度
     * @param i_LineColor        线段颜色。支持 #FFFFFF 格式的颜色
     */
    public PDFDataPath(String i_Name ,Float i_LineWidth ,String i_LineColor)
    {
        this(i_Name ,null ,null ,i_LineWidth ,i_LineColor ,null);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-18
     * @version     v1.0
     *
     * @param i_Name             模板占位符变量名称
     * @param i_LineWidth        线段宽度
     * @param i_LineColor        线段颜色。支持 #FFFFFF 格式的颜色
     * @param i_LineDashPattern  线段虚线样式。由数字组成的用英文逗号分隔
     */
    public PDFDataPath(String i_Name ,Float i_LineWidth ,String i_LineColor ,String i_LineDashPattern)
    {
        this(i_Name ,null ,null ,i_LineWidth ,i_LineColor ,i_LineDashPattern);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-18
     * @version     v1.0
     * 
     * @param i_Name             模板占位符变量名称
     * @param i_X                位置 x 轴
     * @param i_Y                位置 y 轴
     */
    public PDFDataPath(String i_Name ,Float i_X ,Float i_Y)
    {
        this(i_Name ,i_X ,i_Y ,null ,null ,null);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-18
     * @version     v1.0
     *
     * @param i_Name             模板占位符变量名称
     * @param i_X                位置 x 轴
     * @param i_Y                位置 y 轴
     * @param i_LineWidth        线段宽度
     */
    public PDFDataPath(String i_Name ,Float i_X ,Float i_Y ,Float i_LineWidth)
    {
        this(i_Name ,i_X ,i_Y ,i_LineWidth ,null ,null);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-18
     * @version     v1.0
     *
     * @param i_Name             模板占位符变量名称
     * @param i_X                位置 x 轴
     * @param i_Y                位置 y 轴
     * @param i_LineWidth        线段宽度
     * @param i_LineColor        线段颜色。支持 #FFFFFF 格式的颜色
     */
    public PDFDataPath(String i_Name ,Float i_X ,Float i_Y ,Float i_LineWidth ,String i_LineColor)
    {
        this(i_Name ,i_X ,i_Y ,i_LineWidth ,i_LineColor ,null);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-18
     * @version     v1.0
     *
     * @param i_Name             模板占位符变量名称
     * @param i_X                位置 x 轴
     * @param i_Y                位置 y 轴
     * @param i_LineColor        线段颜色。支持 #FFFFFF 格式的颜色
     */
    public PDFDataPath(String i_Name ,Float i_X ,Float i_Y ,String i_LineColor)
    {
        this(i_Name ,i_X ,i_Y ,null ,i_LineColor ,null);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-18
     * @version     v1.0
     *
     * @param i_Name             模板占位符变量名称
     * @param i_X                位置 x 轴
     * @param i_Y                位置 y 轴
     * @param i_LineColor        线段颜色。支持 #FFFFFF 格式的颜色
     * @param i_LineDashPattern  线段虚线样式。由数字组成的用英文逗号分隔
     */
    public PDFDataPath(String i_Name ,Float i_X ,Float i_Y ,String i_LineColor ,String i_LineDashPattern)
    {
        this(i_Name ,i_X ,i_Y ,null ,i_LineColor ,i_LineDashPattern);
    }
    
    
    
    /**
     * 构建器
     *
     * @author      ZhengWei(HY)
     * @createDate  2024-06-18
     * @version     v1.0
     *
     * @param i_Name             模板占位符变量名称
     * @param i_X                位置 x 轴
     * @param i_Y                位置 y 轴
     * @param i_LineWidth        线段宽度
     * @param i_LineColor        线段颜色。支持 #FFFFFF 格式的颜色
     * @param i_LineDashPattern  线段虚线样式。由数字组成的用英文逗号分隔
     */
    public PDFDataPath(String i_Name ,Float i_X ,Float i_Y ,Float i_LineWidth ,String i_LineColor ,String i_LineDashPattern)
    {
        super(i_Name ,i_X ,i_Y ,null ,null);
        this.setDataType(DataTypeEnum.PATH.getValue());
        this.setLineWidth(i_LineWidth);
        this.setLineColor(i_LineColor);
        this.setLineDashPattern(i_LineDashPattern);
    }
    
}
