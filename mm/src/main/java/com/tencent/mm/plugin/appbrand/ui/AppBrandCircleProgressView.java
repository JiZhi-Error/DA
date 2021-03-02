package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.v;
import kotlin.t;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 U2\u00020\u0001:\u0001UB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010M\u001a\u00020NH\u0014J\u0010\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020QH\u0014J\u0006\u0010R\u001a\u00020NJ\b\u0010S\u001a\u00020NH\u0007J\b\u0010T\u001a\u00020NH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168F@FX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u0014\u001a\u0004\b \u0010!R+\u0010#\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b8F@FX\u0002¢\u0006\u0012\n\u0004\b(\u0010\u001d\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010)\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R+\u0010*\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168F@FX\u0002¢\u0006\u0012\n\u0004\b-\u0010\u001d\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001bR\u001b\u0010.\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b0\u0010\u0014\u001a\u0004\b/\u0010!R+\u00101\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b8F@FX\u0002¢\u0006\u0012\n\u0004\b4\u0010\u001d\u001a\u0004\b2\u0010%\"\u0004\b3\u0010'R\u000e\u00105\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R$\u00109\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u0016@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0019\"\u0004\b;\u0010\u001bR+\u0010<\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168F@FX\u0002¢\u0006\u0012\n\u0004\b?\u0010\u001d\u001a\u0004\b=\u0010\u0019\"\u0004\b>\u0010\u001bR\u001b\u0010@\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\bB\u0010\u0014\u001a\u0004\bA\u0010!R+\u0010C\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b8F@FX\u0002¢\u0006\u0012\n\u0004\bF\u0010\u001d\u001a\u0004\bD\u0010%\"\u0004\bE\u0010'R\u0014\u0010G\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\bH\u0010%R\u000e\u0010I\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010J\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0019\"\u0004\bL\u0010\u001b¨\u0006V"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandCircleProgressView;", "Landroid/view/View;", "ctx", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "angle", "", "animDuration", "", "getAnimDuration", "()J", "setAnimDuration", "(J)V", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "animator$delegate", "Lkotlin/Lazy;", "<set-?>", "", "circleColor", "getCircleColor", "()I", "setCircleColor", "(I)V", "circleColor$delegate", "Lkotlin/properties/ReadWriteProperty;", "circlePaint", "Landroid/graphics/Paint;", "getCirclePaint", "()Landroid/graphics/Paint;", "circlePaint$delegate", "circleStrokeWidth", "getCircleStrokeWidth", "()F", "setCircleStrokeWidth", "(F)V", "circleStrokeWidth$delegate", "currentPlayTime", "dotColor", "getDotColor", "setDotColor", "dotColor$delegate", "dotPaint", "getDotPaint", "dotPaint$delegate", "dotWidth", "getDotWidth", "setDotWidth", "dotWidth$delegate", "pointX", "pointY", "processToDraw", "value", "progress", "getProgress", "setProgress", "progressColor", "getProgressColor", "setProgressColor", "progressColor$delegate", "progressPaint", "getProgressPaint", "progressPaint$delegate", "progressWidth", "getProgressWidth", "setProgressWidth", "progressWidth$delegate", "radius", "getRadius", "step", "transitionTimingMs", "getTransitionTimingMs", "setTransitionTimingMs", "onDetachedFromWindow", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "promote", "startAnim", "stopAnim", "Companion", "luggage-wechat-full-sdk_release"})
public final class AppBrandCircleProgressView extends View {
    static final /* synthetic */ kotlin.l.k[] cLI = {aa.a(new v(aa.bp(AppBrandCircleProgressView.class), "circleColor", "getCircleColor()I")), aa.a(new v(aa.bp(AppBrandCircleProgressView.class), "dotColor", "getDotColor()I")), aa.a(new v(aa.bp(AppBrandCircleProgressView.class), "progressColor", "getProgressColor()I")), aa.a(new v(aa.bp(AppBrandCircleProgressView.class), "circleStrokeWidth", "getCircleStrokeWidth()F")), aa.a(new v(aa.bp(AppBrandCircleProgressView.class), "dotWidth", "getDotWidth()F")), aa.a(new v(aa.bp(AppBrandCircleProgressView.class), "progressWidth", "getProgressWidth()F"))};
    public static final g nSL = new g((byte) 0);
    private float angle;
    private int lCq;
    private final kotlin.i.c nSA;
    private final kotlin.i.c nSB;
    private final kotlin.i.c nSC;
    private final kotlin.f nSD;
    private final kotlin.f nSE;
    private final kotlin.f nSF;
    private final kotlin.f nSG;
    private long nSH;
    private float nSI;
    private float nSJ;
    private float nSK;
    private int nSv = 2000;
    private long nSw = 1500;
    private final kotlin.i.c nSx;
    private final kotlin.i.c nSy;
    private final kotlin.i.c nSz;
    private int progress;

    static {
        AppMethodBeat.i(230202);
        AppMethodBeat.o(230202);
    }

    private final ValueAnimator getAnimator() {
        AppMethodBeat.i(230216);
        ValueAnimator valueAnimator = (ValueAnimator) this.nSD.getValue();
        AppMethodBeat.o(230216);
        return valueAnimator;
    }

    private final Paint getCirclePaint() {
        AppMethodBeat.i(230217);
        Paint paint = (Paint) this.nSE.getValue();
        AppMethodBeat.o(230217);
        return paint;
    }

    private final Paint getDotPaint() {
        AppMethodBeat.i(230218);
        Paint paint = (Paint) this.nSF.getValue();
        AppMethodBeat.o(230218);
        return paint;
    }

    private final Paint getProgressPaint() {
        AppMethodBeat.i(230219);
        Paint paint = (Paint) this.nSG.getValue();
        AppMethodBeat.o(230219);
        return paint;
    }

    public final int getCircleColor() {
        AppMethodBeat.i(230204);
        int intValue = ((Number) this.nSx.a(cLI[0])).intValue();
        AppMethodBeat.o(230204);
        return intValue;
    }

    public final float getCircleStrokeWidth() {
        AppMethodBeat.i(230210);
        float floatValue = ((Number) this.nSA.a(cLI[3])).floatValue();
        AppMethodBeat.o(230210);
        return floatValue;
    }

    public final int getDotColor() {
        AppMethodBeat.i(230206);
        int intValue = ((Number) this.nSy.a(cLI[1])).intValue();
        AppMethodBeat.o(230206);
        return intValue;
    }

    public final float getDotWidth() {
        AppMethodBeat.i(230212);
        float floatValue = ((Number) this.nSB.a(cLI[4])).floatValue();
        AppMethodBeat.o(230212);
        return floatValue;
    }

    public final int getProgressColor() {
        AppMethodBeat.i(230208);
        int intValue = ((Number) this.nSz.a(cLI[2])).intValue();
        AppMethodBeat.o(230208);
        return intValue;
    }

    public final float getProgressWidth() {
        AppMethodBeat.i(230214);
        float floatValue = ((Number) this.nSC.a(cLI[5])).floatValue();
        AppMethodBeat.o(230214);
        return floatValue;
    }

    public final void setCircleColor(int i2) {
        AppMethodBeat.i(230205);
        this.nSx.a(cLI[0], Integer.valueOf(i2));
        AppMethodBeat.o(230205);
    }

    public final void setCircleStrokeWidth(float f2) {
        AppMethodBeat.i(230211);
        this.nSA.a(cLI[3], Float.valueOf(f2));
        AppMethodBeat.o(230211);
    }

    public final void setDotColor(int i2) {
        AppMethodBeat.i(230207);
        this.nSy.a(cLI[1], Integer.valueOf(i2));
        AppMethodBeat.o(230207);
    }

    public final void setDotWidth(float f2) {
        AppMethodBeat.i(230213);
        this.nSB.a(cLI[4], Float.valueOf(f2));
        AppMethodBeat.o(230213);
    }

    public final void setProgressColor(int i2) {
        AppMethodBeat.i(230209);
        this.nSz.a(cLI[2], Integer.valueOf(i2));
        AppMethodBeat.o(230209);
    }

    public final void setProgressWidth(float f2) {
        AppMethodBeat.i(230215);
        this.nSC.a(cLI[5], Float.valueOf(f2));
        AppMethodBeat.o(230215);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBrandCircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "ctx");
        AppMethodBeat.i(230225);
        kotlin.i.a aVar = kotlin.i.a.SYL;
        this.nSx = new a(-7829368, -7829368, this);
        kotlin.i.a aVar2 = kotlin.i.a.SYL;
        this.nSy = new b(-7829368, -7829368, this);
        kotlin.i.a aVar3 = kotlin.i.a.SYL;
        this.nSz = new c(-16711936, -16711936, this);
        kotlin.i.a aVar4 = kotlin.i.a.SYL;
        Float valueOf = Float.valueOf(1.0f);
        this.nSA = new d(valueOf, valueOf, this);
        kotlin.i.a aVar5 = kotlin.i.a.SYL;
        Float valueOf2 = Float.valueOf(1.0f);
        this.nSB = new e(valueOf2, valueOf2, this);
        kotlin.i.a aVar6 = kotlin.i.a.SYL;
        Float valueOf3 = Float.valueOf(3.0f);
        this.nSC = new f(valueOf3, valueOf3, this);
        this.nSD = kotlin.g.ah(new h(this));
        this.nSE = kotlin.g.ah(new i(this));
        this.nSF = kotlin.g.ah(new j(this));
        this.nSG = kotlin.g.ah(new k(this));
        this.lCq = 1;
        this.nSK = (float) this.progress;
        AppMethodBeat.o(230225);
    }

    public static final /* synthetic */ float a(AppBrandCircleProgressView appBrandCircleProgressView) {
        AppMethodBeat.i(230226);
        float radius = appBrandCircleProgressView.getRadius();
        AppMethodBeat.o(230226);
        return radius;
    }

    public static final /* synthetic */ Paint b(AppBrandCircleProgressView appBrandCircleProgressView) {
        AppMethodBeat.i(230227);
        Paint circlePaint = appBrandCircleProgressView.getCirclePaint();
        AppMethodBeat.o(230227);
        return circlePaint;
    }

    public static final /* synthetic */ Paint c(AppBrandCircleProgressView appBrandCircleProgressView) {
        AppMethodBeat.i(230228);
        Paint dotPaint = appBrandCircleProgressView.getDotPaint();
        AppMethodBeat.o(230228);
        return dotPaint;
    }

    public static final /* synthetic */ Paint d(AppBrandCircleProgressView appBrandCircleProgressView) {
        AppMethodBeat.i(230229);
        Paint progressPaint = appBrandCircleProgressView.getProgressPaint();
        AppMethodBeat.o(230229);
        return progressPaint;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandCircleProgressView$Companion;", "", "()V", "TAG", "", "luggage-wechat-full-sdk_release"})
    public static final class g {
        private g() {
        }

        public /* synthetic */ g(byte b2) {
            this();
        }
    }

    public final int getTransitionTimingMs() {
        return this.nSv;
    }

    public final void setTransitionTimingMs(int i2) {
        this.nSv = i2;
    }

    public final long getAnimDuration() {
        return this.nSw;
    }

    public final void setAnimDuration(long j2) {
        this.nSw = j2;
    }

    public final int getProgress() {
        return this.progress;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t¸\u0006\u0000"}, hxF = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
    public static final class a extends kotlin.i.b<Integer> {
        final /* synthetic */ Object mKT;
        final /* synthetic */ AppBrandCircleProgressView nSM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Object obj, Object obj2, AppBrandCircleProgressView appBrandCircleProgressView) {
            super(obj2);
            this.mKT = obj;
            this.nSM = appBrandCircleProgressView;
        }

        @Override // kotlin.i.b
        public final void a(kotlin.l.k<?> kVar, Integer num, Integer num2) {
            AppMethodBeat.i(230191);
            p.h(kVar, "property");
            int intValue = num2.intValue();
            num.intValue();
            AppBrandCircleProgressView.b(this.nSM).setColor(intValue);
            AppMethodBeat.o(230191);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t¸\u0006\u0000"}, hxF = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
    public static final class b extends kotlin.i.b<Integer> {
        final /* synthetic */ Object mKT;
        final /* synthetic */ AppBrandCircleProgressView nSM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Object obj, Object obj2, AppBrandCircleProgressView appBrandCircleProgressView) {
            super(obj2);
            this.mKT = obj;
            this.nSM = appBrandCircleProgressView;
        }

        @Override // kotlin.i.b
        public final void a(kotlin.l.k<?> kVar, Integer num, Integer num2) {
            AppMethodBeat.i(230192);
            p.h(kVar, "property");
            int intValue = num2.intValue();
            num.intValue();
            AppBrandCircleProgressView.c(this.nSM).setColor(intValue);
            AppMethodBeat.o(230192);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t¸\u0006\u0000"}, hxF = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
    public static final class c extends kotlin.i.b<Integer> {
        final /* synthetic */ Object mKT;
        final /* synthetic */ AppBrandCircleProgressView nSM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Object obj, Object obj2, AppBrandCircleProgressView appBrandCircleProgressView) {
            super(obj2);
            this.mKT = obj;
            this.nSM = appBrandCircleProgressView;
        }

        @Override // kotlin.i.b
        public final void a(kotlin.l.k<?> kVar, Integer num, Integer num2) {
            AppMethodBeat.i(230193);
            p.h(kVar, "property");
            int intValue = num2.intValue();
            num.intValue();
            AppBrandCircleProgressView.d(this.nSM).setColor(intValue);
            AppMethodBeat.o(230193);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t¸\u0006\u0000"}, hxF = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
    public static final class d extends kotlin.i.b<Float> {
        final /* synthetic */ Object mKT;
        final /* synthetic */ AppBrandCircleProgressView nSM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Object obj, Object obj2, AppBrandCircleProgressView appBrandCircleProgressView) {
            super(obj2);
            this.mKT = obj;
            this.nSM = appBrandCircleProgressView;
        }

        @Override // kotlin.i.b
        public final void a(kotlin.l.k<?> kVar, Float f2, Float f3) {
            AppMethodBeat.i(230194);
            p.h(kVar, "property");
            float floatValue = f3.floatValue();
            f2.floatValue();
            AppBrandCircleProgressView.b(this.nSM).setStrokeWidth(floatValue);
            AppMethodBeat.o(230194);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t¸\u0006\u0000"}, hxF = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
    public static final class e extends kotlin.i.b<Float> {
        final /* synthetic */ Object mKT;
        final /* synthetic */ AppBrandCircleProgressView nSM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Object obj, Object obj2, AppBrandCircleProgressView appBrandCircleProgressView) {
            super(obj2);
            this.mKT = obj;
            this.nSM = appBrandCircleProgressView;
        }

        @Override // kotlin.i.b
        public final void a(kotlin.l.k<?> kVar, Float f2, Float f3) {
            AppMethodBeat.i(230195);
            p.h(kVar, "property");
            float floatValue = f3.floatValue();
            f2.floatValue();
            AppBrandCircleProgressView.b(this.nSM).setStrokeWidth(floatValue);
            AppMethodBeat.o(230195);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t¸\u0006\u0000"}, hxF = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
    public static final class f extends kotlin.i.b<Float> {
        final /* synthetic */ Object mKT;
        final /* synthetic */ AppBrandCircleProgressView nSM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Object obj, Object obj2, AppBrandCircleProgressView appBrandCircleProgressView) {
            super(obj2);
            this.mKT = obj;
            this.nSM = appBrandCircleProgressView;
        }

        @Override // kotlin.i.b
        public final void a(kotlin.l.k<?> kVar, Float f2, Float f3) {
            AppMethodBeat.i(230196);
            p.h(kVar, "property");
            float floatValue = f3.floatValue();
            f2.floatValue();
            AppBrandCircleProgressView.d(this.nSM).setStrokeWidth(floatValue);
            AppMethodBeat.o(230196);
        }
    }

    public final void setProgress(int i2) {
        AppMethodBeat.i(230203);
        Log.d("AppBrandCircleProgressView", "hash = " + hashCode() + " progress = " + i2);
        this.progress = i2;
        AppMethodBeat.o(230203);
    }

    private final float getRadius() {
        AppMethodBeat.i(230220);
        float f2 = 0.0f;
        if (isLaidOut()) {
            f2 = Math.min(((float) getMeasuredHeight()) - (Math.max(getProgressWidth(), getDotWidth()) * 2.0f), ((float) getMeasuredWidth()) - (Math.max(getProgressWidth(), getDotWidth()) * 2.0f)) / 2.0f;
        }
        AppMethodBeat.o(230220);
        return f2;
    }

    public final void bWT() {
        AppMethodBeat.i(230221);
        this.nSH = 0;
        getAnimator().addUpdateListener(new l(this));
        getAnimator().start();
        AppMethodBeat.o(230221);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class l implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ AppBrandCircleProgressView nSM;

        l(AppBrandCircleProgressView appBrandCircleProgressView) {
            this.nSM = appBrandCircleProgressView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(230201);
            AppBrandCircleProgressView appBrandCircleProgressView = this.nSM;
            p.g(valueAnimator, "animation");
            appBrandCircleProgressView.nSH = valueAnimator.getCurrentPlayTime();
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(230201);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            this.nSM.nSI = AppBrandCircleProgressView.a(this.nSM) * ((float) Math.cos((double) floatValue));
            this.nSM.nSJ = AppBrandCircleProgressView.a(this.nSM) * ((float) Math.sin((double) floatValue));
            this.nSM.angle = (float) (((double) (floatValue * 360.0f)) / 6.283185307179586d);
            this.nSM.invalidate();
            AppMethodBeat.o(230201);
        }
    }

    public final void bWU() {
        AppMethodBeat.i(230222);
        this.nSv = 0;
        getAnimator().setDuration(1000L);
        this.lCq = 5;
        AppMethodBeat.o(230222);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(230223);
        p.h(canvas, "canvas");
        super.onDraw(canvas);
        if (this.nSI == 0.0f || this.nSJ == 0.0f) {
            AppMethodBeat.o(230223);
            return;
        }
        float measuredWidth = (float) getMeasuredWidth();
        float measuredHeight = (float) getMeasuredHeight();
        canvas.drawCircle(measuredWidth / 2.0f, measuredHeight / 2.0f, getRadius(), getCirclePaint());
        if (this.nSH <= ((long) this.nSv)) {
            canvas.drawCircle(this.nSI + getRadius() + Math.max(getProgressWidth(), getDotWidth()), this.nSJ + getRadius() + Math.max(getProgressWidth(), getDotWidth()), getDotWidth(), getDotPaint());
            AppMethodBeat.o(230223);
            return;
        }
        if (this.nSK < ((float) this.progress)) {
            this.nSK += (float) this.lCq;
        } else if (this.nSK <= 80.0f) {
            this.nSK += 0.5f;
        }
        canvas.drawArc((measuredWidth / 2.0f) - getRadius(), (measuredHeight / 2.0f) - getRadius(), getRadius() + (measuredWidth / 2.0f), (measuredHeight / 2.0f) + getRadius(), this.angle, (this.nSK * 360.0f) / 100.0f, false, getProgressPaint());
        if (this.nSK >= 100.0f) {
            getAnimator().cancel();
        }
        AppMethodBeat.o(230223);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(230224);
        super.onDetachedFromWindow();
        getAnimator().cancel();
        AppMethodBeat.o(230224);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "invoke"})
    static final class h extends q implements kotlin.g.a.a<ValueAnimator> {
        final /* synthetic */ AppBrandCircleProgressView nSM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(AppBrandCircleProgressView appBrandCircleProgressView) {
            super(0);
            this.nSM = appBrandCircleProgressView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ValueAnimator invoke() {
            AppMethodBeat.i(230197);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(-1.5707964f, 4.712389f);
            ofFloat.setRepeatMode(1);
            ofFloat.setRepeatCount(-1);
            ofFloat.setDuration(this.nSM.getAnimDuration());
            ofFloat.setInterpolator(new LinearInterpolator());
            AppMethodBeat.o(230197);
            return ofFloat;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"})
    static final class i extends q implements kotlin.g.a.a<Paint> {
        final /* synthetic */ AppBrandCircleProgressView nSM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(AppBrandCircleProgressView appBrandCircleProgressView) {
            super(0);
            this.nSM = appBrandCircleProgressView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Paint invoke() {
            AppMethodBeat.i(230198);
            Paint paint = new Paint(1);
            paint.setStrokeWidth(this.nSM.getCircleStrokeWidth());
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(this.nSM.getCircleColor());
            AppMethodBeat.o(230198);
            return paint;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"})
    static final class j extends q implements kotlin.g.a.a<Paint> {
        final /* synthetic */ AppBrandCircleProgressView nSM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(AppBrandCircleProgressView appBrandCircleProgressView) {
            super(0);
            this.nSM = appBrandCircleProgressView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Paint invoke() {
            AppMethodBeat.i(230199);
            Paint paint = new Paint(1);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setStrokeWidth(this.nSM.getCircleStrokeWidth());
            AppMethodBeat.o(230199);
            return paint;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"})
    static final class k extends q implements kotlin.g.a.a<Paint> {
        final /* synthetic */ AppBrandCircleProgressView nSM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(AppBrandCircleProgressView appBrandCircleProgressView) {
            super(0);
            this.nSM = appBrandCircleProgressView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Paint invoke() {
            AppMethodBeat.i(230200);
            Paint paint = new Paint(1);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.nSM.getProgressWidth());
            paint.setColor(this.nSM.getProgressColor());
            AppMethodBeat.o(230200);
            return paint;
        }
    }
}
