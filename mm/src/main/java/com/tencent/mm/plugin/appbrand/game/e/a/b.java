package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.game.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.IOException;

public abstract class b extends d<c> {

    protected class a implements c.a {
        String lsB;
        String lsC;

        /* synthetic */ a(b bVar, String str, String str2, byte b2) {
            this(str, str2);
        }

        private a(String str, String str2) {
            this.lsB = str;
            this.lsC = str2;
        }

        @Override // com.tencent.mm.plugin.appbrand.game.g.c.a
        public final String getAbsolutePath() {
            return this.lsB;
        }
    }

    public static com.tencent.mm.plugin.appbrand.game.g.b g(s sVar) {
        return com.tencent.mm.plugin.appbrand.game.g.b.a(sVar.getAppId(), h(sVar), sVar.getContext());
    }

    protected static MagicBrushView h(s sVar) {
        com.tencent.mm.plugin.appbrand.game.f.a aVar = (com.tencent.mm.plugin.appbrand.game.f.a) sVar.getCurrentPageView().S(com.tencent.mm.plugin.appbrand.game.f.a.class);
        if (aVar == null) {
            return null;
        }
        return aVar.MQ();
    }

    /* access modifiers changed from: protected */
    public final a a(com.tencent.mm.plugin.appbrand.service.c cVar, String str) {
        String b2 = b(cVar, str);
        if (b2 == null) {
            Log.e("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: can not generate!");
            return null;
        }
        Log.i("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: creating file: %s", b2);
        if (com.tencent.mm.vfs.s.YS(b2)) {
            Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", Boolean.TRUE);
            com.tencent.mm.vfs.s.deleteFile(b2);
        }
        o oVar = new o(b2);
        com.tencent.mm.vfs.s.boN(com.tencent.mm.vfs.s.boZ(b2));
        try {
            if (oVar.createNewFile()) {
                return new a(this, aa.z(oVar.her()), YM(str), (byte) 0);
            }
            Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: create file failed!");
            return null;
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.WAGameJsApiScreenRecorderBase", e2, "hy: create file failed!", new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final a a(com.tencent.mm.plugin.appbrand.service.c cVar, String str, String str2, boolean z) {
        Log.i("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: request saveFileToClientData: %s, %b, %b", str, Boolean.TRUE, Boolean.valueOf(z));
        if (!com.tencent.mm.vfs.s.YS(str)) {
            Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: src file not exists!");
            return null;
        }
        String b2 = b(cVar, str2);
        if (b2 == null) {
            Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: can not generate dest file!");
            return null;
        }
        if (com.tencent.mm.vfs.s.YS(b2)) {
            Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", Boolean.TRUE);
            com.tencent.mm.vfs.s.deleteFile(b2);
        }
        o oVar = new o(b2);
        if (z) {
            if (!com.tencent.mm.vfs.s.nx(aa.z(new o(str).mUri), aa.z(oVar.mUri))) {
                Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: rename failed!");
                return null;
            }
        } else if (com.tencent.mm.vfs.s.nw(str, b2) <= 0) {
            Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: copy failed!");
            return null;
        }
        return new a(this, b2, YM(str2), (byte) 0);
    }

    private static String b(com.tencent.mm.plugin.appbrand.service.c cVar, String str) {
        boolean z;
        if (cVar == null || Util.isNullOrNil(str)) {
            Object[] objArr = new Object[2];
            if (cVar == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = str;
            Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: param error %b, %s", objArr);
            return null;
        }
        at atVar = (at) cVar.getFileSystem();
        if (atVar == null) {
            Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: fs is null");
            return null;
        }
        String str2 = ((z) atVar.Wj("wxfile://clientdata")).kSr;
        if (!str2.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            str2 = str2 + FilePathGenerator.ANDROID_DIR_SEP;
        }
        YN(str2);
        return str2 + str;
    }

    private static String YM(String str) {
        return "wxfile://clientdata/".concat(String.valueOf(str));
    }

    private static void YN(String str) {
        o oVar = new o(str + FilePathGenerator.NO_MEDIA_FILENAME);
        if (!oVar.exists()) {
            Log.i("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: no nomedia file. trigger new");
            try {
                oVar.createNewFile();
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.WAGameJsApiScreenRecorderBase", e2, "hy: create no media file failed!", new Object[0]);
            }
        }
    }
}
