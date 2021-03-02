package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.axf;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/modelsns/SnsFinderShareLive;", "Lcom/tencent/mm/modelsns/SnsTimeLineObjectPiece;", "()V", "shareLive", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "getShareLive", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "setShareLive", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;)V", "makeContent", "", "parseContent", "", "tagPrefix", "values", "", "plugin-sns_release"})
public final class d implements j {
    public axf jlf = new axf();

    public d() {
        AppMethodBeat.i(201801);
        AppMethodBeat.o(201801);
    }

    public final void a(axf axf) {
        AppMethodBeat.i(201798);
        p.h(axf, "<set-?>");
        this.jlf = axf;
        AppMethodBeat.o(201798);
    }

    @Override // com.tencent.mm.modelsns.j
    public final String bfF() {
        AppMethodBeat.i(201799);
        String c2 = com.tencent.mm.plugin.i.a.l.c(this.jlf);
        p.g(c2, "FinderShareParser.makeContent(shareLive)");
        AppMethodBeat.o(201799);
        return c2;
    }

    public final void j(String str, Map<String, String> map) {
        AppMethodBeat.i(201800);
        axf v = com.tencent.mm.plugin.i.a.l.v(str, map);
        p.g(v, "FinderShareParser.parseF…erLive(tagPrefix, values)");
        this.jlf = v;
        AppMethodBeat.o(201800);
    }
}
