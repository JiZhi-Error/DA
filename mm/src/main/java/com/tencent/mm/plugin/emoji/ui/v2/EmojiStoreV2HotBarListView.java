package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class EmojiStoreV2HotBarListView extends ListView {
    public EmojiStoreV2HotBarListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public EmojiStoreV2HotBarListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(109189);
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        AppMethodBeat.o(109189);
    }
}
