package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.d.b.a.a;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.e.c.a.f;
import kotlin.l.b.a.b.e.c.a.g;
import kotlin.l.b.a.b.e.c.a.i;
import kotlin.l.b.a.b.h.k;
import kotlin.l.b.a.b.k.a.h;
import kotlin.l.b.a.b.k.a.l;
import kotlin.l.b.a.b.k.a.t;
import kotlin.o;

public final class e {
    private static final Set<a.EnumC2293a> Tvu = ak.setOf(a.EnumC2293a.CLASS);
    private static final Set<a.EnumC2293a> Tvv = ak.setOf((Object[]) new a.EnumC2293a[]{a.EnumC2293a.FILE_FACADE, a.EnumC2293a.MULTIFILE_CLASS_PART});
    private static final f Tvw = new f(1, 1, 2);
    private static final f Tvx = new f(1, 1, 11);
    private static final f Tvy = new f(1, 1, 13);
    public static final a Tvz = new a((byte) 0);
    public l Tvt;

    public final l hEh() {
        AppMethodBeat.i(58183);
        l lVar = this.Tvt;
        if (lVar == null) {
            p.btv("components");
        }
        AppMethodBeat.o(58183);
        return lVar;
    }

    private final boolean hEi() {
        AppMethodBeat.i(58184);
        if (this.Tvt == null) {
            p.btv("components");
        }
        AppMethodBeat.o(58184);
        return false;
    }

    public final h a(p pVar) {
        o<g, a.b> oVar;
        AppMethodBeat.i(58185);
        p.h(pVar, "kotlinClass");
        String[] a2 = a(pVar, Tvu);
        if (a2 == null) {
            AppMethodBeat.o(58185);
            return null;
        }
        String[] strArr = pVar.hCA().strings;
        if (strArr == null) {
            AppMethodBeat.o(58185);
            return null;
        }
        try {
            oVar = i.e(a2, strArr);
        } catch (k e2) {
            IllegalStateException illegalStateException = new IllegalStateException("Could not read data from " + pVar.getLocation(), e2);
            AppMethodBeat.o(58185);
            throw illegalStateException;
        } catch (Throwable th) {
            hEi();
            if (pVar.hCA().Twm.hIi()) {
                AppMethodBeat.o(58185);
                throw th;
            }
            oVar = null;
        }
        if (oVar == null) {
            AppMethodBeat.o(58185);
            return null;
        }
        h hVar = new h(oVar.first, oVar.second, pVar.hCA().Twm, new r(pVar, b(pVar), c(pVar)));
        AppMethodBeat.o(58185);
        return hVar;
    }

    public final kotlin.l.b.a.b.j.f.h a(ab abVar, p pVar) {
        o<g, a.k> oVar;
        AppMethodBeat.i(58186);
        p.h(abVar, "descriptor");
        p.h(pVar, "kotlinClass");
        String[] a2 = a(pVar, Tvv);
        if (a2 == null) {
            AppMethodBeat.o(58186);
            return null;
        }
        String[] strArr = pVar.hCA().strings;
        if (strArr == null) {
            AppMethodBeat.o(58186);
            return null;
        }
        try {
            oVar = i.f(a2, strArr);
        } catch (k e2) {
            IllegalStateException illegalStateException = new IllegalStateException("Could not read data from " + pVar.getLocation(), e2);
            AppMethodBeat.o(58186);
            throw illegalStateException;
        } catch (Throwable th) {
            hEi();
            if (pVar.hCA().Twm.hIi()) {
                AppMethodBeat.o(58186);
                throw th;
            }
            oVar = null;
        }
        if (oVar == null) {
            AppMethodBeat.o(58186);
            return null;
        }
        A a3 = oVar.first;
        B b2 = oVar.second;
        j jVar = new j(pVar, b2, a3, b(pVar), c(pVar));
        A a4 = a3;
        f fVar = pVar.hCA().Twm;
        j jVar2 = jVar;
        l lVar = this.Tvt;
        if (lVar == null) {
            p.btv("components");
        }
        kotlin.l.b.a.b.k.a.b.i iVar = new kotlin.l.b.a.b.k.a.b.i(abVar, b2, a4, fVar, jVar2, lVar, b.TvA);
        AppMethodBeat.o(58186);
        return iVar;
    }

    private final t<f> b(p pVar) {
        AppMethodBeat.i(58187);
        hEi();
        if (pVar.hCA().Twm.hIi()) {
            AppMethodBeat.o(58187);
            return null;
        }
        t<f> tVar = new t<>(pVar.hCA().Twm, f.TCE, pVar.getLocation(), pVar.hyy());
        AppMethodBeat.o(58187);
        return tVar;
    }

    private final boolean c(p pVar) {
        AppMethodBeat.i(58188);
        if (this.Tvt == null) {
            p.btv("components");
        }
        if (d(pVar)) {
            AppMethodBeat.o(58188);
            return true;
        }
        AppMethodBeat.o(58188);
        return false;
    }

    private final boolean d(p pVar) {
        AppMethodBeat.i(58189);
        if (this.Tvt == null) {
            p.btv("components");
        }
        if (!pVar.hCA().hEq() || !p.j(pVar.hCA().Twm, Tvx)) {
            AppMethodBeat.o(58189);
            return false;
        }
        AppMethodBeat.o(58189);
        return true;
    }

    private static String[] a(p pVar, Set<? extends a.EnumC2293a> set) {
        AppMethodBeat.i(58190);
        kotlin.l.b.a.b.d.b.a.a hCA = pVar.hCA();
        String[] strArr = hCA.Two;
        if (strArr == null) {
            strArr = hCA.Twp;
        }
        if (strArr == null) {
            AppMethodBeat.o(58190);
            return null;
        } else if (set.contains(hCA.Twl)) {
            AppMethodBeat.o(58190);
            return strArr;
        } else {
            AppMethodBeat.o(58190);
            return null;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(58191);
        AppMethodBeat.o(58191);
    }

    static final class b extends q implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.f.f>> {
        public static final b TvA = new b();

        static {
            AppMethodBeat.i(58182);
            AppMethodBeat.o(58182);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ List<? extends kotlin.l.b.a.b.f.f> invoke() {
            return v.SXr;
        }
    }
}
