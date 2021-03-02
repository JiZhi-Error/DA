package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.view.popview.AbstractPopView;

public class SmileySubGrid extends GridView {
    private volatile int LBD = -1;
    int OPg = 6;
    int RmU = -1;
    boolean RmV;
    private AbstractPopView RmW;
    private c RmX;
    private int RmY;
    private a RmZ;
    private b Rna;
    private View Rnb;
    private boolean Rnc = false;
    private MTimerHandler Rnd = null;
    private volatile boolean Rne = false;
    public boolean Rnf = true;
    private final Object Rng = new Object();
    Rect amS = new Rect();
    int amX;
    private int anJ;
    int ayc;
    private MMHandler mHandler = new MMHandler();
    private int mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    private WindowManager mWindowManager;
    float riK;
    float riL;
    private boolean rnp;

    static /* synthetic */ void a(SmileySubGrid smileySubGrid, View view, int i2) {
        AppMethodBeat.i(184699);
        smileySubGrid.aY(view, i2);
        AppMethodBeat.o(184699);
    }

    static /* synthetic */ int c(SmileySubGrid smileySubGrid) {
        AppMethodBeat.i(105242);
        int windowAttachCount = smileySubGrid.getWindowAttachCount();
        AppMethodBeat.o(105242);
        return windowAttachCount;
    }

    static /* synthetic */ int d(SmileySubGrid smileySubGrid) {
        AppMethodBeat.i(183932);
        int windowAttachCount = smileySubGrid.getWindowAttachCount();
        AppMethodBeat.o(183932);
        return windowAttachCount;
    }

    public SmileySubGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(105228);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.anJ = getLongTouchTime();
        this.RmY = ViewConfiguration.getPressedStateDuration();
        AppMethodBeat.o(105228);
    }

    private void aY(final View view, int i2) {
        AppMethodBeat.i(105230);
        if (i2 != this.LBD) {
            Log.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks begin show:%d", Integer.valueOf(i2));
            Object item = getAdapter().getItem(i2);
            if (this.RmW == null) {
                this.RmW = com.tencent.mm.view.popview.c.b(getContext(), item);
                this.mWindowManager.addView(this.RmW, this.RmW.getWindowLayoutParams());
                this.RmW.setVisibility(4);
            }
            es(item);
            this.mWindowManager.updateViewLayout(this.RmW, this.RmW.getWindowLayoutParams());
            this.RmW.post(new Runnable() {
                /* class com.tencent.mm.view.SmileySubGrid.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(183931);
                    if (SmileySubGrid.this.RmW != null) {
                        SmileySubGrid.this.RmW.setVisibility(0);
                        SmileySubGrid.this.RmW.hI(view);
                        SmileySubGrid.this.mWindowManager.updateViewLayout(SmileySubGrid.this.RmW, SmileySubGrid.this.RmW.getWindowLayoutParams());
                    }
                    AppMethodBeat.o(183931);
                }
            });
        } else {
            Log.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks already show:%d", Integer.valueOf(i2));
        }
        this.LBD = i2;
        AppMethodBeat.o(105230);
    }

    public final void hfZ() {
        AppMethodBeat.i(105233);
        if (this.RmX != null) {
            this.mHandler.removeCallbacks(this.RmX);
        }
        if (this.RmW != null) {
            this.mWindowManager.removeView(this.RmW);
            this.RmW = null;
            this.rnp = false;
            this.Rne = false;
        }
        this.LBD = -1;
        AppMethodBeat.o(105233);
    }

    public void setViewParent(View view) {
        this.Rnb = view;
    }

    private void hG(View view) {
        AppMethodBeat.i(105234);
        Rect rect = this.amS;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        S(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.RmV;
        if (view.isEnabled() != z) {
            this.RmV = !z;
            refreshDrawableState();
        }
        AppMethodBeat.o(105234);
    }

    private void S(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(105235);
        this.amS.set(i2 - getPaddingLeft(), i3 - getPaddingTop(), getPaddingRight() + i4, getPaddingBottom() + i5);
        AppMethodBeat.o(105235);
    }

    class d {
        private int OTb;

        private d() {
        }

        /* synthetic */ d(SmileySubGrid smileySubGrid, byte b2) {
            this();
        }

        public final void gWv() {
            AppMethodBeat.i(105226);
            this.OTb = SmileySubGrid.c(SmileySubGrid.this);
            AppMethodBeat.o(105226);
        }

        public final boolean gWw() {
            AppMethodBeat.i(105227);
            if (!SmileySubGrid.this.hasWindowFocus() || SmileySubGrid.d(SmileySubGrid.this) != this.OTb) {
                AppMethodBeat.o(105227);
                return false;
            }
            AppMethodBeat.o(105227);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements Runnable {
        final /* synthetic */ SmileySubGrid Rnh;

        public final void run() {
            AppMethodBeat.i(105225);
            if (!this.Rnh.rnp) {
                this.Rnh.mWindowManager.addView(this.Rnh.RmW, this.Rnh.RmW.getWindowLayoutParams());
                this.Rnh.rnp = true;
            }
            AppMethodBeat.o(105225);
        }
    }

    class b extends d implements Runnable {
        View FP;
        int QkN;

        private b() {
            super(SmileySubGrid.this, (byte) 0);
        }

        /* synthetic */ b(SmileySubGrid smileySubGrid, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(105224);
            Log.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "Click run");
            ListAdapter adapter = SmileySubGrid.this.getAdapter();
            int i2 = this.QkN;
            if (adapter != null && SmileySubGrid.this.getCount() > 0 && i2 != -1 && i2 < adapter.getCount() && gWw()) {
                Log.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "PerformClick performItemClick position:[%d] id:[%d] ", Integer.valueOf(i2), Long.valueOf(adapter.getItemId(i2)));
                SmileySubGrid.this.performItemClick(this.FP, i2, adapter.getItemId(i2));
            }
            AppMethodBeat.o(105224);
        }
    }

    class a extends d implements Runnable {
        private a() {
            super(SmileySubGrid.this, (byte) 0);
        }

        /* synthetic */ a(SmileySubGrid smileySubGrid, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(105223);
            Log.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "LongPress run");
            int i2 = SmileySubGrid.this.amX;
            SmileySubGrid smileySubGrid = SmileySubGrid.this;
            View childAt = smileySubGrid.getChildAt(i2 - smileySubGrid.getFirstVisiblePosition());
            if (childAt != null) {
                int i3 = SmileySubGrid.this.amX;
                long itemId = SmileySubGrid.this.getAdapter().getItemId(SmileySubGrid.this.amX);
                if (gWw()) {
                    Log.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "CheckForLongPress performLongPress position:[%d] id:[%d]", Integer.valueOf(i3), Long.valueOf(itemId));
                    SmileySubGrid.a(SmileySubGrid.this, childAt, i2);
                    SmileySubGrid.this.ayc = -1;
                    SmileySubGrid.this.OPg = 5;
                    SmileySubGrid.this.setScrollEnable(false);
                }
            }
            AppMethodBeat.o(105223);
        }
    }

    /* access modifiers changed from: protected */
    public void setScrollEnable(boolean z) {
        AppMethodBeat.i(105236);
        Log.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "cpan t setScrollEnable:%b", Boolean.valueOf(z));
        if (this.Rnb != null) {
            if (this.Rnb instanceof MMFlipper) {
                ((MMFlipper) this.Rnb).setScrollEnable(z);
                AppMethodBeat.o(105236);
                return;
            } else if (this.Rnb instanceof CustomViewPager) {
                ((CustomViewPager) this.Rnb).setCanSlide(z);
            }
        }
        AppMethodBeat.o(105236);
    }

    /* access modifiers changed from: protected */
    public int getLongTouchTime() {
        AppMethodBeat.i(105237);
        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
        AppMethodBeat.o(105237);
        return longPressTimeout;
    }

    public void setIsShowPopWin(boolean z) {
        this.Rnf = z;
    }

    private void es(Object obj) {
        AppMethodBeat.i(105238);
        synchronized (this.Rng) {
            try {
                if (this.RmW != null) {
                    com.tencent.mm.view.popview.c.a(this.RmW, obj);
                } else {
                    Log.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "mPopImageView is null.");
                }
            } finally {
                AppMethodBeat.o(105238);
            }
        }
    }

    public void setFromDetail(boolean z) {
        this.Rnc = z;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(105240);
        super.onDetachedFromWindow();
        hfZ();
        AppMethodBeat.o(105240);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        View childAt;
        View childAt2;
        View view = null;
        AppMethodBeat.i(105229);
        if (!this.Rnf) {
            hfZ();
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(105229);
            return onTouchEvent;
        }
        int action = motionEvent.getAction();
        switch (action) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                this.riK = (float) x;
                this.riL = (float) y;
                int pointToPosition = pointToPosition(x, y);
                if (pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
                    this.ayc = 0;
                }
                if (pointToPosition >= 0) {
                    this.RmU = pointToPosition;
                    view = getChildAt(pointToPosition - getFirstVisiblePosition());
                }
                if (view != null) {
                    view.setPressed(true);
                    view.setSelected(true);
                    hG(view);
                }
                if (this.RmZ == null) {
                    this.RmZ = new a(this, (byte) 0);
                }
                this.RmZ.gWv();
                this.amX = pointToPosition;
                if (pointToPosition >= 0 && (getAdapter() instanceof com.tencent.mm.view.a.a)) {
                    getAdapter();
                    this.mHandler.postDelayed(this.RmZ, (long) this.anJ);
                }
                if (pointToPosition >= 0 && (getAdapter() instanceof com.tencent.mm.view.a.a)) {
                    getAdapter();
                    break;
                }
            case 1:
            case 3:
                int i2 = this.amX;
                View childAt3 = getChildAt(i2 - getFirstVisiblePosition());
                if (action == 1 && this.ayc != -1) {
                    if (this.Rna == null) {
                        this.Rna = new b(this, (byte) 0);
                    }
                    b bVar = this.Rna;
                    bVar.FP = childAt3;
                    bVar.QkN = i2;
                    bVar.gWv();
                    this.mHandler.post(bVar);
                }
                if (this.Rnd != null) {
                    this.Rnd.stopTimer();
                    this.Rnd = null;
                }
                this.mHandler.removeCallbacks(this.RmZ);
                setScrollEnable(true);
                hfZ();
                if (this.RmU >= 0 && (childAt = getChildAt(this.RmU - getFirstVisiblePosition())) != null) {
                    childAt.setPressed(false);
                    childAt.setSelected(false);
                    hG(childAt);
                }
                this.OPg = 6;
                break;
            case 2:
                int x2 = (int) motionEvent.getX();
                int y2 = (int) motionEvent.getY();
                if (this.OPg != 5) {
                    if (Math.abs(this.riK - ((float) x2)) > ((float) this.mTouchSlop)) {
                        this.ayc = -1;
                        this.mHandler.removeCallbacks(this.RmZ);
                    }
                    hfZ();
                    break;
                } else {
                    int pointToPosition2 = pointToPosition(x2, y2);
                    this.amX = pointToPosition2;
                    if (pointToPosition2 < 0 || !(getAdapter() instanceof com.tencent.mm.view.a.a)) {
                        hfZ();
                        if (this.RmU >= 0 && (childAt2 = getChildAt(this.RmU - getFirstVisiblePosition())) != null) {
                            childAt2.setPressed(false);
                            childAt2.setSelected(false);
                            hG(childAt2);
                        }
                    } else {
                        getAdapter();
                        if (this.RmU != pointToPosition2) {
                            this.RmU = pointToPosition2;
                            View childAt4 = getChildAt(pointToPosition2 - getFirstVisiblePosition());
                            layoutChildren();
                            if (childAt4 != null) {
                                childAt4.setPressed(true);
                                childAt4.setSelected(true);
                                hG(childAt4);
                                aY(childAt4, this.RmU);
                            }
                        }
                    }
                    this.mHandler.removeCallbacks(this.RmZ);
                    break;
                }
                break;
        }
        AppMethodBeat.o(105229);
        return true;
    }
}
