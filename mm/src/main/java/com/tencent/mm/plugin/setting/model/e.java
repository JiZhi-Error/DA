package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bgu;
import com.tencent.mm.protocal.protobuf.bgv;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.TbsListener;
import java.util.LinkedList;
import java.util.Map;

public final class e extends q implements m {
    public String CXI;
    private i callback;
    private d rr;

    public e(String str) {
        this(str, null);
        AppMethodBeat.i(73766);
        AppMethodBeat.o(73766);
    }

    public e(String str, Map<Integer, String> map) {
        AppMethodBeat.i(256455);
        d.a aVar = new d.a();
        aVar.iLN = new bgu();
        aVar.iLO = new bgv();
        aVar.uri = "/cgi-bin/micromsg-bin/generalset";
        aVar.funcId = TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.CXI = str;
        bgu bgu = (bgu) this.rr.iLK.iLR;
        bgu.SetType = 1;
        bgu.LQD = str;
        if (map != null) {
            bgu.LQE = map.size();
            bgu.LQF = new LinkedList<>();
            for (Integer num : map.keySet()) {
                bgw bgw = new bgw();
                bgw.oUv = num.intValue();
                bgw.Bri = map.get(num);
                bgu.LQF.add(bgw);
            }
        }
        AppMethodBeat.o(256455);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(73767);
        Log.d("MicroMsg.NetSceneGeneralSet", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(73767);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(73768);
        Log.d("MicroMsg.NetSceneGeneralSet", "onGYNetEnd errType:" + i3 + " errCode:" + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(73768);
    }
}
