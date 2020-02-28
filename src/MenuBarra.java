import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class MenuBarra extends JMenuBar
    {


    public MenuBarra ()
        {

        this.setBackground(new Color(255 , 255 , 255));

        JMenu menuFile = new JMenu(Principale.bundle_lingua.getString("FILE"));
        JMenu menuHelp = new JMenu(Principale.bundle_lingua.getString("HELP"));
        this.add(menuFile);
        this.add(menuHelp);
        JMenuItem voceAbout = new JMenuItem(Principale.bundle_lingua.getString("ABOUT"));
        JMenu voceLocale = new JMenu(Principale.bundle_lingua.getString("SCEGLI_LINGUA"));
        JMenuItem voceEsci = new JMenuItem(Principale.bundle_lingua.getString("ESCI"));
        JMenuItem voceApriDiagnostics = new JMenuItem(Principale.bundle_lingua.getString("APRI_DIAGNOSTICS"));
        JMenuItem voceItaliano = new JMenuItem("Italiano");
        JMenuItem voceInglese = new JMenuItem("English");
        try
            {
            ImageIcon aboutIcon = new ImageIcon("resources/info.png");
            ImageIcon diagnosticsIcon = new ImageIcon("resources/activity.png");
            ImageIcon esciIcon = new ImageIcon("resources/x.png");
            ImageIcon linguaIcon = new ImageIcon("resources/globe.png");
            ImageIcon italianoIcon = new ImageIcon("resources/ita.png");
            ImageIcon ingleseIcon = new ImageIcon("resources/eng.png");
            voceApriDiagnostics.setIcon(diagnosticsIcon);
            voceEsci.setIcon(esciIcon);
            voceLocale.setIcon(linguaIcon);
            voceItaliano.setIcon(italianoIcon);
            voceInglese.setIcon(ingleseIcon);
            voceAbout.setIcon(aboutIcon);

            } catch ( Exception e )
            {
            e.printStackTrace();
            }

        menuFile.add(voceEsci);
        menuFile.add(voceApriDiagnostics);
        voceLocale.add(voceItaliano);
        voceLocale.add(voceInglese);
        menuFile.add(voceLocale);
        menuHelp.add(voceAbout);
        
        voceAbout.addActionListener(( e ) ->
        {
        new CreditsFrame().setVisible(true);
        });


        //aggiunta del comportamento della voce "esci" del menu principale
        voceEsci.addActionListener(new ActionListener()
            {
            @Override
            public void actionPerformed ( ActionEvent actionEvent )
                {


                Principale.getP().releaseMediaPlayer();
                //Principale.getMenuBarLeft().closeCtg();
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
                    JOptionPane.showMessageDialog(null , Principale.bundle_lingua.getString(
                            "NESSUNO_STREAM_VIDEO_ATTIVO") , Principale.bundle_lingua.getString(
                                    "NESSUN_DATO_DI_DIAGNOSTICA_DISPONIBILE") , JOptionPane.ERROR_MESSAGE);
                    }

                }
            });


        voceItaliano.addActionListener(new ActionListener()
            {
            @Override
            public void actionPerformed ( ActionEvent actionEvent )
                {
                Locale newLocale = new Locale("it" , "IT");
                SaveUtilities.saveLocale(newLocale);
                JOptionPane.showMessageDialog(null , Principale.bundle_lingua.getString("CAMBIO_LOCALE"));
                }
            });

        voceInglese.addActionListener(new ActionListener()
            {
            @Override
            public void actionPerformed ( ActionEvent actionEvent )
                {
                Locale newLocale = new Locale("en" , "US");
                SaveUtilities.saveLocale(newLocale);
                JOptionPane.showMessageDialog(null , Principale.bundle_lingua.getString("CAMBIO_LOCALE"));

                }
            });

        }

    }
