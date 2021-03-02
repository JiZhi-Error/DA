package com.tencent.mm.plugin.patmsg.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class PatTipWrapView extends FrameLayout {
    private View ARQ;

    public PatTipWrapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public PatTipWrapView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(207011);
        this.ARQ = View.inflate(getContext(), R.layout.bhb, null);
        AppMethodBeat.o(207011);
    }
}
