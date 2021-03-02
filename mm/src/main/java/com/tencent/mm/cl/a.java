package com.tencent.mm.cl;

import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;

public final class a {
    public static String boD(String str) {
        AppMethodBeat.i(9345);
        String str2 = b.aKS() + String.format("%s%d.%s", "wx_photo_edit_", Long.valueOf(System.currentTimeMillis()), str);
        AppMethodBeat.o(9345);
        return str2;
    }

    public static int ao(float f2) {
        AppMethodBeat.i(9346);
        int i2 = (int) ((MMApplicationContext.getContext().getResources().getDisplayMetrics().density * f2) + 0.5f);
        AppMethodBeat.o(9346);
        return i2;
    }

    public static int a(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = 1;
        while (options.outWidth / i5 > i2) {
            i5++;
        }
        while (i4 / i5 > i3) {
            i5++;
        }
        return i5;
    }

    public static void boE(String str) {
        o[] het;
        AppMethodBeat.i(9347);
        Log.i("MicroMsg.MMPhotoEditUtil", "[deleteDirAllFile] dir:%s", str);
        o oVar = new o(str);
        if (oVar.exists() && (het = oVar.het()) != null) {
            for (o oVar2 : het) {
                if (oVar2.isFile() && !Util.isNullOrNil(oVar2.getName()) && oVar2.getName().startsWith("wx_photo_edit_")) {
                    oVar2.delete();
                }
            }
        }
        AppMethodBeat.o(9347);
    }
}
