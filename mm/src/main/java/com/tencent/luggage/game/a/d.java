package com.tencent.luggage.game.a;

import android.content.Context;
import com.facebook.appevents.UserDataStore;
import com.tencent.luggage.game.b.b;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.aj;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\"B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u0010J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0006\u0010\u0018\u001a\u00020\u000eJ\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\u001f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "", "androidContext", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;)V", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "destroyTask", "Lcom/tencent/luggage/game/boot/MagicBrushSimple$DestroyTask;", "getJsRuntime", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "appbrandRuntimeReady", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "awaitDestroyDone", "create", "destroy", "getJsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "getMagicBrush", "getMagicBrushNullable", "getRawPointerOfJsRuntime", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "onAppBrandRuntimeReady", "onConfig", "onCreate", "costMs", "", "DestroyTask", "luggage-wxa-game-ext_release"})
public class d {
    volatile e cui;
    private final f cuj = new f();
    public final a cuk = new a(new b(this));
    private final Context cul;
    protected final i cum;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "invoke"})
    /* renamed from: com.tencent.luggage.game.a.d$d  reason: collision with other inner class name */
    public static final class C0166d extends q implements kotlin.g.a.b<g.b, x> {
        public static final C0166d cup = new C0166d();

        static {
            AppMethodBeat.i(130742);
            AppMethodBeat.o(130742);
        }

        C0166d() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(g.b bVar) {
            AppMethodBeat.i(130741);
            g.b bVar2 = bVar;
            p.h(bVar2, "$receiver");
            bVar2.cMt = true;
            bVar2.cMv = new b.C0168b();
            bVar2.cMw = null;
            x xVar = x.SXb;
            AppMethodBeat.o(130741);
            return xVar;
        }
    }

    public d(Context context, i iVar) {
        p.h(context, "androidContext");
        p.h(iVar, "jsRuntime");
        AppMethodBeat.i(130750);
        this.cul = context;
        this.cum = iVar;
        AppMethodBeat.o(130750);
    }

    public final e getMagicBrush() {
        AppMethodBeat.i(130743);
        e eVar = this.cui;
        if (eVar == null) {
            p.hyc();
        }
        AppMethodBeat.o(130743);
        return eVar;
    }

    /* access modifiers changed from: protected */
    public void a(f fVar) {
        AppMethodBeat.i(130744);
        p.h(fVar, "builder");
        fVar.context = this.cul;
        fVar.ae(com.tencent.mm.plugin.appbrand.ac.g.bZk());
        fVar.cLK = new c((v) this.cum.R(v.class));
        com.tencent.mm.plugin.appbrand.m.q qVar = (com.tencent.mm.plugin.appbrand.m.q) this.cum.R(com.tencent.mm.plugin.appbrand.m.q.class);
        if (qVar == null) {
            IllegalStateException illegalStateException = new IllegalStateException("JsRuntime don't support JsThread addon".toString());
            AppMethodBeat.o(130744);
            throw illegalStateException;
        }
        fVar.cLJ = new a(qVar);
        fVar.a(C0166d.cup);
        String aKJ = com.tencent.mm.loader.j.b.aKJ();
        p.g(aKJ, "CConstants.DATAROOT_SDCARD_PATH()");
        fVar.dY(aKJ);
        AppMethodBeat.o(130744);
    }

    /* access modifiers changed from: protected */
    public void a(e eVar, long j2) {
        AppMethodBeat.i(130745);
        p.h(eVar, "magicbrush");
        AppMethodBeat.o(130745);
    }

    /* access modifiers changed from: protected */
    public void a(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(130746);
        p.h(appBrandRuntime, "runtime");
        com.tencent.luggage.game.b.b.cux.a((MBRuntime) this.cui, appBrandRuntime, true);
        AppMethodBeat.o(130746);
    }

    public final e LQ() {
        AppMethodBeat.i(130747);
        long currentTicks = Util.currentTicks();
        a(this.cuj);
        e Rm = this.cuj.Rm();
        if (Rm == null) {
            p.hyc();
        }
        synchronized (this) {
            try {
                if (!(this.cui == null)) {
                    IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
                    AppMethodBeat.o(130747);
                    throw illegalStateException;
                }
                this.cui = Rm;
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(130747);
                throw th;
            }
        }
        a(Rm, Util.ticksToNow(currentTicks));
        AppMethodBeat.o(130747);
        return Rm;
    }

    public final void b(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(130748);
        p.h(appBrandRuntime, "runtime");
        a(appBrandRuntime);
        AppMethodBeat.o(130748);
    }

    public final void destroy() {
        AppMethodBeat.i(130749);
        Log.i("MicroMsg.MagicBrush", "destroy");
        ((m) this.cum.R(m.class)).a(this.cuk);
        AppMethodBeat.o(130749);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"Lcom/tencent/luggage/game/boot/MagicBrushSimple$DestroyTask;", "Lcom/tencent/magicbrush/utils/SyncTask;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonDestroyListener$OnDestroyListener;", UserDataStore.FIRST_NAME, "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "onDestroy", "luggage-wxa-game-ext_release"})
    public static final class a extends com.tencent.magicbrush.utils.e implements m.a {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(kotlin.g.a.a<x> aVar) {
            super(new e(aVar));
            p.h(aVar, UserDataStore.FIRST_NAME);
            AppMethodBeat.i(130738);
            AppMethodBeat.o(130738);
        }

        @Override // com.tencent.mm.plugin.appbrand.m.m.a
        public final void onDestroy() {
            AppMethodBeat.i(130737);
            run();
            AppMethodBeat.o(130737);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/magicbrush/V8RawPointer;", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<aj> {
        final /* synthetic */ v cuo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(v vVar) {
            super(0);
            this.cuo = vVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ aj invoke() {
            AppMethodBeat.i(130740);
            v vVar = this.cuo;
            p.g(vVar, "addonV8");
            long isolatePtr = vVar.getIsolatePtr();
            v vVar2 = this.cuo;
            p.g(vVar2, "addonV8");
            long XK = vVar2.XK();
            v vVar3 = this.cuo;
            p.g(vVar3, "addonV8");
            aj ajVar = new aj(isolatePtr, XK, vVar3.getUVLoopPtr());
            AppMethodBeat.o(130740);
            return ajVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d cun;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d dVar) {
            super(0);
            this.cun = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(130739);
            synchronized (this.cun) {
                try {
                    if (this.cun.cui == null) {
                        IllegalStateException illegalStateException = new IllegalStateException("Required value was null.".toString());
                        AppMethodBeat.o(130739);
                        throw illegalStateException;
                    }
                    e eVar = this.cun.cui;
                    if (eVar == null) {
                        p.hyc();
                    }
                    eVar.destroy();
                    this.cun.cui = null;
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(130739);
                    throw th;
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(130739);
            return xVar2;
        }
    }
}
