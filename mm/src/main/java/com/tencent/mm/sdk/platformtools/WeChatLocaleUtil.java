package com.tencent.mm.sdk.platformtools;

import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import java.util.Locale;
import java.util.TimeZone;

public class WeChatLocaleUtil {
    public static boolean isOverseasUserByWechatLanguage() {
        AppMethodBeat.i(125286);
        String loadApplicationLanguageSettings = LocaleUtil.loadApplicationLanguageSettings(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
        String applicationLanguage = LocaleUtil.getApplicationLanguage();
        if (!loadApplicationLanguageSettings.equals(LocaleUtil.LANGUAGE_DEFAULT)) {
            applicationLanguage = loadApplicationLanguageSettings;
        }
        if (!applicationLanguage.equals(LocaleUtil.CHINA)) {
            AppMethodBeat.o(125286);
            return true;
        }
        if (TimeZone.getDefault().getRawOffset() != TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
            AppMethodBeat.o(125286);
            return true;
        }
        TelephonyManager telephonyManager = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!Util.isNullOrNil(networkCountryIso) && !networkCountryIso.contains("cn") && !networkCountryIso.contains(WeChatBrands.AppInfo.LANG_CN)) {
                AppMethodBeat.o(125286);
                return true;
            }
        }
        AppMethodBeat.o(125286);
        return false;
    }

    public static boolean isOverseasUser() {
        AppMethodBeat.i(200974);
        if (!Locale.getDefault().getCountry().equalsIgnoreCase(WeChatBrands.AppInfo.LANG_CN)) {
            AppMethodBeat.o(200974);
            return true;
        }
        if (TimeZone.getDefault().getRawOffset() != TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
            AppMethodBeat.o(200974);
            return true;
        }
        TelephonyManager telephonyManager = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!Util.isNullOrNil(networkCountryIso) && !networkCountryIso.contains("cn") && !networkCountryIso.contains(WeChatBrands.AppInfo.LANG_CN)) {
                AppMethodBeat.o(200974);
                return true;
            }
        }
        AppMethodBeat.o(200974);
        return false;
    }
}
