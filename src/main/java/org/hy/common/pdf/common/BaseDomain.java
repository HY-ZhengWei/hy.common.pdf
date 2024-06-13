package org.hy.common.pdf.common;





/**
 * 通用的领域模型
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-12
 * @version     v1.0
 * @param <DO>  DO类的数据
 */
public class BaseDomain<DO>
{
 
    /** DO 类型的数据 */
    protected DO data;
    
    
    
    /**
     * 获取：DO 类型的数据
     */
    public DO gatData()
    {
        return data;
    }

    
    /**
     * 设置：DO 类型的数据
     * 
     * @param i_Data DO 类型的数据
     */
    public void satData(DO i_Data)
    {
        this.data = i_Data;
    }
    
}
