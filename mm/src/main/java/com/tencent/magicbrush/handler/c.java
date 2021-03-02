package com.tencent.magicbrush.handler;

import com.tencent.magicbrush.utils.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

public final class c implements a {
    private a cMP;

    public c(a aVar) {
        this.cMP = aVar;
    }

    public final void post(Runnable runnable) {
        AppMethodBeat.i(261724);
        a(runnable, false);
        AppMethodBeat.o(261724);
    }

    @Override // com.tencent.magicbrush.handler.a
    public final void a(Runnable runnable, boolean z) {
        AppMethodBeat.i(206808);
        if (this.cMP.LO()) {
            runnable.run();
            AppMethodBeat.o(206808);
            return;
        }
        this.cMP.a(runnable, z);
        AppMethodBeat.o(206808);
    }

    @Override // com.tencent.magicbrush.handler.a
    public final boolean LO() {
        AppMethodBeat.i(139999);
        boolean LO = this.cMP.LO();
        AppMethodBeat.o(139999);
        return LO;
    }

    public final <T> T c(Callable<T> callable) {
        AppMethodBeat.i(140000);
        e eVar = new e(callable);
        p(eVar);
        T t = (T) eVar.get();
        AppMethodBeat.o(140000);
        return t;
    }

    public final void p(Runnable runnable) {
        AppMethodBeat.i(140001);
        if (this.cMP.LO()) {
            runnable.run();
            AppMethodBeat.o(140001);
            return;
        }
        this.cMP.a(runnable, false);
        AppMethodBeat.o(140001);
    }

    @Override // com.tencent.magicbrush.handler.a
    public final String LP() {
        AppMethodBeat.i(185066);
        String LP = this.cMP.LP();
        AppMethodBeat.o(185066);
        return LP;
    }

    @Override // com.tencent.magicbrush.handler.a
    public final void resumeLoopTasks() {
        AppMethodBeat.i(206809);
        this.cMP.resumeLoopTasks();
        AppMethodBeat.o(206809);
    }

    @Override // com.tencent.magicbrush.handler.a
    public final boolean doInnerLoopTask() {
        AppMethodBeat.i(206810);
        boolean doInnerLoopTask = this.cMP.doInnerLoopTask();
        AppMethodBeat.o(206810);
        return doInnerLoopTask;
    }
}
