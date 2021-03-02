package kotlin.l.b.a.b.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.aa;
import kotlin.g.b.p;

public interface q extends s {
    int a(l lVar);

    f a(g gVar);

    h a(d dVar);

    j a(j jVar, b bVar);

    j a(j jVar, boolean z);

    m a(h hVar, int i2);

    m a(l lVar, int i2);

    o a(n nVar, int i2);

    boolean a(m mVar);

    j b(g gVar);

    t b(m mVar);

    t b(o oVar);

    boolean b(n nVar, n nVar2);

    h c(m mVar);

    j c(g gVar);

    Collection<h> d(j jVar);

    n d(h hVar);

    j e(h hVar);

    boolean e(j jVar);

    d f(j jVar);

    j f(h hVar);

    e g(j jVar);

    boolean g(n nVar);

    boolean h(j jVar);

    boolean h(n nVar);

    n i(j jVar);

    boolean i(n nVar);

    int j(n nVar);

    l j(j jVar);

    Collection<h> k(n nVar);

    boolean k(j jVar);

    h kJ(List<? extends h> list);

    boolean l(j jVar);

    boolean l(n nVar);

    boolean m(n nVar);

    boolean n(h hVar);

    boolean n(n nVar);

    j o(h hVar);

    boolean o(n nVar);

    g p(h hVar);

    int q(h hVar);

    m r(h hVar);

    boolean s(h hVar);

    public static final class a {
        public static m a(q qVar, j jVar, int i2) {
            AppMethodBeat.i(61226);
            p.h(jVar, "$this$getArgumentOrNull");
            int q = qVar.q(jVar);
            if (i2 >= 0 && q > i2) {
                m a2 = qVar.a(jVar, i2);
                AppMethodBeat.o(61226);
                return a2;
            }
            AppMethodBeat.o(61226);
            return null;
        }

        public static j a(q qVar, h hVar) {
            j jVar;
            AppMethodBeat.i(61227);
            p.h(hVar, "$this$lowerBoundIfFlexible");
            g p = qVar.p(hVar);
            if ((p == null || (jVar = qVar.c(p)) == null) && (jVar = qVar.o(hVar)) == null) {
                p.hyc();
            }
            AppMethodBeat.o(61227);
            return jVar;
        }

        public static j b(q qVar, h hVar) {
            j jVar;
            AppMethodBeat.i(61228);
            p.h(hVar, "$this$upperBoundIfFlexible");
            g p = qVar.p(hVar);
            if ((p == null || (jVar = qVar.b(p)) == null) && (jVar = qVar.o(hVar)) == null) {
                p.hyc();
            }
            AppMethodBeat.o(61228);
            return jVar;
        }

        public static boolean c(q qVar, h hVar) {
            AppMethodBeat.i(61229);
            p.h(hVar, "$this$isDynamic");
            g p = qVar.p(hVar);
            if ((p != null ? qVar.a(p) : null) != null) {
                AppMethodBeat.o(61229);
                return true;
            }
            AppMethodBeat.o(61229);
            return false;
        }

        public static boolean d(q qVar, h hVar) {
            AppMethodBeat.i(61230);
            p.h(hVar, "$this$isDefinitelyNotNullType");
            j o = qVar.o(hVar);
            if ((o != null ? qVar.g(o) : null) != null) {
                AppMethodBeat.o(61230);
                return true;
            }
            AppMethodBeat.o(61230);
            return false;
        }

        public static boolean e(q qVar, h hVar) {
            AppMethodBeat.i(61231);
            p.h(hVar, "$this$hasFlexibleNullability");
            if (qVar.h(qVar.e(hVar)) != qVar.h(qVar.f(hVar))) {
                AppMethodBeat.o(61231);
                return true;
            }
            AppMethodBeat.o(61231);
            return false;
        }

        public static n f(q qVar, h hVar) {
            AppMethodBeat.i(61232);
            p.h(hVar, "$this$typeConstructor");
            j o = qVar.o(hVar);
            if (o == null) {
                o = qVar.e(hVar);
            }
            n i2 = qVar.i(o);
            AppMethodBeat.o(61232);
            return i2;
        }

        public static boolean g(q qVar, h hVar) {
            AppMethodBeat.i(61233);
            p.h(hVar, "$this$isNothing");
            if (!qVar.o(qVar.d(hVar)) || qVar.s(hVar)) {
                AppMethodBeat.o(61233);
                return false;
            }
            AppMethodBeat.o(61233);
            return true;
        }

        public static boolean a(q qVar, j jVar) {
            AppMethodBeat.i(61234);
            p.h(jVar, "$this$isClassType");
            boolean l = qVar.l(qVar.i(jVar));
            AppMethodBeat.o(61234);
            return l;
        }

        public static List<j> b(j jVar, n nVar) {
            AppMethodBeat.i(61235);
            p.h(jVar, "$this$fastCorrespondingSupertypes");
            p.h(nVar, "constructor");
            AppMethodBeat.o(61235);
            return null;
        }

        public static boolean b(q qVar, j jVar) {
            AppMethodBeat.i(61236);
            p.h(jVar, "$this$isIntegerLiteralType");
            boolean h2 = qVar.h(qVar.i(jVar));
            AppMethodBeat.o(61236);
            return h2;
        }

        public static m a(q qVar, l lVar, int i2) {
            AppMethodBeat.i(61237);
            p.h(lVar, "$this$get");
            if (lVar instanceof j) {
                m a2 = qVar.a((h) lVar, i2);
                AppMethodBeat.o(61237);
                return a2;
            } else if (lVar instanceof a) {
                Object obj = ((a) lVar).get(i2);
                p.g(obj, "get(index)");
                m mVar = (m) obj;
                AppMethodBeat.o(61237);
                return mVar;
            } else {
                IllegalStateException illegalStateException = new IllegalStateException(("unknown type argument list type: " + lVar + ", " + aa.bp(lVar.getClass())).toString());
                AppMethodBeat.o(61237);
                throw illegalStateException;
            }
        }

        public static int a(q qVar, l lVar) {
            AppMethodBeat.i(61238);
            p.h(lVar, "$this$size");
            if (lVar instanceof j) {
                int q = qVar.q((h) lVar);
                AppMethodBeat.o(61238);
                return q;
            } else if (lVar instanceof a) {
                int size = ((a) lVar).size();
                AppMethodBeat.o(61238);
                return size;
            } else {
                IllegalStateException illegalStateException = new IllegalStateException(("unknown type argument list type: " + lVar + ", " + aa.bp(lVar.getClass())).toString());
                AppMethodBeat.o(61238);
                throw illegalStateException;
            }
        }
    }
}
