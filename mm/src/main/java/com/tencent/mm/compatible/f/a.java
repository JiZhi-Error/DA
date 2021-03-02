package com.tencent.mm.compatible.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends BitmapFactory {
    private static AbstractC0303a gLb = null;

    /* renamed from: com.tencent.mm.compatible.f.a$a  reason: collision with other inner class name */
    public interface AbstractC0303a {
        Bitmap decodeResource(Resources resources, int i2, BitmapFactory.Options options);
    }

    public static void a(AbstractC0303a aVar) {
        gLb = aVar;
    }

    public static Bitmap decodeResource(Resources resources, int i2) {
        AppMethodBeat.i(155854);
        Bitmap decodeResource = decodeResource(resources, i2, null);
        AppMethodBeat.o(155854);
        return decodeResource;
    }

    public static Bitmap decodeResource(Resources resources, int i2, BitmapFactory.Options options) {
        Bitmap decodeResource;
        AppMethodBeat.i(155855);
        if (gLb == null || (decodeResource = gLb.decodeResource(resources, i2, options)) == null) {
            Bitmap a2 = a(resources, i2, options);
            AppMethodBeat.o(155855);
            return a2;
        }
        AppMethodBeat.o(155855);
        return decodeResource;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0054, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0055, code lost:
        r2 = r1;
        r3 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038 A[SYNTHETIC, Splitter:B:19:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0043 A[SYNTHETIC, Splitter:B:25:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0054 A[ExcHandler: all (r1v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:4:0x0014] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap a(android.content.res.Resources r5, int r6, android.graphics.BitmapFactory.Options r7) {
        /*
            r1 = 0
            r4 = 155856(0x260d0, float:2.18401E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            com.tencent.mm.sdk.platformtools.BitmapUtil.bindlowMemeryOption(r7)
            android.util.TypedValue r2 = new android.util.TypedValue     // Catch:{ Exception -> 0x0033, all -> 0x003e }
            r2.<init>()     // Catch:{ Exception -> 0x0033, all -> 0x003e }
            java.io.InputStream r0 = r5.openRawResource(r6, r2)     // Catch:{ Exception -> 0x0033, all -> 0x003e }
            r3 = 0
            android.graphics.Bitmap r1 = decodeResourceStream(r5, r2, r0, r3, r7)     // Catch:{ Exception -> 0x004e, all -> 0x0054 }
        L_0x0018:
            if (r1 != 0) goto L_0x005b
            android.graphics.Bitmap r2 = decodeStream(r0)     // Catch:{ Exception -> 0x0058, all -> 0x0054 }
        L_0x001e:
            if (r0 == 0) goto L_0x0023
            r0.close()     // Catch:{ IOException -> 0x0050 }
        L_0x0023:
            if (r2 != 0) goto L_0x004a
            if (r7 == 0) goto L_0x004a
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Problem decoding into existing bitmap"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r0
        L_0x0033:
            r0 = move-exception
            r0 = r1
            r2 = r1
        L_0x0036:
            if (r0 == 0) goto L_0x0023
            r0.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0023
        L_0x003c:
            r0 = move-exception
            goto L_0x0023
        L_0x003e:
            r0 = move-exception
            r2 = r0
            r3 = r1
        L_0x0041:
            if (r3 == 0) goto L_0x0046
            r3.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0046:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r2
        L_0x004a:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return r2
        L_0x004e:
            r2 = move-exception
            goto L_0x0018
        L_0x0050:
            r0 = move-exception
            goto L_0x0023
        L_0x0052:
            r0 = move-exception
            goto L_0x0046
        L_0x0054:
            r1 = move-exception
            r2 = r1
            r3 = r0
            goto L_0x0041
        L_0x0058:
            r2 = move-exception
            r2 = r1
            goto L_0x0036
        L_0x005b:
            r2 = r1
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.f.a.a(android.content.res.Resources, int, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }
}
