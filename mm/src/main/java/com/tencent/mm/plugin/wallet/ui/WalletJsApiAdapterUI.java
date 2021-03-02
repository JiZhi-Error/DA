package com.tencent.mm.plugin.wallet.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletJsApiAdapterUI extends WalletBaseUI {
    protected boolean CqH = false;
    protected String HMF = "";
    protected String packageName = "";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69852);
        super.onCreate(bundle);
        setContentViewVisibility(8);
        this.packageName = getIntent().getStringExtra("intent_jump_package");
        this.HMF = getIntent().getStringExtra("intent_jump_ui");
        addSceneEndListener(580);
        if (getIntent() == null) {
            Log.d("MicroMsg.WalletJsApiAdapterUI", "func[doCheckPayNetscene] intent null");
            setResult(0);
            finish();
            AppMethodBeat.o(69852);
            return;
        }
        int intExtra = getIntent().getIntExtra("source_type", 1);
        Log.i("MicroMsg.WalletJsApiAdapterUI", "do check jsapi: %s", Integer.valueOf(intExtra));
        d dVar = null;
        if (intExtra == 1) {
            dVar = new d(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), getIntent().getIntExtra("jsapi_scene", 0), "openWCPayCardList", getIntent().getIntExtra("pay_channel", 0));
        } else if (intExtra == 2) {
            dVar = new d(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getIntExtra("jsapi_scene", 0), getIntent().getStringExtra("wxapp_username"), getIntent().getStringExtra("wxapp_path"), getIntent().getStringExtra("command_word"), getIntent().getIntExtra("pay_channel", 0));
        }
        if (dVar != null) {
            doSceneForceProgress(dVar);
        }
        AppMethodBeat.o(69852);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(69853);
        Log.v("MicroMsg.WalletJsApiAdapterUI", "onNewIntent");
        int intExtra = intent.getIntExtra("RESET_PWD_USER_ACTION", 0);
        if (intExtra == 1) {
            setResult(-1);
            finish();
            AppMethodBeat.o(69853);
        } else if (intExtra == 2) {
            setResult(-1000);
            finish();
            AppMethodBeat.o(69853);
        } else {
            setResult(0);
            finish();
            AppMethodBeat.o(69853);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(69854);
        removeSceneEndListener(580);
        super.onDestroy();
        AppMethodBeat.o(69854);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(69855);
        if (!this.CqH) {
            Log.d("MicroMsg.WalletJsApiAdapterUI", "back press not lock");
            finish();
            AppMethodBeat.o(69855);
            return;
        }
        Log.d("MicroMsg.WalletJsApiAdapterUI", "back press but lock");
        AppMethodBeat.o(69855);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(69856);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            setResult(-1);
            finish();
        }
        AppMethodBeat.o(69856);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(69857);
        Log.i("MicroMsg.WalletJsApiAdapterUI", "onSceneEnd errType %s errCode %s errMsg %s scene %s", Integer.valueOf(i2), Integer.valueOf(i3), str, qVar);
        if (i2 != 0 || i3 != 0) {
            setResult(-1000);
            h.cD(this, str);
            finish();
            AppMethodBeat.o(69857);
            return true;
        } else if (qVar instanceof d) {
            e.bfP(((d) qVar).fPP());
            if (Util.isNullOrNil(this.packageName) || Util.isNullOrNil(this.HMF)) {
                setResult(-1);
                finish();
            } else {
                Intent intent = new Intent();
                intent.putExtra("intent_finish_self", true);
                c.b(this, this.packageName, this.HMF, intent, 1);
            }
            AppMethodBeat.o(69857);
            return true;
        } else {
            AppMethodBeat.o(69857);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }
}
