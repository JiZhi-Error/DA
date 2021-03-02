package com.tencent.mm.loader.g;

import kotlin.g.b.p;

public final class k implements Runnable {
    private b iaV;
    private c ibC;
    private a ibD;

    public interface a {
        void b(c cVar, j jVar);
    }

    public k(c cVar, b bVar, a aVar) {
        this.ibC = cVar;
        this.iaV = bVar;
        this.ibD = aVar;
    }

    public final void run() {
        c cVar = this.ibC;
        b bVar = this.iaV;
        a aVar = this.ibD;
        p.h(bVar, "loader");
        p.h(aVar, "watch");
        cVar.iaV = bVar;
        cVar.iaW = aVar;
        cVar.call();
    }
}
