package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ae;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView;
import com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.taskbar.api.HeaderContainer;
import com.tencent.mm.plugin.taskbar.api.b;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppBrandDesktopView extends DragRecyclerView implements b.a {
    private int aYN = 0;
    private int aYO = 0;
    private RecyclerView.a adj;
    public int apM = 4;
    private int atO = 0;
    private boolean dSv = false;
    private boolean dXX = false;
    private RecyclerView.l guX = new RecyclerView.l() {
        /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.AnonymousClass4 */

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(227756);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$12", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onScrollStateChanged %d, needScroll: %b", Integer.valueOf(i2), Boolean.valueOf(AppBrandDesktopView.this.ons));
            if (!AppBrandDesktopView.K(AppBrandDesktopView.this) && AppBrandDesktopView.this.ons && i2 == 0) {
                AppBrandDesktopView.this.ons = false;
                AppBrandDesktopView.M(AppBrandDesktopView.this);
            }
            if (i2 == 0) {
                if (AppBrandDesktopView.this.ooc) {
                    AppBrandDesktopView.this.ooc = false;
                } else if (AppBrandDesktopView.this.mLastState == 1 || AppBrandDesktopView.this.mLastState == 2) {
                    AppBrandDesktopView.Q(AppBrandDesktopView.this);
                }
                if (!AppBrandDesktopView.R(AppBrandDesktopView.this)) {
                    AppBrandDesktopView.this.ood = false;
                } else if (AppBrandDesktopView.this.onK && !AppBrandDesktopView.this.ood && AppBrandDesktopView.this.onJ != null) {
                    AppBrandDesktopView.this.onJ.ccU();
                }
            }
            AppBrandDesktopView.this.mLastState = i2;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$12", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(227756);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            int ks;
            AppMethodBeat.i(227757);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$12", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            if (AppBrandDesktopView.this.onj) {
                AppBrandDesktopView.this.onj = false;
                if (AppBrandDesktopView.this.oni != null && (ks = AppBrandDesktopView.this.atO - AppBrandDesktopView.this.oni.ks()) >= 0 && ks < AppBrandDesktopView.this.getChildCount()) {
                    AppBrandDesktopView.this.scrollBy(0, AppBrandDesktopView.this.getChildAt(ks).getTop());
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$12", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(227757);
        }
    };
    private int hIX = 0;
    private boolean iCn;
    private boolean isPaused = false;
    private Context mContext;
    private ArrayList<c> mDataList = new ArrayList<>();
    private Interpolator mInterpolator = new DecelerateInterpolator();
    private int mLastState = -1;
    private RecyclerView.r mSmoothScroller;
    private int mTouchSlop = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    private int ocu;
    private AppBrandDesktopDragView.b omR = new AppBrandDesktopDragView.b() {
        /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.b
        public final void cU(Object obj) {
            AppMethodBeat.i(49564);
            if (obj == null) {
                AppMethodBeat.o(49564);
                return;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.ooj != null) {
                    AppBrandDesktopView.a(AppBrandDesktopView.this, true);
                    Log.i("MicroMsg.AppBrandDesktopView", "alvinluo usage to collection reorderCollection result: %b", Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)));
                    if (AppBrandDesktopView.this.onJ != null && !Util.isNullOrNil(cVar.ooj.appId)) {
                        com.tencent.mm.plugin.appbrand.widget.recent.g gVar = AppBrandDesktopView.this.onJ;
                        String str = cVar.ooj.appId;
                        Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo addRecentAppBrandToCollection id: %s", str);
                        gVar.oCj++;
                        gVar.oCq.append(str + ":");
                    }
                    AppBrandDesktopView.a(AppBrandDesktopView.this, ((c) obj).position);
                }
            }
            AppMethodBeat.o(49564);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.b
        public final void cV(Object obj) {
            AppMethodBeat.i(49565);
            if (obj == null) {
                AppMethodBeat.o(49565);
                return;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.type == 1 && cVar.ooj != null) {
                    AppBrandDesktopView.a(AppBrandDesktopView.this, true);
                    com.tencent.mm.plugin.appbrand.widget.recent.b ccQ = com.tencent.mm.plugin.appbrand.widget.recent.c.oBT.ccQ();
                    if (ccQ == null) {
                        AppMethodBeat.o(49565);
                        return;
                    }
                    if (ccQ.bh(cVar.ooj.username, cVar.ooj.iOo)) {
                        AppBrandDesktopView.a(AppBrandDesktopView.this, ((c) obj).position);
                    }
                    if (AppBrandDesktopView.this.onJ != null && !Util.isNullOrNil(cVar.ooj.appId)) {
                        com.tencent.mm.plugin.appbrand.widget.recent.g gVar = AppBrandDesktopView.this.onJ;
                        String str = cVar.ooj.appId;
                        Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo deleteStarAppBrand id: %s", str);
                        gVar.oCu++;
                        gVar.oCz.append(str + ":");
                    }
                }
            }
            AppMethodBeat.o(49565);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.b
        public final void cW(Object obj) {
            boolean z;
            AppMethodBeat.i(49566);
            if (obj == null) {
                AppMethodBeat.o(49566);
                return;
            }
            c cVar = (c) obj;
            if (cVar.ooj != null) {
                Log.d("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView removeUsage username: %s, versionType: %d", cVar.ooj.username, Integer.valueOf(cVar.ooj.iOo));
                AppBrandDesktopView.a(AppBrandDesktopView.this, true);
                com.tencent.mm.plugin.appbrand.widget.recent.j ccP = com.tencent.mm.plugin.appbrand.widget.recent.c.oBT.ccP();
                if (ccP != null) {
                    z = ccP.bi(cVar.ooj.username, cVar.ooj.iOo);
                } else {
                    z = false;
                }
                if (!(AppBrandDesktopView.this.onJ == null || cVar.ooj == null || Util.isNullOrNil(cVar.ooj.appId))) {
                    com.tencent.mm.plugin.appbrand.widget.recent.g gVar = AppBrandDesktopView.this.onJ;
                    String str = cVar.ooj.appId;
                    Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo deleteRecentAppBrand id: %s", str);
                    gVar.oCi++;
                    gVar.oCo.append(str + ":");
                }
                if (AppBrandDesktopView.this.onm != null) {
                    if (z) {
                        AppBrandDesktopView.b(AppBrandDesktopView.this, cVar.position);
                        AppMethodBeat.o(49566);
                        return;
                    }
                    Log.e("MicroMsg.AppBrandDesktopView", "alvinluo removeUsage failed");
                    cVar.type = 2;
                    AppBrandDesktopView.this.ond.add(cVar.position, cVar);
                    AppBrandDesktopView.this.onm.setDataList(AppBrandDesktopView.this.ond);
                    if (AppBrandDesktopView.this.onn != null) {
                        AppBrandDesktopView.this.onn.getAdapter().ci(cVar.position);
                    }
                }
            }
            AppMethodBeat.o(49566);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.b
        public final void f(int i2, int i3, Object obj) {
            AppMethodBeat.i(49567);
            AppBrandDesktopView.a(AppBrandDesktopView.this, true);
            Log.i("MicroMsg.AppBrandDesktopView", "alvinluo collection reorderCollection result: %b, startPos: %d, endPos: %d", Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)), Integer.valueOf(i2), Integer.valueOf(i3));
            if ((obj instanceof c) && AppBrandDesktopView.this.onJ != null && ((c) obj).ooj != null && !Util.isNullOrNil(((c) obj).ooj.appId)) {
                if (i2 < i3) {
                    com.tencent.mm.plugin.appbrand.widget.recent.g gVar = AppBrandDesktopView.this.onJ;
                    String str = ((c) obj).ooj.appId;
                    Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionBackward id: %s", str);
                    gVar.oCx++;
                    gVar.oCD.append(str + ":");
                } else if (i2 > i3) {
                    com.tencent.mm.plugin.appbrand.widget.recent.g gVar2 = AppBrandDesktopView.this.onJ;
                    String str2 = ((c) obj).ooj.appId;
                    Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionForward id: %s", str2);
                    gVar2.oCw++;
                    gVar2.oCC.append(str2 + ":");
                }
            }
            AppBrandDesktopView.a(AppBrandDesktopView.this, AppBrandDesktopView.this.one);
            AppMethodBeat.o(49567);
        }
    };
    private int onA = 0;
    private int onB = 0;
    private boolean onC = false;
    private View onD;
    private int onE = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 80);
    private boolean onF = true;
    private String onG = "";
    private View onH;
    private int onI = 0;
    private com.tencent.mm.plugin.appbrand.widget.recent.g onJ = new com.tencent.mm.plugin.appbrand.widget.recent.g();
    private boolean onK = false;
    private boolean onL = false;
    private boolean onM = false;
    private boolean onN = false;
    private boolean onO = false;
    private int onP = 0;
    private final b onQ = new b(this, 1);
    private final b onR = new b(this, 2);
    private boolean onS = false;
    private boolean onT = false;
    private int onU = 0;
    private int onV = 0;
    private float onW = 0.0f;
    private float onX = 0.0f;
    private boolean onY = false;
    private boolean onZ = false;
    private i onc;
    private ArrayList<c> ond = new ArrayList<>();
    private int one = 0;
    private boolean onf = false;
    private boolean ong = false;
    private HeaderContainer onh;
    private l oni = null;
    private boolean onj = false;
    private boolean onk = true;
    private RelativeLayout onl;
    private RecentAppBrandViewContainer onm;
    private RecentAppBrandView onn;
    private AppBrandDesktopDragView ono;
    private int onp = 0;
    private int onq = 0;
    private boolean onr = false;
    private boolean ons = false;
    private Runnable ont = null;
    private Runnable onu = null;
    private int onv;
    private int onw;
    private int onx;
    private int ony;
    private int onz = 0;
    private final Runnable ooa = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.AnonymousClass10 */

        public final void run() {
            AppMethodBeat.i(227761);
            AppBrandDesktopView.a(AppBrandDesktopView.this, false);
            com.tencent.mm.plugin.appbrand.widget.recent.c.oBT.ccQ().bxG();
            AppMethodBeat.o(227761);
        }
    };
    private int oob = 0;
    private boolean ooc = false;
    private boolean ood = true;
    private Animator.AnimatorListener wY = new Animator.AnimatorListener() {
        /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.AnonymousClass5 */

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    };

    /* access modifiers changed from: package-private */
    public interface f {
        void dQ(boolean z);
    }

    public interface i {
    }

    static /* synthetic */ void a(AppBrandDesktopView appBrandDesktopView, boolean z) {
        AppMethodBeat.i(49628);
        appBrandDesktopView.setIgnoreNotify(z);
        AppMethodBeat.o(49628);
    }

    static /* synthetic */ boolean a(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.i(49629);
        boolean zS = appBrandDesktopView.zS(0);
        AppMethodBeat.o(49629);
        return zS;
    }

    static /* synthetic */ boolean a(AppBrandDesktopView appBrandDesktopView, LocalUsageInfo localUsageInfo, WxaAttributes.a aVar) {
        AppMethodBeat.i(227769);
        boolean a2 = appBrandDesktopView.a(localUsageInfo, aVar);
        AppMethodBeat.o(227769);
        return a2;
    }

    static /* synthetic */ int g(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.i(49632);
        int collectionDataSize = appBrandDesktopView.getCollectionDataSize();
        AppMethodBeat.o(49632);
        return collectionDataSize;
    }

    static /* synthetic */ void h(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.i(49633);
        appBrandDesktopView.caA();
        AppMethodBeat.o(49633);
    }

    class a implements AppBrandDesktopDragView.a {
        private a() {
        }

        /* synthetic */ a(AppBrandDesktopView appBrandDesktopView, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.a
        public final int caq() {
            AppMethodBeat.i(49582);
            int g2 = AppBrandDesktopView.g(AppBrandDesktopView.this);
            AppMethodBeat.o(49582);
            return g2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b implements MStorage.IOnStorageChange {
        private int mType;
        boolean onL = false;
        private WeakReference<AppBrandDesktopView> ooi;

        public b(AppBrandDesktopView appBrandDesktopView, int i2) {
            AppMethodBeat.i(49583);
            this.mType = i2;
            this.ooi = new WeakReference<>(appBrandDesktopView);
            AppMethodBeat.o(49583);
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(49584);
            Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onNotifyChange type: %d, ignore: %b, eventId: %d", Integer.valueOf(this.mType), Boolean.valueOf(this.onL), Integer.valueOf(mStorageEventData.eventId));
            if (mStorageEventData.eventId == -1) {
                Log.w("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onNotifyChange pass eventId: %d", Integer.valueOf(mStorageEventData.eventId));
                AppMethodBeat.o(49584);
            } else if (this.onL) {
                Log.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onNotifyChange ignoreNotify");
                this.onL = false;
                AppMethodBeat.o(49584);
            } else {
                AppBrandDesktopView appBrandDesktopView = this.ooi.get();
                if (appBrandDesktopView != null) {
                    AppBrandDesktopView.h(appBrandDesktopView);
                }
                AppMethodBeat.o(49584);
            }
        }
    }

    public void setTaskBarCallback(i iVar) {
        this.onc = iVar;
    }

    private void setIgnoreNotify(boolean z) {
        if (this.onR != null) {
            this.onR.onL = z;
        }
        if (this.onQ != null) {
            this.onQ.onL = z;
        }
    }

    private boolean zS(int i2) {
        boolean z = false;
        AppMethodBeat.i(49601);
        Log.d("MicroMsg.AppBrandDesktopView", "alvinluo reorderCollection");
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.mDataList.size(); i3++) {
            c cVar = this.mDataList.get(i3);
            if (cVar.type == 1 && cVar.ooj != null) {
                arrayList.add(cVar.ooj);
            }
        }
        com.tencent.mm.plugin.appbrand.widget.recent.b ccQ = com.tencent.mm.plugin.appbrand.widget.recent.c.oBT.ccQ();
        if (ccQ == null) {
            AppMethodBeat.o(49601);
        } else {
            z = ccQ.g(arrayList, i2);
            if (!z) {
                Log.e("MicroMsg.AppBrandDesktopView", "alvinluo reorederCollection failed, needProcessResult: %b");
            }
            AppMethodBeat.o(49601);
        }
        return z;
    }

    private void car() {
        AppMethodBeat.i(49602);
        this.mDataList.clear();
        this.mDataList.add(new c(6));
        this.mDataList.add(new c(9));
        this.mDataList.add(new c(3));
        this.onf = false;
        this.ong = false;
        this.onC = false;
        this.adj.atj.notifyChanged();
        jc(true);
        AppMethodBeat.o(49602);
    }

    private void cas() {
        AppMethodBeat.i(49603);
        Log.d("MicroMsg.AppBrandDesktopView", "alvinluo checkEmptyNum currentEmptyNum: %d, myAppBrandNum: %d, toAddEmptyNum: %d", Integer.valueOf(this.onB), Integer.valueOf(this.mDataList.size() - 4), 1);
        for (int i2 = 0; i2 <= 0; i2++) {
            this.mDataList.add(new c(7));
        }
        this.onB = 1;
        AppMethodBeat.o(49603);
    }

    public AppBrandDesktopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(49604);
        init(context);
        AppMethodBeat.o(49604);
    }

    public AppBrandDesktopView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(49605);
        init(context);
        AppMethodBeat.o(49605);
    }

    public void setHeaderContainer(HeaderContainer headerContainer) {
        this.onh = headerContainer;
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        AppMethodBeat.i(49606);
        super.onVisibilityChanged(view, i2);
        Log.d("MicroMsg.AppBrandDesktopView", "[onVisibilityChanged] visibility:".concat(String.valueOf(i2)));
        AppMethodBeat.o(49606);
    }

    /* access modifiers changed from: package-private */
    public class l extends GridLayoutManager {
        public l(int i2) {
            super(i2, 1);
        }

        @Override // android.support.v7.widget.GridLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
        public final void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
            AppMethodBeat.i(49599);
            try {
                super.onLayoutChildren(nVar, sVar);
                AppMethodBeat.o(49599);
            } catch (IndexOutOfBoundsException e2) {
                Log.e("MicroMsg.AppBrandDesktopView", "[onLayoutChildren] IndexOutOfBoundsException!!");
                AppMethodBeat.o(49599);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
        public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
            AppMethodBeat.i(49600);
            k kVar = new k(AppBrandDesktopView.this.mContext);
            kVar.atO = i2;
            startSmoothScroll(kVar);
            AppMethodBeat.o(49600);
        }
    }

    class k extends ae {
        k(Context context) {
            super(context);
        }

        @Override // android.support.v7.widget.RecyclerView.r
        public final PointF bZ(int i2) {
            AppMethodBeat.i(49598);
            PointF bZ = AppBrandDesktopView.this.oni.bZ(i2);
            AppMethodBeat.o(49598);
            return bZ;
        }

        @Override // android.support.v7.widget.ae
        public final int f(int i2, int i3, int i4, int i5, int i6) {
            return i4 - i2;
        }

        @Override // android.support.v7.widget.ae
        public final float a(DisplayMetrics displayMetrics) {
            return 300.0f / ((float) displayMetrics.densityDpi);
        }
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onAttachedToWindow() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(227765);
        super.onAttachedToWindow();
        View rootView = getRootView();
        if (rootView == null) {
            AppMethodBeat.o(227765);
            return;
        }
        this.ono = (AppBrandDesktopDragView) rootView.findViewById(R.id.buz);
        Object[] objArr = new Object[1];
        if (this.ono == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onAttachedToWindow mDragFeatureView == null: %b", objArr);
        if (this.ono != null) {
            AppBrandDesktopDragView appBrandDesktopDragView = this.ono;
            if (this.iCn && this.ocu != 1) {
                z2 = false;
            }
            appBrandDesktopDragView.setRecentListDragEnable(z2);
        }
        this.ono.setRecyclerView(this);
        this.ono.setCopyList(this.ond);
        this.ono.setList(this.mDataList);
        this.ono.setCollectionCallback(this.omR);
        this.ono.setItemPadding(this.onq);
        this.ono.setAppBrandCounter(new a(this, (byte) 0));
        this.ono.setViewWidth(this.aYN);
        this.ono.setRecyclerViewScrollComputer(new f() {
            /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.AnonymousClass6 */
        });
        this.opb = this.ono;
        if (this.ono != null && (this.ono.getParent() instanceof RelativeLayout)) {
            Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onAttachedToWindow get root container");
            this.onl = (RelativeLayout) this.ono.getParent();
        }
        AppMethodBeat.o(227765);
    }

    private void cat() {
        AppMethodBeat.i(49609);
        this.onq = getItemPadding();
        AppMethodBeat.o(49609);
    }

    public int getLeftRightMargin() {
        AppMethodBeat.i(49610);
        int ex = b.ex(getContext()) - this.onq;
        if (ex < 0) {
            ex = 0;
        }
        Log.d("MicroMsg.AppBrandDesktopView", "alvinluo getLeftRightMargin: %d, mGridItemPadding: %d", Integer.valueOf(ex), Integer.valueOf(this.onq));
        AppMethodBeat.o(49610);
        return ex;
    }

    private void init(Context context) {
        AppMethodBeat.i(49611);
        this.mContext = context;
        this.onA = 0;
        this.onz = this.onA;
        cau();
        cbl();
        a.init(this.mContext);
        this.apM = a.getCompletelyCountPerPage();
        cat();
        caz();
        this.oni = new l(this.apM);
        this.oni.apR = new GridLayoutManager.b() {
            /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.AnonymousClass7 */

            @Override // android.support.v7.widget.GridLayoutManager.b
            public final int bX(int i2) {
                AppMethodBeat.i(227758);
                int itemViewType = AppBrandDesktopView.this.getAdapter().getItemViewType(i2);
                if (itemViewType == 3 || itemViewType == 11 || itemViewType == 10 || itemViewType == 2 || itemViewType == 6 || itemViewType == 8 || itemViewType == 9) {
                    int i3 = AppBrandDesktopView.this.apM;
                    AppMethodBeat.o(227758);
                    return i3;
                }
                AppMethodBeat.o(227758);
                return 1;
            }
        };
        setLayoutManager(this.oni);
        setOverScrollMode(2);
        a(this.guX);
        this.adj = new e(this, (byte) 0);
        setAdapter(this.adj);
        caA();
        cay();
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(227759);
                AppBrandDesktopView.q(AppBrandDesktopView.this);
                AppMethodBeat.o(227759);
            }
        }, 200);
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView init %d, searchView height: %d", Integer.valueOf(hashCode()), Integer.valueOf(this.onE));
        this.onU = com.tencent.mm.cb.a.fromDPToPix(context, 200);
        this.oob = com.tencent.mm.cb.a.fromDPToPix(context, 24);
        this.onV = com.tencent.mm.cb.a.fromDPToPix(context, 100);
        this.mSmoothScroller = new ae(getContext()) {
            /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.AnonymousClass9 */

            @Override // android.support.v7.widget.ae
            public final int kA() {
                return -1;
            }

            @Override // android.support.v7.widget.ae
            public final float a(DisplayMetrics displayMetrics) {
                return 20.0f / ((float) displayMetrics.densityDpi);
            }

            @Override // android.support.v7.widget.RecyclerView.r
            public final PointF bZ(int i2) {
                AppMethodBeat.i(227760);
                PointF bZ = AppBrandDesktopView.this.oni.bZ(i2);
                AppMethodBeat.o(227760);
                return bZ;
            }
        };
        AppMethodBeat.o(49611);
    }

    private void cau() {
        AppMethodBeat.i(227763);
        this.iCn = ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
        this.ocu = ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvp();
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo updateTeenModeStatus isTeenMode: %b, miniProgramOption: %d", Boolean.valueOf(this.iCn), Integer.valueOf(this.ocu));
        AppMethodBeat.o(227763);
    }

    private void cbl() {
        AppMethodBeat.i(261639);
        boolean z = this.onk;
        this.onk = !this.iCn || this.ocu == 1;
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo updateShowSearchStatus showSearch: %b, lastShow: %b, updateSearchView: %b", Boolean.valueOf(this.onk), Boolean.valueOf(z), Boolean.FALSE);
        AppMethodBeat.o(261639);
    }

    private void caw() {
        AppMethodBeat.i(227766);
        if (this.onf) {
            this.one = this.onk ? 4 : 3;
        } else {
            this.one = this.onk ? 2 : 1;
        }
        Log.i("MicroMsg.AppBrandDesktopView", "alvinuo updateMyAppBrandStartPosition: %d", Integer.valueOf(this.one));
        AppMethodBeat.o(227766);
    }

    private void cay() {
        AppMethodBeat.i(49612);
        if (this.onS) {
            AppMethodBeat.o(49612);
            return;
        }
        com.tencent.mm.plugin.appbrand.widget.recent.j ccP = com.tencent.mm.plugin.appbrand.widget.recent.c.oBT.ccP();
        com.tencent.mm.plugin.appbrand.widget.recent.b ccQ = com.tencent.mm.plugin.appbrand.widget.recent.c.oBT.ccQ();
        if (ccP == null || ccQ == null) {
            AppMethodBeat.o(49612);
            return;
        }
        this.onS = true;
        ccP.remove(this.onR);
        ccP.add(this.onR);
        ccQ.remove(this.onQ);
        ccQ.add(this.onQ);
        AppMethodBeat.o(49612);
    }

    private int getItemPadding() {
        AppMethodBeat.i(49613);
        int ew = b.ew(getContext());
        AppMethodBeat.o(49613);
        return ew;
    }

    private void caz() {
        AppMethodBeat.i(49614);
        setVerticalFadingEdgeEnabled(false);
        setNestedScrollingEnabled(true);
        setBackgroundColor(getContext().getResources().getColor(R.color.ac_));
        AppMethodBeat.o(49614);
    }

    private void caA() {
        AppMethodBeat.i(49615);
        long currentTimeMillis = System.currentTimeMillis();
        this.mDataList.clear();
        this.ond.clear();
        this.onB = 0;
        this.onC = false;
        if (this.onk) {
            this.mDataList.add(new c(6));
        }
        com.tencent.mm.plugin.appbrand.widget.recent.j ccP = com.tencent.mm.plugin.appbrand.widget.recent.c.oBT.ccP();
        List<LocalUsageInfo> vW = ccP != null ? ccP.vW(com.tencent.mm.plugin.appbrand.widget.recent.i.oCT.count) : null;
        com.tencent.mm.plugin.appbrand.widget.recent.b ccQ = com.tencent.mm.plugin.appbrand.widget.recent.c.oBT.ccQ();
        List<LocalUsageInfo> a2 = ccQ != null ? ccQ.a(com.tencent.mm.plugin.appbrand.widget.recent.i.oCS.count, com.tencent.mm.plugin.appbrand.widget.recent.i.oCS.kWk) : null;
        this.onf = vW != null && vW.size() > 0;
        caw();
        if (this.ono != null) {
            this.ono.setCollectionStartPosition(this.one);
        }
        if (a2 == null || a2.size() == 0) {
            this.ong = false;
        } else {
            this.ong = true;
        }
        if (this.onf || this.ong) {
            new c(0);
            if (vW != null && !vW.isEmpty()) {
                this.mDataList.add(new c(10));
                this.mDataList.add(new c(2));
                for (int i2 = 0; i2 < vW.size(); i2++) {
                    c cVar = new c(2);
                    cVar.ooj = vW.get(i2);
                    this.ond.add(cVar);
                }
            }
            this.mDataList.add(new c(11));
            if (a2 != null) {
                Log.i("MicroMsg.AppBrandDesktopView", "alvinluo makeData myList: %d", Integer.valueOf(a2.size()));
                for (int i3 = 0; i3 < a2.size(); i3++) {
                    c cVar2 = new c(1);
                    cVar2.ooj = a2.get(i3);
                    this.mDataList.add(cVar2);
                }
            }
            cas();
            if (!this.ong) {
                this.mDataList.add(new c(8));
                this.onC = true;
            }
            this.mDataList.add(new c(3));
            if (this.ono != null) {
                this.ono.setCopyList(this.ond);
                this.ono.setList(this.mDataList);
            }
            Log.d("MicroMsg.AppBrandDesktopView", "[makeData] cost: %d, isShow: %b, isPaused: %b", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(isShown()), Boolean.valueOf(this.isPaused));
            if (this.asn) {
                this.dXX = true;
            }
            this.adj.atj.notifyChanged();
            if (this.onm != null) {
                Log.d("MicroMsg.AppBrandDesktopView", "alvinluo makeData RecentView notifyDataSetChanged");
                this.onm.setDataList(this.ond);
                this.onm.notifyDataSetChanged();
            }
            Log.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView init mDataList: %d, recentDataCount: %d, myAppBrandCount: %d", Integer.valueOf(this.mDataList.size()), Integer.valueOf(this.ond.size()), Integer.valueOf(this.mDataList.size() - this.one));
            AppMethodBeat.o(49615);
            return;
        }
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView add fullEmpty item");
        this.mDataList.add(new c(9));
        this.mDataList.add(new c(3));
        AppMethodBeat.o(49615);
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(49616);
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        this.aYN = size;
        this.aYO = size2;
        Log.i("MicroMsg.AppBrandDesktopView", "[onMeasure] appbrand desktop view container width: %d", Integer.valueOf(this.aYN));
        int b2 = b.b(this.aYN, getContext());
        if (b2 != this.onq) {
            int i4 = this.aYN;
            Log.i("MicroMsg.AppBrandDesktopView", "alvinluo notifyItemPaddingChanged itemPadding old: %d, new: %d", Integer.valueOf(this.onq), Integer.valueOf(b2));
            a.init(getContext());
            this.onq = b2;
            Log.i("MicroMsg.AppBrandDesktopView", "alvinluo updateItemPadding %d", Integer.valueOf(this.onq));
            if (this.onm != null) {
                this.onm.eH(this.onq, i4);
                if (this.onn != null) {
                    this.onn.cax();
                }
            }
            if (this.adj != null) {
                this.adj.atj.notifyChanged();
            }
            if (this.ono != null) {
                this.ono.setItemPadding(b2);
            }
        }
        if (this.ono != null) {
            this.ono.setViewWidth(this.aYN);
        }
        if (!(this.ooU || this.onh == null || this.onp == this.onh.getViewHeight())) {
            this.onp = this.onh.getViewHeight();
            Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onMeasure fixedViewHeight: %d, measuredHeight: %d", Integer.valueOf(this.onp), Integer.valueOf(this.onh.getMeasuredHeight()));
        }
        AppMethodBeat.o(49616);
    }

    public RecyclerView getRecyclerView() {
        return this;
    }

    private int getCollectionDataSize() {
        AppMethodBeat.i(49617);
        if (!this.ong) {
            AppMethodBeat.o(49617);
            return 0;
        }
        int size = ((this.mDataList.size() - this.one) - this.onB) - 1;
        AppMethodBeat.o(49617);
        return size;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b.a
    public final void caB() {
        AppMethodBeat.i(49618);
        Log.i("MicroMsg.AppBrandDesktopView", "[onOpenHeader]");
        if (!this.onK) {
            setIgnoreNotify(true);
            com.tencent.mm.plugin.appbrand.widget.recent.c.oBT.ccQ();
            removeCallbacks(this.ooa);
            postDelayed(this.ooa, 600);
            com.tencent.mm.plugin.appbrand.report.l.aeK(com.tencent.mm.plugin.appbrand.report.l.bUv());
            String str = this.onG;
            Object obj = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WXA_SEARCH_FROM_DESKTOP_INPUT_HINT_CONTENT_STRING_SYNC, (Object) null);
            if (obj instanceof String) {
                this.onG = Util.nullAs((String) obj, this.onG);
            }
            Log.d("MicroMsg.AppBrandDesktopView", "alvinluo updateSearchWording last: %s, new: %s", str, this.onG);
            caD();
            if (!(this.onJ == null || this.onn == null)) {
                Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onOpenHeader report open recentCount: %d, collectionCount: %d", Integer.valueOf(this.onn.getShowCount()), Integer.valueOf(getCollectionDataSize()));
                this.onJ.eO(this.onn.getShowCount(), getCollectionDataSize());
                this.onJ.ccU();
                if (this.onJ != null) {
                    if (this.onn != null) {
                        this.onJ.oCI = TextUtils.join(":", bW(this.onn.getShowList()));
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator<c> it = this.mDataList.iterator();
                    while (it.hasNext()) {
                        c next = it.next();
                        if (next.type == 1) {
                            arrayList.add(next);
                        }
                        if (arrayList.size() >= 20) {
                            break;
                        }
                    }
                    this.onJ.oCJ = TextUtils.join(":", bW(arrayList));
                }
                com.tencent.f.h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.AnonymousClass11 */

                    public final void run() {
                        AppMethodBeat.i(49580);
                        if (AppBrandDesktopView.this.ong && AppBrandDesktopView.this.onf) {
                            if (AppBrandDesktopView.this.onn == null) {
                                AppMethodBeat.o(49580);
                                return;
                            }
                            List<c> showList = AppBrandDesktopView.this.onn.getShowList();
                            ArrayList arrayList = new ArrayList();
                            for (int i2 = 0; i2 < showList.size(); i2++) {
                                c cVar = showList.get(i2);
                                if (!(cVar == null || cVar.ooj == null)) {
                                    com.tencent.mm.plugin.appbrand.widget.recent.e eVar = new com.tencent.mm.plugin.appbrand.widget.recent.e(cVar.ooj);
                                    eVar.position = i2;
                                    arrayList.add(eVar);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList();
                            for (int i3 = AppBrandDesktopView.this.one; i3 < AppBrandDesktopView.this.mDataList.size(); i3++) {
                                c cVar2 = (c) AppBrandDesktopView.this.mDataList.get(i3);
                                if (cVar2 != null && cVar2.type == 1) {
                                    com.tencent.mm.plugin.appbrand.widget.recent.e eVar2 = new com.tencent.mm.plugin.appbrand.widget.recent.e(cVar2.ooj);
                                    eVar2.position = i3;
                                    arrayList2.add(eVar2);
                                }
                            }
                            com.tencent.mm.plugin.appbrand.widget.recent.g.k(arrayList, arrayList2);
                        }
                        AppMethodBeat.o(49580);
                    }
                });
            }
            this.onK = true;
            this.onN = true;
            this.onO = true;
            com.tencent.mm.modelappbrand.b.aXE();
            ai.LX(0);
        }
        setLayoutFrozen(false);
        AppMethodBeat.o(49618);
    }

    private static ArrayList<String> bW(List<c> list) {
        AppMethodBeat.i(49619);
        ArrayList<String> arrayList = new ArrayList<>();
        if (list == null) {
            AppMethodBeat.o(49619);
            return arrayList;
        }
        for (c cVar : list) {
            if (cVar.ooj != null && !Util.isNullOrNil(cVar.ooj.appId)) {
                arrayList.add(cVar.ooj.appId);
            }
        }
        AppMethodBeat.o(49619);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b.a
    public final void eG(int i2, int i3) {
        AppMethodBeat.i(227768);
        Log.i("MicroMsg.AppBrandDesktopView", "[onCloseHeader] reason: %d", Integer.valueOf(i2));
        removeCallbacks(this.ooa);
        if (this.onK) {
            if (!(this.onJ == null || this.onn == null)) {
                this.onJ.oCH = false;
                Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo enableNativeDynamicBackground %b", Boolean.FALSE);
                Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onCloseHeader report close recentCount: %d, collectionCount: %d, reason: %d", Integer.valueOf(this.onn.getShowCount()), Integer.valueOf(getCollectionDataSize()), Integer.valueOf(i2));
                com.tencent.mm.plugin.appbrand.widget.recent.g gVar = this.onJ;
                int cal = a.cal();
                int showLines = this.onn.getShowLines();
                int completelyCountPerPage = a.getCompletelyCountPerPage();
                gVar.oCk = cal;
                gVar.oCl = showLines;
                gVar.oCm = completelyCountPerPage;
                com.tencent.mm.plugin.appbrand.widget.recent.g gVar2 = this.onJ;
                int showCount = this.onn.getShowCount();
                int collectionDataSize = getCollectionDataSize();
                gVar2.oCg = showCount;
                gVar2.oCs = collectionDataSize;
                gVar2.oCd = i2;
                com.tencent.f.h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.widget.recent.g.AnonymousClass2 */

                    public final void run() {
                        int i2 = 1;
                        AppMethodBeat.i(194389);
                        if (g.this.oCb <= 0) {
                            Log.d("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime <= 0");
                            AppMethodBeat.o(194389);
                            return;
                        }
                        Log.i("MicroMsg.AppBrandRecentViewReporter", "mOpenTime: %d, mRecentCountAtOpen: %d, mRecentCountAtClose: %d, mCloseType: %d, mOpenRecentAppBrandList: %s, mDeleteRecentCount: %d, mDeleteRecentAppBrandList: %s,\nmStarCountAtOpen: %d, mStarCountAtClose: %d, mOpenStarAppBrandList: %s, mDeleteStarCount: %d, mDeleteStarAppBrandList: %s,\nmClickRecentAppBrandList: %s, mClickStarAppBrandList: %s, mAddCollectionCount: %d, mAddCollectionAppBrandList: %s, fullScreen: %b,\nmMoveStarAppBrandForwardCount: %d, mMoveStarAppBrandBackwardCount: %d, mScrollUpDown: %d, mShowSearchViewCount: %d, mClickSearchViewCount: %d,\nmMoveStarAppBrandForwardList: %s, mMoveStarAppBrandBackwardList: %s, mEnableNativeDynamicBackground: %b, recentMaxShowLines: %d, recentCurrentShowLine: %d, recentCountPerLine: %d,openSession: %d", Long.valueOf(g.this.oCb), Integer.valueOf(g.this.oCf), Integer.valueOf(g.this.oCg), Integer.valueOf(g.this.oCd), g.this.oCn.toString(), Integer.valueOf(g.this.oCi), g.this.oCo.toString(), Integer.valueOf(g.this.oCr), Integer.valueOf(g.this.oCs), g.this.oCy.toString(), Integer.valueOf(g.this.oCu), g.this.oCz.toString(), g.this.oCp.toString(), g.this.oCB.toString(), Integer.valueOf(g.this.oCj), g.this.oCq.toString(), Boolean.TRUE, Integer.valueOf(g.this.oCw), Integer.valueOf(g.this.oCx), Integer.valueOf(g.this.oCE), Integer.valueOf(g.this.oCF), Integer.valueOf(g.this.oCG), g.this.oCC.toString(), g.this.oCD.toString(), Boolean.valueOf(g.this.oCH), Integer.valueOf(g.this.oCk), Integer.valueOf(g.this.oCl), Integer.valueOf(g.this.oCm), Integer.valueOf(g.this.oCc));
                        h hVar = h.INSTANCE;
                        Object[] objArr = new Object[36];
                        objArr[0] = Long.valueOf(g.this.oCb);
                        objArr[1] = Integer.valueOf(g.this.oCf);
                        objArr[2] = Integer.valueOf(g.this.oCg);
                        objArr[3] = Integer.valueOf(g.this.oCd);
                        objArr[4] = 0;
                        objArr[5] = g.this.oCn.toString();
                        objArr[6] = Integer.valueOf(g.this.oCi);
                        objArr[7] = g.this.oCo.toString();
                        objArr[8] = 0;
                        objArr[9] = Integer.valueOf(g.this.oCr);
                        objArr[10] = Integer.valueOf(g.this.oCs);
                        objArr[11] = 0;
                        objArr[12] = g.this.oCy.toString();
                        objArr[13] = Integer.valueOf(g.this.oCu);
                        objArr[14] = g.this.oCz.toString();
                        objArr[15] = 0;
                        objArr[16] = g.this.oCp.toString();
                        objArr[17] = g.this.oCB.toString();
                        objArr[18] = "";
                        objArr[19] = Integer.valueOf(g.this.oCj);
                        objArr[20] = g.this.oCq.toString();
                        objArr[21] = 1;
                        objArr[22] = 0;
                        objArr[23] = 0;
                        objArr[24] = Integer.valueOf(g.this.oCw);
                        objArr[25] = Integer.valueOf(g.this.oCx);
                        objArr[26] = Integer.valueOf(g.this.oCE);
                        objArr[27] = Integer.valueOf(g.this.oCF);
                        objArr[28] = Integer.valueOf(g.this.oCG);
                        objArr[29] = g.this.oCC.toString();
                        objArr[30] = g.this.oCD.toString();
                        if (!g.this.oCH) {
                            i2 = 0;
                        }
                        objArr[31] = Integer.valueOf(i2);
                        objArr[32] = Integer.valueOf(g.this.oCk);
                        objArr[33] = Integer.valueOf(g.this.oCl);
                        objArr[34] = Integer.valueOf(g.this.oCm);
                        objArr[35] = Integer.valueOf(g.this.oCc);
                        hVar.a(15081, objArr);
                        g.a(g.this);
                        AppMethodBeat.o(194389);
                    }
                });
                if (gVar2.oCI == null) {
                    gVar2.oCI = "";
                }
                if (gVar2.oCJ == null) {
                    gVar2.oCJ = "";
                }
                Log.i("MicroMsg.AppBrandRecentViewReporter", "alvinluo reportShowAppIdList openSession: %d, recentShowAppIdList: %s, %d, starShowAppIdList: %s, %d", Integer.valueOf(gVar2.oCc), gVar2.oCI, Integer.valueOf(gVar2.oCI.length()), gVar2.oCJ, Integer.valueOf(gVar2.oCJ.length()));
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(18446, Integer.valueOf(gVar2.oCc), gVar2.oCI, gVar2.oCJ);
            }
            this.onK = false;
            this.onN = false;
            this.onO = false;
            if (i2 == 9 || i2 == 13) {
                if (this.onQ != null) {
                    this.onQ.onL = false;
                }
            } else if (this.onQ != null) {
                this.onQ.onL = true;
            }
            if (this.onR != null) {
                this.onR.onL = false;
            }
            postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.AnonymousClass12 */

                public final void run() {
                    AppMethodBeat.i(49581);
                    AppBrandDesktopView.q(AppBrandDesktopView.this);
                    AppMethodBeat.o(49581);
                }
            }, 300);
        }
        zS(1);
        AppMethodBeat.o(227768);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b.a
    public final void zT(int i2) {
        AppMethodBeat.i(49621);
        eG(i2, 0);
        AppMethodBeat.o(49621);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b.a
    public final void caC() {
        AppMethodBeat.i(49622);
        caB();
        AppMethodBeat.o(49622);
    }

    private void caD() {
        EditText editText;
        AppMethodBeat.i(49623);
        if (!(this.onD == null || (editText = (EditText) this.onD.findViewById(R.id.nr)) == null || Util.isNullOrNil(this.onG))) {
            Log.v("MicroMsg.AppBrandDesktopView", "alvinluo initSearchView searchWording: %s", this.onG);
            editText.setHint(this.onG);
        }
        AppMethodBeat.o(49623);
    }

    private boolean a(LocalUsageInfo localUsageInfo, WxaAttributes.a aVar) {
        if (aVar.serviceType != 0 && aVar.serviceType != 4) {
            return true;
        }
        if (this.ocu == 0) {
            return localUsageInfo.kWa;
        }
        if (this.ocu == 2) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public class e extends RecyclerView.a {
        private e() {
        }

        /* synthetic */ e(AppBrandDesktopView appBrandDesktopView, byte b2) {
            this();
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(49589);
            if (i2 == 1) {
                d dVar = new d(aa.jQ(AppBrandDesktopView.this.getContext()).inflate(R.layout.gx, viewGroup, false));
                AppMethodBeat.o(49589);
                return dVar;
            } else if (i2 == 2) {
                Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onCreateViewHolder RecentView");
                AppBrandDesktopView.this.onm = new RecentAppBrandViewContainer(AppBrandDesktopView.this.getContext());
                AppBrandDesktopView.this.onm.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                AppBrandDesktopView.this.onm.eH(AppBrandDesktopView.this.onq, AppBrandDesktopView.this.aYN);
                AppBrandDesktopView.this.onn = AppBrandDesktopView.this.onm.getRecentView();
                if (AppBrandDesktopView.this.onn != null) {
                    AppBrandDesktopView.this.onn.setReporter(AppBrandDesktopView.this.onJ);
                    AppBrandDesktopView.this.onn.setOnItemClickListener(new RecentAppBrandView.b() {
                        /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.e.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandView.b
                        public final void a(final RecyclerView.v vVar, final c cVar) {
                            AppMethodBeat.i(49586);
                            if (cVar == null) {
                                AppMethodBeat.o(49586);
                                return;
                            }
                            AppBrandDesktopView.a(AppBrandDesktopView.this, cVar.ooj, new f() {
                                /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.e.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.f
                                public final void dQ(boolean z) {
                                    AppMethodBeat.i(227762);
                                    Log.i("MicroMsg.AppBrandDesktopView", "checkLaunchAppBrand checkOk: %b", Boolean.valueOf(z));
                                    if (!z) {
                                        ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(AppBrandDesktopView.this.mContext);
                                        if (cVar.ooj != null) {
                                            com.tencent.mm.plugin.appbrand.launching.f.a.aco(cVar.ooj.username);
                                        }
                                        AppMethodBeat.o(227762);
                                        return;
                                    }
                                    AppBrandDesktopView.this.onM = false;
                                    AppBrandDesktopView.this.onN = false;
                                    AppBrandDesktopView.this.onO = false;
                                    AppBrandDesktopView.this.setLayoutFrozen(true);
                                    AppBrandDesktopView.a(AppBrandDesktopView.this, 1089, 2, cVar.ooj, vVar.lR());
                                    AppMethodBeat.o(227762);
                                }
                            });
                            AppMethodBeat.o(49586);
                        }
                    });
                }
                AppBrandDesktopView.this.onm.setDataList(AppBrandDesktopView.this.ond);
                AppBrandDesktopView.this.onm.setOnMoreClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.e.AnonymousClass2 */

                    public final void onClick(View view) {
                        int i2;
                        AppMethodBeat.i(49587);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$ItemAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        AppBrandDesktopView.this.onM = false;
                        AppBrandDesktopView.this.onN = false;
                        AppBrandDesktopView.this.onO = false;
                        i unused = AppBrandDesktopView.this.onc;
                        AppBrandDesktopView.this.onP = 9;
                        i unused2 = AppBrandDesktopView.this.onc;
                        int unused3 = AppBrandDesktopView.this.onP;
                        t tVar = (t) com.tencent.mm.kernel.g.af(t.class);
                        Context context = view.getContext();
                        if (AppBrandDesktopView.this.onJ != null) {
                            i2 = AppBrandDesktopView.this.onJ.oCc;
                        } else {
                            i2 = 0;
                        }
                        tVar.L(context, i2);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$ItemAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(49587);
                    }
                });
                AnonymousClass3 r0 = new RecyclerView.v(AppBrandDesktopView.this.onm) {
                    /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.e.AnonymousClass3 */
                };
                AppMethodBeat.o(49589);
                return r0;
            } else if (i2 == 3) {
                View view = new View(AppBrandDesktopView.this.getContext());
                RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, AppBrandDesktopView.this.onz);
                layoutParams.setMargins(layoutParams.leftMargin + AppBrandDesktopView.this.onq, layoutParams.topMargin, layoutParams.rightMargin + AppBrandDesktopView.this.onq, layoutParams.bottomMargin);
                view.setLayoutParams(layoutParams);
                j jVar = new j(view);
                AppMethodBeat.o(49589);
                return jVar;
            } else if (i2 == 6) {
                try {
                    AppBrandDesktopView.this.onD = aa.jQ(AppBrandDesktopView.this.getContext()).inflate(R.layout.dn, viewGroup, false);
                    h hVar = new h(AppBrandDesktopView.this.onD);
                    AppMethodBeat.o(49589);
                    return hVar;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.AppBrandDesktopView", e2, "alvinluo init searchView exception", new Object[0]);
                    h hVar2 = new h(new View(AppBrandDesktopView.this.getContext()));
                    AppMethodBeat.o(49589);
                    return hVar2;
                }
            } else if (i2 == 7) {
                View inflate = aa.jQ(AppBrandDesktopView.this.getContext()).inflate(R.layout.gx, viewGroup, false);
                RecyclerView.LayoutParams layoutParams2 = new RecyclerView.LayoutParams(-1, -2);
                layoutParams2.setMargins(layoutParams2.leftMargin + AppBrandDesktopView.this.onq, layoutParams2.topMargin, layoutParams2.rightMargin + AppBrandDesktopView.this.onq, layoutParams2.bottomMargin);
                inflate.setLayoutParams(layoutParams2);
                AppBrandDesktopView.this.onH = inflate;
                d dVar2 = new d(inflate);
                AppMethodBeat.o(49589);
                return dVar2;
            } else if (i2 == 8) {
                g gVar = new g(aa.jQ(AppBrandDesktopView.this.getContext()).inflate(R.layout.dj, viewGroup, false));
                AppMethodBeat.o(49589);
                return gVar;
            } else if (i2 == 9) {
                d dVar3 = new d(aa.jQ(AppBrandDesktopView.this.getContext()).inflate(R.layout.dl, viewGroup, false));
                AppMethodBeat.o(49589);
                return dVar3;
            } else {
                j jVar2 = new j(aa.jQ(AppBrandDesktopView.this.getContext()).inflate(R.layout.bep, viewGroup, false));
                AppMethodBeat.o(49589);
                return jVar2;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(49590);
            c zU = zU(i2);
            if (zU != null) {
                int i3 = zU.type;
                AppMethodBeat.o(49590);
                return i3;
            }
            AppMethodBeat.o(49590);
            return 0;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(49592);
            int size = AppBrandDesktopView.this.mDataList.size();
            AppMethodBeat.o(49592);
            return size;
        }

        private c zU(int i2) {
            AppMethodBeat.i(49593);
            if (i2 >= AppBrandDesktopView.this.mDataList.size() || i2 < 0) {
                AppMethodBeat.o(49593);
                return null;
            }
            c cVar = (c) AppBrandDesktopView.this.mDataList.get(i2);
            AppMethodBeat.o(49593);
            return cVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            boolean z;
            int i3 = 0;
            AppMethodBeat.i(49591);
            int i4 = vVar.auw;
            if (i4 == 3) {
                int i5 = AppBrandDesktopView.this.onz;
                if (AppBrandDesktopView.this.onp == 0) {
                    AppBrandDesktopView.this.onp = AppBrandDesktopView.this.onh.getViewHeight();
                }
                int fromDPToPix = ((AppBrandDesktopView.this.onp - com.tencent.mm.cb.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 56)) - com.tencent.mm.cb.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 48)) - ao.getStatusBarHeight(AppBrandDesktopView.this.getContext());
                int k = AppBrandDesktopView.k(AppBrandDesktopView.this);
                if (k > AppBrandDesktopView.this.onE + fromDPToPix) {
                    AppBrandDesktopView.this.onz = AppBrandDesktopView.this.onA;
                } else if (k > fromDPToPix) {
                    AppBrandDesktopView.this.onz = AppBrandDesktopView.this.onE - (k - fromDPToPix);
                } else {
                    AppBrandDesktopView.this.onz = (fromDPToPix - k) + AppBrandDesktopView.this.onE;
                }
                Log.i("MicroMsg.AppBrandDesktopView", "alvinluo computeFooterHeight mostHeight: %d, titleHeight: %d, itemHeight: %d, recyclerViewHeight: %d, mFooterHeight: %d, oldFooterHeight: %d, searchLayoutHeight: %d", Integer.valueOf(fromDPToPix), Integer.valueOf(AppBrandDesktopView.this.onw), Integer.valueOf(AppBrandDesktopView.this.onv), Integer.valueOf(k), Integer.valueOf(AppBrandDesktopView.this.onz), Integer.valueOf(i5), Integer.valueOf(AppBrandDesktopView.this.onE));
                vVar.aus.setVisibility(4);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) vVar.aus.getLayoutParams();
                layoutParams.height = AppBrandDesktopView.this.onz;
                Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder change footer height: %d", Integer.valueOf(AppBrandDesktopView.this.onz));
                vVar.aus.setLayoutParams(layoutParams);
                AppMethodBeat.o(49591);
            } else if (i4 == 10 || i4 == 11) {
                if (vVar == null) {
                    AppMethodBeat.o(49591);
                    return;
                }
                View view = vVar.aus;
                int fromDPToPix2 = AppBrandDesktopView.this.onq + ((int) (((float) com.tencent.mm.cb.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 8)) * b.ez(AppBrandDesktopView.this.getContext())));
                RecyclerView.LayoutParams layoutParams2 = new RecyclerView.LayoutParams(-1, -2);
                layoutParams2.setMargins(layoutParams2.leftMargin + fromDPToPix2, layoutParams2.topMargin, fromDPToPix2 + layoutParams2.rightMargin, layoutParams2.bottomMargin);
                view.setLayoutParams(layoutParams2);
                if (AppBrandDesktopView.this.onw == 0) {
                    View view2 = vVar.aus;
                    view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder titleHeight: %d, titleWidth: %d", Integer.valueOf(view2.getMeasuredHeight()), Integer.valueOf(view2.getMeasuredWidth()));
                    AppBrandDesktopView.this.onw = view2.getMeasuredHeight();
                }
                ((j) vVar).titleTv.setText(i4 == 10 ? R.string.fux : R.string.f_c);
                AppMethodBeat.o(49591);
            } else if (i4 == 8) {
                g gVar = (g) vVar;
                if (!AppBrandDesktopView.this.ong) {
                    z = true;
                } else {
                    z = false;
                }
                Log.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder show: %b, itemHeight: %d", Boolean.valueOf(z), Integer.valueOf(AppBrandDesktopView.this.onv));
                if (!z) {
                    i3 = 4;
                }
                if (AppBrandDesktopView.this.onH != null && z) {
                    AppBrandDesktopView.this.onH.getLayoutParams().height = AppBrandDesktopView.this.onv;
                }
                if (gVar.aus != null) {
                    gVar.aus.setVisibility(i3);
                }
                AppMethodBeat.o(49591);
            } else if (i4 == 6) {
                AppBrandDesktopView.c(AppBrandDesktopView.this, vVar.aus);
                AppMethodBeat.o(49591);
            } else if (i4 == 2 || i4 == 9) {
                AppMethodBeat.o(49591);
            } else {
                if (i4 == 1 || i4 == 7) {
                    final d dVar = (d) vVar;
                    dVar.aus.setPadding(AppBrandDesktopView.this.onq, com.tencent.mm.cb.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 8), AppBrandDesktopView.this.onq, com.tencent.mm.cb.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 16));
                    int ey = (int) b.ey(AppBrandDesktopView.this.getContext());
                    dVar.ooC.getLayoutParams().width = ((int) (((float) (com.tencent.mm.cb.a.aH(AppBrandDesktopView.this.getContext(), R.dimen.k5) * 2)) * b.ez(AppBrandDesktopView.this.getContext()))) + ey;
                    dVar.ooC.getLayoutParams().height = ((int) (((float) (com.tencent.mm.cb.a.aH(AppBrandDesktopView.this.getContext(), R.dimen.k5) * 2)) * b.ez(AppBrandDesktopView.this.getContext()))) + ey;
                    dVar.nnL.getLayoutParams().width = ey;
                    dVar.nnL.getLayoutParams().height = ey;
                    dVar.ooB.getLayoutParams().width = ey;
                    dVar.ooB.getLayoutParams().height = ey;
                    vVar.aus.setVisibility(0);
                    if (AppBrandDesktopView.this.onv == 0) {
                        View view3 = vVar.aus;
                        view3.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder itemHeight: %d, itemWidth: %d", Integer.valueOf(view3.getMeasuredHeight()), Integer.valueOf(view3.getMeasuredWidth()));
                        AppBrandDesktopView.this.onv = view3.getMeasuredHeight();
                    }
                    if (i4 == 7) {
                        vVar.aus.setVisibility(4);
                        if (((i2 - AppBrandDesktopView.this.one) + 1) % 4 != 1 || i2 <= AppBrandDesktopView.this.one) {
                            if (AppBrandDesktopView.this.onI == 0) {
                                View view4 = vVar.aus;
                                view4.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                                Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder emptyItemHeight: %d", Integer.valueOf(view4.getMeasuredHeight()));
                                AppBrandDesktopView.this.onI = view4.getMeasuredHeight();
                            }
                            AppMethodBeat.o(49591);
                            return;
                        }
                        vVar.aus.getLayoutParams().height = 1;
                        AppBrandDesktopView.this.onI = vVar.aus.getLayoutParams().height;
                        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder height: %d", Integer.valueOf(vVar.aus.getLayoutParams().height));
                        AppMethodBeat.o(49591);
                        return;
                    }
                    final c zU = zU(i2);
                    if (zU == null) {
                        AppMethodBeat.o(49591);
                        return;
                    }
                    zU.position = i2;
                    dVar.ooG = zU;
                    if (zU.ooj != null) {
                        if (!Util.isNullOrNil(zU.ooj.cyB)) {
                            dVar.titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.b.a.afX(zU.ooj.cyB));
                            dVar.titleTv.setVisibility(0);
                        } else if (!Util.isNullOrNil(zU.ooj.nickname)) {
                            dVar.titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.b.a.afX(zU.ooj.nickname));
                            dVar.titleTv.setVisibility(0);
                        } else if (!Util.isNullOrNil(zU.ooj.username)) {
                            dVar.titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.b.a.afX(zU.ooj.nickname));
                            dVar.titleTv.setVisibility(0);
                        } else {
                            Log.w("MicroMsg.AppBrandDesktopView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", zU.ooj.username, zU.ooj.appId);
                            dVar.titleTv.setVisibility(4);
                        }
                        dVar.ooB.setVisibility(0);
                        if (!Util.isNullOrNil(zU.ooj.kVZ)) {
                            com.tencent.mm.modelappbrand.a.b.aXY().a(dVar.nnL, zU.ooj.kVZ, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
                        } else {
                            dVar.nnL.setImageDrawable(com.tencent.mm.modelappbrand.a.a.aXX());
                        }
                        if (!Util.isNullOrNil(com.tencent.mm.plugin.appbrand.appcache.e.vO(zU.ooj.iOo))) {
                            dVar.ooD.setVisibility(0);
                            dVar.ooD.setText(com.tencent.mm.plugin.appbrand.appcache.e.vO(zU.ooj.iOo));
                        } else {
                            dVar.ooD.setVisibility(8);
                        }
                        dVar.aus.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.e.AnonymousClass4 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(49588);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$ItemAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                AppBrandDesktopView.this.onM = false;
                                AppBrandDesktopView.this.onN = false;
                                AppBrandDesktopView.this.onO = false;
                                AppBrandDesktopView.this.setLayoutFrozen(true);
                                AppBrandDesktopView.a(AppBrandDesktopView.this, 1104, 1, zU.ooj, dVar.lR());
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$ItemAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(49588);
                            }
                        });
                    } else {
                        com.tencent.mm.modelappbrand.a.b.aXY().a(dVar.nnL, "", com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
                        dVar.titleTv.setVisibility(0);
                        dVar.ooD.setVisibility(8);
                        dVar.titleTv.setText("");
                    }
                }
                if (AppBrandDesktopView.this.getDragRubbishView() != null) {
                    DragFeatureView dragRubbishView = AppBrandDesktopView.this.getDragRubbishView();
                    if (dragRubbishView.getVisibility() != 8) {
                        if (dragRubbishView.ooL == i2) {
                            vVar.aus.setVisibility(4);
                            AppMethodBeat.o(49591);
                            return;
                        }
                        vVar.aus.setVisibility(0);
                    }
                }
                AppMethodBeat.o(49591);
            }
        }
    }

    public class j extends RecyclerView.v {
        protected TextView titleTv;

        public j(View view) {
            super(view);
            AppMethodBeat.i(49597);
            this.titleTv = (TextView) view.findViewById(R.id.ikt);
            AppMethodBeat.o(49597);
        }
    }

    public class h extends RecyclerView.v {
        private View.OnClickListener ko = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.h.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(49595);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$SearchViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                AppBrandDesktopView.this.onM = false;
                AppBrandDesktopView.this.onN = false;
                AppBrandDesktopView.this.onO = false;
                Log.i("MicroMsg.AppBrandDesktopView", "alvinluo AppbrandDesktop search jump to AppBrandSearchUI");
                long currentTimeMillis = System.currentTimeMillis();
                if (AppBrandDesktopView.this.onJ != null && (h.this.lastClickTime == 0 || currentTimeMillis - h.this.lastClickTime > 1000)) {
                    h.this.lastClickTime = currentTimeMillis;
                    com.tencent.mm.plugin.appbrand.widget.recent.g gVar = AppBrandDesktopView.this.onJ;
                    gVar.oCG++;
                    Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo clickSearchView %d", Integer.valueOf(gVar.oCG));
                }
                com.tencent.mm.plugin.websearch.api.h hVar = (com.tencent.mm.plugin.websearch.api.h) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.websearch.api.h.class);
                if (hVar != null) {
                    hVar.b(AppBrandDesktopView.this.mContext, 42, AppBrandDesktopView.this.onG, "");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$SearchViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(49595);
            }
        };
        private long lastClickTime = 0;
        protected EditText ooo;

        public h(View view) {
            super(view);
            AppMethodBeat.i(49596);
            this.ooo = (EditText) view.findViewById(R.id.nr);
            if (this.ooo != null) {
                this.ooo.setFocusable(false);
                this.ooo.setOnClickListener(this.ko);
            }
            view.setOnClickListener(this.ko);
            AppMethodBeat.o(49596);
        }
    }

    public class g extends RecyclerView.v {
        public g(View view) {
            super(view);
            AppMethodBeat.i(49594);
            AppBrandDesktopView.this.ony = AppBrandDesktopView.this.onv;
            if (AppBrandDesktopView.this.ony == 0 && this.aus != null) {
                this.aus.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                Log.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder itemHeight: %d, itemWidth: %d", Integer.valueOf(this.aus.getMeasuredHeight()), Integer.valueOf(this.aus.getMeasuredWidth()));
                AppBrandDesktopView.this.ony = this.aus.getMeasuredHeight();
            }
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
            layoutParams.setMargins(layoutParams.leftMargin + AppBrandDesktopView.this.onq, layoutParams.topMargin - AppBrandDesktopView.this.ony, layoutParams.rightMargin + AppBrandDesktopView.this.onq, layoutParams.bottomMargin);
            Log.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder topMargin: %d", Integer.valueOf(layoutParams.topMargin));
            if (this.aus != null) {
                this.aus.setLayoutParams(layoutParams);
            }
            AppMethodBeat.o(49594);
        }
    }

    public class d extends RecyclerView.v {
        public d(View view) {
            super(view);
            AppMethodBeat.i(49585);
            if (AppBrandDesktopView.this.onx == 0 && this.aus != null) {
                this.aus.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                Log.i("MicroMsg.AppBrandDesktopView", "alvinluo FullEmptyViewHolder itemHeight: %d, itemWidth: %d", Integer.valueOf(this.aus.getMeasuredHeight()), Integer.valueOf(this.aus.getMeasuredWidth()));
                AppBrandDesktopView.this.onx = this.aus.getMeasuredHeight();
            }
            AppMethodBeat.o(49585);
        }
    }

    public static class c {
        public LocalUsageInfo ooj;
        public int position;
        public int type;

        public c(int i2) {
            this.type = i2;
        }
    }

    private void jc(boolean z) {
        int i2;
        AppMethodBeat.i(49627);
        if (this.mSmoothScroller != null) {
            RecyclerView.r rVar = this.mSmoothScroller;
            if (z) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            rVar.atO = i2;
            this.oni.startSmoothScroll(this.mSmoothScroller);
        }
        AppMethodBeat.o(49627);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.DragRecyclerView
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(49607);
        if (this.ooU) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(49607);
            return dispatchTouchEvent;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.onW = motionEvent.getRawY();
                this.ons = true;
                this.onX = 0.0f;
                this.onY = false;
                this.onZ = false;
                break;
            case 1:
            case 3:
                if (this.onY) {
                    this.ons = false;
                    if (Math.abs(this.onX) >= ((float) this.onV) && this.onh != null) {
                        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo checkAndClose closeHeader because of pull up bottom");
                        this.onh.ac(0, 15);
                    }
                    animate().translationY(0.0f).setDuration(300).setInterpolator(this.mInterpolator).setListener(this.wY).start();
                }
                this.onX = 0.0f;
                this.onY = false;
                this.onZ = false;
                break;
            case 2:
                Log.v("MicroMsg.AppBrandDesktopView", "alvinluo ActionMove moveUp: %b, mMoveY: %f, touchSlop: %d", Boolean.valueOf(this.onY), Float.valueOf(this.onX), Integer.valueOf(this.mTouchSlop));
                if (this.oni == null || this.mDataList == null) {
                    z = false;
                } else {
                    int kv = this.oni.kv();
                    Log.i("MicroMsg.AppBrandDesktopView", "alvinluo isAtBottom last: %d, data list size: %d", Integer.valueOf(kv), Integer.valueOf(this.mDataList.size()));
                    z = kv == this.mDataList.size() + -1;
                }
                if (z && !this.onY) {
                    if (this.onZ) {
                        this.onX = (motionEvent.getRawY() - this.onW) * 0.55f;
                        if (this.onX < ((float) (-this.mTouchSlop))) {
                            this.onY = true;
                            break;
                        }
                    } else {
                        this.onW = motionEvent.getRawY();
                        this.onX = 0.0f;
                        this.onZ = true;
                        break;
                    }
                } else if (this.onY) {
                    this.onX = (motionEvent.getRawY() - this.onW) * 0.55f;
                    if (this.onX > 0.0f) {
                        boolean dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
                        AppMethodBeat.o(49607);
                        return dispatchTouchEvent2;
                    }
                    int abs = (int) Math.abs(this.onX);
                    Log.v("MicroMsg.AppBrandDesktopView", "alvinluo moveView: %d", Integer.valueOf(abs));
                    setTranslationY((float) (-abs));
                    AppMethodBeat.o(49607);
                    return true;
                }
                break;
        }
        boolean dispatchTouchEvent3 = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(49607);
        return dispatchTouchEvent3;
    }

    static /* synthetic */ void a(AppBrandDesktopView appBrandDesktopView, int i2) {
        AppMethodBeat.i(49630);
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo notifyCollectionDataChanged mDataList: %d, mMyAppBrandStartPosition: %d, startPos: %d, hasMyAppBrandData: %b", Integer.valueOf(appBrandDesktopView.mDataList.size()), Integer.valueOf(appBrandDesktopView.one), Integer.valueOf(i2), Boolean.valueOf(appBrandDesktopView.ong));
        if (appBrandDesktopView.mDataList.size() > (appBrandDesktopView.onC ? 1 : 0) + appBrandDesktopView.one + 2) {
            if (!appBrandDesktopView.ong) {
                appBrandDesktopView.ong = true;
                appBrandDesktopView.adj.atj.notifyChanged();
                AppMethodBeat.o(49630);
                return;
            }
        } else if (appBrandDesktopView.onf) {
            if (!appBrandDesktopView.onC) {
                appBrandDesktopView.mDataList.add(appBrandDesktopView.mDataList.size() - 1, new c(8));
                appBrandDesktopView.onC = true;
            }
            appBrandDesktopView.adj.atj.notifyChanged();
            if (appBrandDesktopView.ong) {
                appBrandDesktopView.ong = false;
                AppMethodBeat.o(49630);
                return;
            }
        } else {
            appBrandDesktopView.car();
        }
        AppMethodBeat.o(49630);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView r14, int r15) {
        /*
        // Method dump skipped, instructions count: 563
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.b(com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView, int):void");
    }

    static /* synthetic */ int k(AppBrandDesktopView appBrandDesktopView) {
        int i2;
        AppMethodBeat.i(49634);
        int i3 = appBrandDesktopView.onE;
        if (appBrandDesktopView.onf || appBrandDesktopView.ong) {
            if (appBrandDesktopView.onf) {
                i3 += appBrandDesktopView.onw;
                if (appBrandDesktopView.onm != null) {
                    Log.i("MicroMsg.AppBrandDesktopView", "alvinluo computeRecyclerViewTotalHeight recent row: %d", Integer.valueOf(appBrandDesktopView.onm.getShowLines()));
                    i3 += appBrandDesktopView.onm.getShowLines() * appBrandDesktopView.onv;
                }
            }
            if (appBrandDesktopView.ong) {
                int i4 = appBrandDesktopView.onw + i3;
                int collectionDataSize = appBrandDesktopView.getCollectionDataSize();
                Log.i("MicroMsg.AppBrandDesktopView", "alvinluo computeRecyclerViewTotalHeight itemCount: %d", Integer.valueOf(collectionDataSize));
                if (collectionDataSize > appBrandDesktopView.apM) {
                    int i5 = (collectionDataSize / appBrandDesktopView.apM) + (collectionDataSize % appBrandDesktopView.apM == 0 ? 0 : 1);
                    if (appBrandDesktopView.onv * i5 < appBrandDesktopView.ony) {
                        i2 = appBrandDesktopView.ony + i4;
                    } else {
                        i2 = (appBrandDesktopView.onv * i5) + i4;
                        if (collectionDataSize % appBrandDesktopView.apM == 0) {
                            Log.i("MicroMsg.AppBrandDesktopView", "alvinluo computeRecyclerViewTotalHeight add extra itemHeight: %d", Integer.valueOf(appBrandDesktopView.onI));
                            i2 += appBrandDesktopView.onI;
                        }
                    }
                    Log.i("MicroMsg.AppBrandDesktopView", "alvinluo computeRecyclerViewTotalHeight collection row: %d, myAppbrandEmptyItemHeight: %d", Integer.valueOf(i5), Integer.valueOf(appBrandDesktopView.ony));
                } else if (collectionDataSize <= 0) {
                    i2 = i4;
                } else if (appBrandDesktopView.onC) {
                    i2 = com.tencent.mm.cb.a.fromDPToPix(appBrandDesktopView.getContext(), 16) + appBrandDesktopView.getResources().getDimensionPixelSize(R.dimen.p6) + i4;
                } else {
                    i2 = appBrandDesktopView.onv + i4;
                    if (collectionDataSize % appBrandDesktopView.apM == 0) {
                        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo computeRecyclerViewTotalHeight add extra itemHeight2: %d", Integer.valueOf(appBrandDesktopView.onI));
                        i2 += appBrandDesktopView.onI;
                    }
                }
                Log.i("MicroMsg.AppBrandDesktopView", "alvinluo computeRecyclerViewTotalHeight dataList: %d, mMyAppBrandStartPosition: %d, itemCount: %d, hasAddCollectionEmptyItem: %b", Integer.valueOf(appBrandDesktopView.mDataList.size()), Integer.valueOf(appBrandDesktopView.one), Integer.valueOf(collectionDataSize), Boolean.valueOf(appBrandDesktopView.onC));
            } else {
                Log.i("MicroMsg.AppBrandDesktopView", "alvinluo computeRecyclerViewTotalHeight empty collection and add MyAppBrandEmptyViewHolder height");
                i2 = i3 + appBrandDesktopView.onw + appBrandDesktopView.mContext.getResources().getDimensionPixelSize(R.dimen.p6) + appBrandDesktopView.mContext.getResources().getDimensionPixelSize(R.dimen.hs);
            }
        } else {
            Log.i("MicroMsg.AppBrandDesktopView", "alvinluo computeRecyclerViewTotalHeight full empty");
            i2 = i3 + appBrandDesktopView.onx;
        }
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo computeRecyclerViewTotalHeight: %d", Integer.valueOf(i2));
        AppMethodBeat.o(49634);
        return i2;
    }

    static /* synthetic */ void q(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.i(49635);
        Log.d("MicroMsg.AppBrandDesktopView", "alvinluo resetSearchView first: %d, enableAlwaysShowSearchView: %b", Integer.valueOf(appBrandDesktopView.oni.kt()), Boolean.valueOf(appBrandDesktopView.onF));
        if ((appBrandDesktopView.ong || appBrandDesktopView.onf) && !appBrandDesktopView.onF) {
            appBrandDesktopView.jc(false);
            AppMethodBeat.o(49635);
            return;
        }
        appBrandDesktopView.jc(true);
        AppMethodBeat.o(49635);
    }

    static /* synthetic */ void a(AppBrandDesktopView appBrandDesktopView, int i2, final int i3, final LocalUsageInfo localUsageInfo, final int i4) {
        AppMethodBeat.i(227770);
        if (appBrandDesktopView.ooU) {
            Log.i("MicroMsg.AppBrandDesktopView", "alvinluo launchAppBrand long pressing return");
            AppMethodBeat.o(227770);
            return;
        }
        Log.v("MicroMsg.AppBrandDesktopView", "alvinluo launchAppBrand position: %d", Integer.valueOf(i4));
        final AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = i2;
        if (i3 == 1) {
            appBrandStatObject.dCw = "2:" + (i4 - appBrandDesktopView.one);
        } else {
            appBrandStatObject.dCw = "2:".concat(String.valueOf(i4));
        }
        if (localUsageInfo != null) {
            appBrandDesktopView.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(49569);
                    AppBrandDesktopView.a(AppBrandDesktopView.this, false);
                    AppBrandDesktopView.this.onP = 13;
                    i unused = AppBrandDesktopView.this.onc;
                    int unused2 = AppBrandDesktopView.this.onP;
                    ((r) com.tencent.mm.kernel.g.af(r.class)).a(AppBrandDesktopView.this.getContext(), localUsageInfo.username, localUsageInfo.appId, localUsageInfo.iOo, -1, (String) null, appBrandStatObject);
                    if (AppBrandDesktopView.this.onJ != null && !Util.isNullOrNil(localUsageInfo.appId)) {
                        if (i3 == 1) {
                            com.tencent.mm.plugin.appbrand.widget.recent.g gVar = AppBrandDesktopView.this.onJ;
                            String str = localUsageInfo.appId;
                            int i2 = (i4 - AppBrandDesktopView.this.one) + 1;
                            Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo openStarAppBrand id: %s, pos: %d", str, Integer.valueOf(i2));
                            gVar.oCy.append(str + ":");
                            gVar.oCB.append(i2 + ":");
                            AppMethodBeat.o(49569);
                            return;
                        }
                        com.tencent.mm.plugin.appbrand.widget.recent.g gVar2 = AppBrandDesktopView.this.onJ;
                        String str2 = localUsageInfo.appId;
                        int i3 = i4 + 1;
                        Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo openRecentAppBrand id: %s, pos: %d", str2, Integer.valueOf(i3));
                        gVar2.oCn.append(str2 + ":");
                        gVar2.oCp.append(i3 + ":");
                    }
                    AppMethodBeat.o(49569);
                }
            }, 100);
        }
        AppMethodBeat.o(227770);
    }

    static /* synthetic */ void a(AppBrandDesktopView appBrandDesktopView, final LocalUsageInfo localUsageInfo, final f fVar) {
        AppMethodBeat.i(227771);
        if (!appBrandDesktopView.iCn || appBrandDesktopView.ocu == 1) {
            fVar.dQ(true);
            AppMethodBeat.o(227771);
        } else if (localUsageInfo == null || Util.isNullOrNil(localUsageInfo.username)) {
            fVar.dQ(true);
            AppMethodBeat.o(227771);
        } else {
            WxaAttributes Xk = ((q) com.tencent.mm.kernel.g.af(q.class)).Xk(localUsageInfo.username);
            if (Xk != null) {
                fVar.dQ(appBrandDesktopView.a(localUsageInfo, Xk.bAn()));
                AppMethodBeat.o(227771);
                return;
            }
            ((q) com.tencent.mm.kernel.g.af(q.class)).a(localUsageInfo.username, new q.a() {
                /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.service.q.a
                public final void b(WxaAttributes wxaAttributes) {
                    AppMethodBeat.i(227755);
                    if (!(wxaAttributes == null || fVar == null)) {
                        fVar.dQ(AppBrandDesktopView.a(AppBrandDesktopView.this, localUsageInfo, wxaAttributes.bAn()));
                    }
                    AppMethodBeat.o(227755);
                }
            });
            AppMethodBeat.o(227771);
        }
    }

    static /* synthetic */ void c(AppBrandDesktopView appBrandDesktopView, View view) {
        AppMethodBeat.i(227772);
        if (view != null) {
            int dimensionPixelSize = appBrandDesktopView.getResources().getDimensionPixelSize(R.dimen.hv);
            int dimensionPixelSize2 = appBrandDesktopView.getResources().getDimensionPixelSize(R.dimen.hs);
            int i2 = appBrandDesktopView.onq;
            view.setPadding(i2, dimensionPixelSize, i2, dimensionPixelSize2);
            appBrandDesktopView.caD();
        }
        AppMethodBeat.o(227772);
    }

    static /* synthetic */ boolean K(AppBrandDesktopView appBrandDesktopView) {
        boolean z = false;
        AppMethodBeat.i(227773);
        if (appBrandDesktopView.oni != null) {
            if (appBrandDesktopView.oni.kv() == appBrandDesktopView.mDataList.size() - 1 && appBrandDesktopView.oni.ks() == 0) {
                z = true;
            }
            appBrandDesktopView.onr = z;
        } else {
            appBrandDesktopView.onr = false;
        }
        boolean z2 = appBrandDesktopView.onr;
        AppMethodBeat.o(227773);
        return z2;
    }

    static /* synthetic */ void M(AppBrandDesktopView appBrandDesktopView) {
        View childAt;
        AppMethodBeat.i(227774);
        if (appBrandDesktopView.oni != null) {
            int kt = appBrandDesktopView.oni.kt();
            int ks = appBrandDesktopView.oni.ks();
            if (kt == 1 && ks == 0 && (childAt = appBrandDesktopView.getChildAt(kt)) != null) {
                int top = childAt.getTop();
                appBrandDesktopView.ooc = true;
                if (((float) top) >= ((float) appBrandDesktopView.onE) * 0.5f) {
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(appBrandDesktopView, a2.axQ(), "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView", "scrollIfNeed", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                    appBrandDesktopView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(appBrandDesktopView, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView", "scrollIfNeed", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                    AppMethodBeat.o(227774);
                    return;
                }
                com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(appBrandDesktopView, a3.axQ(), "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView", "scrollIfNeed", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                appBrandDesktopView.smoothScrollToPosition(((Integer) a3.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(appBrandDesktopView, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView", "scrollIfNeed", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            }
        }
        AppMethodBeat.o(227774);
    }

    static /* synthetic */ void Q(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.i(227775);
        if (appBrandDesktopView.onJ != null) {
            com.tencent.mm.plugin.appbrand.widget.recent.g gVar = appBrandDesktopView.onJ;
            gVar.oCE++;
            Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo scrollUpDown %d", Integer.valueOf(gVar.oCE));
        }
        AppMethodBeat.o(227775);
    }

    static /* synthetic */ boolean R(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.i(227776);
        if (appBrandDesktopView.oni.kt() == 0) {
            AppMethodBeat.o(227776);
            return true;
        }
        AppMethodBeat.o(227776);
        return false;
    }
}
