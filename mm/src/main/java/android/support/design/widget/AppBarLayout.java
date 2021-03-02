package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.a;
import android.support.design.internal.f;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.e.j;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ac;
import android.support.v4.view.p;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@CoordinatorLayout.b(Behavior.class)
public class AppBarLayout extends LinearLayout {
    List<a> listeners;
    private int mS;
    private int mT;
    private int mU;
    boolean mV;
    int mW;
    ac mZ;
    private boolean na;
    private boolean nb;
    private boolean nc;
    boolean nd;
    private int[] ne;

    public interface a<T extends AppBarLayout> {
        void c(T t, int i2);
    }

    public interface b extends a<AppBarLayout> {
        @Override // android.support.design.widget.AppBarLayout.a
        void c(AppBarLayout appBarLayout, int i2);
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mS = -1;
        this.mT = -1;
        this.mU = -1;
        this.mW = 0;
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            q.B(this);
            q.a(this, attributeSet);
        }
        TypedArray a2 = f.a(context, attributeSet, a.C0008a.AppBarLayout, 0, R.style.a3p, new int[0]);
        u.a(this, a2.getDrawable(0));
        if (a2.hasValue(4)) {
            b(a2.getBoolean(4, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && a2.hasValue(3)) {
            q.c(this, (float) a2.getDimensionPixelSize(3, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (a2.hasValue(2)) {
                setKeyboardNavigationCluster(a2.getBoolean(2, false));
            }
            if (a2.hasValue(1)) {
                setTouchscreenBlocksFocus(a2.getBoolean(1, false));
            }
        }
        this.nd = a2.getBoolean(5, false);
        a2.recycle();
        u.a(this, new p() {
            /* class android.support.design.widget.AppBarLayout.AnonymousClass1 */

            @Override // android.support.v4.view.p
            public final ac a(View view, ac acVar) {
                AppBarLayout appBarLayout = AppBarLayout.this;
                ac acVar2 = null;
                if (u.aq(appBarLayout)) {
                    acVar2 = acVar;
                }
                if (!j.equals(appBarLayout.mZ, acVar2)) {
                    appBarLayout.mZ = acVar2;
                    appBarLayout.bN();
                }
                return acVar;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        bN();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        /*
        // Method dump skipped, instructions count: 101
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.AppBarLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public final void bN() {
        this.mS = -1;
        this.mT = -1;
        this.mU = -1;
    }

    public void setOrientation(int i2) {
        if (i2 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i2);
    }

    public void setExpanded(boolean z) {
        b(z, u.az(this), true);
    }

    public final void bO() {
        b(true, true, true);
    }

    public final void b(boolean z, boolean z2, boolean z3) {
        int i2 = 0;
        int i3 = (z2 ? 4 : 0) | (z ? 1 : 2);
        if (z3) {
            i2 = 8;
        }
        this.mW = i2 | i3;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private static LayoutParams bP() {
        return new LayoutParams(-2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    private static LayoutParams a(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public final int getTotalScrollRange() {
        int i2;
        if (this.mS != -1) {
            return this.mS;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = layoutParams.nu;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += layoutParams.bottomMargin + measuredHeight + layoutParams.topMargin;
            if ((i5 & 2) != 0) {
                i2 = i4 - u.ag(childAt);
                break;
            }
            i3++;
        }
        i2 = i4;
        int max = Math.max(0, i2 - getTopInset());
        this.mS = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedPreScrollRange() {
        int i2;
        if (this.mT != -1) {
            return this.mT;
        }
        int childCount = getChildCount() - 1;
        int i3 = 0;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = layoutParams.nu;
            if ((i4 & 5) != 5) {
                if (i3 > 0) {
                    break;
                }
                i2 = i3;
            } else {
                int i5 = layoutParams.bottomMargin + layoutParams.topMargin + i3;
                if ((i4 & 8) != 0) {
                    i2 = i5 + u.ag(childAt);
                } else if ((i4 & 2) != 0) {
                    i2 = i5 + (measuredHeight - u.ag(childAt));
                } else {
                    i2 = i5 + (measuredHeight - getTopInset());
                }
            }
            childCount--;
            i3 = i2;
        }
        int max = Math.max(0, i3);
        this.mT = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedScrollRange() {
        int i2;
        if (this.mU != -1) {
            return this.mU;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int i5 = layoutParams.nu;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight;
            if ((i5 & 2) != 0) {
                i2 = i4 - (u.ag(childAt) + getTopInset());
                break;
            }
            i3++;
        }
        i2 = i4;
        int max = Math.max(0, i2);
        this.mU = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public final void F(int i2) {
        if (this.listeners != null) {
            int size = this.listeners.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = this.listeners.get(i3);
                if (aVar != null) {
                    aVar.c(this, i2);
                }
            }
        }
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int ag = u.ag(this);
        if (ag != 0) {
            return (ag * 2) + topInset;
        }
        int childCount = getChildCount();
        int ag2 = childCount > 0 ? u.ag(getChildAt(childCount - 1)) : 0;
        if (ag2 != 0) {
            return (ag2 * 2) + topInset;
        }
        return getHeight() / 3;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        if (this.ne == null) {
            this.ne = new int[4];
        }
        int[] iArr = this.ne;
        int[] onCreateDrawableState = super.onCreateDrawableState(iArr.length + i2);
        iArr[0] = this.nb ? R.attr.a02 : -2130969566;
        iArr[1] = (!this.nb || !this.nc) ? -2130969567 : R.attr.a03;
        iArr[2] = this.nb ? R.attr.a01 : -2130969565;
        iArr[3] = (!this.nb || !this.nc) ? -2130969564 : R.attr.a00;
        return mergeDrawableStates(onCreateDrawableState, iArr);
    }

    /* access modifiers changed from: package-private */
    public final boolean t(boolean z) {
        if (this.nc == z) {
            return false;
        }
        this.nc = z;
        refreshDrawableState();
        return true;
    }

    public void setLiftOnScroll(boolean z) {
        this.nd = z;
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            q.c(this, f2);
        }
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public int getPendingAction() {
        return this.mW;
    }

    /* access modifiers changed from: package-private */
    public final int getTopInset() {
        if (this.mZ != null) {
            return this.mZ.getSystemWindowInsetTop();
        }
        return 0;
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public int nu = 1;
        Interpolator nv;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0008a.AppBarLayout_Layout);
            this.nu = obtainStyledAttributes.getInt(0, 0);
            if (obtainStyledAttributes.hasValue(1)) {
                this.nv = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(1, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i2) {
            super(-1, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {

        public static abstract class a extends BaseBehavior.a<AppBarLayout> {
        }

        @Override // android.support.design.widget.ViewOffsetBehavior
        public final /* bridge */ /* synthetic */ boolean G(int i2) {
            return super.G(i2);
        }

        @Override // android.support.design.widget.AppBarLayout.BaseBehavior
        public final /* bridge */ /* synthetic */ void a(BaseBehavior.a aVar) {
            super.a(aVar);
        }

        @Override // android.support.design.widget.AppBarLayout.BaseBehavior
        public final /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.a(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // android.support.design.widget.AppBarLayout.BaseBehavior
        public final /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2) {
            super.a(coordinatorLayout, appBarLayout, view, i2);
        }

        @Override // android.support.design.widget.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int i4, int i5, int i6) {
            super.a(coordinatorLayout, appBarLayout, view, i2, i3, i4, i5, i6);
        }

        @Override // android.support.design.widget.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
            super.a(coordinatorLayout, appBarLayout, view, i2, i3, iArr, i4);
        }

        @Override // android.support.design.widget.AppBarLayout.BaseBehavior
        public final /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2, int i3, int i4, int i5) {
            return super.a(coordinatorLayout, appBarLayout, i2, i3, i4, i5);
        }

        @Override // android.support.design.widget.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i2, int i3) {
            return super.a(coordinatorLayout, appBarLayout, view, view2, i2, i3);
        }

        @Override // android.support.design.widget.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2) {
            return super.a(coordinatorLayout, appBarLayout, i2);
        }

        @Override // android.support.design.widget.ViewOffsetBehavior
        public final /* bridge */ /* synthetic */ int bT() {
            return super.bT();
        }

        @Override // android.support.design.widget.AppBarLayout.BaseBehavior
        public final /* bridge */ /* synthetic */ Parcelable c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.b(coordinatorLayout, appBarLayout);
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private int ng;
        private int nh;
        private ValueAnimator ni;
        private int nj = -1;
        private boolean nk;
        private float nl;
        private WeakReference<View> nm;
        private a nn;

        public static abstract class a<T extends AppBarLayout> {
            public abstract boolean bS();
        }

        /* access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderBehavior
        public final /* synthetic */ int a(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int bQ = bQ();
            if (i3 == 0 || bQ < i3 || bQ > i4) {
                this.ng = 0;
                return 0;
            }
            int clamp = android.support.v4.b.a.clamp(i2, i3, i4);
            if (bQ == clamp) {
                return 0;
            }
            if (appBarLayout.mV) {
                int abs = Math.abs(clamp);
                int childCount = appBarLayout.getChildCount();
                int i8 = 0;
                while (true) {
                    if (i8 >= childCount) {
                        break;
                    }
                    View childAt = appBarLayout.getChildAt(i8);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    Interpolator interpolator = layoutParams.nv;
                    if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                        i8++;
                    } else if (interpolator != null) {
                        int i9 = layoutParams.nu;
                        if ((i9 & 1) != 0) {
                            i7 = layoutParams.bottomMargin + childAt.getHeight() + layoutParams.topMargin + 0;
                            if ((i9 & 2) != 0) {
                                i7 -= u.ag(childAt);
                            }
                        } else {
                            i7 = 0;
                        }
                        if (u.aq(childAt)) {
                            i7 -= appBarLayout.getTopInset();
                        }
                        if (i7 > 0) {
                            i5 = (Math.round(interpolator.getInterpolation(((float) (abs - childAt.getTop())) / ((float) i7)) * ((float) i7)) + childAt.getTop()) * Integer.signum(clamp);
                        }
                    }
                }
                i5 = clamp;
            } else {
                i5 = clamp;
            }
            boolean G = G(i5);
            int i10 = bQ - clamp;
            this.ng = clamp - i5;
            if (!G && appBarLayout.mV) {
                coordinatorLayout.s(appBarLayout);
            }
            appBarLayout.F(bT());
            if (clamp < bQ) {
                i6 = -1;
            } else {
                i6 = 1;
            }
            a(coordinatorLayout, appBarLayout, clamp, i6, false);
            return i10;
        }

        /* access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderBehavior
        public final /* synthetic */ int f(View view) {
            return ((AppBarLayout) view).getTotalScrollRange();
        }

        /* access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderBehavior
        public final /* synthetic */ int g(View view) {
            return -((AppBarLayout) view).getDownNestedScrollRange();
        }

        public BaseBehavior() {
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
            if (r2 != false) goto L_0x0025;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(android.support.design.widget.CoordinatorLayout r5, T r6, android.view.View r7, android.view.View r8, int r9, int r10) {
            /*
                r4 = this;
                r0 = 1
                r1 = 0
                r2 = r9 & 2
                if (r2 == 0) goto L_0x003a
                boolean r2 = r6.nd
                if (r2 != 0) goto L_0x0025
                int r2 = r6.getTotalScrollRange()
                if (r2 == 0) goto L_0x0036
                r2 = r0
            L_0x0011:
                if (r2 == 0) goto L_0x0038
                int r2 = r5.getHeight()
                int r3 = r7.getHeight()
                int r2 = r2 - r3
                int r3 = r6.getHeight()
                if (r2 > r3) goto L_0x0038
                r2 = r0
            L_0x0023:
                if (r2 == 0) goto L_0x003a
            L_0x0025:
                if (r0 == 0) goto L_0x0030
                android.animation.ValueAnimator r1 = r4.ni
                if (r1 == 0) goto L_0x0030
                android.animation.ValueAnimator r1 = r4.ni
                r1.cancel()
            L_0x0030:
                r1 = 0
                r4.nm = r1
                r4.nh = r10
                return r0
            L_0x0036:
                r2 = r1
                goto L_0x0011
            L_0x0038:
                r2 = r1
                goto L_0x0023
            L_0x003a:
                r0 = r1
                goto L_0x0025
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.AppBarLayout.BaseBehavior.a(android.support.design.widget.CoordinatorLayout, android.support.design.widget.AppBarLayout, android.view.View, android.view.View, int, int):boolean");
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i2, int i3, int[] iArr, int i4) {
            int i5;
            int i6;
            if (i3 != 0) {
                if (i3 < 0) {
                    i5 = -t.getTotalScrollRange();
                    i6 = i5 + t.getDownNestedPreScrollRange();
                } else {
                    i5 = -t.getUpNestedPreScrollRange();
                    i6 = 0;
                }
                if (i5 != i6) {
                    iArr[1] = b(coordinatorLayout, t, i3, i5, i6);
                    a(i3, t, view, i4);
                }
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i2, int i3, int i4, int i5, int i6) {
            boolean z = false;
            if (i5 < 0) {
                b(coordinatorLayout, t, i5, -t.getDownNestedScrollRange(), 0);
                a(i5, t, view, i6);
            }
            if (t.nd) {
                if (view.getScrollY() > 0) {
                    z = true;
                }
                t.t(z);
            }
        }

        private void a(int i2, T t, View view, int i3) {
            if (i3 == 1) {
                int bQ = bQ();
                if ((i2 < 0 && bQ == 0) || (i2 > 0 && bQ == (-t.getDownNestedScrollRange()))) {
                    u.ay(view);
                }
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i2) {
            if (this.nh == 0 || i2 == 1) {
                a(coordinatorLayout, (AppBarLayout) t);
            }
            this.nm = new WeakReference<>(view);
        }

        public void a(a aVar) {
            this.nn = aVar;
        }

        private void a(final CoordinatorLayout coordinatorLayout, final T t, int i2) {
            int height;
            int abs = Math.abs(bQ() - i2);
            float abs2 = Math.abs(0.0f);
            if (abs2 > 0.0f) {
                height = Math.round((((float) abs) / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((((float) abs) / ((float) t.getHeight())) + 1.0f) * 150.0f);
            }
            int bQ = bQ();
            if (bQ != i2) {
                if (this.ni == null) {
                    this.ni = new ValueAnimator();
                    this.ni.setInterpolator(android.support.design.a.a.gO);
                    this.ni.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        /* class android.support.design.widget.AppBarLayout.BaseBehavior.AnonymousClass1 */

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            BaseBehavior.this.b(coordinatorLayout, (View) t, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                } else {
                    this.ni.cancel();
                }
                this.ni.setDuration((long) Math.min(height, 600));
                this.ni.setIntValues(bQ, i2);
                this.ni.start();
            } else if (this.ni != null && this.ni.isRunning()) {
                this.ni.cancel();
            }
        }

        private static int a(T t, int i2) {
            int i3;
            int childCount = t.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = t.getChildAt(i4);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (o(layoutParams.nu, 32)) {
                    top -= layoutParams.topMargin;
                    i3 = layoutParams.bottomMargin + bottom;
                } else {
                    i3 = bottom;
                }
                if (top <= (-i2) && i3 >= (-i2)) {
                    return i4;
                }
            }
            return -1;
        }

        /* access modifiers changed from: private */
        public void a(CoordinatorLayout coordinatorLayout, T t) {
            int bQ = bQ();
            int a2 = a((AppBarLayout) t, bQ);
            if (a2 >= 0) {
                View childAt = t.getChildAt(a2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i2 = layoutParams.nu;
                if ((i2 & 17) == 17) {
                    int i3 = -childAt.getTop();
                    int i4 = -childAt.getBottom();
                    if (a2 == t.getChildCount() - 1) {
                        i4 += t.getTopInset();
                    }
                    if (o(i2, 2)) {
                        i4 += u.ag(childAt);
                    } else if (o(i2, 5)) {
                        int ag = u.ag(childAt) + i4;
                        if (bQ < ag) {
                            i3 = ag;
                        } else {
                            i4 = ag;
                        }
                    }
                    if (o(i2, 32)) {
                        i3 += layoutParams.topMargin;
                        i4 -= layoutParams.bottomMargin;
                    }
                    if (bQ >= (i4 + i3) / 2) {
                        i4 = i3;
                    }
                    a(coordinatorLayout, (AppBarLayout) t, android.support.v4.b.a.clamp(i4, -t.getTotalScrollRange(), 0));
                }
            }
        }

        private static boolean o(int i2, int i3) {
            return (i2 & i3) == i3;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, int i4, int i5) {
            if (((CoordinatorLayout.d) t.getLayoutParams()).height != -2) {
                return super.a(coordinatorLayout, (View) t, i2, i3, i4, i5);
            }
            coordinatorLayout.a(t, i2, i3, View.MeasureSpec.makeMeasureSpec(0, 0), i5);
            return true;
        }

        /* renamed from: b */
        public boolean a(CoordinatorLayout coordinatorLayout, T t, int i2) {
            boolean z;
            int round;
            boolean a2 = super.a(coordinatorLayout, (View) t, i2);
            int pendingAction = t.getPendingAction();
            if (this.nj >= 0 && (pendingAction & 8) == 0) {
                View childAt = t.getChildAt(this.nj);
                int i3 = -childAt.getBottom();
                if (this.nk) {
                    round = u.ag(childAt) + t.getTopInset() + i3;
                } else {
                    round = Math.round(((float) childAt.getHeight()) * this.nl) + i3;
                }
                b(coordinatorLayout, (View) t, round);
            } else if (pendingAction != 0) {
                if ((pendingAction & 4) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if ((pendingAction & 2) != 0) {
                    int i4 = -t.getUpNestedPreScrollRange();
                    if (z) {
                        a(coordinatorLayout, (AppBarLayout) t, i4);
                    } else {
                        b(coordinatorLayout, (View) t, i4);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        a(coordinatorLayout, (AppBarLayout) t, 0);
                    } else {
                        b(coordinatorLayout, (View) t, 0);
                    }
                }
            }
            t.mW = 0;
            this.nj = -1;
            G(android.support.v4.b.a.clamp(bT(), -t.getTotalScrollRange(), 0));
            a(coordinatorLayout, (AppBarLayout) t, bT(), 0, true);
            t.F(bT());
            return a2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0047  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x006c  */
        /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static void a(android.support.design.widget.CoordinatorLayout r6, T r7, int r8, int r9, boolean r10) {
            /*
            // Method dump skipped, instructions count: 112
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.AppBarLayout.BaseBehavior.a(android.support.design.widget.CoordinatorLayout, android.support.design.widget.AppBarLayout, int, int, boolean):void");
        }

        private static boolean b(CoordinatorLayout coordinatorLayout, T t) {
            List<View> u = coordinatorLayout.u(t);
            int size = u.size();
            for (int i2 = 0; i2 < size; i2++) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.d) u.get(i2).getLayoutParams()).qC;
                if (behavior instanceof ScrollingViewBehavior) {
                    if (((ScrollingViewBehavior) behavior).sh != 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            return false;
        }

        private static View b(AppBarLayout appBarLayout, int i2) {
            int abs = Math.abs(i2);
            int childCount = appBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = appBarLayout.getChildAt(i3);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private static View a(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if (childAt instanceof android.support.v4.view.j) {
                    return childAt;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderBehavior
        public final int bQ() {
            return bT() + this.ng;
        }

        /* renamed from: c */
        public Parcelable b(CoordinatorLayout coordinatorLayout, T t) {
            boolean z = false;
            Parcelable b2 = super.b(coordinatorLayout, (View) t);
            int bT = bT();
            int childCount = t.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                int bottom = childAt.getBottom() + bT;
                if (childAt.getTop() + bT <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(b2);
                    savedState.nr = i2;
                    if (bottom == u.ag(childAt) + t.getTopInset()) {
                        z = true;
                    }
                    savedState.nt = z;
                    savedState.ns = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return b2;
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.a(coordinatorLayout, (View) t, savedState.Pm);
                this.nj = savedState.nr;
                this.nl = savedState.ns;
                this.nk = savedState.nt;
                return;
            }
            super.a(coordinatorLayout, (View) t, parcelable);
            this.nj = -1;
        }

        /* access modifiers changed from: protected */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
                /* class android.support.design.widget.AppBarLayout.BaseBehavior.SavedState.AnonymousClass1 */

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
            int nr;
            float ns;
            boolean nt;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.nr = parcel.readInt();
                this.ns = parcel.readFloat();
                this.nt = parcel.readByte() != 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // android.support.v4.view.AbsSavedState
            public void writeToParcel(Parcel parcel, int i2) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.nr);
                parcel.writeFloat(this.ns);
                parcel.writeByte((byte) (this.nt ? 1 : 0));
            }
        }

        /* access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderBehavior
        public final /* synthetic */ boolean bR() {
            View view;
            if (this.nn != null) {
                return this.nn.bS();
            }
            if (this.nm == null || ((view = this.nm.get()) != null && view.isShown() && !view.canScrollVertically(-1))) {
                return true;
            }
            return false;
        }
    }

    public final void a(b bVar) {
        if (this.listeners == null) {
            this.listeners = new ArrayList();
        }
        if (bVar != null && !this.listeners.contains(bVar)) {
            this.listeners.add(bVar);
        }
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        @Override // android.support.design.widget.ViewOffsetBehavior
        public final /* bridge */ /* synthetic */ boolean G(int i2) {
            return super.G(i2);
        }

        @Override // android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i2) {
            return super.a(coordinatorLayout, view, i2);
        }

        @Override // android.support.design.widget.HeaderScrollingViewBehavior, android.support.design.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
            return super.a(coordinatorLayout, view, i2, i3, i4, i5);
        }

        @Override // android.support.design.widget.ViewOffsetBehavior
        public final /* bridge */ /* synthetic */ int bT() {
            return super.bT();
        }

        /* access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderScrollingViewBehavior
        public final /* synthetic */ View e(List list) {
            return d(list);
        }

        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0008a.ScrollingViewBehavior_Layout);
            this.sh = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            obtainStyledAttributes.recycle();
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public final boolean a(View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public final boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            boolean z;
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.d) view2.getLayoutParams()).qC;
            if (behavior instanceof BaseBehavior) {
                u.s(view, ((((BaseBehavior) behavior).ng + (view2.getBottom() - view.getTop())) + this.sg) - w(view2));
            }
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.nd) {
                    if (view.getScrollY() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    appBarLayout.t(z);
                }
            }
            return false;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public final boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            boolean z2;
            AppBarLayout d2 = d(coordinatorLayout.t(view));
            if (d2 != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.se;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    if (!z) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    d2.b(false, z2, true);
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderScrollingViewBehavior
        public final float h(View view) {
            int i2;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.d) appBarLayout.getLayoutParams()).qC;
                if (behavior instanceof BaseBehavior) {
                    i2 = ((BaseBehavior) behavior).bQ();
                } else {
                    i2 = 0;
                }
                if (downNestedPreScrollRange != 0 && totalScrollRange + i2 <= downNestedPreScrollRange) {
                    return 0.0f;
                }
                int i3 = totalScrollRange - downNestedPreScrollRange;
                if (i3 != 0) {
                    return (((float) i2) / ((float) i3)) + 1.0f;
                }
            }
            return 0.0f;
        }

        private static AppBarLayout d(List<View> list) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = list.get(i2);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderScrollingViewBehavior
        public final int i(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.i(view);
        }
    }
}
