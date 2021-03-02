package android.support.design.widget;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.a;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.design.widget.n;
import android.support.v4.view.a.b;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    static final Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        /* class android.support.design.widget.BaseTransientBottomBar.AnonymousClass1 */

        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    ((BaseTransientBottomBar) message.obj).bU();
                    return true;
                case 1:
                    ((BaseTransientBottomBar) message.obj).H(message.arg1);
                    return true;
                default:
                    return false;
            }
        }
    });
    private static final boolean nw = (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 19);
    private static final int[] nx = {R.attr.zj};
    private List<Object<B>> callbacks;
    private final android.support.design.g.a nA;
    private Behavior nB;
    private final AccessibilityManager nC;
    final n.a nD;
    private final ViewGroup ny;
    protected final d nz;

    /* access modifiers changed from: protected */
    public interface b {
        void ca();
    }

    /* access modifiers changed from: protected */
    public interface c {
        void cb();
    }

    /* access modifiers changed from: package-private */
    public final void bU() {
        Behavior behavior;
        if (this.nz.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.nz.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.d) {
                CoordinatorLayout.d dVar = (CoordinatorLayout.d) layoutParams;
                if (this.nB == null) {
                    behavior = new Behavior();
                } else {
                    behavior = this.nB;
                }
                if (behavior instanceof Behavior) {
                    Behavior.a(behavior, this);
                }
                behavior.tU = new SwipeDismissBehavior.a() {
                    /* class android.support.design.widget.BaseTransientBottomBar.AnonymousClass4 */

                    @Override // android.support.design.widget.SwipeDismissBehavior.a
                    public final void onDismiss(View view) {
                        view.setVisibility(8);
                        BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
                        n cV = n.cV();
                        n.a aVar = baseTransientBottomBar.nD;
                        synchronized (cV.lock) {
                            if (cV.e(aVar)) {
                                cV.a(cV.tJ);
                            } else if (cV.f(aVar)) {
                                cV.a(cV.tK);
                            }
                        }
                    }

                    @Override // android.support.design.widget.SwipeDismissBehavior.a
                    public final void I(int i2) {
                        switch (i2) {
                            case 0:
                                n.cV().c(BaseTransientBottomBar.this.nD);
                                return;
                            case 1:
                            case 2:
                                n.cV().b(BaseTransientBottomBar.this.nD);
                                return;
                            default:
                                return;
                        }
                    }
                };
                dVar.a(behavior);
                dVar.qG = 80;
            }
            this.ny.addView(this.nz);
        }
        this.nz.setOnAttachStateChangeListener(new b() {
            /* class android.support.design.widget.BaseTransientBottomBar.AnonymousClass5 */

            @Override // android.support.design.widget.BaseTransientBottomBar.b
            public final void ca() {
                if (n.cV().d(BaseTransientBottomBar.this.nD)) {
                    BaseTransientBottomBar.handler.post(new Runnable() {
                        /* class android.support.design.widget.BaseTransientBottomBar.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            BaseTransientBottomBar.this.bY();
                        }
                    });
                }
            }
        });
        if (!u.az(this.nz)) {
            this.nz.setOnLayoutChangeListener(new c() {
                /* class android.support.design.widget.BaseTransientBottomBar.AnonymousClass6 */

                @Override // android.support.design.widget.BaseTransientBottomBar.c
                public final void cb() {
                    BaseTransientBottomBar.this.nz.setOnLayoutChangeListener(null);
                    if (BaseTransientBottomBar.this.bZ()) {
                        BaseTransientBottomBar.this.bV();
                    } else {
                        BaseTransientBottomBar.this.bX();
                    }
                }
            });
        } else if (bZ()) {
            bV();
        } else {
            bX();
        }
    }

    /* access modifiers changed from: package-private */
    public final void bV() {
        final int bW = bW();
        if (nw) {
            u.s(this.nz, bW);
        } else {
            this.nz.setTranslationY((float) bW);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(bW, 0);
        valueAnimator.setInterpolator(android.support.design.a.a.gL);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            /* class android.support.design.widget.BaseTransientBottomBar.AnonymousClass7 */

            public final void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.nA.bL();
            }

            public final void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.bX();
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class android.support.design.widget.BaseTransientBottomBar.AnonymousClass8 */
            private int nF = bW;

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.nw) {
                    u.s(BaseTransientBottomBar.this.nz, intValue - this.nF);
                } else {
                    BaseTransientBottomBar.this.nz.setTranslationY((float) intValue);
                }
                this.nF = intValue;
            }
        });
        valueAnimator.start();
    }

    private int bW() {
        int height = this.nz.getHeight();
        ViewGroup.LayoutParams layoutParams = this.nz.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + height;
        }
        return height;
    }

    /* access modifiers changed from: package-private */
    public final void H(final int i2) {
        if (!bZ() || this.nz.getVisibility() != 0) {
            bY();
            return;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, bW());
        valueAnimator.setInterpolator(android.support.design.a.a.gL);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            /* class android.support.design.widget.BaseTransientBottomBar.AnonymousClass2 */

            public final void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.nA.bM();
            }

            public final void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.bY();
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class android.support.design.widget.BaseTransientBottomBar.AnonymousClass3 */
            private int nF = 0;

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.nw) {
                    u.s(BaseTransientBottomBar.this.nz, intValue - this.nF);
                } else {
                    BaseTransientBottomBar.this.nz.setTranslationY((float) intValue);
                }
                this.nF = intValue;
            }
        });
        valueAnimator.start();
    }

    /* access modifiers changed from: package-private */
    public final void bX() {
        n.cV().a(this.nD);
        if (this.callbacks != null) {
            for (int size = this.callbacks.size() - 1; size >= 0; size--) {
                this.callbacks.get(size);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void bY() {
        n cV = n.cV();
        n.a aVar = this.nD;
        synchronized (cV.lock) {
            if (cV.e(aVar)) {
                cV.tJ = null;
                if (!(cV.tK == null || cV.tK == null)) {
                    cV.tJ = cV.tK;
                    cV.tK = null;
                    if (cV.tJ.tM.get() == null) {
                        cV.tJ = null;
                    }
                }
            }
        }
        if (this.callbacks != null) {
            for (int size = this.callbacks.size() - 1; size >= 0; size--) {
                this.callbacks.get(size);
            }
        }
        ViewParent parent = this.nz.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.nz);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean bZ() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.nC.getEnabledAccessibilityServiceList(1);
        if (enabledAccessibilityServiceList == null || !enabledAccessibilityServiceList.isEmpty()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public static class d extends FrameLayout {
        private final AccessibilityManager nC;
        private final b.a nJ;
        private c nK;
        private b nL;

        protected d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0008a.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(1)) {
                u.l(this, (float) obtainStyledAttributes.getDimensionPixelSize(1, 0));
            }
            obtainStyledAttributes.recycle();
            this.nC = (AccessibilityManager) context.getSystemService("accessibility");
            this.nJ = new b.a() {
                /* class android.support.design.widget.BaseTransientBottomBar.d.AnonymousClass1 */

                @Override // android.support.v4.view.a.b.a
                public final void onTouchExplorationStateChanged(boolean z) {
                    d.this.setClickableOrFocusableBasedOnAccessibility(z);
                }
            };
            AccessibilityManager accessibilityManager = this.nC;
            b.a aVar = this.nJ;
            if (Build.VERSION.SDK_INT >= 19 && aVar != null) {
                accessibilityManager.addTouchExplorationStateChangeListener(new b.accessibility.AccessibilityManager$TouchExplorationStateChangeListenerC0035b(aVar));
            }
            setClickableOrFocusableBasedOnAccessibility(this.nC.isTouchExplorationEnabled());
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void setClickableOrFocusableBasedOnAccessibility(boolean z) {
            setClickable(!z);
            setFocusable(z);
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            if (this.nK != null) {
                this.nK.cb();
            }
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            u.ap(this);
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.nL != null) {
                this.nL.ca();
            }
            AccessibilityManager accessibilityManager = this.nC;
            b.a aVar = this.nJ;
            if (Build.VERSION.SDK_INT >= 19 && aVar != null) {
                accessibilityManager.removeTouchExplorationStateChangeListener(new b.accessibility.AccessibilityManager$TouchExplorationStateChangeListenerC0035b(aVar));
            }
        }

        /* access modifiers changed from: package-private */
        public void setOnLayoutChangeListener(c cVar) {
            this.nK = cVar;
        }

        /* access modifiers changed from: package-private */
        public void setOnAttachStateChangeListener(b bVar) {
            this.nL = bVar;
        }
    }

    public static class Behavior extends SwipeDismissBehavior<View> {
        private final a nI = new a(this);

        @Override // android.support.design.widget.SwipeDismissBehavior, android.support.design.widget.CoordinatorLayout.Behavior
        public final boolean b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            a aVar = this.nI;
            switch (motionEvent.getActionMasked()) {
                case 0:
                    if (coordinatorLayout.d(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                        n.cV().b(aVar.nD);
                        break;
                    }
                    break;
                case 1:
                case 3:
                    n.cV().c(aVar.nD);
                    break;
            }
            return super.b(coordinatorLayout, view, motionEvent);
        }

        @Override // android.support.design.widget.SwipeDismissBehavior
        public final boolean j(View view) {
            return view instanceof d;
        }

        static /* synthetic */ void a(Behavior behavior, BaseTransientBottomBar baseTransientBottomBar) {
            behavior.nI.nD = baseTransientBottomBar.nD;
        }
    }

    public static class a {
        n.a nD;

        public a(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.ua = SwipeDismissBehavior.u(0.1f);
            swipeDismissBehavior.ub = SwipeDismissBehavior.u(0.6f);
            swipeDismissBehavior.tY = 0;
        }
    }
}
