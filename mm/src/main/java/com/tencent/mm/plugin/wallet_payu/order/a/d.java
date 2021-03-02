package com.tencent.mm.plugin.wallet_payu.order.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.a.a;
import com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderDetailUI;
import com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderRecordListUI;
import com.tencent.mm.sdk.platformtools.Log;

public class d extends a {
    @Override // com.tencent.mm.plugin.order.a.a, com.tencent.mm.wallet_core.d
    public final com.tencent.mm.wallet_core.d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72065);
        Log.d("MicroMsg.PayUShowOrdersInfoProcess", "start Process : ShowOrdersInfo");
        b(activity, PayUMallOrderRecordListUI.class, bundle);
        AppMethodBeat.o(72065);
        return this;
    }

    @Override // com.tencent.mm.plugin.order.a.a, com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(72066);
        if (activity instanceof PayUMallOrderRecordListUI) {
            b(activity, PayUMallOrderDetailUI.class, bundle);
        }
        AppMethodBeat.o(72066);
    }
}
