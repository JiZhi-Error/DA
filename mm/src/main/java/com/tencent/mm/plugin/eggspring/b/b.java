package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.t.a.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/cgi/GetInteractionADCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/eggspring/model/GetInteractionADResp;", "keyword", "", "uxinfo", "source", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "plugin-eggspring_release"})
public final class b extends c<d> {
    public b(String str, String str2) {
        p.h(str, "keyword");
        p.h(str2, "uxinfo");
        AppMethodBeat.i(194565);
        com.tencent.mm.t.a.c cVar = new com.tencent.mm.t.a.c();
        cVar.dDv = str;
        cVar.gTk = str2;
        cVar.source = 1;
        d.a aVar = new d.a();
        aVar.c(cVar);
        com.tencent.mm.t.a.d dVar = new com.tencent.mm.t.a.d();
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.ErrMsg = new dqi();
        dVar.setBaseResponse(baseResponse);
        aVar.d(dVar);
        aVar.sI(0);
        aVar.sJ(0);
        aVar.MB("/cgi-bin/mmoc-bin/interaction/get_interaction_ad");
        aVar.sG(4947);
        c(aVar.aXF());
        AppMethodBeat.o(194565);
    }
}
