package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletRealNameProcessProxyUI extends WalletBaseUI {
    private d.a HKI;
    private String scene;
    private String sessionId;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        int i2;
        AppMethodBeat.i(70042);
        super.onCreate(bundle);
        addSceneEndListener(580);
        Bundle input = getInput();
        if (input != null) {
            i2 = input.getInt("realname_scene", 0);
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
            i2 = getIntent().getIntExtra("realname_scene", 0);
        }
        if (i2 == 1) {
            Log.i("MicroMsg.WalletRealNameProcessProxyUI", "from jsapi, do NetSceneCheckPayJsapi");
            if (getIntent() == null) {
                String str = "";
                if (Util.isNullOrNil(str)) {
                    str = getString(R.string.itf);
                }
                h.a((Context) this, str, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameProcessProxyUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(70041);
                        WalletRealNameProcessProxyUI.this.setResult(1);
                        WalletRealNameProcessProxyUI.this.finish();
                        AppMethodBeat.o(70041);
                    }
                });
                AppMethodBeat.o(70042);
                return;
            }
            String stringExtra = getIntent().getStringExtra("appId");
            String stringExtra2 = getIntent().getStringExtra("timeStamp");
            String stringExtra3 = getIntent().getStringExtra("nonceStr");
            String stringExtra4 = getIntent().getStringExtra("packageExt");
            String stringExtra5 = getIntent().getStringExtra("signtype");
            String stringExtra6 = getIntent().getStringExtra("paySignature");
            String stringExtra7 = getIntent().getStringExtra("url");
            int i3 = 8;
            if (getInput().getInt("realname_scene") == 2) {
                i3 = 12;
            }
            doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.d(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7, i3, "idCardRealnameVerify", getIntent().getIntExtra("pay_channel", 0)));
            AppMethodBeat.o(70042);
            return;
        }
        aJ(input);
        AppMethodBeat.o(70042);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(70043);
        super.onResume();
        AppMethodBeat.o(70043);
    }

    private void aJ(Bundle bundle) {
        AppMethodBeat.i(70044);
        Log.i("MicroMsg.WalletRealNameProcessProxyUI", "goRealNameUI");
        if (bundle == null) {
            Log.i("MicroMsg.WalletRealNameProcessProxyUI", "goRealNameUI, param is null");
            bundle = new Bundle();
        }
        bundle.putString("key_realname_scene", this.scene);
        bundle.putString("key_realname_sessionid", this.sessionId);
        bundle.putString("realname_verify_process_jump_plugin", "wallet_core");
        bundle.putString("realname_verify_process_jump_activity", ".id_verify.WalletRealNameProcessProxyUI");
        bundle.putBoolean("process_finish_stay_orgpage", false);
        this.HKI = new d.a() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameProcessProxyUI.AnonymousClass1 */

            @Override // com.tencent.mm.wallet_core.d.a
            public final Intent q(int i2, Bundle bundle) {
                AppMethodBeat.i(70040);
                Log.i("MicroMsg.WalletRealNameProcessProxyUI", "realname end: %s", Integer.valueOf(i2));
                Intent intent = new Intent();
                AppMethodBeat.o(70040);
                return intent;
            }
        };
        com.tencent.mm.wallet_core.a.a(this, a.class, bundle, this.HKI);
        AppMethodBeat.o(70044);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(70045);
        if (qVar instanceof com.tencent.mm.plugin.wallet_core.c.d) {
            Log.e("MicroMsg.WalletRealNameProcessProxyUI", "NetSceneCheckPayJsapi resp,errType = " + i2 + ",errCode=" + i3);
            if (i2 == 0 && i3 == 0) {
                e.bfP(((com.tencent.mm.plugin.wallet_core.c.d) qVar).fPP());
                this.sessionId = ((zf) ((com.tencent.mm.plugin.wallet_core.c.d) qVar).rr.iLL.iLR).session_id;
                this.scene = ((zf) ((com.tencent.mm.plugin.wallet_core.c.d) qVar).rr.iLL.iLR).scene;
                aJ(getInput());
                AppMethodBeat.o(70045);
                return true;
            }
        }
        AppMethodBeat.o(70045);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(70046);
        Log.i("MicroMsg.WalletRealNameProcessProxyUI", "onNewIntent");
        Bundle extras = getIntent().getExtras();
        if (extras == null || !extras.getBoolean("key_is_realname_verify_process")) {
            setResult(0);
        } else {
            switch (extras.getInt("realname_verify_process_ret", 0)) {
                case -1:
                    setResult(-1);
                    break;
            }
            setResult(0);
        }
        finish();
        AppMethodBeat.o(70046);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean isTransparent() {
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(70047);
        super.onDestroy();
        removeSceneEndListener(580);
        AppMethodBeat.o(70047);
    }
}
