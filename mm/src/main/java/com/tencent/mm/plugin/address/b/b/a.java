package com.tencent.mm.plugin.address.b.b;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;

public final class a implements i {
    private HashSet<q> ksO;
    private HashSet<q> ksP;
    private Dialog tipDialog;

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(20764);
        if (this.ksP.contains(qVar)) {
            this.ksP.remove(qVar);
            Log.d("MicroMsg.InvoiceNetSceneMgr", "has find scene ");
        } else if (this.ksO.contains(qVar)) {
            this.ksO.remove(qVar);
            Log.d("MicroMsg.InvoiceNetSceneMgr", "has find forcescenes ");
        }
        if (this.ksP.isEmpty() && this.ksO.isEmpty() && this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        AppMethodBeat.o(20764);
    }
}
