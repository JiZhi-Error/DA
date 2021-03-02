package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.mj;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.recovery.wx.util.WXUtil;

public final class b extends q implements m {
    private i callback;
    private String dOX;
    private String dOZ;
    public long jkB;
    public final d rr;

    public b(long j2, String str, String str2, String str3, String str4, int i2, boolean z) {
        byte[] a2;
        AppMethodBeat.i(109745);
        this.jkB = 0;
        d.a aVar = new d.a();
        aVar.iLN = new mj();
        aVar.iLO = new mk();
        aVar.uri = "/cgi-bin/micromsg-bin/bindqq";
        aVar.funcId = 144;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.jkB = j2;
        mj mjVar = (mj) this.rr.iLK.iLR;
        mjVar.KQu = new p(j2).intValue();
        mjVar.KQi = "";
        mjVar.KQv = "";
        mjVar.KQw = "";
        mjVar.KQx = "";
        mjVar.KQz = new dqi().bhy("");
        mjVar.KQy = 1;
        if (z) {
            a2 = g.aAf().azh().e(j2, str3);
        } else {
            a2 = g.aAf().azh().a(j2, Util.getFullPasswordMD5(str), true);
        }
        mjVar.KNX = new SKBuiltinBuffer_t().setBuffer(a2);
        String nullAsNil = Util.nullAsNil((String) g.aAh().azQ().get(47, (Object) null));
        mjVar.KQA = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString(nullAsNil));
        Log.i("MicroMsg.NetSceneBindQQ", "init opcode:%d qq:%d  wtbuf:%d img[%s,%s,%s] ksid:%s", Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(Util.getLength(a2)), str3, str2, str4, nullAsNil);
        AppMethodBeat.o(109745);
    }

    public b(long j2, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        this(j2, str, str2, str3, str4, 1, z);
        AppMethodBeat.i(109746);
        this.dOX = str5;
        this.dOZ = str6;
        mj mjVar = (mj) this.rr.iLK.iLR;
        mjVar.KPU = str5;
        mjVar.KPV = str6;
        AppMethodBeat.o(109746);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(109747);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(109747);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 144;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(109748);
        mj mjVar = (mj) this.rr.iLK.iLR;
        mk mkVar = (mk) this.rr.iLL.iLR;
        byte[] a2 = z.a(mkVar.KLb);
        boolean a3 = !Util.isNullOrNil(a2) ? g.aAf().azh().a(new p(mjVar.KQu).longValue(), a2) : false;
        if (a3 && g.aAc()) {
            g.aAh().azQ().set(ar.a.USERINFO_MANUAL_AUTH_AS_QQ_ACCOUNT_BOOLEAN_SYNC, Boolean.TRUE);
        }
        Log.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd[%d,%d] wtret:%b wtRespBuf:%d imgsid:%s", Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(a3), Integer.valueOf(Util.getLength(a2)), mkVar.KQw);
        if (i3 == 0 && i4 == 0) {
            int i5 = g.aAh().azQ().getInt(9, 0);
            g.aAh().azQ().set(9, Integer.valueOf(mjVar.KQu));
            if (i5 != 0) {
                if (g.aAh().azQ().get(ar.a.USERINFO_LAST_LOGIN_USERNAME_STRING, "").equals(String.valueOf(i5))) {
                    g.aAh().azQ().set(ar.a.USERINFO_LAST_LOGIN_USERNAME_STRING, com.tencent.mm.model.z.aTY());
                }
                for (String str2 : ch.iFO.aWo()) {
                    if (String.valueOf(i5).equals(ch.iFO.getString(str2, WXUtil.LAST_LOGIN_USERNAME))) {
                        ch.iFO.l(str2, WXUtil.LAST_LOGIN_USERNAME, str2);
                    }
                }
            }
            if (mjVar.KQy == 1) {
                g.aAh().azQ().set(17, Integer.valueOf(mkVar.KEi));
            }
            ((l) g.af(l.class)).aSW().bO(mkVar.KQD, mkVar.KQC == 1);
            int i6 = mjVar.KQu;
            if (i6 != 0) {
                ((l) g.af(l.class)).aSW().eJ(new p(i6) + "@qqim", 3);
            }
            c.e((long) i6, 3);
            g.aAh().azQ().set(32, mjVar.KQi);
            g.aAh().azQ().set(33, mjVar.KQv);
            String encodeHexString = Util.encodeHexString(g.aAf().azh().Aj(new p(mjVar.KQu).longValue()));
            Log.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd wtret:%b newa2key:%s ", Boolean.valueOf(a3), Util.secPrint(encodeHexString));
            g.aAh().azQ().set(72, encodeHexString);
            g.aAh().azQ().set(46, Util.encodeHexString(z.a(mkVar.KLh)));
            String encodeHexString2 = Util.encodeHexString(z.a(mjVar.KQA));
            g.aAh().azQ().set(47, encodeHexString2);
            g.aAh().hqB.set(18, encodeHexString2);
            g.aAh().azQ().set(-1535680990, mkVar.KQE);
        } else if (i3 == 4) {
            g.aAh().azQ().set(32, "");
            g.aAh().azQ().set(33, "");
        }
        if (mjVar.KQy == 3 && i4 == -3) {
            i4 = 10000;
            Log.d("MicroMsg.NetSceneBindQQ", "onGYNetEnd : retCode = 10000");
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(109748);
    }
}
