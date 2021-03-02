package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class GameCenterListView extends ListView {
    static boolean xPA;
    static int xPC;
    private View agA;
    private Context mContext;
    private Scroller mScroller;
    private int rZ;
    private boolean xPB;
    private ImageView xPD;
    private ImageView xPE;
    private boolean xPx;
    private float xPy;
    private boolean xPz;

    public GameCenterListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(41944);
        super.onFinishInflate();
        this.rZ = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
        this.mScroller = new Scroller(this.mContext);
        super.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.game.ui.GameCenterListView.AnonymousClass1 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                AppMethodBeat.i(41943);
                if (i2 == 0 && GameCenterListView.this.agA != null && GameCenterListView.this.agA.getTop() == 0) {
                    GameCenterListView.this.xPz = true;
                    AppMethodBeat.o(41943);
                    return;
                }
                GameCenterListView.this.xPz = false;
                AppMethodBeat.o(41943);
            }
        });
        AppMethodBeat.o(41944);
    }

    public static void setCanPulldown(boolean z) {
        xPA = z;
    }

    public static void setDefaultPadding(int i2) {
        xPC = i2;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(41945);
        super.onLayout(z, i2, i3, i4, i5);
        if (z && !this.xPx) {
            this.agA = getChildAt(0);
            this.xPE = (ImageView) this.agA.findViewById(R.id.ht0);
            this.xPD = (ImageView) this.agA.findViewById(R.id.a3g);
            this.xPx = true;
        }
        AppMethodBeat.o(41945);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(41946);
        if (!xPA || this.agA == null) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(41946);
            return dispatchTouchEvent;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.xPB = false;
                this.xPy = motionEvent.getRawY();
                break;
            case 2:
                if (this.xPz) {
                    if (this.xPB) {
                        AppMethodBeat.o(41946);
                        return true;
                    }
                    int rawY = (int) (motionEvent.getRawY() - this.xPy);
                    if (this.agA.getPaddingTop() <= xPC + this.rZ) {
                        if (rawY > 0 && Math.abs(rawY) >= this.rZ) {
                            this.xPB = true;
                            this.mScroller.startScroll(0, this.agA.getPaddingTop(), 0, -this.agA.getPaddingTop(), 500);
                            this.xPD.setClickable(true);
                            invalidate();
                            motionEvent.setAction(3);
                            super.dispatchTouchEvent(motionEvent);
                            AppMethodBeat.o(41946);
                            return true;
                        }
                    } else if (this.agA.getPaddingTop() >= (-this.rZ) && rawY < 0 && Math.abs(rawY) >= this.rZ) {
                        this.xPB = true;
                        this.mScroller.startScroll(0, 0, 0, xPC, 500);
                        invalidate();
                        motionEvent.setAction(3);
                        super.dispatchTouchEvent(motionEvent);
                        AppMethodBeat.o(41946);
                        return true;
                    }
                }
                break;
        }
        boolean dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(41946);
        return dispatchTouchEvent2;
    }

    public void computeScroll() {
        AppMethodBeat.i(41947);
        if (this.agA == null) {
            AppMethodBeat.o(41947);
            return;
        }
        if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            this.agA.setPadding(0, currY, 0, 0);
            float f2 = (((float) (xPC - currY)) / ((float) xPC)) * 255.0f;
            this.xPE.setAlpha(255 - ((int) f2));
            this.xPD.setAlpha((int) f2);
            invalidate();
        }
        AppMethodBeat.o(41947);
    }
}
