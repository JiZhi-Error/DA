package com.tencent.xweb.extension.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import org.xwalk.core.Log;

public class VideoDotPercentIndicator extends LinearLayout {
    private int mDG;
    private LayoutInflater mInflater;

    public VideoDotPercentIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(153554);
        init(context);
        AppMethodBeat.o(153554);
    }

    public VideoDotPercentIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(153555);
        init(context);
        AppMethodBeat.o(153555);
    }

    private void init(Context context) {
        AppMethodBeat.i(153556);
        this.mInflater = LayoutInflater.from(context);
        setDotsNum(0);
        AppMethodBeat.o(153556);
    }

    public void setDotsNum(int i2) {
        AppMethodBeat.i(153557);
        if (i2 <= 1) {
            i2 = 8;
        }
        this.mDG = i2;
        removeAllViews();
        for (int i3 = 0; i3 < this.mDG; i3++) {
            addView((ImageView) this.mInflater.inflate(R.layout.cd5, (ViewGroup) this, false));
        }
        AppMethodBeat.o(153557);
    }

    public void setProgress(float f2) {
        float f3 = 1.0f;
        float f4 = 0.0f;
        AppMethodBeat.i(153558);
        float f5 = f2 / 100.0f;
        if (f5 >= 0.0f) {
            f4 = f5;
        }
        if (f4 <= 1.0f) {
            f3 = f4;
        }
        int rint = (int) Math.rint((double) (((float) this.mDG) * f3));
        Log.v("MicroMsg.AppBrandDotPercentIndicator", "setPercent percent:" + f3 + " dotsOnNum:" + rint);
        int i2 = 0;
        while (i2 < rint && i2 < getChildCount()) {
            ((ImageView) getChildAt(i2)).setImageResource(R.drawable.b6v);
            i2++;
        }
        while (i2 < getChildCount()) {
            ((ImageView) getChildAt(i2)).setImageResource(R.drawable.b6u);
            i2++;
        }
        AppMethodBeat.o(153558);
    }
}
