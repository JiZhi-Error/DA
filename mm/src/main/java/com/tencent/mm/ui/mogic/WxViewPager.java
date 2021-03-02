package com.tencent.mm.ui.mogic;

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
import android.view.KeyEvent;
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
import java.util.List;
import junit.framework.Assert;

public class WxViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<b> COMPARATOR = new Comparator<b>() {
        /* class com.tencent.mm.ui.mogic.WxViewPager.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(b bVar, b bVar2) {
            return bVar.position - bVar2.position;
        }
    };
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    private static final int[] LAYOUT_ATTRS = {16842931};
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "WxViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator = new Interpolator() {
        /* class com.tencent.mm.ui.mogic.WxViewPager.AnonymousClass2 */

        public final float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private static final f sPositionComparator = new f();
    private List<ViewPager.OnPageChangeListener> listeners = new ArrayList();
    private int mActivePointerId = -1;
    private q mAdapter;
    private d mAdapterChangeListener;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    private int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable = new Runnable() {
        /* class com.tencent.mm.ui.mogic.WxViewPager.AnonymousClass3 */

        public final void run() {
            AppMethodBeat.i(142887);
            WxViewPager.access$000(WxViewPager.this, 0);
            WxViewPager.this.populate();
            AppMethodBeat.o(142887);
        }
    };
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout = true;
    private float mFirstOffset = -3.4028235E38f;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mIgnoreGutter;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private ViewPager.OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private final ArrayList<b> mItems = new ArrayList<>();
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset = Float.MAX_VALUE;
    private i mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets = false;
    private e mObserver;
    private int mOffscreenPageLimit = 1;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mPageMargin;
    private ViewPager.d mPageTransformer;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState = null;
    private ClassLoader mRestoredClassLoader = null;
    private int mRestoredCurItem = -1;
    private i mRightEdge;
    private int mScrollState = 0;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private Method mSetChildrenDrawingOrderEnabled;
    private final b mTempItem = new b();
    private final Rect mTempRect = new Rect();
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    interface a {
    }

    interface d {
    }

    static /* synthetic */ void access$000(WxViewPager wxViewPager, int i2) {
        AppMethodBeat.i(142982);
        wxViewPager.setScrollState(i2);
        AppMethodBeat.o(142982);
    }

    static {
        AppMethodBeat.i(142983);
        AppMethodBeat.o(142983);
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

    public WxViewPager(Context context) {
        super(context);
        AppMethodBeat.i(142901);
        initViewPager();
        AppMethodBeat.o(142901);
    }

    public WxViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(142902);
        initViewPager();
        AppMethodBeat.o(142902);
    }

    /* access modifiers changed from: package-private */
    public void initViewPager() {
        AppMethodBeat.i(142903);
        setWillNotDraw(false);
        setDescendantFocusability(TPMediaCodecProfileLevel.HEVCMainTierLevel52);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = v.a(viewConfiguration);
        this.mMinimumVelocity = (int) (400.0f * f2);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new i(context);
        this.mRightEdge = new i(context);
        this.mFlingDistance = (int) (25.0f * f2);
        this.mCloseEnough = (int) (2.0f * f2);
        this.mDefaultGutterSize = (int) (16.0f * f2);
        u.a(this, new c());
        if (u.Y(this) == 0) {
            u.p(this, 1);
        }
        AppMethodBeat.o(142903);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(142904);
        removeCallbacks(this.mEndScrollRunnable);
        super.onDetachedFromWindow();
        AppMethodBeat.o(142904);
    }

    private void setScrollState(int i2) {
        AppMethodBeat.i(142905);
        if (this.mScrollState == i2) {
            AppMethodBeat.o(142905);
            return;
        }
        this.mScrollState = i2;
        if (this.mPageTransformer != null) {
            enableLayers(i2 != 0);
        }
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrollStateChanged(i2);
        }
        notifyOnPageScrollStateChanged(i2);
        AppMethodBeat.o(142905);
    }

    public void setAdapter(q qVar) {
        AppMethodBeat.i(142906);
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mObserver);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i2 = 0; i2 < this.mItems.size(); i2++) {
                b bVar = this.mItems.get(i2);
                this.mAdapter.destroyItem((ViewGroup) this, bVar.position, bVar.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            scrollTo(0, 0);
        }
        this.mAdapter = qVar;
        this.mExpectedAdapterCount = 0;
        if (this.mAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new e(this, (byte) 0);
            }
            this.mAdapter.registerDataSetObserver(this.mObserver);
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
                AppMethodBeat.o(142906);
                return;
            } else if (!z) {
                populate();
                AppMethodBeat.o(142906);
                return;
            } else {
                requestLayout();
            }
        }
        AppMethodBeat.o(142906);
    }

    private void removeNonDecorViews() {
        AppMethodBeat.i(142907);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < getChildCount()) {
                if (!((LayoutParams) getChildAt(i3).getLayoutParams()).QY) {
                    removeViewAt(i3);
                    i3--;
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.o(142907);
                return;
            }
        }
    }

    public q getAdapter() {
        return this.mAdapter;
    }

    /* access modifiers changed from: package-private */
    public void setOnAdapterChangeListener(d dVar) {
        this.mAdapterChangeListener = dVar;
    }

    private int getClientWidth() {
        AppMethodBeat.i(142908);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        AppMethodBeat.o(142908);
        return measuredWidth;
    }

    public void setCurrentItem(int i2) {
        boolean z;
        AppMethodBeat.i(142909);
        this.mPopulatePending = false;
        if (!this.mFirstLayout) {
            z = true;
        } else {
            z = false;
        }
        setCurrentItemInternal(i2, z, false);
        AppMethodBeat.o(142909);
    }

    public void setCurrentItem(int i2, boolean z) {
        AppMethodBeat.i(142910);
        this.mPopulatePending = false;
        setCurrentItemInternal(i2, z, false);
        AppMethodBeat.o(142910);
    }

    public void setCurrentItem(int i2, boolean z, boolean z2) {
        AppMethodBeat.i(205345);
        this.mPopulatePending = false;
        setCurrentItemInternal(i2, z, z2);
        AppMethodBeat.o(205345);
    }

    public void setCurrentItemNotify(int i2, boolean z) {
        AppMethodBeat.i(142911);
        this.mPopulatePending = false;
        setCurrentItemInternal(i2, z, false, 0, true);
        AppMethodBeat.o(142911);
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    /* access modifiers changed from: package-private */
    public void setCurrentItemInternal(int i2, boolean z, boolean z2) {
        AppMethodBeat.i(142912);
        setCurrentItemInternal(i2, z, z2, 0);
        AppMethodBeat.o(142912);
    }

    /* access modifiers changed from: package-private */
    public void setCurrentItemInternal(int i2, boolean z, boolean z2, int i3) {
        AppMethodBeat.i(142913);
        setCurrentItemInternal(i2, z, z2, i3, false);
        AppMethodBeat.o(142913);
    }

    /* access modifiers changed from: package-private */
    public void setCurrentItemInternal(int i2, boolean z, boolean z2, int i3, boolean z3) {
        boolean z4 = false;
        AppMethodBeat.i(142914);
        if (this.mAdapter == null || this.mAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
            AppMethodBeat.o(142914);
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
                z4 = true;
            }
            if (this.mFirstLayout) {
                this.mCurItem = i2;
                if ((z3 || z4) && this.mOnPageChangeListener != null) {
                    this.mOnPageChangeListener.onPageSelected(i2);
                }
                if ((z3 || z4) && this.mInternalPageChangeListener != null) {
                    this.mInternalPageChangeListener.onPageSelected(i2);
                }
                if (z3 || z4) {
                    notifyOnPageSelected(i2);
                }
                requestLayout();
                AppMethodBeat.o(142914);
                return;
            }
            populate(i2);
            scrollToItem(i2, z, i3, z4);
            AppMethodBeat.o(142914);
        } else {
            setScrollingCacheEnabled(false);
            AppMethodBeat.o(142914);
        }
    }

    private void scrollToItem(int i2, boolean z, int i3, boolean z2) {
        int i4;
        AppMethodBeat.i(142915);
        b infoForPosition = infoForPosition(i2);
        if (infoForPosition != null) {
            i4 = (int) (Math.max(this.mFirstOffset, Math.min(infoForPosition.offset, this.mLastOffset)) * ((float) getClientWidth()));
        } else {
            i4 = 0;
        }
        if (z) {
            smoothScrollTo(i4, 0, i3);
            if (z2 && this.mOnPageChangeListener != null) {
                this.mOnPageChangeListener.onPageSelected(i2);
            }
            if (z2 && this.mInternalPageChangeListener != null) {
                this.mInternalPageChangeListener.onPageSelected(i2);
            }
            if (z2) {
                notifyOnPageSelected(i2);
                AppMethodBeat.o(142915);
                return;
            }
        } else {
            if (z2 && this.mOnPageChangeListener != null) {
                this.mOnPageChangeListener.onPageSelected(i2);
            }
            if (z2 && this.mInternalPageChangeListener != null) {
                this.mInternalPageChangeListener.onPageSelected(i2);
            }
            if (z2) {
                notifyOnPageSelected(i2);
            }
            completeScroll(false);
            scrollTo(i4, 0);
            pageScrolled(i4);
        }
        AppMethodBeat.o(142915);
    }

    private void notifyOnPageScrolled(int i2, float f2, int i3) {
        AppMethodBeat.i(205346);
        for (ViewPager.OnPageChangeListener onPageChangeListener : this.listeners) {
            onPageChangeListener.onPageScrolled(i2, f2, i3);
        }
        AppMethodBeat.o(205346);
    }

    private void notifyOnPageSelected(int i2) {
        AppMethodBeat.i(205347);
        for (ViewPager.OnPageChangeListener onPageChangeListener : this.listeners) {
            onPageChangeListener.onPageSelected(i2);
        }
        AppMethodBeat.o(205347);
    }

    private void notifyOnPageScrollStateChanged(int i2) {
        AppMethodBeat.i(205348);
        for (ViewPager.OnPageChangeListener onPageChangeListener : this.listeners) {
            onPageChangeListener.onPageScrollStateChanged(i2);
        }
        AppMethodBeat.o(205348);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void addOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        AppMethodBeat.i(205349);
        if (!this.listeners.contains(onPageChangeListener)) {
            this.listeners.add(onPageChangeListener);
        }
        AppMethodBeat.o(205349);
    }

    public void removeOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        AppMethodBeat.i(205350);
        this.listeners.remove(onPageChangeListener);
        AppMethodBeat.o(205350);
    }

    public void setPageTransformer(boolean z, ViewPager.d dVar) {
        boolean z2;
        int i2 = 1;
        AppMethodBeat.i(142916);
        if (Build.VERSION.SDK_INT >= 11) {
            boolean z3 = dVar != null;
            if (this.mPageTransformer != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z4 = z3 != z2;
            this.mPageTransformer = dVar;
            setChildrenDrawingOrderEnabledCompat(z3);
            if (z3) {
                if (z) {
                    i2 = 2;
                }
                this.mDrawingOrder = i2;
            } else {
                this.mDrawingOrder = 0;
            }
            if (z4) {
                populate();
            }
        }
        AppMethodBeat.o(142916);
    }

    /* access modifiers changed from: package-private */
    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
        AppMethodBeat.i(142917);
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
                AppMethodBeat.o(142917);
                return;
            } catch (Exception e3) {
            }
        }
        AppMethodBeat.o(142917);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        AppMethodBeat.i(142918);
        if (this.mDrawingOrder == 2) {
            i3 = (i2 - 1) - i3;
        }
        int i4 = ((LayoutParams) this.mDrawingOrderedChildren.get(i3).getLayoutParams()).Ra;
        AppMethodBeat.o(142918);
        return i4;
    }

    /* access modifiers changed from: package-private */
    public ViewPager.OnPageChangeListener setInternalPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        ViewPager.OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = onPageChangeListener;
        return onPageChangeListener2;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public void setOffscreenPageLimit(int i2) {
        AppMethodBeat.i(142919);
        if (i2 <= 0) {
            new StringBuilder("Requested offscreen page limit ").append(i2).append(" too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i2;
            populate();
        }
        AppMethodBeat.o(142919);
    }

    public void setPageMargin(int i2) {
        AppMethodBeat.i(142920);
        int i3 = this.mPageMargin;
        this.mPageMargin = i2;
        int width = getWidth();
        recomputeScrollPosition(width, width, i2, i3);
        requestLayout();
        AppMethodBeat.o(142920);
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        AppMethodBeat.i(142921);
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
        AppMethodBeat.o(142921);
    }

    public void setPageMarginDrawable(int i2) {
        AppMethodBeat.i(142922);
        setPageMarginDrawable(getContext().getResources().getDrawable(i2));
        AppMethodBeat.o(142922);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        AppMethodBeat.i(142923);
        if (super.verifyDrawable(drawable) || drawable == this.mMarginDrawable) {
            AppMethodBeat.o(142923);
            return true;
        }
        AppMethodBeat.o(142923);
        return false;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        AppMethodBeat.i(142924);
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
        AppMethodBeat.o(142924);
    }

    /* access modifiers changed from: package-private */
    public float distanceInfluenceForSnapDuration(float f2) {
        AppMethodBeat.i(142925);
        float sin = (float) Math.sin((double) ((float) (((double) (f2 - 0.5f)) * 0.4712389167638204d)));
        AppMethodBeat.o(142925);
        return sin;
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollTo(int i2, int i3) {
        AppMethodBeat.i(142926);
        smoothScrollTo(i2, i3, 0);
        AppMethodBeat.o(142926);
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollTo(int i2, int i3, int i4) {
        int abs;
        AppMethodBeat.i(142927);
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            AppMethodBeat.o(142927);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i5 = i2 - scrollX;
        int i6 = i3 - scrollY;
        if (i5 == 0 && i6 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            AppMethodBeat.o(142927);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float distanceInfluenceForSnapDuration = (((float) i7) * distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / ((float) clientWidth)))) + ((float) i7);
        int abs2 = Math.abs(i4);
        if (abs2 > 0) {
            abs = Math.round(1000.0f * Math.abs(distanceInfluenceForSnapDuration / ((float) abs2))) * 4;
        } else {
            abs = (int) (((((float) Math.abs(i5)) / ((((float) clientWidth) * this.mAdapter.getPageWidth(this.mCurItem)) + ((float) this.mPageMargin))) + 3.0f) * 100.0f);
        }
        this.mScroller.startScroll(scrollX, scrollY, i5, i6, Math.min(abs, 600));
        u.X(this);
        AppMethodBeat.o(142927);
    }

    /* access modifiers changed from: package-private */
    public b addNewItem(int i2, int i3) {
        AppMethodBeat.i(142928);
        b bVar = new b();
        bVar.position = i2;
        bVar.object = this.mAdapter.instantiateItem((ViewGroup) this, i2);
        bVar.widthFactor = this.mAdapter.getPageWidth(i2);
        if (i3 < 0 || i3 >= this.mItems.size()) {
            this.mItems.add(bVar);
        } else {
            this.mItems.add(i3, bVar);
        }
        AppMethodBeat.o(142928);
        return bVar;
    }

    /* access modifiers changed from: package-private */
    public void dataSetChanged() {
        AppMethodBeat.i(142929);
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
        AppMethodBeat.o(142929);
    }

    /* access modifiers changed from: package-private */
    public void populate() {
        AppMethodBeat.i(142930);
        populate(this.mCurItem);
        AppMethodBeat.o(142930);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f0, code lost:
        if (r0.position == r14.mCurItem) goto L_0x00f2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void populate(int r15) {
        /*
        // Method dump skipped, instructions count: 708
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.mogic.WxViewPager.populate(int):void");
    }

    private void sortChildDrawingOrder() {
        AppMethodBeat.i(142932);
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
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
        AppMethodBeat.o(142932);
    }

    private void calculatePageOffsets(b bVar, int i2, b bVar2) {
        b bVar3;
        b bVar4;
        AppMethodBeat.i(142933);
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
        AppMethodBeat.o(142933);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = android.support.v4.os.c.a(new android.support.v4.os.d<SavedState>() {
            /* class com.tencent.mm.ui.mogic.WxViewPager.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.support.v4.os.d
            public final /* bridge */ /* synthetic */ SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.support.v4.os.d
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                AppMethodBeat.i(142895);
                SavedState savedState = new SavedState(parcel, classLoader);
                AppMethodBeat.o(142895);
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
            AppMethodBeat.i(142896);
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.Rb, i2);
            AppMethodBeat.o(142896);
        }

        public String toString() {
            AppMethodBeat.i(142897);
            String str = "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
            AppMethodBeat.o(142897);
            return str;
        }

        static {
            AppMethodBeat.i(142899);
            AppMethodBeat.o(142899);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            AppMethodBeat.i(142898);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.Rb = parcel.readParcelable(classLoader);
            this.Rc = classLoader;
            AppMethodBeat.o(142898);
        }
    }

    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(142934);
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.mCurItem;
        if (this.mAdapter != null) {
            savedState.Rb = this.mAdapter.saveState();
        }
        AppMethodBeat.o(142934);
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(142935);
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            AppMethodBeat.o(142935);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.mAdapter != null) {
            this.mAdapter.restoreState(savedState.Rb, savedState.Rc);
            setCurrentItemInternal(savedState.position, false, true);
            AppMethodBeat.o(142935);
            return;
        }
        this.mRestoredCurItem = savedState.position;
        this.mRestoredAdapterState = savedState.Rb;
        this.mRestoredClassLoader = savedState.Rc;
        AppMethodBeat.o(142935);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams layoutParams2;
        AppMethodBeat.i(142936);
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
            AppMethodBeat.o(142936);
        } else if (layoutParams3.QY) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot add pager decor view during layout");
            AppMethodBeat.o(142936);
            throw illegalStateException;
        } else {
            layoutParams3.QZ = true;
            addViewInLayout(view, i2, layoutParams2);
            AppMethodBeat.o(142936);
        }
    }

    public void removeView(View view) {
        AppMethodBeat.i(142937);
        if (this.mInLayout) {
            removeViewInLayout(view);
            AppMethodBeat.o(142937);
            return;
        }
        super.removeView(view);
        AppMethodBeat.o(142937);
    }

    /* access modifiers changed from: package-private */
    public b infoForChild(View view) {
        AppMethodBeat.i(142938);
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            b bVar = this.mItems.get(i2);
            if (this.mAdapter.isViewFromObject(view, bVar.object)) {
                AppMethodBeat.o(142938);
                return bVar;
            }
        }
        AppMethodBeat.o(142938);
        return null;
    }

    /* access modifiers changed from: package-private */
    public b infoForAnyChild(View view) {
        AppMethodBeat.i(142939);
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                b infoForChild = infoForChild(view);
                AppMethodBeat.o(142939);
                return infoForChild;
            } else if (parent == null || !(parent instanceof View)) {
                AppMethodBeat.o(142939);
            } else {
                view = (View) parent;
            }
        }
        AppMethodBeat.o(142939);
        return null;
    }

    /* access modifiers changed from: package-private */
    public b infoForPosition(int i2) {
        AppMethodBeat.i(142940);
        for (int i3 = 0; i3 < this.mItems.size(); i3++) {
            b bVar = this.mItems.get(i3);
            if (bVar.position == i2) {
                AppMethodBeat.o(142940);
                return bVar;
            }
        }
        AppMethodBeat.o(142940);
        return null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(142941);
        super.onAttachedToWindow();
        this.mFirstLayout = true;
        AppMethodBeat.o(142941);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
        // Method dump skipped, instructions count: 290
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.mogic.WxViewPager.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(142943);
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            recomputeScrollPosition(i2, i4, this.mPageMargin, this.mPageMargin);
        }
        AppMethodBeat.o(142943);
    }

    private void recomputeScrollPosition(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(142944);
        if (i3 <= 0 || this.mItems.isEmpty()) {
            b infoForPosition = infoForPosition(this.mCurItem);
            int min = (int) ((infoForPosition != null ? Math.min(infoForPosition.offset, this.mLastOffset) : 0.0f) * ((float) ((i2 - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                completeScroll(false);
                scrollTo(min, getScrollY());
            }
            AppMethodBeat.o(142944);
            return;
        }
        int paddingLeft = (int) (((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((float) getScrollX()) / ((float) (((i3 - getPaddingLeft()) - getPaddingRight()) + i5))));
        scrollTo(paddingLeft, getScrollY());
        if (!this.mScroller.isFinished()) {
            int duration = this.mScroller.getDuration() - this.mScroller.timePassed();
            b infoForPosition2 = infoForPosition(this.mCurItem);
            if (infoForPosition2 != null) {
                this.mScroller.startScroll(paddingLeft, 0, (int) (infoForPosition2.offset * ((float) i2)), 0, duration);
            }
        }
        AppMethodBeat.o(142944);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        b infoForChild;
        int i6;
        int i7;
        int i8;
        int measuredWidth;
        int measuredHeight;
        int i9;
        AppMethodBeat.i(142945);
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
                if (!layoutParams2.QY && (infoForChild = infoForChild(childAt2)) != null) {
                    int i19 = ((int) (infoForChild.offset * ((float) i17))) + paddingLeft;
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
        AppMethodBeat.o(142945);
    }

    public void computeScroll() {
        AppMethodBeat.i(142946);
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            AppMethodBeat.o(142946);
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
        AppMethodBeat.o(142946);
    }

    private boolean pageScrolled(int i2) {
        AppMethodBeat.i(142947);
        if (this.mItems.size() == 0) {
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (!this.mCalledSuper) {
                IllegalStateException illegalStateException = new IllegalStateException("onPageScrolled did not call superclass implementation");
                AppMethodBeat.o(142947);
                throw illegalStateException;
            }
            AppMethodBeat.o(142947);
            return false;
        }
        b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
        if (infoForCurrentScrollPosition == null) {
            AppMethodBeat.o(142947);
            return false;
        }
        int clientWidth = getClientWidth();
        int i3 = this.mPageMargin + clientWidth;
        float f2 = ((float) this.mPageMargin) / ((float) clientWidth);
        int i4 = infoForCurrentScrollPosition.position;
        float f3 = ((((float) i2) / ((float) clientWidth)) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.widthFactor + f2);
        this.mCalledSuper = false;
        onPageScrolled(i4, f3, (int) (((float) i3) * f3));
        if (!this.mCalledSuper) {
            IllegalStateException illegalStateException2 = new IllegalStateException("onPageScrolled did not call superclass implementation");
            AppMethodBeat.o(142947);
            throw illegalStateException2;
        }
        AppMethodBeat.o(142947);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPageScrolled(int i2, float f2, int i3) {
        int i4;
        int measuredWidth;
        AppMethodBeat.i(142948);
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
        notifyOnPageScrolled(i2, f2, i3);
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
        AppMethodBeat.o(142948);
    }

    private void completeScroll(boolean z) {
        AppMethodBeat.i(142949);
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
                AppMethodBeat.o(142949);
                return;
            }
            this.mEndScrollRunnable.run();
        }
        AppMethodBeat.o(142949);
    }

    /* access modifiers changed from: protected */
    public boolean isGutterDrag(float f2, float f3) {
        AppMethodBeat.i(142950);
        if ((f2 >= ((float) this.mGutterSize) || f3 <= 0.0f) && (f2 <= ((float) (getWidth() - this.mGutterSize)) || f3 >= 0.0f)) {
            AppMethodBeat.o(142950);
            return false;
        }
        AppMethodBeat.o(142950);
        return true;
    }

    private void enableLayers(boolean z) {
        AppMethodBeat.i(142951);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            u.q(getChildAt(i2), z ? 2 : 0);
        }
        AppMethodBeat.o(142951);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(142952);
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.mIsBeingDragged = false;
            this.mIsUnableToDrag = false;
            this.mActivePointerId = -1;
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
            }
            AppMethodBeat.o(142952);
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                AppMethodBeat.o(142952);
                return true;
            } else if (this.mIsUnableToDrag) {
                AppMethodBeat.o(142952);
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
            case 2:
                int i2 = this.mActivePointerId;
                if (i2 != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float f2 = x2 - this.mLastMotionX;
                    float abs = Math.abs(f2);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float abs2 = Math.abs(y2 - this.mInitialMotionY);
                    if (f2 == 0.0f || isGutterDrag(this.mLastMotionX, f2) || !canScroll(this, false, (int) f2, (int) x2, (int) y2)) {
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
                    } else {
                        this.mLastMotionX = x2;
                        this.mLastMotionY = y2;
                        this.mIsUnableToDrag = true;
                        AppMethodBeat.o(142952);
                        return false;
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
        boolean z = this.mIsBeingDragged;
        AppMethodBeat.o(142952);
        return z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f2;
        boolean z = false;
        AppMethodBeat.i(142953);
        if (this.mFakeDragging) {
            AppMethodBeat.o(142953);
            return true;
        } else if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            AppMethodBeat.o(142953);
            return false;
        } else if (this.mAdapter == null || this.mAdapter.getCount() == 0) {
            AppMethodBeat.o(142953);
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
                        b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                        if (infoForCurrentScrollPosition != null) {
                            int i2 = infoForCurrentScrollPosition.position;
                            float f3 = ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.widthFactor;
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex < 0) {
                                findPointerIndex = 0;
                            }
                            setCurrentItemInternal(determineTargetPage(i2, f3, xVelocity, (int) (motionEvent.getX(findPointerIndex) - this.mInitialMotionX)), true, true, xVelocity);
                        }
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
            AppMethodBeat.o(142953);
            return true;
        }
    }

    private boolean performDrag(float f2) {
        boolean z;
        float f3;
        boolean z2 = true;
        boolean z3 = false;
        AppMethodBeat.i(142954);
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
        AppMethodBeat.o(142954);
        return z3;
    }

    private b infoForCurrentScrollPosition() {
        float f2;
        b bVar;
        AppMethodBeat.i(142955);
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
                b bVar4 = this.mTempItem;
                bVar4.offset = f4 + f3 + f2;
                bVar4.position = i2 + 1;
                bVar4.widthFactor = this.mAdapter.getPageWidth(bVar4.position);
                i3--;
                bVar = bVar4;
            }
            f4 = bVar.offset;
            float f5 = bVar.widthFactor + f4 + f2;
            if (!z && scrollX < f4) {
                AppMethodBeat.o(142955);
                return bVar2;
            } else if (scrollX < f5 || i3 == this.mItems.size() - 1) {
                AppMethodBeat.o(142955);
                return bVar;
            } else {
                i2 = bVar.position;
                f3 = bVar.widthFactor;
                i3++;
                bVar2 = bVar;
                z = false;
            }
        }
        AppMethodBeat.o(142955);
        return bVar2;
    }

    private int determineTargetPage(int i2, float f2, int i3, int i4) {
        AppMethodBeat.i(142956);
        if (Math.abs(i4) <= this.mFlingDistance || Math.abs(i3) <= this.mMinimumVelocity) {
            i2 = (int) ((i2 >= this.mCurItem ? 0.6f : 0.4f) + ((float) i2) + f2);
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.mItems.size() > 0) {
            i2 = Math.max(firstItemPosForDetermine(), Math.min(i2, lastItemPosForDetermine()));
        }
        AppMethodBeat.o(142956);
        return i2;
    }

    public int firstItemPosForDetermine() {
        AppMethodBeat.i(142957);
        int i2 = this.mItems.get(0).position;
        AppMethodBeat.o(142957);
        return i2;
    }

    public int lastItemPosForDetermine() {
        AppMethodBeat.i(142958);
        int i2 = this.mItems.get(this.mItems.size() - 1).position;
        AppMethodBeat.o(142958);
        return i2;
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(142959);
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
        AppMethodBeat.o(142959);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        AppMethodBeat.i(142960);
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
                    this.mMarginDrawable.setBounds(((int) f2) - 1, this.mTopPageBounds, ((int) ((((float) this.mPageMargin) + f2) + 0.5f)) - 1, this.mBottomPageBounds);
                    this.mMarginDrawable.draw(canvas);
                }
                if (f2 > ((float) (scrollX + width))) {
                    break;
                }
            }
        }
        AppMethodBeat.o(142960);
    }

    public boolean beginFakeDrag() {
        AppMethodBeat.i(142961);
        if (this.mIsBeingDragged) {
            AppMethodBeat.o(142961);
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        AppMethodBeat.o(142961);
        return true;
    }

    public void endFakeDrag() {
        AppMethodBeat.i(142962);
        if (!this.mFakeDragging) {
            IllegalStateException illegalStateException = new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
            AppMethodBeat.o(142962);
            throw illegalStateException;
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
        int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
        this.mPopulatePending = true;
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
        if (infoForCurrentScrollPosition != null) {
            setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.widthFactor, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
        }
        endDrag();
        this.mFakeDragging = false;
        AppMethodBeat.o(142962);
    }

    public void fakeDragBy(float f2) {
        float f3;
        float f4;
        AppMethodBeat.i(142963);
        if (!this.mFakeDragging) {
            IllegalStateException illegalStateException = new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
            AppMethodBeat.o(142963);
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
        AppMethodBeat.o(142963);
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    private void endDrag() {
        AppMethodBeat.i(142965);
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        AppMethodBeat.o(142965);
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    public boolean canScrollHorizontally(int i2) {
        AppMethodBeat.i(142966);
        if (this.mAdapter == null) {
            AppMethodBeat.o(142966);
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i2 < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.mFirstOffset))) {
                AppMethodBeat.o(142966);
                return true;
            }
            AppMethodBeat.o(142966);
            return false;
        } else if (i2 <= 0) {
            AppMethodBeat.o(142966);
            return false;
        } else if (scrollX < ((int) (((float) clientWidth) * this.mLastOffset))) {
            AppMethodBeat.o(142966);
            return true;
        } else {
            AppMethodBeat.o(142966);
            return false;
        }
    }

    public void setLastMotion(float f2, float f3) {
        this.mLastMotionX = f2;
        this.mLastMotionY = f3;
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z, int i2, int i3, int i4) {
        AppMethodBeat.i(142967);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i3 + scrollX >= childAt.getLeft() && i3 + scrollX < childAt.getRight() && i4 + scrollY >= childAt.getTop() && i4 + scrollY < childAt.getBottom() && canScroll(childAt, true, i2, (i3 + scrollX) - childAt.getLeft(), (i4 + scrollY) - childAt.getTop()) && childAt.isEnabled()) {
                    AppMethodBeat.o(142967);
                    return true;
                }
            }
        }
        if (!z || !u.n(view, -i2)) {
            AppMethodBeat.o(142967);
            return false;
        }
        AppMethodBeat.o(142967);
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(142968);
        if (super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent)) {
            AppMethodBeat.o(142968);
            return true;
        }
        AppMethodBeat.o(142968);
        return false;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(142969);
        boolean z = false;
        if (keyEvent.getAction() == 0) {
            switch (keyEvent.getKeyCode()) {
                case 21:
                    z = arrowScroll(17);
                    break;
                case 22:
                    z = arrowScroll(66);
                    break;
                case PlayerException.EXCEPTION_TYPE_INITLIB /*{ENCODED_INT: 61}*/:
                    if (Build.VERSION.SDK_INT >= 11) {
                        if (!keyEvent.hasNoModifiers()) {
                            if (keyEvent.hasModifiers(1)) {
                                z = arrowScroll(1);
                                break;
                            }
                        } else {
                            z = arrowScroll(2);
                            break;
                        }
                    }
                    break;
            }
        }
        AppMethodBeat.o(142969);
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c9, code lost:
        if (r10 != 2) goto L_0x00d1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean arrowScroll(int r10) {
        /*
        // Method dump skipped, instructions count: 218
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.mogic.WxViewPager.arrowScroll(int):boolean");
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        Rect rect2;
        AppMethodBeat.i(142971);
        if (rect == null) {
            rect2 = new Rect();
        } else {
            rect2 = rect;
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            AppMethodBeat.o(142971);
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
        AppMethodBeat.o(142971);
        return rect2;
    }

    /* access modifiers changed from: package-private */
    public boolean pageLeft() {
        AppMethodBeat.i(142972);
        if (this.mCurItem > 0) {
            setCurrentItem(this.mCurItem - 1, true);
            AppMethodBeat.o(142972);
            return true;
        }
        AppMethodBeat.o(142972);
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean pageRight() {
        AppMethodBeat.i(142973);
        if (this.mAdapter == null || this.mCurItem >= this.mAdapter.getCount() - 1) {
            AppMethodBeat.o(142973);
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        AppMethodBeat.o(142973);
        return true;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        b infoForChild;
        AppMethodBeat.i(142974);
        Assert.assertNotNull(arrayList);
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if (descendantFocusability != 262144 || size == arrayList.size()) {
            if (!isFocusable()) {
                AppMethodBeat.o(142974);
                return;
            } else if ((i3 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) {
                arrayList.add(this);
            } else {
                AppMethodBeat.o(142974);
                return;
            }
        }
        AppMethodBeat.o(142974);
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addTouchables(ArrayList<View> arrayList) {
        b infoForChild;
        AppMethodBeat.i(142975);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
        AppMethodBeat.o(142975);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        b infoForChild;
        AppMethodBeat.i(142976);
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
            if (childAt.getVisibility() != 0 || (infoForChild = infoForChild(childAt)) == null || infoForChild.position != this.mCurItem || !childAt.requestFocus(i2, rect)) {
                i3 += i4;
            } else {
                AppMethodBeat.o(142976);
                return true;
            }
        }
        AppMethodBeat.o(142976);
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        b infoForChild;
        AppMethodBeat.i(142977);
        if (accessibilityEvent.getEventType() == 4096) {
            boolean dispatchPopulateAccessibilityEvent = super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
            AppMethodBeat.o(142977);
            return dispatchPopulateAccessibilityEvent;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                AppMethodBeat.o(142977);
                return true;
            }
        }
        AppMethodBeat.o(142977);
        return false;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        AppMethodBeat.i(142978);
        LayoutParams layoutParams = new LayoutParams();
        AppMethodBeat.o(142978);
        return layoutParams;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(142979);
        ViewGroup.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        AppMethodBeat.o(142979);
        return generateDefaultLayoutParams;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(142980);
        if (!(layoutParams instanceof LayoutParams) || !super.checkLayoutParams(layoutParams)) {
            AppMethodBeat.o(142980);
            return false;
        }
        AppMethodBeat.o(142980);
        return true;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AppMethodBeat.i(142981);
        LayoutParams layoutParams = new LayoutParams(getContext(), attributeSet);
        AppMethodBeat.o(142981);
        return layoutParams;
    }

    /* access modifiers changed from: package-private */
    public class c extends android.support.v4.view.a {
        c() {
        }

        @Override // android.support.v4.view.a
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AppMethodBeat.i(142889);
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(WxViewPager.class.getName());
            android.support.v4.view.a.e fJ = android.support.v4.view.a.e.fJ();
            fJ.setScrollable(fG());
            if (accessibilityEvent.getEventType() == 4096 && WxViewPager.this.mAdapter != null) {
                fJ.setItemCount(WxViewPager.this.mAdapter.getCount());
                fJ.setFromIndex(WxViewPager.this.mCurItem);
                fJ.setToIndex(WxViewPager.this.mCurItem);
            }
            AppMethodBeat.o(142889);
        }

        @Override // android.support.v4.view.a
        public final void onInitializeAccessibilityNodeInfo(View view, android.support.v4.view.a.c cVar) {
            AppMethodBeat.i(142890);
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.setClassName(WxViewPager.class.getName());
            cVar.setScrollable(fG());
            if (WxViewPager.this.canScrollHorizontally(1)) {
                cVar.addAction(4096);
            }
            if (WxViewPager.this.canScrollHorizontally(-1)) {
                cVar.addAction(8192);
            }
            AppMethodBeat.o(142890);
        }

        @Override // android.support.v4.view.a
        public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            AppMethodBeat.i(142891);
            if (super.performAccessibilityAction(view, i2, bundle)) {
                AppMethodBeat.o(142891);
                return true;
            }
            switch (i2) {
                case 4096:
                    if (WxViewPager.this.canScrollHorizontally(1)) {
                        WxViewPager.this.setCurrentItem(WxViewPager.this.mCurItem + 1);
                        AppMethodBeat.o(142891);
                        return true;
                    }
                    AppMethodBeat.o(142891);
                    return false;
                case 8192:
                    if (WxViewPager.this.canScrollHorizontally(-1)) {
                        WxViewPager.this.setCurrentItem(WxViewPager.this.mCurItem - 1);
                        AppMethodBeat.o(142891);
                        return true;
                    }
                    AppMethodBeat.o(142891);
                    return false;
                default:
                    AppMethodBeat.o(142891);
                    return false;
            }
        }

        private boolean fG() {
            AppMethodBeat.i(142892);
            if (WxViewPager.this.mAdapter == null || WxViewPager.this.mAdapter.getCount() <= 1) {
                AppMethodBeat.o(142892);
                return false;
            }
            AppMethodBeat.o(142892);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public class e extends DataSetObserver {
        private e() {
        }

        /* synthetic */ e(WxViewPager wxViewPager, byte b2) {
            this();
        }

        public final void onChanged() {
            AppMethodBeat.i(142893);
            WxViewPager.this.dataSetChanged();
            AppMethodBeat.o(142893);
        }

        public final void onInvalidated() {
            AppMethodBeat.i(142894);
            WxViewPager.this.dataSetChanged();
            AppMethodBeat.o(142894);
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
            AppMethodBeat.i(142888);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, WxViewPager.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(142888);
        }
    }

    /* access modifiers changed from: package-private */
    public static class f implements Comparator<View> {
        f() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(View view, View view2) {
            AppMethodBeat.i(142900);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            if (layoutParams.QY == layoutParams2.QY) {
                int i2 = layoutParams.position - layoutParams2.position;
                AppMethodBeat.o(142900);
                return i2;
            } else if (layoutParams.QY) {
                AppMethodBeat.o(142900);
                return 1;
            } else {
                AppMethodBeat.o(142900);
                return -1;
            }
        }
    }

    public void setScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int i2;
        AppMethodBeat.i(142964);
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
        AppMethodBeat.o(142964);
    }
}
