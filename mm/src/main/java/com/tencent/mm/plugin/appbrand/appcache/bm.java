package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class bm {
    public static void clear(String str) {
        AppMethodBeat.i(90662);
        String str2 = g.aAh().cachePath;
        if (!str2.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            str2 = str2 + FilePathGenerator.ANDROID_DIR_SEP;
        }
        o oVar = new o(str2 + "appbrand/loadingurl/" + str);
        if (oVar.exists() && oVar.isDirectory()) {
            s.dy(aa.z(oVar.mUri), true);
        }
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (!absolutePath.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            absolutePath = absolutePath + FilePathGenerator.ANDROID_DIR_SEP;
        }
        o oVar2 = new o(absolutePath + "tencent/MicroMsg/appbrand/loadingurl");
        if (oVar2.exists() && oVar2.isDirectory()) {
            s.dy(aa.z(oVar2.mUri), true);
        }
        AppMethodBeat.o(90662);
    }
}
