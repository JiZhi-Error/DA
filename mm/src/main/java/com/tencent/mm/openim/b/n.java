package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.b.b;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.protocal.protobuf.dsl;
import com.tencent.mm.protocal.protobuf.dsm;
import com.tencent.mm.sdk.platformtools.Log;

public final class n extends q implements m {
    private i callback;
    private String jHf;
    public dsk jHg;
    public String jHh;
    private final d rr;

    public n(String str) {
        AppMethodBeat.i(151215);
        d.a aVar = new d.a();
        aVar.iLN = new dsl();
        aVar.iLO = new dsm();
        aVar.uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
        aVar.funcId = b.CTRL_INDEX;
        this.rr = aVar.aXF();
        Log.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", this.jHf);
        dsl dsl = (dsl) this.rr.iLK.iLR;
        dsl.MUO = "";
        dsl.dSf = str;
        dsl.MUP = 1;
        AppMethodBeat.o(151215);
    }

    public n(String str, byte b2) {
        AppMethodBeat.i(151216);
        this.jHf = str;
        d.a aVar = new d.a();
        aVar.iLN = new dsl();
        aVar.iLO = new dsm();
        aVar.uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
        aVar.funcId = b.CTRL_INDEX;
        this.rr = aVar.aXF();
        Log.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", str);
        ((dsl) this.rr.iLK.iLR).MUO = str;
        AppMethodBeat.o(151216);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(151217);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(151217);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return b.CTRL_INDEX;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(151218);
        Log.i("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.jHg = ((dsm) this.rr.iLL.iLR).MUQ;
            com.tencent.mm.aj.i iVar = new com.tencent.mm.aj.i();
            iVar.username = this.jHg.UserName;
            iVar.iKX = this.jHg.Lir;
            iVar.iKW = this.jHg.Lis;
            iVar.cSx = -1;
            Log.d("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd search setImageFlag %s b[%s] s[%s]", iVar.getUsername(), iVar.aYt(), iVar.aYu());
            iVar.fuz = 3;
            iVar.fv(true);
            p.aYB().b(iVar);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(151218);
            return;
        }
        if (i3 == 4 && i4 == -2034) {
            this.jHh = ((dsm) this.rr.iLL.iLR).url;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(151218);
    }
}
