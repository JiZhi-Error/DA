package com.tencent.h.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;

public final class e {
    public static void closeQuietly(Closeable closeable) {
        AppMethodBeat.i(214639);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                AppMethodBeat.o(214639);
                return;
            }
        }
        AppMethodBeat.o(214639);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e A[SYNTHETIC, Splitter:B:13:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046 A[SYNTHETIC, Splitter:B:24:0x0046] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] aa(java.io.File r7) {
        /*
            r6 = 214640(0x34670, float:3.00775E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ Throwable -> 0x0057, all -> 0x0041 }
            java.lang.String r2 = "r"
            r1.<init>(r7, r2)     // Catch:{ Throwable -> 0x0057, all -> 0x0041 }
            long r2 = r1.length()     // Catch:{ Throwable -> 0x0028 }
            int r0 = (int) r2     // Catch:{ Throwable -> 0x0028 }
            long r4 = (long) r0     // Catch:{ Throwable -> 0x0028 }
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0035
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Throwable -> 0x0028 }
            java.lang.String r2 = ""
            r0.<init>(r2)     // Catch:{ Throwable -> 0x0028 }
            r2 = 214640(0x34670, float:3.00775E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)     // Catch:{ Throwable -> 0x0028 }
            throw r0     // Catch:{ Throwable -> 0x0028 }
        L_0x0028:
            r0 = move-exception
        L_0x0029:
            r0 = 0
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0053 }
            if (r1 == 0) goto L_0x0031
            r1.close()     // Catch:{ IOException -> 0x004f }
        L_0x0031:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
        L_0x0034:
            return r0
        L_0x0035:
            byte[] r0 = new byte[r0]
            r1.readFully(r0)
            r1.close()     // Catch:{ IOException -> 0x004d }
        L_0x003d:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            goto L_0x0034
        L_0x0041:
            r1 = move-exception
            r2 = r1
            r3 = r0
        L_0x0044:
            if (r3 == 0) goto L_0x0049
            r3.close()     // Catch:{ IOException -> 0x0051 }
        L_0x0049:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            throw r2
        L_0x004d:
            r1 = move-exception
            goto L_0x003d
        L_0x004f:
            r1 = move-exception
            goto L_0x0031
        L_0x0051:
            r0 = move-exception
            goto L_0x0049
        L_0x0053:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L_0x0044
        L_0x0057:
            r1 = move-exception
            r1 = r0
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.h.c.e.aa(java.io.File):byte[]");
    }
}
