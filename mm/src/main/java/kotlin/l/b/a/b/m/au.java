package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.as;

public abstract class au extends ay {
    public static final a TOz = new a((byte) 0);

    public static final ay a(at atVar, List<? extends av> list) {
        return a.a(atVar, list);
    }

    public abstract av d(at atVar);

    @Override // kotlin.l.b.a.b.m.ay
    public final av N(ab abVar) {
        p.h(abVar, "key");
        return d(abVar.hKE());
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* renamed from: kotlin.l.b.a.b.m.au$a$a  reason: collision with other inner class name */
        public static final class C2361a extends au {
            final /* synthetic */ Map TOA;
            final /* synthetic */ boolean TOB = false;

            C2361a(Map map, boolean z) {
                this.TOA = map;
            }

            @Override // kotlin.l.b.a.b.m.au
            public final av d(at atVar) {
                AppMethodBeat.i(60831);
                p.h(atVar, "key");
                av avVar = (av) this.TOA.get(atVar);
                AppMethodBeat.o(60831);
                return avVar;
            }

            @Override // kotlin.l.b.a.b.m.ay
            public final boolean isEmpty() {
                AppMethodBeat.i(60832);
                boolean isEmpty = this.TOA.isEmpty();
                AppMethodBeat.o(60832);
                return isEmpty;
            }

            @Override // kotlin.l.b.a.b.m.ay
            public final boolean hLy() {
                return this.TOB;
            }
        }

        public static au cC(Map<at, ? extends av> map) {
            AppMethodBeat.i(60833);
            p.h(map, "map");
            C2361a aVar = new C2361a(map, false);
            AppMethodBeat.o(60833);
            return aVar;
        }

        public final ay ax(ab abVar) {
            AppMethodBeat.i(60834);
            p.h(abVar, "kotlinType");
            ay a2 = a(abVar.hKE(), abVar.hKB());
            AppMethodBeat.o(60834);
            return a2;
        }

        public static ay a(at atVar, List<? extends av> list) {
            AppMethodBeat.i(60835);
            p.h(atVar, "typeConstructor");
            p.h(list, "arguments");
            List<as> parameters = atVar.getParameters();
            p.g(parameters, "typeConstructor.parameters");
            as asVar = (as) j.kv(parameters);
            if (asVar != null ? asVar.hAC() : false) {
                List<as> parameters2 = atVar.getParameters();
                p.g(parameters2, "typeConstructor.parameters");
                List<as> list2 = parameters2;
                ArrayList arrayList = new ArrayList(j.a(list2, 10));
                for (T t : list2) {
                    p.g(t, LocaleUtil.ITALIAN);
                    arrayList.add(t.hzz());
                }
                au cC = cC(ae.E(j.c((Iterable) arrayList, (Iterable) list)));
                AppMethodBeat.o(60835);
                return cC;
            }
            z zVar = new z(parameters, list);
            AppMethodBeat.o(60835);
            return zVar;
        }
    }

    public static final au cB(Map<at, ? extends av> map) {
        return a.cC(map);
    }
}
