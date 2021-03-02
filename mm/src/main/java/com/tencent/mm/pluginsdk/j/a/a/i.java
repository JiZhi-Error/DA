package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxmm.v2encoder;
import java.util.Locale;

public final class i {
    static final byte[] JZc = {48, -126, 1, 75, 48, -126, 1, 3, 6, 7, 42, -122, 72, -50, 61, 2, 1, 48, -127, -9, 2, 1, 1, 48, 44, 6, 7, 42, -122, 72, -50, 61, 1, 1, 2, 33, 0, -1, -1, -1, -1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 48, 91, 4, 32, -1, -1, -1, -1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -4, 4, 32, 90, -58, 53, -40, -86, 58, -109, -25, -77, -21, -67, 85, 118, -104, -122, -68, 101, 29, 6, -80, -52, 83, -80, -10, 59, -50, 60, 62, 39, -46, 96, 75, 3, 21, 0, -60, -99, 54, 8, -122, -25, 4, -109, 106, 102, 120, -31, 19, -99, 38, -73, -127, -97, 126, -112, 4, 65, 4, 107, 23, -47, -14, -31, 44, 66, 71, -8, -68, -26, -27, 99, -92, 64, -14, 119, 3, 125, -127, 45, -21, 51, -96, -12, -95, 57, 69, -40, -104, -62, -106, 79, -29, 66, -30, -2, 26, Byte.MAX_VALUE, -101, -114, -25, -21, 74, 124, 15, -98, 22, 43, -50, 51, 87, 107, 49, 94, -50, -53, -74, 64, 104, 55, -65, 81, -11, 2, 33, 0, -1, -1, -1, -1, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -68, -26, -6, -83, -89, 23, -98, -124, -13, -71, -54, -62, -4, 99, 37, 81, 2, 1, 1, 3, 66, 0, 4, 52, 4, -14, 45, -10, -68, -118, -59, 62, 64, -101, 93, 6, -54, -27, 79, 94, 126, -9, -80, -61, -63, -38, 115, -53, 70, -63, v2encoder.enumCODEC_vcodec2, -20, -32, -80, -80, 38, 102, v2encoder.enumCODEC_vcodec2, 27, 28, 61, -60, -33, 65, 93, -25, 30, 83, 66, -24, 28, 39, 24, 69, -104, 55, -63, 108, 5, 56, -63, -4, -5, 88, -49, -126, 85};
    private static final String JZd = (com.tencent.mm.loader.j.b.aKJ() + "CheckResUpdate/");
    private static final String JZe = (com.tencent.mm.loader.j.b.aKC() + "CheckResUpdate/");
    static final int[] JZf = {27, 35, 29, 38, 40, 33, 37, 39, 49, 46, 47, 56, 59, 62, 66, 54, 55, 63, 73, 79, 85, 87};

    static {
        AppMethodBeat.i(151977);
        AppMethodBeat.o(151977);
    }

    static String aee(String str) {
        String str2;
        AppMethodBeat.i(151974);
        if (str.startsWith(new StringBuilder("38.").toString()) || str.startsWith(new StringBuilder("56.").toString())) {
            str2 = JZe;
        } else {
            str2 = JZd;
        }
        FilePathGenerator.checkMkdir(str2);
        String str3 = str2 + str;
        AppMethodBeat.o(151974);
        return str3;
    }

    public static String kD(int i2, int i3) {
        AppMethodBeat.i(151975);
        String format = String.format(Locale.US, "%d.%d.data", Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(151975);
        return format;
    }

    static boolean bdY(String str) {
        AppMethodBeat.i(151976);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(151976);
            return false;
        }
        String aee = aee(str);
        boolean bej = com.tencent.mm.pluginsdk.j.a.d.a.bej(aee + ".decrypted") & com.tencent.mm.pluginsdk.j.a.d.a.bej(aee) & true & com.tencent.mm.pluginsdk.j.a.d.a.bej(aee + ".decompressed");
        AppMethodBeat.o(151976);
        return bej;
    }

    /* access modifiers changed from: package-private */
    public enum b {
        DoNothing(0),
        DoCache(1),
        DoDecrypt(2),
        DoDelete(4);
        
        final int cSx;

        public static b valueOf(String str) {
            AppMethodBeat.i(151971);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(151971);
            return bVar;
        }

        static {
            AppMethodBeat.i(151973);
            AppMethodBeat.o(151973);
        }

        private b(int i2) {
            this.cSx = i2;
        }

        static boolean ahT(int i2) {
            return i2 == DoNothing.cSx;
        }

        static boolean ahU(int i2) {
            return (DoCache.cSx & i2) > 0;
        }

        static boolean ahV(int i2) {
            return (DoDecrypt.cSx & i2) > 0;
        }

        static boolean ahW(int i2) {
            return (DoDelete.cSx & i2) > 0;
        }

        static int bdZ(String str) {
            AppMethodBeat.i(151972);
            if ("cache".equals(str)) {
                int i2 = DoCache.cSx;
                AppMethodBeat.o(151972);
                return i2;
            } else if ("delete".equals(str)) {
                int i3 = DoDelete.cSx;
                AppMethodBeat.o(151972);
                return i3;
            } else if ("decrypt".equals(str)) {
                int i4 = DoDecrypt.cSx;
                AppMethodBeat.o(151972);
                return i4;
            } else {
                int i5 = DoNothing.cSx;
                AppMethodBeat.o(151972);
                return i5;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public enum a {
        ENCRYPTION(1),
        COMPRESSION(2);
        
        final int cSx;

        public static a valueOf(String str) {
            AppMethodBeat.i(151968);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(151968);
            return aVar;
        }

        static {
            AppMethodBeat.i(151969);
            AppMethodBeat.o(151969);
        }

        private a(int i2) {
            this.cSx = i2;
        }

        static boolean ahQ(int i2) {
            return (ENCRYPTION.cSx & i2) > 0;
        }

        static boolean ahR(int i2) {
            return (COMPRESSION.cSx & i2) > 0;
        }

        static int gnL() {
            return ENCRYPTION.cSx | 0;
        }

        static int ahS(int i2) {
            return COMPRESSION.cSx | i2;
        }
    }
}
