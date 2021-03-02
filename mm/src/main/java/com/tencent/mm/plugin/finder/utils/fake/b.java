package com.tencent.mm.plugin.finder.utils.fake;

import android.view.MenuItem;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.e;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.utils.fake.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\u0006\u0010!\u001a\u00020\u001dR\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockDebug;", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "MOCK_GIFT_1", "", "getMOCK_GIFT_1", "()I", "MOCK_GIFT_2", "getMOCK_GIFT_2", "MOCK_GIFT_3", "getMOCK_GIFT_3", "MOCK_GIFT_4", "getMOCK_GIFT_4", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "commandList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "createDefault", "giftType", "Lcom/tencent/mm/plugin/finder/utils/fake/GiftType;", "count", "relaunchAndOnAnimationEndCurrentCase", "", "relaunchFailCase", "replaceBulletCase", "sendGiftToLinkMicUser", "show", "Companion", "plugin-finder_release"})
public final class b {
    private static final String TAG = TAG;
    public static final a waK = new a((byte) 0);
    final int UVl = 4;
    public final MMActivity activity;
    private final g liveData;
    final int waG = 1;
    final int waH = 2;
    final int waI = 3;
    private final LinkedList<c.d> waJ = new LinkedList<>();

    public b(MMActivity mMActivity, g gVar) {
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(gVar, "liveData");
        AppMethodBeat.i(261495);
        this.activity = mMActivity;
        this.liveData = gVar;
        AppMethodBeat.o(261495);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockDebug$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(253830);
        AppMethodBeat.o(253830);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    /* renamed from: com.tencent.mm.plugin.finder.utils.fake.b$b  reason: collision with other inner class name */
    public static final class C1315b implements o.f {
        final /* synthetic */ b waL;

        public C1315b(b bVar) {
            this.waL = bVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(253827);
            p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                mVar.d(this.waL.waG, "爱心1+爱心5延迟4秒(小礼物不消失case)");
                mVar.d(this.waL.waH, "全自己火箭5+打call1+爱心连击20（连击聚合失效case）");
                mVar.d(this.waL.waI, "火箭1+自己打call1延迟1秒（大礼物循环播放case）");
                mVar.d(this.waL.UVl, "给连麦小主播送礼");
            }
            AppMethodBeat.o(253827);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class c implements o.g {
        final /* synthetic */ b waL;

        public c(b bVar) {
            this.waL = bVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(253828);
            p.g(menuItem, "menuItem");
            if (menuItem.getItemId() == this.waL.waG) {
                b.a(this.waL);
                AppMethodBeat.o(253828);
            } else if (menuItem.getItemId() == this.waL.waH) {
                b.b(this.waL);
                AppMethodBeat.o(253828);
            } else if (menuItem.getItemId() == this.waL.waI) {
                b.c(this.waL);
                AppMethodBeat.o(253828);
            } else {
                if (menuItem.getItemId() == this.waL.UVl) {
                    b.d(this.waL);
                }
                AppMethodBeat.o(253828);
            }
        }
    }

    private final c.d a(e eVar, int i2) {
        AppMethodBeat.i(261494);
        c cVar = c.waP;
        c.AbstractC1316c cVar2 = c.dEK().get(eVar);
        if (cVar2 != null) {
            c.d byd = cVar2.Ma(i2).byd(this.liveData.hwd);
            AppMethodBeat.o(261494);
            return byd;
        }
        AppMethodBeat.o(261494);
        return null;
    }

    public static final /* synthetic */ void a(b bVar) {
        c.d dVar = null;
        AppMethodBeat.i(253831);
        bVar.waJ.clear();
        LinkedList<c.d> linkedList = bVar.waJ;
        c.d a2 = bVar.a(e.LOVE, 1);
        linkedList.offerLast(a2 != null ? a2.awF("1") : null);
        LinkedList<c.d> linkedList2 = bVar.waJ;
        c.d a3 = bVar.a(e.LOVE, 5);
        if (a3 != null) {
            a3.waU = 4000;
            dVar = a3.awF("1");
        }
        linkedList2.offerLast(dVar);
        c cVar = c.waP;
        c.eD(bVar.waJ);
        AppMethodBeat.o(253831);
    }

    public static final /* synthetic */ void b(b bVar) {
        c.d dVar;
        AppMethodBeat.i(253832);
        bVar.waJ.clear();
        LinkedList<c.d> linkedList = bVar.waJ;
        c.d a2 = bVar.a(e.ROCKET, 5);
        if (a2 != null) {
            a2.waU = 150;
        } else {
            a2 = null;
        }
        linkedList.offerLast(a2);
        LinkedList<c.d> linkedList2 = bVar.waJ;
        c.d a3 = bVar.a(e.CALL666, 1);
        if (a3 != null) {
            a3.waU = 250;
        } else {
            a3 = null;
        }
        linkedList2.offerLast(a3);
        for (int i2 = 0; i2 <= 19; i2++) {
            LinkedList<c.d> linkedList3 = bVar.waJ;
            c.d a4 = bVar.a(e.LOVE, 1);
            if (a4 != null) {
                a4.waU = 100 * ((long) i2);
                dVar = a4.awF("1");
            } else {
                dVar = null;
            }
            linkedList3.offerLast(dVar);
        }
        c cVar = c.waP;
        c.eD(bVar.waJ);
        AppMethodBeat.o(253832);
    }

    public static final /* synthetic */ void c(b bVar) {
        c.d dVar;
        AppMethodBeat.i(253833);
        bVar.waJ.clear();
        bVar.waJ.offerLast(bVar.a(e.ROCKET, 1));
        LinkedList<c.d> linkedList = bVar.waJ;
        c.d a2 = bVar.a(e.CALL666, 1);
        if (a2 != null) {
            a2.waU = 1000;
            dVar = a2.dEL();
        } else {
            dVar = null;
        }
        linkedList.offerLast(dVar);
        c cVar = c.waP;
        c.eD(bVar.waJ);
        AppMethodBeat.o(253833);
    }

    public static final /* synthetic */ void d(b bVar) {
        c.d dVar;
        AppMethodBeat.i(261496);
        bVar.waJ.clear();
        List<e> list = bVar.liveData.UPZ;
        p.g(list, "liveData.audienceLinkMicUserList");
        for (T t : list) {
            LinkedList<c.d> linkedList = bVar.waJ;
            c cVar = c.waP;
            c.AbstractC1316c cVar2 = c.dEK().get(e.LOVE);
            linkedList.offerLast(cVar2 != null ? cVar2.Ma(1).byd(t.username) : null);
            LinkedList<c.d> linkedList2 = bVar.waJ;
            c cVar3 = c.waP;
            c.AbstractC1316c cVar4 = c.dEK().get(e.ISLAND);
            if (cVar4 != null) {
                c.d Ma = cVar4.Ma(3);
                Ma.waU = 1000;
                dVar = Ma.byd(t.username);
            } else {
                dVar = null;
            }
            linkedList2.offerLast(dVar);
        }
        c cVar5 = c.waP;
        c.eD(bVar.waJ);
        AppMethodBeat.o(261496);
    }
}
