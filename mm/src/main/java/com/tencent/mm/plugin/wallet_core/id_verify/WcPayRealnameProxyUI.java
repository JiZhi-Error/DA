package com.tencent.mm.plugin.wallet_core.id_verify;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_core.id_verify.model.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;

@a(3)
public class WcPayRealnameProxyUI extends WalletBaseUI {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(70067);
        super.onCreate(bundle);
        ao.q(this, getResources().getColor(R.color.ac_));
        Log.i("MicroMsg.WcPayRealnameProxyUI", "do get wording");
        e eVar = new e(getInput().getString("key_realname_sessionid"));
        addSceneEndListener(1666);
        doSceneProgress(eVar);
        AppMethodBeat.o(70067);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(70068);
        removeSceneEndListener(1666);
        e eVar = (e) qVar;
        if (eVar.HTE == null) {
            com.tencent.mm.wallet_core.a.c(getContext(), getInput(), 0);
            AppMethodBeat.o(70068);
        } else {
            try {
                String str2 = new String(eVar.HTE.toByteArray(), org.apache.commons.a.a.ISO_8859_1);
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_get_wording_cache", str2);
                bundle.putAll(getInput());
                bundle.putInt("real_name_verify_mode", 4);
                bundle.putBoolean("realname_verify_process_show_bindcard_page", eVar.HTE.Maz);
                getInput().putBoolean("realname_verify_process_verify_sms_without_bindcard", eVar.HTE.MaB);
                com.tencent.mm.wallet_core.a.l(getContext(), bundle);
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.WcPayRealnameProxyUI", e2, "", new Object[0]);
            }
            AppMethodBeat.o(70068);
        }
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }
}
