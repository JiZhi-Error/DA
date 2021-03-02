package com.tencent.mm.plugin.wallet_payu.remittance.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.a.a;
import com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceAdapterUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.d;

public class g extends a {
    @Override // com.tencent.mm.plugin.remittance.a.a, com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72178);
        Log.d("MicroMsg.PayURemittanceProcess", "start Process : PayURemittanceProcess");
        b(activity, PayURemittanceAdapterUI.class, bundle);
        AppMethodBeat.o(72178);
        return this;
    }
}
