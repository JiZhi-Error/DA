package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet.pwd.c;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletResetPwdAdapterUI extends WalletBaseUI {
    protected boolean CqH = false;
    protected com.tencent.mm.plugin.wallet.a CqI = null;
    protected String HKR = "";
    protected String goe = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69781);
        super.onCreate(bundle);
        setContentViewVisibility(8);
        this.HKR = getIntent().getStringExtra("reset_pwd_token");
        Log.i("MicroMsg.WalletResetPwdAdapterUI", "token_by_resetPwd %s", this.HKR);
        addSceneEndListener(580);
        if (getIntent() == null) {
            Log.d("MicroMsg.WalletResetPwdAdapterUI", "func[doCheckPayNetscene] intent null");
            setResult(0);
            finish();
            AppMethodBeat.o(69781);
            return;
        }
        d dVar = new d(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 13, "setWCPayPassword", getIntent().getIntExtra("pay_channel", 0));
        dVar.setProcessName("RemittanceProcess");
        doSceneForceProgress(dVar);
        AppMethodBeat.o(69781);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(69782);
        Log.v("MicroMsg.WalletResetPwdAdapterUI", "onNewIntent");
        int intExtra = intent.getIntExtra("RESET_PWD_USER_ACTION", 0);
        if (intExtra == 1) {
            setResult(-1);
            finish();
            AppMethodBeat.o(69782);
        } else if (intExtra == 2) {
            setResult(-1000);
            finish();
            AppMethodBeat.o(69782);
        } else {
            setResult(0);
            finish();
            AppMethodBeat.o(69782);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(69783);
        removeSceneEndListener(580);
        super.onDestroy();
        AppMethodBeat.o(69783);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(69784);
        if (!this.CqH) {
            Log.d("MicroMsg.WalletResetPwdAdapterUI", "back press not lock");
            finish();
            AppMethodBeat.o(69784);
            return;
        }
        Log.d("MicroMsg.WalletResetPwdAdapterUI", "back press but lock");
        AppMethodBeat.o(69784);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(69785);
        if (i2 != 0 || i3 != 0) {
            setResult(-1000);
            h.cD(this, str);
            finish();
            AppMethodBeat.o(69785);
            return true;
        } else if (qVar instanceof d) {
            e.bfP(((d) qVar).fPP());
            Bundle bundle = new Bundle();
            bundle.putString("kreq_token", this.HKR);
            dal fPQ = ((d) qVar).fPQ();
            if (fPQ != null) {
                bundle.putString("key_pwd_title", fPQ.title);
                bundle.putString("key_pwd_desc", fPQ.MFO);
            }
            com.tencent.mm.wallet_core.a.a(this, c.class, bundle, (d.a) null);
            AppMethodBeat.o(69785);
            return true;
        } else {
            AppMethodBeat.o(69785);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }
}
