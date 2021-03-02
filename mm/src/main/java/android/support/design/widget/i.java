package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
public final class i extends h {
    private InsetDrawable rU;

    i(VisibilityAwareImageButton visibilityAwareImageButton, m mVar) {
        super(visibilityAwareImageButton, mVar);
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.design.widget.h
    public final void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable drawable;
        this.ry = android.support.v4.graphics.drawable.a.i(cI());
        android.support.v4.graphics.drawable.a.a(this.ry, colorStateList);
        if (mode != null) {
            android.support.v4.graphics.drawable.a.a(this.ry, mode);
        }
        if (i2 > 0) {
            this.rA = a(i2, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{this.rA, this.ry});
        } else {
            this.rA = null;
            drawable = this.ry;
        }
        this.rz = new RippleDrawable(android.support.design.e.a.b(colorStateList2), drawable, null);
        this.rB = this.rz;
        this.rL.setBackgroundDrawable(this.rz);
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.design.widget.h
    public final void setRippleColor(ColorStateList colorStateList) {
        if (this.rz instanceof RippleDrawable) {
            ((RippleDrawable) this.rz).setColor(android.support.design.e.a.b(colorStateList));
        } else {
            super.setRippleColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.design.widget.h
    public final void c(float f2, float f3, float f4) {
        if (Build.VERSION.SDK_INT == 21) {
            this.rK.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, d(f2, f4));
            stateListAnimator.addState(rH, d(f2, f3));
            stateListAnimator.addState(rI, d(f2, f3));
            stateListAnimator.addState(rJ, d(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.rK, "elevation", f2).setDuration(0L));
            if (Build.VERSION.SDK_INT >= 22 && Build.VERSION.SDK_INT <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(this.rK, View.TRANSLATION_Z, this.rK.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.rK, View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(rq);
            stateListAnimator.addState(ENABLED_STATE_SET, animatorSet);
            stateListAnimator.addState(EMPTY_STATE_SET, d(0.0f, 0.0f));
            this.rK.setStateListAnimator(stateListAnimator);
        }
        if (this.rL.cB()) {
            cF();
        }
    }

    private Animator d(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.rK, "elevation", f2).setDuration(0L)).with(ObjectAnimator.ofFloat(this.rK, View.TRANSLATION_Z, f3).setDuration(100L));
        animatorSet.setInterpolator(rq);
        return animatorSet;
    }

    @Override // android.support.design.widget.h
    public final float getElevation() {
        return this.rK.getElevation();
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.design.widget.h
    public final void cE() {
        cF();
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.design.widget.h
    public final void e(Rect rect) {
        if (this.rL.cB()) {
            this.rU = new InsetDrawable(this.rz, rect.left, rect.top, rect.right, rect.bottom);
            this.rL.setBackgroundDrawable(this.rU);
            return;
        }
        this.rL.setBackgroundDrawable(this.rz);
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.design.widget.h
    public final void d(int[] iArr) {
        if (Build.VERSION.SDK_INT != 21) {
            return;
        }
        if (this.rK.isEnabled()) {
            this.rK.setElevation(this.elevation);
            if (this.rK.isPressed()) {
                this.rK.setTranslationZ(this.rD);
            } else if (this.rK.isFocused() || this.rK.isHovered()) {
                this.rK.setTranslationZ(this.rC);
            } else {
                this.rK.setTranslationZ(0.0f);
            }
        } else {
            this.rK.setElevation(0.0f);
            this.rK.setTranslationZ(0.0f);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.design.widget.h
    public final void cD() {
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.design.widget.h
    public final boolean cG() {
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.design.widget.h
    public final b cH() {
        return new c();
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.design.widget.h
    public final GradientDrawable cJ() {
        return new a();
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.design.widget.h
    public final void d(Rect rect) {
        if (this.rL.cB()) {
            float radius = this.rL.getRadius();
            float elevation = this.rK.getElevation() + this.rD;
            int ceil = (int) Math.ceil((double) l.b(elevation, radius, false));
            int ceil2 = (int) Math.ceil((double) l.a(elevation, radius, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }

    static class a extends GradientDrawable {
        a() {
        }

        public final boolean isStateful() {
            return true;
        }
    }
}
