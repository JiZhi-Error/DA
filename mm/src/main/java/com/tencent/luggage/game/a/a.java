package com.tencent.luggage.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.q;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, hxF = {"Lcom/tencent/luggage/game/boot/JsThreadHandler;", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "impl", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;", "(Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;)V", "getImpl", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;", "doInnerLoopTask", "", "getExecutingTaskNameForDebug", "", "isJsThreadCurrent", "post", "", "r", "Ljava/lang/Runnable;", "ignorePause", "resumeLoopTasks", "luggage-wxa-game-ext_release"})
final class a implements com.tencent.magicbrush.handler.a {
    private final q cud;

    public a(q qVar) {
        p.h(qVar, "impl");
        AppMethodBeat.i(130731);
        this.cud = qVar;
        AppMethodBeat.o(130731);
    }

    @Override // com.tencent.magicbrush.handler.a
    public final void a(Runnable runnable, boolean z) {
        AppMethodBeat.i(222894);
        p.h(runnable, "r");
        this.cud.a(runnable, z);
        AppMethodBeat.o(222894);
    }

    @Override // com.tencent.magicbrush.handler.a
    public final boolean LO() {
        AppMethodBeat.i(130730);
        boolean LO = this.cud.LO();
        AppMethodBeat.o(130730);
        return LO;
    }

    @Override // com.tencent.magicbrush.handler.a
    public final String LP() {
        AppMethodBeat.i(184694);
        String LP = this.cud.LP();
        AppMethodBeat.o(184694);
        return LP;
    }

    @Override // com.tencent.magicbrush.handler.a
    public final void resumeLoopTasks() {
        AppMethodBeat.i(222895);
        this.cud.resumeLoopTasks();
        AppMethodBeat.o(222895);
    }

    @Override // com.tencent.magicbrush.handler.a
    public final boolean doInnerLoopTask() {
        AppMethodBeat.i(222896);
        boolean doInnerLoopTask = this.cud.doInnerLoopTask();
        AppMethodBeat.o(222896);
        return doInnerLoopTask;
    }
}
