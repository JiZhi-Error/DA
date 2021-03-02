package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver;
import com.tencent.mm.plugin.finder.view.adapter.a;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.t;

public abstract class FinderTabUIC extends UIComponent {
    public static final a wAy = new a((byte) 0);
    private boolean bex;
    public List<? extends FinderHomeTabFragment> fragments;
    private int lastIndex = -1;
    public com.tencent.mm.plugin.finder.view.tabcomp.g tabContainer;
    public IFinderTabProvider tabProvider;
    public com.tencent.mm.plugin.finder.view.tabcomp.f tabViewAction;
    public List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a> tabs;
    protected ViewPager uO;
    protected TabLayout wAv;
    private com.tencent.mm.plugin.finder.view.adapter.c wAw;
    private com.tencent.mm.plugin.finder.view.adapter.a<FinderHomeTabFragment> wAx;
    final CopyOnWriteArraySet<com.tencent.mm.plugin.finder.view.h> wxj = new CopyOnWriteArraySet<>();

    public abstract IFinderTabProvider cXB();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderTabUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
    }

    public static final /* synthetic */ void d(FinderTabUIC finderTabUIC) {
        ViewGroup viewGroup;
        Object obj;
        boolean z;
        ViewGroup.LayoutParams layoutParams;
        TabLayout.f ab;
        View childAt;
        TabLayout tabLayout = finderTabUIC.wAv;
        if (tabLayout != null) {
            int tabCount = tabLayout.getTabCount();
            TabLayout tabLayout2 = finderTabUIC.wAv;
            if (tabLayout2 == null || (childAt = tabLayout2.getChildAt(0)) == null) {
                viewGroup = null;
            } else if (childAt == null) {
                throw new t("null cannot be cast to non-null type android.view.ViewGroup");
            } else {
                viewGroup = (ViewGroup) childAt;
            }
            if (viewGroup != null) {
                int i2 = 0;
                boolean z2 = false;
                while (i2 < tabCount) {
                    TabLayout tabLayout3 = finderTabUIC.wAv;
                    if (tabLayout3 == null || (ab = tabLayout3.ab(i2)) == null) {
                        obj = null;
                    } else {
                        obj = ab.getTag();
                    }
                    if (obj == null) {
                        throw new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
                    }
                    int[] cXC = ((com.tencent.mm.plugin.finder.view.tabcomp.a) obj).cXC();
                    if (cXC[0] > 0 || cXC[1] > 0) {
                        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(viewGroup.getContext(), cXC[0]);
                        int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix(viewGroup.getContext(), cXC[1]);
                        if (!(fromDPToPix == 0 && fromDPToPix2 == 0)) {
                            if (viewGroup != null) {
                                ViewGroup viewGroup2 = viewGroup.getChildCount() > i2 && i2 >= 0 ? viewGroup : null;
                                if (viewGroup2 != null) {
                                    View childAt2 = viewGroup2.getChildAt(i2);
                                    if (childAt2 != null) {
                                        layoutParams = childAt2.getLayoutParams();
                                    } else {
                                        layoutParams = null;
                                    }
                                    if (layoutParams instanceof LinearLayout.LayoutParams) {
                                        ((LinearLayout.LayoutParams) layoutParams).leftMargin = fromDPToPix;
                                        ((LinearLayout.LayoutParams) layoutParams).rightMargin = fromDPToPix2;
                                    }
                                }
                            }
                            Log.i("Finder.FinderTabUIC", "setMargins : invalidate".concat(String.valueOf(i2)));
                        }
                        z = true;
                    } else {
                        z = z2;
                    }
                    i2++;
                    z2 = z;
                }
                if (z2) {
                    viewGroup.requestLayout();
                }
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment>, java.util.List<com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment> */
    public final List<FinderHomeTabFragment> getFragments() {
        List list = this.fragments;
        if (list == null) {
            p.btv("fragments");
        }
        return list;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a>, java.util.List<com.tencent.mm.plugin.finder.view.tabcomp.a> */
    public final List<com.tencent.mm.plugin.finder.view.tabcomp.a> getTabs() {
        List list = this.tabs;
        if (list == null) {
            p.btv("tabs");
        }
        return list;
    }

    public final com.tencent.mm.plugin.finder.view.tabcomp.f getTabViewAction() {
        com.tencent.mm.plugin.finder.view.tabcomp.f fVar = this.tabViewAction;
        if (fVar == null) {
            p.btv("tabViewAction");
        }
        return fVar;
    }

    public final com.tencent.mm.plugin.finder.view.tabcomp.g getTabContainer() {
        com.tencent.mm.plugin.finder.view.tabcomp.g gVar = this.tabContainer;
        if (gVar == null) {
            p.btv("tabContainer");
        }
        return gVar;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onCreate(Bundle bundle) {
        dIK();
        super.onCreate(bundle);
        List<? extends FinderHomeTabFragment> list = this.fragments;
        if (list == null) {
            p.btv("fragments");
        }
        int size = list.size();
        List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a> list2 = this.tabs;
        if (list2 == null) {
            p.btv("tabs");
        }
        if (size != list2.size()) {
            Log.e("Finder.FinderTabUIC", "fragments size must not be equal to tabs");
            throw new IllegalArgumentException("FinderTabUIC: fragments size must not be equal to tabs");
        }
        com.tencent.mm.plugin.finder.view.tabcomp.g gVar = this.tabContainer;
        if (gVar == null) {
            p.btv("tabContainer");
        }
        Window window = getActivity().getWindow();
        p.g(window, "activity.window");
        gVar.c(window);
        if (this.tabProvider != null) {
            com.tencent.mm.plugin.finder.view.tabcomp.g gVar2 = this.tabContainer;
            if (gVar2 == null) {
                p.btv("tabContainer");
            }
            this.wAv = gVar2.dHJ();
            com.tencent.mm.plugin.finder.view.tabcomp.g gVar3 = this.tabContainer;
            if (gVar3 == null) {
                p.btv("tabContainer");
            }
            this.uO = gVar3.dHL();
        }
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            throw new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        }
        ((MMActivity) activity).setTitleBarClickListener(new f(this), new g(this));
        com.tencent.mm.plugin.finder.view.tabcomp.g gVar4 = this.tabContainer;
        if (gVar4 == null) {
            p.btv("tabContainer");
        }
        View backBtn = gVar4.getBackBtn();
        if (backBtn != null) {
            backBtn.setOnClickListener(new h(this));
        }
        AppCompatActivity activity2 = getActivity();
        if (activity2 == null) {
            throw new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        }
        MMActivity mMActivity = (MMActivity) activity2;
        List<? extends FinderHomeTabFragment> list3 = this.fragments;
        if (list3 == null) {
            p.btv("fragments");
        }
        e eVar = new e(this, mMActivity, list3);
        ViewPager viewPager = this.uO;
        if (viewPager != null) {
            if (this.bex) {
                android.support.v4.app.g supportFragmentManager = getActivity().getSupportFragmentManager();
                p.g(supportFragmentManager, "activity.supportFragmentManager");
                List<? extends FinderHomeTabFragment> list4 = this.fragments;
                if (list4 == null) {
                    p.btv("fragments");
                }
                if (list4 == null) {
                    throw new t("null cannot be cast to non-null type kotlin.collections.MutableList<com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment>");
                }
                this.wAx = new com.tencent.mm.plugin.finder.view.adapter.a<>(viewPager, supportFragmentManager, af.eY(list4));
                viewPager.setAdapter(this.wAx);
                List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a> list5 = this.tabs;
                if (list5 == null) {
                    p.btv("tabs");
                }
                viewPager.setOffscreenPageLimit(j.na(list5.size() + 3, 5));
            } else {
                android.support.v4.app.g supportFragmentManager2 = getActivity().getSupportFragmentManager();
                p.g(supportFragmentManager2, "activity.supportFragmentManager");
                List<? extends FinderHomeTabFragment> list6 = this.fragments;
                if (list6 == null) {
                    p.btv("fragments");
                }
                this.wAw = new com.tencent.mm.plugin.finder.view.adapter.c(supportFragmentManager2, list6);
                viewPager.setAdapter(this.wAw);
                List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a> list7 = this.tabs;
                if (list7 == null) {
                    p.btv("tabs");
                }
                viewPager.setOffscreenPageLimit(list7.size() + 1);
            }
            viewPager.addOnPageChangeListener(eVar);
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            int intValue = com.tencent.mm.plugin.finder.storage.c.dtL().value().intValue();
            if (intValue > 0) {
                an anVar = an.waE;
                an.a(viewPager.getContext(), viewPager, intValue);
            }
        }
        dId();
        com.tencent.mm.plugin.finder.view.tabcomp.g gVar5 = this.tabContainer;
        if (gVar5 == null) {
            p.btv("tabContainer");
        }
        HardTouchableLayout dHK = gVar5.dHK();
        if (dHK != null) {
            dHK.setOnDoubleClickListener(new d(this));
        }
        aw(0, false);
    }

    public static final class f implements Runnable {
        final /* synthetic */ FinderTabUIC wAz;

        f(FinderTabUIC finderTabUIC) {
            this.wAz = finderTabUIC;
        }

        public final void run() {
            AppMethodBeat.i(255978);
            FinderTabUIC.a(this.wAz);
            AppMethodBeat.o(255978);
        }
    }

    public static final class g implements Runnable {
        final /* synthetic */ FinderTabUIC wAz;

        g(FinderTabUIC finderTabUIC) {
            this.wAz = finderTabUIC;
        }

        public final void run() {
            AppMethodBeat.i(255979);
            FinderTabUIC.b(this.wAz);
            AppMethodBeat.o(255979);
        }
    }

    public static final class h implements View.OnClickListener {
        final /* synthetic */ FinderTabUIC wAz;

        h(FinderTabUIC finderTabUIC) {
            this.wAz = finderTabUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255980);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.wAz.dIp();
            if (!this.wAz.getActivity().isFinishing()) {
                this.wAz.getActivity().finish();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255980);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public int getLayoutId() {
        dIK();
        com.tencent.mm.plugin.finder.view.tabcomp.g gVar = this.tabContainer;
        if (gVar == null) {
            p.btv("tabContainer");
        }
        return gVar.getLayoutId();
    }

    private final void dIK() {
        if (!dIL()) {
            this.tabProvider = cXB();
            dIO();
        }
    }

    private boolean dIL() {
        return this.tabProvider != null;
    }

    public void dIp() {
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onDestroy() {
        super.onDestroy();
        Log.i("Finder.FinderTabUIC", "onDestroy");
        com.tencent.mm.plugin.finder.view.adapter.a<FinderHomeTabFragment> aVar = this.wAx;
        if (aVar != null) {
            Log.i("Finder.DynamicAdapter", "removePendingActions");
            if (aVar.wrc != null) {
                aVar.uO.removeCallbacks(aVar.wrc);
            }
            aVar.wra.clear();
            aVar.wrb.clear();
        }
    }

    public final void aw(int i2, boolean z) {
        TabLayout.f ab;
        TabLayout tabLayout = this.wAv;
        if (tabLayout != null) {
            if (!(i2 >= 0 && i2 < tabLayout.getTabCount())) {
                tabLayout = null;
            }
            if (tabLayout != null && (ab = tabLayout.ab(i2)) != null) {
                if (z || !ab.isSelected()) {
                    Log.i("Finder.FinderTabUIC", "select :".concat(String.valueOf(i2)));
                    ab.select();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        if (r0 >= r1.size()) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment getActiveFragment() {
        /*
            r3 = this;
            android.support.v4.view.ViewPager r0 = r3.uO
            if (r0 == 0) goto L_0x002c
            int r0 = r0.getCurrentItem()
        L_0x0008:
            if (r0 < 0) goto L_0x001a
            java.util.List<? extends com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment> r1 = r3.fragments
            if (r1 != 0) goto L_0x0014
            java.lang.String r2 = "fragments"
            kotlin.g.b.p.btv(r2)
        L_0x0014:
            int r1 = r1.size()
            if (r0 < r1) goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            java.util.List<? extends com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment> r1 = r3.fragments
            if (r1 != 0) goto L_0x0025
            java.lang.String r2 = "fragments"
            kotlin.g.b.p.btv(r2)
        L_0x0025:
            java.lang.Object r0 = r1.get(r0)
            com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment r0 = (com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment) r0
            return r0
        L_0x002c:
            int r0 = r3.lastIndex
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC.getActiveFragment():com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
    }

    public final int dIM() {
        ViewPager viewPager = this.uO;
        return viewPager != null ? viewPager.getCurrentItem() : this.lastIndex;
    }

    public final com.tencent.mm.plugin.finder.view.tabcomp.a MI(int i2) {
        List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a> list = this.tabs;
        if (list == null) {
            p.btv("tabs");
        }
        if (!(i2 >= 0 && i2 < list.size())) {
            list = null;
        }
        if (list == null) {
            return null;
        }
        List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a> list2 = this.tabs;
        if (list2 == null) {
            p.btv("tabs");
        }
        return (com.tencent.mm.plugin.finder.view.tabcomp.a) list2.get(i2);
    }

    public final void a(com.tencent.mm.plugin.finder.view.tabcomp.a aVar, FinderHomeTabFragment finderHomeTabFragment) {
        p.h(aVar, "tab");
        p.h(finderHomeTabFragment, "fragment");
        List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a> list = this.tabs;
        if (list == null) {
            p.btv("tabs");
        }
        a(list.size(), aVar, finderHomeTabFragment, false);
    }

    /* access modifiers changed from: public */
    private void a(int i2, com.tencent.mm.plugin.finder.view.tabcomp.a aVar, FinderHomeTabFragment finderHomeTabFragment, boolean z) {
        p.h(aVar, "tab");
        p.h(finderHomeTabFragment, "fragment");
        if (this.bex) {
            List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a> list = this.tabs;
            if (list == null) {
                p.btv("tabs");
            }
            if (af.eX(list)) {
                if (i2 >= 0) {
                    List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a> list2 = this.tabs;
                    if (list2 == null) {
                        p.btv("tabs");
                    }
                    if (i2 <= list2.size()) {
                        aVar.index = i2;
                        List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a> list3 = this.tabs;
                        if (list3 == null) {
                            p.btv("tabs");
                        }
                        if (list3 == null) {
                            throw new t("null cannot be cast to non-null type kotlin.collections.MutableList<com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab>");
                        }
                        af.eY(list3).add(i2, aVar);
                        TabLayout tabLayout = this.wAv;
                        if (tabLayout != null) {
                            a(tabLayout, aVar, i2);
                        }
                        com.tencent.mm.plugin.finder.view.adapter.a<FinderHomeTabFragment> aVar2 = this.wAx;
                        if (aVar2 != null) {
                            aVar2.a(new a.C1328a(true, i2), finderHomeTabFragment);
                        }
                    }
                }
                dnx();
                return;
            }
        }
        Log.e("Finder.FinderTabUIC", "addTabAndFragment param error");
    }

    public void dnx() {
        List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a> list = this.tabs;
        if (list == null) {
            p.btv("tabs");
        }
        if (list.size() <= 1) {
            com.tencent.mm.plugin.finder.view.tabcomp.g gVar = this.tabContainer;
            if (gVar == null) {
                p.btv("tabContainer");
            }
            HardTouchableLayout dHK = gVar.dHK();
            if (dHK != null) {
                dHK.setVisibility(8);
                return;
            }
            return;
        }
        com.tencent.mm.plugin.finder.view.tabcomp.g gVar2 = this.tabContainer;
        if (gVar2 == null) {
            p.btv("tabContainer");
        }
        HardTouchableLayout dHK2 = gVar2.dHK();
        if (dHK2 != null) {
            dHK2.setVisibility(0);
        }
    }

    public final boolean MJ(int i2) {
        List<? extends FinderHomeTabFragment> list = this.fragments;
        if (list == null) {
            p.btv("fragments");
        }
        for (FinderHomeTabFragment finderHomeTabFragment : list) {
            if (finderHomeTabFragment.dLS == i2) {
                return true;
            }
        }
        return false;
    }

    public final void dIN() {
        List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a> list = this.tabs;
        if (list == null) {
            p.btv("tabs");
        }
        gx(list.size() - 1, -1);
    }

    public final void gw(int i2, int i3) {
        int i4 = -1;
        List<? extends FinderHomeTabFragment> list = this.fragments;
        if (list == null) {
            p.btv("fragments");
        }
        for (FinderHomeTabFragment finderHomeTabFragment : list) {
            if (finderHomeTabFragment.dLS == i2) {
                List<? extends FinderHomeTabFragment> list2 = this.fragments;
                if (list2 == null) {
                    p.btv("fragments");
                }
                i4 = list2.indexOf(finderHomeTabFragment);
            } else {
                i4 = i4;
            }
        }
        if (i4 >= 0) {
            gx(i4, i3);
        }
        dnx();
    }

    public final void gx(int i2, int i3) {
        FinderTabUIC finderTabUIC;
        if (this.bex) {
            List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a> list = this.tabs;
            if (list == null) {
                p.btv("tabs");
            }
            if (af.eX(list)) {
                if (this.bex && i2 >= 0) {
                    List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a> list2 = this.tabs;
                    if (list2 == null) {
                        p.btv("tabs");
                    }
                    if (i2 < list2.size()) {
                        List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a> list3 = this.tabs;
                        if (list3 == null) {
                            p.btv("tabs");
                        }
                        if (list3 == null) {
                            throw new t("null cannot be cast to non-null type kotlin.collections.MutableList<com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab>");
                        }
                        af.eY(list3).remove(i2);
                        TabLayout tabLayout = this.wAv;
                        if (tabLayout != null) {
                            tabLayout.removeTabAt(i2);
                        }
                        com.tencent.mm.plugin.finder.view.adapter.a<FinderHomeTabFragment> aVar = this.wAx;
                        if (aVar != null) {
                            aVar.a(new a.C1328a(false, i2), null);
                        }
                        if (i3 >= 0) {
                            List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a> list4 = this.tabs;
                            if (list4 == null) {
                                p.btv("tabs");
                            }
                            if (i3 < list4.size()) {
                                finderTabUIC = this;
                                finderTabUIC.aw(i3, false);
                            }
                        }
                        if (i2 - 1 < 0) {
                            i3 = 0;
                            finderTabUIC = this;
                        } else {
                            i3 = i2 - 1;
                            finderTabUIC = this;
                        }
                        finderTabUIC.aw(i3, false);
                    }
                }
                dnx();
                return;
            }
        }
        Log.e("Finder.FinderTabUIC", "removeTabAndFragment param error");
    }

    private final void dIO() {
        if (this.tabProvider != null) {
            IFinderTabProvider iFinderTabProvider = this.tabProvider;
            if (iFinderTabProvider == null) {
                p.btv("tabProvider");
            }
            this.fragments = iFinderTabProvider.fragments();
            IFinderTabProvider iFinderTabProvider2 = this.tabProvider;
            if (iFinderTabProvider2 == null) {
                p.btv("tabProvider");
            }
            this.tabs = iFinderTabProvider2.tabs();
            IFinderTabProvider iFinderTabProvider3 = this.tabProvider;
            if (iFinderTabProvider3 == null) {
                p.btv("tabProvider");
            }
            this.tabViewAction = iFinderTabProvider3.tabViewAction();
            IFinderTabProvider iFinderTabProvider4 = this.tabProvider;
            if (iFinderTabProvider4 == null) {
                p.btv("tabProvider");
            }
            this.tabContainer = iFinderTabProvider4.tabContainer();
            IFinderTabProvider iFinderTabProvider5 = this.tabProvider;
            if (iFinderTabProvider5 == null) {
                p.btv("tabProvider");
            }
            this.bex = iFinderTabProvider5.isDynamic();
        }
    }

    public static final class c implements TabLayout.b<TabLayout.f> {
        final /* synthetic */ TabLayout wAA;
        final /* synthetic */ FinderTabUIC wAz;

        c(TabLayout tabLayout, FinderTabUIC finderTabUIC) {
            this.wAA = tabLayout;
            this.wAz = finderTabUIC;
        }

        @Override // android.support.design.widget.TabLayout.b
        public final void k(TabLayout.f fVar) {
        }

        @Override // android.support.design.widget.TabLayout.b
        public final void j(TabLayout.f fVar) {
            AppMethodBeat.i(255972);
            if (fVar != null) {
                if (fVar.getTag() instanceof com.tencent.mm.plugin.finder.view.tabcomp.a) {
                    com.tencent.mm.plugin.finder.view.tabcomp.f tabViewAction = this.wAz.getTabViewAction();
                    Context context = this.wAA.getContext();
                    p.g(context, "context");
                    Object tag = fVar.getTag();
                    if (tag == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
                        AppMethodBeat.o(255972);
                        throw tVar;
                    }
                    tabViewAction.b(context, (com.tencent.mm.plugin.finder.view.tabcomp.a) tag);
                    Object tag2 = fVar.getTag();
                    if (tag2 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
                        AppMethodBeat.o(255972);
                        throw tVar2;
                    }
                    com.tencent.mm.plugin.finder.view.tabcomp.a aVar = (com.tencent.mm.plugin.finder.view.tabcomp.a) tag2;
                    View customView = fVar.getCustomView();
                    if (customView == null) {
                        t tVar3 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                        AppMethodBeat.o(255972);
                        throw tVar3;
                    }
                    aVar.a(false, (ViewGroup) customView);
                }
                AppMethodBeat.o(255972);
                return;
            }
            AppMethodBeat.o(255972);
        }

        @Override // android.support.design.widget.TabLayout.b
        public final void i(TabLayout.f fVar) {
            AppMethodBeat.i(255973);
            if (fVar != null) {
                com.tencent.mm.plugin.finder.view.tabcomp.f tabViewAction = this.wAz.getTabViewAction();
                Context context = this.wAA.getContext();
                p.g(context, "context");
                Object tag = fVar.getTag();
                if (tag == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
                    AppMethodBeat.o(255973);
                    throw tVar;
                }
                tabViewAction.a(context, (com.tencent.mm.plugin.finder.view.tabcomp.a) tag);
                Object tag2 = fVar.getTag();
                if (tag2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
                    AppMethodBeat.o(255973);
                    throw tVar2;
                }
                com.tencent.mm.plugin.finder.view.tabcomp.a aVar = (com.tencent.mm.plugin.finder.view.tabcomp.a) tag2;
                View customView = fVar.getCustomView();
                if (customView == null) {
                    t tVar3 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                    AppMethodBeat.o(255973);
                    throw tVar3;
                }
                aVar.a(true, (ViewGroup) customView);
                FinderTabUIC finderTabUIC = this.wAz;
                Object tag3 = fVar.getTag();
                if (tag3 == null) {
                    t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
                    AppMethodBeat.o(255973);
                    throw tVar4;
                }
                int a2 = FinderTabUIC.a(finderTabUIC, (com.tencent.mm.plugin.finder.view.tabcomp.a) tag3);
                Log.i("Finder.FinderTabUIC", "setCurrentPage:".concat(String.valueOf(a2)));
                if (a2 == -1) {
                    a2 = 0;
                }
                FinderTabUIC.d(this.wAz, a2);
                AppMethodBeat.o(255973);
                return;
            }
            AppMethodBeat.o(255973);
        }
    }

    private final void dId() {
        TabLayout tabLayout = this.wAv;
        if (tabLayout != null) {
            tabLayout.a(new c(tabLayout, this));
            List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a> list = this.tabs;
            if (list == null) {
                p.btv("tabs");
            }
            int i2 = 0;
            for (T t : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.j.hxH();
                }
                T t2 = t;
                t2.index = i2;
                a(tabLayout, t2, -1);
                i2 = i3;
            }
            TabLayout tabLayout2 = this.wAv;
            if (tabLayout2 != null) {
                Log.i("Finder.FinderTabUIC", "ajustIndicator:" + tabLayout2.getTabCount());
                if (tabLayout2.getTabCount() > 1) {
                    tabLayout2.post(new b(this));
                }
            }
        }
    }

    public static final class e extends FinderFragmentChangeObserver {
        final /* synthetic */ FinderTabUIC wAz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderTabUIC finderTabUIC, MMActivity mMActivity, List list) {
            super(mMActivity, list);
            this.wAz = finderTabUIC;
        }

        @Override // com.tencent.mm.plugin.finder.view.h
        public final void a(boolean z, int i2, FinderHomeTabFragment finderHomeTabFragment) {
            AppMethodBeat.i(255976);
            p.h(finderHomeTabFragment, "fragment");
            Iterator<T> it = this.wAz.wxj.iterator();
            while (it.hasNext()) {
                it.next().a(z, i2, finderHomeTabFragment);
            }
            AppMethodBeat.o(255976);
        }

        @Override // com.tencent.mm.plugin.finder.view.h
        public final void D(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(255977);
            Log.i(FinderFragmentChangeObserver.TAG, "to :" + i3 + " lastIndex:" + this.wAz.lastIndex);
            this.wAz.lastIndex = i3;
            this.wAz.aw(i3, false);
            Iterator<T> it = this.wAz.wxj.iterator();
            while (it.hasNext()) {
                it.next().D(i2, i3, i4, i5);
            }
            AppMethodBeat.o(255977);
        }
    }

    public static final class d implements HardTouchableLayout.b {
        final /* synthetic */ FinderTabUIC wAz;

        d(FinderTabUIC finderTabUIC) {
            this.wAz = finderTabUIC;
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.b
        public final void a(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(255975);
            p.h(view, "view");
            p.h(motionEvent, "e");
            Log.i("Finder.FinderTabUIC", "onDoubleClick");
            com.tencent.f.h.RTc.aV(new a(this));
            FinderTabUIC finderTabUIC = this.wAz;
            TabLayout tabLayout = this.wAz.wAv;
            com.tencent.mm.plugin.finder.view.tabcomp.a MI = finderTabUIC.MI(tabLayout != null ? tabLayout.getSelectedTabPosition() : this.wAz.lastIndex);
            if (MI != null) {
                this.wAz.getTabViewAction().d(this.wAz.getActivity(), MI);
                AppMethodBeat.o(255975);
                return;
            }
            AppMethodBeat.o(255975);
        }

        static final class a implements Runnable {
            final /* synthetic */ d wAB;

            a(d dVar) {
                this.wAB = dVar;
            }

            public final void run() {
                AppMethodBeat.i(255974);
                this.wAB.wAz.getActiveFragment().dlm();
                AppMethodBeat.o(255974);
            }
        }
    }

    private static void a(TabLayout tabLayout, com.tencent.mm.plugin.finder.view.tabcomp.a aVar, int i2) {
        TabLayout.f cW = tabLayout.cW();
        p.g(cW, "tabLayout.newTab()");
        if (aVar != null) {
            cW.aj(aVar.getLayoutId());
            aVar.u((ViewGroup) cW.getCustomView());
            aVar.pd(false);
        }
        cW.g(aVar);
        if (i2 >= 0) {
            tabLayout.a(cW, i2);
        } else {
            tabLayout.a(cW);
        }
    }

    public static final class b implements Runnable {
        final /* synthetic */ FinderTabUIC wAz;

        b(FinderTabUIC finderTabUIC) {
            this.wAz = finderTabUIC;
        }

        public final void run() {
            AppMethodBeat.i(255971);
            FinderTabUIC.d(this.wAz);
            AppMethodBeat.o(255971);
        }
    }

    public static final /* synthetic */ void a(FinderTabUIC finderTabUIC) {
        Log.i("Finder.FinderTabUIC", "onActionbarDoubleClick");
        TabLayout tabLayout = finderTabUIC.wAv;
        com.tencent.mm.plugin.finder.view.tabcomp.a MI = finderTabUIC.MI(tabLayout != null ? tabLayout.getSelectedTabPosition() : finderTabUIC.lastIndex);
        if (MI != null) {
            com.tencent.mm.plugin.finder.view.tabcomp.f fVar = finderTabUIC.tabViewAction;
            if (fVar == null) {
                p.btv("tabViewAction");
            }
            fVar.d(finderTabUIC.getActivity(), MI);
        }
    }

    public static final /* synthetic */ void b(FinderTabUIC finderTabUIC) {
        Log.i("Finder.FinderTabUIC", "onActionbarClick");
        TabLayout tabLayout = finderTabUIC.wAv;
        com.tencent.mm.plugin.finder.view.tabcomp.a MI = finderTabUIC.MI(tabLayout != null ? tabLayout.getSelectedTabPosition() : finderTabUIC.lastIndex);
        if (MI != null) {
            com.tencent.mm.plugin.finder.view.tabcomp.f fVar = finderTabUIC.tabViewAction;
            if (fVar == null) {
                p.btv("tabViewAction");
            }
            fVar.c(finderTabUIC.getActivity(), MI);
        }
    }

    public static final /* synthetic */ int a(FinderTabUIC finderTabUIC, com.tencent.mm.plugin.finder.view.tabcomp.a aVar) {
        List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a> list = finderTabUIC.tabs;
        if (list == null) {
            p.btv("tabs");
        }
        return list.indexOf(aVar);
    }

    public static final /* synthetic */ void d(FinderTabUIC finderTabUIC, int i2) {
        ViewPager viewPager;
        if (i2 >= 0 && (viewPager = finderTabUIC.uO) != null) {
            viewPager.setCurrentItem(i2);
        }
        Log.i("Finder.FinderTabUIC", "setCurrentPage :".concat(String.valueOf(i2)));
    }
}
