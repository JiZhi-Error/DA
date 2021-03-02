package com.tencent.mm.plugin.downloader.d;

public final class e {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.nio.ByteBuffer, java.lang.Long> L(com.tencent.mm.vfs.o r6) {
        /*
            r0 = 0
            r3 = 177461(0x2b535, float:2.48676E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            boolean r1 = r6.exists()
            if (r1 == 0) goto L_0x0013
            boolean r1 = r6.isFile()
            if (r1 != 0) goto L_0x0017
        L_0x0013:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x0016:
            return r0
        L_0x0017:
            android.net.Uri r1 = r6.mUri     // Catch:{ all -> 0x0058 }
            java.lang.String r1 = com.tencent.mm.vfs.aa.z(r1)     // Catch:{ all -> 0x0058 }
            r2 = 0
            java.io.RandomAccessFile r2 = com.tencent.mm.vfs.s.dB(r1, r2)     // Catch:{ all -> 0x0058 }
            android.util.Pair r1 = com.tencent.mm.plugin.downloader.d.a.g(r2)     // Catch:{ all -> 0x0043 }
            java.lang.Object r0 = r1.second     // Catch:{ all -> 0x0043 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x0043 }
            long r4 = r0.longValue()     // Catch:{ all -> 0x0043 }
            boolean r0 = com.tencent.mm.plugin.downloader.d.h.c(r2, r4)     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x004e
            com.tencent.mm.plugin.downloader.d.a$b r0 = new com.tencent.mm.plugin.downloader.d.a$b     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = "ZIP64 APK not supported"
            r0.<init>(r1)     // Catch:{ all -> 0x0043 }
            r1 = 177461(0x2b535, float:2.48676E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)     // Catch:{ all -> 0x0043 }
            throw r0     // Catch:{ all -> 0x0043 }
        L_0x0043:
            r0 = move-exception
            r1 = r0
        L_0x0045:
            if (r2 == 0) goto L_0x004a
            r2.close()
        L_0x004a:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            throw r1
        L_0x004e:
            if (r2 == 0) goto L_0x0053
            r2.close()
        L_0x0053:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            r0 = r1
            goto L_0x0016
        L_0x0058:
            r1 = move-exception
            r2 = r0
            goto L_0x0045
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.downloader.d.e.L(com.tencent.mm.vfs.o):android.util.Pair");
    }
}
