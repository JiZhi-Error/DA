package com.tencent.mm.plugin.fingerprint;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.fingerprint.b.b;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.plugin.fingerprint.b.f;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.fingerprint.b.j;
import com.tencent.mm.plugin.fingerprint.b.n;
import com.tencent.mm.plugin.fingerprint.b.q;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class a implements bd {
    private n wEn = new n();
    private i wEo = new i();
    private j wEp = new j();
    private b wEq = new b();
    private e wEr = new e();
    private f wEs = new f();

    public a() {
        AppMethodBeat.i(64213);
        AppMethodBeat.o(64213);
    }

    static {
        AppMethodBeat.i(64216);
        com.tencent.mm.wallet_core.a.j("FingerprintAuth", com.tencent.mm.plugin.fingerprint.ui.a.class);
        AppMethodBeat.o(64216);
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
        AppMethodBeat.i(64214);
        EventCenter.instance.addListener(this.wEn);
        EventCenter.instance.addListener(this.wEo);
        EventCenter.instance.addListener(this.wEp);
        EventCenter.instance.addListener(this.wEq);
        EventCenter.instance.addListener(this.wEr);
        EventCenter.instance.addListener(this.wEs);
        g.a(com.tencent.mm.plugin.fingerprint.b.h.class, new com.tencent.mm.kernel.c.e(new q()));
        AppMethodBeat.o(64214);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(64215);
        EventCenter.instance.removeListener(this.wEn);
        this.wEo.release();
        EventCenter.instance.removeListener(this.wEo);
        EventCenter.instance.removeListener(this.wEp);
        EventCenter.instance.removeListener(this.wEq);
        EventCenter.instance.removeListener(this.wEr);
        ((com.tencent.mm.plugin.fingerprint.b.a.i) g.af(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cancel();
        EventCenter.instance.removeListener(this.wEs);
        g.ag(com.tencent.mm.plugin.fingerprint.b.h.class);
        AppMethodBeat.o(64215);
    }
}
