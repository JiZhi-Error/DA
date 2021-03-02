package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.c;
import com.tencent.magicbrush.ui.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u000e\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, hxF = {"Lcom/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Ljava/lang/Runnable;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "frameIntervalNanos", "", "frameRefreshRate", "", "frameTimeNanos", "latency", "com/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1", "Lcom/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1;", "skippedFrameCount", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "", "onDestroy", "onPause", "onResume", "run", "lib-magicbrush-nano_release"})
public final class k extends a implements Runnable {
    private final a.b cOG = a.b.SchedulerLocker;
    private long cOJ;
    private final int cPl = 60;
    private final long cPm = (1000000000 / ((long) this.cPl));
    private int cPn;
    private final a cPo = new a();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(MBRuntime mBRuntime, c cVar) {
        super(mBRuntime, cVar);
        p.h(mBRuntime, "runtime");
        p.h(cVar, "jsThreadHandler");
        AppMethodBeat.i(206887);
        AppMethodBeat.o(206887);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "now", "", "lib-magicbrush-nano_release"})
    public static final class a extends f {
        a() {
        }
    }

    @Override // com.tencent.magicbrush.ui.a
    public final a.b RB() {
        return this.cOG;
    }

    @Override // com.tencent.magicbrush.ui.a
    public final void onCreate() {
    }

    @Override // com.tencent.magicbrush.ui.a
    public final void onResume() {
        AppMethodBeat.i(140280);
        this.cOJ = 0;
        this.cOw.post(this);
        AppMethodBeat.o(140280);
    }

    @Override // com.tencent.magicbrush.ui.a
    public final void onPause() {
        this.cOJ = 0;
    }

    public final void run() {
        AppMethodBeat.i(140281);
        if (!this.isRunning) {
            AppMethodBeat.o(140281);
            return;
        }
        if (this.cOJ == 0) {
            this.cOJ = System.nanoTime();
        }
        long nanoTime = System.nanoTime();
        long j2 = nanoTime - this.cOJ;
        if (j2 >= this.cPm) {
            this.cPn = (int) (j2 / this.cPm);
            this.cOJ = nanoTime - (j2 % this.cPm);
        }
        h(((double) this.cOJ) / 1000000.0d);
        long nanoTime2 = System.nanoTime() - this.cOJ;
        this.cOJ += this.cPm;
        if (nanoTime2 < this.cPm) {
            do {
            } while (System.nanoTime() < this.cOJ);
        }
        this.cOw.post(this);
        AppMethodBeat.o(140281);
    }
}
