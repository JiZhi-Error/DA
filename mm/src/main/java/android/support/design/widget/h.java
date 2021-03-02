package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.a.g;
import android.support.design.widget.o;
import android.support.v4.view.u;
import android.util.StateSet;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.mm.R;
import java.util.ArrayList;

public class h {
    static final int[] EMPTY_STATE_SET = new int[0];
    static final int[] ENABLED_STATE_SET = {16842910};
    static final int[] PRESSED_ENABLED_STATE_SET = {16842919, 16842910};
    static final int[] rH = {16843623, 16842908, 16842910};
    static final int[] rI = {16842908, 16842910};
    static final int[] rJ = {16843623, 16842910};
    static final TimeInterpolator rq = android.support.design.a.a.gM;
    float elevation;
    android.support.design.a.h iM;
    android.support.design.a.h iN;
    private final Rect mC = new Rect();
    private final RectF mD = new RectF();
    private final RectF mE = new RectF();
    b rA;
    Drawable rB;
    float rC;
    float rD;
    float rE = 1.0f;
    public ArrayList<Animator.AnimatorListener> rF;
    public ArrayList<Animator.AnimatorListener> rG;
    final VisibilityAwareImageButton rK;
    final m rL;
    private final Matrix rM = new Matrix();
    ViewTreeObserver.OnPreDrawListener rN;
    int rf;
    float rotation;
    int rs = 0;
    Animator rt;
    android.support.design.a.h ru;
    android.support.design.a.h rv;
    private final o rw;

    /* renamed from: rx  reason: collision with root package name */
    l f31rx;
    Drawable ry;
    Drawable rz;

    /* access modifiers changed from: package-private */
    public interface d {
    }

    h(VisibilityAwareImageButton visibilityAwareImageButton, m mVar) {
        this.rK = visibilityAwareImageButton;
        this.rL = mVar;
        this.rw = new o();
        this.rw.a(PRESSED_ENABLED_STATE_SET, a(new c()));
        this.rw.a(rH, a(new b()));
        this.rw.a(rI, a(new b()));
        this.rw.a(rJ, a(new b()));
        this.rw.a(ENABLED_STATE_SET, a(new e()));
        this.rw.a(EMPTY_STATE_SET, a(new a()));
        this.rotation = this.rK.getRotation();
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable[] drawableArr;
        this.ry = android.support.v4.graphics.drawable.a.i(cI());
        android.support.v4.graphics.drawable.a.a(this.ry, colorStateList);
        if (mode != null) {
            android.support.v4.graphics.drawable.a.a(this.ry, mode);
        }
        this.rz = android.support.v4.graphics.drawable.a.i(cI());
        android.support.v4.graphics.drawable.a.a(this.rz, android.support.design.e.a.b(colorStateList2));
        if (i2 > 0) {
            this.rA = a(i2, colorStateList);
            drawableArr = new Drawable[]{this.rA, this.ry, this.rz};
        } else {
            this.rA = null;
            drawableArr = new Drawable[]{this.ry, this.rz};
        }
        this.rB = new LayerDrawable(drawableArr);
        this.f31rx = new l(this.rK.getContext(), this.rB, this.rL.getRadius(), this.elevation, this.elevation + this.rD);
        l lVar = this.f31rx;
        lVar.tC = false;
        lVar.invalidateSelf();
        this.rL.setBackgroundDrawable(this.f31rx);
    }

    /* access modifiers changed from: package-private */
    public void setRippleColor(ColorStateList colorStateList) {
        if (this.rz != null) {
            android.support.v4.graphics.drawable.a.a(this.rz, android.support.design.e.a.b(colorStateList));
        }
    }

    /* access modifiers changed from: package-private */
    public final void setElevation(float f2) {
        if (this.elevation != f2) {
            this.elevation = f2;
            c(this.elevation, this.rC, this.rD);
        }
    }

    /* access modifiers changed from: package-private */
    public float getElevation() {
        return this.elevation;
    }

    /* access modifiers changed from: package-private */
    public final void p(float f2) {
        if (this.rC != f2) {
            this.rC = f2;
            c(this.elevation, this.rC, this.rD);
        }
    }

    /* access modifiers changed from: package-private */
    public final void q(float f2) {
        if (this.rD != f2) {
            this.rD = f2;
            c(this.elevation, this.rC, this.rD);
        }
    }

    /* access modifiers changed from: package-private */
    public final void cC() {
        r(this.rE);
    }

    /* access modifiers changed from: package-private */
    public final void r(float f2) {
        this.rE = f2;
        Matrix matrix = this.rM;
        a(f2, matrix);
        this.rK.setImageMatrix(matrix);
    }

    private void a(float f2, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.rK.getDrawable();
        if (drawable != null && this.rf != 0) {
            RectF rectF = this.mD;
            RectF rectF2 = this.mE;
            rectF.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            rectF2.set(0.0f, 0.0f, (float) this.rf, (float) this.rf);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            matrix.postScale(f2, f2, ((float) this.rf) / 2.0f, ((float) this.rf) / 2.0f);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(float f2, float f3, float f4) {
        if (this.f31rx != null) {
            this.f31rx.f(f2, this.rD + f2);
            cF();
        }
    }

    /* access modifiers changed from: package-private */
    public void d(int[] iArr) {
        o.a aVar;
        o oVar = this.rw;
        int size = oVar.tO.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                aVar = null;
                break;
            }
            aVar = oVar.tO.get(i2);
            if (StateSet.stateSetMatches(aVar.tT, iArr)) {
                break;
            }
            i2++;
        }
        if (aVar != oVar.tP) {
            if (!(oVar.tP == null || oVar.tQ == null)) {
                oVar.tQ.cancel();
                oVar.tQ = null;
            }
            oVar.tP = aVar;
            if (aVar != null) {
                oVar.tQ = aVar.animator;
                oVar.tQ.start();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void cD() {
        o oVar = this.rw;
        if (oVar.tQ != null) {
            oVar.tQ.end();
            oVar.tQ = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final AnimatorSet a(android.support.design.a.h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.rK, View.ALPHA, f2);
        hVar.j("opacity").a((Animator) ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.rK, View.SCALE_X, f3);
        hVar.j("scale").a((Animator) ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.rK, View.SCALE_Y, f3);
        hVar.j("scale").a((Animator) ofFloat3);
        arrayList.add(ofFloat3);
        a(f4, this.rM);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.rK, new android.support.design.a.f(), new g(), new Matrix(this.rM));
        hVar.j("iconScale").a((Animator) ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        android.support.design.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    /* access modifiers changed from: package-private */
    public void cE() {
    }

    /* access modifiers changed from: package-private */
    public final void cF() {
        Rect rect = this.mC;
        d(rect);
        e(rect);
        this.rL.e(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* access modifiers changed from: package-private */
    public void d(Rect rect) {
        this.f31rx.getPadding(rect);
    }

    /* access modifiers changed from: package-private */
    public void e(Rect rect) {
    }

    /* access modifiers changed from: package-private */
    public boolean cG() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final b a(int i2, ColorStateList colorStateList) {
        Context context = this.rK.getContext();
        b cH = cH();
        cH.b(android.support.v4.content.b.n(context, R.color.lf), android.support.v4.content.b.n(context, R.color.le), android.support.v4.content.b.n(context, R.color.lc), android.support.v4.content.b.n(context, R.color.ld));
        cH.setBorderWidth((float) i2);
        cH.c(colorStateList);
        return cH;
    }

    /* access modifiers changed from: package-private */
    public b cH() {
        return new b();
    }

    /* access modifiers changed from: package-private */
    public final GradientDrawable cI() {
        GradientDrawable cJ = cJ();
        cJ.setShape(1);
        cJ.setColor(-1);
        return cJ;
    }

    /* access modifiers changed from: package-private */
    public GradientDrawable cJ() {
        return new GradientDrawable();
    }

    public final boolean cK() {
        return this.rK.getVisibility() != 0 ? this.rs == 2 : this.rs != 1;
    }

    private static ValueAnimator a(f fVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(rq);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(fVar);
        valueAnimator.addUpdateListener(fVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    abstract class f extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private boolean rR;
        private float rS;
        private float rT;

        /* access modifiers changed from: protected */
        public abstract float cM();

        private f() {
        }

        /* synthetic */ f(h hVar, byte b2) {
            this();
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.rR) {
                this.rS = h.this.f31rx.ty;
                this.rT = cM();
                this.rR = true;
            }
            h.this.f31rx.t(this.rS + ((this.rT - this.rS) * valueAnimator.getAnimatedFraction()));
        }

        public void onAnimationEnd(Animator animator) {
            h.this.f31rx.t(this.rT);
            this.rR = false;
        }
    }

    class e extends f {
        e() {
            super(h.this, (byte) 0);
        }

        /* access modifiers changed from: protected */
        @Override // android.support.design.widget.h.f
        public final float cM() {
            return h.this.elevation;
        }
    }

    class b extends f {
        b() {
            super(h.this, (byte) 0);
        }

        /* access modifiers changed from: protected */
        @Override // android.support.design.widget.h.f
        public final float cM() {
            return h.this.elevation + h.this.rC;
        }
    }

    class c extends f {
        c() {
            super(h.this, (byte) 0);
        }

        /* access modifiers changed from: protected */
        @Override // android.support.design.widget.h.f
        public final float cM() {
            return h.this.elevation + h.this.rD;
        }
    }

    class a extends f {
        a() {
            super(h.this, (byte) 0);
        }

        /* access modifiers changed from: protected */
        @Override // android.support.design.widget.h.f
        public final float cM() {
            return 0.0f;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean cL() {
        return u.az(this.rK) && !this.rK.isInEditMode();
    }
}
