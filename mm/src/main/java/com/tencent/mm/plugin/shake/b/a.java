package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.dww;
import com.tencent.mm.protocal.protobuf.dwx;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.smtt.sdk.TbsListener;
import java.util.LinkedList;
import java.util.List;

public final class a extends q implements m {
    List<d> DgE;
    private int DgF;
    private i callback;
    private String pWf;
    int ret;
    private d rr;

    public a(byte[] bArr) {
        AppMethodBeat.i(28086);
        d.a aVar = new d.a();
        aVar.iLN = new dww();
        aVar.iLO = new dwx();
        aVar.uri = "/cgi-bin/micromsg-bin/shakeget";
        aVar.funcId = TbsListener.ErrorCode.STARTDOWNLOAD_3;
        aVar.iLP = 57;
        aVar.respCmdId = 1000000057;
        this.rr = aVar.aXF();
        dww dww = (dww) this.rr.iLK.iLR;
        dww.KMS = new SKBuiltinBuffer_t().setBuffer(bArr);
        dww.MWS = 1;
        try {
            ewf ewf = new ewf();
            ewf.NtQ = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.exJ());
            dww.KLQ = new SKBuiltinBuffer_t().setBuffer(ewf.toByteArray());
            AppMethodBeat.o(28086);
        } catch (Throwable th) {
            AppMethodBeat.o(28086);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(28087);
        Log.d("MicroMsg.NetSceneShakeGet", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(28087);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.STARTDOWNLOAD_3;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        boolean z;
        int i5;
        AppMethodBeat.i(28088);
        Log.d("MicroMsg.NetSceneShakeGet", "onGYNetEnd errType:" + i3 + " errCode:" + i4);
        dwx dwx = (dwx) this.rr.iLL.iLR;
        this.DgE = new LinkedList();
        this.DgF = dwx.MWU;
        this.ret = dwx.Ret;
        this.pWf = dwx.AZI;
        int i6 = dwx.oTz;
        Log.d("MicroMsg.NetSceneShakeGet", "size:".concat(String.valueOf(i6)));
        bg.aVF();
        bv aSN = c.aSN();
        if (i6 > 0) {
            e eUm = m.eUm();
            eUm.eUc();
            Log.i("MicroMsg.NewShakeItemStorage", "delOldRecord count:".concat(String.valueOf(i6)));
            if (eUm.db.execSQL("shakeitem1", "DELETE FROM shakeitem1 WHERE shakeItemID NOT IN ( SELECT shakeItemID FROM shakeitem1 ORDER BY shakeItemID DESC LIMIT " + (100 > i6 ? 100 - i6 : 0) + " )")) {
                Log.i("MicroMsg.NewShakeItemStorage", "delOldRecord success count:".concat(String.valueOf(i6)));
                eUm.doNotify();
            }
            for (int i7 = i6 - 1; i7 >= 0; i7--) {
                if (!z.aTY().equals(dwx.MWT.get(i7).UserName)) {
                    com.tencent.mm.api.c MT = ag.bah().MT(dwx.MWT.get(i7).UserName);
                    MT.field_username = dwx.MWT.get(i7).UserName;
                    MT.field_brandList = dwx.MWT.get(i7).kei;
                    aeq aeq = dwx.MWT.get(i7).MmR;
                    if (aeq != null) {
                        MT.field_brandFlag = aeq.kem;
                        MT.field_brandInfo = aeq.keo;
                        MT.field_brandIconURL = aeq.kep;
                        MT.field_extInfo = aeq.ken;
                    }
                    if (!ag.bah().h(MT)) {
                        ag.bah().g(MT);
                    }
                }
                d dVar = new d(dwx.MWT.get(i7));
                com.tencent.mm.aj.i iVar = new com.tencent.mm.aj.i();
                iVar.username = dVar.field_username;
                if (dVar.field_hasHDImg > 0) {
                    z = true;
                } else {
                    z = false;
                }
                iVar.fv(z);
                iVar.fuz = dVar.field_imgstatus;
                iVar.iKX = dwx.MWT.get(i7).Lir;
                iVar.iKW = dwx.MWT.get(i7).Lis;
                p.aYB().b(iVar);
                iVar.cSx = -1;
                Log.d("MicroMsg.NetSceneShakeGet", "dkhurl search %s b[%s] s[%s]", iVar.getUsername(), iVar.aYt(), iVar.aYu());
                if (aSN.bjG(dVar.field_username)) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                dVar.field_reserved2 = i5;
                as Kn = aSN.Kn(dVar.field_username);
                if (Kn != null && ((int) Kn.gMZ) > 0) {
                    eUm.aNj(Kn.field_username);
                    eUm.aNj(Kn.field_encryptUsername);
                }
                eUm.a(dVar, false);
                bg.aVF();
                c.aTp().O(dVar.field_username, this.DgF, dwx.MWT.get(i7).LRO);
                dVar.scene = this.DgF;
                this.DgE.add(dVar);
                Log.v("MicroMsg.NetSceneShakeGet", "item info: " + dVar.field_username + " " + dVar.field_nickname);
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(28088);
    }
}
