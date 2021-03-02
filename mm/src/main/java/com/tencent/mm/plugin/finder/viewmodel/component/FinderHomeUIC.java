package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.Cif;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment;
import com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.view.h;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.m;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u000e\u0018\u0000 42\u00020\u0001:\u00014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001c\u001a\u00020\u0012J\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0019J\b\u0010 \u001a\u00020\u0019H\u0002J\u0010\u0010!\u001a\u0004\u0018\u00010\u00122\u0006\u0010\"\u001a\u00020\u0019J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0019J\b\u0010%\u001a\u00020\u0019H\u0016J\b\u0010&\u001a\u00020\u0016H\u0002J\b\u0010'\u001a\u00020\u0016H\u0016J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010,\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010-\u001a\u00020)H\u0016J\b\u0010.\u001a\u00020)H\u0016J\b\u0010/\u001a\u00020)H\u0016J\b\u00100\u001a\u00020)H\u0016J\u000e\u00101\u001a\u00020)2\u0006\u0010$\u001a\u00020\u0019J\u0018\u00101\u001a\u00020)2\u0006\u0010$\u001a\u00020\u00192\b\u00102\u001a\u0004\u0018\u00010+J \u00101\u001a\u00020)2\u0006\u0010$\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u00162\b\u00102\u001a\u0004\u0018\u00010+R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000¨\u00065"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "fragmentChangeListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "getFragmentChangeListeners", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "fragmentChangeObserver", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1;", "fragments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "getFragments", "()Ljava/util/ArrayList;", "isCreated", "", "isFromSns", "lastIndex", "", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getActiveFragment", "getActiveView", "Landroid/view/View;", "getCurrentTabType", "getForceJumpTabType", "getFragmentByTabType", "tabType", "getIndex", "type", "getLayoutId", "isForceJump", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onPause", "onResume", "onStop", "setCurrentTabType", "args", "withAnim", "Companion", "plugin-finder_release"})
public final class FinderHomeUIC extends UIComponent {
    public static final a wxl = new a((byte) 0);
    private boolean dbG;
    final ArrayList<FinderHomeTabFragment> fragments;
    private int lastIndex;
    private final IListener<Cif> tOh;
    private final FinderHomeTabStateVM tlCache;
    private boolean wxc;
    final CopyOnWriteArraySet<h> wxj;
    private final c wxk;

    static {
        AppMethodBeat.i(255652);
        AppMethodBeat.o(255652);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderHomeUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        ArrayList<FinderHomeTabFragment> ac;
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255651);
        com.tencent.mm.kernel.c.a af = g.af(ad.class);
        p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
        boolean dxX = ((ad) af).dxX();
        if (dxX) {
            ac = j.ac(new FinderFollowTabFragment());
        } else if (!dxX) {
            ac = j.ac(new FinderFollowTabFragment(), new FinderFriendTabFragment(), new FinderMachineTabFragment());
        } else {
            m mVar = new m();
            AppMethodBeat.o(255651);
            throw mVar;
        }
        this.fragments = ac;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
        p.g(viewModel, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
        this.tlCache = (FinderHomeTabStateVM) viewModel;
        this.wxj = new CopyOnWriteArraySet<>();
        this.lastIndex = -1;
        this.wxk = new c(this, appCompatActivity, (MMActivity) appCompatActivity, this.fragments);
        this.tOh = new b(this);
        AppMethodBeat.o(255651);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J \u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¨\u0006\u0016"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onPageScrollStateChanged", "state", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", FirebaseAnalytics.b.INDEX, "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "plugin-finder_release"})
    public static final class c extends FinderFragmentChangeObserver {
        final /* synthetic */ AppCompatActivity uQi;
        final /* synthetic */ FinderHomeUIC wxm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderHomeUIC finderHomeUIC, AppCompatActivity appCompatActivity, MMActivity mMActivity, List list) {
            super(mMActivity, list);
            this.wxm = finderHomeUIC;
            this.uQi = appCompatActivity;
        }

        @Override // com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver, com.tencent.mm.plugin.finder.view.h, android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i2, float f2, int i3) {
            AppMethodBeat.i(255630);
            super.onPageScrolled(i2, f2, i3);
            Iterator<T> it = this.wxm.wxj.iterator();
            while (it.hasNext()) {
                it.next().onPageScrolled(i2, f2, i3);
            }
            AppMethodBeat.o(255630);
        }

        @Override // com.tencent.mm.plugin.finder.view.h
        public final void a(boolean z, int i2, FinderHomeTabFragment finderHomeTabFragment) {
            AppMethodBeat.i(255631);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.en(z);
            bVar.pH(i2);
            bVar.bm(finderHomeTabFragment);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", this, bVar.axR());
            p.h(finderHomeTabFragment, "fragment");
            if (z) {
                String name = finderHomeTabFragment.getClass().getName();
                p.g(name, "fragment.javaClass.name");
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEs = name;
            }
            Iterator<T> it = this.wxm.wxj.iterator();
            while (it.hasNext()) {
                it.next().a(z, i2, finderHomeTabFragment);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V");
            AppMethodBeat.o(255631);
        }

        @Override // com.tencent.mm.plugin.finder.view.h
        public final void D(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(255632);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            bVar.pH(i3);
            bVar.pH(i4);
            bVar.pH(i5);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onFragmentChange", "(IIII)V", this, bVar.axR());
            this.wxm.tlCache.wtW = i5;
            this.wxm.tlCache.UVM = i5;
            this.wxm.lastIndex = i3;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ViewModel viewModel = com.tencent.mm.ui.component.a.b(this.uQi).get(FinderHomeActionBarUIC.class);
            p.g(viewModel, "UICProvider.of(activity)…ActionBarUIC::class.java)");
            ((FinderHomeActionBarUIC) viewModel).Jx(i3);
            Iterator<T> it = this.wxm.wxj.iterator();
            while (it.hasNext()) {
                it.next().D(i2, i3, i4, i5);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", "onFragmentChange", "(IIII)V");
            AppMethodBeat.o(255632);
        }

        @Override // com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver, com.tencent.mm.plugin.finder.view.h, android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i2) {
            AppMethodBeat.i(255633);
            Iterator<T> it = this.wxm.wxj.iterator();
            while (it.hasNext()) {
                it.next().onPageScrollStateChanged(i2);
            }
            AppMethodBeat.o(255633);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$eventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class b extends IListener<Cif> {
        final /* synthetic */ FinderHomeUIC wxm;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(FinderHomeUIC finderHomeUIC) {
            this.wxm = finderHomeUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(Cif ifVar) {
            Cif.a aVar;
            AppMethodBeat.i(255629);
            Cif ifVar2 = ifVar;
            if (!(ifVar2 == null || (aVar = ifVar2.dMQ) == null)) {
                this.wxm.p(aVar.dLS, null);
            }
            AppMethodBeat.o(255629);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.ac8;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01a7  */
    @Override // com.tencent.mm.ui.component.UIComponent
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r15) {
        /*
        // Method dump skipped, instructions count: 442
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC.onCreate(android.os.Bundle):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$onCreate$2$1"})
    static final class d implements Runnable {
        final /* synthetic */ FinderHomeUIC wxm;
        final /* synthetic */ int wxn;

        d(FinderHomeUIC finderHomeUIC, int i2) {
            this.wxm = finderHomeUIC;
            this.wxn = i2;
        }

        public final void run() {
            AppMethodBeat.i(255634);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ViewModel viewModel = com.tencent.mm.ui.component.a.b(this.wxm.getActivity()).get(FinderHomeActionBarUIC.class);
            p.g(viewModel, "UICProvider.of(activity)…ActionBarUIC::class.java)");
            ((FinderHomeActionBarUIC) viewModel).Jx(this.wxm.getIndex(this.wxn));
            this.wxm.wxk.onPageSelected(this.wxm.getIndex(this.wxn));
            AppMethodBeat.o(255634);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreateAfter(Bundle bundle) {
        AppMethodBeat.i(255638);
        super.onCreateAfter(bundle);
        if (getIntent().getBooleanExtra("KEY_POST_DIRECTLY_FROM_SNS", false) || getIntent().getBooleanExtra("KEY_FROM_SHARE_REL", false)) {
            String stringExtra = getIntent().getStringExtra("key_context_id");
            if (stringExtra == null) {
                stringExtra = "";
            }
            i.a aVar = i.tLi;
            i.a.dw(stringExtra, 1);
        }
        int intExtra = getIntent().getIntExtra("FROM_SCENE_KEY", 2);
        com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder) ah).getRedDotManager().Iw(intExtra);
        AppMethodBeat.o(255638);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        RecyclerView recyclerView = null;
        AppMethodBeat.i(255639);
        super.onResume();
        switch (this.tlCache.wtW) {
            case 1:
                k kVar = k.vkd;
                k kVar2 = k.vkd;
                WeakReference<RecyclerView> weakReference = k.dpl().vmq;
                if (weakReference != null) {
                    recyclerView = weakReference.get();
                }
                k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, s.j.COMMENT_SCENE_FRIEND_TAB_AVATAR_FLOW.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_RESUME);
                AppMethodBeat.o(255639);
                return;
            case 3:
                k kVar3 = k.vkd;
                k kVar4 = k.vkd;
                WeakReference<RecyclerView> weakReference2 = k.dpl().vmq;
                if (weakReference2 != null) {
                    recyclerView = weakReference2.get();
                }
                k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, s.j.COMMENT_SCENE_FOLLOW_TAB_AVATAR_FLOW.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_RESUME);
                AppMethodBeat.o(255639);
                return;
            case 4:
                k kVar5 = k.vkd;
                k kVar6 = k.vkd;
                WeakReference<RecyclerView> weakReference3 = k.dpl().vmq;
                if (weakReference3 != null) {
                    recyclerView = weakReference3.get();
                }
                k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR, "20", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_RESUME);
                break;
        }
        AppMethodBeat.o(255639);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        RecyclerView recyclerView = null;
        AppMethodBeat.i(255640);
        super.onPause();
        switch (this.tlCache.wtW) {
            case 1:
                k kVar = k.vkd;
                k kVar2 = k.vkd;
                WeakReference<RecyclerView> weakReference = k.dpl().vmq;
                if (weakReference != null) {
                    recyclerView = weakReference.get();
                }
                k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, s.j.COMMENT_SCENE_FRIEND_TAB_AVATAR_FLOW.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_PAUSE);
                AppMethodBeat.o(255640);
                return;
            case 3:
                k kVar3 = k.vkd;
                k kVar4 = k.vkd;
                WeakReference<RecyclerView> weakReference2 = k.dpl().vmq;
                if (weakReference2 != null) {
                    recyclerView = weakReference2.get();
                }
                k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, s.j.COMMENT_SCENE_FOLLOW_TAB_AVATAR_FLOW.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_PAUSE);
                AppMethodBeat.o(255640);
                return;
            case 4:
                k kVar5 = k.vkd;
                k kVar6 = k.vkd;
                WeakReference<RecyclerView> weakReference3 = k.dpl().vmq;
                if (weakReference3 != null) {
                    recyclerView = weakReference3.get();
                }
                k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR, "20", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_PAUSE);
                break;
        }
        AppMethodBeat.o(255640);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onStop() {
        AppMethodBeat.i(255641);
        super.onStop();
        if (getActivity().isFinishing()) {
            com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
            p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            ((PluginFinder) ah).getRedDotManager().daB();
        }
        AppMethodBeat.o(255641);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(255642);
        super.onDestroy();
        switch (this.tlCache.wtW) {
            case 1:
                k kVar = k.vkd;
                k.b(null, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, s.j.COMMENT_SCENE_FRIEND_TAB_AVATAR_FLOW.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_DESTROY);
                break;
            case 3:
                k kVar2 = k.vkd;
                k.b(null, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, s.j.COMMENT_SCENE_FOLLOW_TAB_AVATAR_FLOW.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_DESTROY);
                break;
        }
        this.tlCache.a(getActiveFragment().dLS, FinderHomeTabStateVM.c.SOURCE_EXIT);
        this.tlCache.Mp(getActiveFragment().dLS);
        this.tOh.dead();
        as asVar = as.uOL;
        as.stopTimer();
        com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder) ah).getRedDotManager().daC();
        AppMethodBeat.o(255642);
    }

    public final void p(int i2, Bundle bundle) {
        AppMethodBeat.i(255643);
        int index = getIndex(i2);
        int size = this.fragments.size();
        if (index < 0) {
            AppMethodBeat.o(255643);
            return;
        }
        if (size > index) {
            if (bundle != null) {
                this.fragments.get(index).Ew = bundle;
            }
            this.tlCache.wtW = i2;
            this.tlCache.UVM = i2;
            FinderViewPager finderViewPager = (FinderViewPager) getActivity().findViewById(R.id.j7c);
            p.g(finderViewPager, "activity.viewPager");
            finderViewPager.setCurrentItem(index);
        }
        AppMethodBeat.o(255643);
    }

    public final void a(boolean z, Bundle bundle) {
        AppMethodBeat.i(255644);
        int index = getIndex(4);
        int size = this.fragments.size();
        if (index < 0) {
            AppMethodBeat.o(255644);
            return;
        }
        if (size > index) {
            this.fragments.get(index).Ew = bundle;
            this.tlCache.wtW = 4;
            this.tlCache.UVM = 4;
            ((FinderViewPager) getActivity().findViewById(R.id.j7c)).setCurrentItem(index, z);
        }
        AppMethodBeat.o(255644);
    }

    public final int dIf() {
        AppMethodBeat.i(255645);
        if (this.dbG) {
            int i2 = getActiveFragment().dLS;
            AppMethodBeat.o(255645);
            return i2;
        } else if (dIh()) {
            int dIg = dIg();
            AppMethodBeat.o(255645);
            return dIg;
        } else {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            int dHR = ((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).dHR();
            AppMethodBeat.o(255645);
            return dHR;
        }
    }

    private final int dIg() {
        AppMethodBeat.i(255646);
        boolean booleanExtra = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB", false);
        boolean booleanExtra3 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", false);
        if (booleanExtra) {
            AppMethodBeat.o(255646);
            return 3;
        } else if (booleanExtra2) {
            AppMethodBeat.o(255646);
            return 1;
        } else if (booleanExtra3) {
            AppMethodBeat.o(255646);
            return 4;
        } else {
            AppMethodBeat.o(255646);
            return -1;
        }
    }

    private final boolean dIh() {
        AppMethodBeat.i(255647);
        boolean booleanExtra = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB", false);
        boolean booleanExtra3 = getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", false);
        if (booleanExtra || booleanExtra2 || booleanExtra3) {
            AppMethodBeat.o(255647);
            return true;
        }
        AppMethodBeat.o(255647);
        return false;
    }

    public final int getIndex(int i2) {
        int i3;
        AppMethodBeat.i(255648);
        Iterator<FinderHomeTabFragment> it = this.fragments.iterator();
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
            AppMethodBeat.o(255648);
            return 0;
        }
        AppMethodBeat.o(255648);
        return i3;
    }

    public final FinderHomeTabFragment getActiveFragment() {
        AppMethodBeat.i(255649);
        FinderViewPager finderViewPager = (FinderViewPager) getActivity().findViewById(R.id.j7c);
        if (finderViewPager == null) {
            Log.e("Finder.HomeUIC", "[getActiveFragment] viewPager==null lastIndex=" + this.lastIndex);
        }
        FinderHomeTabFragment finderHomeTabFragment = this.fragments.get(finderViewPager != null ? finderViewPager.getCurrentItem() : this.lastIndex);
        p.g(finderHomeTabFragment, "fragments[index]");
        FinderHomeTabFragment finderHomeTabFragment2 = finderHomeTabFragment;
        AppMethodBeat.o(255649);
        return finderHomeTabFragment2;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onBackPressed() {
        AppMethodBeat.i(255650);
        if (this.wxc) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.addFlags(536870912);
            intent.putExtra("preferred_tab", 2);
            com.tencent.mm.br.c.f(getActivity(), ".ui.LauncherUI", intent);
            getActivity().overridePendingTransition(MMFragmentActivity.a.ogo, MMFragmentActivity.a.ogp);
            AppMethodBeat.o(255650);
            return true;
        }
        AppMethodBeat.o(255650);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        public static final e wxo = new e();

        static {
            AppMethodBeat.i(255636);
            AppMethodBeat.o(255636);
        }

        e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(255635);
            Log.i("Finder.HomeUIC", "buildInfo=" + BuildInfo.info() + ", LogSync=" + XLogSetup.appendIsSync + " isExDeviceEnv=" + z.aUh() + " inTabletEnv=" + ao.gJH());
            x xVar = x.SXb;
            AppMethodBeat.o(255635);
            return xVar;
        }
    }
}
