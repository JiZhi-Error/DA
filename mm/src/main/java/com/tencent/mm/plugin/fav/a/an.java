package com.tencent.mm.plugin.fav.a;

import android.util.SparseArray;
import com.hilive.mediasdk.SdkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dxp;
import com.tencent.mm.protocal.protobuf.dxq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class an extends q implements m {
    private i callback = null;
    private final d rr;
    private int scene;
    private List<Integer> tbG;
    private a tbH = null;
    private SparseArray<String> tbI = new SparseArray<>();
    private String toUser;

    public interface a {
        void e(SparseArray<String> sparseArray);
    }

    public an(String str, List<Integer> list, a aVar) {
        AppMethodBeat.i(103486);
        d.a aVar2 = new d.a();
        aVar2.iLN = new dxp();
        aVar2.iLO = new dxq();
        aVar2.uri = "/cgi-bin/micromsg-bin/sharefav";
        aVar2.funcId = SdkInfo.ErrCode.kErrCodeNotFound;
        aVar2.iLP = 246;
        aVar2.respCmdId = 1000000246;
        this.rr = aVar2.aXF();
        this.toUser = str;
        this.scene = 2;
        this.tbG = list;
        this.tbH = aVar;
        AppMethodBeat.o(103486);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(103487);
        Log.d("MicroMsg.NetSceneShareFavItem", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        this.tbI.clear();
        if (i3 == 0 && i4 == 0) {
            dxq dxq = (dxq) ((d) sVar).iLL.iLR;
            if (dxq.Mcp != this.tbG.size()) {
                Log.w("MicroMsg.NetSceneShareFavItem", "get url error, request count %d, response count %d", Integer.valueOf(this.tbG.size()), Integer.valueOf(dxq.Mcp));
            }
            int i5 = 0;
            while (i5 < dxq.KOv.size() && i5 < this.tbG.size()) {
                Log.d("MicroMsg.NetSceneShareFavItem", "id[%d] url=%s", this.tbG.get(i5), dxq.KOv.get(i5));
                this.tbI.put(this.tbG.get(i5).intValue(), dxq.KOv.get(i5).MTo);
                i5++;
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        if (this.tbH != null) {
            this.tbH.e(this.tbI);
        }
        AppMethodBeat.o(103487);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return SdkInfo.ErrCode.kErrCodeNotFound;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(103488);
        dxp dxp = (dxp) this.rr.iLK.iLR;
        dxp.MXp = this.toUser;
        dxp.Scene = this.scene;
        dxp.KOn = new LinkedList<>(this.tbG);
        dxp.oTz = dxp.KOn.size();
        Log.d("MicroMsg.NetSceneShareFavItem", "do scene %s %d %s %d", dxp.MXp, Integer.valueOf(dxp.Scene), dxp.KOn, Integer.valueOf(dxp.oTz));
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(103488);
        return dispatch;
    }
}
