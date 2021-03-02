package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.aau;
import com.tencent.mm.protocal.protobuf.eho;
import com.tencent.mm.protocal.protobuf.ehp;
import com.tencent.mm.protocal.protobuf.ehs;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;

public final class k extends q implements m {
    private i callback;
    d rr;

    public k() {
        LinkedList<aau> linkedList = null;
        AppMethodBeat.i(6151);
        d.a aVar = new d.a();
        aVar.iLN = new eho();
        aVar.iLO = new ehp();
        aVar.uri = "/cgi-bin/mmbiz-bin/bizattr/timeline_often_read_biz";
        aVar.funcId = 2768;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        eho eho = (eho) this.rr.iLK.iLR;
        ehp cnr = f.cnr();
        if (cnr != null) {
            LinkedList<ehs> linkedList2 = cnr.Nhd;
            if (!Util.isNullOrNil(linkedList2)) {
                LinkedList<aau> linkedList3 = new LinkedList<>();
                Iterator<ehs> it = linkedList2.iterator();
                while (it.hasNext()) {
                    ehs next = it.next();
                    if (next != null) {
                        aau aau = new aau();
                        aau.KJV = next.KJV;
                        z MP = ag.ban().MP(((l) g.af(l.class)).aSN().bjM(next.KJV));
                        if (MP != null) {
                            aau.Lmc = (int) (MP.field_createTime / 1000);
                        }
                        linkedList3.add(aau);
                    }
                }
                linkedList = linkedList3;
            }
        }
        eho.Nhc = linkedList;
        AppMethodBeat.o(6151);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(6152);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(6152);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2768;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(6153);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(6153);
        return dispatch;
    }
}
