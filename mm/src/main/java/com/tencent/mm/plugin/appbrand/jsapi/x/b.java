package com.tencent.mm.plugin.appbrand.jsapi.x;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import org.json.JSONObject;

public abstract class b extends d<c> {
    /* access modifiers changed from: package-private */
    public abstract void a(c cVar, JSONObject jSONObject, int i2);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i2) {
        c cVar2 = cVar;
        if (cVar2.ay(Activity.class) == null) {
            Log.e("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: no page context");
        } else if (jSONObject == null) {
            cVar2.i(i2, h("fail:data is null or nil", null));
        } else {
            a(cVar2, jSONObject, i2);
        }
    }

    /* access modifiers changed from: protected */
    public class a {
        String lsB;
        String lsC;

        /* synthetic */ a(b bVar, String str, String str2, byte b2) {
            this(str, str2);
        }

        private a(String str, String str2) {
            this.lsB = str;
            this.lsC = str2;
        }
    }

    /* access modifiers changed from: protected */
    public final a d(c cVar, String str) {
        String b2 = b(cVar, str);
        if (b2 == null) {
            Log.e("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: can not generate!");
            return null;
        }
        Log.i("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: creating file: %s", b2);
        if (s.YS(b2)) {
            Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", Boolean.TRUE);
            s.deleteFile(b2);
        }
        o oVar = new o(b2);
        s.boN(s.boZ(b2));
        try {
            if (oVar.createNewFile()) {
                return new a(this, aa.z(oVar.her()), YM(str), (byte) 0);
            }
            Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: create file failed!");
            return null;
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.GameRecord.JsApiScreenRecorderBase", e2, "hy: create file failed!", new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final a a(c cVar, String str, String str2) {
        Log.i("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: request saveFileToClientData: %s, %b, %b", str, Boolean.TRUE, Boolean.TRUE);
        if (!s.YS(str)) {
            Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: src file not exists!");
            return null;
        }
        String b2 = b(cVar, str2);
        if (b2 == null) {
            Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: can not generate dest file!");
            return null;
        }
        if (s.YS(b2)) {
            Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", Boolean.TRUE);
            s.deleteFile(b2);
        }
        if (s.cL(aa.z(new o(str).mUri), aa.z(new o(b2).mUri))) {
            return new a(this, b2, YM(str2), (byte) 0);
        }
        Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: rename failed!");
        return null;
    }

    private static String b(c cVar, String str) {
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
            Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: param error %b, %s", objArr);
            return null;
        }
        at atVar = (at) cVar.getFileSystem();
        if (atVar == null) {
            Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: fs is null");
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
            Log.i("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: no nomedia file. trigger new");
            try {
                oVar.createNewFile();
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.GameRecord.JsApiScreenRecorderBase", e2, "hy: create no media file failed!", new Object[0]);
            }
        }
    }

    protected static com.tencent.mm.plugin.appbrand.game.g.b d(c cVar) {
        return com.tencent.mm.plugin.appbrand.game.g.b.a("1234", null, cVar.getContext());
    }
}
