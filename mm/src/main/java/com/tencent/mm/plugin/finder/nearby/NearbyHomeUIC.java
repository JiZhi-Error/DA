package com.tencent.mm.plugin.finder.nearby;

import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.support.v4.app.g;
import android.support.v7.app.AppCompatActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.Cif;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment;
import com.tencent.mm.plugin.finder.nearby.person.NearbyPersonFragment;
import com.tencent.mm.plugin.finder.nearby.video.NearbyVideoFragment;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.bbj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\t\u0018\u0000 (2\u00020\u0001:\u0001(B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0016\u001a\u00020\u0014J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\u001fH\u0016J\b\u0010$\u001a\u00020\u001fH\u0016J\u000e\u0010%\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u0014J\u0018\u0010%\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010!J \u0010%\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00112\b\u0010&\u001a\u0004\u0018\u00010!R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/NearbyHomeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "fragmentChangeObserver", "com/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$fragmentChangeObserver$1;", "fragments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "getFragments", "()Ljava/util/ArrayList;", "isCreated", "", "isOpenNearbyLiveFriends", "lastIndex", "", "getActiveFragment", "getCurrentTabType", "getIndex", "type", "getLayoutId", "hasExtStatusFlag", "flag", "", "hasPluginFlag", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "setCurrentTabType", "args", "withAnim", "Companion", "plugin-finder_release"})
public final class NearbyHomeUIC extends UIComponent {
    public static final a uQg = new a((byte) 0);
    private boolean dbG;
    final ArrayList<AbsNearByFragment> fragments;
    private int lastIndex;
    private final IListener<Cif> tOh;
    private boolean uQe;
    private final c uQf;

    static {
        AppMethodBeat.i(249009);
        AppMethodBeat.o(249009);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NearbyHomeUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        boolean z;
        ArrayList<AbsNearByFragment> ac;
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(249008);
        if ((((long) z.aUl()) & 512) == 0) {
            z = true;
        } else {
            z = false;
        }
        this.uQe = z;
        if (this.uQe) {
            ac = j.ac(new NearbyVideoFragment(), new NearbyLiveSquareFragment(), new NearbyPersonFragment());
        } else {
            ac = j.ac(new NearbyVideoFragment(), new NearbyLiveSquareFragment());
        }
        this.fragments = ac;
        this.lastIndex = -1;
        this.uQf = new c(this, appCompatActivity, (MMActivity) appCompatActivity, this.fragments);
        this.tOh = new b(this);
        AppMethodBeat.o(249008);
    }

    public static final /* synthetic */ int a(NearbyHomeUIC nearbyHomeUIC, int i2) {
        AppMethodBeat.i(249010);
        int index = nearbyHomeUIC.getIndex(i2);
        AppMethodBeat.o(249010);
        return index;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/nearby/base/FragmentChangeObserver;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", FirebaseAnalytics.b.INDEX, "fragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "plugin-finder_release"})
    public static final class c extends com.tencent.mm.plugin.finder.nearby.base.b {
        final /* synthetic */ NearbyHomeUIC uQh;
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(NearbyHomeUIC nearbyHomeUIC, AppCompatActivity appCompatActivity, MMActivity mMActivity, List list) {
            super(mMActivity, list);
            this.uQh = nearbyHomeUIC;
            this.uQi = appCompatActivity;
        }

        @Override // com.tencent.mm.plugin.finder.nearby.base.a
        public final void a(AbsNearByFragment absNearByFragment) {
            AppMethodBeat.i(248998);
            p.h(absNearByFragment, "fragment");
            AppMethodBeat.o(248998);
        }

        @Override // com.tencent.mm.plugin.finder.nearby.base.a
        public final void D(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(248999);
            Log.i(FinderFragmentChangeObserver.TAG, "onFragmentChange from:" + i2 + " to:" + i3);
            k kVar = k.vkd;
            k.a(null, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "94", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_RESUME, i4, i5);
            this.uQh.lastIndex = i3;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ViewModel viewModel = com.tencent.mm.ui.component.a.b(this.uQi).get(NearbyActionBarUIC.class);
            p.g(viewModel, "UICProvider.of(activity)…ActionBarUIC::class.java)");
            ((NearbyActionBarUIC) viewModel).Jx(i3);
            AppMethodBeat.o(248999);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$eventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class b extends IListener<Cif> {
        final /* synthetic */ NearbyHomeUIC uQh;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(NearbyHomeUIC nearbyHomeUIC) {
            this.uQh = nearbyHomeUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(Cif ifVar) {
            Cif.a aVar;
            AppMethodBeat.i(248997);
            Cif ifVar2 = ifVar;
            if (!(ifVar2 == null || (aVar = ifVar2.dMQ) == null)) {
                this.uQh.Jz(aVar.dLS);
            }
            AppMethodBeat.o(248997);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.bf7;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        String str;
        String str2;
        AppMethodBeat.i(249001);
        a aVar = a.uQd;
        int dlh = a.dlh();
        Log.i("NearbyHomeUIC", "[onCreate] targetTabType=".concat(String.valueOf(dlh)));
        this.tOh.alive();
        FinderViewPager finderViewPager = (FinderViewPager) getActivity().findViewById(R.id.j7c);
        finderViewPager.setEnableViewPagerScroll(true);
        p.g(finderViewPager, "this");
        g supportFragmentManager = getActivity().getSupportFragmentManager();
        p.g(supportFragmentManager, "activity.supportFragmentManager");
        finderViewPager.setAdapter(new com.tencent.mm.plugin.finder.nearby.base.c(supportFragmentManager, this.fragments));
        finderViewPager.addOnPageChangeListener(this.uQf);
        finderViewPager.setOffscreenPageLimit(3);
        finderViewPager.post(new d(this, dlh));
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        int intValue = com.tencent.mm.plugin.finder.storage.c.dtL().value().intValue();
        if (intValue > 0) {
            an anVar = an.waE;
            an.a(finderViewPager.getContext(), (FinderViewPager) getActivity().findViewById(R.id.j7c), intValue);
        }
        this.dbG = true;
        Jz(dlh);
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        String str3 = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).sGQ;
        if (str3 == null) {
            str = "";
        } else {
            str = str3;
        }
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        com.tencent.mm.plugin.messenger.foundation.a.a.g eiv = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eiv();
        p.g(eiv, "MMKernel.service(IMessen…ass.java).lbsVerifyMsgStg");
        if (eiv.ctM() > 0) {
            str2 = "1001-" + cl.aWA();
        } else {
            str2 = "1003-" + cl.aWA();
        }
        ((aj) com.tencent.mm.kernel.g.ah(aj.class)).checkLastLiveObject();
        com.tencent.mm.plugin.expt.hellhound.core.b.aoW(str);
        com.tencent.mm.plugin.expt.hellhound.core.b.aoV(str2);
        com.tencent.mm.plugin.finder.nearby.report.d dVar = com.tencent.mm.plugin.finder.nearby.report.d.uTq;
        com.tencent.mm.plugin.finder.nearby.report.d.gO(str, str2);
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        f redDotManager = ((PluginFinder) ah).getRedDotManager();
        com.tencent.mm.plugin.finder.extension.reddot.k asX = redDotManager.asX("NearbyEntrance");
        if (!(asX == null || asX.atl("NearbyEntrance") == null || asX.field_ctrInfo.type != 16)) {
            redDotManager.b(asX);
            bbj ata = redDotManager.ata("NearbyLiveTab");
            Integer valueOf = ata != null ? Integer.valueOf(ata.VjG) : null;
            if (valueOf != null) {
                valueOf.intValue();
                Integer num = valueOf.intValue() != 0 ? valueOf : null;
                if (num != null) {
                    num.intValue();
                    axj axj = new axj();
                    axj.LHQ = valueOf.intValue();
                    Bundle bundle2 = new Bundle();
                    bundle2.putByteArray("nearby_live_go_to_square_pge_params_key", axj.toByteArray());
                    AbsNearByFragment absNearByFragment = this.fragments.get(1);
                    p.g(absNearByFragment, "fragments[1]");
                    absNearByFragment.setArguments(bundle2);
                }
            }
            Log.i("NearbyHomeUIC", "[onCreate] targetTabType=" + dlh + " targetTabId=" + valueOf);
        }
        redDotManager.asV("NearbyEntrance");
        AppMethodBeat.o(249001);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$onCreate$1$1"})
    static final class d implements Runnable {
        final /* synthetic */ NearbyHomeUIC uQh;
        final /* synthetic */ int uQj;

        d(NearbyHomeUIC nearbyHomeUIC, int i2) {
            this.uQh = nearbyHomeUIC;
            this.uQj = i2;
        }

        public final void run() {
            AppMethodBeat.i(249000);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ViewModel viewModel = com.tencent.mm.ui.component.a.b(this.uQh.getActivity()).get(NearbyActionBarUIC.class);
            p.g(viewModel, "UICProvider.of(activity)…ActionBarUIC::class.java)");
            ((NearbyActionBarUIC) viewModel).Jx(NearbyHomeUIC.a(this.uQh, this.uQj));
            this.uQh.uQf.onPageSelected(NearbyHomeUIC.a(this.uQh, this.uQj));
            AppMethodBeat.o(249000);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        int dlh;
        AppMethodBeat.i(249002);
        super.onDestroy();
        this.tOh.dead();
        a aVar = a.uQd;
        if (this.dbG) {
            AbsNearByFragment dlj = dlj();
            if (dlj != null) {
                dlh = dlj.dLS;
            } else {
                dlh = 1001;
            }
        } else {
            a aVar2 = a.uQd;
            dlh = a.dlh();
        }
        a.Jy(dlh);
        com.tencent.mm.plugin.finder.extension.reddot.l lVar = com.tencent.mm.plugin.finder.extension.reddot.l.tLu;
        com.tencent.mm.plugin.finder.extension.reddot.l.dbR();
        Log.i("NearbyHomeUIC", "onDestroy fragments:" + this.fragments);
        AppMethodBeat.o(249002);
    }

    public final void Jz(int i2) {
        AppMethodBeat.i(249003);
        int index = getIndex(i2);
        Log.i("NearbyHomeUIC", "setCurrentTabIndex size:" + this.fragments.size() + " index:" + index + " args:" + ((Object) null));
        int size = this.fragments.size();
        if (index < 0) {
            AppMethodBeat.o(249003);
            return;
        }
        if (size > index) {
            FinderViewPager finderViewPager = (FinderViewPager) getActivity().findViewById(R.id.j7c);
            p.g(finderViewPager, "activity.viewPager");
            finderViewPager.setCurrentItem(index);
        }
        AppMethodBeat.o(249003);
    }

    private final int getIndex(int i2) {
        int i3;
        AppMethodBeat.i(249004);
        Iterator<AbsNearByFragment> it = this.fragments.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            if (it.next().dLS == i2) {
                i3 = i4;
                break;
            }
            i4++;
        }
        if (i3 < 0) {
            Log.e("Finder.HomeUIC", "[getIndex] type=" + i2 + " is invalid.");
            AppMethodBeat.o(249004);
            return 0;
        }
        AppMethodBeat.o(249004);
        return i3;
    }

    public final AbsNearByFragment dlj() {
        AppMethodBeat.i(249005);
        FinderViewPager finderViewPager = (FinderViewPager) getActivity().findViewById(R.id.j7c);
        if (finderViewPager == null) {
            Log.e("NearbyHomeUIC", "[getActiveFragment] viewPager==null lastIndex=" + this.lastIndex);
        }
        int currentItem = finderViewPager != null ? finderViewPager.getCurrentItem() : this.lastIndex;
        if (currentItem < 0 || currentItem >= this.fragments.size() || this.fragments.size() == 0) {
            AppMethodBeat.o(249005);
            return null;
        }
        AbsNearByFragment absNearByFragment = this.fragments.get(currentItem);
        AppMethodBeat.o(249005);
        return absNearByFragment;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(249006);
        super.onPause();
        Log.i("NearbyHomeUIC", "onPause()");
        AbsNearByFragment dlj = dlj();
        if (!(dlj instanceof NearbyLiveSquareFragment)) {
            com.tencent.mm.plugin.finder.nearby.report.d dVar = com.tencent.mm.plugin.finder.nearby.report.d.uTq;
            com.tencent.mm.plugin.finder.nearby.report.d.c(dlj);
        }
        AppMethodBeat.o(249006);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(249007);
        super.onResume();
        Log.i("NearbyHomeUIC", "onResume()");
        com.tencent.mm.plugin.finder.nearby.report.d dVar = com.tencent.mm.plugin.finder.nearby.report.d.uTq;
        com.tencent.mm.plugin.finder.nearby.report.d.dlB();
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(getContext());
        bbn dIx = fH != null ? fH.dIx() : null;
        i.a aVar2 = i.tLi;
        i.a.b(1, dIx);
        i.a aVar3 = i.tLi;
        i.a.a(1, dIx, 0);
        i.a aVar4 = i.tLi;
        i.a.c(1, dIx);
        AppMethodBeat.o(249007);
    }
}
