package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.base.MMPullDownView;

public class CollectPullDownView extends MMPullDownView {
    public CollectPullDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CollectPullDownView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.ui.base.MMPullDownView
    public final void cAG() {
        AppMethodBeat.i(64191);
        View inflate = inflate(this.context, R.layout.v1, null);
        View inflate2 = inflate(this.context, R.layout.v1, null);
        addView(inflate, 0, new FrameLayout.LayoutParams(-1, a.fromDPToPix(this.context, 48)));
        addView(inflate2, new FrameLayout.LayoutParams(-1, a.fromDPToPix(this.context, 48)));
        AppMethodBeat.o(64191);
    }

    public void setLoadDataEnd(boolean z) {
        this.OSc = z;
    }
}
