package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.bds;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderTopicInfoFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "getTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class bl implements bo {
    public final bds dMU;
    public boolean uOQ;

    public bl(bds bds) {
        p.h(bds, "topicInfo");
        AppMethodBeat.i(248852);
        this.dMU = bds;
        AppMethodBeat.o(248852);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        return this.dMU.twp;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        AppMethodBeat.i(248851);
        p.h(iVar, "obj");
        if (!(iVar instanceof bl) || ((bl) iVar).dMU.twp != this.dMU.twp) {
            AppMethodBeat.o(248851);
            return -1;
        }
        AppMethodBeat.o(248851);
        return 0;
    }
}
