package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoDownLoadMgr;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;
import java.util.concurrent.TimeUnit;

public final class g {
    public static final Runnable kSf = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.appstorage.g.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(44452);
            o oVar = new o(at.bGo());
            if (!oVar.exists() || !oVar.isDirectory()) {
                AppMethodBeat.o(44452);
                return;
            }
            o[] het = oVar.het();
            if (het == null || het.length <= 0) {
                AppMethodBeat.o(44452);
                return;
            }
            for (o oVar2 : het) {
                p(oVar2);
            }
            o oVar3 = new o(AppBrandVideoDownLoadMgr.mvD);
            if (!oVar3.exists() || !oVar3.isDirectory()) {
                AppMethodBeat.o(44452);
                return;
            }
            o[] het2 = oVar3.het();
            if (het2 == null || het2.length <= 0) {
                AppMethodBeat.o(44452);
                return;
            }
            for (o oVar4 : het2) {
                p(oVar4);
            }
            AppMethodBeat.o(44452);
        }

        private void p(o oVar) {
            AppMethodBeat.i(174713);
            if (!oVar.exists() || !oVar.isDirectory()) {
                AppMethodBeat.o(174713);
                return;
            }
            if (s.YS(aa.z(oVar.her()) + "/dir.lock")) {
                if (Util.nowMilliSecond() - new o(aa.z(oVar.her()) + "/dir.lock").lastModified() < g.kSh) {
                    Log.d("MicroMsg.AppBrandLocalMediaPruner", "pruneAppDir dirName %s, locked", oVar.getName());
                    AppMethodBeat.o(174713);
                    return;
                }
                Log.e("MicroMsg.AppBrandLocalMediaPruner", "pruneAppDir dirName %s, lock expired", oVar.getName());
            }
            Log.d("MicroMsg.AppBrandLocalMediaPruner", "pruneAppDir dirName %s, lock free", oVar.getName());
            o[] a2 = oVar.a(new q() {
                /* class com.tencent.mm.plugin.appbrand.appstorage.g.AnonymousClass1.AnonymousClass1 */

                @Override // com.tencent.mm.vfs.q
                public final boolean accept(o oVar) {
                    AppMethodBeat.i(174712);
                    if (oVar.getName().endsWith(".data") || oVar.getName().startsWith("store_") || oVar.getName().endsWith(FilePathGenerator.NO_MEDIA_FILENAME)) {
                        AppMethodBeat.o(174712);
                        return false;
                    }
                    AppMethodBeat.o(174712);
                    return true;
                }
            });
            if (a2 == null || a2.length <= 0) {
                AppMethodBeat.o(174713);
                return;
            }
            long nowMilliSecond = Util.nowMilliSecond();
            for (o oVar2 : a2) {
                if (nowMilliSecond - oVar2.lastModified() >= g.kSg) {
                    s.deleteFile(aa.z(oVar2.her()));
                }
            }
            AppMethodBeat.o(174713);
        }
    };
    private static final long kSg = TimeUnit.MINUTES.toMillis(30);
    private static final long kSh = TimeUnit.DAYS.toMillis(1);

    static {
        AppMethodBeat.i(44454);
        AppMethodBeat.o(44454);
    }
}
