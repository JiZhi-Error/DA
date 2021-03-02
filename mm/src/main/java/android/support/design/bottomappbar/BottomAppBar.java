package android.support.design.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.a;
import android.support.design.behavior.HideBottomViewOnScrollBehavior;
import android.support.design.f.c;
import android.support.design.f.e;
import android.support.design.internal.f;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.h;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.u;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.List;

public class BottomAppBar extends Toolbar implements CoordinatorLayout.a {
    private final int he;
    private final c hf;
    private final a hg;
    private Animator hh;
    private Animator hi;
    private Animator hj;
    private int hk;
    private boolean hl;
    private boolean hm;
    AnimatorListenerAdapter hn;

    static /* synthetic */ void a(BottomAppBar bottomAppBar, boolean z) {
        boolean z2;
        if (u.az(bottomAppBar)) {
            if (bottomAppBar.hh != null) {
                bottomAppBar.hh.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!z || !bottomAppBar.aV()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                bottomAppBar.hg.hx = bottomAppBar.getFabTranslationX();
            }
            float[] fArr = new float[2];
            fArr[0] = bottomAppBar.hf.ma;
            fArr[1] = z2 ? 1.0f : 0.0f;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class android.support.design.bottomappbar.BottomAppBar.AnonymousClass6 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BottomAppBar.this.hf.i(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            ofFloat.setDuration(300L);
            arrayList.add(ofFloat);
            FloatingActionButton aU = bottomAppBar.aU();
            if (aU != null) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aU, "translationY", bottomAppBar.m(z));
                ofFloat2.setDuration(300L);
                arrayList.add(ofFloat2);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            bottomAppBar.hh = animatorSet;
            bottomAppBar.hh.addListener(new AnimatorListenerAdapter() {
                /* class android.support.design.bottomappbar.BottomAppBar.AnonymousClass5 */

                public final void onAnimationEnd(Animator animator) {
                    BottomAppBar.this.hh = null;
                }
            });
            bottomAppBar.hh.start();
        }
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.cg);
    }

    public BottomAppBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.hm = true;
        this.hn = new AnimatorListenerAdapter() {
            /* class android.support.design.bottomappbar.BottomAppBar.AnonymousClass7 */

            public final void onAnimationStart(Animator animator) {
                BottomAppBar.a(BottomAppBar.this, BottomAppBar.this.hm);
                BottomAppBar.this.b(BottomAppBar.this.hk, BottomAppBar.this.hm);
            }
        };
        TypedArray a2 = f.a(context, attributeSet, a.C0008a.BottomAppBar, i2, R.style.a3z, new int[0]);
        ColorStateList b2 = android.support.design.d.a.b(context, a2, 0);
        this.hk = a2.getInt(1, 0);
        this.hl = a2.getBoolean(5, false);
        a2.recycle();
        this.he = getResources().getDimensionPixelOffset(R.dimen.adp);
        this.hg = new a((float) a2.getDimensionPixelOffset(2, 0), (float) a2.getDimensionPixelOffset(3, 0), (float) a2.getDimensionPixelOffset(4, 0));
        e eVar = new e();
        eVar.mr = this.hg;
        this.hf = new c(eVar);
        c cVar = this.hf;
        cVar.lY = true;
        cVar.invalidateSelf();
        c cVar2 = this.hf;
        cVar2.mc = Paint.Style.FILL;
        cVar2.invalidateSelf();
        android.support.v4.graphics.drawable.a.a(this.hf, b2);
        u.a(this, this.hf);
    }

    public int getFabAlignmentMode() {
        return this.hk;
    }

    public void setFabAlignmentMode(int i2) {
        if (this.hk != i2 && u.az(this)) {
            if (this.hi != null) {
                this.hi.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.hm) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(this.hg.hx, (float) C(i2));
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class android.support.design.bottomappbar.BottomAppBar.AnonymousClass2 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        BottomAppBar.this.hg.hx = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        BottomAppBar.this.hf.invalidateSelf();
                    }
                });
                ofFloat.setDuration(300L);
                arrayList.add(ofFloat);
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aU(), "translationX", (float) C(i2));
            ofFloat2.setDuration(300L);
            arrayList.add(ofFloat2);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.hi = animatorSet;
            this.hi.addListener(new AnimatorListenerAdapter() {
                /* class android.support.design.bottomappbar.BottomAppBar.AnonymousClass1 */

                public final void onAnimationEnd(Animator animator) {
                    BottomAppBar.this.hi = null;
                }
            });
            this.hi.start();
        }
        b(i2, this.hm);
        this.hk = i2;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        android.support.v4.graphics.drawable.a.a(this.hf, colorStateList);
    }

    public ColorStateList getBackgroundTint() {
        return this.hf.md;
    }

    public float getFabCradleMargin() {
        return this.hg.hu;
    }

    public void setFabCradleMargin(float f2) {
        if (f2 != getFabCradleMargin()) {
            this.hg.hu = f2;
            this.hf.invalidateSelf();
        }
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.hg.ht;
    }

    public void setFabCradleRoundedCornerRadius(float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            this.hg.ht = f2;
            this.hf.invalidateSelf();
        }
    }

    public float getCradleVerticalOffset() {
        return this.hg.hw;
    }

    public void setCradleVerticalOffset(float f2) {
        if (f2 != getCradleVerticalOffset()) {
            this.hg.hw = f2;
            this.hf.invalidateSelf();
        }
    }

    public boolean getHideOnScroll() {
        return this.hl;
    }

    public void setHideOnScroll(boolean z) {
        this.hl = z;
    }

    /* access modifiers changed from: package-private */
    public void setFabDiameter(int i2) {
        if (((float) i2) != this.hg.hv) {
            this.hg.hv = (float) i2;
            this.hf.invalidateSelf();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private FloatingActionButton aU() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).u(this)) {
            if (view instanceof FloatingActionButton) {
                return (FloatingActionButton) view;
            }
        }
        return null;
    }

    private boolean aV() {
        FloatingActionButton aU = aU();
        return aU != null && aU.getImpl().cK();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(int i2, boolean z) {
        if (u.az(this)) {
            if (this.hj != null) {
                this.hj.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!aV()) {
                z = false;
                i2 = 0;
            }
            a(i2, z, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.hj = animatorSet;
            this.hj.addListener(new AnimatorListenerAdapter() {
                /* class android.support.design.bottomappbar.BottomAppBar.AnonymousClass3 */

                public final void onAnimationEnd(Animator animator) {
                    BottomAppBar.this.hj = null;
                }
            });
            this.hj.start();
        }
    }

    private void a(final int i2, final boolean z, List<Animator> list) {
        final ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            Animator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
            if ((this.hm || (z && aV())) && (this.hk == 1 || i2 == 1)) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                ofFloat2.addListener(new AnimatorListenerAdapter() {
                    /* class android.support.design.bottomappbar.BottomAppBar.AnonymousClass4 */
                    public boolean cancelled;

                    public final void onAnimationCancel(Animator animator) {
                        this.cancelled = true;
                    }

                    public final void onAnimationEnd(Animator animator) {
                        if (!this.cancelled) {
                            BottomAppBar.this.a((BottomAppBar) actionMenuView, (ActionMenuView) i2, (int) z);
                        }
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(150L);
                animatorSet.playSequentially(ofFloat2, ofFloat);
                list.add(animatorSet);
            } else if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        }
    }

    private float m(boolean z) {
        FloatingActionButton aU = aU();
        if (aU == null) {
            return 0.0f;
        }
        Rect rect = new Rect();
        aU.b(rect);
        float height = (float) rect.height();
        if (height == 0.0f) {
            height = (float) aU.getMeasuredHeight();
        }
        float height2 = (height / 2.0f) + (-getCradleVerticalOffset()) + ((float) (aU.getHeight() - rect.bottom));
        float height3 = ((float) (aU.getHeight() - rect.height())) - ((float) aU.getPaddingBottom());
        float f2 = (float) (-getMeasuredHeight());
        if (!z) {
            height2 = height3;
        }
        return height2 + f2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private float getFabTranslationY() {
        return m(this.hm);
    }

    private int C(int i2) {
        boolean z;
        int i3 = 1;
        if (u.Z(this) == 1) {
            z = true;
        } else {
            z = false;
        }
        if (i2 != 1) {
            return 0;
        }
        int measuredWidth = (getMeasuredWidth() / 2) - this.he;
        if (z) {
            i3 = -1;
        }
        return i3 * measuredWidth;
    }

    private float getFabTranslationX() {
        return (float) C(this.hk);
    }

    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(ActionMenuView actionMenuView, int i2, boolean z) {
        boolean z2 = u.Z(this) == 1;
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & 8388615) == 8388611) {
                i3 = Math.max(i3, z2 ? childAt.getLeft() : childAt.getRight());
            }
        }
        actionMenuView.setTranslationX((i2 != 1 || !z) ? 0.0f : (float) (i3 - (z2 ? actionMenuView.getRight() : actionMenuView.getLeft())));
    }

    @Override // android.support.v7.widget.Toolbar
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.hh != null) {
            this.hh.cancel();
        }
        if (this.hj != null) {
            this.hj.cancel();
        }
        if (this.hi != null) {
            this.hi.cancel();
        }
        aW();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void aW() {
        this.hg.hx = getFabTranslationX();
        FloatingActionButton aU = aU();
        this.hf.i((!this.hm || !aV()) ? 0.0f : 1.0f);
        if (aU != null) {
            aU.setTranslationY(getFabTranslationY());
            aU.setTranslationX(getFabTranslationX());
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            actionMenuView.setAlpha(1.0f);
            if (!aV()) {
                a(actionMenuView, 0, false);
            } else {
                a(actionMenuView, this.hk, this.hm);
            }
        }
    }

    @Override // android.support.v7.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    @Override // android.support.v7.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // android.support.design.widget.CoordinatorLayout.a
    public CoordinatorLayout.Behavior<BottomAppBar> getBehavior() {
        return new Behavior();
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        private final Rect hs = new Rect();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.design.widget.CoordinatorLayout, android.view.View, int] */
        @Override // android.support.design.behavior.HideBottomViewOnScrollBehavior, android.support.design.widget.CoordinatorLayout.Behavior
        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i2) {
            BottomAppBar bottomAppBar2 = bottomAppBar;
            FloatingActionButton aU = bottomAppBar2.aU();
            if (aU != null) {
                ((CoordinatorLayout.d) aU.getLayoutParams()).anchorGravity = 17;
                BottomAppBar.a(bottomAppBar2, aU);
                Rect rect = this.hs;
                rect.set(0, 0, aU.getMeasuredWidth(), aU.getMeasuredHeight());
                aU.c(rect);
                bottomAppBar2.setFabDiameter(this.hs.height());
            }
            if (!BottomAppBar.i(bottomAppBar2)) {
                bottomAppBar2.aW();
            }
            coordinatorLayout.g(bottomAppBar2, i2);
            return super.a(coordinatorLayout, bottomAppBar2, i2);
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i3) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            return bottomAppBar.getHideOnScroll() && super.a(coordinatorLayout, bottomAppBar, view2, view3, i2, i3);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View] */
        @Override // android.support.design.behavior.HideBottomViewOnScrollBehavior
        public final /* synthetic */ void b(BottomAppBar bottomAppBar) {
            BottomAppBar bottomAppBar2 = bottomAppBar;
            super.b(bottomAppBar2);
            FloatingActionButton aU = bottomAppBar2.aU();
            if (aU != null) {
                aU.clearAnimation();
                aU.animate().translationY(bottomAppBar2.getFabTranslationY()).setInterpolator(android.support.design.a.a.gN).setDuration(225);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View] */
        @Override // android.support.design.behavior.HideBottomViewOnScrollBehavior
        public final /* synthetic */ void c(BottomAppBar bottomAppBar) {
            BottomAppBar bottomAppBar2 = bottomAppBar;
            super.c(bottomAppBar2);
            FloatingActionButton aU = bottomAppBar2.aU();
            if (aU != null) {
                aU.b(this.hs);
                aU.clearAnimation();
                aU.animate().translationY(((float) (-aU.getPaddingBottom())) + ((float) (aU.getMeasuredHeight() - this.hs.height()))).setInterpolator(android.support.design.a.a.gM).setDuration(175);
            }
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    @Override // android.support.v7.widget.Toolbar
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.hk = this.hk;
        savedState.hm = this.hm;
        return savedState;
    }

    @Override // android.support.v7.widget.Toolbar
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.Pm);
        this.hk = savedState.hk;
        this.hm = savedState.hm;
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class android.support.design.bottomappbar.BottomAppBar.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        int hk;
        boolean hm;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.hk = parcel.readInt();
            this.hm = parcel.readInt() != 0;
        }

        @Override // android.support.v4.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.hk);
            parcel.writeInt(this.hm ? 1 : 0);
        }
    }

    static /* synthetic */ void a(BottomAppBar bottomAppBar, FloatingActionButton floatingActionButton) {
        AnimatorListenerAdapter animatorListenerAdapter = bottomAppBar.hn;
        h impl = floatingActionButton.getImpl();
        if (impl.rG != null) {
            impl.rG.remove(animatorListenerAdapter);
        }
        AnimatorListenerAdapter animatorListenerAdapter2 = bottomAppBar.hn;
        h impl2 = floatingActionButton.getImpl();
        if (impl2.rF != null) {
            impl2.rF.remove(animatorListenerAdapter2);
        }
        AnimatorListenerAdapter animatorListenerAdapter3 = bottomAppBar.hn;
        h impl3 = floatingActionButton.getImpl();
        if (impl3.rG == null) {
            impl3.rG = new ArrayList<>();
        }
        impl3.rG.add(animatorListenerAdapter3);
        AnimatorListenerAdapter animatorListenerAdapter4 = bottomAppBar.hn;
        h impl4 = floatingActionButton.getImpl();
        if (impl4.rF == null) {
            impl4.rF = new ArrayList<>();
        }
        impl4.rF.add(animatorListenerAdapter4);
    }

    static /* synthetic */ boolean i(BottomAppBar bottomAppBar) {
        return (bottomAppBar.hh != null && bottomAppBar.hh.isRunning()) || (bottomAppBar.hj != null && bottomAppBar.hj.isRunning()) || (bottomAppBar.hi != null && bottomAppBar.hi.isRunning());
    }
}
