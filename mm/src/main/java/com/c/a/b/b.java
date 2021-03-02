package com.c.a.b;

import java.util.ArrayList;
import java.util.List;

public final class b extends i {
    private final long cox;

    public b(long j2, n nVar, long j3) {
        super(j2, nVar);
        this.cox = j3;
    }

    public final List<a> Kb() {
        ArrayList arrayList = new ArrayList();
        c Ka = Ka();
        Kl().aT(this.cox);
        for (c cVar = Ka; cVar != null; cVar = cVar.Kd()) {
            d[] dVarArr = cVar.coC;
            for (d dVar : dVarArr) {
                arrayList.add(new a(dVar, a(dVar.cow)));
            }
        }
        return arrayList;
    }

    public final String toString() {
        return String.format("%s@%d (0x%x)", Ka().mClassName, Long.valueOf(getUniqueId()), Long.valueOf(getUniqueId()));
    }

    public static class a {
        public d coy;
        public Object mValue;

        public a(d dVar, Object obj) {
            this.coy = dVar;
            this.mValue = obj;
        }
    }
}
