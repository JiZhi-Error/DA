package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class q implements i {
    private String GQO;
    private int GQT;
    public String GRf;
    public int GRg;
    public a GRw;

    public interface a {
        void aUv(String str);

        void fED();

        void fEF();

        void wP(boolean z);
    }

    public q() {
        AppMethodBeat.i(29809);
        this.GRw = null;
        this.GRg = -1;
        this.GRf = null;
        this.GQO = null;
        this.GQT = 0;
        bg.azz().a(611, this);
        bg.azz().a(613, this);
        AppMethodBeat.o(29809);
    }

    public q(a aVar) {
        this();
        this.GRw = aVar;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(29810);
        Log.d("MicroMsg.VoicePrintUnLockService", "onSceneEnd, errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 || i3 == 0) {
            if (qVar.getType() == 611) {
                d dVar = (d) qVar;
                this.GRg = dVar.GQN;
                this.GRf = dVar.GQM;
                this.GQO = dVar.GQO;
                Log.d("MicroMsg.VoicePrintUnLockService", "onGetVoiceText, resId:%d, verifyKey:%s, voiceText==null:%b", Integer.valueOf(this.GRg), this.GQO, Boolean.valueOf(Util.isNullOrNil(this.GRf)));
                if (this.GRw != null) {
                    this.GRw.aUv(this.GRf);
                }
            }
            if (qVar.getType() == 613) {
                if (((j) qVar).NH == 0) {
                    Log.d("MicroMsg.VoicePrintUnLockService", "onVerify, success");
                    if (this.GRw != null) {
                        this.GRw.wP(true);
                        AppMethodBeat.o(29810);
                        return;
                    }
                } else {
                    Log.d("MicroMsg.VoicePrintUnLockService", "onVerify, failed");
                    if (this.GRw != null) {
                        this.GRw.wP(false);
                    }
                }
            }
            AppMethodBeat.o(29810);
        } else if (i3 == -34) {
            Log.d("MicroMsg.VoicePrintUnLockService", "blocked by limit");
            if (this.GRw != null) {
                this.GRw.fEF();
            }
            AppMethodBeat.o(29810);
        } else {
            if (this.GRw != null) {
                this.GRw.fED();
            }
            AppMethodBeat.o(29810);
        }
    }
}
