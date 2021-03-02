package com.tencent.mm.plugin.appbrand.jsapi.ae;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.d;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001a\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\u0012\u0010\u001f\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J \u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\bH\u0016J\u0018\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\fH\u0016J\u0006\u0010(\u001a\u00020\u0015J\u0016\u0010)\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017J \u0010*\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0017R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/voip/VoipRoomPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/BaseExtendPluginHandler;", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView$SameLayerCallback;", "()V", "cloudVoiceView", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/IOpenVoiceView;", "pendingInvokeContexts", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "scaleHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoScaleHandler;", "surfaceDefaultBufferHeight", "", "surfaceDefaultBufferWidth", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "videoHeight", "videoObjectFit", "", "videoWidth", "adjustScale", "", "data", "Lorg/json/JSONObject;", "adjustSurfaceSize", "openVoiceView", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView;", "applyScale", "handleJsApi", "invokeContext", "handlePluginDestroy", "handlePluginReady", "insert", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "isPluginReady", "", "onVideoSizeChanged", "width", "height", "release", "remove", "update", "Companion", "plugin-appbrand-integration_release"})
public final class e extends com.tencent.luggage.xweb_ext.extendplugin.a.a implements d.b {
    public static final a mGk = new a((byte) 0);
    private final List<com.tencent.luggage.xweb_ext.extendplugin.a> lRj = new ArrayList();
    private com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c mGf;
    private int mGg;
    private int mGh;
    private String mGi = "cover";
    private g mGj = new g();
    private SurfaceTexture surfaceTexture;
    private int videoHeight;
    private int videoWidth;

    static {
        AppMethodBeat.i(228595);
        AppMethodBeat.o(228595);
    }

    public e() {
        AppMethodBeat.i(228594);
        AppMethodBeat.o(228594);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/voip/VoipRoomPluginHandler$Companion;", "", "()V", "DEFAULT_SCALE_TYPE", "", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void e(SurfaceTexture surfaceTexture2) {
        AppMethodBeat.i(228585);
        super.e(surfaceTexture2);
        this.surfaceTexture = surfaceTexture2;
        if (surfaceTexture2 != null) {
            Iterator<T> it = this.lRj.iterator();
            while (it.hasNext()) {
                h(it.next());
            }
            this.lRj.clear();
        }
        AppMethodBeat.o(228585);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void PQ() {
        AppMethodBeat.i(228586);
        super.PQ();
        this.surfaceTexture = null;
        release();
        this.lRj.clear();
        AppMethodBeat.o(228586);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(228587);
        p.h(aVar, "invokeContext");
        AppMethodBeat.o(228587);
        return true;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final String h(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(228588);
        p.h(aVar, "invokeContext");
        if (aVar instanceof com.tencent.mm.plugin.appbrand.h.b) {
            f NN = ((com.tencent.mm.plugin.appbrand.h.b) aVar).NN();
            com.tencent.mm.plugin.appbrand.jsapi.p bCx = ((com.tencent.mm.plugin.appbrand.h.b) aVar).bCx();
            JSONObject KX = ((com.tencent.mm.plugin.appbrand.h.b) aVar).KX();
            p.g(bCx, "jsApi");
            Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", Lb(), bCx.getName(), KX.toString());
            NN.P(new b(this, aVar, new c(this, bCx, NN, aVar, KX)));
        }
        AppMethodBeat.o(228588);
        return null;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ JSONObject lFq;
        final /* synthetic */ com.tencent.luggage.xweb_ext.extendplugin.a lRn;
        final /* synthetic */ e mGl;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.p mGn;
        final /* synthetic */ f mdz;

        c(e eVar, com.tencent.mm.plugin.appbrand.jsapi.p pVar, f fVar, com.tencent.luggage.xweb_ext.extendplugin.a aVar, JSONObject jSONObject) {
            this.mGl = eVar;
            this.mGn = pVar;
            this.mdz = fVar;
            this.lRn = aVar;
            this.lFq = jSONObject;
        }

        public final void run() {
            com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c cVar;
            AppMethodBeat.i(228584);
            com.tencent.mm.plugin.appbrand.jsapi.p pVar = this.mGn;
            if (pVar instanceof c) {
                Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "insert xweb voip");
                e eVar = this.mGl;
                f fVar = this.mdz;
                p.g(fVar, "component");
                com.tencent.luggage.xweb_ext.extendplugin.a aVar = this.lRn;
                JSONObject jSONObject = this.lFq;
                p.g(jSONObject, "data");
                e.a(eVar, fVar, aVar, jSONObject);
                AppMethodBeat.o(228584);
            } else if (pVar instanceof b) {
                Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "update xweb voip");
                e eVar2 = this.mGl;
                com.tencent.luggage.xweb_ext.extendplugin.a aVar2 = this.lRn;
                com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c cVar2 = this.mGl.mGf;
                JSONObject jSONObject2 = this.lFq;
                p.g(jSONObject2, "data");
                p.h(aVar2, "invokeContext");
                p.h(jSONObject2, "data");
                Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "onUpdateView, data:".concat(String.valueOf(jSONObject2)));
                if (cVar2 == null) {
                    aVar2.dP("fail");
                    Log.w("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "the view is null");
                    AppMethodBeat.o(228584);
                    return;
                }
                if (!(cVar2 instanceof d)) {
                    cVar = null;
                } else {
                    cVar = cVar2;
                }
                eVar2.a(jSONObject2, (d) cVar);
                eVar2.ag(jSONObject2);
                cVar2.aH(jSONObject2);
                aVar2.dP("ok");
                AppMethodBeat.o(228584);
            } else {
                if (pVar instanceof d) {
                    Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "remove xweb voip");
                    e eVar3 = this.mGl;
                    com.tencent.luggage.xweb_ext.extendplugin.a aVar3 = this.lRn;
                    JSONObject jSONObject3 = this.lFq;
                    p.g(jSONObject3, "data");
                    p.h(aVar3, "invokeContext");
                    p.h(jSONObject3, "data");
                    Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "onRemoveView,".concat(String.valueOf(jSONObject3)));
                    eVar3.release();
                    aVar3.dP("ok");
                }
                AppMethodBeat.o(228584);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ com.tencent.luggage.xweb_ext.extendplugin.a lRn;
        final /* synthetic */ e mGl;
        final /* synthetic */ Runnable mGm;

        b(e eVar, com.tencent.luggage.xweb_ext.extendplugin.a aVar, Runnable runnable) {
            this.mGl = eVar;
            this.lRn = aVar;
            this.mGm = runnable;
        }

        public final void run() {
            AppMethodBeat.i(228583);
            if (this.mGl.surfaceTexture == null) {
                this.mGl.lRj.add(this.lRn);
                AppMethodBeat.o(228583);
                return;
            }
            this.mGm.run();
            AppMethodBeat.o(228583);
        }
    }

    public final void release() {
        AppMethodBeat.i(228589);
        if (this.mGf != null) {
            q.INSTANCE.czk().a(this.mGf);
            this.mGf = null;
        }
        AppMethodBeat.o(228589);
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.d.b
    public final void eq(int i2, int i3) {
        AppMethodBeat.i(228590);
        if (this.videoWidth == i2 && this.videoHeight == i3) {
            AppMethodBeat.o(228590);
            return;
        }
        this.videoWidth = i2;
        this.videoHeight = i3;
        bLm();
        AppMethodBeat.o(228590);
    }

    /* access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject, d dVar) {
        AppMethodBeat.i(228591);
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            int zD = com.tencent.mm.plugin.appbrand.ac.g.zD(optJSONObject.optInt("width", 0));
            int zD2 = com.tencent.mm.plugin.appbrand.ac.g.zD(optJSONObject.optInt("height", 0));
            Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "adjustSurfaceSize, size:[%d, %d]", Integer.valueOf(zD), Integer.valueOf(zD2));
            if (zD > 0 && zD2 > 0) {
                this.mGg = zD;
                this.mGh = zD2;
                SurfaceTexture surfaceTexture2 = this.surfaceTexture;
                if (surfaceTexture2 != null) {
                    surfaceTexture2.setDefaultBufferSize(zD, zD2);
                }
                if (dVar != null) {
                    dVar.fq(zD, zD2);
                }
                if (dVar != null) {
                    dVar.fr(optJSONObject.optInt("width", 0), optJSONObject.optInt("height", 0));
                    AppMethodBeat.o(228591);
                    return;
                }
            }
        }
        AppMethodBeat.o(228591);
    }

    /* access modifiers changed from: package-private */
    public final void ag(JSONObject jSONObject) {
        AppMethodBeat.i(228592);
        String optString = jSONObject.optString("objectFit", "");
        p.g(optString, "objFit");
        if (optString.length() > 0) {
            this.mGi = optString;
        }
        bLm();
        AppMethodBeat.o(228592);
    }

    private final void bLm() {
        AppMethodBeat.i(228593);
        g gVar = this.mGj;
        if (gVar.a(this.mGi, this.mGg, this.mGh, this.videoWidth, this.videoHeight)) {
            com.tencent.luggage.xweb_ext.extendplugin.d.a(QJ(), getType(), getId(), gVar.QH(), gVar.QI());
        }
        AppMethodBeat.o(228593);
    }

    public static final /* synthetic */ void a(e eVar, f fVar, com.tencent.luggage.xweb_ext.extendplugin.a aVar, JSONObject jSONObject) {
        e eVar2;
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c cVar;
        d.a aVar2 = null;
        AppMethodBeat.i(228596);
        Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "onInsertView, viewId:[data:".concat(String.valueOf(jSONObject)));
        SurfaceTexture surfaceTexture2 = eVar.surfaceTexture;
        if (surfaceTexture2 != null) {
            Context context = fVar.getContext();
            if (context == null) {
                aVar.dP("fail");
                AppMethodBeat.o(228596);
            } else if (q.INSTANCE.czj() == 2) {
                aVar.dP("fail");
                Log.w("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "insert XWeb VoIp view failed, room is audio room");
                AppMethodBeat.o(228596);
            } else {
                com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c a2 = q.INSTANCE.czk().a(context, jSONObject, true);
                if (a2 != null) {
                    if (!(a2 instanceof d)) {
                        cVar = null;
                    } else {
                        cVar = a2;
                    }
                    d dVar = (d) cVar;
                    if (dVar != null) {
                        eVar.a(jSONObject, dVar);
                        eVar.ag(jSONObject);
                        if (dVar instanceof d.a) {
                            aVar2 = dVar;
                        }
                        d.a aVar3 = aVar2;
                        if (aVar3 != null) {
                            aVar3.setSameLayerCallback(eVar);
                        }
                        dVar.setSurfaceTexture(surfaceTexture2);
                        a2.aG(jSONObject);
                    } else {
                        a2 = null;
                    }
                    eVar2 = eVar;
                } else {
                    a2 = null;
                    eVar2 = eVar;
                }
                eVar2.mGf = a2;
                if (eVar.mGf != null) {
                    aVar.dP("ok");
                    AppMethodBeat.o(228596);
                    return;
                }
                aVar.dP("fail");
                AppMethodBeat.o(228596);
            }
        } else {
            AppMethodBeat.o(228596);
        }
    }
}
