package org.hy.common.pdf.junit.line;

import java.awt.Shape;

import org.apache.batik.parser.AWTPathProducer;
import org.apache.batik.parser.PathParser;





/**
 * PDF线段&表格的测试单元
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-06-15
 * @version     v1.0
 */
public class JU_LinePDF
{
    
    public void createPDF_Line()
    {
        String pathData = "M10 10 L90 10 L50 90 Z";
        
        PathParser pathParser = new PathParser();
        AWTPathProducer pathProducer = new AWTPathProducer();
        pathParser.setPathHandler(pathProducer);
        pathParser.parse(pathData);

        Shape v_SvgShape = pathProducer.getShape();
        
        // 现在 path 对象包含了解析后的路径数据，你可以对其进行进一步处理或显示。
    }
    
}
