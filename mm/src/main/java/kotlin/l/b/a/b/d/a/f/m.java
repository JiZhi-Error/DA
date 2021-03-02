package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.e;
import kotlin.a.y;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l.b.a.b.d.b.v;
import kotlin.l.b.a.b.j.e.d;
import kotlin.o;
import kotlin.s;
import kotlin.x;

final class m {
    final Map<String, j> TuJ = new LinkedHashMap();

    public m() {
        AppMethodBeat.i(58117);
        AppMethodBeat.o(58117);
    }

    public final class a {
        final /* synthetic */ m TuK;
        final String className;

        public a(m mVar, String str) {
            p.h(str, "className");
            this.TuK = mVar;
            AppMethodBeat.i(58116);
            this.className = str;
            AppMethodBeat.o(58116);
        }

        public final void p(String str, b<? super C2291a, x> bVar) {
            AppMethodBeat.i(58115);
            p.h(str, "name");
            p.h(bVar, "block");
            Map<String, j> map = this.TuK.TuJ;
            C2291a aVar = new C2291a(this, str);
            bVar.invoke(aVar);
            o<String, j> hEg = aVar.hEg();
            map.put(hEg.first, hEg.second);
            AppMethodBeat.o(58115);
        }

        /* renamed from: kotlin.l.b.a.b.d.a.f.m$a$a  reason: collision with other inner class name */
        public final class C2291a {
            private o<String, r> TuL = s.U("V", null);
            final /* synthetic */ a TuM;
            private final String nlH;
            private final List<o<String, r>> parameters = new ArrayList();

            public C2291a(a aVar, String str) {
                p.h(str, "functionName");
                this.TuM = aVar;
                AppMethodBeat.i(58114);
                this.nlH = str;
                AppMethodBeat.o(58114);
            }

            public final void a(String str, d... dVarArr) {
                r rVar;
                AppMethodBeat.i(58110);
                p.h(str, "type");
                p.h(dVarArr, "qualifiers");
                List<o<String, r>> list = this.parameters;
                if (dVarArr.length == 0) {
                    rVar = null;
                } else {
                    Iterable Z = e.Z(dVarArr);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(j.mZ(ae.atJ(kotlin.a.j.a(Z, 10)), 16));
                    for (Object obj : Z) {
                        linkedHashMap.put(Integer.valueOf(((y) obj).index), ((y) obj).value);
                    }
                    rVar = new r(linkedHashMap);
                }
                list.add(s.U(str, rVar));
                AppMethodBeat.o(58110);
            }

            public final void b(String str, d... dVarArr) {
                AppMethodBeat.i(58111);
                p.h(str, "type");
                p.h(dVarArr, "qualifiers");
                Iterable Z = e.Z(dVarArr);
                LinkedHashMap linkedHashMap = new LinkedHashMap(j.mZ(ae.atJ(kotlin.a.j.a(Z, 10)), 16));
                for (Object obj : Z) {
                    linkedHashMap.put(Integer.valueOf(((y) obj).index), ((y) obj).value);
                }
                this.TuL = s.U(str, new r(linkedHashMap));
                AppMethodBeat.o(58111);
            }

            public final void a(d dVar) {
                AppMethodBeat.i(58112);
                p.h(dVar, "type");
                this.TuL = s.U(dVar.getDesc(), null);
                AppMethodBeat.o(58112);
            }

            public final o<String, j> hEg() {
                AppMethodBeat.i(58113);
                v vVar = v.TvS;
                String str = this.TuM.className;
                String str2 = this.nlH;
                List<o<String, r>> list = this.parameters;
                ArrayList arrayList = new ArrayList(kotlin.a.j.a(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().first);
                }
                String ov = v.ov(str, v.e(str2, arrayList, this.TuL.first));
                B b2 = this.TuL.second;
                List<o<String, r>> list2 = this.parameters;
                ArrayList arrayList2 = new ArrayList(kotlin.a.j.a(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(it2.next().second);
                }
                o<String, j> U = s.U(ov, new j(b2, arrayList2));
                AppMethodBeat.o(58113);
                return U;
            }
        }
    }
}
