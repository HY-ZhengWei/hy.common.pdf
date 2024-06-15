package org.hy.common.pdf.junit.image;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hy.common.pdf.PDFHelp;
import org.hy.common.pdf.data.PDFDataTemplate;
import org.junit.Test;





/**
 * 图片测试单元
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-15
 * @version     v1.0
 */
public class JU_ImagePDF
{
    
    @Test
    public void createPDF_Image()
    {
        String v_PDF = "D:\\Images.pdf";
        
        PDFHelp.create(v_PDF ,makeDataTemplages() ,makeDatas());
    }
    
    
    
    /**
     * 生成PDF数据模板
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-14
     * @version     v1.0
     *
     * @return
     */
    @SuppressWarnings({"rawtypes"})
    private List<PDFDataTemplate> makeDataTemplages()
    {
        List<PDFDataTemplate> v_DataTemplates = new ArrayList<PDFDataTemplate>();
        
        v_DataTemplates.add(new PDFDataTemplate("imageLocal" ,70F ,663F).setImageType("png").setImageWidth(128F).setImageHeight(128F));
        
        return v_DataTemplates;
    }
    
    
    
    /**
     * 生成PDF数据
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-14
     * @version     v1.0
     *
     * @return
     */
    private Map<String ,Object> makeDatas()
    {
        Map<String ,Object> v_Datas = new HashMap<String ,Object>();
        
        // Company
        v_Datas.put("imageLocal" ,"D:\\WorkSpace\\hy.common.pdf\\src\\test\\java\\org\\hy\\common\\pdf\\junit\\image\\iamge01.png");
        
        return v_Datas;
    }
    
}
