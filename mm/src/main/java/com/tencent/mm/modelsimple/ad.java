package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.eps;
import com.tencent.mm.protocal.protobuf.ept;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public final class ad extends q implements m {
    private i callback;
    public long jkB;
    public d rr;

    public ad(String str, String str2, String str3, String str4) {
        this(1, str, str2, str3, str4, false, 0);
    }

    public ad(int i2, String str, String str2, String str3, String str4, boolean z, int i3) {
        this(i2, str, str2, str3, str4, z, i3, true);
    }

    public ad(int i2, String str, String str2, String str3, String str4, boolean z, int i3, boolean z2) {
        byte[] a2;
        AppMethodBeat.i(43059);
        this.jkB = 0;
        d.a aVar = new d.a();
        aVar.iLN = new eps();
        aVar.iLO = new ept();
        aVar.uri = "/cgi-bin/micromsg-bin/newverifypasswd";
        aVar.funcId = 384;
        aVar.iLP = 182;
        aVar.respCmdId = 1000000182;
        this.rr = aVar.aXF();
        eps eps = (eps) this.rr.iLK.iLR;
        eps.OpCode = i2;
        eps.MWU = i3;
        eps.Nnm = Util.getFullPasswordMD5(str);
        eps.KQv = Util.getCutPasswordMD5(str);
        eps.Mdj = new dqi().bhy(str2);
        eps.Nnn = new dqi().bhy(str3);
        eps.KQz = new dqi().bhy(str4);
        if (i2 == 5 || i2 == 2) {
            this.jkB = new p(z.aTX()).longValue();
            if (z) {
                a2 = g.aAf().azh().e(this.jkB, str3);
            } else {
                a2 = g.aAf().azh().a(this.jkB, Util.getFullPasswordMD5(str), z2);
            }
            eps.KNX = new SKBuiltinBuffer_t().setBuffer(a2);
        }
        eps.KQA = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString(Util.nullAsNil((String) g.aAh().azQ().get(47, (Object) null))));
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(eps.OpCode);
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Boolean.valueOf(z2);
        objArr[3] = Integer.valueOf(eps.KNX == null ? -1 : eps.KNX.getILen());
        objArr[4] = eps.KNX == null ? BuildConfig.COMMAND : Util.secPrint(Util.dumpHex(eps.KNX.getBufferToBytes()));
        Log.i("MicroMsg.NetSceneVerifyPswd", "summerauth opCode[%d], hasSecCode[%b], isManualAuth[%b], len:%d, content:[%s]", objArr);
        AppMethodBeat.o(43059);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(43060);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(43060);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 384;
    }

    public final String bbG() {
        AppMethodBeat.i(43061);
        try {
            String str = ((ept) this.rr.iLL.iLR).Bri;
            AppMethodBeat.o(43061);
            return str;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneVerifyPswd", e2, "", new Object[0]);
            AppMethodBeat.o(43061);
            return null;
        }
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(43062);
        updateDispatchId(i2);
        eps eps = (eps) this.rr.iLK.iLR;
        ept ept = (ept) this.rr.iLL.iLR;
        if (ept.KLb != null && ept.KLb.getILen() > 0) {
            Log.i("MicroMsg.NetSceneVerifyPswd", "summerauth parseRet[%b], len[%d]", Boolean.valueOf(g.aAf().azh().a(this.jkB, com.tencent.mm.platformtools.z.a(ept.KLb))), Integer.valueOf(ept.KLb.getILen()));
            if (g.aAc()) {
                g.aAh().azQ().set(ar.a.USERINFO_MANUAL_AUTH_AS_QQ_ACCOUNT_BOOLEAN_SYNC, Boolean.TRUE);
            }
        }
        if (i3 == 0 && i4 == 0) {
            g.aAh().azQ().set(77830, ept.Bri);
            g.aAh().azQ().set(32, eps.Nnm);
            g.aAh().azQ().set(33, eps.KQv);
            g.aAh().azQ().set(46, Util.encodeHexString(com.tencent.mm.platformtools.z.a(ept.KLh)));
            String encodeHexString = Util.encodeHexString(com.tencent.mm.platformtools.z.a(eps.KQA));
            g.aAh().azQ().set(47, encodeHexString);
            g.aAh().hqB.set(18, encodeHexString);
            g.aAh().azQ().set(-1535680990, ept.KLg);
            Log.i("MicroMsg.NetSceneVerifyPswd", "A2Key.len %d, authKey.len: %d, ticketLen:%d", Integer.valueOf(ept.KLh == null ? 0 : ept.KLh.getILen()), Integer.valueOf(ept.KLg == null ? 0 : ept.KLg.length()), Integer.valueOf(ept.Bri == null ? 0 : ept.Bri.length()));
        } else if (i3 == 4) {
            g.aAh().azQ().set(32, "");
            g.aAh().azQ().set(33, "");
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(43062);
    }
}
