import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarra extends JMenuBar
    {
    public MenuBarra ()
        {
        JMenu menuFile = new JMenu("File");
        this.add(menuFile);
        JMenuItem voceEsci = new JMenuItem("Esci");
        menuFile.add(voceEsci);

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


        }
    }
