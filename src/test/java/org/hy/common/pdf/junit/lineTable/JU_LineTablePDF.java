package org.hy.common.pdf.junit.lineTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hy.common.pdf.PDFHelp;
import org.hy.common.pdf.data.PDFDataTemplate;
import org.hy.common.pdf.data.type.PDFDataPath;
import org.junit.Test;





/**
 * PDF线段&表格的测试单元：二维表格
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-18
 * @version     v1.0
 */
public class JU_LineTablePDF
{
    
    @Test
    public void createPDF_LineTable()
    {
        String v_PDF       = "D:\\LineTable.pdf";
        int    v_RowSize   = 20;   // 行数
        int    v_ColSize   = 10;   // 列数
        float  v_LRPadding = 60F;  // 表格左右留白宽度
        float  v_TBPadding = 60F;  // 表格上下留白宽度
        
        PDFHelp.create(v_PDF
                      ,makeDataTemplages(v_RowSize ,v_ColSize ,v_LRPadding ,v_TBPadding)
                      ,makeDatas(        v_RowSize ,v_ColSize ,v_LRPadding ,v_TBPadding));
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
    private List<PDFDataTemplate> makeDataTemplages(int i_RowSize ,int i_ColSize ,float i_LRPadding ,float i_TBPadding)
    {
        List<PDFDataTemplate> v_DataTemplates = new ArrayList<PDFDataTemplate>();
        
        // 水平线
        for (int x=1; x<i_RowSize; x++)
        {
            if ( x == 1 )
            {
                v_DataTemplates.add(new PDFDataPath("水平线" + x ,1F + i_LRPadding ,1F + i_TBPadding ,1F ,"#696969"));
            }
            else
            {
                v_DataTemplates.add(new PDFDataPath("水平线" + x));
            }
        }
        
        // 垂直线
        for (int y=1; y<i_ColSize; y++)
        {
            if ( y == 1 )
            {
                v_DataTemplates.add(new PDFDataPath("垂直线" + y ,1F + i_LRPadding ,1F + i_TBPadding ,1F ,"#696969"));
            }
            else
            {
                v_DataTemplates.add(new PDFDataPath("垂直线" + y));
            }
        }
        
        v_DataTemplates.add(new PDFDataPath("外边框" ,2F ,"#000000" ,""));
        
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
    private Map<String ,Object> makeDatas(int i_RowSize ,int i_ColSize ,float i_LRPadding ,float i_TBPadding)
    {
        Map<String ,Object> v_Datas = new HashMap<String ,Object>();
        float v_A4Width   = 610F - i_LRPadding * 2;          // A4纸：原点为1,1，在左下角，本机测试出来的宽是610，高是790
        float v_A4Height  = 790F - i_TBPadding * 2;
        float v_RowHeight = v_A4Height / (i_RowSize * 1F);   // 行高
        float v_ColWidth  = v_A4Width  / (i_ColSize * 1F);   // 列宽
        
        // 水平线
        for (int x=1; x<i_RowSize; x++)
        {
            float v_Y = v_RowHeight * x;
            v_Datas.put("水平线" + x ,"M 0 " + v_Y +" H " + v_A4Width);
        }
        
        // 垂直线
        for (int y=1; y<i_ColSize; y++)
        {
            float v_X = v_ColWidth * y;
            v_Datas.put("垂直线" + y ,"M " +  v_X + " 0 V " + v_A4Height);
        }
        
        v_Datas.put("外边框" ,"M 0 0 H " + v_A4Width + " V " + v_A4Height + " H 0 Z");
        
        return v_Datas;
    }
    
}
