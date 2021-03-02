package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.a;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.u;
import android.support.v4.widget.t;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mm.R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private Map<View, Integer> mR;
    private boolean nS = true;
    private float nT;
    private int nU;
    private boolean nV;
    private int nW;
    private int nX;
    int nY;
    int nZ;
    int oa;
    public boolean ob;
    private boolean oc;
    t od;
    private boolean oe;
    private int of;
    private boolean og;
    int oh;
    WeakReference<V> oi;
    WeakReference<View> oj;
    public a ok;
    private VelocityTracker ol;
    int om;
    private int oo;
    boolean oq;
    private final t.a or = new t.a() {
        /* class android.support.design.widget.BottomSheetBehavior.AnonymousClass2 */

        @Override // android.support.v4.widget.t.a
        public final boolean c(View view, int i2) {
            View view2;
            if (BottomSheetBehavior.this.state == 1) {
                return false;
            }
            if (BottomSheetBehavior.this.oq) {
                return false;
            }
            if (BottomSheetBehavior.this.state != 3 || BottomSheetBehavior.this.om != i2 || (view2 = BottomSheetBehavior.this.oj.get()) == null || !view2.canScrollVertically(-1)) {
                return BottomSheetBehavior.this.oi != null && BottomSheetBehavior.this.oi.get() == view;
            }
            return false;
        }

        @Override // android.support.v4.widget.t.a
        public final void b(View view, int i2, int i3) {
            BottomSheetBehavior.this.cf();
        }

        @Override // android.support.v4.widget.t.a
        public final void L(int i2) {
            if (i2 == 1) {
                BottomSheetBehavior.this.K(1);
            }
        }

        @Override // android.support.v4.widget.t.a
        public final void a(View view, float f2, float f3) {
            int i2 = 0;
            int i3 = 3;
            if (f3 < 0.0f) {
                if (BottomSheetBehavior.this.nS) {
                    i2 = BottomSheetBehavior.this.nY;
                } else if (view.getTop() > BottomSheetBehavior.this.nZ) {
                    i3 = 6;
                    i2 = BottomSheetBehavior.this.nZ;
                }
            } else if (BottomSheetBehavior.this.ob && BottomSheetBehavior.this.a(view, f3) && (view.getTop() > BottomSheetBehavior.this.oa || Math.abs(f2) < Math.abs(f3))) {
                i3 = 5;
                i2 = BottomSheetBehavior.this.oh;
            } else if (f3 == 0.0f || Math.abs(f2) > Math.abs(f3)) {
                int top = view.getTop();
                if (BottomSheetBehavior.this.nS) {
                    if (Math.abs(top - BottomSheetBehavior.this.nY) < Math.abs(top - BottomSheetBehavior.this.oa)) {
                        i2 = BottomSheetBehavior.this.nY;
                    } else {
                        i3 = 4;
                        i2 = BottomSheetBehavior.this.oa;
                    }
                } else if (top < BottomSheetBehavior.this.nZ) {
                    if (top >= Math.abs(top - BottomSheetBehavior.this.oa)) {
                        i3 = 6;
                        i2 = BottomSheetBehavior.this.nZ;
                    }
                } else if (Math.abs(top - BottomSheetBehavior.this.nZ) < Math.abs(top - BottomSheetBehavior.this.oa)) {
                    i3 = 6;
                    i2 = BottomSheetBehavior.this.nZ;
                } else {
                    i3 = 4;
                    i2 = BottomSheetBehavior.this.oa;
                }
            } else {
                i3 = 4;
                i2 = BottomSheetBehavior.this.oa;
            }
            if (BottomSheetBehavior.this.od.H(view.getLeft(), i2)) {
                BottomSheetBehavior.this.K(2);
                u.b(view, new b(view, i3));
                return;
            }
            BottomSheetBehavior.this.K(i3);
        }

        @Override // android.support.v4.widget.t.a
        public final int d(View view, int i2) {
            return android.support.v4.b.a.clamp(i2, BottomSheetBehavior.this.ce(), BottomSheetBehavior.this.ob ? BottomSheetBehavior.this.oh : BottomSheetBehavior.this.oa);
        }

        @Override // android.support.v4.widget.t.a
        public final int e(View view, int i2) {
            return view.getLeft();
        }

        @Override // android.support.v4.widget.t.a
        public final int cg() {
            if (BottomSheetBehavior.this.ob) {
                return BottomSheetBehavior.this.oh;
            }
            return BottomSheetBehavior.this.oa;
        }
    };
    int state = 4;

    public static abstract class a {
        public abstract void f(View view, int i2);

        public abstract void m(View view);
    }

    public BottomSheetBehavior() {
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0008a.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(2);
        if (peekValue == null || peekValue.data != -1) {
            J(obtainStyledAttributes.getDimensionPixelSize(2, -1));
        } else {
            J(peekValue.data);
        }
        this.ob = obtainStyledAttributes.getBoolean(1, false);
        boolean z = obtainStyledAttributes.getBoolean(0, true);
        if (this.nS != z) {
            this.nS = z;
            if (this.oi != null) {
                cd();
            }
            if (!this.nS || this.state != 6) {
                i2 = this.state;
            } else {
                i2 = 3;
            }
            K(i2);
        }
        this.oc = obtainStyledAttributes.getBoolean(3, false);
        obtainStyledAttributes.recycle();
        this.nT = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.b(coordinatorLayout, (View) v), this.state);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.a(coordinatorLayout, v, savedState.Pm);
        if (savedState.state == 1 || savedState.state == 2) {
            this.state = 4;
        } else {
            this.state = savedState.state;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final boolean a(CoordinatorLayout coordinatorLayout, V v, int i2) {
        if (u.aq(coordinatorLayout) && !u.aq(v)) {
            v.setFitsSystemWindows(true);
        }
        int top = v.getTop();
        coordinatorLayout.g(v, i2);
        this.oh = coordinatorLayout.getHeight();
        if (this.nV) {
            if (this.nW == 0) {
                this.nW = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.z6);
            }
            this.nX = Math.max(this.nW, this.oh - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            this.nX = this.nU;
        }
        this.nY = Math.max(0, this.oh - v.getHeight());
        this.nZ = this.oh / 2;
        cd();
        if (this.state == 3) {
            u.s(v, ce());
        } else if (this.state == 6) {
            u.s(v, this.nZ);
        } else if (this.ob && this.state == 5) {
            u.s(v, this.oh);
        } else if (this.state == 4) {
            u.s(v, this.oa);
        } else if (this.state == 1 || this.state == 2) {
            u.s(v, top - v.getTop());
        }
        if (this.od == null) {
            this.od = t.a(coordinatorLayout, this.or);
        }
        this.oi = new WeakReference<>(v);
        this.oj = new WeakReference<>(k(v));
        return true;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            this.oe = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (this.ol == null) {
            this.ol = VelocityTracker.obtain();
        }
        this.ol.addMovement(motionEvent);
        switch (actionMasked) {
            case 0:
                int x = (int) motionEvent.getX();
                this.oo = (int) motionEvent.getY();
                View view = this.oj != null ? this.oj.get() : null;
                if (view != null && coordinatorLayout.d(view, x, this.oo)) {
                    this.om = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.oq = true;
                }
                this.oe = this.om == -1 && !coordinatorLayout.d(v, x, this.oo);
                break;
            case 1:
            case 3:
                this.oq = false;
                this.om = -1;
                if (this.oe) {
                    this.oe = false;
                    return false;
                }
                break;
        }
        if (!this.oe && this.od != null && this.od.j(motionEvent)) {
            return true;
        }
        View view2 = this.oj != null ? this.oj.get() : null;
        return actionMasked == 2 && view2 != null && !this.oe && this.state != 1 && !coordinatorLayout.d(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) && this.od != null && Math.abs(((float) this.oo) - motionEvent.getY()) > ((float) this.od.mTouchSlop);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        if (this.od != null) {
            this.od.k(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.ol == null) {
            this.ol = VelocityTracker.obtain();
        }
        this.ol.addMovement(motionEvent);
        if (actionMasked == 2 && !this.oe && Math.abs(((float) this.oo) - motionEvent.getY()) > ((float) this.od.mTouchSlop)) {
            this.od.y(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.oe;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final boolean a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
        this.of = 0;
        this.og = false;
        if ((i2 & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 != 1 && view == this.oj.get()) {
            int top = v.getTop();
            int i5 = top - i3;
            if (i3 > 0) {
                if (i5 < ce()) {
                    iArr[1] = top - ce();
                    u.s(v, -iArr[1]);
                    K(3);
                } else {
                    iArr[1] = i3;
                    u.s(v, -i3);
                    K(1);
                }
            } else if (i3 < 0 && !view.canScrollVertically(-1)) {
                if (i5 <= this.oa || this.ob) {
                    iArr[1] = i3;
                    u.s(v, -i3);
                    K(1);
                } else {
                    iArr[1] = top - this.oa;
                    u.s(v, -iArr[1]);
                    K(4);
                }
            }
            v.getTop();
            cf();
            this.of = i3;
            this.og = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2) {
        int i3;
        int i4;
        float yVelocity;
        if (v.getTop() == ce()) {
            K(3);
        } else if (view == this.oj.get() && this.og) {
            if (this.of > 0) {
                i3 = 3;
                i4 = ce();
            } else {
                if (this.ob) {
                    if (this.ol == null) {
                        yVelocity = 0.0f;
                    } else {
                        this.ol.computeCurrentVelocity(1000, this.nT);
                        yVelocity = this.ol.getYVelocity(this.om);
                    }
                    if (a(v, yVelocity)) {
                        i3 = 5;
                        i4 = this.oh;
                    }
                }
                if (this.of == 0) {
                    int top = v.getTop();
                    if (this.nS) {
                        if (Math.abs(top - this.nY) < Math.abs(top - this.oa)) {
                            i3 = 3;
                            i4 = this.nY;
                        } else {
                            i3 = 4;
                            i4 = this.oa;
                        }
                    } else if (top < this.nZ) {
                        if (top < Math.abs(top - this.oa)) {
                            i3 = 3;
                            i4 = 0;
                        } else {
                            i3 = 6;
                            i4 = this.nZ;
                        }
                    } else if (Math.abs(top - this.nZ) < Math.abs(top - this.oa)) {
                        i3 = 6;
                        i4 = this.nZ;
                    } else {
                        i3 = 4;
                        i4 = this.oa;
                    }
                } else {
                    i3 = 4;
                    i4 = this.oa;
                }
            }
            if (this.od.h(v, v.getLeft(), i4)) {
                K(2);
                u.b(v, new b(v, i3));
            } else {
                K(i3);
            }
            this.og = false;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
        return view == this.oj.get() && (this.state != 3 || super.a(coordinatorLayout, v, view, f2, f3));
    }

    public final void J(int i2) {
        V v;
        boolean z = true;
        if (i2 == -1) {
            if (!this.nV) {
                this.nV = true;
            }
            z = false;
        } else {
            if (this.nV || this.nU != i2) {
                this.nV = false;
                this.nU = Math.max(0, i2);
                this.oa = this.oh - i2;
            }
            z = false;
        }
        if (z && this.state == 4 && this.oi != null && (v = this.oi.get()) != null) {
            v.requestLayout();
        }
    }

    public final void u(boolean z) {
        this.ob = z;
    }

    public final void a(a aVar) {
        this.ok = aVar;
    }

    public final void setState(final int i2) {
        if (i2 != this.state) {
            if (this.oi != null) {
                final V v = this.oi.get();
                if (v != null) {
                    ViewParent parent = v.getParent();
                    if (parent == null || !parent.isLayoutRequested() || !u.aD(v)) {
                        b(v, i2);
                    } else {
                        v.post(new Runnable() {
                            /* class android.support.design.widget.BottomSheetBehavior.AnonymousClass1 */

                            public final void run() {
                                BottomSheetBehavior.this.b(v, i2);
                            }
                        });
                    }
                }
            } else if (i2 == 4 || i2 == 3 || i2 == 6 || (this.ob && i2 == 5)) {
                this.state = i2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void K(int i2) {
        if (this.state != i2) {
            this.state = i2;
            if (i2 == 6 || i2 == 3) {
                v(true);
            } else if (i2 == 5 || i2 == 4) {
                v(false);
            }
            V v = this.oi.get();
            if (v != null && this.ok != null) {
                this.ok.f(v, i2);
            }
        }
    }

    private void cd() {
        if (this.nS) {
            this.oa = Math.max(this.oh - this.nX, this.nY);
        } else {
            this.oa = this.oh - this.nX;
        }
    }

    private void reset() {
        this.om = -1;
        if (this.ol != null) {
            this.ol.recycle();
            this.ol = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(View view, float f2) {
        if (this.oc) {
            return true;
        }
        if (view.getTop() < this.oa) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (0.1f * f2)) - ((float) this.oa)) / ((float) this.nU) > 0.5f;
    }

    private View k(View view) {
        if (u.aw(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View k = k(viewGroup.getChildAt(i2));
                if (k != null) {
                    return k;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int ce() {
        if (this.nS) {
            return this.nY;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final void b(View view, int i2) {
        int i3;
        if (i2 == 4) {
            i3 = this.oa;
        } else if (i2 == 6) {
            i3 = this.nZ;
            if (this.nS && i3 <= this.nY) {
                i3 = this.nY;
                i2 = 3;
            }
        } else if (i2 == 3) {
            i3 = ce();
        } else if (!this.ob || i2 != 5) {
            throw new IllegalArgumentException("Illegal state argument: ".concat(String.valueOf(i2)));
        } else {
            i3 = this.oh;
        }
        if (this.od.h(view, view.getLeft(), i3)) {
            K(2);
            u.b(view, new b(view, i2));
            return;
        }
        K(i2);
    }

    /* access modifiers changed from: package-private */
    public final void cf() {
        V v = this.oi.get();
        if (v != null && this.ok != null) {
            this.ok.m(v);
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements Runnable {
        private final int ov;
        private final View view;

        b(View view2, int i2) {
            this.view = view2;
            this.ov = i2;
        }

        public final void run() {
            if (BottomSheetBehavior.this.od == null || !BottomSheetBehavior.this.od.go()) {
                BottomSheetBehavior.this.K(this.ov);
            } else {
                u.b(this.view, this);
            }
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class android.support.design.widget.BottomSheetBehavior.SavedState.AnonymousClass1 */

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
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        final int state;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i2) {
            super(parcelable);
            this.state = i2;
        }

        @Override // android.support.v4.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.state);
        }
    }

    public static <V extends View> BottomSheetBehavior<V> l(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.d)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.d) layoutParams).qC;
        if (behavior instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) behavior;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    private void v(boolean z) {
        if (this.oi != null) {
            ViewParent parent = this.oi.get().getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (Build.VERSION.SDK_INT >= 16 && z) {
                    if (this.mR == null) {
                        this.mR = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = coordinatorLayout.getChildAt(i2);
                    if (childAt != this.oi.get()) {
                        if (z) {
                            if (Build.VERSION.SDK_INT >= 16) {
                                this.mR.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            }
                            u.p(childAt, 4);
                        } else if (this.mR != null && this.mR.containsKey(childAt)) {
                            u.p(childAt, this.mR.get(childAt).intValue());
                        }
                    }
                }
                if (!z) {
                    this.mR = null;
                }
            }
        }
    }
}
