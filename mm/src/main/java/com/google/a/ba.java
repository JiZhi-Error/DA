package com.google.a;

import com.google.a.at;
import com.google.a.cc;
import com.google.a.cj;
import com.google.a.l;
import com.google.a.p;
import com.google.a.z;
import java.util.List;
import java.util.Map;

final class ba {

    /* access modifiers changed from: package-private */
    public interface c {

        public enum a {
            MESSAGE,
            EXTENSION_SET
        }

        a Hh();

        p.b a(p pVar, l.a aVar, int i2);

        Object a(g gVar, r rVar, l.f fVar, at atVar);

        Object a(h hVar, r rVar, l.f fVar, at atVar);

        c ac(l.f fVar, Object obj);

        c ad(l.f fVar, Object obj);

        Object b(h hVar, r rVar, l.f fVar, at atVar);

        boolean e(l.f fVar);

        cj.c j(l.f fVar);
    }

    static void a(at atVar, Map<l.f, Object> map, i iVar) {
        boolean z = atVar.AS().bSq.AG().bRt;
        for (Map.Entry<l.f, Object> entry : map.entrySet()) {
            l.f key = entry.getKey();
            Object value = entry.getValue();
            if (!z || !key.bSP.Cp() || key.bSS != l.f.b.MESSAGE || key.FJ()) {
                x.a(key, value, iVar);
            } else {
                iVar.b(key.bSP.bPE, (at) value);
            }
        }
        cc Ax = atVar.Ax();
        if (z) {
            Ax.c(iVar);
        } else {
            Ax.a(iVar);
        }
    }

    static int a(at atVar, Map<l.f, Object> map) {
        int i2 = 0;
        boolean z = atVar.AS().bSq.AG().bRt;
        for (Map.Entry<l.f, Object> entry : map.entrySet()) {
            l.f key = entry.getKey();
            Object value = entry.getValue();
            if (!z || !key.bSP.Cp() || key.bSS != l.f.b.MESSAGE || key.FJ()) {
                i2 = x.c(key, value) + i2;
            } else {
                i2 = i.d(key.bSP.bPE, (at) value) + i2;
            }
        }
        cc Ax = atVar.Ax();
        if (z) {
            return Ax.HL() + i2;
        }
        return Ax.yC() + i2;
    }

    private static String a(String str, l.f fVar, int i2) {
        StringBuilder sb = new StringBuilder(str);
        if (fVar.bSP.Cp()) {
            sb.append('(').append(fVar.fullName).append(')');
        } else {
            sb.append(fVar.bSP.getName());
        }
        if (i2 != -1) {
            sb.append('[').append(i2).append(']');
        }
        sb.append('.');
        return sb.toString();
    }

    static void a(az azVar, String str, List<String> list) {
        for (l.f fVar : azVar.AS().getFields()) {
            if (fVar.FH() && !azVar.e(fVar)) {
                list.add(str + fVar.bSP.getName());
            }
        }
        for (Map.Entry<l.f, Object> entry : azVar.FS().entrySet()) {
            l.f key = entry.getKey();
            Object value = entry.getValue();
            if (key.bSS.bTz == l.f.a.MESSAGE) {
                if (key.FJ()) {
                    int i2 = 0;
                    for (az azVar2 : (List) value) {
                        a(azVar2, a(str, key, i2), list);
                        i2++;
                    }
                } else if (azVar.e(key)) {
                    a((az) value, a(str, key, -1), list);
                }
            }
        }
    }

    static class a implements c {
        private final at.a bYj;

        public a(at.a aVar) {
            this.bYj = aVar;
        }

        private Object f(l.f fVar) {
            return this.bYj.f(fVar);
        }

        @Override // com.google.a.ba.c
        public final boolean e(l.f fVar) {
            return this.bYj.e(fVar);
        }

        @Override // com.google.a.ba.c
        public final c ac(l.f fVar, Object obj) {
            this.bYj.f(fVar, obj);
            return this;
        }

        @Override // com.google.a.ba.c
        public final c ad(l.f fVar, Object obj) {
            this.bYj.e(fVar, obj);
            return this;
        }

        @Override // com.google.a.ba.c
        public final c.a Hh() {
            return c.a.MESSAGE;
        }

        @Override // com.google.a.ba.c
        public final p.b a(p pVar, l.a aVar, int i2) {
            return pVar.a(aVar, i2);
        }

        @Override // com.google.a.ba.c
        public final Object a(h hVar, r rVar, l.f fVar, at atVar) {
            at.a h2;
            at atVar2;
            if (atVar != null) {
                h2 = atVar.AM();
            } else {
                h2 = this.bYj.h(fVar);
            }
            if (!fVar.FJ() && (atVar2 = (at) f(fVar)) != null) {
                h2.c(atVar2);
            }
            hVar.a(fVar.bSP.bPE, h2, rVar);
            return h2.Bm();
        }

        @Override // com.google.a.ba.c
        public final Object b(h hVar, r rVar, l.f fVar, at atVar) {
            at.a h2;
            at atVar2;
            if (atVar != null) {
                h2 = atVar.AM();
            } else {
                h2 = this.bYj.h(fVar);
            }
            if (!fVar.FJ() && (atVar2 = (at) f(fVar)) != null) {
                h2.c(atVar2);
            }
            hVar.a(h2, rVar);
            return h2.Bm();
        }

        @Override // com.google.a.ba.c
        public final Object a(g gVar, r rVar, l.f fVar, at atVar) {
            at.a h2;
            at atVar2;
            if (atVar != null) {
                h2 = atVar.AM();
            } else {
                h2 = this.bYj.h(fVar);
            }
            if (!fVar.FJ() && (atVar2 = (at) f(fVar)) != null) {
                h2.c(atVar2);
            }
            h2.c(gVar, rVar);
            return h2.Bm();
        }

        @Override // com.google.a.ba.c
        public final cj.c j(l.f fVar) {
            if (fVar.FF()) {
                return cj.c.STRICT;
            }
            if (fVar.FJ() || !(this.bYj instanceof z.a)) {
                return cj.c.LOOSE;
            }
            return cj.c.LAZY;
        }
    }

    static class b implements c {
        private final x<l.f> bWd;

        b(x<l.f> xVar) {
            this.bWd = xVar;
        }

        private Object f(l.f fVar) {
            return this.bWd.b(fVar);
        }

        @Override // com.google.a.ba.c
        public final boolean e(l.f fVar) {
            return this.bWd.a(fVar);
        }

        @Override // com.google.a.ba.c
        public final c ac(l.f fVar, Object obj) {
            this.bWd.a(fVar, obj);
            return this;
        }

        @Override // com.google.a.ba.c
        public final c ad(l.f fVar, Object obj) {
            this.bWd.b(fVar, obj);
            return this;
        }

        @Override // com.google.a.ba.c
        public final c.a Hh() {
            return c.a.EXTENSION_SET;
        }

        @Override // com.google.a.ba.c
        public final p.b a(p pVar, l.a aVar, int i2) {
            return pVar.a(aVar, i2);
        }

        @Override // com.google.a.ba.c
        public final Object a(h hVar, r rVar, l.f fVar, at atVar) {
            at atVar2;
            at.a AM = atVar.AM();
            if (!fVar.FJ() && (atVar2 = (at) f(fVar)) != null) {
                AM.c(atVar2);
            }
            hVar.a(fVar.bSP.bPE, AM, rVar);
            return AM.Bm();
        }

        @Override // com.google.a.ba.c
        public final Object b(h hVar, r rVar, l.f fVar, at atVar) {
            at atVar2;
            at.a AM = atVar.AM();
            if (!fVar.FJ() && (atVar2 = (at) f(fVar)) != null) {
                AM.c(atVar2);
            }
            hVar.a(AM, rVar);
            return AM.Bm();
        }

        @Override // com.google.a.ba.c
        public final Object a(g gVar, r rVar, l.f fVar, at atVar) {
            at atVar2;
            at.a AM = atVar.AM();
            if (!fVar.FJ() && (atVar2 = (at) f(fVar)) != null) {
                AM.c(atVar2);
            }
            AM.c(gVar, rVar);
            return AM.Bm();
        }

        @Override // com.google.a.ba.c
        public final cj.c j(l.f fVar) {
            if (fVar.FF()) {
                return cj.c.STRICT;
            }
            return cj.c.LOOSE;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a(com.google.a.h r8, com.google.a.cc.a r9, com.google.a.r r10, com.google.a.l.a r11, com.google.a.ba.c r12, int r13) {
        /*
        // Method dump skipped, instructions count: 356
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.ba.a(com.google.a.h, com.google.a.cc$a, com.google.a.r, com.google.a.l$a, com.google.a.ba$c, int):boolean");
    }

    private static void a(h hVar, cc.a aVar, r rVar, l.a aVar2, c cVar) {
        int i2 = 0;
        p.b bVar = null;
        g gVar = null;
        while (true) {
            int yT = hVar.yT();
            if (yT == 0) {
                break;
            } else if (yT == cj.caA) {
                i2 = hVar.zc();
                if (i2 != 0 && (rVar instanceof p)) {
                    bVar = cVar.a((p) rVar, aVar2, i2);
                }
            } else if (yT == cj.caB) {
                if (i2 == 0 || bVar == null || !r.Gc()) {
                    gVar = hVar.zb();
                } else {
                    a(hVar, bVar, rVar, cVar);
                    gVar = null;
                }
            } else if (!hVar.fG(yT)) {
                break;
            }
        }
        hVar.fF(cj.caz);
        if (gVar != null && i2 != 0) {
            if (bVar != null) {
                a(gVar, bVar, rVar, cVar);
            } else if (gVar != null && aVar != null) {
                aVar.a(i2, cc.b.HO().h(gVar).HQ());
            }
        }
    }

    private static void a(g gVar, p.b bVar, r rVar, c cVar) {
        l.f fVar = bVar.bUd;
        if (cVar.e(fVar) || r.Gc()) {
            cVar.ac(fVar, cVar.a(gVar, rVar, fVar, bVar.bUe));
        } else {
            cVar.ac(fVar, new ah(bVar.bUe, rVar, gVar));
        }
    }

    private static void a(h hVar, p.b bVar, r rVar, c cVar) {
        l.f fVar = bVar.bUd;
        cVar.ac(fVar, cVar.b(hVar, rVar, fVar, bVar.bUe));
    }
}
