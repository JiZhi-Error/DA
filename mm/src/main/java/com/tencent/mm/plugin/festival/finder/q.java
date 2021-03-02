package com.tencent.mm.plugin.festival.finder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.festival.c.j;
import com.tencent.mm.plugin.festival.finder.k;
import com.tencent.mm.plugin.festival.finder.w;
import com.tencent.mm.ui.base.u;
import java.util.Calendar;
import kotlin.g.b.aa;
import kotlin.g.b.n;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u001a\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016JK\u0010\u001d\u001a\u00020\u001c2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u001c0\u001f2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001c0%2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001c0%H\u0002J\u0012\u0010'\u001a\u00020\u001c2\b\b\u0002\u0010(\u001a\u00020\u0016H\u0002J\b\u0010)\u001a\u00020\u0016H\u0016J\b\u0010*\u001a\u00020\u0016H\u0002J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u001cH\u0017J\u0016\u0010/\u001a\u00020\u001c2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001c0%H\u0002J\u0016\u00101\u001a\u00020\u001c2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001c0%H\u0002J\b\u00102\u001a\u00020\u001cH\u0002J\u001a\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0010*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u0010*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u0010*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveCanvasHandDrawSharePlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalLiveCanvasClickInterceptorPlugin;", "root", "Landroid/view/ViewGroup;", "canvasPresenter", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasViewContract$Presenter;", "pluginLayoutPresenter", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveContract$Presenter;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasViewContract$Presenter;Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveContract$Presenter;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "btnGroup", "Landroid/view/View;", "calender", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "cancelBtn", "enterAnimator", "Landroid/view/ViewPropertyAnimator;", "exitAnimator", "inHandDrawMode", "", "saveBtn", "shareFriendBtn", "shareSNSBtn", "canClearScreen", "clearScreen", "", "doShare", "shareLogicBlock", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", "bitmap", "onSuccess", "Lkotlin/Function0;", "onError", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "keepHandDrawMode", "onBackPress", "onFairyWandDrawEnd", "onInterceptCanvasClick", "pointF", "Landroid/graphics/PointF;", "recoveryScreen", "runEnterAnimation", "onEnd", "runExitAnimation", "show", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-festival_release"})
public final class q extends p implements bn {
    private final View COK;
    private final View CYY;
    private final k.a Uqk;
    private final View UrZ;
    private final View Usa;
    private final Calendar Usb;
    private boolean Usc;
    private ViewPropertyAnimator Usd;
    private ViewPropertyAnimator Use;
    private final w.a Usf;
    private final com.tencent.mm.live.c.b hOp;
    private final View uGB;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final /* synthetic */ class a extends n implements kotlin.g.a.a<Boolean> {
        a(q qVar) {
            super(0, qVar);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(262180);
            kotlin.l.b bp = aa.bp(q.class);
            AppMethodBeat.o(262180);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "onFairyWandDrawEnd";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "onFairyWandDrawEnd()Z";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(262179);
            Boolean valueOf = Boolean.valueOf(q.a((q) this.SYl));
            AppMethodBeat.o(262179);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final b Usg = new b();

        static {
            AppMethodBeat.i(262181);
            AppMethodBeat.o(262181);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final c Ush = new c();

        static {
            AppMethodBeat.i(262182);
            AppMethodBeat.o(262182);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final /* synthetic */ class d extends n implements kotlin.g.a.a<Boolean> {
        d(q qVar) {
            super(0, qVar);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(262184);
            kotlin.l.b bp = aa.bp(q.class);
            AppMethodBeat.o(262184);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "onFairyWandDrawEnd";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "onFairyWandDrawEnd()Z";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(262183);
            Boolean valueOf = Boolean.valueOf(q.a((q) this.SYl));
            AppMethodBeat.o(262183);
            return valueOf;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(ViewGroup viewGroup, k.a aVar, w.a aVar2, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(aVar, "canvasPresenter");
        p.h(aVar2, "pluginLayoutPresenter");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(262207);
        this.Uqk = aVar;
        this.Usf = aVar2;
        this.hOp = bVar;
        View findViewById = viewGroup.findViewById(R.id.jtl);
        if (findViewById == null) {
            p.hyc();
        }
        this.uGB = findViewById;
        this.COK = viewGroup.findViewById(R.id.h__);
        this.UrZ = viewGroup.findViewById(R.id.k2e);
        this.Usa = viewGroup.findViewById(R.id.k2g);
        this.CYY = viewGroup.findViewById(R.id.aib);
        this.Usb = Calendar.getInstance();
        AppMethodBeat.o(262207);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/festival/util/FestivalViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-festival_release", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCanvasHandDrawSharePlugin$$special$$inlined$doOnPreDraw$1"})
    public static final class h implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ q Usi;
        final /* synthetic */ View Usk;
        final /* synthetic */ View nca;

        public h(View view, View view2, q qVar) {
            this.nca = view;
            this.Usk = view2;
            this.Usi = qVar;
        }

        public final boolean onPreDraw() {
            AppMethodBeat.i(262188);
            this.nca.getViewTreeObserver().removeOnPreDrawListener(this);
            int cR = kotlin.h.a.cR(((float) this.Usi.hwr.getWidth()) * 0.058f);
            ViewGroup.LayoutParams layoutParams = this.Usk.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                marginLayoutParams.leftMargin = cR;
                marginLayoutParams.rightMargin = cR;
                j jVar = j.UGJ;
                Context context = this.Usk.getContext();
                p.g(context, "context");
                int aD = j.aD(context);
                Context context2 = this.Usk.getContext();
                p.g(context2, "context");
                marginLayoutParams.bottomMargin = aD + context2.getResources().getDimensionPixelSize(R.dimen.cf);
                this.Usk.requestLayout();
            }
            AppMethodBeat.o(262188);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d
    @SuppressLint({"MissingSuperCall"})
    public final void dCW() {
        AppMethodBeat.i(262197);
        this.Uqk.ar(null);
        rg(8);
        AppMethodBeat.o(262197);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final void epk() {
        AppMethodBeat.i(262198);
        this.Uqk.ar(new a(this));
        AppMethodBeat.o(262198);
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(262199);
        if (this.Usd != null || this.Use != null) {
            AppMethodBeat.o(262199);
            return true;
        } else if (this.hwr.getVisibility() == 0) {
            eQ(false);
            AppMethodBeat.o(262199);
            return true;
        } else {
            AppMethodBeat.o(262199);
            return false;
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(262201);
        p.h(cVar, "status");
        switch (r.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                if (this.Usc) {
                    eQ(true);
                    break;
                }
                break;
        }
        AppMethodBeat.o(262201);
    }

    static /* synthetic */ void a(q qVar, kotlin.g.a.b bVar) {
        AppMethodBeat.i(262202);
        b bVar2 = b.Usg;
        c cVar = c.Ush;
        Bitmap ewK = qVar.Uqk.ewK();
        if (ewK == null) {
            q qVar2 = qVar;
            u.u(qVar2.hwr.getContext(), qVar2.hwr.getContext().getString(R.string.j9k), 0);
            cVar.invoke();
            AppMethodBeat.o(262202);
            return;
        }
        bVar.invoke(ewK);
        bVar2.invoke();
        AppMethodBeat.o(262202);
    }

    private final void show() {
        boolean z;
        Drawable l;
        AppMethodBeat.i(262203);
        this.Usc = true;
        this.Usf.Fh(true);
        this.hwr.bringToFront();
        this.ulW = 65535;
        View view = this.uGB;
        j jVar = j.UGJ;
        view.getViewTreeObserver().addOnPreDrawListener(new h(view, view, this));
        Calendar calendar = this.Usb;
        p.g(calendar, "calender");
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i2 = this.Usb.get(11);
        if (6 <= i2 && 18 > i2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            l = android.support.v4.content.b.l(this.hwr.getContext(), R.drawable.ctn);
        } else {
            l = android.support.v4.content.b.l(this.hwr.getContext(), R.drawable.cto);
        }
        view.setBackground(l);
        rg(0);
        aw(new i(this));
        AppMethodBeat.o(262203);
    }

    private final void eQ(boolean z) {
        AppMethodBeat.i(262204);
        if (z) {
            this.Usc = true;
            this.Usf.Fh(true);
            this.Uqk.ar(new d(this));
        } else {
            this.Usc = false;
            this.Usf.Fh(false);
            this.Uqk.egF();
        }
        View[] viewArr = {this.CYY, this.COK, this.UrZ, this.Usa};
        for (int i2 = 0; i2 < 4; i2++) {
            viewArr[i2].setOnClickListener(null);
        }
        ax(new e(this));
        AppMethodBeat.o(262204);
    }

    private final void aw(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(262205);
        ViewPropertyAnimator viewPropertyAnimator = this.Usd;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        this.Usd = null;
        this.uGB.setVisibility(0);
        this.uGB.setAlpha(0.0f);
        ViewPropertyAnimator animate = this.uGB.animate();
        animate.cancel();
        this.Usd = animate;
        animate.alpha(1.0f);
        animate.setDuration(300);
        animate.setInterpolator(new com.tencent.mm.plugin.festival.ui.a.a.a());
        animate.setListener(new f(this, aVar));
        animate.start();
        AppMethodBeat.o(262205);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCanvasHandDrawSharePlugin$runEnterAnimation$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-festival_release"})
    public static final class f extends AnimatorListenerAdapter {
        final /* synthetic */ q Usi;
        final /* synthetic */ kotlin.g.a.a Usj;

        f(q qVar, kotlin.g.a.a aVar) {
            this.Usi = qVar;
            this.Usj = aVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(262186);
            this.Usi.Usd = null;
            this.Usi.uGB.setAlpha(1.0f);
            this.Usi.uGB.setVisibility(0);
            this.Usi.rg(0);
            this.Usj.invoke();
            AppMethodBeat.o(262186);
        }
    }

    private final void ax(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(262206);
        ViewPropertyAnimator viewPropertyAnimator = this.Use;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        this.Use = null;
        ViewPropertyAnimator animate = this.uGB.animate();
        animate.cancel();
        this.Use = animate;
        animate.alpha(0.0f);
        animate.setDuration(300);
        animate.setInterpolator(new LinearInterpolator());
        animate.setListener(new g(this, aVar));
        animate.start();
        AppMethodBeat.o(262206);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCanvasHandDrawSharePlugin$runExitAnimation$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-festival_release"})
    public static final class g extends AnimatorListenerAdapter {
        final /* synthetic */ q Usi;
        final /* synthetic */ kotlin.g.a.a Usj;

        g(q qVar, kotlin.g.a.a aVar) {
            this.Usi = qVar;
            this.Usj = aVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(262187);
            this.Usi.Use = null;
            this.Usi.uGB.setAlpha(0.0f);
            this.Usi.uGB.setVisibility(8);
            this.Usj.invoke();
            AppMethodBeat.o(262187);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class i extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ q Usi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(q qVar) {
            super(0);
            this.Usi = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(262196);
            this.Usi.CYY.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.festival.finder.q.i.AnonymousClass1 */
                final /* synthetic */ i Usl;

                {
                    this.Usl = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(262189);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCanvasHandDrawSharePlugin$show$2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    this.Usl.Usi.onBackPress();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCanvasHandDrawSharePlugin$show$2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(262189);
                }
            });
            this.Usi.COK.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.festival.finder.q.i.AnonymousClass2 */
                final /* synthetic */ i Usl;

                {
                    this.Usl = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(262191);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCanvasHandDrawSharePlugin$show$2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    q.a(this.Usl.Usi, new kotlin.g.a.b<Bitmap, x>(this) {
                        /* class com.tencent.mm.plugin.festival.finder.q.i.AnonymousClass2.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass2 Usm;

                        {
                            this.Usm = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // kotlin.g.a.b
                        public final /* synthetic */ x invoke(Bitmap bitmap) {
                            AppMethodBeat.i(262190);
                            Bitmap bitmap2 = bitmap;
                            p.h(bitmap2, "bitmap");
                            com.tencent.mm.plugin.festival.model.f fVar = com.tencent.mm.plugin.festival.model.f.UxT;
                            Context context = this.Usm.Usl.Usi.hwr.getContext();
                            p.g(context, "root.context");
                            com.tencent.mm.plugin.festival.model.f.c(context, bitmap2);
                            x xVar = x.SXb;
                            AppMethodBeat.o(262190);
                            return xVar;
                        }
                    });
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCanvasHandDrawSharePlugin$show$2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(262191);
                }
            });
            this.Usi.UrZ.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.festival.finder.q.i.AnonymousClass3 */
                final /* synthetic */ i Usl;

                {
                    this.Usl = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(262193);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCanvasHandDrawSharePlugin$show$2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    q.a(this.Usl.Usi, new kotlin.g.a.b<Bitmap, x>(this) {
                        /* class com.tencent.mm.plugin.festival.finder.q.i.AnonymousClass3.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass3 Usn;

                        {
                            this.Usn = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // kotlin.g.a.b
                        public final /* synthetic */ x invoke(Bitmap bitmap) {
                            AppMethodBeat.i(262192);
                            Bitmap bitmap2 = bitmap;
                            p.h(bitmap2, "bitmap");
                            com.tencent.mm.plugin.festival.model.f fVar = com.tencent.mm.plugin.festival.model.f.UxT;
                            com.tencent.mm.plugin.festival.model.f.a(bitmap2, this.Usn.Usl.Usi.hOp);
                            x xVar = x.SXb;
                            AppMethodBeat.o(262192);
                            return xVar;
                        }
                    });
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCanvasHandDrawSharePlugin$show$2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(262193);
                }
            });
            this.Usi.Usa.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.festival.finder.q.i.AnonymousClass4 */
                final /* synthetic */ i Usl;

                {
                    this.Usl = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(262195);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCanvasHandDrawSharePlugin$show$2$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    q.a(this.Usl.Usi, new kotlin.g.a.b<Bitmap, x>(this) {
                        /* class com.tencent.mm.plugin.festival.finder.q.i.AnonymousClass4.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass4 Uso;

                        {
                            this.Uso = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // kotlin.g.a.b
                        public final /* synthetic */ x invoke(Bitmap bitmap) {
                            AppMethodBeat.i(262194);
                            Bitmap bitmap2 = bitmap;
                            p.h(bitmap2, "bitmap");
                            com.tencent.mm.plugin.festival.model.f fVar = com.tencent.mm.plugin.festival.model.f.UxT;
                            com.tencent.mm.plugin.festival.model.f.b(bitmap2, this.Uso.Usl.Usi.hOp);
                            x xVar = x.SXb;
                            AppMethodBeat.o(262194);
                            return xVar;
                        }
                    });
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCanvasHandDrawSharePlugin$show$2$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(262195);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(262196);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ q Usi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(q qVar) {
            super(0);
            this.Usi = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(262185);
            this.Usi.rg(8);
            x xVar = x.SXb;
            AppMethodBeat.o(262185);
            return xVar;
        }
    }

    @Override // com.tencent.mm.plugin.festival.finder.bn
    public final boolean d(PointF pointF) {
        AppMethodBeat.i(262200);
        p.h(pointF, "pointF");
        if (this.hwr.getVisibility() == 0 && this.Use != null) {
            eQ(true);
            AppMethodBeat.o(262200);
            return true;
        } else if (this.Usc) {
            if (this.hwr.getVisibility() != 0) {
                if (this.Usd == null) {
                    show();
                }
            } else if (this.Use == null) {
                eQ(true);
            }
            AppMethodBeat.o(262200);
            return true;
        } else {
            AppMethodBeat.o(262200);
            return false;
        }
    }

    public static final /* synthetic */ boolean a(q qVar) {
        AppMethodBeat.i(262208);
        qVar.show();
        AppMethodBeat.o(262208);
        return true;
    }
}
