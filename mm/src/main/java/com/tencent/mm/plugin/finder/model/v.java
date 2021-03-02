package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.view.recyclerview.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0005¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "likeObj", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;)V", "blink", "", "getBlink", "()Z", "setBlink", "(Z)V", "hasBlink", "getHasBlink", "setHasBlink", "getLikeObj", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeObj", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class v implements i, a {
    public boolean uOb;
    public boolean uOc;
    public aul uOk;

    public v(aul aul) {
        p.h(aul, "likeObj");
        AppMethodBeat.i(248737);
        this.uOk = aul;
        AppMethodBeat.o(248737);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(248735);
        long hashCode = (long) Long.valueOf(this.uOk.tsR).hashCode();
        AppMethodBeat.o(248735);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        AppMethodBeat.i(248736);
        p.h(iVar, "obj");
        AppMethodBeat.o(248736);
        return 0;
    }
}
