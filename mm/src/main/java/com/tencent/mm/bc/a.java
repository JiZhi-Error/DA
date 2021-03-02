package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bti;
import com.tencent.mm.protocal.protobuf.btj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a extends q implements m {
    private i callback;
    public String jhF;
    public String jhG;
    public byte[] jhH;
    private final d rr;

    public a() {
        this(z.aTY(), Util.nullAsNil((Integer) g.aAh().azQ().get(66561, (Object) null)), 0);
        AppMethodBeat.i(150870);
        AppMethodBeat.o(150870);
    }

    public a(String str, int i2) {
        this(str, i2, 0);
    }

    public a(String str, int i2, int i3) {
        AppMethodBeat.i(150871);
        this.callback = null;
        this.jhF = null;
        this.jhG = null;
        this.jhH = null;
        d.a aVar = new d.a();
        aVar.iLN = new bti();
        aVar.iLO = new btj();
        aVar.uri = "/cgi-bin/micromsg-bin/getqrcode";
        aVar.funcId = 168;
        aVar.iLP = 67;
        aVar.respCmdId = 1000000067;
        this.rr = aVar.aXF();
        bti bti = (bti) this.rr.iLK.iLR;
        bti.Lqk = com.tencent.mm.platformtools.z.Su(str);
        bti.KUh = i2;
        bti.OpCode = i3;
        Log.i("MicroMsg.NetSceneGetQRCode", "username:%s, style:%d, opcode:%d", str, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(150871);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(150872);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(150872);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 168;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(150873);
        Log.d("MicroMsg.NetSceneGetQRCode", "onGYNetEnd errType:" + i3 + " errCode" + i4);
        if (i3 == 0 && i4 == 0) {
            btj btj = (btj) this.rr.iLL.iLR;
            String a2 = com.tencent.mm.platformtools.z.a(((bti) this.rr.iLK.iLR).Lqk);
            this.jhH = com.tencent.mm.platformtools.z.a(btj.LXP, new byte[0]);
            this.jhF = btj.LZY;
            Log.i("MicroMsg.NetSceneGetQRCode", "expiredWording:%s, revokeId:%s, revokeWording:%s", this.jhF, btj.LZZ, btj.Maa);
            if (z.aTY().equals(a2)) {
                String str2 = btj.LZZ;
                String str3 = (String) g.aAh().azQ().get(66563, "");
                if (str2 != null && !str3.equals(str2)) {
                    g.aAh().azQ().set(66563, str2);
                    this.jhG = btj.Maa;
                }
                g.aAh().azQ().set(66561, Integer.valueOf(btj.KUh));
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(150873);
    }
}
