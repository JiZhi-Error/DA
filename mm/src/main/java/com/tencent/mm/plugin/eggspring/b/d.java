package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.t.a.n;
import com.tencent.mm.t.a.o;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/cgi/GetMoneyCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/eggspring/model/OpenMoneyResp;", "uxInfo", "", "source", "", "materialId", "", "traceId", "(Ljava/lang/String;IJLjava/lang/String;)V", "plugin-eggspring_release"})
public final class d extends c<o> {
    public d(String str, long j2, String str2) {
        p.h(str, "uxInfo");
        p.h(str2, "traceId");
        AppMethodBeat.i(194567);
        n nVar = new n();
        nVar.gTk = str;
        nVar.source = 1;
        nVar.gTC = j2;
        nVar.gTl = str2;
        d.a aVar = new d.a();
        aVar.c(nVar);
        aVar.d(new o());
        aVar.sI(0);
        aVar.sJ(0);
        aVar.sG(4919);
        aVar.MB("/cgi-bin/mmoc-bin/interaction/open_money ");
        c(aVar.aXF());
        AppMethodBeat.o(194567);
    }
}
