package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;
import java.util.Set;

public class MMSlideDelView extends ViewGroup {
    private boolean OST = false;
    private b OSU;
    private Runnable OSV;
    private long OSW;
    private boolean OSX = false;
    private a OSY = null;
    private e OSZ;
    private boolean ded = true;
    private MMHandler mHandler = new MMHandler();
    private float mLastMotionX;
    private float mLastMotionY;
    private final Scroller mScroller;
    private final int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private boolean pPO = false;
    private g pkY;
    private c pkZ;
    private d plb;
    long time;
    private int va;

    public interface c {
        int dr(View view);
    }

    public interface d {
        public static final Set<MMSlideDelView> ywx = new HashSet();

        void a(MMSlideDelView mMSlideDelView, boolean z);

        boolean ebn();

        void ebo();

        void ebp();
    }

    public interface e {
    }

    public interface f {
        void cZ(Object obj);
    }

    public interface g {
        void r(View view, int i2, int i3);
    }

    static /* synthetic */ int c(MMSlideDelView mMSlideDelView) {
        AppMethodBeat.i(142150);
        int windowAttachCount = mMSlideDelView.getWindowAttachCount();
        AppMethodBeat.o(142150);
        return windowAttachCount;
    }

    public static d getItemStatusCallBack() {
        AppMethodBeat.i(142134);
        AnonymousClass1 r0 = new d() {
            /* class com.tencent.mm.ui.base.MMSlideDelView.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.d
            public final void a(MMSlideDelView mMSlideDelView, boolean z) {
                AppMethodBeat.i(142127);
                if (z) {
                    ywx.add(mMSlideDelView);
                    AppMethodBeat.o(142127);
                    return;
                }
                ywx.remove(mMSlideDelView);
                AppMethodBeat.o(142127);
            }

            @Override // com.tencent.mm.ui.base.MMSlideDelView.d
            public final boolean ebn() {
                AppMethodBeat.i(142128);
                if (ywx.size() > 0) {
                    AppMethodBeat.o(142128);
                    return true;
                }
                AppMethodBeat.o(142128);
                return false;
            }

            @Override // com.tencent.mm.ui.base.MMSlideDelView.d
            public final void ebo() {
                AppMethodBeat.i(142129);
                for (MMSlideDelView mMSlideDelView : ywx) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.gLa();
                    }
                }
                ywx.clear();
                AppMethodBeat.o(142129);
            }

            @Override // com.tencent.mm.ui.base.MMSlideDelView.d
            public final void ebp() {
                AppMethodBeat.i(142130);
                for (MMSlideDelView mMSlideDelView : ywx) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.gKZ();
                    }
                }
                ywx.clear();
                AppMethodBeat.o(142130);
            }
        };
        AppMethodBeat.o(142134);
        return r0;
    }

    public MMSlideDelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(142135);
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.OSW = (long) ViewConfiguration.getLongPressTimeout();
        AppMethodBeat.o(142135);
    }

    public void setPerformItemClickListener(g gVar) {
        this.pkY = gVar;
    }

    public void setGetViewPositionCallback(c cVar) {
        this.pkZ = cVar;
    }

    public void setItemStatusCallBack(d dVar) {
        this.plb = dVar;
    }

    public void setEnable(boolean z) {
        this.ded = z;
    }

    public void setOnDelViewShowCallback(e eVar) {
        this.OSZ = eVar;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(142136);
        if (getChildCount() < 2) {
            AppMethodBeat.o(142136);
            return;
        }
        int childCount = getChildCount();
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i6, 0, i6 + measuredWidth, i5 - i3);
                i6 += measuredWidth;
            }
        }
        AppMethodBeat.o(142136);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(142137);
        if (getChildCount() < 2) {
            AppMethodBeat.o(142137);
            return;
        }
        int size = View.MeasureSpec.getSize(i2);
        try {
            getChildAt(0).measure(i2, i3);
        } catch (ArrayIndexOutOfBoundsException e2) {
        }
        int max = Math.max(0, getChildAt(0).getMeasuredHeight());
        ViewGroup.LayoutParams layoutParams = getChildAt(1).getLayoutParams();
        View childAt = getChildAt(1);
        if (!(childAt == null || childAt.getVisibility() == 8)) {
            try {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(max, 1073741824));
            } catch (ArrayIndexOutOfBoundsException e3) {
            }
            max = Math.max(max, childAt.getMeasuredHeight());
        }
        setMeasuredDimension(resolveSize(size, i2), resolveSize(max, i3));
        AppMethodBeat.o(142137);
    }

    public void setView(View view) {
        AppMethodBeat.i(142138);
        if (getChildCount() == 2) {
            removeViewAt(0);
        }
        addView(view, 0, new ViewGroup.LayoutParams(-1, -2));
        AppMethodBeat.o(142138);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        boolean z;
        AppMethodBeat.i(142139);
        if (!this.ded) {
            AppMethodBeat.o(142139);
            return false;
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.plb.ebn() && !this.OST) {
            Log.v("MicroMsg.MMSlideDelView", "onTouchEvent a menu has been shown, skip");
            this.OSX = false;
            this.plb.ebo();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (this.OSX) {
            AppMethodBeat.o(142139);
            return false;
        }
        switch (action) {
            case 0:
                if (getContext() instanceof MMActivity) {
                    ((MMActivity) getContext()).hideVKB();
                }
                this.pPO = false;
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
                this.time = System.currentTimeMillis();
                if (this.pkZ != null) {
                    this.va = this.pkZ.dr(this);
                }
                if (this.OSU == null) {
                    this.OSU = new b();
                }
                this.mHandler.postDelayed(this.OSU, (long) ViewConfiguration.getTapTimeout());
                this.mLastMotionX = x;
                this.mLastMotionY = y;
                if (this.OSY == null) {
                    this.OSY = new a(this, (byte) 0);
                }
                a aVar = this.OSY;
                aVar.OTb = MMSlideDelView.this.getWindowAttachCount();
                this.mHandler.postDelayed(this.OSY, this.OSW);
                break;
            case 1:
                gKW();
                if (this.pPO || ((!isPressed() && System.currentTimeMillis() - this.time >= 200) || this.pkY == null || this.OST)) {
                    setPressed(false);
                } else {
                    setPressed(true);
                    if (this.OSV != null) {
                        removeCallbacks(this.OSV);
                    }
                    this.OSV = new Runnable() {
                        /* class com.tencent.mm.ui.base.MMSlideDelView.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(142131);
                            MMSlideDelView.this.setPressed(false);
                            Log.v("MicroMsg.MMSlideDelView", "onClick");
                            MMSlideDelView.this.pkY.r(MMSlideDelView.this, MMSlideDelView.this.va, 0);
                            MMSlideDelView.this.gKZ();
                            AppMethodBeat.o(142131);
                        }
                    };
                    this.mHandler.postDelayed(this.OSV, (long) ViewConfiguration.getPressedStateDuration());
                }
                if (this.pPO) {
                    gKX();
                }
                np();
                if (this.mHandler != null) {
                    this.mHandler.removeCallbacks(this.OSY);
                    break;
                }
                break;
            case 2:
                int i3 = (int) (this.mLastMotionX - x);
                int i4 = (int) (this.mLastMotionY - y);
                int scrollX = getScrollX();
                if (!this.pPO) {
                    if (i3 >= 0 && Math.abs(i3) >= this.mTouchSlop / 3) {
                        if (i4 == 0) {
                            i4 = 1;
                        }
                        if (Math.abs(i3 / i4) > 3) {
                            z = true;
                            if (z || this.OST) {
                                this.pPO = true;
                                lu(true);
                            }
                        }
                    }
                    z = false;
                    this.pPO = true;
                    lu(true);
                }
                if (this.pPO) {
                    View childAt = getChildAt(1);
                    if (childAt != null && !childAt.isShown()) {
                        childAt.setVisibility(0);
                    }
                    gKW();
                    setPressed(false);
                    lu(true);
                    if (scrollX + i3 < 0) {
                        i2 = -scrollX;
                    } else if (scrollX + i3 > getChildAt(1).getWidth()) {
                        i2 = getChildAt(1).getWidth() - scrollX;
                    } else {
                        i2 = i3;
                    }
                    if (this.mHandler != null) {
                        this.mHandler.removeCallbacks(this.OSY);
                    }
                    scrollBy(i2, 0);
                }
                this.mLastMotionX = x;
                this.mLastMotionY = y;
                break;
            case 3:
                gKW();
                setPressed(false);
                if (this.pPO) {
                    gKX();
                }
                np();
                if (this.mHandler != null) {
                    this.mHandler.removeCallbacks(this.OSY);
                    break;
                }
                break;
            default:
                if (this.mHandler != null) {
                    this.mHandler.removeCallbacks(this.OSY);
                    break;
                }
                break;
        }
        AppMethodBeat.o(142139);
        return true;
    }

    private void np() {
        AppMethodBeat.i(142140);
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker = null;
        }
        AppMethodBeat.o(142140);
    }

    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(142141);
        Log.v("MicroMsg.MMSlideDelView", "window focus change, reset long press status");
        this.OSX = false;
        super.onWindowFocusChanged(z);
        AppMethodBeat.o(142141);
    }

    private void gKW() {
        AppMethodBeat.i(142142);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.OSU);
        }
        AppMethodBeat.o(142142);
    }

    private void gKX() {
        AppMethodBeat.i(142143);
        setPressed(false);
        if (this.OST) {
            gLa();
            AppMethodBeat.o(142143);
            return;
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        velocityTracker.computeCurrentVelocity(1000);
        int xVelocity = (int) velocityTracker.getXVelocity();
        if (xVelocity < -600) {
            gKY();
        } else if (xVelocity > 600) {
            gLa();
        } else {
            gLb();
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        this.pPO = false;
        lu(false);
        AppMethodBeat.o(142143);
    }

    private void lu(boolean z) {
        AppMethodBeat.i(142144);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
        AppMethodBeat.o(142144);
    }

    private void gKY() {
        AppMethodBeat.i(142145);
        int scrollX = getScrollX();
        int width = getChildAt(1).getWidth() - scrollX;
        this.plb.a(this, true);
        this.OST = true;
        this.mScroller.startScroll(scrollX, 0, width, 0, 100);
        invalidate();
        AppMethodBeat.o(142145);
    }

    public final void gKZ() {
        AppMethodBeat.i(142146);
        this.plb.a(this, false);
        this.OST = false;
        scrollTo(0, 0);
        invalidate();
        AppMethodBeat.o(142146);
    }

    public final void gLa() {
        AppMethodBeat.i(142147);
        int scrollX = getScrollX();
        this.plb.a(this, false);
        this.OST = false;
        this.mScroller.startScroll(scrollX, 0, -scrollX, 0, 100);
        invalidate();
        AppMethodBeat.o(142147);
    }

    private void gLb() {
        AppMethodBeat.i(142148);
        int scrollX = getScrollX();
        int width = getChildAt(1).getWidth();
        int i2 = width - scrollX;
        if (scrollX > width / 2) {
            this.plb.a(this, true);
            this.OST = true;
            this.mScroller.startScroll(scrollX, 0, i2, 0, 100);
        } else {
            this.OST = false;
            this.plb.a(this, false);
            this.mScroller.startScroll(scrollX, 0, -scrollX, 0, 100);
        }
        invalidate();
        AppMethodBeat.o(142148);
    }

    public void computeScroll() {
        AppMethodBeat.i(142149);
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
        }
        AppMethodBeat.o(142149);
    }

    public Bitmap getDrawingCache() {
        return null;
    }

    public Bitmap getDrawingCache(boolean z) {
        return null;
    }

    public void buildDrawingCache(boolean z) {
    }

    public void buildDrawingCache() {
    }

    /* access modifiers changed from: package-private */
    public class b implements Runnable {
        b() {
        }

        public final void run() {
            AppMethodBeat.i(142133);
            Log.v("MicroMsg.MMSlideDelView", "checkfortap");
            MMSlideDelView.this.setPressed(true);
            AppMethodBeat.o(142133);
        }
    }

    class h {
        int OTb;

        private h() {
        }

        /* synthetic */ h(MMSlideDelView mMSlideDelView, byte b2) {
            this();
        }
    }

    class a extends h implements Runnable {
        private a() {
            super(MMSlideDelView.this, (byte) 0);
        }

        /* synthetic */ a(MMSlideDelView mMSlideDelView, byte b2) {
            this();
        }

        public final void run() {
            boolean z;
            AppMethodBeat.i(142132);
            if (!MMSlideDelView.this.hasWindowFocus() || MMSlideDelView.c(MMSlideDelView.this) != this.OTb) {
                z = false;
            } else {
                z = true;
            }
            if (z && !MMSlideDelView.this.pPO) {
                Log.i("MicroMsg.MMSlideDelView", "is long press");
                if (MMSlideDelView.this.getParent() != null) {
                    MMSlideDelView.this.OSX = true;
                    MMSlideDelView.this.performLongClick();
                }
            }
            AppMethodBeat.o(142132);
        }
    }
}
