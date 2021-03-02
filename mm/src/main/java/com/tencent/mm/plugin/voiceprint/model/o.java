package com.tencent.mm.plugin.voiceprint.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zd;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

public final class o {
    public m GRj;
    public MTimerHandler GRk;
    int GRl;
    int GRm;

    public o() {
        AppMethodBeat.i(29799);
        this.GRj = null;
        this.GRk = null;
        this.GRl = 0;
        this.GRm = 0;
        this.GRj = new m();
        this.GRk = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.voiceprint.model.o.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(29798);
                o.this.GRl += 100;
                o.this.GRm += (o.this.GRj.getMaxAmplitude() * 100) / 100;
                if (o.this.GRl >= 3000) {
                    o oVar = o.this;
                    Log.d("MicroMsg.VoicePrintNoiseDetector", "onDetectFinish");
                    oVar.GRj.ZZ();
                    oVar.GRk.stopTimer();
                    oVar.GRm /= 30;
                    boolean z = oVar.GRm >= 30;
                    Log.d("MicroMsg.VoicePrintNoiseDetector", "average amplitude: %d, hasNoise:%b", Integer.valueOf(oVar.GRm), Boolean.valueOf(z));
                    zd zdVar = new zd();
                    zdVar.efn.efo = z;
                    EventCenter.instance.publish(zdVar);
                    AppMethodBeat.o(29798);
                    return false;
                }
                AppMethodBeat.o(29798);
                return true;
            }
        }, true);
        AppMethodBeat.o(29799);
    }

    private void stopRecord() {
        AppMethodBeat.i(29800);
        this.GRj.ZZ();
        Log.d("MicroMsg.VoicePrintNoiseDetector", "stop record");
        AppMethodBeat.o(29800);
    }

    public final void TR() {
        AppMethodBeat.i(29801);
        Log.d("MicroMsg.VoicePrintNoiseDetector", "start detect noise");
        reset();
        if (!this.GRj.hw(m.cz("voice_pt_voice_print_noise_detect.rec", true))) {
            this.GRj.ZZ();
            reset();
            Log.d("MicroMsg.VoicePrintNoiseDetector", "start record fail");
        } else {
            Log.d("MicroMsg.VoicePrintNoiseDetector", "start record");
        }
        this.GRk.startTimer(100);
        AppMethodBeat.o(29801);
    }

    public final void reset() {
        AppMethodBeat.i(29802);
        stopRecord();
        this.GRk.stopTimer();
        this.GRl = 0;
        this.GRm = 0;
        AppMethodBeat.o(29802);
    }
}
