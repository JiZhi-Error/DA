package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;

public final class c {
    public boolean guh;
    public boolean isStart;
    c.a qrW;
    public com.tencent.mm.audio.b.c yqu;
    public final Object yqv;
    int yqw;
    boolean yqx;
    int yqy;
    boolean yqz;

    public c() {
        AppMethodBeat.i(25430);
        this.yqu = null;
        this.yqv = new Object();
        this.isStart = false;
        this.guh = false;
        this.yqw = 92;
        this.yqx = true;
        this.yqy = 0;
        this.yqz = true;
        this.qrW = new c.a() {
            /* class com.tencent.mm.plugin.ipcall.model.c.c.AnonymousClass1 */

            @Override // com.tencent.mm.audio.b.c.a
            public final void w(byte[] bArr, int i2) {
                int i3;
                int i4 = 0;
                AppMethodBeat.i(25427);
                synchronized (c.this.yqv) {
                    try {
                        c cVar = c.this;
                        if (cVar.yqw <= 10) {
                            cVar.yqw = 92;
                        }
                        a aVar = i.eav().yqo.ypA;
                        if (aVar.qrz != null) {
                            i3 = aVar.qrz.fFq();
                        } else {
                            i3 = 0;
                        }
                        cVar.yqw = ((i3 + 24) + (cVar.yqw * 3)) / 4;
                        if (cVar.yqx) {
                            Log.i("MicroMsg.IPCallRecorder", "preprocessForEcho FirstRefEcho");
                            a aVar2 = i.eav().yqo.ypA;
                            if (aVar2.qrz != null) {
                                i4 = aVar2.qrz.fFn();
                            }
                            cVar.yqy = i4;
                            if (cVar.yqy >= cVar.yqw) {
                                cVar.yqy -= cVar.yqw;
                            }
                            cVar.yqw = cVar.yqy;
                            cVar.yqx = false;
                        } else {
                            cVar.yqw = 0;
                        }
                        if (i.eaw().mAT == 5) {
                            if (c.this.yqz) {
                                Log.i("MicroMsg.IPCallRecorder", "isFirstRecordCallback");
                                c.this.yqz = false;
                            }
                            i.eat().yqF.recordCallback(bArr, i2, c.this.yqw);
                        }
                    } finally {
                        AppMethodBeat.o(25427);
                    }
                }
            }

            @Override // com.tencent.mm.audio.b.c.a
            public final void cj(int i2, int i3) {
            }
        };
        this.isStart = false;
        AppMethodBeat.o(25430);
    }

    public final void bFT() {
        AppMethodBeat.i(25431);
        if (this.isStart) {
            Log.d("MicroMsg.IPCallRecorder", "startRecorder, already start");
            AppMethodBeat.o(25431);
            return;
        }
        Log.i("MicroMsg.IPCallRecorder", "start record");
        this.isStart = true;
        this.yqw = i.eav().yqo.ypA.yqm;
        if (this.yqw <= 10) {
            if (this.yqw <= 0) {
                Log.e("MicroMsg.IPCallRecorder", "playDelayInMs<=0");
                i.eau().eaR();
            }
            this.yqw = 92;
        }
        synchronized (this.yqv) {
            try {
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.plugin.ipcall.model.c.c.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(25428);
                        try {
                            c cVar = c.this;
                            cVar.yqu = new com.tencent.mm.audio.b.c(v2protocal.VOICE_SAMPLERATE, 1, 6);
                            cVar.yqu.jk(20);
                            cVar.yqu.dd(true);
                            cVar.yqu.aag();
                            cVar.yqu.dzk = -19;
                            cVar.yqu.x(1, false);
                            cVar.yqu.dc(true);
                            cVar.yqu.dzv = cVar.qrW;
                            if (!cVar.yqu.aai()) {
                                Log.e("MicroMsg.IPCallRecorder", "start record failed");
                                if (cVar.yqu.dyZ != 13) {
                                    i.eau().eaR();
                                    AppMethodBeat.o(25428);
                                    return;
                                }
                            } else {
                                cVar.yqu.de(cVar.guh);
                            }
                            AppMethodBeat.o(25428);
                        } catch (Exception e2) {
                            Log.e("MicroMsg.IPCallRecorder", "start record error: %s", e2.getMessage());
                            i.eau().eaR();
                            AppMethodBeat.o(25428);
                        }
                    }
                }, "IPCallRecorder_startRecord");
            } finally {
                AppMethodBeat.o(25431);
            }
        }
    }

    public class a implements Runnable {
        private com.tencent.mm.audio.b.c yqB = null;

        public a(com.tencent.mm.audio.b.c cVar) {
            this.yqB = cVar;
        }

        public final void run() {
            AppMethodBeat.i(25429);
            Log.d("MicroMsg.IPCallRecorder", "do stopRecord");
            if (this.yqB != null) {
                this.yqB.ZZ();
                this.yqB = null;
                c cVar = c.this;
                cVar.yqw = 92;
                cVar.yqx = true;
                cVar.yqy = 0;
            }
            AppMethodBeat.o(25429);
        }
    }

    public final void setMute(boolean z) {
        AppMethodBeat.i(25432);
        Log.i("MicroMsg.IPCallRecorder", "setMute: %b", Boolean.valueOf(z));
        if (this.isStart && this.yqu != null) {
            this.yqu.de(z);
        }
        this.guh = z;
        AppMethodBeat.o(25432);
    }
}
