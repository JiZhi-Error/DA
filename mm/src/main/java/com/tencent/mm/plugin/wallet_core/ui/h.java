package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class h extends c {
    public h(WalletCheckPwdNewUI walletCheckPwdNewUI) {
        super(walletCheckPwdNewUI);
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdNewUI.a, com.tencent.mm.plugin.wallet_core.ui.c
    public final void aVF(String str) {
        AppMethodBeat.i(70680);
        Intent intent = new Intent();
        intent.putExtra("encrypt_pwd", str);
        this.IcN.setResult(-1, intent);
        this.IcN.finish();
        AppMethodBeat.o(70680);
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdNewUI.a, com.tencent.mm.plugin.wallet_core.ui.c
    public final void onCreate() {
        AppMethodBeat.i(70679);
        String stringExtra = this.IcN.getIntent().getStringExtra("title");
        if (!Util.isNullOrNil(stringExtra)) {
            this.IcN.Ige.setText(stringExtra);
        }
        AppMethodBeat.o(70679);
    }
}
