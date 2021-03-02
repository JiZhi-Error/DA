package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004J\u001a\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0016\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!J\u0018\u0010\"\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010!J\u0016\u0010#\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!J\u0016\u0010$\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowMonitor;", "", "()V", "TAG", "", "mDetailMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderDetailMonitor;", "mFavMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor;", "mLbsMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor;", "mLikedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLikeMonitor;", "mProfileMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderProfileMonitor;", "mRelMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor;", "mSearchMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderSearchMonitor;", "mTimelineMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderTimelineMonitor;", "mTopicMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderTopicMonitor;", NativeProtocol.WEB_DIALOG_ACTION, "", "actionId", "", "pageName", "doAction", "monitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "free", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "report", "startMonitor", "stopMonitor", "plugin-expt_release"})
public final class b {
    private static m sCV;
    private static c sCW;
    private static n sCX;
    private static i sCY;
    private static k sCZ;
    private static l sDa;
    private static e sDb;
    private static d sDc;
    private static h sDd;
    public static final b sDe = new b();

    static {
        AppMethodBeat.i(220833);
        AppMethodBeat.o(220833);
    }

    private b() {
    }

    public static void c(String str, Activity activity) {
        AppMethodBeat.i(220827);
        p.h(str, "pageName");
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        switch (str.hashCode()) {
            case -2031553009:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI")) {
                    if (sCX == null) {
                        sCX = new n();
                    }
                    n nVar = sCX;
                    if (nVar != null) {
                        nVar.a(0, str, activity);
                        AppMethodBeat.o(220827);
                        return;
                    }
                    AppMethodBeat.o(220827);
                    return;
                }
                break;
            case -1615773847:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI")) {
                    if (sCZ == null) {
                        sCZ = new k();
                    }
                    k kVar = sCZ;
                    if (kVar != null) {
                        kVar.a(0, str, activity);
                        AppMethodBeat.o(220827);
                        return;
                    }
                    AppMethodBeat.o(220827);
                    return;
                }
                break;
            case -1605333887:
                if (str.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI")) {
                    if (sDa == null) {
                        sDa = new l();
                    }
                    l lVar = sDa;
                    if (lVar != null) {
                        lVar.a(0, str, activity);
                        AppMethodBeat.o(220827);
                        return;
                    }
                    AppMethodBeat.o(220827);
                    return;
                }
                break;
            case -1490149623:
                if (str.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI")) {
                    if (sCW == null) {
                        sCW = new c();
                    }
                    c cVar = sCW;
                    if (cVar != null) {
                        cVar.a(0, str, activity);
                        AppMethodBeat.o(220827);
                        return;
                    }
                    AppMethodBeat.o(220827);
                    return;
                }
                break;
            case -936307702:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI")) {
                    if (sDd == null) {
                        sDd = new h();
                    }
                    h hVar = sDd;
                    if (hVar != null) {
                        hVar.a(0, str, activity);
                        AppMethodBeat.o(220827);
                        return;
                    }
                }
                break;
            case 1670085563:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI")) {
                    if (sDc == null) {
                        sDc = new d();
                    }
                    d dVar = sDc;
                    if (dVar != null) {
                        dVar.a(0, str, activity);
                        AppMethodBeat.o(220827);
                        return;
                    }
                    AppMethodBeat.o(220827);
                    return;
                }
                break;
            case 1670607163:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI")) {
                    if (sDb == null) {
                        sDb = new e();
                    }
                    e eVar = sDb;
                    if (eVar != null) {
                        eVar.a(0, str, activity);
                        AppMethodBeat.o(220827);
                        return;
                    }
                    AppMethodBeat.o(220827);
                    return;
                }
                break;
            case 1878606788:
                if (str.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI")) {
                    if (sCY == null) {
                        sCY = new i();
                    }
                    i iVar = sCY;
                    if (iVar != null) {
                        iVar.a(0, str, activity);
                        AppMethodBeat.o(220827);
                        return;
                    }
                    AppMethodBeat.o(220827);
                    return;
                }
                break;
            case 1966129866:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI")) {
                    if (sCV == null) {
                        sCV = new m();
                    }
                    m mVar = sCV;
                    if (mVar != null) {
                        mVar.a(0, str, activity);
                        AppMethodBeat.o(220827);
                        return;
                    }
                    AppMethodBeat.o(220827);
                    return;
                }
                break;
            case 2029821223:
                if (str.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI")) {
                    if (sCW == null) {
                        sCW = new c();
                    }
                    c cVar2 = sCW;
                    if (cVar2 != null) {
                        cVar2.a(0, str, activity);
                        AppMethodBeat.o(220827);
                        return;
                    }
                    AppMethodBeat.o(220827);
                    return;
                }
                break;
        }
        AppMethodBeat.o(220827);
    }

    public static void d(String str, Activity activity) {
        h hVar;
        AppMethodBeat.i(220828);
        p.h(str, "pageName");
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        switch (str.hashCode()) {
            case -2031553009:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI")) {
                    n nVar = sCX;
                    if (nVar != null) {
                        nVar.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", activity);
                        AppMethodBeat.o(220828);
                        return;
                    }
                    AppMethodBeat.o(220828);
                    return;
                }
                break;
            case -1615773847:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI")) {
                    k kVar = sCZ;
                    if (kVar != null) {
                        kVar.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", activity);
                        AppMethodBeat.o(220828);
                        return;
                    }
                    AppMethodBeat.o(220828);
                    return;
                }
                break;
            case -1605333887:
                if (str.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI")) {
                    l lVar = sDa;
                    if (lVar != null) {
                        lVar.a(1, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", activity);
                        AppMethodBeat.o(220828);
                        return;
                    }
                    AppMethodBeat.o(220828);
                    return;
                }
                break;
            case -1490149623:
                if (str.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI")) {
                    c cVar = sCW;
                    if (cVar != null) {
                        cVar.a(1, "com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI", activity);
                        AppMethodBeat.o(220828);
                        return;
                    }
                    AppMethodBeat.o(220828);
                    return;
                }
                break;
            case -936307702:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI") && (hVar = sDd) != null) {
                    hVar.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI", activity);
                    AppMethodBeat.o(220828);
                    return;
                }
            case 1670085563:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI")) {
                    d dVar = sDc;
                    if (dVar != null) {
                        dVar.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", activity);
                        AppMethodBeat.o(220828);
                        return;
                    }
                    AppMethodBeat.o(220828);
                    return;
                }
                break;
            case 1670607163:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI")) {
                    e eVar = sDb;
                    if (eVar != null) {
                        eVar.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI", activity);
                        AppMethodBeat.o(220828);
                        return;
                    }
                    AppMethodBeat.o(220828);
                    return;
                }
                break;
            case 1878606788:
                if (str.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI")) {
                    i iVar = sCY;
                    if (iVar != null) {
                        iVar.a(1, "com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", activity);
                        AppMethodBeat.o(220828);
                        return;
                    }
                    AppMethodBeat.o(220828);
                    return;
                }
                break;
            case 1966129866:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI")) {
                    m mVar = sCV;
                    if (mVar != null) {
                        mVar.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI", activity);
                        AppMethodBeat.o(220828);
                        return;
                    }
                    AppMethodBeat.o(220828);
                    return;
                }
                break;
            case 2029821223:
                if (str.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI")) {
                    c cVar2 = sCW;
                    if (cVar2 != null) {
                        cVar2.a(1, "com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI", activity);
                        AppMethodBeat.o(220828);
                        return;
                    }
                    AppMethodBeat.o(220828);
                    return;
                }
                break;
        }
        AppMethodBeat.o(220828);
    }

    public static void e(String str, Activity activity) {
        h hVar;
        AppMethodBeat.i(220829);
        p.h(str, "pageName");
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        switch (str.hashCode()) {
            case -2031553009:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI")) {
                    n nVar = sCX;
                    if (nVar != null) {
                        nVar.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", activity);
                        AppMethodBeat.o(220829);
                        return;
                    }
                    AppMethodBeat.o(220829);
                    return;
                }
                break;
            case -1615773847:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI")) {
                    k kVar = sCZ;
                    if (kVar != null) {
                        kVar.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", activity);
                        AppMethodBeat.o(220829);
                        return;
                    }
                    AppMethodBeat.o(220829);
                    return;
                }
                break;
            case -1605333887:
                if (str.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI")) {
                    l lVar = sDa;
                    if (lVar != null) {
                        lVar.a(2, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", activity);
                        AppMethodBeat.o(220829);
                        return;
                    }
                    AppMethodBeat.o(220829);
                    return;
                }
                break;
            case -1490149623:
                if (str.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI")) {
                    c cVar = sCW;
                    if (cVar != null) {
                        cVar.a(2, "com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI", activity);
                        AppMethodBeat.o(220829);
                        return;
                    }
                    AppMethodBeat.o(220829);
                    return;
                }
                break;
            case -936307702:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI") && (hVar = sDd) != null) {
                    hVar.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI", activity);
                    AppMethodBeat.o(220829);
                    return;
                }
            case 1670085563:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI")) {
                    d dVar = sDc;
                    if (dVar != null) {
                        dVar.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", activity);
                        AppMethodBeat.o(220829);
                        return;
                    }
                    AppMethodBeat.o(220829);
                    return;
                }
                break;
            case 1670607163:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI")) {
                    e eVar = sDb;
                    if (eVar != null) {
                        eVar.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI", activity);
                        AppMethodBeat.o(220829);
                        return;
                    }
                    AppMethodBeat.o(220829);
                    return;
                }
                break;
            case 1878606788:
                if (str.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI")) {
                    i iVar = sCY;
                    if (iVar != null) {
                        iVar.a(2, "com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", activity);
                        AppMethodBeat.o(220829);
                        return;
                    }
                    AppMethodBeat.o(220829);
                    return;
                }
                break;
            case 1966129866:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI")) {
                    m mVar = sCV;
                    if (mVar != null) {
                        mVar.a(2, str, activity);
                        AppMethodBeat.o(220829);
                        return;
                    }
                    AppMethodBeat.o(220829);
                    return;
                }
                break;
            case 2029821223:
                if (str.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI")) {
                    c cVar2 = sCW;
                    if (cVar2 != null) {
                        cVar2.a(2, "com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI", activity);
                        AppMethodBeat.o(220829);
                        return;
                    }
                    AppMethodBeat.o(220829);
                    return;
                }
                break;
        }
        AppMethodBeat.o(220829);
    }

    public static void apq(String str) {
        h hVar;
        AppMethodBeat.i(220830);
        p.h(str, "pageName");
        switch (str.hashCode()) {
            case -2031553009:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI")) {
                    n nVar = sCX;
                    if (nVar != null) {
                        nVar.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", null);
                        AppMethodBeat.o(220830);
                        return;
                    }
                    AppMethodBeat.o(220830);
                    return;
                }
                break;
            case -1615773847:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI")) {
                    k kVar = sCZ;
                    if (kVar != null) {
                        kVar.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", null);
                        AppMethodBeat.o(220830);
                        return;
                    }
                    AppMethodBeat.o(220830);
                    return;
                }
                break;
            case -1605333887:
                if (str.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI")) {
                    l lVar = sDa;
                    if (lVar != null) {
                        lVar.a(3, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", null);
                        AppMethodBeat.o(220830);
                        return;
                    }
                    AppMethodBeat.o(220830);
                    return;
                }
                break;
            case -1490149623:
                if (str.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI")) {
                    c cVar = sCW;
                    if (cVar != null) {
                        cVar.a(3, "com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI", null);
                        AppMethodBeat.o(220830);
                        return;
                    }
                    AppMethodBeat.o(220830);
                    return;
                }
                break;
            case -936307702:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI") && (hVar = sDd) != null) {
                    hVar.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI", null);
                    AppMethodBeat.o(220830);
                    return;
                }
            case 1670085563:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI")) {
                    d dVar = sDc;
                    if (dVar != null) {
                        dVar.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", null);
                        AppMethodBeat.o(220830);
                        return;
                    }
                    AppMethodBeat.o(220830);
                    return;
                }
                break;
            case 1670607163:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI")) {
                    e eVar = sDb;
                    if (eVar != null) {
                        eVar.a(3, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", null);
                        AppMethodBeat.o(220830);
                        return;
                    }
                    AppMethodBeat.o(220830);
                    return;
                }
                break;
            case 1878606788:
                if (str.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI")) {
                    i iVar = sCY;
                    if (iVar != null) {
                        iVar.a(3, "com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", null);
                        AppMethodBeat.o(220830);
                        return;
                    }
                    AppMethodBeat.o(220830);
                    return;
                }
                break;
            case 1966129866:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI")) {
                    m mVar = sCV;
                    if (mVar != null) {
                        mVar.a(3, str, null);
                        AppMethodBeat.o(220830);
                        return;
                    }
                    AppMethodBeat.o(220830);
                    return;
                }
                break;
            case 2029821223:
                if (str.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI")) {
                    c cVar2 = sCW;
                    if (cVar2 != null) {
                        cVar2.a(3, "com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI", null);
                        AppMethodBeat.o(220830);
                        return;
                    }
                    AppMethodBeat.o(220830);
                    return;
                }
                break;
        }
        AppMethodBeat.o(220830);
    }

    public static void aU(int i2, String str) {
        AppMethodBeat.i(220831);
        p.h(str, "pageName");
        switch (str.hashCode()) {
            case -2031553009:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI")) {
                    a(i2, sCX);
                    if (i2 == 2) {
                        sCX = null;
                        AppMethodBeat.o(220831);
                        return;
                    }
                }
                break;
            case -1615773847:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI")) {
                    a(i2, sCZ);
                    if (i2 == 2) {
                        sCZ = null;
                        AppMethodBeat.o(220831);
                        return;
                    }
                }
                break;
            case -1605333887:
                if (str.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI")) {
                    a(i2, sDa);
                    if (i2 == 2) {
                        sDa = null;
                        AppMethodBeat.o(220831);
                        return;
                    }
                }
                break;
            case -1490149623:
                if (str.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI")) {
                    a(i2, sCW);
                    if (i2 == 2) {
                        sCW = null;
                        AppMethodBeat.o(220831);
                        return;
                    }
                }
                break;
            case -936307702:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI")) {
                    a(i2, sDd);
                    if (i2 == 2) {
                        sDd = null;
                        break;
                    }
                }
                break;
            case 1670085563:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI")) {
                    a(i2, sDc);
                    if (i2 == 2) {
                        sDc = null;
                        AppMethodBeat.o(220831);
                        return;
                    }
                }
                break;
            case 1670607163:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI")) {
                    a(i2, sDb);
                    if (i2 == 2) {
                        sDb = null;
                        AppMethodBeat.o(220831);
                        return;
                    }
                }
                break;
            case 1878606788:
                if (str.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI")) {
                    a(i2, sCY);
                    if (i2 == 2) {
                        sCY = null;
                        AppMethodBeat.o(220831);
                        return;
                    }
                }
                break;
            case 1966129866:
                if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI")) {
                    a(i2, sCV);
                    if (i2 == 2) {
                        sCV = null;
                        AppMethodBeat.o(220831);
                        return;
                    }
                }
                break;
            case 2029821223:
                if (str.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI")) {
                    a(i2, sCW);
                    if (i2 == 2) {
                        sCW = null;
                        AppMethodBeat.o(220831);
                        return;
                    }
                }
                break;
        }
        AppMethodBeat.o(220831);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static void a(int i2, o oVar) {
        AppMethodBeat.i(220832);
        switch (i2) {
            case 0:
                if (oVar != null) {
                    oVar.startMonitor();
                    AppMethodBeat.o(220832);
                    return;
                }
                AppMethodBeat.o(220832);
                return;
            case 1:
                if (oVar != null) {
                    oVar.stopMonitor();
                    AppMethodBeat.o(220832);
                    return;
                }
                AppMethodBeat.o(220832);
                return;
            case 2:
                if (oVar != null) {
                    oVar.free();
                    AppMethodBeat.o(220832);
                    return;
                }
                break;
            case 3:
                if (oVar != null) {
                    oVar.report();
                    AppMethodBeat.o(220832);
                    return;
                }
                AppMethodBeat.o(220832);
                return;
        }
        AppMethodBeat.o(220832);
    }
}
