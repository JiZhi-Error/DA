package com.tencent.mm.ui.l.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appstorage.ab;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.ui.l.a.e;

public final class b extends a {
    public b(e eVar) {
        super(eVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.l.a.a.a
    public final q gWJ() {
        AppMethodBeat.i(234429);
        WxaPkg wxaPkg = new WxaPkg(this.QlN.bes());
        wxaPkg.bvf();
        ab abVar = new ab(wxaPkg);
        AppMethodBeat.o(234429);
        return abVar;
    }
}
