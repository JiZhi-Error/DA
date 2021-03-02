package com.tencent.mm.plugin.textstatus.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/like/LikeItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "likeInfo", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;)V", "getLikeInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;", "getItemId", "", "getItemType", "", "plugin-textstatus_release"})
public final class b implements a {
    public final com.tencent.mm.plugin.textstatus.f.f.b FZy;

    public b(com.tencent.mm.plugin.textstatus.f.f.b bVar) {
        p.h(bVar, "likeInfo");
        AppMethodBeat.i(216236);
        this.FZy = bVar;
        AppMethodBeat.o(216236);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(216235);
        long hashCode = (long) hashCode();
        AppMethodBeat.o(216235);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return 1;
    }
}
