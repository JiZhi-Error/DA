package com.tencent.mm.modelsimple;

import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ffj;
import com.tencent.mm.protocal.protobuf.ffk;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.Util;

public final class af extends q implements m {
    private i callback;
    private final d iFd;
    private int retryCount = 3;

    public af(String str, int i2) {
        AppMethodBeat.i(150966);
        d.a aVar = new d.a();
        aVar.iLN = new ffj();
        aVar.iLO = new ffk();
        aVar.uri = "/cgi-bin/micromsg-bin/yybgetpkgsig";
        aVar.funcId = 729;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iFd = aVar.aXF();
        ffj ffj = (ffj) this.iFd.iLK.iLR;
        ffj.rBI = LocaleUtil.getApplicationLanguage();
        ffj.KLL = com.tencent.mm.plugin.normsg.a.d.INSTANCE.TK(0);
        ffj.NAF = str;
        ffj.xIL = i2;
        Log.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig Language[%s], PkgName[%s], versionCode[%d], stack[%s]", ffj.rBI, str, Integer.valueOf(i2), Util.getStack());
        AppMethodBeat.o(150966);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 729;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(150967);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iFd, this);
        AppMethodBeat.o(150967);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(150968);
        ffj ffj = (ffj) this.iFd.iLK.iLR;
        ffk ffk = (ffk) this.iFd.iLL.iLR;
        Log.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s], ret[%d], sig[%s]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Integer.valueOf(ffk.NAG), ffk.NAH);
        if (i3 == 0 && i4 == 0) {
            if (ffk.NAG == 2 || ffk.NAG == 3) {
                this.retryCount--;
                if (this.retryCount <= 0) {
                    Log.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken err and return with no try!");
                    h.INSTANCE.idkeyStat(322, 2, 1, false);
                    h.INSTANCE.a(11098, 4002, String.format("%s,%d", ffj.NAF, Integer.valueOf(ffj.xIL)));
                    this.callback.onSceneEnd(3, -1, "", this);
                    AppMethodBeat.o(150968);
                    return;
                }
                Log.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken do scene again retryCount:%d", Integer.valueOf(this.retryCount));
                doScene(dispatcher(), this.callback);
            } else if (ffk.NAG == 1) {
                MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.aps()).edit().remove(ffj.NAF).commit();
                h.INSTANCE.idkeyStat(322, 5, 1, false);
                h.INSTANCE.a(11098, Integer.valueOf((int) WearableStatusCodes.ASSET_UNAVAILABLE), String.format("%s,%d", ffj.NAF, Integer.valueOf(ffj.xIL)));
                Log.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no sig[%s] and remove", ffk.NAH);
            } else if (ffk.NAG == 4) {
                Log.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no need try and revise");
                h.INSTANCE.idkeyStat(322, 4, 1, false);
                h.INSTANCE.a(11098, Integer.valueOf((int) WearableStatusCodes.INVALID_TARGET_NODE), String.format("%s,%d", ffj.NAF, Integer.valueOf(ffj.xIL)));
            } else {
                Log.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret sig[%s]", ffk.NAH);
                MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.aps()).edit().putString(ffj.NAF, ffk.NAH).commit();
                h.INSTANCE.idkeyStat(322, 3, 1, false);
                h.INSTANCE.a(11098, Integer.valueOf((int) WearableStatusCodes.DATA_ITEM_TOO_LARGE), String.format("%s,%d,%s", ffj.NAF, Integer.valueOf(ffj.xIL), ffk.NAH));
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(150968);
            return;
        }
        Log.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig err and return!");
        h.INSTANCE.idkeyStat(322, 1, 1, false);
        h.INSTANCE.a(11098, 4001, String.format("%s,%d,%d,%d", ffj.NAF, Integer.valueOf(ffj.xIL), Integer.valueOf(i3), Integer.valueOf(i4)));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(150968);
    }
}
