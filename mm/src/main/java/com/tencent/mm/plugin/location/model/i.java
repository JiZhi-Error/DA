package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.location.ui.impl.f;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.brw;
import com.tencent.mm.protocal.protobuf.brx;
import com.tencent.mm.protocal.protobuf.cxt;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i extends q implements m {
    private com.tencent.mm.ak.i callback;
    public int dJY;
    public int errCode;
    public String errMsg;
    public int errType;
    public String hes;
    public boolean idt = false;
    private Runnable jkz;
    public List<f> list = new ArrayList();
    public final d rr;
    public byte[] yFH;
    public byte[] yFI = null;
    public String yFJ = "";
    public int yFK;

    public i(byte[] bArr, double d2, double d3, int i2, int i3, double d4, double d5, String str, String str2, boolean z) {
        AppMethodBeat.i(55694);
        d.a aVar = new d.a();
        aVar.iLN = new brw();
        aVar.iLO = new brx();
        aVar.uri = "/cgi-bin/micromsg-bin/getpoilist";
        aVar.funcId = 457;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        brw brw = (brw) this.rr.iLK.iLR;
        brw.LXm = bArr == null ? new SKBuiltinBuffer_t() : new SKBuiltinBuffer_t().setBuffer(bArr);
        brw.LPT = str2;
        brw.KUu = d2;
        brw.KUt = d3;
        brw.Scene = i2;
        brw.OpCode = i3;
        brw.LZa = d5;
        brw.LYZ = d4;
        brw.LXo = z ? 1 : 0;
        this.dJY = brw.OpCode;
        this.yFJ = str;
        this.yFH = bArr;
        Log.i("MicroMsg.NetSceneGetPoiList", "lat %f lng %f scene %d opcode %d oriLat %f oriLng %f isAutoQuery %s buffer ".concat(String.valueOf(bArr)), Double.valueOf(d2), Double.valueOf(d3), Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d5), Double.valueOf(d4), Boolean.valueOf(z));
        AppMethodBeat.o(55694);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(55695);
        Log.i("MicroMsg.NetSceneGetPoiList", "NetSceneGetPoiList done.");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(55695);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 457;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(55696);
        Log.d("MicroMsg.NetSceneGetPoiList", "onGYNetEnd  errType:" + i3 + " errCode:" + i4 + "errMsg:" + str);
        this.errType = i3;
        this.errCode = i4;
        this.errMsg = str;
        brx brx = (brx) this.rr.iLL.iLR;
        this.list.clear();
        Log.d("MicroMsg.NetSceneGetPoiList", "url " + brx.LXv + " " + brx.KTg + " " + brx.Url + " " + brx.KZj);
        Log.d("MicroMsg.NetSceneGetPoiList", "autoInterval: %d", Integer.valueOf(brx.LXw));
        this.hes = brx.KZj;
        this.yFK = brx.LXw;
        if (brx.LZc != null) {
            Log.d("MicroMsg.NetSceneGetPoiList", "poi result %d ", Integer.valueOf(brx.LZc.size()));
            if (brx.LZc.size() > 0) {
                Log.d("MicroMsg.NetSceneGetPoiList", "addr %s, province %s, street %s, city %s", brx.LZc.get(0).MCE, brx.LZc.get(0).kdZ, brx.LZc.get(0).LpK, brx.LZc.get(0).kea);
            }
            Iterator<cxt> it = brx.LZc.iterator();
            while (it.hasNext()) {
                f fVar = new f(it.next(), this.hes);
                Log.d("MicroMsg.NetSceneGetPoiList", "lat %s lng %s", Double.valueOf(fVar.cik), Double.valueOf(fVar.cil));
                this.list.add(fVar);
            }
        }
        if (brx.LXm != null) {
            this.yFI = z.a(brx.LXm);
        }
        this.idt = brx.KWa == 1;
        this.callback.onSceneEnd(i3, i4, str, this);
        if (this.jkz != null) {
            this.jkz.run();
        }
        AppMethodBeat.o(55696);
    }

    public final boolean isFirst() {
        return this.yFH == null;
    }
}
