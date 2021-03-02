package com.tencent.mm.plugin.scanner.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.pb;
import com.tencent.mm.protocal.protobuf.pc;

public final class a extends q implements m {
    private i callback;
    public String dRM;
    public d rr;

    public a(String str, byte[] bArr, int i2) {
        AppMethodBeat.i(118333);
        this.dRM = str;
        d.a aVar = new d.a();
        aVar.funcId = getType();
        pb pbVar = new pb();
        pbVar.KRc = new b(bArr);
        pbVar.KRf = str;
        pbVar.KVV = 3;
        pbVar.source = 101;
        pbVar.KND = i2;
        aVar.iLN = pbVar;
        aVar.uri = "/cgi-bin/mmpay-bin/ocrgetbankcardinfo";
        aVar.iLO = new pc();
        this.rr = aVar.aXF();
        AppMethodBeat.o(118333);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(118334);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(118334);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2693;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(118335);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(118335);
        return dispatch;
    }
}
