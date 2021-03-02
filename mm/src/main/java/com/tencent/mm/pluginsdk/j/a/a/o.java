package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.zi;
import com.tencent.mm.protocal.q;

public final class o extends n {
    public static void cjR() {
        AppMethodBeat.i(152004);
        g.aAg().hqi.a(new o(), 0);
        AppMethodBeat.o(152004);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.pluginsdk.j.a.a.n
    public final String getTag() {
        return "MicroMsg.NetSceneEncryptCheckResUpdate";
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.pluginsdk.j.a.a.n
    public final zi h(s sVar) {
        return ((a) sVar).JZH.KzT;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return f.KyZ ? 784 : 722;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.pluginsdk.j.a.a.n
    public final s gnS() {
        AppMethodBeat.i(152005);
        a aVar = new a();
        q.a aVar2 = (q.a) aVar.getReqObjImp();
        aVar2.setUin(0);
        aVar2.KzQ.LsX.LsV.LkB.addAll(this.JZC);
        AppMethodBeat.o(152005);
        return aVar;
    }

    static class a extends com.tencent.mm.ak.o {
        private final q.a JZG = new q.a();
        final q.b JZH = new q.b();

        public a() {
            AppMethodBeat.i(152003);
            AppMethodBeat.o(152003);
        }

        @Override // com.tencent.mm.ak.o
        public final l.d getReqObjImp() {
            return this.JZG;
        }

        @Override // com.tencent.mm.network.s
        public final int getType() {
            return f.KyZ ? 784 : 722;
        }

        @Override // com.tencent.mm.network.s
        public final String getUri() {
            return f.KyZ ? "/cgi-bin/micromsg-bin/secencryptcheckresupdate" : "/cgi-bin/micromsg-bin/encryptcheckresupdate";
        }

        @Override // com.tencent.mm.network.s
        public final l.e getRespObj() {
            return this.JZH;
        }

        @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
        public final int getOptions() {
            return 1;
        }
    }
}
