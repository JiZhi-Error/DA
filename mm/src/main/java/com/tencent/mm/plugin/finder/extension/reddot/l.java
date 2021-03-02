package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.storage.ar;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u00103\u001a\u00020\bH\u0002J\u000e\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0004J\u000e\u00107\u001a\u0002052\u0006\u00108\u001a\u00020\u000eJ\b\u00109\u001a\u00020\u0004H\u0002J\u0006\u0010:\u001a\u000205J\u0006\u0010;\u001a\u000205R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0011\u0010\u0013\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\nR\u0011\u0010\u0015\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\nR\u0011\u0010\u0017\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\nR\u0011\u0010\u0019\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\nR\u0011\u0010\u001b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\nR\u0011\u0010\u001d\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\nR\u0011\u0010\u001f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b \u0010\nR\u0011\u0010!\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\"\u0010\nR\u0014\u0010#\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\nR\u0014\u0010%\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\nR\u0014\u0010'\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\nR\u0011\u0010)\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b*\u0010\nR\u0011\u0010+\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b,\u0010\nR\u0011\u0010-\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b.\u0010\nR\u0011\u0010/\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b0\u0010\nR\u0011\u00101\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b2\u0010\n¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/reddot/RedDotDynamicConfig;", "", "()V", "currentFastEnterLevel", "", "getCurrentFastEnterLevel", "()I", "finderFastEnterTime", "", "getFinderFastEnterTime", "()J", "friendEntranceTimeMs", "getFriendEntranceTimeMs", "fullScreenTabShowed", "", "getFullScreenTabShowed", "()Z", "lastExitFinderTlTime", "getLastExitFinderTlTime", "lastExitNearbyTime", "getLastExitNearbyTime", "moreTabFollowEntranceTimeMs", "getMoreTabFollowEntranceTimeMs", "moreTabFollowTabTimeMs", "getMoreTabFollowTabTimeMs", "moreTabFriendEntranceTimeMs", "getMoreTabFriendEntranceTimeMs", "moreTabHotEntranceTimeMs", "getMoreTabHotEntranceTimeMs", "moreTabLiveEntranceTimeMs", "getMoreTabLiveEntranceTimeMs", "moreTabNearbyEntranceTimeMs", "getMoreTabNearbyEntranceTimeMs", "moreTabNewsEntranceTimeMs", "getMoreTabNewsEntranceTimeMs", "newFeedTipsFastEnterFirstTimeInterval", "getNewFeedTipsFastEnterFirstTimeInterval", "newFeedTipsFastEnterSecondTimeInterval", "getNewFeedTipsFastEnterSecondTimeInterval", "newFeedTipsFastEnterThirdTimeInterval", "getNewFeedTipsFastEnterThirdTimeInterval", "newFollowTipsEnterInterval", "getNewFollowTipsEnterInterval", "newMsgEntranceInterval", "getNewMsgEntranceInterval", "newUnFollowTipsEnterInterval", "getNewUnFollowTipsEnterInterval", "refreshDiscoveryTimeMs", "getRefreshDiscoveryTimeMs", "refreshEntranceInterval", "getRefreshEntranceInterval", "addLevelTime", "setCurrentFastEnterLevel", "", "level", "setFullScreenTabShowed", "isShowed", "testFactor", "updateLastExitTime", "updateNearbyLastExitTime", "plugin-finder_release"})
public final class l {
    public static final l tLu = new l();

    static {
        AppMethodBeat.i(178219);
        AppMethodBeat.o(178219);
    }

    private l() {
    }

    public final long dbA() {
        AppMethodBeat.i(243642);
        long a2 = ((((long) ((b) g.af(b.class)).a(b.a.clicfg_finder_more_tab_follow_entrance_red_dot_interval, 7200)) * 1000) / ((long) dbT())) + dbS();
        AppMethodBeat.o(243642);
        return a2;
    }

    public final long dbB() {
        AppMethodBeat.i(243643);
        long a2 = ((((long) ((b) g.af(b.class)).a(b.a.clicfg_finder_more_tab_follow_tab_red_dot_interval, 0)) * 1000) / ((long) dbT())) + dbS();
        AppMethodBeat.o(243643);
        return a2;
    }

    public final long dbC() {
        AppMethodBeat.i(243644);
        long a2 = ((((long) ((b) g.af(b.class)).a(b.a.clicfg_finder_more_tab_friend_tab_red_dot_interval, 7200)) * 1000) / ((long) dbT())) + dbS();
        AppMethodBeat.o(243644);
        return a2;
    }

    public final long dbD() {
        AppMethodBeat.i(243645);
        long a2 = ((((long) ((b) g.af(b.class)).a(b.a.clicfg_finder_more_tab_hot_tab_red_dot_interval, 7200)) * 1000) / ((long) dbT())) + dbS();
        AppMethodBeat.o(243645);
        return a2;
    }

    public final long dbE() {
        AppMethodBeat.i(243646);
        long a2 = ((((long) ((b) g.af(b.class)).a(b.a.clicfg_finder_more_tab_news_tab_red_dot_interval, 7200)) * 1000) / ((long) dbT())) + dbS();
        AppMethodBeat.o(243646);
        return a2;
    }

    public final long dbF() {
        AppMethodBeat.i(243647);
        long a2 = ((((long) ((b) g.af(b.class)).a(b.a.clicfg_finder_more_tab_live_tab_red_dot_interval, 7200)) * 1000) / ((long) dbT())) + dbS();
        AppMethodBeat.o(243647);
        return a2;
    }

    public final long dbG() {
        AppMethodBeat.i(243648);
        long a2 = ((((long) ((b) g.af(b.class)).a(b.a.clicfg_finder_more_tab_nearby_red_dot_interval, 7200)) * 1000) / ((long) dbT())) + dbS();
        AppMethodBeat.o(243648);
        return a2;
    }

    public final long dbH() {
        AppMethodBeat.i(243649);
        long a2 = ((((long) ((b) g.af(b.class)).a(b.a.clicfg_finder_new_msg_tips_enter_interval, 7200)) * 1000) / ((long) dbT())) + dbS();
        AppMethodBeat.o(243649);
        return a2;
    }

    public static long dbI() {
        AppMethodBeat.i(178209);
        a af = g.af(com.tencent.mm.plugin.zero.b.a.class);
        p.g(af, "MMKernel.service(IConfigService::class.java)");
        long j2 = ((long) ((com.tencent.mm.plugin.zero.b.a) af).aqJ().getInt("FinderFastEnterTime", 0)) * 1000;
        AppMethodBeat.o(178209);
        return j2;
    }

    private static long dbJ() {
        AppMethodBeat.i(178210);
        a af = g.af(com.tencent.mm.plugin.zero.b.a.class);
        p.g(af, "MMKernel.service(IConfigService::class.java)");
        long j2 = (((long) ((com.tencent.mm.plugin.zero.b.a) af).aqJ().getInt("FinderNewFeedTipsFastEnterFirstTimeInterval", LocalCache.TIME_DAY)) * 1000) / ((long) dbT());
        AppMethodBeat.o(178210);
        return j2;
    }

    private static long dbK() {
        AppMethodBeat.i(178211);
        a af = g.af(com.tencent.mm.plugin.zero.b.a.class);
        p.g(af, "MMKernel.service(IConfigService::class.java)");
        long j2 = (((long) ((com.tencent.mm.plugin.zero.b.a) af).aqJ().getInt("FinderNewFeedTipsFastEnterSecondTimeInterval", 172800)) * 1000) / ((long) dbT());
        AppMethodBeat.o(178211);
        return j2;
    }

    private static long dbL() {
        AppMethodBeat.i(178212);
        a af = g.af(com.tencent.mm.plugin.zero.b.a.class);
        p.g(af, "MMKernel.service(IConfigService::class.java)");
        long j2 = (((long) ((com.tencent.mm.plugin.zero.b.a) af).aqJ().getInt("FinderNewFeedTipsFastEnterThirdTimeInterval", 604800)) * 1000) / ((long) dbT());
        AppMethodBeat.o(178212);
        return j2;
    }

    public static int dbM() {
        AppMethodBeat.i(178213);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_CURRENT_FAST_ENTER_LEVEL_INT_SYNC, 0);
        AppMethodBeat.o(178213);
        return i2;
    }

    public static void ID(int i2) {
        AppMethodBeat.i(178214);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_CURRENT_FAST_ENTER_LEVEL_INT_SYNC, Integer.valueOf(i2));
        AppMethodBeat.o(178214);
    }

    public static boolean dbN() {
        AppMethodBeat.i(243650);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        boolean z = aAh.azQ().getBoolean(ar.a.USERINFO_FINDER_FIRST_SHOW_FULL_SCREEN_TAB_BOOLEAN_SYNC, false);
        AppMethodBeat.o(243650);
        return z;
    }

    public static void mU(boolean z) {
        AppMethodBeat.i(243651);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_FIRST_SHOW_FULL_SCREEN_TAB_BOOLEAN_SYNC, Boolean.valueOf(z));
        AppMethodBeat.o(243651);
    }

    public static long dbO() {
        AppMethodBeat.i(178215);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        long a2 = aAh.azQ().a(ar.a.USERINFO_FINDER_EXIT_FINDER_TL_LONG_SYNC, 0);
        AppMethodBeat.o(178215);
        return a2;
    }

    public static long dbP() {
        AppMethodBeat.i(243652);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        long a2 = aAh.azQ().a(ar.a.USERINFO_FINDER_EXIT_NEARBY_LONG_SYNC, 0);
        AppMethodBeat.o(243652);
        return a2;
    }

    public static void dbQ() {
        AppMethodBeat.i(178216);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_EXIT_FINDER_TL_LONG_SYNC, Long.valueOf(cl.aWA()));
        AppMethodBeat.o(178216);
    }

    public static void dbR() {
        AppMethodBeat.i(243653);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_EXIT_NEARBY_LONG_SYNC, Long.valueOf(cl.aWA()));
        AppMethodBeat.o(243653);
    }

    private static long dbS() {
        AppMethodBeat.i(178217);
        switch (dbM()) {
            case 1:
                long dbJ = dbJ();
                AppMethodBeat.o(178217);
                return dbJ;
            case 2:
                long dbK = dbK();
                AppMethodBeat.o(178217);
                return dbK;
            case 3:
                long dbL = dbL();
                AppMethodBeat.o(178217);
                return dbL;
            default:
                AppMethodBeat.o(178217);
                return 0;
        }
    }

    private static int dbT() {
        AppMethodBeat.i(178218);
        c cVar = c.vCb;
        int intValue = c.dte().value().intValue();
        AppMethodBeat.o(178218);
        return intValue;
    }
}
