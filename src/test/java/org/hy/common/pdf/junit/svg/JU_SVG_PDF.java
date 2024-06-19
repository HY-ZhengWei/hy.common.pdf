package org.hy.common.pdf.junit.svg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hy.common.pdf.PDFHelp;
import org.hy.common.pdf.data.PDFDataTemplate;
import org.hy.common.pdf.data.type.PDFDataPath;
import org.junit.Test;





/**
 * PDF线段&表格的测试单元：SVG图形
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-18
 * @version     v1.0
 */
public class JU_SVG_PDF
{
    
    @Test
    public void createPDF_SVG()
    {
        String v_PDF = "D:\\SVG.pdf";
        
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
        
        v_DataTemplates.add(new PDFDataPath("svgPath1" ,150F ,500F ,1F ,0.25F).setLineFillColor("#FFD73A").setLineTranslateXY(true));
        v_DataTemplates.add(new PDFDataPath("svgPath2").setLineFillColor("#873A18"));
        v_DataTemplates.add(new PDFDataPath("svgPath3").setLineFillColor("#FFFFFF"));
        v_DataTemplates.add(new PDFDataPath("svgPath4").setLineFillColor("#F44444"));
        
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
        
        v_Datas.put("svgPath1" ,"M0 512c0 282.774588 229.225412 512 512 512s512-229.225412 512-512S794.774588 0 512 0 0 229.225412 0 512z");
        v_Datas.put("svgPath2" ,"M204.8 337.92a92.16 92.16 0 1 0 184.32 0 92.16 92.16 0 0 0-184.32 0zM634.88 337.92a92.16 92.16 0 1 0 184.32 0 92.16 92.16 0 0 0-184.32 0zM512 778.24c-134.144 0-245.76-97.28-266.24-225.28A35.809882 35.809882 0 0 1 281.6 512h460.8c22.528 0 38.912 19.456 35.84 40.96-20.48 128-132.096 225.28-266.24 225.28z");
        v_Datas.put("svgPath3" ,"M742.4 512H281.6c-22.528 0-38.912 19.456-35.84 40.96 1.024 7.168 2.048 14.336 4.096 21.504H773.12c2.048-7.168 3.072-14.336 4.096-21.504 4.096-21.504-13.312-40.96-34.816-40.96z");
        v_Datas.put("svgPath4" ,"M587.776 635.904c-30.72 0-58.368 15.36-75.776 38.912a91.678118 91.678118 0 0 0-75.776-38.912 92.461176 92.461176 0 0 0-92.16 83.968A267.444706 267.444706 0 0 0 512 778.24a267.444706 267.444706 0 0 0 167.936-58.368 92.461176 92.461176 0 0 0-92.16-83.968z");
        
        return v_Datas;
    }
    
}
