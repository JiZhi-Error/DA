package com.tencent.mm.appbrand.v8;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.eclipsesource.v8.V8ScriptException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class g implements c {
    private c.a dpu = null;
    private final a dpv;
    k dpw = new k();
    private final Looper mLooper;

    g(Looper looper) {
        AppMethodBeat.i(144002);
        this.mLooper = looper;
        this.dpv = new a(looper);
        AppMethodBeat.o(144002);
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final void loop() {
        AppMethodBeat.i(144003);
        Looper.loop();
        AppMethodBeat.o(144003);
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final boolean Xw() {
        AppMethodBeat.i(144004);
        if (this.mLooper.getThread().getId() == Thread.currentThread().getId()) {
            AppMethodBeat.o(144004);
            return true;
        }
        AppMethodBeat.o(144004);
        return false;
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final String LP() {
        AppMethodBeat.i(185101);
        String peek = this.dpw.dpM.peek();
        AppMethodBeat.o(185101);
        return peek;
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final void cS(boolean z) {
        this.dpw.enable = z;
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final void u(Runnable runnable) {
        AppMethodBeat.i(216875);
        if (runnable == null) {
            AppMethodBeat.o(216875);
        } else if (Thread.currentThread().getId() == this.mLooper.getThread().getId()) {
            try {
                runnable.run();
            } catch (V8ScriptException e2) {
                c(e2);
            }
            if (this.dpw.enable) {
                this.dpw.dpM.remove(null);
            }
            AppMethodBeat.o(216875);
        } else {
            this.dpv.post(runnable);
            AppMethodBeat.o(216875);
        }
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final void b(Runnable runnable, long j2, boolean z) {
        AppMethodBeat.i(216876);
        this.dpv.post(runnable);
        AppMethodBeat.o(216876);
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final void pause() {
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final void resume() {
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final void quit() {
        AppMethodBeat.i(144007);
        this.mLooper.quitSafely();
        AppMethodBeat.o(144007);
    }

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        public final void dispatchMessage(Message message) {
            AppMethodBeat.i(144001);
            try {
                super.dispatchMessage(message);
            } catch (V8ScriptException e2) {
                g.this.c(e2);
            }
            if (g.this.dpw.enable) {
                g.this.dpw.dpM.pollFirst();
            }
            AppMethodBeat.o(144001);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(V8ScriptException v8ScriptException) {
        AppMethodBeat.i(144008);
        if (this.dpu != null) {
            this.dpu.b(v8ScriptException);
        }
        AppMethodBeat.o(144008);
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final void a(c.a aVar) {
        this.dpu = aVar;
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final void resumeLoopTasks() {
        AppMethodBeat.i(216877);
        Log.e("resumeLoopTasks", "should not to be here");
        AppMethodBeat.o(216877);
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final boolean doInnerLoopTask() {
        AppMethodBeat.i(216878);
        Log.e("doInnerLoopTask", "should not to be here");
        AppMethodBeat.o(216878);
        return true;
    }
}
