package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.duh;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxmm.v2helper;
import java.util.LinkedList;
import java.util.List;

public final class al extends q implements m {
    private i callback = null;
    private final d rr;

    public al(String str, List<String> list) {
        AppMethodBeat.i(131139);
        d.a aVar = new d.a();
        aVar.iLN = new dug();
        aVar.iLO = new duh();
        aVar.uri = "/cgi-bin/micromsg-bin/sendsmstomfriend";
        aVar.funcId = v2helper.EMethodSetSendToNetworkOn;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dug dug = (dug) this.rr.iLK.iLR;
        dug.Bri = str;
        dug.Mnw = new LinkedList<>();
        dug.Mnv = list.size();
        for (String str2 : list) {
            if (!Util.isNullOrNil(str2)) {
                dug.Mnw.add(new dqi().bhy(str2));
            }
        }
        AppMethodBeat.o(131139);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(131140);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(131140);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return v2helper.EMethodSetSendToNetworkOn;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(131141);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(131141);
    }
}
