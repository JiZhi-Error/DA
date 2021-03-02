package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.m.a.c;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.a.n;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.au;
import kotlin.l.b.a.b.m.ba;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.c.b;
import kotlin.l.b.a.b.m.c.d;
import kotlin.l.b.a.b.m.c.e;
import kotlin.l.b.a.b.m.c.f;
import kotlin.l.b.a.b.m.c.h;
import kotlin.l.b.a.b.m.c.j;
import kotlin.l.b.a.b.m.c.l;
import kotlin.l.b.a.b.m.c.m;
import kotlin.l.b.a.b.m.c.n;
import kotlin.l.b.a.b.m.c.o;
import kotlin.l.b.a.b.m.c.q;
import kotlin.l.b.a.b.m.c.t;
import kotlin.l.b.a.b.m.g;

public final class a extends g implements c {
    public static final C2358a TPa = new C2358a((byte) 0);
    private final i THR;
    private final boolean TOX;
    private final boolean TOY;
    private final boolean TOZ;

    static {
        AppMethodBeat.i(60923);
        AppMethodBeat.o(60923);
    }

    @Override // kotlin.l.b.a.b.m.g, kotlin.l.b.a.b.m.c.q
    public final int a(l lVar) {
        AppMethodBeat.i(60984);
        p.h(lVar, "$this$size");
        int a2 = c.a.a(this, lVar);
        AppMethodBeat.o(60984);
        return a2;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final f a(kotlin.l.b.a.b.m.c.g gVar) {
        AppMethodBeat.i(60935);
        p.h(gVar, "$this$asDynamicType");
        f d2 = c.a.d(gVar);
        AppMethodBeat.o(60935);
        return d2;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final h a(d dVar) {
        AppMethodBeat.i(60930);
        p.h(dVar, "$this$lowerType");
        h b2 = c.a.b(dVar);
        AppMethodBeat.o(60930);
        return b2;
    }

    @Override // kotlin.l.b.a.b.m.bb
    public final h a(o oVar) {
        AppMethodBeat.i(60968);
        p.h(oVar, "$this$getRepresentativeUpperBound");
        h d2 = c.a.d(oVar);
        AppMethodBeat.o(60968);
        return d2;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final j a(j jVar, b bVar) {
        AppMethodBeat.i(60957);
        p.h(jVar, "type");
        p.h(bVar, "status");
        j b2 = c.a.b(jVar, bVar);
        AppMethodBeat.o(60957);
        return b2;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final j a(j jVar, boolean z) {
        AppMethodBeat.i(60927);
        p.h(jVar, "$this$withNullability");
        j b2 = c.a.b(jVar, z);
        AppMethodBeat.o(60927);
        return b2;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final m a(h hVar, int i2) {
        AppMethodBeat.i(60945);
        p.h(hVar, "$this$getArgument");
        m b2 = c.a.b(hVar, i2);
        AppMethodBeat.o(60945);
        return b2;
    }

    @Override // kotlin.l.b.a.b.m.g, kotlin.l.b.a.b.m.c.q
    public final m a(l lVar, int i2) {
        AppMethodBeat.i(60975);
        p.h(lVar, "$this$get");
        m a2 = c.a.a(this, lVar, i2);
        AppMethodBeat.o(60975);
        return a2;
    }

    @Override // kotlin.l.b.a.b.m.bb
    public final o a(n nVar) {
        AppMethodBeat.i(60966);
        p.h(nVar, "$this$getTypeParameterClassifier");
        o y = c.a.y(nVar);
        AppMethodBeat.o(60966);
        return y;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final o a(n nVar, int i2) {
        AppMethodBeat.i(60951);
        p.h(nVar, "$this$getParameter");
        o b2 = c.a.b(nVar, i2);
        AppMethodBeat.o(60951);
        return b2;
    }

    @Override // kotlin.l.b.a.b.m.g
    public final /* synthetic */ g.b a(j jVar) {
        AppMethodBeat.i(60919);
        p.h(jVar, "type");
        p.h(this, "$this$classicSubstitutionSupertypePolicy");
        p.h(jVar, "type");
        if (!(jVar instanceof aj)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(b.fF(jVar).toString());
            AppMethodBeat.o(60919);
            throw illegalArgumentException;
        }
        C2358a.C2359a aVar = new C2358a.C2359a(this, au.TOz.ax((ab) jVar).hLJ());
        AppMethodBeat.o(60919);
        return aVar;
    }

    @Override // kotlin.l.b.a.b.m.bb
    public final boolean a(h hVar, kotlin.l.b.a.b.f.b bVar) {
        AppMethodBeat.i(60965);
        p.h(hVar, "$this$hasAnnotation");
        p.h(bVar, "fqName");
        boolean b2 = c.a.b(hVar, bVar);
        AppMethodBeat.o(60965);
        return b2;
    }

    @Override // kotlin.l.b.a.b.m.g, kotlin.l.b.a.b.m.c.s
    public final boolean a(j jVar, j jVar2) {
        AppMethodBeat.i(60932);
        p.h(jVar, "a");
        p.h(jVar2, "b");
        boolean b2 = c.a.b(jVar, jVar2);
        AppMethodBeat.o(60932);
        return b2;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final boolean a(m mVar) {
        AppMethodBeat.i(60946);
        p.h(mVar, "$this$isStarProjection");
        boolean d2 = c.a.d(mVar);
        AppMethodBeat.o(60946);
        return d2;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final j b(kotlin.l.b.a.b.m.c.g gVar) {
        AppMethodBeat.i(60936);
        p.h(gVar, "$this$upperBound");
        j e2 = c.a.e(gVar);
        AppMethodBeat.o(60936);
        return e2;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final t b(m mVar) {
        AppMethodBeat.i(60947);
        p.h(mVar, "$this$getVariance");
        t e2 = c.a.e(mVar);
        AppMethodBeat.o(60947);
        return e2;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final t b(o oVar) {
        AppMethodBeat.i(60948);
        p.h(oVar, "$this$getVariance");
        t c2 = c.a.c(oVar);
        AppMethodBeat.o(60948);
        return c2;
    }

    @Override // kotlin.l.b.a.b.m.bb
    public final boolean b(n nVar) {
        AppMethodBeat.i(60967);
        p.h(nVar, "$this$isInlineClass");
        boolean z = c.a.z(nVar);
        AppMethodBeat.o(60967);
        return z;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final boolean b(n nVar, n nVar2) {
        AppMethodBeat.i(60953);
        p.h(nVar, "c1");
        p.h(nVar2, "c2");
        boolean c2 = c.a.c(nVar, nVar2);
        AppMethodBeat.o(60953);
        return c2;
    }

    @Override // kotlin.l.b.a.b.m.bb
    public final kotlin.l.b.a.b.a.h c(n nVar) {
        AppMethodBeat.i(60970);
        p.h(nVar, "$this$getPrimitiveType");
        kotlin.l.b.a.b.a.h A = c.a.A(nVar);
        AppMethodBeat.o(60970);
        return A;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final h c(m mVar) {
        AppMethodBeat.i(60949);
        p.h(mVar, "$this$getType");
        h f2 = c.a.f(mVar);
        AppMethodBeat.o(60949);
        return f2;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final j c(kotlin.l.b.a.b.m.c.g gVar) {
        AppMethodBeat.i(60937);
        p.h(gVar, "$this$lowerBound");
        j f2 = c.a.f(gVar);
        AppMethodBeat.o(60937);
        return f2;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final Collection<h> d(j jVar) {
        AppMethodBeat.i(60926);
        p.h(jVar, "$this$possibleIntegerTypes");
        Collection<h> a2 = c.a.a((c) this, jVar);
        AppMethodBeat.o(60926);
        return a2;
    }

    @Override // kotlin.l.b.a.b.m.bb
    public final kotlin.l.b.a.b.a.h d(n nVar) {
        AppMethodBeat.i(60971);
        p.h(nVar, "$this$getPrimitiveArrayType");
        kotlin.l.b.a.b.a.h B = c.a.B(nVar);
        AppMethodBeat.o(60971);
        return B;
    }

    @Override // kotlin.l.b.a.b.m.g, kotlin.l.b.a.b.m.c.q
    public final n d(h hVar) {
        AppMethodBeat.i(60943);
        p.h(hVar, "$this$typeConstructor");
        n b2 = c.a.b(this, hVar);
        AppMethodBeat.o(60943);
        return b2;
    }

    @Override // kotlin.l.b.a.b.m.g, kotlin.l.b.a.b.m.c.q
    public final j e(h hVar) {
        AppMethodBeat.i(60983);
        p.h(hVar, "$this$lowerBoundIfFlexible");
        j c2 = c.a.c(this, hVar);
        AppMethodBeat.o(60983);
        return c2;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final boolean e(j jVar) {
        AppMethodBeat.i(60929);
        p.h(jVar, "$this$isStubType");
        boolean m = c.a.m(jVar);
        AppMethodBeat.o(60929);
        return m;
    }

    @Override // kotlin.l.b.a.b.m.bb
    public final boolean e(n nVar) {
        AppMethodBeat.i(60972);
        p.h(nVar, "$this$isUnderKotlinPackage");
        boolean C = c.a.C(nVar);
        AppMethodBeat.o(60972);
        return C;
    }

    @Override // kotlin.l.b.a.b.m.bb
    public final kotlin.l.b.a.b.f.c f(n nVar) {
        AppMethodBeat.i(60973);
        p.h(nVar, "$this$getClassFqNameUnsafe");
        kotlin.l.b.a.b.f.c D = c.a.D(nVar);
        AppMethodBeat.o(60973);
        return D;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final d f(j jVar) {
        AppMethodBeat.i(60938);
        p.h(jVar, "$this$asCapturedType");
        d n = c.a.n(jVar);
        AppMethodBeat.o(60938);
        return n;
    }

    @Override // kotlin.l.b.a.b.m.g, kotlin.l.b.a.b.m.c.q
    public final j f(h hVar) {
        AppMethodBeat.i(60985);
        p.h(hVar, "$this$upperBoundIfFlexible");
        j d2 = c.a.d(this, hVar);
        AppMethodBeat.o(60985);
        return d2;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final e g(j jVar) {
        AppMethodBeat.i(60939);
        p.h(jVar, "$this$asDefinitelyNotNullType");
        e o = c.a.o(jVar);
        AppMethodBeat.o(60939);
        return o;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final boolean g(n nVar) {
        AppMethodBeat.i(60924);
        p.h(nVar, "$this$isDenotable");
        boolean p = c.a.p(nVar);
        AppMethodBeat.o(60924);
        return p;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final boolean h(j jVar) {
        AppMethodBeat.i(60940);
        p.h(jVar, "$this$isMarkedNullable");
        boolean p = c.a.p(jVar);
        AppMethodBeat.o(60940);
        return p;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final boolean h(n nVar) {
        AppMethodBeat.i(60925);
        p.h(nVar, "$this$isIntegerLiteralTypeConstructor");
        boolean q = c.a.q(nVar);
        AppMethodBeat.o(60925);
        return q;
    }

    @Override // kotlin.l.b.a.b.m.c.q, kotlin.l.b.a.b.m.a.c
    public final n i(j jVar) {
        AppMethodBeat.i(60942);
        p.h(jVar, "$this$typeConstructor");
        n q = c.a.q(jVar);
        AppMethodBeat.o(60942);
        return q;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final boolean i(n nVar) {
        AppMethodBeat.i(60931);
        p.h(nVar, "$this$isIntersection");
        boolean r = c.a.r(nVar);
        AppMethodBeat.o(60931);
        return r;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final int j(n nVar) {
        AppMethodBeat.i(60950);
        p.h(nVar, "$this$parametersCount");
        int s = c.a.s(nVar);
        AppMethodBeat.o(60950);
        return s;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final l j(j jVar) {
        AppMethodBeat.i(60956);
        p.h(jVar, "$this$asArgumentList");
        l r = c.a.r(jVar);
        AppMethodBeat.o(60956);
        return r;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final Collection<h> k(n nVar) {
        AppMethodBeat.i(60952);
        p.h(nVar, "$this$supertypes");
        Collection<h> t = c.a.t(nVar);
        AppMethodBeat.o(60952);
        return t;
    }

    @Override // kotlin.l.b.a.b.m.bb
    public final h k(h hVar) {
        AppMethodBeat.i(60969);
        p.h(hVar, "$this$getSubstitutedUnderlyingType");
        h z = c.a.z(hVar);
        AppMethodBeat.o(60969);
        return z;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final boolean k(j jVar) {
        AppMethodBeat.i(60961);
        p.h(jVar, "$this$isSingleClassifierType");
        boolean s = c.a.s(jVar);
        AppMethodBeat.o(60961);
        return s;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final h kJ(List<? extends h> list) {
        AppMethodBeat.i(60962);
        p.h(list, "types");
        h kK = c.a.kK(list);
        AppMethodBeat.o(60962);
        return kK;
    }

    @Override // kotlin.l.b.a.b.m.bb
    public final boolean l(h hVar) {
        AppMethodBeat.i(60941);
        p.h(hVar, "$this$isMarkedNullable");
        boolean a2 = c.a.a(this, hVar);
        AppMethodBeat.o(60941);
        return a2;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final boolean l(j jVar) {
        AppMethodBeat.i(60964);
        p.h(jVar, "$this$isPrimitiveType");
        boolean t = c.a.t(jVar);
        AppMethodBeat.o(60964);
        return t;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final boolean l(n nVar) {
        AppMethodBeat.i(60954);
        p.h(nVar, "$this$isClassTypeConstructor");
        boolean u = c.a.u(nVar);
        AppMethodBeat.o(60954);
        return u;
    }

    @Override // kotlin.l.b.a.b.m.bb
    public final h m(h hVar) {
        AppMethodBeat.i(60986);
        p.h(hVar, "$this$makeNullable");
        h e2 = c.a.e(this, hVar);
        AppMethodBeat.o(60986);
        return e2;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final boolean m(n nVar) {
        AppMethodBeat.i(60955);
        p.h(nVar, "$this$isCommonFinalClassConstructor");
        boolean v = c.a.v(nVar);
        AppMethodBeat.o(60955);
        return v;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final boolean n(h hVar) {
        AppMethodBeat.i(60928);
        p.h(hVar, "$this$isError");
        boolean t = c.a.t(hVar);
        AppMethodBeat.o(60928);
        return t;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final boolean n(n nVar) {
        AppMethodBeat.i(60958);
        p.h(nVar, "$this$isAnyConstructor");
        boolean w = c.a.w(nVar);
        AppMethodBeat.o(60958);
        return w;
    }

    @Override // kotlin.l.b.a.b.m.c.q, kotlin.l.b.a.b.m.a.c
    public final j o(h hVar) {
        AppMethodBeat.i(60933);
        p.h(hVar, "$this$asSimpleType");
        j u = c.a.u(hVar);
        AppMethodBeat.o(60933);
        return u;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final boolean o(n nVar) {
        AppMethodBeat.i(60959);
        p.h(nVar, "$this$isNothingConstructor");
        boolean x = c.a.x(nVar);
        AppMethodBeat.o(60959);
        return x;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final kotlin.l.b.a.b.m.c.g p(h hVar) {
        AppMethodBeat.i(60934);
        p.h(hVar, "$this$asFlexibleType");
        kotlin.l.b.a.b.m.c.g v = c.a.v(hVar);
        AppMethodBeat.o(60934);
        return v;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final int q(h hVar) {
        AppMethodBeat.i(60944);
        p.h(hVar, "$this$argumentsCount");
        int w = c.a.w(hVar);
        AppMethodBeat.o(60944);
        return w;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final m r(h hVar) {
        AppMethodBeat.i(60960);
        p.h(hVar, "$this$asTypeArgument");
        m x = c.a.x(hVar);
        AppMethodBeat.o(60960);
        return x;
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public final boolean s(h hVar) {
        AppMethodBeat.i(60963);
        p.h(hVar, "$this$isNullableType");
        boolean y = c.a.y(hVar);
        AppMethodBeat.o(60963);
        return y;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(boolean z, boolean z2, boolean z3, i iVar, int i2) {
        this(z, (i2 & 2) != 0 ? true : z2, (i2 & 4) != 0 ? true : z3, (i2 & 8) != 0 ? i.a.TPf : iVar);
        AppMethodBeat.i(186274);
        AppMethodBeat.o(186274);
    }

    private a(boolean z, boolean z2, boolean z3, i iVar) {
        p.h(iVar, "kotlinTypeRefiner");
        AppMethodBeat.i(186273);
        this.TOX = z;
        this.TOY = z2;
        this.TOZ = z3;
        this.THR = iVar;
        AppMethodBeat.o(186273);
    }

    @Override // kotlin.l.b.a.b.m.g
    public final h a(h hVar) {
        AppMethodBeat.i(60916);
        p.h(hVar, "type");
        if (!(hVar instanceof ab)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(b.fF(hVar).toString());
            AppMethodBeat.o(60916);
            throw illegalArgumentException;
        }
        n.a aVar = n.TPq;
        n.a.hLO();
        bg c2 = o.c(((ab) hVar).hLF());
        AppMethodBeat.o(60916);
        return c2;
    }

    @Override // kotlin.l.b.a.b.m.g
    public final h b(h hVar) {
        AppMethodBeat.i(60917);
        p.h(hVar, "type");
        if (!(hVar instanceof ab)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(b.fF(hVar).toString());
            AppMethodBeat.o(60917);
            throw illegalArgumentException;
        }
        ab aK = this.THR.aK((ab) hVar);
        AppMethodBeat.o(60917);
        return aK;
    }

    @Override // kotlin.l.b.a.b.m.g
    public final boolean hLv() {
        return this.TOX;
    }

    @Override // kotlin.l.b.a.b.m.g
    public final boolean hLw() {
        return this.TOY;
    }

    @Override // kotlin.l.b.a.b.m.g
    public final boolean a(kotlin.l.b.a.b.m.c.n nVar, kotlin.l.b.a.b.m.c.n nVar2) {
        AppMethodBeat.i(60918);
        p.h(nVar, "a");
        p.h(nVar2, "b");
        if (!(nVar instanceof at)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(b.fF(nVar).toString());
            AppMethodBeat.o(60918);
            throw illegalArgumentException;
        } else if (!(nVar2 instanceof at)) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(b.fF(nVar2).toString());
            AppMethodBeat.o(60918);
            throw illegalArgumentException2;
        } else {
            at atVar = (at) nVar;
            at atVar2 = (at) nVar2;
            p.h(atVar, "a");
            p.h(atVar2, "b");
            if (atVar instanceof kotlin.l.b.a.b.j.b.n) {
                boolean c2 = ((kotlin.l.b.a.b.j.b.n) atVar).c(atVar2);
                AppMethodBeat.o(60918);
                return c2;
            } else if (atVar2 instanceof kotlin.l.b.a.b.j.b.n) {
                boolean c3 = ((kotlin.l.b.a.b.j.b.n) atVar2).c(atVar);
                AppMethodBeat.o(60918);
                return c3;
            } else {
                boolean j2 = p.j(atVar, atVar2);
                AppMethodBeat.o(60918);
                return j2;
            }
        }
    }

    @Override // kotlin.l.b.a.b.m.g
    public final boolean c(h hVar) {
        AppMethodBeat.i(60920);
        p.h(hVar, "$this$isAllowedTypeVariable");
        if (!(hVar instanceof bg) || !this.TOZ || !(((bg) hVar).hKE() instanceof p)) {
            AppMethodBeat.o(60920);
            return false;
        }
        AppMethodBeat.o(60920);
        return true;
    }

    /* renamed from: kotlin.l.b.a.b.m.a.a$a  reason: collision with other inner class name */
    public static final class C2358a {
        private C2358a() {
        }

        public /* synthetic */ C2358a(byte b2) {
            this();
        }

        /* renamed from: kotlin.l.b.a.b.m.a.a$a$a  reason: collision with other inner class name */
        public static final class C2359a extends g.b.a {
            final /* synthetic */ c TPb;
            final /* synthetic */ ba TgS;

            C2359a(c cVar, ba baVar) {
                this.TPb = cVar;
                this.TgS = baVar;
            }

            @Override // kotlin.l.b.a.b.m.g.b
            public final j b(g gVar, h hVar) {
                AppMethodBeat.i(60915);
                p.h(gVar, "context");
                p.h(hVar, "type");
                c cVar = this.TPb;
                ba baVar = this.TgS;
                j e2 = this.TPb.e(hVar);
                if (e2 == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.types.KotlinType");
                    AppMethodBeat.o(60915);
                    throw tVar;
                }
                ab b2 = baVar.b((ab) e2, bh.INVARIANT);
                p.g(b2, "substitutor.safeSubstitu…ANT\n                    )");
                j o = cVar.o(b2);
                if (o == null) {
                    p.hyc();
                }
                AppMethodBeat.o(60915);
                return o;
            }
        }
    }

    @Override // kotlin.l.b.a.b.m.g
    public final List<j> a(j jVar, kotlin.l.b.a.b.m.c.n nVar) {
        AppMethodBeat.i(60974);
        p.h(jVar, "$this$fastCorrespondingSupertypes");
        p.h(nVar, "constructor");
        p.h(jVar, "$this$fastCorrespondingSupertypes");
        p.h(nVar, "constructor");
        p.h(jVar, "$this$fastCorrespondingSupertypes");
        p.h(nVar, "constructor");
        List<j> b2 = q.a.b(jVar, nVar);
        AppMethodBeat.o(60974);
        return b2;
    }

    @Override // kotlin.l.b.a.b.m.g
    public final m a(j jVar, int i2) {
        AppMethodBeat.i(60976);
        p.h(jVar, "$this$getArgumentOrNull");
        p.h(jVar, "$this$getArgumentOrNull");
        p.h(jVar, "$this$getArgumentOrNull");
        m a2 = q.a.a(this, jVar, i2);
        AppMethodBeat.o(60976);
        return a2;
    }

    @Override // kotlin.l.b.a.b.m.g
    public final boolean i(h hVar) {
        AppMethodBeat.i(60977);
        p.h(hVar, "$this$hasFlexibleNullability");
        p.h(hVar, "$this$hasFlexibleNullability");
        p.h(hVar, "$this$hasFlexibleNullability");
        boolean e2 = q.a.e(this, hVar);
        AppMethodBeat.o(60977);
        return e2;
    }

    @Override // kotlin.l.b.a.b.m.g
    public final boolean b(j jVar) {
        AppMethodBeat.i(60978);
        p.h(jVar, "$this$isClassType");
        p.h(jVar, "$this$isClassType");
        p.h(jVar, "$this$isClassType");
        boolean a2 = q.a.a((q) this, jVar);
        AppMethodBeat.o(60978);
        return a2;
    }

    @Override // kotlin.l.b.a.b.m.g
    public final boolean h(h hVar) {
        AppMethodBeat.i(60979);
        p.h(hVar, "$this$isDefinitelyNotNullType");
        p.h(hVar, "$this$isDefinitelyNotNullType");
        p.h(hVar, "$this$isDefinitelyNotNullType");
        boolean d2 = q.a.d(this, hVar);
        AppMethodBeat.o(60979);
        return d2;
    }

    @Override // kotlin.l.b.a.b.m.g
    public final boolean g(h hVar) {
        AppMethodBeat.i(60980);
        p.h(hVar, "$this$isDynamic");
        p.h(hVar, "$this$isDynamic");
        p.h(hVar, "$this$isDynamic");
        boolean c2 = q.a.c(this, hVar);
        AppMethodBeat.o(60980);
        return c2;
    }

    @Override // kotlin.l.b.a.b.m.g
    public final boolean c(j jVar) {
        AppMethodBeat.i(60981);
        p.h(jVar, "$this$isIntegerLiteralType");
        p.h(jVar, "$this$isIntegerLiteralType");
        p.h(jVar, "$this$isIntegerLiteralType");
        boolean b2 = q.a.b((q) this, jVar);
        AppMethodBeat.o(60981);
        return b2;
    }

    @Override // kotlin.l.b.a.b.m.g
    public final boolean j(h hVar) {
        AppMethodBeat.i(60982);
        p.h(hVar, "$this$isNothing");
        p.h(hVar, "$this$isNothing");
        p.h(hVar, "$this$isNothing");
        boolean g2 = q.a.g(this, hVar);
        AppMethodBeat.o(60982);
        return g2;
    }
}
