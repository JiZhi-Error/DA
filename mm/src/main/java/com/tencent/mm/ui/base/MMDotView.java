package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ae.a;
import com.tencent.mm.sdk.platformtools.Log;

public class MMDotView extends LinearLayout {
    private int OPQ = R.drawable.ans;
    private int OPR = R.drawable.anq;
    private int maxCount = 9;

    @TargetApi(11)
    public MMDotView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(141879);
        init(context, attributeSet);
        AppMethodBeat.o(141879);
    }

    public MMDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(141880);
        init(context, attributeSet);
        AppMethodBeat.o(141880);
    }

    private void init(Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(141881);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.MMDotView);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        setDotCount(resourceId);
        AppMethodBeat.o(141881);
    }

    public void setDarkStyle(boolean z) {
        if (z) {
            this.OPQ = R.drawable.ant;
            this.OPR = R.drawable.anr;
            return;
        }
        this.OPQ = R.drawable.ans;
        this.OPR = R.drawable.anq;
    }

    public void setInvertedStyle(boolean z) {
        if (z) {
            this.OPQ = R.drawable.anq;
            this.OPR = R.drawable.ans;
            return;
        }
        this.OPQ = R.drawable.ans;
        this.OPR = R.drawable.anq;
    }

    public void setMaxCount(int i2) {
        AppMethodBeat.i(141882);
        Log.d("MicroMsg.MMDotView", "setMaxCount:%d", Integer.valueOf(i2));
        this.maxCount = i2;
        AppMethodBeat.o(141882);
    }

    public void setDotCount(int i2) {
        AppMethodBeat.i(141883);
        Log.v("MicroMsg.MMDotView", "setDotCount:%d", Integer.valueOf(i2));
        if (i2 < 0) {
            AppMethodBeat.o(141883);
            return;
        }
        if (i2 > this.maxCount) {
            Log.i("MicroMsg.MMDotView", "large than max count");
            i2 = this.maxCount;
        }
        removeAllViews();
        while (i2 != 0) {
            ImageView imageView = (ImageView) View.inflate(getContext(), R.layout.baq, null);
            imageView.setImageResource(this.OPQ);
            addView(imageView);
            i2--;
        }
        ImageView imageView2 = (ImageView) getChildAt(0);
        if (imageView2 != null) {
            imageView2.setImageResource(this.OPR);
        }
        AppMethodBeat.o(141883);
    }

    public void setSelectedDot(int i2) {
        AppMethodBeat.i(141884);
        Log.v("MicroMsg.MMDotView", "setSelectedDot:target index is %d", Integer.valueOf(i2));
        if (i2 >= getChildCount()) {
            i2 = getChildCount() - 1;
        } else if (i2 < 0) {
            i2 = 0;
        }
        Log.v("MicroMsg.MMDotView", "setSelectedDot:after adjust index is %d", Integer.valueOf(i2));
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            ((ImageView) getChildAt(i3)).setImageResource(this.OPQ);
        }
        ImageView imageView = (ImageView) getChildAt(i2);
        if (imageView != null) {
            imageView.setImageResource(this.OPR);
        }
        AppMethodBeat.o(141884);
    }
}
