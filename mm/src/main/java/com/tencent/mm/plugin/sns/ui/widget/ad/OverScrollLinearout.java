package com.tencent.mm.plugin.sns.ui.widget.ad;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public class OverScrollLinearout extends LinearLayout {
    private int Eki;
    private a FfW;
    private int FfX;
    private int FfY;
    private Scroller mScroller;
    private boolean nak;
    private int nrL;

    public interface a {
        void bV(float f2);

        void fdL();

        boolean fel();
    }

    public OverScrollLinearout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(204017);
        init(context);
        AppMethodBeat.o(204017);
    }

    public OverScrollLinearout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(204018);
        init(context);
        AppMethodBeat.o(204018);
    }

    private void init(Context context) {
        AppMethodBeat.i(204019);
        this.mScroller = new Scroller(context);
        this.FfX = ViewConfiguration.get(context).getScaledTouchSlop();
        AppMethodBeat.o(204019);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(204020);
        int action = motionEvent.getAction();
        int y = (int) motionEvent.getY();
        int rawY = (int) motionEvent.getRawY();
        if (action == 0) {
            this.nak = false;
            this.Eki = y;
            this.nrL = this.Eki;
            this.FfY = rawY;
            if (this.FfW != null) {
                this.FfW.fdL();
            }
        } else if (action == 2) {
            if (this.FfW != null && this.FfW.fel() && this.FfY - rawY >= this.FfX) {
                this.nak = true;
            }
        } else if (action == 1 || action == 3) {
            this.mScroller.forceFinished(true);
            int scrollY = getScrollY();
            if (scrollY != 0) {
                this.mScroller.startScroll(0, scrollY, 0, -scrollY, 300);
                invalidate();
            }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(204020);
        return dispatchTouchEvent;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.nak;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(204021);
        int y = (int) motionEvent.getY();
        if (this.FfW != null) {
            this.FfW.bV((float) (this.nrL - y));
        }
        this.nrL = y;
        boolean z = this.nak;
        AppMethodBeat.o(204021);
        return z;
    }

    public void setOnScrollActionListener(a aVar) {
        this.FfW = aVar;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(204022);
        super.onDraw(canvas);
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(0, this.mScroller.getCurrY());
            invalidate();
        }
        AppMethodBeat.o(204022);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(final int i2, final int i3, final int i4, final int i5) {
        AppMethodBeat.i(204023);
        super.onScrollChanged(i2, i3, i4, i5);
        postOnAnimation(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(204016);
                Log.w("OverScrollLinearout", "the onScrollChanged: l is " + i2 + ", t is " + i3 + ", old l is " + i4 + ", oldt is " + i5);
                uy uyVar = new uy();
                uyVar.ebn.scrollX = i2;
                uyVar.ebn.scrollY = i3;
                uyVar.ebn.ebp = i4;
                uyVar.ebn.ebo = i5;
                EventCenter.instance.publish(uyVar);
                AppMethodBeat.o(204016);
            }
        });
        AppMethodBeat.o(204023);
    }
}
