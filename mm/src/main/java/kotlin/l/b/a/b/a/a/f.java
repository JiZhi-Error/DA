package kotlin.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.v;
import kotlin.a.y;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.c.ae;
import kotlin.l.b.a.b.b.c.p;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.n.j;

public final class f extends ae {
    public static final a TfI = new a((byte) 0);

    static {
        AppMethodBeat.i(56743);
        AppMethodBeat.o(56743);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private f(l lVar, f fVar, b.a aVar, boolean z) {
        super(lVar, fVar, g.a.hBP(), j.TQF, aVar, an.ThK);
        g.a aVar2 = g.TiC;
        AppMethodBeat.i(56742);
        this.TkM = true;
        this.TkU = z;
        EC(false);
        AppMethodBeat.o(56742);
    }

    public /* synthetic */ f(l lVar, b.a aVar, boolean z) {
        this(lVar, null, aVar, z);
    }

    @Override // kotlin.l.b.a.b.b.c.p
    public final t a(p.a aVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(56739);
        kotlin.g.b.p.h(aVar, "configuration");
        f fVar = (f) super.a(aVar);
        if (fVar == null) {
            AppMethodBeat.o(56739);
            return null;
        }
        List<av> hAw = fVar.hAw();
        kotlin.g.b.p.g(hAw, "substituted.valueParameters");
        List<av> list = hAw;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                kotlin.g.b.p.g(next, LocaleUtil.ITALIAN);
                ab hBy = next.hBy();
                kotlin.g.b.p.g(hBy, "it.type");
                if (kotlin.l.b.a.b.a.f.k(hBy) != null) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            f fVar2 = fVar;
            AppMethodBeat.o(56739);
            return fVar2;
        }
        List<av> hAw2 = fVar.hAw();
        kotlin.g.b.p.g(hAw2, "substituted.valueParameters");
        List<av> list2 = hAw2;
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(list2, 10));
        for (T t : list2) {
            kotlin.g.b.p.g(t, LocaleUtil.ITALIAN);
            ab hBy2 = t.hBy();
            kotlin.g.b.p.g(hBy2, "it.type");
            arrayList.add(kotlin.l.b.a.b.a.f.k(hBy2));
        }
        t ky = fVar.ky(arrayList);
        AppMethodBeat.o(56739);
        return ky;
    }

    @Override // kotlin.l.b.a.b.b.c.p, kotlin.l.b.a.b.b.c.ae
    public final p a(l lVar, t tVar, b.a aVar, kotlin.l.b.a.b.f.f fVar, g gVar, an anVar) {
        AppMethodBeat.i(56740);
        kotlin.g.b.p.h(lVar, "newOwner");
        kotlin.g.b.p.h(aVar, "kind");
        kotlin.g.b.p.h(gVar, "annotations");
        kotlin.g.b.p.h(anVar, "source");
        f fVar2 = new f(lVar, (f) tVar, aVar, hAZ());
        AppMethodBeat.o(56740);
        return fVar2;
    }

    @Override // kotlin.l.b.a.b.b.v, kotlin.l.b.a.b.b.c.p
    public final boolean isExternal() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.t, kotlin.l.b.a.b.b.c.p
    public final boolean hzI() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.t, kotlin.l.b.a.b.b.c.p
    public final boolean hzX() {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.l.b.a.b.b.t ky(java.util.List<kotlin.l.b.a.b.f.f> r11) {
        /*
        // Method dump skipped, instructions count: 218
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.a.a.f.ky(java.util.List):kotlin.l.b.a.b.b.t");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:3:0x001f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static kotlin.l.b.a.b.b.av a(kotlin.l.b.a.b.a.a.f r13, int r14, kotlin.l.b.a.b.b.as r15) {
            /*
            // Method dump skipped, instructions count: 146
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.a.a.f.a.a(kotlin.l.b.a.b.a.a.f, int, kotlin.l.b.a.b.b.as):kotlin.l.b.a.b.b.av");
        }

        public static f a(b bVar, boolean z) {
            AppMethodBeat.i(56737);
            kotlin.g.b.p.h(bVar, "functionClass");
            List<as> list = bVar.parameters;
            f fVar = new f(bVar, b.a.DECLARATION, z);
            ak hAO = bVar.hAO();
            v vVar = v.SXr;
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                if (!(t.hAJ() == bh.IN_VARIANCE)) {
                    break;
                }
                arrayList.add(t);
            }
            Iterable<y> s = kotlin.a.j.s((Iterable) arrayList);
            ArrayList arrayList2 = new ArrayList(kotlin.a.j.a(s, 10));
            for (y yVar : s) {
                a aVar = f.TfI;
                arrayList2.add(a(fVar, yVar.index, yVar.value));
            }
            fVar.b(null, hAO, vVar, arrayList2, ((as) kotlin.a.j.ku(list)).hAG(), w.ABSTRACT, az.ThU);
            fVar.ED(true);
            AppMethodBeat.o(56737);
            return fVar;
        }
    }
}
