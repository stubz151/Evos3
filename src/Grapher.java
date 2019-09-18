import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultHighLowDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.util.ArrayList;

public class Grapher extends javax.swing.JFrame {
    public XYSeries fitSeries = new XYSeries("Fitness");
    public Grapher() {


        XYDataset xyDataset = new XYSeriesCollection(fitSeries);
        JFreeChart chart = ChartFactory.createXYLineChart("BestProfit versus Generations", "Iteration", "Profit", xyDataset, PlotOrientation.VERTICAL, true, true, false);

        chart.getXYPlot().getRangeAxis().setRange(180000, 200000);
        chart.getXYPlot().getDomainAxis().setRange(0,1000);
        ChartPanel cp = new ChartPanel(chart) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(320, 240);
            }
        };
        cp.setMouseWheelEnabled(true);
        add(cp);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }




    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grapher().setVisible(true);
            }

        });
    }
}

