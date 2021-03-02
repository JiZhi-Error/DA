package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.dza;
import com.tencent.mm.protocal.protobuf.dzb;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.eaq;
import com.tencent.mm.protocal.protobuf.ecp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class k extends q implements m {
    private String DIa;
    private dzj DIb;
    public i callback;
    private d rr;
    private int type;

    public k(dzj dzj, String str, String str2, int i2) {
        ecp ecp;
        AppMethodBeat.i(95564);
        d.a aVar = new d.a();
        aVar.iLN = new dza();
        aVar.iLO = new dzb();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsadcomment";
        aVar.funcId = com.tencent.mm.plugin.appbrand.jsapi.pay.k.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dza dza = (dza) this.rr.iLK.iLR;
        dza.MYE = dzj;
        this.type = dzj.MZb.oUv;
        this.DIb = dzj;
        dza.izX = str;
        dza.Scene = i2;
        this.DIa = str;
        long j2 = dzj.Id;
        AdSnsInfo JE = aj.faR().JE(j2);
        if (JE != null) {
            TimeLineObject timeLine = JE.getTimeLine();
            if (timeLine != null) {
                ecp = p.PU(timeLine.statExtStr);
            } else {
                Log.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", Long.valueOf(j2));
                ecp = null;
            }
        } else {
            Log.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", Long.valueOf(j2));
            ecp = null;
        }
        if (ecp != null) {
            dza.MYF = z.Su(p.a(ecp));
            dza.xub = ecp.source;
        }
        dza.MYD = z.Su(Util.nullAs(str2, ""));
        Log.i("MicroMsg.NetSceneSnsAdComment", dzj.MZb.MKC + " " + dzj.MZb.LsY + " type " + dzj.MZb.oUv + " aduxinfo " + str2 + ", SnsStat=" + dza.MYF + ", source=" + dza.xub + ", scene=" + i2);
        AppMethodBeat.o(95564);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(95565);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(95565);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.pay.k.CTRL_INDEX;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        SnsObject snsObject;
        AppMethodBeat.i(95566);
        Log.d("MicroMsg.NetSceneSnsAdComment", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        if (i3 == 0 && i4 == 0) {
            aj.faN().i(this.DIb.Id, this.type, this.DIa);
            dzi dzi = this.DIb.MZb;
            if (dzi.oUv == 1 || dzi.oUv == 2 || dzi.oUv == 3 || dzi.oUv == 5 || dzi.oUv == 7 || dzi.oUv == 8 || dzi.oUv == 16) {
                dzo dzo = new dzo();
                dzo.CreateTime = dzi.CreateTime;
                dzo.oUv = dzi.oUv;
                dzo.xub = dzi.xub;
                dzo.Username = dzi.MKC;
                dzo.Nickname = dzi.MYQ;
                dzo.iAc = dzi.iAc;
                dzo.MYX = dzi.MYX;
                try {
                    dza dza = (dza) this.rr.iLK.iLR;
                    dzb dzb = (dzb) this.rr.iLL.iLR;
                    if (dza.xub == 1 || dza.xub == 2) {
                        eaq eaq = dzb.MOf;
                        snsObject = eaq.MYH;
                        a.a(eaq);
                    } else {
                        dzd dzd = dzb.KHG;
                        snsObject = dzd.MYH;
                        a.a(dzd);
                    }
                    Log.d("MicroMsg.NetSceneSnsAdComment", "snsComment:" + snsObject.toString() + " " + snsObject.LikeUserList.size() + " " + snsObject.CommentUserList.size());
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.NetSceneSnsAdComment", e2, "", new Object[0]);
                }
            }
            aj.faN().fan();
        } else if (i3 == 4) {
            aj.faN().i(this.DIb.Id, this.type, this.DIa);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(95566);
    }
}
