package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.a;
import android.support.design.a.h;
import android.support.design.c.c;
import android.support.design.internal.f;
import android.support.design.internal.g;
import android.support.design.stateful.ExtendableSavedState;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.h;
import android.support.v4.e.n;
import android.support.v4.view.s;
import android.support.v4.view.u;
import android.support.v7.widget.i;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.tencent.mm.R;
import java.util.Iterator;
import java.util.List;

@CoordinatorLayout.b(Behavior.class)
public class FloatingActionButton extends VisibilityAwareImageButton implements android.support.design.c.a, s, android.support.v4.widget.s {
    private PorterDuff.Mode hI;
    private ColorStateList hJ;
    private ColorStateList hL;
    private ColorStateList ra;
    private PorterDuff.Mode rb;
    private int rc;
    private int rd;
    private int re;
    private int rf;
    boolean rg;
    final Rect rh;
    private final Rect ri;
    private final i rj;
    private final c rk;
    private h rl;
    private int size;

    public static abstract class a {
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.lu);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.rh = new Rect();
        this.ri = new Rect();
        TypedArray a2 = f.a(context, attributeSet, a.C0008a.FloatingActionButton, i2, R.style.a3t, new int[0]);
        this.hJ = android.support.design.d.a.b(context, a2, 0);
        this.hI = g.a(a2.getInt(1, -1), null);
        this.hL = android.support.design.d.a.b(context, a2, 10);
        this.size = a2.getInt(5, -1);
        this.rd = a2.getDimensionPixelSize(4, 0);
        this.rc = a2.getDimensionPixelSize(2, 0);
        float dimension = a2.getDimension(3, 0.0f);
        float dimension2 = a2.getDimension(7, 0.0f);
        float dimension3 = a2.getDimension(9, 0.0f);
        this.rg = a2.getBoolean(12, false);
        this.rf = a2.getDimensionPixelSize(8, 0);
        h a3 = h.a(context, a2, 11);
        h a4 = h.a(context, a2, 6);
        a2.recycle();
        this.rj = new i(this);
        this.rj.a(attributeSet, i2);
        this.rk = new c(this);
        getImpl().a(this.hJ, this.hI, this.hL, this.rc);
        getImpl().setElevation(dimension);
        getImpl().p(dimension2);
        getImpl().q(dimension3);
        h impl = getImpl();
        int i3 = this.rf;
        if (impl.rf != i3) {
            impl.rf = i3;
            impl.cC();
        }
        getImpl().iM = a3;
        getImpl().iN = a4;
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int sizeDimension = getSizeDimension();
        this.re = (sizeDimension - this.rf) / 2;
        getImpl().cF();
        int min = Math.min(resolveAdjustedSize(sizeDimension, i2), resolveAdjustedSize(sizeDimension, i3));
        setMeasuredDimension(this.rh.left + min + this.rh.right, min + this.rh.top + this.rh.bottom);
    }

    @Deprecated
    public int getRippleColor() {
        if (this.hL != null) {
            return this.hL.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.hL;
    }

    public void setRippleColor(int i2) {
        setRippleColor(ColorStateList.valueOf(i2));
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.hL != colorStateList) {
            this.hL = colorStateList;
            getImpl().setRippleColor(this.hL);
        }
    }

    public ColorStateList getBackgroundTintList() {
        return this.hJ;
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.hJ != colorStateList) {
            this.hJ = colorStateList;
            h impl = getImpl();
            if (impl.ry != null) {
                android.support.v4.graphics.drawable.a.a(impl.ry, colorStateList);
            }
            if (impl.rA != null) {
                impl.rA.c(colorStateList);
            }
        }
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.hI;
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.hI != mode) {
            this.hI = mode;
            h impl = getImpl();
            if (impl.ry != null) {
                android.support.v4.graphics.drawable.a.a(impl.ry, mode);
            }
        }
    }

    @Override // android.support.v4.view.s
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // android.support.v4.view.s
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // android.support.v4.view.s
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // android.support.v4.view.s
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // android.support.v4.widget.s
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.ra != colorStateList) {
            this.ra = colorStateList;
            cA();
        }
    }

    @Override // android.support.v4.widget.s
    public ColorStateList getSupportImageTintList() {
        return this.ra;
    }

    @Override // android.support.v4.widget.s
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.rb != mode) {
            this.rb = mode;
            cA();
        }
    }

    @Override // android.support.v4.widget.s
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.rb;
    }

    private void cA() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (this.ra == null) {
                android.support.v4.graphics.drawable.a.h(drawable);
                return;
            }
            int colorForState = this.ra.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.rb;
            if (mode == null) {
                mode = PorterDuff.Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(android.support.v7.widget.g.b(colorForState, mode));
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setBackgroundResource(int i2) {
    }

    public void setBackgroundColor(int i2) {
    }

    public void setImageResource(int i2) {
        this.rj.setImageResource(i2);
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        getImpl().cC();
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar) {
        h hVar;
        h impl = getImpl();
        h.d c2 = c(aVar);
        if (!impl.cK()) {
            if (impl.rt != null) {
                impl.rt.cancel();
            }
            if (impl.cL()) {
                if (impl.rK.getVisibility() != 0) {
                    impl.rK.setAlpha(0.0f);
                    impl.rK.setScaleY(0.0f);
                    impl.rK.setScaleX(0.0f);
                    impl.r(0.0f);
                }
                if (impl.iM != null) {
                    hVar = impl.iM;
                } else {
                    if (impl.ru == null) {
                        impl.ru = android.support.design.a.h.k(impl.rK.getContext(), R.animator.f3009d);
                    }
                    hVar = impl.ru;
                }
                AnimatorSet a2 = impl.a(hVar, 1.0f, 1.0f, 1.0f);
                a2.addListener(new AnimatorListenerAdapter(c2) {
                    /* class android.support.design.widget.h.AnonymousClass2 */
                    final /* synthetic */ boolean rO = false;
                    final /* synthetic */ d rP;

                    {
                        this.rP = r3;
                    }

                    public final void onAnimationStart(Animator animator) {
                        h.this.rK.e(0, this.rO);
                        h.this.rs = 2;
                        h.this.rt = animator;
                    }

                    public final void onAnimationEnd(Animator animator) {
                        h.this.rs = 0;
                        h.this.rt = null;
                    }
                });
                if (impl.rF != null) {
                    Iterator<Animator.AnimatorListener> it = impl.rF.iterator();
                    while (it.hasNext()) {
                        a2.addListener(it.next());
                    }
                }
                a2.start();
                return;
            }
            impl.rK.e(0, false);
            impl.rK.setAlpha(1.0f);
            impl.rK.setScaleY(1.0f);
            impl.rK.setScaleX(1.0f);
            impl.r(1.0f);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(a aVar) {
        android.support.design.a.h hVar;
        boolean z = true;
        h impl = getImpl();
        h.d c2 = c(aVar);
        if (impl.rK.getVisibility() == 0) {
            if (impl.rs != 1) {
                z = false;
            }
        } else if (impl.rs == 2) {
            z = false;
        }
        if (!z) {
            if (impl.rt != null) {
                impl.rt.cancel();
            }
            if (impl.cL()) {
                if (impl.iN != null) {
                    hVar = impl.iN;
                } else {
                    if (impl.rv == null) {
                        impl.rv = android.support.design.a.h.k(impl.rK.getContext(), R.animator.f3008c);
                    }
                    hVar = impl.rv;
                }
                AnimatorSet a2 = impl.a(hVar, 0.0f, 0.0f, 0.0f);
                a2.addListener(new AnimatorListenerAdapter(c2) {
                    /* class android.support.design.widget.h.AnonymousClass1 */
                    private boolean cancelled;
                    final /* synthetic */ boolean rO = false;
                    final /* synthetic */ d rP;

                    {
                        this.rP = r3;
                    }

                    public final void onAnimationStart(Animator animator) {
                        h.this.rK.e(0, this.rO);
                        h.this.rs = 1;
                        h.this.rt = animator;
                        this.cancelled = false;
                    }

                    public final void onAnimationCancel(Animator animator) {
                        this.cancelled = true;
                    }

                    public final void onAnimationEnd(Animator animator) {
                        h.this.rs = 0;
                        h.this.rt = null;
                        if (!this.cancelled) {
                            h.this.rK.e(this.rO ? 8 : 4, this.rO);
                        }
                    }
                });
                if (impl.rG != null) {
                    Iterator<Animator.AnimatorListener> it = impl.rG.iterator();
                    while (it.hasNext()) {
                        a2.addListener(it.next());
                    }
                }
                a2.start();
                return;
            }
            impl.rK.e(4, false);
        }
    }

    @Override // android.support.design.c.b
    public final boolean bB() {
        return this.rk.jT;
    }

    public void setExpandedComponentIdHint(int i2) {
        this.rk.jU = i2;
    }

    public int getExpandedComponentIdHint() {
        return this.rk.jU;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.rg != z) {
            this.rg = z;
            getImpl().cE();
        }
    }

    public boolean getUseCompatPadding() {
        return this.rg;
    }

    public void setSize(int i2) {
        this.rd = 0;
        if (i2 != this.size) {
            this.size = i2;
            requestLayout();
        }
    }

    public int getSize() {
        return this.size;
    }

    private h.d c(final a aVar) {
        if (aVar == null) {
            return null;
        }
        return new h.d() {
            /* class android.support.design.widget.FloatingActionButton.AnonymousClass1 */
        };
    }

    public void setCustomSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        this.rd = i2;
    }

    public int getCustomSize() {
        return this.rd;
    }

    /* access modifiers changed from: package-private */
    public int getSizeDimension() {
        int i2 = this.size;
        while (this.rd == 0) {
            Resources resources = getResources();
            switch (i2) {
                case -1:
                    if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                case 0:
                default:
                    return resources.getDimensionPixelSize(R.dimen.za);
                case 1:
                    return resources.getDimensionPixelSize(R.dimen.z_);
            }
        }
        return this.rd;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h impl = getImpl();
        if (impl.cG()) {
            if (impl.rN == null) {
                impl.rN = new ViewTreeObserver.OnPreDrawListener() {
                    /* class android.support.design.widget.h.AnonymousClass3 */

                    public final boolean onPreDraw() {
                        h hVar = h.this;
                        float rotation = hVar.rK.getRotation();
                        if (hVar.rotation != rotation) {
                            hVar.rotation = rotation;
                            if (Build.VERSION.SDK_INT == 19) {
                                if (hVar.rotation % 90.0f != 0.0f) {
                                    if (hVar.rK.getLayerType() != 1) {
                                        hVar.rK.setLayerType(1, null);
                                    }
                                } else if (hVar.rK.getLayerType() != 0) {
                                    hVar.rK.setLayerType(0, null);
                                }
                            }
                            if (hVar.f31rx != null) {
                                l lVar = hVar.f31rx;
                                float f2 = -hVar.rotation;
                                if (lVar.rotation != f2) {
                                    lVar.rotation = f2;
                                    lVar.invalidateSelf();
                                }
                            }
                            if (hVar.rA != null) {
                                b bVar = hVar.rA;
                                float f3 = -hVar.rotation;
                                if (f3 != bVar.rotation) {
                                    bVar.rotation = f3;
                                    bVar.invalidateSelf();
                                }
                            }
                        }
                        return true;
                    }
                };
            }
            impl.rK.getViewTreeObserver().addOnPreDrawListener(impl.rN);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h impl = getImpl();
        if (impl.rN != null) {
            impl.rK.getViewTreeObserver().removeOnPreDrawListener(impl.rN);
            impl.rN = null;
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().d(getDrawableState());
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().cD();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(super.onSaveInstanceState());
        n<String, Bundle> nVar = extendableSavedState.mv;
        c cVar = this.rk;
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", cVar.jT);
        bundle.putInt("expandedComponentIdHint", cVar.jU);
        nVar.put("expandableWidgetHelper", bundle);
        return extendableSavedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.Pm);
        c cVar = this.rk;
        Bundle bundle = extendableSavedState.mv.get("expandableWidgetHelper");
        cVar.jT = bundle.getBoolean("expanded", false);
        cVar.jU = bundle.getInt("expandedComponentIdHint", 0);
        if (cVar.jT) {
            ViewParent parent = cVar.jS.getParent();
            if (parent instanceof CoordinatorLayout) {
                ((CoordinatorLayout) parent).s(cVar.jS);
            }
        }
    }

    @Deprecated
    public final boolean b(Rect rect) {
        if (!u.az(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        c(rect);
        return true;
    }

    public final void c(Rect rect) {
        rect.left += this.rh.left;
        rect.top += this.rh.top;
        rect.right -= this.rh.right;
        rect.bottom -= this.rh.bottom;
    }

    public Drawable getContentBackground() {
        return getImpl().rB;
    }

    private static int resolveAdjustedSize(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i2, size2);
            case 0:
                return i2;
            case 1073741824:
                return size2;
            default:
                throw new IllegalArgumentException();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !b(this.ri) || this.ri.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        @Override // android.support.design.widget.FloatingActionButton.BaseBehavior, android.support.design.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ void a(CoordinatorLayout.d dVar) {
            super.a(dVar);
        }

        @Override // android.support.design.widget.FloatingActionButton.BaseBehavior
        public final /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i2) {
            return super.a(coordinatorLayout, floatingActionButton, i2);
        }

        @Override // android.support.design.widget.FloatingActionButton.BaseBehavior
        public final /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.a(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // android.support.design.widget.FloatingActionButton.BaseBehavior
        public final /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.a(coordinatorLayout, floatingActionButton, view);
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private Rect mC;
        private a ro;
        private boolean rp;

        public BaseBehavior() {
            this.rp = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0008a.FloatingActionButton_Behavior_Layout);
            this.rp = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public void a(CoordinatorLayout.d dVar) {
            if (dVar.qH == 0) {
                dVar.qH = 80;
            }
        }

        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (!v(view)) {
                return false;
            } else {
                b(view, floatingActionButton);
                return false;
            }
        }

        private static boolean v(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.d) {
                return ((CoordinatorLayout.d) layoutParams).qC instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean a(View view, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.d dVar = (CoordinatorLayout.d) floatingActionButton.getLayoutParams();
            if (!this.rp) {
                return false;
            }
            if (dVar.qF != view.getId()) {
                return false;
            }
            if (floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            return true;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!a((View) appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.mC == null) {
                this.mC = new Rect();
            }
            Rect rect = this.mC;
            f.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.b(this.ro);
            } else {
                floatingActionButton.a(this.ro);
            }
            return true;
        }

        private boolean b(View view, FloatingActionButton floatingActionButton) {
            if (!a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < ((CoordinatorLayout.d) floatingActionButton.getLayoutParams()).topMargin + (floatingActionButton.getHeight() / 2)) {
                floatingActionButton.b(this.ro);
            } else {
                floatingActionButton.a(this.ro);
            }
            return true;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i2) {
            int i3;
            int i4 = 0;
            List<View> t = coordinatorLayout.t(floatingActionButton);
            int size = t.size();
            for (int i5 = 0; i5 < size; i5++) {
                View view = t.get(i5);
                if (!(view instanceof AppBarLayout)) {
                    if (v(view) && b(view, floatingActionButton)) {
                        break;
                    }
                } else if (a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.g(floatingActionButton, i2);
            Rect rect = floatingActionButton.rh;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return true;
            }
            CoordinatorLayout.d dVar = (CoordinatorLayout.d) floatingActionButton.getLayoutParams();
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - dVar.rightMargin) {
                i3 = rect.right;
            } else if (floatingActionButton.getLeft() <= dVar.leftMargin) {
                i3 = -rect.left;
            } else {
                i3 = 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - dVar.bottomMargin) {
                i4 = rect.bottom;
            } else if (floatingActionButton.getTop() <= dVar.topMargin) {
                i4 = -rect.top;
            }
            if (i4 != 0) {
                u.s(floatingActionButton, i4);
            }
            if (i3 == 0) {
                return true;
            }
            u.u(floatingActionButton, i3);
            return true;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.rh;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }
    }

    public float getCompatElevation() {
        return getImpl().getElevation();
    }

    public void setCompatElevation(float f2) {
        getImpl().setElevation(f2);
    }

    public void setCompatElevationResource(int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().rC;
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        getImpl().p(f2);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().rD;
    }

    public void setCompatPressedTranslationZ(float f2) {
        getImpl().q(f2);
    }

    public void setCompatPressedTranslationZResource(int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public android.support.design.a.h getShowMotionSpec() {
        return getImpl().iM;
    }

    public void setShowMotionSpec(android.support.design.a.h hVar) {
        getImpl().iM = hVar;
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(android.support.design.a.h.k(getContext(), i2));
    }

    public android.support.design.a.h getHideMotionSpec() {
        return getImpl().iN;
    }

    public void setHideMotionSpec(android.support.design.a.h hVar) {
        getImpl().iN = hVar;
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(android.support.design.a.h.k(getContext(), i2));
    }

    public h getImpl() {
        h hVar;
        if (this.rl == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                hVar = new i(this, new b());
            } else {
                hVar = new h(this, new b());
            }
            this.rl = hVar;
        }
        return this.rl;
    }

    /* access modifiers changed from: package-private */
    public class b implements m {
        b() {
        }

        @Override // android.support.design.widget.m
        public final float getRadius() {
            return ((float) FloatingActionButton.this.getSizeDimension()) / 2.0f;
        }

        @Override // android.support.design.widget.m
        public final void e(int i2, int i3, int i4, int i5) {
            FloatingActionButton.this.rh.set(i2, i3, i4, i5);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(floatingActionButton.re + i2, FloatingActionButton.this.re + i3, FloatingActionButton.this.re + i4, FloatingActionButton.this.re + i5);
        }

        @Override // android.support.design.widget.m
        public final void setBackgroundDrawable(Drawable drawable) {
            FloatingActionButton.super.setBackgroundDrawable(drawable);
        }

        @Override // android.support.design.widget.m
        public final boolean cB() {
            return FloatingActionButton.this.rg;
        }
    }
}
