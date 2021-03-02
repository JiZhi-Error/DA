package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.aa;

public class AAQueryListLoadingMoreView extends LinearLayout {
    public AAQueryListLoadingMoreView(Context context) {
        super(context);
        AppMethodBeat.i(63504);
        init(context);
        AppMethodBeat.o(63504);
    }

    public AAQueryListLoadingMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(63505);
        init(context);
        AppMethodBeat.o(63505);
    }

    public AAQueryListLoadingMoreView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(63506);
        init(context);
        AppMethodBeat.o(63506);
    }

    private void init(Context context) {
        AppMethodBeat.i(63507);
        aa.jQ(context).inflate(R.layout.ad, (ViewGroup) this, true);
        AppMethodBeat.o(63507);
    }
}
