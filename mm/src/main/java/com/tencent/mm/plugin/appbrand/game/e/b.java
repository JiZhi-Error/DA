package com.tencent.mm.plugin.appbrand.game.e;

import android.view.View;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af;
import com.tencent.mm.plugin.appbrand.game.a.r;
import com.tencent.mm.plugin.appbrand.game.a.t;
import com.tencent.mm.plugin.appbrand.game.f.a.c;
import com.tencent.mm.plugin.appbrand.game.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0002\u0010\u0007J,\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/game/jsapi/WAGameJsApiInsertVideoPlayer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/jsapi/JsApiInsertVideoPlayer;", "()V", "getUnderView", "", "data", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Ljava/lang/Boolean;", "onInsertView", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentView;", "viewId", "", "view", "Landroid/view/View;", "Companion", "plugin-appbrand-integration_release"})
public final class b extends com.tencent.mm.plugin.appbrand.jsapi.video.d.a {
    public static final int CTRL_INDEX = 6;
    public static final String NAME = "insertVideoPlayer";
    @Deprecated
    public static final a lsy = new a((byte) 0);

    static {
        AppMethodBeat.i(180454);
        AppMethodBeat.o(180454);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/magicbrush/ui/MagicBrushView;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.game.e.b$b  reason: collision with other inner class name */
    static final class C0585b extends q implements kotlin.g.a.b<MagicBrushView, x> {
        public static final C0585b lsz = new C0585b();

        static {
            AppMethodBeat.i(180451);
            AppMethodBeat.o(180451);
        }

        C0585b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(MagicBrushView magicBrushView) {
            AppMethodBeat.i(180450);
            MagicBrushView magicBrushView2 = magicBrushView;
            p.h(magicBrushView2, LocaleUtil.ITALIAN);
            a unused = b.lsy;
            Log.i("Luggage.WAGameJsApiInsertVideoPlayer", "InsertVideoPlayer, info: change viewType to TextureView");
            if (magicBrushView2.getViewType() != MagicBrushView.h.TextureView) {
                magicBrushView2.setRendererView(new c(magicBrushView2.getContext()));
                magicBrushView2.setOpaque(false);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(180450);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/game/jsapi/WAGameJsApiInsertVideoPlayer$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final Boolean I(JSONObject jSONObject) {
        Boolean bool = null;
        AppMethodBeat.i(180452);
        if (jSONObject != null) {
            try {
                bool = Boolean.valueOf(jSONObject.getBoolean("underGameView"));
            } catch (JSONException e2) {
            }
        }
        Log.i("Luggage.WAGameJsApiInsertVideoPlayer", "getUnderView ".concat(String.valueOf(bool)));
        AppMethodBeat.o(180452);
        return bool;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.d.a, com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final void a(h hVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(180453);
        p.h(hVar, "component");
        super.a(hVar, i2, view, jSONObject);
        com.tencent.mm.plugin.appbrand.service.c bsE = ((d) hVar).bsE();
        com.tencent.luggage.game.d.a.a.b bVar = bsE != null ? (com.tencent.luggage.game.d.a.a.b) bsE.S(com.tencent.luggage.game.d.a.a.b.class) : null;
        if (bVar == null) {
            Log.w("JsApiInsertHTMLCanvasElement", "hy: webgl extension not exists!");
            AppMethodBeat.o(180453);
            return;
        }
        e magicBrush = bVar.getMagicBrush();
        if (magicBrush == null) {
            Log.e("Luggage.WAGameJsApiInsertVideoPlayer", "InsertViewPlayer but, no magicbrush found, maybe functionalPage[%d]", Boolean.valueOf(af.p(((d) hVar).getRuntime())));
            AppMethodBeat.o(180453);
            return;
        }
        if (p.j(Boolean.TRUE, I(jSONObject))) {
            magicBrush.cLz.forEach(C0585b.lsz);
            if (((Boolean) r.lrS.aLT()).booleanValue()) {
                Log.i("Luggage.WAGameJsApiInsertVideoPlayer", "hy: use main thread choreographer");
                if (((Boolean) t.lrU.aLT()).booleanValue()) {
                    magicBrush.a(a.b.NativeLocker);
                    AppMethodBeat.o(180453);
                    return;
                }
                magicBrush.a(a.b.ChoreographerInMainThread);
                AppMethodBeat.o(180453);
                return;
            }
            Log.i("Luggage.WAGameJsApiInsertVideoPlayer", "hy: use js thread choreographer");
            magicBrush.a(a.b.ChoreographerInJsThread);
        }
        AppMethodBeat.o(180453);
    }
}
