package com.tencent.mm.plugin.fav.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.protocal.protobuf.ane;
import com.tencent.mm.protocal.protobuf.yj;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.protocal.protobuf.yl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a extends q implements m {
    private i callback = null;
    private d iUB;

    public a(List<amr> list) {
        AppMethodBeat.i(101580);
        d.a aVar = new d.a();
        aVar.iLN = new yj();
        aVar.iLO = new yk();
        aVar.uri = "/cgi-bin/micromsg-bin/checkfavitem";
        aVar.funcId = 405;
        aVar.iLP = 196;
        aVar.respCmdId = 1000000196;
        this.iUB = aVar.aXF();
        yj yjVar = (yj) this.iUB.iLK.iLR;
        yjVar.Ljx = new LinkedList<>();
        yjVar.Ljx.addAll(list);
        yjVar.Scene = 1;
        Log.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_OBJECT %s", Integer.valueOf(list.size()));
        AppMethodBeat.o(101580);
    }

    public a(ane ane) {
        AppMethodBeat.i(101581);
        d.a aVar = new d.a();
        aVar.iLN = new yj();
        aVar.iLO = new yk();
        aVar.uri = "/cgi-bin/micromsg-bin/checkfavitem";
        aVar.funcId = 405;
        aVar.iLP = 196;
        aVar.respCmdId = 1000000196;
        this.iUB = aVar.aXF();
        yj yjVar = (yj) this.iUB.iLK.iLR;
        yjVar.Ljy = ane;
        yjVar.Scene = 2;
        Log.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_DATA %s", Integer.valueOf(ane.KGZ));
        AppMethodBeat.o(101581);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(101582);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(101582);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(101583);
        Log.i("MicroMsg.Fav.NetSceneCheckFavItem", "netId %d errType %d errCode %d errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        yk ykVar = (yk) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0) {
            Iterator<yl> it = ykVar.Ljz.iterator();
            while (it.hasNext()) {
                yl next = it.next();
                Log.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem, onGYNetEnd,favid: %d, ret: %d", Integer.valueOf(next.KGZ), Integer.valueOf(next.Ret));
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(101583);
            return;
        }
        Log.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem,cgi return error,errcode:%d,errType:%d", Integer.valueOf(i4), Integer.valueOf(i3));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(101583);
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 10;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 405;
    }
}
