package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.o;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import junit.framework.Assert;

public final class j extends q implements m {
    private i callback;
    public byte[] content;
    private s iMO;
    public String jje = "";

    public j(List<String> list, byte[] bArr) {
        boolean z = true;
        AppMethodBeat.i(20613);
        Assert.assertTrue(list.size() > 0 && bArr != null);
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        String str = list.get(0);
        for (int i2 = 1; i2 < list.size(); i2++) {
            str = str + "," + list.get(i2).trim();
        }
        this.iMO = new a();
        p.a aVar = (p.a) this.iMO.getReqObj();
        aVar.dKy = 111;
        aVar.cSx = 0;
        aVar.jlm = currentTimeMillis;
        Assert.assertTrue(str != null);
        aVar.KzO = str;
        Assert.assertTrue(bArr == null ? false : z);
        aVar.KzP = bArr;
        Log.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: cmdId=111 seq=" + currentTimeMillis);
        Log.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: lstReceiver=" + str + " status = " + o.v(bArr, 0));
        AppMethodBeat.o(20613);
    }

    public j(l.e eVar) {
        AppMethodBeat.i(20614);
        p.b bVar = (p.b) eVar;
        this.jje = bVar.jje;
        this.content = bVar.content;
        AppMethodBeat.o(20614);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(20615);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iMO, this);
        AppMethodBeat.o(20615);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 10;
    }

    @Override // com.tencent.mm.ak.q
    public final boolean uniqueInNetsceneQueue() {
        return true;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20616);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20616);
    }

    public static class a extends com.tencent.mm.ak.o {
        private final p.a jjf = new p.a();
        private final p.b jjg = new p.b();

        public a() {
            AppMethodBeat.i(20612);
            AppMethodBeat.o(20612);
        }

        @Override // com.tencent.mm.ak.o
        public final l.d getReqObjImp() {
            return this.jjf;
        }

        @Override // com.tencent.mm.network.s
        public final l.e getRespObj() {
            return this.jjg;
        }

        @Override // com.tencent.mm.network.s
        public final int getType() {
            return 10;
        }

        @Override // com.tencent.mm.network.s
        public final String getUri() {
            return null;
        }
    }
}
