package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class SpellMap {
    public static HashMap<String, String> jNI = new HashMap<>();

    public static native String spellGetJni(int i2, int i3);

    public static String x(char c2) {
        String str;
        AppMethodBeat.i(132983);
        int y = y(c2);
        if (y < 65536) {
            String valueOf = String.valueOf(c2);
            AppMethodBeat.o(132983);
            return valueOf;
        }
        int i2 = y >> 16;
        int i3 = y & 255;
        if (i2 < 129 || i2 > 253) {
            str = null;
        } else if (i3 < 63 || i3 > 254) {
            str = null;
        } else {
            str = spellGetJni(i2 - 129, i3 - 63);
        }
        if (str == null) {
            AppMethodBeat.o(132983);
            return null;
        }
        String[] split = str.split(",");
        if (split == null || split.length < 2) {
            AppMethodBeat.o(132983);
            return str;
        }
        String str2 = split[0];
        AppMethodBeat.o(132983);
        return str2;
    }

    private static int y(char c2) {
        AppMethodBeat.i(132984);
        if (c2 <= 128) {
            AppMethodBeat.o(132984);
            return c2;
        }
        try {
            byte[] bytes = String.valueOf(c2).getBytes("GBK");
            if (bytes == null || bytes.length > 2 || bytes.length <= 0) {
                AppMethodBeat.o(132984);
                return 0;
            } else if (bytes.length == 1) {
                byte b2 = bytes[0];
                AppMethodBeat.o(132984);
                return b2;
            } else if (bytes.length == 2) {
                int i2 = ((bytes[0] + 256) << 16) + bytes[1] + 256;
                AppMethodBeat.o(132984);
                return i2;
            } else {
                AppMethodBeat.o(132984);
                return 0;
            }
        } catch (UnsupportedEncodingException e2) {
            AppMethodBeat.o(132984);
            return 0;
        }
    }

    static {
        AppMethodBeat.i(132985);
        AppMethodBeat.o(132985);
    }
}
