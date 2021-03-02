package com.tencent.magicbrush.ui;

import android.view.Choreographer;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c;
import com.tencent.magicbrush.ui.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/magicbrush/ui/ChoreographerInJsThreadAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Landroid/view/Choreographer$FrameCallback;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "choreographer", "Landroid/view/Choreographer;", "latency", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "tryGetTimes", "", "doFrame", "", "frameTimeNanos", "", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "onDestroy", "onPause", "onResume", "tryGetChoreographer", "tryLaterIfFailed", "", "lib-magicbrush-nano_release"})
public final class c extends a implements Choreographer.FrameCallback {
    private final f cOE = new f();
    private int cOF;
    private final a.b cOG = a.b.ChoreographerInJsThread;
    private Choreographer choreographer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(MBRuntime mBRuntime, com.tencent.magicbrush.handler.c cVar) {
        super(mBRuntime, cVar);
        p.h(mBRuntime, "runtime");
        p.h(cVar, "jsThreadHandler");
        AppMethodBeat.i(206869);
        AppMethodBeat.o(206869);
    }

    public static final /* synthetic */ Choreographer a(c cVar) {
        AppMethodBeat.i(140214);
        Choreographer RC = cVar.RC();
        AppMethodBeat.o(140214);
        return RC;
    }

    private final Choreographer RC() {
        Choreographer choreographer2;
        AppMethodBeat.i(140209);
        if (this.choreographer != null) {
            Choreographer choreographer3 = this.choreographer;
            AppMethodBeat.o(140209);
            return choreographer3;
        }
        this.cOF++;
        try {
            choreographer2 = Choreographer.getInstance();
        } catch (Exception e2) {
            if (this.cOF == 1 || this.cOF % 100000 == 0) {
                c.C0193c.printStackTrace("AnimationFrameHandler", e2, "get choreographer failed [" + this.cOF + "] times. but it's ok, i will try it later if needed. " + e2, new Object[0]);
            }
            choreographer2 = null;
        }
        if (choreographer2 != null) {
            if (choreographer2 != null) {
                this.choreographer = choreographer2;
            }
            AppMethodBeat.o(140209);
            return choreographer2;
        }
        this.cOw.post(new a(this));
        AppMethodBeat.o(140209);
        return null;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ c cOH;

        a(c cVar) {
            this.cOH = cVar;
        }

        public final void run() {
            AppMethodBeat.i(140208);
            if (!this.cOH.isRunning) {
                AppMethodBeat.o(140208);
                return;
            }
            Choreographer a2 = c.a(this.cOH);
            if (a2 == null) {
                AppMethodBeat.o(140208);
                return;
            }
            a2.removeFrameCallback(this.cOH);
            a2.postFrameCallback(this.cOH);
            c.C0193c.i("AnimationFrameHandler", "Aha! we get a choreographer after try [" + this.cOH.cOF + "] times ", new Object[0]);
            AppMethodBeat.o(140208);
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
        AppMethodBeat.i(140210);
        Choreographer RC = RC();
        if (RC != null) {
            RC.removeFrameCallback(this);
        }
        if (RC != null) {
            RC.postFrameCallback(this);
            AppMethodBeat.o(140210);
            return;
        }
        AppMethodBeat.o(140210);
    }

    @Override // com.tencent.magicbrush.ui.a
    public final void onPause() {
        AppMethodBeat.i(140211);
        Choreographer choreographer2 = this.choreographer;
        if (choreographer2 != null) {
            choreographer2.removeFrameCallback(this);
            AppMethodBeat.o(140211);
            return;
        }
        AppMethodBeat.o(140211);
    }

    public final void doFrame(long j2) {
        AppMethodBeat.i(140212);
        if (this.isRunning) {
            Choreographer choreographer2 = this.choreographer;
            if (choreographer2 != null) {
                choreographer2.postFrameCallback(this);
            }
            h(((double) j2) / 1000000.0d);
        }
        AppMethodBeat.o(140212);
    }
}
