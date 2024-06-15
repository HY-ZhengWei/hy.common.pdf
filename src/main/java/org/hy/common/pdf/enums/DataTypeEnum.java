package org.hy.common.pdf.enums;

import org.hy.common.pdf.common.BaseEnum;





/**
 * 数据模板中的数据类型
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-15
 * @version     v1.0
 */
public enum DataTypeEnum implements BaseEnum<String>
{
    
    TEXT("TEXT"   ,"文本数据"),
    
    IMAGE("IMAGE" ,"图片数据"),
    
    PATH("PATH"   ,"路径数据");
    
    
    
    /** 值 */
    private String value;
    
    /** 描述 */
    private String desc;
    
    
    
    /**
     * 数值转为常量
     * 
     * @author      ZhengWei(HY)
     * @createDate  2018-05-08
     * @version     v1.0
     *
     * @param i_Value
     * @return
     */
    public static DataTypeEnum get(String i_Value)
    {
        if ( i_Value == null )
        {
            return null;
        }
        
        for (DataTypeEnum v_Enum : DataTypeEnum.values())
        {
            if ( v_Enum.value.equalsIgnoreCase(i_Value.trim()) )
            {
                return v_Enum;
            }
        }
        
        return null;
    }
    
    
    
    DataTypeEnum(String i_Value ,String i_Desc)
    {
        this.value = i_Value;
        this.desc  = i_Desc;
    }

    
    
    @Override
    public String getValue()
    {
        return this.value;
    }
    
    
    
    public String getDesc()
    {
        return this.desc;
    }
    
    

    @Override
    public String toString()
    {
        return this.value;
    }
    
}
