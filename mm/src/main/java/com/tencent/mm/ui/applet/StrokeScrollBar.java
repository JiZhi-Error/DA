package com.tencent.mm.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.VerticalScrollBar;

public class StrokeScrollBar extends VerticalScrollBar {
    @Override // com.tencent.mm.ui.base.VerticalScrollBar
    public final void ann() {
        AppMethodBeat.i(33837);
        this.yuX = new String[18];
        for (int i2 = 0; i2 < this.yuX.length; i2++) {
            this.yuX[i2] = Integer.toString(i2 + 3) + "劃";
        }
        this.yuV = 2.0f;
        this.yuW = 79;
        AppMethodBeat.o(33837);
    }

    public StrokeScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.ui.base.VerticalScrollBar
    public int getToastLayoutId() {
        return R.layout.bsg;
    }
}
