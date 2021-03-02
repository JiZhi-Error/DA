package com.google.android.gms.common.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class GmsVersionParser {
    public static final int UNKNOWN = -1;
    private static Pattern zzzy = null;

    private GmsVersionParser() {
    }

    public static int parseBuildMajorVersion(int i2) {
        if (i2 == -1) {
            return -1;
        }
        return i2 / 100000;
    }

    public static long parseBuildNumber(String str) {
        long j2 = -1;
        AppMethodBeat.i(5219);
        if (str == null) {
            AppMethodBeat.o(5219);
        } else {
            Matcher matcher = zzdc().matcher(str);
            if (matcher.find()) {
                try {
                    j2 = Long.parseLong(matcher.group(2));
                    AppMethodBeat.o(5219);
                } catch (NumberFormatException e2) {
                }
            }
            AppMethodBeat.o(5219);
        }
        return j2;
    }

    public static int parseBuildType(String str) {
        AppMethodBeat.i(5221);
        long parseVariantCode = parseVariantCode(str);
        if (parseVariantCode == -1) {
            AppMethodBeat.o(5221);
            return -1;
        }
        int i2 = (int) (parseVariantCode / 10000);
        AppMethodBeat.o(5221);
        return i2;
    }

    public static int parseBuildVersion(int i2) {
        if (i2 == -1) {
            return -1;
        }
        return i2 / 1000;
    }

    public static int parseScreenDensity(String str) {
        AppMethodBeat.i(5223);
        long parseVariantCode = parseVariantCode(str);
        if (parseVariantCode == -1) {
            AppMethodBeat.o(5223);
            return -1;
        }
        int i2 = (int) (parseVariantCode % 100);
        AppMethodBeat.o(5223);
        return i2;
    }

    public static int parseTargetArchitecture(String str) {
        AppMethodBeat.i(5222);
        long parseVariantCode = parseVariantCode(str);
        if (parseVariantCode == -1) {
            AppMethodBeat.o(5222);
            return -1;
        }
        int i2 = (int) ((parseVariantCode / 100) % 100);
        AppMethodBeat.o(5222);
        return i2;
    }

    public static long parseVariantCode(String str) {
        long j2 = -1;
        AppMethodBeat.i(5220);
        if (str == null) {
            AppMethodBeat.o(5220);
        } else {
            Matcher matcher = zzdc().matcher(str);
            if (matcher.find()) {
                try {
                    j2 = Long.parseLong(matcher.group(1));
                    AppMethodBeat.o(5220);
                } catch (NumberFormatException e2) {
                }
            }
            AppMethodBeat.o(5220);
        }
        return j2;
    }

    private static Pattern zzdc() {
        AppMethodBeat.i(5218);
        if (zzzy == null) {
            zzzy = Pattern.compile("\\((?:eng-)?(\\d+)-(.+?)[-)$]");
        }
        Pattern pattern = zzzy;
        AppMethodBeat.o(5218);
        return pattern;
    }
}
