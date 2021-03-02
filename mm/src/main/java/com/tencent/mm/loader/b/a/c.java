package com.tencent.mm.loader.b.a;

import android.graphics.Bitmap;
import android.system.ErrnoException;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.OutputStream;
import kotlin.g.b.p;

public final class c {
    private static final String TAG = TAG;
    public static final c hYJ = new c();

    private c() {
    }

    public static OutputStream Hg(String str) {
        boolean z;
        OutputStream outputStream;
        p.h(str, "filePath");
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        try {
            o heq = new o(str).heq();
            if (heq != null) {
                heq.mkdirs();
            }
            outputStream = s.LM(str);
        } catch (Exception e2) {
            Log.e(TAG, "obtainOutputStream:%s", e2);
            outputStream = null;
        }
        return outputStream;
    }

    public static boolean a(byte[] bArr, OutputStream outputStream) {
        p.h(bArr, "data");
        p.h(outputStream, "stream");
        try {
            outputStream.write(bArr);
            return true;
        } catch (ErrnoException e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005d, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005e, code lost:
        r4 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r11, java.io.OutputStream r12) {
        /*
            r5 = 0
            r10 = 0
            java.lang.String r2 = "filePath"
            kotlin.g.b.p.h(r11, r2)
            java.lang.String r2 = "stream"
            kotlin.g.b.p.h(r12, r2)
            boolean r2 = com.tencent.mm.vfs.s.YS(r11)
            if (r2 == 0) goto L_0x0056
            java.io.InputStream r2 = com.tencent.mm.vfs.s.openRead(r11)     // Catch:{ Throwable -> 0x0038 }
            if (r2 == 0) goto L_0x0056
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ Throwable -> 0x0038 }
            r0 = r2
            java.io.InputStream r0 = (java.io.InputStream) r0     // Catch:{ Throwable -> 0x0030, all -> 0x005d }
            r3 = r0
            r4 = 4096(0x1000, float:5.74E-42)
            byte[] r4 = new byte[r4]     // Catch:{ Throwable -> 0x0030, all -> 0x005d }
        L_0x0024:
            int r6 = r3.read(r4)     // Catch:{ Throwable -> 0x0030, all -> 0x005d }
            r7 = -1
            if (r6 == r7) goto L_0x0057
            r7 = 0
            r12.write(r4, r7, r6)     // Catch:{ Throwable -> 0x0030, all -> 0x005d }
            goto L_0x0024
        L_0x0030:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r4 = move-exception
            r5 = r3
        L_0x0034:
            kotlin.f.b.a(r2, r5)
            throw r4
        L_0x0038:
            r2 = move-exception
            com.tencent.mm.plugin.report.e r3 = com.tencent.mm.plugin.report.e.INSTANCE
            r4 = 1299(0x513, double:6.42E-321)
            r6 = 12
            r8 = 1
            r3.idkeyStat(r4, r6, r8, r10)
            java.lang.String r3 = com.tencent.mm.loader.b.a.c.TAG
            java.lang.String r4 = "save failed. path:"
            java.lang.String r5 = java.lang.String.valueOf(r11)
            java.lang.String r4 = r4.concat(r5)
            java.lang.Object[] r5 = new java.lang.Object[r10]
            com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(r3, r2, r4, r5)
        L_0x0056:
            return r10
        L_0x0057:
            r3 = 0
            kotlin.f.b.a(r2, r3)
            r10 = 1
            goto L_0x0056
        L_0x005d:
            r3 = move-exception
            r4 = r3
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.loader.b.a.c.a(java.lang.String, java.io.OutputStream):boolean");
    }

    public static /* synthetic */ boolean a(Bitmap bitmap, OutputStream outputStream) {
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        p.h(bitmap, "bm");
        p.h(compressFormat, "format");
        p.h(outputStream, "stream");
        com.tencent.mm.ac.c cVar = new com.tencent.mm.ac.c("compress");
        boolean compress = bitmap.compress(compressFormat, 80, outputStream);
        if (!compress) {
            Log.e(TAG, "compress error %s", Util.getStack().toString());
        }
        cVar.aBw();
        return compress;
    }
}
