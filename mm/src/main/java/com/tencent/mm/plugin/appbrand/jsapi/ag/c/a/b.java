package com.tencent.mm.plugin.appbrand.jsapi.ag.c.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.TXLiveConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.b {
    private com.tencent.mm.plugin.appbrand.h.b mJX;

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.b
    public final void m(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        if (aVar instanceof com.tencent.mm.plugin.appbrand.h.b) {
            this.mJX = (com.tencent.mm.plugin.appbrand.h.b) aVar;
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.b
    public final void a(int i2, int i3, Bundle bundle) {
        AppMethodBeat.i(139489);
        c cVar = new c((byte) 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewId", i2);
            jSONObject.put("errCode", i3);
            jSONObject.put("errMsg", bundle == null ? "" : bundle.getString(TXLiveConstants.EVT_DESCRIPTION));
            a(cVar, jSONObject);
            AppMethodBeat.o(139489);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "onXWebLivePlayerEvent fail", e2);
            AppMethodBeat.o(139489);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.b
    public final void d(int i2, Bundle bundle) {
        AppMethodBeat.i(139490);
        bc dVar = new d((byte) 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewId", i2);
            JSONObject jSONObject2 = new JSONObject();
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    jSONObject2.put(str, bundle.get(str));
                }
            }
            jSONObject.put("info", jSONObject2);
            a(dVar, jSONObject);
            AppMethodBeat.o(139490);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "onXWebLivePlayerNetStatus fail", e2);
            AppMethodBeat.o(139490);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.b
    public final void bW(int i2, int i3) {
        AppMethodBeat.i(139491);
        a aVar = new a((byte) 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewId", i2);
            jSONObject.put("volume", i3);
            a(aVar, jSONObject);
            AppMethodBeat.o(139491);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "onXWebLivePlayerAudioVolume fail", e2);
            AppMethodBeat.o(139491);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.b
    public final void v(int i2, boolean z) {
        AppMethodBeat.i(215863);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewId", i2);
            jSONObject.put("playInBackground", z);
            a(new C0606b((byte) 0), jSONObject);
            AppMethodBeat.o(215863);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "onXWebLivePlayerBackgroundPlaybackChange fail", e2);
            AppMethodBeat.o(215863);
        }
    }

    private void a(bc bcVar, JSONObject jSONObject) {
        f fVar;
        AppMethodBeat.i(139492);
        if (!bcVar.getName().equalsIgnoreCase("onXWebLivePlayerEvent") && !bcVar.getName().equalsIgnoreCase("onXWebLivePlayerNetStatus") && !bcVar.getName().equalsIgnoreCase("onXWebLivePlayerAudioVolume")) {
            Log.i("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "dispatch event:%s, data:%s", bcVar.getName(), jSONObject.toString());
        }
        bc Zh = bcVar.Zh(jSONObject.toString());
        if (!(this.mJX == null || (fVar = this.mJX.lqg) == null)) {
            if (fVar instanceof s) {
                s sVar = (s) fVar;
                sVar.a(Zh, (int[]) null);
                ac currentPageView = sVar.getCurrentPageView();
                if (currentPageView != null) {
                    currentPageView.a(Zh, (int[]) null);
                }
                AppMethodBeat.o(139492);
                return;
            } else if (fVar instanceof ac) {
                ac acVar = (ac) fVar;
                acVar.a(Zh, (int[]) null);
                s NY = acVar.NY();
                if (NY != null) {
                    NY.a(Zh, (int[]) null);
                }
                AppMethodBeat.o(139492);
                return;
            } else {
                fVar.a(Zh, (int[]) null);
            }
        }
        AppMethodBeat.o(139492);
    }

    static final class c extends bc {
        private static final int CTRL_INDEX = 575;
        private static final String NAME = "onXWebLivePlayerEvent";

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    static final class d extends bc {
        private static final int CTRL_INDEX = 576;
        private static final String NAME = "onXWebLivePlayerNetStatus";

        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }
    }

    static final class a extends bc {
        private static final int CTRL_INDEX = 710;
        private static final String NAME = "onXWebLivePlayerAudioVolume";

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.b$b  reason: collision with other inner class name */
    static final class C0606b extends bc {
        private static final int CTRL_INDEX = 839;
        private static final String NAME = "onXWebLivePlayerBackgroundPlaybackChange";

        private C0606b() {
        }

        /* synthetic */ C0606b(byte b2) {
            this();
        }
    }
}
