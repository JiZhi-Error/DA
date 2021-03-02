package com.tencent.mm.plugin.textstatus.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.g.u;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/like/LikeHistoryItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "statusId", "", "likeInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLiked;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLiked;)V", "getLikeInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLiked;", "getStatusId", "()Ljava/lang/String;", "getItemId", "", "getItemType", "", "plugin-textstatus_release"})
public final class a implements com.tencent.mm.view.recyclerview.a {
    private final String FYf;
    public final u FZx;

    public a(String str, u uVar) {
        p.h(str, "statusId");
        p.h(uVar, "likeInfo");
        AppMethodBeat.i(216234);
        this.FYf = str;
        this.FZx = uVar;
        AppMethodBeat.o(216234);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(216233);
        long hashCode = (long) hashCode();
        AppMethodBeat.o(216233);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return 0;
    }
}
