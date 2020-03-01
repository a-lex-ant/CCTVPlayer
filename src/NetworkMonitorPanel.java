import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;

import org.jfree.chart.renderer.category.LineAndShapeRenderer;
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
	private TimeSeries           series2;
	private TimeSeries           series3;
	private TimeSeriesCollection dataset;



	/**
	 * Instantiates a new Network monitor panel.
	 *
	 * @throws HeadlessException When code that is dependent on a keyboard, display, or mouse is called in an environment that does not support them.
	 */
	public NetworkMonitorPanel() throws HeadlessException
		{

		this.setLayout(new GridLayout());
		this.series1 = new TimeSeries(l10n.getString("AUDIO_BUFFERS_LOST"));
		this.series2 = new TimeSeries(l10n.getString("DEMUX_CORRUPTED"));
		this.series3 = new TimeSeries(l10n.getString("PICTURES_LOST"));
		this.dataset = new TimeSeriesCollection();
		ChartPanel graficoPanel = (ChartPanel) creaPannelloGrafico();
		this.add(graficoPanel);
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
	return new ChartPanel(grafico,true);
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
	JFreeChart grafico = ChartFactory.createTimeSeriesChart(l10n.getString("NETWORK_MONITORING"), "",
	                                                        l10n.getString("DATA_RATE"), dataset);
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
	dataset.addSeries(series2);
	dataset.addSeries(series3);
	}

	/**
	 * Updates the chart
	 *
	 * @param value1 the new value to be painted (Audio Buffers Lost)
	 * @param value2 the new value to be painted (Demux Corrupted)
	 * @param value3 the new value to be painted (Pictures Lost)
	 */
	private void aggiornaGrafico(double value1, double value2, double value3)
		{
		if (series1.getItemCount() >= 20 | series2.getItemCount() >= 20 | series3.getItemCount() >= 20)
			{
			series1.clear();
			series2.clear();
			series3.clear();
			}
		Second s = new Second();
		series1.add(s, value1);
		series2.add(s,value2);
		series3.add(s,value3);

		this.repaint();
		}

	/**
	 * Runs the timer to regularly update the chart.
	 */
	private void runTimer()
		{
		Timer t = new Timer(1000, actionEvent ->
		{
		double d1 = DataUtility.getAudioBuffersLost();
		double d2 = DataUtility.getDemuxCorrupted();
		double d3 = DataUtility.getPicturesLost();

		aggiornaGrafico(d1,d2,d3);
		});
		t.start();

		}

	//***************************END OF CLASS**************************************************************
	}
