package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.t.a.e;
import com.tencent.mm.t.a.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0002\u0010\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/cgi/GetInteractionMaterialCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/eggspring/model/GetInteractionMaterialResp;", "keyword", "", "uxinfo", "source", "", "traceId", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "plugin-eggspring_release"})
public final class c extends com.tencent.mm.ak.c<f> {
    public c(String str, String str2, String str3) {
        p.h(str, "keyword");
        p.h(str2, "uxinfo");
        p.h(str3, "traceId");
        AppMethodBeat.i(194566);
        e eVar = new e();
        eVar.dDv = str;
        eVar.gTk = str2;
        eVar.source = 0;
        eVar.gTl = str3;
        d.a aVar = new d.a();
        aVar.c(eVar);
        aVar.d(new f());
        aVar.sI(0);
        aVar.sJ(0);
        aVar.MB("/cgi-bin/mmoc-bin/interaction/get_interaction_material");
        aVar.sG(4310);
        c(aVar.aXF());
        AppMethodBeat.o(194566);
    }
}
