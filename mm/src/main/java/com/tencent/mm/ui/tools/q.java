package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class q implements Runnable {
    public ListView GP;
    public long QvV = System.currentTimeMillis();
    public int QvW;
    public int QvX;
    public int QvY;
    private final int QvZ;
    public int Qwa;
    public int mMode;

    public q(ListView listView) {
        AppMethodBeat.i(143221);
        this.GP = listView;
        this.QvZ = ViewConfiguration.get(this.GP.getContext()).getScaledFadingEdgeLength();
        Log.d("ScrollerRunnable", "mExtraScroll: %d", Integer.valueOf(this.QvZ));
        AppMethodBeat.o(143221);
    }

    public final void run() {
        int paddingTop;
        int paddingBottom;
        AppMethodBeat.i(143222);
        if (System.currentTimeMillis() - this.QvV > 10000) {
            AppMethodBeat.o(143222);
            return;
        }
        int height = this.GP.getHeight();
        int firstVisiblePosition = this.GP.getFirstVisiblePosition();
        switch (this.mMode) {
            case 1:
                int childCount = this.GP.getChildCount() - 1;
                int i2 = firstVisiblePosition + childCount;
                if (childCount < 0) {
                    AppMethodBeat.o(143222);
                    return;
                }
                if (i2 == this.QvX) {
                    if (this.Qwa > 20) {
                        this.GP.setSelection(this.QvW);
                        Log.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
                    } else {
                        this.GP.post(this);
                        this.Qwa++;
                        Log.d("ScrollerRunnable", "dz:try scroll lastpos = %d", Integer.valueOf(i2));
                        AppMethodBeat.o(143222);
                        return;
                    }
                }
                this.Qwa = 0;
                View childAt = this.GP.getChildAt(childCount);
                int height2 = childAt.getHeight();
                int top = height - childAt.getTop();
                if (i2 < this.GP.getCount() - 1) {
                    paddingBottom = this.QvZ;
                } else {
                    paddingBottom = this.GP.getPaddingBottom();
                }
                this.GP.smoothScrollBy(paddingBottom + (height2 - top), this.QvY);
                this.QvX = i2;
                if (i2 < this.QvW) {
                    this.GP.post(this);
                    AppMethodBeat.o(143222);
                    return;
                }
                break;
            case 2:
                if (firstVisiblePosition == this.QvX) {
                    if (this.Qwa > 20) {
                        this.GP.setSelection(this.QvW);
                        Log.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
                    } else {
                        this.GP.post(this);
                        this.Qwa++;
                        Log.d("ScrollerRunnable", "dz:try scroll firstPos = %d", Integer.valueOf(firstVisiblePosition));
                        AppMethodBeat.o(143222);
                        return;
                    }
                }
                this.Qwa = 0;
                View childAt2 = this.GP.getChildAt(0);
                if (childAt2 != null) {
                    int top2 = childAt2.getTop();
                    if (firstVisiblePosition > 0) {
                        paddingTop = this.QvZ;
                    } else {
                        paddingTop = this.GP.getPaddingTop();
                    }
                    this.GP.smoothScrollBy(top2 - paddingTop, this.QvY);
                    this.QvX = firstVisiblePosition;
                    if (firstVisiblePosition > this.QvW) {
                        this.GP.post(this);
                        break;
                    }
                } else {
                    AppMethodBeat.o(143222);
                    return;
                }
                break;
        }
        AppMethodBeat.o(143222);
    }
}
