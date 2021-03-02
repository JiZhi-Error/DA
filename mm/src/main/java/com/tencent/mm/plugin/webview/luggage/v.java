package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.d.i;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bt;
import com.tencent.mm.plugin.webview.modeltools.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public class v extends i {
    a IVh = new a();

    public v(final Activity activity) {
        super(activity);
        AppMethodBeat.i(78469);
        this.ctk = com.tencent.mm.plugin.webview.luggage.webview_impl.a.class;
        this.ctn.E(bt.dTr());
        this.cts.LA().a(new f.c() {
            /* class com.tencent.mm.plugin.webview.luggage.v.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                AppMethodBeat.i(78468);
                boolean d2 = v.this.IVh.d(activity, i2, i3, intent);
                AppMethodBeat.o(78468);
                return d2;
            }
        });
        AppMethodBeat.o(78469);
    }

    @Override // com.tencent.luggage.d.i
    public final void onResume() {
        AppMethodBeat.i(78470);
        super.onResume();
        gch();
        AppMethodBeat.o(78470);
    }

    @Override // com.tencent.luggage.d.i
    public final void Ls() {
        AppMethodBeat.i(78472);
        ((g) Ln()).gby();
        gch();
        AppMethodBeat.o(78472);
    }

    @Override // com.tencent.luggage.d.i
    public final void Lt() {
        AppMethodBeat.i(78473);
        gch();
        AppMethodBeat.o(78473);
    }

    private void gch() {
        SwipeBackLayout swipeBackLayout;
        AppMethodBeat.i(78471);
        if ((this.mContext instanceof MMActivity) && (swipeBackLayout = ((MMActivity) this.mContext).getSwipeBackLayout()) != null) {
            if (this.cts.Lx().size() <= 1) {
                swipeBackLayout.setEnableGesture(true);
                AppMethodBeat.o(78471);
                return;
            }
            swipeBackLayout.setEnableGesture(false);
        }
        AppMethodBeat.o(78471);
    }
}
