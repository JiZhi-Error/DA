package com.google.android.gms.auth;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CookieUtil {
    private CookieUtil() {
    }

    public static String getCookieUrl(String str, Boolean bool) {
        AppMethodBeat.i(10595);
        Preconditions.checkNotEmpty(str);
        String str2 = zzd(bool) ? "https" : "http";
        String sb = new StringBuilder(String.valueOf(str2).length() + 3 + String.valueOf(str).length()).append(str2).append("://").append(str).toString();
        AppMethodBeat.o(10595);
        return sb;
    }

    public static String getCookieValue(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, Long l) {
        AppMethodBeat.i(10596);
        StringBuilder append = new StringBuilder(str).append('=');
        if (!TextUtils.isEmpty(str2)) {
            append.append(str2);
        }
        if (zzd(bool)) {
            append.append(";HttpOnly");
        }
        if (zzd(bool2)) {
            append.append(";Secure");
        }
        if (!TextUtils.isEmpty(str3)) {
            append.append(";Domain=").append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            append.append(";Path=").append(str4);
        }
        if (l != null && l.longValue() > 0) {
            append.append(";Max-Age=").append(l);
        }
        String sb = append.toString();
        AppMethodBeat.o(10596);
        return sb;
    }

    private static boolean zzd(Boolean bool) {
        AppMethodBeat.i(10594);
        if (bool == null || !bool.booleanValue()) {
            AppMethodBeat.o(10594);
            return false;
        }
        AppMethodBeat.o(10594);
        return true;
    }
}
