package com.tencent.magicbrush.ui;

import android.os.SystemClock;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.c;
import com.tencent.magicbrush.ui.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, hxF = {"Lcom/tencent/magicbrush/ui/EglSurfaceSwapLockerAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Ljava/lang/Runnable;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "frameTimeMillis", "", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "onCreate", "", "onDestroy", "onPause", "onResume", "run", "lib-magicbrush-nano_release"})
public final class e extends a implements Runnable {
    private final a.b cOG = a.b.EglSurfaceSwapLocker;
    private double cOL;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(MBRuntime mBRuntime, c cVar) {
        super(mBRuntime, cVar);
        p.h(mBRuntime, "runtime");
        p.h(cVar, "jsThreadHandler");
        AppMethodBeat.i(206871);
        AppMethodBeat.o(206871);
    }

    @Override // com.tencent.magicbrush.ui.a
    public final a.b RB() {
        return this.cOG;
    }

    @Override // com.tencent.magicbrush.ui.a
    public final void onCreate() {
    }

    @Override // com.tencent.magicbrush.ui.a
    public final void onPause() {
        this.cOL = 0.0d;
    }

    @Override // com.tencent.magicbrush.ui.a
    public final void onResume() {
        AppMethodBeat.i(140222);
        this.cOw.post(this);
        AppMethodBeat.o(140222);
    }

    public final void run() {
        AppMethodBeat.i(140223);
        if (this.isRunning) {
            this.cOw.post(this);
            if (this.cOL == 0.0d) {
                this.cOL = (double) SystemClock.elapsedRealtime();
            }
            h(this.cOL);
            this.cOL = (double) SystemClock.elapsedRealtime();
        }
        AppMethodBeat.o(140223);
    }
}
