package com.tencent.mm.plugin.appbrand.ae;

import com.tencent.mm.plugin.appbrand.ae.d.d;
import com.tencent.mm.plugin.appbrand.ae.e.a;
import com.tencent.mm.plugin.appbrand.ae.e.e;
import com.tencent.mm.plugin.appbrand.ae.e.i;

public abstract class b implements d {
    protected boolean oim;

    @Override // com.tencent.mm.plugin.appbrand.ae.d
    public final i bZy() {
        return new e();
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d
    public void b(a aVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d
    public void c(d dVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d
    public final void a(a aVar, d dVar) {
        com.tencent.mm.plugin.appbrand.ae.d.e eVar = new com.tencent.mm.plugin.appbrand.ae.d.e(dVar);
        eVar.a(d.a.PONG);
        aVar.b(eVar);
    }

    public final void setTcpNoDelay(boolean z) {
        this.oim = z;
    }
}
