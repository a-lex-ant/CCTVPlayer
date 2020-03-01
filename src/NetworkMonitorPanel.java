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

/**
 * The Network monitor panel class.
 */
public class NetworkMonitorPanel extends JPanel
	{

	private TimeSeries           series1;
	private TimeSeriesCollection dataset;

	/**
	 * Instantiates a new Network monitor panel.
	 *
	 * @throws HeadlessException
	 */
	public NetworkMonitorPanel() throws HeadlessException
		{
		this.setLayout(new BorderLayout());
		this.series1 = new TimeSeries(CCTVPlayer.bundle_lingua.getString("BYTE_SEC_INPUT"));
		this.dataset = new TimeSeriesCollection();
		ChartPanel grafico = (ChartPanel) creaPannelloGrafico();
		this.add(grafico);
		this.setVisible(true);
		runTimer();
		}

	/**
	 * Creates a panel that shows the chart
	 *
	 * @return the panel
	 */
	public JPanel creaPannelloGrafico()
	{
	linkSeriesAndDataset();
	JFreeChart grafico = creaGrafico(this.dataset);
	ChartPanel panel   = new ChartPanel(grafico, true);
	return panel;
	}

	/**
	 * Creates a JFreeChart chart
	 *
	 * @param dataset the dataset
	 *
	 * @return the chart object
	 */
	private JFreeChart creaGrafico(XYDataset dataset)  //createChart
	{
	JFreeChart grafico = ChartFactory.createTimeSeriesChart(CCTVPlayer.bundle_lingua.getString("NETWORK_MONITORING"), "secs",
	                                                        CCTVPlayer.bundle_lingua.getString("DATA_RATE"), dataset);

	XYPlot plot = (XYPlot) grafico.getPlot();
	plot.setDomainGridlinesVisible(false);
	plot.setBackgroundPaint(Color.WHITE);
	plot.setRangeGridlinePaint(Color.GRAY);

	return grafico;
	}

	/**
	 * Link series and corresponding dataset.
	 */
	private void linkSeriesAndDataset()
	{
	dataset.addSeries(series1);
	}

	/**
	 * Updates the chart
	 *
	 * @param value the new value to be painted
	 */
	private void aggiornaGrafico(double value)
		{
		if (series1.getItemCount() >= 60)
			{
			series1.clear();
			}
		Second s = new Second();
		series1.add(s, value);

		this.repaint();
		}

	/**
	 * Runs the timer to regularly update the chart.
	 */
	private void runTimer()
		{
		Timer t = new Timer(1000, actionEvent ->
		{
		double d1 = CCTVPlayer.getPannelloMediaPlayer()
		                      .getInputBitrate();
		aggiornaGrafico(d1);
		});
		t.start();

		}

	//***************************END OF CLASS**************************************************************
	}
