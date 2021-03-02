package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.ui.widget.a;

public final class af implements View.OnTouchListener {
    private static q Esx;
    private static TextView Esy;
    private static a VaS;

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009a, code lost:
        if (r6 > (((com.tencent.mm.kiss.widget.textview.PLSysTextView) r13).getVerticalDrawOffset() + r2.getHeight())) goto L_0x009c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
        /*
        // Method dump skipped, instructions count: 480
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.af.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public static void ffX() {
        AppMethodBeat.i(97958);
        if (Esx != null) {
            Esx.setIsPressed(false);
            Esy.invalidate();
            Esy = null;
            Esx = null;
        }
        if (VaS != null) {
            VaS.setIsPressed(false);
            Esy.invalidate();
            Esy = null;
            VaS = null;
        }
        AppMethodBeat.o(97958);
    }
}
