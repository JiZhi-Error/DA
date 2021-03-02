package com.tencent.mm.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class j extends l {
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap a(java.io.InputStream r8, android.graphics.BitmapFactory.Options r9) {
        /*
            r7 = 156426(0x2630a, float:2.192E-40)
            r1 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
            com.tencent.mm.memory.h r0 = com.tencent.mm.memory.h.itz     // Catch:{ Exception -> 0x0026, all -> 0x0045 }
            java.lang.Object r0 = r0.acquire()     // Catch:{ Exception -> 0x0026, all -> 0x0045 }
            java.nio.ByteBuffer r0 = (java.nio.ByteBuffer) r0     // Catch:{ Exception -> 0x0026, all -> 0x0045 }
            r2 = 0
            r3 = 0
            android.graphics.BitmapFactory$Options r2 = a(r8, r9, r0, r2, r3)     // Catch:{ Exception -> 0x005a, all -> 0x0053 }
            r3 = 0
            android.graphics.Bitmap r1 = b(r8, r3, r2)     // Catch:{ Exception -> 0x005a, all -> 0x0053 }
            if (r0 == 0) goto L_0x005f
            com.tencent.mm.memory.h r2 = com.tencent.mm.memory.h.itz
            r2.release(r0)
            r0 = r1
        L_0x0022:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            return r0
        L_0x0026:
            r0 = move-exception
            r2 = r0
            r3 = r1
        L_0x0029:
            java.lang.String r0 = "MicroMsg.InBitmapFactory"
            java.lang.String r4 = "error decode bitmap %s"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0057 }
            r6 = 0
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0057 }
            r5[r6] = r2     // Catch:{ all -> 0x0057 }
            com.tencent.mm.sdk.platformtools.Log.e(r0, r4, r5)     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x005d
            com.tencent.mm.memory.h r0 = com.tencent.mm.memory.h.itz
            r0.release(r3)
            r0 = r1
            goto L_0x0022
        L_0x0045:
            r0 = move-exception
            r2 = r0
            r3 = r1
        L_0x0048:
            if (r3 == 0) goto L_0x004f
            com.tencent.mm.memory.h r0 = com.tencent.mm.memory.h.itz
            r0.release(r3)
        L_0x004f:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            throw r2
        L_0x0053:
            r1 = move-exception
            r2 = r1
            r3 = r0
            goto L_0x0048
        L_0x0057:
            r0 = move-exception
            r2 = r0
            goto L_0x0048
        L_0x005a:
            r2 = move-exception
            r3 = r0
            goto L_0x0029
        L_0x005d:
            r0 = r1
            goto L_0x0022
        L_0x005f:
            r0 = r1
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.memory.j.a(java.io.InputStream, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    @Override // com.tencent.mm.memory.l
    public final Bitmap a(String str, BitmapFactory.Options options) {
        InputStream inputStream;
        Throwable th;
        Exception e2;
        Bitmap bitmap = null;
        AppMethodBeat.i(156427);
        try {
            inputStream = s.openRead(str);
            try {
                bitmap = a(inputStream, options);
                Util.qualityClose(inputStream);
            } catch (Exception e3) {
                e2 = e3;
                try {
                    Log.printErrStackTrace("MicroMsg.InBitmapFactory", e2, "error decode bitmap %s", e2.getMessage());
                    Util.qualityClose(inputStream);
                    AppMethodBeat.o(156427);
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    Util.qualityClose(inputStream);
                    AppMethodBeat.o(156427);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            inputStream = null;
            Log.printErrStackTrace("MicroMsg.InBitmapFactory", e2, "error decode bitmap %s", e2.getMessage());
            Util.qualityClose(inputStream);
            AppMethodBeat.o(156427);
            return bitmap;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            Util.qualityClose(inputStream);
            AppMethodBeat.o(156427);
            throw th;
        }
        AppMethodBeat.o(156427);
        return bitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054  */
    @Override // com.tencent.mm.memory.l
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap a(java.lang.String r10, android.graphics.Rect r11, android.graphics.BitmapFactory.Options r12) {
        /*
        // Method dump skipped, instructions count: 114
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.memory.j.a(java.lang.String, android.graphics.Rect, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    @TargetApi(19)
    private static BitmapFactory.Options a(InputStream inputStream, BitmapFactory.Options options, ByteBuffer byteBuffer, boolean z, Rect rect) {
        int i2;
        Bitmap g2;
        boolean z2;
        int i3;
        AppMethodBeat.i(156429);
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        if (byteBuffer != null) {
            options.inTempStorage = byteBuffer.array();
        }
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("cannot get the bitmap size!");
            AppMethodBeat.o(156429);
            throw illegalArgumentException;
        }
        options.inJustDecodeBounds = false;
        options.inDither = true;
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (rect == null) {
            Log.i("MicroMsg.InBitmapFactory", "options.outWidth: %s, options.outHeight: %s, sampleSize: %s", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(options.inSampleSize));
            i2 = i5;
        } else {
            i4 = rect.right - rect.left;
            int i6 = rect.bottom - rect.top;
            Log.i("MicroMsg.InBitmapFactory", "region decode, width: %s, height: %s, rect: %s", Integer.valueOf(i4), Integer.valueOf(i6), rect);
            i2 = i6;
        }
        if (z) {
            g2 = (Bitmap) c.itr.e(c.f(Integer.valueOf(i4 * i2)));
            if (g2 != null && d.oD(19)) {
                g2.reconfigure(i4, i2, Bitmap.Config.ARGB_8888);
            }
        } else {
            g2 = c.itr.g(c.f(Integer.valueOf(i2 * i4)));
        }
        Object[] objArr = new Object[5];
        objArr[0] = g2;
        if (g2 == null || g2.isRecycled()) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[1] = Boolean.valueOf(z2);
        objArr[2] = Boolean.valueOf(z);
        if (g2 != null) {
            i3 = g2.getWidth();
        } else {
            i3 = 0;
        }
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = Integer.valueOf(g2 != null ? g2.getHeight() : 0);
        Log.i("MicroMsg.InBitmapFactory", "bitmapToReuse: %s, isRecycle: %s, isRegionDecode: %s, width: %s, height: %s", objArr);
        if (g2 != null && g2.isMutable() && !g2.isRecycled()) {
            options.inBitmap = g2;
        }
        options.inMutable = true;
        BitmapUtil.bindlowMemeryOption(options);
        Log.i("MicroMsg.InBitmapFactory", "mimetype: %s", options.outMimeType);
        AppMethodBeat.o(156429);
        return options;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap b(java.io.InputStream r12, android.graphics.Rect r13, android.graphics.BitmapFactory.Options r14) {
        /*
        // Method dump skipped, instructions count: 323
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.memory.j.b(java.io.InputStream, android.graphics.Rect, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    @Override // com.tencent.mm.memory.l
    public final void x(Bitmap bitmap) {
        AppMethodBeat.i(156431);
        if (bitmap != null && !bitmap.isRecycled()) {
            c.itr.f(bitmap);
        }
        AppMethodBeat.o(156431);
    }
}
