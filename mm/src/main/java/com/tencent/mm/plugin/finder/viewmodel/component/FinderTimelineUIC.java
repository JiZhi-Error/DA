package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.convert.aj;
import com.tencent.mm.plugin.finder.feed.ai;
import com.tencent.mm.plugin.finder.feed.at;
import com.tencent.mm.plugin.finder.feed.au;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.n;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.upload.b;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.utils.j;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.r;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.LinkedList;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 D2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001DB\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001e\u001a\u00020\u001fJ \u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0012H\u0016J\u000e\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u000bJ\"\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0006\u0010-\u001a\u00020!J\b\u0010.\u001a\u00020\u000bH\u0016J\u0012\u0010/\u001a\u00020!2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00102\u001a\u00020!2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00103\u001a\u00020!2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00104\u001a\u00020!H\u0016J\b\u00105\u001a\u00020!H\u0016J\b\u00106\u001a\u00020!H\u0016J,\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u00122\b\u0010:\u001a\u0004\u0018\u00010\u001f2\b\u0010%\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020!H\u0016J\b\u0010=\u001a\u00020!H\u0016J\b\u0010>\u001a\u00020!H\u0016J(\u0010?\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020\u000b2\b\u0010B\u001a\u0004\u0018\u00010CR\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\n\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000¨\u0006E"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "isEnableFullScreenEnjoy", "", "()Z", "isEnableFullScreenEnjoy$delegate", "Lkotlin/Lazy;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "tabType", "", "getTabType", "()I", "tabType$delegate", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "findBaseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedId", "", "getLayoutId", "getVisibleFeedByUsername", ch.COL_USERNAME, "", "handleCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "selector", "scene", "onActionbarClick", "isDouble", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAutoToLoadMore", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "requestInsert", "keepUnreadSize", "isPrefetch", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "Companion", "plugin-finder_release"})
public final class FinderTimelineUIC extends UIComponent implements i, com.tencent.mm.plugin.finder.api.f {
    public static final a wAK = new a((byte) 0);
    private final kotlin.f tLX = kotlin.g.ah(new b(this));
    ai.b tRV;
    private ai.a tTf;
    private final kotlin.f vPc = kotlin.g.ah(new g(this));

    static {
        AppMethodBeat.i(256034);
        AppMethodBeat.o(256034);
    }

    private final boolean dck() {
        AppMethodBeat.i(256014);
        boolean booleanValue = ((Boolean) this.tLX.getValue()).booleanValue();
        AppMethodBeat.o(256014);
        return booleanValue;
    }

    private final int getTabType() {
        AppMethodBeat.i(256015);
        int intValue = ((Number) this.vPc.getValue()).intValue();
        AppMethodBeat.o(256015);
        return intValue;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
    static final class e extends q implements kotlin.g.a.b<r, Boolean> {
        public static final e wAO = new e();

        static {
            AppMethodBeat.i(256011);
            AppMethodBeat.o(256011);
        }

        e() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(r rVar) {
            AppMethodBeat.i(256010);
            p.h(rVar, LocaleUtil.ITALIAN);
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(256010);
            return bool;
        }
    }

    public static final /* synthetic */ int a(FinderTimelineUIC finderTimelineUIC) {
        AppMethodBeat.i(256035);
        int tabType = finderTimelineUIC.getTabType();
        AppMethodBeat.o(256035);
        return tabType;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderTimelineUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(256032);
        AppMethodBeat.o(256032);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderTimelineUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(256033);
        AppMethodBeat.o(256033);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        AppMethodBeat.i(256016);
        if (dck()) {
            AppMethodBeat.o(256016);
            return R.layout.aki;
        }
        AppMethodBeat.o(256016);
        return R.layout.akn;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreateBefore(Bundle bundle) {
        AppMethodBeat.i(256017);
        if (!isBelongFragment()) {
            h.aU(getActivity());
        }
        AppMethodBeat.o(256017);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(256018);
        ao aoVar = ao.tuE;
        ao.cYb();
        b.a aVar = com.tencent.mm.plugin.finder.upload.b.vRM;
        com.tencent.mm.plugin.finder.upload.b.vRL.dAP();
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(256018);
            throw tVar;
        }
        MMActivity mMActivity = (MMActivity) activity;
        Fragment fragment = getFragment();
        if (!(fragment instanceof FinderHomeTabFragment)) {
            fragment = null;
        }
        this.tTf = new at(mMActivity, (FinderHomeTabFragment) fragment);
        AppCompatActivity activity2 = getActivity();
        if (activity2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(256018);
            throw tVar2;
        }
        MMActivity mMActivity2 = (MMActivity) activity2;
        ai.a aVar2 = this.tTf;
        if (aVar2 == null) {
            p.btv("presenter");
        }
        this.tRV = new au(mMActivity2, aVar2, getRootView(), getFragment());
        ai.a aVar3 = this.tTf;
        if (aVar3 == null) {
            p.btv("presenter");
        }
        ai.b bVar = this.tRV;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        aVar3.onAttach(bVar);
        g.a aVar4 = com.tencent.mm.plugin.finder.upload.g.vSJ;
        com.tencent.mm.plugin.finder.upload.g.vSH.dAZ();
        ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().a(104, this);
        ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().a(108, this);
        boolean a2 = y.a(y.vXH, getTabType(), 0, 2);
        TouchableLayout touchableLayout = (TouchableLayout) getRootView().findViewById(R.id.ify);
        p.g(touchableLayout, LocaleUtil.ITALIAN);
        int paddingLeft = touchableLayout.getPaddingLeft();
        int paddingRight = touchableLayout.getPaddingRight();
        int paddingBottom = touchableLayout.getPaddingBottom();
        if (!a2) {
            touchableLayout.setPadding(paddingLeft, com.tencent.mm.ui.au.eu(getActivity()) + com.tencent.mm.ui.au.getStatusBarHeight(getActivity()), paddingRight, paddingBottom);
        }
        if (a2) {
            int statusBarHeight = com.tencent.mm.ui.au.getStatusBarHeight(getActivity());
            int eu = com.tencent.mm.ui.au.eu(getActivity());
            View findViewById = getRootView().findViewById(R.id.c4);
            p.g(findViewById, "rootView.findViewById<Vi…d.actionBarOverlayLayout)");
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            if (layoutParams == null) {
                t tVar3 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(256018);
                throw tVar3;
            }
            ((FrameLayout.LayoutParams) layoutParams).topMargin = statusBarHeight + eu;
        }
        AppMethodBeat.o(256018);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreateAfter(Bundle bundle) {
        Class<?> cls;
        AppMethodBeat.i(256019);
        if (!isBelongFragment()) {
            h.r((MMActivity) getActivity());
        }
        ai.a aVar = this.tTf;
        if (aVar == null) {
            p.btv("presenter");
        }
        FinderVideoAutoPlayManager finderVideoAutoPlayManager = aVar.getVideoCore().weS;
        if (finderVideoAutoPlayManager != null) {
            StringBuilder sb = new StringBuilder();
            Fragment fragment = getFragment();
            FinderVideoAutoPlayManager.a(finderVideoAutoPlayManager, sb.append((fragment == null || (cls = fragment.getClass()) == null) ? null : cls.getSimpleName()).append("#onViewFocused").toString(), true);
            AppMethodBeat.o(256019);
            return;
        }
        AppMethodBeat.o(256019);
    }

    public final void a(long j2, int i2, boolean z, atn atn) {
        BaseFinderFeed baseFinderFeed;
        int i3;
        com.tencent.mm.view.recyclerview.h hVar;
        int i4 = 0;
        BaseFinderFeed baseFinderFeed2 = null;
        AppMethodBeat.i(256020);
        ai.b bVar = this.tRV;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        RecyclerView.a adapter = bVar.getRecyclerView().getAdapter();
        if (!(adapter instanceof WxRecyclerAdapter)) {
            adapter = null;
        }
        WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
        com.tencent.mm.view.recyclerview.h hVar2 = wxRecyclerAdapter != null ? (com.tencent.mm.view.recyclerview.h) wxRecyclerAdapter.V(j2, false) : null;
        if (hVar2 == null || (baseFinderFeed = (BaseFinderFeed) hVar2.hgv()) == null) {
            AppMethodBeat.o(256020);
            return;
        }
        LinkedList linkedList = new LinkedList();
        ai.b bVar2 = this.tRV;
        if (bVar2 == null) {
            p.btv("viewCallback");
        }
        RecyclerView.LayoutManager layoutManager = bVar2.getRecyclerView().getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            layoutManager = null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager != null) {
            i3 = linearLayoutManager.ks();
        } else {
            i3 = 0;
        }
        if (linearLayoutManager != null) {
            i4 = linearLayoutManager.ku();
        }
        y yVar = y.vXH;
        ai.b bVar3 = this.tRV;
        if (bVar3 == null) {
            p.btv("viewCallback");
        }
        long j3 = y.a(bVar3.getRecyclerView(), i3, i4, (Set) null, 8).feedId;
        if (i3 <= i4) {
            while (true) {
                ai.b bVar4 = this.tRV;
                if (bVar4 == null) {
                    p.btv("viewCallback");
                }
                RecyclerView.v ch = bVar4.getRecyclerView().ch(i3);
                if (!(ch instanceof com.tencent.mm.view.recyclerview.h)) {
                    ch = null;
                }
                com.tencent.mm.view.recyclerview.h hVar3 = (com.tencent.mm.view.recyclerview.h) ch;
                if (hVar3 instanceof com.tencent.mm.view.recyclerview.h) {
                    Object hgv = hVar3.hgv();
                    if (hgv instanceof BaseFinderFeed) {
                        linkedList.add(hgv);
                    }
                }
                if (i3 == i4) {
                    break;
                }
                i3++;
            }
        }
        if (j2 != j3) {
            ai.b bVar5 = this.tRV;
            if (bVar5 == null) {
                p.btv("viewCallback");
            }
            RecyclerView.a adapter2 = bVar5.getRecyclerView().getAdapter();
            if (!(adapter2 instanceof WxRecyclerAdapter)) {
                adapter2 = null;
            }
            WxRecyclerAdapter wxRecyclerAdapter2 = (WxRecyclerAdapter) adapter2;
            if (!(wxRecyclerAdapter2 == null || (hVar = (com.tencent.mm.view.recyclerview.h) wxRecyclerAdapter2.V(j3, false)) == null)) {
                baseFinderFeed2 = (BaseFinderFeed) hVar.hgv();
            }
            if (baseFinderFeed2 != null) {
                ai.a aVar = this.tTf;
                if (aVar == null) {
                    p.btv("presenter");
                }
                aVar.a(baseFinderFeed, baseFinderFeed2, i2, linkedList, z, atn);
            }
        } else {
            ai.a aVar2 = this.tTf;
            if (aVar2 == null) {
                p.btv("presenter");
            }
            aVar2.a(baseFinderFeed, baseFinderFeed, i2, linkedList, z, atn);
        }
        MediaPreloadCore.a aVar3 = MediaPreloadCore.uTV;
        if (MediaPreloadCore.uTU) {
            com.tencent.mm.ac.d.h(new f(baseFinderFeed, this, j2, i2, z, atn));
        }
        AppMethodBeat.o(256020);
    }

    public final void dHX() {
        int i2;
        AppMethodBeat.i(256021);
        ai.b bVar = this.tRV;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        RecyclerView.LayoutManager layoutManager = bVar.getRecyclerView().getLayoutManager();
        if (layoutManager == null) {
            t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
            AppMethodBeat.o(256021);
            throw tVar;
        }
        int ks = ((LinearLayoutManager) layoutManager).ks();
        ai.b bVar2 = this.tRV;
        if (bVar2 == null) {
            p.btv("viewCallback");
        }
        RecyclerView.LayoutManager layoutManager2 = bVar2.getRecyclerView().getLayoutManager();
        if (!(layoutManager2 instanceof LinearLayoutManager)) {
            layoutManager2 = null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager2;
        if (linearLayoutManager != null) {
            linearLayoutManager.ah(0, 0);
        }
        if (ks < 0) {
            ai.b bVar3 = this.tRV;
            if (bVar3 == null) {
                p.btv("viewCallback");
            }
            bVar3.getRecyclerView().post(new c(linearLayoutManager));
        }
        ai.b bVar4 = this.tRV;
        if (bVar4 == null) {
            p.btv("viewCallback");
        }
        bVar4.dcP();
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dsx().value().intValue() == 1) {
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(getActivity());
            if (fH != null) {
                k kVar = k.vfA;
                k.a(fH.dIx(), 5, getTabType());
            }
        }
        aj.a aVar2 = aj.tEf;
        ai.b bVar5 = this.tRV;
        if (bVar5 == null) {
            p.btv("viewCallback");
        }
        Fragment fragment = getFragment();
        if (!(fragment instanceof FinderHomeTabFragment)) {
            fragment = null;
        }
        FinderHomeTabFragment finderHomeTabFragment = (FinderHomeTabFragment) fragment;
        if (finderHomeTabFragment != null) {
            i2 = finderHomeTabFragment.dLS;
        } else {
            i2 = 0;
        }
        aj.a.a(bVar5, i2);
        AppMethodBeat.o(256021);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ LinearLayoutManager tSy;
        final /* synthetic */ boolean wAM = true;

        c(LinearLayoutManager linearLayoutManager) {
            this.tSy = linearLayoutManager;
        }

        public final void run() {
            AppMethodBeat.i(256007);
            LinearLayoutManager linearLayoutManager = this.tSy;
            if (linearLayoutManager != null) {
                linearLayoutManager.ah(this.wAM ? 0 : 1, 0);
                AppMethodBeat.o(256007);
                return;
            }
            AppMethodBeat.o(256007);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(256022);
        Log.i("Finder.TimelineUIC", "errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
        AppMethodBeat.o(256022);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onBackPressed() {
        AppMethodBeat.i(256023);
        if (isBelongFragment()) {
            ai.a aVar = this.tTf;
            if (aVar == null) {
                p.btv("presenter");
            }
            boolean onBackPressed = aVar.onBackPressed();
            AppMethodBeat.o(256023);
            return onBackPressed;
        }
        ai.a aVar2 = this.tTf;
        if (aVar2 == null) {
            p.btv("presenter");
        }
        if (!aVar2.onBackPressed()) {
            getActivity().finish();
            AppMethodBeat.o(256023);
            return true;
        }
        AppMethodBeat.o(256023);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onActivityResult(int i2, int i3, Intent intent) {
        FinderVideoLayout finderVideoLayout;
        long j2;
        AppMethodBeat.i(256024);
        super.onActivityResult(i2, i3, intent);
        if (isUserVisibleFocused() && dck() && -1 == i3 && i2 == 101) {
            ai.b bVar = this.tRV;
            if (bVar == null) {
                p.btv("viewCallback");
            }
            RecyclerView recyclerView = bVar.getRecyclerView();
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                RecyclerView.v ch = recyclerView.ch(((LinearLayoutManager) layoutManager).ks());
                if (!(ch instanceof com.tencent.mm.view.recyclerview.h)) {
                    ch = null;
                }
                com.tencent.mm.view.recyclerview.h hVar = (com.tencent.mm.view.recyclerview.h) ch;
                if (!(hVar == null || (finderVideoLayout = (FinderVideoLayout) hVar.Mn(R.id.ckd)) == null)) {
                    long longExtra = intent != null ? intent.getLongExtra("KEY_CACHE_OBJECT_ID", -1) : -1;
                    if (intent != null) {
                        j2 = intent.getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", -1);
                    } else {
                        j2 = -1;
                    }
                    Log.i("Finder.TimelineUIC", "[onActivityResult] feedId=" + com.tencent.mm.ac.d.zs(longExtra) + " seekTime=" + j2);
                    if (j2 != -1) {
                        finderVideoLayout.setStartPlayTime(j2);
                    }
                    AppMethodBeat.o(256024);
                    return;
                }
            }
        }
        AppMethodBeat.o(256024);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(256025);
        super.onResume();
        ai.a aVar = this.tTf;
        if (aVar == null) {
            p.btv("presenter");
        }
        aVar.onUIResume();
        g.a aVar2 = com.tencent.mm.plugin.finder.upload.g.vSJ;
        if ((com.tencent.mm.plugin.finder.upload.g.vSI) && getTabType() == 3) {
            Log.i("Finder.TimelineUIC", "[onResume] shouldScrollToPostingItem");
            ai.b bVar = this.tRV;
            if (bVar == null) {
                p.btv("viewCallback");
            }
            RecyclerView.LayoutManager layoutManager = bVar.getRecyclerView().getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager != null) {
                linearLayoutManager.ah(0, 0);
            }
            g.a aVar3 = com.tencent.mm.plugin.finder.upload.g.vSJ;
            com.tencent.mm.plugin.finder.upload.g.vSI = false;
        }
        com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
        com.tencent.mm.plugin.finder.report.h.Km(getTabType());
        AppMethodBeat.o(256025);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleFocused() {
        boolean z;
        String str;
        Class<?> cls;
        Intent intent;
        Intent intent2;
        Class<?> cls2;
        int i2 = 0;
        AppMethodBeat.i(256026);
        super.onUserVisibleFocused();
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
        getTabType();
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        ((FinderVideoRecycler) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).J(e.wAO);
        ai.a aVar3 = this.tTf;
        if (aVar3 == null) {
            p.btv("presenter");
        }
        FinderVideoAutoPlayManager finderVideoAutoPlayManager = aVar3.getVideoCore().weS;
        if (finderVideoAutoPlayManager != null) {
            StringBuilder sb = new StringBuilder();
            Fragment fragment = getFragment();
            finderVideoAutoPlayManager.g(sb.append((fragment == null || (cls2 = fragment.getClass()) == null) ? null : cls2.getSimpleName()).append("#onViewFocused").toString(), false, true);
        }
        ai.a aVar4 = this.tTf;
        if (aVar4 == null) {
            p.btv("presenter");
        }
        aVar4.onUserVisibleFocused();
        ai.a aVar5 = this.tTf;
        if (aVar5 == null) {
            p.btv("presenter");
        }
        MMActivity activity = aVar5.getActivity();
        if (activity == null || (intent2 = activity.getIntent()) == null) {
            z = false;
        } else {
            z = intent2.getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);
        }
        ai.a aVar6 = this.tTf;
        if (aVar6 == null) {
            p.btv("presenter");
        }
        MMActivity activity2 = aVar6.getActivity();
        if (!(activity2 == null || (intent = activity2.getIntent()) == null)) {
            intent.removeExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB");
        }
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        boolean Iz = ((PluginFinder) ah).getRedDotManager().Iz(getTabType());
        if (!z || getTabType() != 3) {
            ai.a aVar7 = this.tTf;
            if (aVar7 == null) {
                p.btv("presenter");
            }
            aVar7.M(false, true);
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dsx().value().intValue() == 1 && Iz) {
                FinderReporterUIC.a aVar8 = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(getActivity());
                if (fH != null) {
                    k kVar = k.vfA;
                    k.a(fH.dIx(), 6);
                }
            }
        } else if (z && getTabType() == 3) {
            ai.a aVar9 = this.tTf;
            if (aVar9 == null) {
                p.btv("presenter");
            }
            FinderVideoAutoPlayManager finderVideoAutoPlayManager2 = aVar9.getVideoCore().weS;
            if (finderVideoAutoPlayManager2 != null) {
                StringBuilder sb2 = new StringBuilder();
                Fragment fragment2 = getFragment();
                if (fragment2 == null || (cls = fragment2.getClass()) == null) {
                    str = null;
                } else {
                    str = cls.getSimpleName();
                }
                finderVideoAutoPlayManager2.g(sb2.append(str).append("#onAttach").toString(), false, true);
            }
            ai.a aVar10 = this.tTf;
            if (aVar10 == null) {
                p.btv("presenter");
            }
            aVar10.M(true, false);
            Log.i("Finder.TimelineUIC", "[onUserVisibleFocused] pass this check");
        }
        com.tencent.mm.ui.component.a aVar11 = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.event.base.c MA = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).MA(getTabType());
        if (MA != null) {
            com.tencent.mm.plugin.finder.event.base.k kVar2 = new com.tencent.mm.plugin.finder.event.base.k(getTabType());
            ai.b bVar = this.tRV;
            if (bVar == null) {
                p.btv("viewCallback");
            }
            RecyclerView recyclerView = bVar.getRecyclerView();
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                int ks = ((LinearLayoutManager) layoutManager).ks();
                int ku = ((LinearLayoutManager) layoutManager).ku();
                y yVar = y.vXH;
                kVar2.tIF = y.a(recyclerView, ks, ku, (Set) null, 8).feed;
            }
            MA.b(kVar2);
        }
        if (getActivity() instanceof MMFinderUI) {
            AppCompatActivity activity3 = getActivity();
            if (!(activity3 instanceof MMFinderUI)) {
                activity3 = null;
            }
            MMFinderUI mMFinderUI = (MMFinderUI) activity3;
            if (mMFinderUI != null) {
                i2 = mMFinderUI.getCommentScene();
            }
            com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.dpl().vlR = i2;
        }
        AppMethodBeat.o(256026);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleUnFocused() {
        AppMethodBeat.i(256027);
        super.onUserVisibleUnFocused();
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mp(getTabType());
        ai.a aVar2 = this.tTf;
        if (aVar2 == null) {
            p.btv("presenter");
        }
        aVar2.onUserVisibleUnFocused();
        com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
        com.tencent.mm.plugin.finder.report.h.Kn(getTabType());
        com.tencent.mm.plugin.finder.report.h hVar2 = com.tencent.mm.plugin.finder.report.h.veu;
        com.tencent.mm.plugin.finder.report.h.ar(getTabType(), true);
        com.tencent.mm.plugin.finder.report.f fVar = com.tencent.mm.plugin.finder.report.f.veb;
        com.tencent.mm.plugin.finder.report.f.dnO();
        AppMethodBeat.o(256027);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(256028);
        super.onPause();
        ai.a aVar = this.tTf;
        if (aVar == null) {
            p.btv("presenter");
        }
        aVar.onUIPause();
        com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
        com.tencent.mm.plugin.finder.report.h.dnU();
        AppMethodBeat.o(256028);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onStop() {
        AppMethodBeat.i(256029);
        super.onStop();
        if (getActivity().isFinishing()) {
            com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
            int tabType = getTabType();
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(getActivity());
            com.tencent.mm.plugin.finder.report.h.e(tabType, fH != null ? fH.dIx() : null);
            AppMethodBeat.o(256029);
            return;
        }
        com.tencent.mm.plugin.finder.report.h.d(com.tencent.mm.plugin.finder.report.h.veu, getTabType());
        AppMethodBeat.o(256029);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        bbn bbn;
        AppMethodBeat.i(256030);
        Log.i("Finder.TimelineUIC", "onDestroy");
        ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().b(104, this);
        ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().b(108, this);
        ai.a aVar = this.tTf;
        if (aVar == null) {
            p.btv("presenter");
        }
        aVar.onDetach();
        n nVar = n.uNU;
        n.release();
        com.tencent.mm.ac.d.i(d.wAN);
        ai.b bVar = this.tRV;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        bVar.getRecyclerView().setAdapter(null);
        com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
        int tabType = getTabType();
        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(getActivity());
        if (fH != null) {
            bbn = fH.dIx();
        } else {
            bbn = null;
        }
        com.tencent.mm.plugin.finder.report.h.e(tabType, bbn);
        com.tencent.mm.plugin.finder.report.h hVar2 = com.tencent.mm.plugin.finder.report.h.veu;
        com.tencent.mm.plugin.finder.report.h.dnU();
        AppMethodBeat.o(256030);
    }

    @Override // com.tencent.mm.plugin.finder.api.f
    public final void a(apf apf, int i2, int i3) {
        AppMethodBeat.i(256031);
        p.h(apf, "cmdItem");
        switch (apf.cmdId) {
            case 108:
                ai.a aVar = this.tTf;
                if (aVar == null) {
                    p.btv("presenter");
                }
                aVar.dcO();
                break;
        }
        AppMethodBeat.o(256031);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ FinderTimelineUIC wAL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderTimelineUIC finderTimelineUIC) {
            super(0);
            this.wAL = finderTimelineUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(256006);
            Boolean valueOf = Boolean.valueOf(y.a(y.vXH, FinderTimelineUIC.a(this.wAL), 0, 2));
            AppMethodBeat.o(256006);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ FinderTimelineUIC wAL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(FinderTimelineUIC finderTimelineUIC) {
            super(0);
            this.wAL = finderTimelineUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            int i2;
            AppMethodBeat.i(256013);
            Fragment fragment = this.wAL.getFragment();
            if (!(fragment instanceof FinderHomeTabFragment)) {
                fragment = null;
            }
            FinderHomeTabFragment finderHomeTabFragment = (FinderHomeTabFragment) fragment;
            if (finderHomeTabFragment != null) {
                i2 = finderHomeTabFragment.dLS;
            } else {
                i2 = 0;
            }
            Integer valueOf = Integer.valueOf(i2);
            AppMethodBeat.o(256013);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC$requestInsert$1$1"})
    static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ BaseFinderFeed tEM;
        final /* synthetic */ long vXh;
        final /* synthetic */ FinderTimelineUIC wAL;
        final /* synthetic */ int wAP;
        final /* synthetic */ boolean wAQ;
        final /* synthetic */ atn wAR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(BaseFinderFeed baseFinderFeed, FinderTimelineUIC finderTimelineUIC, long j2, int i2, boolean z, atn atn) {
            super(0);
            this.tEM = baseFinderFeed;
            this.wAL = finderTimelineUIC;
            this.vXh = j2;
            this.wAP = i2;
            this.wAQ = z;
            this.wAR = atn;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            String str;
            AppMethodBeat.i(256012);
            Context context = MMApplicationContext.getContext();
            StringBuilder append = new StringBuilder().append(com.tencent.mm.ac.d.zs(this.tEM.feedObject.getId()).subSequence(0, 5)).append(", ");
            String description = this.tEM.feedObject.getDescription();
            if (description != null) {
                int min = Math.min(description.length(), 3);
                if (description == null) {
                    t tVar = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(256012);
                    throw tVar;
                }
                str = description.substring(0, min);
                p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                str = null;
            }
            Toast.makeText(context, append.append(str).append(" isPrefetch=").append(this.wAQ).toString(), 0).show();
            x xVar = x.SXb;
            AppMethodBeat.o(256012);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        public static final d wAN = new d();

        static {
            AppMethodBeat.i(256009);
            AppMethodBeat.o(256009);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(256008);
            j jVar = j.vVA;
            j.dBI();
            x xVar = x.SXb;
            AppMethodBeat.o(256008);
            return xVar;
        }
    }
}
