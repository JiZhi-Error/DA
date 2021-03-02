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
import com.tencent.mm.plugin.game.protobuf.bn;
import com.tencent.mm.plugin.game.protobuf.bo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import java.util.Iterator;
import java.util.LinkedList;

public final class an extends q implements m {
    private i callback;
    public final d hhm;

    public an(String str, LinkedList<String> linkedList, o oVar, o oVar2, o oVar3, boolean z) {
        String str2;
        AppMethodBeat.i(41601);
        Log.i("MicroMsg.NetSceneGetGameIndex4", "lang = " + str + ", installedApp list size: " + linkedList.size());
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            Log.i("MicroMsg.NetSceneGetGameIndex4", "install id:[%s]", it.next());
        }
        d.a aVar = new d.a();
        aVar.iLN = new bn();
        aVar.iLO = new bo();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindex4";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hhm = aVar.aXF();
        bn bnVar = (bn) this.hhm.iLK.iLR;
        bnVar.xLl = str;
        bnVar.xLF = linkedList;
        String gf = e.gf(MMApplicationContext.getContext());
        gf = Util.isNullOrNil(gf) ? Util.getSimCountryCode(MMApplicationContext.getContext()) : gf;
        if (!Util.isNullOrNil(j.countryCode)) {
            str2 = j.countryCode;
        } else {
            str2 = gf;
        }
        bnVar.keh = str2;
        if (oVar == null) {
            if (oVar2 != null) {
                oVar = oVar2;
            } else if (oVar3 != null) {
                oVar = oVar3;
            } else {
                oVar = null;
            }
        }
        bnVar.xLG = new ac();
        if (oVar != null) {
            bnVar.xLG.xJZ = oVar.xFg.xGi;
            bnVar.xLG.jfi = oVar.field_appId;
            bnVar.xLG.xIG = oVar.xFW;
            bnVar.xLG.xKb = oVar.xFV;
        }
        if (oVar2 != null) {
            bnVar.xLG.xKa |= 1;
        }
        if (oVar3 != null) {
            bnVar.xLG.xKa |= 2;
        }
        bnVar.xLH = ((f) g.af(f.class)).dSK().dVz();
        bnVar.xLI = z;
        bnVar.xLm = ChannelUtil.isGPVersion() ? 1 : 0;
        Log.i("MicroMsg.NetSceneGetGameIndex4", "Country Code: %s", str2);
        if (!Util.isNullOrNil(bnVar.keh) && !WeChatBrands.AppInfo.LANG_CN.equalsIgnoreCase(bnVar.keh)) {
            h.INSTANCE.idkeyStat(860, 7, 1, false);
        }
        AppMethodBeat.o(41601);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(41602);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hhm, this);
        AppMethodBeat.o(41602);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(41603);
        Log.i("MicroMsg.NetSceneGetGameIndex4", "errType = " + i3 + ", errCode = " + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(41603);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2994;
    }
}
