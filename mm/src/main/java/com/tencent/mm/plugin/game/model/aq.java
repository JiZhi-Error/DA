package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.protobuf.bv;
import com.tencent.mm.plugin.game.protobuf.bw;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class aq extends q implements m {
    private i callback;
    public final d hhm;

    public aq(int i2, LinkedList<String> linkedList, int i3, boolean z) {
        AppMethodBeat.i(41610);
        d.a aVar = new d.a();
        aVar.iLN = new bv();
        aVar.iLO = new bw();
        aVar.uri = "/cgi-bin/mmgame-bin/newgetlibgamelist";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hhm = aVar.aXF();
        bv bvVar = (bv) this.hhm.iLK.iLR;
        bvVar.xLV = i2;
        bvVar.xLW = 15;
        bvVar.xLl = LocaleUtil.getApplicationLanguage();
        bvVar.keh = Util.getSimCountryCode(MMApplicationContext.getContext());
        bvVar.xLX = i3;
        bvVar.xLF = linkedList;
        bvVar.xLY = z;
        AppMethodBeat.o(41610);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(41611);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hhm, this);
        AppMethodBeat.o(41611);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(41612);
        Log.i("MicroMsg.NetSceneGetLibGameList", "errType = " + i3 + ", errCode = " + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(41612);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1218;
    }
}
