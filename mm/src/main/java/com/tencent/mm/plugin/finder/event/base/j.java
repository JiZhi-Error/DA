package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bo;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010#\u001a\u00020$H\u0016R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0004R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u000bR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/event/base/SingleFeedFlowScrollEvent;", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "type", "", "(I)V", "acrossFeedList", "", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "getAcrossFeedList", "()Ljava/util/List;", "setAcrossFeedList", "(Ljava/util/List;)V", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "()I", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "visibleFeedList", "getVisibleFeedList", "setVisibleFeedList", "visibleNotFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getVisibleNotFeedList", "()Ljava/util/LinkedList;", "setVisibleNotFeedList", "(Ljava/util/LinkedList;)V", "toString", "", "plugin-finder_release"})
public final class j extends h {
    public int ptb = -1;
    public int ptc = -1;
    public long tCi = -1;
    public List<g> tIH;
    public List<g> tII;
    public LinkedList<bo> tIJ;

    public j(int i2) {
        super(i2);
    }

    @Override // com.tencent.mm.plugin.finder.event.base.h
    public final String toString() {
        AppMethodBeat.i(243471);
        StringBuilder append = new StringBuilder("ScrollEvent(type=").append(this.type).append(", ").append(this.tIx).append(", ").append(this.tIy).append(", ").append(this.tIz).append(", ").append(this.tIA).append(", itemCount=").append(this.akb).append(", newState=").append(this.tIB).append(") idleAcrossFeedList=");
        List<g> list = this.tIH;
        String sb = append.append(list != null ? Integer.valueOf(list.size()) : null).toString();
        AppMethodBeat.o(243471);
        return sb;
    }
}
