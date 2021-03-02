package com.tencent.mm.plugin.appbrand.jsapi.b.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.b.a.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.b.a.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\fH\u0016J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\fH\u0002J\b\u0010#\u001a\u00020\u001eH\u0016J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010%\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J(\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0007H\u0002J\u0012\u00100\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\fH\u0016J(\u00101\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0007H\u0002J\u0018\u00102\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\u0006\u00103\u001a\u000204H\u0002J\u0012\u00105\u001a\u00020\u001e2\b\u00106\u001a\u0004\u0018\u00010\u000eH\u0016JC\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\t2!\u0010:\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020?0;2\u0006\u0010@\u001a\u00020AH\u0016J(\u0010B\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0007H\u0002J\b\u0010C\u001a\u00020\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/BaseExtendPluginHandler;", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "()V", "componentView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "height", "", "inited", "", "pendingInvokeContexts", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "surfaceListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "thisView", "Landroid/view/View;", "getThisView", "()Landroid/view/View;", "viewId", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "virtualView", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "width", "clearPendingJsApi", "", "handleJsApi", "", "invokeContext", "handleJsApiInternal", "handlePluginDestroy", "handlePluginReady", "handlePluginTouch", "event", "Landroid/view/MotionEvent;", "insert", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "data", "Lorg/json/JSONObject;", "jsApi", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "callbackId", "isPluginReady", "remove", "runOnJsThread", "runnable", "Ljava/lang/Runnable;", "setSurfaceListener", "l", "switchToRecordableMode", "forceRecreate", "recordable", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "update", "updateSurfaceTexture", "Companion", "plugin-appbrand-integration_release"})
public final class a extends com.tencent.luggage.xweb_ext.extendplugin.a.a implements MagicBrushView.b {
    public static final C0647a lRl = new C0647a((byte) 0);
    private MagicBrushView.c cOP;
    private volatile boolean gKM;
    private int height = -1;
    private ag lRi;
    private final List<com.tencent.luggage.xweb_ext.extendplugin.a> lRj = new ArrayList();
    private MagicBrushView lRk;
    private SurfaceTexture surfaceTexture;
    private int viewId;
    private int width = -1;

    static {
        AppMethodBeat.i(228361);
        AppMethodBeat.o(228361);
    }

    public a() {
        AppMethodBeat.i(228360);
        AppMethodBeat.o(228360);
    }

    public static final /* synthetic */ ag d(a aVar) {
        AppMethodBeat.i(228366);
        ag agVar = aVar.lRi;
        if (agVar == null) {
            p.btv("componentView");
        }
        AppMethodBeat.o(228366);
        return agVar;
    }

    @Override // com.tencent.magicbrush.ui.MagicBrushView.b
    public final Object getSurface() {
        AppMethodBeat.i(228362);
        Object a2 = MagicBrushView.b.a.a(this);
        AppMethodBeat.o(228362);
        return a2;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void e(SurfaceTexture surfaceTexture2) {
        AppMethodBeat.i(228351);
        p.h(surfaceTexture2, "surfaceTexture");
        super.e(surfaceTexture2);
        Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "handlePluginReady mViewId:" + this.viewId + " inited:" + this.gKM + " id:" + this.id);
        SurfaceTexture surfaceTexture3 = this.surfaceTexture;
        if (surfaceTexture3 != null) {
            Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "destroy previous surface ".concat(String.valueOf(surfaceTexture3)));
            MagicBrushView.c cVar = this.cOP;
            if (cVar != null) {
                cVar.a(surfaceTexture3, false);
            }
        }
        this.surfaceTexture = surfaceTexture2;
        if (this.gKM) {
            bGe();
            AppMethodBeat.o(228351);
            return;
        }
        bGf();
        this.gKM = true;
        AppMethodBeat.o(228351);
    }

    private final void bGe() {
        AppMethodBeat.i(228352);
        Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "update surfaceTexture[" + this.surfaceTexture + "]: width:" + this.width + ", height:" + this.height + ' ');
        MagicBrushView.c cVar = this.cOP;
        if (cVar != null) {
            SurfaceTexture surfaceTexture2 = this.surfaceTexture;
            if (surfaceTexture2 == null) {
                p.hyc();
            }
            cVar.a(surfaceTexture2, this.width, this.height, false);
            AppMethodBeat.o(228352);
            return;
        }
        AppMethodBeat.o(228352);
    }

    private final void bGf() {
        AppMethodBeat.i(228353);
        List<com.tencent.luggage.xweb_ext.extendplugin.a> list = this.lRj;
        if (list.isEmpty()) {
            AppMethodBeat.o(228353);
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            x(it.next());
        }
        list.clear();
        AppMethodBeat.o(228353);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void PQ() {
        MagicBrushView.c cVar;
        AppMethodBeat.i(228354);
        Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "plugin destroyed viewId: " + this.viewId);
        super.PQ();
        SurfaceTexture surfaceTexture2 = this.surfaceTexture;
        if (!(surfaceTexture2 == null || (cVar = this.cOP) == null)) {
            cVar.a(surfaceTexture2, false);
        }
        this.surfaceTexture = null;
        AppMethodBeat.o(228354);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final String h(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(228355);
        p.h(aVar, "invokeContext");
        Log.v("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "handleJsApi " + aVar.Pt());
        if (this.gKM) {
            x(aVar);
        } else {
            this.lRj.add(aVar);
        }
        AppMethodBeat.o(228355);
        return null;
    }

    private final void x(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(228356);
        if (!(aVar instanceof com.tencent.mm.plugin.appbrand.h.b)) {
            AppMethodBeat.o(228356);
            return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.f NN = ((com.tencent.mm.plugin.appbrand.h.b) aVar).NN();
        p.g(NN, "invokeContext.component");
        a(NN, new b(this, aVar));
        AppMethodBeat.o(228356);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ a lRm;
        final /* synthetic */ com.tencent.luggage.xweb_ext.extendplugin.a lRn;

        b(a aVar, com.tencent.luggage.xweb_ext.extendplugin.a aVar2) {
            this.lRm = aVar;
            this.lRn = aVar2;
        }

        public final void run() {
            AppMethodBeat.i(228346);
            com.tencent.mm.plugin.appbrand.jsapi.p bCx = ((com.tencent.mm.plugin.appbrand.h.b) this.lRn).bCx();
            if (bCx instanceof com.tencent.mm.plugin.appbrand.jsapi.b.a.a.b) {
                a aVar = this.lRm;
                com.tencent.mm.plugin.appbrand.jsapi.f NN = ((com.tencent.mm.plugin.appbrand.h.b) this.lRn).NN();
                p.g(NN, "invokeContext.component");
                JSONObject KX = ((com.tencent.mm.plugin.appbrand.h.b) this.lRn).KX();
                p.g(KX, "invokeContext.data");
                com.tencent.mm.plugin.appbrand.jsapi.p bCx2 = ((com.tencent.mm.plugin.appbrand.h.b) this.lRn).bCx();
                p.g(bCx2, "invokeContext.jsApi");
                a.a(aVar, NN, KX, bCx2, ((com.tencent.mm.plugin.appbrand.h.b) this.lRn).bCw());
                AppMethodBeat.o(228346);
            } else if (bCx instanceof d) {
                a aVar2 = this.lRm;
                com.tencent.mm.plugin.appbrand.jsapi.f NN2 = ((com.tencent.mm.plugin.appbrand.h.b) this.lRn).NN();
                p.g(NN2, "invokeContext.component");
                JSONObject KX2 = ((com.tencent.mm.plugin.appbrand.h.b) this.lRn).KX();
                p.g(KX2, "invokeContext.data");
                com.tencent.mm.plugin.appbrand.jsapi.p bCx3 = ((com.tencent.mm.plugin.appbrand.h.b) this.lRn).bCx();
                p.g(bCx3, "invokeContext.jsApi");
                a.b(aVar2, NN2, KX2, bCx3, ((com.tencent.mm.plugin.appbrand.h.b) this.lRn).bCw());
                AppMethodBeat.o(228346);
            } else {
                if (bCx instanceof c) {
                    a aVar3 = this.lRm;
                    com.tencent.mm.plugin.appbrand.jsapi.f NN3 = ((com.tencent.mm.plugin.appbrand.h.b) this.lRn).NN();
                    p.g(NN3, "invokeContext.component");
                    p.g(((com.tencent.mm.plugin.appbrand.h.b) this.lRn).KX(), "invokeContext.data");
                    com.tencent.mm.plugin.appbrand.jsapi.p bCx4 = ((com.tencent.mm.plugin.appbrand.h.b) this.lRn).bCx();
                    p.g(bCx4, "invokeContext.jsApi");
                    a.a(aVar3, NN3, bCx4, ((com.tencent.mm.plugin.appbrand.h.b) this.lRn).bCw());
                }
                AppMethodBeat.o(228346);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$1$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "onDestroy", "", "plugin-appbrand-integration_release"})
    public static final class c implements i.c {
        final /* synthetic */ a lRm;

        c(a aVar) {
            this.lRm = aVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
        public final void onDestroy() {
            AppMethodBeat.i(228347);
            SurfaceTexture surfaceTexture = this.lRm.surfaceTexture;
            if (surfaceTexture != null) {
                MagicBrushView.c cVar = this.lRm.cOP;
                if (cVar != null) {
                    cVar.a(surfaceTexture, false);
                }
                this.lRm.surfaceTexture = null;
            }
            a.d(this.lRm).b(this);
            AppMethodBeat.o(228347);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$2$1", "Lcom/tencent/magicbrush/ui/MagicBrushView$OnPreparedListener;", "onPrepared", "", "plugin-appbrand-integration_release"})
    public static final class d implements MagicBrushView.f {
        final /* synthetic */ a lRm;
        final /* synthetic */ com.tencent.magicbrush.e lRo;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.f lRp;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.p lRq;
        final /* synthetic */ boolean lRr;
        final /* synthetic */ int lzt;

        d(a aVar, com.tencent.magicbrush.e eVar, com.tencent.mm.plugin.appbrand.jsapi.f fVar, int i2, com.tencent.mm.plugin.appbrand.jsapi.p pVar, boolean z) {
            this.lRm = aVar;
            this.lRo = eVar;
            this.lRp = fVar;
            this.lzt = i2;
            this.lRq = pVar;
            this.lRr = z;
        }

        @Override // com.tencent.magicbrush.ui.MagicBrushView.f
        public final void tf() {
            AppMethodBeat.i(228348);
            this.lRp.i(this.lzt, this.lRq.Zf("ok"));
            AppMethodBeat.o(228348);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "onForeground", "com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$3$1"})
    public static final class e implements i.d {
        final /* synthetic */ a lRm;
        final /* synthetic */ com.tencent.magicbrush.e lRo;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.f lRp;

        e(a aVar, com.tencent.mm.plugin.appbrand.jsapi.f fVar, com.tencent.magicbrush.e eVar) {
            this.lRm = aVar;
            this.lRp = fVar;
            this.lRo = eVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.i.d
        public final void onForeground() {
            AppMethodBeat.i(228349);
            Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "foreground");
            a.C0646a aVar = com.tencent.mm.plugin.appbrand.jsapi.b.a.lQO;
            String appId = ((ag) this.lRp).getAppId();
            p.g(appId, "component.appId");
            com.tencent.mm.plugin.appbrand.jsapi.b.a ZJ = a.C0646a.ZJ(appId);
            ZJ.wZ(this.lRm.viewId);
            if (ZJ.bGc() == 1) {
                this.lRo.Rc();
            }
            AppMethodBeat.o(228349);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "onBackground", "com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$3$3"})
    public static final class f implements i.b {
        final /* synthetic */ a lRm;
        final /* synthetic */ com.tencent.magicbrush.e lRo;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.f lRp;

        f(a aVar, com.tencent.mm.plugin.appbrand.jsapi.f fVar, com.tencent.magicbrush.e eVar) {
            this.lRm = aVar;
            this.lRp = fVar;
            this.lRo = eVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
        public final void onBackground() {
            AppMethodBeat.i(228350);
            Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "background");
            q runtime = ((ag) this.lRp).getRuntime();
            p.g(runtime, "component.runtime");
            if (runtime.isDestroyed()) {
                AppMethodBeat.o(228350);
                return;
            }
            a.C0646a aVar = com.tencent.mm.plugin.appbrand.jsapi.b.a.lQO;
            String appId = ((ag) this.lRp).getAppId();
            p.g(appId, "component.appId");
            com.tencent.mm.plugin.appbrand.jsapi.b.a ZJ = a.C0646a.ZJ(appId);
            ZJ.xa(this.lRm.viewId);
            if (ZJ.bGc() == 0) {
                this.lRo.Rd();
            }
            AppMethodBeat.o(228350);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void o(MotionEvent motionEvent) {
        AppMethodBeat.i(228357);
        if (motionEvent != null) {
            MagicBrushView magicBrushView = this.lRk;
            if (magicBrushView != null) {
                magicBrushView.onTouchEvent(motionEvent);
                AppMethodBeat.o(228357);
                return;
            }
            AppMethodBeat.o(228357);
            return;
        }
        AppMethodBeat.o(228357);
    }

    private static void a(com.tencent.mm.plugin.appbrand.jsapi.f fVar, Runnable runnable) {
        AppMethodBeat.i(228358);
        Handler asyncHandler = fVar.getAsyncHandler();
        p.g(asyncHandler, "component.asyncHandler");
        if (p.j(asyncHandler.getLooper(), Looper.myLooper())) {
            runnable.run();
            AppMethodBeat.o(228358);
            return;
        }
        fVar.getAsyncHandler().post(runnable);
        AppMethodBeat.o(228358);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.b.a.a$a  reason: collision with other inner class name */
    public static final class C0647a {
        private C0647a() {
        }

        public /* synthetic */ C0647a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.magicbrush.ui.MagicBrushView.b
    public final View getThisView() {
        return null;
    }

    @Override // com.tencent.magicbrush.ui.MagicBrushView.b
    public final MagicBrushView.h getViewType() {
        return MagicBrushView.h.VirtualView;
    }

    @Override // com.tencent.magicbrush.ui.MagicBrushView.b
    public final void setSurfaceListener(MagicBrushView.c cVar) {
        this.cOP = cVar;
    }

    @Override // com.tencent.magicbrush.ui.MagicBrushView.b
    public final void a(boolean z, boolean z2, kotlin.g.a.b<? super Boolean, Void> bVar, MBRuntime mBRuntime) {
        AppMethodBeat.i(228359);
        p.h(bVar, "callback");
        p.h(mBRuntime, "runtime");
        AppMethodBeat.o(228359);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        return true;
    }

    public static final /* synthetic */ void a(a aVar, com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject, com.tencent.mm.plugin.appbrand.jsapi.p pVar, int i2) {
        AppMethodBeat.i(228363);
        if (fVar instanceof ag) {
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            aVar.width = (int) g.a(optJSONObject, "width", 0.0f);
            aVar.height = (int) g.a(optJSONObject, "height", 0.0f);
            ((ag) fVar).a(new c(aVar));
            aVar.lRi = (ag) fVar;
            com.tencent.mm.plugin.appbrand.service.c bsE = ((ag) fVar).bsE();
            com.tencent.luggage.game.d.a.a.c cVar = bsE != null ? (com.tencent.luggage.game.d.a.a.c) bsE.S(com.tencent.luggage.game.d.a.a.c.class) : null;
            if (cVar == null) {
                Log.w("JsApiInsertHTMLCanvasElement", "hy: webgl extension not exists!");
                AppMethodBeat.o(228363);
                return;
            }
            com.tencent.magicbrush.e magicBrush = cVar.getMagicBrush();
            if (magicBrush == null) {
                AppMethodBeat.o(228363);
                return;
            }
            boolean optBoolean = jSONObject.optBoolean("scrollSupportedTouchEvent", false);
            aVar.viewId = jSONObject.optInt("canvasId", 0);
            Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "insert xweb webgl canvas viewId:" + aVar.viewId + " scrollSupportedTouchEvent:" + optBoolean);
            Context context = ((ag) fVar).getContext();
            p.g(context, "component.context");
            MagicBrushView magicBrushView = new MagicBrushView(context, aVar);
            magicBrushView.setMagicBrush(magicBrush);
            magicBrushView.getPreparedListeners().add(new d(aVar, magicBrush, fVar, i2, pVar, optBoolean));
            a.C0646a aVar2 = com.tencent.mm.plugin.appbrand.jsapi.b.a.lQO;
            String appId = ((ag) fVar).getAppId();
            p.g(appId, "component.appId");
            a.C0646a.ZJ(appId).a(aVar.viewId, magicBrushView);
            if (optBoolean) {
                magicBrushView.setEnableTouchEvent(false);
            }
            aVar.lRk = magicBrushView;
            ag agVar = (ag) fVar;
            agVar.a(new e(aVar, fVar, magicBrush));
            if (agVar.Pv()) {
                a.C0646a aVar3 = com.tencent.mm.plugin.appbrand.jsapi.b.a.lQO;
                String appId2 = ((ag) fVar).getAppId();
                p.g(appId2, "component.appId");
                com.tencent.mm.plugin.appbrand.jsapi.b.a ZJ = a.C0646a.ZJ(appId2);
                ZJ.wZ(aVar.viewId);
                if (ZJ.bGc() == 1) {
                    magicBrush.Rc();
                }
            }
            agVar.a(new f(aVar, fVar, magicBrush));
            aVar.bGe();
        }
        AppMethodBeat.o(228363);
    }

    public static final /* synthetic */ void b(a aVar, com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject, com.tencent.mm.plugin.appbrand.jsapi.p pVar, int i2) {
        SurfaceTexture surfaceTexture2;
        AppMethodBeat.i(228364);
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            aVar.width = (int) g.a(optJSONObject, "width", 0.0f);
            aVar.height = (int) g.a(optJSONObject, "height", 0.0f);
            MagicBrushView.c cVar = aVar.cOP;
            if (!(cVar == null || (surfaceTexture2 = aVar.surfaceTexture) == null)) {
                cVar.c(surfaceTexture2, aVar.width, aVar.height);
            }
        }
        fVar.i(i2, pVar.Zf("ok"));
        AppMethodBeat.o(228364);
    }

    public static final /* synthetic */ void a(a aVar, com.tencent.mm.plugin.appbrand.jsapi.f fVar, com.tencent.mm.plugin.appbrand.jsapi.p pVar, int i2) {
        AppMethodBeat.i(228365);
        a.C0646a aVar2 = com.tencent.mm.plugin.appbrand.jsapi.b.a.lQO;
        ag agVar = aVar.lRi;
        if (agVar == null) {
            p.btv("componentView");
        }
        String appId = agVar.getAppId();
        p.g(appId, "componentView.appId");
        a.C0646a.ZJ(appId).remove(aVar.viewId);
        fVar.i(i2, pVar.Zf("ok"));
        AppMethodBeat.o(228365);
    }
}
