package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.aq;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bb;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.c.b;
import kotlin.l.b.a.b.m.c.d;
import kotlin.l.b.a.b.m.c.e;
import kotlin.l.b.a.b.m.c.f;
import kotlin.l.b.a.b.m.c.g;
import kotlin.l.b.a.b.m.c.h;
import kotlin.l.b.a.b.m.c.j;
import kotlin.l.b.a.b.m.c.l;
import kotlin.l.b.a.b.m.c.m;
import kotlin.l.b.a.b.m.c.n;
import kotlin.l.b.a.b.m.c.o;
import kotlin.l.b.a.b.m.c.r;
import kotlin.l.b.a.b.m.c.t;
import kotlin.l.b.a.b.m.v;

public interface c extends bb, r {
    @Override // kotlin.l.b.a.b.m.c.q
    n i(j jVar);

    @Override // kotlin.l.b.a.b.m.c.q
    j o(h hVar);

    public static final class a {
        public static int a(c cVar, l lVar) {
            AppMethodBeat.i(61040);
            p.h(lVar, "$this$size");
            int a2 = r.a.a(cVar, lVar);
            AppMethodBeat.o(61040);
            return a2;
        }

        public static m a(c cVar, l lVar, int i2) {
            AppMethodBeat.i(61038);
            p.h(lVar, "$this$get");
            m a2 = r.a.a(cVar, lVar, i2);
            AppMethodBeat.o(61038);
            return a2;
        }

        public static boolean a(c cVar, h hVar) {
            AppMethodBeat.i(61036);
            p.h(hVar, "$this$isMarkedNullable");
            boolean b2 = bb.a.b(cVar, hVar);
            AppMethodBeat.o(61036);
            return b2;
        }

        public static n b(c cVar, h hVar) {
            AppMethodBeat.i(61037);
            p.h(hVar, "$this$typeConstructor");
            n a2 = r.a.a(cVar, hVar);
            AppMethodBeat.o(61037);
            return a2;
        }

        public static j c(c cVar, h hVar) {
            AppMethodBeat.i(61039);
            p.h(hVar, "$this$lowerBoundIfFlexible");
            j b2 = r.a.b(cVar, hVar);
            AppMethodBeat.o(61039);
            return b2;
        }

        public static j d(c cVar, h hVar) {
            AppMethodBeat.i(61041);
            p.h(hVar, "$this$upperBoundIfFlexible");
            j c2 = r.a.c(cVar, hVar);
            AppMethodBeat.o(61041);
            return c2;
        }

        public static h e(c cVar, h hVar) {
            AppMethodBeat.i(61042);
            p.h(hVar, "$this$makeNullable");
            h c2 = bb.a.c(cVar, hVar);
            AppMethodBeat.o(61042);
            return c2;
        }

        public static boolean p(n nVar) {
            AppMethodBeat.i(60988);
            p.h(nVar, "$this$isDenotable");
            if (!(nVar instanceof at)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + aa.bp(nVar.getClass())).toString());
                AppMethodBeat.o(60988);
                throw illegalArgumentException;
            }
            boolean hzU = ((at) nVar).hzU();
            AppMethodBeat.o(60988);
            return hzU;
        }

        public static boolean q(n nVar) {
            AppMethodBeat.i(60989);
            p.h(nVar, "$this$isIntegerLiteralTypeConstructor");
            if (!(nVar instanceof at)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + aa.bp(nVar.getClass())).toString());
                AppMethodBeat.o(60989);
                throw illegalArgumentException;
            }
            boolean z = nVar instanceof kotlin.l.b.a.b.j.b.n;
            AppMethodBeat.o(60989);
            return z;
        }

        public static Collection<h> a(c cVar, j jVar) {
            AppMethodBeat.i(60990);
            p.h(jVar, "$this$possibleIntegerTypes");
            n i2 = cVar.i(jVar);
            if (!(i2 instanceof kotlin.l.b.a.b.j.b.n)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + jVar + ", " + aa.bp(jVar.getClass())).toString());
                AppMethodBeat.o(60990);
                throw illegalArgumentException;
            }
            Set<ab> set = ((kotlin.l.b.a.b.j.b.n) i2).TIA;
            AppMethodBeat.o(60990);
            return set;
        }

        public static j b(j jVar, boolean z) {
            AppMethodBeat.i(60991);
            p.h(jVar, "$this$withNullability");
            if (!(jVar instanceof aj)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + jVar + ", " + aa.bp(jVar.getClass())).toString());
                AppMethodBeat.o(60991);
                throw illegalArgumentException;
            }
            aj EG = ((aj) jVar).EG(z);
            AppMethodBeat.o(60991);
            return EG;
        }

        public static boolean t(h hVar) {
            AppMethodBeat.i(60992);
            p.h(hVar, "$this$isError");
            if (!(hVar instanceof ab)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + aa.bp(hVar.getClass())).toString());
                AppMethodBeat.o(60992);
                throw illegalArgumentException;
            }
            boolean ap = ad.ap((ab) hVar);
            AppMethodBeat.o(60992);
            return ap;
        }

        public static boolean m(j jVar) {
            AppMethodBeat.i(60993);
            p.h(jVar, "$this$isStubType");
            if (!(jVar instanceof aj)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + jVar + ", " + aa.bp(jVar.getClass())).toString());
                AppMethodBeat.o(60993);
                throw illegalArgumentException;
            }
            boolean z = jVar instanceof aq;
            AppMethodBeat.o(60993);
            return z;
        }

        public static h b(d dVar) {
            AppMethodBeat.i(60994);
            p.h(dVar, "$this$lowerType");
            if (!(dVar instanceof k)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + dVar + ", " + aa.bp(dVar.getClass())).toString());
                AppMethodBeat.o(60994);
                throw illegalArgumentException;
            }
            bg bgVar = ((k) dVar).TPj;
            AppMethodBeat.o(60994);
            return bgVar;
        }

        public static boolean r(n nVar) {
            AppMethodBeat.i(60995);
            p.h(nVar, "$this$isIntersection");
            if (!(nVar instanceof at)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + aa.bp(nVar.getClass())).toString());
                AppMethodBeat.o(60995);
                throw illegalArgumentException;
            }
            boolean z = nVar instanceof kotlin.l.b.a.b.m.aa;
            AppMethodBeat.o(60995);
            return z;
        }

        public static boolean b(j jVar, j jVar2) {
            AppMethodBeat.i(60996);
            p.h(jVar, "a");
            p.h(jVar2, "b");
            if (!(jVar instanceof aj)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + jVar + ", " + aa.bp(jVar.getClass())).toString());
                AppMethodBeat.o(60996);
                throw illegalArgumentException;
            } else if (!(jVar2 instanceof aj)) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + jVar2 + ", " + aa.bp(jVar2.getClass())).toString());
                AppMethodBeat.o(60996);
                throw illegalArgumentException2;
            } else if (((aj) jVar).hKB() == ((aj) jVar2).hKB()) {
                AppMethodBeat.o(60996);
                return true;
            } else {
                AppMethodBeat.o(60996);
                return false;
            }
        }

        public static j u(h hVar) {
            AppMethodBeat.i(60997);
            p.h(hVar, "$this$asSimpleType");
            if (!(hVar instanceof ab)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + aa.bp(hVar.getClass())).toString());
                AppMethodBeat.o(60997);
                throw illegalArgumentException;
            }
            bg hLF = ((ab) hVar).hLF();
            if (!(hLF instanceof aj)) {
                hLF = null;
            }
            aj ajVar = (aj) hLF;
            AppMethodBeat.o(60997);
            return ajVar;
        }

        public static g v(h hVar) {
            AppMethodBeat.i(60998);
            p.h(hVar, "$this$asFlexibleType");
            if (!(hVar instanceof ab)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + aa.bp(hVar.getClass())).toString());
                AppMethodBeat.o(60998);
                throw illegalArgumentException;
            }
            bg hLF = ((ab) hVar).hLF();
            if (!(hLF instanceof v)) {
                hLF = null;
            }
            v vVar = (v) hLF;
            AppMethodBeat.o(60998);
            return vVar;
        }

        public static f d(g gVar) {
            AppMethodBeat.i(60999);
            p.h(gVar, "$this$asDynamicType");
            if (!(gVar instanceof v)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + gVar + ", " + aa.bp(gVar.getClass())).toString());
                AppMethodBeat.o(60999);
                throw illegalArgumentException;
            }
            kotlin.l.b.a.b.m.r rVar = (kotlin.l.b.a.b.m.r) (!(gVar instanceof kotlin.l.b.a.b.m.r) ? null : gVar);
            AppMethodBeat.o(60999);
            return rVar;
        }

        public static j e(g gVar) {
            AppMethodBeat.i(61000);
            p.h(gVar, "$this$upperBound");
            if (!(gVar instanceof v)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + gVar + ", " + aa.bp(gVar.getClass())).toString());
                AppMethodBeat.o(61000);
                throw illegalArgumentException;
            }
            aj ajVar = ((v) gVar).TNW;
            AppMethodBeat.o(61000);
            return ajVar;
        }

        public static j f(g gVar) {
            AppMethodBeat.i(61001);
            p.h(gVar, "$this$lowerBound");
            if (!(gVar instanceof v)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + gVar + ", " + aa.bp(gVar.getClass())).toString());
                AppMethodBeat.o(61001);
                throw illegalArgumentException;
            }
            aj ajVar = ((v) gVar).TNV;
            AppMethodBeat.o(61001);
            return ajVar;
        }

        public static d n(j jVar) {
            AppMethodBeat.i(61002);
            p.h(jVar, "$this$asCapturedType");
            if (!(jVar instanceof aj)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + jVar + ", " + aa.bp(jVar.getClass())).toString());
                AppMethodBeat.o(61002);
                throw illegalArgumentException;
            }
            k kVar = (k) (!(jVar instanceof k) ? null : jVar);
            AppMethodBeat.o(61002);
            return kVar;
        }

        public static e o(j jVar) {
            AppMethodBeat.i(61003);
            p.h(jVar, "$this$asDefinitelyNotNullType");
            if (!(jVar instanceof aj)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + jVar + ", " + aa.bp(jVar.getClass())).toString());
                AppMethodBeat.o(61003);
                throw illegalArgumentException;
            }
            kotlin.l.b.a.b.m.l lVar = (kotlin.l.b.a.b.m.l) (!(jVar instanceof kotlin.l.b.a.b.m.l) ? null : jVar);
            AppMethodBeat.o(61003);
            return lVar;
        }

        public static boolean p(j jVar) {
            AppMethodBeat.i(61004);
            p.h(jVar, "$this$isMarkedNullable");
            if (!(jVar instanceof aj)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + jVar + ", " + aa.bp(jVar.getClass())).toString());
                AppMethodBeat.o(61004);
                throw illegalArgumentException;
            }
            boolean hEa = ((aj) jVar).hEa();
            AppMethodBeat.o(61004);
            return hEa;
        }

        public static n q(j jVar) {
            AppMethodBeat.i(61005);
            p.h(jVar, "$this$typeConstructor");
            if (!(jVar instanceof aj)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + jVar + ", " + aa.bp(jVar.getClass())).toString());
                AppMethodBeat.o(61005);
                throw illegalArgumentException;
            }
            at hKE = ((aj) jVar).hKE();
            AppMethodBeat.o(61005);
            return hKE;
        }

        public static int w(h hVar) {
            AppMethodBeat.i(61006);
            p.h(hVar, "$this$argumentsCount");
            if (!(hVar instanceof ab)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + aa.bp(hVar.getClass())).toString());
                AppMethodBeat.o(61006);
                throw illegalArgumentException;
            }
            int size = ((ab) hVar).hKB().size();
            AppMethodBeat.o(61006);
            return size;
        }

        public static m b(h hVar, int i2) {
            AppMethodBeat.i(61007);
            p.h(hVar, "$this$getArgument");
            if (!(hVar instanceof ab)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + aa.bp(hVar.getClass())).toString());
                AppMethodBeat.o(61007);
                throw illegalArgumentException;
            }
            av avVar = ((ab) hVar).hKB().get(i2);
            AppMethodBeat.o(61007);
            return avVar;
        }

        public static boolean d(m mVar) {
            AppMethodBeat.i(61008);
            p.h(mVar, "$this$isStarProjection");
            if (!(mVar instanceof av)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + aa.bp(mVar.getClass())).toString());
                AppMethodBeat.o(61008);
                throw illegalArgumentException;
            }
            boolean hLH = ((av) mVar).hLH();
            AppMethodBeat.o(61008);
            return hLH;
        }

        public static t e(m mVar) {
            AppMethodBeat.i(61009);
            p.h(mVar, "$this$getVariance");
            if (!(mVar instanceof av)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + aa.bp(mVar.getClass())).toString());
                AppMethodBeat.o(61009);
                throw illegalArgumentException;
            }
            bh hLI = ((av) mVar).hLI();
            p.g(hLI, "this.projectionKind");
            t a2 = d.a(hLI);
            AppMethodBeat.o(61009);
            return a2;
        }

        public static h f(m mVar) {
            AppMethodBeat.i(61010);
            p.h(mVar, "$this$getType");
            if (!(mVar instanceof av)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + aa.bp(mVar.getClass())).toString());
                AppMethodBeat.o(61010);
                throw illegalArgumentException;
            }
            bg hLF = ((av) mVar).hBy().hLF();
            AppMethodBeat.o(61010);
            return hLF;
        }

        public static int s(n nVar) {
            AppMethodBeat.i(61011);
            p.h(nVar, "$this$parametersCount");
            if (!(nVar instanceof at)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + aa.bp(nVar.getClass())).toString());
                AppMethodBeat.o(61011);
                throw illegalArgumentException;
            }
            int size = ((at) nVar).getParameters().size();
            AppMethodBeat.o(61011);
            return size;
        }

        public static o b(n nVar, int i2) {
            AppMethodBeat.i(61012);
            p.h(nVar, "$this$getParameter");
            if (!(nVar instanceof at)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + aa.bp(nVar.getClass())).toString());
                AppMethodBeat.o(61012);
                throw illegalArgumentException;
            }
            as asVar = ((at) nVar).getParameters().get(i2);
            p.g(asVar, "this.parameters[index]");
            as asVar2 = asVar;
            AppMethodBeat.o(61012);
            return asVar2;
        }

        public static Collection<h> t(n nVar) {
            AppMethodBeat.i(61013);
            p.h(nVar, "$this$supertypes");
            if (!(nVar instanceof at)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + aa.bp(nVar.getClass())).toString());
                AppMethodBeat.o(61013);
                throw illegalArgumentException;
            }
            Collection<ab> hBV = ((at) nVar).hBV();
            p.g(hBV, "this.supertypes");
            AppMethodBeat.o(61013);
            return hBV;
        }

        public static t c(o oVar) {
            AppMethodBeat.i(61014);
            p.h(oVar, "$this$getVariance");
            if (!(oVar instanceof as)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + aa.bp(oVar.getClass())).toString());
                AppMethodBeat.o(61014);
                throw illegalArgumentException;
            }
            bh hAJ = ((as) oVar).hAJ();
            p.g(hAJ, "this.variance");
            t a2 = d.a(hAJ);
            AppMethodBeat.o(61014);
            return a2;
        }

        public static boolean c(n nVar, n nVar2) {
            AppMethodBeat.i(61015);
            p.h(nVar, "c1");
            p.h(nVar2, "c2");
            if (!(nVar instanceof at)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + aa.bp(nVar.getClass())).toString());
                AppMethodBeat.o(61015);
                throw illegalArgumentException;
            } else if (!(nVar2 instanceof at)) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar2 + ", " + aa.bp(nVar2.getClass())).toString());
                AppMethodBeat.o(61015);
                throw illegalArgumentException2;
            } else {
                boolean j2 = p.j(nVar, nVar2);
                AppMethodBeat.o(61015);
                return j2;
            }
        }

        public static boolean u(n nVar) {
            AppMethodBeat.i(61016);
            p.h(nVar, "$this$isClassTypeConstructor");
            if (!(nVar instanceof at)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + aa.bp(nVar.getClass())).toString());
                AppMethodBeat.o(61016);
                throw illegalArgumentException;
            }
            boolean z = ((at) nVar).hzS() instanceof kotlin.l.b.a.b.b.e;
            AppMethodBeat.o(61016);
            return z;
        }

        public static boolean v(n nVar) {
            AppMethodBeat.i(61017);
            p.h(nVar, "$this$isCommonFinalClassConstructor");
            if (!(nVar instanceof at)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + aa.bp(nVar.getClass())).toString());
                AppMethodBeat.o(61017);
                throw illegalArgumentException;
            }
            kotlin.l.b.a.b.b.h hzS = ((at) nVar).hzS();
            if (!(hzS instanceof kotlin.l.b.a.b.b.e)) {
                hzS = null;
            }
            kotlin.l.b.a.b.b.e eVar = (kotlin.l.b.a.b.b.e) hzS;
            if (eVar == null) {
                AppMethodBeat.o(61017);
                return false;
            } else if (!x.p(eVar) || eVar.hzB() == kotlin.l.b.a.b.b.f.ENUM_ENTRY || eVar.hzB() == kotlin.l.b.a.b.b.f.ANNOTATION_CLASS) {
                AppMethodBeat.o(61017);
                return false;
            } else {
                AppMethodBeat.o(61017);
                return true;
            }
        }

        public static l r(j jVar) {
            AppMethodBeat.i(61018);
            p.h(jVar, "$this$asArgumentList");
            if (!(jVar instanceof aj)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + jVar + ", " + aa.bp(jVar.getClass())).toString());
                AppMethodBeat.o(61018);
                throw illegalArgumentException;
            }
            l lVar = (l) jVar;
            AppMethodBeat.o(61018);
            return lVar;
        }

        public static j b(j jVar, b bVar) {
            AppMethodBeat.i(61019);
            p.h(jVar, "type");
            p.h(bVar, "status");
            if (!(jVar instanceof aj)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + jVar + ", " + aa.bp(jVar.getClass())).toString());
                AppMethodBeat.o(61019);
                throw illegalArgumentException;
            }
            aj a2 = m.a((aj) jVar, bVar);
            AppMethodBeat.o(61019);
            return a2;
        }

        public static boolean w(n nVar) {
            AppMethodBeat.i(61020);
            p.h(nVar, "$this$isAnyConstructor");
            if (!(nVar instanceof at)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + aa.bp(nVar.getClass())).toString());
                AppMethodBeat.o(61020);
                throw illegalArgumentException;
            }
            boolean a2 = kotlin.l.b.a.b.a.g.a((at) nVar, kotlin.l.b.a.b.a.g.TcO.TcS);
            AppMethodBeat.o(61020);
            return a2;
        }

        public static boolean x(n nVar) {
            AppMethodBeat.i(61021);
            p.h(nVar, "$this$isNothingConstructor");
            if (!(nVar instanceof at)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + aa.bp(nVar.getClass())).toString());
                AppMethodBeat.o(61021);
                throw illegalArgumentException;
            }
            boolean a2 = kotlin.l.b.a.b.a.g.a((at) nVar, kotlin.l.b.a.b.a.g.TcO.TcT);
            AppMethodBeat.o(61021);
            return a2;
        }

        public static m x(h hVar) {
            AppMethodBeat.i(61022);
            p.h(hVar, "$this$asTypeArgument");
            if (!(hVar instanceof ab)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + aa.bp(hVar.getClass())).toString());
                AppMethodBeat.o(61022);
                throw illegalArgumentException;
            }
            av aN = kotlin.l.b.a.b.m.d.a.aN((ab) hVar);
            AppMethodBeat.o(61022);
            return aN;
        }

        public static boolean s(j jVar) {
            AppMethodBeat.i(61023);
            p.h(jVar, "$this$isSingleClassifierType");
            if (!(jVar instanceof aj)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + jVar + ", " + aa.bp(jVar.getClass())).toString());
                AppMethodBeat.o(61023);
                throw illegalArgumentException;
            } else if (ad.ap((ab) jVar) || (((aj) jVar).hKE().hzS() instanceof ar) || (((aj) jVar).hKE().hzS() == null && !(jVar instanceof kotlin.l.b.a.b.j.a.a.a) && !(jVar instanceof k) && !(jVar instanceof kotlin.l.b.a.b.m.l) && !(((aj) jVar).hKE() instanceof kotlin.l.b.a.b.j.b.n))) {
                AppMethodBeat.o(61023);
                return false;
            } else {
                AppMethodBeat.o(61023);
                return true;
            }
        }

        public static h kK(List<? extends h> list) {
            AppMethodBeat.i(61024);
            p.h(list, "types");
            bg kL = f.kL(list);
            AppMethodBeat.o(61024);
            return kL;
        }

        public static boolean y(h hVar) {
            AppMethodBeat.i(61025);
            p.h(hVar, "$this$isNullableType");
            if (!(hVar instanceof ab)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + aa.bp(hVar.getClass())).toString());
                AppMethodBeat.o(61025);
                throw illegalArgumentException;
            }
            boolean aE = bc.aE((ab) hVar);
            AppMethodBeat.o(61025);
            return aE;
        }

        public static boolean t(j jVar) {
            AppMethodBeat.i(61026);
            p.h(jVar, "$this$isPrimitiveType");
            if (!(jVar instanceof ab)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + jVar + ", " + aa.bp(jVar.getClass())).toString());
                AppMethodBeat.o(61026);
                throw illegalArgumentException;
            }
            boolean o = kotlin.l.b.a.b.a.g.o((ab) jVar);
            AppMethodBeat.o(61026);
            return o;
        }

        public static boolean b(h hVar, kotlin.l.b.a.b.f.b bVar) {
            AppMethodBeat.i(61027);
            p.h(hVar, "$this$hasAnnotation");
            p.h(bVar, "fqName");
            if (!(hVar instanceof ab)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + aa.bp(hVar.getClass())).toString());
                AppMethodBeat.o(61027);
                throw illegalArgumentException;
            }
            boolean h2 = ((ab) hVar).hzL().h(bVar);
            AppMethodBeat.o(61027);
            return h2;
        }

        public static o y(n nVar) {
            AppMethodBeat.i(61028);
            p.h(nVar, "$this$getTypeParameterClassifier");
            if (!(nVar instanceof at)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + aa.bp(nVar.getClass())).toString());
                AppMethodBeat.o(61028);
                throw illegalArgumentException;
            }
            kotlin.l.b.a.b.b.h hzS = ((at) nVar).hzS();
            if (!(hzS instanceof as)) {
                hzS = null;
            }
            as asVar = (as) hzS;
            AppMethodBeat.o(61028);
            return asVar;
        }

        public static boolean z(n nVar) {
            AppMethodBeat.i(61029);
            p.h(nVar, "$this$isInlineClass");
            if (!(nVar instanceof at)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + aa.bp(nVar.getClass())).toString());
                AppMethodBeat.o(61029);
                throw illegalArgumentException;
            }
            kotlin.l.b.a.b.b.h hzS = ((at) nVar).hzS();
            if (!(hzS instanceof kotlin.l.b.a.b.b.e)) {
                hzS = null;
            }
            kotlin.l.b.a.b.b.e eVar = (kotlin.l.b.a.b.b.e) hzS;
            if (eVar == null || !eVar.hzI()) {
                AppMethodBeat.o(61029);
                return false;
            }
            AppMethodBeat.o(61029);
            return true;
        }

        public static h d(o oVar) {
            AppMethodBeat.i(61030);
            p.h(oVar, "$this$getRepresentativeUpperBound");
            if (!(oVar instanceof as)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + aa.bp(oVar.getClass())).toString());
                AppMethodBeat.o(61030);
                throw illegalArgumentException;
            }
            ab e2 = kotlin.l.b.a.b.m.d.a.e((as) oVar);
            AppMethodBeat.o(61030);
            return e2;
        }

        public static h z(h hVar) {
            AppMethodBeat.i(61031);
            p.h(hVar, "$this$getSubstitutedUnderlyingType");
            if (!(hVar instanceof ab)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + aa.bp(hVar.getClass())).toString());
                AppMethodBeat.o(61031);
                throw illegalArgumentException;
            }
            ab ab = kotlin.l.b.a.b.j.e.ab((ab) hVar);
            AppMethodBeat.o(61031);
            return ab;
        }

        public static kotlin.l.b.a.b.a.h A(n nVar) {
            AppMethodBeat.i(61032);
            p.h(nVar, "$this$getPrimitiveType");
            if (!(nVar instanceof at)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + aa.bp(nVar.getClass())).toString());
                AppMethodBeat.o(61032);
                throw illegalArgumentException;
            }
            kotlin.l.b.a.b.b.h hzS = ((at) nVar).hzS();
            if (hzS == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                AppMethodBeat.o(61032);
                throw tVar;
            }
            kotlin.l.b.a.b.a.h e2 = kotlin.l.b.a.b.a.g.e((kotlin.l.b.a.b.b.l) ((kotlin.l.b.a.b.b.e) hzS));
            AppMethodBeat.o(61032);
            return e2;
        }

        public static kotlin.l.b.a.b.a.h B(n nVar) {
            AppMethodBeat.i(61033);
            p.h(nVar, "$this$getPrimitiveArrayType");
            if (!(nVar instanceof at)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + aa.bp(nVar.getClass())).toString());
                AppMethodBeat.o(61033);
                throw illegalArgumentException;
            }
            kotlin.l.b.a.b.b.h hzS = ((at) nVar).hzS();
            if (hzS == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                AppMethodBeat.o(61033);
                throw tVar;
            }
            kotlin.l.b.a.b.a.h f2 = kotlin.l.b.a.b.a.g.f((kotlin.l.b.a.b.b.l) ((kotlin.l.b.a.b.b.e) hzS));
            AppMethodBeat.o(61033);
            return f2;
        }

        public static boolean C(n nVar) {
            AppMethodBeat.i(61034);
            p.h(nVar, "$this$isUnderKotlinPackage");
            if (!(nVar instanceof at)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + aa.bp(nVar.getClass())).toString());
                AppMethodBeat.o(61034);
                throw illegalArgumentException;
            }
            kotlin.l.b.a.b.b.h hzS = ((at) nVar).hzS();
            if (hzS == null || !kotlin.l.b.a.b.a.g.d(hzS)) {
                AppMethodBeat.o(61034);
                return false;
            }
            AppMethodBeat.o(61034);
            return true;
        }

        public static kotlin.l.b.a.b.f.c D(n nVar) {
            AppMethodBeat.i(61035);
            p.h(nVar, "$this$getClassFqNameUnsafe");
            if (!(nVar instanceof at)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + aa.bp(nVar.getClass())).toString());
                AppMethodBeat.o(61035);
                throw illegalArgumentException;
            }
            kotlin.l.b.a.b.b.h hzS = ((at) nVar).hzS();
            if (hzS == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                AppMethodBeat.o(61035);
                throw tVar;
            }
            kotlin.l.b.a.b.f.c q = kotlin.l.b.a.b.j.d.a.q((kotlin.l.b.a.b.b.e) hzS);
            AppMethodBeat.o(61035);
            return q;
        }
    }
}
