package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.abs;
import com.tencent.mm.protocal.protobuf.abt;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class i extends q implements m {
    private List<String> GjL;
    private List<Integer> GjM;
    private com.tencent.mm.ak.i callback;
    public int jgF = 0;
    public d rr;
    private long uOV;

    public i(i iVar) {
        AppMethodBeat.i(91020);
        Log.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "copy NetSceneTopStorySetBlockList", Integer.valueOf(iVar.GjL.size()), Integer.valueOf(iVar.GjM.size()));
        this.jgF = iVar.jgF;
        x(iVar.GjL, iVar.GjM);
        AppMethodBeat.o(91020);
    }

    public i(List<String> list, List<Integer> list2) {
        AppMethodBeat.i(91021);
        Log.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "create NetSceneTopStorySetBlockList, users size:%s, type size:%s", Integer.valueOf(list.size()), Integer.valueOf(list2.size()));
        x(list, list2);
        AppMethodBeat.o(91021);
    }

    private void x(List<String> list, List<Integer> list2) {
        AppMethodBeat.i(91022);
        this.uOV = System.currentTimeMillis();
        this.GjL = list;
        this.GjM = list2;
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmsearch-bin/colikeblock";
        aVar.iLN = new abs();
        aVar.iLO = new abu();
        this.rr = aVar.aXF();
        abs abs = (abs) this.rr.iLK.iLR;
        for (int i2 = 0; i2 < list.size(); i2++) {
            abt abt = new abt();
            abt.dDH = list2.get(i2).intValue();
            abt.Username = list.get(i2);
            abs.KKx.add(abt);
        }
        AppMethodBeat.o(91022);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2859;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(91023);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(91023);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(91024);
        Log.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Long.valueOf(System.currentTimeMillis() - this.uOV));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(91024);
    }
}
