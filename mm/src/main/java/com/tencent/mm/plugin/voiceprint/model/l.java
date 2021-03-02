package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class l implements i {
    public int GQT;
    public int GRe;
    private String GRf;
    public int GRg;
    public a GRh;

    public interface a {
        void Y(boolean z, int i2);

        void aUs(String str);

        void aUt(String str);

        void aUu(String str);

        void fED();
    }

    public l() {
        AppMethodBeat.i(29792);
        this.GRe = 71;
        this.GRf = null;
        this.GRg = 0;
        this.GQT = 0;
        this.GRh = null;
        bg.azz().a(611, this);
        bg.azz().a(612, this);
        AppMethodBeat.o(29792);
    }

    public l(a aVar) {
        this();
        this.GRh = aVar;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(29793);
        Log.d("MicroMsg.VoicePrintCreateService", "onSceneEnd, errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 || i3 == 0) {
            if (qVar.getType() == 611) {
                d dVar = (d) qVar;
                this.GRg = dVar.GQN;
                this.GRf = dVar.GQM;
                Log.d("MicroMsg.VoicePrintCreateService", "onFinishGetText, resId:%d, voiceText==null:%b", Integer.valueOf(this.GRg), Boolean.valueOf(Util.isNullOrNil(this.GRf)));
                if (this.GRh != null) {
                    if (this.GRe == 71) {
                        this.GRh.aUs(this.GRf);
                    } else if (this.GRe == 72) {
                        this.GRh.aUt(this.GRf);
                    }
                }
            }
            if (qVar.getType() == 612) {
                f fVar = (f) qVar;
                boolean z = (fVar.GQU == 72 && fVar.NH == 0) || fVar.GQU == 71;
                if (z) {
                    Log.d("MicroMsg.VoicePrintCreateService", "onRegister, ok, step:%d", Integer.valueOf(fVar.GQU));
                    this.GQT = fVar.GQT;
                    if (this.GRh != null) {
                        this.GRh.Y(true, fVar.GQU);
                    }
                } else {
                    Log.d("MicroMsg.VoicePrintCreateService", "onRegister, not ok, step:%d", Integer.valueOf(fVar.GQU));
                    if (this.GRh != null) {
                        this.GRh.Y(false, fVar.GQU);
                    }
                }
                if (z && fVar.GQU == 71 && this.GRh != null) {
                    this.GRh.aUt(this.GRf);
                }
            }
            AppMethodBeat.o(29793);
        } else if (i3 == -34) {
            Log.d("MicroMsg.VoicePrintCreateService", "blocked by limit");
            if (this.GRh != null) {
                this.GRh.aUu(str);
            }
            AppMethodBeat.o(29793);
        } else {
            if (this.GRh != null) {
                this.GRh.fED();
            }
            AppMethodBeat.o(29793);
        }
    }
}
