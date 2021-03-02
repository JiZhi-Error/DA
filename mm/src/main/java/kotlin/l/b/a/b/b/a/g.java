package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;

public interface g extends Iterable<c>, kotlin.g.b.a.a {
    public static final a TiC = a.TiE;

    c g(kotlin.l.b.a.b.f.b bVar);

    boolean h(kotlin.l.b.a.b.f.b bVar);

    boolean isEmpty();

    public static final class b {
        public static c a(g gVar, kotlin.l.b.a.b.f.b bVar) {
            Object obj;
            AppMethodBeat.i(56947);
            p.h(bVar, "fqName");
            Iterator it = gVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                Object next = it.next();
                if (p.j(((c) next).hBk(), bVar)) {
                    obj = next;
                    break;
                }
            }
            c cVar = (c) obj;
            AppMethodBeat.o(56947);
            return cVar;
        }

        public static boolean b(g gVar, kotlin.l.b.a.b.f.b bVar) {
            AppMethodBeat.i(56948);
            p.h(bVar, "fqName");
            if (gVar.g(bVar) != null) {
                AppMethodBeat.o(56948);
                return true;
            }
            AppMethodBeat.o(56948);
            return false;
        }
    }

    public static final class a {
        private static final g TiD = new C2277a();
        static final /* synthetic */ a TiE = new a();

        /* renamed from: kotlin.l.b.a.b.b.a.g$a$a  reason: collision with other inner class name */
        public static final class C2277a implements g {
            C2277a() {
            }

            @Override // kotlin.l.b.a.b.b.a.g
            public final /* synthetic */ c g(kotlin.l.b.a.b.f.b bVar) {
                AppMethodBeat.i(56942);
                p.h(bVar, "fqName");
                AppMethodBeat.o(56942);
                return null;
            }

            @Override // kotlin.l.b.a.b.b.a.g
            public final boolean h(kotlin.l.b.a.b.f.b bVar) {
                AppMethodBeat.i(56944);
                p.h(bVar, "fqName");
                boolean b2 = b.b(this, bVar);
                AppMethodBeat.o(56944);
                return b2;
            }

            @Override // kotlin.l.b.a.b.b.a.g
            public final boolean isEmpty() {
                return true;
            }

            public final String toString() {
                return "EMPTY";
            }

            @Override // java.lang.Iterable
            public final Iterator<c> iterator() {
                AppMethodBeat.i(56943);
                Iterator<c> it = v.SXr.iterator();
                AppMethodBeat.o(56943);
                return it;
            }
        }

        static {
            AppMethodBeat.i(56946);
            AppMethodBeat.o(56946);
        }

        private a() {
        }

        public static g hBP() {
            return TiD;
        }

        public static g kA(List<? extends c> list) {
            AppMethodBeat.i(56945);
            p.h(list, "annotations");
            if (list.isEmpty()) {
                g gVar = TiD;
                AppMethodBeat.o(56945);
                return gVar;
            }
            h hVar = new h(list);
            AppMethodBeat.o(56945);
            return hVar;
        }
    }
}
