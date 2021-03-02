package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMAnimateView;

public class BannerEmojiView extends MMAnimateView {
    public BannerEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BannerEmojiView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(104703);
        int right = ((getRight() - getLeft()) - getPaddingRight()) - getPaddingLeft();
        int i4 = right / 2;
        if (right == 0 || i4 == 0) {
            right = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        float f2 = 0.53333336f;
        Drawable drawable = getDrawable();
        if (drawable != null && drawable.getIntrinsicHeight() > 0 && drawable.getIntrinsicWidth() > 0) {
            f2 = (1.0f * ((float) drawable.getIntrinsicHeight())) / ((float) drawable.getIntrinsicWidth());
        }
        setMeasuredDimension(right, (int) (f2 * ((float) right)));
        AppMethodBeat.o(104703);
    }
}
