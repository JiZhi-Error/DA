package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c;
import com.tencent.magicbrush.handler.c;
import com.tencent.magicbrush.ui.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, hxF = {"Lcom/tencent/magicbrush/ui/NativeAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Ljava/lang/Runnable;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "onCreate", "", "onDestroy", "onPause", "onResume", "run", "lib-magicbrush-nano_release"})
public final class j extends a implements Runnable {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(MBRuntime mBRuntime, c cVar) {
        super(mBRuntime, cVar);
        p.h(mBRuntime, "runtime");
        p.h(cVar, "jsThreadHandler");
        AppMethodBeat.i(206886);
        AppMethodBeat.o(206886);
    }

    @Override // com.tencent.magicbrush.ui.a
    public final a.b RB() {
        return a.b.NativeLocker;
    }

    @Override // com.tencent.magicbrush.ui.a
    public final void onCreate() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ j cPk;

        a(j jVar) {
            this.cPk = jVar;
        }

        public final void run() {
            AppMethodBeat.i(206882);
            this.cPk.cKJ.Rf();
            AppMethodBeat.o(206882);
        }
    }

    public final void run() {
        AppMethodBeat.i(206885);
        c.C0193c.i("AnimationFrameHandler", "hy: start native raf looper", new Object[0]);
        this.cKJ.Re();
        AppMethodBeat.o(206885);
    }

    @Override // com.tencent.magicbrush.ui.a
    public final void onResume() {
        AppMethodBeat.i(206883);
        this.cOw.post(this);
        AppMethodBeat.o(206883);
    }

    @Override // com.tencent.magicbrush.ui.a
    public final void onPause() {
        AppMethodBeat.i(206884);
        this.cOw.post(new a(this));
        AppMethodBeat.o(206884);
    }
}
