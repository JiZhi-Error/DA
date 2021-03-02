package com.tencent.mm.plugin.order.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI;
import com.tencent.mm.plugin.order.ui.MallOrderProductListUI;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI;
import com.tencent.mm.plugin.order.ui.MallOrderTransactionInfoUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.d;

public class a extends d {
    @Override // com.tencent.mm.wallet_core.d
    public d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(66631);
        Log.d("MicroMsg.ShowOrdersInfoProcess", "start Process : ShowOrdersInfo");
        b(activity, MallOrderRecordListUI.class, bundle);
        AppMethodBeat.o(66631);
        return this;
    }

    @Override // com.tencent.mm.wallet_core.d
    public void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(66632);
        if (activity instanceof MallOrderRecordListUI) {
            b(activity, MallOrderTransactionInfoUI.class, bundle);
            AppMethodBeat.o(66632);
        } else if (activity instanceof MallOrderDetailInfoUI) {
            int i3 = bundle.getInt("key_enter_id");
            if (i3 == 0) {
                b(activity, MallOrderProductListUI.class, bundle);
                AppMethodBeat.o(66632);
                return;
            }
            if (i3 == 1) {
                b(activity, MallOrderTransactionInfoUI.class, bundle);
            }
            AppMethodBeat.o(66632);
        } else {
            if ((activity instanceof MallOrderProductListUI) || (activity instanceof MallOrderTransactionInfoUI)) {
                P(activity);
            }
            AppMethodBeat.o(66632);
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(66633);
        super.bA(activity);
        AppMethodBeat.o(66633);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(66634);
        P(activity);
        AppMethodBeat.o(66634);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "ShowOrdersInfoProcess";
    }
}
