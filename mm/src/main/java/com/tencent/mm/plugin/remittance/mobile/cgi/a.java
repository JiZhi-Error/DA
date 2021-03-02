package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.wallet_core.c.r;

public abstract class a extends r {
    private final String TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitBase";
    protected i callback;
    protected d rr;

    @Override // com.tencent.mm.wallet_core.c.r, com.tencent.mm.ak.q
    public int doScene(g gVar, i iVar) {
        this.callback = iVar;
        return dispatch(gVar, this.rr, this);
    }
}
