package com.tencent.mm.plugin.sns.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.l;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.performance.watchdogs.c;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    public static Bitmap k(String str, float f2) {
        Bitmap bitmap = null;
        AppMethodBeat.i(202559);
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap a2 = l.aRY().a(str, null);
        if (f2 == 0.0f) {
            Log.d("MicroMsg.SnsBitmapUtil", "decode used %dms %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), a2);
            AppMethodBeat.o(202559);
            return a2;
        }
        if (a2 != null) {
            bitmap = BitmapUtil.getRoundedCornerBitmap(a2, true, ((float) a2.getWidth()) * f2);
            Log.d("MicroMsg.SnsBitmapUtil", "decode used %dms %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), a2);
        }
        AppMethodBeat.o(202559);
        return bitmap;
    }

    public static n c(String str, BitmapFactory.Options options) {
        AppMethodBeat.i(95063);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Bitmap a2 = l.aRY().a(str, options);
            if (a2 != null) {
                a2 = r.t(str, a2);
            }
            Log.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), a2);
            n H = n.H(a2);
            AppMethodBeat.o(95063);
            return H;
        } catch (OutOfMemoryError e2) {
            Log.e("MicroMsg.SnsBitmapUtil", "%s", c.eCH().S(true, 0));
            Log.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + e2.getMessage());
            AppMethodBeat.o(95063);
            return null;
        }
    }

    public static Bitmap b(String str, BitmapFactory.Options options) {
        AppMethodBeat.i(95064);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Bitmap a2 = l.aRY().a(str, options);
            if (a2 != null) {
                a2 = r.t(str, a2);
            }
            Log.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), a2);
            AppMethodBeat.o(95064);
            return a2;
        } catch (OutOfMemoryError e2) {
            Log.e("MicroMsg.SnsBitmapUtil", "%s", c.eCH().S(true, 0));
            Log.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + e2.getMessage());
            AppMethodBeat.o(95064);
            return null;
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.SnsBitmapUtil", e3, "", new Object[0]);
            AppMethodBeat.o(95064);
            return null;
        }
    }
}
