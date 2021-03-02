package com.tencent.magicbrush.ui;

import android.view.Choreographer;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.c;
import com.tencent.magicbrush.ui.a;
import com.tencent.magicbrush.utils.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016R\u0015\u0010\u0007\u001a\u00060\bR\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, hxF = {"Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "bridge", "Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "getBridge", "()Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "choreographer", "Landroid/view/Choreographer;", "getChoreographer", "()Landroid/view/Choreographer;", "setChoreographer", "(Landroid/view/Choreographer;)V", "latency", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "", "onDestroy", "onPause", "onResume", "MainThreadChoreographerBridge", "lib-magicbrush-nano_release"})
public final class d extends a {
    private final f cOE = new f();
    private final a.b cOG = a.b.ChoreographerInMainThread;
    final a cOI = new a();
    volatile Choreographer choreographer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(MBRuntime mBRuntime, c cVar) {
        super(mBRuntime, cVar);
        p.h(mBRuntime, "runtime");
        p.h(cVar, "jsThreadHandler");
        AppMethodBeat.i(206870);
        AppMethodBeat.o(206870);
    }

    @Override // com.tencent.magicbrush.ui.a
    public final a.b RB() {
        return this.cOG;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\b\u0010\f\u001a\u00020\u000bH\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, hxF = {"Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "Landroid/view/Choreographer$FrameCallback;", "Ljava/lang/Runnable;", "(Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler;)V", "frameTimeNanos", "", "getFrameTimeNanos", "()J", "setFrameTimeNanos", "(J)V", "doFrame", "", "run", "lib-magicbrush-nano_release"})
    final class a implements Choreographer.FrameCallback, Runnable {
        private long cOJ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        public final void doFrame(long j2) {
            AppMethodBeat.i(140215);
            this.cOJ = j2;
            f unused = d.this.cOE;
            d.this.cOw.post(d.this.cOI);
            AppMethodBeat.o(140215);
        }

        public final void run() {
            AppMethodBeat.i(140216);
            if (d.this.isRunning) {
                synchronized (d.this.cOv) {
                    try {
                        Choreographer choreographer = d.this.choreographer;
                        if (choreographer != null) {
                            choreographer.postFrameCallback(d.this.cOI);
                            x xVar = x.SXb;
                        }
                    } finally {
                        AppMethodBeat.o(140216);
                    }
                }
                d.this.h(((double) this.cOJ) / 1000000.0d);
            }
        }
    }

    @Override // com.tencent.magicbrush.ui.a
    public final void onCreate() {
        AppMethodBeat.i(140218);
        f fVar = f.cPx;
        f.e(new b(this));
        AppMethodBeat.o(140218);
    }

    @Override // com.tencent.magicbrush.ui.a
    public final void onResume() {
        AppMethodBeat.i(140219);
        if (this.choreographer != null) {
            Choreographer choreographer2 = this.choreographer;
            if (choreographer2 == null) {
                p.hyc();
            }
            choreographer2.removeFrameCallback(this.cOI);
            Choreographer choreographer3 = this.choreographer;
            if (choreographer3 == null) {
                p.hyc();
            }
            choreographer3.postFrameCallback(this.cOI);
        }
        AppMethodBeat.o(140219);
    }

    @Override // com.tencent.magicbrush.ui.a
    public final void onPause() {
        AppMethodBeat.i(140220);
        if (this.choreographer != null) {
            Choreographer choreographer2 = this.choreographer;
            if (choreographer2 == null) {
                p.hyc();
            }
            choreographer2.removeFrameCallback(this.cOI);
        }
        AppMethodBeat.o(140220);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d cOK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d dVar) {
            super(0);
            this.cOK = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(140217);
            synchronized (this.cOK.cOv) {
                try {
                    this.cOK.choreographer = Choreographer.getInstance();
                    if (this.cOK.isRunning) {
                        Choreographer choreographer = this.cOK.choreographer;
                        if (choreographer == null) {
                            p.hyc();
                        }
                        choreographer.postFrameCallback(this.cOK.cOI);
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(140217);
                    throw th;
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(140217);
            return xVar2;
        }
    }
}
