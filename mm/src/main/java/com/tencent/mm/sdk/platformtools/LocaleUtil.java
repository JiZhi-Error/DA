package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import java.util.Locale;

public final class LocaleUtil {
    public static final String ARABIC = "ar";
    public static final String CHINA = "zh_CN";
    public static final String ENGLISH = "en";
    public static final String FRENCH = "fr";
    public static final String GERMAN = "de";
    public static final String HONGKONG = "zh_HK";
    public static final String INDONESIAN = "id";
    public static final String INDONESIAN_NEWNAME = "in";
    public static final String ITALIAN = "it";
    public static final String JAPANESE = "ja";
    public static final String KOREAN = "ko";
    public static final String LANGUAGE_DEFAULT = "language_default";
    public static final String LANGUAGE_KEY = "language_key";
    public static final String LAO = "lo";
    public static final String MALAY = "ms";
    public static final String MYANMAR = "my";
    public static final String PORTUGUESE = "pt";
    public static final String RUSSIAN = "ru";
    public static final String SPANISH = "es";
    private static final String TAG = "MicroMsg.LocaleUtil";
    public static final String TAIWAN = "zh_TW";
    public static final String THAI = "th";
    public static final String TURKEY = "tr";
    public static final String VIETNAMESE = "vi";
    static final String _LANGUAGE_DEFAULT = "language_default";
    public static Locale sysDefaultLocale;

    static {
        AppMethodBeat.i(125269);
        loadCurrentSystemLocale();
        AppMethodBeat.o(125269);
    }

    private LocaleUtil() {
    }

    public static boolean isLanguageSupported(String str) {
        AppMethodBeat.i(200894);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(200894);
            return false;
        } else if (str.equalsIgnoreCase(TAIWAN) || str.equalsIgnoreCase(HONGKONG) || str.equalsIgnoreCase(CHINA) || str.equalsIgnoreCase(ENGLISH) || str.equalsIgnoreCase(THAI) || str.equals("id") || str.equals(INDONESIAN_NEWNAME) || str.equals(VIETNAMESE) || str.equalsIgnoreCase(PORTUGUESE) || str.equalsIgnoreCase(SPANISH) || str.equalsIgnoreCase(RUSSIAN) || str.equalsIgnoreCase(ARABIC) || str.equalsIgnoreCase(JAPANESE) || str.equalsIgnoreCase(ITALIAN) || str.equalsIgnoreCase(KOREAN) || str.equalsIgnoreCase(MALAY) || str.equalsIgnoreCase(TURKEY) || str.equalsIgnoreCase(GERMAN) || str.equalsIgnoreCase(FRENCH) || str.equalsIgnoreCase(MYANMAR) || str.equalsIgnoreCase(LAO)) {
            AppMethodBeat.o(200894);
            return true;
        } else {
            AppMethodBeat.o(200894);
            return false;
        }
    }

    public static boolean isChineseAppLang() {
        AppMethodBeat.i(125254);
        String applicationLanguage = getApplicationLanguage();
        if (applicationLanguage.equals(CHINA) || applicationLanguage.equals(TAIWAN) || applicationLanguage.equals(HONGKONG)) {
            AppMethodBeat.o(125254);
            return true;
        }
        AppMethodBeat.o(125254);
        return false;
    }

    public static boolean isSimplifiedChineseAppLang() {
        AppMethodBeat.i(125255);
        if (getApplicationLanguage().equals(CHINA)) {
            AppMethodBeat.o(125255);
            return true;
        }
        AppMethodBeat.o(125255);
        return false;
    }

    public static boolean isTraditionalChineseAppLang() {
        AppMethodBeat.i(125256);
        if (getApplicationLanguage().equals(TAIWAN) || getApplicationLanguage().equals(HONGKONG)) {
            AppMethodBeat.o(125256);
            return true;
        }
        AppMethodBeat.o(125256);
        return false;
    }

    public static boolean isChineseSysLang() {
        AppMethodBeat.i(200895);
        if (Locale.getDefault().equals(Locale.CHINA) || Locale.getDefault().equals(Locale.TAIWAN) || Locale.getDefault().toString().startsWith(Locale.CHINESE.toString())) {
            AppMethodBeat.o(200895);
            return true;
        }
        AppMethodBeat.o(200895);
        return false;
    }

    public static void updateApplicationResourceLocale(Context context, Locale locale) {
        AppMethodBeat.i(125257);
        try {
            Resources resources = context.getResources();
            Configuration configuration = resources.getConfiguration();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration.locale = locale;
            resources.updateConfiguration(configuration, displayMetrics);
            Resources.getSystem().updateConfiguration(configuration, displayMetrics);
            WeChatBrands.updateLang(transLocaleToLanguage(locale));
            AppMethodBeat.o(125257);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "updateApplicationResourceLocale err~~~", new Object[0]);
            AppMethodBeat.o(125257);
        }
    }

    public static String transLocaleToLanguage(Locale locale) {
        AppMethodBeat.i(125258);
        String language = locale.getLanguage();
        if (language.equals("zh")) {
            String str = language + "_" + locale.getCountry().toUpperCase();
            AppMethodBeat.o(125258);
            return str;
        }
        AppMethodBeat.o(125258);
        return language;
    }

    public static Locale transLanguageToLocale(String str) {
        AppMethodBeat.i(125259);
        if (str.equals(TAIWAN)) {
            Locale locale = Locale.TAIWAN;
            AppMethodBeat.o(125259);
            return locale;
        } else if (str.equals(HONGKONG)) {
            Locale locale2 = new Locale("zh", WeChatBrands.AppInfo.LANG_HK);
            AppMethodBeat.o(125259);
            return locale2;
        } else if (str.equals(ENGLISH)) {
            Locale locale3 = Locale.ENGLISH;
            AppMethodBeat.o(125259);
            return locale3;
        } else if (str.equals(CHINA)) {
            Locale locale4 = Locale.CHINA;
            AppMethodBeat.o(125259);
            return locale4;
        } else if (WeChatSomeFeatureSwitch.temporaryBlockMinorLanguage()) {
            Locale locale5 = Locale.ENGLISH;
            AppMethodBeat.o(125259);
            return locale5;
        } else if (str.equalsIgnoreCase(THAI) || str.equalsIgnoreCase("id") || str.equalsIgnoreCase(INDONESIAN_NEWNAME) || str.equalsIgnoreCase(VIETNAMESE) || str.equalsIgnoreCase(PORTUGUESE) || str.equalsIgnoreCase(SPANISH) || str.equalsIgnoreCase(RUSSIAN) || str.equalsIgnoreCase(ARABIC) || str.equalsIgnoreCase(JAPANESE) || str.equalsIgnoreCase(ITALIAN) || str.equalsIgnoreCase(KOREAN) || str.equalsIgnoreCase(MALAY) || str.equalsIgnoreCase(TURKEY) || str.equalsIgnoreCase(GERMAN) || str.equalsIgnoreCase(FRENCH) || str.equalsIgnoreCase(MYANMAR) || str.equalsIgnoreCase(LAO)) {
            Locale locale6 = new Locale(str);
            AppMethodBeat.o(125259);
            return locale6;
        } else {
            Log.e(TAG, "transLanguageToLocale country = ".concat(String.valueOf(str)));
            Locale locale7 = Locale.ENGLISH;
            AppMethodBeat.o(125259);
            return locale7;
        }
    }

    public static void loadCurrentSystemLocale() {
        AppMethodBeat.i(200896);
        if (Build.VERSION.SDK_INT < 24) {
            sysDefaultLocale = Locale.getDefault();
        } else {
            sysDefaultLocale = LocaleList.getDefault().get(0);
        }
        Locale.setDefault(sysDefaultLocale);
        AppMethodBeat.o(200896);
    }

    public static String getCurrentCountryCode() {
        AppMethodBeat.i(125260);
        String trim = Locale.getDefault().getCountry().trim();
        AppMethodBeat.o(125260);
        return trim;
    }

    private static String filterLanguage(String str) {
        AppMethodBeat.i(125261);
        String trim = Locale.getDefault().getLanguage().trim();
        String str2 = trim + "_" + Locale.getDefault().getCountry().trim();
        if (trim.equals(ENGLISH)) {
            AppMethodBeat.o(125261);
            return trim;
        } else if (str2.equals(TAIWAN)) {
            AppMethodBeat.o(125261);
            return TAIWAN;
        } else if (str2.equals(HONGKONG)) {
            AppMethodBeat.o(125261);
            return HONGKONG;
        } else if (str2.equals(CHINA)) {
            AppMethodBeat.o(125261);
            return CHINA;
        } else if (WeChatSomeFeatureSwitch.temporaryBlockMinorLanguage()) {
            AppMethodBeat.o(125261);
            return str;
        } else if (trim.equals(THAI)) {
            AppMethodBeat.o(125261);
            return THAI;
        } else if (trim.equals("id")) {
            AppMethodBeat.o(125261);
            return "id";
        } else if (trim.equals(INDONESIAN_NEWNAME)) {
            AppMethodBeat.o(125261);
            return "id";
        } else if (trim.equals(VIETNAMESE)) {
            AppMethodBeat.o(125261);
            return VIETNAMESE;
        } else if (trim.equals(PORTUGUESE)) {
            AppMethodBeat.o(125261);
            return PORTUGUESE;
        } else if (trim.equals(SPANISH)) {
            AppMethodBeat.o(125261);
            return SPANISH;
        } else if (trim.equals(RUSSIAN)) {
            AppMethodBeat.o(125261);
            return RUSSIAN;
        } else if (trim.equals(ARABIC)) {
            AppMethodBeat.o(125261);
            return ARABIC;
        } else if (trim.equals(JAPANESE)) {
            AppMethodBeat.o(125261);
            return JAPANESE;
        } else if (trim.equals(ITALIAN)) {
            AppMethodBeat.o(125261);
            return ITALIAN;
        } else if (trim.equals(KOREAN)) {
            AppMethodBeat.o(125261);
            return KOREAN;
        } else if (trim.equals(MALAY)) {
            AppMethodBeat.o(125261);
            return MALAY;
        } else if (trim.equals(TURKEY)) {
            AppMethodBeat.o(125261);
            return TURKEY;
        } else if (trim.equals(GERMAN)) {
            AppMethodBeat.o(125261);
            return GERMAN;
        } else if (trim.equals(FRENCH)) {
            AppMethodBeat.o(125261);
            return FRENCH;
        } else if (trim.equals(MYANMAR)) {
            AppMethodBeat.o(125261);
            return MYANMAR;
        } else if (trim.equals(LAO)) {
            AppMethodBeat.o(125261);
            return LAO;
        } else {
            AppMethodBeat.o(125261);
            return str;
        }
    }

    public static String getApplicationLanguage() {
        AppMethodBeat.i(125262);
        String nullAsNil = Util.nullAsNil(SystemProperty.getProperty(LANGUAGE_KEY));
        if (nullAsNil.length() <= 0 || nullAsNil.equals("language_default")) {
            String filterLanguage = filterLanguage(ENGLISH);
            AppMethodBeat.o(125262);
            return filterLanguage;
        }
        AppMethodBeat.o(125262);
        return nullAsNil;
    }

    public static String loadApplicationLanguage(SharedPreferences sharedPreferences, Context context) {
        AppMethodBeat.i(200897);
        String nullAsNil = Util.nullAsNil(sharedPreferences.getString(LANGUAGE_KEY, null));
        if (nullAsNil.length() <= 0 || nullAsNil.equals("language_default")) {
            String filterLanguage = filterLanguage(ENGLISH);
            SystemProperty.setProperty(LANGUAGE_KEY, filterLanguage);
            AppMethodBeat.o(200897);
            return filterLanguage;
        }
        SystemProperty.setProperty(LANGUAGE_KEY, nullAsNil);
        AppMethodBeat.o(200897);
        return nullAsNil;
    }

    public static String loadApplicationLanguageSettings(SharedPreferences sharedPreferences, Context context) {
        AppMethodBeat.i(200898);
        String nullAsNil = Util.nullAsNil(sharedPreferences.getString(LANGUAGE_KEY, null));
        if (!Util.isNullOrNil(nullAsNil)) {
            AppMethodBeat.o(200898);
            return nullAsNil;
        }
        AppMethodBeat.o(200898);
        return "language_default";
    }

    public static void saveApplicationLanguage(SharedPreferences sharedPreferences, Context context, String str) {
        AppMethodBeat.i(200899);
        if (sharedPreferences.edit().putString(LANGUAGE_KEY, str).commit()) {
            SystemProperty.setProperty(LANGUAGE_KEY, str);
            Log.w(TAG, "save application lang as:".concat(String.valueOf(str)));
            AppMethodBeat.o(200899);
            return;
        }
        Log.e(TAG, "saving application lang failed");
        AppMethodBeat.o(200899);
    }

    public static String getCurrentLanguage(Context context) {
        AppMethodBeat.i(125266);
        String loadApplicationLanguageSettings = loadApplicationLanguageSettings(context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), context);
        String applicationLanguage = getApplicationLanguage();
        if (!loadApplicationLanguageSettings.equalsIgnoreCase("language_default")) {
            applicationLanguage = loadApplicationLanguageSettings;
        }
        AppMethodBeat.o(125266);
        return applicationLanguage;
    }

    public static String getLanguageName(Context context, int i2, int i3) {
        AppMethodBeat.i(200900);
        String[] stringArray = context.getResources().getStringArray(i2);
        String loadApplicationLanguageSettings = loadApplicationLanguageSettings(context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), context);
        if (loadApplicationLanguageSettings == null) {
            String string = context.getString(i3);
            AppMethodBeat.o(200900);
            return string;
        }
        String[] strArr = LocaleGen.LOCALES;
        int length = strArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            if (strArr[i4].equals(loadApplicationLanguageSettings)) {
                String str = stringArray[i5];
                AppMethodBeat.o(200900);
                return str;
            }
            i4++;
            i5++;
        }
        String string2 = context.getString(i3);
        AppMethodBeat.o(200900);
        return string2;
    }

    public static Locale initLanguage(Context context) {
        AppMethodBeat.i(125268);
        String loadApplicationLanguage = loadApplicationLanguage(context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), context);
        if (loadApplicationLanguage.equals("language_default")) {
            updateApplicationResourceLocale(context, Locale.ENGLISH);
            Locale locale = Locale.getDefault();
            AppMethodBeat.o(125268);
            return locale;
        }
        Locale transLanguageToLocale = transLanguageToLocale(loadApplicationLanguage);
        updateApplicationResourceLocale(context, transLanguageToLocale);
        AppMethodBeat.o(125268);
        return transLanguageToLocale;
    }
}
