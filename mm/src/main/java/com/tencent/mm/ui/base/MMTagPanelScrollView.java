package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;

public class MMTagPanelScrollView extends ScrollView {
    private Runnable OTH = new Runnable() {
        /* class com.tencent.mm.ui.base.MMTagPanelScrollView.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(142215);
            MMTagPanelScrollView.this.scrollTo(0, MMTagPanelScrollView.this.getBottom());
            AppMethodBeat.o(142215);
        }
    };
    private a OTI = new a((byte) 0);
    private int OTJ = 2;
    private int targetHeight = 0;

    public MMTagPanelScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142217);
        AppMethodBeat.o(142217);
    }

    public MMTagPanelScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(142218);
        AppMethodBeat.o(142218);
    }

    static class a implements Runnable {
        public MMTagPanel OTL;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(142216);
            if (this.OTL != null) {
                this.OTL.gLd();
            }
            this.OTL = null;
            AppMethodBeat.o(142216);
        }
    }

    public void setMaxLine(int i2) {
        if (i2 <= 0) {
            i2 = 1;
        }
        this.OTJ = i2;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(142219);
        super.onMeasure(i2, i3);
        if (getChildCount() <= 0) {
            AppMethodBeat.o(142219);
            return;
        }
        if (getChildAt(0) instanceof MMTagPanel) {
            MMTagPanel mMTagPanel = (MMTagPanel) getChildAt(0);
            boolean isFocused = mMTagPanel.OTr == null ? false : mMTagPanel.OTr.isFocused();
            if (mMTagPanel.getLineCount() == this.OTJ) {
                this.targetHeight = mMTagPanel.getMeasuredHeight() + getResources().getDimensionPixelOffset(R.dimen.k_);
            }
            if (mMTagPanel.getLineCount() >= this.OTJ) {
                int size = View.MeasureSpec.getSize(i2);
                int max = Math.max(0, Math.min(mMTagPanel.OOl.size(), this.OTJ));
                int paddingTop = mMTagPanel.getPaddingTop();
                for (int i4 = 0; i4 < max - 1; i4++) {
                    paddingTop += mMTagPanel.OOl.get(i4).intValue() + mMTagPanel.OOk;
                }
                int max2 = Math.max(mMTagPanel.OOl.get(max - 1).intValue() + paddingTop + mMTagPanel.getPaddingBottom(), this.targetHeight);
                Log.d("MicroMsg.FavTagPanelScrollView", "height %d", Integer.valueOf(max2));
                setMeasuredDimension(size, max2);
                if (isFocused) {
                    this.OTI.OTL = mMTagPanel;
                    removeCallbacks(this.OTI);
                    post(this.OTI);
                }
            }
        }
        AppMethodBeat.o(142219);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(142220);
        super.onLayout(z, i2, i3, i4, i5);
        scrollBy(0, i5);
        AppMethodBeat.o(142220);
    }
}
