package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class SnsAdNativeLandingPagesScrollView extends NestedScrollView {
    private int Exn = 0;
    private int Exo = 0;
    private int Exp = 50;
    private az Exq = null;
    private long Exr = System.currentTimeMillis();
    private Runnable Exs = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesScrollView.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(98316);
            int scrollY = SnsAdNativeLandingPagesScrollView.this.getScrollY();
            Log.w("SnsAdNativeLandingPagesScrollView", "1 middlePos %d, newPos %d", Integer.valueOf(SnsAdNativeLandingPagesScrollView.this.Exo), Integer.valueOf(scrollY));
            if (scrollY != SnsAdNativeLandingPagesScrollView.this.Exo) {
                if (SnsAdNativeLandingPagesScrollView.this.Exq != null) {
                    az unused = SnsAdNativeLandingPagesScrollView.this.Exq;
                    int unused2 = SnsAdNativeLandingPagesScrollView.this.Exn;
                }
                SnsAdNativeLandingPagesScrollView.this.Exr = System.currentTimeMillis();
            }
            if (SnsAdNativeLandingPagesScrollView.this.Exo - scrollY == 0) {
                if (SnsAdNativeLandingPagesScrollView.this.Exq != null) {
                    az unused3 = SnsAdNativeLandingPagesScrollView.this.Exq;
                    int unused4 = SnsAdNativeLandingPagesScrollView.this.Exo;
                    int unused5 = SnsAdNativeLandingPagesScrollView.this.Exn;
                }
                SnsAdNativeLandingPagesScrollView.this.Exn = SnsAdNativeLandingPagesScrollView.this.Exo;
            }
            SnsAdNativeLandingPagesScrollView.this.Exo = SnsAdNativeLandingPagesScrollView.this.getScrollY();
            Log.w("SnsAdNativeLandingPagesScrollView", "2 middlePos %d, newPos %d", Integer.valueOf(SnsAdNativeLandingPagesScrollView.this.Exo), Integer.valueOf(scrollY));
            SnsAdNativeLandingPagesScrollView.this.postDelayed(SnsAdNativeLandingPagesScrollView.this.Exs, (long) SnsAdNativeLandingPagesScrollView.this.Exp);
            AppMethodBeat.o(98316);
        }
    };

    public SnsAdNativeLandingPagesScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(98317);
        AppMethodBeat.o(98317);
    }

    public SnsAdNativeLandingPagesScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(98318);
        AppMethodBeat.o(98318);
    }

    public void setScrollViewListener(az azVar) {
        this.Exq = azVar;
    }

    @Override // android.support.v4.widget.NestedScrollView
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(98319);
        super.onScrollChanged(i2, i3, i4, i5);
        Log.w("SnsAdNativeLandingPagesScrollView", "onScrollChanged x %d,y %d,oldx %d,oldy %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        AppMethodBeat.o(98319);
    }

    @Override // android.support.v4.widget.NestedScrollView
    public void scrollTo(int i2, int i3) {
        AppMethodBeat.i(98320);
        super.scrollTo(i2, i3);
        AppMethodBeat.o(98320);
    }

    public void scrollBy(int i2, int i3) {
        AppMethodBeat.i(98321);
        super.scrollBy(i2, i3);
        AppMethodBeat.o(98321);
    }

    @Override // android.support.v4.widget.NestedScrollView
    public final void fling(int i2) {
        AppMethodBeat.i(98322);
        super.fling(i2 / 3);
        AppMethodBeat.o(98322);
    }

    @Override // android.support.v4.widget.NestedScrollView
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(98323);
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(98323);
        return onInterceptTouchEvent;
    }
}
