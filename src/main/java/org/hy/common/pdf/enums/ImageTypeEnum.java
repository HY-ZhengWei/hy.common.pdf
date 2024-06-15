package org.hy.common.pdf.enums;

import org.hy.common.pdf.common.BaseEnum;





/**
 * 图片类型
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-14
 * @version     v1.0
 */
public enum ImageTypeEnum implements BaseEnum<String>
{
    
    PNG("PNG"   ,"png"),
    
    JPG("JPG"   ,"jpg"),
    
    JPEG("JPEG" ,"jpeg"),
    
    TIF("TIF"   ,"tif"),
    
    TIFF("TIFF" ,"tiff"),
    
    GIF("GIF"   ,"gif"),
    
    BMP("BMP"   ,"bmp");
    
    
    
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
    public static ImageTypeEnum get(String i_Value)
    {
        if ( i_Value == null )
        {
            return null;
        }
        
        for (ImageTypeEnum v_Enum : ImageTypeEnum.values())
        {
            if ( v_Enum.value.equalsIgnoreCase(i_Value.trim()) )
            {
                return v_Enum;
            }
        }
        
        return null;
    }
    
    
    
    ImageTypeEnum(String i_Value ,String i_Desc)
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
