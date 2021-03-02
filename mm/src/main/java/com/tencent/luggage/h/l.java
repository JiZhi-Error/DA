package com.tencent.luggage.h;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class l {
    public static String dL(String str) {
        AppMethodBeat.i(221210);
        try {
            String host = Uri.parse(str).getHost();
            AppMethodBeat.o(221210);
            return host;
        } catch (Exception e2) {
            AppMethodBeat.o(221210);
            return "";
        }
    }

    public static String dM(String str) {
        AppMethodBeat.i(140521);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(140521);
            return str;
        }
        int indexOf = str.indexOf(63);
        if (indexOf < 0) {
            AppMethodBeat.o(140521);
            return str;
        }
        String substring = str.substring(0, indexOf);
        AppMethodBeat.o(140521);
        return substring;
    }

    public static Map<String, String> dN(String str) {
        String substring;
        String substring2;
        AppMethodBeat.i(140522);
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(140522);
            return hashMap;
        }
        int indexOf = str.indexOf(63);
        if (indexOf < 0) {
            AppMethodBeat.o(140522);
            return hashMap;
        }
        int i2 = indexOf + 1;
        int lastIndexOf = str.lastIndexOf(38);
        int lastIndexOf2 = str.lastIndexOf(35);
        if (lastIndexOf2 < 0 || lastIndexOf2 <= lastIndexOf || i2 > lastIndexOf2) {
            substring = str.substring(i2, str.length());
        } else {
            substring = str.substring(i2, lastIndexOf2);
        }
        if (TextUtils.isEmpty(substring)) {
            AppMethodBeat.o(140522);
            return hashMap;
        }
        int i3 = 0;
        int length = substring.length();
        while (true) {
            int indexOf2 = substring.indexOf(38, i3);
            int i4 = indexOf2 != -1 ? indexOf2 : length;
            int indexOf3 = substring.indexOf(61, i3);
            if (indexOf3 > i4 || indexOf3 == -1) {
                indexOf3 = i4;
            }
            String decode = Uri.decode(substring.substring(i3, indexOf3));
            if (indexOf3 == i4) {
                substring2 = "";
            } else {
                substring2 = substring.substring(indexOf3 + 1, i4);
            }
            hashMap.put(decode, substring2);
            if (indexOf2 != -1) {
                i3 = indexOf2 + 1;
            } else {
                AppMethodBeat.o(140522);
                return hashMap;
            }
        }
    }

    public static boolean C(String str, String str2) {
        AppMethodBeat.i(140523);
        if (str == null || str2 == null || str.length() < 0 || str2.length() < 0) {
            AppMethodBeat.o(140523);
            return false;
        } else if (str2.length() > str.length()) {
            AppMethodBeat.o(140523);
            return false;
        } else if (str2.equalsIgnoreCase(str.substring(0, str2.length()))) {
            AppMethodBeat.o(140523);
            return true;
        } else {
            AppMethodBeat.o(140523);
            return false;
        }
    }
}
