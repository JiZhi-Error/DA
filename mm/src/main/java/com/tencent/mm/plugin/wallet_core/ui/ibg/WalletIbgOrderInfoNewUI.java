package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.le;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.t;

public class WalletIbgOrderInfoNewUI extends WalletOrderInfoNewUI {
    private Orders HFH;

    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI, com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI, com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71444);
        this.HFH = WalletIbgOrderInfoUI.HFH;
        super.onCreate(bundle);
        le leVar = new le();
        leVar.dQr.requestCode = 25;
        leVar.dQr.resultCode = -1;
        leVar.dQr.dQs = new Intent();
        EventCenter.instance.publish(leVar);
        AppMethodBeat.o(71444);
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI
    public final Orders fSS() {
        return this.HFH;
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI
    public final void done() {
        AppMethodBeat.i(71445);
        Log.i("MicroMsg.WalletIbgOrderInfoNewUI", "hy: result is not set manly. set to OK");
        for (String str : this.Ihn) {
            if (!Util.isNullOrNil(str)) {
                Log.d("MicroMsg.WalletIbgOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", str);
                g.aAi();
                g.aAg().hqi.a(new t(str), 0);
            }
        }
        setResult(-1);
        finish();
        AppMethodBeat.o(71445);
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI
    public final void fSE() {
    }
}
