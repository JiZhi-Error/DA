package com.tencent.mm.plugin.voiceprint.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.x;

public final class p {
    public static int dAR = 100;
    public int FKi = 0;
    public b GRo;
    public String GRp;
    public boolean GRq = false;
    public com.tencent.mm.plugin.voiceprint.b.a GRr = new com.tencent.mm.plugin.voiceprint.b.a(new kotlin.g.a.b<Boolean, x>() {
        /* class com.tencent.mm.plugin.voiceprint.model.p.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(232123);
            p.a(p.this);
            AppMethodBeat.o(232123);
            return null;
        }
    });
    public a GRs = null;
    public m doF = null;
    public String fileName = "";
    private int pkT = 0;
    public long qPl = 0;

    public interface a {
        void fEG();
    }

    public p() {
        AppMethodBeat.i(232124);
        AppMethodBeat.o(232124);
    }

    public final boolean Qt() {
        long j2 = 0;
        AppMethodBeat.i(29808);
        this.GRr.wN(false);
        this.GRq = false;
        Log.d("MicroMsg.VoicePrintRecoder", "stop Record :" + this.fileName);
        synchronized (this) {
            try {
                Log.d("MicroMsg.VoicePrintRecoder", "stop synchronized Record :" + this.fileName);
                if (this.doF != null) {
                    this.doF.ZZ();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(29808);
                throw th;
            }
        }
        if (this.FKi != 2) {
            this.fileName = null;
            this.GRq = false;
            Log.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName);
        } else {
            if (this.qPl > 0) {
                j2 = Util.ticksToNow(this.qPl);
            }
            this.pkT = (int) j2;
            if (this.pkT < 1000) {
                Log.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName + " by voiceLen: " + this.pkT);
                this.fileName = "";
                this.GRq = false;
            } else {
                this.GRq = true;
                Log.d("MicroMsg.VoicePrintRecoder", "Stop file success: " + this.fileName);
            }
            this.fileName = "";
        }
        this.FKi = -1;
        Log.d("MicroMsg.VoicePrintRecoder", "bLongEnough " + this.GRq);
        boolean z = this.GRq;
        AppMethodBeat.o(29808);
        return z;
    }

    /* access modifiers changed from: package-private */
    public final class b extends Thread {
        MMHandler handler;

        public b() {
            AppMethodBeat.i(29805);
            this.handler = new MMHandler(p.this) {
                /* class com.tencent.mm.plugin.voiceprint.model.p.b.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MMHandler
                public final void handleMessage(Message message) {
                    AppMethodBeat.i(29804);
                    if (p.this.FKi <= 0) {
                        AppMethodBeat.o(29804);
                        return;
                    }
                    p.this.FKi = 2;
                    AppMethodBeat.o(29804);
                }
            };
            AppMethodBeat.o(29805);
        }

        public final void run() {
            AppMethodBeat.i(29806);
            if (p.this.doF == null) {
                Log.e("MicroMsg.VoicePrintRecoder", "Stop Record Failed recorder == null");
                AppMethodBeat.o(29806);
                return;
            }
            synchronized (p.this) {
                try {
                    String cz = m.cz(p.this.fileName, true);
                    Log.d("MicroMsg.VoicePrintRecoder", "fullPathName %s", cz);
                    p.this.GRp = cz;
                    p.this.GRr.wN(true);
                    if (!p.this.doF.hw(cz)) {
                        p.this.fileName = null;
                        Log.d("MicroMsg.VoicePrintRecoder", "Thread Start Record  Error fileName[" + p.this.fileName + "]");
                        p.this.doF.ZZ();
                        p.this.doF = null;
                        p.this.GRr.wN(true);
                        if (p.this.GRs != null) {
                            p.this.GRs.fEG();
                        }
                        return;
                    }
                    if (p.this.GRs != null) {
                        a unused = p.this.GRs;
                    }
                    p.this.qPl = Util.currentTicks();
                    Log.d("MicroMsg.VoicePrintRecoder", "Thread Started Record fileName[" + p.this.fileName + "]");
                    this.handler.sendEmptyMessageDelayed(0, 1);
                    AppMethodBeat.o(29806);
                } finally {
                    AppMethodBeat.o(29806);
                }
            }
        }
    }

    static /* synthetic */ void a(p pVar) {
        AppMethodBeat.i(232125);
        pVar.doF = new m();
        pVar.GRo = new b();
        pVar.GRo.start();
        pVar.GRq = false;
        pVar.FKi = 1;
        AppMethodBeat.o(232125);
    }
}
