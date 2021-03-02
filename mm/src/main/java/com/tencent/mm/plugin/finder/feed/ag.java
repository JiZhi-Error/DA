package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.bcu;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0016H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020#H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0010\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/model/IFeedSessionBuffer;", "card", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "layoutType", "", "rvFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;ILjava/util/LinkedList;)V", "getCard", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "setCard", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;)V", "getLayoutType", "()I", "position", "getPosition", "setPosition", "(I)V", "recTimeMs", "", "getRecTimeMs", "()J", "setRecTimeMs", "(J)V", "getRvFeedList", "()Ljava/util/LinkedList;", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "getSessionBuffer", "", "plugin-finder_release"})
public final class ag implements bo {
    public int position = -1;
    public final LinkedList<BaseFinderFeed> rvFeedList;
    public long tQP = cl.aWA();
    public bcu tQQ;
    private final int tQR;

    public ag(bcu bcu, int i2, LinkedList<BaseFinderFeed> linkedList) {
        p.h(bcu, "card");
        p.h(linkedList, "rvFeedList");
        AppMethodBeat.i(244172);
        this.tQQ = bcu;
        this.tQR = i2;
        this.rvFeedList = linkedList;
        AppMethodBeat.o(244172);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        return this.tQQ.id;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        switch (this.tQR) {
            case 0:
                return 2010;
            case 1:
            default:
                return 0;
            case 2:
                return 2013;
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        AppMethodBeat.i(244171);
        p.h(iVar, "obj");
        if ((iVar instanceof bcu) && ((bcu) iVar).uOx == this.tQQ.uOx && ((bcu) iVar).tQR == this.tQQ.tQR) {
            AppMethodBeat.o(244171);
            return 0;
        }
        AppMethodBeat.o(244171);
        return -1;
    }
}
