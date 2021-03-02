package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.view.q;
import android.support.v4.view.u;
import android.support.v4.view.v;
import android.support.v4.widget.i;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import junit.framework.Assert;

public class AdLandingViewPager extends ViewGroup {
    private static final Comparator<b> COMPARATOR = new Comparator<b>() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(b bVar, b bVar2) {
            return bVar.position - bVar2.position;
        }
    };
    private static final f EhX = new f();
    private static final int[] LAYOUT_ATTRS = {16842931};
    private static final Interpolator sInterpolator = new Interpolator() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.AnonymousClass2 */

        public final float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private final b EhU = new b();
    private e EhV;
    private d EhW;
    int mActivePointerId = -1;
    private q mAdapter;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    private int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable = new Runnable() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.AnonymousClass3 */

        public final void run() {
            AppMethodBeat.i(96966);
            AdLandingViewPager.a(AdLandingViewPager.this);
            AdLandingViewPager.this.populate();
            AppMethodBeat.o(96966);
        }
    };
    private int mExpectedAdapterCount;
    long mFakeDragBeginTime;
    boolean mFakeDragging;
    private boolean mFirstLayout = true;
    private float mFirstOffset = -3.4028235E38f;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    float mInitialMotionX;
    private float mInitialMotionY;
    private ViewPager.OnPageChangeListener mInternalPageChangeListener;
    boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private final ArrayList<b> mItems = new ArrayList<>();
    float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset = Float.MAX_VALUE;
    private i mLeftEdge;
    private Drawable mMarginDrawable;
    int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets = false;
    private int mOffscreenPageLimit = 1;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mPageMargin;
    ViewPager.d mPageTransformer;
    boolean mPopulatePending;
    private Parcelable mRestoredAdapterState = null;
    private ClassLoader mRestoredClassLoader = null;
    private int mRestoredCurItem = -1;
    private i mRightEdge;
    private int mScrollState = 0;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private Method mSetChildrenDrawingOrderEnabled;
    private final Rect mTempRect = new Rect();
    private int mTopPageBounds;
    private int mTouchSlop;
    VelocityTracker mVelocityTracker;

    interface a {
    }

    interface d {
    }

    static /* synthetic */ void a(AdLandingViewPager adLandingViewPager) {
        AppMethodBeat.i(97049);
        adLandingViewPager.setScrollState(0);
        AppMethodBeat.o(97049);
    }

    static {
        AppMethodBeat.i(97050);
        AppMethodBeat.o(97050);
    }

    /* access modifiers changed from: package-private */
    public static class b {
        Object object;
        float offset;
        int position;
        boolean scrolling;
        float widthFactor;

        b() {
        }
    }

    public AdLandingViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(96980);
        setWillNotDraw(false);
        setDescendantFocusability(TPMediaCodecProfileLevel.HEVCMainTierLevel52);
        setFocusable(true);
        Context context2 = getContext();
        this.mScroller = new Scroller(context2, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f2 = context2.getResources().getDisplayMetrics().density;
        this.mTouchSlop = v.a(viewConfiguration);
        this.mMinimumVelocity = (int) (400.0f * f2);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new i(context2);
        this.mRightEdge = new i(context2);
        this.mFlingDistance = (int) (25.0f * f2);
        this.mCloseEnough = (int) (2.0f * f2);
        this.mDefaultGutterSize = (int) (16.0f * f2);
        u.a(this, new c());
        if (u.Y(this) == 0) {
            u.p(this, 1);
        }
        AppMethodBeat.o(96980);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(96981);
        removeCallbacks(this.mEndScrollRunnable);
        super.onDetachedFromWindow();
        AppMethodBeat.o(96981);
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i2) {
        AppMethodBeat.i(96982);
        if (this.mScrollState == i2) {
            AppMethodBeat.o(96982);
            return;
        }
        this.mScrollState = i2;
        if (this.mPageTransformer != null) {
            boolean z = i2 != 0;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                u.q(getChildAt(i3), z ? 2 : 0);
            }
        }
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrollStateChanged(i2);
        }
        AppMethodBeat.o(96982);
    }

    public void setAdapter(q qVar) {
        AppMethodBeat.i(96983);
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.EhV);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i2 = 0; i2 < this.mItems.size(); i2++) {
                b bVar = this.mItems.get(i2);
                this.mAdapter.destroyItem((ViewGroup) this, bVar.position, bVar.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            int i3 = 0;
            while (i3 < getChildCount()) {
                if (!((LayoutParams) getChildAt(i3).getLayoutParams()).QY) {
                    removeViewAt(i3);
                    i3--;
                }
                i3++;
            }
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        this.mAdapter = qVar;
        this.mExpectedAdapterCount = 0;
        if (this.mAdapter != null) {
            if (this.EhV == null) {
                this.EhV = new e(this, (byte) 0);
            }
            this.mAdapter.registerDataSetObserver(this.EhV);
            this.mPopulatePending = false;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
                AppMethodBeat.o(96983);
                return;
            } else if (!z) {
                populate();
                AppMethodBeat.o(96983);
                return;
            } else {
                requestLayout();
            }
        }
        AppMethodBeat.o(96983);
    }

    public q getAdapter() {
        return this.mAdapter;
    }

    /* access modifiers changed from: package-private */
    public void setOnAdapterChangeListener(d dVar) {
        this.EhW = dVar;
    }

    /* access modifiers changed from: package-private */
    public int getClientWidth() {
        AppMethodBeat.i(96984);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        AppMethodBeat.o(96984);
        return measuredWidth;
    }

    public void setCurrentItem(int i2) {
        boolean z;
        AppMethodBeat.i(96985);
        this.mPopulatePending = false;
        if (!this.mFirstLayout) {
            z = true;
        } else {
            z = false;
        }
        setCurrentItemInternal(i2, z, false);
        AppMethodBeat.o(96985);
    }

    public final void setCurrentItem$2563266(int i2) {
        AppMethodBeat.i(96986);
        this.mPopulatePending = false;
        setCurrentItemInternal(i2, true, false);
        AppMethodBeat.o(96986);
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    private void setCurrentItemInternal(int i2, boolean z, boolean z2) {
        AppMethodBeat.i(96987);
        setCurrentItemInternal(i2, z, z2, 0);
        AppMethodBeat.o(96987);
    }

    /* access modifiers changed from: package-private */
    public final void setCurrentItemInternal(int i2, boolean z, boolean z2, int i3) {
        boolean z3 = false;
        AppMethodBeat.i(96988);
        if (this.mAdapter == null || this.mAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
            AppMethodBeat.o(96988);
        } else if (z2 || this.mCurItem != i2 || this.mItems.size() == 0) {
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 >= this.mAdapter.getCount()) {
                i2 = this.mAdapter.getCount() - 1;
            }
            int i4 = this.mOffscreenPageLimit;
            if (i2 > this.mCurItem + i4 || i2 < this.mCurItem - i4) {
                for (int i5 = 0; i5 < this.mItems.size(); i5++) {
                    this.mItems.get(i5).scrolling = true;
                }
            }
            if (this.mCurItem != i2) {
                z3 = true;
            }
            if (this.mFirstLayout) {
                this.mCurItem = i2;
                if (z3 && this.mOnPageChangeListener != null) {
                    this.mOnPageChangeListener.onPageSelected(i2);
                }
                if (z3 && this.mInternalPageChangeListener != null) {
                    this.mInternalPageChangeListener.onPageSelected(i2);
                }
                requestLayout();
                AppMethodBeat.o(96988);
                return;
            }
            populate(i2);
            scrollToItem(i2, z, i3, z3);
            AppMethodBeat.o(96988);
        } else {
            setScrollingCacheEnabled(false);
            AppMethodBeat.o(96988);
        }
    }

    private void scrollToItem(int i2, boolean z, int i3, boolean z2) {
        int i4;
        AppMethodBeat.i(96989);
        b Zg = Zg(i2);
        if (Zg != null) {
            i4 = (int) (Math.max(this.mFirstOffset, Math.min(Zg.offset, this.mLastOffset)) * ((float) getClientWidth()));
        } else {
            i4 = 0;
        }
        if (z) {
            iC(i4, i3);
            if (z2 && this.mOnPageChangeListener != null) {
                this.mOnPageChangeListener.onPageSelected(i2);
            }
            if (z2 && this.mInternalPageChangeListener != null) {
                this.mInternalPageChangeListener.onPageSelected(i2);
                AppMethodBeat.o(96989);
                return;
            }
        } else {
            if (z2 && this.mOnPageChangeListener != null) {
                this.mOnPageChangeListener.onPageSelected(i2);
            }
            if (z2 && this.mInternalPageChangeListener != null) {
                this.mInternalPageChangeListener.onPageSelected(i2);
            }
            completeScroll(false);
            scrollTo(i4, 0);
            pageScrolled(i4);
        }
        AppMethodBeat.o(96989);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    /* access modifiers changed from: package-private */
    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
        AppMethodBeat.i(96990);
        if (Build.VERSION.SDK_INT >= 7) {
            if (this.mSetChildrenDrawingOrderEnabled == null) {
                try {
                    this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
                } catch (NoSuchMethodException e2) {
                }
            }
            try {
                if (this.mSetChildrenDrawingOrderEnabled != null) {
                    this.mSetChildrenDrawingOrderEnabled.invoke(this, Boolean.valueOf(z));
                }
                AppMethodBeat.o(96990);
                return;
            } catch (Exception e3) {
            }
        }
        AppMethodBeat.o(96990);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        AppMethodBeat.i(96991);
        if (this.mDrawingOrder == 2) {
            i3 = (i2 - 1) - i3;
        }
        int i4 = ((LayoutParams) this.mDrawingOrderedChildren.get(i3).getLayoutParams()).Ra;
        AppMethodBeat.o(96991);
        return i4;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public void setOffscreenPageLimit(int i2) {
        AppMethodBeat.i(96992);
        if (i2 <= 0) {
            new StringBuilder("Requested offscreen page limit ").append(i2).append(" too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i2;
            populate();
        }
        AppMethodBeat.o(96992);
    }

    public void setPageMargin(int i2) {
        AppMethodBeat.i(96993);
        int i3 = this.mPageMargin;
        this.mPageMargin = i2;
        int width = getWidth();
        recomputeScrollPosition(width, width, i2, i3);
        requestLayout();
        AppMethodBeat.o(96993);
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        AppMethodBeat.i(96994);
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
        AppMethodBeat.o(96994);
    }

    public void setPageMarginDrawable(int i2) {
        AppMethodBeat.i(96995);
        setPageMarginDrawable(getContext().getResources().getDrawable(i2));
        AppMethodBeat.o(96995);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        AppMethodBeat.i(96996);
        if (super.verifyDrawable(drawable) || drawable == this.mMarginDrawable) {
            AppMethodBeat.o(96996);
            return true;
        }
        AppMethodBeat.o(96996);
        return false;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        AppMethodBeat.i(96997);
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
        AppMethodBeat.o(96997);
    }

    private static float distanceInfluenceForSnapDuration(float f2) {
        AppMethodBeat.i(96998);
        float sin = (float) Math.sin((double) ((float) (((double) (f2 - 0.5f)) * 0.4712389167638204d)));
        AppMethodBeat.o(96998);
        return sin;
    }

    private void iC(int i2, int i3) {
        int abs;
        AppMethodBeat.i(96999);
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            AppMethodBeat.o(96999);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i2 - scrollX;
        int i5 = 0 - scrollY;
        if (i4 == 0 && i5 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            AppMethodBeat.o(96999);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i6 = clientWidth / 2;
        float distanceInfluenceForSnapDuration = (((float) i6) * distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) Math.abs(i4)) * 1.0f) / ((float) clientWidth)))) + ((float) i6);
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            abs = Math.round(1000.0f * Math.abs(distanceInfluenceForSnapDuration / ((float) abs2))) * 4;
        } else {
            abs = (int) (((((float) Math.abs(i4)) / ((((float) clientWidth) * this.mAdapter.getPageWidth(this.mCurItem)) + ((float) this.mPageMargin))) + 3.0f) * 100.0f);
        }
        this.mScroller.startScroll(scrollX, scrollY, i4, i5, Math.min(abs, 600));
        u.X(this);
        AppMethodBeat.o(96999);
    }

    private b iD(int i2, int i3) {
        AppMethodBeat.i(97000);
        b bVar = new b();
        bVar.position = i2;
        bVar.object = this.mAdapter.instantiateItem((ViewGroup) this, i2);
        bVar.widthFactor = this.mAdapter.getPageWidth(i2);
        if (i3 < 0 || i3 >= this.mItems.size()) {
            this.mItems.add(bVar);
        } else {
            this.mItems.add(i3, bVar);
        }
        AppMethodBeat.o(97000);
        return bVar;
    }

    /* access modifiers changed from: package-private */
    public final void dataSetChanged() {
        AppMethodBeat.i(97001);
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        boolean z = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count;
        int i2 = this.mCurItem;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = z;
        while (i3 < this.mItems.size()) {
            b bVar = this.mItems.get(i3);
            int itemPosition = this.mAdapter.getItemPosition(bVar.object);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i3);
                    i3--;
                    if (!z2) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, bVar.position, bVar.object);
                    if (this.mCurItem == bVar.position) {
                        i2 = Math.max(0, Math.min(this.mCurItem, count - 1));
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                } else if (bVar.position != itemPosition) {
                    if (bVar.position == this.mCurItem) {
                        i2 = itemPosition;
                    }
                    bVar.position = itemPosition;
                    z3 = true;
                }
            }
            i3++;
        }
        if (z2) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z3) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
                if (!layoutParams.QY) {
                    layoutParams.widthFactor = 0.0f;
                }
            }
            setCurrentItemInternal(i2, false, true);
            requestLayout();
        }
        AppMethodBeat.o(97001);
    }

    /* access modifiers changed from: package-private */
    public final void populate() {
        AppMethodBeat.i(97002);
        populate(this.mCurItem);
        AppMethodBeat.o(97002);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f0, code lost:
        if (r0.position == r14.mCurItem) goto L_0x00f2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void populate(int r15) {
        /*
        // Method dump skipped, instructions count: 708
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.populate(int):void");
    }

    private void sortChildDrawingOrder() {
        AppMethodBeat.i(97004);
        if (this.mDrawingOrder != 0) {
            if (this.mDrawingOrderedChildren == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                this.mDrawingOrderedChildren.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.mDrawingOrderedChildren.add(getChildAt(i2));
            }
            Collections.sort(this.mDrawingOrderedChildren, EhX);
        }
        AppMethodBeat.o(97004);
    }

    private void a(b bVar, int i2, b bVar2) {
        b bVar3;
        b bVar4;
        AppMethodBeat.i(97005);
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        if (bVar2 != null) {
            int i3 = bVar2.position;
            if (i3 < bVar.position) {
                float f3 = bVar2.offset + bVar2.widthFactor + f2;
                int i4 = i3 + 1;
                int i5 = 0;
                while (i4 <= bVar.position && i5 < this.mItems.size()) {
                    b bVar5 = this.mItems.get(i5);
                    while (true) {
                        bVar4 = bVar5;
                        if (i4 > bVar4.position && i5 < this.mItems.size() - 1) {
                            i5++;
                            bVar5 = this.mItems.get(i5);
                        }
                    }
                    while (i4 < bVar4.position) {
                        f3 += this.mAdapter.getPageWidth(i4) + f2;
                        i4++;
                    }
                    bVar4.offset = f3;
                    f3 += bVar4.widthFactor + f2;
                    i4++;
                }
            } else if (i3 > bVar.position) {
                int size = this.mItems.size() - 1;
                float f4 = bVar2.offset;
                int i6 = i3 - 1;
                while (true) {
                    int i7 = i6;
                    if (i7 < bVar.position || size < 0) {
                        break;
                    }
                    b bVar6 = this.mItems.get(size);
                    while (true) {
                        bVar3 = bVar6;
                        if (i7 < bVar3.position && size > 0) {
                            size--;
                            bVar6 = this.mItems.get(size);
                        }
                    }
                    while (i7 > bVar3.position) {
                        f4 -= this.mAdapter.getPageWidth(i7) + f2;
                        i7--;
                    }
                    f4 -= bVar3.widthFactor + f2;
                    bVar3.offset = f4;
                    i6 = i7 - 1;
                }
            }
        }
        int size2 = this.mItems.size();
        float f5 = bVar.offset;
        int i8 = bVar.position - 1;
        this.mFirstOffset = bVar.position == 0 ? bVar.offset : -3.4028235E38f;
        this.mLastOffset = bVar.position == count + -1 ? (bVar.offset + bVar.widthFactor) - 1.0f : Float.MAX_VALUE;
        for (int i9 = i2 - 1; i9 >= 0; i9--) {
            b bVar7 = this.mItems.get(i9);
            while (i8 > bVar7.position) {
                f5 -= this.mAdapter.getPageWidth(i8) + f2;
                i8--;
            }
            f5 -= bVar7.widthFactor + f2;
            bVar7.offset = f5;
            if (bVar7.position == 0) {
                this.mFirstOffset = f5;
            }
            i8--;
        }
        float f6 = bVar.offset + bVar.widthFactor + f2;
        int i10 = bVar.position + 1;
        for (int i11 = i2 + 1; i11 < size2; i11++) {
            b bVar8 = this.mItems.get(i11);
            while (i10 < bVar8.position) {
                f6 += this.mAdapter.getPageWidth(i10) + f2;
                i10++;
            }
            if (bVar8.position == count - 1) {
                this.mLastOffset = (bVar8.widthFactor + f6) - 1.0f;
            }
            bVar8.offset = f6;
            f6 += bVar8.widthFactor + f2;
            i10++;
        }
        this.mNeedCalculatePageOffsets = false;
        AppMethodBeat.o(97005);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = android.support.v4.os.c.a(new android.support.v4.os.d<SavedState>() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.support.v4.os.d
            public final /* bridge */ /* synthetic */ SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.support.v4.os.d
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                AppMethodBeat.i(96974);
                SavedState savedState = new SavedState(parcel, classLoader);
                AppMethodBeat.o(96974);
                return savedState;
            }
        });
        Parcelable Rb;
        ClassLoader Rc;
        int position;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(96975);
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.Rb, i2);
            AppMethodBeat.o(96975);
        }

        public String toString() {
            AppMethodBeat.i(96976);
            String str = "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
            AppMethodBeat.o(96976);
            return str;
        }

        static {
            AppMethodBeat.i(96978);
            AppMethodBeat.o(96978);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            AppMethodBeat.i(96977);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.Rb = parcel.readParcelable(classLoader);
            this.Rc = classLoader;
            AppMethodBeat.o(96977);
        }
    }

    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(97006);
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.mCurItem;
        if (this.mAdapter != null) {
            savedState.Rb = this.mAdapter.saveState();
        }
        AppMethodBeat.o(97006);
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(97007);
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            AppMethodBeat.o(97007);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.mAdapter != null) {
            this.mAdapter.restoreState(savedState.Rb, savedState.Rc);
            setCurrentItemInternal(savedState.position, false, true);
            AppMethodBeat.o(97007);
            return;
        }
        this.mRestoredCurItem = savedState.position;
        this.mRestoredAdapterState = savedState.Rb;
        this.mRestoredClassLoader = savedState.Rc;
        AppMethodBeat.o(97007);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams layoutParams2;
        AppMethodBeat.i(97008);
        if (!checkLayoutParams(layoutParams)) {
            layoutParams2 = generateLayoutParams(layoutParams);
        } else {
            layoutParams2 = layoutParams;
        }
        Assert.assertNotNull(layoutParams2);
        LayoutParams layoutParams3 = (LayoutParams) layoutParams2;
        layoutParams3.QY |= view instanceof a;
        if (!this.mInLayout) {
            super.addView(view, i2, layoutParams2);
            AppMethodBeat.o(97008);
        } else if (layoutParams3 == null || !layoutParams3.QY) {
            layoutParams3.QZ = true;
            addViewInLayout(view, i2, layoutParams2);
            AppMethodBeat.o(97008);
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot add pager decor view during layout");
            AppMethodBeat.o(97008);
            throw illegalStateException;
        }
    }

    public void removeView(View view) {
        AppMethodBeat.i(97009);
        if (this.mInLayout) {
            removeViewInLayout(view);
            AppMethodBeat.o(97009);
            return;
        }
        super.removeView(view);
        AppMethodBeat.o(97009);
    }

    private b fl(View view) {
        AppMethodBeat.i(97010);
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            b bVar = this.mItems.get(i2);
            if (this.mAdapter.isViewFromObject(view, bVar.object)) {
                AppMethodBeat.o(97010);
                return bVar;
            }
        }
        AppMethodBeat.o(97010);
        return null;
    }

    private b fm(View view) {
        AppMethodBeat.i(97011);
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                b fl = fl(view);
                AppMethodBeat.o(97011);
                return fl;
            } else if (parent == null || !(parent instanceof View)) {
                AppMethodBeat.o(97011);
            } else {
                view = (View) parent;
            }
        }
        AppMethodBeat.o(97011);
        return null;
    }

    private b Zg(int i2) {
        AppMethodBeat.i(97012);
        for (int i3 = 0; i3 < this.mItems.size(); i3++) {
            b bVar = this.mItems.get(i3);
            if (bVar.position == i2) {
                AppMethodBeat.o(97012);
                return bVar;
            }
        }
        AppMethodBeat.o(97012);
        return null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(97013);
        super.onAttachedToWindow();
        this.mFirstLayout = true;
        AppMethodBeat.o(97013);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
        // Method dump skipped, instructions count: 290
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(97015);
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            recomputeScrollPosition(i2, i4, this.mPageMargin, this.mPageMargin);
        }
        AppMethodBeat.o(97015);
    }

    private void recomputeScrollPosition(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(97016);
        if (i3 <= 0 || this.mItems.isEmpty()) {
            b Zg = Zg(this.mCurItem);
            int min = (int) ((Zg != null ? Math.min(Zg.offset, this.mLastOffset) : 0.0f) * ((float) ((i2 - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                completeScroll(false);
                scrollTo(min, getScrollY());
            }
            AppMethodBeat.o(97016);
            return;
        }
        int paddingLeft = (int) (((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((float) getScrollX()) / ((float) (((i3 - getPaddingLeft()) - getPaddingRight()) + i5))));
        scrollTo(paddingLeft, getScrollY());
        if (!this.mScroller.isFinished()) {
            this.mScroller.startScroll(paddingLeft, 0, (int) (Zg(this.mCurItem).offset * ((float) i2)), 0, this.mScroller.getDuration() - this.mScroller.timePassed());
        }
        AppMethodBeat.o(97016);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        b fl;
        int i6;
        int i7;
        int i8;
        int measuredWidth;
        int measuredHeight;
        int i9;
        AppMethodBeat.i(97017);
        int childCount = getChildCount();
        int i10 = i4 - i2;
        int i11 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i12 = 0;
        int i13 = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.QY) {
                    int i14 = layoutParams.gravity & 7;
                    int i15 = layoutParams.gravity & 112;
                    switch (i14) {
                        case 1:
                            measuredWidth = Math.max((i10 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i7 = paddingRight;
                            i8 = paddingLeft;
                            break;
                        case 2:
                        case 4:
                        default:
                            measuredWidth = paddingLeft;
                            i7 = paddingRight;
                            i8 = paddingLeft;
                            break;
                        case 3:
                            i8 = paddingLeft + childAt.getMeasuredWidth();
                            measuredWidth = paddingLeft;
                            i7 = paddingRight;
                            break;
                        case 5:
                            measuredWidth = (i10 - paddingRight) - childAt.getMeasuredWidth();
                            i7 = paddingRight + childAt.getMeasuredWidth();
                            i8 = paddingLeft;
                            break;
                    }
                    switch (i15) {
                        case 16:
                            measuredHeight = Math.max((i11 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i9 = paddingTop;
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                            i9 = paddingTop + childAt.getMeasuredHeight();
                            measuredHeight = paddingTop;
                            break;
                        case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                            measuredHeight = (i11 - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                            i9 = paddingTop;
                            break;
                        default:
                            measuredHeight = paddingTop;
                            i9 = paddingTop;
                            break;
                    }
                    int i16 = measuredWidth + scrollX;
                    childAt.layout(i16, measuredHeight, childAt.getMeasuredWidth() + i16, childAt.getMeasuredHeight() + measuredHeight);
                    i6 = i12 + 1;
                    paddingTop = i9;
                    i13++;
                    i12 = i6;
                    paddingRight = i7;
                    paddingLeft = i8;
                }
            }
            i6 = i12;
            i7 = paddingRight;
            i8 = paddingLeft;
            i13++;
            i12 = i6;
            paddingRight = i7;
            paddingLeft = i8;
        }
        int i17 = (i10 - paddingLeft) - paddingRight;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.QY && (fl = fl(childAt2)) != null) {
                    int i19 = ((int) (fl.offset * ((float) i17))) + paddingLeft;
                    if (layoutParams2.QZ) {
                        layoutParams2.QZ = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (layoutParams2.widthFactor * ((float) i17)), 1073741824), View.MeasureSpec.makeMeasureSpec((i11 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i19, paddingTop, childAt2.getMeasuredWidth() + i19, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.mTopPageBounds = paddingTop;
        this.mBottomPageBounds = i11 - paddingBottom;
        this.mDecorChildCount = i12;
        if (this.mFirstLayout) {
            scrollToItem(this.mCurItem, false, 0, false);
        }
        this.mFirstLayout = false;
        AppMethodBeat.o(97017);
    }

    public void computeScroll() {
        AppMethodBeat.i(97018);
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            AppMethodBeat.o(97018);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        u.X(this);
        AppMethodBeat.o(97018);
    }

    private boolean pageScrolled(int i2) {
        AppMethodBeat.i(97019);
        if (this.mItems.size() == 0) {
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (!this.mCalledSuper) {
                IllegalStateException illegalStateException = new IllegalStateException("onPageScrolled did not call superclass implementation");
                AppMethodBeat.o(97019);
                throw illegalStateException;
            }
            AppMethodBeat.o(97019);
            return false;
        }
        b fdV = fdV();
        int clientWidth = getClientWidth();
        int i3 = this.mPageMargin + clientWidth;
        float f2 = ((float) this.mPageMargin) / ((float) clientWidth);
        int i4 = fdV.position;
        float f3 = ((((float) i2) / ((float) clientWidth)) - fdV.offset) / (fdV.widthFactor + f2);
        this.mCalledSuper = false;
        onPageScrolled(i4, f3, (int) (((float) i3) * f3));
        if (!this.mCalledSuper) {
            IllegalStateException illegalStateException2 = new IllegalStateException("onPageScrolled did not call superclass implementation");
            AppMethodBeat.o(97019);
            throw illegalStateException2;
        }
        AppMethodBeat.o(97019);
        return true;
    }

    private void onPageScrolled(int i2, float f2, int i3) {
        int i4;
        int measuredWidth;
        AppMethodBeat.i(97020);
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i5 = 0;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.QY) {
                    switch (layoutParams.gravity & 7) {
                        case 1:
                            measuredWidth = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingLeft;
                            break;
                        case 2:
                        case 4:
                        default:
                            measuredWidth = paddingLeft;
                            i4 = paddingLeft;
                            break;
                        case 3:
                            i4 = paddingLeft + childAt.getWidth();
                            measuredWidth = paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (width - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            i4 = paddingLeft;
                            break;
                    }
                    int left = (measuredWidth + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                } else {
                    i4 = paddingLeft;
                }
                i5++;
                paddingLeft = i4;
            }
        }
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i2, f2, i3);
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrolled(i2, f2, i3);
        }
        if (this.mPageTransformer != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i6 = 0; i6 < childCount2; i6++) {
                View childAt2 = getChildAt(i6);
                if (!((LayoutParams) childAt2.getLayoutParams()).QY) {
                    this.mPageTransformer.o(childAt2, ((float) (childAt2.getLeft() - scrollX2)) / ((float) getClientWidth()));
                }
            }
        }
        this.mCalledSuper = true;
        AppMethodBeat.o(97020);
    }

    private void completeScroll(boolean z) {
        AppMethodBeat.i(97021);
        boolean z2 = this.mScrollState == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.mPopulatePending = false;
        boolean z3 = z2;
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            b bVar = this.mItems.get(i2);
            if (bVar.scrolling) {
                bVar.scrolling = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                u.b(this, this.mEndScrollRunnable);
                AppMethodBeat.o(97021);
                return;
            }
            this.mEndScrollRunnable.run();
        }
        AppMethodBeat.o(97021);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(97022);
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.mIsBeingDragged = false;
            this.mIsUnableToDrag = false;
            this.mActivePointerId = -1;
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
            }
            AppMethodBeat.o(97022);
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                AppMethodBeat.o(97022);
                return true;
            } else if (this.mIsUnableToDrag) {
                AppMethodBeat.o(97022);
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                float y = motionEvent.getY();
                this.mInitialMotionY = y;
                this.mLastMotionY = y;
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mIsUnableToDrag = false;
                this.mScroller.computeScrollOffset();
                if (this.mScrollState == 2 && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = false;
                    populate();
                    this.mIsBeingDragged = true;
                    setScrollState(1);
                    break;
                } else {
                    completeScroll(false);
                    this.mIsBeingDragged = false;
                    break;
                }
                break;
            case 2:
                int i2 = this.mActivePointerId;
                if (i2 != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float f2 = x2 - this.mLastMotionX;
                    float abs = Math.abs(f2);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float abs2 = Math.abs(y2 - this.mInitialMotionY);
                    if (f2 != 0.0f) {
                        float f3 = this.mLastMotionX;
                        if ((f3 >= ((float) this.mGutterSize) || f2 <= 0.0f) && (f3 <= ((float) (getWidth() - this.mGutterSize)) || f2 >= 0.0f)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z && canScroll(this, false, (int) f2, (int) x2, (int) y2)) {
                            this.mLastMotionX = x2;
                            this.mLastMotionY = y2;
                            this.mIsUnableToDrag = true;
                            AppMethodBeat.o(97022);
                            return false;
                        }
                    }
                    if (abs > ((float) this.mTouchSlop) && 0.5f * abs > abs2) {
                        this.mIsBeingDragged = true;
                        setScrollState(1);
                        this.mLastMotionX = f2 > 0.0f ? this.mInitialMotionX + ((float) this.mTouchSlop) : this.mInitialMotionX - ((float) this.mTouchSlop);
                        this.mLastMotionY = y2;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > ((float) this.mTouchSlop)) {
                        this.mIsUnableToDrag = true;
                    }
                    if (this.mIsBeingDragged && performDrag(x2)) {
                        u.X(this);
                        break;
                    }
                }
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        boolean z2 = this.mIsBeingDragged;
        AppMethodBeat.o(97022);
        return z2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f2;
        boolean z = false;
        AppMethodBeat.i(97023);
        if (this.mFakeDragging) {
            AppMethodBeat.o(97023);
            return true;
        } else if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            AppMethodBeat.o(97023);
            return false;
        } else if (this.mAdapter == null || this.mAdapter.getCount() == 0) {
            AppMethodBeat.o(97023);
            return false;
        } else {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = false;
                    populate();
                    this.mIsBeingDragged = true;
                    setScrollState(1);
                    float x = motionEvent.getX();
                    this.mInitialMotionX = x;
                    this.mLastMotionX = x;
                    float y = motionEvent.getY();
                    this.mInitialMotionY = y;
                    this.mLastMotionY = y;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    break;
                case 1:
                    if (this.mIsBeingDragged) {
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                        int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                        this.mPopulatePending = true;
                        int clientWidth = getClientWidth();
                        int scrollX = getScrollX();
                        b fdV = fdV();
                        int i2 = fdV.position;
                        float f3 = ((((float) scrollX) / ((float) clientWidth)) - fdV.offset) / fdV.widthFactor;
                        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                        if (findPointerIndex < 0) {
                            findPointerIndex = 0;
                        }
                        setCurrentItemInternal(determineTargetPage(i2, f3, xVelocity, (int) (motionEvent.getX(findPointerIndex) - this.mInitialMotionX)), true, true, xVelocity);
                        this.mActivePointerId = -1;
                        endDrag();
                        z = this.mRightEdge.ga() | this.mLeftEdge.ga();
                        break;
                    }
                    break;
                case 2:
                    if (!this.mIsBeingDragged) {
                        int findPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
                        float x2 = motionEvent.getX(findPointerIndex2);
                        float abs = Math.abs(x2 - this.mLastMotionX);
                        float y2 = motionEvent.getY(findPointerIndex2);
                        float abs2 = Math.abs(y2 - this.mLastMotionY);
                        if (abs > ((float) this.mTouchSlop) && abs > abs2) {
                            this.mIsBeingDragged = true;
                            if (x2 - this.mInitialMotionX > 0.0f) {
                                f2 = this.mInitialMotionX + ((float) this.mTouchSlop);
                            } else {
                                f2 = this.mInitialMotionX - ((float) this.mTouchSlop);
                            }
                            this.mLastMotionX = f2;
                            this.mLastMotionY = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                        }
                    }
                    if (this.mIsBeingDragged) {
                        z = performDrag(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId))) | false;
                        break;
                    }
                    break;
                case 3:
                    if (this.mIsBeingDragged) {
                        scrollToItem(this.mCurItem, true, 0, false);
                        this.mActivePointerId = -1;
                        endDrag();
                        z = this.mRightEdge.ga() | this.mLeftEdge.ga();
                        break;
                    }
                    break;
                case 5:
                    int actionIndex = motionEvent.getActionIndex();
                    this.mLastMotionX = motionEvent.getX(actionIndex);
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                    break;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                    break;
            }
            if (z) {
                u.X(this);
            }
            AppMethodBeat.o(97023);
            return true;
        }
    }

    private boolean performDrag(float f2) {
        boolean z;
        float f3;
        boolean z2 = true;
        boolean z3 = false;
        AppMethodBeat.i(97024);
        this.mLastMotionX = f2;
        float scrollX = ((float) getScrollX()) + (this.mLastMotionX - f2);
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.mFirstOffset;
        float f5 = ((float) clientWidth) * this.mLastOffset;
        b bVar = this.mItems.get(0);
        b bVar2 = this.mItems.get(this.mItems.size() - 1);
        if (bVar.position != 0) {
            f4 = ((float) clientWidth) * bVar.offset;
            z = false;
        } else {
            z = true;
        }
        if (bVar2.position != this.mAdapter.getCount() - 1) {
            f3 = bVar2.offset * ((float) clientWidth);
            z2 = false;
        } else {
            f3 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.mLeftEdge.G(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f3) {
            if (z2) {
                z3 = this.mRightEdge.G(Math.abs(scrollX - f3) / ((float) clientWidth));
            }
            f4 = f3;
        } else {
            f4 = scrollX;
        }
        this.mLastMotionX += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        pageScrolled((int) f4);
        AppMethodBeat.o(97024);
        return z3;
    }

    /* access modifiers changed from: package-private */
    public final b fdV() {
        float f2;
        b bVar;
        AppMethodBeat.i(97025);
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        if (clientWidth > 0) {
            f2 = ((float) this.mPageMargin) / ((float) clientWidth);
        } else {
            f2 = 0.0f;
        }
        int i2 = -1;
        boolean z = true;
        int i3 = 0;
        b bVar2 = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (i3 < this.mItems.size()) {
            b bVar3 = this.mItems.get(i3);
            if (z || bVar3.position == i2 + 1) {
                bVar = bVar3;
            } else {
                b bVar4 = this.EhU;
                bVar4.offset = f4 + f3 + f2;
                bVar4.position = i2 + 1;
                bVar4.widthFactor = this.mAdapter.getPageWidth(bVar4.position);
                i3--;
                bVar = bVar4;
            }
            f4 = bVar.offset;
            float f5 = bVar.widthFactor + f4 + f2;
            if (!z && scrollX < f4) {
                AppMethodBeat.o(97025);
                return bVar2;
            } else if (scrollX < f5 || i3 == this.mItems.size() - 1) {
                AppMethodBeat.o(97025);
                return bVar;
            } else {
                i2 = bVar.position;
                f3 = bVar.widthFactor;
                i3++;
                bVar2 = bVar;
                z = false;
            }
        }
        AppMethodBeat.o(97025);
        return bVar2;
    }

    /* access modifiers changed from: package-private */
    public final int determineTargetPage(int i2, float f2, int i3, int i4) {
        AppMethodBeat.i(97026);
        if (Math.abs(i4) <= this.mFlingDistance || Math.abs(i3) <= this.mMinimumVelocity) {
            i2 = (int) ((i2 >= this.mCurItem ? 0.85f : 0.15f) + ((float) i2) + f2);
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.mItems.size() > 0) {
            i2 = Math.max(firstItemPosForDetermine(), Math.min(i2, lastItemPosForDetermine()));
        }
        AppMethodBeat.o(97026);
        return i2;
    }

    private int firstItemPosForDetermine() {
        AppMethodBeat.i(97027);
        int i2 = this.mItems.get(0).position;
        AppMethodBeat.o(97027);
        return i2;
    }

    private int lastItemPosForDetermine() {
        AppMethodBeat.i(97028);
        int i2 = this.mItems.get(this.mItems.size() - 1).position;
        AppMethodBeat.o(97028);
        return i2;
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(97029);
        super.draw(canvas);
        boolean z = false;
        int S = u.S(this);
        if (S == 0 || (S == 1 && this.mAdapter != null && this.mAdapter.getCount() > 1)) {
            if (!this.mLeftEdge.Uv.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.mFirstOffset * ((float) width));
                this.mLeftEdge.setSize(height, width);
                z = this.mLeftEdge.draw(canvas) | false;
                canvas.restoreToCount(save);
            }
            if (!this.mRightEdge.Uv.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.mLastOffset + 1.0f)) * ((float) width2));
                this.mRightEdge.setSize(height2, width2);
                z |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.mLeftEdge.Uv.finish();
            this.mRightEdge.Uv.finish();
        }
        if (z) {
            u.X(this);
        }
        AppMethodBeat.o(97029);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        AppMethodBeat.i(97030);
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f3 = ((float) this.mPageMargin) / ((float) width);
            b bVar = this.mItems.get(0);
            float f4 = bVar.offset;
            int size = this.mItems.size();
            int i2 = bVar.position;
            int i3 = this.mItems.get(size - 1).position;
            int i4 = 0;
            for (int i5 = i2; i5 < i3; i5++) {
                while (i5 > bVar.position && i4 < size) {
                    i4++;
                    bVar = this.mItems.get(i4);
                }
                if (i5 == bVar.position) {
                    f2 = (bVar.offset + bVar.widthFactor) * ((float) width);
                    f4 = bVar.offset + bVar.widthFactor + f3;
                } else {
                    float pageWidth = this.mAdapter.getPageWidth(i5);
                    f2 = (f4 + pageWidth) * ((float) width);
                    f4 += pageWidth + f3;
                }
                if (((float) this.mPageMargin) + f2 > ((float) scrollX)) {
                    this.mMarginDrawable.setBounds((int) f2, this.mTopPageBounds, (int) (((float) this.mPageMargin) + f2 + 0.5f), this.mBottomPageBounds);
                    this.mMarginDrawable.draw(canvas);
                }
                if (f2 > ((float) (scrollX + width))) {
                    break;
                }
            }
        }
        AppMethodBeat.o(97030);
    }

    public final void fakeDragBy(float f2) {
        float f3;
        float f4;
        AppMethodBeat.i(97031);
        if (!this.mFakeDragging) {
            IllegalStateException illegalStateException = new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
            AppMethodBeat.o(97031);
            throw illegalStateException;
        }
        this.mLastMotionX += f2;
        float scrollX = ((float) getScrollX()) - f2;
        int clientWidth = getClientWidth();
        float f5 = ((float) clientWidth) * this.mFirstOffset;
        float f6 = ((float) clientWidth) * this.mLastOffset;
        b bVar = this.mItems.get(0);
        b bVar2 = this.mItems.get(this.mItems.size() - 1);
        if (bVar.position != 0) {
            f3 = bVar.offset * ((float) clientWidth);
        } else {
            f3 = f5;
        }
        if (bVar2.position != this.mAdapter.getCount() - 1) {
            f4 = bVar2.offset * ((float) clientWidth);
        } else {
            f4 = f6;
        }
        if (scrollX >= f3) {
            if (scrollX > f4) {
                f3 = f4;
            } else {
                f3 = scrollX;
            }
        }
        this.mLastMotionX += f3 - ((float) ((int) f3));
        scrollTo((int) f3, getScrollY());
        pageScrolled((int) f3);
        MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        AppMethodBeat.o(97031);
    }

    /* access modifiers changed from: package-private */
    public final void endDrag() {
        AppMethodBeat.i(97033);
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        AppMethodBeat.o(97033);
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    public boolean canScrollHorizontally(int i2) {
        AppMethodBeat.i(97034);
        if (this.mAdapter == null) {
            AppMethodBeat.o(97034);
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i2 < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.mFirstOffset))) {
                AppMethodBeat.o(97034);
                return true;
            }
            AppMethodBeat.o(97034);
            return false;
        } else if (i2 <= 0) {
            AppMethodBeat.o(97034);
            return false;
        } else if (scrollX < ((int) (((float) clientWidth) * this.mLastOffset))) {
            AppMethodBeat.o(97034);
            return true;
        } else {
            AppMethodBeat.o(97034);
            return false;
        }
    }

    private boolean canScroll(View view, boolean z, int i2, int i3, int i4) {
        AppMethodBeat.i(97035);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i3 + scrollX >= childAt.getLeft() && i3 + scrollX < childAt.getRight() && i4 + scrollY >= childAt.getTop() && i4 + scrollY < childAt.getBottom() && canScroll(childAt, true, i2, (i3 + scrollX) - childAt.getLeft(), (i4 + scrollY) - childAt.getTop())) {
                    AppMethodBeat.o(97035);
                    return true;
                }
            }
        }
        if (!z || !u.n(view, -i2)) {
            AppMethodBeat.o(97035);
            return false;
        }
        AppMethodBeat.o(97035);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(android.view.KeyEvent r6) {
        /*
            r5 = this;
            r0 = 0
            r4 = 97036(0x17b0c, float:1.35976E-40)
            r1 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            boolean r2 = super.dispatchKeyEvent(r6)
            if (r2 != 0) goto L_0x001e
            int r2 = r6.getAction()
            if (r2 != 0) goto L_0x001b
            int r2 = r6.getKeyCode()
            switch(r2) {
                case 21: goto L_0x0023;
                case 22: goto L_0x002a;
                case 61: goto L_0x0031;
                default: goto L_0x001b;
            }
        L_0x001b:
            r2 = r0
        L_0x001c:
            if (r2 == 0) goto L_0x004e
        L_0x001e:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            r0 = r1
        L_0x0022:
            return r0
        L_0x0023:
            r2 = 17
            boolean r2 = r5.arrowScroll(r2)
            goto L_0x001c
        L_0x002a:
            r2 = 66
            boolean r2 = r5.arrowScroll(r2)
            goto L_0x001c
        L_0x0031:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 11
            if (r2 < r3) goto L_0x001b
            boolean r2 = r6.hasNoModifiers()
            if (r2 == 0) goto L_0x0043
            r2 = 2
            boolean r2 = r5.arrowScroll(r2)
            goto L_0x001c
        L_0x0043:
            boolean r2 = r6.hasModifiers(r1)
            if (r2 == 0) goto L_0x001b
            boolean r2 = r5.arrowScroll(r1)
            goto L_0x001c
        L_0x004e:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0022
            switch-data {21->0x0023, 22->0x002a, 61->0x0031, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c9, code lost:
        if (r10 != 2) goto L_0x00d1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean arrowScroll(int r10) {
        /*
        // Method dump skipped, instructions count: 218
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.arrowScroll(int):boolean");
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        Rect rect2;
        AppMethodBeat.i(97038);
        if (rect == null) {
            rect2 = new Rect();
        } else {
            rect2 = rect;
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            AppMethodBeat.o(97038);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        AppMethodBeat.o(97038);
        return rect2;
    }

    private boolean pageLeft() {
        AppMethodBeat.i(97039);
        if (this.mCurItem > 0) {
            setCurrentItem$2563266(this.mCurItem - 1);
            AppMethodBeat.o(97039);
            return true;
        }
        AppMethodBeat.o(97039);
        return false;
    }

    private boolean pageRight() {
        AppMethodBeat.i(97040);
        if (this.mAdapter == null || this.mCurItem >= this.mAdapter.getCount() - 1) {
            AppMethodBeat.o(97040);
            return false;
        }
        setCurrentItem$2563266(this.mCurItem + 1);
        AppMethodBeat.o(97040);
        return true;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        b fl;
        AppMethodBeat.i(97041);
        Assert.assertNotNull(arrayList);
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (fl = fl(childAt)) != null && fl.position == this.mCurItem) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if (descendantFocusability != 262144 || size == arrayList.size()) {
            if (!isFocusable()) {
                AppMethodBeat.o(97041);
                return;
            } else if ((i3 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) {
                arrayList.add(this);
            } else {
                AppMethodBeat.o(97041);
                return;
            }
        }
        AppMethodBeat.o(97041);
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addTouchables(ArrayList<View> arrayList) {
        b fl;
        AppMethodBeat.i(97042);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (fl = fl(childAt)) != null && fl.position == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
        AppMethodBeat.o(97042);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        b fl;
        AppMethodBeat.i(97043);
        int childCount = getChildCount();
        if ((i2 & 2) != 0) {
            i4 = 1;
            i3 = 0;
        } else {
            i3 = childCount - 1;
            i4 = -1;
            childCount = -1;
        }
        while (i3 != childCount) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 0 || (fl = fl(childAt)) == null || fl.position != this.mCurItem || !childAt.requestFocus(i2, rect)) {
                i3 += i4;
            } else {
                AppMethodBeat.o(97043);
                return true;
            }
        }
        AppMethodBeat.o(97043);
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        b fl;
        AppMethodBeat.i(97044);
        if (accessibilityEvent.getEventType() == 4096) {
            boolean dispatchPopulateAccessibilityEvent = super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
            AppMethodBeat.o(97044);
            return dispatchPopulateAccessibilityEvent;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (fl = fl(childAt)) != null && fl.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                AppMethodBeat.o(97044);
                return true;
            }
        }
        AppMethodBeat.o(97044);
        return false;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        AppMethodBeat.i(97045);
        LayoutParams layoutParams = new LayoutParams();
        AppMethodBeat.o(97045);
        return layoutParams;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(97046);
        ViewGroup.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        AppMethodBeat.o(97046);
        return generateDefaultLayoutParams;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(97047);
        if (!(layoutParams instanceof LayoutParams) || !super.checkLayoutParams(layoutParams)) {
            AppMethodBeat.o(97047);
            return false;
        }
        AppMethodBeat.o(97047);
        return true;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AppMethodBeat.i(97048);
        LayoutParams layoutParams = new LayoutParams(getContext(), attributeSet);
        AppMethodBeat.o(97048);
        return layoutParams;
    }

    class c extends android.support.v4.view.a {
        c() {
        }

        @Override // android.support.v4.view.a
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AppMethodBeat.i(96968);
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(AdLandingViewPager.class.getName());
            android.support.v4.view.a.e fJ = android.support.v4.view.a.e.fJ();
            fJ.setScrollable(fG());
            if (accessibilityEvent.getEventType() == 4096 && AdLandingViewPager.this.mAdapter != null) {
                fJ.setItemCount(AdLandingViewPager.this.mAdapter.getCount());
                fJ.setFromIndex(AdLandingViewPager.this.mCurItem);
                fJ.setToIndex(AdLandingViewPager.this.mCurItem);
            }
            AppMethodBeat.o(96968);
        }

        @Override // android.support.v4.view.a
        public final void onInitializeAccessibilityNodeInfo(View view, android.support.v4.view.a.c cVar) {
            AppMethodBeat.i(96969);
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.setClassName(AdLandingViewPager.class.getName());
            cVar.setScrollable(fG());
            if (AdLandingViewPager.this.canScrollHorizontally(1)) {
                cVar.addAction(4096);
            }
            if (AdLandingViewPager.this.canScrollHorizontally(-1)) {
                cVar.addAction(8192);
            }
            AppMethodBeat.o(96969);
        }

        @Override // android.support.v4.view.a
        public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            AppMethodBeat.i(96970);
            if (super.performAccessibilityAction(view, i2, bundle)) {
                AppMethodBeat.o(96970);
                return true;
            }
            switch (i2) {
                case 4096:
                    if (AdLandingViewPager.this.canScrollHorizontally(1)) {
                        AdLandingViewPager.this.setCurrentItem(AdLandingViewPager.this.mCurItem + 1);
                        AppMethodBeat.o(96970);
                        return true;
                    }
                    AppMethodBeat.o(96970);
                    return false;
                case 8192:
                    if (AdLandingViewPager.this.canScrollHorizontally(-1)) {
                        AdLandingViewPager.this.setCurrentItem(AdLandingViewPager.this.mCurItem - 1);
                        AppMethodBeat.o(96970);
                        return true;
                    }
                    AppMethodBeat.o(96970);
                    return false;
                default:
                    AppMethodBeat.o(96970);
                    return false;
            }
        }

        private boolean fG() {
            AppMethodBeat.i(96971);
            if (AdLandingViewPager.this.mAdapter == null || AdLandingViewPager.this.mAdapter.getCount() <= 1) {
                AppMethodBeat.o(96971);
                return false;
            }
            AppMethodBeat.o(96971);
            return true;
        }
    }

    class e extends DataSetObserver {
        private e() {
        }

        /* synthetic */ e(AdLandingViewPager adLandingViewPager, byte b2) {
            this();
        }

        public final void onChanged() {
            AppMethodBeat.i(96972);
            AdLandingViewPager.this.dataSetChanged();
            AppMethodBeat.o(96972);
        }

        public final void onInvalidated() {
            AppMethodBeat.i(96973);
            AdLandingViewPager.this.dataSetChanged();
            AppMethodBeat.o(96973);
        }
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        public boolean QY;
        boolean QZ;
        int Ra;
        public int gravity;
        int position;
        float widthFactor = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            AppMethodBeat.i(96967);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AdLandingViewPager.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(96967);
        }
    }

    /* access modifiers changed from: package-private */
    public static class f implements Comparator<View> {
        f() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(View view, View view2) {
            AppMethodBeat.i(96979);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            if (layoutParams.QY == layoutParams2.QY) {
                int i2 = layoutParams.position - layoutParams2.position;
                AppMethodBeat.o(96979);
                return i2;
            } else if (layoutParams.QY) {
                AppMethodBeat.o(96979);
                return 1;
            } else {
                AppMethodBeat.o(96979);
                return -1;
            }
        }
    }

    public void setScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int i2;
        AppMethodBeat.i(97032);
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            if (actionIndex == 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            this.mLastMotionX = motionEvent.getX(i2);
            this.mActivePointerId = motionEvent.getPointerId(i2);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
        AppMethodBeat.o(97032);
    }
}
