package com.tencent.mm.plugin.finder.event.base;

import com.tencent.mm.plugin.finder.storage.FeedData;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/event/base/TabChangeEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "focusTabType", "", "(I)V", "centerFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getCenterFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setCenterFeed", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "getFocusTabType", "()I", "plugin-finder_release"})
public final class k extends b {
    public FeedData tIF;
    private final int tIK;

    public k(int i2) {
        this.tIK = i2;
    }
}
