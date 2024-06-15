package org.hy.common.pdf.junit.line;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.batik.parser.AWTPathProducer;
import org.apache.batik.parser.PathParser;

public class SvgPathViewer extends JPanel {

    private static final long serialVersionUID = -6483046146026853251L;
    private Shape svgPathShape;

    public SvgPathViewer(String pathData) {
        try {
            // 使用 Batik 的 PathParser 解析路径数据
            PathParser pathParser = new PathParser();
            AWTPathProducer pathProducer = new AWTPathProducer();
            pathParser.setPathHandler(pathProducer);
            pathParser.parse(pathData);

            svgPathShape = pathProducer.getShape();

            setPreferredSize(new Dimension(800, 600));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (svgPathShape != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.BLUE);
            g2d.draw(svgPathShape);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SVG Path Viewer");
        String pathData = "M10 10 L90 10 L50 90 Z";
        SvgPathViewer svgPathViewer = new SvgPathViewer(pathData);
        frame.add(svgPathViewer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
