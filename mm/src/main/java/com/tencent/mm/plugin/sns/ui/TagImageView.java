package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.QFadeImageView;

public class TagImageView extends QFadeImageView {
    private int position = -1;

    public void setPosition(int i2) {
        this.position = i2;
    }

    public int getPosition() {
        return this.position;
    }

    public TagImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.ui.widget.QImageView
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(99700);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(99700);
    }

    @Override // com.tencent.mm.ui.widget.QImageView
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(99701);
        super.onLayout(z, i2, i3, i4, i5);
        AppMethodBeat.o(99701);
    }
}
