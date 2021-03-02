package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.C2395do;
import com.tencent.mm.protocal.protobuf.dp;
import com.tencent.mm.protocal.protobuf.eku;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class c extends q implements m {
    private i callback;
    private List<String> sNv;

    public c(List<String> list) {
        this.sNv = list;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(73762);
        updateDispatchIdNew(i2);
        if (!(i3 == 0 && i4 == 0)) {
            Log.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", Integer.valueOf(i3), Integer.valueOf(i4));
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(73762);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 583;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(73763);
        this.callback = iVar;
        d.a aVar = new d.a();
        C2395do doVar = new C2395do();
        ArrayList arrayList = new ArrayList();
        if (this.sNv != null) {
            for (int i2 = 0; i2 < this.sNv.size(); i2++) {
                eku eku = new eku();
                eku.UserName = this.sNv.get(i2);
                arrayList.add(eku);
            }
        }
        doVar.KHC.addAll(arrayList);
        aVar.iLN = doVar;
        aVar.iLO = new dp();
        aVar.uri = "/cgi-bin/micromsg-bin/addtrustedfriends";
        aVar.funcId = 583;
        aVar.iLP = 0;
        aVar.iLP = 0;
        int dispatch = dispatch(gVar, aVar.aXF(), this);
        AppMethodBeat.o(73763);
        return dispatch;
    }
}
