import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NetworkMonitorPanel extends JPanel
    {

    private TimeSeries series1;
    private TimeSeries series2;
    private TimeSeriesCollection dataset;

    public NetworkMonitorPanel () throws HeadlessException
        {
        this.setLayout(new BorderLayout());
        this.series1 = new TimeSeries("byte/sec input");
        this.series2 = new TimeSeries("byte/sec output");
        this.dataset =  new TimeSeriesCollection();
        ChartPanel grafico = (ChartPanel)creaPannelloGrafico();
        this.add(grafico);
        this.setVisible(true);
        runTimer();
        }

    public JPanel creaPannelloGrafico()  //createDemoPanel
    {
    linkSeriesAndDataset();
    JFreeChart grafico = creaGrafico(this.dataset);
    ChartPanel panel = new ChartPanel(grafico, true);
    return panel;
    }

    private JFreeChart creaGrafico ( XYDataset dataset )  //createChart
    {
    JFreeChart grafico = ChartFactory.createTimeSeriesChart("Network Monitoring" , "secs" , "date rate" , dataset);

    XYPlot plot = (XYPlot) grafico.getPlot();
    plot.setDomainGridlinesVisible(false);
    plot.setBackgroundPaint(Color.WHITE);
    plot.setRangeGridlinePaint(Color.GRAY);

    return grafico;
    }

    private void linkSeriesAndDataset ()  //createDataset
    {
    //series.add(new Second(), 1.0); //prima inizializzazione per prova
    dataset.addSeries(series1);
    dataset.addSeries(series2);


    }

    private void aggiornaGrafico(double value, double value2)
        {
        if ( series1.getItemCount() >= 60 && series2.getItemCount() >= 60) {
        series1.clear();
        series2.clear();}
        Second s = new Second();
        series1.add(s,value);
        series2.add(s,value2);
        this.repaint();
        }

    private void runTimer()
        {
        Timer t = new Timer(1000 , new ActionListener()
            {
            @Override
            public void actionPerformed ( ActionEvent actionEvent )
                {
                double d1 = -10.0 + new Random().nextDouble() * 20.0; //versione che crea dei random a scopo di testing
                double d2 = -10.0 + new Random().nextDouble() * 20.0;
                aggiornaGrafico(d1,d2);
                }
            });
        t.start();



        }










    //***************************FINE CLASSE***************************************************************
    }
