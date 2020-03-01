import java.util.Locale;
import java.util.ResourceBundle;

/**
 * localization Class
 */
public class l10n
	{
	/**
	 * The language bundle for localization.
	 */
	protected static ResourceBundle bundle_lingua;

	/**
	 * Initializes the locale, loading it from the HDD.
	 */
	public l10n()
		{
		Locale currentLocale = SaveUtilities.loadLocale();
		bundle_lingua = ResourceBundle.getBundle("LanguageBundles/LanguageBundle", currentLocale);
		}

	public static String getString(String richiesta)
		{
		return bundle_lingua.getString(richiesta);
		}

	}
