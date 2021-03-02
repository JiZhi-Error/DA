package com.google.android.gms.common.util;

import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HttpUtils {
    private static final Pattern zzaab = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final Pattern zzaac = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    private static final Pattern zzaad = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    static {
        AppMethodBeat.i(5239);
        AppMethodBeat.o(5239);
    }

    private HttpUtils() {
    }

    private static String decode(String str, String str2) {
        AppMethodBeat.i(5234);
        if (str2 == null) {
            str2 = KindaConfigCacheStg.SAVE_CHARSET;
        }
        try {
            String decode = URLDecoder.decode(str, str2);
            AppMethodBeat.o(5234);
            return decode;
        } catch (UnsupportedEncodingException e2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(e2);
            AppMethodBeat.o(5234);
            throw illegalArgumentException;
        }
    }

    public static boolean isIPv4Address(String str) {
        AppMethodBeat.i(5235);
        boolean matches = zzaab.matcher(str).matches();
        AppMethodBeat.o(5235);
        return matches;
    }

    public static boolean isIPv6Address(String str) {
        AppMethodBeat.i(5238);
        if (isIPv6StdAddress(str) || isIPv6HexCompressedAddress(str)) {
            AppMethodBeat.o(5238);
            return true;
        }
        AppMethodBeat.o(5238);
        return false;
    }

    public static boolean isIPv6HexCompressedAddress(String str) {
        AppMethodBeat.i(5237);
        boolean matches = zzaad.matcher(str).matches();
        AppMethodBeat.o(5237);
        return matches;
    }

    public static boolean isIPv6StdAddress(String str) {
        AppMethodBeat.i(5236);
        boolean matches = zzaac.matcher(str).matches();
        AppMethodBeat.o(5236);
        return matches;
    }

    public static Map<String, String> parse(URI uri, String str) {
        AppMethodBeat.i(5233);
        Map<String, String> emptyMap = Collections.emptyMap();
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && rawQuery.length() > 0) {
            HashMap hashMap = new HashMap();
            Scanner scanner = new Scanner(rawQuery);
            scanner.useDelimiter("&");
            while (scanner.hasNext()) {
                String[] split = scanner.next().split("=");
                if (split.length == 0 || split.length > 2) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("bad parameter");
                    AppMethodBeat.o(5233);
                    throw illegalArgumentException;
                }
                String decode = decode(split[0], str);
                String str2 = null;
                if (split.length == 2) {
                    str2 = decode(split[1], str);
                }
                hashMap.put(decode, str2);
            }
            emptyMap = hashMap;
        }
        AppMethodBeat.o(5233);
        return emptyMap;
    }
}
