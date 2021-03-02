package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bro;
import com.tencent.mm.protocal.protobuf.brp;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class h extends q implements m {
    private i callback;
    private String jGZ;
    private String jHa;
    public cvw jHb;
    private int ret;
    private final d rr;

    public h(String str, String str2, String str3) {
        AppMethodBeat.i(151199);
        d.a aVar = new d.a();
        aVar.iLN = new bro();
        aVar.iLO = new brp();
        aVar.uri = "/cgi-bin/micromsg-bin/getopenimcontact";
        aVar.funcId = 881;
        this.rr = aVar.aXF();
        this.jGZ = str;
        this.jHa = Util.nullAs(str2, "");
        Log.i("MicroMsg.Openim.NetSceneGetOpenIMContact", "get openim username: %s, roomname: %s, ticket:%s", str, this.jHa, str3);
        bro bro = (bro) this.rr.iLK.iLR;
        bro.jGZ = str;
        bro.dOe = this.jHa;
        bro.dHx = str3;
        AppMethodBeat.o(151199);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(151200);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(151200);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 881;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(151201);
        Log.i("MicroMsg.Openim.NetSceneGetOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", Integer.valueOf(i3), Integer.valueOf(i4), str, this.jGZ);
        if (i3 == 0 && i4 == 0) {
            brp brp = (brp) this.rr.iLL.iLR;
            this.jHb = brp.LYS;
            this.ret = s.a(brp);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(151201);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(151201);
    }
}
