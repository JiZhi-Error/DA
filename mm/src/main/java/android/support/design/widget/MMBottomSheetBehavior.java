package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
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
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public class MMBottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    int mActivePointerId;
    int mState = 4;
    private VelocityTracker mVelocityTracker;
    WeakReference<V> mViewRef;
    private float sH;
    private int sI;
    private boolean sJ;
    private int sK;
    int sL;
    int sM;
    boolean sN;
    private boolean sO;
    t sP;
    private boolean sQ;
    private int sR;
    private boolean sS;
    int sT;
    WeakReference<View> sU;
    private a sV;
    private boolean sW;
    private boolean sX;
    private int sY;
    private int sZ;
    boolean ta;
    private boolean tb = false;
    private final t.a tc = new t.a() {
        /* class android.support.design.widget.MMBottomSheetBehavior.AnonymousClass2 */

        @Override // android.support.v4.widget.t.a
        public final boolean c(View view, int i2) {
            View view2;
            if (MMBottomSheetBehavior.this.mState == 1) {
                return false;
            }
            if (MMBottomSheetBehavior.this.ta) {
                return false;
            }
            if (MMBottomSheetBehavior.this.mState != 3 || MMBottomSheetBehavior.this.mActivePointerId != i2 || (view2 = MMBottomSheetBehavior.this.sU.get()) == null || !view2.canScrollVertically(-1)) {
                return MMBottomSheetBehavior.this.mViewRef != null && MMBottomSheetBehavior.this.mViewRef.get() == view;
            }
            return false;
        }

        @Override // android.support.v4.widget.t.a
        public final void b(View view, int i2, int i3) {
            MMBottomSheetBehavior.this.Z(i3);
        }

        @Override // android.support.v4.widget.t.a
        public final void L(int i2) {
            if (i2 == 1) {
                MMBottomSheetBehavior.this.K(1);
            }
        }

        @Override // android.support.v4.widget.t.a
        public final void a(View view, float f2, float f3) {
            int i2;
            int i3 = 3;
            if (f3 < 0.0f) {
                i2 = MMBottomSheetBehavior.this.sL;
            } else if (MMBottomSheetBehavior.this.sN && MMBottomSheetBehavior.this.a(view, f3)) {
                i3 = 5;
                i2 = MMBottomSheetBehavior.this.sT;
            } else if (f3 == 0.0f) {
                int top = view.getTop();
                if (Math.abs(top - MMBottomSheetBehavior.this.sL) < Math.abs(top - MMBottomSheetBehavior.this.sM)) {
                    i2 = MMBottomSheetBehavior.this.sL;
                } else {
                    i2 = MMBottomSheetBehavior.this.sM;
                    i3 = 4;
                }
            } else {
                i2 = MMBottomSheetBehavior.this.sM;
                i3 = 4;
            }
            if (MMBottomSheetBehavior.this.sP.H(view.getLeft(), i2)) {
                MMBottomSheetBehavior.this.K(2);
                u.b(view, new c(view, i3));
                return;
            }
            MMBottomSheetBehavior.this.K(i3);
        }

        @Override // android.support.v4.widget.t.a
        public final int d(View view, int i2) {
            return android.support.v4.b.a.clamp(i2, MMBottomSheetBehavior.this.sL, MMBottomSheetBehavior.this.sN ? MMBottomSheetBehavior.this.sT : MMBottomSheetBehavior.this.sM);
        }

        @Override // android.support.v4.widget.t.a
        public final int e(View view, int i2) {
            return view.getLeft();
        }

        @Override // android.support.v4.widget.t.a
        public final int cg() {
            if (MMBottomSheetBehavior.this.sN) {
                return MMBottomSheetBehavior.this.sT - MMBottomSheetBehavior.this.sL;
            }
            return MMBottomSheetBehavior.this.sM - MMBottomSheetBehavior.this.sL;
        }
    };
    private b td;

    public static abstract class a {
        public abstract void b(View view, float f2);

        public abstract void f(View view, int i2);
    }

    public interface b {
        boolean onInterceptTouchEvent(MotionEvent motionEvent);
    }

    public MMBottomSheetBehavior() {
    }

    public MMBottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0008a.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(2);
        if (peekValue == null || peekValue.data != -1) {
            J(obtainStyledAttributes.getDimensionPixelSize(2, -1));
        } else {
            J(peekValue.data);
        }
        this.sN = obtainStyledAttributes.getBoolean(1, false);
        this.sO = obtainStyledAttributes.getBoolean(3, false);
        obtainStyledAttributes.recycle();
        this.sH = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.b(coordinatorLayout, (View) v), this.mState);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.a(coordinatorLayout, v, savedState.Pm);
        if (savedState.state == 1 || savedState.state == 2) {
            this.mState = 4;
        } else {
            this.mState = savedState.state;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final boolean a(CoordinatorLayout coordinatorLayout, V v, int i2) {
        int i3;
        if (u.aq(coordinatorLayout) && !u.aq(v)) {
            u.e((View) v, true);
        }
        int top = v.getTop();
        coordinatorLayout.g(v, i2);
        this.sT = coordinatorLayout.getHeight();
        if (this.sJ) {
            if (this.sK == 0) {
                this.sK = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.z6);
            }
            i3 = Math.max(this.sK, this.sT - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            i3 = this.sI;
        }
        this.sL = Math.max(0, this.sT - v.getHeight());
        this.sM = Math.max(this.sT - i3, this.sL);
        if (this.mState == 3) {
            u.s(v, this.sL);
        } else if (this.sN && this.mState == 5) {
            u.s(v, this.sT);
        } else if (this.mState == 4) {
            u.s(v, this.sM);
        } else if (this.mState == 1 || this.mState == 2) {
            u.s(v, top - v.getTop());
        }
        if (this.sP == null) {
            this.sP = t.a(coordinatorLayout, this.tc);
        }
        this.mViewRef = new WeakReference<>(v);
        this.sU = new WeakReference<>(k(v));
        return true;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        Log.d("microMsg.MMBottomSheetBehavior", "onInterceptTouchEvent action: %d, x: %f, y: %f, rawX: %f, rawY: %f.", Integer.valueOf(motionEvent.getAction()), Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY()));
        if (motionEvent.getAction() == 0) {
            this.tb = false;
        }
        if (this.tb) {
            Log.d("microMsg.MMBottomSheetBehavior", "external deal with, continue.");
            return false;
        } else if (this.td != null && this.td.onInterceptTouchEvent(motionEvent)) {
            Log.d("microMsg.MMBottomSheetBehavior", "external deal with.");
            this.tb = true;
            return false;
        } else if (!v.isShown()) {
            this.sQ = true;
            return false;
        } else {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                reset();
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            switch (actionMasked) {
                case 0:
                    this.sW = false;
                    this.sX = false;
                    this.sY = (int) motionEvent.getX();
                    this.sZ = (int) motionEvent.getY();
                    View view = this.sU != null ? this.sU.get() : null;
                    if (view != null && coordinatorLayout.d(view, this.sY, this.sZ)) {
                        this.mActivePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.ta = true;
                    }
                    this.sQ = this.mActivePointerId == -1 && !coordinatorLayout.d(v, this.sY, this.sZ);
                    break;
                case 1:
                case 3:
                    this.ta = false;
                    this.mActivePointerId = -1;
                    if (this.sQ) {
                        this.sQ = false;
                        return false;
                    }
                    break;
                case 2:
                    int x = ((int) motionEvent.getX()) - this.sY;
                    int y = ((int) motionEvent.getY()) - this.sZ;
                    if (!this.sW) {
                        if (Math.abs(x) > this.sP.mTouchSlop || Math.abs(y) > this.sP.mTouchSlop) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.sW = z2;
                    }
                    if (this.sW) {
                        if (Math.abs(y) > Math.abs(x)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.sX = z;
                        break;
                    }
                    break;
            }
            if (!this.sQ && this.sP.j(motionEvent) && this.sX) {
                return true;
            }
            View view2 = this.sU.get();
            return actionMasked == 2 && view2 != null && !this.sQ && this.mState != 1 && !coordinatorLayout.d(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) && Math.abs(((float) this.sZ) - motionEvent.getY()) > ((float) this.sP.mTouchSlop) && this.sX;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        Log.d("microMsg.MMBottomSheetBehavior", "onTouchEvent action: %d, x: %f, y: %f, rawX: %f, rawY: %f.", Integer.valueOf(motionEvent.getAction()), Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY()));
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.mState == 1 && actionMasked == 0) {
            return true;
        }
        if (this.sP != null) {
            this.sP.k(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (actionMasked == 2 && !this.sQ && Math.abs(((float) this.sZ) - motionEvent.getY()) > ((float) this.sP.mTouchSlop)) {
            this.sP.y(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.sQ;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final boolean B(int i2) {
        this.sR = 0;
        this.sS = false;
        if ((i2 & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final void a(V v, View view, int i2, int[] iArr) {
        if (view == this.sU.get()) {
            int top = v.getTop();
            int i3 = top - i2;
            if (i2 > 0) {
                if (i3 < this.sL) {
                    iArr[1] = top - this.sL;
                    u.s(v, -iArr[1]);
                    K(3);
                } else {
                    iArr[1] = i2;
                    u.s(v, -i2);
                    K(1);
                }
            } else if (i2 < 0 && !view.canScrollVertically(-1)) {
                if (i3 <= this.sM || this.sN) {
                    iArr[1] = i2;
                    u.s(v, -i2);
                    K(1);
                } else {
                    iArr[1] = top - this.sM;
                    u.s(v, -iArr[1]);
                    K(4);
                }
            }
            Z(v.getTop());
            this.sR = i2;
            this.sS = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final void b(V v, View view) {
        int i2;
        int i3 = 3;
        if (v.getTop() == this.sL) {
            K(3);
        } else if (this.sU != null && view == this.sU.get() && this.sS) {
            if (this.sR > 0) {
                i2 = this.sL;
            } else {
                if (this.sN) {
                    this.mVelocityTracker.computeCurrentVelocity(1000, this.sH);
                    if (a(v, this.mVelocityTracker.getYVelocity(this.mActivePointerId))) {
                        i3 = 5;
                        i2 = this.sT;
                    }
                }
                if (this.sR == 0) {
                    int top = v.getTop();
                    if (Math.abs(top - this.sL) < Math.abs(top - this.sM)) {
                        i2 = this.sL;
                    } else {
                        i2 = this.sM;
                        i3 = 4;
                    }
                } else {
                    i2 = this.sM;
                    i3 = 4;
                }
            }
            if (this.sP.h(v, v.getLeft(), i2)) {
                K(2);
                u.b(v, new c(v, i3));
            } else {
                K(i3);
            }
            this.sS = false;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
        return view == this.sU.get() && (this.mState != 3 || super.a(coordinatorLayout, v, view, f2, f3));
    }

    private void J(int i2) {
        V v;
        boolean z = true;
        if (i2 == -1) {
            if (!this.sJ) {
                this.sJ = true;
            }
            z = false;
        } else {
            if (this.sJ || this.sI != i2) {
                this.sJ = false;
                this.sI = Math.max(0, i2);
                this.sM = this.sT - i2;
            }
            z = false;
        }
        if (z && this.mState == 4 && this.mViewRef != null && (v = this.mViewRef.get()) != null) {
            v.requestLayout();
        }
    }

    public final void a(a aVar) {
        this.sV = aVar;
    }

    public final void cU() {
        if (3 != this.mState) {
            if (this.mViewRef == null) {
                this.mState = 3;
                return;
            }
            final V v = this.mViewRef.get();
            if (v != null) {
                ViewParent parent = v.getParent();
                if (parent == null || !parent.isLayoutRequested() || !u.aD(v)) {
                    b(v, 3);
                } else {
                    v.post(new Runnable() {
                        /* class android.support.design.widget.MMBottomSheetBehavior.AnonymousClass1 */
                        final /* synthetic */ int te = 3;

                        public final void run() {
                            MMBottomSheetBehavior.this.b(v, this.te);
                        }
                    });
                }
            }
        }
    }

    public final int getState() {
        return this.mState;
    }

    /* access modifiers changed from: package-private */
    public final void K(int i2) {
        if (this.mState != i2) {
            this.mState = i2;
            V v = this.mViewRef.get();
            if (v != null && this.sV != null) {
                this.sV.f(v, i2);
            }
        }
    }

    private void reset() {
        this.mActivePointerId = -1;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(View view, float f2) {
        if (this.sO) {
            return true;
        }
        if (view.getTop() < this.sM) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (0.1f * f2)) - ((float) this.sM)) / ((float) this.sI) > 0.5f;
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

    /* access modifiers changed from: package-private */
    public final void b(View view, int i2) {
        int i3;
        if (i2 == 4) {
            i3 = this.sM;
        } else if (i2 == 3) {
            i3 = this.sL;
        } else if (!this.sN || i2 != 5) {
            throw new IllegalArgumentException("Illegal state argument: ".concat(String.valueOf(i2)));
        } else {
            i3 = this.sT;
        }
        if (this.sP.h(view, view.getLeft(), i3)) {
            K(2);
            u.b(view, new c(view, i2));
            return;
        }
        K(i2);
    }

    /* access modifiers changed from: package-private */
    public final void Z(int i2) {
        V v = this.mViewRef.get();
        if (v != null && this.sV != null) {
            if (i2 > this.sM) {
                this.sV.b(v, ((float) (this.sM - i2)) / ((float) (this.sT - this.sM)));
            } else {
                this.sV.b(v, ((float) (this.sM - i2)) / ((float) (this.sM - this.sL)));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements Runnable {
        private final View mView;
        private final int tg;

        c(View view, int i2) {
            this.mView = view;
            this.tg = i2;
        }

        public final void run() {
            if (MMBottomSheetBehavior.this.sP == null || !MMBottomSheetBehavior.this.sP.go()) {
                MMBottomSheetBehavior.this.K(this.tg);
            } else {
                u.b(this.mView, this);
            }
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class android.support.design.widget.MMBottomSheetBehavior.SavedState.AnonymousClass1 */

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

    public static <V extends View> MMBottomSheetBehavior<V> x(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.d)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.d) layoutParams).qC;
        if (behavior instanceof MMBottomSheetBehavior) {
            return (MMBottomSheetBehavior) behavior;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    public final void a(b bVar) {
        this.td = bVar;
    }
}
