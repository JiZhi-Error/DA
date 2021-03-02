package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.protobuf.ac;
import com.tencent.mm.plugin.game.protobuf.bt;
import com.tencent.mm.plugin.game.protobuf.bu;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import java.util.Iterator;
import java.util.LinkedList;

public final class ap extends q implements m {
    private i callback;
    public final d hhm;

    public ap(String str, LinkedList<String> linkedList, o oVar, o oVar2, o oVar3, boolean z) {
        String str2;
        AppMethodBeat.i(41607);
        Log.i("MicroMsg.NetSceneGetGameIndexForeign", "lang = " + str + ", installedApp list size: " + linkedList.size());
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            Log.i("MicroMsg.NetSceneGetGameIndexForeign", "install id:[%s]", it.next());
        }
        bt btVar = new bt();
        btVar.xLl = str;
        btVar.xLF = linkedList;
        String gf = e.gf(MMApplicationContext.getContext());
        gf = Util.isNullOrNil(gf) ? Util.getSimCountryCode(MMApplicationContext.getContext()) : gf;
        if (!Util.isNullOrNil(j.countryCode)) {
            str2 = j.countryCode;
        } else {
            str2 = gf;
        }
        btVar.keh = str2;
        if (oVar == null) {
            if (oVar2 != null) {
                oVar = oVar2;
            } else if (oVar3 != null) {
                oVar = oVar3;
            } else {
                oVar = null;
            }
        }
        btVar.xLG = new ac();
        if (oVar != null) {
            btVar.xLG.xJZ = oVar.xFg.xGi;
            btVar.xLG.jfi = oVar.field_appId;
            btVar.xLG.xIG = oVar.xFW;
            btVar.xLG.xKb = oVar.xFV;
        }
        if (oVar2 != null) {
            btVar.xLG.xKa |= 1;
        }
        if (oVar3 != null) {
            btVar.xLG.xKa |= 2;
        }
        btVar.xLH = ((f) g.af(f.class)).dSK().dVz();
        btVar.xLI = z;
        btVar.xLm = ChannelUtil.isGPVersion() ? 1 : 0;
        Log.i("MicroMsg.NetSceneGetGameIndexForeign", "Country Code: %s", str2);
        if (!Util.isNullOrNil(btVar.keh) && WeChatBrands.AppInfo.LANG_CN.equalsIgnoreCase(btVar.keh)) {
            h.INSTANCE.idkeyStat(860, 8, 1, false);
        }
        d.a aVar = new d.a();
        aVar.iLN = btVar;
        aVar.iLO = new bu();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindexforeign";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hhm = aVar.aXF();
        AppMethodBeat.o(41607);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2855;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(41608);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hhm, this);
        AppMethodBeat.o(41608);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(41609);
        Log.i("MicroMsg.NetSceneGetGameIndexForeign", "errType = " + i3 + ", errCode = " + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(41609);
    }
}
