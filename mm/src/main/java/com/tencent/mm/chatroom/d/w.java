package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.emu;
import com.tencent.mm.protocal.protobuf.emv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class w extends q implements m {
    private i callback;
    public String dOe;
    private String errMsg;
    public emv gsu;
    private final d rr;

    public w(String str, String str2, int i2) {
        AppMethodBeat.i(194032);
        Log.i("MicroMsg.NetSceneUpgradeAssociateChatRoom", "NetSceneUpgradeAssociateChatRoom roomname:%s", Util.nullAs(str, ""));
        d.a aVar = new d.a();
        aVar.uri = "/cgi-bin/micromsg-bin/upgradeassociatechatroom";
        aVar.funcId = 3927;
        aVar.iLN = new emu();
        aVar.iLO = new emv();
        this.rr = aVar.aXF();
        this.dOe = str;
        emu emu = (emu) this.rr.iLK.iLR;
        emu.dOe = str;
        emu.dHx = str2;
        emu.scene = i2;
        AppMethodBeat.o(194032);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3927;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(182095);
        this.callback = iVar;
        this.gsu = (emv) this.rr.iLL.iLR;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(182095);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(182096);
        Log.d("MicroMsg.NetSceneUpgradeAssociateChatRoom", "onGYNetEnd:[%d,%d,%s]", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        this.errMsg = str;
        AppMethodBeat.o(182096);
    }
}
