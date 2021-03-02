package com.google.android.gms.common.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@VisibleForTesting
public class Strings {
    private static final Pattern zzaak = Pattern.compile("\\$\\{(.*?)\\}");

    static {
        AppMethodBeat.i(5295);
        AppMethodBeat.o(5295);
    }

    private Strings() {
    }

    public static String capitalize(String str) {
        AppMethodBeat.i(5292);
        if (str.length() == 0) {
            AppMethodBeat.o(5292);
            return str;
        }
        char charAt = str.charAt(0);
        char upperCase = Character.toUpperCase(charAt);
        if (charAt == upperCase) {
            AppMethodBeat.o(5292);
            return str;
        }
        String substring = str.substring(1);
        String sb = new StringBuilder(String.valueOf(substring).length() + 1).append(upperCase).append(substring).toString();
        AppMethodBeat.o(5292);
        return sb;
    }

    public static String emptyToNull(String str) {
        AppMethodBeat.i(5291);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(5291);
            return null;
        }
        AppMethodBeat.o(5291);
        return str;
    }

    public static String format(String str, Bundle bundle) {
        AppMethodBeat.i(5290);
        Matcher matcher = zzaak.matcher(str);
        if (matcher.find()) {
            StringBuffer stringBuffer = new StringBuffer();
            do {
                String group = matcher.group(1);
                Object obj = bundle.get(group);
                if (obj != null) {
                    matcher.appendReplacement(stringBuffer, obj.toString());
                } else if (bundle.containsKey(group)) {
                    matcher.appendReplacement(stringBuffer, BuildConfig.COMMAND);
                } else {
                    matcher.appendReplacement(stringBuffer, "");
                }
            } while (matcher.find());
            matcher.appendTail(stringBuffer);
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(5290);
            return stringBuffer2;
        }
        AppMethodBeat.o(5290);
        return str;
    }

    public static boolean isEmptyOrWhitespace(String str) {
        AppMethodBeat.i(5293);
        if (str == null || str.trim().isEmpty()) {
            AppMethodBeat.o(5293);
            return true;
        }
        AppMethodBeat.o(5293);
        return false;
    }

    public static String nullToEmpty(String str) {
        return str == null ? "" : str;
    }

    public static String padEnd(String str, int i2, char c2) {
        AppMethodBeat.i(5294);
        Preconditions.checkNotNull(str);
        if (str.length() >= i2) {
            AppMethodBeat.o(5294);
            return str;
        }
        StringBuilder sb = new StringBuilder(i2);
        sb.append(str);
        for (int length = str.length(); length < i2; length++) {
            sb.append(c2);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(5294);
        return sb2;
    }
}
