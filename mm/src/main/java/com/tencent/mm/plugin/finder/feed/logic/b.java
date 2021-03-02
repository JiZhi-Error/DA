package com.tencent.mm.plugin.finder.feed.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.cjl;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/logic/FinderFeedTransformLogic;", "", "()V", "TAG", "", "checkTransformLongVideoToNormalVideoMedia", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "plugin-finder_release"})
public final class b {
    public static final b tUw = new b();

    static {
        AppMethodBeat.i(244538);
        AppMethodBeat.o(244538);
    }

    private b() {
    }

    public static LinkedList<cjl> b(FinderItem finderItem) {
        AppMethodBeat.i(244537);
        p.h(finderItem, "finderItem");
        if (!finderItem.isReplaceLongVideoToNormal() || finderItem.getMediaType() != 4 || !finderItem.isLongVideo()) {
            LinkedList<cjl> mediaList = finderItem.getMediaList();
            AppMethodBeat.o(244537);
            return mediaList;
        }
        LinkedList<cjl> longVideoMediaList = finderItem.getLongVideoMediaList();
        AppMethodBeat.o(244537);
        return longVideoMediaList;
    }
}
