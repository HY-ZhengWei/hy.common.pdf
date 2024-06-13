package org.hy.common.pdf.junit.alipay;

import java.util.ArrayList;
import java.util.List;

import org.hy.common.pdf.PDFHelp;
import org.hy.common.pdf.data.PDFText;
import org.junit.Test;





/**
 * PDF实战案例
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-12
 * @version     v1.0
 */
public class JU_Alipay
{
    
    @Test
    public void createAlipayPDF()
    {
        String v_TemplatePDF = "D:\\WorkSpace\\hy.common.pdf\\src\\test\\java\\org\\hy\\common\\pdf\\junit\\alipay\\Template.pdf";
        String v_DataPDF     = "D:\\alipayData.pdf";
        String v_AlipayPDF   = "D:\\alipay.pdf";
        
        if ( PDFHelp.create(v_DataPDF ,makeDatas()) )
        {
            PDFHelp.overlay(v_TemplatePDF ,v_DataPDF ,v_AlipayPDF);
        }
    }
    
    
    /**
     * 生成PDF数据
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @return
     */
    private List<PDFText> makeDatas()
    {
        List<PDFText> v_Texts = new ArrayList<PDFText>();
        
        // Company
        v_Texts.add(new PDFText("China Company"                       ,70F ,663F ,12F ,"Helvetica"));
        v_Texts.add(new PDFText("Xi'an City, Shaanxi Province, China" ,70F  ,644F));
        v_Texts.add(new PDFText("Wuhan City, Hubei Province, China"   ,70F  ,624F));
        
        // Guest Details
        v_Texts.add(new PDFText("Zheng Wei"                           ,300F ,553F));
        v_Texts.add(new PDFText("HY.ZhengWei@qq.com"                  ,300F ,534F));
        
        // Booking Details
        v_Texts.add(new PDFText("1234567890"                          ,300F ,499F));
        v_Texts.add(new PDFText("Correct Hotel"                       ,300F ,481F));
        v_Texts.add(new PDFText("2024-06-13"                          ,300F ,463F));
        v_Texts.add(new PDFText("2024-06-28"                          ,300F ,444F));
        v_Texts.add(new PDFText("3"                                   ,300F ,426F));
        v_Texts.add(new PDFText("2024-04-28"                          ,300F ,408F));
        
        // Price Details
        v_Texts.add(new PDFText("CNY 500.00"                          ,300F ,374F));
        v_Texts.add(new PDFText("-CNY 50.00"                          ,300F ,356F));
        v_Texts.add(new PDFText("CNY 450.00"                          ,300F ,338F ,"Helvetica-Bold"));
        
        return v_Texts;
    }

}
