package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;

public final class b {
    public static String anz(String str) {
        AppMethodBeat.i(23501);
        if (Util.isNullOrNil(str) || "#".equals(str)) {
            AppMethodBeat.o(23501);
            return "";
        }
        o oVar = new o(d.cKY(), MD5Util.getMD5String(str));
        if (oVar.exists()) {
            String z = aa.z(oVar.her());
            AppMethodBeat.o(23501);
            return z;
        }
        try {
            oVar.createNewFile();
        } catch (IOException e2) {
            Log.d("MicroMsg.ExdevicePictureLocalizer", "hy: %s", e2.toString());
        }
        bg.aAk().postToWorker(new a(str, oVar));
        AppMethodBeat.o(23501);
        return "";
    }

    static class a implements Runnable {
        private o rCg;
        private String url;

        a(String str, o oVar) {
            this.url = str;
            this.rCg = oVar;
        }

        public final void run() {
            AppMethodBeat.i(23499);
            byte[] httpGet = Util.httpGet(this.url);
            if (httpGet != null) {
                s.f(aa.z(this.rCg.mUri), httpGet, httpGet.length);
            }
            AppMethodBeat.o(23499);
        }

        public final String toString() {
            AppMethodBeat.i(23500);
            String str = super.toString() + "|DownloadRunnable";
            AppMethodBeat.o(23500);
            return str;
        }
    }
}
