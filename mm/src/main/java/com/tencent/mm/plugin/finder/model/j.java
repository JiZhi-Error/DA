package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.view.recyclerview.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "tags", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getTags", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTags", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class j extends g.b implements i {
    public dmk uNS;

    public j(dmk dmk) {
        p.h(dmk, "tags");
        AppMethodBeat.i(248714);
        this.uNS = dmk;
        AppMethodBeat.o(248714);
    }

    public final void a(dmk dmk) {
        AppMethodBeat.i(248713);
        p.h(dmk, "<set-?>");
        this.uNS = dmk;
        AppMethodBeat.o(248713);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(261248);
        long hashCode = (long) hashCode();
        AppMethodBeat.o(261248);
        return hashCode;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        AppMethodBeat.i(248712);
        p.h(iVar, "obj");
        AppMethodBeat.o(248712);
        return 2147483646;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return -6;
    }
}
