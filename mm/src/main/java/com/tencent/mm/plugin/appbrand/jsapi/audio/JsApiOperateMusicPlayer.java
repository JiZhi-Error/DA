package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.media.music.a;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.core.AssetExtension;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiOperateMusicPlayer extends d<com.tencent.mm.plugin.appbrand.service.c> {
    public static final int CTRL_INDEX = 47;
    public static final String NAME = "operateMusicPlayer";
    OperateMusicPlayer lEg;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject, int i2) {
        AnonymousClass1 r1;
        AppMethodBeat.i(45930);
        final com.tencent.mm.plugin.appbrand.service.c cVar2 = cVar;
        this.lEg = new OperateMusicPlayer(this, cVar2, i2);
        final ad.b G = ad.aVe().G(ad.JX("AppBrandService#" + cVar2.hashCode()), true);
        synchronized (G) {
            try {
                f fVar = (f) G.get("StickyBannerChangeListener", null);
                if (fVar == null) {
                    AnonymousClass1 r0 = new f() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.appbrand.ui.banner.f
                        public final void bJ(String str, int i2) {
                            AppMethodBeat.i(45906);
                            String string = G.getString("appId", "");
                            int i3 = G.getInt("pkgType", 0);
                            if ((!string.equals(str) || i3 != i2) && G.JY("Music#isPlaying") && h.Ud(string) != h.b.ON_RESUME) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("operationType", "pause");
                                } catch (JSONException e2) {
                                }
                                OperateMusicPlayer operateMusicPlayer = new OperateMusicPlayer(JsApiOperateMusicPlayer.this, cVar2, JsApiOperateMusicPlayer.this.lEg.lqe);
                                operateMusicPlayer.jsonString = jSONObject.toString();
                                operateMusicPlayer.dNI = string;
                                operateMusicPlayer.lEi = G;
                                AppBrandMainProcessService.a(operateMusicPlayer);
                            }
                            AppMethodBeat.o(45906);
                        }
                    };
                    AppBrandSysConfigWC bsB = cVar2.getRuntime().bsB();
                    if (bsB != null) {
                        G.l("pkgType", Integer.valueOf(bsB.leE.kNW));
                    }
                    G.l("StickyBannerChangeListener", r0);
                    G.l("appId", cVar2.getAppId());
                    r1 = r0;
                } else {
                    r1 = fVar;
                }
                if (((h.c) G.get("AppBrandLifeCycle.Listener", null)) == null) {
                    AnonymousClass2 r02 = new h.c() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.AnonymousClass2 */

                        @Override // com.tencent.mm.plugin.appbrand.h.c
                        public final void a(h.d dVar) {
                            AppMethodBeat.i(45907);
                            String string = G.getString("appId", "");
                            G.getInt("pkgType", 0);
                            switch (AnonymousClass3.kRE[dVar.ordinal()]) {
                                case 1:
                                case 2:
                                    int i2 = cVar2.getRuntime().ON().cyA.scene;
                                    AppBrandStickyBannerLogic.a.bYc();
                                    if (i2 != 1023) {
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            jSONObject.put("operationType", "pause");
                                        } catch (JSONException e2) {
                                        }
                                        OperateMusicPlayer operateMusicPlayer = new OperateMusicPlayer(JsApiOperateMusicPlayer.this, cVar2, JsApiOperateMusicPlayer.this.lEg.lqe);
                                        operateMusicPlayer.jsonString = jSONObject.toString();
                                        operateMusicPlayer.dNI = string;
                                        operateMusicPlayer.lEi = G;
                                        AppBrandMainProcessService.a(operateMusicPlayer);
                                        break;
                                    }
                                    break;
                            }
                            AppMethodBeat.o(45907);
                        }

                        @Override // com.tencent.mm.plugin.appbrand.h.c
                        public final void onDestroy() {
                            AppMethodBeat.i(45908);
                            Log.d("MicroMsg.JsApiOperateMusicPlayer", "onDestroy");
                            String string = G.getString("appId", "");
                            G.getInt("pkgType", 0);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("operationType", "stop");
                            } catch (JSONException e2) {
                            }
                            OperateMusicPlayer operateMusicPlayer = new OperateMusicPlayer(JsApiOperateMusicPlayer.this, cVar2, JsApiOperateMusicPlayer.this.lEg.lqe);
                            operateMusicPlayer.jsonString = jSONObject.toString();
                            operateMusicPlayer.dNI = string;
                            operateMusicPlayer.action = -1;
                            operateMusicPlayer.lEi = G;
                            AppBrandMainProcessService.b(operateMusicPlayer);
                            AppMethodBeat.o(45908);
                        }
                    };
                    G.l("AppBrandLifeCycle.Listener", r02);
                    this.lEg.cxI = r02;
                }
                this.lEg.lEj = r1;
                this.lEg.lEi = G;
            } catch (Throwable th) {
                AppMethodBeat.o(45930);
                throw th;
            }
        }
        this.lEg.jsonString = jSONObject.toString();
        this.lEg.dNI = cVar2.getAppId();
        AppBrandMainProcessService.a(this.lEg);
        AppMethodBeat.o(45930);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] kRE = new int[h.d.values().length];

        static {
            AppMethodBeat.i(45909);
            try {
                kRE[h.d.BACK.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                kRE[h.d.CLOSE.ordinal()] = 2;
                AppMethodBeat.o(45909);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.o(45909);
            }
        }
    }

    static class OperateMusicPlayer extends MainProcessTask {
        public static final Parcelable.Creator<OperateMusicPlayer> CREATOR = new Parcelable.Creator<OperateMusicPlayer>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer.AnonymousClass7 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ OperateMusicPlayer[] newArray(int i2) {
                return new OperateMusicPlayer[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ OperateMusicPlayer createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45916);
                OperateMusicPlayer operateMusicPlayer = new OperateMusicPlayer(parcel);
                AppMethodBeat.o(45916);
                return operateMusicPlayer;
            }
        };
        public int action;
        h.c cxI;
        public String dNI;
        public boolean error = false;
        public String errorMsg;
        public String jsonString;
        private s kGT;
        private p lAw;
        ad.b lEi;
        f lEj;
        public String lEk;
        private final IListener lEl = new IListener<mx>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer.AnonymousClass6 */

            {
                AppMethodBeat.i(160596);
                this.__eventId = mx.class.getName().hashCode();
                AppMethodBeat.o(160596);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(mx mxVar) {
                AppMethodBeat.i(45915);
                mx mxVar2 = mxVar;
                Log.i("MicroMsg.JsApiOperateMusicPlayer", "callback in(action : %s)", Integer.valueOf(mxVar2.dSE.action));
                com.tencent.mm.ay.f fVar = mxVar2.dSE.dSy;
                if (fVar == null) {
                    AppMethodBeat.o(45915);
                } else {
                    String str = fVar.jfb;
                    HashMap hashMap = new HashMap();
                    hashMap.put("dataUrl", str);
                    OperateMusicPlayer.this.lEk = new JSONObject(hashMap).toString();
                    OperateMusicPlayer.this.action = mxVar2.dSE.action;
                    OperateMusicPlayer.h(OperateMusicPlayer.this);
                    AppMethodBeat.o(45915);
                }
                return false;
            }
        };
        private int lqe;

        static /* synthetic */ boolean c(OperateMusicPlayer operateMusicPlayer) {
            AppMethodBeat.i(45923);
            boolean bDU = operateMusicPlayer.bDU();
            AppMethodBeat.o(45923);
            return bDU;
        }

        static /* synthetic */ boolean d(OperateMusicPlayer operateMusicPlayer) {
            AppMethodBeat.i(45924);
            boolean bDU = operateMusicPlayer.bDU();
            AppMethodBeat.o(45924);
            return bDU;
        }

        static /* synthetic */ boolean e(OperateMusicPlayer operateMusicPlayer) {
            AppMethodBeat.i(45925);
            boolean bDU = operateMusicPlayer.bDU();
            AppMethodBeat.o(45925);
            return bDU;
        }

        static /* synthetic */ boolean f(OperateMusicPlayer operateMusicPlayer) {
            AppMethodBeat.i(45926);
            boolean bDU = operateMusicPlayer.bDU();
            AppMethodBeat.o(45926);
            return bDU;
        }

        static /* synthetic */ boolean g(OperateMusicPlayer operateMusicPlayer) {
            AppMethodBeat.i(45927);
            boolean bDU = operateMusicPlayer.bDU();
            AppMethodBeat.o(45927);
            return bDU;
        }

        static /* synthetic */ boolean h(OperateMusicPlayer operateMusicPlayer) {
            AppMethodBeat.i(45928);
            boolean bDU = operateMusicPlayer.bDU();
            AppMethodBeat.o(45928);
            return bDU;
        }

        public OperateMusicPlayer(p pVar, s sVar, int i2) {
            AppMethodBeat.i(45917);
            this.lAw = pVar;
            this.kGT = sVar;
            this.lqe = i2;
            AppMethodBeat.o(45917);
        }

        public OperateMusicPlayer(Parcel parcel) {
            AppMethodBeat.i(45918);
            f(parcel);
            AppMethodBeat.o(45918);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(45919);
            try {
                JSONObject jSONObject = new JSONObject(this.jsonString);
                String optString = jSONObject.optString("operationType");
                final String optString2 = jSONObject.optString("dataUrl");
                if (Util.isNullOrNil(optString)) {
                    this.action = -1;
                    this.error = true;
                    this.errorMsg = "operationType is null or nil";
                    bDU();
                    AppMethodBeat.o(45919);
                } else if (!a.C0751a.ndb.es(this.dNI, optString)) {
                    Log.i("MicroMsg.JsApiOperateMusicPlayer", "appid not match cannot operate");
                    this.action = -1;
                    this.error = true;
                    this.errorMsg = "appid not match cannot operate";
                    bDU();
                    AppMethodBeat.o(45919);
                } else {
                    if (com.tencent.mm.ay.a.bee() && !com.tencent.mm.ay.a.bec() && optString.equalsIgnoreCase(AssetExtension.SCENE_PLAY)) {
                        com.tencent.mm.ay.f bef = com.tencent.mm.ay.a.bef();
                        if (bef == null || (!Util.isNullOrNil(optString2) && !optString2.equals(bef.jfb))) {
                            Log.i("MicroMsg.JsApiOperateMusicPlayer", "data url has changed ,restart play");
                        } else if (a.C0751a.ndb.es(this.dNI, "resume")) {
                            Log.i("MicroMsg.JsApiOperateMusicPlayer", "same appid %s, change play to resume", this.dNI);
                            optString = "resume";
                        } else {
                            Log.i("MicroMsg.JsApiOperateMusicPlayer", "not same not same appid ,restart play");
                        }
                    }
                    if (optString.equalsIgnoreCase(AssetExtension.SCENE_PLAY)) {
                        final String optString3 = jSONObject.optString("title");
                        final String optString4 = jSONObject.optString("singer");
                        final String optString5 = jSONObject.optString("epname");
                        final String optString6 = jSONObject.optString("coverImgUrl");
                        if (Util.isNullOrNil(optString2)) {
                            this.action = -1;
                            this.error = true;
                            this.errorMsg = "dataUrl is null or nil";
                            bDU();
                            AppMethodBeat.o(45919);
                            return;
                        }
                        Log.i("MicroMsg.JsApiOperateMusicPlayer", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s", optString3, optString4, optString5, optString6, optString2, optString2, optString2);
                        com.tencent.mm.ay.a.bea();
                        String str = a.C0751a.ndb.ncY;
                        if (!Util.isNullOrNil(str)) {
                            Log.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", str, this.dNI);
                            a.C0751a.ndb.acD(str);
                        }
                        MMHandlerThread.postToMainThreadDelayed(new Runnable(optString2, optString2) {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer.AnonymousClass1 */
                            final /* synthetic */ String lEm;
                            final /* synthetic */ String lEp;

                            {
                                this.lEm = r2;
                                this.lEp = r6;
                            }

                            public final void run() {
                                AppMethodBeat.i(45910);
                                String sb = new StringBuilder().append((OperateMusicPlayer.this.dNI + this.lEm + optString6).hashCode()).toString();
                                String str = optString6;
                                String str2 = optString6;
                                String str3 = optString3;
                                String str4 = optString4;
                                String str5 = this.lEp;
                                String str6 = optString2;
                                String str7 = this.lEm;
                                String aKJ = com.tencent.mm.loader.j.b.aKJ();
                                String str8 = optString5;
                                com.tencent.mm.ay.f fVar = new com.tencent.mm.ay.f();
                                fVar.jeT = 7;
                                fVar.jfa = str;
                                fVar.jfm = str2;
                                fVar.jeX = str3;
                                fVar.jeY = str4;
                                fVar.jfd = str5;
                                fVar.jfc = str6;
                                fVar.jfb = str7;
                                fVar.jfg = aKJ;
                                fVar.jfi = "";
                                fVar.jff = com.tencent.mm.plugin.image.d.aSY() + optString6.hashCode();
                                fVar.jeV = sb;
                                fVar.jeW = 0.0f;
                                fVar.jeZ = str8;
                                fVar.jeU = 1;
                                fVar.jfe = null;
                                fVar.jfl = sb;
                                fVar.jfr = true;
                                com.tencent.mm.ay.a.c(fVar);
                                a.C0751a.ndb.a(OperateMusicPlayer.this.lEl, OperateMusicPlayer.this.dNI);
                                a.C0751a.ndb.ncY = OperateMusicPlayer.this.dNI;
                                a.C0751a.ndb.ncZ = fVar.jeV;
                                Log.i("MicroMsg.JsApiOperateMusicPlayer", "startPlayMusic");
                                OperateMusicPlayer.this.action = -1;
                                OperateMusicPlayer.this.errorMsg = "";
                                OperateMusicPlayer.this.error = false;
                                OperateMusicPlayer.c(OperateMusicPlayer.this);
                                AppMethodBeat.o(45910);
                            }
                        }, 500);
                        AppMethodBeat.o(45919);
                    } else if (optString.equalsIgnoreCase("resume")) {
                        String str2 = a.C0751a.ndb.ncY;
                        if (!Util.isNullOrNil(str2)) {
                            Log.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", str2, this.dNI);
                            a.C0751a.ndb.acD(str2);
                        }
                        a.C0751a.ndb.a(this.lEl, this.dNI);
                        a.C0751a.ndb.ncY = this.dNI;
                        com.tencent.mm.ay.f bef2 = com.tencent.mm.ay.a.bef();
                        if (bef2 != null) {
                            a.C0751a.ndb.ncZ = bef2.jeV;
                        }
                        if (com.tencent.mm.ay.b.beh()) {
                            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(45911);
                                    Log.i("MicroMsg.JsApiOperateMusicPlayer", "resume ok");
                                    OperateMusicPlayer.this.action = -1;
                                    OperateMusicPlayer.this.errorMsg = "";
                                    OperateMusicPlayer.this.error = false;
                                    OperateMusicPlayer.d(OperateMusicPlayer.this);
                                    AppMethodBeat.o(45911);
                                }
                            }, 500);
                            AppMethodBeat.o(45919);
                            return;
                        }
                        Log.i("MicroMsg.JsApiOperateMusicPlayer", "resume fail");
                        this.action = -1;
                        this.error = true;
                        this.errorMsg = "resume play fail";
                        bDU();
                        AppMethodBeat.o(45919);
                    } else if (optString.equalsIgnoreCase("pause")) {
                        if (com.tencent.mm.ay.b.bei()) {
                            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer.AnonymousClass3 */

                                public final void run() {
                                    AppMethodBeat.i(45912);
                                    Log.i("MicroMsg.JsApiOperateMusicPlayer", "pause ok");
                                    OperateMusicPlayer.this.action = -1;
                                    OperateMusicPlayer.this.error = false;
                                    OperateMusicPlayer.this.errorMsg = "";
                                    OperateMusicPlayer.e(OperateMusicPlayer.this);
                                    AppMethodBeat.o(45912);
                                }
                            }, 500);
                            AppMethodBeat.o(45919);
                            return;
                        }
                        Log.i("MicroMsg.JsApiOperateMusicPlayer", "pause fail");
                        this.action = -1;
                        this.error = true;
                        this.errorMsg = "pause play fail";
                        bDU();
                        AppMethodBeat.o(45919);
                    } else if (optString.equalsIgnoreCase("seek")) {
                        if (com.tencent.mm.ay.a.tG(Util.getInt(Util.notNullToString(jSONObject.optString("position")), -1) * 1000)) {
                            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer.AnonymousClass4 */

                                public final void run() {
                                    AppMethodBeat.i(45913);
                                    Log.i("MicroMsg.JsApiOperateMusicPlayer", "seek ok");
                                    OperateMusicPlayer.this.action = -1;
                                    OperateMusicPlayer.this.error = false;
                                    OperateMusicPlayer.this.errorMsg = "";
                                    OperateMusicPlayer.f(OperateMusicPlayer.this);
                                    AppMethodBeat.o(45913);
                                }
                            }, 500);
                            AppMethodBeat.o(45919);
                            return;
                        }
                        Log.i("MicroMsg.JsApiOperateMusicPlayer", "seek fail");
                        this.action = -1;
                        this.error = true;
                        this.errorMsg = "seek fail";
                        bDU();
                        AppMethodBeat.o(45919);
                    } else if (!optString.equalsIgnoreCase("stop")) {
                        this.action = -1;
                        this.error = true;
                        bDU();
                        AppMethodBeat.o(45919);
                    } else if (com.tencent.mm.ay.b.bej()) {
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer.AnonymousClass5 */

                            public final void run() {
                                AppMethodBeat.i(45914);
                                Log.i("MicroMsg.JsApiOperateMusicPlayer", "stop ok");
                                OperateMusicPlayer.this.action = -1;
                                OperateMusicPlayer.this.error = false;
                                OperateMusicPlayer.this.errorMsg = "";
                                OperateMusicPlayer.g(OperateMusicPlayer.this);
                                AppMethodBeat.o(45914);
                            }
                        }, 500);
                        AppMethodBeat.o(45919);
                    } else {
                        Log.i("MicroMsg.JsApiOperateMusicPlayer", "stop fail");
                        this.action = -1;
                        this.error = false;
                        this.errorMsg = "stop play fail";
                        bDU();
                        AppMethodBeat.o(45919);
                    }
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.JsApiOperateMusicPlayer", e2.toString());
                this.action = -1;
                this.error = true;
                this.errorMsg = "data is null";
                bDU();
                AppMethodBeat.o(45919);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            String str;
            String str2;
            AppMethodBeat.i(45920);
            Log.i("MicroMsg.JsApiOperateMusicPlayer", "runInClientProcess(action : %s)", Integer.valueOf(this.action));
            s sVar = this.kGT;
            int i2 = this.lqe;
            p pVar = this.lAw;
            if (this.error) {
                StringBuilder sb = new StringBuilder("fail");
                if (TextUtils.isEmpty(this.errorMsg)) {
                    str2 = "";
                } else {
                    str2 = ":" + this.errorMsg;
                }
                str = sb.append(str2).toString();
            } else {
                str = "ok";
            }
            sVar.i(i2, pVar.h(str, null));
            switch (this.action) {
                case 0:
                    Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPlay in");
                    new c((byte) 0).g(this.kGT).Zg(this.lEk).bEo();
                    this.lEi.l("Music#isPlaying", Boolean.TRUE);
                    AppBrandStickyBannerLogic.a.d(this.lEj);
                    h.a(this.kGT.getAppId(), this.cxI);
                    AppMethodBeat.o(45920);
                    return;
                case 1:
                    Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicResume in");
                    this.lEi.l("Music#isPlaying", Boolean.TRUE);
                    AppBrandStickyBannerLogic.a.d(this.lEj);
                    h.a(this.kGT.getAppId(), this.cxI);
                    AppMethodBeat.o(45920);
                    return;
                case 2:
                    Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicStop in");
                    new a((byte) 0).g(this.kGT).Zg(this.lEk).bEo();
                    Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicEnd in");
                    this.lEi.l("Music#isPlaying", Boolean.FALSE);
                    AppBrandStickyBannerLogic.a.c(this.lEj);
                    h.b(this.kGT.getAppId(), this.cxI);
                    AppMethodBeat.o(45920);
                    return;
                case 3:
                    Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPause in");
                    new b((byte) 0).g(this.kGT).Zg(this.lEk).bEo();
                    this.lEi.l("Music#isPlaying", Boolean.FALSE);
                    AppBrandStickyBannerLogic.a.c(this.lEj);
                    h.b(this.kGT.getAppId(), this.cxI);
                    AppMethodBeat.o(45920);
                    return;
                case 4:
                    Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicError in");
                    this.kGT.c("onMusicError", this.lEk, 0);
                    this.lEi.l("Music#isPlaying", Boolean.FALSE);
                    AppBrandStickyBannerLogic.a.c(this.lEj);
                    h.b(this.kGT.getAppId(), this.cxI);
                    AppMethodBeat.o(45920);
                    return;
                case 5:
                case 6:
                default:
                    AppMethodBeat.o(45920);
                    return;
                case 7:
                    Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicEnd in");
                    this.lEi.l("Music#isPlaying", Boolean.FALSE);
                    AppBrandStickyBannerLogic.a.c(this.lEj);
                    h.b(this.kGT.getAppId(), this.cxI);
                    AppMethodBeat.o(45920);
                    return;
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(45921);
            this.jsonString = parcel.readString();
            this.dNI = parcel.readString();
            this.error = parcel.readByte() != 0;
            this.lEk = parcel.readString();
            this.action = parcel.readInt();
            this.errorMsg = parcel.readString();
            AppMethodBeat.o(45921);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45922);
            parcel.writeString(this.jsonString);
            parcel.writeString(this.dNI);
            parcel.writeByte(this.error ? (byte) 1 : 0);
            parcel.writeString(this.lEk);
            parcel.writeInt(this.action);
            parcel.writeString(this.errorMsg);
            AppMethodBeat.o(45922);
        }

        static {
            AppMethodBeat.i(45929);
            AppMethodBeat.o(45929);
        }
    }

    static final class c extends com.tencent.mm.plugin.appbrand.jsapi.s {
        private static final int CTRL_INDEX = 80;
        private static final String NAME = "onMusicPlay";

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    static final class b extends com.tencent.mm.plugin.appbrand.jsapi.s {
        private static final int CTRL_INDEX = 81;
        private static final String NAME = "onMusicPause";

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    static final class a extends com.tencent.mm.plugin.appbrand.jsapi.s {
        private static final int CTRL_INDEX = 82;
        private static final String NAME = "onMusicEnd";

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }
}
