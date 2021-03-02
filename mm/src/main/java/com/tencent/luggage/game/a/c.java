package com.tencent.luggage.game.a;

import android.content.Context;
import com.tencent.luggage.game.b.b;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.g;
import com.tencent.magicbrush.ui.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.m.i;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0014¨\u0006\u000e"}, hxF = {"Lcom/tencent/luggage/game/boot/MagicBrushForMiniProgram;", "Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "context", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;)V", "onAppBrandRuntimeReady", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "onConfig", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "luggage-wxa-game-ext_release"})
public class c extends d {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context, i iVar) {
        super(context, iVar);
        p.h(context, "context");
        p.h(iVar, "jsRuntime");
        AppMethodBeat.i(130736);
        AppMethodBeat.o(130736);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.luggage.game.a.d
    public void a(f fVar) {
        AppMethodBeat.i(130734);
        p.h(fVar, "builder");
        super.a(fVar);
        fVar.cr(true);
        fVar.cq(false);
        fVar.b(a.b.ChoreographerInMainThread);
        fVar.cMc.a(g.cLI[15], Boolean.FALSE);
        fVar.co(false);
        fVar.cp(false);
        AppMethodBeat.o(130734);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.luggage.game.a.d
    public final void a(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(130735);
        p.h(appBrandRuntime, "runtime");
        b.cux.a((MBRuntime) getMagicBrush(), appBrandRuntime, false);
        AppMethodBeat.o(130735);
    }
}
