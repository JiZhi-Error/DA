package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\n¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "hasShowLongVideoGuide", "", "getHasShowLongVideoGuide", "()Z", "setHasShowLongVideoGuide", "(Z)V", "isShowFullscreen", "setShowFullscreen", "videoHasCompleted", "getVideoHasCompleted", "setVideoHasCompleted", "plugin-finder_release"})
public final class ad extends BaseFinderFeed {
    public boolean uOp;
    public boolean uOq;
    public boolean uOr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ad(FinderItem finderItem) {
        super(finderItem);
        p.h(finderItem, "feedObject");
        AppMethodBeat.i(166389);
        AppMethodBeat.o(166389);
    }
}
