package com.tencent.mm.plugin.voip.video.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.c;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e {
    private static e HlV;
    public d HcD = null;
    public AtomicBoolean HlW = new AtomicBoolean(false);
    public g HlX;
    public a HlY;

    public interface a {
        void MC();
    }

    public e() {
        AppMethodBeat.i(235900);
        AppMethodBeat.o(235900);
    }

    public static e fLK() {
        AppMethodBeat.i(115738);
        if (HlV == null) {
            HlV = new e();
        }
        e eVar = HlV;
        AppMethodBeat.o(115738);
        return eVar;
    }

    public final synchronized g fLL() {
        g gVar;
        AppMethodBeat.i(115739);
        this.HcD = c.a(false, 14);
        t tVar = t.GYO;
        t.fHw();
        if (this.HcD.igv <= 0) {
            t tVar2 = t.GYO;
            t.fHx();
        }
        this.HlX = new g(this.HcD.igv);
        this.HcD.close();
        this.HcD = null;
        gVar = this.HlX;
        AppMethodBeat.o(115739);
        return gVar;
    }

    public final synchronized boolean fLM() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(235901);
            Log.i("MicroMsg.VoipHardDecodeUtil", "attachGLContext ,isContextAttached %s", this.HlW);
            if (this.HcD == null) {
                this.HcD = c.a(false, 14);
                v2protocal.HcD = this.HcD;
                Log.i("MicroMsg.VoipHardDecodeUtil", "attachGLContext, texture:%s", this.HcD);
            }
            if (this.HlW.compareAndSet(true, false)) {
                Log.i("MicroMsg.VoipHardDecodeUtil", "current has attach and it need to attach ");
                AppMethodBeat.o(235901);
            } else {
                if (this.HlW.compareAndSet(false, true)) {
                    this.HlX.attachToGLContext(this.HcD.igv);
                    this.HlY.MC();
                }
                z = this.HlW.get();
                AppMethodBeat.o(235901);
            }
        }
        return z;
    }

    public final synchronized void fLH() {
        AppMethodBeat.i(235902);
        Log.printInfoStack("MicroMsg.VoipHardDecodeUtil", "detachGLContext, isContextAttached %s", this.HlW);
        if (this.HlW.compareAndSet(false, false)) {
            Log.i("MicroMsg.VoipHardDecodeUtil", "current has attach and it need to detach ");
        }
        if (this.HlW.compareAndSet(true, false) && this.HlX != null) {
            this.HlX.detachFromGLContext();
            if (this.HcD != null) {
                this.HcD.close();
                this.HcD = null;
            }
        }
        AppMethodBeat.o(235902);
    }
}
