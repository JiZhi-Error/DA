package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k;
import com.tencent.mm.protocal.protobuf.bcf;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0001H\u0016J>\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J&\u0010\u0017\u001a\u00020\u000b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00192\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderAlbum;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareAlbum", "Lcom/tencent/mm/protocal/protobuf/FinderShareAlbum;", "getShareAlbum", "()Lcom/tencent/mm/protocal/protobuf/FinderShareAlbum;", "setShareAlbum", "(Lcom/tencent/mm/protocal/protobuf/FinderShareAlbum;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class d extends f {
    public bcf jle = new bcf();

    public d() {
        AppMethodBeat.i(208771);
        AppMethodBeat.o(208771);
    }

    public final bcf dJw() {
        return this.jle;
    }

    @Override // com.tencent.mm.ag.f
    public final f aHj() {
        AppMethodBeat.i(208768);
        d dVar = new d();
        dVar.jle = this.jle;
        d dVar2 = dVar;
        AppMethodBeat.o(208768);
        return dVar2;
    }

    @Override // com.tencent.mm.ag.f
    public final void a(StringBuilder sb, k.b bVar, String str, com.tencent.mm.i.d dVar, int i2, int i3) {
        AppMethodBeat.i(208769);
        p.h(sb, "sb");
        sb.append(l.a(this.jle));
        AppMethodBeat.o(208769);
    }

    @Override // com.tencent.mm.ag.f
    public final void a(Map<String, String> map, k.b bVar) {
        AppMethodBeat.i(208770);
        p.h(map, "values");
        bcf A = l.A(".msg.appmsg", map);
        p.g(A, "FinderShareParser.parseF…um(\".msg.appmsg\", values)");
        this.jle = A;
        AppMethodBeat.o(208770);
    }
}
