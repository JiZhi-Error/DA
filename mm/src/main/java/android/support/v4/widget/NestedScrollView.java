package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.a.c;
import android.support.v4.view.k;
import android.support.v4.view.l;
import android.support.v4.view.n;
import android.support.v4.view.o;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.ArrayList;

public class NestedScrollView extends FrameLayout implements k, n {
    private static final a UT = new a();
    private static final int[] UU = {16843130};
    private long UC;
    private OverScroller UD;
    private EdgeEffect UE;
    private EdgeEffect UF;
    private int UG;
    private boolean UH;
    private boolean UJ;
    private View UK;
    private boolean UL;
    private boolean UM;
    private final int[] UN;
    private final int[] UO;
    private int UQ;
    private int UR;
    private SavedState US;
    private final o UV;
    private final l UW;
    private float UX;
    private b UY;
    private int mActivePointerId;
    private boolean mIsBeingDragged;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public interface b {
        void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mTempRect = new Rect();
        this.UH = true;
        this.UJ = false;
        this.UK = null;
        this.mIsBeingDragged = false;
        this.UM = true;
        this.mActivePointerId = -1;
        this.UN = new int[2];
        this.UO = new int[2];
        this.UD = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(TPMediaCodecProfileLevel.HEVCMainTierLevel52);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, UU, i2, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.UV = new o(this);
        this.UW = new l(this);
        setNestedScrollingEnabled(true);
        u.a(this, UT);
    }

    private boolean A(int i2, int i3) {
        return this.UW.A(i2, i3);
    }

    @Override // android.support.v4.view.k
    public final void aM(int i2) {
        this.UW.aM(i2);
    }

    private boolean aN(int i2) {
        return this.UW.aN(i2);
    }

    private boolean a(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return this.UW.a(i2, i3, i4, i5, iArr, i6);
    }

    private boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return this.UW.a(i2, i3, iArr, iArr2, i4);
    }

    @Override // android.support.v4.view.j
    public void setNestedScrollingEnabled(boolean z) {
        this.UW.setNestedScrollingEnabled(z);
    }

    @Override // android.support.v4.view.j
    public boolean isNestedScrollingEnabled() {
        return this.UW.PY;
    }

    public boolean startNestedScroll(int i2) {
        return A(i2, 0);
    }

    @Override // android.support.v4.view.j
    public void stopNestedScroll() {
        aM(0);
    }

    public boolean hasNestedScrollingParent() {
        return aN(0);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return a(i2, i3, i4, i5, iArr, 0);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return a(i2, i3, iArr, iArr2, 0);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.UW.dispatchNestedFling(f2, f3, z);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.UW.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.support.v4.view.n
    public final boolean a(View view, View view2, int i2, int i3) {
        return (i2 & 2) != 0;
    }

    @Override // android.support.v4.view.n
    public final void b(View view, View view2, int i2, int i3) {
        this.UV.Qb = i2;
        A(2, i3);
    }

    @Override // android.support.v4.view.n
    public final void k(View view, int i2) {
        this.UV.Qb = 0;
        aM(i2);
    }

    @Override // android.support.v4.view.n
    public final void a(View view, int i2, int i3, int i4, int i5, int i6) {
        int scrollY = getScrollY();
        scrollBy(0, i5);
        int scrollY2 = getScrollY() - scrollY;
        a(0, scrollY2, 0, i5 - scrollY2, (int[]) null, i6);
    }

    @Override // android.support.v4.view.n
    public final void a(View view, int i2, int i3, int[] iArr, int i4) {
        a(i2, i3, iArr, (int[]) null, i4);
    }

    @Override // android.support.v4.view.m
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return a(view, view2, i2, 0);
    }

    @Override // android.support.v4.view.m
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        b(view, view2, i2, 0);
    }

    @Override // android.support.v4.view.m
    public void onStopNestedScroll(View view) {
        k(view, 0);
    }

    @Override // android.support.v4.view.m
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        a(view, i2, i3, i4, i5, 0);
    }

    @Override // android.support.v4.view.m
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        a(view, i2, i3, iArr, 0);
    }

    @Override // android.support.v4.view.m
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        if (z) {
            return false;
        }
        bc((int) f3);
        return true;
    }

    @Override // android.support.v4.view.m
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    public int getNestedScrollAxes() {
        return this.UV.Qb;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + childAt.getBottom()) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i2, layoutParams);
    }

    public void setOnScrollChangeListener(b bVar) {
        this.UY = bVar;
    }

    private boolean fG() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (layoutParams.bottomMargin + childAt.getHeight() + layoutParams.topMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
            return true;
        }
        return false;
    }

    public void setFillViewport(boolean z) {
        if (z != this.UL) {
            this.UL = z;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.UM = z;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        if (this.UY != null) {
            this.UY.a(this, i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.UL && View.MeasureSpec.getMode(i3) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public final boolean executeKeyEvent(KeyEvent keyEvent) {
        boolean z;
        int i2 = 33;
        this.mTempRect.setEmpty();
        if (fG()) {
            if (keyEvent.getAction() == 0) {
                switch (keyEvent.getKeyCode()) {
                    case 19:
                        if (keyEvent.isAltPressed()) {
                            z = fullScroll(33);
                            break;
                        } else {
                            z = arrowScroll(33);
                            break;
                        }
                    case 20:
                        if (keyEvent.isAltPressed()) {
                            z = fullScroll(130);
                            break;
                        } else {
                            z = arrowScroll(130);
                            break;
                        }
                    case 62:
                        if (!keyEvent.isShiftPressed()) {
                            i2 = 130;
                        }
                        pageScroll(i2);
                    default:
                        z = false;
                        break;
                }
                return z;
            }
            z = false;
            return z;
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) {
                return false;
            }
            return true;
        }
    }

    private void gb() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void gd() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            gd();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2 = true;
        int action = motionEvent.getAction();
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        switch (action & 255) {
            case 0:
                int y = (int) motionEvent.getY();
                int x = (int) motionEvent.getX();
                if (getChildCount() > 0) {
                    int scrollY = getScrollY();
                    View childAt = getChildAt(0);
                    z = y >= childAt.getTop() - scrollY && y < childAt.getBottom() - scrollY && x >= childAt.getLeft() && x < childAt.getRight();
                } else {
                    z = false;
                }
                if (z) {
                    this.UG = y;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    if (this.mVelocityTracker == null) {
                        this.mVelocityTracker = VelocityTracker.obtain();
                    } else {
                        this.mVelocityTracker.clear();
                    }
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.UD.computeScrollOffset();
                    if (this.UD.isFinished()) {
                        z2 = false;
                    }
                    this.mIsBeingDragged = z2;
                    A(2, 0);
                    break;
                } else {
                    this.mIsBeingDragged = false;
                    gd();
                    break;
                }
                break;
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                gd();
                if (this.UD.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    u.X(this);
                }
                aM(0);
                break;
            case 2:
                int i2 = this.mActivePointerId;
                if (i2 != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    if (findPointerIndex != -1) {
                        int y2 = (int) motionEvent.getY(findPointerIndex);
                        if (Math.abs(y2 - this.UG) > this.mTouchSlop && (getNestedScrollAxes() & 2) == 0) {
                            this.mIsBeingDragged = true;
                            this.UG = y2;
                            gb();
                            this.mVelocityTracker.addMovement(motionEvent);
                            this.UQ = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    } else {
                        new StringBuilder("Invalid pointerId=").append(i2).append(" in onInterceptTouchEvent");
                        break;
                    }
                }
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        return this.mIsBeingDragged;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        boolean z;
        ViewParent parent;
        gb();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.UQ = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.UQ);
        switch (actionMasked) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z2 = !this.UD.isFinished();
                    this.mIsBeingDragged = z2;
                    if (z2 && (parent = getParent()) != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    if (!this.UD.isFinished()) {
                        this.UD.abortAnimation();
                    }
                    this.UG = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    A(2, 0);
                    break;
                } else {
                    return false;
                }
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                int yVelocity = (int) velocityTracker.getYVelocity(this.mActivePointerId);
                if (Math.abs(yVelocity) > this.mMinimumVelocity) {
                    bc(-yVelocity);
                } else if (this.UD.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    u.X(this);
                }
                this.mActivePointerId = -1;
                endDrag();
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex != -1) {
                    int y = (int) motionEvent.getY(findPointerIndex);
                    int i3 = this.UG - y;
                    if (a(0, i3, this.UO, this.UN, 0)) {
                        i3 -= this.UO[1];
                        obtain.offsetLocation(0.0f, (float) this.UN[1]);
                        this.UQ += this.UN[1];
                    }
                    if (this.mIsBeingDragged || Math.abs(i3) <= this.mTouchSlop) {
                        i2 = i3;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.mIsBeingDragged = true;
                        if (i3 > 0) {
                            i2 = i3 - this.mTouchSlop;
                        } else {
                            i2 = i3 + this.mTouchSlop;
                        }
                    }
                    if (this.mIsBeingDragged) {
                        this.UG = y - this.UN[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (g(i2, 0, getScrollY(), scrollRange) && !aN(0)) {
                            this.mVelocityTracker.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!a(0, scrollY2, 0, i2 - scrollY2, this.UN, 0)) {
                            if (z) {
                                ge();
                                int i4 = scrollY + i2;
                                if (i4 < 0) {
                                    i.a(this.UE, ((float) i2) / ((float) getHeight()), motionEvent.getX(findPointerIndex) / ((float) getWidth()));
                                    if (!this.UF.isFinished()) {
                                        this.UF.onRelease();
                                    }
                                } else if (i4 > scrollRange) {
                                    i.a(this.UF, ((float) i2) / ((float) getHeight()), 1.0f - (motionEvent.getX(findPointerIndex) / ((float) getWidth())));
                                    if (!this.UE.isFinished()) {
                                        this.UE.onRelease();
                                    }
                                }
                                if (this.UE != null && (!this.UE.isFinished() || !this.UF.isFinished())) {
                                    u.X(this);
                                    break;
                                }
                            }
                        } else {
                            this.UG -= this.UN[1];
                            obtain.offsetLocation(0.0f, (float) this.UN[1]);
                            this.UQ += this.UN[1];
                            break;
                        }
                    }
                } else {
                    new StringBuilder("Invalid pointerId=").append(this.mActivePointerId).append(" in onTouchEvent");
                    break;
                }
                break;
            case 3:
                if (this.mIsBeingDragged && getChildCount() > 0 && this.UD.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    u.X(this);
                }
                this.mActivePointerId = -1;
                endDrag();
                break;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                this.UG = (int) motionEvent.getY(actionIndex);
                this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                this.UG = (int) motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId));
                break;
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.UG = (int) motionEvent.getY(i2);
            this.mActivePointerId = motionEvent.getPointerId(i2);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 8:
                if (this.mIsBeingDragged) {
                    return false;
                }
                float axisValue = motionEvent.getAxisValue(9);
                if (axisValue == 0.0f) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i2 = scrollY - verticalScrollFactorCompat;
                if (i2 < 0) {
                    scrollRange = 0;
                } else if (i2 <= scrollRange) {
                    scrollRange = i2;
                }
                if (scrollRange == scrollY) {
                    return false;
                }
                super.scrollTo(getScrollX(), scrollRange);
                return true;
            default:
                return false;
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.UX == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.UX = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.UX;
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        super.scrollTo(i2, i3);
    }

    private boolean g(int i2, int i3, int i4, int i5) {
        boolean z;
        boolean z2;
        getOverScrollMode();
        computeHorizontalScrollRange();
        computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        computeVerticalScrollExtent();
        int i6 = i3 + 0;
        int i7 = i4 + i2;
        int i8 = i5 + 0;
        if (i6 > 0) {
            i6 = 0;
            z = true;
        } else if (i6 < 0) {
            i6 = 0;
            z = true;
        } else {
            z = false;
        }
        if (i7 > i8) {
            z2 = true;
        } else if (i7 < 0) {
            z2 = true;
            i8 = 0;
        } else {
            z2 = false;
            i8 = i7;
        }
        if (z2 && !aN(1)) {
            this.UD.springBack(i6, i8, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i6, i8, z, z2);
        return z || z2;
    }

    /* access modifiers changed from: package-private */
    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, (layoutParams.bottomMargin + (childAt.getHeight() + layoutParams.topMargin)) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    private View c(boolean z, int i2, int i3) {
        boolean z2;
        ArrayList focusables = getFocusables(2);
        View view = null;
        int size = focusables.size();
        int i4 = 0;
        boolean z3 = false;
        while (i4 < size) {
            View view2 = (View) focusables.get(i4);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i2 < bottom && top < i3) {
                z2 = i2 < top && bottom < i3;
                if (view != null) {
                    boolean z4 = (z && top < view.getTop()) || (!z && bottom > view.getBottom());
                    if (z3) {
                        if (z2 && z4) {
                            z2 = z3;
                        }
                    } else if (z2) {
                        z2 = true;
                    } else if (z4) {
                        z2 = z3;
                    }
                }
                i4++;
                z3 = z2;
                view = view2;
            }
            z2 = z3;
            view2 = view;
            i4++;
            z3 = z2;
            view = view2;
        }
        return view;
    }

    private boolean pageScroll(int i2) {
        boolean z = i2 == 130;
        int height = getHeight();
        if (z) {
            this.mTempRect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + childAt.getBottom() + getPaddingBottom();
                if (this.mTempRect.top + height > bottom) {
                    this.mTempRect.top = bottom - height;
                }
            }
        } else {
            this.mTempRect.top = getScrollY() - height;
            if (this.mTempRect.top < 0) {
                this.mTempRect.top = 0;
            }
        }
        this.mTempRect.bottom = this.mTempRect.top + height;
        return g(i2, this.mTempRect.top, this.mTempRect.bottom);
    }

    public final boolean fullScroll(int i2) {
        int childCount;
        boolean z = i2 == 130;
        int height = getHeight();
        this.mTempRect.top = 0;
        this.mTempRect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.mTempRect.bottom = ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + childAt.getBottom() + getPaddingBottom();
            this.mTempRect.top = this.mTempRect.bottom - height;
        }
        return g(i2, this.mTempRect.top, this.mTempRect.bottom);
    }

    private boolean g(int i2, int i3, int i4) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = scrollY + height;
        boolean z2 = i2 == 33;
        View c2 = c(z2, i3, i4);
        if (c2 == null) {
            c2 = this;
        }
        if (i3 < scrollY || i4 > i5) {
            aY(z2 ? i3 - scrollY : i4 - i5);
            z = true;
        }
        if (c2 != findFocus()) {
            c2.requestFocus(i2);
        }
        return z;
    }

    private boolean arrowScroll(int i2) {
        View view;
        int i3;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i2);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !g(findNextFocus, maxScrollAmount, getHeight())) {
            if (i2 == 33 && getScrollY() < maxScrollAmount) {
                i3 = getScrollY();
            } else if (i2 != 130 || getChildCount() <= 0) {
                i3 = maxScrollAmount;
            } else {
                View childAt = getChildAt(0);
                i3 = Math.min((((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + childAt.getBottom()) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (i3 == 0) {
                return false;
            }
            if (i2 != 130) {
                i3 = -i3;
            }
            aY(i3);
        } else {
            findNextFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findNextFocus, this.mTempRect);
            aY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
            findNextFocus.requestFocus(i2);
        }
        if (view != null && view.isFocused() && aT(view)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    private boolean aT(View view) {
        return !g(view, 0, getHeight());
    }

    private boolean g(View view, int i2, int i3) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        return this.mTempRect.bottom + i2 >= getScrollY() && this.mTempRect.top - i2 <= getScrollY() + i3;
    }

    private void aY(int i2) {
        if (i2 == 0) {
            return;
        }
        if (this.UM) {
            smoothScrollBy(0, i2);
        } else {
            scrollBy(0, i2);
        }
    }

    private void smoothScrollBy(int i2, int i3) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.UC > 250) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int height = layoutParams.bottomMargin + childAt.getHeight() + layoutParams.topMargin;
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int scrollY = getScrollY();
                this.UR = getScrollY();
                OverScroller overScroller = this.UD;
                int scrollX = getScrollX();
                overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(scrollY + i3, Math.max(0, height - height2))) - scrollY);
                u.X(this);
            } else {
                if (!this.UD.isFinished()) {
                    this.UD.abortAnimation();
                }
                scrollBy(i2, i3);
            }
            this.UC = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void aZ(int i2) {
        smoothScrollBy(0 - getScrollX(), i2 - getScrollY());
    }

    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + childAt.getBottom();
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > max) {
            return bottom + (scrollY - max);
        }
        return bottom;
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    /* access modifiers changed from: protected */
    public void measureChild(View view, int i2, int i3) {
        view.measure(getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    public void computeScroll() {
        boolean z = false;
        if (this.UD.computeScrollOffset()) {
            this.UD.getCurrX();
            int currY = this.UD.getCurrY();
            int i2 = currY - this.UR;
            if (a(0, i2, this.UO, (int[]) null, 1)) {
                i2 -= this.UO[1];
            }
            if (i2 != 0) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                g(i2, getScrollX(), scrollY, scrollRange);
                int scrollY2 = getScrollY() - scrollY;
                if (!a(0, scrollY2, 0, i2 - scrollY2, (int[]) null, 1)) {
                    int overScrollMode = getOverScrollMode();
                    if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                        z = true;
                    }
                    if (z) {
                        ge();
                        if (currY <= 0 && scrollY > 0) {
                            this.UE.onAbsorb((int) this.UD.getCurrVelocity());
                        } else if (currY >= scrollRange && scrollY < scrollRange) {
                            this.UF.onAbsorb((int) this.UD.getCurrVelocity());
                        }
                    }
                }
            }
            this.UR = currY;
            u.X(this);
            return;
        }
        if (aN(1)) {
            aM(1);
        }
        this.UR = 0;
    }

    private void aU(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    private int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i7 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            i2 = scrollY + verticalFadingEdgeLength;
        } else {
            i2 = scrollY;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (rect.bottom < childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin) {
            i3 = i7 - verticalFadingEdgeLength;
        } else {
            i3 = i7;
        }
        if (rect.bottom > i3 && rect.top > i2) {
            if (rect.height() > height) {
                i6 = (rect.top - i2) + 0;
            } else {
                i6 = (rect.bottom - i3) + 0;
            }
            i4 = Math.min(i6, (layoutParams.bottomMargin + childAt.getBottom()) - i7);
        } else if (rect.top >= i2 || rect.bottom >= i3) {
            i4 = 0;
        } else {
            if (rect.height() > height) {
                i5 = 0 - (i3 - rect.bottom);
            } else {
                i5 = 0 - (i2 - rect.top);
            }
            i4 = Math.max(i5, -getScrollY());
        }
        return i4;
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.UH) {
            aU(view2);
        } else {
            this.UK = view2;
        }
        super.requestChildFocus(view, view2);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        View findNextFocusFromRect;
        if (i2 == 2) {
            i2 = 130;
        } else if (i2 == 1) {
            i2 = 33;
        }
        if (rect == null) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, null, i2);
        } else {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i2);
        }
        if (findNextFocusFromRect != null && !aT(findNextFocusFromRect)) {
            return findNextFocusFromRect.requestFocus(i2, rect);
        }
        return false;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean z2 = computeScrollDeltaToGetChildRectOnScreen != 0;
        if (z2) {
            if (z) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            } else {
                smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
        return z2;
    }

    public void requestLayout() {
        this.UH = true;
        super.requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        super.onLayout(z, i2, i3, i4, i5);
        this.UH = false;
        if (this.UK != null && c(this.UK, this)) {
            aU(this.UK);
        }
        this.UK = null;
        if (!this.UJ) {
            if (this.US != null) {
                scrollTo(getScrollX(), this.US.UZ);
                this.US = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i6 = layoutParams.bottomMargin + childAt.getMeasuredHeight() + layoutParams.topMargin;
            }
            int paddingTop = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int clamp = clamp(scrollY, paddingTop, i6);
            if (clamp != scrollY) {
                scrollTo(getScrollX(), clamp);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.UJ = true;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.UJ = false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && g(findFocus, 0, i5)) {
            findFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findFocus, this.mTempRect);
            aY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        }
    }

    private static boolean c(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup) || !c((View) parent, view2)) {
            return false;
        }
        return true;
    }

    public void fling(int i2) {
        if (getChildCount() > 0) {
            A(2, 1);
            this.UD.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            this.UR = getScrollY();
            u.X(this);
        }
    }

    private void bc(int i2) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i2 > 0) && (scrollY < getScrollRange() || i2 < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i2)) {
            dispatchNestedFling(0.0f, (float) i2, z);
            fling(i2);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        gd();
        aM(0);
        if (this.UE != null) {
            this.UE.onRelease();
            this.UF.onRelease();
        }
    }

    public void scrollTo(int i2, int i3) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = layoutParams.bottomMargin + childAt.getHeight() + layoutParams.topMargin;
            int clamp = clamp(i2, width, width2);
            int clamp2 = clamp(i3, height, height2);
            if (clamp != getScrollX() || clamp2 != getScrollY()) {
                super.scrollTo(clamp, clamp2);
            }
        }
    }

    private void ge() {
        if (getOverScrollMode() == 2) {
            this.UE = null;
            this.UF = null;
        } else if (this.UE == null) {
            Context context = getContext();
            this.UE = new EdgeEffect(context);
            this.UF = new EdgeEffect(context);
        }
    }

    public void draw(Canvas canvas) {
        int i2;
        int i3 = 0;
        super.draw(canvas);
        if (this.UE != null) {
            int scrollY = getScrollY();
            if (!this.UE.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int min = Math.min(0, scrollY);
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    i2 = getPaddingLeft() + 0;
                } else {
                    i2 = 0;
                }
                if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    min += getPaddingTop();
                }
                canvas.translate((float) i2, (float) min);
                this.UE.setSize(width, height);
                if (this.UE.draw(canvas)) {
                    u.X(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.UF.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = getHeight();
                int max = Math.max(getScrollRange(), scrollY) + height2;
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width2 -= getPaddingLeft() + getPaddingRight();
                    i3 = getPaddingLeft() + 0;
                }
                if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height2 -= getPaddingTop() + getPaddingBottom();
                    max -= getPaddingBottom();
                }
                canvas.translate((float) (i3 - width2), (float) max);
                canvas.rotate(180.0f, (float) width2, 0.0f);
                this.UF.setSize(width2, height2);
                if (this.UF.draw(canvas)) {
                    u.X(this);
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    private static int clamp(int i2, int i3, int i4) {
        if (i3 >= i4 || i2 < 0) {
            return 0;
        }
        if (i3 + i2 > i4) {
            return i4 - i3;
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.US = savedState;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.UZ = getScrollY();
        return savedState;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class android.support.v4.widget.NestedScrollView.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };
        public int UZ;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.UZ = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.UZ);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.UZ + "}";
        }
    }

    static class a extends android.support.v4.view.a {
        a() {
        }

        @Override // android.support.v4.view.a
        public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (super.performAccessibilityAction(view, i2, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            switch (i2) {
                case 4096:
                    int min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.aZ(min);
                    return true;
                case 8192:
                    int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.aZ(max);
                    return true;
                default:
                    return false;
            }
        }

        @Override // android.support.v4.view.a
        public final void onInitializeAccessibilityNodeInfo(View view, c cVar) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            cVar.setClassName(ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                cVar.setScrollable(true);
                if (nestedScrollView.getScrollY() > 0) {
                    cVar.addAction(8192);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    cVar.addAction(4096);
                }
            }
        }

        @Override // android.support.v4.view.a
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            int scrollX = nestedScrollView.getScrollX();
            if (Build.VERSION.SDK_INT >= 15) {
                accessibilityEvent.setMaxScrollX(scrollX);
            }
            int scrollRange = nestedScrollView.getScrollRange();
            if (Build.VERSION.SDK_INT >= 15) {
                accessibilityEvent.setMaxScrollY(scrollRange);
            }
        }
    }
}
