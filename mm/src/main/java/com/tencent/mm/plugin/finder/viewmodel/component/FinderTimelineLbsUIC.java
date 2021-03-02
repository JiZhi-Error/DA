package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.aj;
import com.tencent.mm.plugin.finder.feed.ak;
import com.tencent.mm.plugin.finder.feed.al;
import com.tencent.mm.plugin.finder.feed.am;
import com.tencent.mm.plugin.finder.feed.ap;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.r;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\u0018\u0000 /2\u00020\u0001:\u0001/B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\"\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\b\u0010#\u001a\u00020\u0017H\u0016J\b\u0010$\u001a\u00020\u0017H\u0002J-\u0010%\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00152\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020(0'2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0002\u0010+J\b\u0010,\u001a\u00020\u0017H\u0016J\b\u0010-\u001a\u00020\u0017H\u0016J\b\u0010.\u001a\u00020\u0017H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineLbsUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "autoFlingFlag", "", "getAutoFlingFlag", "()Z", "setAutoFlingFlag", "(Z)V", "hasPermissionWhenPause", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "presenter1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter;", "presenter2", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter;", "viewCallback1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback;", "getLayoutId", "", "onActionbarClick", "", "onActionbarDoubleClick", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinished", "onPause", "onPermissionOk", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public final class FinderTimelineLbsUIC extends UIComponent {
    public static final a wAF = new a((byte) 0);
    private boolean uTD = true;
    private boolean uTE = true;
    private final FinderGlobalLocationVM udf;
    public am wAC;
    public ak wAD;
    private ap wAE;

    static {
        AppMethodBeat.i(255995);
        AppMethodBeat.o(255995);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<r, Boolean> {
        public static final b wAG = new b();

        static {
            AppMethodBeat.i(255982);
            AppMethodBeat.o(255982);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(r rVar) {
            AppMethodBeat.i(255981);
            p.h(rVar, LocaleUtil.ITALIAN);
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(255981);
            return bool;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineLbsUIC$Companion;", "", "()V", "REQUEST_STREAM_CODE", "", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderTimelineLbsUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255994);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
        p.g(viewModel, "UICProvider.of(PluginFin…alLocationVM::class.java)");
        this.udf = (FinderGlobalLocationVM) viewModel;
        AppMethodBeat.o(255994);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.akl;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(255983);
        super.onCreate(bundle);
        c cVar = c.vCb;
        if (c.dst().value().intValue() == 1) {
            AppCompatActivity activity = getActivity();
            if (activity == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(255983);
                throw tVar;
            }
            am amVar = new am((MMActivity) activity, (FinderHomeTabFragment) getFragment());
            this.wAC = amVar;
            AppCompatActivity activity2 = getActivity();
            if (activity2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(255983);
                throw tVar2;
            }
            ap apVar = new ap((MMActivity) activity2, amVar, getRootView());
            amVar.a(apVar);
            this.wAE = apVar;
            AppMethodBeat.o(255983);
            return;
        }
        AppCompatActivity activity3 = getActivity();
        if (activity3 == null) {
            t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255983);
            throw tVar3;
        }
        ak akVar = new ak((MMActivity) activity3, (FinderHomeTabFragment) getFragment());
        this.wAD = akVar;
        AppCompatActivity activity4 = getActivity();
        if (activity4 == null) {
            t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255983);
            throw tVar4;
        }
        akVar.a(new al((MMActivity) activity4, akVar, getRootView()));
        AppMethodBeat.o(255983);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(255984);
        super.onResume();
        if (!this.uTD && FinderGlobalLocationVM.dHO()) {
            dlD();
        }
        h hVar = h.veu;
        h.Km(2);
        k kVar = k.vkd;
        ap apVar = this.wAE;
        k.b(apVar != null ? apVar.getRecyclerView() : null, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, s.j.COMMENT_SCENE_LBS_TOP_LIVE_CARD.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_RESUME);
        AppMethodBeat.o(255984);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(255985);
        super.onPause();
        this.uTD = FinderGlobalLocationVM.dHO();
        k kVar = k.vkd;
        ap apVar = this.wAE;
        k.b(apVar != null ? apVar.getRecyclerView() : null, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, s.j.COMMENT_SCENE_LBS_TOP_LIVE_CARD.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_PAUSE);
        AppMethodBeat.o(255985);
    }

    public final void dlm() {
        AppMethodBeat.i(255986);
        am amVar = this.wAC;
        if (amVar != null) {
            amVar.onActionbarClick(true);
        }
        ak akVar = this.wAD;
        if (akVar != null) {
            akVar.onActionbarClick(true);
            AppMethodBeat.o(255986);
            return;
        }
        AppMethodBeat.o(255986);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleFocused() {
        AppMethodBeat.i(255987);
        super.onUserVisibleFocused();
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
        am amVar = this.wAC;
        if (amVar != null) {
            d.i(new am.j(amVar));
            if (amVar.isEmptyLocation) {
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.ac(amVar.activity, 1);
            }
        }
        ak akVar = this.wAD;
        if (akVar != null) {
            if (akVar.isEmptyLocation) {
                com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.ac(akVar.activity, 1);
            }
            com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
            p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            ((PluginFinder) ah).getRedDotManager().asV("finder_tl_nearby_tab");
            com.tencent.mm.kernel.b.a ah2 = g.ah(PluginFinder.class);
            p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
            ((PluginFinder) ah2).getRedDotManager().gI("finder_tl_nearby_tab", "onRefreshEnd");
        }
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        ((FinderVideoRecycler) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).J(b.wAG);
        this.udf.cxh();
        com.tencent.mm.kernel.b.a ah3 = g.ah(PluginFinder.class);
        p.g(ah3, "MMKernel.plugin(PluginFinder::class.java)");
        if (((PluginFinder) ah3).getRedDotManager().Iz(2)) {
            Log.i("Finder.TimelineLbsUIC", "[onUserVisibleFocused] tabType=2 autoFlingToRefresh");
            am amVar2 = this.wAC;
            if (amVar2 != null) {
                amVar2.ED(0);
            }
            ak akVar2 = this.wAD;
            if (akVar2 != null) {
                akVar2.ED(0);
            }
            c cVar = c.vCb;
            if (c.dsx().value().intValue() == 1) {
                FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(getActivity());
                if (fH != null) {
                    com.tencent.mm.plugin.finder.report.k kVar3 = com.tencent.mm.plugin.finder.report.k.vfA;
                    com.tencent.mm.plugin.finder.report.k.a(fH.dIx(), 6);
                }
            }
        }
        com.tencent.mm.kernel.b.a ah4 = g.ah(PluginFinder.class);
        p.g(ah4, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder) ah4).getRedDotManager().asV("finder_tl_nearby_tab");
        AppMethodBeat.o(255987);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleUnFocused() {
        AppMethodBeat.i(255988);
        super.onUserVisibleUnFocused();
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mp(2);
        AppMethodBeat.o(255988);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onFinished() {
        AppMethodBeat.i(255989);
        super.onFinished();
        am amVar = this.wAC;
        if (amVar != null) {
            aj.b<bo> bVar = amVar.tQZ;
            if (bVar == null) {
                p.btv("viewCallback");
            }
            RecyclerView recyclerView = bVar.getRecyclerView();
            if (recyclerView != null) {
                Log.i("Finder.TimelineLbsPresenter", "[onFinishing] position=" + am.findFirstPosition(recyclerView) + " totalDy=" + amVar.totalDy);
                for (bo boVar : amVar.tRo.getDataListJustForAdapter()) {
                    if (boVar instanceof BaseFinderFeed) {
                        ((BaseFinderFeed) boVar).dku();
                    }
                }
                FinderHomeTabStateVM.a(amVar.tlCache, 2, 0, amVar.totalDy, amVar.tRo.getDataListJustForAdapter());
            }
        }
        ak akVar = this.wAD;
        if (akVar != null) {
            aj.b<com.tencent.mm.plugin.finder.model.c> bVar2 = akVar.tQZ;
            if (bVar2 == null) {
                p.btv("viewCallback");
            }
            RecyclerView recyclerView2 = bVar2.getRecyclerView();
            if (recyclerView2 == null) {
                AppMethodBeat.o(255989);
                return;
            }
            int findFirstPosition = ak.findFirstPosition(recyclerView2);
            Log.i("Finder.FinderTimelineLbsMixPresenter", "[onFinishing] position=" + findFirstPosition + " totalDy=" + akVar.totalDy);
            FinderHomeTabStateVM finderHomeTabStateVM = akVar.tlCache;
            int i2 = akVar.totalDy;
            ArrayList<bo> arrayList = new ArrayList<>(0);
            FinderLbsLoader finderLbsLoader = akVar.tQY;
            if (finderLbsLoader == null) {
                p.btv("feedLoader");
            }
            finderHomeTabStateVM.a(1000, findFirstPosition, i2, arrayList, finderLbsLoader.getDataListJustForAdapter());
            AppMethodBeat.o(255989);
            return;
        }
        AppMethodBeat.o(255989);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        bbn bbn;
        AppMethodBeat.i(255990);
        super.onDestroy();
        k kVar = k.vkd;
        k.b(null, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, s.j.COMMENT_SCENE_LBS_TOP_LIVE_CARD.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_DESTROY);
        am amVar = this.wAC;
        if (amVar != null) {
            amVar.onDetach();
        }
        ak akVar = this.wAD;
        if (akVar != null) {
            akVar.onDetach();
        }
        h hVar = h.veu;
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(getActivity());
        if (fH != null) {
            bbn = fH.dIx();
        } else {
            bbn = null;
        }
        h.e(2, bbn);
        AppMethodBeat.o(255990);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onActivityResult(int i2, int i3, Intent intent) {
        am amVar;
        RecyclerView recyclerView;
        com.tencent.mm.bw.b bVar;
        AppMethodBeat.i(255991);
        if (i2 != 501 || i3 != -1 || intent == null || (amVar = this.wAC) == null) {
            AppMethodBeat.o(255991);
            return;
        }
        p.h(intent, "data");
        aj.b<bo> bVar2 = amVar.tQZ;
        if (bVar2 == null) {
            p.btv("viewCallback");
        }
        if (bVar2 == null || (recyclerView = bVar2.getRecyclerView()) == null) {
            AppMethodBeat.o(255991);
            return;
        }
        y yVar = y.vXH;
        com.tencent.mm.plugin.finder.feed.model.h a2 = y.a(intent, recyclerView, (BaseFeedLoader<bo>) amVar.tRo, false, (kotlin.g.a.b<? super bo, Boolean>) am.k.tRA);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        ao azQ = aAh.azQ();
        y yVar2 = y.vXH;
        azQ.set(y.LK(2), Util.encodeHexString((a2 == null || (bVar = a2.lastBuffer) == null) ? null : bVar.toByteArray()));
        AppMethodBeat.o(255991);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(255992);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        if (i2 == 79) {
            if (iArr[0] == 0) {
                dlD();
                AppMethodBeat.o(255992);
                return;
            }
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.ac(getActivity(), 3);
        }
        AppMethodBeat.o(255992);
    }

    private final void dlD() {
        AppMethodBeat.i(255993);
        if (this.uTE) {
            this.uTE = false;
            am amVar = this.wAC;
            if (amVar != null) {
                amVar.ED(100);
            }
            ak akVar = this.wAD;
            if (akVar != null) {
                akVar.ED(100);
            }
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.ac(getActivity(), 5);
        }
        AppMethodBeat.o(255993);
    }
}
