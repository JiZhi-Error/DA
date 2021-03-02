package com.tencent.mm.plugin.finder.nearby.live.square;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.nearby.NearbyActionBarUIC;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.guide.a;
import com.tencent.mm.plugin.finder.nearby.live.square.more.NearbyLiveSquareMoreFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.tab.NearbyLiveSquareTabFragment;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.atc;
import com.tencent.mm.protocal.protobuf.awf;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.HardTouchableLayout;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0002./B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J*\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010\u000f\u001a\u00020\u0011H\u0016J\b\u0010&\u001a\u00020\u0011H\u0016J\u000e\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020 J\u0014\u0010)\u001a\u0004\u0018\u00010**\u00020+2\u0006\u0010,\u001a\u00020-R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareTabLayoutUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "hasBuildTab", "", "isCurrentResume", "isRequestingLbs", "liveTabLists", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "netSceneNearbyLiveSquareTabs", "Lcom/tencent/mm/plugin/finder/nearby/live/square/NetSceneNearbyLiveSquareTabs;", "onUserVisibleFocused", "buildTab", "", "liveTabList", "", "fetchLiveSquareTabs", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "fetchTabsInternal", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onUserVisibleUnFocused", "setTabIndex", FirebaseAnalytics.b.INDEX, "findByTag", "Landroid/support/design/widget/TabLayout$Tab;", "Landroid/support/design/widget/TabLayout;", "any", "", "Companion", "NearbyTab", "plugin-finder_release"})
public final class NearbyLiveSquareTabLayoutUIC extends UIComponent implements com.tencent.mm.ak.i {
    public static final a uRx = new a((byte) 0);
    private boolean isRequestingLbs;
    private boolean uPU;
    private a uRt;
    private List<axj> uRu = new LinkedList();
    private boolean uRv;
    private boolean uRw;

    static {
        AppMethodBeat.i(249185);
        AppMethodBeat.o(249185);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareTabLayoutUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(NearbyLiveSquareTabLayoutUIC nearbyLiveSquareTabLayoutUIC, List list) {
        AppMethodBeat.i(249187);
        nearbyLiveSquareTabLayoutUIC.ek(list);
        AppMethodBeat.o(249187);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NearbyLiveSquareTabLayoutUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(249184);
        AppMethodBeat.o(249184);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(249175);
        Fragment fragment = getFragment();
        if (fragment == null) {
            p.hyc();
        }
        Log.i("NearbyLiveSquareTabLayoutUIC", "onCreate");
        ((HardTouchableLayout) fragment.getView().findViewById(R.id.ig6)).setOnSingleClickListener(new g(fragment));
        ((HardTouchableLayout) fragment.getView().findViewById(R.id.ig6)).setOnDoubleClickListener(new h(fragment));
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        if (fragment == null) {
            p.hyc();
        }
        com.tencent.mm.plugin.finder.nearby.guide.a aVar2 = ((NearbyLiveSquareGuideUIC) com.tencent.mm.ui.component.a.of(fragment).get(NearbyLiveSquareGuideUIC.class)).uRs;
        TabLayout tabLayout = (TabLayout) fragment.getView().findViewById(R.id.igb);
        p.g(tabLayout, "fragment.tab_layout");
        TabLayout tabLayout2 = tabLayout;
        p.h(tabLayout2, "targetView");
        aVar2.targetView = tabLayout2;
        tabLayout2.getLocationOnScreen(aVar2.uQv);
        Log.i("TabLayoutScrollGuideHelper", "setTargetView pos[" + aVar2.uQv[0] + ", " + aVar2.uQv[1] + "] targetView:" + tabLayout2);
        aVar2.uQz = ValueAnimator.ofFloat(0.0f, (float) com.tencent.mm.live.core.view.c.dip2px(tabLayout2.getContext(), -52.0f));
        ValueAnimator valueAnimator = aVar2.uQz;
        if (valueAnimator != null) {
            valueAnimator.addUpdateListener(new a.b(aVar2));
        }
        ValueAnimator valueAnimator2 = aVar2.uQz;
        if (valueAnimator2 != null) {
            valueAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        ValueAnimator valueAnimator3 = aVar2.uQz;
        if (valueAnimator3 != null) {
            valueAnimator3.setDuration(1000L);
        }
        aVar2.uQA = ValueAnimator.ofFloat((float) com.tencent.mm.live.core.view.c.dip2px(tabLayout2.getContext(), -52.0f), 0.0f);
        ValueAnimator valueAnimator4 = aVar2.uQA;
        if (valueAnimator4 != null) {
            valueAnimator4.addUpdateListener(new a.c(aVar2));
        }
        ValueAnimator valueAnimator5 = aVar2.uQA;
        if (valueAnimator5 != null) {
            valueAnimator5.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        ValueAnimator valueAnimator6 = aVar2.uQA;
        if (valueAnimator6 != null) {
            valueAnimator6.setDuration(500L);
        }
        aVar2.uQy = new AnimatorSet();
        AnimatorSet animatorSet = aVar2.uQy;
        if (animatorSet != null) {
            animatorSet.playSequentially(aVar2.uQz, aVar2.uQA);
        }
        AnimatorSet animatorSet2 = aVar2.uQy;
        if (animatorSet2 != null) {
            animatorSet2.addListener(aVar2);
        }
        com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
        bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.of(fragment).get(FinderReporterUIC.class)).dIx();
        Log.i("NearbyLiveSquareTabLayoutUIC", "fetchLiveSquareTabs, contextObj:".concat(String.valueOf(dIx)));
        com.tencent.mm.plugin.finder.utils.l lVar = com.tencent.mm.plugin.finder.utils.l.vVE;
        com.tencent.mm.plugin.finder.utils.l.a(d.uRz, new e(this, dIx), new f(this, dIx));
        AppMethodBeat.o(249175);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareTabLayoutUIC$onCreate$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
    public static final class g implements HardTouchableLayout.g {
        final /* synthetic */ Fragment uRC;

        g(Fragment fragment) {
            this.uRC = fragment;
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.g
        public final void b(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(249171);
            p.h(view, "view");
            Log.i("NearbyLiveSquareTabLayoutUIC", "onDoubleClick ...");
            com.tencent.f.h.RTc.aV(new a(this));
            AppMethodBeat.o(249171);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ g uRD;

            a(g gVar) {
                this.uRD = gVar;
            }

            public final void run() {
                AppMethodBeat.i(249170);
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                Fragment fragment = this.uRD.uRC;
                if (fragment == null) {
                    p.hyc();
                }
                AbsNearByFragment dlj = ((NearbyLiveSquareUIC) com.tencent.mm.ui.component.a.of(fragment).get(NearbyLiveSquareUIC.class)).dlj();
                if (dlj != null) {
                    dlj.dll();
                    AppMethodBeat.o(249170);
                    return;
                }
                AppMethodBeat.o(249170);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareTabLayoutUIC$onCreate$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
    public static final class h implements HardTouchableLayout.b {
        final /* synthetic */ Fragment uRC;

        h(Fragment fragment) {
            this.uRC = fragment;
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.b
        public final void a(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(249173);
            p.h(view, "view");
            p.h(motionEvent, "e");
            Log.i("NearbyLiveSquareTabLayoutUIC", "onDoubleClick ...");
            com.tencent.f.h.RTc.aV(new a(this));
            AppMethodBeat.o(249173);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ h uRE;

            a(h hVar) {
                this.uRE = hVar;
            }

            public final void run() {
                AppMethodBeat.i(249172);
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                Fragment fragment = this.uRE.uRC;
                if (fragment == null) {
                    p.hyc();
                }
                AbsNearByFragment dlj = ((NearbyLiveSquareUIC) com.tencent.mm.ui.component.a.of(fragment).get(NearbyLiveSquareUIC.class)).dlj();
                if (dlj != null) {
                    dlj.dlm();
                    AppMethodBeat.o(249172);
                    return;
                }
                AppMethodBeat.o(249172);
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleFocused() {
        AppMethodBeat.i(249176);
        super.onUserVisibleFocused();
        this.uRv = true;
        ek(this.uRu);
        Log.i("NearbyLiveSquareTabLayoutUIC", "onUserVisibleFocused");
        AppMethodBeat.o(249176);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleUnFocused() {
        AppMethodBeat.i(249177);
        super.onUserVisibleUnFocused();
        this.uRv = false;
        AppMethodBeat.o(249177);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(249178);
        super.onDestroy();
        Log.i("NearbyLiveSquareTabLayoutUIC", "onDestroy");
        AppMethodBeat.o(249178);
    }

    public final void Jx(int i2) {
        TabLayout.f ab;
        AppMethodBeat.i(249179);
        Fragment fragment = getFragment();
        if (fragment == null) {
            p.hyc();
        }
        TabLayout tabLayout = (TabLayout) fragment.getView().findViewById(R.id.igb);
        if (tabLayout == null || (ab = tabLayout.ab(i2)) == null) {
            AppMethodBeat.o(249179);
            return;
        }
        p.g(ab, "this");
        if (!ab.isSelected()) {
            ab.select();
        }
        AppMethodBeat.o(249179);
    }

    private final void ek(List<? extends axj> list) {
        int i2 = 8;
        AppMethodBeat.i(249180);
        if (this.uRw) {
            Log.i("NearbyLiveSquareTabLayoutUIC", "buildTab hasBuildTab:" + this.uRw);
            AppMethodBeat.o(249180);
        } else if (!this.uRv) {
            Log.i("NearbyLiveSquareTabLayoutUIC", "buildTab onUserVisibleFocused:" + this.uRv);
            AppMethodBeat.o(249180);
        } else {
            Fragment fragment = getFragment();
            if (fragment == null) {
                p.hyc();
            }
            if (fragment.isDetached()) {
                Log.i("NearbyLiveSquareTabLayoutUIC", "buildTab after fragment detached");
                AppMethodBeat.o(249180);
                return;
            }
            Fragment fragment2 = getFragment();
            if (fragment2 == null) {
                p.hyc();
            }
            if (fragment2.getView() == null) {
                Log.i("NearbyLiveSquareTabLayoutUIC", "buildTab view is null");
                AppMethodBeat.o(249180);
            } else if (list.isEmpty()) {
                Log.i("NearbyLiveSquareTabLayoutUIC", "buildTab liveTabList:".concat(String.valueOf(list)));
                Fragment fragment3 = getFragment();
                if (fragment3 == null) {
                    p.hyc();
                }
                FinderViewPager finderViewPager = (FinderViewPager) fragment3.getView().findViewById(R.id.j7c);
                p.g(finderViewPager, "fragment!!.viewPager");
                finderViewPager.setVisibility(8);
                Fragment fragment4 = getFragment();
                if (fragment4 == null) {
                    p.hyc();
                }
                HardTouchableLayout hardTouchableLayout = (HardTouchableLayout) fragment4.getView().findViewById(R.id.ig6);
                p.g(hardTouchableLayout, "fragment!!.tab_container_htl");
                hardTouchableLayout.setVisibility(8);
                AppMethodBeat.o(249180);
            } else {
                Fragment fragment5 = getFragment();
                if (fragment5 == null) {
                    p.hyc();
                }
                HardTouchableLayout hardTouchableLayout2 = (HardTouchableLayout) fragment5.getView().findViewById(R.id.ig6);
                p.g(hardTouchableLayout2, "fragment!!.tab_container_htl");
                hardTouchableLayout2.setVisibility(0);
                Fragment fragment6 = getFragment();
                if (fragment6 == null) {
                    p.hyc();
                }
                FinderViewPager finderViewPager2 = (FinderViewPager) fragment6.getView().findViewById(R.id.j7c);
                p.g(finderViewPager2, "fragment!!.viewPager");
                finderViewPager2.setVisibility(0);
                Fragment fragment7 = getFragment();
                if (fragment7 == null) {
                    p.hyc();
                }
                TextView textView = (TextView) fragment7.getView().findViewById(R.id.c39);
                p.g(textView, "fragment!!.empty_tip_tv");
                if (this.uRu.size() == 0) {
                    i2 = 0;
                }
                textView.setVisibility(i2);
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                Fragment fragment8 = getFragment();
                if (fragment8 == null) {
                    p.hyc();
                }
                bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.of(fragment8).get(FinderReporterUIC.class)).dIx();
                LinkedList linkedList = new LinkedList();
                int i3 = 0;
                for (T t : list) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        j.hxH();
                    }
                    T t2 = t;
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("nearby_live_square_tab_info_key", t2.toByteArray());
                    bundle.putInt("key_comment_scene", dIx.tCE);
                    NearbyLiveSquareTabFragment nearbyLiveSquareTabFragment = new NearbyLiveSquareTabFragment();
                    nearbyLiveSquareTabFragment.uQK = t2;
                    nearbyLiveSquareTabFragment.setTitle(String.valueOf(t2.LHR));
                    nearbyLiveSquareTabFragment.setArguments(bundle);
                    linkedList.add(nearbyLiveSquareTabFragment);
                    i3 = i4;
                }
                Fragment fragment9 = getFragment();
                if (fragment9 == null) {
                    p.hyc();
                }
                TabLayout tabLayout = (TabLayout) fragment9.getView().findViewById(R.id.igb);
                int i5 = 0;
                for (Object obj : linkedList) {
                    int i6 = i5 + 1;
                    if (i5 < 0) {
                        j.hxH();
                    }
                    NearbyLiveSquareTabFragment nearbyLiveSquareTabFragment2 = (NearbyLiveSquareTabFragment) obj;
                    TabLayout.f cW = tabLayout.cW();
                    p.g(cW, "tabLayout.newTab()");
                    b bVar = new b(cW, nearbyLiveSquareTabFragment2.dLS);
                    bVar.setTitle(nearbyLiveSquareTabFragment2.title);
                    bVar.index = i5;
                    tabLayout.a(bVar.vq, false);
                    i5 = i6;
                }
                tabLayout.a(new c(this));
                com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                Fragment fragment10 = getFragment();
                if (fragment10 == null) {
                    p.hyc();
                }
                ((NearbyLiveSquareUIC) com.tencent.mm.ui.component.a.of(fragment10).get(NearbyLiveSquareUIC.class)).m(list, linkedList);
                this.uRw = true;
                AppMethodBeat.o(249180);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0017J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0017J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0017¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareTabLayoutUIC$buildTab$3", "Landroid/support/design/widget/TabLayout$BaseOnTabSelectedListener;", "Landroid/support/design/widget/TabLayout$Tab;", "onTabReselected", "", "t", "onTabSelected", "onTabUnselected", "plugin-finder_release"})
    public static final class c implements TabLayout.b<TabLayout.f> {
        final /* synthetic */ NearbyLiveSquareTabLayoutUIC uRy;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(NearbyLiveSquareTabLayoutUIC nearbyLiveSquareTabLayoutUIC) {
            this.uRy = nearbyLiveSquareTabLayoutUIC;
        }

        @Override // android.support.design.widget.TabLayout.b
        @SuppressLint({"ResourceType"})
        public final void k(TabLayout.f fVar) {
            AppMethodBeat.i(249161);
            p.h(fVar, "t");
            AppMethodBeat.o(249161);
        }

        @Override // android.support.design.widget.TabLayout.b
        @SuppressLint({"ResourceType"})
        public final void j(TabLayout.f fVar) {
            AppMethodBeat.i(249162);
            p.h(fVar, "t");
            Object tag = fVar.getTag();
            if (tag instanceof b) {
                ((b) tag).setTextColor(R.color.l4);
                ((b) tag).setTextBold(false);
            }
            AppMethodBeat.o(249162);
        }

        @Override // android.support.design.widget.TabLayout.b
        @SuppressLint({"ResourceType"})
        public final void i(TabLayout.f fVar) {
            AppMethodBeat.i(249163);
            p.h(fVar, "t");
            Object tag = fVar.getTag();
            if (tag instanceof b) {
                ((b) tag).setTextColor(R.color.a2x);
                ((b) tag).setTextBold(true);
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                Fragment fragment = this.uRy.getFragment();
                if (fragment == null) {
                    p.hyc();
                }
                NearbyLiveSquareUIC.a((NearbyLiveSquareUIC) com.tencent.mm.ui.component.a.of(fragment).get(NearbyLiveSquareUIC.class), ((b) tag).index);
            }
            AppMethodBeat.o(249163);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(249181);
        super.onResume();
        this.uPU = true;
        AppMethodBeat.o(249181);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(249182);
        super.onPause();
        this.uPU = false;
        AppMethodBeat.o(249182);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0005J\u000e\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareTabLayoutUIC$NearbyTab;", "", "tab", "Landroid/support/design/widget/TabLayout$Tab;", "tabType", "", "(Landroid/support/design/widget/TabLayout$Tab;I)V", FirebaseAnalytics.b.INDEX, "getIndex", "()I", "setIndex", "(I)V", "getTab", "()Landroid/support/design/widget/TabLayout$Tab;", "setTab", "(Landroid/support/design/widget/TabLayout$Tab;)V", "getTabType", "setTabType", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "setTextBold", "", "isBold", "", "setTextColor", "id", "setTitle", "title", "", "plugin-finder_release"})
    public static final class b {
        private int dLS;
        int index;
        private TextView titleTv;
        TabLayout.f vq;

        @SuppressLint({"ResourceType"})
        public b(TabLayout.f fVar, int i2) {
            p.h(fVar, "tab");
            AppMethodBeat.i(249160);
            this.vq = fVar;
            this.dLS = i2;
            this.vq.g(this);
            this.vq.aj(R.layout.bfc);
            View customView = this.vq.getCustomView();
            TextView textView = customView != null ? (TextView) customView.findViewById(R.id.ifz) : null;
            if (textView == null) {
                p.hyc();
            }
            this.titleTv = textView;
            TextView textView2 = this.titleTv;
            if (textView2 != null) {
                textView2.setTextSize(1, 14.0f);
                AppMethodBeat.o(249160);
                return;
            }
            AppMethodBeat.o(249160);
        }

        public final void setTitle(String str) {
            AppMethodBeat.i(249157);
            p.h(str, "title");
            TextView textView = this.titleTv;
            if (textView != null) {
                textView.setText(str);
                AppMethodBeat.o(249157);
                return;
            }
            AppMethodBeat.o(249157);
        }

        public final void setTextColor(int i2) {
            AppMethodBeat.i(249158);
            TextView textView = this.titleTv;
            if (textView != null) {
                View customView = this.vq.getCustomView();
                if (customView == null) {
                    p.hyc();
                }
                p.g(customView, "tab.customView!!");
                Context context = customView.getContext();
                p.g(context, "tab.customView!!.context");
                textView.setTextColor(context.getResources().getColor(i2));
                AppMethodBeat.o(249158);
                return;
            }
            AppMethodBeat.o(249158);
        }

        public final void setTextBold(boolean z) {
            AppMethodBeat.i(249159);
            TextView textView = this.titleTv;
            if (textView == null) {
                AppMethodBeat.o(249159);
            } else if (z) {
                ao.a(textView.getPaint(), 0.8f);
                AppMethodBeat.o(249159);
            } else {
                TextPaint paint = textView.getPaint();
                p.g(paint, "it.paint");
                paint.setFakeBoldText(false);
                TextPaint paint2 = textView.getPaint();
                p.g(paint2, "it.paint");
                paint2.setStrokeWidth(0.0f);
                AppMethodBeat.o(249159);
            }
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(249183);
        p.h(qVar, "scene");
        Log.i("NearbyLiveSquareTabLayoutUIC", "onSceneEnd handle NetSceneNearbyLiveSquareTabs, errType:" + i2 + " errCode:" + i3);
        com.tencent.mm.kernel.g.azz().b(4210, this);
        if ((i2 == 0 && i3 == 0) || i3 == -200008) {
            com.tencent.mm.ak.d dVar = ((a) qVar).rr;
            if (dVar == null) {
                p.hyc();
            }
            com.tencent.mm.bw.a aYK = dVar.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveTabsResponse");
                AppMethodBeat.o(249183);
                throw tVar;
            }
            atc atc = (atc) aYK;
            com.tencent.mm.plugin.finder.nearby.live.square.tab.a aVar = com.tencent.mm.plugin.finder.nearby.live.square.tab.a.uRQ;
            LinkedList<axj> linkedList = atc.LDY;
            p.g(linkedList, "response.tab_list");
            com.tencent.mm.plugin.finder.nearby.live.square.tab.a.el(linkedList);
            com.tencent.mm.ac.d.h(new i(this, atc));
            Log.i("NearbyLiveSquareTabLayoutUIC", "onSceneEnd list:" + atc.LDY);
            AppMethodBeat.o(249183);
            return;
        }
        Log.e("NearbyLiveSquareTabLayoutUIC", "onSceneEnd handle NetSceneNearbyLiveSquareTabs error");
        AppMethodBeat.o(249183);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final d uRz = new d();

        static {
            AppMethodBeat.i(249165);
            AppMethodBeat.o(249165);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(249164);
            Log.w("NearbyLiveSquareTabLayoutUIC", "fetchLiveSquareTabs no location permission");
            x xVar = x.SXb;
            AppMethodBeat.o(249164);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ bbn $contextObj;
        final /* synthetic */ NearbyLiveSquareTabLayoutUIC uRy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(NearbyLiveSquareTabLayoutUIC nearbyLiveSquareTabLayoutUIC, bbn bbn) {
            super(0);
            this.uRy = nearbyLiveSquareTabLayoutUIC;
            this.$contextObj = bbn;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(249168);
            if (!this.uRy.isRequestingLbs) {
                this.uRy.isRequestingLbs = true;
                com.tencent.mm.ac.d.b("LbsPresenter_requestLbs", new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareTabLayoutUIC.e.AnonymousClass1 */
                    final /* synthetic */ e uRA;

                    {
                        this.uRA = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(249167);
                        com.tencent.mm.plugin.finder.utils.l lVar = com.tencent.mm.plugin.finder.utils.l.vVE;
                        final boolean dBK = com.tencent.mm.plugin.finder.utils.l.dBK();
                        this.uRA.uRy.isRequestingLbs = false;
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareTabLayoutUIC.e.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 uRB;

                            {
                                this.uRB = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(249166);
                                Log.w("NearbyLiveSquareTabLayoutUIC", "fetchLiveSquareTabs success:" + dBK);
                                NearbyLiveSquareTabLayoutUIC.a(this.uRB.uRA.uRy, this.uRB.uRA.$contextObj);
                                x xVar = x.SXb;
                                AppMethodBeat.o(249166);
                                return xVar;
                            }
                        });
                        x xVar = x.SXb;
                        AppMethodBeat.o(249167);
                        return xVar;
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(249168);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ bbn $contextObj;
        final /* synthetic */ NearbyLiveSquareTabLayoutUIC uRy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(NearbyLiveSquareTabLayoutUIC nearbyLiveSquareTabLayoutUIC, bbn bbn) {
            super(0);
            this.uRy = nearbyLiveSquareTabLayoutUIC;
            this.$contextObj = bbn;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(249169);
            NearbyLiveSquareTabLayoutUIC.a(this.uRy, this.$contextObj);
            x xVar = x.SXb;
            AppMethodBeat.o(249169);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ atc uRF;
        final /* synthetic */ NearbyLiveSquareTabLayoutUIC uRy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(NearbyLiveSquareTabLayoutUIC nearbyLiveSquareTabLayoutUIC, atc atc) {
            super(0);
            this.uRy = nearbyLiveSquareTabLayoutUIC;
            this.uRF = atc;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            String str;
            String str2;
            AppMethodBeat.i(249174);
            if (!(this.uRy.getFragment() instanceof NearbyLiveSquareMoreFragment)) {
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                NearbyActionBarUIC nearbyActionBarUIC = (NearbyActionBarUIC) com.tencent.mm.ui.component.a.b(this.uRy.getActivity()).get(NearbyActionBarUIC.class);
                awf awf = this.uRF.LDZ;
                if (awf == null || (str2 = awf.LGW) == null) {
                    str = "";
                } else {
                    str = str2;
                }
                p.h(str, "title");
                Log.i("NearbyActionBarUIC", "setNearbyVideoTabTitle title:".concat(String.valueOf(str)));
                com.tencent.mm.ac.d.h(new NearbyActionBarUIC.k(nearbyActionBarUIC, str));
            }
            List list = this.uRy.uRu;
            LinkedList<axj> linkedList = this.uRF.LDY;
            p.g(linkedList, "response.tab_list");
            list.addAll(linkedList);
            NearbyLiveSquareTabLayoutUIC.a(this.uRy, this.uRy.uRu);
            x xVar = x.SXb;
            AppMethodBeat.o(249174);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(NearbyLiveSquareTabLayoutUIC nearbyLiveSquareTabLayoutUIC, bbn bbn) {
        AppMethodBeat.i(249186);
        nearbyLiveSquareTabLayoutUIC.uRt = new a(bbn);
        a aVar = nearbyLiveSquareTabLayoutUIC.uRt;
        if (aVar != null) {
            aVar.d(nearbyLiveSquareTabLayoutUIC.getContext(), nearbyLiveSquareTabLayoutUIC.getContext().getResources().getString(R.string.dbf), 500);
        }
        com.tencent.mm.kernel.g.azz().a(4210, nearbyLiveSquareTabLayoutUIC);
        com.tencent.mm.kernel.g.azz().b(nearbyLiveSquareTabLayoutUIC.uRt);
        AppMethodBeat.o(249186);
    }
}
