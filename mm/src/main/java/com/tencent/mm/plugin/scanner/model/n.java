package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.protocal.protobuf.pt;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.Log;

public final class n extends q implements m {
    public boolean CFF = false;
    private i callback;
    private int dFL;
    public int dFM;
    private String dWl = "";
    public d rr;

    public n(int i2, String str, int i3) {
        AppMethodBeat.i(51626);
        d.a aVar = new d.a();
        aVar.iLN = new pt();
        aVar.iLO = new pu();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
        aVar.funcId = 1061;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        pt ptVar = (pt) this.rr.iLK.iLR;
        this.dFL = i2;
        ptVar.oUv = i2;
        ptVar.KWI = str;
        ptVar.Scene = Wt(0);
        ptVar.mode = 2;
        this.dFM = i3;
        Log.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, codeType: %s, barcode: %s, codeVersion: %s, mode: %d, entryScene: %d, scene: %d", Integer.valueOf(i2), str, Integer.valueOf(i3), 2, 0, Integer.valueOf(ptVar.Scene));
        AppMethodBeat.o(51626);
    }

    public n(String str, String str2, int i2, int i3, int i4) {
        AppMethodBeat.i(240715);
        d.a aVar = new d.a();
        aVar.iLN = new pt();
        aVar.iLO = new pu();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
        aVar.funcId = 1061;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        pt ptVar = (pt) this.rr.iLK.iLR;
        this.dFL = e.d.bcV(str);
        ptVar.oUv = this.dFL;
        ptVar.KWI = str2;
        ptVar.Scene = Wt(i4);
        ptVar.mode = i3;
        this.dFM = i2;
        this.dWl = str;
        Log.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, codeType: %s, barcode: %s, codeName: %s, codeVersion: %s, mode: %d, entryScene: %d, scene: %d", Integer.valueOf(this.dFL), str2, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(ptVar.Scene));
        AppMethodBeat.o(240715);
    }

    private static int Wt(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 5:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            default:
                return 0;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(51628);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(51628);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        AppMethodBeat.i(51629);
        pt ptVar = (pt) ((d) sVar).iLK.iLR;
        if (ptVar.oUv < 0 || ptVar.KWI == null || ptVar.KWI.length() <= 0) {
            Log.e("MicroMsg.scanner.NetSceneScanBarcode", "securityVerificationChecked failed, Type = " + ptVar.oUv + ", Barcode = %s" + ptVar.KWI);
            q.b bVar = q.b.EFailed;
            AppMethodBeat.o(51629);
            return bVar;
        }
        q.b bVar2 = q.b.EOk;
        AppMethodBeat.o(51629);
        return bVar2;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(51630);
        Log.d("MicroMsg.scanner.NetSceneScanBarcode", "onGYNetEnd errtype:" + i3 + " errcode:" + i4 + " errMsg:" + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(51630);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1061;
    }
}
