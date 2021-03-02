package com.tencent.mm.plugin.wallet_ecard.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;

public class a extends b {
    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(71704);
        K("start", activity, bundle);
        Log.d("MicroMsg.BindCardProcess", "start Process : BindCardProcess");
        if (bundle != null) {
            ab.mg(6, bundle.getInt("key_bind_scene"));
            z.aqh(bundle.getInt("key_bind_scene"));
        } else {
            ab.mg(6, 0);
            z.aqh(0);
        }
        if (!t.fQI().fRk()) {
            if (bundle != null) {
                f.jV(bundle.getInt("key_bind_scene", 0), 1);
            }
            if (bundle == null || !bundle.getBoolean("key_is_import_bind", false)) {
                d a2 = super.a(activity, bundle);
                AppMethodBeat.o(71704);
                return a2;
            }
            b(activity, WalletCardImportUI.class, bundle);
            AppMethodBeat.o(71704);
            return this;
        } else if (bundle != null) {
            if (bundle.getBoolean("key_is_import_bind", false)) {
                b(activity, WalletCardImportUI.class, bundle);
            } else {
                b(activity, WalletBankcardIdUI.class, bundle);
            }
            AppMethodBeat.o(71704);
            return this;
        } else {
            d a3 = super.a(activity, bundle);
            AppMethodBeat.o(71704);
            return a3;
        }
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(71705);
        if (bundle == null || !bundle.getBoolean("intent_bind_end", false)) {
            a(activity, "wallet_ecard", ".ui.WalletECardBindCardListUI", 0, new Intent(), true);
            activity.finish();
            AppMethodBeat.o(71705);
            return;
        }
        a(activity, "wallet_ecard", ".ui.WalletECardBindCardListUI", -1, new Intent(), true);
        AppMethodBeat.o(71705);
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "OpenECardBindCardProcess";
    }
}
