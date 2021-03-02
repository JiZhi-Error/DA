package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.axf;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0001H\u0016JB\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\rj\u0002`\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J$\u0010\u0018\u001a\u00020\u000b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001a2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/findersdk/api/AppMSgContentFinderLiveObject;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "getShareObject", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "setShareObject", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class b extends f {
    public axf wDV = new axf();

    public b() {
        AppMethodBeat.i(208762);
        AppMethodBeat.o(208762);
    }

    public final void b(axf axf) {
        AppMethodBeat.i(208758);
        p.h(axf, "<set-?>");
        this.wDV = axf;
        AppMethodBeat.o(208758);
    }

    public final axf dJu() {
        return this.wDV;
    }

    @Override // com.tencent.mm.ag.f
    public final f aHj() {
        AppMethodBeat.i(208759);
        b bVar = new b();
        bVar.wDV = this.wDV;
        b bVar2 = bVar;
        AppMethodBeat.o(208759);
        return bVar2;
    }

    @Override // com.tencent.mm.ag.f
    public final void a(StringBuilder sb, k.b bVar, String str, d dVar, int i2, int i3) {
        AppMethodBeat.i(208760);
        p.h(sb, "sb");
        sb.append(l.c(this.wDV));
        AppMethodBeat.o(208760);
    }

    @Override // com.tencent.mm.ag.f
    public final void a(Map<String, String> map, k.b bVar) {
        AppMethodBeat.i(208761);
        p.h(map, "values");
        p.h(bVar, "content");
        axf v = l.v(".msg.appmsg", map);
        p.g(v, "FinderShareParser.parseF…ve(\".msg.appmsg\", values)");
        this.wDV = v;
        AppMethodBeat.o(208761);
    }
}
