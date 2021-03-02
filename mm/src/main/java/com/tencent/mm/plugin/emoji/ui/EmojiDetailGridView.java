package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.SmileySubGrid;

public class EmojiDetailGridView extends SmileySubGrid {
    private String rcD;
    private EmojiDetailScrollView rgr;
    private volatile boolean rgs = true;

    public EmojiDetailGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(108927);
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        AppMethodBeat.o(108927);
    }

    @Override // com.tencent.mm.view.SmileySubGrid
    public void setScrollEnable(boolean z) {
        AppMethodBeat.i(108928);
        if (this.rgr != null) {
            this.rgr.setScrollEnable(z);
        }
        AppMethodBeat.o(108928);
    }

    public void setEmojiDetailScrollView(EmojiDetailScrollView emojiDetailScrollView) {
        this.rgr = emojiDetailScrollView;
    }

    @Override // com.tencent.mm.view.SmileySubGrid
    public int getLongTouchTime() {
        return 200;
    }

    public String getProductId() {
        return this.rcD;
    }

    public void setProductId(String str) {
        this.rcD = str;
    }
}
