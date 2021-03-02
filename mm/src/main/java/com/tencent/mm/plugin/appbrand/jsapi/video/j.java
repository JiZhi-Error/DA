package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.h.a.e;
import com.google.android.exoplayer2.h.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.l;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.common.TPAudioFrame;

public class j implements g {
    private static j mwW;
    private boolean iCs = false;
    public boolean mwX = true;
    private boolean mwY = false;
    private boolean mwZ = false;
    private k mxa = new k() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.video.j.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.c.k
        public final void xw(int i2) {
            AppMethodBeat.i(234631);
            if (i2 < 0) {
                j.this.mwX = false;
            }
            AppMethodBeat.o(234631);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.c.k
        public final void bJH() {
            AppMethodBeat.i(234632);
            j.this.mwX = false;
            AppMethodBeat.o(234632);
        }
    };

    public j() {
        AppMethodBeat.i(234633);
        AppMethodBeat.o(234633);
    }

    public static j bJE() {
        AppMethodBeat.i(234634);
        if (mwW == null) {
            synchronized (j.class) {
                try {
                    if (mwW == null) {
                        mwW = new j();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(234634);
                    throw th;
                }
            }
        }
        j jVar = mwW;
        AppMethodBeat.o(234634);
        return jVar;
    }

    public final boolean bJF() {
        return this.mwY;
    }

    public final void a(Context context, boolean z, boolean z2, a aVar, f fVar) {
        boolean z3;
        AppMethodBeat.i(234635);
        if (this.iCs) {
            Log.i("MicroMsg.SameLayer.VideoCore", "init already, current enableProxy:%s", Boolean.valueOf(this.mwX));
            AppMethodBeat.o(234635);
            return;
        }
        Log.i("MicroMsg.SameLayer.VideoCore", "init, enableProxy:%s, enableHlsProxy:%s", Boolean.valueOf(z), Boolean.valueOf(z2));
        long nowMilliSecond = Util.nowMilliSecond();
        this.iCs = true;
        this.mwY = z2;
        this.mwX = z;
        if (this.mwX) {
            String aaU = aaU("wxvideocache");
            if (Util.isNullOrNil(aaU)) {
                this.mwX = false;
                Log.i("MicroMsg.SameLayer.VideoCore", "init, disableProxy for cache dir make fail");
                aVar.xw(-1);
            } else {
                com.tencent.mm.plugin.appbrand.jsapi.video.b.a.init(context.getApplicationContext());
                com.tencent.mm.plugin.appbrand.jsapi.video.b.a bJK = com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK();
                if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                bJK.cWq = z3;
                com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxm = 1048576;
                com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxl = TPAudioFrame.TP_CH_STEREO_LEFT;
                com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxf = true;
                com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxg = true;
                com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxh = true;
                com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxi = z2;
                com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxj = false;
                com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxn = 3;
                com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxo = new k();
                com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxq = new g();
                com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxp = aVar;
                com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxr = fVar;
                com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxa = this.mxa;
                com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().cacheDir = aaU;
                com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().tmpDir = aaU("wxvideotmp");
                l.init();
            }
        }
        Log.i("MicroMsg.SameLayer.VideoCore", "init, costTimeMs:%s", Long.valueOf(Util.nowMilliSecond() - nowMilliSecond));
        AppMethodBeat.o(234635);
    }

    private static String aaU(String str) {
        AppMethodBeat.i(234636);
        String aKJ = b.aKJ();
        if (!aKJ.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            aKJ = aKJ + FilePathGenerator.ANDROID_DIR_SEP;
        }
        String str2 = aKJ + str + FilePathGenerator.ANDROID_DIR_SEP;
        try {
            if (!s.boN(str2)) {
                Log.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 1, maybe dir exist:%s", str2);
                if (!new o(str2).isDirectory()) {
                    Log.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 2, not dir:%s", str2);
                    s.deleteFile(str2);
                    if (!s.boN(str2)) {
                        Log.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 3, no space? dir:%s", str2);
                        AppMethodBeat.o(234636);
                        return null;
                    }
                }
            }
            Log.i("MicroMsg.SameLayer.VideoCore", "ensureDir %s:%s", str, str2);
            AppMethodBeat.o(234636);
            return str2;
        } catch (Throwable th) {
            Log.e("MicroMsg.SameLayer.VideoCore", "mkdirs exception:%s", th);
            AppMethodBeat.o(234636);
            return null;
        }
    }

    public final boolean bJG() {
        return this.mwX;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.g
    public final g.a bJs() {
        AppMethodBeat.i(234637);
        if (!this.mwX) {
            e eVar = c.bJr().mwL;
            AppMethodBeat.o(234637);
            return eVar;
        }
        AppMethodBeat.o(234637);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.g
    public final String getProxyUrl(String str) {
        boolean z = true;
        AppMethodBeat.i(234638);
        if (!this.mwX) {
            String proxyUrl = c.bJr().getProxyUrl(str);
            AppMethodBeat.o(234638);
            return proxyUrl;
        }
        if (!Util.isNullOrNil(str)) {
            if (Util.isNullOrNil(str) || !str.startsWith("http://127.0.0.1")) {
                z = false;
            }
            if (!z) {
                try {
                    String a2 = l.bJT().myF.a(str, true, true, "video/mp4", 90);
                    AppMethodBeat.o(234638);
                    return a2;
                } catch (Exception e2) {
                    h.a(6, "MicroMsg.SameLayer.VideoCore", "getProxyUrl exception", e2);
                    AppMethodBeat.o(234638);
                    return str;
                }
            }
        }
        AppMethodBeat.o(234638);
        return str;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.g
    public final void o(String str, long j2, long j3) {
        AppMethodBeat.i(234639);
        if (!this.mwX) {
            c.bJr().o(str, j2, j3);
            AppMethodBeat.o(234639);
            return;
        }
        try {
            l.bJT().U(str, j3);
            AppMethodBeat.o(234639);
        } catch (Exception e2) {
            h.a(6, "MicroMsg.SameLayer.VideoCore", "preload exception", e2);
            AppMethodBeat.o(234639);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.g
    public final long f(String str, long j2, long j3) {
        AppMethodBeat.i(234640);
        if (!this.mwX) {
            long f2 = c.bJr().f(str, j2, j3);
            AppMethodBeat.o(234640);
            return f2;
        }
        try {
            long aba = l.bJT().aba(str);
            AppMethodBeat.o(234640);
            return aba;
        } catch (Exception e2) {
            h.a(6, "MicroMsg.SameLayer.VideoCore", "getCachedBytes exception", e2);
            AppMethodBeat.o(234640);
            return 0;
        }
    }

    public final void hQ(boolean z) {
        this.mwZ = z;
    }

    public final String aaV(String str) {
        AppMethodBeat.i(234641);
        Uri parse = Uri.parse(str);
        String uri = parse.toString();
        try {
            if (this.mwZ && str != null && parse.getHost().equals("mpvideo.qpic.cn") && parse.getQueryParameter("vid") != null) {
                uri = parse.getPath() + "_" + parse.getQueryParameter("vid");
                Log.i("MicroMsg.SameLayer.VideoCore", "[TRACE_VIDEO_PRELOAD] cachekey = %s", uri);
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(234641);
        return uri;
    }
}
