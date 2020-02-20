import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarra extends JMenuBar
    {


    public MenuBarra ()
        {


        JMenu menuFile = new JMenu(Principale.bundle_lingua.getString("FILE"));
        this.add(menuFile);
        JMenuItem voceEsci = new JMenuItem(Principale.bundle_lingua.getString("ESCI"));
        JMenuItem voceApriDiagnostics = new JMenuItem(Principale.bundle_lingua.getString("APRI_DIAGNOSTICS"));
        try
            {
            ImageIcon diagnosticsIcon = new ImageIcon("resources/activity.png");
            ImageIcon esciIcon = new ImageIcon("resources/x.png");
            voceApriDiagnostics.setIcon(diagnosticsIcon);
            voceEsci.setIcon(esciIcon);
            } catch ( Exception e )
            {
            e.printStackTrace();
            }

        menuFile.add(voceEsci);
        menuFile.add(voceApriDiagnostics);




        //aggiunta del comportamento della voce "esci" del menu principale
        voceEsci.addActionListener(new ActionListener()
            {
            @Override
            public void actionPerformed ( ActionEvent actionEvent )
                {

                //TO DO: aggiungere check prima di chiudere di brutto
                System.exit(0);




                }
            });

        voceApriDiagnostics.addActionListener(new ActionListener()
            {
            @Override
            public void actionPerformed ( ActionEvent actionEvent )
                {
                try
                    {
                    FrameMetadata fm = new FrameMetadata();
                    } catch ( NullPointerException e )
                    {
                    JOptionPane.showMessageDialog(null, Principale.bundle_lingua.getString("NESSUNO_STREAM_VIDEO_ATTIVO") ,
                            Principale.bundle_lingua.getString("NESSUN_DATO_DI_DIAGNOSTICA_DISPONIBILE") ,
                            JOptionPane.ERROR_MESSAGE);
                    }

                }
            });


        }
    }
