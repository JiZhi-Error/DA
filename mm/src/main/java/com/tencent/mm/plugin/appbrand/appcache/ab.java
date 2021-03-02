package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.e;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.io.OutputStream;

public final class ab {
    public static String a(WxaPkg wxaPkg, String str) {
        String str2 = null;
        AppMethodBeat.i(134679);
        if (wxaPkg == null || Util.isNullOrNil(str)) {
            AppMethodBeat.o(134679);
        } else {
            wxaPkg.bvf();
            InputStream UR = wxaPkg.UR(str);
            if (UR == null) {
                AppMethodBeat.o(134679);
            } else {
                try {
                    UR.mark(UR.available());
                    String b2 = g.b(UR, 4096);
                    UR.reset();
                    o oVar = new o(aa.z(wxaPkg.mFile.her()) + "_xdir/" + str);
                    o heq = oVar.heq();
                    if (heq.exists() && heq.isFile()) {
                        heq.delete();
                    }
                    heq.mkdirs();
                    if (!b2.equals(s.bhK(aa.z(oVar.mUri)))) {
                        if (oVar.isDirectory()) {
                            Runtime.getRuntime().exec("rm -r " + aa.z(oVar.her()));
                        } else {
                            oVar.delete();
                        }
                        OutputStream ap = s.ap(oVar);
                        e.copyStream(UR, ap);
                        Util.qualityClose(ap);
                    }
                    str2 = aa.z(oVar.her());
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.AppBrand.PkgPartialCopy", e2, "copy failed", new Object[0]);
                } finally {
                    Util.qualityClose(UR);
                    AppMethodBeat.o(134679);
                }
            }
        }
        return str2;
    }
}
