package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.f.h;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.l;
import com.tencent.luggage.sdk.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.page.a.d;
import com.tencent.mm.plugin.appbrand.page.b.g;
import com.tencent.mm.plugin.appbrand.page.b.i;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.a;
import org.json.JSONObject;

public abstract class t extends SwipeBackLayout {
    private w kAs;
    private View mContentView;
    public boolean mSwiping = false;
    private boolean noI = true;
    private boolean noJ = false;
    private final Map<i, g> noK = new HashMap();
    private final Set<Runnable> noL = new HashSet();
    private int noM;
    private int noN;
    final boolean[] noO = {false};
    private final SwipeBackLayout.a noP = new a() {
        /* class com.tencent.mm.plugin.appbrand.page.t.AnonymousClass5 */
        private int noS = -1;

        @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.a, me.imid.swipebacklayout.lib.a
        public final void i(int i2, float f2) {
            AppMethodBeat.i(219372);
            if (t.this.getContainer() == null || t.this.getContainer().getCurrentPage() != t.this) {
                t.this.setEnableGesture(false);
                AppMethodBeat.o(219372);
            } else if (t.this.kAs.d("scene_swipe_back", null)) {
                Log.i("MicroMsg.AppBrandPage", "[onScrollStateChange] navigate back be intercepted");
                t.this.hPi();
                AppMethodBeat.o(219372);
            } else {
                w container = t.this.getContainer();
                t k = t.this.kAs.k(t.this);
                if (container == null) {
                    Log.w("MicroMsg.AppBrandPage", "onScrollStateChange, null == pageContainer");
                } else {
                    float f3 = f2 * 100.0f;
                    int ceil = (int) Math.ceil((double) (100.0f * f2));
                    if (ceil == 0 || -1 == this.noS) {
                        if (t.this.mSwiping) {
                            bx bxVar = bx.NAVIGATE_BACK;
                            t tVar = t.this;
                            if (container.npr != null) {
                                container.npr.d(bxVar, tVar, k);
                                container.npq = false;
                            }
                        } else {
                            bx bxVar2 = bx.NAVIGATE_BACK;
                            t tVar2 = t.this;
                            if (container.npr != null && !container.npq) {
                                container.npp = container.npr.b(bxVar2, tVar2, k);
                                container.npq = true;
                            }
                        }
                    } else if (100 > ceil) {
                        bx bxVar3 = bx.NAVIGATE_BACK;
                        t tVar3 = t.this;
                        if (container.npr != null) {
                            if (!container.npq) {
                                container.npp = container.npr.b(bxVar3, tVar3, k);
                                container.npq = true;
                            }
                            container.npr.aQ(f3);
                        }
                    }
                    this.noS = ceil;
                }
                if (i2 != 0) {
                    t.this.mSwiping = true;
                } else {
                    t.this.mSwiping = false;
                    this.noS = -1;
                }
                if (Float.compare(1.0f, f2) <= 0) {
                    if (!t.this.noO[0]) {
                        if (k != null) {
                            t.t(k.getContentView(), 0.0f);
                        }
                        t tVar4 = t.this;
                        Log.d("MicroMsg.AppBrandPage", "onSwipeBack %s", android.util.Log.getStackTraceString(new Throwable()));
                        tVar4.mSwiping = true;
                        tVar4.post(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.page.t.AnonymousClass6 */

                            public final void run() {
                                AppMethodBeat.i(219373);
                                t.this.kAs.a(t.this, "scene_swipe_back");
                                AppMethodBeat.o(219373);
                            }
                        });
                        t.this.noO[0] = true;
                    }
                } else if (k != null) {
                    k.onSwipe(f2);
                }
                Log.v("MicroMsg.AppBrandPage", "scrollPercent %f", Float.valueOf(f2));
                if (t.this.getContainer().getPageCount() == 1 && t.this.getContainer().getRuntime().kAN && t.this.getContainer().getRuntime().kAM != null) {
                    t.this.getContainer().getRuntime().kAM.vC(i2);
                }
                AppMethodBeat.o(219372);
            }
        }

        @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.a, me.imid.swipebacklayout.lib.a
        public final int bS(boolean z) {
            return 1;
        }
    };
    public boolean noQ = false;

    /* access modifiers changed from: protected */
    public abstract View MT();

    public abstract void a(String str, String str2, int[] iArr);

    public abstract boolean dw(String str);

    public abstract ac getCurrentPageView();

    public abstract String getCurrentUrl();

    public abstract ac hL(int i2);

    public abstract void loadUrl(String str);

    static /* synthetic */ void f(t tVar) {
        tVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        tVar.setScrimColor(0);
        tVar.mContentView = tVar.MT();
        tVar.addView(tVar.getContentView());
        tVar.setContentView(tVar.getContentView());
        tVar.a(tVar.noP);
    }

    public t(Context context, w wVar) {
        super(context);
        this.kAs = wVar;
        c.a("AppBrandPageProfile| " + getLocalClassName() + " <init>:initView()", new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.t.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(135005);
                t.f(t.this);
                AppMethodBeat.o(135005);
            }
        });
    }

    private String getLocalClassName() {
        return getClass().getName().replaceFirst(Pattern.quote("com.tencent.mm.plugin.appbrand"), "");
    }

    public final void af(final Runnable runnable) {
        if (runnable != null) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.page.t.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(176558);
                        t.this.af(runnable);
                        AppMethodBeat.o(176558);
                    }
                });
                return;
            }
            Object tag = getTag(w.noX);
            if (tag instanceof Animator) {
                ((Animator) tag).addListener(new AnimatorListenerAdapter() {
                    /* class com.tencent.mm.plugin.appbrand.page.t.AnonymousClass3 */

                    public final void onAnimationCancel(Animator animator) {
                        AppMethodBeat.i(176559);
                        super.onAnimationCancel(animator);
                        runnable.run();
                        AppMethodBeat.o(176559);
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(176560);
                        super.onAnimationEnd(animator);
                        runnable.run();
                        AppMethodBeat.o(176560);
                    }
                });
            } else if (getAnimation() == null) {
                runnable.run();
            } else {
                this.noL.add(runnable);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onAnimationEnd() {
        super.onAnimationEnd();
        for (Runnable runnable : this.noL) {
            runnable.run();
        }
        this.noL.clear();
    }

    public final int bQL() {
        if (this.kAs == null) {
            return -1;
        }
        return this.kAs.l(this);
    }

    public void adB(String str) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    public void a(ac acVar, AppBrandPageFullScreenView appBrandPageFullScreenView) {
        if (appBrandPageFullScreenView != null && appBrandPageFullScreenView.getParent() == null && (this.mContentView instanceof ViewGroup)) {
            ((ViewGroup) this.mContentView).addView(appBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    /* access modifiers changed from: package-private */
    public final void bQM() {
        ac currentPageView = getCurrentPageView();
        if (currentPageView != null) {
            Iterator<Object> it = currentPageView.nnC.lxJ.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void bQN() {
        if (this.noI) {
            this.noI = false;
            this.noJ = false;
            MV();
        }
    }

    /* access modifiers changed from: package-private */
    public final void bQO() {
        if (!this.noI) {
            this.noI = true;
            MW();
        }
    }

    public final void performDestroy() {
        MU();
    }

    public final void NR() {
        cleanup();
    }

    /* access modifiers changed from: protected */
    public void cleanup() {
    }

    /* access modifiers changed from: protected */
    public void MV() {
        Log.d("MicroMsg.AppBrandPage", "onPageForeground: %s", getCurrentUrl());
        bQP();
        setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void MW() {
        Log.d("MicroMsg.AppBrandPage", "onPageBackground: %s", getCurrentUrl());
    }

    /* access modifiers changed from: protected */
    public void MU() {
        Log.d("MicroMsg.AppBrandPage", "onPageDestroy: %s", getCurrentUrl());
    }

    public final void bQP() {
        if (this.kAs.getRuntime().kAP) {
            setEnableGesture(false);
        } else {
            setEnableGesture(this.kAs.bQW());
        }
        setEdgeTrackingEnabled(1);
        onSwipe(1.0f);
        this.noO[0] = false;
        this.mSwiping = false;
        super.hPi();
    }

    private void hide() {
        if (this.noI) {
            setVisibility(4);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean isInBackground() {
        return this.noI;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private View getContentView() {
        return this.mContentView;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        if (this.noI) {
            this.noJ = true;
        }
        ac currentPageView = getCurrentPageView();
        if (currentPageView != null) {
            currentPageView.onConfigurationChanged(configuration);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.noI && !this.noJ && this.noM > 0 && this.noN > 0) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.noM, 1073741824), View.MeasureSpec.makeMeasureSpec(this.noN, 1073741824));
            return;
        }
        super.onMeasure(i2, i3);
        this.noM = getMeasuredWidth();
        this.noN = getMeasuredHeight();
    }

    public String getAppId() {
        return this.kAs.getAppId();
    }

    /* access modifiers changed from: protected */
    public w getContainer() {
        return this.kAs;
    }

    public b.d getPageConfig() {
        return getCurrentPageView().getPageConfig();
    }

    private void a(String str, bx bxVar, w.h hVar) {
        boolean z;
        HashMap hashMap = new HashMap();
        String currentUrl = getCurrentUrl();
        String dM = l.dM(currentUrl);
        Map<String, String> dN = l.dN(currentUrl);
        hashMap.put("path", dM);
        hashMap.put(SearchIntents.EXTRA_QUERY, dN);
        hashMap.put("rawPath", currentUrl);
        if (bxVar != null) {
            hashMap.put("openType", bxVar.toString());
        }
        if (hVar != null) {
            hashMap.put("pipMode", hVar.name);
        }
        if ("onAppRoute".equals(str)) {
            d dVar = (d) getCurrentPageView().S(d.class);
            if (dVar == null || !dVar.MY()) {
                z = false;
            } else {
                z = true;
            }
            hashMap.put("resizing", Boolean.valueOf(z));
            if (bx.NAVIGATE_BACK != bxVar) {
                if (this.kAs.getAppConfig().bzJ() != null) {
                    hashMap.put("page", this.kAs.getAppConfig().bzJ().opt(dM));
                }
                if (this.kAs.getAppConfig().bzK() != null) {
                    hashMap.put("preloadRule", this.kAs.getAppConfig().bzK().opt(org.apache.commons.b.g.id(dM, dM.lastIndexOf(".html"))));
                }
            }
            getCurrentPageView().a(hashMap, bxVar);
        }
        e.m(hashMap);
        String jSONObject = new JSONObject(hashMap).toString();
        Log.i("MicroMsg.AppBrandPage", "dispatchRoute, appId:%s, event:%s, type:%s, webviewId:%d, rawPath:%s, data:%s", getAppId(), str, bxVar.toString(), Integer.valueOf(getCurrentPageView().getComponentId()), currentUrl, jSONObject);
        getCurrentPageView().b(str, jSONObject, (int[]) null);
    }

    public final void a(bx bxVar, w.h hVar) {
        a("onAppRoute", bxVar, hVar);
    }

    public final void b(bx bxVar) {
        a("onAppRouteDone", bxVar, (w.h) null);
        if (this.kAs.npl.v(getCurrentPageView())) {
            this.kAs.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.t.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(219371);
                    t.this.kAs.adK(com.tencent.mm.plugin.appbrand.jsapi.p.h.NAME);
                    AppMethodBeat.o(219371);
                }
            }, 200);
        }
    }

    protected static boolean i(int[] iArr, int i2) {
        if (iArr == null || iArr.length == 0) {
            return true;
        }
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void hideVKB() {
        com.tencent.luggage.h.g.aM(getContext());
    }

    /* access modifiers changed from: private */
    public static void t(View view, float f2) {
        view.clearAnimation();
        view.setTranslationX(f2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onSwipe(float f2) {
        if (this.noI) {
            if (f2 >= 0.0f) {
                setVisibility(0);
            } else {
                hide();
            }
        }
        t(this, (((float) getWidth()) / 4.0f) * (1.0f - f2) * -1.0f);
    }

    public final g a(i iVar) {
        g gVar;
        synchronized (this.noK) {
            gVar = this.noK.get(iVar);
        }
        return gVar;
    }

    public final void a(i iVar, g gVar) {
        if (iVar != null) {
            synchronized (this.noK) {
                if (gVar == null) {
                    this.noK.remove(iVar);
                    Log.i("MicroMsg.AppBrandPage", "[registerNavigateBackInterceptionInfo] remove ".concat(String.valueOf(iVar)));
                } else {
                    this.noK.put(iVar, gVar);
                    Log.i("MicroMsg.AppBrandPage", "[registerNavigateBackInterceptionInfo] add ".concat(String.valueOf(iVar)));
                }
                Log.i("MicroMsg.AppBrandPage", "[registerNavigateBackInterceptionInfo] navigateBackInterceptionInfos size=" + this.noK.size());
            }
        }
    }
}
