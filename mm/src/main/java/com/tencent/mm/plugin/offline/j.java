package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.d;

public class j extends d {
    @Override // com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        String str;
        AppMethodBeat.i(66251);
        if (bundle != null) {
            if (!Util.isNullOrNil(bundle.getString("key_trans_id"))) {
                str = "key_trans_id";
            } else {
                Orders orders = (Orders) bundle.getParcelable("key_orders");
                if (!(orders == null || orders.HZd == null || orders.HZd.size() <= 0)) {
                    str = orders.HZd.get(0).dDM;
                }
            }
            g.aAi();
            g.aAg().hqi.a(new com.tencent.mm.plugin.offline.a.g("offlineshowpage", "push", str), 0);
            b(activity, WalletOrderInfoUI.class, bundle);
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.TRUE);
            AppMethodBeat.o(66251);
            return this;
        }
        str = "";
        g.aAi();
        g.aAg().hqi.a(new com.tencent.mm.plugin.offline.a.g("offlineshowpage", "push", str), 0);
        b(activity, WalletOrderInfoUI.class, bundle);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.TRUE);
        AppMethodBeat.o(66251);
        return this;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(66252);
        if (activity instanceof WalletOrderInfoUI) {
            P(activity);
            b(activity, null);
        }
        AppMethodBeat.o(66252);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(66253);
        P(activity);
        AppMethodBeat.o(66253);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(66254);
        bA(activity);
        if (this.dQL.getInt("key_from_scene") == 8) {
            a.aJv(this.dQL.getString("key_appid"));
        }
        AppMethodBeat.o(66254);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "ShowOrderSuccessProcess";
    }
}
