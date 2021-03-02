package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.t;

public class WalletMixOrderInfoProxyUI extends WalletOrderInfoNewUI {
    private Orders HFH;
    private String prepayId = null;

    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI, com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI, com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(70973);
        this.HFH = (Orders) getIntent().getParcelableExtra("key_orders");
        this.prepayId = getIntent().getStringExtra("prepayId");
        super.onCreate(bundle);
        AppMethodBeat.o(70973);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI
    public final Orders fSS() {
        return this.HFH;
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI
    public final void done() {
        AppMethodBeat.i(70974);
        for (String str : this.Ihn) {
            if (!Util.isNullOrNil(str)) {
                Log.d("MicroMsg.WalletMixOrderInfoProxyUI", "hy: doing netscene subscribe...appName: %s", str);
                g.aAi();
                g.aAg().hqi.a(new t(str), 0);
            }
        }
        if (!Util.isNullOrNil(this.prepayId)) {
            aaa aaa = new aaa();
            Intent intent = new Intent();
            intent.putExtra("intent_pay_end", true);
            intent.putExtra("is_jsapi_close_page", this.HFH.HZq);
            aaa.egJ.intent = intent;
            aaa.egJ.dDL = this.prepayId;
            aaa.egJ.result = -1;
            aaa.egJ.egM = 1;
            EventCenter.instance.publish(aaa);
        }
        setResult(-1);
        finish();
        AppMethodBeat.o(70974);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI
    public final void fSE() {
    }
}
