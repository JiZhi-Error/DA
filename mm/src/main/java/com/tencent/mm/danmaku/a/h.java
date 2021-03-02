package com.tencent.mm.danmaku.a;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.e.e;
import com.tencent.mm.plugin.finder.megavideo.bullet.b;
import kotlin.f;

public final class h {
    com.tencent.mm.danmaku.c.a gNt;
    HandlerThread gOs;
    private Handler gOt;
    Boolean gOu = Boolean.FALSE;

    public interface a {
        void c(com.tencent.mm.danmaku.b.a aVar);
    }

    public h(com.tencent.mm.danmaku.c.a aVar) {
        this.gNt = aVar;
    }

    public static void a(com.tencent.mm.danmaku.c.a aVar, com.tencent.mm.danmaku.b.a aVar2) {
        AppMethodBeat.i(241659);
        if (aVar2.asx()) {
            AppMethodBeat.o(241659);
            return;
        }
        com.tencent.mm.danmaku.e.a g2 = aVar.e(aVar2).g(aVar2);
        aVar2.ak(g2.gPb + ((float) (com.tencent.mm.danmaku.c.a.asO().gPJ * 2)));
        aVar2.al(g2.gPc + ((float) (com.tencent.mm.danmaku.c.a.asO().gPI * 2)));
        aVar2.asy();
        AppMethodBeat.o(241659);
    }

    /* access modifiers changed from: package-private */
    public final Handler aso() {
        AppMethodBeat.i(241660);
        if (this.gOs == null || !this.gOs.isAlive()) {
            try {
                b.a aVar = b.uJZ;
                f dkf = b.dkf();
                b.a aVar2 = b.uJZ;
                HandlerThread handlerThread = ((b) dkf.getValue()).uJW;
                if (handlerThread == null || !handlerThread.isAlive()) {
                    this.gOs = new HandlerThread("DanmakuMeasureThread");
                    this.gOs.start();
                    this.gOs.setUncaughtExceptionHandler(new com.tencent.mm.danmaku.e.b());
                    this.gOu = Boolean.FALSE;
                } else {
                    this.gOs = handlerThread;
                    this.gOu = Boolean.TRUE;
                }
                this.gOt = new Handler(this.gOs.getLooper());
            } catch (Throwable th) {
                e.e("DanmakuMeasureManager", th);
            }
        }
        Handler handler = this.gOt;
        AppMethodBeat.o(241660);
        return handler;
    }
}
