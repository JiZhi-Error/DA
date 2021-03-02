package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.EmojiStatusView;

public class PreViewEmojiView extends EmojiStatusView {
    private int mSize = 0;

    public PreViewEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PreViewEmojiView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setSize(int i2) {
        this.mSize = i2;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(104723);
        super.onMeasure(i2, i3);
        if (this.mSize > 0) {
            setMeasuredDimension(this.mSize, this.mSize);
        }
        AppMethodBeat.o(104723);
    }
}
