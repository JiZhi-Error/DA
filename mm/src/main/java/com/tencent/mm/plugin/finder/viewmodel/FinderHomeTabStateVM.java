package com.tencent.mm.plugin.finder.viewmodel;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.component.UIComponentPlugin;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00045678B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0006J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\u0006\u0010\u001d\u001a\u00020\u0006J\u0010\u0010\u001e\u001a\u00020\u00182\b\b\u0002\u0010\u001f\u001a\u00020\u0006J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u0006J\u0010\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u0006J\u0006\u0010\"\u001a\u00020\u000eJ\u000e\u0010#\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010$\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0006J\b\u0010&\u001a\u00020\u0018H\u0014J\u0006\u0010'\u001a\u00020\u0018JZ\u0010(\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020.0-j\b\u0012\u0004\u0012\u00020.`/2\u0018\b\u0002\u00100\u001a\u0012\u0012\u0004\u0012\u0002010-j\b\u0012\u0004\u0012\u000201`/JP\u0010(\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020.0-j\b\u0012\u0004\u0012\u00020.`/2\u0018\b\u0002\u00100\u001a\u0012\u0012\u0004\u0012\u0002010-j\b\u0012\u0004\u0012\u000201`/J\u0016\u00102\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u00103\u001a\u000204R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR\u001a\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\f¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Cache;", "currentTabType", "getCurrentTabType", "()I", "setCurrentTabType", "(I)V", "isEnableStoreLastTabType", "", "isNeedCheckShowCollapsibleTip", "isNeedShowDoubleClickTip", "lastTabType", "getLastTabType", "setLastTabType", "refreshExpired", "getRefreshExpired", "setRefreshExpired", "clearTipCache", "", "get", "tabType", "getBusinessInfoKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getTargetEnterTabType", "incrementCollapsibleTipCount", "count", "incrementDoubleClickTipCount", "isAutoRefresh", "isShowCollapsibleTip", "isShowDoubleClickTip", "markFocusTabType", "markUnFocusTabType", "onCleared", "resetCache", "store", "lastRootScrollPy", "lastExitPosition", "lastExitFromTopPx", "lastDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "lastSectionDataList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "storeLastTabType", "source", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$LastTabTypeSource;", "Cache", "Companion", "LastTabTypeSource", "RefreshState", "plugin-finder_release"})
public final class FinderHomeTabStateVM extends UIComponentPlugin<PluginFinder> {
    public static final b wub = new b((byte) 0);
    public int UVM;
    private final ConcurrentHashMap<Integer, a> wtV = new ConcurrentHashMap<>();
    public int wtW;
    public int wtX;
    private boolean wtY;
    private boolean wtZ;
    private boolean wua;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$LastTabTypeSource;", "", "(Ljava/lang/String;I)V", "SOURCE_EXIT", "SOURCE_RED_DOT", "SOURCE_RESET", "SOURCE_MULTI_TAB_NEW", "SOURCE_RED_DOT_REVOKE", "plugin-finder_release"})
    public enum c {
        SOURCE_EXIT,
        SOURCE_RED_DOT,
        SOURCE_RESET,
        SOURCE_MULTI_TAB_NEW,
        SOURCE_RED_DOT_REVOKE;

        static {
            AppMethodBeat.i(255335);
            AppMethodBeat.o(255335);
        }

        public static c valueOf(String str) {
            AppMethodBeat.i(255337);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(255337);
            return cVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;", "", "(Ljava/lang/String;I)V", "Default", "HardRefresh", "Timeout", "InCacheTime", "plugin-finder_release"})
    public enum d {
        Default,
        HardRefresh,
        Timeout,
        InCacheTime;

        static {
            AppMethodBeat.i(255338);
            AppMethodBeat.o(255338);
        }

        public static d valueOf(String str) {
            AppMethodBeat.i(255340);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(255340);
            return dVar;
        }
    }

    static {
        AppMethodBeat.i(255357);
        AppMethodBeat.o(255357);
    }

    public FinderHomeTabStateVM() {
        AppMethodBeat.i(255356);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.wtX = com.tencent.mm.plugin.finder.storage.c.dsa().value().intValue();
        this.wtZ = true;
        this.wua = true;
        AppMethodBeat.o(255356);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public static /* synthetic */ void a(FinderHomeTabStateVM finderHomeTabStateVM, int i2, int i3, int i4, int i5, ArrayList arrayList) {
        AppMethodBeat.i(255342);
        finderHomeTabStateVM.a(i2, i3, i4, i5, arrayList, new ArrayList<>());
        AppMethodBeat.o(255342);
    }

    private void a(int i2, int i3, int i4, int i5, ArrayList<bo> arrayList, ArrayList<com.tencent.mm.plugin.finder.model.c> arrayList2) {
        AppMethodBeat.i(255341);
        p.h(arrayList, "lastDataList");
        p.h(arrayList2, "lastSectionDataList");
        Mq(i2).wue = i3;
        a(i2, i4, i5, arrayList, arrayList2);
        AppMethodBeat.o(255341);
    }

    public static /* synthetic */ void a(FinderHomeTabStateVM finderHomeTabStateVM, int i2, int i3, int i4, ArrayList arrayList) {
        AppMethodBeat.i(255344);
        finderHomeTabStateVM.a(i2, i3, i4, arrayList, new ArrayList<>());
        AppMethodBeat.o(255344);
    }

    public final void a(int i2, int i3, int i4, ArrayList<bo> arrayList, ArrayList<com.tencent.mm.plugin.finder.model.c> arrayList2) {
        AppMethodBeat.i(255343);
        p.h(arrayList, "lastDataList");
        p.h(arrayList2, "lastSectionDataList");
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.wtX = com.tencent.mm.plugin.finder.storage.c.dsa().value().intValue();
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.wtY = com.tencent.mm.plugin.finder.storage.c.dsj();
        this.wtW = 0;
        for (T t : arrayList) {
            if (t instanceof BaseFinderFeed) {
                t.dku();
            }
        }
        a Mq = Mq(i2);
        Mq.wuf = i3;
        Mq.wug = i4;
        Mq.eF(arrayList);
        Mq.eG(arrayList2);
        Mq.a((!arrayList.isEmpty() || !arrayList2.isEmpty()) ? d.Default : d.HardRefresh);
        Log.i("Finder.TlTabStateVM", "[store] tabType=" + i2 + " lastExitPosition=" + i3 + " lastExitFromTopPx=" + i4 + " refreshState=" + Mq.wui + ' ' + "current=" + f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, Mq.wuh / 1000));
        AppMethodBeat.o(255343);
    }

    public final void a(int i2, c cVar) {
        AppMethodBeat.i(255345);
        p.h(cVar, "source");
        Log.i("Finder.TlTabStateVM", "[storeLastTabType] tabType=" + i2 + " source=" + cVar + " isEnableStoreLastTabType=" + this.wtY);
        if (cVar == c.SOURCE_EXIT) {
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_LAST_TAB_TYPE_INT_SYNC, Integer.valueOf(i2));
            e aAh2 = g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_FINDER_LAST_TAB_TYPE_RED_DOT_INT_SYNC, (Object) -1);
        }
        AppMethodBeat.o(255345);
    }

    public final boolean JN(int i2) {
        AppMethodBeat.i(255346);
        a Mq = Mq(i2);
        d dVar = Mq.wui;
        if (dVar == d.HardRefresh) {
            AppMethodBeat.o(255346);
            return true;
        }
        if (dVar == d.Default || dVar == d.InCacheTime) {
            if (System.currentTimeMillis() - Mq.wuh > ((long) this.wtX)) {
                Mq.a(d.Timeout);
                AppMethodBeat.o(255346);
                return true;
            }
        } else if (dVar == d.Timeout) {
            AppMethodBeat.o(255346);
            return true;
        }
        Mq.a(d.InCacheTime);
        AppMethodBeat.o(255346);
        return false;
    }

    public final void Mp(int i2) {
        AppMethodBeat.i(255347);
        a Mq = Mq(i2);
        Mq.a(d.Default);
        Mq.wuh = System.currentTimeMillis();
        Log.i("Finder.TlTabStateVM", "[markUnFocusTabType] tabType=".concat(String.valueOf(i2)));
        AppMethodBeat.o(255347);
    }

    public final int dHR() {
        AppMethodBeat.i(255348);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_LAST_TAB_TYPE_INT_SYNC, 4);
        int i3 = this.wtY ? i2 : 4;
        if (JN(i2)) {
            com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
            p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            int daF = ((PluginFinder) ah).getRedDotManager().daF();
            if (daF == -1) {
                daF = i3;
            }
            Log.i("Finder.TlTabStateVM", "[getLastTabType] autoRefresh... ret=" + daF + " lastRedType=-1 lastExitTabType=" + i2 + " defaultServerTabType=" + i3);
            AppMethodBeat.o(255348);
            return daF;
        }
        Log.i("Finder.TlTabStateVM", "[getLastTabType] no autoRefresh... lastExitTabType=".concat(String.valueOf(i2)));
        AppMethodBeat.o(255348);
        return i2;
    }

    public final a Mq(int i2) {
        AppMethodBeat.i(255349);
        if (this.wtV.get(Integer.valueOf(i2)) == null) {
            this.wtV.put(Integer.valueOf(i2), new a(i2));
        }
        a aVar = this.wtV.get(Integer.valueOf(i2));
        if (aVar == null) {
            p.hyc();
        }
        a aVar2 = aVar;
        AppMethodBeat.o(255349);
        return aVar2;
    }

    @Override // android.arch.lifecycle.ViewModel
    public final void onCleared() {
        AppMethodBeat.i(255350);
        super.onCleared();
        AppMethodBeat.o(255350);
    }

    public final void resetCache() {
        AppMethodBeat.i(255351);
        a(4, c.SOURCE_RESET);
        this.wtV.clear();
        AppMethodBeat.o(255351);
    }

    public final boolean Mr(int i2) {
        AppMethodBeat.i(255352);
        if (!this.wtZ) {
            AppMethodBeat.o(255352);
            return false;
        }
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        if (aAh.azQ().getInt(Mt(i2), 0) < 3) {
            AppMethodBeat.o(255352);
            return true;
        }
        this.wtZ = false;
        AppMethodBeat.o(255352);
        return false;
    }

    public static void dHS() {
        AppMethodBeat.i(255353);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_TIP_COLLAPSIBLE_INT, 0);
        e aAh2 = g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        aAh2.azQ().set(ar.a.USERINFO_FINDER_TIP_COLLAPSIBLE_INT, Integer.valueOf(i2 + 1));
        AppMethodBeat.o(255353);
    }

    public static /* synthetic */ void Ms(int i2) {
        AppMethodBeat.i(255355);
        gu(i2, 1);
        AppMethodBeat.o(255355);
    }

    public static void gu(int i2, int i3) {
        AppMethodBeat.i(255354);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        int i4 = aAh.azQ().getInt(Mt(i2), 0);
        e aAh2 = g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        aAh2.azQ().set(Mt(i2), Integer.valueOf(i4 + i3));
        AppMethodBeat.o(255354);
    }

    public static ar.a Mt(int i2) {
        switch (i2) {
            case 1:
                return ar.a.USERINFO_FINDER_TAB_TIP_FRIEND_INT;
            case 2:
                return ar.a.USERINFO_FINDER_TAB_TIP_LBS_INT;
            case 3:
                return ar.a.USERINFO_FINDER_TAB_TIP_FOLLOW_INT;
            case 4:
                return ar.a.USERINFO_FINDER_TAB_TIP_MACHINE_INT;
            default:
                return ar.a.USERINFO_FINDER_TAB_TIP_FRIEND_INT;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u0013\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0004R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010\u000bR\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000e¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Cache;", "", "tabType", "", "(I)V", "lastDataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLastDataList", "()Ljava/util/List;", "setLastDataList", "(Ljava/util/List;)V", "lastExitFromTopPx", "getLastExitFromTopPx", "()I", "setLastExitFromTopPx", "lastExitPosition", "getLastExitPosition", "setLastExitPosition", "lastExitTime", "", "getLastExitTime", "()J", "setLastExitTime", "(J)V", "lastRootScrollPy", "getLastRootScrollPy", "setLastRootScrollPy", "lastSectionDataList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "getLastSectionDataList", "setLastSectionDataList", "refreshState", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;", "getRefreshState", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;", "setRefreshState", "(Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$RefreshState;)V", "getTabType", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-finder_release"})
    public static final class a {
        private final int dLS;
        public List<? extends bo> wuc = new LinkedList();
        public List<com.tencent.mm.plugin.finder.model.c> wud = new LinkedList();
        public int wue;
        public int wuf;
        public int wug;
        public long wuh;
        d wui = d.Default;

        public final boolean equals(Object obj) {
            return this == obj || ((obj instanceof a) && this.dLS == ((a) obj).dLS);
        }

        public final int hashCode() {
            return this.dLS;
        }

        public final String toString() {
            AppMethodBeat.i(255334);
            String str = "Cache(tabType=" + this.dLS + ")";
            AppMethodBeat.o(255334);
            return str;
        }

        public a(int i2) {
            AppMethodBeat.i(255333);
            this.dLS = i2;
            AppMethodBeat.o(255333);
        }

        public final void eF(List<? extends bo> list) {
            AppMethodBeat.i(255330);
            p.h(list, "<set-?>");
            this.wuc = list;
            AppMethodBeat.o(255330);
        }

        public final void eG(List<com.tencent.mm.plugin.finder.model.c> list) {
            AppMethodBeat.i(255331);
            p.h(list, "<set-?>");
            this.wud = list;
            AppMethodBeat.o(255331);
        }

        public final void a(d dVar) {
            AppMethodBeat.i(255332);
            p.h(dVar, "<set-?>");
            this.wui = dVar;
            AppMethodBeat.o(255332);
        }
    }
}
