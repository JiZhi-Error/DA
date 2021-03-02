package com.tencent.mm.plugin.finder.storage.data;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.feed.model.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.k;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0007J \u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\u0007J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0014\u001a\u00020\u0007J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010#\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0007J\u0016\u0010$\u001a\u00020\u00122\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010&J\u0016\u0010'\u001a\u00020\u00122\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010&J \u0010(\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0016\u0010*\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/FinderHotRelatedCache;", "", "()V", "TAG", "", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "prefetchCache", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "relatedFeedSet", "relatedPreloadFeedSet", "totalExposeList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "clear", "", "clearFetchRelatedFeed", "feedId", "clearPrefetchCache", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isCollectUnread", "", "source", "clearPrefetchRelatedFeed", "getHotRelatedFeed", "getPosTriggerConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "getPrefetchCache", "isCanFetch", "isCanPrefetch", "markFetchRelatedFeed", "markPrefetchRelatedFeed", "restoreTotalExposeMap", "map", "Landroid/util/LongSparseArray;", "saveTotalExposeMap", "setPrefetchCache", "info", "update", "feed", "plugin-finder_release"})
public final class h {
    private static final ConcurrentHashMap<Long, FinderItem> cache = new ConcurrentHashMap<>();
    private static final LinkedList<k> vGg = new LinkedList<>();
    private static final ConcurrentHashMap<Long, Object> vGh = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Long, Object> vGi = new ConcurrentHashMap<>();
    public static o<Long, b> vGj;
    public static final h vGk = new h();

    static {
        AppMethodBeat.i(251994);
        AppMethodBeat.o(251994);
    }

    private h() {
    }

    public static void b(LongSparseArray<k> longSparseArray) {
        AppMethodBeat.i(251982);
        StringBuilder sb = new StringBuilder();
        vGg.clear();
        if (longSparseArray != null) {
            int size = longSparseArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                vGg.add(longSparseArray.valueAt(i2));
                sb.append(d.zs(longSparseArray.keyAt(i2)) + ", ");
            }
        }
        Log.i("Finder.HotRelatedCache", "[saveTotalExposeMap] ".concat(String.valueOf(sb)));
        AppMethodBeat.o(251982);
    }

    public static void c(LongSparseArray<k> longSparseArray) {
        AppMethodBeat.i(251983);
        StringBuilder sb = new StringBuilder();
        if (longSparseArray != null) {
            for (T t : vGg) {
                long lT = t.Rrp.lT();
                longSparseArray.append(lT, t);
                sb.append(d.zs(lT) + ", ");
            }
        }
        Log.i("Finder.HotRelatedCache", "[restoreTotalExposeMap] ".concat(String.valueOf(sb)));
        AppMethodBeat.o(251983);
    }

    public static void c(long j2, FinderItem finderItem) {
        AppMethodBeat.i(251984);
        p.h(finderItem, "feed");
        cache.put(Long.valueOf(j2), finderItem);
        finderItem.setPosTriggerConfig(finderItem.parseJsonOfPosTriggerConfig());
        AppMethodBeat.o(251984);
    }

    public static FinderItem FH(long j2) {
        AppMethodBeat.i(251985);
        FinderItem finderItem = cache.get(Long.valueOf(j2));
        AppMethodBeat.o(251985);
        return finderItem;
    }

    public static FinderItem.b FI(long j2) {
        AppMethodBeat.i(251986);
        FinderItem finderItem = cache.get(Long.valueOf(j2));
        if (finderItem == null) {
            Log.w("Finder.HotRelatedCache", "[get] feedId=" + d.zs(j2) + " config is null.");
        }
        if (finderItem != null) {
            FinderItem.b posTriggerConfig = finderItem.getPosTriggerConfig();
            AppMethodBeat.o(251986);
            return posTriggerConfig;
        }
        AppMethodBeat.o(251986);
        return null;
    }

    public static boolean FJ(long j2) {
        AppMethodBeat.i(251987);
        if (!vGh.containsKey(Long.valueOf(j2))) {
            AppMethodBeat.o(251987);
            return true;
        }
        AppMethodBeat.o(251987);
        return false;
    }

    public static boolean FK(long j2) {
        AppMethodBeat.i(251988);
        if (!vGi.containsKey(Long.valueOf(j2))) {
            AppMethodBeat.o(251988);
            return true;
        }
        AppMethodBeat.o(251988);
        return false;
    }

    public static void FL(long j2) {
        AppMethodBeat.i(251989);
        Log.i("Finder.HotRelatedCache", "[markFetchRelatedFeed] feedId=" + d.zs(j2));
        vGh.put(Long.valueOf(j2), new Object());
        AppMethodBeat.o(251989);
    }

    public static void FM(long j2) {
        AppMethodBeat.i(251990);
        Log.i("Finder.HotRelatedCache", "[clearFetchRelatedFeed] feedId=" + d.zs(j2));
        vGh.remove(Long.valueOf(j2));
        AppMethodBeat.o(251990);
    }

    public static void FN(long j2) {
        AppMethodBeat.i(251991);
        Log.i("Finder.HotRelatedCache", "[markPrefetchRelatedFeed] feedId=" + d.zs(j2));
        vGi.put(Long.valueOf(j2), new Object());
        AppMethodBeat.o(251991);
    }

    public static b FO(long j2) {
        AppMethodBeat.i(251992);
        o<Long, b> oVar = vGj;
        if (oVar == null || oVar.first.longValue() != j2) {
            AppMethodBeat.o(251992);
            return null;
        }
        Log.i("Finder.HotRelatedCache", "[getPrefetchCache] use cache, feedId=" + d.zs(j2) + ' ');
        o<Long, b> oVar2 = vGj;
        if (oVar2 != null) {
            B b2 = oVar2.second;
            AppMethodBeat.o(251992);
            return b2;
        }
        AppMethodBeat.o(251992);
        return null;
    }

    public static void a(bbn bbn, boolean z, String str) {
        List list;
        A a2;
        B b2;
        LinkedList<bo> linkedList;
        A a3;
        long j2 = 0;
        AppMethodBeat.i(251993);
        p.h(str, "source");
        StringBuilder sb = new StringBuilder("[clearPrefetchCache] feedId=");
        o<Long, b> oVar = vGj;
        Log.i("Finder.HotRelatedCache", sb.append(d.zs((oVar == null || (a3 = oVar.first) == null) ? 0 : a3.longValue())).append(" source=").append(str).toString());
        o<Long, b> oVar2 = vGj;
        if (oVar2 == null || (b2 = oVar2.second) == null || (linkedList = b2.tUz) == null) {
            list = null;
        } else {
            y yVar = y.vXH;
            list = y.a(linkedList, BaseFinderFeed.class);
        }
        if (list != null) {
            o<Long, b> oVar3 = vGj;
            if (!(oVar3 == null || (a2 = oVar3.first) == null)) {
                j2 = a2.longValue();
            }
            Log.i("Finder.HotRelatedCache", "[clearPrefetchRelatedFeed] feedId=" + d.zs(j2));
            vGi.remove(Long.valueOf(j2));
            if (z) {
                y yVar2 = y.vXH;
                y.a(4, list, bbn);
            }
        }
        vGj = null;
        AppMethodBeat.o(251993);
    }
}
