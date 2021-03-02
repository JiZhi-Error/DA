package com.tencent.qqmusic.mediaplayer.perf;

public class FileLogger {
    private static final String TAG = "FileLogger";

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f A[SYNTHETIC, Splitter:B:16:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003f A[SYNTHETIC, Splitter:B:24:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void write(java.lang.StringBuilder r5, java.io.File r6, boolean r7) {
        /*
            r4 = 114184(0x1be08, float:1.60006E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            r2 = 0
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch:{ IOException -> 0x0022, all -> 0x003b }
            r1.<init>(r6, r7)     // Catch:{ IOException -> 0x0022, all -> 0x003b }
            java.lang.String r0 = r5.toString()     // Catch:{ IOException -> 0x004e }
            r1.write(r0)     // Catch:{ IOException -> 0x004e }
            r1.flush()     // Catch:{ IOException -> 0x004e }
            r1.close()     // Catch:{ IOException -> 0x001d }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x001c:
            return
        L_0x001d:
            r0 = move-exception
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x001c
        L_0x0022:
            r0 = move-exception
            r1 = r2
        L_0x0024:
            java.lang.String r2 = "FileLogger"
            java.lang.String r3 = "[write] failed!"
            com.tencent.qqmusic.mediaplayer.util.Logger.e(r2, r3, r0)     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x0046
            r1.close()     // Catch:{ IOException -> 0x0036 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x001c
        L_0x0036:
            r0 = move-exception
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x001c
        L_0x003b:
            r0 = move-exception
            r1 = r2
        L_0x003d:
            if (r1 == 0) goto L_0x0042
            r1.close()     // Catch:{ IOException -> 0x004a }
        L_0x0042:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r0
        L_0x0046:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x001c
        L_0x004a:
            r1 = move-exception
            goto L_0x0042
        L_0x004c:
            r0 = move-exception
            goto L_0x003d
        L_0x004e:
            r0 = move-exception
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqmusic.mediaplayer.perf.FileLogger.write(java.lang.StringBuilder, java.io.File, boolean):void");
    }
}
