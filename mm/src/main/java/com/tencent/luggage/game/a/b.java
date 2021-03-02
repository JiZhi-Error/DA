package com.tencent.luggage.game.a;

import android.content.Context;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.i;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/luggage/game/boot/MagicBrushForMiniGame;", "Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "context", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "shouldEnableCommandBuffer", "", "shouldEnableGfx", "cmdPoolTypeEnabled", "", "shouldRevertCpuOptimizerTest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;ZZIZ)V", "onConfig", "", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "luggage-wxa-game-ext_release"})
public class b extends d {
    private final boolean cue;
    private final boolean cuf;
    private final int cug;
    private final boolean cuh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, i iVar, boolean z, boolean z2, int i2, boolean z3) {
        super(context, iVar);
        p.h(context, "context");
        p.h(iVar, "jsRuntime");
        AppMethodBeat.i(222897);
        this.cue = z;
        this.cuf = z2;
        this.cug = i2;
        this.cuh = z3;
        AppMethodBeat.o(222897);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.luggage.game.a.d
    public void a(f fVar) {
        AppMethodBeat.i(130732);
        p.h(fVar, "builder");
        super.a(fVar);
        fVar.cr(false);
        fVar.co(this.cue);
        fVar.cLW.a(g.cLI[9], Boolean.valueOf(this.cuf));
        fVar.cMf.a(g.cLI[16], Integer.valueOf(this.cug));
        fVar.cMh.a(g.cLI[18], Boolean.TRUE);
        fVar.cMg.a(g.cLI[17], Boolean.valueOf(this.cuh));
        AppMethodBeat.o(130732);
    }
}
