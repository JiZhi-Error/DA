package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.view.j;
import android.support.v4.view.l;
import android.support.v4.view.m;
import android.support.v4.view.o;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;

public class SwipeRefreshLayout extends ViewGroup implements j, m {
    private static final int[] LAYOUT_ATTRS = {16842766};
    private static final String LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
    private View Sg;
    b VD;
    boolean VE = false;
    private float VF = -1.0f;
    private float VG;
    private final l VH;
    private final int[] VI = new int[2];
    private final int[] VJ = new int[2];
    private boolean VK;
    private int VL;
    int VM;
    private float VN;
    boolean VO;
    private boolean VP;
    private final DecelerateInterpolator VQ;
    c VR;
    private int VS = -1;
    float VT;
    protected int VU;
    int VV;
    int VW;
    d VX;
    private Animation VY;
    private Animation VZ;
    private Animation Wa;
    private Animation Wb;
    private Animation Wc;
    boolean Wd;
    private int We;
    boolean Wf;
    private a Wg;
    private Animation.AnimationListener Wh = new Animation.AnimationListener() {
        /* class android.support.v4.widget.SwipeRefreshLayout.AnonymousClass1 */

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            if (SwipeRefreshLayout.this.VE) {
                SwipeRefreshLayout.this.VX.setAlpha(255);
                SwipeRefreshLayout.this.VX.start();
                SwipeRefreshLayout.this.VM = SwipeRefreshLayout.this.VR.getTop();
                return;
            }
            SwipeRefreshLayout.this.reset();
        }
    };
    private final Animation Wi = new Animation() {
        /* class android.support.v4.widget.SwipeRefreshLayout.AnonymousClass6 */

        public final void applyTransformation(float f2, Transformation transformation) {
            int i2;
            if (!SwipeRefreshLayout.this.Wf) {
                i2 = SwipeRefreshLayout.this.VV - Math.abs(SwipeRefreshLayout.this.VU);
            } else {
                i2 = SwipeRefreshLayout.this.VV;
            }
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((((int) (((float) (i2 - SwipeRefreshLayout.this.mFrom)) * f2)) + SwipeRefreshLayout.this.mFrom) - SwipeRefreshLayout.this.VR.getTop());
            SwipeRefreshLayout.this.VX.C(1.0f - f2);
        }
    };
    private final Animation Wj = new Animation() {
        /* class android.support.v4.widget.SwipeRefreshLayout.AnonymousClass7 */

        public final void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.M(f2);
        }
    };
    private int mActivePointerId = -1;
    protected int mFrom;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private int mTouchSlop;
    private final o qA;

    public interface a {
        boolean gm();
    }

    public interface b {
    }

    /* access modifiers changed from: package-private */
    public final void reset() {
        this.VR.clearAnimation();
        this.VX.stop();
        this.VR.setVisibility(8);
        setColorViewAlpha(255);
        if (this.VO) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.VU - this.VM);
        }
        this.VM = this.VR.getTop();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            reset();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void setColorViewAlpha(int i2) {
        this.VR.getBackground().setAlpha(i2);
        this.VX.setAlpha(i2);
    }

    public int getProgressViewStartOffset() {
        return this.VU;
    }

    public int getProgressViewEndOffset() {
        return this.VV;
    }

    public void setSlingshotDistance(int i2) {
        this.VW = i2;
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                this.We = (int) (displayMetrics.density * 56.0f);
            } else {
                this.We = (int) (displayMetrics.density * 40.0f);
            }
            this.VR.setImageDrawable(null);
            this.VX.setStyle(i2);
            this.VR.setImageDrawable(this.VX);
        }
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.VL = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.VQ = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.We = (int) (40.0f * displayMetrics.density);
        this.VR = new c(getContext());
        this.VX = new d(getContext());
        this.VX.setStyle(1);
        this.VR.setImageDrawable(this.VX);
        this.VR.setVisibility(8);
        addView(this.VR);
        setChildrenDrawingOrderEnabled(true);
        this.VV = (int) (displayMetrics.density * 64.0f);
        this.VF = (float) this.VV;
        this.qA = new o(this);
        this.VH = new l(this);
        setNestedScrollingEnabled(true);
        int i2 = -this.We;
        this.VM = i2;
        this.VU = i2;
        M(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        if (this.VS < 0) {
            return i3;
        }
        if (i3 == i2 - 1) {
            return this.VS;
        }
        if (i3 >= this.VS) {
            return i3 + 1;
        }
        return i3;
    }

    public void setOnRefreshListener(b bVar) {
        this.VD = bVar;
    }

    public void setRefreshing(boolean z) {
        int i2;
        if (!z || this.VE == z) {
            f(z, false);
            return;
        }
        this.VE = z;
        if (!this.Wf) {
            i2 = this.VV + this.VU;
        } else {
            i2 = this.VV;
        }
        setTargetOffsetTopAndBottom(i2 - this.VM);
        this.Wd = false;
        Animation.AnimationListener animationListener = this.Wh;
        this.VR.setVisibility(0);
        this.VX.setAlpha(255);
        this.VY = new Animation() {
            /* class android.support.v4.widget.SwipeRefreshLayout.AnonymousClass2 */

            public final void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f2);
            }
        };
        this.VY.setDuration((long) this.VL);
        if (animationListener != null) {
            this.VR.SD = animationListener;
        }
        this.VR.clearAnimation();
        this.VR.startAnimation(this.VY);
    }

    /* access modifiers changed from: package-private */
    public void setAnimationProgress(float f2) {
        this.VR.setScaleX(f2);
        this.VR.setScaleY(f2);
    }

    private void f(boolean z, boolean z2) {
        if (this.VE != z) {
            this.Wd = z2;
            gk();
            this.VE = z;
            if (this.VE) {
                a(this.VM, this.Wh);
            } else {
                a(this.Wh);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Animation.AnimationListener animationListener) {
        this.VZ = new Animation() {
            /* class android.support.v4.widget.SwipeRefreshLayout.AnonymousClass3 */

            public final void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f2);
            }
        };
        this.VZ.setDuration(150);
        this.VR.SD = animationListener;
        this.VR.clearAnimation();
        this.VR.startAnimation(this.VZ);
    }

    private void gi() {
        this.Wa = G(this.VX.getAlpha(), 76);
    }

    private void gj() {
        this.Wb = G(this.VX.getAlpha(), 255);
    }

    private Animation G(final int i2, final int i3) {
        AnonymousClass4 r0 = new Animation() {
            /* class android.support.v4.widget.SwipeRefreshLayout.AnonymousClass4 */

            public final void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.VX.setAlpha((int) (((float) i2) + (((float) (i3 - i2)) * f2)));
            }
        };
        r0.setDuration(300);
        this.VR.SD = null;
        this.VR.clearAnimation();
        this.VR.startAnimation(r0);
        return r0;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeResource(@android.support.annotation.a int i2) {
        setProgressBackgroundColorSchemeColor(android.support.v4.content.b.n(getContext(), i2));
    }

    public void setProgressBackgroundColorSchemeColor(int i2) {
        this.VR.setBackgroundColor(i2);
    }

    @Deprecated
    public void setColorScheme(@android.support.annotation.a int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(@android.support.annotation.a int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = android.support.v4.content.b.n(context, iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        gk();
        d dVar = this.VX;
        dVar.SL.setColors(iArr);
        dVar.SL.aV(0);
        dVar.invalidateSelf();
    }

    private void gk() {
        if (this.Sg == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.VR)) {
                    this.Sg = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i2) {
        this.VF = (float) i2;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.Sg == null) {
                gk();
            }
            if (this.Sg != null) {
                View view = this.Sg;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.VR.getMeasuredWidth();
                this.VR.layout((measuredWidth / 2) - (measuredWidth2 / 2), this.VM, (measuredWidth / 2) + (measuredWidth2 / 2), this.VM + this.VR.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.Sg == null) {
            gk();
        }
        if (this.Sg != null) {
            this.Sg.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.VR.measure(View.MeasureSpec.makeMeasureSpec(this.We, 1073741824), View.MeasureSpec.makeMeasureSpec(this.We, 1073741824));
            this.VS = -1;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                if (getChildAt(i4) == this.VR) {
                    this.VS = i4;
                    return;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.We;
    }

    private boolean gl() {
        if (this.Wg != null) {
            return this.Wg.gm();
        }
        if (!(this.Sg instanceof ListView)) {
            return this.Sg.canScrollVertically(-1);
        }
        ListView listView = (ListView) this.Sg;
        if (Build.VERSION.SDK_INT >= 19) {
            return listView.canScrollList(-1);
        }
        if (listView.getChildCount() != 0) {
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int top = listView.getChildAt(0).getTop();
            if (firstVisiblePosition > 0 || top < listView.getListPaddingTop()) {
                return true;
            }
        }
        return false;
    }

    public void setOnChildScrollUpCallback(a aVar) {
        this.Wg = aVar;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        gk();
        int actionMasked = motionEvent.getActionMasked();
        if (this.VP && actionMasked == 0) {
            this.VP = false;
        }
        if (!isEnabled() || this.VP || gl() || this.VE || this.VK) {
            return false;
        }
        switch (actionMasked) {
            case 0:
                setTargetOffsetTopAndBottom(this.VU - this.VR.getTop());
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mIsBeingDragged = false;
                int findPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex2 >= 0) {
                    this.VN = motionEvent.getY(findPointerIndex2);
                    break;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                break;
            case 2:
                if (this.mActivePointerId != -1 && (findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId)) >= 0) {
                    L(motionEvent.getY(findPointerIndex));
                    break;
                } else {
                    return false;
                }
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        return this.mIsBeingDragged;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT < 21 && (this.Sg instanceof AbsListView)) {
            return;
        }
        if (this.Sg == null || u.aw(this.Sg)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // android.support.v4.view.m
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return isEnabled() && !this.VP && !this.VE && (i2 & 2) != 0;
    }

    @Override // android.support.v4.view.m
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.qA.Qb = i2;
        startNestedScroll(i2 & 2);
        this.VG = 0.0f;
        this.VK = true;
    }

    @Override // android.support.v4.view.m
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0 && this.VG > 0.0f) {
            if (((float) i3) > this.VG) {
                iArr[1] = i3 - ((int) this.VG);
                this.VG = 0.0f;
            } else {
                this.VG -= (float) i3;
                iArr[1] = i3;
            }
            J(this.VG);
        }
        if (this.Wf && i3 > 0 && this.VG == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.VR.setVisibility(8);
        }
        int[] iArr2 = this.VI;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    public int getNestedScrollAxes() {
        return this.qA.Qb;
    }

    @Override // android.support.v4.view.m
    public void onStopNestedScroll(View view) {
        this.qA.Qb = 0;
        this.VK = false;
        if (this.VG > 0.0f) {
            K(this.VG);
            this.VG = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.support.v4.view.m
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        dispatchNestedScroll(i2, i3, i4, i5, this.VJ);
        int i6 = this.VJ[1] + i5;
        if (i6 < 0 && !gl()) {
            this.VG = ((float) Math.abs(i6)) + this.VG;
            J(this.VG);
        }
    }

    @Override // android.support.v4.view.j
    public void setNestedScrollingEnabled(boolean z) {
        this.VH.setNestedScrollingEnabled(z);
    }

    @Override // android.support.v4.view.j
    public boolean isNestedScrollingEnabled() {
        return this.VH.PY;
    }

    public boolean startNestedScroll(int i2) {
        return this.VH.A(i2, 0);
    }

    @Override // android.support.v4.view.j
    public void stopNestedScroll() {
        this.VH.aM(0);
    }

    public boolean hasNestedScrollingParent() {
        return this.VH.aN(0);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.VH.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.VH.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.support.v4.view.m
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.support.v4.view.m
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return dispatchNestedFling(f2, f3, z);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.VH.dispatchNestedFling(f2, f3, z);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.VH.dispatchNestedPreFling(f2, f3);
    }

    private static boolean a(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    private void J(float f2) {
        int i2;
        this.VX.M(true);
        float min = Math.min(1.0f, Math.abs(f2 / this.VF));
        float max = (Math.max((float) (((double) min) - 0.4d), 0.0f) * 5.0f) / 3.0f;
        float abs = Math.abs(f2) - this.VF;
        if (this.VW > 0) {
            i2 = this.VW;
        } else {
            i2 = this.Wf ? this.VV - this.VU : this.VV;
        }
        float f3 = (float) i2;
        float max2 = Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3);
        float pow = ((float) (((double) (max2 / 4.0f)) - Math.pow((double) (max2 / 4.0f), 2.0d))) * 2.0f;
        int i3 = ((int) ((f3 * min) + (f3 * pow * 2.0f))) + this.VU;
        if (this.VR.getVisibility() != 0) {
            this.VR.setVisibility(0);
        }
        if (!this.VO) {
            this.VR.setScaleX(1.0f);
            this.VR.setScaleY(1.0f);
        }
        if (this.VO) {
            setAnimationProgress(Math.min(1.0f, f2 / this.VF));
        }
        if (f2 < this.VF) {
            if (this.VX.getAlpha() > 76 && !a(this.Wa)) {
                gi();
            }
        } else if (this.VX.getAlpha() < 255 && !a(this.Wb)) {
            gj();
        }
        this.VX.D(Math.min(0.8f, max * 0.8f));
        this.VX.C(Math.min(1.0f, max));
        this.VX.E((-0.25f + (max * 0.4f) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i3 - this.VM);
    }

    private void K(float f2) {
        if (f2 > this.VF) {
            f(true, true);
            return;
        }
        this.VE = false;
        this.VX.D(0.0f);
        AnonymousClass5 r0 = null;
        if (!this.VO) {
            r0 = new Animation.AnimationListener() {
                /* class android.support.v4.widget.SwipeRefreshLayout.AnonymousClass5 */

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    if (!SwipeRefreshLayout.this.VO) {
                        SwipeRefreshLayout.this.a((Animation.AnimationListener) null);
                    }
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            };
        }
        b(this.VM, r0);
        this.VX.M(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.VP && actionMasked == 0) {
            this.VP = false;
        }
        if (!isEnabled() || this.VP || gl() || this.VE || this.VK) {
            return false;
        }
        switch (actionMasked) {
            case 0:
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mIsBeingDragged = false;
                break;
            case 1:
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex < 0) {
                    return false;
                }
                if (this.mIsBeingDragged) {
                    this.mIsBeingDragged = false;
                    K((motionEvent.getY(findPointerIndex) - this.mInitialMotionY) * 0.5f);
                }
                this.mActivePointerId = -1;
                return false;
            case 2:
                int findPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex2 < 0) {
                    return false;
                }
                float y = motionEvent.getY(findPointerIndex2);
                L(y);
                if (this.mIsBeingDragged) {
                    float f2 = (y - this.mInitialMotionY) * 0.5f;
                    if (f2 > 0.0f) {
                        J(f2);
                        break;
                    } else {
                        return false;
                    }
                }
                break;
            case 3:
                return false;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex >= 0) {
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                    break;
                } else {
                    return false;
                }
            case 6:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        return true;
    }

    private void L(float f2) {
        if (f2 - this.VN > ((float) this.mTouchSlop) && !this.mIsBeingDragged) {
            this.mInitialMotionY = this.VN + ((float) this.mTouchSlop);
            this.mIsBeingDragged = true;
            this.VX.setAlpha(76);
        }
    }

    private void a(int i2, Animation.AnimationListener animationListener) {
        this.mFrom = i2;
        this.Wi.reset();
        this.Wi.setDuration(200);
        this.Wi.setInterpolator(this.VQ);
        if (animationListener != null) {
            this.VR.SD = animationListener;
        }
        this.VR.clearAnimation();
        this.VR.startAnimation(this.Wi);
    }

    private void b(int i2, Animation.AnimationListener animationListener) {
        if (this.VO) {
            c(i2, animationListener);
            return;
        }
        this.mFrom = i2;
        this.Wj.reset();
        this.Wj.setDuration(200);
        this.Wj.setInterpolator(this.VQ);
        if (animationListener != null) {
            this.VR.SD = animationListener;
        }
        this.VR.clearAnimation();
        this.VR.startAnimation(this.Wj);
    }

    /* access modifiers changed from: package-private */
    public final void M(float f2) {
        setTargetOffsetTopAndBottom((this.mFrom + ((int) (((float) (this.VU - this.mFrom)) * f2))) - this.VR.getTop());
    }

    private void c(int i2, Animation.AnimationListener animationListener) {
        this.mFrom = i2;
        this.VT = this.VR.getScaleX();
        this.Wc = new Animation() {
            /* class android.support.v4.widget.SwipeRefreshLayout.AnonymousClass8 */

            public final void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(SwipeRefreshLayout.this.VT + ((-SwipeRefreshLayout.this.VT) * f2));
                SwipeRefreshLayout.this.M(f2);
            }
        };
        this.Wc.setDuration(150);
        if (animationListener != null) {
            this.VR.SD = animationListener;
        }
        this.VR.clearAnimation();
        this.VR.startAnimation(this.Wc);
    }

    /* access modifiers changed from: package-private */
    public void setTargetOffsetTopAndBottom(int i2) {
        this.VR.bringToFront();
        u.s(this.VR, i2);
        this.VM = this.VR.getTop();
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            this.mActivePointerId = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }
}
