package com.tencent.mm.plugin.music.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.plugin.music.d.a;
import com.tencent.mm.plugin.music.f.d;
import com.tencent.mm.plugin.music.f.e;
import com.tencent.mm.plugin.music.h.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public abstract class h implements c {
    private Runnable AjA = new Runnable() {
        /* class com.tencent.mm.plugin.music.e.h.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(137281);
            boolean bee = h.this.etW().bee();
            boolean bec = h.this.etW().bec();
            Log.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayRunnable, isStartPlayMusic:%b, isPlayingMusic:%b", Boolean.valueOf(bee), Boolean.valueOf(bec));
            if (bee && !bec) {
                h.this.etW().stopPlay();
            }
            AppMethodBeat.o(137281);
        }
    };
    private d Ajx = new d();
    private e Ajy = new e();
    private a Ajz = new a();

    @Override // com.tencent.mm.plugin.music.e.c
    public final void t(f fVar) {
        if (c.U(fVar)) {
            Log.i("MicroMsg.Music.MusicBasePlayEngine", "use exoMusicPlayer");
            euh();
            this.Ajz.h(fVar);
        } else if (c.Th(fVar.jeT)) {
            Log.i("MicroMsg.Music.MusicBasePlayEngine", "use qqMusicPlayer");
            euh();
            this.Ajy.h(fVar);
        } else {
            Log.i("MicroMsg.Music.MusicBasePlayEngine", "use musicPlayer");
            euh();
            this.Ajx.h(fVar);
        }
        if (fVar.jeT != 11) {
            eui();
        }
    }

    @Override // com.tencent.mm.plugin.music.e.c
    public com.tencent.mm.plugin.music.f.a.d etW() {
        f etU = etU();
        if (c.U(etU)) {
            return this.Ajz;
        }
        if (etU == null || !c.Th(etU.jeT)) {
            return this.Ajx;
        }
        return this.Ajy;
    }

    private void euh() {
        if (this.Ajx.bec()) {
            this.Ajx.stopPlay();
        }
        if (this.Ajy.bec()) {
            this.Ajy.stopPlay();
        }
        if (this.Ajz.bec()) {
            this.Ajz.stopPlay();
        }
    }

    @Override // com.tencent.mm.plugin.music.e.c
    public void bea() {
        this.Ajx.stopPlay();
        if (this.Ajy != null) {
            this.Ajy.stopPlay();
        }
        if (this.Ajz != null) {
            this.Ajz.stopPlay();
        }
        MMHandlerThread.removeRunnable(this.AjA);
    }

    public void release() {
        Log.i("MicroMsg.Music.MusicBasePlayEngine", "release");
        if (this.Ajy != null) {
            this.Ajy.release();
        }
        if (this.Ajz != null) {
            this.Ajz.release();
        }
        MMHandlerThread.removeRunnable(this.AjA);
    }

    public void finish() {
        bea();
        release();
    }

    @Override // com.tencent.mm.plugin.music.e.c
    public void sl(boolean z) {
        if (this.Ajx.bec()) {
            this.Ajx.dSH = z;
        }
        if (this.Ajy.bec()) {
            this.Ajy.dSH = z;
        }
        if (this.Ajz.bec()) {
            this.Ajz.dSH = z;
        }
    }

    public f etU() {
        return null;
    }

    public void m(f fVar) {
        if (this.Ajx.bec()) {
            this.Ajx.m(fVar);
        }
        if (this.Ajy.bec()) {
            this.Ajy.m(fVar);
        }
        if (this.Ajz.bec()) {
            this.Ajz.m(fVar);
        }
    }

    @Override // com.tencent.mm.plugin.music.e.c
    public final void u(f fVar) {
        if (c.U(fVar)) {
            this.Ajz.P(fVar);
        } else if (fVar == null || !c.Th(fVar.jeT)) {
            this.Ajx.P(fVar);
        } else {
            this.Ajy.P(fVar);
        }
    }

    public static void eui() {
        Log.i("MicroMsg.Music.MusicBasePlayEngine", "sendPreemptedEvent");
        mx mxVar = new mx();
        mxVar.dSE.action = 10;
        mxVar.dSE.state = "preempted";
        mxVar.dSE.appId = "not from app brand appid";
        mxVar.dSE.dSG = true;
        EventCenter.instance.asyncPublish(mxVar, Looper.getMainLooper());
    }

    public void SP(int i2) {
        Log.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayIfPaused, delay_ms:%d", Integer.valueOf(i2));
        MMHandlerThread.removeRunnable(this.AjA);
        MMHandlerThread.postToMainThreadDelayed(this.AjA, (long) i2);
    }
}
