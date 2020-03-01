import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;

/**
 * The Save utilities class.
 */
public class SaveUtilities
	{

	/**
	 * The user directory.
	 */
	private static String userDir = System.getProperty("user.dir");

	/**
	 * Saves the locale chosen on disk.
	 *
	 * @param newLocale the new locale to be written
	 */
	public static void saveLocale(Locale newLocale)
		{
		checkForSaveDirectoryExistance();
		try (
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(userDir + "/savedData/localeSettings.bin"))
		)
			{
			objectOutputStream.writeObject(newLocale);
			}
		catch (IOException e)
			{
			e.printStackTrace();
			}
		System.out.println("Finito salvare locale");
		}

	/**
	 * Checks for save directory existance.
	 */
	private static void checkForSaveDirectoryExistance()
		{
		if (!Files.exists(Paths.get(System.getProperty("user.dir") + "/savedData")))
			{
			try
				{
				Files.createDirectory(Paths.get(userDir + "/savedData"));
				}
			catch (IOException e)
				{
				e.printStackTrace();
				}
			}
		}

	/**
	 * Loads locale from disk.
	 *
	 * @return the locale
	 */
	public static Locale loadLocale()
		{
		checkForSaveDirectoryExistance();
		Locale letto;
		try (
				ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(userDir + "/savedData" + "/localeSettings.bin"))
		)
			{
			letto = (Locale) objectInputStream.readObject();
			}
		catch (IOException | ClassNotFoundException e)
			{
			letto = new Locale("it", "IT");
			}
		if (letto == null) { letto = new Locale("it", "IT"); }
		System.out.println("finito caricare locale");
		return letto;
		}

	}
