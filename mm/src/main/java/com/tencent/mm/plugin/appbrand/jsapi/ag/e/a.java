package com.tencent.mm.plugin.appbrand.jsapi.ag.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import java.math.BigDecimal;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 #2\u00020\u0001:\r#$%&'()*+,-.\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;", "()V", "mEventData", "", "mInvokeContext", "Lcom/tencent/mm/plugin/appbrand/extendplugin/AppBrandInvokeContext;", "mLastUpdatePos", "", "dispatchEvent", "", "event", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "data", "Lorg/json/JSONObject;", "getBaseEventData", "onVideoEnded", "onVideoPause", "onVideoPlay", "onVideoProgress", "percent", "onVideoTimeUpdate", "currentPosition", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "onVideoWaiting", "onXWebCastingInterrupt", "onXWebCastingUserSelect", "state", "", "onXWebDLNACastingStateChange", "isSuccess", "setInvokeContext", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "setVideoEventData", "Companion", "OnXWebCastingInterrupt", "OnXWebCastingUserSelect", "OnXWebVideoEnded", "OnXWebVideoError", "OnXWebVideoLoadedMetaData", "OnXWebVideoPause", "OnXWebVideoPlay", "OnXWebVideoPreloadedMetaData", "OnXWebVideoProgress", "OnXWebVideoTimeUpdate", "OnXWebVideoWaiting", "luggage-xweb-ext_release"})
public final class a implements com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a {
    public static final C0608a mKw = new C0608a((byte) 0);
    private com.tencent.mm.plugin.appbrand.h.b mJX;
    private int mKu;
    private String mKv = "";

    static {
        AppMethodBeat.i(139650);
        AppMethodBeat.o(139650);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$Companion;", "", "()V", "TAG", "", "luggage-xweb-ext_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.e.a$a  reason: collision with other inner class name */
    public static final class C0608a {
        private C0608a() {
        }

        public /* synthetic */ C0608a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a
    public final void onVideoPlay() {
        AppMethodBeat.i(139637);
        try {
            this.mKu = 0;
            JSONObject bKv = bKv();
            bKv.put("timeStamp", System.currentTimeMillis());
            bKv.put("type", "DLNA");
            a(new f(), bKv);
            AppMethodBeat.o(139637);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebVideoPlay fail", e2);
            AppMethodBeat.o(139637);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a
    public final void onVideoPause() {
        AppMethodBeat.i(139638);
        Log.i("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onVideoPause: ");
        try {
            JSONObject bKv = bKv();
            bKv.put("type", "DLNA");
            a(new e(), bKv);
            AppMethodBeat.o(139638);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebVideoPause fail", e2);
            AppMethodBeat.o(139638);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a
    public final void onVideoEnded() {
        AppMethodBeat.i(139639);
        Log.i("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onVideoEnded: ");
        try {
            JSONObject bKv = bKv();
            bKv.put("type", "DLNA");
            a(new d(), bKv);
            AppMethodBeat.o(139639);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebVideoEnded fail", e2);
            AppMethodBeat.o(139639);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a
    public final void onVideoWaiting() {
        AppMethodBeat.i(139640);
        try {
            JSONObject bKv = bKv();
            bKv.put("timeStamp", System.currentTimeMillis());
            bKv.put("type", "DLNA");
            a(new i(), bKv);
            AppMethodBeat.o(139640);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebVideoWaiting fail", e2);
            AppMethodBeat.o(139640);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a
    public final void ie(int i2) {
        AppMethodBeat.i(139641);
        Log.i("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onVideoProgress: ".concat(String.valueOf(i2)));
        try {
            JSONObject bKv = bKv();
            bKv.put("buffered", i2);
            bKv.put("type", "DLNA");
            a(new g(), bKv);
            AppMethodBeat.o(139641);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebVideoProgress fail", e2);
            AppMethodBeat.o(139641);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a
    public final void bZ(int i2, int i3) {
        AppMethodBeat.i(139642);
        Log.i("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onVideoTimeUpdate: currentPosition = " + i2 + " duration = " + i3);
        try {
            if (Math.abs(i2 - this.mKu) < 250) {
                AppMethodBeat.o(139642);
                return;
            }
            this.mKu = i2;
            double doubleValue = new BigDecimal((((double) i2) * 1.0d) / 1000.0d).setScale(3, 4).doubleValue();
            JSONObject bKv = bKv();
            bKv.put("type", "DLNA");
            bKv.put("position", doubleValue);
            bKv.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, (((double) i3) * 1.0d) / 1000.0d);
            a(new h(), bKv);
            AppMethodBeat.o(139642);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebVideoTimeUpdate fail", e2);
            AppMethodBeat.o(139642);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a
    public final void m(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(139643);
        p.h(aVar, "invokeContext");
        if (aVar instanceof com.tencent.mm.plugin.appbrand.h.b) {
            this.mJX = (com.tencent.mm.plugin.appbrand.h.b) aVar;
        }
        AppMethodBeat.o(139643);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a
    public final void cg(boolean z) {
        AppMethodBeat.i(139644);
        String str = z ? "success" : "fail";
        Log.i("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onXWebDLNACastingStateChange: status = ".concat(String.valueOf(str)));
        try {
            JSONObject bKv = bKv();
            bKv.put("status", str);
            a(new j(), bKv);
            AppMethodBeat.o(139644);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onXWebDLNACastingStateChange fail", e2);
            AppMethodBeat.o(139644);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a
    public final void ch(boolean z) {
        String str;
        AppMethodBeat.i(161187);
        Log.i("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onXWebCastingUserSelect: ");
        try {
            JSONObject bKv = bKv();
            bKv.put("type", "DLNA");
            if (z) {
                str = "success";
            } else {
                str = "fail";
            }
            bKv.put("state", str);
            a(new c(), bKv);
            AppMethodBeat.o(161187);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebCastingUserSelect fail", e2);
            AppMethodBeat.o(161187);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a
    public final void QB() {
        AppMethodBeat.i(139646);
        try {
            a(new b(), bKv());
            AppMethodBeat.o(139646);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onXWebCastingInterrupt fail", e2);
            AppMethodBeat.o(139646);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a
    public final void dV(String str) {
        AppMethodBeat.i(139647);
        p.h(str, "data");
        this.mKv = str;
        AppMethodBeat.o(139647);
    }

    private final void a(bc bcVar, JSONObject jSONObject) {
        AppMethodBeat.i(139648);
        if (!(bcVar instanceof h) && !(bcVar instanceof g)) {
            Log.i("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "dispatch event:%s, data:%s", bcVar.getName(), jSONObject.toString());
        }
        bc Zh = bcVar.Zh(jSONObject.toString());
        if (this.mJX != null) {
            com.tencent.mm.plugin.appbrand.h.b bVar = this.mJX;
            if (bVar == null) {
                p.hyc();
            }
            com.tencent.mm.plugin.appbrand.jsapi.f NN = bVar.NN();
            if (NN != null) {
                if (NN instanceof s) {
                    s sVar = (s) NN;
                    sVar.a(Zh, (int[]) null);
                    ac currentPageView = sVar.getCurrentPageView();
                    if (currentPageView != null) {
                        currentPageView.a(Zh, (int[]) null);
                        AppMethodBeat.o(139648);
                        return;
                    }
                    AppMethodBeat.o(139648);
                    return;
                } else if (NN instanceof ac) {
                    ac acVar = (ac) NN;
                    acVar.a(Zh, (int[]) null);
                    s NY = acVar.NY();
                    if (NY != null) {
                        NY.a(Zh, (int[]) null);
                        AppMethodBeat.o(139648);
                        return;
                    }
                    AppMethodBeat.o(139648);
                    return;
                } else {
                    NN.a(Zh, (int[]) null);
                }
            }
        }
        AppMethodBeat.o(139648);
    }

    private final JSONObject bKv() {
        AppMethodBeat.i(139649);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", this.mKv);
        AppMethodBeat.o(139649);
        return jSONObject;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoPlay;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"})
    static final class f extends bc {
        private static final int CTRL_INDEX = CTRL_INDEX;
        private static final String NAME = NAME;
        public static final C0613a mKB = new C0613a((byte) 0);

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoPlay$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.e.a$f$a  reason: collision with other inner class name */
        public static final class C0613a {
            private C0613a() {
            }

            public /* synthetic */ C0613a(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(139632);
            AppMethodBeat.o(139632);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoPause;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"})
    static final class e extends bc {
        private static final int CTRL_INDEX = CTRL_INDEX;
        private static final String NAME = NAME;
        public static final C0612a mKA = new C0612a((byte) 0);

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoPause$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.e.a$e$a  reason: collision with other inner class name */
        public static final class C0612a {
            private C0612a() {
            }

            public /* synthetic */ C0612a(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(139631);
            AppMethodBeat.o(139631);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoEnded;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"})
    static final class d extends bc {
        private static final int CTRL_INDEX = CTRL_INDEX;
        private static final String NAME = NAME;
        public static final C0611a mKz = new C0611a((byte) 0);

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoEnded$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.e.a$d$a  reason: collision with other inner class name */
        public static final class C0611a {
            private C0611a() {
            }

            public /* synthetic */ C0611a(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(139630);
            AppMethodBeat.o(139630);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoTimeUpdate;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"})
    public static final class h extends bc {
        private static final int CTRL_INDEX = CTRL_INDEX;
        private static final String NAME = NAME;
        public static final C0617a mKD = new C0617a((byte) 0);

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoTimeUpdate$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.e.a$h$a  reason: collision with other inner class name */
        public static final class C0617a {
            private C0617a() {
            }

            public /* synthetic */ C0617a(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(139634);
            AppMethodBeat.o(139634);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoWaiting;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"})
    static final class i extends bc {
        private static final int CTRL_INDEX = 540;
        private static final String NAME = NAME;
        public static final C0620a mKE = new C0620a((byte) 0);

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoWaiting$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.e.a$i$a  reason: collision with other inner class name */
        public static final class C0620a {
            private C0620a() {
            }

            public /* synthetic */ C0620a(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(139635);
            AppMethodBeat.o(139635);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoProgress;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"})
    public static final class g extends bc {
        private static final int CTRL_INDEX = CTRL_INDEX;
        private static final String NAME = NAME;
        public static final C0614a mKC = new C0614a((byte) 0);

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoProgress$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.e.a$g$a  reason: collision with other inner class name */
        public static final class C0614a {
            private C0614a() {
            }

            public /* synthetic */ C0614a(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(139633);
            AppMethodBeat.o(139633);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$onXWebDLNACastingStateChange;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"})
    static final class j extends bc {
        private static final int CTRL_INDEX = CTRL_INDEX;
        private static final String NAME = NAME;
        public static final C0621a mKF = new C0621a((byte) 0);

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$onXWebDLNACastingStateChange$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.e.a$j$a  reason: collision with other inner class name */
        public static final class C0621a {
            private C0621a() {
            }

            public /* synthetic */ C0621a(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(139636);
            AppMethodBeat.o(139636);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebCastingUserSelect;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"})
    static final class c extends bc {
        private static final int CTRL_INDEX = CTRL_INDEX;
        private static final String NAME = NAME;
        public static final C0610a mKy = new C0610a((byte) 0);

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebCastingUserSelect$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.e.a$c$a  reason: collision with other inner class name */
        public static final class C0610a {
            private C0610a() {
            }

            public /* synthetic */ C0610a(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(139629);
            AppMethodBeat.o(139629);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebCastingInterrupt;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"})
    static final class b extends bc {
        private static final int CTRL_INDEX = 704;
        private static final String NAME = NAME;
        public static final C0609a mKx = new C0609a((byte) 0);

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebCastingInterrupt$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.e.a$b$a  reason: collision with other inner class name */
        public static final class C0609a {
            private C0609a() {
            }

            public /* synthetic */ C0609a(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(139628);
            AppMethodBeat.o(139628);
        }
    }
}
