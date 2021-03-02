package com.tencent.mm.plugin.appbrand.jsapi.video.c;

import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements i.c {
    AppBrandVideoView mAK;
    private com.tencent.mm.plugin.appbrand.jsapi.h mAL;
    public MTimerHandler mAM;
    public int mAN;

    public static final class j extends bc {
        private static final int CTRL_INDEX = 484;
        private static final String NAME = "onVideoResourceError";
    }

    public static final class k extends bc {
        private static final int CTRL_INDEX = 483;
        private static final String NAME = "onVideoResourceLoad";
    }

    public b(AppBrandVideoView appBrandVideoView, com.tencent.mm.plugin.appbrand.jsapi.h hVar) {
        AppMethodBeat.i(234907);
        this.mAK = appBrandVideoView;
        this.mAL = hVar;
        this.mAL.a(this);
        AppMethodBeat.o(234907);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
    public final void onDestroy() {
        AppMethodBeat.i(234908);
        Log.d("MicroMsg.Video.JsApiVideoCallback", "onDestroy clean");
        clean();
        this.mAK.setCallback(null);
        AppMethodBeat.o(234908);
    }

    public final void clean() {
        AppMethodBeat.i(234909);
        this.mAL.b(this);
        bKw();
        AppMethodBeat.o(234909);
    }

    public final void c(int i2, boolean z, int i3) {
        AppMethodBeat.i(234910);
        try {
            Log.i("MicroMsg.Video.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%d", Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3));
            JSONObject bKv = bKv();
            bKv.put("fullScreen", z);
            bKv.put("videoPlayerId", i2);
            bKv.put(TencentLocation.EXTRA_DIRECTION, i3);
            a(new e((byte) 0), bKv);
            AppMethodBeat.o(234910);
        } catch (JSONException e2) {
            Log.e("MicroMsg.Video.JsApiVideoCallback", "onVideoFullScreenChange e=%s", e2);
            AppMethodBeat.o(234910);
        }
    }

    public final void a(bc bcVar, JSONObject jSONObject) {
        AppMethodBeat.i(234911);
        if (!(bcVar instanceof l) && !(bcVar instanceof i)) {
            Log.i("MicroMsg.Video.JsApiVideoCallback", "dispatchEvent event %s", bcVar.getName());
        }
        this.mAL.a(bcVar.Zh(jSONObject.toString()), (int[]) null);
        AppMethodBeat.o(234911);
    }

    public final JSONObject bKv() {
        AppMethodBeat.i(234912);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", this.mAK.getCookieData());
        AppMethodBeat.o(234912);
        return jSONObject;
    }

    public final void bKw() {
        AppMethodBeat.i(234913);
        if (this.mAM != null) {
            this.mAM.stopTimer();
        }
        AppMethodBeat.o(234913);
    }

    public static final class h extends bc {
        private static final int CTRL_INDEX = 127;
        private static final String NAME = "onVideoPlay";

        private h() {
        }

        public /* synthetic */ h(byte b2) {
            this();
        }
    }

    public static final class g extends bc {
        private static final int CTRL_INDEX = 128;
        private static final String NAME = "onVideoPause";

        private g() {
        }

        public /* synthetic */ g(byte b2) {
            this();
        }
    }

    public static final class c extends bc {
        private static final int CTRL_INDEX = 129;
        private static final String NAME = "onVideoEnded";

        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class l extends bc {
        private static final int CTRL_INDEX = 138;
        private static final String NAME = "onVideoTimeUpdate";

        private l() {
        }

        /* synthetic */ l(byte b2) {
            this();
        }
    }

    static final class e extends bc {
        private static final int CTRL_INDEX = 130;
        private static final String NAME = "onVideoFullScreenChange";

        private e() {
        }

        /* synthetic */ e(byte b2) {
            this();
        }
    }

    public static final class m extends bc {
        private static final int CTRL_INDEX = 350;
        private static final String NAME = "onVideoWaiting";

        private m() {
        }

        public /* synthetic */ m(byte b2) {
            this();
        }
    }

    public static final class d extends bc {
        private static final int CTRL_INDEX = 349;
        private static final String NAME = "onVideoError";

        private d() {
        }

        public /* synthetic */ d(byte b2) {
            this();
        }
    }

    public static final class i extends bc {
        private static final int CTRL_INDEX = 548;
        private static final String NAME = "onVideoProgress";

        private i() {
        }

        public /* synthetic */ i(byte b2) {
            this();
        }
    }

    public static final class f extends bc {
        private static final int CTRL_INDEX = 628;
        private static final String NAME = "onVideoLoadedMetaData";

        private f() {
        }

        public /* synthetic */ f(byte b2) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.c.b$b  reason: collision with other inner class name */
    public static final class C0712b extends bc {
        private static final int CTRL_INDEX = 131;
        private static final String NAME = "onVideoClickDanmuBtn";

        private C0712b() {
        }

        public /* synthetic */ C0712b(byte b2) {
            this();
        }
    }

    public static final class a extends bc {
        private static final int CTRL_INDEX = 480;
        private static final String NAME = "onVideoCanPlay";

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
