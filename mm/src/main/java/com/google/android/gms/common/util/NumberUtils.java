package com.google.android.gms.common.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
public class NumberUtils {
    private NumberUtils() {
    }

    public static int compare(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    public static int compare(long j2, long j3) {
        if (j2 < j3) {
            return -1;
        }
        return j2 == j3 ? 0 : 1;
    }

    public static boolean isNumeric(String str) {
        AppMethodBeat.i(5274);
        try {
            Long.parseLong(str);
            AppMethodBeat.o(5274);
            return true;
        } catch (NumberFormatException e2) {
            AppMethodBeat.o(5274);
            return false;
        }
    }

    public static long parseHexLong(String str) {
        AppMethodBeat.i(5273);
        if (str.length() > 16) {
            NumberFormatException numberFormatException = new NumberFormatException(new StringBuilder(String.valueOf(str).length() + 37).append("Invalid input: ").append(str).append(" exceeds 16 characters").toString());
            AppMethodBeat.o(5273);
            throw numberFormatException;
        } else if (str.length() == 16) {
            long parseLong = Long.parseLong(str.substring(8), 16) | (Long.parseLong(str.substring(0, 8), 16) << 32);
            AppMethodBeat.o(5273);
            return parseLong;
        } else {
            long parseLong2 = Long.parseLong(str, 16);
            AppMethodBeat.o(5273);
            return parseLong2;
        }
    }
}
