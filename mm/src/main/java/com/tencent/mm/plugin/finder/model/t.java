package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderFeedCommentHeaderContent;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isContentCollapsed", "", "()Z", "setContentCollapsed", "(Z)V", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class t extends s implements i {
    public boolean isContentCollapsed = true;
    public final FinderItem tHo;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public t(com.tencent.mm.plugin.finder.storage.FinderItem r5) {
        /*
            r4 = this;
            java.lang.String r0 = "feed"
            kotlin.g.b.p.h(r5, r0)
            com.tencent.mm.plugin.finder.storage.an r0 = new com.tencent.mm.plugin.finder.storage.an
            r0.<init>()
            com.tencent.mm.protocal.protobuf.FinderCommentInfo r1 = r0.dyb()
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r1.displayid = r2
            r4.<init>(r0)
            r4.tHo = r5
            r0 = 1
            r4.isContentCollapsed = r0
            r0 = 248734(0x3cb9e, float:3.4855E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.model.t.<init>(com.tencent.mm.plugin.finder.storage.FinderItem):void");
    }

    @Override // com.tencent.mm.view.recyclerview.a, com.tencent.mm.plugin.finder.model.s
    public final long lT() {
        return this.tHo.field_id;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i, com.tencent.mm.plugin.finder.model.s
    public final int a(i iVar) {
        AppMethodBeat.i(248733);
        p.h(iVar, "obj");
        AppMethodBeat.o(248733);
        return 0;
    }

    @Override // com.tencent.mm.view.recyclerview.a, com.tencent.mm.plugin.finder.model.s
    public final int cxn() {
        return s.uOi;
    }
}
