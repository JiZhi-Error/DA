package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.byk;
import com.tencent.mm.protocal.protobuf.byl;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class j extends q implements m {
    private i callback;
    private final d rr;
    public List<se> yFL = new ArrayList(8);

    public j() {
        AppMethodBeat.i(55697);
        d.a aVar = new d.a();
        aVar.iLN = new byk();
        aVar.iLO = new byl();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getweapplistbylocation";
        aVar.funcId = 1913;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(55697);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1913;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(55698);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(55698);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(55699);
        Log.i("MicroMsg.NetSceneGetWeappListByLocation", "onGYNetEnd errType: %s, errCode: %s, errMsg: %s.", Integer.valueOf(i3), Integer.valueOf(i4), str);
        byl byl = (byl) this.rr.iLL.iLR;
        if (byl.MdU != null) {
            int size = byl.MdU.size();
            Log.i("MicroMsg.NetSceneGetWeappListByLocation", "weapp list size: %s.", Integer.valueOf(size));
            if (size <= 8) {
                this.yFL.addAll(byl.MdU);
            } else {
                this.yFL.addAll(byl.MdU.subList(0, 8));
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(55699);
    }
}
