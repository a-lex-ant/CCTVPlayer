import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The Clock panel Class
 */
public class PannelloOrologio extends JPanel
	{

	private JLabel clock;

	/**
	 * Instantiates a new clock panel.
	 */
	public PannelloOrologio()
		{
		this.setLayout(new BorderLayout());
		this.clock = new JLabel(new Date().toString());
		this.add(clock, BorderLayout.CENTER);
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.submit(new AggiornaOrologio());
		}

	/**
	 * Utility class that implements the run method called by the timer.
	 * Updates the time showed.
	 */
	private class AggiornaOrologio implements Runnable
		{

		@Override
		public void run()
			{
			Timer timer = new Timer(1000, actionEvent -> clock.setText((new Date().toString())));

			timer.start();
			}

		}

	}
