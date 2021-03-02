package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.co.f;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;

public abstract class a<Req extends dop, Resp extends dpc> {
    private c yPq;
    Req yPr;
    private Resp yPs;

    /* access modifiers changed from: protected */
    public abstract Resp eeC();

    /* access modifiers changed from: protected */
    public abstract int getFuncId();

    /* access modifiers changed from: protected */
    public abstract String getUri();

    public final <T> f<T> b(com.tencent.mm.vending.c.a<T, c.a<Resp>> aVar) {
        boolean z = true;
        eeD();
        this.yPs = eeC();
        this.yPq = new c();
        c cVar = this.yPq;
        Req req = this.yPr;
        Resp resp = this.yPs;
        if (req == null || resp == null) {
            StringBuilder append = new StringBuilder("CgiBase called withoud req or resp req?[").append(req == null).append("] resp?[");
            if (resp != null) {
                z = false;
            }
            throw new IllegalStateException(append.append(z).append("]").toString());
        }
        d.a aVar2 = new d.a();
        aVar2.funcId = getFuncId();
        aVar2.uri = getUri();
        aVar2.iLN = req;
        aVar2.iLO = resp;
        cVar.c(aVar2.aXF());
        return this.yPq.aYI().g(new com.tencent.mm.vending.c.a<c.a<Resp>, c.a<Resp>>() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.a.a.AnonymousClass1 */

            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(64870);
                c.a aVar = (c.a) obj;
                a.this.eeE();
                AppMethodBeat.o(64870);
                return aVar;
            }
        }).b(aVar);
    }

    /* access modifiers changed from: protected */
    public void eeD() {
    }

    /* access modifiers changed from: protected */
    public void eeE() {
    }
}
