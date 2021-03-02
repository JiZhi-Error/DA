package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k;
import com.tencent.mm.i.d;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bcl;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0001H\u0016JB\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\rj\u0002`\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J&\u0010\u0018\u001a\u00020\u000b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001a2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderActivity;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareTopic", "Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "getShareTopic", "()Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "setShareTopic", "(Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class c extends f {
    public bcl jld = new bcl();

    public c() {
        AppMethodBeat.i(208767);
        AppMethodBeat.o(208767);
    }

    public final void a(bcl bcl) {
        AppMethodBeat.i(208763);
        p.h(bcl, "<set-?>");
        this.jld = bcl;
        AppMethodBeat.o(208763);
    }

    public final bcl dJv() {
        return this.jld;
    }

    @Override // com.tencent.mm.ag.f
    public final f aHj() {
        AppMethodBeat.i(208764);
        c cVar = new c();
        cVar.jld = this.jld;
        c cVar2 = cVar;
        AppMethodBeat.o(208764);
        return cVar2;
    }

    @Override // com.tencent.mm.ag.f
    public final void a(StringBuilder sb, k.b bVar, String str, d dVar, int i2, int i3) {
        AppMethodBeat.i(208765);
        p.h(sb, "sb");
        if (l.d(bVar != null ? bVar.aSu() : null, bVar != null ? bVar.izD : 0) != 3) {
            AppMethodBeat.o(208765);
            return;
        }
        a ah = g.ah(aj.class);
        p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
        ac finderSwitchApi = ((aj) ah).getFinderSwitchApi();
        p.g(finderSwitchApi, "MMKernel.plugin(IPluginF…ass.java).finderSwitchApi");
        sb.append(l.bf(finderSwitchApi.dCw(), l.b(this.jld)));
        AppMethodBeat.o(208765);
    }

    @Override // com.tencent.mm.ag.f
    public final void a(Map<String, String> map, k.b bVar) {
        AppMethodBeat.i(208766);
        p.h(map, "values");
        bcl z = l.z(l.dJA(), map);
        p.g(z, "FinderShareParser.parseF…getOuterPrifix(), values)");
        this.jld = z;
        AppMethodBeat.o(208766);
    }
}
