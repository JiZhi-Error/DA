package com.tencent.mm.view.drawer;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.HeadFooterLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

public final class RecyclerViewDrawerSquares extends LinearLayout implements com.tencent.mm.ui.tools.g, HeadFooterLayout.b {
    public static final a Ror = new a((byte) 0);
    private com.tencent.mm.ui.tools.g Roc;
    private c Roe;
    private RefreshLoadMoreLayout Roi;
    private FrameLayout Roj;
    private FrameLayout Rok;
    private List<View> Rol = new ArrayList();
    boolean Rom;
    private boolean Ron;
    private b Roo;
    private final kotlin.g.a.b<kotlin.g.a.a<x>, x> Rop;
    private boolean Roq;
    private com.tencent.mm.ui.tools.h gyh;
    private FrameLayout wrT;
    private boolean xfU;

    public interface b {
        void hgf();
    }

    public interface c {
        void S(boolean z, boolean z2);

        void bo(float f2);

        void dHu();
    }

    static {
        AppMethodBeat.i(164699);
        AppMethodBeat.o(164699);
    }

    public static final class g extends q implements kotlin.g.a.a<x> {
        public static final g Rou = new g();

        static {
            AppMethodBeat.i(164673);
            AppMethodBeat.o(164673);
        }

        g() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class h extends q implements kotlin.g.a.b<kotlin.g.a.a<? extends x>, x> {
        final /* synthetic */ RecyclerViewDrawerSquares Rot;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(RecyclerViewDrawerSquares recyclerViewDrawerSquares) {
            super(1);
            this.Rot = recyclerViewDrawerSquares;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(kotlin.g.a.a<? extends x> aVar) {
            AppMethodBeat.i(164676);
            final kotlin.g.a.a<? extends x> aVar2 = aVar;
            p.h(aVar2, LocaleUtil.ITALIAN);
            if (!this.Rot.Rom) {
                this.Rot.clearAnimation();
                this.Rot.animate().cancel();
                this.Rot.animate().setInterpolator(new DecelerateInterpolator(1.5f)).translationY(0.0f).withEndAction(new Runnable() {
                    /* class com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.h.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(164674);
                        aVar2.invoke();
                        AppMethodBeat.o(164674);
                    }
                }).setUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
                    /* class com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.h.AnonymousClass2 */
                    final /* synthetic */ h Row;

                    {
                        this.Row = r1;
                    }

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(164675);
                        Log.d("DrawerSquares", "[openDrawer] setUpdateListener height:" + this.Row.Rot.getHeight() + ", translationY:" + this.Row.Rot.getTranslationY());
                        c onOpenDrawerListener = this.Row.Rot.getOnOpenDrawerListener();
                        if (onOpenDrawerListener != null) {
                            onOpenDrawerListener.bo((1.0f * this.Row.Rot.getTranslationY()) / ((float) this.Row.Rot.getHeight()));
                            AppMethodBeat.o(164675);
                            return;
                        }
                        AppMethodBeat.o(164675);
                    }
                }).setDuration(300).start();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(164676);
            return xVar;
        }
    }

    public RecyclerViewDrawerSquares(Context context) {
        super(context);
        AppMethodBeat.i(164696);
        Context context2 = getContext();
        if (context2 == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(164696);
            throw tVar;
        }
        this.gyh = new com.tencent.mm.ui.tools.h((Activity) context2);
        this.Rop = new h(this);
        setOrientation(1);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bm4, this);
        View findViewById = inflate.findViewById(R.id.gyl);
        p.g(findViewById, "view.findViewById(R.id.refresh_load_more_layout)");
        this.Roi = (RefreshLoadMoreLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.gca);
        p.g(findViewById2, "view.findViewById(R.id.placeholder_drawer_header)");
        this.Rok = (FrameLayout) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.gc_);
        p.g(findViewById3, "view.findViewById(R.id.placeholder_drawer_footer)");
        this.Roj = (FrameLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.gcb);
        p.g(findViewById4, "view.findViewById(R.id.placeholder_loading_layout)");
        this.wrT = (FrameLayout) findViewById4;
        this.Roi.setOverCallback(this);
        setVisibility(8);
        this.gyh.setKeyboardHeightObserver(this);
        setOnClickListener(AnonymousClass1.Ros);
        AppMethodBeat.o(164696);
    }

    public RecyclerViewDrawerSquares(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(164697);
        Context context2 = getContext();
        if (context2 == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(164697);
            throw tVar;
        }
        this.gyh = new com.tencent.mm.ui.tools.h((Activity) context2);
        this.Rop = new h(this);
        setOrientation(1);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bm4, this);
        View findViewById = inflate.findViewById(R.id.gyl);
        p.g(findViewById, "view.findViewById(R.id.refresh_load_more_layout)");
        this.Roi = (RefreshLoadMoreLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.gca);
        p.g(findViewById2, "view.findViewById(R.id.placeholder_drawer_header)");
        this.Rok = (FrameLayout) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.gc_);
        p.g(findViewById3, "view.findViewById(R.id.placeholder_drawer_footer)");
        this.Roj = (FrameLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.gcb);
        p.g(findViewById4, "view.findViewById(R.id.placeholder_loading_layout)");
        this.wrT = (FrameLayout) findViewById4;
        this.Roi.setOverCallback(this);
        setVisibility(8);
        this.gyh.setKeyboardHeightObserver(this);
        setOnClickListener(AnonymousClass1.Ros);
        AppMethodBeat.o(164697);
    }

    public RecyclerViewDrawerSquares(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(164698);
        Context context2 = getContext();
        if (context2 == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(164698);
            throw tVar;
        }
        this.gyh = new com.tencent.mm.ui.tools.h((Activity) context2);
        this.Rop = new h(this);
        setOrientation(1);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bm4, this);
        View findViewById = inflate.findViewById(R.id.gyl);
        p.g(findViewById, "view.findViewById(R.id.refresh_load_more_layout)");
        this.Roi = (RefreshLoadMoreLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.gca);
        p.g(findViewById2, "view.findViewById(R.id.placeholder_drawer_header)");
        this.Rok = (FrameLayout) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.gc_);
        p.g(findViewById3, "view.findViewById(R.id.placeholder_drawer_footer)");
        this.Roj = (FrameLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.gcb);
        p.g(findViewById4, "view.findViewById(R.id.placeholder_loading_layout)");
        this.wrT = (FrameLayout) findViewById4;
        this.Roi.setOverCallback(this);
        setVisibility(8);
        this.gyh.setKeyboardHeightObserver(this);
        setOnClickListener(AnonymousClass1.Ros);
        AppMethodBeat.o(164698);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final com.tencent.mm.ui.tools.g getKeyboardHeightObserver() {
        return this.Roc;
    }

    public final void setKeyboardHeightObserver(com.tencent.mm.ui.tools.g gVar) {
        this.Roc = gVar;
    }

    public final RefreshLoadMoreLayout getCenterLayout() {
        return this.Roi;
    }

    public final void setCenterLayout(RefreshLoadMoreLayout refreshLoadMoreLayout) {
        AppMethodBeat.i(164681);
        p.h(refreshLoadMoreLayout, "<set-?>");
        this.Roi = refreshLoadMoreLayout;
        AppMethodBeat.o(164681);
    }

    public final FrameLayout getDrawerFooterLayout() {
        return this.Roj;
    }

    public final void setDrawerFooterLayout(FrameLayout frameLayout) {
        AppMethodBeat.i(164682);
        p.h(frameLayout, "<set-?>");
        this.Roj = frameLayout;
        AppMethodBeat.o(164682);
    }

    public final FrameLayout getDrawerHeaderLayout() {
        return this.Rok;
    }

    public final void setDrawerHeaderLayout(FrameLayout frameLayout) {
        AppMethodBeat.i(164683);
        p.h(frameLayout, "<set-?>");
        this.Rok = frameLayout;
        AppMethodBeat.o(164683);
    }

    public final List<View> getIgnoreInterceptViewList() {
        return this.Rol;
    }

    public final void setIgnoreInterceptViewList(List<View> list) {
        AppMethodBeat.i(205022);
        p.h(list, "<set-?>");
        this.Rol = list;
        AppMethodBeat.o(205022);
    }

    public final FrameLayout getLoadingLayout() {
        return this.wrT;
    }

    public final void setLoadingLayout(FrameLayout frameLayout) {
        AppMethodBeat.i(164684);
        p.h(frameLayout, "<set-?>");
        this.wrT = frameLayout;
        AppMethodBeat.o(164684);
    }

    public final void setClosing(boolean z) {
        this.Rom = z;
    }

    public final void setOpening(boolean z) {
        this.Ron = z;
    }

    public final c getOnOpenDrawerListener() {
        return this.Roe;
    }

    public final void setOnOpenDrawerListener(c cVar) {
        this.Roe = cVar;
    }

    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        b bVar;
        AppMethodBeat.i(164685);
        super.onLayout(z, i2, i3, i4, i5);
        if (!z || (bVar = this.Roo) == null) {
            AppMethodBeat.o(164685);
            return;
        }
        bVar.hgf();
        AppMethodBeat.o(164685);
    }

    public final RecyclerView getRecyclerView() {
        AppMethodBeat.i(164686);
        RecyclerView recyclerView = this.Roi.getRecyclerView();
        AppMethodBeat.o(164686);
        return recyclerView;
    }

    public final void bi(boolean z, boolean z2) {
        AppMethodBeat.i(205023);
        Log.i("DrawerSquares", "[openDrawer] isOpening=" + this.Ron + ", canCloseDrawerWhenStop=" + z2);
        if (!this.Ron) {
            setCanCloseDrawerWhenStop(z2);
            this.gyh.start();
            c cVar = this.Roe;
            if (cVar != null) {
                cVar.S(true, true);
            }
            this.Ron = true;
            if (!z) {
                setTranslationY(0.0f);
                this.Ron = false;
                c cVar2 = this.Roe;
                if (cVar2 != null) {
                    cVar2.S(true, false);
                }
            } else if (((float) getHeight()) <= 0.0f) {
                this.Roo = new i(this);
            } else {
                setTranslationY((float) getHeight());
                this.Rop.invoke(new j(this));
            }
            setVisibility(0);
        }
        AppMethodBeat.o(205023);
    }

    public static final class i implements b {
        final /* synthetic */ RecyclerViewDrawerSquares Rot;

        i(RecyclerViewDrawerSquares recyclerViewDrawerSquares) {
            this.Rot = recyclerViewDrawerSquares;
        }

        @Override // com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.b
        public final void hgf() {
            AppMethodBeat.i(164679);
            Log.d("DrawerSquares", "[openDrawer] onLayoutChange height:" + this.Rot.getHeight());
            this.Rot.Roo = null;
            this.Rot.setTranslationY((float) this.Rot.getHeight());
            this.Rot.post(new a(this));
            AppMethodBeat.o(164679);
        }

        /* access modifiers changed from: package-private */
        public static final class a implements Runnable {
            final /* synthetic */ i Rox;

            a(i iVar) {
                this.Rox = iVar;
            }

            public final void run() {
                AppMethodBeat.i(164678);
                this.Rox.Rot.Rop.invoke(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.i.a.AnonymousClass1 */
                    final /* synthetic */ a Roy;

                    {
                        this.Roy = r2;
                    }

                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(164677);
                        this.Roy.Rox.Rot.setOpening(false);
                        c onOpenDrawerListener = this.Roy.Rox.Rot.getOnOpenDrawerListener();
                        if (onOpenDrawerListener != null) {
                            onOpenDrawerListener.S(true, false);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(164677);
                        return xVar;
                    }
                });
                AppMethodBeat.o(164678);
            }
        }
    }

    public static /* synthetic */ void a(RecyclerViewDrawerSquares recyclerViewDrawerSquares) {
        AppMethodBeat.i(164688);
        recyclerViewDrawerSquares.DG(true);
        AppMethodBeat.o(164688);
    }

    public final void DG(boolean z) {
        long j2;
        AppMethodBeat.i(164687);
        Log.i("DrawerSquares", "closeDrawer isClosing " + this.Rom + ", isWithAnim " + z);
        if (!this.Rom) {
            Context context = getContext();
            if (!(context instanceof MMFragmentActivity)) {
                context = null;
            }
            MMFragmentActivity mMFragmentActivity = (MMFragmentActivity) context;
            if (mMFragmentActivity != null) {
                mMFragmentActivity.hideVKB();
            }
            this.Rom = true;
            this.Ron = false;
            c cVar = this.Roe;
            if (cVar != null) {
                cVar.S(false, true);
            }
            if (z) {
                clearAnimation();
                animate().cancel();
                ViewPropertyAnimator updateListener = animate().setInterpolator(new DecelerateInterpolator(1.5f)).translationY((float) getHeight()).setDuration(300).withEndAction(new d(this)).setUpdateListener(new e(this));
                if (this.xfU) {
                    j2 = 200;
                } else {
                    j2 = 0;
                }
                updateListener.setStartDelay(j2).start();
                AppMethodBeat.o(164687);
                return;
            }
            clearAnimation();
            animate().cancel();
            animate().alpha(0.0f).setDuration(300).withEndAction(new f(this));
        }
        AppMethodBeat.o(164687);
    }

    public static final class d implements Runnable {
        final /* synthetic */ RecyclerViewDrawerSquares Rot;

        d(RecyclerViewDrawerSquares recyclerViewDrawerSquares) {
            this.Rot = recyclerViewDrawerSquares;
        }

        public final void run() {
            AppMethodBeat.i(164670);
            this.Rot.setVisibility(8);
            this.Rot.setClosing(false);
            c onOpenDrawerListener = this.Rot.getOnOpenDrawerListener();
            if (onOpenDrawerListener != null) {
                onOpenDrawerListener.S(false, false);
            }
            this.Rot.gyh.close();
            this.Rot.xfU = false;
            com.tencent.mm.ui.tools.g keyboardHeightObserver = this.Rot.getKeyboardHeightObserver();
            if (keyboardHeightObserver != null) {
                keyboardHeightObserver.y(0, false);
                AppMethodBeat.o(164670);
                return;
            }
            AppMethodBeat.o(164670);
        }
    }

    public static final class e implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ RecyclerViewDrawerSquares Rot;

        e(RecyclerViewDrawerSquares recyclerViewDrawerSquares) {
            this.Rot = recyclerViewDrawerSquares;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(164671);
            Log.d("DrawerSquares", "[closeDrawer] setUpdateListener height:" + this.Rot.getHeight() + ", translationY:" + this.Rot.getTranslationY());
            c onOpenDrawerListener = this.Rot.getOnOpenDrawerListener();
            if (onOpenDrawerListener != null) {
                onOpenDrawerListener.bo((1.0f * this.Rot.getTranslationY()) / ((float) this.Rot.getHeight()));
                AppMethodBeat.o(164671);
                return;
            }
            AppMethodBeat.o(164671);
        }
    }

    public static final class f implements Runnable {
        final /* synthetic */ RecyclerViewDrawerSquares Rot;

        f(RecyclerViewDrawerSquares recyclerViewDrawerSquares) {
            this.Rot = recyclerViewDrawerSquares;
        }

        public final void run() {
            AppMethodBeat.i(164672);
            this.Rot.setAlpha(1.0f);
            this.Rot.setTranslationY((float) this.Rot.getHeight());
            this.Rot.setVisibility(8);
            this.Rot.xfU = false;
            this.Rot.setClosing(false);
            c onOpenDrawerListener = this.Rot.getOnOpenDrawerListener();
            if (onOpenDrawerListener != null) {
                onOpenDrawerListener.S(false, false);
            }
            this.Rot.gyh.close();
            com.tencent.mm.ui.tools.g keyboardHeightObserver = this.Rot.getKeyboardHeightObserver();
            if (keyboardHeightObserver != null) {
                keyboardHeightObserver.y(0, false);
                AppMethodBeat.o(164672);
                return;
            }
            AppMethodBeat.o(164672);
        }
    }

    @Override // com.tencent.mm.ui.tools.g
    public final void y(int i2, boolean z) {
        AppMethodBeat.i(164689);
        this.xfU = i2 > 0;
        com.tencent.mm.ui.tools.g gVar = this.Roc;
        if (gVar != null) {
            gVar.y(i2, z);
            AppMethodBeat.o(164689);
            return;
        }
        AppMethodBeat.o(164689);
    }

    public final void onAttachedToWindow() {
        AppMethodBeat.i(164690);
        super.onAttachedToWindow();
        if (getContext() instanceof Activity) {
            Context context = getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(164690);
                throw tVar;
            }
            ((Activity) context).getWindow().setSoftInputMode(48);
        }
        AppMethodBeat.o(164690);
    }

    public final void onDetachedFromWindow() {
        AppMethodBeat.i(164691);
        super.onDetachedFromWindow();
        this.gyh.close();
        AppMethodBeat.o(164691);
    }

    public final void setTranslationY(float f2) {
        AppMethodBeat.i(164692);
        super.setTranslationY(f2);
        c cVar = this.Roe;
        if (cVar != null) {
            cVar.bo((1.0f * f2) / ((float) getHeight()));
            AppMethodBeat.o(164692);
            return;
        }
        AppMethodBeat.o(164692);
    }

    public final boolean getCanCloseDrawerWhenStop() {
        return this.Roq;
    }

    public final void setCanCloseDrawerWhenStop(boolean z) {
        AppMethodBeat.i(164693);
        this.Roq = z;
        Log.i("DrawerSquares", "lxl set canCloseDrawerWhenStop " + z + ' ');
        AppMethodBeat.o(164693);
    }

    @Override // com.tencent.mm.view.HeadFooterLayout.b
    public final void ddr() {
        AppMethodBeat.i(164694);
        if (getTranslationY() < 0.25f * ((float) getHeight())) {
            this.Rop.invoke(g.Rou);
        } else if (this.Roq) {
            DG(true);
            AppMethodBeat.o(164694);
            return;
        }
        AppMethodBeat.o(164694);
    }

    @Override // com.tencent.mm.view.HeadFooterLayout.b
    public final boolean u(int i2, int i3, boolean z) {
        AppMethodBeat.i(164695);
        if (this.Rom || this.Ron) {
            AppMethodBeat.o(164695);
            return true;
        } else if (i3 == 1 && !z) {
            AppMethodBeat.o(164695);
            return false;
        } else if ((z || (!z && i2 < 0)) && this.Roq) {
            setTranslationY(android.support.v4.b.a.p(getTranslationY() - ((float) i2), 0.0f, (float) getHeight()));
            AppMethodBeat.o(164695);
            return true;
        } else {
            AppMethodBeat.o(164695);
            return false;
        }
    }

    @Override // com.tencent.mm.view.HeadFooterLayout.b
    public final boolean IJ(int i2) {
        return false;
    }

    public static final class j extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ RecyclerViewDrawerSquares Rot;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(RecyclerViewDrawerSquares recyclerViewDrawerSquares) {
            super(0);
            this.Rot = recyclerViewDrawerSquares;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(164680);
            this.Rot.setOpening(false);
            x xVar = x.SXb;
            AppMethodBeat.o(164680);
            return xVar;
        }
    }
}
