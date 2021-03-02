package com.tencent.mm.plugin.sns.ad.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.ad.b.a;
import com.tencent.mm.plugin.sns.ad.i.f;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.protocal.protobuf.cc;
import com.tencent.mm.protocal.protobuf.cd;
import com.tencent.mm.protocal.protobuf.ce;
import com.tencent.mm.protocal.protobuf.cf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g extends q implements m {
    public i callback;
    private d rr;

    public g(String str, int i2, cf cfVar, int i3, int i4, int i5, b bVar, b bVar2, String str2, b bVar3) {
        this(str, i2, 1, 0, null, cfVar, i3, "", i4, i5, 0, 0, 0, bVar, bVar2, str2, bVar3);
    }

    public g(String str, int i2, int i3, String str2, int i4, int i5, int i6, b bVar, b bVar2, String str3) {
        this(str, i2, 2, i3, null, null, 2, str2, -1, i4, i5, i6, 0, bVar, bVar2, str3, null);
    }

    public g(String str, int i2, int i3, int i4, cc ccVar, cf cfVar, int i5, String str2, int i6, int i7, int i8, int i9, int i10, b bVar, b bVar2, String str3, b bVar3) {
        int length;
        int length2;
        AppMethodBeat.i(202034);
        d.a aVar = new d.a();
        aVar.iLN = new cd();
        aVar.iLO = new ce();
        if (i7 != 2) {
            aVar.uri = "/cgi-bin/mmoc-bin/ad/exposure";
            aVar.funcId = 1231;
        } else {
            aVar.uri = "/cgi-bin/mmux-bin/adexposure";
            aVar.funcId = 1875;
        }
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        Log.i("MicroMsg.NetSceneAdExposure", "uri %s", this.rr.getUri());
        cd cdVar = (cd) this.rr.iLK.iLR;
        cdVar.KGj = i4;
        cdVar.type = i3;
        cdVar.scene = i2;
        cdVar.DvI = str;
        cdVar.KGm = i6;
        cdVar.KGn = (long) i8;
        cdVar.KGo = (long) i9;
        cdVar.KFR = i10;
        cdVar.Dsg = a.aoK();
        cdVar.imei = a.eWE();
        String nullAsNil = Util.nullAsNil(str3);
        cdVar.KFI = nullAsNil;
        cdVar.KFH = com.tencent.mm.plugin.sns.waid.b.aRy(nullAsNil);
        if (ccVar != null) {
            cdVar.KGk = ccVar;
            Log.i("MicroMsg.NetSceneAdExposure", "exposure_info " + ccVar.KGh);
        }
        if (cfVar != null) {
            cdVar.KGl = cfVar;
            Log.i("MicroMsg.NetSceneAdExposure", "socialInfo, commentCount=" + cfVar.KGx + ", likeCount=" + cfVar.KGw);
        }
        cdVar.KFM = System.currentTimeMillis();
        cdVar.KFO = i5;
        if (str2 != null) {
            cdVar.KFL = str2;
        }
        if (bVar2 != null) {
            cdVar.KFT = bVar2;
        }
        if (bVar != null) {
            cdVar.KFS = bVar;
        }
        if (bVar3 != null) {
            cdVar.KGp = (float) b.getScreenWidth();
            cdVar.KGq = (float) b.getScreenHeight();
            cdVar.KGr = (float) bVar3.Dut;
            cdVar.KGs = b.eXn();
            cdVar.KGt = bVar3.Duu;
            cdVar.KGu = bVar3.Duv;
            cdVar.KFW = k.s(bVar3.DsC);
            cdVar.KFX = k.r(bVar3.DsC);
            cdVar.KGv = bVar3.Dus;
        }
        cdVar.KFG = a.eWC();
        cdVar.KFF = f.eYk();
        try {
            StringBuilder sb = new StringBuilder();
            StringBuilder append = sb.append("##scene:").append(i2).append(", exposureScene:").append(i3).append(", duration:").append(i4).append(", feed_duration:").append(i8).append(", feed_full_duration:").append(i9).append(", ad_type:").append(i5).append(", exposureCount:").append(i6).append(", descXml:").append(str2).append(", flip_status:").append(i10).append(", self_info.length:");
            if (bVar2 == null) {
                length = 0;
            } else {
                length = bVar2.zy.length;
            }
            StringBuilder append2 = append.append(length).append(", source_info.length:");
            if (bVar == null) {
                length2 = 0;
            } else {
                length2 = bVar.zy.length;
            }
            append2.append(length2).append(", screen.w=").append(cdVar.KGp).append(", screen.h=").append(cdVar.KGq).append(", adView.h=").append(cdVar.KGr).append(", darkMode=").append(cdVar.KGs).append(", halfDuration=").append(cdVar.KGt).append(", fullDuration=").append(cdVar.KGu).append(", followStatus=").append(cdVar.KFW).append(", installStatus=").append(cdVar.KFX).append(", timelineIdx=").append(cdVar.KGv).append(", oaid=").append(cdVar.Dsg).append(", imei=").append(cdVar.imei).append(", waidPkg=").append(nullAsNil).append(", waid=").append(cdVar.KFH).append(", req.ua.length=").append(Util.isNullOrNil(cdVar.KFF) ? 0 : cdVar.KFF.length()).append(", req.common_device_id.length=").append(Util.isNullOrNil(cdVar.KFG) ? 0 : cdVar.KFG.length());
            Log.i("MicroMsg.NetSceneAdExposure", sb.toString());
            Log.i("MicroMsg.NetSceneAdExposure", "viewId.length=" + (str == null ? 0 : str.length()) + ", viewId=" + str);
            AppMethodBeat.o(202034);
        } catch (Throwable th) {
            Log.e("MicroMsg.NetSceneAdExposure", th.toString());
            AppMethodBeat.o(202034);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(94980);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(94980);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1231;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(94981);
        Log.i("MicroMsg.NetSceneAdExposure", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        ce ceVar = (ce) this.rr.iLL.iLR;
        Log.i("MicroMsg.NetSceneAdExposure", "resp " + ceVar.ret + " msg: " + ceVar.msg);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(94981);
    }
}
