package com.tencent.matrix.resource.analyzer.model;

import com.c.a.b.h;
import com.c.a.b.l;
import com.tencent.matrix.resource.analyzer.a.a;
import com.tencent.matrix.resource.analyzer.a.b;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.File;

public final class g {
    private final o cXW;
    public final l coS;

    public g(o oVar) {
        this.cXW = (o) b.checkNotNull(oVar, "hprofFile");
        l Kh = new h(new com.c.a.b.a.b(new File(s.k(aa.z(oVar.mUri), true)), (byte) 0)).Kh();
        a.a(Kh);
        this.coS = Kh;
    }
}
