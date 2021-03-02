package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.protocal.protobuf.cil;
import com.tencent.mm.protocal.protobuf.cim;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aj extends q implements m {
    private i callback = null;
    private final d rr;

    public aj(String str, List<String[]> list) {
        int i2 = 0;
        AppMethodBeat.i(131132);
        d.a aVar = new d.a();
        aVar.iLN = new cil();
        aVar.iLO = new cim();
        aVar.uri = "/cgi-bin/micromsg-bin/listmfriend";
        aVar.funcId = 431;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cil cil = (cil) this.rr.iLK.iLR;
        cil.Bri = str;
        cil.Mnx = 0;
        cil.Mnv = list != null ? list.size() : i2;
        cil.Mny = new LinkedList<>();
        cil.Mnw = new LinkedList<>();
        if (list != null) {
            for (String[] strArr : list) {
                if (!Util.isNullOrNil(strArr[2])) {
                    cil.Mnw.add(new dqi().bhy(strArr[2]));
                }
            }
        }
        AppMethodBeat.o(131132);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(131133);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(131133);
        return dispatch;
    }

    public final LinkedList<cik> bor() {
        AppMethodBeat.i(131134);
        LinkedList<cik> linkedList = ((cim) this.rr.iLL.iLR).Mnz;
        if (linkedList != null) {
            Iterator<cik> it = linkedList.iterator();
            while (it.hasNext()) {
                cik next = it.next();
                a.bqE().aTp().mP(next.UserName, next.LRO);
            }
        }
        LinkedList<cik> linkedList2 = ((cim) this.rr.iLL.iLR).Mnz;
        AppMethodBeat.o(131134);
        return linkedList2;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 431;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(131135);
        final cim cim = (cim) this.rr.iLL.iLR;
        com.tencent.mm.kernel.g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread() {
            /* class com.tencent.mm.plugin.account.friend.a.aj.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean onPostExecute() {
                return false;
            }

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean doInBackground() {
                AppMethodBeat.i(131130);
                if (cim != null && cim.Mnz.size() > 0) {
                    Iterator<cik> it = cim.Mnz.iterator();
                    while (it.hasNext()) {
                        cik next = it.next();
                        if (next.oTW == 1) {
                            com.tencent.mm.aj.i iVar = new com.tencent.mm.aj.i();
                            iVar.username = next.UserName;
                            iVar.iKX = next.Lir;
                            iVar.iKW = next.Lis;
                            iVar.cSx = -1;
                            Log.d("MicroMsg.NetSceneListMFriend", "getmlist  %s b[%s] s[%s]", iVar.getUsername(), iVar.aYt(), iVar.aYu());
                            iVar.fuz = 3;
                            iVar.fv(true);
                            p.aYB().b(iVar);
                        }
                    }
                }
                AppMethodBeat.o(131130);
                return true;
            }

            public final String toString() {
                AppMethodBeat.i(131131);
                String str = super.toString() + "|onGYNetEnd";
                AppMethodBeat.o(131131);
                return str;
            }
        });
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(131135);
    }
}
