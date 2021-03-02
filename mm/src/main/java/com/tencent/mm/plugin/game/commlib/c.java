package com.tencent.mm.plugin.game.commlib;

import android.os.Build;
import com.facebook.device.yearclass.YearClass;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.bi;
import com.tencent.mm.plugin.game.protobuf.f;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class c extends q implements m {
    private i callback;
    private final d hhm;

    public c(int i2) {
        AppMethodBeat.i(201264);
        d.a aVar = new d.a();
        aVar.iLN = new bi();
        aVar.iLO = new GetGameCenterGlobalSettingResponse();
        aVar.uri = "/cgi-bin/mmgame-bin/getgamecenterglobalsetting";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hhm = aVar.aXF();
        bi biVar = (bi) this.hhm.iLK.iLR;
        biVar.xLl = LocaleUtil.getApplicationLanguage();
        String dSF = b.a.dSQ().dSF();
        biVar.keh = Util.isNullOrNil(dSF) ? Util.getSimCountryCode(MMApplicationContext.getContext()) : dSF;
        biVar.xLm = ChannelUtil.channelId;
        biVar.xLn = new f();
        biVar.xLn.xIH = Build.VERSION.SDK_INT;
        biVar.xLn.xII = YearClass.get(MMApplicationContext.getContext());
        biVar.Scene = i2;
        Log.i("MicroMsg.NetSceneGetGameGlobalConfig", "lang=%s, country=%s, releaseChannel=%s, osVersion = %d, deviceLevel = %d, scene:%d", biVar.xLl, biVar.keh, Integer.valueOf(biVar.xLm), Integer.valueOf(biVar.xLn.xIH), Integer.valueOf(biVar.xLn.xII), Integer.valueOf(i2));
        AppMethodBeat.o(201264);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00bf A[SYNTHETIC, Splitter:B:24:0x00bf] */
    @Override // com.tencent.mm.network.m
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onGYNetEnd(int r8, int r9, int r10, java.lang.String r11, com.tencent.mm.network.s r12, byte[] r13) {
        /*
        // Method dump skipped, instructions count: 243
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.commlib.c.onGYNetEnd(int, int, int, java.lang.String, com.tencent.mm.network.s, byte[]):void");
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1311;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(89936);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hhm, this);
        AppMethodBeat.o(89936);
        return dispatch;
    }
}
