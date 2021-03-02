package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AutoBottomScrollView extends ScrollView {
    public AutoBottomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AutoBottomScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(109756);
        super.onSizeChanged(i2, i3, i4, i5);
        postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.account.bind.ui.AutoBottomScrollView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(109755);
                AutoBottomScrollView.this.smoothScrollTo(0, AutoBottomScrollView.this.getBottom());
                AppMethodBeat.o(109755);
            }
        }, 100);
        AppMethodBeat.o(109756);
    }
}
