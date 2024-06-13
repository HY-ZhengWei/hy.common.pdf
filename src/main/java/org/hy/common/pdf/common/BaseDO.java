package org.hy.common.pdf.common;





/**
 * 通用的DO数据
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-12
 * @version     v1.0
 * @param <DO>  DO类的数据
 */
public class BaseDO
{
    
    /** 注解说明 */
    protected String comment;

    
    
    /**
     * 获取：注解说明
     */
    public String getComment()
    {
        return comment;
    }

    
    /**
     * 设置：注解说明
     * 
     * @param i_Comment 注解说明
     */
    public void setComment(String i_Comment)
    {
        this.comment = i_Comment;
    }
    
}
