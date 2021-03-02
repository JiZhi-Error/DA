package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.t.a.q;
import com.tencent.mm.t.a.r;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/cgi/GetEggRedEnvelopeCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/eggspring/model/GetRedpacketCoverRecvEntranceResp;", "()V", "plugin-eggspring_release"})
public final class e extends c<r> {
    public e() {
        AppMethodBeat.i(259482);
        q qVar = new q();
        d.a aVar = new d.a();
        aVar.c(qVar);
        aVar.d(new r());
        aVar.MB("/cgi-bin/micromsg-bin/getredpacketcoverrecventrance");
        aVar.sG(4074);
        c(aVar.aXF());
        AppMethodBeat.o(259482);
    }
}
