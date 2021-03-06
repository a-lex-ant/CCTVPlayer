import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * The Link listener class, to interact with the links in the CreditsFrame.
 */
public class LinkListener implements HyperlinkListener
	{

	@Override
	public void hyperlinkUpdate(HyperlinkEvent hyperlinkEvent)
		{
		if (hyperlinkEvent.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
			{
			if (Desktop.isDesktopSupported() && Desktop.getDesktop()
			                                           .isSupported(Desktop.Action.BROWSE))
				{
				try
					{
					Desktop.getDesktop()
					       .browse(hyperlinkEvent.getURL()
					                             .toURI());
					}
				catch (IOException | URISyntaxException e)
					{
					e.printStackTrace();
					}
				}

			}

		}

	}
