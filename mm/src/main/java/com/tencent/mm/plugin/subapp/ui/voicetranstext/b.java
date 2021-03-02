package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bxo;
import com.tencent.mm.protocal.protobuf.bxp;
import com.tencent.mm.protocal.protobuf.esm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public final class b extends q implements m {
    private i AAQ;
    private String FNA;
    public esm FNH;
    public int FNL = -1;
    private final String TAG = "MicroMsg.NetSceneGetVoiceTransRes";
    private d iLF;

    public b(String str) {
        boolean z;
        AppMethodBeat.i(29270);
        if (!Util.isNullOrNil(str)) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        this.FNA = str;
        d.a aVar = new d.a();
        aVar.iLN = new bxo();
        aVar.iLO = new bxp();
        aVar.uri = "/cgi-bin/micromsg-bin/getvoicetransres";
        aVar.funcId = 548;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iLF = aVar.aXF();
        AppMethodBeat.o(29270);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 548;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(29271);
        this.AAQ = iVar;
        ((bxo) this.iLF.iLK.iLR).KXr = this.FNA;
        int dispatch = dispatch(gVar, this.iLF, this);
        AppMethodBeat.o(29271);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(29272);
        if (i3 == 0 && i4 == 0) {
            bxp bxp = (bxp) this.iLF.iLL.iLR;
            if (bxp.Llm != null) {
                this.FNL = bxp.Llm.MML;
            }
            this.FNH = bxp.Llk;
        } else {
            Log.i("MicroMsg.NetSceneGetVoiceTransRes", "error get: errType:%d, errCode:%d", Integer.valueOf(i3), Integer.valueOf(i4));
        }
        this.AAQ.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(29272);
    }

    public final boolean isComplete() {
        return this.FNH != null && this.FNH.jeU == 1;
    }

    public final boolean ftu() {
        AppMethodBeat.i(29273);
        if (this.FNH == null || Util.isNullOrNil(this.FNH.NpE)) {
            AppMethodBeat.o(29273);
            return false;
        }
        AppMethodBeat.o(29273);
        return true;
    }
}
