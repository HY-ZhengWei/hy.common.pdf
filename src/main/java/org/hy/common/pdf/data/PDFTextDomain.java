package org.hy.common.pdf.data;

import java.io.Serializable;





/**
 * PDF文本数据的领域模型
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-12
 * @version     v1.0
 */
public class PDFTextDomain extends PDFDataTemplateDomain<PDFText> implements Serializable
{

    private static final long serialVersionUID = 965838833191988043L;
    

    
    public PDFTextDomain()
    {
        this(new PDFText());
    }
    
    
    
    public PDFTextDomain(PDFText i_PDFText)
    {
        super(i_PDFText);
    }

    
    
    /**
     * 获取：文本信息
     */
    public String getText()
    {
        return this.data.getText();
    }

    
    /**
     * 设置：文本信息
     * 
     * @param i_Text 文本信息
     */
    public void setText(String i_Text)
    {
        this.data.setText(i_Text);
    }
    
}
