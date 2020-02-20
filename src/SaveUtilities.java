import java.io.*;
import java.util.Locale;

public class SaveUtilities
    {

    //TODO: fare sì che i file si salvino in una directory sua

    public static void saveLocale( Locale newLocale)
        {
        try ( ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("localeSettings.txt")) )
            {
            objectOutputStream.writeObject(newLocale);
            } catch ( IOException e )
            {
            e.printStackTrace();
            }
        System.out.println("Finito salvare locale");
        }


    public static Locale loadLocale()
        {
        Locale letto = null;
        try ( ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("localeSettings.txt")) )
            {
            letto = (Locale) objectInputStream.readObject();
            objectInputStream.close();
            } catch ( IOException | ClassNotFoundException e )
            {
            letto = new Locale("it","IT");
            }
        if (letto == null) letto = new Locale("it","IT");
        System.out.println("finito caricare locale");
        return letto;
        }
    }
