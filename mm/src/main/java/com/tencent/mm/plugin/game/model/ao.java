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
import com.tencent.mm.plugin.game.protobuf.br;
import com.tencent.mm.plugin.game.protobuf.bs;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class ao extends q implements m {
    private i callback;
    public final d hhm;

    public ao(String str, LinkedList<String> linkedList, o oVar, o oVar2, o oVar3, boolean z) {
        String str2;
        AppMethodBeat.i(41604);
        Log.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "lang = " + str + ", installedApp list size: " + linkedList.size());
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            Log.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "install id:[%s]", it.next());
        }
        br brVar = new br();
        brVar.xLl = str;
        brVar.xLF = linkedList;
        String gf = e.gf(MMApplicationContext.getContext());
        gf = Util.isNullOrNil(gf) ? Util.getSimCountryCode(MMApplicationContext.getContext()) : gf;
        if (!Util.isNullOrNil(j.countryCode)) {
            str2 = j.countryCode;
        } else {
            str2 = gf;
        }
        brVar.keh = str2;
        if (oVar == null) {
            if (oVar2 != null) {
                oVar = oVar2;
            } else if (oVar3 != null) {
                oVar = oVar3;
            } else {
                oVar = null;
            }
        }
        brVar.xLG = new ac();
        if (oVar != null) {
            brVar.xLG.xJZ = oVar.xFg.xGi;
            brVar.xLG.jfi = oVar.field_appId;
            brVar.xLG.xIG = oVar.xFW;
            brVar.xLG.xKb = oVar.xFV;
        }
        if (oVar2 != null) {
            brVar.xLG.xKa |= 1;
        }
        if (oVar3 != null) {
            brVar.xLG.xKa |= 2;
        }
        brVar.xLH = ((f) g.af(f.class)).dSK().dVz();
        brVar.xLI = z;
        brVar.xLm = ChannelUtil.isGPVersion() ? 1 : 0;
        Log.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "Country Code: %s", str2);
        d.a aVar = new d.a();
        aVar.iLN = brVar;
        aVar.iLO = new bs();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindexdownloadguidance";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hhm = aVar.aXF();
        AppMethodBeat.o(41604);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2586;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(41605);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hhm, this);
        AppMethodBeat.o(41605);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(41606);
        Log.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "errType = " + i3 + ", errCode = " + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(41606);
    }
}
