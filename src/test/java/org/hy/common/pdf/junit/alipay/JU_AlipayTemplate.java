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
        String v_FontNormal = "D:\\WorkSpace\\hy.common.pdf\\src\\test\\java\\org\\hy\\common\\pdf\\junit\\alipay\\PingFangHK-Regular-19.ttf";
        String v_FontBlod   = "D:\\WorkSpace\\hy.common.pdf\\src\\test\\java\\org\\hy\\common\\pdf\\junit\\alipay\\PingFang-Bold-1.ttf";
        
        // Company
        v_DataTemplates.add(new PDFDataTemplate("companyName"           ,70F  ,663F ,12F ,v_FontNormal));
        v_DataTemplates.add(new PDFDataTemplate("companyAddress1"       ,70F  ,644F));
        v_DataTemplates.add(new PDFDataTemplate("companyAddress2"       ,70F  ,624F));
        
        // Guest Details
        v_DataTemplates.add(new PDFDataTemplate("name"                  ,300F ,553F));
        v_DataTemplates.add(new PDFDataTemplate("emailAddress"          ,300F ,534F));
                                                                        
        // Booking Details
        v_DataTemplates.add(new PDFDataTemplate("bookingID"             ,300F ,499F));
        v_DataTemplates.add(new PDFDataTemplate("hotelName"             ,300F ,481F));
        v_DataTemplates.add(new PDFDataTemplate("checkInDate"           ,300F ,463F));
        v_DataTemplates.add(new PDFDataTemplate("checkOutDate"          ,300F ,444F));
        v_DataTemplates.add(new PDFDataTemplate("numberOfRooms"         ,300F ,426F));
        v_DataTemplates.add(new PDFDataTemplate("paymentDate"           ,300F ,409F));
                                                                        
        // Price Details
        v_DataTemplates.add(new PDFDataTemplate("totalRoomCharges"      ,300F ,356F));
        v_DataTemplates.add(new PDFDataTemplate("vat"                   ,300F ,319F));
        v_DataTemplates.add(new PDFDataTemplate("serviceFee"            ,300F ,302F));
        v_DataTemplates.add(new PDFDataTemplate("surcharge"             ,300F ,283F));
        v_DataTemplates.add(new PDFDataTemplate("discount"              ,300F ,266F));
        v_DataTemplates.add(new PDFDataTemplate("grandTotal"            ,300F ,248F ,v_FontBlod));
        
        // Title
        v_DataTemplates.add(new PDFDataTemplate("titleName"             ,64F  ,553F ,v_FontNormal));
        v_DataTemplates.add(new PDFDataTemplate("titleEmail"            ,64F  ,534F));
        v_DataTemplates.add(new PDFDataTemplate("titleBookingID"        ,64F  ,499F));
        v_DataTemplates.add(new PDFDataTemplate("titleHotelName"        ,64F  ,481F));
        v_DataTemplates.add(new PDFDataTemplate("titleCheckIn"          ,64F  ,463F));
        v_DataTemplates.add(new PDFDataTemplate("titleCheckOut"         ,64F  ,444F));
        v_DataTemplates.add(new PDFDataTemplate("titleNumberofRooms"    ,64F  ,426F));
        v_DataTemplates.add(new PDFDataTemplate("titlePaymentDate"      ,64F  ,409F));
        
        // Title Price
        v_DataTemplates.add(new PDFDataTemplate("titleRoomType"         ,64F  ,374F));
        v_DataTemplates.add(new PDFDataTemplate("titleTotalRoomCharges" ,64F  ,356F));
        v_DataTemplates.add(new PDFDataTemplate("titleFaxesFees"        ,64F  ,337F));
        v_DataTemplates.add(new PDFDataTemplate("titleVAT"              ,80F  ,319F));
        v_DataTemplates.add(new PDFDataTemplate("titleServiceFee"       ,80F  ,302F));
        v_DataTemplates.add(new PDFDataTemplate("titleSurcharge"        ,80F  ,283F));
        v_DataTemplates.add(new PDFDataTemplate("titleDiscount"         ,64F  ,266F));
        v_DataTemplates.add(new PDFDataTemplate("titleGrandTotal"       ,64F  ,248F));
        v_DataTemplates.add(new PDFDataTemplate("titleHint"             ,64F  ,215F ,9F));
        
        // Main Title
        v_DataTemplates.add(new PDFDataTemplate("titleEReceipt"         ,270F ,588F ,12F ,v_FontBlod));
        v_DataTemplates.add(new PDFDataTemplate("titleGuestDetails"     ,256F ,570F).setFontColor("#FFFFFF"));
        v_DataTemplates.add(new PDFDataTemplate("titleBookingDetails"   ,250F ,517F));
        v_DataTemplates.add(new PDFDataTemplate("titlePriceDetails"     ,130F ,392F));
        v_DataTemplates.add(new PDFDataTemplate("titleAmount"           ,400F ,392F));
        
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
        v_Datas.put("companyName"           ,"蚂蚁科技集团股份有限公司");
        v_Datas.put("companyAddress1"       ,"Xi'an City, Shaanxi Province, China");
        v_Datas.put("companyAddress2"       ,"Wuhan City, Hubei Province, China"  );
                                            
        // Guest Details
        v_Datas.put("name"                  ,"Zheng Wei 鄭偉");
        v_Datas.put("emailAddress"          ,"HY.ZhengWei@qq.com");
                                            
        // Booking Details
        v_Datas.put("bookingID"             ,"1234567890");
        v_Datas.put("hotelName"             ,"Correct Hotel");
        v_Datas.put("checkInDate"           ,"2024-06-13");
        v_Datas.put("checkOutDate"          ,"2024-06-28");
        v_Datas.put("numberOfRooms"         ,"5");
        v_Datas.put("paymentDate"           ,"2024-04-28");
                                            
        // Price Details
        v_Datas.put("totalRoomCharges"      ,"CNY 500.00");
        v_Datas.put("vat"                   ,"CNY 10.00");
        v_Datas.put("serviceFee"            ,"CNY 20.00");
        v_Datas.put("surcharge"             ,"CNY 30.00");
        v_Datas.put("discount"              ,"-CNY 40.00");
        v_Datas.put("grandTotal"            ,"CNY 520.00");
                                            
        // Title
        v_Datas.put("titleName"             ,"Name:");
        v_Datas.put("titleEmail"            ,"Email Address:");
        v_Datas.put("titleBookingID"        ,"Booking ID:");
        v_Datas.put("titleHotelName"        ,"Hotel Name:");
        v_Datas.put("titleCheckIn"          ,"Check-in Date:");
        v_Datas.put("titleCheckOut"         ,"Check-out Date:");
        v_Datas.put("titleNumberofRooms"    ,"Number of Room(s):");
        v_Datas.put("titlePaymentDate"      ,"Payment Date:");
        
        // Title Price
        v_Datas.put("titleRoomType"         ,"Room Type");
        v_Datas.put("titleTotalRoomCharges" ,"1 room(s) x 1 nights:");
        v_Datas.put("titleFaxesFees"        ,"Taxes & Fees:");
        v_Datas.put("titleVAT"              ,"VAT");
        v_Datas.put("titleServiceFee"       ,"Service Fee");
        v_Datas.put("titleSurcharge"        ,"Surcharge");
        v_Datas.put("titleDiscount"         ,"Special Discount:");
        v_Datas.put("titleGrandTotal"       ,"Grand Total(Paid via TNG eWallet)");
        v_Datas.put("titleHint"             ,"This receipt is auto generated and no signature required.");
        
        // Main Title
        v_Datas.put("titleEReceipt"         ,"E-Receipt");
        v_Datas.put("titleGuestDetails"     ,"Guest Details");
        v_Datas.put("titleBookingDetails"   ,"Booking Details");
        v_Datas.put("titlePriceDetails"     ,"Price Details");
        v_Datas.put("titleAmount"           ,"Amount");
        
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
        String v_FontNormal = "D:\\WorkSpace\\hy.common.pdf\\src\\test\\java\\org\\hy\\common\\pdf\\junit\\alipay\\PingFangHK-Regular-19.ttf";
        String v_FontBlod   = "D:\\WorkSpace\\hy.common.pdf\\src\\test\\java\\org\\hy\\common\\pdf\\junit\\alipay\\PingFang-Bold-1.ttf";
        
        
        // Company
        v_DataTemplates.add(new PDFDataTemplate("companyName"           ,70F  ,663F ,12F ,v_FontNormal));
        v_DataTemplates.add(new PDFDataTemplate("companyAddress1"       ,70F  ,644F));
        v_DataTemplates.add(new PDFDataTemplate("companyAddress2"       ,70F  ,624F));
                                                                        
        // Guest Details
        v_DataTemplates.add(new PDFDataTemplate("name"                  ,300F ,553F));
        v_DataTemplates.add(new PDFDataTemplate("emailAddress"          ,300F ,534F));
                                                                        
        // Booking Details
        v_DataTemplates.add(new PDFDataTemplate("bookingID"             ,300F ,499F));
        v_DataTemplates.add(new PDFDataTemplate("hotelName"             ,300F ,481F));
        v_DataTemplates.add(new PDFDataTemplate("checkInDate"           ,300F ,463F));
        v_DataTemplates.add(new PDFDataTemplate("checkOutDate"          ,300F ,444F));
        v_DataTemplates.add(new PDFDataTemplate("numberOfRooms"         ,300F ,426F));
        v_DataTemplates.add(new PDFDataTemplate("paymentDate"           ,300F ,409F));
                                                                        
        // Price Details
        v_DataTemplates.add(new PDFDataTemplate("totalRoomCharges"      ,300F ,356F));
        v_DataTemplates.add(new PDFDataTemplate("vat"                   ,300F ,338F));
        v_DataTemplates.add(new PDFDataTemplate("serviceFee"            ,300F ,301F));
        v_DataTemplates.add(new PDFDataTemplate("surcharge"             ,300F ,283F));
        v_DataTemplates.add(new PDFDataTemplate("discount"              ,300F ,265F));
        v_DataTemplates.add(new PDFDataTemplate("grandTotal"            ,300F ,247.5F ,v_FontBlod));
                                                                        
        // Refund Details
        v_DataTemplates.add(new PDFDataTemplate("refunded"              ,300F ,213F ,v_FontNormal));
        v_DataTemplates.add(new PDFDataTemplate("nonRefundable"         ,300F ,194F).setFontColor("#FF0000"));
        
        // Title
        v_DataTemplates.add(new PDFDataTemplate("titleName"             ,64F  ,553F ,v_FontNormal).setFontColor("#000000"));
        v_DataTemplates.add(new PDFDataTemplate("titleEmail"            ,64F  ,534F));
        v_DataTemplates.add(new PDFDataTemplate("titleBookingID"        ,64F  ,499F));
        v_DataTemplates.add(new PDFDataTemplate("titleHotelName"        ,64F  ,481F));
        v_DataTemplates.add(new PDFDataTemplate("titleCheckIn"          ,64F  ,463F));
        v_DataTemplates.add(new PDFDataTemplate("titleCheckOut"         ,64F  ,444F));
        v_DataTemplates.add(new PDFDataTemplate("titleNumberofRooms"    ,64F  ,426F));
        v_DataTemplates.add(new PDFDataTemplate("titlePaymentDate"      ,64F  ,409F));
        
        // Title Price
        v_DataTemplates.add(new PDFDataTemplate("titleRoomType"         ,64F  ,374F));
        v_DataTemplates.add(new PDFDataTemplate("titleTotalRoomCharges" ,64F  ,356F));
        v_DataTemplates.add(new PDFDataTemplate("titleFaxesFees"        ,64F  ,337F));
        v_DataTemplates.add(new PDFDataTemplate("titleVAT"              ,80F  ,319F));
        v_DataTemplates.add(new PDFDataTemplate("titleServiceFee"       ,80F  ,302F));
        v_DataTemplates.add(new PDFDataTemplate("titleSurcharge"        ,80F  ,283F));
        v_DataTemplates.add(new PDFDataTemplate("titleDiscount"         ,64F  ,266F));
        v_DataTemplates.add(new PDFDataTemplate("titleGrandTotal"       ,64F  ,248F));
        
        // Title Price Refund
        v_DataTemplates.add(new PDFDataTemplate("titleRefunded"         ,64F  ,213F));
        v_DataTemplates.add(new PDFDataTemplate("titleNonRefundable"    ,64F  ,194F));
        v_DataTemplates.add(new PDFDataTemplate("titleHint"             ,64F  ,165F ,9F));
        
        // Main Title
        v_DataTemplates.add(new PDFDataTemplate("titleEReceipt"         ,270F ,588F ,12F ,v_FontBlod));
        v_DataTemplates.add(new PDFDataTemplate("titleGuestDetails"     ,256F ,570F).setFontColor("#FFFFFF"));
        v_DataTemplates.add(new PDFDataTemplate("titleBookingDetails"   ,250F ,517F));
        v_DataTemplates.add(new PDFDataTemplate("titlePriceDetails"     ,130F ,391.5F));
        v_DataTemplates.add(new PDFDataTemplate("titleAmount"           ,400F ,391.5F));
        v_DataTemplates.add(new PDFDataTemplate("titleRefundDetails"    ,128F ,231F));
        v_DataTemplates.add(new PDFDataTemplate("titleRefundAmount"     ,400F ,231F));
        
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
        v_Datas.put("name"             ,"Zheng Wei 鄭偉");
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
        v_Datas.put("vat"              ,"CNY 10.00");
        v_Datas.put("serviceFee"       ,"CNY 20.00");
        v_Datas.put("surcharge"        ,"CNY 30.00");
        v_Datas.put("discount"         ,"-CNY 40.00");
        v_Datas.put("grandTotal"       ,"CNY 520.00");
        
        // Refund Details
        v_Datas.put("refunded"         ,"CNY 320.00");
        v_Datas.put("nonRefundable"    ,"CNY 200.00");
        
        // Title
        v_Datas.put("titleName"             ,"Name:");
        v_Datas.put("titleEmail"            ,"Email Address:");
        v_Datas.put("titleBookingID"        ,"Booking ID:");
        v_Datas.put("titleHotelName"        ,"Hotel Name:");
        v_Datas.put("titleCheckIn"          ,"Check-in Date:");
        v_Datas.put("titleCheckOut"         ,"Check-out Date:");
        v_Datas.put("titleNumberofRooms"    ,"Number of Room(s):");
        v_Datas.put("titlePaymentDate"      ,"Payment Date:");
        
        // Title Price
        v_Datas.put("titleRoomType"         ,"Room Type");
        v_Datas.put("titleTotalRoomCharges" ,"1 room(s) x 1 nights:");
        v_Datas.put("titleFaxesFees"        ,"Taxes & Fees:");
        v_Datas.put("titleVAT"              ,"VAT");
        v_Datas.put("titleServiceFee"       ,"Service Fee");
        v_Datas.put("titleSurcharge"        ,"Surcharge");
        v_Datas.put("titleDiscount"         ,"Special Discount:");
        v_Datas.put("titleGrandTotal"       ,"Grand Total(Paid via TNG eWallet)");
        
        // Title Price Refund
        v_Datas.put("titleRefunded"         ,"Refunded Amount:");
        v_Datas.put("titleNonRefundable"    ,"Non-Refundable Amount:");
        v_Datas.put("titleHint"             ,"This receipt is auto generated and no signature required.");
        
        // Main Title
        v_Datas.put("titleEReceipt"         ,"E-Receipt");
        v_Datas.put("titleGuestDetails"     ,"Guest Details");
        v_Datas.put("titleBookingDetails"   ,"Booking Details");
        v_Datas.put("titlePriceDetails"     ,"Price Details");
        v_Datas.put("titleAmount"           ,"Amount");
        v_Datas.put("titleRefundDetails"    ,"Refund Details");
        v_Datas.put("titleRefundAmount"     ,"Amount");
        
        return v_Datas;
    }

}
