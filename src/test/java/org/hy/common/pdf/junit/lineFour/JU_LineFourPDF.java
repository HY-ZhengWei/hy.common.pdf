package org.hy.common.pdf.junit.lineFour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hy.common.pdf.PDFHelp;
import org.hy.common.pdf.data.PDFDataTemplate;
import org.hy.common.pdf.data.type.PDFDataPath;
import org.junit.Test;





/**
 * PDF线段&表格的测试单元：田字格
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-18
 * @version     v1.0
 */
public class JU_LineFourPDF
{
    
    @Test
    public void createPDF_LineFour()
    {
        String v_PDF = "D:\\LineFour.pdf";
        
        PDFHelp.create(v_PDF ,makeDataTemplages() ,makeDatas());
    }
    
    
    /**
     * 生成PDF数据模板
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-18
     * @version     v1.0
     *
     * @return
     */
    @SuppressWarnings({"rawtypes"})
    private List<PDFDataTemplate> makeDataTemplages()
    {
        List<PDFDataTemplate> v_DataTemplates = new ArrayList<PDFDataTemplate>();
        
        v_DataTemplates.add(new PDFDataPath("水平线" ,100F ,500F ,1F ,"#696969" ,"1,1"));  // 虚线
        v_DataTemplates.add(new PDFDataPath("垂直线"));
        v_DataTemplates.add(new PDFDataPath("外边框" ,2F ,"#000000" ,""));                 // 实线
        
        return v_DataTemplates;
    }
    
    
    
    /**
     * 生成PDF数据
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-18
     * @version     v1.0
     *
     * @return
     */
    private Map<String ,Object> makeDatas()
    {
        Map<String ,Object> v_Datas = new HashMap<String ,Object>();
        
        v_Datas.put("水平线" ,"M 0 50 H 100");
        v_Datas.put("垂直线" ,"M 50 0 V 100");
        v_Datas.put("外边框" ,"M 0 0 H 100 V 100 H 0 Z");
        
        return v_Datas;
    }
    
}
