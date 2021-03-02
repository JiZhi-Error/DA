package com.tencent.mm.toolkit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

final class d {

    public static class b {
        public static void U(File file) {
            AppMethodBeat.i(196821);
            if (file != null) {
                file.delete();
            }
            AppMethodBeat.o(196821);
        }
    }

    public static class c {
        public static void closeQuietly(Closeable closeable) {
            AppMethodBeat.i(196822);
            if (closeable != null) {
                try {
                    closeable.close();
                    AppMethodBeat.o(196822);
                    return;
                } catch (IOException e2) {
                    e.gGf();
                }
            }
            AppMethodBeat.o(196822);
        }
    }

    public static class a {
        private static final char[] gqp = "0123456789ABCDEF".toCharArray();

        static {
            AppMethodBeat.i(196820);
            AppMethodBeat.o(196820);
        }

        public static String toHexString(byte[] bArr) {
            AppMethodBeat.i(196819);
            char[] cArr = new char[(bArr.length * 2)];
            for (int i2 = 0; i2 < bArr.length; i2++) {
                int i3 = bArr[i2] & 255;
                cArr[i2 * 2] = gqp[i3 >>> 4];
                cArr[(i2 * 2) + 1] = gqp[i3 & 15];
            }
            String str = new String(cArr);
            AppMethodBeat.o(196819);
            return str;
        }
    }
}
