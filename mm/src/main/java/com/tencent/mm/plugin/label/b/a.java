package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.protocal.protobuf.cgu;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a extends q implements m {
    private i callback;
    private final d rr;
    private LinkedList<cgu> yBT = new LinkedList<>();

    public a(String str) {
        AppMethodBeat.i(26142);
        d.a aVar = new d.a();
        aVar.iLN = new cu();
        aVar.iLO = new cv();
        aVar.uri = "/cgi-bin/micromsg-bin/addcontactlabel";
        aVar.funcId = b.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        if (!Util.isNullOrNil(str)) {
            cgu cgu = new cgu();
            cgu.Mmb = str;
            this.yBT.add(cgu);
        }
        AppMethodBeat.o(26142);
    }

    public a(List<String> list) {
        AppMethodBeat.i(26143);
        d.a aVar = new d.a();
        aVar.iLN = new cu();
        aVar.iLO = new cv();
        aVar.uri = "/cgi-bin/micromsg-bin/addcontactlabel";
        aVar.funcId = b.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                cgu cgu = new cgu();
                cgu.Mmb = list.get(i2);
                this.yBT.add(cgu);
            }
        }
        AppMethodBeat.o(26143);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(26144);
        Log.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene].");
        this.callback = iVar;
        cu cuVar = (cu) this.rr.iLK.iLR;
        if (this.yBT == null || this.yBT.size() <= 0) {
            Log.e("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene] label list is null.");
            iVar.onSceneEnd(3, -1, "[doScene]empty contact list.", this);
            AppMethodBeat.o(26144);
            return 0;
        }
        cuVar.KGW = this.yBT;
        cuVar.KGV = this.yBT.size();
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(26144);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(26145);
        Log.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        cv ech = ech();
        if (ech != null) {
            LinkedList<cgu> linkedList = ech.KGW;
            ArrayList arrayList = new ArrayList();
            int size = linkedList.size();
            for (int i5 = 0; i5 < size; i5++) {
                cgu cgu = linkedList.get(i5);
                au auVar = new au();
                auVar.field_labelID = cgu.Mmc;
                auVar.field_labelName = cgu.Mmb;
                auVar.field_labelPYFull = f.Sh(cgu.Mmb);
                auVar.field_labelPYShort = f.Si(cgu.Mmb);
                auVar.field_isTemporary = false;
                arrayList.add(auVar);
            }
            e.ecf().iF(arrayList);
            e.ecf().iG(arrayList);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(26145);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return b.CTRL_INDEX;
    }

    public final cv ech() {
        return (cv) this.rr.iLL.iLR;
    }
}
