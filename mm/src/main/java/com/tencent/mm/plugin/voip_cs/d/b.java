package com.tencent.mm.plugin.voip_cs.d;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

public final class b {
    public int[] HeN;
    public int HeO;
    public int HeP;
    public TextView Ws;
    public MTimerHandler cve = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.voip_cs.d.b.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(125488);
            int i2 = b.this.HeN[b.this.HeP % b.this.HeN.length];
            if (b.this.Ws != null) {
                if (-1 == i2) {
                    b.this.Ws.setText((CharSequence) null);
                } else {
                    b.this.Ws.setText(i2);
                }
            }
            b.this.HeP++;
            AppMethodBeat.o(125488);
            return true;
        }
    }, true);

    public b() {
        AppMethodBeat.i(125489);
        AppMethodBeat.o(125489);
    }

    public final void fJB() {
        AppMethodBeat.i(125490);
        if (this.cve != null) {
            this.cve.stopTimer();
        }
        Log.printDebugStack("MicroMsg.DynamicTextWrap", "stop textview: " + this.Ws, new Object[0]);
        this.Ws = null;
        AppMethodBeat.o(125490);
    }
}
