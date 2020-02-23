import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class LinkListener implements HyperlinkListener
    {
    @Override
    public void hyperlinkUpdate ( HyperlinkEvent hyperlinkEvent )
        {
        if ( hyperlinkEvent.getEventType() == HyperlinkEvent.EventType.ACTIVATED )
            {
            if ( Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE) )
                {
                try
                    {
                    Desktop.getDesktop().browse(hyperlinkEvent.getURL().toURI());
                    } catch ( IOException e )
                    {
                    e.printStackTrace();
                    } catch ( URISyntaxException e )
                    {
                    e.printStackTrace();
                    }
                }

            }

        }
    }
