package com.tencent.mm.plugin.festival.ui.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.festival.PluginFestival;
import com.tencent.mm.plugin.festival.finder.j;
import com.tencent.mm.plugin.festival.finder.k;
import com.tencent.mm.plugin.festival.ui.view.FestivalAvatarPopupSparkleWrapperLayout;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.l;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

public final class a extends FrameLayout {
    public static final C1080a UFa = new C1080a((byte) 0);
    private kotlin.g.a.a<x> UEQ;
    private kotlin.g.a.a<x> UER;
    private kotlin.g.a.a<x> UES;
    public final FestivalCdnImageView UET;
    private FestivalAvatarPopupSparkleWrapperLayout UEU;
    private com.tencent.mm.plugin.festival.finder.g UEV;
    private final Point UEW;
    private final kotlin.g.a.a<x> UEX;
    private final kotlin.g.a.a<x> UEY;
    private final PointF UEZ;
    private String Uxq;
    private int yHr;

    static {
        AppMethodBeat.i(263392);
        AppMethodBeat.o(263392);
    }

    /* access modifiers changed from: package-private */
    public static final class e extends q implements kotlin.g.a.a<x> {
        public static final e UFe = new e();

        static {
            AppMethodBeat.i(263370);
            AppMethodBeat.o(263370);
        }

        e() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class f extends q implements kotlin.g.a.a<x> {
        public static final f UFf = new f();

        static {
            AppMethodBeat.i(263371);
            AppMethodBeat.o(263371);
        }

        f() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class g extends q implements kotlin.g.a.a<x> {
        public static final g UFg = new g();

        static {
            AppMethodBeat.i(263372);
            AppMethodBeat.o(263372);
        }

        g() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    public static final class h extends q implements kotlin.g.a.b<View, x> {
        final /* synthetic */ a UFb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(a aVar) {
            super(1);
            this.UFb = aVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(View view) {
            AppMethodBeat.i(263373);
            View view2 = view;
            p.h(view2, LocaleUtil.ITALIAN);
            if (!p.j(view2, this.UFb)) {
                view2.setClickable(false);
                view2.setDuplicateParentStateEnabled(true);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(263373);
            return xVar;
        }
    }

    /* renamed from: com.tencent.mm.plugin.festival.ui.view.a$a */
    static final class C1080a {
        private C1080a() {
        }

        public /* synthetic */ C1080a(byte b2) {
            this();
        }
    }

    public /* synthetic */ a(Context context) {
        this(context, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, j jVar) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(263391);
        this.UEQ = e.UFe;
        this.UER = g.UFg;
        this.UES = f.UFf;
        this.Uxq = "";
        if (jVar != null) {
            jVar.a(this);
        } else {
            LayoutInflater.from(context).inflate(R.layout.cdg, this);
        }
        View findViewById = findViewById(R.id.x1);
        FestivalCdnImageView festivalCdnImageView = (FestivalCdnImageView) findViewById;
        festivalCdnImageView.setShowCircleImage(true);
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFestival.class);
        p.g(ah, "plugin(PluginFestival::class.java)");
        com.tencent.mm.av.a.a strangerAvatarImageLoader = ((PluginFestival) ah).getStrangerAvatarImageLoader();
        p.g(strangerAvatarImageLoader, "plugin(PluginFestival::c…strangerAvatarImageLoader");
        festivalCdnImageView.setLoader(strangerAvatarImageLoader);
        p.g(findViewById, "findViewById<FestivalCdn…atarImageLoader\n        }");
        this.UET = (FestivalCdnImageView) findViewById;
        this.yHr = context.getResources().getDimensionPixelSize(R.dimen.cm);
        setFocusable(true);
        setClickable(true);
        this.UEW = new Point(0, 0);
        this.UEX = new c(this);
        this.UEY = new b(this);
        this.UEZ = new PointF();
        AppMethodBeat.o(263391);
    }

    public static final /* synthetic */ FestivalAvatarPopupSparkleWrapperLayout d(a aVar) {
        AppMethodBeat.i(263393);
        FestivalAvatarPopupSparkleWrapperLayout festivalAvatarPopupSparkleWrapperLayout = aVar.UEU;
        if (festivalAvatarPopupSparkleWrapperLayout == null) {
            p.btv("sparkleWrapperLayout");
        }
        AppMethodBeat.o(263393);
        return festivalAvatarPopupSparkleWrapperLayout;
    }

    public final int getAvatarSize() {
        return this.yHr;
    }

    public final void setAvatarSize(int i2) {
        this.yHr = i2;
    }

    public final kotlin.g.a.a<x> getOnDismiss() {
        return this.UEQ;
    }

    public final void setOnDismiss(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(263376);
        p.h(aVar, "<set-?>");
        this.UEQ = aVar;
        AppMethodBeat.o(263376);
    }

    public final kotlin.g.a.a<x> getOnShowAnimationStart() {
        return this.UER;
    }

    public final void setOnShowAnimationStart(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(263377);
        p.h(aVar, "<set-?>");
        this.UER = aVar;
        AppMethodBeat.o(263377);
    }

    public final kotlin.g.a.a<x> getOnShowAnimationEnd() {
        return this.UES;
    }

    public final void setOnShowAnimationEnd(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(263378);
        p.h(aVar, "<set-?>");
        this.UES = aVar;
        AppMethodBeat.o(263378);
    }

    public final String getUserAvatarUrl() {
        return this.Uxq;
    }

    public final void setUserAvatarUrl(String str) {
        AppMethodBeat.i(263379);
        this.Uxq = str;
        this.UET.setImageCdnUrl(str);
        AppMethodBeat.o(263379);
    }

    public static final class i implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ a UFb;
        final /* synthetic */ long UFh;
        final /* synthetic */ View nca;

        public i(View view, a aVar, long j2) {
            this.nca = view;
            this.UFb = aVar;
            this.UFh = j2;
        }

        public final boolean onPreDraw() {
            AppMethodBeat.i(263375);
            this.nca.getViewTreeObserver().removeOnPreDrawListener(this);
            this.UFb.getOnShowAnimationStart().invoke();
            d dVar = d.UFJ;
            d.a(this.UFb, this.UFh, new C1081a(this));
            AppMethodBeat.o(263375);
            return false;
        }

        /* renamed from: com.tencent.mm.plugin.festival.ui.view.a$i$a */
        static final class C1081a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ i UFi;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1081a(i iVar) {
                super(0);
                this.UFi = iVar;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(263374);
                this.UFi.UFb.getOnShowAnimationEnd().invoke();
                FestivalAvatarPopupSparkleWrapperLayout d2 = a.d(this.UFi.UFb);
                Animator animator = d2.UEI;
                if (animator != null) {
                    animator.cancel();
                }
                d2.UEI = null;
                if (!d2.UEF.isEmpty() && !d2.UEE.isEmpty()) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(d2.getDRAW_MIN_SCALE(), d2.UEL);
                    ofFloat.setRepeatCount(-1);
                    ofFloat.setRepeatMode(2);
                    ofFloat.setDuration(d2.UEM);
                    ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                    ofFloat.addUpdateListener(new FestivalAvatarPopupSparkleWrapperLayout.b(d2));
                    ofFloat.addListener(new FestivalAvatarPopupSparkleWrapperLayout.c(d2));
                    ofFloat.start();
                    d2.UEI = ofFloat;
                }
                x xVar = x.SXb;
                AppMethodBeat.o(263374);
                return xVar;
            }
        }
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(263380);
        super.setOnClickListener(onClickListener);
        if (onClickListener != null) {
            setClickable(true);
            a(this, new h(this));
            AppMethodBeat.o(263380);
            return;
        }
        setClickable(false);
        AppMethodBeat.o(263380);
    }

    private final void a(View view, kotlin.g.a.b<? super View, x> bVar) {
        AppMethodBeat.i(263381);
        if (view instanceof ViewGroup) {
            com.tencent.mm.plugin.festival.c.j jVar = com.tencent.mm.plugin.festival.c.j.UGJ;
            for (View view2 : com.tencent.mm.plugin.festival.c.j.K((ViewGroup) view)) {
                a(view2, bVar);
            }
            bVar.invoke(view);
            AppMethodBeat.o(263381);
            return;
        }
        bVar.invoke(view);
        AppMethodBeat.o(263381);
    }

    public static /* synthetic */ void a(a aVar, com.tencent.mm.plugin.festival.finder.g gVar, k.a aVar2, int i2, int i3) {
        AppMethodBeat.i(263383);
        aVar.a(gVar, aVar2, i2, i3, 0);
        AppMethodBeat.o(263383);
    }

    public final void a(com.tencent.mm.plugin.festival.finder.g gVar, k.a aVar, int i2, int i3, long j2) {
        AppMethodBeat.i(263382);
        p.h(gVar, "container");
        p.h(aVar, "canvas");
        this.UEV = gVar;
        gVar.as(this.UEX);
        gVar.au(this.UEY);
        ViewParent parent = this.UET.getParent();
        if (parent == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.festival.ui.view.FestivalAvatarPopupSparkleWrapperLayout");
            AppMethodBeat.o(263382);
            throw tVar;
        }
        this.UEU = (FestivalAvatarPopupSparkleWrapperLayout) parent;
        ViewGroup.LayoutParams layoutParams = this.UET.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.yHr;
            layoutParams.height = this.yHr;
            this.UET.requestLayout();
        }
        this.UEW.set(i2, i3);
        gVar.addView(this);
        com.tencent.mm.plugin.festival.c.j jVar = com.tencent.mm.plugin.festival.c.j.UGJ;
        a aVar2 = this;
        aVar2.getViewTreeObserver().addOnPreDrawListener(new i(aVar2, this, j2));
        a("showAtLocation", gVar, aVar);
        AppMethodBeat.o(263382);
    }

    public final void a(String str, com.tencent.mm.plugin.festival.finder.g gVar, k.a aVar) {
        AppMethodBeat.i(263384);
        p.h(str, "reason");
        p.h(gVar, "container");
        p.h(aVar, "canvas");
        a aVar2 = this;
        PointF pointF = new PointF(this.UEW);
        aVar.c(pointF, pointF);
        if (Float.isNaN(pointF.x) || Float.isNaN(pointF.y)) {
            pointF.x = 0.0f;
            pointF.y = 0.0f;
            Log.e("MicroMsg.FestivalMemoriesCardPopup", "updateViewLocation(" + str + ") get NaN location from canvas");
        }
        Rect a2 = a(aVar2, kotlin.h.a.cR(pointF.x), kotlin.h.a.cR(pointF.y), gVar);
        Log.d("MicroMsg.FestivalMemoriesCardPopup", "updateViewLocation(" + str + "), sxy(" + this.UEW + ") -> vxy(" + pointF + ") -> location(" + a2);
        aVar2.setX((float) a2.left);
        aVar2.setY((float) a2.top);
        AppMethodBeat.o(263384);
    }

    private static Rect a(View view, int i2, int i3, com.tencent.mm.plugin.festival.finder.g gVar) {
        AppMethodBeat.i(263385);
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        Rect eWS = gVar.eWS();
        Rect rect = new Rect();
        rect.left = android.support.v4.b.a.clamp(i2 - (measuredWidth / 2), eWS.left, eWS.right - measuredWidth);
        rect.right = measuredWidth + rect.left;
        rect.top = android.support.v4.b.a.clamp(i3 - (measuredHeight / 2), eWS.top, eWS.bottom - measuredHeight);
        rect.bottom = rect.top + measuredHeight;
        AppMethodBeat.o(263385);
        return rect;
    }

    public static /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(263387);
        aVar.rX(true);
        AppMethodBeat.o(263387);
    }

    public final void rX(boolean z) {
        AppMethodBeat.i(263386);
        if (this.UEV != null) {
            com.tencent.mm.plugin.festival.finder.g gVar = this.UEV;
            if (gVar == null) {
                p.btv("container");
            }
            gVar.at(this.UEX);
            com.tencent.mm.plugin.festival.finder.g gVar2 = this.UEV;
            if (gVar2 == null) {
                p.btv("container");
            }
            gVar2.av(this.UEY);
        }
        a aVar = this;
        if (aVar.isAttachedToWindow()) {
            if (!z) {
                ViewParent parent = aVar.getParent();
                if (!(parent instanceof ViewGroup)) {
                    parent = null;
                }
                ViewGroup viewGroup = (ViewGroup) parent;
                if (viewGroup != null) {
                    viewGroup.removeView(aVar);
                    AppMethodBeat.o(263386);
                    return;
                }
                AppMethodBeat.o(263386);
                return;
            }
            FestivalAvatarPopupSparkleWrapperLayout festivalAvatarPopupSparkleWrapperLayout = this.UEU;
            if (festivalAvatarPopupSparkleWrapperLayout == null) {
                p.btv("sparkleWrapperLayout");
            }
            FestivalAvatarPopupSparkleWrapperLayout.a(festivalAvatarPopupSparkleWrapperLayout);
            aVar.setClickable(false);
            Animation animation = aVar.getAnimation();
            if (animation != null) {
                animation.cancel();
            }
            ViewPropertyAnimator animate = aVar.animate();
            if (animate != null) {
                animate.cancel();
            }
            d dVar = d.UFJ;
            d.b(aVar, new d(this, aVar));
        }
        AppMethodBeat.o(263386);
    }

    public final float getCenterX() {
        AppMethodBeat.i(263388);
        float x = getX() + (((float) getWidth()) / 2.0f);
        AppMethodBeat.o(263388);
        return x;
    }

    public final float getCenterY() {
        AppMethodBeat.i(263389);
        float y = getY() + (((float) getHeight()) / 2.0f);
        AppMethodBeat.o(263389);
        return y;
    }

    public final PointF getLastTouchUpPoint() {
        return this.UEZ;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(263390);
        p.h(motionEvent, "ev");
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 1:
                this.UEZ.set(motionEvent.getRawX(), motionEvent.getRawY());
                break;
            default:
                PointF pointF = this.UEZ;
                l lVar = l.SYx;
                float hYV = l.hYV();
                l lVar2 = l.SYx;
                pointF.set(hYV, l.hYV());
                break;
        }
        AppMethodBeat.o(263390);
        return dispatchTouchEvent;
    }

    /* access modifiers changed from: package-private */
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a UFb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(0);
            this.UFb = aVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            FestivalAvatarPopupSparkleWrapperLayout d2;
            Animator animator;
            AppMethodBeat.i(263367);
            if (!(this.UFb.UEU == null || (animator = (d2 = a.d(this.UFb)).UEI) == null || !animator.isStarted())) {
                Animator animator2 = d2.UEI;
                if (animator2 == null) {
                    p.hyc();
                }
                animator2.resume();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(263367);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a UFb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(0);
            this.UFb = aVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            FestivalAvatarPopupSparkleWrapperLayout d2;
            Animator animator;
            AppMethodBeat.i(263366);
            if (!(this.UFb.UEU == null || (animator = (d2 = a.d(this.UFb)).UEI) == null || !animator.isStarted())) {
                Animator animator2 = d2.UEI;
                if (animator2 == null) {
                    p.hyc();
                }
                animator2.pause();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(263366);
            return xVar;
        }
    }

    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a UFb;
        final /* synthetic */ a UFc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar, a aVar2) {
            super(0);
            this.UFb = aVar;
            this.UFc = aVar2;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(263369);
            com.tencent.f.h.RTc.n(new Runnable(this) {
                /* class com.tencent.mm.plugin.festival.ui.view.a.d.AnonymousClass1 */
                final /* synthetic */ d UFd;

                {
                    this.UFd = r1;
                }

                public final void run() {
                    AppMethodBeat.i(263368);
                    ViewParent parent = this.UFd.UFc.getParent();
                    if (!(parent instanceof ViewGroup)) {
                        parent = null;
                    }
                    ViewGroup viewGroup = (ViewGroup) parent;
                    if (viewGroup != null) {
                        viewGroup.removeView(this.UFd.UFc);
                    }
                    this.UFd.UFb.getOnDismiss().invoke();
                    AppMethodBeat.o(263368);
                }
            }, 0);
            x xVar = x.SXb;
            AppMethodBeat.o(263369);
            return xVar;
        }
    }
}
