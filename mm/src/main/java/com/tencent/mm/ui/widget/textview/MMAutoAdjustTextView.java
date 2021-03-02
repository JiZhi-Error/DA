package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a;
import com.tencent.mm.ui.at;

public class MMAutoAdjustTextView extends TextView {
    private float scale;
    private float textSize;
    private Paint yt;

    public MMAutoAdjustTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(159842);
        d(context.obtainStyledAttributes(attributeSet, a.C0296a.MMAutoAdjustTextView));
        init();
        AppMethodBeat.o(159842);
    }

    public MMAutoAdjustTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(159843);
        d(context.obtainStyledAttributes(attributeSet, a.C0296a.MMAutoAdjustTextView));
        init();
        AppMethodBeat.o(159843);
    }

    private void init() {
        AppMethodBeat.i(159844);
        this.textSize = getTextSize();
        this.scale = at.ez(getContext());
        this.yt = new Paint();
        this.yt.set(getPaint());
        AppMethodBeat.o(159844);
    }

    private static void d(TypedArray typedArray) {
        AppMethodBeat.i(159845);
        if (typedArray != null) {
            typedArray.recycle();
        }
        AppMethodBeat.o(159845);
    }

    private void apA(int i2) {
        AppMethodBeat.i(159846);
        if (i2 <= 0) {
            AppMethodBeat.o(159846);
            return;
        }
        while (true) {
            measure(0, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
            if (((float) getMeasuredWidth()) > ((float) i2)) {
                this.textSize -= at.getDensity(getContext());
                setTextSize(0, this.textSize * this.scale);
            } else {
                AppMethodBeat.o(159846);
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        AppMethodBeat.i(159847);
        super.onTextChanged(charSequence, i2, i3, i4);
        charSequence.toString();
        apA(getWidth());
        AppMethodBeat.o(159847);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(159848);
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            getText().toString();
            apA(i2);
        }
        AppMethodBeat.o(159848);
    }
}
