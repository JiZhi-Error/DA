package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bre;
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.protocal.protobuf.cut;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class ae extends q implements m {
    private i callback;
    d hJu;
    int kfo;

    public ae(String str, int i2, String str2) {
        AppMethodBeat.i(184425);
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/micromsg-bin/getoldacctfriend";
        bre bre = new bre();
        this.kfo = i2;
        bre.LYG = i2;
        bre.UserName = str;
        bre.SessionId = str2;
        aVar.iLN = bre;
        aVar.iLO = new brf();
        this.hJu = aVar.aXF();
        Log.i("MicroMsg.NetSceneGetOldAccountFriend", "get old account friend %s, max seq %d, session %s", str, Integer.valueOf(i2), str2);
        AppMethodBeat.o(184425);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3513;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(184426);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(184426);
        return dispatch;
    }

    public final List<cut> boo() {
        return ((brf) this.hJu.iLL.iLR).LYH;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(184427);
        Log.i("MicroMsg.NetSceneGetOldAccountFriend", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0 && !boo().isEmpty()) {
            this.kfo = boo().get(boo().size() - 1).KXP;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(184427);
    }
}
