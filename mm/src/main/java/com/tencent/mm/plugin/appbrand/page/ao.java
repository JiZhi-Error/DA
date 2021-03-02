package com.tencent.mm.plugin.appbrand.page;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.jsapi.container.AppBrandNativeContainerView;
import com.tencent.mm.plugin.appbrand.jsapi.container.WrapperNativeContainerView;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.u;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.v;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.bv;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import java.lang.ref.WeakReference;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ao implements h.a {
    public static final /* synthetic */ boolean $assertionsDisabled = (!ao.class.desiredAssertionStatus());
    private MMHandler mHandler;
    private ViewGroup nmW;
    private d nqS;
    private int nsA = -1;
    private bd nsB;
    private AppBrandPageFullScreenView nsC;
    public FrameLayout nsD;
    public bg nsE;
    final Deque<b> nsv;
    private int nsw = -1;
    private float[] nsx;
    private View nsy;
    private bu nsz;

    static {
        AppMethodBeat.i(178631);
        AppMethodBeat.o(178631);
    }

    static /* synthetic */ boolean a(ao aoVar, int i2) {
        AppMethodBeat.i(178626);
        boolean yO = aoVar.yO(i2);
        AppMethodBeat.o(178626);
        return yO;
    }

    static /* synthetic */ boolean a(ao aoVar, int i2, float[] fArr, int i3, Boolean bool, Boolean bool2) {
        AppMethodBeat.i(178628);
        boolean b2 = aoVar.b(i2, fArr, i3, bool, bool2);
        AppMethodBeat.o(178628);
        return b2;
    }

    static /* synthetic */ boolean a(ao aoVar, View view, int i2, int i3, float[] fArr, int i4, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(178625);
        boolean b2 = aoVar.b(view, i2, i3, fArr, i4, z, z2, z3);
        AppMethodBeat.o(178625);
        return b2;
    }

    static /* synthetic */ boolean b(ao aoVar, int i2) {
        AppMethodBeat.i(178630);
        boolean yQ = aoVar.yQ(i2);
        AppMethodBeat.o(178630);
        return yQ;
    }

    public ao(ViewGroup viewGroup) {
        AppMethodBeat.i(140711);
        this.nmW = viewGroup;
        this.mHandler = new MMHandler(Looper.getMainLooper());
        this.nsv = new ConcurrentLinkedDeque();
        this.nsy = new View(viewGroup.getContext());
        AppMethodBeat.o(140711);
    }

    public final void setFullscreenImpl(d dVar) {
        AppMethodBeat.i(176692);
        this.nqS = dVar;
        this.nqS.a(new com.tencent.mm.plugin.appbrand.platform.window.b() {
            /* class com.tencent.mm.plugin.appbrand.page.ao.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.platform.window.b
            public final void Na() {
                AppMethodBeat.i(140701);
                ao.a(ao.this);
                if (ao.this.nsz != null) {
                    ao.this.nsz.Na();
                    ao.this.nsz = null;
                }
                AppMethodBeat.o(140701);
            }
        });
        AppMethodBeat.o(176692);
    }

    public final void a(bd bdVar) {
        AppMethodBeat.i(140713);
        Log.i("MicroMsg.AppBrandWebViewCustomViewContainer", "setFullScreenViewObtainer fullScreenViewAttacher:%b", Boolean.TRUE);
        this.nsB = bdVar;
        if (this.nsC != null) {
            this.nsB.a(this.nsC);
        }
        AppMethodBeat.o(140713);
    }

    private void bRW() {
        AppMethodBeat.i(140714);
        if (this.nsC == null) {
            this.nsC = new AppBrandPageFullScreenView(this.nmW.getContext());
            if (this.nsB != null) {
                this.nsB.a(this.nsC);
            }
        }
        AppMethodBeat.o(140714);
    }

    public final ViewGroup bRX() {
        AppMethodBeat.i(140715);
        bRW();
        AppBrandPageFullScreenView appBrandPageFullScreenView = this.nsC;
        AppMethodBeat.o(140715);
        return appBrandPageFullScreenView;
    }

    public boolean a(View view, int i2, int i3, float[] fArr, int i4, boolean z) {
        AppMethodBeat.i(219452);
        boolean a2 = a(view, i2, i3, fArr, i4, z, false);
        AppMethodBeat.o(219452);
        return a2;
    }

    public boolean a(View view, int i2, int i3, float[] fArr, int i4, boolean z, boolean z2) {
        AppMethodBeat.i(140716);
        boolean a2 = a(view, i2, i3, fArr, i4, z, z2, false);
        AppMethodBeat.o(140716);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.a
    public boolean a(final View view, final int i2, final int i3, final float[] fArr, final int i4, final boolean z, final boolean z2, final boolean z3) {
        AppMethodBeat.i(178621);
        AnonymousClass2 r0 = new SyncTask<Boolean>(Boolean.FALSE) {
            /* class com.tencent.mm.plugin.appbrand.page.ao.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ Boolean run() {
                AppMethodBeat.i(140702);
                Boolean valueOf = Boolean.valueOf(ao.a(ao.this, view, i2, i3, fArr, i4, z, z2, z3));
                AppMethodBeat.o(140702);
                return valueOf;
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            boolean booleanValue = ((Boolean) r0.exec(null)).booleanValue();
            AppMethodBeat.o(178621);
            return booleanValue;
        }
        boolean booleanValue2 = ((Boolean) r0.exec(this.mHandler)).booleanValue();
        AppMethodBeat.o(178621);
        return booleanValue2;
    }

    private boolean b(View view, int i2, int i3, float[] fArr, int i4, boolean z, boolean z2, boolean z3) {
        int i5;
        int childCount;
        float f2;
        float f3;
        AppMethodBeat.i(178622);
        if (view == null || fArr == null || fArr.length < 5) {
            AppMethodBeat.o(178622);
            return false;
        }
        ViewGroup b2 = b(i3, z2, z3);
        if (b2 == null) {
            AppMethodBeat.o(178622);
            return false;
        } else if (getViewById(i2) != null) {
            AppMethodBeat.o(178622);
            return false;
        } else {
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[2];
            float f7 = fArr[3];
            int i6 = (int) fArr[4];
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams((int) f6, (int) f7);
            int et = et(i3, i6);
            if (et < 0) {
                i5 = 0;
            } else {
                i5 = et;
            }
            if (b2 instanceof u) {
                childCount = ((u) b2).getTargetViewChildCount();
            } else {
                childCount = b2.getChildCount();
            }
            if (i5 > childCount) {
                i5 = childCount;
            }
            if (i4 >= 0) {
                view.setVisibility(i4 == 0 ? 0 : 4);
            }
            b2.addView(view, i5, layoutParams);
            b bVar = new b(view, i2, i3, i6, z, z2, z3);
            d(bVar);
            if (i3 != 0 || !(b2 instanceof bv) || !z) {
                f2 = f5;
                f3 = f4;
            } else {
                a aVar = new a((byte) 0);
                aVar.view = view;
                aVar.x = f4;
                aVar.y = f5;
                aVar.nsP = (float) this.nmW.getScrollX();
                aVar.nsQ = (float) this.nmW.getScrollY();
                f3 = f4 + aVar.nsP;
                ((bv) b2).a(aVar);
                bVar.nsU = aVar;
                f2 = aVar.nsQ + f5;
            }
            view.setX(f3);
            view.setY(f2);
            AppMethodBeat.o(178622);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.a
    public final ViewGroup bEh() {
        AppMethodBeat.i(176693);
        ViewGroup b2 = b(0, false, false);
        AppMethodBeat.o(176693);
        return b2;
    }

    /* access modifiers changed from: protected */
    public final ViewGroup b(int i2, boolean z, boolean z2) {
        AppMethodBeat.i(178623);
        if (z2) {
            ViewGroup bRY = bRY();
            AppMethodBeat.o(178623);
            return bRY;
        } else if (z) {
            ViewGroup bRX = bRX();
            AppMethodBeat.o(178623);
            return bRX;
        } else if (i2 == 0) {
            ViewGroup viewGroup = this.nmW;
            AppMethodBeat.o(178623);
            return viewGroup;
        } else {
            b yP = yP(i2);
            if (yP == null) {
                AppMethodBeat.o(178623);
                return null;
            }
            View view = yP.nsR.get();
            if ((view instanceof WrapperNativeContainerView) && (view instanceof v) && (view instanceof ViewGroup)) {
                ViewGroup viewGroup2 = (ViewGroup) ((WrapperNativeContainerView) view).aB(AppBrandNativeContainerView.class);
                AppMethodBeat.o(178623);
                return viewGroup2;
            } else if (!(view instanceof v) || !(view instanceof ViewGroup)) {
                AppMethodBeat.o(178623);
                return null;
            } else {
                ViewGroup viewGroup3 = (ViewGroup) view;
                AppMethodBeat.o(178623);
                return viewGroup3;
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.a
    public final boolean wF(final int i2) {
        AppMethodBeat.i(140719);
        AnonymousClass3 r0 = new SyncTask<Boolean>(Boolean.FALSE) {
            /* class com.tencent.mm.plugin.appbrand.page.ao.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ Boolean run() {
                AppMethodBeat.i(140703);
                Boolean valueOf = Boolean.valueOf(ao.a(ao.this, i2));
                AppMethodBeat.o(140703);
                return valueOf;
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            boolean booleanValue = ((Boolean) r0.exec(null)).booleanValue();
            AppMethodBeat.o(140719);
            return booleanValue;
        }
        boolean booleanValue2 = ((Boolean) r0.exec(this.mHandler)).booleanValue();
        AppMethodBeat.o(140719);
        return booleanValue2;
    }

    private boolean yO(int i2) {
        AppMethodBeat.i(140720);
        b yP = yP(i2);
        if (yP == null) {
            AppMethodBeat.o(140720);
            return false;
        }
        yQ(i2);
        a(yP);
        ViewGroup b2 = b(yP.parent, yP.lcx, yP.nsT);
        if (b2 != null) {
            e(yP);
            b2.removeView(yP.nsR.get());
            if (yP.parent == 0 && (b2 instanceof bv) && yP.nsS) {
                ((bv) b2).b(yP.nsU);
            }
            AppMethodBeat.o(140720);
            return true;
        }
        AppMethodBeat.o(140720);
        return false;
    }

    public final void removeAll() {
        AppMethodBeat.i(140721);
        AnonymousClass4 r0 = new SyncTask<Boolean>(Boolean.FALSE) {
            /* class com.tencent.mm.plugin.appbrand.page.ao.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ Boolean run() {
                AppMethodBeat.i(140705);
                Boolean bRZ = bRZ();
                AppMethodBeat.o(140705);
                return bRZ;
            }

            private Boolean bRZ() {
                AppMethodBeat.i(140704);
                try {
                    ao.d(ao.this);
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandWebViewCustomViewContainer", "removeAll error ".concat(String.valueOf(e2)));
                }
                Boolean bool = Boolean.FALSE;
                AppMethodBeat.o(140704);
                return bool;
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            r0.exec(null);
        }
        r0.exec(this.mHandler);
        AppMethodBeat.o(140721);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.a
    public final boolean a(final int i2, final float[] fArr, final int i3, final Boolean bool, final Boolean bool2) {
        AppMethodBeat.i(140722);
        AnonymousClass5 r0 = new SyncTask<Boolean>(Boolean.FALSE) {
            /* class com.tencent.mm.plugin.appbrand.page.ao.AnonymousClass5 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ Boolean run() {
                AppMethodBeat.i(140706);
                Boolean valueOf = Boolean.valueOf(ao.a(ao.this, i2, fArr, i3, bool, bool2));
                AppMethodBeat.o(140706);
                return valueOf;
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            boolean booleanValue = ((Boolean) r0.exec(null)).booleanValue();
            AppMethodBeat.o(140722);
            return booleanValue;
        }
        boolean booleanValue2 = ((Boolean) r0.exec(this.mHandler)).booleanValue();
        AppMethodBeat.o(140722);
        return booleanValue2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x014c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(int r12, float[] r13, int r14, java.lang.Boolean r15, java.lang.Boolean r16) {
        /*
        // Method dump skipped, instructions count: 335
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.page.ao.b(int, float[], int, java.lang.Boolean, java.lang.Boolean):boolean");
    }

    private void a(b bVar) {
        AppMethodBeat.i(140724);
        try {
            for (b bVar2 : b(bVar)) {
                e(bVar2);
            }
            AppMethodBeat.o(140724);
        } catch (StackOverflowError e2) {
            c(bVar);
            AppMethodBeat.o(140724);
        }
    }

    private List<b> b(b bVar) {
        AppMethodBeat.i(140725);
        if (bVar.parent == bVar.id) {
            LinkedList linkedList = new LinkedList();
            AppMethodBeat.o(140725);
            return linkedList;
        }
        LinkedList linkedList2 = new LinkedList();
        for (b bVar2 : this.nsv) {
            if (bVar.id == bVar2.parent && bVar.parent != bVar2.id) {
                linkedList2.addAll(b(bVar2));
            }
        }
        linkedList2.add(bVar);
        AppMethodBeat.o(140725);
        return linkedList2;
    }

    private void c(b bVar) {
        AppMethodBeat.i(140726);
        LinkedList linkedList = new LinkedList(this.nsv);
        Log.i("MicroMsg.AppBrandWebViewCustomViewContainer", "dumpViewInfoBeforeCrash: oops");
        Log.i("MicroMsg.AppBrandWebViewCustomViewContainer", "dumpViewInfoBeforeCrash: root: [id] = %d [parent] = %d", Integer.valueOf(bVar.id), Integer.valueOf(bVar.parent));
        Log.i("MicroMsg.AppBrandWebViewCustomViewContainer", "==================ViewInfoListBegin==================");
        Iterator it = linkedList.iterator();
        int i2 = -1;
        while (it.hasNext()) {
            b bVar2 = (b) it.next();
            i2++;
            Log.i("MicroMsg.AppBrandWebViewCustomViewContainer", "dumpViewInfoBeforeCrash: vi#%d [id] = %d [parent] = %d", Integer.valueOf(i2), Integer.valueOf(bVar2.id), Integer.valueOf(bVar2.parent));
        }
        Log.i("MicroMsg.AppBrandWebViewCustomViewContainer", "==================ViewInfoListEnd==================");
        Log.appenderFlushSync();
        StackOverflowError stackOverflowError = new StackOverflowError();
        AppMethodBeat.o(140726);
        throw stackOverflowError;
    }

    public final void clear() {
        AppMethodBeat.i(219453);
        Log.i("MicroMsg.AppBrandWebViewCustomViewContainer", "clear: ");
        this.nsv.clear();
        AppMethodBeat.o(219453);
    }

    private int et(int i2, int i3) {
        AppMethodBeat.i(140727);
        int i4 = 0;
        Iterator<b> it = this.nsv.iterator();
        while (true) {
            int i5 = i4;
            if (it.hasNext()) {
                b next = it.next();
                if (i2 == next.parent && i3 >= next.z) {
                    i5++;
                }
                i4 = i5;
            } else {
                AppMethodBeat.o(140727);
                return i5;
            }
        }
    }

    private b yP(int i2) {
        AppMethodBeat.i(140728);
        for (b bVar : this.nsv) {
            if (bVar.id == i2) {
                AppMethodBeat.o(140728);
                return bVar;
            }
        }
        AppMethodBeat.o(140728);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.a
    public final boolean wD(int i2) {
        AppMethodBeat.i(140729);
        if (yP(i2) != null) {
            AppMethodBeat.o(140729);
            return true;
        }
        AppMethodBeat.o(140729);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.a
    public final View getViewById(int i2) {
        AppMethodBeat.i(140730);
        b yP = yP(i2);
        if (yP == null) {
            AppMethodBeat.o(140730);
            return null;
        }
        View view = yP.nsR.get();
        AppMethodBeat.o(140730);
        return view;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.a
    public final int wE(int i2) {
        AppMethodBeat.i(176694);
        b yP = yP(i2);
        if (yP == null) {
            AppMethodBeat.o(176694);
            return 0;
        }
        int i3 = yP.parent;
        AppMethodBeat.o(176694);
        return i3;
    }

    /* access modifiers changed from: protected */
    public static final class b {
        int id;
        boolean lcx;
        WeakReference<View> nsR;
        boolean nsS;
        boolean nsT;
        a nsU;
        int parent;
        int z;

        public b(View view, int i2, int i3, int i4, boolean z2, boolean z3, boolean z4) {
            AppMethodBeat.i(178619);
            this.nsR = new WeakReference<>(view);
            this.id = i2;
            this.parent = i3;
            this.z = i4;
            this.nsS = z2;
            this.lcx = z3;
            this.nsT = z4;
            AppMethodBeat.o(178619);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.a
    public final ad.b wC(int i2) {
        AppMethodBeat.i(140731);
        ad.b JW = ad.aVe().JW(hashCode() + "#" + i2);
        AppMethodBeat.o(140731);
        return JW;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.a
    public final ad.b L(int i2, boolean z) {
        AppMethodBeat.i(140732);
        ad.b G = ad.aVe().G(hashCode() + "#" + i2, z);
        AppMethodBeat.o(140732);
        return G;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.a
    public final boolean wH(int i2) {
        return this.nsA == i2 || this.nsw == i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.a
    public final boolean a(final int i2, final bu buVar, final int i3) {
        AppMethodBeat.i(140733);
        AnonymousClass6 r0 = new SyncTask<Boolean>(Boolean.FALSE) {
            /* class com.tencent.mm.plugin.appbrand.page.ao.AnonymousClass6 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ Boolean run() {
                AppMethodBeat.i(140707);
                Boolean valueOf = Boolean.valueOf(ao.a(ao.this, i2, buVar, i3));
                AppMethodBeat.o(140707);
                return valueOf;
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            boolean booleanValue = ((Boolean) r0.exec(null)).booleanValue();
            AppMethodBeat.o(140733);
            return booleanValue;
        }
        boolean booleanValue2 = ((Boolean) r0.exec(this.mHandler)).booleanValue();
        AppMethodBeat.o(140733);
        return booleanValue2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.a
    public final boolean wG(final int i2) {
        AppMethodBeat.i(140734);
        AnonymousClass7 r0 = new SyncTask<Boolean>(Boolean.FALSE) {
            /* class com.tencent.mm.plugin.appbrand.page.ao.AnonymousClass7 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ Boolean run() {
                AppMethodBeat.i(140708);
                Boolean valueOf = Boolean.valueOf(ao.b(ao.this, i2));
                AppMethodBeat.o(140708);
                return valueOf;
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            boolean booleanValue = ((Boolean) r0.exec(null)).booleanValue();
            AppMethodBeat.o(140734);
            return booleanValue;
        }
        boolean booleanValue2 = ((Boolean) r0.exec(this.mHandler)).booleanValue();
        AppMethodBeat.o(140734);
        return booleanValue2;
    }

    private boolean yQ(int i2) {
        AppMethodBeat.i(140735);
        if (i2 != this.nsw) {
            AppMethodBeat.o(140735);
            return false;
        } else if (yP(i2) == null) {
            AppMethodBeat.o(140735);
            return false;
        } else {
            this.nqS.btC();
            AppMethodBeat.o(140735);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.a
    public final View getRootView() {
        return this.nmW;
    }

    /* access modifiers changed from: package-private */
    public static final class a implements bv.a {
        float nsP;
        float nsQ;
        View view;
        float x;
        float y;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.page.bv.a
        public final void eu(int i2, int i3) {
            AppMethodBeat.i(140709);
            this.nsP = (float) i2;
            this.nsQ = (float) i3;
            this.view.setX(this.x + ((float) i2));
            this.view.setY(this.y + ((float) i3));
            AppMethodBeat.o(140709);
        }
    }

    /* access modifiers changed from: protected */
    public final void d(b bVar) {
        AppMethodBeat.i(219454);
        Log.i("MicroMsg.AppBrandWebViewCustomViewContainer", "addViewInfo: [%d, %d]", Integer.valueOf(bVar.id), Integer.valueOf(bVar.parent));
        this.nsv.add(bVar);
        AppMethodBeat.o(219454);
    }

    private void e(b bVar) {
        AppMethodBeat.i(140736);
        Log.i("MicroMsg.AppBrandWebViewCustomViewContainer", "removeViewInfo: [%d, %d]", Integer.valueOf(bVar.id), Integer.valueOf(bVar.parent));
        this.nsv.remove(bVar);
        AppMethodBeat.o(140736);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.a
    public final boolean wI(int i2) {
        AppMethodBeat.i(219455);
        while (i2 != 0) {
            b yP = yP(i2);
            if (yP == null) {
                AppMethodBeat.o(219455);
                return false;
            }
            View view = yP.nsR.get();
            if (view instanceof CoverViewContainer) {
                boolean z = ((CoverViewContainer) view).lSW;
                if (z) {
                    AppMethodBeat.o(219455);
                    return true;
                } else if (z || yP.parent <= 0) {
                    AppMethodBeat.o(219455);
                    return false;
                } else {
                    i2 = yP.parent;
                }
            } else {
                AppMethodBeat.o(219455);
                return false;
            }
        }
        AppMethodBeat.o(219455);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.a
    public final int wJ(int i2) {
        AppMethodBeat.i(219456);
        while (i2 != 0) {
            b yP = yP(i2);
            if (yP == null) {
                AppMethodBeat.o(219456);
                return -1;
            }
            View view = yP.nsR.get();
            if (view instanceof CoverViewContainer) {
                boolean z = ((CoverViewContainer) view).lSW;
                if (z) {
                    int i3 = yP.id;
                    AppMethodBeat.o(219456);
                    return i3;
                } else if (z || yP.parent <= 0) {
                    AppMethodBeat.o(219456);
                    return -1;
                } else {
                    i2 = yP.parent;
                }
            } else {
                AppMethodBeat.o(219456);
                return -1;
            }
        }
        AppMethodBeat.o(219456);
        return -1;
    }

    private ViewGroup bRY() {
        AppMethodBeat.i(178620);
        if (this.nsD == null) {
            this.nsD = new FrameLayout(this.nmW.getContext());
            if (this.nsE != null) {
                this.nsE.a(this.nsD);
            }
        }
        FrameLayout frameLayout = this.nsD;
        AppMethodBeat.o(178620);
        return frameLayout;
    }

    static /* synthetic */ void a(ao aoVar) {
        b yP;
        View view;
        AppMethodBeat.i(178624);
        b yP2 = aoVar.yP(aoVar.nsA);
        float[] fArr = aoVar.nsx;
        if (yP2 == null || yP2.nsR == null || fArr == null) {
            AppMethodBeat.o(178624);
            return;
        }
        View view2 = yP2.nsR.get();
        if (view2 != null) {
            if (!(aoVar.nsA == aoVar.nsw || (yP = aoVar.yP(aoVar.nsw)) == null || yP.nsR == null || (view = yP.nsR.get()) == null)) {
                aoVar.b(aoVar.nsw, fArr, view.getVisibility(), Boolean.valueOf(yP2.nsS), Boolean.FALSE);
            }
            int i2 = aoVar.nsA;
            aoVar.nsw = -1;
            aoVar.nsA = -1;
            aoVar.b(i2, fArr, view2.getVisibility(), Boolean.valueOf(yP2.nsS), Boolean.FALSE);
        }
        AppMethodBeat.o(178624);
    }

    static /* synthetic */ void d(ao aoVar) {
        AppMethodBeat.i(178627);
        LinkedList linkedList = new LinkedList();
        for (b bVar : aoVar.nsv) {
            linkedList.add(bVar);
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            aoVar.yO(((b) it.next()).id);
        }
        linkedList.clear();
        AppMethodBeat.o(178627);
    }

    static /* synthetic */ boolean a(ao aoVar, int i2, bu buVar, int i3) {
        b bVar;
        ViewGroup viewGroup;
        ViewGroup b2;
        AppMethodBeat.i(178629);
        if (i2 == aoVar.nsw) {
            AppMethodBeat.o(178629);
            return false;
        }
        b yP = aoVar.yP(i2);
        if (yP == null || yP.nsR == null) {
            AppMethodBeat.o(178629);
            return false;
        }
        View view = yP.nsR.get();
        if (view == null) {
            AppMethodBeat.o(178629);
            return false;
        }
        aoVar.nsA = i2;
        ViewGroup b3 = aoVar.b(yP.parent, false, false);
        if (!(b3 instanceof AppBrandNativeContainerView) || !((AppBrandNativeContainerView) b3).lSD || (bVar = aoVar.yP(yP.parent)) == null || (b2 = aoVar.b(bVar.parent, false, false)) == null) {
            bVar = yP;
        } else {
            View view2 = yP.nsR.get();
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                view2.setLayoutParams(layoutParams);
            }
            aoVar.nsA = bVar.id;
            b3 = b2;
        }
        if (b3 != null) {
            view = bVar.nsR.get();
            int indexOfChild = b3.indexOfChild(view);
            if (!(aoVar.nsy == null || (viewGroup = (ViewGroup) aoVar.nsy.getParent()) == null)) {
                viewGroup.removeView(aoVar.nsy);
            }
            b3.addView(aoVar.nsy, indexOfChild);
            b3.removeView(view);
        }
        aoVar.nsx = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) bVar.z};
        aoVar.nqS.N(view, i3);
        aoVar.nsw = i2;
        aoVar.nsz = buVar;
        AppMethodBeat.o(178629);
        return true;
    }
}
