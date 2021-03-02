package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.nm;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class u extends q implements m {
    private i callback;
    private String goe;
    private a<u> iOQ;
    d rr;

    public interface a<T extends q> {
        void a(int i2, int i3, String str, T t);
    }

    public u(String str, String str2, a<u> aVar) {
        this(str, str2);
        this.iOQ = aVar;
    }

    private u(String str, String str2) {
        AppMethodBeat.i(124117);
        this.goe = str;
        Log.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] NetSceneBizAttrSync (%s)", str);
        d.a aVar = new d.a();
        aVar.funcId = 1075;
        aVar.uri = "/cgi-bin/mmbiz-bin/bizattr/bizattrsync";
        aVar.iLN = new nm();
        aVar.iLO = new nn();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        nm nmVar = (nm) this.rr.iLK.iLR;
        nmVar.KSV = this.goe;
        nmVar.KSW = new b(Util.decodeHexString(Util.nullAsNil(str2)));
        AppMethodBeat.o(124117);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124118);
        Log.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        if (this.iOQ != null) {
            this.iOQ.a(i3, i4, str, this);
        }
        AppMethodBeat.o(124118);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1075;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(124119);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124119);
        return dispatch;
    }
}
