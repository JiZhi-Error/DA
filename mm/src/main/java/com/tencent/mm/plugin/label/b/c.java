package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.protocal.protobuf.blr;
import com.tencent.mm.protocal.protobuf.bls;
import com.tencent.mm.protocal.protobuf.cgu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.LinkedList;

public final class c extends q implements m {
    private i callback;
    private final d rr;

    public c() {
        AppMethodBeat.i(26149);
        d.a aVar = new d.a();
        aVar.iLN = new blr();
        aVar.iLO = new bls();
        aVar.uri = "/cgi-bin/micromsg-bin/getcontactlabellist";
        aVar.funcId = 639;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(26149);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(26150);
        Log.d("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(209408, Long.valueOf(System.currentTimeMillis()));
            bls bls = (bls) this.rr.iLL.iLR;
            if (!(bls == null || bls.KGW == null)) {
                LinkedList<cgu> linkedList = bls.KGW;
                ArrayList arrayList = new ArrayList();
                int size = linkedList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    cgu cgu = linkedList.get(i5);
                    au auVar = new au();
                    auVar.field_labelID = cgu.Mmc;
                    auVar.field_labelName = cgu.Mmb;
                    auVar.field_labelPYFull = f.Sh(cgu.Mmb);
                    auVar.field_labelPYShort = f.Si(cgu.Mmb);
                    arrayList.add(auVar);
                }
                e.ecf().iG(arrayList);
                e.ecf().iH(e.ecf().iI(arrayList));
            }
        } else {
            Log.w("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] getcontactlabellist fail.");
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(26150);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 639;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(26151);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(26151);
        return dispatch;
    }
}
