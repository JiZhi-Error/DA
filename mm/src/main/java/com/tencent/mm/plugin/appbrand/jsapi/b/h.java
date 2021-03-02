package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.content.Context;
import android.view.View;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.i;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\f\u001a\u00020\nH\u0014J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\"\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0006H\u0014J\b\u0010\u0014\u001a\u00020\nH\u0014J0\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0015R2\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u00060\u0007R\u00020\u00000\u0005j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u00060\u0007R\u00020\u0000`\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/BaseInsertViewJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "requestMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "Lkotlin/collections/HashMap;", "scrollSupportedTouchEvent", "", "enableGesture", "enableLongClick", "getViewId", "data", "Lorg/json/JSONObject;", "inflateView", "Landroid/view/View;", "component", "viewId", "isAsyncCallback", "onInsertViewWithAsyncCallback", "", "view", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "Companion", "Request", "plugin-appbrand-integration_release"})
public final class h extends com.tencent.mm.plugin.appbrand.jsapi.base.b<ag> {
    public static final int CTRL_INDEX = 594;
    public static final String NAME = "insertWebGLCanvas";
    public static final a lQY = new a((byte) 0);
    private final HashMap<Integer, b> lQW = new HashMap<>();
    private boolean lQX;

    static {
        AppMethodBeat.i(50501);
        AppMethodBeat.o(50501);
    }

    public h() {
        AppMethodBeat.i(50500);
        AppMethodBeat.o(50500);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.h, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final /* bridge */ /* synthetic */ View a(ag agVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(50497);
        View a2 = a(agVar, jSONObject, i2);
        AppMethodBeat.o(50497);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.h, int, android.view.View, org.json.JSONObject, com.tencent.mm.plugin.appbrand.jsapi.base.i] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final /* synthetic */ void a(ag agVar, int i2, View view, JSONObject jSONObject, i iVar) {
        AppMethodBeat.i(50499);
        p.h(agVar, "component");
        p.h(view, "view");
        p.h(jSONObject, "data");
        p.h(iVar, "callback");
        b bVar = this.lQW.get(Integer.valueOf(i2));
        if (bVar == null) {
            p.hyc();
        }
        b bVar2 = bVar;
        if (!(iVar != null)) {
            IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.o(50499);
            throw illegalStateException;
        }
        bVar2.lRa = iVar;
        if (bVar2.lQZ) {
            bVar2.invoke();
        }
        AppMethodBeat.o(50499);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0002R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "", "id", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;I)V", "value", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "callback", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;)V", "getId", "()I", "", "isViewReady", "()Z", "setViewReady", "(Z)V", "invoke", "", "plugin-appbrand-integration_release"})
    public final class b {
        private final int id;
        boolean lQZ;
        i lRa;

        public b(int i2) {
            this.id = i2;
        }

        /* access modifiers changed from: package-private */
        public final void invoke() {
            AppMethodBeat.i(50492);
            if (!this.lQZ) {
                IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
                AppMethodBeat.o(50492);
                throw illegalStateException;
            }
            i iVar = this.lRa;
            if (iVar == null) {
                p.hyc();
            }
            iVar.ZA(h.this.Zf("ok"));
            h.this.lQW.remove(Integer.valueOf(this.id));
            Log.i("JsApiInsertHTMLCanvasElement", "callback ok for canvasId [" + this.id + ']');
            AppMethodBeat.o(50492);
        }
    }

    private View a(ag agVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(50496);
        p.h(agVar, "component");
        p.h(jSONObject, "data");
        Log.i("JsApiInsertHTMLCanvasElement", "inflateView of HTMLCanvasElement for canvasId [" + i2 + "] [" + jSONObject + ']');
        com.tencent.mm.plugin.appbrand.service.c bsE = agVar.bsE();
        com.tencent.luggage.game.d.a.a.c cVar = bsE != null ? (com.tencent.luggage.game.d.a.a.c) bsE.S(com.tencent.luggage.game.d.a.a.c.class) : null;
        if (cVar == null) {
            Log.w("JsApiInsertHTMLCanvasElement", "hy: webgl extension not exists!");
            AppMethodBeat.o(50496);
            return null;
        }
        com.tencent.magicbrush.e magicBrush = cVar.getMagicBrush();
        if (magicBrush == null) {
            AppMethodBeat.o(50496);
            return null;
        }
        this.lQX = jSONObject.optBoolean("scrollSupportedTouchEvent", false);
        b bVar = new b(i2);
        this.lQW.put(Integer.valueOf(i2), bVar);
        Context context = agVar.getContext();
        p.g(context, "component.context");
        MagicBrushView magicBrushView = new MagicBrushView(context, MagicBrushView.h.TextureView);
        magicBrushView.setMagicBrush(magicBrush);
        magicBrushView.getPreparedListeners().add(new c(bVar));
        a.C0646a aVar = a.lQO;
        String appId = agVar.getAppId();
        p.g(appId, "component.appId");
        a.C0646a.ZJ(appId).a(i2, magicBrushView);
        if (this.lQX) {
            magicBrushView.setEnableTouchEvent(false);
        }
        agVar.a(new d(agVar, i2, magicBrush));
        if (agVar.Pv()) {
            a.C0646a aVar2 = a.lQO;
            String appId2 = agVar.getAppId();
            p.g(appId2, "component.appId");
            a ZJ = a.C0646a.ZJ(appId2);
            ZJ.wZ(i2);
            if (ZJ.bGc() == 1) {
                magicBrush.Rc();
            }
        }
        agVar.a(new e(agVar, i2, magicBrush));
        CoverViewContainer coverViewContainer = new CoverViewContainer(agVar.getContext(), magicBrushView);
        AppMethodBeat.o(50496);
        return coverViewContainer;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$inflateView$1", "Lcom/tencent/magicbrush/ui/MagicBrushView$OnPreparedListener;", "onPrepared", "", "plugin-appbrand-integration_release"})
    public static final class c implements MagicBrushView.f {
        final /* synthetic */ b lRc;

        c(b bVar) {
            this.lRc = bVar;
        }

        @Override // com.tencent.magicbrush.ui.MagicBrushView.f
        public final void tf() {
            AppMethodBeat.i(50493);
            b bVar = this.lRc;
            bVar.lQZ = true;
            if (bVar.lRa != null) {
                bVar.invoke();
            }
            AppMethodBeat.o(50493);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onForeground"})
    public static final class d implements i.d {
        final /* synthetic */ ag lRd;
        final /* synthetic */ int lRe;
        final /* synthetic */ com.tencent.magicbrush.e lRf;

        d(ag agVar, int i2, com.tencent.magicbrush.e eVar) {
            this.lRd = agVar;
            this.lRe = i2;
            this.lRf = eVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.i.d
        public final void onForeground() {
            AppMethodBeat.i(50494);
            Log.i("JsApiInsertHTMLCanvasElement", "foreground");
            a.C0646a aVar = a.lQO;
            String appId = this.lRd.getAppId();
            p.g(appId, "component.appId");
            a ZJ = a.C0646a.ZJ(appId);
            ZJ.wZ(this.lRe);
            if (ZJ.bGc() == 1) {
                this.lRf.Rc();
            }
            AppMethodBeat.o(50494);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onBackground"})
    public static final class e implements i.b {
        final /* synthetic */ ag lRd;
        final /* synthetic */ int lRe;
        final /* synthetic */ com.tencent.magicbrush.e lRf;

        e(ag agVar, int i2, com.tencent.magicbrush.e eVar) {
            this.lRd = agVar;
            this.lRe = i2;
            this.lRf = eVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
        public final void onBackground() {
            AppMethodBeat.i(50495);
            Log.i("JsApiInsertHTMLCanvasElement", "background");
            q runtime = this.lRd.getRuntime();
            p.g(runtime, "component.runtime");
            if (runtime.isDestroyed()) {
                AppMethodBeat.o(50495);
                return;
            }
            a.C0646a aVar = a.lQO;
            String appId = this.lRd.getAppId();
            p.g(appId, "component.appId");
            a ZJ = a.C0646a.ZJ(appId);
            ZJ.xa(this.lRe);
            if (ZJ.bGc() == 0) {
                this.lRf.Rd();
            }
            AppMethodBeat.o(50495);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(50498);
        p.h(jSONObject, "data");
        int i2 = jSONObject.getInt("canvasId");
        AppMethodBeat.o(50498);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final boolean bEV() {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final boolean bEW() {
        return this.lQX;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final boolean bEX() {
        return this.lQX;
    }
}
