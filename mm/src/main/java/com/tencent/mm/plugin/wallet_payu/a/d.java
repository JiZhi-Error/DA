package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.wallet_payu.create.a.c;
import com.tencent.mm.plugin.wallet_payu.pwd.a.f;
import com.tencent.mm.plugin.wallet_payu.pwd.a.g;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.wallet_core.a;
import java.util.HashMap;

public class d implements bd {
    private int ItA = -1;
    private String Itz = null;

    static {
        AppMethodBeat.i(72055);
        a.j("PayUOpenProcess", c.class);
        a.j("PayUBindProcess", com.tencent.mm.plugin.wallet_payu.bind.model.c.class);
        a.j("PayUForgotPwdProcess", f.class);
        a.j("PayUModifyPasswordProcess", g.class);
        a.j("PayURemittanceProcess", com.tencent.mm.plugin.wallet_payu.remittance.a.g.class);
        a.j("PayUShowOrderProcess", com.tencent.mm.plugin.wallet_payu.order.a.d.class);
        AppMethodBeat.o(72055);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
    }
}
