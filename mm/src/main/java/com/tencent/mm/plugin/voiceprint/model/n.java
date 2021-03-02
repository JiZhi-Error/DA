package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.appbrand.jsapi.ce;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class n implements i {
    private String GRf = null;
    public int GRg = -1;
    public a GRi = null;
    public String kly = null;
    public String lhR = null;
    public String mRa = null;

    public interface a {
        void aUv(String str);

        void fED();

        void fEF();

        void wO(boolean z);
    }

    public n() {
        AppMethodBeat.i(29795);
        bg.azz().a(ce.CTRL_INDEX, this);
        bg.azz().a(616, this);
        bg.azz().a(617, this);
        AppMethodBeat.o(29795);
    }

    public final void fEE() {
        AppMethodBeat.i(29796);
        bg.azz().a(new g(this.lhR), 0);
        AppMethodBeat.o(29796);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(29797);
        Log.d("MicroMsg.VoicePrintLoginService", "onSceneEnd, errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 || i3 == 0) {
            if (qVar.getType() == 618) {
                this.lhR = ((e) qVar).gwF;
                Log.d("MicroMsg.VoicePrintLoginService", "onGetTicket, loginTicket==null:%b", Boolean.valueOf(Util.isNullOrNil(this.lhR)));
                if (!Util.isNullOrNil(this.lhR)) {
                    fEE();
                }
            }
            if (qVar.getType() == 616) {
                g gVar = (g) qVar;
                this.GRg = gVar.GQN;
                this.GRf = gVar.GQM;
                Log.d("MicroMsg.VoicePrintLoginService", "onFinishGetText, resId:%d, voiceText==null:%b", Integer.valueOf(this.GRg), Boolean.valueOf(Util.isNullOrNil(this.GRf)));
                if (this.GRi != null) {
                    this.GRi.aUv(this.GRf);
                }
            }
            if (qVar.getType() == 617) {
                h hVar = (h) qVar;
                if (hVar.NH == 0) {
                    Log.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, success");
                    this.kly = hVar.kly;
                    if (this.GRi != null) {
                        this.GRi.wO(true);
                        AppMethodBeat.o(29797);
                        return;
                    }
                } else {
                    Log.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, failed");
                    if (this.GRi != null) {
                        this.GRi.wO(false);
                    }
                }
            }
            AppMethodBeat.o(29797);
        } else if (i3 == -34 && qVar.getType() == 617) {
            Log.d("MicroMsg.VoicePrintLoginService", "blocked by limit");
            if (this.GRi != null) {
                this.GRi.fEF();
            }
            AppMethodBeat.o(29797);
        } else {
            if (this.GRi != null) {
                this.GRi.fED();
            }
            AppMethodBeat.o(29797);
        }
    }
}
