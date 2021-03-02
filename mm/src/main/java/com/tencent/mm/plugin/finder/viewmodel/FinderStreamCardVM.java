package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponentPlugin;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0003J*\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0017\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019J\u0010\u0010\u001a\u001a\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u0014\u0010\u001d\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007J\u000e\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 J\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007J\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007J\u0016\u0010#\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u00020\u000bR \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "cardDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "cardPositionCache", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "readAlbumFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "readAlbumFeedSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "checkForReportReadStats", "", "list", "token", "call", "Lkotlin/Function0;", "clearAlbumReadFeeds", "isDestroy", "", "collectReadFeeds", "getCardLastPosition", "item", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "getThisAlbumReadFeeds", "getThisReadStats", "recordCardLastPosition", "position", "Companion", "plugin-finder_release"})
public final class FinderStreamCardVM extends UIComponentPlugin<PluginFinder> {
    public static final a wuH = new a((byte) 0);
    public final ConcurrentHashMap<String, List<FinderObject>> wuD = new ConcurrentHashMap<>();
    public final HashMap<String, Integer> wuE = new HashMap<>();
    private final LinkedList<cmm> wuF = new LinkedList<>();
    private final HashSet<Long> wuG = new HashSet<>();

    static {
        AppMethodBeat.i(255367);
        AppMethodBeat.o(255367);
    }

    public FinderStreamCardVM() {
        AppMethodBeat.i(255366);
        AppMethodBeat.o(255366);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM$Companion;", "", "()V", "TAG", "", "getCardToken", "item", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String b(ag agVar) {
            Long l;
            Long l2 = null;
            AppMethodBeat.i(255360);
            p.h(agVar, "item");
            StringBuilder append = new StringBuilder().append(agVar.tQQ.uOx).append('_');
            LinkedList<FinderObject> linkedList = agVar.tQQ.object;
            p.g(linkedList, "item.card.`object`");
            FinderObject finderObject = (FinderObject) j.kt(linkedList);
            if (finderObject != null) {
                l = Long.valueOf(finderObject.id);
            } else {
                l = null;
            }
            StringBuilder append2 = append.append(l).append('_');
            LinkedList<FinderObject> linkedList2 = agVar.tQQ.object;
            p.g(linkedList2, "item.card.`object`");
            FinderObject finderObject2 = (FinderObject) j.kv(linkedList2);
            if (finderObject2 != null) {
                l2 = Long.valueOf(finderObject2.id);
            }
            String sb = append2.append(l2).toString();
            AppMethodBeat.o(255360);
            return sb;
        }
    }

    public final void a(List<? extends FinderObject> list, String str, kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(255361);
        p.h(list, "list");
        p.h(str, "token");
        p.h(aVar, "call");
        if (!this.wuD.containsKey(str)) {
            Log.i("Finder.StreamCardVM", "[checkPreloadForReportReadStats] token=" + str + " not exist.");
            this.wuD.put(str, list);
            aVar.invoke();
            AppMethodBeat.o(255361);
            return;
        }
        Log.i("Finder.StreamCardVM", "[checkPreloadForReportReadStats] token=" + str + " has exist.");
        AppMethodBeat.o(255361);
    }

    public final void eH(List<? extends cmm> list) {
        int i2;
        AppMethodBeat.i(255362);
        p.h(list, "list");
        synchronized (this.wuF) {
            try {
                for (T t : list) {
                    Iterator<cmm> it = this.wuF.iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i2 = -1;
                            break;
                        }
                        if (it.next().hFK == t.hFK) {
                            i2 = i3;
                            break;
                        }
                        i3++;
                    }
                    if (i2 < 0 && !this.wuG.contains(Long.valueOf(t.hFK))) {
                        this.wuF.add(t);
                        this.wuG.add(Long.valueOf(t.hFK));
                    }
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(255362);
            }
        }
    }

    public final List<cmm> dHT() {
        AppMethodBeat.i(255363);
        LinkedList linkedList = new LinkedList();
        synchronized (this.wuF) {
            try {
                linkedList.addAll(this.wuF);
            } catch (Throwable th) {
                AppMethodBeat.o(255363);
                throw th;
            }
        }
        LinkedList linkedList2 = linkedList;
        AppMethodBeat.o(255363);
        return linkedList2;
    }

    public static /* synthetic */ void a(FinderStreamCardVM finderStreamCardVM) {
        AppMethodBeat.i(255365);
        finderStreamCardVM.pg(false);
        AppMethodBeat.o(255365);
    }

    public final void pg(boolean z) {
        AppMethodBeat.i(255364);
        Log.i("Finder.StreamCardVM", "clearAlbumReadFeeds... size=" + this.wuF.size());
        synchronized (this.wuF) {
            try {
                this.wuF.clear();
                if (z) {
                    this.wuG.clear();
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(255364);
            }
        }
    }
}
