package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.d.b;
import com.tencent.mm.plugin.multitalk.d.c;
import com.tencent.mm.ui.base.WxImageView;

public final class d {
    public View jBN;
    public Context mContext;
    public boolean zRI = false;
    public WxImageView zRJ;
    public TextView zRK;
    public TextView zRL;
    public WxImageView zRM;
    boolean zRN = false;
    public ViewTreeObserver.OnDrawListener zRO = new ViewTreeObserver.OnDrawListener() {
        /* class com.tencent.mm.plugin.multitalk.ui.widget.d.AnonymousClass1 */

        public final void onDraw() {
            AppMethodBeat.i(164058);
            if (!d.this.zRN) {
                d.this.zRN = true;
                c.a(b.epW(), 0, 0, 0, 0, 0, 0, 0, 1, "", 0);
            }
            AppMethodBeat.o(164058);
        }
    };

    public d(Context context) {
        AppMethodBeat.i(164062);
        this.mContext = context;
        AppMethodBeat.o(164062);
    }
}
