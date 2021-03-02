package com.tencent.matrix.resource.analyzer;

import com.c.a.b.b;
import com.c.a.b.e;
import com.c.a.b.i;
import com.c.a.b.l;
import com.tencent.matrix.resource.analyzer.a.c;
import com.tencent.matrix.resource.analyzer.model.d;
import com.tencent.matrix.resource.analyzer.model.g;
import com.tencent.matrix.resource.analyzer.model.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class a {
    private final String cWR;
    private final d cWS;

    public a(String str, d dVar) {
        this.cWR = str;
        this.cWS = dVar;
    }

    public final com.tencent.matrix.resource.analyzer.model.a a(g gVar) {
        return a(gVar, this.cWR);
    }

    private com.tencent.matrix.resource.analyzer.model.a a(g gVar, String str) {
        c.a aVar;
        long nanoTime = System.nanoTime();
        try {
            l lVar = gVar.coS;
            com.c.a.b.c cJ = lVar.cJ("com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo");
            if (cJ == null) {
                throw new IllegalStateException("Unabled to find destroy activity info class with name: com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo");
            }
            ArrayList arrayList = new ArrayList();
            for (i iVar : cJ.Ke()) {
                List<b.a> b2 = e.b(iVar);
                String as = e.as(e.b(b2, "mKey"));
                if (as.equals(str)) {
                    i iVar2 = (i) e.b(b2, "mActivityRef");
                    if (iVar2 != null) {
                        i iVar3 = (i) e.b(e.b(iVar2), "referent");
                        if (iVar3 == null) {
                            return com.tencent.matrix.resource.analyzer.model.a.bf(com.tencent.matrix.resource.analyzer.a.a.bg(nanoTime));
                        }
                        c cVar = new c(this.cWS);
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(iVar3);
                        Map<i, c.a> a2 = cVar.a(lVar, arrayList2);
                        if (a2.isEmpty()) {
                            aVar = new c.a(null, false);
                        } else {
                            aVar = a2.get(iVar3);
                        }
                        if (aVar.cYy == null) {
                            return com.tencent.matrix.resource.analyzer.model.a.bf(com.tencent.matrix.resource.analyzer.a.a.bg(nanoTime));
                        }
                        h Ta = aVar.Ta();
                        String str2 = iVar3.Ka().mClassName;
                        if (!aVar.cYz) {
                            if (!(Ta.elements == null || Ta.elements.isEmpty())) {
                                return com.tencent.matrix.resource.analyzer.model.a.a(str2, Ta, com.tencent.matrix.resource.analyzer.a.a.bg(nanoTime));
                            }
                        }
                        return com.tencent.matrix.resource.analyzer.model.a.bf(com.tencent.matrix.resource.analyzer.a.a.bg(nanoTime));
                    }
                } else {
                    arrayList.add(as);
                }
            }
            throw new IllegalStateException("Could not find weak reference with key " + str + " in " + arrayList);
        } catch (Throwable th) {
            return com.tencent.matrix.resource.analyzer.model.a.a(th, com.tencent.matrix.resource.analyzer.a.a.bg(nanoTime));
        }
    }
}
