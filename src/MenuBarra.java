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
                FrameMetadata fm = new FrameMetadata();
                }
            });


        }
    }
