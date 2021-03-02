package com.tencent.mm.plugin.finder.nearby.live.square;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.q;
import android.support.v7.app.AppCompatActivity;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.Cif;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.tab.NearbyLiveSquareTabFragment;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.ui.f;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b*\u0001\f\u0018\u0000 ?2\u00020\u0001:\u0001?B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\"\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100 J\b\u0010\"\u001a\u0004\u0018\u00010#J\u0006\u0010$\u001a\u00020\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0016H\u0002J\b\u0010'\u001a\u00020\u0016H\u0016J\"\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00162\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010-\u001a\u00020\u001f2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\u001fH\u0016J\u0006\u00101\u001a\u00020\u001fJ\b\u00102\u001a\u00020\u001fH\u0016J-\u00103\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u00162\u000e\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u000206052\u0006\u00107\u001a\u000208H\u0016¢\u0006\u0002\u00109J\u000e\u0010:\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0016J\u0018\u0010:\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u00162\b\u0010;\u001a\u0004\u0018\u00010/J \u0010:\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010<\u001a\u00020\u00142\b\u0010;\u001a\u0004\u0018\u00010/J$\u0010=\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020\u00162\b\b\u0002\u0010<\u001a\u00020\u00142\n\b\u0002\u0010;\u001a\u0004\u0018\u00010/R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMFragmentActivity;", "(Lcom/tencent/mm/ui/MMFragmentActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "fragmentChangeObserver", "com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$fragmentChangeObserver$1;", "fragments", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabFragment;", "getFragments", "()Ljava/util/LinkedList;", "isCreated", "", "lastIndex", "", "livePostHelper", "Lcom/tencent/mm/plugin/finder/ui/FinderLivePostForNearby;", "liveTabLists", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "targetTabInfo", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "addFragments", "", "", "fragmentList", "getActiveFragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "getCurrentTabType", "getIndex", "tabId", "getLayoutId", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onMenuClick", "onPause", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "setCurrentTabId", "args", "withAnim", "setCurrentTabIndex", FirebaseAnalytics.b.INDEX, "Companion", "plugin-finder_release"})
public final class NearbyLiveSquareUIC extends UIComponent {
    public static final a uRK = new a((byte) 0);
    private boolean dbG;
    private int lastIndex = -1;
    private final IListener<Cif> tOh;
    private final FinderHomeTabStateVM tlCache;
    private axj uRG;
    private final LinkedList<NearbyLiveSquareTabFragment> uRH = new LinkedList<>();
    private final LinkedList<axj> uRI = new LinkedList<>();
    private final d uRJ;
    f uRi;

    static {
        AppMethodBeat.i(249203);
        AppMethodBeat.o(249203);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ int b(NearbyLiveSquareUIC nearbyLiveSquareUIC, int i2) {
        AppMethodBeat.i(249204);
        int index = nearbyLiveSquareUIC.getIndex(i2);
        AppMethodBeat.o(249204);
        return index;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NearbyLiveSquareUIC(MMFragmentActivity mMFragmentActivity) {
        super(mMFragmentActivity);
        p.h(mMFragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(249201);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
        p.g(viewModel, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
        this.tlCache = (FinderHomeTabStateVM) viewModel;
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(249201);
            throw tVar;
        }
        this.uRJ = new d(this, (MMActivity) activity, this.uRH);
        this.tOh = new c(this);
        AppMethodBeat.o(249201);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NearbyLiveSquareUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(249202);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
        p.g(viewModel, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
        this.tlCache = (FinderHomeTabStateVM) viewModel;
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(249202);
            throw tVar;
        }
        this.uRJ = new d(this, (MMActivity) activity, this.uRH);
        this.tOh = new c(this);
        AppMethodBeat.o(249202);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/nearby/base/FragmentChangeObserver;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", FirebaseAnalytics.b.INDEX, "fragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "plugin-finder_release"})
    public static final class d extends com.tencent.mm.plugin.finder.nearby.base.b {
        final /* synthetic */ NearbyLiveSquareUIC uRM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(NearbyLiveSquareUIC nearbyLiveSquareUIC, MMActivity mMActivity, List list) {
            super(mMActivity, list);
            this.uRM = nearbyLiveSquareUIC;
        }

        @Override // com.tencent.mm.plugin.finder.nearby.base.a
        public final void a(AbsNearByFragment absNearByFragment) {
            AppMethodBeat.i(249190);
            p.h(absNearByFragment, "fragment");
            AppMethodBeat.o(249190);
        }

        @Override // com.tencent.mm.plugin.finder.nearby.base.a
        public final void D(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(249191);
            Log.i(FinderFragmentChangeObserver.TAG, "onFragmentChange from:" + i2 + " to:" + i3);
            k kVar = k.vkd;
            k.a(null, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "94", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_RESUME, i4, i5);
            this.uRM.lastIndex = i3;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            Fragment fragment = this.uRM.getFragment();
            if (fragment == null) {
                p.hyc();
            }
            ViewModel viewModel = com.tencent.mm.ui.component.a.of(fragment).get(NearbyLiveSquareTabLayoutUIC.class);
            p.g(viewModel, "UICProvider.of(fragment!…TabLayoutUIC::class.java)");
            ((NearbyLiveSquareTabLayoutUIC) viewModel).Jx(i3);
            AppMethodBeat.o(249191);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$eventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class c extends IListener<Cif> {
        final /* synthetic */ NearbyLiveSquareUIC uRM;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(NearbyLiveSquareUIC nearbyLiveSquareUIC) {
            this.uRM = nearbyLiveSquareUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(Cif ifVar) {
            Cif.a aVar;
            AppMethodBeat.i(249189);
            Cif ifVar2 = ifVar;
            if (!(ifVar2 == null || (aVar = ifVar2.dMQ) == null)) {
                this.uRM.JB(aVar.dLS);
            }
            AppMethodBeat.o(249189);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.bff;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        axj axj;
        NearbyLiveSquareUIC nearbyLiveSquareUIC;
        Integer num;
        String str;
        String str2;
        byte[] byteArray;
        String str3 = null;
        AppMethodBeat.i(249192);
        Bundle arguments = getArguments();
        if (arguments == null || (byteArray = arguments.getByteArray("nearby_live_go_to_square_pge_params_key")) == null) {
            axj = null;
            nearbyLiveSquareUIC = this;
        } else {
            com.tencent.mm.bw.a parseFrom = new axj().parseFrom(byteArray);
            if (parseFrom == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveTabInfo");
                AppMethodBeat.o(249192);
                throw tVar;
            }
            axj = (axj) parseFrom;
            nearbyLiveSquareUIC = this;
        }
        nearbyLiveSquareUIC.uRG = axj;
        StringBuilder sb = new StringBuilder("onCreate targetTabInfo=");
        axj axj2 = this.uRG;
        if (axj2 != null) {
            num = Integer.valueOf(axj2.LHQ);
        } else {
            num = null;
        }
        StringBuilder append = sb.append(num).append('-');
        axj axj3 = this.uRG;
        if (axj3 != null) {
            str3 = axj3.LHR;
        }
        Log.i("NearbyLiveSquareUIC", append.append(str3).toString());
        this.tOh.alive();
        this.uRi = new f(getActivity());
        Fragment fragment = getFragment();
        if (fragment == null) {
            p.hyc();
        }
        ((FinderViewPager) fragment.getView().findViewById(R.id.j7c)).setEnableViewPagerScroll(true);
        this.dbG = true;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        Fragment fragment2 = getFragment();
        if (fragment2 == null) {
            p.hyc();
        }
        String str4 = ((FinderReporterUIC) com.tencent.mm.ui.component.a.of(fragment2).get(FinderReporterUIC.class)).sGQ;
        if (str4 == null) {
            str = "";
        } else {
            str = str4;
        }
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        com.tencent.mm.plugin.messenger.foundation.a.a.g eiv = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eiv();
        p.g(eiv, "MMKernel.service(IMessen…ass.java).lbsVerifyMsgStg");
        if (eiv.ctM() > 0) {
            str2 = "1001-" + cl.aWA();
        } else {
            str2 = "1003-" + cl.aWA();
        }
        com.tencent.mm.plugin.expt.hellhound.core.b.aoW(str);
        com.tencent.mm.plugin.expt.hellhound.core.b.aoV(str2);
        com.tencent.mm.plugin.finder.nearby.report.d dVar = com.tencent.mm.plugin.finder.nearby.report.d.uTq;
        com.tencent.mm.plugin.finder.nearby.report.d.gO(str, str2);
        AppMethodBeat.o(249192);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(261252);
        super.onPause();
        f fVar = this.uRi;
        if (fVar == null) {
            p.btv("livePostHelper");
        }
        if (fVar != null) {
            fVar.reset();
            AppMethodBeat.o(261252);
            return;
        }
        AppMethodBeat.o(261252);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(249193);
        super.onDestroy();
        this.tOh.dead();
        AppMethodBeat.o(249193);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(249194);
        f fVar = this.uRi;
        if (fVar == null) {
            p.btv("livePostHelper");
        }
        fVar.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(249194);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(249195);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        f fVar = this.uRi;
        if (fVar == null) {
            p.btv("livePostHelper");
        }
        fVar.onRequestPermissionsResult(i2, strArr, iArr);
        AppMethodBeat.o(249195);
    }

    public final void m(List<? extends axj> list, List<NearbyLiveSquareTabFragment> list2) {
        AppMethodBeat.i(249196);
        p.h(list, "liveTabLists");
        p.h(list2, "fragmentList");
        this.uRI.addAll(list);
        this.uRH.addAll(list2);
        Fragment fragment = getFragment();
        if (fragment == null) {
            p.hyc();
        }
        FinderViewPager finderViewPager = (FinderViewPager) fragment.getView().findViewById(R.id.j7c);
        p.g(finderViewPager, "this");
        Fragment fragment2 = getFragment();
        if (fragment2 == null) {
            p.hyc();
        }
        android.support.v4.app.g childFragmentManager = fragment2.getChildFragmentManager();
        p.g(childFragmentManager, "fragment!!.childFragmentManager");
        finderViewPager.setAdapter(new com.tencent.mm.plugin.finder.nearby.base.c(childFragmentManager, this.uRH));
        finderViewPager.addOnPageChangeListener(this.uRJ);
        finderViewPager.setOffscreenPageLimit(2);
        finderViewPager.post(new b(finderViewPager, this));
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        int intValue = com.tencent.mm.plugin.finder.storage.c.dtL().value().intValue();
        if (intValue > 0) {
            an anVar = an.waE;
            Context context = finderViewPager.getContext();
            Fragment fragment3 = getFragment();
            if (fragment3 == null) {
                p.hyc();
            }
            an.a(context, (FinderViewPager) fragment3.getView().findViewById(R.id.j7c), intValue);
        }
        Fragment fragment4 = getFragment();
        if (fragment4 == null) {
            p.hyc();
        }
        FinderViewPager finderViewPager2 = (FinderViewPager) fragment4.getView().findViewById(R.id.j7c);
        p.g(finderViewPager2, "fragment!!.viewPager");
        q adapter = finderViewPager2.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
            AppMethodBeat.o(249196);
            return;
        }
        AppMethodBeat.o(249196);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$addFragments$1$1"})
    static final class b implements Runnable {
        final /* synthetic */ FinderViewPager uRL;
        final /* synthetic */ NearbyLiveSquareUIC uRM;

        b(FinderViewPager finderViewPager, NearbyLiveSquareUIC nearbyLiveSquareUIC) {
            this.uRL = finderViewPager;
            this.uRM = nearbyLiveSquareUIC;
        }

        public final void run() {
            Integer num;
            String str = null;
            AppMethodBeat.i(249188);
            Fragment fragment = this.uRM.getFragment();
            if (fragment == null) {
                p.hyc();
            }
            if (fragment.getView() == null) {
                Log.i("NearbyLiveSquareUIC", "addFragments after post view is null");
                AppMethodBeat.o(249188);
                return;
            }
            Fragment fragment2 = this.uRM.getFragment();
            if (fragment2 == null) {
                p.hyc();
            }
            if (fragment2.isDetached()) {
                Log.i("NearbyLiveSquareUIC", "addFragments after fragment detached");
                AppMethodBeat.o(249188);
                return;
            }
            axj axj = this.uRM.uRG;
            if (axj != null) {
                StringBuilder sb = new StringBuilder("addFragments go to target page:targetTabInfo=");
                axj axj2 = this.uRM.uRG;
                if (axj2 != null) {
                    num = Integer.valueOf(axj2.LHQ);
                } else {
                    num = null;
                }
                StringBuilder append = sb.append(num).append('-');
                axj axj3 = this.uRM.uRG;
                if (axj3 != null) {
                    str = axj3.LHR;
                }
                Log.i("NearbyLiveSquareUIC", append.append(str).toString());
                this.uRM.JB(axj.LHQ);
                this.uRM.uRJ.onPageSelected(NearbyLiveSquareUIC.b(this.uRM, axj.LHQ));
                AppMethodBeat.o(249188);
                return;
            }
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            Fragment fragment3 = this.uRM.getFragment();
            if (fragment3 == null) {
                p.hyc();
            }
            ViewModel viewModel = com.tencent.mm.ui.component.a.of(fragment3).get(NearbyLiveSquareTabLayoutUIC.class);
            p.g(viewModel, "UICProvider.of(fragment!…TabLayoutUIC::class.java)");
            ((NearbyLiveSquareTabLayoutUIC) viewModel).Jx(0);
            this.uRM.uRJ.onPageSelected(0);
            AppMethodBeat.o(249188);
        }
    }

    public final void JB(int i2) {
        AppMethodBeat.i(249197);
        int index = getIndex(i2);
        int size = this.uRH.size();
        if (index < 0) {
            AppMethodBeat.o(249197);
            return;
        }
        if (size > index) {
            Fragment fragment = getFragment();
            if (fragment == null) {
                p.hyc();
            }
            FinderViewPager finderViewPager = (FinderViewPager) fragment.getView().findViewById(R.id.j7c);
            p.g(finderViewPager, "fragment!!.viewPager");
            finderViewPager.setCurrentItem(index);
        }
        AppMethodBeat.o(249197);
    }

    private final int getIndex(int i2) {
        int i3;
        AppMethodBeat.i(249199);
        Iterator<axj> it = this.uRI.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            if (it.next().LHQ == i2) {
                i3 = i4;
                break;
            }
            i4++;
        }
        if (i3 < 0) {
            Log.e("NearbyLiveSquareUIC", "[getIndex] tabId=" + i2 + " is invalid.");
            AppMethodBeat.o(249199);
            return 0;
        }
        AppMethodBeat.o(249199);
        return i3;
    }

    public final AbsNearByFragment dlj() {
        AppMethodBeat.i(249200);
        Fragment fragment = getFragment();
        if (fragment == null) {
            p.hyc();
        }
        if (fragment.getView() == null) {
            Log.e("NearbyLiveSquareUIC", "[getActiveFragment] view is null");
            AppMethodBeat.o(249200);
            return null;
        }
        Fragment fragment2 = getFragment();
        if (fragment2 == null) {
            p.hyc();
        }
        FinderViewPager finderViewPager = (FinderViewPager) fragment2.getView().findViewById(R.id.j7c);
        if (finderViewPager == null) {
            Log.e("NearbyLiveSquareUIC", "[getActiveFragment] viewPager==null lastIndex=" + this.lastIndex);
        }
        int currentItem = finderViewPager != null ? finderViewPager.getCurrentItem() : this.lastIndex;
        if (currentItem < 0 || currentItem >= this.uRH.size() || this.uRH.size() == 0) {
            AppMethodBeat.o(249200);
            return null;
        }
        NearbyLiveSquareTabFragment nearbyLiveSquareTabFragment = this.uRH.get(currentItem);
        AppMethodBeat.o(249200);
        return nearbyLiveSquareTabFragment;
    }

    public static /* synthetic */ void a(NearbyLiveSquareUIC nearbyLiveSquareUIC, int i2) {
        AppMethodBeat.i(249198);
        Log.i("NearbyLiveSquareUIC", "setCurrentTabIndex size:" + nearbyLiveSquareUIC.uRH.size() + " index:" + i2 + " withAnim:true args:" + ((Object) null));
        int size = nearbyLiveSquareUIC.uRH.size();
        if (i2 < 0) {
            AppMethodBeat.o(249198);
            return;
        }
        if (size > i2) {
            Fragment fragment = nearbyLiveSquareUIC.getFragment();
            if (fragment == null) {
                p.hyc();
            }
            ((FinderViewPager) fragment.getView().findViewById(R.id.j7c)).setCurrentItem(i2, true);
        }
        AppMethodBeat.o(249198);
    }
}
