package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "removeIt", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "invoke"})
public final class FinderProfileFeedLoader$ProfileDataFetcher$mergeLocalData$1 extends q implements b<FinderItem, Boolean> {
    final /* synthetic */ List $nowList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderProfileFeedLoader$ProfileDataFetcher$mergeLocalData$1(List list) {
        super(1);
        this.$nowList = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ Boolean invoke(FinderItem finderItem) {
        AppMethodBeat.i(244785);
        Boolean valueOf = Boolean.valueOf(invoke(finderItem));
        AppMethodBeat.o(244785);
        return valueOf;
    }

    public final boolean invoke(FinderItem finderItem) {
        Object obj;
        boolean z;
        AppMethodBeat.i(244786);
        p.h(finderItem, "removeIt");
        Iterator it = this.$nowList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            Object next = it.next();
            FinderItem finderItem2 = (FinderItem) next;
            if (finderItem2.getLocalId() == finderItem.getLocalId() || ((finderItem2.field_id != 0 && finderItem2.field_id == finderItem.field_id) || finderItem2.getCreateTime() == finderItem.getCreateTime())) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                obj = next;
                break;
            }
        }
        if (((FinderItem) obj) != null) {
            AppMethodBeat.o(244786);
            return true;
        }
        AppMethodBeat.o(244786);
        return false;
    }
}
