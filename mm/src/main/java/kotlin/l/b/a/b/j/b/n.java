package kotlin.l.b.a.b.j.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.f;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.bh;
import kotlin.m;

public final class n implements at {
    public static final a TIC = new a((byte) 0);
    public final Set<ab> TIA;
    private final f TIB;
    private final y Tfp;
    private final aj TuN;
    private final long value;

    static {
        AppMethodBeat.i(60083);
        AppMethodBeat.o(60083);
    }

    static final class c extends q implements kotlin.g.a.b<ab, String> {
        public static final c TIH = new c();

        static {
            AppMethodBeat.i(60082);
            AppMethodBeat.o(60082);
        }

        c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(ab abVar) {
            AppMethodBeat.i(60081);
            ab abVar2 = abVar;
            p.h(abVar2, LocaleUtil.ITALIAN);
            String abVar3 = abVar2.toString();
            AppMethodBeat.o(60081);
            return abVar3;
        }
    }

    public static final class a {

        /* renamed from: kotlin.l.b.a.b.j.b.n$a$a  reason: collision with other inner class name */
        enum EnumC2343a {
            COMMON_SUPER_TYPE,
            INTERSECTION_TYPE;

            static {
                AppMethodBeat.i(60074);
                AppMethodBeat.o(60074);
            }

            public static EnumC2343a valueOf(String str) {
                AppMethodBeat.i(60076);
                EnumC2343a aVar = (EnumC2343a) Enum.valueOf(EnumC2343a.class, str);
                AppMethodBeat.o(60076);
                return aVar;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static aj A(Collection<? extends aj> collection) {
            Set b2;
            AppMethodBeat.i(60078);
            p.h(collection, "types");
            EnumC2343a aVar = EnumC2343a.INTERSECTION_TYPE;
            if (collection.isEmpty()) {
                AppMethodBeat.o(60078);
                return null;
            }
            Iterator<T> it = collection.iterator();
            if (!it.hasNext()) {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Empty collection can't be reduced.");
                AppMethodBeat.o(60078);
                throw unsupportedOperationException;
            }
            aj next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                aj ajVar = next;
                a aVar2 = n.TIC;
                if (ajVar == null || next2 == null) {
                    next = null;
                } else {
                    at hKE = ajVar.hKE();
                    at hKE2 = next2.hKE();
                    if ((hKE instanceof n) && (hKE2 instanceof n)) {
                        n nVar = (n) hKE;
                        n nVar2 = (n) hKE2;
                        switch (o.$EnumSwitchMapping$0[aVar.ordinal()]) {
                            case 1:
                                Set<ab> set = nVar.TIA;
                                Set<ab> set2 = nVar2.TIA;
                                p.h(set, "$this$intersect");
                                p.h(set2, FacebookRequestErrorClassification.KEY_OTHER);
                                Set u = j.u((Iterable) set);
                                Set set3 = u;
                                p.h(set3, "$this$retainAll");
                                p.h(set2, MessengerShareContentUtility.ELEMENTS);
                                af.eV(set3).retainAll(j.a((Iterable) set2, (Iterable) set3));
                                b2 = u;
                                break;
                            case 2:
                                b2 = j.b((Iterable) nVar.TIA, (Iterable) nVar2.TIA);
                                break;
                            default:
                                m mVar = new m();
                                AppMethodBeat.o(60078);
                                throw mVar;
                        }
                        n nVar3 = new n(nVar.value, nVar.Tfp, b2, (byte) 0);
                        g.a aVar3 = g.TiC;
                        next = ac.a(g.a.hBP(), nVar3);
                    } else if (hKE instanceof n) {
                        next = a((n) hKE, next2);
                    } else {
                        next = hKE2 instanceof n ? a((n) hKE2, ajVar) : null;
                    }
                }
            }
            aj ajVar2 = next;
            AppMethodBeat.o(60078);
            return ajVar2;
        }

        private static aj a(n nVar, aj ajVar) {
            AppMethodBeat.i(60079);
            if (nVar.TIA.contains(ajVar)) {
                AppMethodBeat.o(60079);
                return ajVar;
            }
            AppMethodBeat.o(60079);
            return null;
        }
    }

    public /* synthetic */ n(long j2, y yVar, Set set, byte b2) {
        this(j2, yVar, set);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.Set<? extends kotlin.l.b.a.b.m.ab> */
    /* JADX WARN: Multi-variable type inference failed */
    private n(long j2, y yVar, Set<? extends ab> set) {
        AppMethodBeat.i(60088);
        g.a aVar = g.TiC;
        this.TuN = ac.a(g.a.hBP(), this);
        this.TIB = kotlin.g.ah(new b(this));
        this.value = j2;
        this.Tfp = yVar;
        this.TIA = set;
        AppMethodBeat.o(60088);
    }

    @Override // kotlin.l.b.a.b.m.at
    public final boolean hzU() {
        return false;
    }

    @Override // kotlin.l.b.a.b.m.at
    public final h hzS() {
        return null;
    }

    @Override // kotlin.l.b.a.b.m.at
    public final kotlin.l.b.a.b.a.g hBh() {
        AppMethodBeat.i(60085);
        kotlin.l.b.a.b.a.g hBh = this.Tfp.hBh();
        AppMethodBeat.o(60085);
        return hBh;
    }

    public final String toString() {
        AppMethodBeat.i(60086);
        String str = "IntegerLiteralType" + ("[" + j.a(this.TIA, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, c.TIH, 30) + ']');
        AppMethodBeat.o(60086);
        return str;
    }

    public final boolean c(at atVar) {
        AppMethodBeat.i(60087);
        p.h(atVar, "constructor");
        Set<ab> set = this.TIA;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                if (p.j(it.next().hKE(), atVar)) {
                    AppMethodBeat.o(60087);
                    return true;
                }
            }
        }
        AppMethodBeat.o(60087);
        return false;
    }

    @Override // kotlin.l.b.a.b.m.at
    public final List<as> getParameters() {
        return v.SXr;
    }

    static final class b extends q implements kotlin.g.a.a<List<aj>> {
        final /* synthetic */ n TIG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(n nVar) {
            super(0);
            this.TIG = nVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<aj> invoke() {
            AppMethodBeat.i(60080);
            e btz = this.TIG.hBh().btz("Comparable");
            p.g(btz, "builtIns.comparable");
            aj hAG = btz.hAG();
            p.g(hAG, "builtIns.comparable.defaultType");
            List mutableListOf = j.mutableListOf(az.a(hAG, j.listOf(new ax(bh.IN_VARIANCE, this.TIG.TuN)), null, 2));
            if (!n.b(this.TIG)) {
                List list = mutableListOf;
                aj hAG2 = this.TIG.hBh().btz("Number").hAG();
                if (hAG2 == null) {
                    kotlin.l.b.a.b.a.g.atM(54);
                }
                list.add(hAG2);
            }
            AppMethodBeat.o(60080);
            return mutableListOf;
        }
    }

    @Override // kotlin.l.b.a.b.m.at
    public final Collection<ab> hBV() {
        AppMethodBeat.i(60084);
        List list = (List) this.TIB.getValue();
        AppMethodBeat.o(60084);
        return list;
    }

    public static final /* synthetic */ boolean b(n nVar) {
        boolean z;
        AppMethodBeat.i(60089);
        y yVar = nVar.Tfp;
        p.h(yVar, "$this$allSignedLiteralTypes");
        List<ab> listOf = j.listOf((Object[]) new aj[]{yVar.hBh().hzn(), yVar.hBh().hzo(), yVar.hBh().hzl(), yVar.hBh().hzm()});
        if (!(listOf instanceof Collection) || !listOf.isEmpty()) {
            for (ab abVar : listOf) {
                if (!nVar.TIA.contains(abVar)) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    AppMethodBeat.o(60089);
                    return false;
                }
            }
        }
        AppMethodBeat.o(60089);
        return true;
    }
}
