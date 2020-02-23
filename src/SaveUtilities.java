import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;

public class SaveUtilities
    {

    private static String userDir = System.getProperty("user.dir");

    public static void saveLocale ( Locale newLocale )
        {
        checkForSaveDirectoryExistance();
        try ( ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(userDir +
                "/savedData/localeSettings.bin")) )
            {
            objectOutputStream.writeObject(newLocale);
            } catch ( IOException e )
            {
            e.printStackTrace();
            }
        System.out.println("Finito salvare locale");
        }

    private static void checkForSaveDirectoryExistance ()
        {
        if ( !Files.exists(Paths.get(System.getProperty("user.dir") + "/savedData")) )
            {
            try
                {
                Files.createDirectory(Paths.get(userDir + "/savedData"));
                } catch ( IOException e )
                {
                e.printStackTrace();
                }
            }
        }


    public static Locale loadLocale ()
        {
        checkForSaveDirectoryExistance();
        Locale letto = null;
        try ( ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(userDir + "/savedData" +
                "/localeSettings.bin")) )
            {
            letto = (Locale) objectInputStream.readObject();
            } catch ( IOException | ClassNotFoundException e )
            {
            letto = new Locale("it" , "IT");
            }
        if ( letto == null )
            letto = new Locale("it" , "IT");
        System.out.println("finito caricare locale");
        return letto;
        }
    }
