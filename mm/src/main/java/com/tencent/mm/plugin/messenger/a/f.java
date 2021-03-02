package com.tencent.mm.plugin.messenger.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.drs;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;

public final class f extends q implements m {
    private i callback;
    public final d rr;
    public final boolean zpn;

    public f(String str) {
        this(str, 0);
    }

    public f(String str, int i2) {
        this(str, i2, (byte) 0);
    }

    private f(String str, int i2, byte b2) {
        this(str, 1, i2, false);
    }

    public f(String str, int i2, int i3, boolean z) {
        AppMethodBeat.i(94802);
        this.zpn = z;
        d.a aVar = new d.a();
        aVar.iLN = new drs();
        aVar.iLO = new drt();
        aVar.uri = "/cgi-bin/micromsg-bin/searchcontact";
        aVar.funcId = 106;
        aVar.iLP = 34;
        aVar.respCmdId = 1000000034;
        this.rr = aVar.aXF();
        Log.d("MicroMsg.NetSceneSearchContact", "search username [%s], scene [%s]", str, Integer.valueOf(i3));
        drs drs = (drs) this.rr.iLK.iLR;
        drs.Lqk = new dqi().bhy(str);
        drs.MJj = i2;
        drs.MUl = i3;
        AppMethodBeat.o(94802);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(94803);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(94803);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 106;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(94804);
        drt drt = (drt) this.rr.iLL.iLR;
        if (drt != null && drt.LUB > 0) {
            Iterator<drr> it = drt.LUC.iterator();
            while (it.hasNext()) {
                drr next = it.next();
                Log.d("MicroMsg.NetSceneSearchContact", "search RES username [%s]", next.Lqk);
                com.tencent.mm.aj.i iVar = new com.tencent.mm.aj.i();
                iVar.username = z.a(next.Lqk);
                iVar.iKX = next.Lir;
                iVar.iKW = next.Lis;
                iVar.cSx = -1;
                Log.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", iVar.getUsername(), iVar.aYt(), iVar.aYu());
                iVar.fuz = 3;
                iVar.fv(true);
                p.aYB().b(iVar);
            }
        } else if (drt != null && !Util.isNullOrNil(z.a(drt.Lqk))) {
            String a2 = z.a(drt.Lqk);
            com.tencent.mm.aj.i iVar2 = new com.tencent.mm.aj.i();
            iVar2.username = a2;
            iVar2.iKX = drt.Lir;
            iVar2.iKW = drt.Lis;
            iVar2.cSx = -1;
            Log.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", iVar2.getUsername(), iVar2.aYt(), iVar2.aYu());
            iVar2.fuz = 3;
            iVar2.fv(true);
            p.aYB().b(iVar2);
        }
        if (drt != null) {
            Iterator<dsk> it2 = drt.MUq.iterator();
            while (it2.hasNext()) {
                dsk next2 = it2.next();
                com.tencent.mm.aj.i iVar3 = new com.tencent.mm.aj.i();
                iVar3.username = next2.UserName;
                iVar3.iKX = next2.Lir;
                iVar3.iKW = next2.Lis;
                iVar3.cSx = -1;
                Log.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", iVar3.getUsername(), iVar3.aYt(), iVar3.aYu());
                iVar3.fuz = 3;
                iVar3.fv(true);
                p.aYB().b(iVar3);
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(94804);
    }

    public final drt eiq() {
        AppMethodBeat.i(94805);
        drt drt = (drt) this.rr.iLL.iLR;
        if (drt != null) {
            Iterator<drr> it = drt.LUC.iterator();
            while (it.hasNext()) {
                drr next = it.next();
                a.bqE().aTp().mP(next.Lqk.MTo, next.LRO);
            }
        }
        AppMethodBeat.o(94805);
        return drt;
    }
}
