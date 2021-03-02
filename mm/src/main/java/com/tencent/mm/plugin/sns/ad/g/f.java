package com.tencent.mm.plugin.sns.ad.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.ad.b.a;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.bv;
import com.tencent.mm.protocal.protobuf.bw;
import com.tencent.mm.sdk.platformtools.Log;

public final class f extends q implements m {
    public i callback;
    private d rr;

    public f(long j2, String str, int i2, int i3, int i4, String str2, int i5, String str3, int i6, b bVar, b bVar2, long j3, String str4, String str5, a aVar) {
        int length;
        int length2;
        AppMethodBeat.i(192747);
        d.a aVar2 = new d.a();
        aVar2.iLN = new bv();
        aVar2.iLO = new bw();
        int IY = o.DCS.IY(j2);
        if (IY != 2) {
            aVar2.uri = "/cgi-bin/mmoc-bin/ad/click";
            aVar2.funcId = 1232;
        } else {
            aVar2.uri = "/cgi-bin/mmux-bin/adclick";
            aVar2.funcId = 1817;
        }
        aVar2.iLP = 0;
        aVar2.respCmdId = 0;
        this.rr = aVar2.aXF();
        Log.i("MicroMsg.NetSceneAdClick", "source %d, uri %s", Integer.valueOf(IY), this.rr.getUri());
        bv bvVar = (bv) this.rr.iLK.iLR;
        bvVar.KFK = i2;
        bvVar.DvI = str;
        bvVar.scene = i4;
        bvVar.KFL = str2;
        bvVar.KFM = System.currentTimeMillis();
        bvVar.KFO = i5;
        bvVar.KFP = i3;
        bvVar.source = IY;
        bvVar.KFQ = str3;
        bvVar.KFR = i6;
        bvVar.KFU = j3;
        bvVar.Dsg = a.aoK();
        bvVar.imei = a.eWE();
        bvVar.KFI = str4;
        bvVar.KFH = str5;
        if (bVar2 != null) {
            bvVar.KFT = bVar2;
        }
        if (bVar != null) {
            bvVar.KFS = bVar;
        }
        bvVar.KFV = aVar.Dur;
        bvVar.KFW = aVar.Duq;
        bvVar.KFX = aVar.Dup;
        bvVar.KFG = a.eWC();
        bvVar.KFF = com.tencent.mm.plugin.sns.ad.i.f.eYk();
        try {
            StringBuilder sb = new StringBuilder();
            StringBuilder append = sb.append("##snsId:").append(j2).append(", clickPos:").append(i2).append(", clickAction:").append(i3).append(", sceneType:").append(i4).append(", descXml:").append(str2).append(", adtype:").append(i5).append(", snsStatStr:").append(str3).append(", flipStatus:").append(i6).append(", remind_source_info.length:");
            if (bVar == null) {
                length = 0;
            } else {
                length = bVar.zy.length;
            }
            StringBuilder append2 = append.append(length).append(", remind_self_info.length:");
            if (bVar2 == null) {
                length2 = 0;
            } else {
                length2 = bVar2.zy.length;
            }
            append2.append(length2).append(", exposure_start_time:").append(j3).append(", followStatus:").append(bvVar.KFW).append(", installStatus:").append(bvVar.KFX).append(", videoCurTime:").append(bvVar.KFV).append(", oaid:").append(bvVar.Dsg).append(", imei:").append(bvVar.imei).append(", waidPkg:").append(str4).append(", waid:").append(str5).append(", ua:").append(bvVar.KFF).append(", common_device_id:").append(bvVar.KFG);
            Log.i("MicroMsg.NetSceneAdClick", sb.toString());
            Log.i("MicroMsg.NetSceneAdClick", "viewId.length=" + (str == null ? 0 : str.length()) + ", viewId=" + str);
            AppMethodBeat.o(192747);
        } catch (Throwable th) {
            Log.e("MicroMsg.NetSceneAdClick", th.toString());
            AppMethodBeat.o(192747);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(125683);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(125683);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1232;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(125684);
        Log.d("MicroMsg.NetSceneAdClick", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(125684);
    }
}
