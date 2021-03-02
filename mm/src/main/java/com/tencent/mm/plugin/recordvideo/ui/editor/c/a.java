package com.tencent.mm.plugin.recordvideo.ui.editor.c;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0002J(\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0002J \u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0002JJ\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2:\b\u0002\u0010%\u001a4\u0012\u0013\u0012\u00110$¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110)¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\"\u0018\u00010&R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/MatrixChecker;", "", "()V", "bounds", "Landroid/graphics/RectF;", "getBounds", "()Landroid/graphics/RectF;", "setBounds", "(Landroid/graphics/RectF;)V", "maxScale", "", "getMaxScale", "()F", "setMaxScale", "(F)V", "minScale", "getMinScale", "setMinScale", "pivot", "", "getPivot", "()[F", "setPivot", "([F)V", "clamp", "value", "min", "max", "fallback", "interpolate", "from", "to", "input", "resolve", "", "matrix", "Landroid/graphics/Matrix;", "updateCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "animateFinish", "plugin-recordvideo_release"})
public final class a {
    public RectF CgM = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    float[] CgN = new float[2];
    public float aXt = 1.0f;
    public float aXu = 1.0f;

    public a() {
        AppMethodBeat.i(237927);
        AppMethodBeat.o(237927);
    }

    public final void f(RectF rectF) {
        AppMethodBeat.i(237923);
        p.h(rectF, "<set-?>");
        this.CgM = rectF;
        AppMethodBeat.o(237923);
    }

    public final void n(float[] fArr) {
        AppMethodBeat.i(237924);
        p.h(fArr, "<set-?>");
        this.CgN = fArr;
        AppMethodBeat.o(237924);
    }

    public final void a(Matrix matrix, m<? super Matrix, ? super Boolean, x> mVar) {
        AppMethodBeat.i(237925);
        p.h(matrix, "matrix");
        float[] fArr = new float[2];
        matrix.mapPoints(fArr, this.CgN);
        float[] fArr2 = {p(fArr[0], this.CgM.left, this.CgM.right), p(fArr[1], this.CgM.top, this.CgM.bottom)};
        float[] fArr3 = new float[9];
        matrix.getValues(fArr3);
        double d2 = (double) fArr3[0];
        double d3 = (double) fArr3[3];
        float sqrt = (float) Math.sqrt((d2 * d2) + (d3 * d3));
        float round = (float) Math.round(Math.atan2(d3, (double) fArr3[4]) * 57.29577951308232d);
        float p = p(sqrt, this.aXu, this.aXt);
        if (sqrt == p && fArr[0] == fArr2[0] && fArr[1] == fArr2[1]) {
            mVar.invoke(matrix, Boolean.TRUE);
            AppMethodBeat.o(237925);
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        p.g(ofFloat, "animator");
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new C1658a(this, sqrt, p, round, fArr, fArr2, mVar));
        ofFloat.start();
        AppMethodBeat.o(237925);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    /* renamed from: com.tencent.mm.plugin.recordvideo.ui.editor.c.a$a  reason: collision with other inner class name */
    static final class C1658a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ a CgO;
        final /* synthetic */ float CgP;
        final /* synthetic */ float CgQ;
        final /* synthetic */ float[] CgR;
        final /* synthetic */ float[] CgS;
        final /* synthetic */ m CgT;
        final /* synthetic */ float wrG;

        C1658a(a aVar, float f2, float f3, float f4, float[] fArr, float[] fArr2, m mVar) {
            this.CgO = aVar;
            this.wrG = f2;
            this.CgP = f3;
            this.CgQ = f4;
            this.CgR = fArr;
            this.CgS = fArr2;
            this.CgT = mVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            boolean z;
            AppMethodBeat.i(237922);
            a aVar = this.CgO;
            p.g(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(237922);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            Matrix matrix = new Matrix();
            matrix.setTranslate(-aVar.CgN[0], -aVar.CgN[1]);
            matrix.postScale(a.q(this.wrG, this.CgP, floatValue), a.q(this.wrG, this.CgP, floatValue));
            matrix.postRotate(this.CgQ);
            matrix.postTranslate(a.q(this.CgR[0], this.CgS[0], floatValue), a.q(this.CgR[1], this.CgS[1], floatValue));
            m mVar = this.CgT;
            if (mVar != null) {
                if (floatValue == 1.0f) {
                    z = true;
                } else {
                    z = false;
                }
                mVar.invoke(matrix, Boolean.valueOf(z));
                AppMethodBeat.o(237922);
                return;
            }
            AppMethodBeat.o(237922);
        }
    }

    private static float p(float f2, float f3, float f4) {
        AppMethodBeat.i(237926);
        float max = Math.max(f3, Math.min(f2, f4));
        AppMethodBeat.o(237926);
        return max;
    }

    public static final /* synthetic */ float q(float f2, float f3, float f4) {
        return (f3 * f4) + ((1.0f - f4) * f2);
    }
}
