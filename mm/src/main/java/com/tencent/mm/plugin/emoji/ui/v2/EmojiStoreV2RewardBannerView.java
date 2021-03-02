package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMAnimateView;

public class EmojiStoreV2RewardBannerView extends MMAnimateView {
    private float dhh = 0.75f;

    public EmojiStoreV2RewardBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EmojiStoreV2RewardBannerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setScale(float f2) {
        this.dhh = f2;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(109243);
        int right = ((getRight() - getLeft()) - getPaddingRight()) - getPaddingLeft();
        int i4 = (int) (((float) right) * this.dhh);
        if (right == 0 || i4 == 0) {
            right = getContext().getResources().getDisplayMetrics().widthPixels;
            i4 = (int) (((float) right) * this.dhh);
        }
        setMeasuredDimension(right, i4);
        AppMethodBeat.o(109243);
    }
}
