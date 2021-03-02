package com.tencent.mm.sandbox.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sandbox.SubCoreSandBox;
import com.tencent.mm.protocal.protobuf.bwn;
import com.tencent.mm.protocal.protobuf.bwo;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class a extends q implements m, b {
    private i callback;
    public final d rr;

    public a(int i2) {
        AppMethodBeat.i(32578);
        d.a aVar = new d.a();
        aVar.iLN = new bwn();
        aVar.iLO = new bwo();
        aVar.uri = "/cgi-bin/micromsg-bin/getupdateinfo";
        aVar.funcId = 113;
        aVar.iLP = 35;
        aVar.respCmdId = 1000000035;
        this.rr = aVar.aXF();
        bwn bwn = (bwn) this.rr.iLK.iLR;
        bwn.Mck = i2;
        bwn.KCx = ChannelUtil.channelId;
        if (10012 == ac.jOC && ac.jOD > 0) {
            bwn.KCx = ac.jOD;
        }
        switch (i2) {
            case 1:
                h.INSTANCE.idkeyStat(405, 3, 1, true);
                break;
            case 2:
                h.INSTANCE.idkeyStat(405, 4, 1, true);
                break;
            case 3:
                h.INSTANCE.idkeyStat(405, 5, 1, true);
                break;
            case 4:
                h.INSTANCE.idkeyStat(405, 6, 1, true);
                break;
        }
        Log.i("MicroMsg.NetSceneGetUpdateInfo", "summerupdate dkchan NetSceneGetUpdateInfo updateType:%d channel:%d release:%d, stack[%s]", Integer.valueOf(bwn.Mck), Integer.valueOf(bwn.KCx), Integer.valueOf(ChannelUtil.channelId), Util.getStack());
        AppMethodBeat.o(32578);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(32579);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(32579);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 11;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(32580);
        Log.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken GetUpdateInfo onGYNetEnd errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            h.INSTANCE.idkeyStat(405, 7, 1, true);
        } else {
            h.INSTANCE.idkeyStat(405, 8, 1, true);
            if (i3 == 4) {
                h.INSTANCE.idkeyStat(405, 9, 1, true);
                if (i4 == -16) {
                    h.INSTANCE.idkeyStat(405, 10, 1, true);
                } else if (i4 == -17) {
                    h.INSTANCE.idkeyStat(405, 11, 1, true);
                } else if (i4 == -18) {
                    h.INSTANCE.idkeyStat(405, 12, 1, true);
                }
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        String gvU = gvU();
        if (gvU != null) {
            com.tencent.mm.d.i fR = com.tencent.mm.d.i.fR(gvU);
            if (fR != null) {
                int i5 = fR.versionCode;
                Log.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchVersionCode[%d]", Integer.valueOf(i5));
                bg.azz().a(new af(MMApplicationContext.getPackageName(), i5), 0);
                h.INSTANCE.idkeyStat(405, 13, 1, true);
                AppMethodBeat.o(32580);
                return;
            }
            Log.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchInfo is null patchXml[%s]", gvU);
            AppMethodBeat.o(32580);
            return;
        }
        Log.w("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchXml is null!");
        h.INSTANCE.idkeyStat(405, 14, 1, true);
        AppMethodBeat.o(32580);
    }

    public final int gvS() {
        return ((bwo) this.rr.iLL.iLR).Mcn;
    }

    public final String gvT() {
        return ((bwo) this.rr.iLL.iLR).Mcm;
    }

    @Override // com.tencent.mm.plugin.p.b
    public final int ell() {
        return ((bwo) this.rr.iLL.iLR).Mcl;
    }

    @Override // com.tencent.mm.plugin.p.b
    public final String[] elm() {
        AppMethodBeat.i(32581);
        bwo bwo = (bwo) this.rr.iLL.iLR;
        String[] strArr = new String[bwo.Mcq.size()];
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = bwo.Mcq.get(i2).MTo;
        }
        AppMethodBeat.o(32581);
        return strArr;
    }

    public final String gvU() {
        AppMethodBeat.i(32582);
        bwo bwo = (bwo) this.rr.iLL.iLR;
        Log.d("MicroMsg.NetSceneGetUpdateInfo", "summertoken getPatchInfo[%s], stack[%s]", bwo.Mcr, Util.getStack());
        String str = bwo.Mcr;
        AppMethodBeat.o(32582);
        return str;
    }

    @Override // com.tencent.mm.plugin.p.b
    public final bwo eln() {
        int i2 = 1;
        AppMethodBeat.i(232383);
        if (SubCoreSandBox.Czx) {
            bwo bwo = (bwo) this.rr.iLL.iLR;
            bwo.Mcs = 1;
            bwo.Mct = HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
            if (!SubCoreSandBox.Czy) {
                i2 = 0;
            }
            bwo.Mcu = i2;
        }
        bwo bwo2 = (bwo) this.rr.iLL.iLR;
        AppMethodBeat.o(232383);
        return bwo2;
    }
}
