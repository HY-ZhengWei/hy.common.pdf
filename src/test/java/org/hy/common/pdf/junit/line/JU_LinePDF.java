package org.hy.common.pdf.junit.line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hy.common.pdf.PDFHelp;
import org.hy.common.pdf.data.PDFDataTemplate;
import org.hy.common.pdf.data.type.PDFDataPath;
import org.junit.Test;





/**
 * PDF线段&表格的测试单元
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-18
 * @version     v1.0
 */
public class JU_LinePDF
{
    
    @Test
    public void createPDF_Line()
    {
        String v_PDF = "D:\\Lines.pdf";
        
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
        
        v_DataTemplates.add(new PDFDataPath("水平线1" ,100F ,500F ,1F ,"#FF0000"));
        v_DataTemplates.add(new PDFDataPath("水平线2"));
        v_DataTemplates.add(new PDFDataPath("水平线3"));
        
        v_DataTemplates.add(new PDFDataPath("垂直线1" ,"#00FF00"));
        v_DataTemplates.add(new PDFDataPath("垂直线2"));
        v_DataTemplates.add(new PDFDataPath("垂直线3"));
        
        v_DataTemplates.add(new PDFDataPath("外边框" ,2F ,"#000000"));
        
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
        
        v_Datas.put("水平线1" ,"M 50 100 H 250");
        v_Datas.put("水平线2" ,"M 50 150 H 250");
        v_Datas.put("水平线3" ,"M 50 200 H 250");
        
        v_Datas.put("垂直线1" ,"M 100 50 V 250");
        v_Datas.put("垂直线2" ,"M 150 50 V 250");
        v_Datas.put("垂直线3" ,"M 200 50 V 250");
        
        v_Datas.put("外边框"  ,"M 50 50 H 250 V 250 H 50 Z");
        
        return v_Datas;
    }
    
}
