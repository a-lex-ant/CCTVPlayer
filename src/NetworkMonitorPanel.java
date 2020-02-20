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
    private TimeSeriesCollection dataset;

    public NetworkMonitorPanel () throws HeadlessException
        {
        this.setLayout(new BorderLayout());
        this.series1 = new TimeSeries(Principale.bundle_lingua.getString("BYTE_SEC_INPUT"));
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
    JFreeChart grafico = ChartFactory.createTimeSeriesChart(Principale.bundle_lingua.getString("NETWORK_MONITORING") , "secs" , Principale.bundle_lingua.getString("DATA_RATE") , dataset);

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



    }

    private void aggiornaGrafico(double value)
        {
        if ( series1.getItemCount() >= 60)
            {
            series1.clear();
            }
        Second s = new Second();
        series1.add(s,value);

        this.repaint();
        }

    private void runTimer()
        {
        Timer t = new Timer(1000 , new ActionListener()
            {
            @Override
            public void actionPerformed ( ActionEvent actionEvent )
                {
                double d1 = Principale.getP().getInputBitrate();
                aggiornaGrafico(d1);
                }
            });
        t.start();



        }










    //***************************FINE CLASSE***************************************************************
    }
