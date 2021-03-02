package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.a.aj;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;

public interface b {
    String a(h hVar, c cVar);

    /* renamed from: kotlin.l.b.a.b.i.b$b  reason: collision with other inner class name */
    public static final class C2339b implements b {
        public static final C2339b TEZ = new C2339b();

        static {
            AppMethodBeat.i(59652);
            AppMethodBeat.o(59652);
        }

        private C2339b() {
        }

        @Override // kotlin.l.b.a.b.i.b
        public final String a(h hVar, c cVar) {
            AppMethodBeat.i(59651);
            p.h(hVar, "classifier");
            p.h(cVar, "renderer");
            if (hVar instanceof as) {
                f hAH = ((as) hVar).hAH();
                p.g(hAH, "classifier.name");
                String b2 = cVar.b(hAH, false);
                AppMethodBeat.o(59651);
                return b2;
            }
            ArrayList arrayList = new ArrayList();
            h hVar2 = hVar;
            do {
                arrayList.add(hVar2.hAH());
                hVar2 = hVar2.hzx();
            } while (hVar2 instanceof e);
            ArrayList arrayList2 = arrayList;
            p.h(arrayList2, "$this$asReversed");
            String kH = q.kH(new aj(arrayList2));
            AppMethodBeat.o(59651);
            return kH;
        }
    }

    public static final class a implements b {
        public static final a TEY = new a();

        static {
            AppMethodBeat.i(59650);
            AppMethodBeat.o(59650);
        }

        private a() {
        }

        @Override // kotlin.l.b.a.b.i.b
        public final String a(h hVar, c cVar) {
            AppMethodBeat.i(59649);
            p.h(hVar, "classifier");
            p.h(cVar, "renderer");
            if (hVar instanceof as) {
                f hAH = ((as) hVar).hAH();
                p.g(hAH, "classifier.name");
                String b2 = cVar.b(hAH, false);
                AppMethodBeat.o(59649);
                return b2;
            }
            kotlin.l.b.a.b.f.c n = kotlin.l.b.a.b.j.c.n(hVar);
            p.g(n, "DescriptorUtils.getFqName(classifier)");
            String f2 = cVar.f(n);
            AppMethodBeat.o(59649);
            return f2;
        }
    }

    public static final class c implements b {
        public static final c TFa = new c();

        static {
            AppMethodBeat.i(59656);
            AppMethodBeat.o(59656);
        }

        private c() {
        }

        @Override // kotlin.l.b.a.b.i.b
        public final String a(h hVar, c cVar) {
            AppMethodBeat.i(59653);
            p.h(hVar, "classifier");
            p.h(cVar, "renderer");
            String a2 = a(hVar);
            AppMethodBeat.o(59653);
            return a2;
        }

        private final String a(h hVar) {
            AppMethodBeat.i(59654);
            f hAH = hVar.hAH();
            p.g(hAH, "descriptor.name");
            String x = q.x(hAH);
            if (hVar instanceof as) {
                AppMethodBeat.o(59654);
                return x;
            }
            l hzx = hVar.hzx();
            p.g(hzx, "descriptor.containingDeclaration");
            String j2 = j(hzx);
            if (j2 == null || !(!p.j(j2, ""))) {
                AppMethodBeat.o(59654);
                return x;
            }
            String str = j2 + "." + x;
            AppMethodBeat.o(59654);
            return str;
        }

        private final String j(l lVar) {
            AppMethodBeat.i(59655);
            if (lVar instanceof e) {
                String a2 = a((h) lVar);
                AppMethodBeat.o(59655);
                return a2;
            } else if (lVar instanceof ab) {
                kotlin.l.b.a.b.f.c hJe = ((ab) lVar).hBk().hJe();
                p.g(hJe, "descriptor.fqName.toUnsafe()");
                String g2 = q.g(hJe);
                AppMethodBeat.o(59655);
                return g2;
            } else {
                AppMethodBeat.o(59655);
                return null;
            }
        }
    }
}
