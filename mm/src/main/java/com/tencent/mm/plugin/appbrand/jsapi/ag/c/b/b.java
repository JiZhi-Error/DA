package com.tencent.mm.plugin.appbrand.jsapi.ag.c.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLiveConstants;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.b {
    private com.tencent.mm.plugin.appbrand.h.b mJX;

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.b
    public final void m(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        if (aVar instanceof com.tencent.mm.plugin.appbrand.h.b) {
            this.mJX = (com.tencent.mm.plugin.appbrand.h.b) aVar;
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.b
    public final void b(int i2, int i3, Bundle bundle) {
        AppMethodBeat.i(139520);
        f fVar = new f((byte) 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewId", i2);
            jSONObject.put("errCode", i3);
            jSONObject.put("errMsg", bundle == null ? "" : bundle.getString(TXLiveConstants.EVT_DESCRIPTION));
            a(fVar, jSONObject);
            AppMethodBeat.o(139520);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherEvent fail", e2);
            AppMethodBeat.o(139520);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.b
    public final void e(int i2, Bundle bundle) {
        AppMethodBeat.i(139521);
        bc gVar = new g((byte) 0);
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
            a(gVar, jSONObject);
            AppMethodBeat.o(139521);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherNetStatus fail", e2);
            AppMethodBeat.o(139521);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.b
    public final void ic(int i2) {
        AppMethodBeat.i(139522);
        d dVar = new d((byte) 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewId", i2);
            a(dVar, jSONObject);
            AppMethodBeat.o(139522);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherBGMStart fail", e2);
            AppMethodBeat.o(139522);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.b
    public final void g(int i2, long j2, long j3) {
        AppMethodBeat.i(139523);
        c cVar = new c((byte) 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewId", i2);
            jSONObject.put("progress", j2);
            jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, j3);
            a(cVar, jSONObject);
            AppMethodBeat.o(139523);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherBGMProgress fail", e2);
            AppMethodBeat.o(139523);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.b
    public final void bX(int i2, int i3) {
        AppMethodBeat.i(139524);
        C0607b bVar = new C0607b((byte) 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewId", i2);
            jSONObject.put("errCode", i3);
            a(bVar, jSONObject);
            AppMethodBeat.o(139524);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherBGMComplete fail", e2);
            AppMethodBeat.o(139524);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.b
    public final void bY(int i2, int i3) {
        AppMethodBeat.i(178856);
        a aVar = new a((byte) 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewId", i2);
            jSONObject.put("volume", i3);
            a(aVar, jSONObject);
            AppMethodBeat.o(178856);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherAudioVolume fail", e2);
            AppMethodBeat.o(178856);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.b
    public final void a(int i2, int i3, String str, HashMap<String, Object> hashMap) {
        AppMethodBeat.i(139525);
        e eVar = new e((byte) 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewId", i2);
            jSONObject.put("errCode", i3);
            jSONObject.put("errMsg", Util.nullAsNil(str));
            if (!hashMap.isEmpty()) {
                jSONObject.put("data", new JSONObject(hashMap));
            }
            a(eVar, jSONObject);
            AppMethodBeat.o(139525);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherError fail", e2);
            AppMethodBeat.o(139525);
        }
    }

    private void a(bc bcVar, JSONObject jSONObject) {
        com.tencent.mm.plugin.appbrand.jsapi.f fVar;
        AppMethodBeat.i(139526);
        if (!bcVar.getName().equalsIgnoreCase("onXWebLivePusherEvent") && !bcVar.getName().equalsIgnoreCase("onXWebLivePusherNetStatus")) {
            Log.i("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "dispatch event:%s, data:%s", bcVar.getName(), jSONObject.toString());
        }
        bc Zh = bcVar.Zh(jSONObject.toString());
        if (!(this.mJX == null || (fVar = this.mJX.lqg) == null)) {
            if (fVar instanceof s) {
                ((s) fVar).a(Zh, (int[]) null);
                AppMethodBeat.o(139526);
                return;
            } else if (fVar instanceof ac) {
                ((ac) fVar).a(Zh, (int[]) null);
                AppMethodBeat.o(139526);
                return;
            } else {
                fVar.a(Zh, (int[]) null);
            }
        }
        AppMethodBeat.o(139526);
    }

    static final class f extends bc {
        private static final int CTRL_INDEX = 569;
        private static final String NAME = "onXWebLivePusherEvent";

        private f() {
        }

        /* synthetic */ f(byte b2) {
            this();
        }
    }

    static final class g extends bc {
        private static final int CTRL_INDEX = 570;
        private static final String NAME = "onXWebLivePusherNetStatus";

        private g() {
        }

        /* synthetic */ g(byte b2) {
            this();
        }
    }

    static final class d extends bc {
        private static final int CTRL_INDEX = 571;
        private static final String NAME = "onXWebLivePusherBGMStart";

        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }
    }

    static final class c extends bc {
        private static final int CTRL_INDEX = 572;
        private static final String NAME = "onXWebLivePusherBGMProgress";

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.b$b  reason: collision with other inner class name */
    static final class C0607b extends bc {
        private static final int CTRL_INDEX = 573;
        private static final String NAME = "onXWebLivePusherBGMComplete";

        private C0607b() {
        }

        /* synthetic */ C0607b(byte b2) {
            this();
        }
    }

    static final class a extends bc {
        private static final int CTRL_INDEX = 784;
        private static final String NAME = "onXWebLivePusherAudioVolume";

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    static final class e extends bc {
        private static final int CTRL_INDEX = 574;
        private static final String NAME = "onXWebLivePusherError";

        private e() {
        }

        /* synthetic */ e(byte b2) {
            this();
        }
    }
}
