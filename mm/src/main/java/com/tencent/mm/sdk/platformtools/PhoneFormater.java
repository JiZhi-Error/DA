package com.tencent.mm.sdk.platformtools;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.PhoneFormaterConfig;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneFormater {
    private static final String TAG = "MicroMsg.PhoneFormater";
    public static PhoneFormaterConfig config = null;

    public static String extractCountryCode(String str, String str2) {
        int length;
        int length2;
        AppMethodBeat.i(157761);
        String replace = pureNumber(str).replace("+", "");
        if (config == null) {
            config = new PhoneFormaterConfig();
        }
        if (Util.isNullOrNil(str2)) {
            for (PhoneFormaterConfig.Country country : config.contryList) {
                if (replace.startsWith(country.countrycode) && (length2 = replace.length() - country.countrycode.length()) >= country.minlen && length2 <= country.maxlen) {
                    Log.i(TAG, "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", country.countrycode, country.isocode, Integer.valueOf(country.maxlen), Integer.valueOf(country.maxlen));
                    String str3 = country.countrycode;
                    AppMethodBeat.o(157761);
                    return str3;
                }
            }
        } else {
            for (PhoneFormaterConfig.Country country2 : config.contryList) {
                if (replace.startsWith(country2.countrycode) && (length = replace.length() - country2.countrycode.length()) >= country2.minlen && length <= country2.maxlen && str2.equalsIgnoreCase(country2.isocode)) {
                    Log.i(TAG, "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", country2.countrycode, country2.isocode, Integer.valueOf(country2.maxlen), Integer.valueOf(country2.maxlen));
                    String str4 = country2.countrycode;
                    AppMethodBeat.o(157761);
                    return str4;
                }
            }
        }
        AppMethodBeat.o(157761);
        return null;
    }

    public static String extractCountryCode(String str) {
        AppMethodBeat.i(157762);
        String extractCountryCode = extractCountryCode(str, null);
        AppMethodBeat.o(157762);
        return extractCountryCode;
    }

    public static String formatMobileString(String str) {
        AppMethodBeat.i(157763);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(157763);
            return str;
        } else if (!Util.isPhoneNumber(str).booleanValue()) {
            AppMethodBeat.o(157763);
            return str;
        } else {
            PhoneFormater phoneFormater = new PhoneFormater();
            String str2 = "86";
            if (str.startsWith("+") && (str2 = extractCountryCode((str = str.replace("+", "")))) != null) {
                str = str.substring(str2.length());
            }
            String formatNumber = phoneFormater.formatNumber(str2, str);
            AppMethodBeat.o(157763);
            return formatNumber;
        }
    }

    public static String pureNumber(String str) {
        AppMethodBeat.i(157764);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(157764);
            return "";
        }
        String trim = str.replaceAll("[\\.\\-\\ ]", "").trim();
        AppMethodBeat.o(157764);
        return trim;
    }

    public static String pureCountryCode(String str) {
        AppMethodBeat.i(157765);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(157765);
            return "";
        }
        String replace = str.replace("+", "");
        AppMethodBeat.o(157765);
        return replace;
    }

    public static String countryCodeWithPlus(String str) {
        AppMethodBeat.i(157766);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(157766);
            return "";
        } else if (str.startsWith("+")) {
            AppMethodBeat.o(157766);
            return str;
        } else {
            String concat = "+".concat(String.valueOf(str));
            AppMethodBeat.o(157766);
            return concat;
        }
    }

    public static String pureCountryName(String str) {
        AppMethodBeat.i(230366);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(230366);
            return "";
        }
        int indexOf = str.indexOf("（+");
        if (indexOf >= 0) {
            String substring = str.substring(0, indexOf);
            AppMethodBeat.o(230366);
            return substring;
        }
        AppMethodBeat.o(230366);
        return str;
    }

    public static String countryNameWithCode(String str, String str2) {
        AppMethodBeat.i(157767);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(157767);
            return "";
        }
        String str3 = str + "（+" + str2 + "）";
        AppMethodBeat.o(157767);
        return str3;
    }

    public String formatNumber(String str, String str2) {
        AppMethodBeat.i(157768);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(157768);
            return str2;
        }
        if (config == null) {
            config = new PhoneFormaterConfig();
        }
        for (PhoneFormaterConfig.Country country : config.contryList) {
            if (!(country.countrycode == null || !str.trim().toLowerCase().equals(country.countrycode.trim().toLowerCase()) || country.formatList == null)) {
                String pureNumber = pureNumber(str2);
                if (pureNumber == null || pureNumber.length() <= country.minlen) {
                    for (PhoneFormaterConfig.Format format : country.formatList) {
                        if (Util.isNullOrNil(format.leading)) {
                            if (country.formatList.size() > 1) {
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append(pureNumber);
                                int length = pureNumber.length();
                                if (length <= getMatchLenght(format.formatregex, country.maxlen)) {
                                    while (stringBuffer.toString().length() < country.maxlen) {
                                        stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                    }
                                    String format2 = format(format.formatregex, format.pattern, stringBuffer.toString());
                                    int i2 = 0;
                                    for (int i3 = 0; i3 < format2.length(); i3++) {
                                        char charAt = format2.charAt(i3);
                                        if (i2 >= length) {
                                            format2 = format2.substring(0, i3);
                                        }
                                        if (!(charAt == ' ' || charAt == '-' || charAt == 12290)) {
                                            i2++;
                                        }
                                    }
                                    AppMethodBeat.o(157768);
                                    return format2;
                                }
                            } else {
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append(pureNumber);
                                int length2 = pureNumber.length();
                                while (stringBuffer2.toString().length() < country.maxlen) {
                                    stringBuffer2.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                }
                                String format3 = format(format.formatregex, format.pattern, stringBuffer2.toString());
                                int i4 = 0;
                                for (int i5 = 0; i5 < format3.length(); i5++) {
                                    char charAt2 = format3.charAt(i5);
                                    if (i4 >= length2) {
                                        format3 = format3.substring(0, i5);
                                    }
                                    if (!(charAt2 == ' ' || charAt2 == '-' || charAt2 == 12290)) {
                                        i4++;
                                    }
                                }
                                AppMethodBeat.o(157768);
                                return format3;
                            }
                        } else if (Pattern.compile(format.leading).matcher(pureNumber).lookingAt()) {
                            StringBuffer stringBuffer3 = new StringBuffer();
                            stringBuffer3.append(pureNumber);
                            int length3 = pureNumber.length();
                            while (stringBuffer3.toString().length() < country.maxlen) {
                                stringBuffer3.append(pureNumber.charAt(length3 - 1));
                            }
                            String format4 = format(format.formatregex, format.pattern, stringBuffer3.toString());
                            int i6 = 0;
                            for (int i7 = 0; i7 < format4.length(); i7++) {
                                char charAt3 = format4.charAt(i7);
                                if (i6 >= length3) {
                                    format4 = format4.substring(0, i7);
                                }
                                if (!(charAt3 == ' ' || charAt3 == '-' || charAt3 == 12290)) {
                                    i6++;
                                }
                            }
                            AppMethodBeat.o(157768);
                            return format4;
                        }
                    }
                    continue;
                } else {
                    AppMethodBeat.o(157768);
                    return pureNumber;
                }
            }
        }
        AppMethodBeat.o(157768);
        return str2;
    }

    private int getMatchLenght(String str, int i2) {
        AppMethodBeat.i(157769);
        Pattern compile = Pattern.compile(str);
        String str2 = "1";
        int i3 = 0;
        while (i3 < i2 && !compile.matcher(str2).find()) {
            str2 = str2 + "1";
            i3++;
        }
        int i4 = i3 + 1;
        AppMethodBeat.o(157769);
        return i4;
    }

    private String format(String str, String str2, String str3) {
        AppMethodBeat.i(157770);
        Matcher matcher = Pattern.compile(str).matcher(str3);
        if (matcher.find()) {
            String replaceAll = matcher.replaceAll(str2);
            AppMethodBeat.o(157770);
            return replaceAll;
        }
        AppMethodBeat.o(157770);
        return str3;
    }
}
