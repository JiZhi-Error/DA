package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dxa;
import com.tencent.mm.protocal.protobuf.dxb;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b extends q implements m {
    private i callback;
    byte[] efs;
    int ret;
    private final d rr;

    public b(float f2, float f3, int i2, int i3, String str, String str2) {
        AppMethodBeat.i(28089);
        d.a aVar = new d.a();
        aVar.iLN = new dxa();
        aVar.iLO = new dxb();
        aVar.uri = "/cgi-bin/micromsg-bin/shakereport";
        aVar.funcId = 161;
        aVar.iLP = 56;
        aVar.respCmdId = 1000000056;
        this.rr = aVar.aXF();
        dxa dxa = (dxa) this.rr.iLK.iLR;
        Log.i("MicroMsg.NetSceneShakeReport", "share reprot %f %f", Float.valueOf(f3), Float.valueOf(f2));
        dxa.OpCode = 0;
        dxa.LbC = f2;
        dxa.LbD = f3;
        dxa.LuT = i2;
        dxa.LuU = str;
        dxa.LuV = str2;
        dxa.LuW = i3;
        bg.aVF();
        dxa.MXg = Util.nullAs((Integer) c.azQ().get(4107, (Object) null), 0);
        bg.aVF();
        int nullAsNil = Util.nullAsNil((Integer) c.azQ().get(4106, (Object) null));
        dxa.MXh = nullAsNil;
        bg.aVF();
        c.azQ().set(4106, Integer.valueOf(nullAsNil + 1));
        try {
            ewf ewf = new ewf();
            ewf.NtQ = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.exJ());
            dxa.KLQ = new SKBuiltinBuffer_t().setBuffer(ewf.toByteArray());
        } catch (Throwable th) {
        }
        o.a(2002, f2, f3, i2);
        AppMethodBeat.o(28089);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(28090);
        Log.d("MicroMsg.NetSceneShakeReport", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(28090);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 161;
    }

    public final int eTO() {
        return ((dxa) this.rr.iLK.iLR).LuW;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(28091);
        Log.d("MicroMsg.NetSceneShakeReport", "onGYNetEnd errType:" + i3 + " errCode:" + i4);
        dxb dxb = (dxb) this.rr.iLL.iLR;
        this.ret = sVar.getRespObj().getRetCode();
        if (i3 == 0 && i4 == 0) {
            this.efs = z.a(dxb.KMS);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(28091);
    }
}
