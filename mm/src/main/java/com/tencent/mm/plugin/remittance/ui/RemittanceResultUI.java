package com.tencent.mm.plugin.remittance.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.remittance.model.p;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class RemittanceResultUI extends WalletBaseUI {
    private Orders CwO;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01db  */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r15) {
        /*
        // Method dump skipped, instructions count: 492
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.remittance.ui.RemittanceResultUI.onCreate(android.os.Bundle):void");
    }

    private void aV(Class<?> cls) {
        AppMethodBeat.i(68315);
        if (getProcess() == null) {
            startActivity(cls, getIntent());
            AppMethodBeat.o(68315);
            return;
        }
        getProcess().b(this, cls, getInput());
        AppMethodBeat.o(68315);
    }

    /* access modifiers changed from: protected */
    public boolean eOn() {
        return true;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(68316);
        if (qVar instanceof p) {
            Log.i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
            p pVar = (p) qVar;
            if (i2 == 0 && i3 == 0) {
                vt vtVar = pVar.CoN;
                Log.i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, retcode: %s, retmsg: %s, exposesureInfo: %s", Integer.valueOf(vtVar.dDN), vtVar.qwn, vtVar.Iah);
                if (vtVar.dDN == 0) {
                    try {
                        getInput().putByteArray("key_succpage_resp", vtVar.toByteArray());
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.RemittanceResultUI", e2, "pass succ page resp error: %s", e2.getMessage());
                    }
                    aV(RemittanceResultNewUI.class);
                    finish();
                    AppMethodBeat.o(68316);
                    return true;
                }
                Toast.makeText(this, vtVar.qwn, 1).show();
            }
            aV(RemittanceResultNewUI.class);
            finish();
            AppMethodBeat.o(68316);
            return true;
        }
        AppMethodBeat.o(68316);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(68317);
        super.onDestroy();
        removeSceneEndListener(2773);
        AppMethodBeat.o(68317);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }
}
