package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.lz;
import com.tencent.mm.protocal.protobuf.ma;
import com.tencent.mm.sdk.platformtools.Log;

public final class x extends q implements m {
    public static int keX = 0;
    public static int keY = 1;
    public static int keZ = -85;
    private i callback;
    private int kfa = -1;
    private String kfb;
    private int kfc = 0;
    private final d rr;

    public enum a {
        MM_BIND_GCONTACT_OPCODE_BIND,
        MM_BIND_GCONTACT_OPCODE_UNBIND;

        public static a valueOf(String str) {
            AppMethodBeat.i(131084);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(131084);
            return aVar;
        }

        static {
            AppMethodBeat.i(131085);
            AppMethodBeat.o(131085);
        }
    }

    public x(a aVar, String str, int i2) {
        AppMethodBeat.i(131086);
        switch (aVar) {
            case MM_BIND_GCONTACT_OPCODE_BIND:
                this.kfa = 1;
                break;
            case MM_BIND_GCONTACT_OPCODE_UNBIND:
                this.kfa = 2;
                break;
        }
        this.kfb = str;
        this.kfc = i2;
        d.a aVar2 = new d.a();
        aVar2.iLN = new lz();
        aVar2.iLO = new ma();
        aVar2.uri = "/cgi-bin/micromsg-bin/bindgooglecontact";
        aVar2.funcId = 487;
        aVar2.iLP = 0;
        aVar2.respCmdId = 0;
        this.rr = aVar2.aXF();
        AppMethodBeat.o(131086);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(131087);
        Log.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
        this.callback = iVar;
        lz lzVar = (lz) this.rr.iLK.iLR;
        lzVar.KMz = this.kfa;
        lzVar.KPA = this.kfb;
        lzVar.KPB = this.kfc;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(131087);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(131088);
        Log.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(131088);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 487;
    }
}
