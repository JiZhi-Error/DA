package com.tencent.mm.plugin.appbrand.jsapi.ag.e;

import android.app.Activity;
import android.os.HandlerThread;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.math.BigDecimal;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class e implements com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d {
    private s cEX = null;
    private com.tencent.luggage.xweb_ext.extendplugin.component.video.a cJC = null;
    private MTimerHandler mAM;
    private HandlerThread mHandlerThread;
    com.tencent.mm.plugin.appbrand.h.b mJX;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.c mKZ;
    private int mKu;
    private String mKv;
    double mLe;
    private volatile boolean mLf = false;

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d
    public final void b(com.tencent.luggage.xweb_ext.extendplugin.component.video.c cVar) {
        this.mKZ = cVar;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d
    public final void m(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        if (aVar instanceof com.tencent.mm.plugin.appbrand.h.b) {
            this.mJX = (com.tencent.mm.plugin.appbrand.h.b) aVar;
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d
    public final void ci(boolean z) {
        AppMethodBeat.i(177220);
        this.mLf = false;
        try {
            this.mKu = 0;
            JSONObject bKv = bKv();
            bKv.put("timeStamp", System.currentTimeMillis());
            a(new f((byte) 0), bKv);
            Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "start video update timer");
            if (this.mHandlerThread == null) {
                this.mHandlerThread = com.tencent.f.c.d.hA("AppBrandVideoEventHandler_HandlerThread", 5);
                this.mHandlerThread.start();
            }
            if (this.mAM == null && this.mHandlerThread != null) {
                Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "start video update timer, create new timer");
                this.mAM = new MTimerHandler(this.mHandlerThread.getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.e.AnonymousClass1 */

                    @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                    public final boolean onTimerExpired() {
                        AppMethodBeat.i(139581);
                        if (e.this.mKZ != null) {
                            e.this.bZ(e.this.mKZ.getCurrentPosition(), (int) (e.this.mLe * 1000.0d));
                        }
                        AppMethodBeat.o(139581);
                        return true;
                    }
                }, true);
            }
            if (this.mAM != null) {
                this.mAM.startTimer(0, 250);
            }
            if (this.mJX != null && "wxfe02ecfe70800f46".equalsIgnoreCase(this.mJX.getAppId())) {
                Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startUpdateTimer, send play event");
                EventCenter.instance.publish(new com.tencent.mm.plugin.appbrand.jsapi.video.c.a());
            }
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.e.AnonymousClass2 */

                public final void run() {
                    com.tencent.mm.plugin.appbrand.jsapi.f fVar;
                    Activity activity;
                    AppMethodBeat.i(139582);
                    if (!(e.this.mJX == null || (fVar = e.this.mJX.lqg) == null)) {
                        if (fVar instanceof com.tencent.mm.plugin.appbrand.s) {
                            activity = ((com.tencent.mm.plugin.appbrand.s) fVar).ay(Activity.class);
                        } else if (!(fVar instanceof ac) || !(fVar.getContext() instanceof Activity)) {
                            activity = null;
                        } else {
                            activity = (Activity) fVar.getContext();
                        }
                        if (activity != null) {
                            Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startKeepScreenOn");
                            try {
                                activity.getWindow().addFlags(128);
                                AppMethodBeat.o(139582);
                                return;
                            } catch (Exception e2) {
                                Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startKeepScreenOn exception", e2);
                            }
                        }
                    }
                    AppMethodBeat.o(139582);
                }
            });
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPlay fail", e2);
        }
        Log.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart");
        if (this.mKZ == null || this.mJX == null) {
            Log.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart, mPluginHandler or mInvokeContext is null");
        } else {
            com.tencent.mm.plugin.appbrand.jsapi.ag.a f2 = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.mJX);
            if (f2 == null) {
                Log.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart, audioOfVideoBackgroundPlayManager is null");
            } else {
                f2.d(this.mKZ);
            }
        }
        if (this.cEX != null) {
            this.cEX.bZ(z);
        }
        AppMethodBeat.o(177220);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d
    public final void cj(boolean z) {
        AppMethodBeat.i(177221);
        try {
            a(new C0624e((byte) 0), bKv());
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPause fail", e2);
        }
        bKw();
        bMk();
        bMl();
        if (this.cEX != null) {
            if (!z) {
                this.cEX.onPause();
                AppMethodBeat.o(177221);
                return;
            }
            this.cEX.onStop();
        }
        AppMethodBeat.o(177221);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d
    public final void onVideoEnded() {
        AppMethodBeat.i(139586);
        try {
            a(new b((byte) 0), bKv());
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoEnded fail", e2);
        }
        bKw();
        bMk();
        bMl();
        AppMethodBeat.o(139586);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d
    public final void onVideoWaiting() {
        AppMethodBeat.i(139587);
        this.mLf = true;
        try {
            JSONObject bKv = bKv();
            bKv.put("timeStamp", System.currentTimeMillis());
            a(new k((byte) 0), bKv);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoWaiting fail", e2);
        }
        if (this.cEX != null) {
            this.cEX.PL();
        }
        AppMethodBeat.o(139587);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d
    public final void ie(int i2) {
        AppMethodBeat.i(139588);
        try {
            JSONObject bKv = bKv();
            bKv.put("buffered", i2);
            a(new h((byte) 0), bKv);
            AppMethodBeat.o(139588);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoProgress fail", e2);
            AppMethodBeat.o(139588);
        }
    }

    public final void bZ(int i2, int i3) {
        AppMethodBeat.i(215895);
        if (this.mLf) {
            Log.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onVideoTimeUpdate, video waiting");
            AppMethodBeat.o(215895);
            return;
        }
        try {
            if (Math.abs(i2 - this.mKu) < 250) {
                AppMethodBeat.o(215895);
                return;
            }
            if (this.cJC != null) {
                this.cJC.bZ(i2, i3);
            }
            this.mKu = i2;
            double doubleValue = new BigDecimal((((double) i2) * 1.0d) / 1000.0d).setScale(3, 4).doubleValue();
            JSONObject bKv = bKv();
            bKv.put("position", doubleValue);
            bKv.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, (((double) i3) * 1.0d) / 1000.0d);
            a(new j((byte) 0), bKv);
            AppMethodBeat.o(215895);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoTimeUpdate fail", e2);
            AppMethodBeat.o(215895);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d
    public final void h(String str, int i2, int i3) {
        AppMethodBeat.i(139589);
        bKw();
        bMk();
        try {
            JSONObject bKv = bKv();
            bKv.put("errMsg", String.format(Locale.US, "%s(%d,%d)", str, Integer.valueOf(i2), Integer.valueOf(i3)));
            a(new c((byte) 0), bKv);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoError fail", e2);
        }
        bMl();
        if (this.cEX != null) {
            this.cEX.onError();
        }
        AppMethodBeat.o(139589);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d
    public final void E(int i2, int i3, int i4) {
        AppMethodBeat.i(139590);
        try {
            JSONObject bKv = bKv();
            bKv.put("width", i2);
            bKv.put("height", i3);
            this.mLe = (((double) i4) * 1.0d) / 1000.0d;
            bKv.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, this.mLe);
            a(new d((byte) 0), bKv);
            AppMethodBeat.o(139590);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoLoadedMetaData fail", e2);
            AppMethodBeat.o(139590);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d
    public final void aX(long j2) {
        AppMethodBeat.i(139591);
        try {
            JSONObject bKv = bKv();
            bKv.put("preloadSize", j2);
            a(new g((byte) 0), bKv);
            AppMethodBeat.o(139591);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoPreloadedMetaData fail", e2);
            AppMethodBeat.o(139591);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d
    /* renamed from: if  reason: not valid java name */
    public final void m12if(int i2) {
        AppMethodBeat.i(215896);
        this.mLf = false;
        if ((this.mAM == null || this.mAM.stopped()) && this.mKZ != null) {
            Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onVideoSeekComplete, dispatch onVideoTimeUpdate");
            bZ(this.mKZ.getCurrentPosition(), (int) (this.mLe * 1000.0d));
        }
        try {
            JSONObject bKv = bKv();
            bKv.put("position", i2);
            a(new i((byte) 0), bKv);
            AppMethodBeat.o(215896);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoSeekComplete fail", e2);
            AppMethodBeat.o(215896);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d
    public final void ck(boolean z) {
        AppMethodBeat.i(215897);
        try {
            JSONObject bKv = bKv();
            bKv.put("playInBackground", z);
            a(new a((byte) 0), bKv);
            AppMethodBeat.o(215897);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoBackgroundPlaybackChange fail", e2);
            AppMethodBeat.o(215897);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d
    public final void dV(String str) {
        this.mKv = str;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d
    public final void destroy() {
        AppMethodBeat.i(139592);
        bKw();
        if (this.mHandlerThread != null) {
            this.mHandlerThread.quit();
            this.mHandlerThread = null;
        }
        AppMethodBeat.o(139592);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d
    public final synchronized void a(com.tencent.luggage.xweb_ext.extendplugin.component.video.a aVar) {
        this.cJC = aVar;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d
    public final synchronized void a(s sVar) {
        this.cEX = sVar;
    }

    private void bKw() {
        AppMethodBeat.i(139593);
        Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stop video update timer");
        if (this.mAM != null) {
            this.mAM.stopTimer();
        }
        AppMethodBeat.o(139593);
    }

    private JSONObject bKv() {
        AppMethodBeat.i(139594);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", this.mKv);
        AppMethodBeat.o(139594);
        return jSONObject;
    }

    private void a(bc bcVar, JSONObject jSONObject) {
        com.tencent.mm.plugin.appbrand.jsapi.f fVar;
        AppMethodBeat.i(139595);
        if (!(bcVar instanceof j) && !(bcVar instanceof h)) {
            Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "dispatch event:%s, data:%s", bcVar.getName(), jSONObject.toString());
        }
        bc Zh = bcVar.Zh(jSONObject.toString());
        if (!(this.mJX == null || (fVar = this.mJX.lqg) == null)) {
            if (fVar instanceof com.tencent.mm.plugin.appbrand.s) {
                com.tencent.mm.plugin.appbrand.s sVar = (com.tencent.mm.plugin.appbrand.s) fVar;
                sVar.a(Zh, (int[]) null);
                ac currentPageView = sVar.getCurrentPageView();
                if (currentPageView != null) {
                    currentPageView.a(Zh, (int[]) null);
                }
                AppMethodBeat.o(139595);
                return;
            } else if (fVar instanceof ac) {
                ac acVar = (ac) fVar;
                acVar.a(Zh, (int[]) null);
                com.tencent.mm.plugin.appbrand.s NY = acVar.NY();
                if (NY != null) {
                    NY.a(Zh, (int[]) null);
                }
                AppMethodBeat.o(139595);
                return;
            } else {
                fVar.a(Zh, (int[]) null);
            }
        }
        AppMethodBeat.o(139595);
    }

    private void bMk() {
        AppMethodBeat.i(139596);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.e.AnonymousClass3 */

            public final void run() {
                com.tencent.mm.plugin.appbrand.jsapi.f fVar;
                Activity activity;
                AppMethodBeat.i(139583);
                if (!(e.this.mJX == null || (fVar = e.this.mJX.lqg) == null)) {
                    if (fVar instanceof com.tencent.mm.plugin.appbrand.s) {
                        activity = ((com.tencent.mm.plugin.appbrand.s) fVar).ay(Activity.class);
                    } else if (!(fVar instanceof ac) || !(fVar.getContext() instanceof Activity)) {
                        activity = null;
                    } else {
                        activity = (Activity) fVar.getContext();
                    }
                    if (activity != null) {
                        Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stopKeepScreenOn");
                        try {
                            activity.getWindow().clearFlags(128);
                            AppMethodBeat.o(139583);
                            return;
                        } catch (Exception e2) {
                            Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stopKeepScreenOn exception", e2);
                        }
                    }
                }
                AppMethodBeat.o(139583);
            }
        });
        AppMethodBeat.o(139596);
    }

    private void bMl() {
        AppMethodBeat.i(215898);
        Log.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop");
        if (this.mKZ == null || this.mJX == null) {
            Log.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop, pluginHandler or invokeContext is null");
            AppMethodBeat.o(215898);
            return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.ag.a f2 = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.mJX);
        if (f2 == null) {
            Log.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop, audioOfVideoBackgroundPlayManager is null");
            AppMethodBeat.o(215898);
            return;
        }
        f2.e(this.mKZ);
        AppMethodBeat.o(215898);
    }

    static final class f extends bc {
        private static final int CTRL_INDEX = 541;
        private static final String NAME = "onXWebVideoPlay";

        private f() {
        }

        /* synthetic */ f(byte b2) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.e.e$e  reason: collision with other inner class name */
    static final class C0624e extends bc {
        private static final int CTRL_INDEX = 542;
        private static final String NAME = "onXWebVideoPause";

        private C0624e() {
        }

        /* synthetic */ C0624e(byte b2) {
            this();
        }
    }

    static final class b extends bc {
        private static final int CTRL_INDEX = 543;
        private static final String NAME = "onXWebVideoEnded";

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class j extends bc {
        private static final int CTRL_INDEX = 544;
        private static final String NAME = "onXWebVideoTimeUpdate";

        private j() {
        }

        /* synthetic */ j(byte b2) {
            this();
        }
    }

    static final class k extends bc {
        private static final int CTRL_INDEX = 540;
        private static final String NAME = "onXWebVideoWaiting";

        private k() {
        }

        /* synthetic */ k(byte b2) {
            this();
        }
    }

    static final class c extends bc {
        private static final int CTRL_INDEX = 545;
        private static final String NAME = "onXWebVideoError";

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class h extends bc {
        private static final int CTRL_INDEX = 547;
        private static final String NAME = "onXWebVideoProgress";

        private h() {
        }

        /* synthetic */ h(byte b2) {
            this();
        }
    }

    static final class d extends bc {
        private static final int CTRL_INDEX = 546;
        private static final String NAME = "onXWebVideoLoadedMetaData";

        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }
    }

    static final class g extends bc {
        private static final int CTRL_INDEX = 683;
        private static final String NAME = "onXWebVideoPreloadedMetaData";

        private g() {
        }

        /* synthetic */ g(byte b2) {
            this();
        }
    }

    static final class i extends bc {
        private static final int CTRL_INDEX = 837;
        private static final String NAME = "onXWebVideoSeekComplete";

        private i() {
        }

        /* synthetic */ i(byte b2) {
            this();
        }
    }

    static final class a extends bc {
        private static final int CTRL_INDEX = 838;
        private static final String NAME = "onXWebVideoBackgroundPlaybackChange";

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }
}
