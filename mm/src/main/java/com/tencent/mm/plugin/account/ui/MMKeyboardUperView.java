package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMKeyboardUperView extends ScrollView {
    private int defaultHeight = -1;
    private View knd;
    private Runnable kne = new Runnable() {
        /* class com.tencent.mm.plugin.account.ui.MMKeyboardUperView.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(128254);
            MMKeyboardUperView.this.fullScroll(130);
            MMKeyboardUperView.this.knd.setVisibility(4);
            AppMethodBeat.o(128254);
        }
    };
    private Runnable knf = new Runnable() {
        /* class com.tencent.mm.plugin.account.ui.MMKeyboardUperView.AnonymousClass2 */

        public final void run() {
            AppMethodBeat.i(128255);
            MMKeyboardUperView.this.knd.setVisibility(0);
            AppMethodBeat.o(128255);
        }
    };

    public MMKeyboardUperView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(128256);
        AppMethodBeat.o(128256);
    }

    public MMKeyboardUperView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(128257);
        AppMethodBeat.o(128257);
    }

    public void setupUperView(View view) {
        this.knd = view;
        this.defaultHeight = -1;
    }
}
