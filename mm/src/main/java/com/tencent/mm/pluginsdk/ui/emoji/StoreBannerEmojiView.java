package com.tencent.mm.pluginsdk.ui.emoji;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMAnimateView;

public class StoreBannerEmojiView extends MMAnimateView {
    private static String TAG = "MicroMsg.emoji.StoreBannerEmojiView";

    public StoreBannerEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StoreBannerEmojiView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(104744);
        Context context = getContext();
        int[] iArr = new int[2];
        if (context instanceof Activity) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        int i4 = iArr[0];
        int i5 = ((i4 * 3) / 8) + 1;
        if (i4 <= 0 || i5 <= 0) {
            super.onMeasure(i2, i3);
            AppMethodBeat.o(104744);
            return;
        }
        setMeasuredDimension(i4, i5);
        AppMethodBeat.o(104744);
    }
}
