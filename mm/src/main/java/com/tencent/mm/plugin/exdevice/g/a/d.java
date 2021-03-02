package com.tencent.mm.plugin.exdevice.g.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public final class d {
    private static final String rCi = (b.aKZ() + "uploaded_photos/");
    private static final String rCj = (b.aKZ() + "temp/");

    static {
        AppMethodBeat.i(23505);
        AppMethodBeat.o(23505);
    }

    public static o cKY() {
        AppMethodBeat.i(23504);
        o oVar = new o(rCi);
        if (!oVar.exists() || !oVar.isDirectory()) {
            oVar.mkdirs();
        }
        AppMethodBeat.o(23504);
        return oVar;
    }

    public static String anA(String str) {
        String z;
        AppMethodBeat.i(23503);
        if (Util.isNullOrNil(str)) {
            z = "";
        } else {
            z = aa.z(new o(cKY(), MD5Util.getMD5String(str) + "_t").her());
        }
        BitmapUtil.createThumbNail(str, 640, 640, Bitmap.CompressFormat.JPEG, 100, z, true);
        System.currentTimeMillis();
        AppMethodBeat.o(23503);
        return z;
    }
}
