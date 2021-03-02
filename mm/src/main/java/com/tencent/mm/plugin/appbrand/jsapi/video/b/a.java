package com.tencent.mm.plugin.appbrand.jsapi.video.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.j;
import com.tencent.mm.vfs.o;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import java.util.List;

public class a {
    private static volatile a mxe;
    public Context appContext;
    public boolean cWq = false;
    public String cacheDir;
    public k mxa;
    public boolean mxf = true;
    public boolean mxg = true;
    public boolean mxh = true;
    public boolean mxi = true;
    public boolean mxj = false;
    public List<String> mxk;
    public long mxl = TPAudioFrame.TP_CH_STEREO_LEFT;
    public long mxm = 1048576;
    public int mxn = 5;
    public j mxo;
    public com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a mxp;
    public e mxq;
    public f mxr;
    public String tmpDir;

    private a(Context context) {
        this.appContext = context;
    }

    public static a bJK() {
        AppMethodBeat.i(234656);
        if (mxe == null) {
            RuntimeException runtimeException = new RuntimeException("PlayerConfig not initialized!");
            AppMethodBeat.o(234656);
            throw runtimeException;
        }
        a aVar = mxe;
        AppMethodBeat.o(234656);
        return aVar;
    }

    public static void init(Context context) {
        AppMethodBeat.i(234657);
        if (mxe == null) {
            synchronized (a.class) {
                try {
                    if (mxe == null) {
                        mxe = new a(context);
                    }
                } finally {
                    AppMethodBeat.o(234657);
                }
            }
            return;
        }
        AppMethodBeat.o(234657);
    }

    public final String getCacheDir() {
        o oVar;
        AppMethodBeat.i(234658);
        if (TextUtils.isEmpty(this.cacheDir)) {
            try {
                oVar = o.X(this.appContext.getExternalCacheDir());
            } catch (Exception e2) {
                h.a(5, "PlayerConfig", "getCacheDir fail", e2);
                oVar = null;
            }
            if (oVar == null) {
                h.log(5, "PlayerConfig", "getCacheDir fail, extCacheDir not exist");
                AppMethodBeat.o(234658);
                return null;
            }
            String aaX = aaX(oVar + "/wxvideocache");
            AppMethodBeat.o(234658);
            return aaX;
        }
        String str = this.cacheDir;
        AppMethodBeat.o(234658);
        return str;
    }

    public final String bJL() {
        o oVar;
        AppMethodBeat.i(234659);
        if (TextUtils.isEmpty(this.tmpDir)) {
            try {
                oVar = o.X(this.appContext.getFilesDir());
            } catch (Exception e2) {
                h.a(5, "PlayerConfig", "getTempDir fail", e2);
                oVar = null;
            }
            if (oVar == null) {
                AppMethodBeat.o(234659);
                return null;
            }
            String aaX = aaX(oVar + "/wxvideotmp");
            AppMethodBeat.o(234659);
            return aaX;
        }
        String str = this.tmpDir;
        AppMethodBeat.o(234659);
        return str;
    }

    private static String aaX(String str) {
        AppMethodBeat.i(234660);
        if (!TextUtils.isEmpty(str)) {
            o oVar = new o(str);
            if (oVar.isFile()) {
                h.log(4, "PlayerConfig", "fileDir:" + str + " is file, delete result:" + oVar.delete());
            }
            if (!oVar.exists()) {
                h.log(4, "PlayerConfig", "fileDir:" + str + " not exist, make dir result:" + oVar.mkdirs());
            }
        }
        AppMethodBeat.o(234660);
        return str;
    }
}
