package com.tencent.mm.plugin.finder.feed;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.view.manager.FinderAutoScrollLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u00102\u001a\u00020 H\u0002J\b\u00103\u001a\u00020 H\u0002J\u0006\u00104\u001a\u00020 J\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u000206J\u0006\u00108\u001a\u000206J\u0010\u00108\u001a\u0002062\u0006\u00109\u001a\u00020 H\u0002J\u0006\u0010:\u001a\u000206J\u0010\u0010;\u001a\u0002062\u0006\u0010<\u001a\u00020 H\u0002J\u0006\u0010=\u001a\u000206J\u0006\u0010>\u001a\u000206J\u0016\u0010?\u001a\u0002062\u0006\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u00020 R\u001e\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R#\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u000e\u0010(\u001a\u00020)X.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X.¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020.8BX\u0002¢\u0006\f\n\u0004\b1\u0010\u001b\u001a\u0004\b/\u00100¨\u0006B"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "", "parent", "Landroid/view/View;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "(Landroid/view/View;Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "bulletSubtitleLayout", "Landroid/widget/FrameLayout;", "bulletSubtitleRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getBulletSubtitleRv", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setBulletSubtitleRv", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "enterAnimator", "Landroid/animation/ValueAnimator;", "exitAnimator", "isEnterAnimRunning", "", "isFunctionTurnOn", "isPause", "()Z", "setPause", "(Z)V", "isStartLoop", "setStartLoop", "layoutManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderAutoScrollLayoutManager;", "needToRefresh", "restartRunnable", "Ljava/lang/Runnable;", "screenWidth", "", "getScreenWidth", "()I", "screenWidth$delegate", "checkAllAnimPause", "checkAllAnimResume", "getFunctionSwitch", "initView", "", "pause", "reset", "prepareForRestart", "resume", "showBulletSubtitleLayout", "isShow", "smoothScrollToLastPosition", "startLoop", "switchFunction", "isTurnOn", "needRefresh", "plugin-finder_release"})
public final class e {
    boolean dLD;
    final View hVd;
    private final kotlin.f tCY = kotlin.g.ah(new g(this));
    public WxRecyclerAdapter<?> tFp;
    FrameLayout tMA;
    private FinderAutoScrollLayoutManager tMB;
    ValueAnimator tMC;
    ValueAnimator tMD;
    Runnable tME;
    public boolean tMF;
    private boolean tMG = true;
    private boolean tMH;
    boolean tMI;
    private final d tMJ;
    private final kotlin.f tMy = kotlin.g.ah(new a(this));
    public WxRecyclerView tMz;

    private final Context getContext() {
        AppMethodBeat.i(243731);
        Context context = (Context) this.tMy.getValue();
        AppMethodBeat.o(243731);
        return context;
    }

    private final int getScreenWidth() {
        AppMethodBeat.i(243732);
        int intValue = ((Number) this.tCY.getValue()).intValue();
        AppMethodBeat.o(243732);
        return intValue;
    }

    public e(View view, d dVar) {
        p.h(view, "parent");
        p.h(dVar, "presenter");
        AppMethodBeat.i(243741);
        this.hVd = view;
        this.tMJ = dVar;
        AppMethodBeat.o(243741);
    }

    public final WxRecyclerView dcy() {
        AppMethodBeat.i(243733);
        WxRecyclerView wxRecyclerView = this.tMz;
        if (wxRecyclerView == null) {
            p.btv("bulletSubtitleRv");
        }
        AppMethodBeat.o(243733);
        return wxRecyclerView;
    }

    public final void initView() {
        AppMethodBeat.i(243734);
        View findViewById = this.hVd.findViewById(R.id.h9y);
        p.g(findViewById, "parent.findViewById<WxRe…(R.id.rv_bullet_subtitle)");
        this.tMz = (WxRecyclerView) findViewById;
        View findViewById2 = this.hVd.findViewById(R.id.afk);
        p.g(findViewById2, "parent.findViewById<Fram…d.bullet_subtitle_layout)");
        this.tMA = (FrameLayout) findViewById2;
        WxRecyclerView wxRecyclerView = this.tMz;
        if (wxRecyclerView == null) {
            p.btv("bulletSubtitleRv");
        }
        wxRecyclerView.setOnTouchListener(b.tML);
        d dVar = this.tMJ;
        Context context = getContext();
        p.g(context, "context");
        this.tFp = dVar.fm(context);
        WxRecyclerView wxRecyclerView2 = this.tMz;
        if (wxRecyclerView2 == null) {
            p.btv("bulletSubtitleRv");
        }
        WxRecyclerAdapter<?> wxRecyclerAdapter = this.tFp;
        if (wxRecyclerAdapter == null) {
            p.btv("adapter");
        }
        wxRecyclerView2.setAdapter(wxRecyclerAdapter);
        WxRecyclerView wxRecyclerView3 = this.tMz;
        if (wxRecyclerView3 == null) {
            p.btv("bulletSubtitleRv");
        }
        Context context2 = getContext();
        p.g(context2, "context");
        FinderAutoScrollLayoutManager finderAutoScrollLayoutManager = new FinderAutoScrollLayoutManager(context2);
        finderAutoScrollLayoutManager.setOrientation(0);
        wxRecyclerView3.setLayoutManager(finderAutoScrollLayoutManager);
        WxRecyclerView wxRecyclerView4 = this.tMz;
        if (wxRecyclerView4 == null) {
            p.btv("bulletSubtitleRv");
        }
        RecyclerView.LayoutManager layoutManager = wxRecyclerView4.getLayoutManager();
        if (layoutManager == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderAutoScrollLayoutManager");
            AppMethodBeat.o(243734);
            throw tVar;
        }
        this.tMB = (FinderAutoScrollLayoutManager) layoutManager;
        WxRecyclerView wxRecyclerView5 = this.tMz;
        if (wxRecyclerView5 == null) {
            p.btv("bulletSubtitleRv");
        }
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        Context context3 = getContext();
        if (context3 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(243734);
            throw tVar2;
        }
        wxRecyclerView5.setRecycledViewPool(((FinderRecyclerViewPool) com.tencent.mm.ui.component.a.b((MMActivity) context3).get(FinderRecyclerViewPool.class)).wuz);
        WxRecyclerView wxRecyclerView6 = this.tMz;
        if (wxRecyclerView6 == null) {
            p.btv("bulletSubtitleRv");
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(wxRecyclerView6, "translationX", (float) getScreenWidth(), 0.0f);
        p.g(ofFloat, "ObjectAnimator.ofFloat(b…creenWidth.toFloat(), 0f)");
        this.tMC = ofFloat;
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        ValueAnimator valueAnimator = this.tMC;
        if (valueAnimator == null) {
            p.btv("enterAnimator");
        }
        valueAnimator.setInterpolator(linearInterpolator);
        this.tME = new c(this);
        ValueAnimator valueAnimator2 = this.tMC;
        if (valueAnimator2 == null) {
            p.btv("enterAnimator");
        }
        valueAnimator2.addListener(new d(this));
        ValueAnimator valueAnimator3 = this.tMC;
        if (valueAnimator3 == null) {
            p.btv("enterAnimator");
        }
        valueAnimator3.setDuration(4000L);
        WxRecyclerView wxRecyclerView7 = this.tMz;
        if (wxRecyclerView7 == null) {
            p.btv("bulletSubtitleRv");
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(wxRecyclerView7, "translationX", 0.0f, -((float) getScreenWidth()));
        p.g(ofFloat2, "ObjectAnimator.ofFloat(b…, -screenWidth.toFloat())");
        this.tMD = ofFloat2;
        ValueAnimator valueAnimator4 = this.tMD;
        if (valueAnimator4 == null) {
            p.btv("exitAnimator");
        }
        valueAnimator4.setInterpolator(linearInterpolator);
        ValueAnimator valueAnimator5 = this.tMD;
        if (valueAnimator5 == null) {
            p.btv("exitAnimator");
        }
        valueAnimator5.addListener(new C1145e(this));
        ValueAnimator valueAnimator6 = this.tMD;
        if (valueAnimator6 == null) {
            p.btv("exitAnimator");
        }
        valueAnimator6.setDuration(4000L);
        WxRecyclerView wxRecyclerView8 = this.tMz;
        if (wxRecyclerView8 == null) {
            p.btv("bulletSubtitleRv");
        }
        wxRecyclerView8.a(new f(this));
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        this.tMG = aAh.azQ().getBoolean(ar.a.USERINFO_FINDER_FEED_BULLET_SUBTITLE_SWITCH_BOOLEAN, true);
        AppMethodBeat.o(243734);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    public static final class b implements View.OnTouchListener {
        public static final b tML = new b();

        static {
            AppMethodBeat.i(243723);
            AppMethodBeat.o(243723);
        }

        b() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ e tMK;

        c(e eVar) {
            this.tMK = eVar;
        }

        public final void run() {
            boolean z = true;
            AppMethodBeat.i(243724);
            if (this.tMK.dcy().getVisibility() == 0) {
                this.tMK.startLoop();
                if (this.tMK.dLD) {
                    e eVar = this.tMK;
                    eVar.dLD = true;
                    if (eVar.tMF) {
                        boolean z2 = false;
                        ValueAnimator valueAnimator = eVar.tMC;
                        if (valueAnimator == null) {
                            p.btv("enterAnimator");
                        }
                        if (valueAnimator.isRunning()) {
                            ValueAnimator valueAnimator2 = eVar.tMC;
                            if (valueAnimator2 == null) {
                                p.btv("enterAnimator");
                            }
                            valueAnimator2.pause();
                            z2 = true;
                        }
                        ValueAnimator valueAnimator3 = eVar.tMD;
                        if (valueAnimator3 == null) {
                            p.btv("exitAnimator");
                        }
                        if (valueAnimator3.isRunning()) {
                            ValueAnimator valueAnimator4 = eVar.tMD;
                            if (valueAnimator4 == null) {
                                p.btv("exitAnimator");
                            }
                            valueAnimator4.pause();
                        } else {
                            z = z2;
                        }
                        if (!z) {
                            WxRecyclerView wxRecyclerView = eVar.tMz;
                            if (wxRecyclerView == null) {
                                p.btv("bulletSubtitleRv");
                            }
                            wxRecyclerView.kQ();
                        }
                    }
                }
            }
            AppMethodBeat.o(243724);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$4", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
    public static final class d extends AnimatorListenerAdapter {
        final /* synthetic */ e tMK;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(e eVar) {
            this.tMK = eVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(243725);
            this.tMK.tMI = false;
            if (this.tMK.dcy().getVisibility() != 0) {
                AppMethodBeat.o(243725);
                return;
            }
            this.tMK.dcz();
            AppMethodBeat.o(243725);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$5", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.feed.e$e  reason: collision with other inner class name */
    public static final class C1145e extends AnimatorListenerAdapter {
        final /* synthetic */ e tMK;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1145e(e eVar) {
            this.tMK = eVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(243726);
            this.tMK.reset(true);
            WxRecyclerView dcy = this.tMK.dcy();
            Runnable runnable = this.tMK.tME;
            if (runnable == null) {
                p.btv("restartRunnable");
            }
            dcy.postDelayed(runnable, 5000);
            AppMethodBeat.o(243726);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
    public static final class f extends RecyclerView.l {
        final /* synthetic */ e tMK;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(243728);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(243728);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(e eVar) {
            this.tMK = eVar;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(243727);
            p.h(recyclerView, "recyclerView");
            if (i2 == 0) {
                if (recyclerView.getVisibility() == 8 || !this.tMK.tMF || this.tMK.dLD) {
                    AppMethodBeat.o(243727);
                    return;
                }
                this.tMK.dcz();
            }
            AppMethodBeat.o(243727);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void L(boolean r8, boolean r9) {
        /*
        // Method dump skipped, instructions count: 155
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.e.L(boolean, boolean):void");
    }

    public final boolean getFunctionSwitch() {
        AppMethodBeat.i(243736);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        this.tMG = aAh.azQ().getBoolean(ar.a.USERINFO_FINDER_FEED_BULLET_SUBTITLE_SWITCH_BOOLEAN, true);
        boolean z = this.tMG;
        AppMethodBeat.o(243736);
        return z;
    }

    public final void startLoop() {
        int i2;
        int i3;
        AppMethodBeat.i(243737);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(ad.class);
        p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (((ad) af).dxX()) {
            AppMethodBeat.o(243737);
            return;
        }
        FeedData feedData = this.tMJ.feed;
        if (feedData != null) {
            com.tencent.mm.plugin.finder.report.c cVar = com.tencent.mm.plugin.finder.report.c.vdc;
            com.tencent.mm.plugin.finder.report.c.start(feedData.getId());
        }
        if (!this.tMF) {
            WxRecyclerView wxRecyclerView = this.tMz;
            if (wxRecyclerView == null) {
                p.btv("bulletSubtitleRv");
            }
            RecyclerView.a adapter = wxRecyclerView.getAdapter();
            if (adapter == null) {
                p.hyc();
            }
            p.g(adapter, "bulletSubtitleRv.adapter!!");
            if (adapter.getItemCount() > 0) {
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                p.g(aAh, "MMKernel.storage()");
                if (!aAh.azQ().getBoolean(ar.a.USERINFO_FINDER_FEED_BULLET_SUBTITLE_SWITCH_BOOLEAN, true)) {
                    this.tMG = false;
                    FeedData feedData2 = this.tMJ.feed;
                    if (feedData2 != null) {
                        com.tencent.mm.plugin.finder.report.c cVar2 = com.tencent.mm.plugin.finder.report.c.vdc;
                        long id = feedData2.getId();
                        if (this.tMG) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        com.tencent.mm.plugin.finder.report.c.F(id, i3);
                        AppMethodBeat.o(243737);
                        return;
                    }
                    AppMethodBeat.o(243737);
                    return;
                }
                this.tMG = true;
                WxRecyclerAdapter<?> wxRecyclerAdapter = this.tFp;
                if (wxRecyclerAdapter == null) {
                    p.btv("adapter");
                }
                wxRecyclerAdapter.notifyDataSetChanged();
                FeedData feedData3 = this.tMJ.feed;
                if (feedData3 != null) {
                    com.tencent.mm.plugin.finder.report.c cVar3 = com.tencent.mm.plugin.finder.report.c.vdc;
                    com.tencent.mm.plugin.finder.report.c.EV(feedData3.getId());
                    com.tencent.mm.plugin.finder.report.c cVar4 = com.tencent.mm.plugin.finder.report.c.vdc;
                    long id2 = feedData3.getId();
                    WxRecyclerAdapter<?> wxRecyclerAdapter2 = this.tFp;
                    if (wxRecyclerAdapter2 == null) {
                        p.btv("adapter");
                    }
                    com.tencent.mm.plugin.finder.report.c.E(id2, (wxRecyclerAdapter2 != null ? Integer.valueOf(wxRecyclerAdapter2.getItemCount()) : null).intValue());
                    com.tencent.mm.plugin.finder.report.c cVar5 = com.tencent.mm.plugin.finder.report.c.vdc;
                    long id3 = feedData3.getId();
                    if (this.tMG) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    com.tencent.mm.plugin.finder.report.c.F(id3, i2);
                }
                WxRecyclerView wxRecyclerView2 = this.tMz;
                if (wxRecyclerView2 == null) {
                    p.btv("bulletSubtitleRv");
                }
                wxRecyclerView2.setTranslationX((float) getScreenWidth());
                WxRecyclerView wxRecyclerView3 = this.tMz;
                if (wxRecyclerView3 == null) {
                    p.btv("bulletSubtitleRv");
                }
                wxRecyclerView3.setVisibility(0);
                mV(true);
                ValueAnimator valueAnimator = this.tMC;
                if (valueAnimator == null) {
                    p.btv("enterAnimator");
                }
                valueAnimator.start();
                this.tMI = true;
                this.tMF = true;
                this.dLD = false;
                AppMethodBeat.o(243737);
                return;
            }
        }
        AppMethodBeat.o(243737);
    }

    public final void reset(boolean z) {
        AppMethodBeat.i(243738);
        this.tMF = false;
        this.dLD = false;
        this.tMJ.dcx();
        WxRecyclerView wxRecyclerView = this.tMz;
        if (wxRecyclerView == null) {
            p.btv("bulletSubtitleRv");
        }
        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "reset", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
        wxRecyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "reset", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
        if (!z) {
            mV(false);
            WxRecyclerView wxRecyclerView2 = this.tMz;
            if (wxRecyclerView2 == null) {
                p.btv("bulletSubtitleRv");
            }
            wxRecyclerView2.setVisibility(8);
            WxRecyclerView wxRecyclerView3 = this.tMz;
            if (wxRecyclerView3 == null) {
                p.btv("bulletSubtitleRv");
            }
            Runnable runnable = this.tME;
            if (runnable == null) {
                p.btv("restartRunnable");
            }
            wxRecyclerView3.removeCallbacks(runnable);
        }
        this.tMI = false;
        ValueAnimator valueAnimator = this.tMC;
        if (valueAnimator == null) {
            p.btv("enterAnimator");
        }
        valueAnimator.cancel();
        ValueAnimator valueAnimator2 = this.tMD;
        if (valueAnimator2 == null) {
            p.btv("exitAnimator");
        }
        valueAnimator2.cancel();
        AppMethodBeat.o(243738);
    }

    public final void dcz() {
        AppMethodBeat.i(243739);
        if (this.dLD || !this.tMF || this.tMI) {
            AppMethodBeat.o(243739);
            return;
        }
        WxRecyclerView wxRecyclerView = this.tMz;
        if (wxRecyclerView == null) {
            p.btv("bulletSubtitleRv");
        }
        if (!wxRecyclerView.canScrollHorizontally(1)) {
            ValueAnimator valueAnimator = this.tMD;
            if (valueAnimator == null) {
                p.btv("exitAnimator");
            }
            valueAnimator.start();
            AppMethodBeat.o(243739);
            return;
        }
        WxRecyclerView wxRecyclerView2 = this.tMz;
        if (wxRecyclerView2 == null) {
            p.btv("bulletSubtitleRv");
        }
        WxRecyclerView wxRecyclerView3 = this.tMz;
        if (wxRecyclerView3 == null) {
            p.btv("bulletSubtitleRv");
        }
        RecyclerView.a adapter = wxRecyclerView3.getAdapter();
        if (adapter == null) {
            p.hyc();
        }
        p.g(adapter, "bulletSubtitleRv.adapter!!");
        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(adapter.getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView2, a2.axQ(), "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "smoothScrollToLastPosition", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        wxRecyclerView2.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView2, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "smoothScrollToLastPosition", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        AppMethodBeat.o(243739);
    }

    private final void mV(boolean z) {
        AppMethodBeat.i(243740);
        if (z) {
            FrameLayout frameLayout = this.tMA;
            if (frameLayout == null) {
                p.btv("bulletSubtitleLayout");
            }
            frameLayout.animate().cancel();
            FrameLayout frameLayout2 = this.tMA;
            if (frameLayout2 == null) {
                p.btv("bulletSubtitleLayout");
            }
            frameLayout2.setAlpha(0.0f);
            FrameLayout frameLayout3 = this.tMA;
            if (frameLayout3 == null) {
                p.btv("bulletSubtitleLayout");
            }
            frameLayout3.animate().alpha(1.0f).setDuration(300).withStartAction(new h(this)).start();
            AppMethodBeat.o(243740);
            return;
        }
        FrameLayout frameLayout4 = this.tMA;
        if (frameLayout4 == null) {
            p.btv("bulletSubtitleLayout");
        }
        frameLayout4.animate().cancel();
        FrameLayout frameLayout5 = this.tMA;
        if (frameLayout5 == null) {
            p.btv("bulletSubtitleLayout");
        }
        frameLayout5.setAlpha(1.0f);
        FrameLayout frameLayout6 = this.tMA;
        if (frameLayout6 == null) {
            p.btv("bulletSubtitleLayout");
        }
        frameLayout6.setVisibility(8);
        AppMethodBeat.o(243740);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class h implements Runnable {
        final /* synthetic */ e tMK;

        h(e eVar) {
            this.tMK = eVar;
        }

        public final void run() {
            AppMethodBeat.i(243730);
            FrameLayout frameLayout = this.tMK.tMA;
            if (frameLayout == null) {
                p.btv("bulletSubtitleLayout");
            }
            frameLayout.setVisibility(0);
            AppMethodBeat.o(243730);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a extends q implements kotlin.g.a.a<Context> {
        final /* synthetic */ e tMK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(e eVar) {
            super(0);
            this.tMK = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Context invoke() {
            AppMethodBeat.i(243722);
            Context context = this.tMK.hVd.getContext();
            AppMethodBeat.o(243722);
            return context;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ e tMK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(e eVar) {
            super(0);
            this.tMK = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(243729);
            Integer valueOf = Integer.valueOf(au.az(this.tMK.hVd.getContext()).x);
            AppMethodBeat.o(243729);
            return valueOf;
        }
    }
}
