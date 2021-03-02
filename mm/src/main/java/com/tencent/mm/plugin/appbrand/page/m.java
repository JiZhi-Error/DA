package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.u;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
import com.tencent.mm.plugin.appbrand.widget.tabbar.AppBrandTabBarItem;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
public final class m extends t {
    private ViewGroup lja;
    private boolean mDestroyed = false;
    private String mwq;
    private com.tencent.mm.plugin.appbrand.widget.tabbar.a nop;
    private FrameLayout noq;
    private ac nor = getContainer().bQT();
    private Map<String, ac> nos = new HashMap();
    private SparseArray<AppBrandPageFullScreenView> not = new SparseArray<>();
    private boolean nou = false;
    private final Runnable nov = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.page.m.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(134965);
            m.a(m.this);
            AppMethodBeat.o(134965);
        }
    };
    private final Runnable now = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.page.m.AnonymousClass3 */

        public final void run() {
            AppMethodBeat.i(134967);
            if (m.this.mDestroyed) {
                AppMethodBeat.o(134967);
                return;
            }
            ac currentPageView = m.this.getCurrentPageView();
            if (currentPageView == null) {
                AppMethodBeat.o(134967);
                return;
            }
            com.tencent.mm.plugin.appbrand.widget.actionbar.b bRi = currentPageView.bRi();
            if (bRi == null) {
                AppMethodBeat.o(134967);
                return;
            }
            currentPageView.nqT.AB(bRi.getMeasuredHeight() + bRi.getTop());
            AppMethodBeat.o(134967);
        }
    };
    private final LinkedList<c> nox = new LinkedList<>();

    public static final class a extends s {
        private static final int CTRL_INDEX = 390;
        private static final String NAME = "onTabItemTap";
    }

    public interface b {
        void b(m mVar, String str);

        void e(m mVar);
    }

    static /* synthetic */ void a(m mVar, String str) {
        AppMethodBeat.i(176557);
        mVar.adA(str);
        AppMethodBeat.o(176557);
    }

    public m(Context context, w wVar) {
        super(context, wVar);
        AppMethodBeat.i(134975);
        AppMethodBeat.o(134975);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final View MT() {
        AppMethodBeat.i(134976);
        if (this.lja == null) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            this.noq = new FrameLayout(getContext());
            com.tencent.luggage.sdk.g.c.a("createTabBar", new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.m.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(219358);
                    m.this.nop = m.this.a((ba) m.this.getContainer().getRuntime().af(ba.class));
                    AppMethodBeat.o(219358);
                }
            });
            if (getContainer().getAppConfig().bzG().lcq) {
                this.nop.setVisibility(8);
            }
            if ("top".equals(getContainer().getAppConfig().bzG().lcm)) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(10);
                relativeLayout.addView(this.noq, layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(10);
                relativeLayout.addView(this.nop, layoutParams2);
            } else {
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams3.addRule(12);
                relativeLayout.addView(this.nop, layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams4.addRule(2, this.nop.getId());
                relativeLayout.addView(this.noq, layoutParams4);
            }
            this.lja = relativeLayout;
        }
        ViewGroup viewGroup = this.lja;
        AppMethodBeat.o(134976);
        return viewGroup;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(134977);
        super.onMeasure(i2, i3);
        bQG();
        bQH();
        AppMethodBeat.o(134977);
    }

    public final void onDescendantInvalidated(View view, View view2) {
        AppMethodBeat.i(134978);
        super.onDescendantInvalidated(view, view2);
        if (view2 instanceof d) {
            bQG();
            bQH();
        }
        AppMethodBeat.o(134978);
    }

    private void bQG() {
        AppMethodBeat.i(134979);
        if (this.mDestroyed) {
            AppMethodBeat.o(134979);
            return;
        }
        post(this.nov);
        AppMethodBeat.o(134979);
    }

    private void bQH() {
        AppMethodBeat.i(134980);
        if (this.mDestroyed) {
            AppMethodBeat.o(134980);
            return;
        }
        post(this.now);
        AppMethodBeat.o(134980);
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.plugin.appbrand.widget.tabbar.a a(ba baVar) {
        AppMethodBeat.i(219368);
        com.tencent.mm.plugin.appbrand.widget.tabbar.a aVar = (com.tencent.mm.plugin.appbrand.widget.tabbar.a) baVar.a(com.tencent.mm.plugin.appbrand.widget.tabbar.a.class, getContext());
        if (aVar == null) {
            aVar = (com.tencent.mm.plugin.appbrand.widget.tabbar.a) getContainer().getDecorWidgetFactory().d(getContext(), com.tencent.mm.plugin.appbrand.widget.tabbar.a.class);
        }
        aVar.setId(R.id.pk);
        final b.g bzG = getContainer().getAppConfig().bzG();
        aVar.setPosition(bzG.lcm);
        aVar.j(bzG.ixw, bzG.lcn, bzG.lco, bzG.lcp);
        Iterator<b.h> it = bzG.lj.iterator();
        while (it.hasNext()) {
            b.h next = it.next();
            aVar.a(next.url, next.text, next.icon, next.lcs, (AppBrandTabBarItem) baVar.a(AppBrandTabBarItem.class, getContext()));
        }
        aVar.setClickListener(new a.b() {
            /* class com.tencent.mm.plugin.appbrand.page.m.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.appbrand.widget.tabbar.a.b
            public final void aq(int i2, String str) {
                AppMethodBeat.i(219359);
                m.this.getContainer().adE(str);
                HashMap hashMap = new HashMap();
                hashMap.put("pagePath", str);
                hashMap.put("text", bzG.lj.get(i2).text);
                hashMap.put(FirebaseAnalytics.b.INDEX, Integer.valueOf(i2));
                m.this.getCurrentPageView().a(new a().L(hashMap), (int[]) null);
                AppMethodBeat.o(219359);
            }
        });
        AppMethodBeat.o(219368);
        return aVar;
    }

    public final com.tencent.mm.plugin.appbrand.widget.tabbar.a getTabBar() {
        return this.nop;
    }

    public final void a(final String str, final b bVar) {
        AppMethodBeat.i(219369);
        Log.i("MicroMsg.AppBrandMultiplePage", "AppBrandPageProfile| loadUrl, appId:%s, url:%s", getAppId(), str);
        if (str.equals(this.mwq)) {
            if (bVar != null) {
                bVar.b(this, str);
                bVar.e(this);
            }
            AppMethodBeat.o(219369);
            return;
        }
        int agk = this.nop.agk(str);
        if (agk < 0) {
            Log.e("MicroMsg.AppBrandMultiplePage", "loadUrl, index not found, appId:%s, url:%s", getAppId(), str);
            AppMethodBeat.o(219369);
            return;
        }
        m14if(true);
        this.mwq = str;
        this.nop.AI(agk);
        if (this.nos.get(l.dM(str)) == null) {
            final ac adz = adz(l.dM(str));
            final boolean[] zArr = new boolean[1];
            final AnonymousClass6 r0 = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.m.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(219361);
                    if (bVar != null) {
                        if (!zArr[0]) {
                            m.this.post(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.page.m.AnonymousClass6.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(219360);
                                    bVar.e(m.this);
                                    AppMethodBeat.o(219360);
                                }
                            });
                            AppMethodBeat.o(219361);
                            return;
                        }
                        bVar.e(m.this);
                    }
                    AppMethodBeat.o(219361);
                }
            };
            Log.i("MicroMsg.AppBrandMultiplePage", "loadAndWait appId[%s] url[%s]", getAppId(), str);
            final AnonymousClass7 r3 = new c() {
                /* class com.tencent.mm.plugin.appbrand.page.m.AnonymousClass7 */

                @Override // com.tencent.mm.plugin.appbrand.page.m.c
                public final void bQK() {
                    AppMethodBeat.i(219362);
                    m.a(m.this, str);
                    if (r0 != null) {
                        r0.run();
                    }
                    AppMethodBeat.o(219362);
                }
            };
            final long currentTimeMillis = System.currentTimeMillis();
            adz.a(new i.f() {
                /* class com.tencent.mm.plugin.appbrand.page.m.AnonymousClass8 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.f
                public final void onReady() {
                    AppMethodBeat.i(219363);
                    adz.b(this);
                    r3.run();
                    Log.i("MicroMsg.AppBrandMultiplePage", "Tab[%s][%s] onReady received, time: %d", m.this.getAppId(), str, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(219363);
                }
            });
            if (this.nos.size() > 1) {
                this.nox.addLast(r3);
                postDelayed(r3, 500);
            }
            this.nou = true;
            adz.dE(str);
            if (bVar != null) {
                bVar.b(this, str);
                zArr[0] = true;
            }
            AppMethodBeat.o(219369);
            return;
        }
        if (bVar != null) {
            bVar.b(this, str);
        }
        adA(str);
        if (bVar != null) {
            bVar.e(this);
        }
        AppMethodBeat.o(219369);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final void loadUrl(String str) {
        AppMethodBeat.i(134982);
        a(str, (b) null);
        AppMethodBeat.o(134982);
    }

    private synchronized ac adz(String str) {
        ac bQT;
        AppMethodBeat.i(134983);
        if (this.nor != null) {
            bQT = this.nor;
            this.nor = null;
        } else {
            bQT = getContainer().bQT();
        }
        bQT.nqU = this;
        this.nos.put(str, bQT);
        this.noq.addView(bQT.getContentView(), 0);
        AppMethodBeat.o(134983);
        return bQT;
    }

    private void adA(String str) {
        AppMethodBeat.i(134984);
        this.nou = false;
        ac acVar = this.nos.get(l.dM(str));
        acVar.getContentView().setVisibility(4);
        ac acVar2 = null;
        for (ac acVar3 : this.nos.values()) {
            if (acVar3.getContentView().getVisibility() != 0 || acVar == acVar3) {
                acVar3 = acVar2;
            }
            acVar2 = acVar3;
        }
        acVar.getContentView().bringToFront();
        acVar.getContentView().setVisibility(0);
        if (acVar2 != null) {
            acVar2.getContentView().setVisibility(4);
        }
        if (acVar2 != null) {
            acVar2.onBackground();
        }
        acVar.onForeground();
        bQI();
        AppMethodBeat.o(134984);
    }

    private void bQI() {
        AppMethodBeat.i(134985);
        if (this.not.size() <= 0) {
            AppMethodBeat.o(134985);
            return;
        }
        for (int i2 = 0; i2 < this.not.size(); i2++) {
            this.not.valueAt(i2).setVisibility(4);
        }
        ac currentPageView = getCurrentPageView();
        if (currentPageView == null) {
            AppMethodBeat.o(134985);
            return;
        }
        AppBrandPageFullScreenView appBrandPageFullScreenView = this.not.get(currentPageView.hashCode());
        if (appBrandPageFullScreenView != null) {
            appBrandPageFullScreenView.setVisibility(0);
        }
        AppMethodBeat.o(134985);
    }

    /* renamed from: if  reason: not valid java name */
    private void m14if(boolean z) {
        AppMethodBeat.i(134986);
        Iterator<c> it = this.nox.iterator();
        while (it.hasNext()) {
            c next = it.next();
            removeCallbacks(next);
            if (z) {
                next.run();
            } else {
                next.mCanceled = true;
            }
        }
        this.nox.clear();
        AppMethodBeat.o(134986);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final boolean dw(String str) {
        AppMethodBeat.i(134987);
        if (this.nop.agk(str) != -1) {
            AppMethodBeat.o(134987);
            return true;
        }
        AppMethodBeat.o(134987);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final void MV() {
        AppMethodBeat.i(134988);
        super.MV();
        getCurrentPageView().onForeground();
        AppMethodBeat.o(134988);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final void MW() {
        AppMethodBeat.i(134989);
        super.MW();
        getCurrentPageView().onBackground();
        AppMethodBeat.o(134989);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final void MU() {
        AppMethodBeat.i(134990);
        super.MU();
        if (this.nor != null) {
            this.nor.onDestroy();
        }
        for (ac acVar : this.nos.values()) {
            acVar.onDestroy();
        }
        AppMethodBeat.o(134990);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final void a(String str, String str2, int[] iArr) {
        AppMethodBeat.i(134991);
        if (this.nor != null && i(iArr, this.nor.getComponentId())) {
            this.nor.c(str, str2, 0);
        }
        for (ac acVar : this.nos.values()) {
            if (i(iArr, acVar.getComponentId())) {
                acVar.c(str, str2, 0);
            }
        }
        AppMethodBeat.o(134991);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final void cleanup() {
        AppMethodBeat.i(134992);
        this.mDestroyed = true;
        super.cleanup();
        if (this.nor != null) {
            this.nor.cleanup();
        }
        for (ac acVar : this.nos.values()) {
            acVar.cleanup();
        }
        m14if(false);
        removeCallbacks(this.nov);
        removeCallbacks(this.now);
        AppMethodBeat.o(134992);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final synchronized ac getCurrentPageView() {
        ac acVar;
        AppMethodBeat.i(134993);
        if (this.nor != null) {
            acVar = this.nor;
            AppMethodBeat.o(134993);
        } else {
            acVar = this.nos.get(l.dM(this.mwq));
            AppMethodBeat.o(134993);
        }
        return acVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final String getCurrentUrl() {
        return this.mwq;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final ac hL(int i2) {
        AppMethodBeat.i(219370);
        for (ac acVar : this.nos.values()) {
            if (acVar.getComponentId() == i2) {
                AppMethodBeat.o(219370);
                return acVar;
            }
        }
        AppMethodBeat.o(219370);
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final void a(ac acVar, AppBrandPageFullScreenView appBrandPageFullScreenView) {
        AppMethodBeat.i(134994);
        if (acVar == null) {
            Log.e("MicroMsg.AppBrandMultiplePage", "getCurrentFullScreenView err, pageView is null");
            AppMethodBeat.o(134994);
            return;
        }
        if (appBrandPageFullScreenView != null && appBrandPageFullScreenView.getParent() == null && (this.lja instanceof ViewGroup)) {
            this.lja.addView(appBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
            this.not.put(acVar.hashCode(), appBrandPageFullScreenView);
        }
        AppMethodBeat.o(134994);
    }

    public final Iterator<ac> bQJ() {
        AppMethodBeat.i(134995);
        AnonymousClass9 r0 = new Iterator<ac>() {
            /* class com.tencent.mm.plugin.appbrand.page.m.AnonymousClass9 */
            private final Iterator<ac> noF = m.this.nos.values().iterator();

            {
                AppMethodBeat.i(219364);
                AppMethodBeat.o(219364);
            }

            public final boolean hasNext() {
                AppMethodBeat.i(219365);
                boolean hasNext = this.noF.hasNext();
                AppMethodBeat.o(219365);
                return hasNext;
            }

            public final void remove() {
                AppMethodBeat.i(219366);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.o(219366);
                throw unsupportedOperationException;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.Iterator
            public final /* bridge */ /* synthetic */ ac next() {
                AppMethodBeat.i(219367);
                ac next = this.noF.next();
                AppMethodBeat.o(219367);
                return next;
            }
        };
        AppMethodBeat.o(134995);
        return r0;
    }

    /* access modifiers changed from: package-private */
    public static abstract class c implements Runnable {
        boolean mCanceled;
        private boolean noG;

        public abstract void bQK();

        private c() {
            this.noG = false;
            this.mCanceled = false;
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        public final void run() {
            boolean z;
            if (this.noG || this.mCanceled) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.noG = true;
                bQK();
            }
        }
    }

    static /* synthetic */ void a(m mVar) {
        AppMethodBeat.i(134996);
        if (!mVar.mDestroyed && mVar.getCurrentPageView() != null && !mVar.nou && "top".equals(mVar.nop.getPosition()) && (mVar.nop.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) mVar.nop.getLayoutParams();
            com.tencent.mm.plugin.appbrand.widget.actionbar.b bRi = mVar.getCurrentPageView().bRi();
            int measuredHeight = bRi.getMeasuredHeight() + bRi.getTop();
            if (marginLayoutParams.topMargin != measuredHeight) {
                marginLayoutParams.topMargin = measuredHeight;
                mVar.nop.setLayoutParams(marginLayoutParams);
                mVar.post(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.page.m.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(134966);
                        if (u.aD(m.this) && (m.this.nop.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && ((ViewGroup.MarginLayoutParams) m.this.nop.getLayoutParams()).topMargin != m.this.nop.getTop()) {
                            m.this.nop.requestLayout();
                        }
                        AppMethodBeat.o(134966);
                    }
                });
            }
            mVar.getCurrentPageView().yJ(mVar.nop.getMeasuredHeight());
        }
        AppMethodBeat.o(134996);
    }
}
