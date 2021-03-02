package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.plugin.game.protobuf.aq;
import com.tencent.mm.plugin.game.protobuf.ar;
import com.tencent.mm.plugin.game.protobuf.as;
import com.tencent.mm.plugin.game.protobuf.at;
import com.tencent.mm.plugin.game.protobuf.ax;
import com.tencent.mm.plugin.game.protobuf.bo;
import com.tencent.mm.plugin.game.protobuf.cl;
import com.tencent.mm.plugin.game.protobuf.eg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class ac extends x {
    private bo xHg;
    public cl xHh;
    public a xHi;
    public as xHj;
    public eg xHk;
    public ax xHl;

    public static class a {
        public String desc;
        public c xHm;
        public aq xHn;
        public ar xHo;
        public at xHp;
    }

    public ac(bo boVar) {
        AppMethodBeat.i(41537);
        if (boVar == null) {
            this.xHg = new bo();
            AppMethodBeat.o(41537);
            return;
        }
        this.xHg = boVar;
        pN(true);
        AppMethodBeat.o(41537);
    }

    public ac(byte[] bArr) {
        AppMethodBeat.i(41538);
        this.xHg = new bo();
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(41538);
            return;
        }
        try {
            this.xHg.parseFrom(bArr);
        } catch (IOException e2) {
            Log.e("MicroMsg.GamePBDataIndex4", "Parsing Failed: %s", e2.getMessage());
        }
        pN(false);
        AppMethodBeat.o(41538);
    }

    private void pN(boolean z) {
        AppMethodBeat.i(41539);
        dVP();
        pO(z);
        AppMethodBeat.o(41539);
    }

    private void pO(boolean z) {
        AppMethodBeat.i(41540);
        if (this.xHg == null || !z) {
            AppMethodBeat.o(41540);
            return;
        }
        if (!(this.xHg.xLJ == null || this.xHg.xLJ.xIz == null)) {
            d.c(a(this.xHg.xLJ.xIz));
        }
        ((e) g.af(e.class)).dSI().init(MMApplicationContext.getContext());
        AppMethodBeat.o(41540);
    }

    private void dVP() {
        AppMethodBeat.i(41541);
        if (this.xHg == null) {
            AppMethodBeat.o(41541);
            return;
        }
        this.xHh = this.xHg.xLM;
        if (!(this.xHg.xLJ == null || this.xHg.xLJ.xIz == null)) {
            this.xHi = new a();
            this.xHi.xHm = a(this.xHg.xLJ.xIz);
            if (this.xHi.xHm != null) {
                this.xHi.xHm.xDV = this.xHg.xLJ.Desc;
                this.xHi.xHm.scene = 10;
                this.xHi.xHm.dYu = 1002;
                this.xHi.xHm.position = 1;
            }
            this.xHi.xHn = this.xHg.xLJ.xKC;
            this.xHi.xHo = this.xHg.xLJ.xKB;
            this.xHi.desc = this.xHg.xLJ.Desc;
            this.xHi.xHp = this.xHg.xLL;
        }
        this.xHj = this.xHg.xLK;
        this.xHk = this.xHg.xLN;
        this.xHl = this.xHg.xLO;
        AppMethodBeat.o(41541);
    }
}
