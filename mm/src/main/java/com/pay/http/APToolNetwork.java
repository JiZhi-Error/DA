package com.pay.http;

import android.text.TextUtils;
import android.util.Patterns;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class APToolNetwork {
    private static final int BASE_16 = 16;
    private static final int IPV6_MAX_HEX_DIGITS_PER_GROUP = 4;
    private static final int IPV6_MAX_HEX_GROUPS = 8;
    private static final int MAX_UNSIGNED_SHORT = 65535;
    private static final Pattern PATTERN = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    static {
        AppMethodBeat.i(193270);
        AppMethodBeat.o(193270);
    }

    public static boolean validateIPV4(String str) {
        AppMethodBeat.i(193266);
        boolean matches = Patterns.IP_ADDRESS.matcher(str).matches();
        AppMethodBeat.o(193266);
        return matches;
    }

    public static boolean isIPAddress(String str) {
        AppMethodBeat.i(193267);
        if (validateIPV4(str) || validateIPV6(str)) {
            AppMethodBeat.o(193267);
            return true;
        }
        AppMethodBeat.o(193267);
        return false;
    }

    public static boolean validateIPV6(String str) {
        AppMethodBeat.i(193268);
        boolean contains = str.contains("::");
        if (contains && str.indexOf("::") != str.lastIndexOf("::")) {
            AppMethodBeat.o(193268);
            return false;
        } else if ((!str.startsWith(":") || str.startsWith("::")) && (!str.endsWith(":") || str.endsWith("::"))) {
            String[] split = str.split(":");
            if (contains) {
                ArrayList arrayList = new ArrayList(Arrays.asList(split));
                if (str.endsWith("::")) {
                    arrayList.add("");
                } else if (str.startsWith("::") && !arrayList.isEmpty()) {
                    arrayList.remove(0);
                }
                split = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            if (split.length > 8) {
                AppMethodBeat.o(193268);
                return false;
            }
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < split.length; i4++) {
                String str2 = split[i4];
                if (str2.length() == 0) {
                    i3++;
                    if (i3 > 1) {
                        AppMethodBeat.o(193268);
                        return false;
                    }
                    i2++;
                } else if (i4 != split.length - 1 || !str2.contains(".")) {
                    if (str2.length() > 4) {
                        AppMethodBeat.o(193268);
                        return false;
                    }
                    try {
                        int parseInt = Integer.parseInt(str2, 16);
                        if (parseInt < 0 || parseInt > 65535) {
                            AppMethodBeat.o(193268);
                            return false;
                        }
                        i3 = 0;
                        i2++;
                    } catch (NumberFormatException e2) {
                        AppMethodBeat.o(193268);
                        return false;
                    }
                } else if (!Patterns.IP_ADDRESS.matcher(str2).matches()) {
                    AppMethodBeat.o(193268);
                    return false;
                } else {
                    i2 += 2;
                    i3 = 0;
                }
            }
            if (i2 > 8 || (i2 < 8 && !contains)) {
                AppMethodBeat.o(193268);
                return false;
            }
            AppMethodBeat.o(193268);
            return true;
        } else {
            AppMethodBeat.o(193268);
            return false;
        }
    }

    public static String joinDomainPort(String str, String str2) {
        AppMethodBeat.i(193269);
        if (!TextUtils.isEmpty(str2)) {
            if (validateIPV4(str)) {
                str = str + ":" + str2;
            } else if (validateIPV6(str)) {
                str = "[" + str + "]:" + str2;
            }
        }
        AppMethodBeat.o(193269);
        return str;
    }
}
