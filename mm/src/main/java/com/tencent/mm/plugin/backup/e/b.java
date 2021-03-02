package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.protocal.protobuf.ip;
import com.tencent.mm.protocal.protobuf.ir;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b extends q implements m {
    protected i callback;
    public d rr;

    public b(LinkedList<adi> linkedList, String str) {
        AppMethodBeat.i(21373);
        d.a aVar = new d.a();
        aVar.iLN = new ip();
        aVar.iLO = new ir();
        aVar.uri = "/cgi-bin/micromsg-bin/bakchatcreateqrcode";
        aVar.funcId = 704;
        this.rr = aVar.aXF();
        ip ipVar = (ip) this.rr.iLK.iLR;
        ipVar.KMC = linkedList.size();
        ipVar.KMD = linkedList;
        ipVar.KMF = z.aTY();
        ipVar.KME = com.tencent.mm.compatible.deviceinfo.q.aoJ();
        ipVar.KMG = str;
        ipVar.oTS = 0;
        ipVar.Scene = 2;
        AppMethodBeat.o(21373);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(21374);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(21374);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(21375);
        Log.i("MicroMsg.BackupCreateQRCodeScene", "err: %d, %d, %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            ir irVar = (ir) this.rr.iLL.iLR;
            Log.i("MicroMsg.BackupCreateQRCodeScene", "onGYNetEnd QRCodeUrl:%s", irVar.KMJ);
            com.tencent.mm.plugin.backup.b.d.aS(irVar.KLU.getBuffer().zy);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(21375);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(21375);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 704;
    }
}
