package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bss;
import com.tencent.mm.protocal.protobuf.bst;
import com.tencent.mm.protocal.protobuf.dbz;
import com.tencent.mm.protocal.protobuf.dca;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class f extends q implements m {
    private i CXJ = null;
    public boolean CXK = false;
    private final d hhm;

    public f() {
        AppMethodBeat.i(256456);
        d.a aVar = new d.a();
        aVar.iLN = new bss();
        aVar.iLO = new bst();
        aVar.uri = "/cgi-bin/micromsg-bin/getpluginswitch";
        aVar.funcId = 4158;
        this.hhm = aVar.aXF();
        AppMethodBeat.o(256456);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 4158;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(256457);
        this.CXJ = iVar;
        int dispatch = dispatch(gVar, this.hhm, this);
        AppMethodBeat.o(256457);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        bst bst;
        dca dca;
        LinkedList<dbz> linkedList;
        AppMethodBeat.i(256458);
        if (i3 == 0 && i4 == 0 && (bst = (bst) ((d) sVar).iLL.iLR) != null && (dca = bst.LZx) != null && (linkedList = dca.gCs) != null) {
            Iterator<dbz> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                dbz next = it.next();
                if (next != null) {
                    Log.i("MicroMsg.NetSceneGetMiniShopHelperPluginShowStatus", "updateNeedShow, switchId: %d, switchValue: %b", Integer.valueOf(next.MGL), Boolean.valueOf(next.MGM));
                    if (5200001 == next.MGL) {
                        this.CXK = next.MGM;
                        break;
                    }
                }
            }
        }
        if (this.CXJ != null) {
            this.CXJ.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(256458);
    }
}
