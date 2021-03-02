package com.tencent.mm.plugin.websearch.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;

public class WebSearchDotPercentIndicator extends LinearLayout {
    private int mDG;
    private LayoutInflater mInflater;

    public WebSearchDotPercentIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(110220);
        init(context);
        AppMethodBeat.o(110220);
    }

    public WebSearchDotPercentIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(110221);
        init(context);
        AppMethodBeat.o(110221);
    }

    private void init(Context context) {
        AppMethodBeat.i(110222);
        this.mInflater = LayoutInflater.from(context);
        AppMethodBeat.o(110222);
    }

    public void setDotsNum(int i2) {
        AppMethodBeat.i(110223);
        if (i2 <= 1) {
            i2 = 8;
        }
        this.mDG = i2;
        removeAllViews();
        for (int i3 = 0; i3 < this.mDG; i3++) {
            addView((ImageView) this.mInflater.inflate(R.layout.ao0, (ViewGroup) this, false));
        }
        AppMethodBeat.o(110223);
    }

    public void setPercent(float f2) {
        float f3 = 1.0f;
        float f4 = 0.0f;
        AppMethodBeat.i(110224);
        if (f2 >= 0.0f) {
            f4 = f2;
        }
        if (f4 <= 1.0f) {
            f3 = f4;
        }
        int rint = (int) Math.rint((double) (((float) this.mDG) * f3));
        Log.v("MicroMsg.AppBrandDotPercentIndicator", "setPercent percent:%s dotsOnNum:%d", Float.valueOf(f3), Integer.valueOf(rint));
        int i2 = 0;
        while (i2 < rint && i2 < getChildCount()) {
            ((ImageView) getChildAt(i2)).setImageResource(R.drawable.a5a);
            i2++;
        }
        while (i2 < getChildCount()) {
            ((ImageView) getChildAt(i2)).setImageResource(R.drawable.a5_);
            i2++;
        }
        AppMethodBeat.o(110224);
    }
}
