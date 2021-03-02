package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.u;
import android.support.v4.widget.t;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
    private final Rect Ui;
    int Vg;
    private int Vh;
    private Drawable Vi;
    private Drawable Vj;
    private final int Vk;
    View Vl;
    float Vm;
    private float Vn;
    int Vo;
    int Vp;
    private d Vq;
    final t Vr;
    boolean Vs;
    final ArrayList<b> Vt;
    private Method Vu;
    private Field Vv;
    private boolean Vw;
    private boolean mCanSlide;
    private boolean mFirstLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    boolean mIsUnableToDrag;

    public interface d {
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Vg = -858993460;
        this.mFirstLayout = true;
        this.Ui = new Rect();
        this.Vt = new ArrayList<>();
        float f2 = context.getResources().getDisplayMetrics().density;
        this.Vk = (int) ((32.0f * f2) + 0.5f);
        setWillNotDraw(false);
        u.a(this, new a());
        u.p(this, 1);
        this.Vr = t.a(this, 0.5f, new c());
        this.Vr.WH = f2 * 400.0f;
    }

    public void setParallaxDistance(int i2) {
        this.Vp = i2;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.Vp;
    }

    public void setSliderFadeColor(int i2) {
        this.Vg = i2;
    }

    public int getSliderFadeColor() {
        return this.Vg;
    }

    public void setCoveredFadeColor(int i2) {
        this.Vh = i2;
    }

    public int getCoveredFadeColor() {
        return this.Vh;
    }

    public void setPanelSlideListener(d dVar) {
        this.Vq = dVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aV(android.view.View r18) {
        /*
        // Method dump skipped, instructions count: 209
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.aV(android.view.View):void");
    }

    /* access modifiers changed from: package-private */
    public final void gf() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        int size = this.Vt.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.Vt.get(i2).run();
        }
        this.Vt.clear();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int paddingTop;
        int makeMeasureSpec;
        int makeMeasureSpec2;
        float f2;
        int makeMeasureSpec3;
        int makeMeasureSpec4;
        int i6;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode == 1073741824) {
            if (mode2 == 0) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                } else if (mode2 == 0) {
                    size2 = 300;
                    i4 = Integer.MIN_VALUE;
                    i5 = size;
                }
            }
            i4 = mode2;
            i5 = size;
        } else if (isInEditMode()) {
            if (mode != Integer.MIN_VALUE && mode == 0) {
                i4 = mode2;
                i5 = 300;
            }
            i4 = mode2;
            i5 = size;
        } else {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        }
        int i7 = 0;
        switch (i4) {
            case Integer.MIN_VALUE:
                paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                int paddingTop2 = (size2 - getPaddingTop()) - getPaddingBottom();
                paddingTop = paddingTop2;
                i7 = paddingTop2;
                break;
            default:
                paddingTop = 0;
                break;
        }
        float f3 = 0.0f;
        boolean z = false;
        int paddingLeft = (i5 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        this.Vl = null;
        int i8 = 0;
        int i9 = paddingLeft;
        int i10 = i7;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.VA = false;
                i6 = i9;
                f2 = f3;
            } else {
                if (layoutParams.weight > 0.0f) {
                    f2 = layoutParams.weight + f3;
                    if (layoutParams.width == 0) {
                        i6 = i9;
                    }
                } else {
                    f2 = f3;
                }
                int i11 = layoutParams.leftMargin + layoutParams.rightMargin;
                if (layoutParams.width == -2) {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i11, Integer.MIN_VALUE);
                } else if (layoutParams.width == -1) {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i11, 1073741824);
                } else {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                }
                if (layoutParams.height == -2) {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                } else if (layoutParams.height == -1) {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                } else {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                }
                childAt.measure(makeMeasureSpec3, makeMeasureSpec4);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i4 == Integer.MIN_VALUE && measuredHeight > i10) {
                    i10 = Math.min(measuredHeight, paddingTop);
                }
                int i12 = i9 - measuredWidth;
                boolean z2 = i12 < 0;
                layoutParams.Vz = z2;
                boolean z3 = z2 | z;
                if (layoutParams.Vz) {
                    this.Vl = childAt;
                }
                i6 = i12;
                z = z3;
            }
            i8++;
            i9 = i6;
            f3 = f2;
        }
        if (z || f3 > 0.0f) {
            int i13 = paddingLeft - this.Vk;
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt2 = getChildAt(i14);
                if (childAt2.getVisibility() != 8) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        boolean z4 = layoutParams2.width == 0 && layoutParams2.weight > 0.0f;
                        int measuredWidth2 = z4 ? 0 : childAt2.getMeasuredWidth();
                        if (!z || childAt2 == this.Vl) {
                            if (layoutParams2.weight > 0.0f) {
                                if (layoutParams2.width != 0) {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                } else if (layoutParams2.height == -2) {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                } else if (layoutParams2.height == -1) {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                } else {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824);
                                }
                                if (z) {
                                    int i15 = paddingLeft - (layoutParams2.rightMargin + layoutParams2.leftMargin);
                                    int makeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
                                    if (measuredWidth2 != i15) {
                                        childAt2.measure(makeMeasureSpec5, makeMeasureSpec);
                                    }
                                } else {
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(((int) ((layoutParams2.weight * ((float) Math.max(0, i9))) / f3)) + measuredWidth2, 1073741824), makeMeasureSpec);
                                }
                            }
                        } else if (layoutParams2.width < 0 && (measuredWidth2 > i13 || layoutParams2.weight > 0.0f)) {
                            if (!z4) {
                                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            } else if (layoutParams2.height == -2) {
                                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                            } else if (layoutParams2.height == -1) {
                                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                            } else {
                                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824);
                            }
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec(i13, 1073741824), makeMeasureSpec2);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i5, getPaddingTop() + i10 + getPaddingBottom());
        this.mCanSlide = z;
        if (!(this.Vr.Wx == 0 || z)) {
            this.Vr.abort();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean gh = gh();
        if (gh) {
            this.Vr.WJ = 2;
        } else {
            this.Vr.WJ = 1;
        }
        int i11 = i4 - i2;
        int paddingRight = gh ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = gh ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.mFirstLayout) {
            this.Vm = (!this.mCanSlide || !this.Vs) ? 0.0f : 1.0f;
        }
        int i12 = 0;
        int i13 = paddingRight;
        int i14 = paddingRight;
        while (i12 < childCount) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int i15 = 0;
                if (layoutParams.Vz) {
                    int min = (Math.min(i13, (i11 - paddingLeft) - this.Vk) - i14) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.Vo = min;
                    int i16 = gh ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.VA = ((i14 + i16) + min) + (measuredWidth / 2) > i11 - paddingLeft;
                    int i17 = (int) (((float) min) * this.Vm);
                    i8 = i14 + i16 + i17;
                    this.Vm = ((float) i17) / ((float) this.Vo);
                } else {
                    i15 = (!this.mCanSlide || this.Vp == 0) ? 0 : (int) ((1.0f - this.Vm) * ((float) this.Vp));
                    i8 = i13;
                }
                if (gh) {
                    i10 = (i11 - i8) + i15;
                    i9 = i10 - measuredWidth;
                } else {
                    i9 = i8 - i15;
                    i10 = i9 + measuredWidth;
                }
                childAt.layout(i9, paddingTop, i10, childAt.getMeasuredHeight() + paddingTop);
                i6 = childAt.getWidth() + i13;
                i7 = i8;
            } else {
                i6 = i13;
                i7 = i14;
            }
            i12++;
            i13 = i6;
            i14 = i7;
        }
        if (this.mFirstLayout) {
            if (this.mCanSlide) {
                if (this.Vp != 0) {
                    I(this.Vm);
                }
                if (((LayoutParams) this.Vl.getLayoutParams()).VA) {
                    a(this.Vl, this.Vm, this.Vg);
                }
            } else {
                for (int i18 = 0; i18 < childCount; i18++) {
                    a(getChildAt(i18), 0.0f, this.Vg);
                }
            }
            aV(this.Vl);
        }
        this.mFirstLayout = false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            this.mFirstLayout = true;
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.mCanSlide) {
            this.Vs = view == this.Vl;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.mCanSlide && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.Vs = !t.i(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.mCanSlide || (this.mIsUnableToDrag && actionMasked != 0)) {
            this.Vr.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.Vr.cancel();
            return false;
        } else {
            switch (actionMasked) {
                case 0:
                    this.mIsUnableToDrag = false;
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.mInitialMotionX = x;
                    this.mInitialMotionY = y;
                    if (t.i(this.Vl, (int) x, (int) y) && aX(this.Vl)) {
                        z = true;
                        break;
                    }
                    z = false;
                    break;
                case 1:
                default:
                    z = false;
                    break;
                case 2:
                    float x2 = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    float abs = Math.abs(x2 - this.mInitialMotionX);
                    float abs2 = Math.abs(y2 - this.mInitialMotionY);
                    if (abs > ((float) this.Vr.mTouchSlop) && abs2 > abs) {
                        this.Vr.cancel();
                        this.mIsUnableToDrag = true;
                        return false;
                    }
                    z = false;
                    break;
            }
            return this.Vr.j(motionEvent) || z;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanSlide) {
            return super.onTouchEvent(motionEvent);
        }
        this.Vr.k(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                break;
            case 1:
                if (aX(this.Vl)) {
                    float x2 = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    float f2 = x2 - this.mInitialMotionX;
                    float f3 = y2 - this.mInitialMotionY;
                    int i2 = this.Vr.mTouchSlop;
                    if ((f2 * f2) + (f3 * f3) < ((float) (i2 * i2)) && t.i(this.Vl, (int) x2, (int) y2)) {
                        gg();
                        break;
                    }
                }
                break;
        }
        return true;
    }

    private boolean gg() {
        if (!this.mFirstLayout && !H(0.0f)) {
            return false;
        }
        this.Vs = false;
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void a(View view, float f2, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f2 > 0.0f && i2 != 0) {
            int i3 = (((int) (((float) ((-16777216 & i2) >>> 24)) * f2)) << 24) | (16777215 & i2);
            if (layoutParams.VB == null) {
                layoutParams.VB = new Paint();
            }
            layoutParams.VB.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.VB);
            }
            aW(view);
        } else if (view.getLayerType() != 0) {
            if (layoutParams.VB != null) {
                layoutParams.VB.setColorFilter(null);
            }
            b bVar = new b(view);
            this.Vt.add(bVar);
            u.b(this, bVar);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.mCanSlide && !layoutParams.Vz && this.Vl != null) {
            canvas.getClipBounds(this.Ui);
            if (gh()) {
                this.Ui.left = Math.max(this.Ui.left, this.Vl.getRight());
            } else {
                this.Ui.right = Math.min(this.Ui.right, this.Vl.getLeft());
            }
            canvas.clipRect(this.Ui);
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(save);
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    public final void aW(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            u.a(view, ((LayoutParams) view.getLayoutParams()).VB);
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (!this.Vw) {
                try {
                    this.Vu = View.class.getDeclaredMethod("getDisplayList", null);
                } catch (NoSuchMethodException e2) {
                }
                try {
                    this.Vv = View.class.getDeclaredField("mRecreateDisplayList");
                    this.Vv.setAccessible(true);
                } catch (NoSuchFieldException e3) {
                }
                this.Vw = true;
            }
            if (this.Vu == null || this.Vv == null) {
                view.invalidate();
                return;
            } else {
                try {
                    this.Vv.setBoolean(view, true);
                    this.Vu.invoke(view, null);
                } catch (Exception e4) {
                }
            }
        }
        u.c(this, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    private boolean H(float f2) {
        int paddingLeft;
        if (!this.mCanSlide) {
            return false;
        }
        boolean gh = gh();
        LayoutParams layoutParams = (LayoutParams) this.Vl.getLayoutParams();
        if (gh) {
            paddingLeft = (int) (((float) getWidth()) - ((((float) (layoutParams.rightMargin + getPaddingRight())) + (((float) this.Vo) * f2)) + ((float) this.Vl.getWidth())));
        } else {
            paddingLeft = (int) (((float) (layoutParams.leftMargin + getPaddingLeft())) + (((float) this.Vo) * f2));
        }
        if (!this.Vr.h(this.Vl, paddingLeft, this.Vl.getTop())) {
            return false;
        }
        gf();
        u.X(this);
        return true;
    }

    public void computeScroll() {
        if (!this.Vr.go()) {
            return;
        }
        if (!this.mCanSlide) {
            this.Vr.abort();
        } else {
            u.X(this);
        }
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.Vi = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.Vj = drawable;
    }

    @Deprecated
    public void setShadowResource(int i2) {
        setShadowDrawable(getResources().getDrawable(i2));
    }

    public void setShadowResourceLeft(int i2) {
        setShadowDrawableLeft(android.support.v4.content.b.l(getContext(), i2));
    }

    public void setShadowResourceRight(int i2) {
        setShadowDrawableRight(android.support.v4.content.b.l(getContext(), i2));
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        int left;
        int i2;
        super.draw(canvas);
        if (gh()) {
            drawable = this.Vj;
        } else {
            drawable = this.Vi;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (gh()) {
                i2 = childAt.getRight();
                left = i2 + intrinsicWidth;
            } else {
                left = childAt.getLeft();
                i2 = left - intrinsicWidth;
            }
            drawable.setBounds(i2, top, left, bottom);
            drawable.draw(canvas);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void I(float r10) {
        /*
            r9 = this;
            r1 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            boolean r3 = r9.gh()
            android.view.View r0 = r9.Vl
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.support.v4.widget.SlidingPaneLayout$LayoutParams r0 = (android.support.v4.widget.SlidingPaneLayout.LayoutParams) r0
            boolean r2 = r0.VA
            if (r2 == 0) goto L_0x0055
            if (r3 == 0) goto L_0x0052
            int r0 = r0.rightMargin
        L_0x0017:
            if (r0 > 0) goto L_0x0055
            r0 = 1
        L_0x001a:
            int r4 = r9.getChildCount()
            r2 = r1
        L_0x001f:
            if (r2 >= r4) goto L_0x005c
            android.view.View r5 = r9.getChildAt(r2)
            android.view.View r1 = r9.Vl
            if (r5 == r1) goto L_0x004e
            float r1 = r9.Vn
            float r1 = r8 - r1
            int r6 = r9.Vp
            float r6 = (float) r6
            float r1 = r1 * r6
            int r1 = (int) r1
            r9.Vn = r10
            float r6 = r8 - r10
            int r7 = r9.Vp
            float r7 = (float) r7
            float r6 = r6 * r7
            int r6 = (int) r6
            int r1 = r1 - r6
            if (r3 == 0) goto L_0x003f
            int r1 = -r1
        L_0x003f:
            r5.offsetLeftAndRight(r1)
            if (r0 == 0) goto L_0x004e
            if (r3 == 0) goto L_0x0057
            float r1 = r9.Vn
            float r1 = r1 - r8
        L_0x0049:
            int r6 = r9.Vh
            r9.a(r5, r1, r6)
        L_0x004e:
            int r1 = r2 + 1
            r2 = r1
            goto L_0x001f
        L_0x0052:
            int r0 = r0.leftMargin
            goto L_0x0017
        L_0x0055:
            r0 = r1
            goto L_0x001a
        L_0x0057:
            float r1 = r9.Vn
            float r1 = r8 - r1
            goto L_0x0049
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.I(float):void");
    }

    /* access modifiers changed from: package-private */
    public final boolean aX(View view) {
        if (view == null) {
            return false;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!this.mCanSlide || !layoutParams.VA || this.Vm <= 0.0f) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.VC = this.mCanSlide ? !this.mCanSlide || this.Vm == 1.0f : this.Vs;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.Pm);
        if (!savedState.VC) {
            gg();
        } else if (this.mFirstLayout || H(1.0f)) {
            this.Vs = true;
        }
        this.Vs = savedState.VC;
    }

    class c extends t.a {
        c() {
        }

        @Override // android.support.v4.widget.t.a
        public final boolean c(View view, int i2) {
            if (SlidingPaneLayout.this.mIsUnableToDrag) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).Vz;
        }

        @Override // android.support.v4.widget.t.a
        public final void L(int i2) {
            if (SlidingPaneLayout.this.Vr.Wx != 0) {
                return;
            }
            if (SlidingPaneLayout.this.Vm == 0.0f) {
                SlidingPaneLayout.this.aV(SlidingPaneLayout.this.Vl);
                SlidingPaneLayout.this.sendAccessibilityEvent(32);
                SlidingPaneLayout.this.Vs = false;
                return;
            }
            SlidingPaneLayout.this.sendAccessibilityEvent(32);
            SlidingPaneLayout.this.Vs = true;
        }

        @Override // android.support.v4.widget.t.a
        public final void l(View view, int i2) {
            SlidingPaneLayout.this.gf();
        }

        @Override // android.support.v4.widget.t.a
        public final void b(View view, int i2, int i3) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.Vl == null) {
                slidingPaneLayout.Vm = 0.0f;
            } else {
                boolean gh = slidingPaneLayout.gh();
                LayoutParams layoutParams = (LayoutParams) slidingPaneLayout.Vl.getLayoutParams();
                int width = slidingPaneLayout.Vl.getWidth();
                if (gh) {
                    i2 = (slidingPaneLayout.getWidth() - i2) - width;
                }
                slidingPaneLayout.Vm = ((float) (i2 - ((gh ? layoutParams.rightMargin : layoutParams.leftMargin) + (gh ? slidingPaneLayout.getPaddingRight() : slidingPaneLayout.getPaddingLeft())))) / ((float) slidingPaneLayout.Vo);
                if (slidingPaneLayout.Vp != 0) {
                    slidingPaneLayout.I(slidingPaneLayout.Vm);
                }
                if (layoutParams.VA) {
                    slidingPaneLayout.a(slidingPaneLayout.Vl, slidingPaneLayout.Vm, slidingPaneLayout.Vg);
                }
            }
            SlidingPaneLayout.this.invalidate();
        }

        @Override // android.support.v4.widget.t.a
        public final void a(View view, float f2, float f3) {
            int paddingLeft;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.gh()) {
                int paddingRight = layoutParams.rightMargin + SlidingPaneLayout.this.getPaddingRight();
                if (f2 < 0.0f || (f2 == 0.0f && SlidingPaneLayout.this.Vm > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.Vo;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.Vl.getWidth();
            } else {
                paddingLeft = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f2 > 0.0f || (f2 == 0.0f && SlidingPaneLayout.this.Vm > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.Vo;
                }
            }
            SlidingPaneLayout.this.Vr.H(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // android.support.v4.widget.t.a
        public final int y(View view) {
            return SlidingPaneLayout.this.Vo;
        }

        @Override // android.support.v4.widget.t.a
        public final int e(View view, int i2) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.Vl.getLayoutParams();
            if (SlidingPaneLayout.this.gh()) {
                int width = SlidingPaneLayout.this.getWidth() - ((layoutParams.rightMargin + SlidingPaneLayout.this.getPaddingRight()) + SlidingPaneLayout.this.Vl.getWidth());
                return Math.max(Math.min(i2, width), width - SlidingPaneLayout.this.Vo);
            }
            int paddingLeft = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
            return Math.min(Math.max(i2, paddingLeft), SlidingPaneLayout.this.Vo + paddingLeft);
        }

        @Override // android.support.v4.widget.t.a
        public final int d(View view, int i2) {
            return view.getTop();
        }

        @Override // android.support.v4.widget.t.a
        public final void D(int i2, int i3) {
            SlidingPaneLayout.this.Vr.y(SlidingPaneLayout.this.Vl, i3);
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int[] QA = {16843137};
        boolean VA;
        Paint VB;
        boolean Vz;
        public float weight = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, QA);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class android.support.v4.widget.SlidingPaneLayout.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };
        boolean VC;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel, null);
            this.VC = parcel.readInt() != 0;
        }

        @Override // android.support.v4.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.VC ? 1 : 0);
        }
    }

    class a extends android.support.v4.view.a {
        private final Rect Ui = new Rect();

        a() {
        }

        @Override // android.support.v4.view.a
        public final void onInitializeAccessibilityNodeInfo(View view, android.support.v4.view.a.c cVar) {
            android.support.v4.view.a.c a2 = android.support.v4.view.a.c.a(cVar);
            super.onInitializeAccessibilityNodeInfo(view, a2);
            Rect rect = this.Ui;
            a2.getBoundsInParent(rect);
            cVar.setBoundsInParent(rect);
            a2.getBoundsInScreen(rect);
            cVar.setBoundsInScreen(rect);
            cVar.setVisibleToUser(a2.isVisibleToUser());
            cVar.setPackageName(a2.Ro.getPackageName());
            cVar.setClassName(a2.Ro.getClassName());
            cVar.setContentDescription(a2.Ro.getContentDescription());
            cVar.setEnabled(a2.Ro.isEnabled());
            cVar.setClickable(a2.Ro.isClickable());
            cVar.setFocusable(a2.Ro.isFocusable());
            cVar.setFocused(a2.Ro.isFocused());
            cVar.setAccessibilityFocused(a2.isAccessibilityFocused());
            cVar.setSelected(a2.Ro.isSelected());
            cVar.setLongClickable(a2.Ro.isLongClickable());
            cVar.addAction(a2.Ro.getActions());
            int movementGranularities = Build.VERSION.SDK_INT >= 16 ? a2.Ro.getMovementGranularities() : 0;
            if (Build.VERSION.SDK_INT >= 16) {
                cVar.Ro.setMovementGranularities(movementGranularities);
            }
            a2.Ro.recycle();
            cVar.setClassName(SlidingPaneLayout.class.getName());
            cVar.setSource(view);
            ViewParent aa = u.aa(view);
            if (aa instanceof View) {
                cVar.setParent((View) aa);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i2);
                if (!aY(childAt) && childAt.getVisibility() == 0) {
                    u.p(childAt, 1);
                    cVar.addChild(childAt);
                }
            }
        }

        @Override // android.support.v4.view.a
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        @Override // android.support.v4.view.a
        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!aY(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        private boolean aY(View view) {
            return SlidingPaneLayout.this.aX(view);
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements Runnable {
        final View Vy;

        b(View view) {
            this.Vy = view;
        }

        public final void run() {
            if (this.Vy.getParent() == SlidingPaneLayout.this) {
                this.Vy.setLayerType(0, null);
                SlidingPaneLayout.this.aW(this.Vy);
            }
            SlidingPaneLayout.this.Vt.remove(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean gh() {
        return u.Z(this) == 1;
    }
}
