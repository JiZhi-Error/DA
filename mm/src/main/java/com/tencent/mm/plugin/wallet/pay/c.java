package com.tencent.mm.plugin.wallet.pay;

import com.tencent.mm.ak.q;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class c extends g {
    public c(WalletBaseUI walletBaseUI, i iVar) {
        super(walletBaseUI, iVar);
    }

    @Override // com.tencent.mm.wallet_core.d.g
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }
}
