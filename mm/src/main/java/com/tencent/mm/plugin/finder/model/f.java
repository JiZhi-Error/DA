package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.view.recyclerview.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FeedHeaderCommentFailedNotifyData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "feedId", "", "objectNonceId", "", "canRemove", "", "(JLjava/lang/String;I)V", "getCanRemove", "()I", "setCanRemove", "(I)V", "getFeedId", "()J", "getObjectNonceId", "()Ljava/lang/String;", "compare", "obj", "getItemId", "getItemType", "plugin-finder_release"})
public final class f extends g.b implements i {
    public final long feedId;
    public final String objectNonceId;
    public int uNO;

    private f(long j2, String str) {
        p.h(str, "objectNonceId");
        AppMethodBeat.i(166366);
        this.feedId = j2;
        this.objectNonceId = str;
        this.uNO = 0;
        AppMethodBeat.o(166366);
    }

    public /* synthetic */ f(long j2, String str, byte b2) {
        this(j2, str);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        AppMethodBeat.i(166364);
        p.h(iVar, "obj");
        AppMethodBeat.o(166364);
        return 0;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(261245);
        long hashCode = (long) hashCode();
        AppMethodBeat.o(261245);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return -4;
    }
}
