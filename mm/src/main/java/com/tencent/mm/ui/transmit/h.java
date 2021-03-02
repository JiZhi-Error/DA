package com.tencent.mm.ui.transmit;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.q;

public final class h {
    boolean QAD = false;
    a QAE;
    Context context;
    Runnable lNe = new Runnable() {
        /* class com.tencent.mm.ui.transmit.h.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(39487);
            if (h.this.tipDialog != null) {
                h.this.tipDialog.dismiss();
            }
            h.this.bXo();
            AppMethodBeat.o(39487);
        }
    };
    boolean nUP;
    boolean nUQ;
    boolean nUR;
    int nUS;
    String text;
    q tipDialog;

    /* access modifiers changed from: package-private */
    public interface a {
        void e(boolean z, String str, boolean z2);
    }

    public h(Context context2) {
        AppMethodBeat.i(39488);
        this.context = context2;
        AppMethodBeat.o(39488);
    }

    public final void gYw() {
        AppMethodBeat.i(234537);
        this.nUQ = true;
        if (rS()) {
            MMHandlerThread.removeRunnable(this.lNe);
            bXo();
        }
        AppMethodBeat.o(234537);
    }

    public final void a(boolean z, String str, int i2, boolean z2) {
        AppMethodBeat.i(234538);
        this.nUP = true;
        this.nUR = z;
        this.text = str;
        this.nUS = i2;
        this.QAD = z2;
        if (rS()) {
            bXo();
            AppMethodBeat.o(234538);
            return;
        }
        if (z) {
            this.tipDialog = com.tencent.mm.ui.base.h.a(this.context, this.context.getString(R.string.gkk), true, (DialogInterface.OnCancelListener) null);
            MMHandlerThread.postToMainThreadDelayed(this.lNe, 5000);
        }
        AppMethodBeat.o(234538);
    }

    private boolean rS() {
        return this.nUP & this.nUQ;
    }

    public final void bXo() {
        AppMethodBeat.i(39489);
        if (this.QAE != null) {
            this.QAE.e(this.nUR, this.text, this.QAD);
        }
        AppMethodBeat.o(39489);
    }
}
