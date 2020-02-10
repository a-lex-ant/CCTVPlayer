import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarra extends JMenuBar
    {
    public MenuBarra ()
        {



        JMenu menuFile = new JMenu("File");
        this.add(menuFile);
        JMenuItem voceEsci = new JMenuItem("Esci");
        JMenuItem voceApriDiagnostics = new JMenuItem("Apri Diagnostics");
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
                    JOptionPane.showMessageDialog(null,
                            "Nessuno stream video attivo",
                            "Nessun dato di diagnostica disponibile al momento",
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            });


        }
    }
