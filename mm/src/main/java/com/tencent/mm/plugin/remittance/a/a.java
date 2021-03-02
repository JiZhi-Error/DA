package com.tencent.mm.plugin.remittance.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.d;

public class a extends d {
    @Override // com.tencent.mm.wallet_core.d
    public d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(67333);
        Log.d("MicroMsg.RemittanceProcess", "start Process : RemittanceProcess");
        b(activity, RemittanceAdapterUI.class, bundle);
        AppMethodBeat.o(67333);
        return this;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(67334);
        super.bA(activity);
        AppMethodBeat.o(67334);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(67335);
        P(activity);
        AppMethodBeat.o(67335);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "RemittanceProcess";
    }
}
