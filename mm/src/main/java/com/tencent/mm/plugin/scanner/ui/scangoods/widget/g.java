package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\n*\u0001\r\u0018\u0000 A2\u00020\u0001:\u0001AB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u0018\u00102\u001a\u00020/2\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u0012H\u0016J\b\u00105\u001a\u00020/H\u0016J#\u00106\u001a\u00020/2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u0019082\u0006\u00109\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010:J\u0010\u0010;\u001a\u00020/2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020\u000bH\u0016J\b\u0010>\u001a\u00020/H\u0016J \u0010?\u001a\u00020/2\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u00122\u0006\u0010@\u001a\u00020\"H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R\u001a\u0010+\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010\u0016¨\u0006B"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsGroupView;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "context", "Landroid/content/Context;", "dotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;)V", "alphaAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "animationListener", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView$AnimationListener;", "animatorListener", "com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsGroupView$animatorListener$1", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsGroupView$animatorListener$1;", "animatorSet", "Landroid/animation/AnimatorSet;", "centerCount", "", "getCenterCount", "()I", "setCenterCount", "(I)V", "centerList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/model/ScanPoint;", "Lkotlin/collections/ArrayList;", "getCenterList", "()Ljava/util/ArrayList;", "setCenterList", "(Ljava/util/ArrayList;)V", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "isAnimating", "", "paint", "Landroid/graphics/Paint;", "radius", "", "sizeAnimator", "viewHeight", "getViewHeight", "setViewHeight", "viewWidth", "getViewWidth", "setViewWidth", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onViewSizeChanged", "width", "height", "release", "setAnimationDots", "points", "", "pointCount", "([Lcom/tencent/mm/plugin/scanner/model/ScanPoint;I)V", "setDuration", "startAnimation", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "stopAnimation", "updateViewSize", "forceUpdateDotsCenter", "Companion", "plugin-scan_release"})
public final class g implements c {
    public static final c CPG = new c((byte) 0);
    private AnimatorSet CPA;
    private d CPB = new d(this);
    private c.a CPC;
    private int CPD;
    private ArrayList<ScanPoint> CPE = new ArrayList<>();
    private final d CPF;
    private final ValueAnimator CPy;
    private final ValueAnimator CPz;
    private long duration = 700;
    private int gRD;
    private int gRE;
    private boolean isAnimating;
    private Paint paint;
    private float radius;

    static {
        AppMethodBeat.i(52274);
        AppMethodBeat.o(52274);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsGroupView$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    public g(Context context, d dVar) {
        p.h(context, "context");
        p.h(dVar, "dotsView");
        AppMethodBeat.i(52273);
        this.CPF = dVar;
        this.radius = context.getResources().getDimension(R.dimen.ai3);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, this.radius);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new a(this));
        this.CPy = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(-1.0f, 1.0f);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new b(this));
        this.CPz = ofFloat2;
        Paint paint2 = new Paint();
        paint2.setColor(context.getResources().getColor(R.color.am));
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        this.paint = paint2;
        AppMethodBeat.o(52273);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsGroupView$sizeAnimator$1$1"})
    static final class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ g CPH;

        a(g gVar) {
            this.CPH = gVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(52262);
            p.g(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(52262);
                throw tVar;
            }
            this.CPH.radius = ((Float) animatedValue).floatValue();
            this.CPH.CPF.refreshView();
            AppMethodBeat.o(52262);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsGroupView$alphaAnimator$1$1"})
    static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ g CPH;

        b(g gVar) {
            this.CPH = gVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(52263);
            p.g(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(52263);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            if (floatValue <= 0.0f) {
                this.CPH.paint.setAlpha((int) ((floatValue + 1.0f) * 255.0f));
            } else {
                this.CPH.paint.setAlpha((int) ((1.0f - floatValue) * 255.0f));
            }
            this.CPH.CPF.refreshView();
            AppMethodBeat.o(52263);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsGroupView$animatorListener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
    public static final class d implements Animator.AnimatorListener {
        final /* synthetic */ g CPH;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(g gVar) {
            this.CPH = gVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(52264);
            this.CPH.isAnimating = false;
            c.a aVar = this.CPH.CPC;
            if (aVar != null) {
                aVar.a(this.CPH);
                AppMethodBeat.o(52264);
                return;
            }
            AppMethodBeat.o(52264);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(52265);
            this.CPH.isAnimating = false;
            AppMethodBeat.o(52265);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(52266);
            this.CPH.isAnimating = true;
            c.a unused = this.CPH.CPC;
            AppMethodBeat.o(52266);
        }
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.c
    public final void draw(Canvas canvas) {
        AppMethodBeat.i(52267);
        if (!this.isAnimating) {
            AppMethodBeat.o(52267);
            return;
        }
        int i2 = this.CPD;
        for (int i3 = 0; i3 < i2; i3++) {
            ScanPoint scanPoint = (ScanPoint) j.L(this.CPE, i3);
            if (scanPoint == null) {
                AppMethodBeat.o(52267);
                return;
            }
            if (canvas != null) {
                canvas.drawCircle(scanPoint.getX(), scanPoint.getY(), this.radius, this.paint);
            }
        }
        AppMethodBeat.o(52267);
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.c
    public final void setDuration(long j2) {
        this.duration = j2;
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.c
    public final void A(int i2, int i3, boolean z) {
        AppMethodBeat.i(52268);
        Log.v("MicroMsg.ScanAnimationDotsGroupView", "alvinluo setViewSize width: %d, height: %d, forceUpdateDotsCenter: %b", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z));
        boolean z2 = ((this.gRD == i2 && this.gRE == i3 && !z) || i2 == 0 || i3 == 0) ? false : true;
        this.gRD = i2;
        this.gRE = i3;
        if (z2) {
            int i4 = this.gRD;
            int i5 = this.gRE;
            int i6 = this.CPD;
            for (int i7 = 0; i7 < i6; i7++) {
                ScanPoint scanPoint = (ScanPoint) j.L(this.CPE, i7);
                if (scanPoint == null) {
                    scanPoint = new ScanPoint();
                    this.CPE.add(scanPoint);
                }
                scanPoint.setX(((float) i4) * scanPoint.getXFactor());
                scanPoint.setY(((float) i5) * scanPoint.getYFactor());
                Log.d("MicroMsg.ScanAnimationDotsGroupView", "alvinluo onViewSizeChanged i: %d, %f, %f", Integer.valueOf(i7), Float.valueOf(scanPoint.getX()), Float.valueOf(scanPoint.getY()));
            }
        }
        AppMethodBeat.o(52268);
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.c
    public final void a(ScanPoint[] scanPointArr, int i2) {
        ScanPoint scanPoint;
        AppMethodBeat.i(52269);
        p.h(scanPointArr, "points");
        this.CPD = i2;
        int i3 = this.CPD;
        for (int i4 = 0; i4 < i3; i4++) {
            ScanPoint scanPoint2 = (ScanPoint) e.f(scanPointArr, i4);
            ScanPoint scanPoint3 = (ScanPoint) j.L(this.CPE, i4);
            if (scanPoint3 == null) {
                ScanPoint scanPoint4 = new ScanPoint();
                this.CPE.add(scanPoint4);
                scanPoint = scanPoint4;
            } else {
                scanPoint = scanPoint3;
            }
            scanPoint.setXFactor(scanPoint2 != null ? scanPoint2.getXFactor() : 0.0f);
            scanPoint.setYFactor(scanPoint2 != null ? scanPoint2.getYFactor() : 0.0f);
            scanPoint.setX(0.0f);
            scanPoint.setY(0.0f);
        }
        AppMethodBeat.o(52269);
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.c
    public final void a(c.a aVar) {
        AppMethodBeat.i(52270);
        p.h(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Log.v("MicroMsg.ScanAnimationDotsGroupView", "alvinluo startAnimation %d", Integer.valueOf(hashCode()));
        this.CPC = aVar;
        this.CPA = new AnimatorSet();
        AnimatorSet animatorSet = this.CPA;
        if (animatorSet == null) {
            p.hyc();
        }
        animatorSet.setDuration(this.duration);
        animatorSet.removeAllListeners();
        animatorSet.addListener(this.CPB);
        animatorSet.playTogether(this.CPy, this.CPz);
        animatorSet.start();
        AppMethodBeat.o(52270);
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.c
    public final void stopAnimation() {
        AppMethodBeat.i(52271);
        Log.v("MicroMsg.ScanAnimationDotsGroupView", "alvinluo stopAnimation");
        AnimatorSet animatorSet = this.CPA;
        if (animatorSet != null) {
            animatorSet.cancel();
            AppMethodBeat.o(52271);
            return;
        }
        AppMethodBeat.o(52271);
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.c
    public final boolean isAnimating() {
        return this.isAnimating;
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.c
    public final void release() {
        AppMethodBeat.i(52272);
        this.CPD = 0;
        this.CPE.clear();
        AppMethodBeat.o(52272);
    }
}
