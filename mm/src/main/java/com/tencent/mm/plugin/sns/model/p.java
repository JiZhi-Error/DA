package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.protocal.protobuf.eaj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Locale;

public final class p extends q implements m {
    private String DIa;
    public dzj DIb;
    public int DIk;
    public SnsObject DqN;
    public SnsInfo DqO;
    public i callback;
    private d rr;
    private int type;

    public p(dzj dzj, String str) {
        this(dzj, str, 0);
        AppMethodBeat.i(95586);
        AppMethodBeat.o(95586);
    }

    public p(dzj dzj, String str, int i2) {
        AppMethodBeat.i(202725);
        d.a aVar = new d.a();
        aVar.iLN = new dzp();
        aVar.iLO = new dzq();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnscomment";
        aVar.funcId = 213;
        aVar.iLP = 100;
        aVar.respCmdId = 1000000100;
        this.rr = aVar.aXF();
        dzp dzp = (dzp) this.rr.iLK.iLR;
        dzp.MYE = dzj;
        this.type = dzj.MZb.oUv;
        this.DIb = dzj;
        this.DIk = i2;
        dzp.izX = str;
        this.DIa = str;
        Log.d("MicroMsg.NetSceneSnsComment", dzj.MZb.MKC + " " + dzj.MZb.LsY);
        AppMethodBeat.o(202725);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        SnsInfo snsInfo;
        AdSnsInfo JE;
        AppMethodBeat.i(95587);
        SnsInfo JJ = aj.faO().JJ(this.DIb.Id);
        if (JJ != null || (JE = aj.faR().JE(this.DIb.Id)) == null) {
            snsInfo = JJ;
        } else {
            snsInfo = JE.convertToSnsInfo();
        }
        if (snsInfo != null) {
            try {
                SnsObject snsObject = (SnsObject) new SnsObject().parseFrom(snsInfo.field_attrBuf);
                if (snsObject.ObjectOperations != null && snsObject.ObjectOperations.hasBuffer()) {
                    eaj eaj = (eaj) new eaj().parseFrom(snsObject.ObjectOperations.getBufferToBytes());
                    dzp dzp = (dzp) this.rr.iLK.iLR;
                    if (eaj.MZL != null) {
                        String format = String.format(Locale.US, "preloadLayerId=%d&preloadExpId=%d", Integer.valueOf(eaj.MZL.Lqt), Integer.valueOf(eaj.MZL.Lqu));
                        Log.i("MicroMsg.NetSceneSnsComment", "doScene(sight_autodownload) snsStatExt:%s", format);
                        dzp.MYF = new dqi().bhy(format);
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.NetSceneSnsComment", e2, "", new Object[0]);
            }
        }
        this.DqO = snsInfo;
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(95587);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 213;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(95588);
        Log.d("MicroMsg.NetSceneSnsComment", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        if (i3 == 0 && i4 == 0) {
            aj.faN().i(this.DIb.Id, this.type, this.DIa);
            dzi dzi = this.DIb.MZb;
            if (dzi.oUv == 1 || dzi.oUv == 2 || dzi.oUv == 3 || dzi.oUv == 5) {
                dzo dzo = new dzo();
                dzo.CreateTime = dzi.CreateTime;
                dzo.oUv = dzi.oUv;
                dzo.xub = dzi.xub;
                dzo.Username = dzi.MKC;
                dzo.Nickname = dzi.MYQ;
                dzo.iAc = dzi.iAc;
                dzo.MYX = dzi.MYX;
                try {
                    SnsObject snsObject = ((dzq) this.rr.iLL.iLR).MYH;
                    this.DqN = snsObject;
                    if (dzi.oUv == 1 || dzi.oUv == 5) {
                        Log.i("MicroMsg.NetSceneSnsComment", "snsComment:" + snsObject.Id + " " + z.b(snsObject.ObjectDesc) + " " + snsObject.LikeUserList.size() + " " + snsObject.CommentUserList.size());
                    } else {
                        Log.i("MicroMsg.NetSceneSnsComment", "snsComment:" + snsObject.Id + " " + snsObject.LikeUserList.size() + " " + snsObject.CommentUserList.size());
                    }
                    an.e(snsObject);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.NetSceneSnsComment", e2, "", new Object[0]);
                }
            }
            aj.faN().fan();
        } else if (i3 == 4) {
            aj.faN().i(this.DIb.Id, this.type, this.DIa);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(95588);
    }
}
