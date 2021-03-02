package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.List;
import kotlin.g.a.b;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.k;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.i.h;
import kotlin.l.b.a.b.i.i;
import kotlin.l.b.a.b.m.ab;
import kotlin.x;

public class f implements Comparator<l> {
    static final /* synthetic */ boolean $assertionsDisabled = (!f.class.desiredAssertionStatus());
    public static final f THL = new f();
    private static final c THM = c.a.T(new b<i, x>() {
        /* class kotlin.l.b.a.b.j.f.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(i iVar) {
            AppMethodBeat.i(59946);
            i iVar2 = iVar;
            iVar2.EO(false);
            iVar2.EN(true);
            iVar2.a(kotlin.l.b.a.b.i.a.UNLESS_EMPTY);
            iVar2.E(h.TFT);
            x xVar = x.SXb;
            AppMethodBeat.o(59946);
            return xVar;
        }
    });

    static {
        AppMethodBeat.i(59953);
        c.a aVar = c.TFl;
        AppMethodBeat.o(59953);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public /* synthetic */ int compare(l lVar, l lVar2) {
        int compareTo;
        boolean z = true;
        AppMethodBeat.i(59952);
        l lVar3 = lVar;
        l lVar4 = lVar2;
        Integer f2 = a.f(lVar3, lVar4);
        if (f2 != null) {
            int intValue = f2.intValue();
            AppMethodBeat.o(59952);
            return intValue;
        }
        if ((lVar3 instanceof ar) && (lVar4 instanceof ar)) {
            int compareTo2 = THM.b(((ar) lVar3).hBv()).compareTo(THM.b(((ar) lVar4).hBv()));
            if (compareTo2 != 0) {
                AppMethodBeat.o(59952);
                return compareTo2;
            }
        } else if ((lVar3 instanceof kotlin.l.b.a.b.b.a) && (lVar4 instanceof kotlin.l.b.a.b.b.a)) {
            kotlin.l.b.a.b.b.a aVar = (kotlin.l.b.a.b.b.a) lVar3;
            kotlin.l.b.a.b.b.a aVar2 = (kotlin.l.b.a.b.b.a) lVar4;
            ak hAr = aVar.hAr();
            ak hAr2 = aVar2.hAr();
            if (!$assertionsDisabled) {
                boolean z2 = hAr != null;
                if (hAr2 == null) {
                    z = false;
                }
                if (z2 != z) {
                    AssertionError assertionError = new AssertionError();
                    AppMethodBeat.o(59952);
                    throw assertionError;
                }
            }
            if (hAr == null || (compareTo = THM.b(hAr.hBy()).compareTo(THM.b(hAr2.hBy()))) == 0) {
                List<av> hAw = aVar.hAw();
                List<av> hAw2 = aVar2.hAw();
                for (int i2 = 0; i2 < Math.min(hAw.size(), hAw2.size()); i2++) {
                    int compareTo3 = THM.b(hAw.get(i2).hBy()).compareTo(THM.b(hAw2.get(i2).hBy()));
                    if (compareTo3 != 0) {
                        AppMethodBeat.o(59952);
                        return compareTo3;
                    }
                }
                int size = hAw.size() - hAw2.size();
                if (size != 0) {
                    AppMethodBeat.o(59952);
                    return size;
                }
                List<as> hAt = aVar.hAt();
                List<as> hAt2 = aVar2.hAt();
                for (int i3 = 0; i3 < Math.min(hAt.size(), hAt2.size()); i3++) {
                    List<ab> hyo = hAt.get(i3).hyo();
                    List<ab> hyo2 = hAt2.get(i3).hyo();
                    int size2 = hyo.size() - hyo2.size();
                    if (size2 != 0) {
                        AppMethodBeat.o(59952);
                        return size2;
                    }
                    for (int i4 = 0; i4 < hyo.size(); i4++) {
                        int compareTo4 = THM.b(hyo.get(i4)).compareTo(THM.b(hyo2.get(i4)));
                        if (compareTo4 != 0) {
                            AppMethodBeat.o(59952);
                            return compareTo4;
                        }
                    }
                }
                int size3 = hAt.size() - hAt2.size();
                if (size3 != 0) {
                    AppMethodBeat.o(59952);
                    return size3;
                } else if ((aVar instanceof kotlin.l.b.a.b.b.b) && (aVar2 instanceof kotlin.l.b.a.b.b.b)) {
                    int ordinal = ((kotlin.l.b.a.b.b.b) aVar).hAA().ordinal() - ((kotlin.l.b.a.b.b.b) aVar2).hAA().ordinal();
                    if (ordinal != 0) {
                        AppMethodBeat.o(59952);
                        return ordinal;
                    }
                }
            } else {
                AppMethodBeat.o(59952);
                return compareTo;
            }
        } else if (!(lVar3 instanceof e) || !(lVar4 instanceof e)) {
            AssertionError assertionError2 = new AssertionError(String.format("Unsupported pair of descriptors:\n'%s' Class: %s\n%s' Class: %s", lVar3, lVar3.getClass(), lVar4, lVar4.getClass()));
            AppMethodBeat.o(59952);
            throw assertionError2;
        } else {
            e eVar = (e) lVar3;
            e eVar2 = (e) lVar4;
            if (eVar.hzB().ordinal() != eVar2.hzB().ordinal()) {
                int ordinal2 = eVar.hzB().ordinal() - eVar2.hzB().ordinal();
                AppMethodBeat.o(59952);
                return ordinal2;
            } else if (eVar.hzF() != eVar2.hzF()) {
                if (eVar.hzF()) {
                    AppMethodBeat.o(59952);
                    return 1;
                }
                AppMethodBeat.o(59952);
                return -1;
            }
        }
        int compareTo5 = THM.k(lVar3).compareTo(THM.k(lVar4));
        if (compareTo5 != 0) {
            AppMethodBeat.o(59952);
            return compareTo5;
        }
        int u = c.s(lVar3).hAH().u(c.s(lVar4).hAH());
        AppMethodBeat.o(59952);
        return u;
    }

    private f() {
    }

    public static class a implements Comparator<l> {
        public static final a THN = new a();

        static /* synthetic */ Integer f(l lVar, l lVar2) {
            AppMethodBeat.i(59950);
            Integer e2 = e(lVar, lVar2);
            AppMethodBeat.o(59950);
            return e2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(l lVar, l lVar2) {
            AppMethodBeat.i(59949);
            Integer e2 = e(lVar, lVar2);
            if (e2 != null) {
                int intValue = e2.intValue();
                AppMethodBeat.o(59949);
                return intValue;
            }
            AppMethodBeat.o(59949);
            return 0;
        }

        static {
            AppMethodBeat.i(59951);
            AppMethodBeat.o(59951);
        }

        private a() {
        }

        private static int E(l lVar) {
            AppMethodBeat.i(59947);
            if (c.x(lVar)) {
                AppMethodBeat.o(59947);
                return 8;
            } else if (lVar instanceof k) {
                AppMethodBeat.o(59947);
                return 7;
            } else if (lVar instanceof ah) {
                if (((ah) lVar).hAr() == null) {
                    AppMethodBeat.o(59947);
                    return 6;
                }
                AppMethodBeat.o(59947);
                return 5;
            } else if (lVar instanceof t) {
                if (((t) lVar).hAr() == null) {
                    AppMethodBeat.o(59947);
                    return 4;
                }
                AppMethodBeat.o(59947);
                return 3;
            } else if (lVar instanceof e) {
                AppMethodBeat.o(59947);
                return 2;
            } else if (lVar instanceof ar) {
                AppMethodBeat.o(59947);
                return 1;
            } else {
                AppMethodBeat.o(59947);
                return 0;
            }
        }

        private static Integer e(l lVar, l lVar2) {
            AppMethodBeat.i(59948);
            int E = E(lVar2) - E(lVar);
            if (E != 0) {
                Integer valueOf = Integer.valueOf(E);
                AppMethodBeat.o(59948);
                return valueOf;
            } else if (!c.x(lVar) || !c.x(lVar2)) {
                int u = lVar.hAH().u(lVar2.hAH());
                if (u != 0) {
                    Integer valueOf2 = Integer.valueOf(u);
                    AppMethodBeat.o(59948);
                    return valueOf2;
                }
                AppMethodBeat.o(59948);
                return null;
            } else {
                AppMethodBeat.o(59948);
                return 0;
            }
        }
    }
}
