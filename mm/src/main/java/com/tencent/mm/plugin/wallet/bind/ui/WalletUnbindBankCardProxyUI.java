package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.HashMap;
import java.util.Map;

@a(3)
public class WalletUnbindBankCardProxyUI extends WalletBaseUI {
    private String HDU;
    private Bankcard HDV;
    private Map<String, String> HDW;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        HashMap hashMap;
        Bankcard bankcard = null;
        AppMethodBeat.i(69175);
        super.onCreate(bundle);
        Intent intent = getIntent();
        setResult(0);
        if (intent != null) {
            this.HDU = intent.getStringExtra("packageExt");
            if (!Util.isNullOrNil(this.HDU)) {
                String str = this.HDU;
                if (!Util.isNullOrNil(str)) {
                    String[] split = str.split("&");
                    hashMap = new HashMap();
                    if (split != null && split.length > 0) {
                        for (String str2 : split) {
                            if (!Util.isNullOrNil(str2)) {
                                int indexOf = str2.indexOf("=");
                                String substring = str2.substring(0, indexOf);
                                String substring2 = str2.substring(indexOf + 1, str2.length());
                                if (!Util.isNullOrNil(substring) && !Util.isNullOrNil(substring2)) {
                                    hashMap.put(substring, substring2);
                                }
                            }
                        }
                        this.HDW = hashMap;
                        if (this.HDW.containsKey("bank_type") || !this.HDW.containsKey("bind_serial")) {
                            Log.e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param:package error.package==" + this.HDU);
                            setResult(1);
                            finish();
                            AppMethodBeat.o(69175);
                            return;
                        }
                        Cursor rawQuery = t.fQF().db.rawQuery("select * from WalletBankcard where bindSerial = '" + this.HDW.get("bind_serial") + "'", null, 2);
                        if (rawQuery.moveToNext()) {
                            bankcard = new Bankcard();
                            bankcard.convertFrom(rawQuery);
                        }
                        rawQuery.close();
                        this.HDV = bankcard;
                        if (this.HDV == null) {
                            Log.e("MicorMsg.WalletUnbindBankCardProxyUI", "can not found bankcard");
                            setResult(0);
                            finish();
                            AppMethodBeat.o(69175);
                            return;
                        }
                        intent.putExtra("key_is_show_detail", false);
                        intent.putExtra("key_bankcard", this.HDV);
                        intent.putExtra("scene", 1);
                        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.bind.a.class, intent.getExtras(), new d.a() {
                            /* class com.tencent.mm.plugin.wallet.bind.ui.WalletUnbindBankCardProxyUI.AnonymousClass1 */

                            @Override // com.tencent.mm.wallet_core.d.a
                            public final Intent q(int i2, Bundle bundle) {
                                AppMethodBeat.i(69174);
                                switch (i2) {
                                    case -1:
                                        WalletUnbindBankCardProxyUI.this.setResult(-1);
                                        break;
                                    case 0:
                                        WalletUnbindBankCardProxyUI.this.setResult(0);
                                        break;
                                    case 1:
                                        WalletUnbindBankCardProxyUI.this.setResult(1);
                                        break;
                                }
                                AppMethodBeat.o(69174);
                                return null;
                            }
                        });
                        AppMethodBeat.o(69175);
                        return;
                    }
                }
                hashMap = null;
                this.HDW = hashMap;
                if (this.HDW.containsKey("bank_type")) {
                }
                Log.e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param:package error.package==" + this.HDU);
                setResult(1);
                finish();
                AppMethodBeat.o(69175);
                return;
            }
            Log.e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param error");
            setResult(1);
            finish();
            AppMethodBeat.o(69175);
            return;
        }
        Log.e("MicorMsg.WalletUnbindBankCardProxyUI", "intent is null");
        finish();
        AppMethodBeat.o(69175);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(69176);
        finish();
        AppMethodBeat.o(69176);
    }
}
