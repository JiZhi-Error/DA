package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.v;
import kotlin.l.b.a.b.j.i;
import kotlin.l.b.a.b.m.a.g;
import kotlin.l.b.a.b.m.at;

public final class a {
    public static final a THm = new a();

    /* access modifiers changed from: package-private */
    /* renamed from: kotlin.l.b.a.b.j.a$a  reason: collision with other inner class name */
    public static final class C2342a extends q implements m<l, l, Boolean> {
        public static final C2342a THn = new C2342a();

        static {
            AppMethodBeat.i(59873);
            AppMethodBeat.o(59873);
        }

        C2342a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* bridge */ /* synthetic */ Boolean invoke(l lVar, l lVar2) {
            return Boolean.FALSE;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b implements g.a {
        final /* synthetic */ boolean THo;
        final /* synthetic */ kotlin.l.b.a.b.b.a THp;
        final /* synthetic */ kotlin.l.b.a.b.b.a THq;

        b(boolean z, kotlin.l.b.a.b.b.a aVar, kotlin.l.b.a.b.b.a aVar2) {
            this.THo = z;
            this.THp = aVar;
            this.THq = aVar2;
        }

        @Override // kotlin.l.b.a.b.m.a.g.a
        public final /* synthetic */ boolean a(at atVar, at atVar2) {
            AppMethodBeat.i(59875);
            p.h(atVar, "c1");
            p.h(atVar2, "c2");
            if (p.j(atVar, atVar2)) {
                AppMethodBeat.o(59875);
                return true;
            }
            h hzS = atVar.hzS();
            h hzS2 = atVar2.hzS();
            if (!(hzS instanceof as) || !(hzS2 instanceof as)) {
                AppMethodBeat.o(59875);
                return false;
            }
            boolean a2 = a.a(a.THm, (as) hzS, (as) hzS2, this.THo, new m<l, l, Boolean>(this) {
                /* class kotlin.l.b.a.b.j.a.b.AnonymousClass1 */
                final /* synthetic */ b THr;

                {
                    this.THr = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.m
                public final /* synthetic */ Boolean invoke(l lVar, l lVar2) {
                    boolean z;
                    AppMethodBeat.i(59874);
                    l lVar3 = lVar2;
                    if (!p.j(lVar, this.THr.THp) || !p.j(lVar3, this.THr.THq)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    Boolean valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(59874);
                    return valueOf;
                }
            });
            AppMethodBeat.o(59875);
            return a2;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c extends q implements m<l, l, Boolean> {
        public static final c THs = new c();

        static {
            AppMethodBeat.i(59876);
            AppMethodBeat.o(59876);
        }

        c() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* bridge */ /* synthetic */ Boolean invoke(l lVar, l lVar2) {
            return Boolean.FALSE;
        }
    }

    static {
        AppMethodBeat.i(59881);
        AppMethodBeat.o(59881);
    }

    private a() {
    }

    public static final /* synthetic */ boolean a(a aVar, as asVar, as asVar2, boolean z, m mVar) {
        AppMethodBeat.i(59882);
        boolean a2 = aVar.a(asVar, asVar2, z, mVar);
        AppMethodBeat.o(59882);
        return a2;
    }

    public final boolean a(l lVar, l lVar2, boolean z) {
        AppMethodBeat.i(59877);
        if ((lVar instanceof e) && (lVar2 instanceof e)) {
            boolean j2 = p.j(((e) lVar).hzz(), ((e) lVar2).hzz());
            AppMethodBeat.o(59877);
            return j2;
        } else if ((lVar instanceof as) && (lVar2 instanceof as)) {
            boolean a2 = a((as) lVar, (as) lVar2, z, c.THs);
            AppMethodBeat.o(59877);
            return a2;
        } else if ((lVar instanceof kotlin.l.b.a.b.b.a) && (lVar2 instanceof kotlin.l.b.a.b.b.a)) {
            kotlin.l.b.a.b.b.a aVar = (kotlin.l.b.a.b.b.a) lVar;
            kotlin.l.b.a.b.b.a aVar2 = (kotlin.l.b.a.b.b.a) lVar2;
            p.h(aVar, "a");
            p.h(aVar2, "b");
            if (p.j(aVar, aVar2)) {
                AppMethodBeat.o(59877);
                return true;
            }
            if (!(!p.j(aVar.hAH(), aVar2.hAH())) && (!p.j(aVar.hzx(), aVar2.hzx()) || (z && !(!p.j(d(aVar), d(aVar2))) && (!(aVar instanceof v) || !(aVar2 instanceof v) || ((v) aVar).hzJ() == ((v) aVar2).hzJ())))) {
                if (c.m(aVar) || c.m(aVar2)) {
                    AppMethodBeat.o(59877);
                    return false;
                } else if (a(aVar, aVar2, C2342a.THn, z)) {
                    i a3 = i.a(new b(z, aVar, aVar2));
                    p.g(a3, "OverridingUtil.createWit…= a && y == b }\n        }");
                    i.a a4 = a3.a(aVar, aVar2, (e) null, true);
                    p.g(a4, "overridingUtil.isOverrid… null, !ignoreReturnType)");
                    if (a4.hKA() == i.a.EnumC2349a.OVERRIDABLE) {
                        i.a a5 = a3.a(aVar2, aVar, (e) null, true);
                        p.g(a5, "overridingUtil.isOverrid… null, !ignoreReturnType)");
                        if (a5.hKA() == i.a.EnumC2349a.OVERRIDABLE) {
                            AppMethodBeat.o(59877);
                            return true;
                        }
                    }
                }
            }
            AppMethodBeat.o(59877);
            return false;
        } else if (!(lVar instanceof ab) || !(lVar2 instanceof ab)) {
            boolean j3 = p.j(lVar, lVar2);
            AppMethodBeat.o(59877);
            return j3;
        } else {
            boolean j4 = p.j(((ab) lVar).hBk(), ((ab) lVar2).hBk());
            AppMethodBeat.o(59877);
            return j4;
        }
    }

    private final boolean a(as asVar, as asVar2, boolean z, m<? super l, ? super l, Boolean> mVar) {
        AppMethodBeat.i(59878);
        if (p.j(asVar, asVar2)) {
            AppMethodBeat.o(59878);
            return true;
        } else if (p.j(asVar.hzx(), asVar2.hzx())) {
            AppMethodBeat.o(59878);
            return false;
        } else if (!a(asVar, asVar2, mVar, z)) {
            AppMethodBeat.o(59878);
            return false;
        } else if (asVar.getIndex() == asVar2.getIndex()) {
            AppMethodBeat.o(59878);
            return true;
        } else {
            AppMethodBeat.o(59878);
            return false;
        }
    }

    private static an d(kotlin.l.b.a.b.b.a aVar) {
        AppMethodBeat.i(59879);
        kotlin.l.b.a.b.b.b bVar = aVar;
        while ((bVar instanceof kotlin.l.b.a.b.b.b) && ((kotlin.l.b.a.b.b.b) bVar).hAA() == b.a.FAKE_OVERRIDE) {
            Collection<? extends kotlin.l.b.a.b.b.b> hAy = ((kotlin.l.b.a.b.b.b) bVar).hAy();
            p.g(hAy, "overriddenDescriptors");
            kotlin.l.b.a.b.b.b bVar2 = (kotlin.l.b.a.b.b.b) j.j(hAy);
            if (bVar2 != null) {
                bVar = bVar2;
            } else {
                AppMethodBeat.o(59879);
                return null;
            }
        }
        an hzM = bVar.hzM();
        AppMethodBeat.o(59879);
        return hzM;
    }

    private final boolean a(l lVar, l lVar2, m<? super l, ? super l, Boolean> mVar, boolean z) {
        AppMethodBeat.i(59880);
        l hzx = lVar.hzx();
        l hzx2 = lVar2.hzx();
        if ((hzx instanceof kotlin.l.b.a.b.b.b) || (hzx2 instanceof kotlin.l.b.a.b.b.b)) {
            boolean booleanValue = mVar.invoke(hzx, hzx2).booleanValue();
            AppMethodBeat.o(59880);
            return booleanValue;
        }
        boolean a2 = a(hzx, hzx2, z);
        AppMethodBeat.o(59880);
        return a2;
    }
}
