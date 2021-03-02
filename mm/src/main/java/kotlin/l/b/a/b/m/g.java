package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Set;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.m.c.h;
import kotlin.l.b.a.b.m.c.j;
import kotlin.l.b.a.b.m.c.l;
import kotlin.l.b.a.b.m.c.m;
import kotlin.l.b.a.b.m.c.n;
import kotlin.l.b.a.b.m.c.q;
import kotlin.l.b.a.b.o.i;

public abstract class g implements q {
    int TNn;
    private boolean TNo;
    ArrayDeque<j> TNp;
    Set<j> TNq;

    public enum a {
        CHECK_ONLY_LOWER,
        CHECK_SUBTYPE_AND_LOWER,
        SKIP_LOWER;

        static {
            AppMethodBeat.i(60590);
            AppMethodBeat.o(60590);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(60592);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(60592);
            return aVar;
        }
    }

    public abstract b a(j jVar);

    public abstract boolean a(n nVar, n nVar2);

    public abstract boolean c(h hVar);

    public abstract boolean hLv();

    public abstract boolean hLw();

    @Override // kotlin.l.b.a.b.m.c.q
    public int a(l lVar) {
        p.h(lVar, "$this$size");
        return q.a.a(this, lVar);
    }

    public List<j> a(j jVar, n nVar) {
        p.h(jVar, "$this$fastCorrespondingSupertypes");
        p.h(nVar, "constructor");
        return q.a.b(jVar, nVar);
    }

    public m a(j jVar, int i2) {
        p.h(jVar, "$this$getArgumentOrNull");
        return q.a.a(this, jVar, i2);
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public m a(l lVar, int i2) {
        p.h(lVar, "$this$get");
        return q.a.a(this, lVar, i2);
    }

    public boolean b(j jVar) {
        p.h(jVar, "$this$isClassType");
        return q.a.a((q) this, jVar);
    }

    public boolean c(j jVar) {
        p.h(jVar, "$this$isIntegerLiteralType");
        return q.a.b((q) this, jVar);
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public n d(h hVar) {
        p.h(hVar, "$this$typeConstructor");
        return q.a.f(this, hVar);
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public j e(h hVar) {
        p.h(hVar, "$this$lowerBoundIfFlexible");
        return q.a.a(this, hVar);
    }

    @Override // kotlin.l.b.a.b.m.c.q
    public j f(h hVar) {
        p.h(hVar, "$this$upperBoundIfFlexible");
        return q.a.b(this, hVar);
    }

    public boolean g(h hVar) {
        p.h(hVar, "$this$isDynamic");
        return q.a.c(this, hVar);
    }

    public boolean h(h hVar) {
        p.h(hVar, "$this$isDefinitelyNotNullType");
        return q.a.d(this, hVar);
    }

    public boolean i(h hVar) {
        p.h(hVar, "$this$hasFlexibleNullability");
        return q.a.e(this, hVar);
    }

    public boolean j(h hVar) {
        p.h(hVar, "$this$isNothing");
        return q.a.g(this, hVar);
    }

    public h a(h hVar) {
        p.h(hVar, "type");
        return hVar;
    }

    public h b(h hVar) {
        p.h(hVar, "type");
        return hVar;
    }

    public static Boolean a(h hVar, h hVar2) {
        p.h(hVar, "subType");
        p.h(hVar2, "superType");
        return null;
    }

    public final void initialize() {
        boolean z = !this.TNo;
        if (!aa.SXc || z) {
            this.TNo = true;
            if (this.TNp == null) {
                this.TNp = new ArrayDeque<>(4);
            }
            if (this.TNq == null) {
                i.b bVar = i.TSf;
                this.TNq = i.b.hLZ();
                return;
            }
            return;
        }
        throw new AssertionError("Assertion failed");
    }

    public final void clear() {
        ArrayDeque<j> arrayDeque = this.TNp;
        if (arrayDeque == null) {
            p.hyc();
        }
        arrayDeque.clear();
        Set<j> set = this.TNq;
        if (set == null) {
            p.hyc();
        }
        set.clear();
        this.TNo = false;
    }

    public static abstract class b {
        public abstract j b(g gVar, h hVar);

        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        public static final class c extends b {
            public static final c TNw = new c();

            static {
                AppMethodBeat.i(60599);
                AppMethodBeat.o(60599);
            }

            private c() {
                super((byte) 0);
            }

            @Override // kotlin.l.b.a.b.m.g.b
            public final /* synthetic */ j b(g gVar, h hVar) {
                AppMethodBeat.i(60598);
                p.h(gVar, "context");
                p.h(hVar, "type");
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Should not be called");
                AppMethodBeat.o(60598);
                throw unsupportedOperationException;
            }
        }

        public static final class d extends b {
            public static final d TNx = new d();

            static {
                AppMethodBeat.i(60601);
                AppMethodBeat.o(60601);
            }

            private d() {
                super((byte) 0);
            }

            @Override // kotlin.l.b.a.b.m.g.b
            public final j b(g gVar, h hVar) {
                AppMethodBeat.i(60600);
                p.h(gVar, "context");
                p.h(hVar, "type");
                j f2 = gVar.f(hVar);
                AppMethodBeat.o(60600);
                return f2;
            }
        }

        /* renamed from: kotlin.l.b.a.b.m.g$b$b  reason: collision with other inner class name */
        public static final class C2363b extends b {
            public static final C2363b TNv = new C2363b();

            static {
                AppMethodBeat.i(60597);
                AppMethodBeat.o(60597);
            }

            private C2363b() {
                super((byte) 0);
            }

            @Override // kotlin.l.b.a.b.m.g.b
            public final j b(g gVar, h hVar) {
                AppMethodBeat.i(60596);
                p.h(gVar, "context");
                p.h(hVar, "type");
                j e2 = gVar.e(hVar);
                AppMethodBeat.o(60596);
                return e2;
            }
        }

        public static abstract class a extends b {
            public a() {
                super((byte) 0);
            }
        }
    }

    @Override // kotlin.l.b.a.b.m.c.s
    public boolean a(j jVar, j jVar2) {
        p.h(jVar, "a");
        p.h(jVar2, "b");
        p.h(jVar, "a");
        p.h(jVar2, "b");
        p.h(jVar, "a");
        p.h(jVar2, "b");
        return false;
    }
}
