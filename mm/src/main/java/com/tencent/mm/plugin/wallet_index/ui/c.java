package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_index.c.g;
import com.tencent.mm.plugin.wallet_index.c.n;
import com.tencent.mm.protocal.protobuf.ccu;
import com.tencent.mm.protocal.protobuf.ccv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.c.v;
import java.util.ArrayList;
import java.util.List;

public final class c {
    int AQo;
    public String IqF = null;
    public String IqG = null;
    public ccu IqP;
    public ccv IqQ;
    public String Irm = null;
    public ArrayList<String> Irp = new ArrayList<>();
    public ArrayList<String> Irq = new ArrayList<>();
    public String Irr = null;
    public int Irs = 0;
    List<String> Irt = new ArrayList();
    boolean Iru = false;
    public String Irv;
    public String Irw;
    public int mCount = 1;
    public String rcD = null;

    public c() {
        AppMethodBeat.i(71861);
        AppMethodBeat.o(71861);
    }

    public final q f(int i2, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(214277);
        if (this.Iru) {
            try {
                g gVar = new g(i2, str2, this.IqG, str3, this.mCount, this.IqF, str4, this.Irv, this.Irw);
                AppMethodBeat.o(214277);
                return gVar;
            } catch (NumberFormatException e2) {
                Log.printErrStackTrace("MicroMsg.IapData", e2, "NetSceneGetAndroidIapPackage Error priceLevel:" + this.IqG, new Object[0]);
                AppMethodBeat.o(214277);
                return null;
            }
        } else {
            u uVar = new u(this.rcD, this.IqG, this.IqF, this.mCount, i2, str);
            AppMethodBeat.o(214277);
            return uVar;
        }
    }

    public final boolean fUs() {
        return this.AQo == 2;
    }

    public final q a(com.tencent.mm.plugin.wallet_index.b.a.c cVar, boolean z) {
        AppMethodBeat.i(71862);
        int i2 = z ? 2 : 1;
        if (this.Iru) {
            if (!fUs()) {
                this.IqP.MiK = cVar.mSignature;
                this.IqP.MiH = cVar.IqE;
                this.IqP.price = cVar.IqG;
                this.IqP.LSm = cVar.IqF;
                this.IqP.AZx = cVar.rcD;
                this.IqP.MiJ = cVar.mOriginalJson;
            }
            n nVar = new n(this.AQo, i2, cVar.rcD, this.IqQ, this.IqP);
            AppMethodBeat.o(71862);
            return nVar;
        }
        v vVar = new v(cVar.rcD, i2, this.AQo, this.mCount, cVar.IqE, cVar.mOriginalJson, cVar.mSignature, cVar.IqF, cVar.IqG);
        AppMethodBeat.o(71862);
        return vVar;
    }
}
