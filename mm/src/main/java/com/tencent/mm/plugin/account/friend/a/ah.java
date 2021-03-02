package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cdn;
import com.tencent.mm.protocal.protobuf.cdo;
import com.tencent.mm.protocal.protobuf.cdp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ah extends q implements m {
    private i callback;
    private LinkedList<cdn> kft = new LinkedList<>();
    public String kfu;
    private final d rr;

    public ah(ArrayList<String> arrayList) {
        AppMethodBeat.i(131123);
        d.a aVar = new d.a();
        aVar.iLN = new cdo();
        aVar.iLO = new cdp();
        aVar.uri = "/cgi-bin/micromsg-bin/invitegooglecontact";
        aVar.funcId = 489;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        if (arrayList.size() > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                cdn cdn = new cdn();
                cdn.KPA = arrayList.get(i2);
                this.kft.add(cdn);
            }
        }
        AppMethodBeat.o(131123);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(131124);
        Log.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
        this.callback = iVar;
        cdo cdo = (cdo) this.rr.iLK.iLR;
        cdo.oTz = this.kft.size();
        cdo.oTA = this.kft;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(131124);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(131125);
        Log.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(131125);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(131125);
    }

    public final cdp bop() {
        return (cdp) this.rr.iLL.iLR;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 489;
    }
}
