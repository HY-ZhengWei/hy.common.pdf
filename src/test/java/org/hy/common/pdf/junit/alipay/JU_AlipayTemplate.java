package org.hy.common.pdf.junit.alipay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hy.common.pdf.PDFHelp;
import org.hy.common.pdf.data.PDFDataTemplate;
import org.junit.Test;





/**
 * PDF实战案例
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-14
 * @version     v1.0
 */
public class JU_AlipayTemplate
{
    
    @Test
    public void createAlipayPDF()
    {
        String v_TemplatePDF = "D:\\WorkSpace\\hy.common.pdf\\src\\test\\java\\org\\hy\\common\\pdf\\junit\\alipay\\Template.pdf";
        String v_DataPDF     = "D:\\alipayData.pdf";
        String v_AlipayPDF   = "D:\\alipay.pdf";
        
        if ( PDFHelp.create(v_DataPDF ,makeDataTemplages() ,makeDatas()) )
        {
            PDFHelp.overlay(v_TemplatePDF ,v_DataPDF ,v_AlipayPDF);
        }
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
        
        // Company
        v_DataTemplates.add(new PDFDataTemplate("companyName"      ,70F  ,663F ,12F ,"D:\\WorkSpace\\hy.common.pdf\\src\\test\\java\\org\\hy\\common\\pdf\\junit\\alipay\\DENGB.TTF"));
        v_DataTemplates.add(new PDFDataTemplate("companyAddress1"  ,70F  ,644F ,"Helvetica"));
        v_DataTemplates.add(new PDFDataTemplate("companyAddress2"  ,70F  ,624F));
        
        // Guest Details
        v_DataTemplates.add(new PDFDataTemplate("name"             ,300F ,553F));
        v_DataTemplates.add(new PDFDataTemplate("emailAddress"     ,300F ,534F));
        
        // Booking Details
        v_DataTemplates.add(new PDFDataTemplate("bookingID"        ,300F ,499F));
        v_DataTemplates.add(new PDFDataTemplate("hotelName"        ,300F ,481F));
        v_DataTemplates.add(new PDFDataTemplate("checkInDate"      ,300F ,463F));
        v_DataTemplates.add(new PDFDataTemplate("checkOutDate"     ,300F ,444F));
        v_DataTemplates.add(new PDFDataTemplate("numberOfRooms"    ,300F ,426F));
        v_DataTemplates.add(new PDFDataTemplate("paymentDate"      ,300F ,408F));
        
        // Price Details
        v_DataTemplates.add(new PDFDataTemplate("totalRoomCharges" ,300F ,374F));
        v_DataTemplates.add(new PDFDataTemplate("discount"         ,300F ,356F));
        v_DataTemplates.add(new PDFDataTemplate("grandTotal"       ,300F ,338F ,"Helvetica-Bold"));
        
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
        v_Datas.put("companyName"      ,"蚂蚁科技集团股份有限公司");
        v_Datas.put("companyAddress1"  ,"Xi'an City, Shaanxi Province, China");
        v_Datas.put("companyAddress2"  ,"Wuhan City, Hubei Province, China"  );
        
        // Guest Details
        v_Datas.put("name"             ,"Zheng Wei");
        v_Datas.put("emailAddress"     ,"HY.ZhengWei@qq.com");
        
        // Booking Details
        v_Datas.put("bookingID"        ,"1234567890");
        v_Datas.put("hotelName"        ,"Correct Hotel");
        v_Datas.put("checkInDate"      ,"2024-06-13");
        v_Datas.put("checkOutDate"     ,"2024-06-28");
        v_Datas.put("numberOfRooms"    ,"5");
        v_Datas.put("paymentDate"      ,"2024-04-28");
        
        // Price Details
        v_Datas.put("totalRoomCharges" ,"CNY 500.00");
        v_Datas.put("discount"         ,"-CNY 50.00");
        v_Datas.put("grandTotal"       ,"CNY 450.00");
        
        return v_Datas;
    }
    
    
    
    @Test
    public void createAlipayRefundPDF()
    {
        String v_TemplatePDF = "D:\\WorkSpace\\hy.common.pdf\\src\\test\\java\\org\\hy\\common\\pdf\\junit\\alipay\\Template_Refund.pdf";
        String v_DataPDF     = "D:\\alipayRefundData.pdf";
        String v_AlipayPDF   = "D:\\alipayRefund.pdf";
        
        if ( PDFHelp.create(v_DataPDF ,makeDataTemplagesRefund() ,makeDatasRefund()) )
        {
            PDFHelp.overlay(v_TemplatePDF ,v_DataPDF ,v_AlipayPDF);
        }
    }
    
    
    
    /**
     * 生成PDF数据（退款的）
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-14
     * @version     v1.0
     *
     * @return
     */
    @SuppressWarnings("rawtypes")
    private List<PDFDataTemplate> makeDataTemplagesRefund()
    {
        List<PDFDataTemplate> v_DataTemplates = new ArrayList<PDFDataTemplate>();
        
        // Company
        v_DataTemplates.add(new PDFDataTemplate("companyName"      ,70F  ,663F ,12F ,"D:\\WorkSpace\\hy.common.pdf\\src\\test\\java\\org\\hy\\common\\pdf\\junit\\alipay\\DENGB.TTF"));
        v_DataTemplates.add(new PDFDataTemplate("companyAddress1"  ,70F  ,644F ,"Helvetica"));
        v_DataTemplates.add(new PDFDataTemplate("companyAddress2"  ,70F  ,624F));
        
        // Guest Details
        v_DataTemplates.add(new PDFDataTemplate("name"             ,300F ,553F));
        v_DataTemplates.add(new PDFDataTemplate("emailAddress"     ,300F ,534F));
        
        // Booking Details
        v_DataTemplates.add(new PDFDataTemplate("bookingID"        ,300F ,499F));
        v_DataTemplates.add(new PDFDataTemplate("bookingStatus"    ,300F ,481F));
        v_DataTemplates.add(new PDFDataTemplate("hotelName"        ,300F ,463F));
        v_DataTemplates.add(new PDFDataTemplate("checkInDate"      ,300F ,444F));
        v_DataTemplates.add(new PDFDataTemplate("checkOutDate"     ,300F ,426F));
        v_DataTemplates.add(new PDFDataTemplate("numberOfRooms"    ,300F ,409F));
        v_DataTemplates.add(new PDFDataTemplate("paymentDate"      ,300F ,391F));
        
        // Price Details
        v_DataTemplates.add(new PDFDataTemplate("totalRoomCharges" ,300F ,357F));
        v_DataTemplates.add(new PDFDataTemplate("discount"         ,300F ,338F));
        v_DataTemplates.add(new PDFDataTemplate("grandTotal"       ,300F ,320F ,"Helvetica-Bold"));
        
        // Refund Details
        v_DataTemplates.add(new PDFDataTemplate("refunded"         ,300F ,284.5F ,"Helvetica"));
        v_DataTemplates.add(new PDFDataTemplate("nonRefundable"    ,300F ,266F).setFontColor("#FF0000"));
        
        return v_DataTemplates;
    }
    
    
    
    /**
     * 生成PDF数据（退款的）
     * 
     * @author      ZhengWei(HY)
     * @createDate  2024-06-13
     * @version     v1.0
     *
     * @return
     */
    private Map<String ,Object> makeDatasRefund()
    {
        Map<String ,Object> v_Datas = new HashMap<String ,Object>();
        
        // Company
        v_Datas.put("companyName"      ,"蚂蚁科技集团股份有限公司");
        v_Datas.put("companyAddress1"  ,"Xi'an City, Shaanxi Province, China");
        v_Datas.put("companyAddress2"  ,"Wuhan City, Hubei Province, China"  );
        
        // Guest Details
        v_Datas.put("name"             ,"Zheng Wei");
        v_Datas.put("emailAddress"     ,"HY.ZhengWei@qq.com");
        
        // Booking Details
        v_Datas.put("bookingID"        ,"1234567890");
        v_Datas.put("bookingStatus"    ,"CANCELED");
        v_Datas.put("hotelName"        ,"Correct Hotel");
        v_Datas.put("checkInDate"      ,"2024-06-13");
        v_Datas.put("checkOutDate"     ,"2024-06-28");
        v_Datas.put("numberOfRooms"    ,"5");
        v_Datas.put("paymentDate"      ,"2024-04-28");
        
        // Price Details
        v_Datas.put("totalRoomCharges" ,"CNY 500.00");
        v_Datas.put("discount"         ,"-CNY 50.00");
        v_Datas.put("grandTotal"       ,"CNY 450.00");
        
        // Refund Details
        v_Datas.put("refunded"         ,"CNY 300.00");
        v_Datas.put("nonRefundable"    ,"CNY 150.00");
        
        return v_Datas;
    }

}