package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.bw;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import junit.framework.Assert;

@SuppressLint({"ViewConstructor"})
public class w extends FrameLayout {
    static final int noX = R.id.pl;
    private AppBrandRuntime kEc;
    private String mAppId;
    private volatile boolean mDestroyed = false;
    private boolean noY = false;
    private boolean noZ = false;
    private a npa;
    private b npb;
    private final Map<com.tencent.mm.plugin.appbrand.page.b.i, com.tencent.mm.plugin.appbrand.page.b.e> npc = new HashMap();
    private final byte[] npd = new byte[0];
    private final LinkedList<t> npe = new LinkedList<>();
    private final LinkedList<t> npf = new LinkedList<>();
    private final LinkedList<c> npg = new LinkedList<>();
    private ac nph;
    private boolean npi = false;
    private t npj;
    private bw npk;
    final ax npl = new ax();
    private boolean npm = true;
    private f npn;
    private i npo = null;
    h npp = null;
    boolean npq = false;
    e npr = null;

    public interface a {
        boolean MX();

        ac a(w wVar);

        t a(String str, bx bxVar, w wVar, Callable<t> callable);

        boolean a(String str, bx bxVar, w wVar, d dVar);
    }

    public interface b {
        a a(a aVar);
    }

    /* access modifiers changed from: package-private */
    public interface c extends Runnable {
        void ig(boolean z);
    }

    public interface d {
        void bQX();

        void cancel();

        void proceed();
    }

    public interface e {
        void aQ(float f2);

        h b(bx bxVar, t tVar, t tVar2);

        void c(bx bxVar, t tVar, t tVar2);

        void d(bx bxVar, t tVar, t tVar2);
    }

    public interface f {
        void brP();
    }

    public interface i {
        void r(t tVar);
    }

    static /* synthetic */ Object a(w wVar, t tVar, bx bxVar, boolean z) {
        AppMethodBeat.i(219424);
        Object a2 = wVar.a(tVar, bxVar, z);
        AppMethodBeat.o(219424);
        return a2;
    }

    static /* synthetic */ Object a(w wVar, t tVar, boolean z, boolean z2) {
        AppMethodBeat.i(219423);
        Object a2 = wVar.a(tVar, z, z2);
        AppMethodBeat.o(219423);
        return a2;
    }

    static /* synthetic */ void a(w wVar, bx bxVar, t tVar, t tVar2) {
        AppMethodBeat.i(219426);
        wVar.a(bxVar, tVar, tVar2);
        AppMethodBeat.o(219426);
    }

    static /* synthetic */ void a(w wVar, bx bxVar, t tVar, t tVar2, g gVar) {
        AppMethodBeat.i(219425);
        wVar.a(bxVar, tVar, tVar2, gVar);
        AppMethodBeat.o(219425);
    }

    static /* synthetic */ void a(w wVar, t tVar) {
        AppMethodBeat.i(219427);
        wVar.j(tVar);
        AppMethodBeat.o(219427);
    }

    static /* synthetic */ void a(w wVar, t tVar, t tVar2) {
        AppMethodBeat.i(176604);
        wVar.b(tVar, tVar2);
        AppMethodBeat.o(176604);
    }

    static /* synthetic */ void a(w wVar, t tVar, t tVar2, bx bxVar, h hVar) {
        AppMethodBeat.i(176605);
        wVar.a(tVar, tVar2, bxVar, hVar);
        AppMethodBeat.o(176605);
    }

    static /* synthetic */ t b(w wVar, String str, bx bxVar) {
        AppMethodBeat.i(176606);
        t a2 = wVar.a(str, bxVar);
        AppMethodBeat.o(176606);
        return a2;
    }

    static /* synthetic */ int d(w wVar) {
        AppMethodBeat.i(176603);
        int actualPageStackSize = wVar.getActualPageStackSize();
        AppMethodBeat.o(176603);
        return actualPageStackSize;
    }

    public w(Context context, AppBrandRuntime appBrandRuntime) {
        super(context);
        AppMethodBeat.i(135048);
        Log.i("MicroMsg.AppBrandPageContainer", "AppBrandPageContainerProfile| <init> appId[%s]", appBrandRuntime.mAppId);
        this.kEc = appBrandRuntime;
        this.mAppId = appBrandRuntime.mAppId;
        this.npk = new bw.a();
        AppMethodBeat.o(135048);
    }

    public void setPipVideoRelatedPage(t tVar) {
        AppMethodBeat.i(219402);
        if (tVar != null) {
            Log.i("MicroMsg.AppBrandPageContainer", "setPipVideoRelatedPage, page(%s)", tVar.getCurrentUrl());
        } else {
            Log.i("MicroMsg.AppBrandPageContainer", "setPipVideoRelatedPage, page is null");
        }
        this.npj = tVar;
        AppMethodBeat.o(219402);
    }

    public bw getDecorWidgetFactory() {
        return this.npk;
    }

    public void setDecorWidgetFactory(bw bwVar) {
        AppMethodBeat.i(135049);
        if (bwVar == null) {
            NullPointerException nullPointerException = new NullPointerException("Should not be null");
            AppMethodBeat.o(135049);
            throw nullPointerException;
        }
        this.npk = bwVar;
        AppMethodBeat.o(135049);
    }

    public final void setDelegate(a aVar) {
        AppMethodBeat.i(135050);
        if (this.npa != null) {
            IllegalAccessError illegalAccessError = new IllegalAccessError("Duplicated call!!!");
            AppMethodBeat.o(135050);
            throw illegalAccessError;
        }
        if (this.npb != null) {
            aVar = this.npb.a(aVar);
        }
        this.npa = aVar;
        AppMethodBeat.o(135050);
    }

    public void setDelegateWrapperFactory(b bVar) {
        AppMethodBeat.i(176584);
        this.npb = bVar;
        if (this.npa != null) {
            this.npa = bVar.a(this.npa);
        }
        AppMethodBeat.o(176584);
    }

    public List<com.tencent.mm.plugin.appbrand.page.b.e> getNavigateBackInterceptorChain() {
        ArrayList arrayList;
        AppMethodBeat.i(219403);
        synchronized (this.npc) {
            try {
                if (this.npc.size() == 0 || getCurrentPage() == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(this.npc.values());
                    Collections.sort(arrayList, new Comparator<com.tencent.mm.plugin.appbrand.page.b.e>() {
                        /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass1 */

                        {
                            AppMethodBeat.i(135020);
                            AppMethodBeat.o(135020);
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                        @Override // java.util.Comparator
                        public final /* synthetic */ int compare(com.tencent.mm.plugin.appbrand.page.b.e eVar, com.tencent.mm.plugin.appbrand.page.b.e eVar2) {
                            AppMethodBeat.i(219374);
                            com.tencent.mm.plugin.appbrand.page.b.e eVar3 = eVar;
                            com.tencent.mm.plugin.appbrand.page.b.e eVar4 = eVar2;
                            com.tencent.mm.plugin.appbrand.page.b.g a2 = w.this.getCurrentPage().a(eVar3.bSE());
                            com.tencent.mm.plugin.appbrand.page.b.g a3 = w.this.getCurrentPage().a(eVar4.bSE());
                            if (a2 == null) {
                                AppMethodBeat.o(219374);
                                return 1;
                            } else if (a3 == null) {
                                AppMethodBeat.o(219374);
                                return -1;
                            } else {
                                int i2 = eVar4.bSD().priority - eVar3.bSD().priority;
                                AppMethodBeat.o(219374);
                                return i2;
                            }
                        }
                    });
                    AppMethodBeat.o(219403);
                }
            } finally {
                AppMethodBeat.o(219403);
            }
        }
        return arrayList;
    }

    public final void a(com.tencent.mm.plugin.appbrand.page.b.i iVar, com.tencent.mm.plugin.appbrand.page.b.e eVar) {
        AppMethodBeat.i(219404);
        if (iVar == null) {
            AppMethodBeat.o(219404);
            return;
        }
        synchronized (this.npc) {
            try {
                this.npc.put(iVar, eVar);
            } finally {
                AppMethodBeat.o(219404);
            }
        }
    }

    public void setActuallyVisible(boolean z) {
        AppMethodBeat.i(135051);
        boolean z2 = this.noY != z;
        this.noY = z;
        if (z && z2) {
            getCurrentPage().getCurrentPageView().bRp();
            super.setVisibility(0);
            if (this.noZ) {
                adK("setActuallyVisible");
            }
        }
        if (!z && z2) {
            super.setVisibility(4);
        }
        AppMethodBeat.o(135051);
    }

    /* access modifiers changed from: protected */
    public final void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(135052);
        if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            AppMethodBeat.o(135052);
        } else if (this.kEc == null) {
            Log.w("MicroMsg.AppBrandPageContainer", "runOnUiThread but mRuntime==NULL, appId:%s, stack:%s", getAppId(), android.util.Log.getStackTraceString(new Throwable()));
            AppMethodBeat.o(135052);
        } else {
            this.kEc.i(runnable, 0);
            AppMethodBeat.o(135052);
        }
    }

    public final int getPageCount() {
        int size;
        AppMethodBeat.i(135053);
        synchronized (this.npd) {
            try {
                size = this.npe.size() + this.npf.size();
            } finally {
                AppMethodBeat.o(135053);
            }
        }
        return size;
    }

    private int getActualPageStackSize() {
        int size;
        AppMethodBeat.i(176586);
        synchronized (this.npd) {
            try {
                size = this.npe.size();
            } finally {
                AppMethodBeat.o(176586);
            }
        }
        return size;
    }

    public final Iterator<t> bQQ() {
        AppMethodBeat.i(135054);
        AnonymousClass12 r0 = new Iterator<t>() {
            /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass12 */
            final ListIterator<t> npC = w.this.npe.listIterator();

            {
                AppMethodBeat.i(219382);
                AppMethodBeat.o(219382);
            }

            public final boolean hasNext() {
                AppMethodBeat.i(219383);
                boolean hasNext = this.npC.hasNext();
                AppMethodBeat.o(219383);
                return hasNext;
            }

            public final void remove() {
                AppMethodBeat.i(219384);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.o(219384);
                throw unsupportedOperationException;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.Iterator
            public final /* bridge */ /* synthetic */ t next() {
                AppMethodBeat.i(219385);
                t next = this.npC.next();
                AppMethodBeat.o(219385);
                return next;
            }
        };
        AppMethodBeat.o(135054);
        return r0;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public void init(final String str) {
        AppMethodBeat.i(135055);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass23 */

            public final void run() {
                AppMethodBeat.i(135041);
                w.a(w.this, str, bx.APP_LAUNCH);
                AppMethodBeat.o(135041);
            }
        });
        AppMethodBeat.o(135055);
    }

    public final void adC(final String str) {
        AppMethodBeat.i(135056);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass27 */

            public final void run() {
                AppMethodBeat.i(135042);
                w.a(w.this, str, bx.NAVIGATE_TO);
                AppMethodBeat.o(135042);
            }
        });
        AppMethodBeat.o(135056);
    }

    public final void ax(final String str, final boolean z) {
        AppMethodBeat.i(135057);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass28 */

            public final void run() {
                AppMethodBeat.i(135043);
                w.a(w.this, str, z ? bx.AUTO_RE_LAUNCH : bx.RE_LAUNCH);
                AppMethodBeat.o(135043);
            }
        });
        AppMethodBeat.o(135057);
    }

    public final void adD(final String str) {
        AppMethodBeat.i(135058);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass29 */

            public final void run() {
                AppMethodBeat.i(135044);
                w.a(w.this, str, bx.REDIRECT_TO);
                AppMethodBeat.o(135044);
            }
        });
        AppMethodBeat.o(135058);
    }

    public final boolean ar(int i2, String str) {
        ac acVar;
        AppMethodBeat.i(219405);
        if (i2 != 0) {
            acVar = hL(i2);
            if (acVar == null) {
                Log.w("MicroMsg.AppBrandPageContainer", "rewriteRoute invalid page appId:%s, webviewId:%d, url:%s", getAppId(), Integer.valueOf(i2), str);
                AppMethodBeat.o(219405);
                return false;
            }
        } else if (getCurrentPage() == null || (acVar = getCurrentPage().getCurrentPageView()) == null) {
            Log.w("MicroMsg.AppBrandPageContainer", "rewriteRoute invalid page appId:%s, url:%s", getAppId(), str);
            AppMethodBeat.o(219405);
            return false;
        }
        boolean adL = acVar.adL(str);
        AppMethodBeat.o(219405);
        return adL;
    }

    private ac hL(int i2) {
        ac hL;
        AppMethodBeat.i(219406);
        LinkedList linkedList = new LinkedList();
        synchronized (this.npd) {
            try {
                linkedList.addAll(this.npf);
                linkedList.addAll(this.npe);
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    t tVar = (t) it.next();
                    if (tVar != null && (hL = tVar.hL(i2)) != null) {
                        return hL;
                    }
                }
                AppMethodBeat.o(219406);
                return null;
            } finally {
                AppMethodBeat.o(219406);
            }
        }
    }

    public final void adE(final String str) {
        AppMethodBeat.i(135059);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass30 */

            public final void run() {
                AppMethodBeat.i(219400);
                w.a(w.this, str, bx.SWITCH_TAB);
                AppMethodBeat.o(219400);
            }
        });
        AppMethodBeat.o(135059);
    }

    public final void bQR() {
        AppMethodBeat.i(135060);
        ax(this.kEc.getAppConfig().bzI(), true);
        AppMethodBeat.o(135060);
    }

    public final void adF(final String str) {
        AppMethodBeat.i(176587);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass32 */

            public final void run() {
                AppMethodBeat.i(135047);
                w.this.adG(str);
                AppMethodBeat.o(135047);
            }
        });
        AppMethodBeat.o(176587);
    }

    public final void a(final int i2, final String str, final com.tencent.mm.plugin.appbrand.page.b.f fVar) {
        AppMethodBeat.i(219407);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(135024);
                w.a(w.this, i2, str, fVar);
                AppMethodBeat.o(135024);
            }
        });
        AppMethodBeat.o(219407);
    }

    public final void adG(String str) {
        AppMethodBeat.i(219408);
        a(1, str, (com.tencent.mm.plugin.appbrand.page.b.f) null);
        AppMethodBeat.o(219408);
    }

    public final void a(final t tVar, final String str) {
        AppMethodBeat.i(176589);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(176564);
                int l = w.this.l(tVar);
                if (l < 0) {
                    Log.w("MicroMsg.AppBrandPageContainer", "navigateBack with appId(%s) Page(%s), but already off stack, maybe frequent clicks were performed", w.this.getAppId(), tVar.getCurrentUrl());
                    AppMethodBeat.o(176564);
                    return;
                }
                w.a(w.this, l + 1, str, (com.tencent.mm.plugin.appbrand.page.b.f) null);
                AppMethodBeat.o(176564);
            }
        });
        AppMethodBeat.o(176589);
    }

    public final void b(final t tVar, final String str) {
        AppMethodBeat.i(176590);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(176565);
                w.a(w.this, w.this.l(tVar), str, (com.tencent.mm.plugin.appbrand.page.b.f) null);
                AppMethodBeat.o(176565);
            }
        });
        AppMethodBeat.o(176590);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0015  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean d(java.lang.String r5, java.lang.Runnable r6) {
        /*
            r4 = this;
            r3 = 219409(0x35911, float:3.07457E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            java.util.List r1 = r4.getNavigateBackInterceptorChain()
            r0 = 0
            java.util.Iterator r1 = r1.iterator()
        L_0x000f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0025
            java.lang.Object r0 = r1.next()
            com.tencent.mm.plugin.appbrand.page.b.e r0 = (com.tencent.mm.plugin.appbrand.page.b.e) r0
            com.tencent.mm.plugin.appbrand.AppBrandRuntime r2 = r4.getRuntime()
            boolean r0 = r0.a(r2, r5, r6)
            if (r0 == 0) goto L_0x000f
        L_0x0025:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.page.w.d(java.lang.String, java.lang.Runnable):boolean");
    }

    /* access modifiers changed from: protected */
    public h a(t tVar, t tVar2) {
        AppMethodBeat.i(176591);
        Objects.requireNonNull(tVar2);
        Object[] objArr = new Object[4];
        objArr[0] = getAppId();
        objArr[1] = tVar == null ? null : l.dM(tVar.getCurrentUrl());
        objArr[2] = l.dM(tVar2.getCurrentUrl());
        objArr[3] = Boolean.valueOf(this.noY);
        Log.i("MicroMsg.AppBrandPageContainer", "onNavigateBack, appId[%s] out[%s], in[%s], mActuallyVisible[%b]", objArr);
        if (this.noY) {
            tVar2.getCurrentPageView().bRp();
        }
        if (tVar != null) {
            tVar.hideVKB();
        }
        getRuntime().kAx.a(tVar2.getCurrentPageView(), bx.NAVIGATE_BACK);
        j(tVar2.getCurrentPageView());
        h hVar = this.npp;
        if (this.npr != null && !this.npq) {
            hVar = this.npr.b(bx.NAVIGATE_BACK, tVar, tVar2);
            this.npq = true;
        }
        AppMethodBeat.o(176591);
        return hVar;
    }

    private t a(String str, bx bxVar) {
        AppMethodBeat.i(135065);
        if (b(str, bxVar)) {
            m mVar = new m(getContext(), this);
            AppMethodBeat.o(135065);
            return mVar;
        }
        ak akVar = new ak(getContext(), this);
        AppMethodBeat.o(135065);
        return akVar;
    }

    public h a(t tVar, t tVar2, bx bxVar, String str, boolean z) {
        AppMethodBeat.i(219410);
        Object[] objArr = new Object[5];
        objArr[0] = getAppId();
        objArr[1] = tVar == null ? null : l.dM(tVar.getCurrentUrl());
        objArr[2] = l.dM(str);
        objArr[3] = Boolean.valueOf(this.noY);
        objArr[4] = bxVar;
        Log.i("MicroMsg.AppBrandPageContainer", "onNavigateStart, appId[%s] out[%s], in[%s], mActuallyVisible[%b], type[%s]", objArr);
        if (tVar != null) {
            tVar.hideVKB();
        }
        h hVar = this.npp;
        if (this.npr != null && !this.npq) {
            hVar = this.npr.b(bxVar, tVar, tVar2);
            this.npq = true;
        }
        if (bx.APP_LAUNCH == bxVar) {
            getRuntime().kAx.a(tVar2.getCurrentPageView(), bxVar);
            j(tVar2.getCurrentPageView());
        }
        if (!(tVar == null || tVar.getCurrentPageView() == null || tVar.getCurrentPageView().getFullscreenImpl() == null || !tVar.getCurrentPageView().getFullscreenImpl().bTK())) {
            tVar.getCurrentPageView().getFullscreenImpl().btC();
        }
        AppMethodBeat.o(219410);
        return hVar;
    }

    public void a(t tVar, t tVar2, bx bxVar) {
        AppMethodBeat.i(135067);
        Object[] objArr = new Object[5];
        objArr[0] = getAppId();
        objArr[1] = tVar == null ? null : l.dM(tVar.getCurrentUrl());
        objArr[2] = l.dM(tVar2.getCurrentUrl());
        objArr[3] = Boolean.valueOf(this.noY);
        objArr[4] = bxVar;
        Log.i("MicroMsg.AppBrandPageContainer", "onNavigateEnd, appId[%s] out[%s], in[%s], mActuallyVisible[%b], type[%s]", objArr);
        if (this.noY) {
            tVar2.getCurrentPageView().bRp();
        }
        if (bx.APP_LAUNCH != bxVar) {
            getRuntime().kAx.a(tVar2.getCurrentPageView(), bxVar);
        }
        if (e(tVar2)) {
            tVar2.getCurrentPageView().bRD();
        }
        j(tVar2.getCurrentPageView());
        AppMethodBeat.o(135067);
    }

    /* access modifiers changed from: protected */
    public boolean e(t tVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        AppMethodBeat.i(219411);
        String currentUrl = tVar.getCurrentUrl();
        boolean[] zArr = new boolean[5];
        zArr[0] = getPageCount() == 1;
        if (!currentUrl.startsWith(getRuntime().getAppConfig().bzI())) {
            z = true;
        } else {
            z = false;
        }
        zArr[1] = z;
        if (tVar.getCurrentPageView().bRi() != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        zArr[2] = z2;
        if (!tVar.getCurrentPageView().bRi().isFullscreenMode()) {
            z3 = true;
        } else {
            z3 = false;
        }
        zArr[3] = z3;
        zArr[4] = !(tVar instanceof m);
        int i2 = 0;
        while (true) {
            if (i2 >= 5) {
                z4 = true;
                break;
            } else if (!zArr[i2]) {
                Log.i("MicroMsg.AppBrandPageContainer", "[%s,%s]->shouldShowActionBarHomeButton: test fail cause #[%d] condition,", tVar.getAppId(), tVar.getCurrentUrl(), Integer.valueOf(i2));
                break;
            } else {
                i2++;
            }
        }
        AppMethodBeat.o(219411);
        return z4;
    }

    private boolean adH(String str) {
        t first;
        AppMethodBeat.i(219412);
        final t currentPage = getCurrentPage();
        m adI = adI(str);
        if (adI != null) {
            final h[] hVarArr = new h[1];
            adI.a(str, new m.b() {
                /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass10 */

                @Override // com.tencent.mm.plugin.appbrand.page.m.b
                public final void b(m mVar, String str) {
                    AppMethodBeat.i(219378);
                    hVarArr[0] = w.this.a(currentPage, mVar, bx.SWITCH_TAB, str, by.c(bx.SWITCH_TAB));
                    mVar.a(bx.SWITCH_TAB, hVarArr[0]);
                    AppMethodBeat.o(219378);
                }

                @Override // com.tencent.mm.plugin.appbrand.page.m.b
                public final void e(m mVar) {
                    AppMethodBeat.i(219379);
                    mVar.b(bx.SWITCH_TAB);
                    w.a(w.this, bx.SWITCH_TAB, currentPage, mVar);
                    w.this.a(currentPage, mVar, bx.SWITCH_TAB);
                    AppMethodBeat.o(219379);
                }
            });
            AppMethodBeat.o(219412);
            return true;
        }
        m adJ = adJ(str);
        if (adJ != null) {
            final h[] hVarArr2 = new h[1];
            adJ.a(str, new m.b() {
                /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass11 */

                @Override // com.tencent.mm.plugin.appbrand.page.m.b
                public final void b(m mVar, String str) {
                    AppMethodBeat.i(219380);
                    hVarArr2[0] = w.this.a(currentPage, mVar, bx.SWITCH_TAB, str, by.c(bx.SWITCH_TAB));
                    AppMethodBeat.o(219380);
                }

                @Override // com.tencent.mm.plugin.appbrand.page.m.b
                public final void e(m mVar) {
                    AppMethodBeat.i(219381);
                    w.this.a(currentPage, mVar, bx.SWITCH_TAB);
                    AppMethodBeat.o(219381);
                }
            });
            synchronized (this.npd) {
                try {
                    first = this.npe.getFirst();
                } catch (Throwable th) {
                    AppMethodBeat.o(219412);
                    throw th;
                }
            }
            b(first, adJ);
            a(adJ, first, bx.SWITCH_TAB, hVarArr2[0]);
            AppMethodBeat.o(219412);
            return true;
        }
        AppMethodBeat.o(219412);
        return false;
    }

    private boolean b(String str, bx bxVar) {
        boolean z;
        int i2;
        int i3;
        AppMethodBeat.i(135069);
        if (bxVar == bx.SWITCH_TAB) {
            AppMethodBeat.o(135069);
            return true;
        } else if (bxVar == bx.RE_LAUNCH || bxVar == bx.AUTO_RE_LAUNCH) {
            boolean WX = this.kEc.getAppConfig().bzG().WX(str);
            AppMethodBeat.o(135069);
            return WX;
        } else {
            synchronized (this.npd) {
                try {
                    if (bxVar == bx.REDIRECT_TO || bxVar == bx.REWRITE_ROUTE) {
                        z = true;
                    } else {
                        z = false;
                    }
                    int size = this.npe.size() + 1;
                    if (z) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    i3 = size - i2;
                } catch (Throwable th) {
                    AppMethodBeat.o(135069);
                    throw th;
                }
            }
            if (!this.kEc.getAppConfig().bzG().WX(str) || i3 != 1) {
                AppMethodBeat.o(135069);
                return false;
            }
            AppMethodBeat.o(135069);
            return true;
        }
    }

    private void bQS() {
        LinkedList linkedList;
        AppMethodBeat.i(176593);
        synchronized (this.npd) {
            try {
                linkedList = new LinkedList(this.npg);
                this.npg.clear();
            } finally {
                AppMethodBeat.o(176593);
            }
        }
        Iterator descendingIterator = linkedList.descendingIterator();
        while (descendingIterator.hasNext()) {
            c cVar = (c) descendingIterator.next();
            cVar.ig(true);
            cVar.run();
            descendingIterator.remove();
        }
    }

    private void b(t tVar, t tVar2) {
        AppMethodBeat.i(135071);
        LinkedList<t> linkedList = new LinkedList();
        synchronized (this.npd) {
            try {
                Iterator<t> it = this.npe.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    t next = it.next();
                    if (next == tVar) {
                        z = true;
                    } else if (next == tVar2) {
                        break;
                    } else if (z) {
                        linkedList.add(next);
                        it.remove();
                        this.npf.remove(next);
                    }
                }
            } finally {
                AppMethodBeat.o(135071);
            }
        }
        for (t tVar3 : linkedList) {
            q(tVar3);
            j(tVar3);
        }
    }

    private void a(final t tVar, final t tVar2, final bx bxVar, h hVar) {
        boolean z;
        Object obj;
        Object obj2 = null;
        AppMethodBeat.i(176594);
        synchronized (this.npd) {
            try {
                this.npe.remove(tVar2);
                this.npf.remove(tVar2);
            } catch (Throwable th) {
                AppMethodBeat.o(176594);
                throw th;
            }
        }
        if (!tVar2.mSwiping) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            obj = b(tVar2, new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass13 */

                public final void run() {
                    AppMethodBeat.i(135035);
                    w.a(w.this, tVar2);
                    AppMethodBeat.o(135035);
                }
            });
        } else {
            j(tVar2);
            obj = null;
        }
        Log.i("MicroMsg.AppBrandPageContainer", "switchPageClear, in: %s out: %s", tVar.getCurrentUrl(), tVar2.getCurrentUrl());
        Log.d("MicroMsg.AppBrandPageContainer", "switchPageClear, dispatchRoute, type: %s, pipMode: %s", bxVar, hVar);
        tVar.a(bxVar, hVar);
        tVar.bQN();
        if (z) {
            obj2 = a(tVar, new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass14 */

                public final void run() {
                    AppMethodBeat.i(176569);
                    tVar.b(bxVar);
                    AppMethodBeat.o(176569);
                }
            });
        } else {
            tVar.b(bxVar);
        }
        a(bxVar, tVar2, tVar, new g(obj2, obj));
        AppMethodBeat.o(176594);
    }

    private Object a(final t tVar, boolean z, final boolean z2) {
        AppMethodBeat.i(176595);
        if (tVar == null) {
            AppMethodBeat.o(176595);
            return null;
        }
        if (z2) {
            synchronized (this.npd) {
                try {
                    this.npe.remove(tVar);
                    this.npf.remove(tVar);
                } catch (Throwable th) {
                    AppMethodBeat.o(176595);
                    throw th;
                }
            }
        }
        tVar.bQO();
        AnonymousClass15 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass15 */

            public final void run() {
                AppMethodBeat.i(176570);
                if (z2) {
                    w.a(w.this, tVar);
                }
                AppMethodBeat.o(176570);
            }
        };
        if (z) {
            Object a2 = a(tVar, n(tVar), r1);
            AppMethodBeat.o(176595);
            return a2;
        }
        q(tVar);
        r1.run();
        AppMethodBeat.o(176595);
        return null;
    }

    private Object a(final t tVar, final bx bxVar, boolean z) {
        AppMethodBeat.i(219413);
        if (tVar == null) {
            AppMethodBeat.o(219413);
            return null;
        }
        synchronized (this.npd) {
            try {
                this.npe.remove(tVar);
                this.npe.push(tVar);
                this.npf.remove(tVar);
            } catch (Throwable th) {
                AppMethodBeat.o(219413);
                throw th;
            }
        }
        tVar.bringToFront();
        requestLayout();
        invalidate();
        tVar.bQN();
        AnonymousClass16 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass16 */

            public final void run() {
                AppMethodBeat.i(219386);
                tVar.b(bxVar);
                AppMethodBeat.o(219386);
            }
        };
        if (z) {
            Object a2 = a(tVar, m(tVar), r1);
            AppMethodBeat.o(219413);
            return a2;
        }
        q(tVar);
        r1.run();
        AppMethodBeat.o(219413);
        return null;
    }

    private m adI(String str) {
        m mVar;
        AppMethodBeat.i(219414);
        synchronized (this.npd) {
            try {
                t peekFirst = this.npe.peekFirst();
                if (!(peekFirst instanceof m) || !peekFirst.dw(str)) {
                    mVar = null;
                    AppMethodBeat.o(219414);
                } else {
                    mVar = (m) peekFirst;
                }
            } finally {
                AppMethodBeat.o(219414);
            }
        }
        return mVar;
    }

    private m adJ(String str) {
        AppMethodBeat.i(219415);
        synchronized (this.npd) {
            try {
                if (this.npe.size() < 2) {
                    return null;
                }
                ListIterator<t> listIterator = this.npe.listIterator(1);
                while (listIterator.hasNext()) {
                    t next = listIterator.next();
                    if ((next instanceof m) && next.dw(str)) {
                        m mVar = (m) next;
                        AppMethodBeat.o(219415);
                        return mVar;
                    }
                }
                AppMethodBeat.o(219415);
                return null;
            } finally {
                AppMethodBeat.o(219415);
            }
        }
    }

    private void j(t tVar) {
        AppMethodBeat.i(135076);
        if (this.npo != null) {
            this.npo.r(tVar);
        }
        tVar.setVisibility(8);
        tVar.bQO();
        if (!tVar.noQ) {
            tVar.performDestroy();
        }
        removeView(tVar);
        if (!tVar.noQ) {
            tVar.NR();
        }
        AppMethodBeat.o(135076);
    }

    public final void c(final String str, final String str2, final int[] iArr) {
        AppMethodBeat.i(135077);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass17 */

            public final void run() {
                AppMethodBeat.i(219387);
                w.a(w.this, str, str2, iArr);
                AppMethodBeat.o(219387);
            }
        });
        AppMethodBeat.o(135077);
    }

    /* JADX INFO: finally extract failed */
    public t getCurrentPage() {
        t peekFirst;
        boolean z = true;
        AppMethodBeat.i(135078);
        synchronized (this.npd) {
            try {
                if (!this.npf.isEmpty()) {
                    peekFirst = this.npf.getFirst();
                    try {
                        if (this.kEc != null) {
                            if (!this.kEc.bry() || this.kEc.mInitialized) {
                                z = false;
                            }
                            if (peekFirst == null && !z) {
                                Log.e("MicroMsg.AppBrandPageContainer", "getCurrentPage returns NULL, appId[%s] mStagingStack.size[%d] mPageStack.size[%d] stack:%s", getAppId(), Integer.valueOf(this.npf.size()), Integer.valueOf(this.npe.size()), android.util.Log.getStackTraceString(new Throwable()));
                            }
                        }
                    } finally {
                        AppMethodBeat.o(135078);
                    }
                } else {
                    peekFirst = this.npe.peekFirst();
                    if (this.kEc != null) {
                        if (!this.kEc.bry() || this.kEc.mInitialized) {
                            z = false;
                        }
                        if (peekFirst == null && !z) {
                            Log.e("MicroMsg.AppBrandPageContainer", "getCurrentPage returns NULL, appId[%s] mStagingStack.size[%d] mPageStack.size[%d] stack:%s", getAppId(), Integer.valueOf(this.npf.size()), Integer.valueOf(this.npe.size()), android.util.Log.getStackTraceString(new Throwable()));
                        }
                    }
                    AppMethodBeat.o(135078);
                }
            } catch (Throwable th) {
                if (this.kEc != null) {
                    if (!this.kEc.bry() || this.kEc.mInitialized) {
                        z = false;
                    }
                    if (0 == 0 && !z) {
                        Log.e("MicroMsg.AppBrandPageContainer", "getCurrentPage returns NULL, appId[%s] mStagingStack.size[%d] mPageStack.size[%d] stack:%s", getAppId(), Integer.valueOf(this.npf.size()), Integer.valueOf(this.npe.size()), android.util.Log.getStackTraceString(new Throwable()));
                    }
                }
                AppMethodBeat.o(135078);
                throw th;
            }
        }
        return peekFirst;
    }

    public final t k(t tVar) {
        t tVar2;
        AppMethodBeat.i(135079);
        synchronized (this.npd) {
            try {
                if (this.npf.contains(tVar)) {
                    tVar2 = this.npe.peekFirst();
                } else {
                    int indexOf = this.npe.indexOf(tVar);
                    if (indexOf >= this.npe.size() - 1) {
                        tVar2 = null;
                        AppMethodBeat.o(135079);
                    } else {
                        tVar2 = this.npe.get(indexOf + 1);
                        AppMethodBeat.o(135079);
                    }
                }
            } finally {
                AppMethodBeat.o(135079);
            }
        }
        return tVar2;
    }

    /* access modifiers changed from: package-private */
    public final int l(t tVar) {
        int indexOf;
        AppMethodBeat.i(176597);
        synchronized (this.npd) {
            try {
                indexOf = this.npe.indexOf(tVar);
            } finally {
                AppMethodBeat.o(176597);
            }
        }
        return indexOf;
    }

    public String getCurrentUrl() {
        AppMethodBeat.i(135080);
        t currentPage = getCurrentPage();
        if (currentPage != null) {
            String currentUrl = currentPage.getCurrentUrl();
            AppMethodBeat.o(135080);
            return currentUrl;
        }
        AppMethodBeat.o(135080);
        return null;
    }

    public final void cleanup() {
        AppMethodBeat.i(135081);
        this.mDestroyed = true;
        onDestroy();
        LinkedList linkedList = new LinkedList();
        synchronized (this.npe) {
            try {
                linkedList.addAll(this.npe);
                linkedList.addAll(this.npf);
                this.npe.clear();
                this.npf.clear();
            } catch (Throwable th) {
                AppMethodBeat.o(135081);
                throw th;
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            tVar.bQO();
            tVar.performDestroy();
            tVar.NR();
            q(tVar);
        }
        linkedList.clear();
        if (this.nph != null) {
            try {
                this.nph.onDestroy();
            } catch (Exception e2) {
            }
            try {
                this.nph.cleanup();
            } catch (Exception e3) {
            }
        }
        removeAllViews();
        this.npn = null;
        this.kEc = null;
        this.npo = null;
        AppMethodBeat.o(135081);
    }

    public final ac bQT() {
        AppMethodBeat.i(135082);
        boolean z = !this.npi;
        this.npi = true;
        if (this.nph == null) {
            ac bQU = bQU();
            if (bQU == null) {
                bQU = new ac();
            }
            if (z) {
                bQU.nqW = true;
            }
            bQU.npk = getDecorWidgetFactory();
            bQU.a(getContext(), this.kEc);
            AppMethodBeat.o(135082);
            return bQU;
        }
        ac acVar = this.nph;
        this.nph = null;
        if (z) {
            acVar.nqW = true;
        }
        View contentView = acVar.getContentView();
        if (contentView != null) {
            contentView.setVisibility(0);
        }
        removeView(acVar.getContentView());
        AppMethodBeat.o(135082);
        return acVar;
    }

    private ac bQU() {
        ac a2;
        AppMethodBeat.i(135083);
        if (this.npa == null || (a2 = this.npa.a(this)) == null) {
            AppMethodBeat.o(135083);
            return null;
        }
        AppMethodBeat.o(135083);
        return a2;
    }

    public final ac getPageView() {
        ac acVar = null;
        AppMethodBeat.i(135084);
        if (this.mDestroyed) {
            AppMethodBeat.o(135084);
        } else {
            boolean z = this.kEc.kAU;
            t currentPage = getCurrentPage();
            if (currentPage == null) {
                if (z) {
                    Assert.fail("getPageView() assert by NULL page, appId=" + getAppId());
                }
                AppMethodBeat.o(135084);
            } else {
                acVar = currentPage.getCurrentPageView();
                if (acVar == null && z) {
                    Assert.fail("getPageView() assert by NULL pv, appId=" + getAppId());
                }
                AppMethodBeat.o(135084);
            }
        }
        return acVar;
    }

    /* access modifiers changed from: package-private */
    public ac getPreloadedPageView() {
        return this.nph;
    }

    public final void i(final ac acVar) {
        AppMethodBeat.i(219416);
        if (!MMHandlerThread.isMainThread()) {
            getRuntime().i(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass18 */

                public final void run() {
                    AppMethodBeat.i(219388);
                    w.this.i(acVar);
                    AppMethodBeat.o(219388);
                }
            }, 0);
            AppMethodBeat.o(219416);
            return;
        }
        this.npl.u(acVar);
        AppMethodBeat.o(219416);
    }

    public final void adK(final String str) {
        AppMethodBeat.i(219417);
        if (!MMHandlerThread.isMainThread()) {
            getRuntime().i(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass19 */

                public final void run() {
                    AppMethodBeat.i(219389);
                    w.this.adK(str);
                    AppMethodBeat.o(219389);
                }
            }, 0);
            AppMethodBeat.o(219417);
        } else if (this.mDestroyed) {
            Log.w("MicroMsg.AppBrandPageContainer", "preloadNext, destroyed, appId:%s, reason:%s", getAppId(), str);
            AppMethodBeat.o(219417);
        } else if (!this.noY) {
            this.noZ = true;
            Log.i("MicroMsg.AppBrandPageContainer", "preloadNext, deferred, appId:%s, reason:%s", getAppId(), str);
            AppMethodBeat.o(219417);
        } else {
            this.noZ = false;
            if (this.npa != null && this.npa.MX()) {
                Log.i("MicroMsg.AppBrandPageContainer", "preloadNext, intercepted, appId:%s, reason:%s", getAppId(), str);
                AppMethodBeat.o(219417);
            } else if (this.nph != null) {
                Log.i("MicroMsg.AppBrandPageContainer", "preloadNext, already preloaded, appId:%s, reason:%s", getAppId(), str);
                AppMethodBeat.o(219417);
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                ac bQU = bQU();
                if (bQU == null) {
                    bQU = new ac();
                }
                bQU.npk = getDecorWidgetFactory();
                bQU.a(getContext(), this.kEc);
                bQU.hide();
                addView(bQU.getContentView(), 0);
                this.nph = bQU;
                Log.i("MicroMsg.AppBrandPageContainer", "preloadNextPageView: appId:%s, cost:%d, reason:%s", getAppId(), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), str);
                AppMethodBeat.o(219417);
            }
        }
    }

    public final com.tencent.mm.plugin.appbrand.config.b getAppConfig() {
        AppMethodBeat.i(135086);
        com.tencent.mm.plugin.appbrand.config.b appConfig = this.kEc.getAppConfig();
        AppMethodBeat.o(135086);
        return appConfig;
    }

    public AppBrandRuntime getRuntime() {
        return this.kEc;
    }

    public void onForeground() {
        t peekFirst;
        AppMethodBeat.i(135087);
        synchronized (this.npd) {
            try {
                peekFirst = this.npe.peekFirst();
            } finally {
                AppMethodBeat.o(135087);
            }
        }
        if (peekFirst == null) {
            AppMethodBeat.o(135087);
            return;
        }
        peekFirst.bQN();
        if (this.noY) {
            Log.d("MicroMsg.AppBrandPageContainer", "onForeground, call onUserVisible, appId[%s] url[%s]", getAppId(), peekFirst.getCurrentPageView().lBI);
            peekFirst.getCurrentPageView().bRp();
        }
    }

    public void onBackground() {
        t peekFirst;
        AppMethodBeat.i(135088);
        synchronized (this.npd) {
            try {
                peekFirst = this.npe.peekFirst();
            } catch (Throwable th) {
                AppMethodBeat.o(135088);
                throw th;
            }
        }
        if (peekFirst == null) {
            AppMethodBeat.o(135088);
            return;
        }
        peekFirst.bQO();
        AppMethodBeat.o(135088);
    }

    /* access modifiers changed from: protected */
    public final void bQV() {
        AppMethodBeat.i(135089);
        if (this.kEc == null) {
            AppMethodBeat.o(135089);
            return;
        }
        if (this.npm) {
            if (this.npn != null) {
                this.npn.brP();
            }
            onReady();
            this.npm = false;
        }
        AppMethodBeat.o(135089);
    }

    /* access modifiers changed from: protected */
    public void onReady() {
    }

    public void setOnReadyListener(f fVar) {
        this.npn = fVar;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
    }

    public Object m(t tVar) {
        AppMethodBeat.i(135090);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tVar, "translationX", (float) tVar.getWidth(), 0.0f);
        ofFloat.setDuration(250L);
        AppMethodBeat.o(135090);
        return ofFloat;
    }

    public Object n(t tVar) {
        AppMethodBeat.i(135091);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tVar, "translationX", 0.0f, -(((float) tVar.getWidth()) * 0.25f));
        ofFloat.setDuration(250L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(tVar, "translationX", 0.0f);
        ofFloat2.setDuration(0L);
        new AnimatorSet().playSequentially(ofFloat, ofFloat2);
        AppMethodBeat.o(135091);
        return ofFloat;
    }

    public Object o(t tVar) {
        AppMethodBeat.i(135092);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tVar, "translationX", -(((float) tVar.getWidth()) * 0.25f), 0.0f);
        ofFloat.setDuration(250L);
        AppMethodBeat.o(135092);
        return ofFloat;
    }

    public Object p(t tVar) {
        AppMethodBeat.i(135093);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tVar, "translationX", 0.0f, (float) tVar.getWidth());
        ofFloat.setDuration(250L);
        AppMethodBeat.o(135093);
        return ofFloat;
    }

    private Object a(t tVar, Runnable runnable) {
        AppMethodBeat.i(219418);
        Object a2 = a(tVar, o(tVar), runnable);
        AppMethodBeat.o(219418);
        return a2;
    }

    private Object b(t tVar, Runnable runnable) {
        AppMethodBeat.i(219419);
        Object a2 = a(tVar, p(tVar), runnable);
        AppMethodBeat.o(219419);
        return a2;
    }

    private static void q(t tVar) {
        AppMethodBeat.i(135094);
        tVar.clearAnimation();
        Object tag = tVar.getTag(noX);
        if (tag instanceof Animator) {
            Animator animator = (Animator) tag;
            animator.cancel();
            animator.removeAllListeners();
            AppMethodBeat.o(135094);
            return;
        }
        if (tag instanceof Animation) {
            Animation animation = (Animation) tag;
            animation.setAnimationListener(null);
            animation.cancel();
        }
        AppMethodBeat.o(135094);
    }

    private Object a(final t tVar, Object obj, final Runnable runnable) {
        AppMethodBeat.i(176598);
        if (obj instanceof Animator) {
            Animator animator = (Animator) obj;
            q(tVar);
            tVar.setTag(noX, animator);
            animator.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass20 */

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(219391);
                    tVar.setTag(w.noX, null);
                    if (runnable != null) {
                        w.this.removeCallbacks(runnable);
                        if (!w.this.mDestroyed) {
                            runnable.run();
                        }
                    }
                    AppMethodBeat.o(219391);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(219392);
                    tVar.setTag(w.noX, null);
                    if (runnable != null) {
                        w.this.post(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass20.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(219390);
                                if (!w.this.mDestroyed) {
                                    runnable.run();
                                }
                                AppMethodBeat.o(219390);
                            }
                        });
                    }
                    AppMethodBeat.o(219392);
                }
            });
            animator.start();
        } else if (obj instanceof Animation) {
            Animation animation = (Animation) obj;
            animation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass21 */

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(219394);
                    if (runnable != null) {
                        AnonymousClass1 r0 = new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass21.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(219393);
                                if (!w.this.mDestroyed) {
                                    runnable.run();
                                }
                                tVar.setTag(w.noX, null);
                                AppMethodBeat.o(219393);
                            }
                        };
                        if (animation.getStartTime() == Long.MIN_VALUE) {
                            r0.run();
                            AppMethodBeat.o(219394);
                            return;
                        }
                        if (!w.this.mDestroyed) {
                            w.this.post(r0);
                        }
                        AppMethodBeat.o(219394);
                        return;
                    }
                    tVar.setTag(w.noX, null);
                    AppMethodBeat.o(219394);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            q(tVar);
            tVar.setTag(noX, animation);
            tVar.startAnimation(animation);
        } else if (obj != null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Page animation should be Animator or Animation");
            AppMethodBeat.o(176598);
            throw illegalArgumentException;
        } else if (runnable != null) {
            runnable.run();
        }
        AppMethodBeat.o(176598);
        return obj;
    }

    public void onBackPressed() {
        boolean z;
        AppMethodBeat.i(135096);
        t currentPage = getCurrentPage();
        if (currentPage == null) {
            AppMethodBeat.o(135096);
        } else if (currentPage.getCurrentPageView().onBackPressed()) {
            AppMethodBeat.o(135096);
        } else {
            synchronized (this.npd) {
                try {
                    z = !this.npf.isEmpty();
                } catch (Throwable th) {
                    AppMethodBeat.o(135096);
                    throw th;
                }
            }
            if (z || currentPage.getTag(noX) != null) {
                Log.w("MicroMsg.AppBrandPageContainer", "onBackPressed, has navigating pages, skip");
                AppMethodBeat.o(135096);
                return;
            }
            adF("scene_back_key_pressed");
            AppMethodBeat.o(135096);
        }
    }

    public final boolean bQW() {
        AppMethodBeat.i(219420);
        if (getActualPageStackSize() > 1 || getRuntime().kAN) {
            AppMethodBeat.o(219420);
            return true;
        }
        AppMethodBeat.o(219420);
        return false;
    }

    public enum h {
        MIN("min"),
        MAX("max");
        
        public final String name;

        public static h valueOf(String str) {
            AppMethodBeat.i(176582);
            h hVar = (h) Enum.valueOf(h.class, str);
            AppMethodBeat.o(176582);
            return hVar;
        }

        static {
            AppMethodBeat.i(176583);
            AppMethodBeat.o(176583);
        }

        private h(String str) {
            this.name = str;
        }
    }

    public void setPipPageLifeCycleListener(i iVar) {
        this.npo = iVar;
    }

    /* access modifiers changed from: package-private */
    public static class g {
        final Object npT;
        final Object npU;

        g(Object obj, Object obj2) {
            this.npT = obj;
            this.npU = obj2;
        }

        public final String toString() {
            AppMethodBeat.i(176580);
            String str = "PageSwitchResult{enterAnimation=" + this.npT + ", exitAnimation=" + this.npU + '}';
            AppMethodBeat.o(176580);
            return str;
        }
    }

    private void a(final bx bxVar, final t tVar, final t tVar2, g gVar) {
        AppMethodBeat.i(176599);
        Log.d("MicroMsg.AppBrandPageContainer", "processPageSwitchResult, pageSwitchResult: ".concat(String.valueOf(gVar)));
        if (this.npr == null) {
            Log.d("MicroMsg.AppBrandPageContainer", "processPageSwitchResult, null == mOnPageSwitchListener");
            AppMethodBeat.o(176599);
            return;
        }
        Object obj = gVar.npT;
        if (obj instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) obj;
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass22 */

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(219395);
                    super.onAnimationEnd(animator);
                    w.a(w.this, bxVar, tVar, tVar2);
                    AppMethodBeat.o(219395);
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(219396);
                    super.onAnimationCancel(animator);
                    w.this.npr.d(bxVar, tVar, tVar2);
                    w.this.npq = false;
                    AppMethodBeat.o(219396);
                }
            });
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass24 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(219397);
                    w.this.npr.aQ((float) ((int) (valueAnimator.getAnimatedFraction() * 100.0f)));
                    AppMethodBeat.o(219397);
                }
            });
            AppMethodBeat.o(176599);
        } else if (obj instanceof Animation) {
            final Animation animation = (Animation) obj;
            final long duration = animation.getDuration();
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
                /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass25 */

                public final void doFrame(long j2) {
                    AppMethodBeat.i(219398);
                    float elapsedRealtime = (((float) (SystemClock.elapsedRealtime() - elapsedRealtime)) + 0.0f) / ((float) duration);
                    if (1.0f <= elapsedRealtime) {
                        w.a(w.this, bxVar, tVar, tVar2);
                        AppMethodBeat.o(219398);
                        return;
                    }
                    w.this.npr.aQ((float) ((int) (animation.getInterpolator().getInterpolation(elapsedRealtime) * 100.0f)));
                    Choreographer.getInstance().postFrameCallback(this);
                    AppMethodBeat.o(219398);
                }
            });
            AppMethodBeat.o(176599);
        } else {
            a(bxVar, tVar, tVar2);
            AppMethodBeat.o(176599);
        }
    }

    private void a(bx bxVar, t tVar, t tVar2) {
        AppMethodBeat.i(176600);
        if (this.npr == null) {
            AppMethodBeat.o(176600);
            return;
        }
        if (!this.npq) {
            this.npp = this.npr.b(bxVar, tVar, tVar2);
            this.npq = true;
        }
        this.npr.c(bxVar, tVar, tVar2);
        this.npq = false;
        AppMethodBeat.o(176600);
    }

    public void setOnPageSwitchListener(e eVar) {
        AppMethodBeat.i(176601);
        Log.d("MicroMsg.AppBrandPageContainer", "setOnPageSwitchListener, onPageSwitchListener: ".concat(String.valueOf(eVar)));
        this.npr = eVar;
        AppMethodBeat.o(176601);
    }

    public final void j(final ac acVar) {
        AppMethodBeat.i(219421);
        getRuntime().kAT.setFullscreenImpl(acVar.getFullscreenImpl());
        getRuntime().kAT.a(new bd() {
            /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass26 */

            @Override // com.tencent.mm.plugin.appbrand.page.bd
            public final void a(AppBrandPageFullScreenView appBrandPageFullScreenView) {
                AppMethodBeat.i(219399);
                acVar.nqU.a(acVar, appBrandPageFullScreenView);
                AppMethodBeat.o(219399);
            }
        });
        AppMethodBeat.o(219421);
    }

    static /* synthetic */ void a(w wVar, final String str, final bx bxVar) {
        boolean z = false;
        AppMethodBeat.i(135097);
        if (wVar.kEc == null) {
            Log.e("MicroMsg.AppBrandPageContainer", "navigateToImpl destroyed, url[%s], type[%s]", str, bxVar);
            AppMethodBeat.o(135097);
            return;
        }
        Log.i("MicroMsg.AppBrandPageContainer", "navigateTo: %s, type[%s]", str, bxVar);
        if (Util.isNullOrNil(str)) {
            str = wVar.kEc.getAppConfig().bzI();
        }
        if (str.startsWith("?")) {
            str = wVar.kEc.getAppConfig().bzI() + str;
        }
        Log.i("MicroMsg.AppBrandPageContainer", "navigateTo: %s fixed, type[%s]", str, bxVar);
        wVar.bQS();
        if (bxVar != bx.SWITCH_TAB || !wVar.adH(str)) {
            AnonymousClass31 r1 = new d() {
                /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass31 */
                private boolean mCanceled = false;
                private boolean npP = false;
                private boolean npQ = false;

                @Override // com.tencent.mm.plugin.appbrand.page.w.d
                public final void proceed() {
                    AppMethodBeat.i(219401);
                    if (this.mCanceled) {
                        AppMethodBeat.o(219401);
                    } else if (w.this.kEc == null) {
                        Log.w("MicroMsg.AppBrandPageContainer", "attempt to proceed but destroyed, url[%s], type[%s]", str, bxVar);
                        AppMethodBeat.o(219401);
                    } else {
                        if (!this.npP) {
                            w.a(w.this, str, bxVar, this.npQ);
                            this.npP = true;
                        }
                        AppMethodBeat.o(219401);
                    }
                }

                @Override // com.tencent.mm.plugin.appbrand.page.w.d
                public final void cancel() {
                    this.mCanceled = true;
                }

                @Override // com.tencent.mm.plugin.appbrand.page.w.d
                public final void bQX() {
                    this.npQ = true;
                }
            };
            if (wVar.npa != null) {
                z = wVar.npa.a(str, bxVar, wVar, r1);
            }
            if (!z) {
                r1.proceed();
            }
        }
        AppMethodBeat.o(135097);
    }

    static /* synthetic */ void a(w wVar, final String str, final bx bxVar, boolean z) {
        int size;
        final t peekFirst;
        t tVar;
        AppMethodBeat.i(135098);
        synchronized (wVar.npd) {
            try {
                size = wVar.npf.size();
            } finally {
                AppMethodBeat.o(135098);
            }
        }
        Log.i("MicroMsg.AppBrandPageContainer", "navigateToNext: %s (%s), Staging Count: %d, disableAnimation %b", str, bxVar.name(), Integer.valueOf(size), Boolean.valueOf(z));
        final t tVar2 = (t) com.tencent.luggage.sdk.g.c.a("AppBrandPageContainerProfile| createPage", new kotlin.g.a.a<t>() {
            /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass7 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ t invoke() {
                AppMethodBeat.i(219376);
                t c2 = w.c(w.this, str, bxVar);
                AppMethodBeat.o(219376);
                return c2;
            }
        });
        ViewGroup viewGroup = tVar2 != null ? (ViewGroup) tVar2.getParent() : null;
        if (viewGroup != null) {
            Log.printErrStackTrace("MicroMsg.AppBrandPageContainer", new Throwable(), "page already has a parent", new Object[0]);
            viewGroup.removeView(tVar2);
        }
        wVar.addView(tVar2, 0);
        synchronized (wVar.npd) {
            try {
                peekFirst = wVar.npe.peekFirst();
            } finally {
                AppMethodBeat.o(135098);
            }
        }
        boolean z2 = z | (!by.c(bxVar));
        h a2 = wVar.a(peekFirst, tVar2, bxVar, str, !z2);
        final AnonymousClass8 r11 = new c() {
            /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass8 */
            private boolean noG = false;
            private boolean npx = false;

            public final void run() {
                t tVar;
                boolean z;
                String dM;
                AppMethodBeat.i(135030);
                if (this.noG) {
                    AppMethodBeat.o(135030);
                    return;
                }
                this.noG = true;
                if (w.this.getPageCount() == 0) {
                    AppMethodBeat.o(135030);
                    return;
                }
                synchronized (w.this.npd) {
                    try {
                        tVar = (t) w.this.npe.peekFirst();
                    } catch (Throwable th) {
                        AppMethodBeat.o(135030);
                        throw th;
                    }
                }
                if (by.e(bxVar)) {
                    w.a(w.this, tVar, (t) null);
                }
                if (!this.npx) {
                    z = true;
                } else {
                    z = false;
                }
                boolean d2 = by.d(bxVar);
                Object[] objArr = new Object[6];
                objArr[0] = w.this.getAppId();
                if (peekFirst == null) {
                    dM = null;
                } else {
                    dM = l.dM(peekFirst.getCurrentUrl());
                }
                objArr[1] = dM;
                objArr[2] = l.dM(tVar2.getCurrentUrl());
                objArr[3] = Boolean.valueOf(z);
                objArr[4] = Boolean.valueOf(d2);
                objArr[5] = bxVar;
                Log.i("MicroMsg.AppBrandPageContainer", "navigateToNext$navigateTask.run(), before switch page, appId[%s], out[%s] in[%s] animate[%b] close[%b] type[%s]", objArr);
                w.a(w.this, bxVar, tVar, tVar2, new g(w.a(w.this, tVar2, bxVar, z), w.a(w.this, tVar, z, d2)));
                w.this.a(tVar, tVar2, bxVar);
                AppMethodBeat.o(135030);
            }

            @Override // com.tencent.mm.plugin.appbrand.page.w.c
            public final void ig(boolean z) {
                this.npx = z;
            }
        };
        r11.ig(z2);
        synchronized (wVar.npd) {
            try {
                wVar.npf.push(tVar2);
                wVar.npg.push(r11);
                if (wVar.npe.size() == 0) {
                    wVar.postDelayed(r11, 5000);
                } else {
                    wVar.postDelayed(r11, bxVar == bx.AUTO_RE_LAUNCH ? 0 : 500);
                }
                if ((!by.d(bxVar) && !by.e(bxVar)) || (tVar = wVar.npe.peekFirst()) == null || tVar == tVar2) {
                    tVar = null;
                }
                Log.i("MicroMsg.AppBrandPageContainer", "navigateToNext mStagingStack push done, appId[%s] url[%s] type[%s]", wVar.getAppId(), str, bxVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (tVar != null) {
            tVar.bQM();
        }
        final long currentTicks = Util.currentTicks();
        tVar2.getCurrentPageView().a(new i.f() {
            /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.i.f
            public final void onReady() {
                AppMethodBeat.i(219377);
                Log.i("MicroMsg.AppBrandPageContainer", "navigateToNext, onReady cost[%dms], appId[%s] type[%s], url[%s]", Long.valueOf(Util.currentTicks() - currentTicks), w.this.getAppId(), bxVar, str);
                tVar2.getCurrentPageView().b(this);
                w.this.removeCallbacks(r11);
                w.this.post(r11);
                w.this.bQV();
                AppMethodBeat.o(219377);
            }
        });
        if (bx.APP_LAUNCH == bxVar) {
            tVar2.getCurrentPageView().nqW = true;
        }
        tVar2.loadUrl(str);
        tVar2.a(bxVar, a2);
        AppMethodBeat.o(135098);
    }

    static /* synthetic */ void a(w wVar, final int i2, String str, com.tencent.mm.plugin.appbrand.page.b.f fVar) {
        AppMethodBeat.i(219422);
        wVar.bQS();
        Log.i("MicroMsg.AppBrandPageContainer", "navigateBackImpl");
        AnonymousClass5 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass5 */

            public final void run() {
                int i2;
                t tVar;
                t tVar2;
                int i3 = 1;
                AppMethodBeat.i(135027);
                if (w.d(w.this) <= 1) {
                    com.tencent.mm.plugin.appbrand.h.a(w.this.mAppId, h.d.BACK);
                    w.this.kEc.close();
                    AppMethodBeat.o(135027);
                    return;
                }
                synchronized (w.this.npd) {
                    try {
                        int i4 = i2;
                        if (i4 > 0) {
                            i3 = i4;
                        }
                        if (i3 >= w.this.npe.size()) {
                            i2 = w.this.npe.size() - 1;
                        } else {
                            i2 = i3;
                        }
                        tVar = (t) w.this.npe.getFirst();
                        tVar2 = (t) w.this.npe.get(i2);
                    } catch (Throwable th) {
                        AppMethodBeat.o(135027);
                        throw th;
                    }
                }
                h a2 = w.this.a(tVar, tVar2);
                w.a(w.this, tVar, tVar2);
                w.a(w.this, tVar2, tVar, bx.NAVIGATE_BACK, a2);
                AppMethodBeat.o(135027);
            }
        };
        boolean d2 = wVar.d(str, r0);
        if (fVar != null) {
            fVar.hL(d2);
        }
        if (!d2) {
            r0.run();
        }
        AppMethodBeat.o(219422);
    }

    static /* synthetic */ t c(w wVar, final String str, final bx bxVar) {
        t a2;
        AppMethodBeat.i(176607);
        if (wVar.npa == null || (a2 = wVar.npa.a(str, bxVar, wVar, new Callable<t>() {
            /* class com.tencent.mm.plugin.appbrand.page.w.AnonymousClass6 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ t call() {
                AppMethodBeat.i(219375);
                t b2 = w.b(w.this, str, bxVar);
                AppMethodBeat.o(219375);
                return b2;
            }
        })) == null) {
            t a3 = wVar.a(str, bxVar);
            AppMethodBeat.o(176607);
            return a3;
        }
        AppMethodBeat.o(176607);
        return a2;
    }

    static /* synthetic */ void a(w wVar, String str, String str2, int[] iArr) {
        AppMethodBeat.i(219428);
        synchronized (wVar.npd) {
            try {
                Iterator<t> it = wVar.npe.iterator();
                while (it.hasNext()) {
                    it.next().a(str, str2, iArr);
                }
                Iterator<t> it2 = wVar.npf.iterator();
                while (it2.hasNext()) {
                    it2.next().a(str, str2, iArr);
                }
            } finally {
                AppMethodBeat.o(219428);
            }
        }
        if (!(wVar.nph == null || iArr == null || !com.tencent.mm.compatible.loader.a.contains(iArr, wVar.nph.getComponentId()))) {
            wVar.nph.c(str, str2, 0);
        }
        if (wVar.npj != null) {
            wVar.npj.a(str, str2, iArr);
        }
    }
}
