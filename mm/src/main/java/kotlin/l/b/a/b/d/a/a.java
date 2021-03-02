package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.v;
import kotlin.g.b.aa;
import kotlin.g.b.n;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.f;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.l.d;
import kotlin.l.b.a.b.l.j;

public final class a {
    public final boolean HIg = this.Tob.hLT();
    private final d<e, kotlin.l.b.a.b.b.a.c> Toa;
    public final kotlin.l.b.a.b.o.e Tob;

    /* renamed from: kotlin.l.b.a.b.d.a.a$a  reason: collision with other inner class name */
    public enum EnumC2281a {
        METHOD_RETURN_TYPE,
        VALUE_PARAMETER,
        FIELD,
        TYPE_USE;

        static {
            AppMethodBeat.i(57527);
            AppMethodBeat.o(57527);
        }

        public static EnumC2281a valueOf(String str) {
            AppMethodBeat.i(57529);
            EnumC2281a aVar = (EnumC2281a) Enum.valueOf(EnumC2281a.class, str);
            AppMethodBeat.o(57529);
            return aVar;
        }
    }

    static final /* synthetic */ class c extends n implements kotlin.g.a.b<e, kotlin.l.b.a.b.b.a.c> {
        c(a aVar) {
            super(1, aVar);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(57534);
            kotlin.l.b bp = aa.bp(a.class);
            AppMethodBeat.o(57534);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "computeTypeQualifierNickname";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "computeTypeQualifierNickname(Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;)Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.l.b.a.b.b.a.c invoke(e eVar) {
            AppMethodBeat.i(57533);
            e eVar2 = eVar;
            p.h(eVar2, "p1");
            kotlin.l.b.a.b.b.a.c a2 = a.a((a) this.SYl, eVar2);
            AppMethodBeat.o(57533);
            return a2;
        }
    }

    public a(j jVar, kotlin.l.b.a.b.o.e eVar) {
        p.h(jVar, "storageManager");
        p.h(eVar, "jsr305State");
        AppMethodBeat.i(57541);
        this.Tob = eVar;
        this.Toa = jVar.V(new c(this));
        AppMethodBeat.o(57541);
    }

    public static final class b {
        public final kotlin.l.b.a.b.b.a.c Toh;
        private final int Toi;

        public b(kotlin.l.b.a.b.b.a.c cVar, int i2) {
            p.h(cVar, "typeQualifier");
            AppMethodBeat.i(57532);
            this.Toh = cVar;
            this.Toi = i2;
            AppMethodBeat.o(57532);
        }

        public final List<EnumC2281a> hDm() {
            AppMethodBeat.i(57530);
            EnumC2281a[] values = EnumC2281a.values();
            ArrayList arrayList = new ArrayList();
            for (EnumC2281a aVar : values) {
                b bVar = this;
                if (bVar.a(EnumC2281a.TYPE_USE) || bVar.a(aVar)) {
                    arrayList.add(aVar);
                }
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(57530);
            return arrayList2;
        }

        private final boolean a(EnumC2281a aVar) {
            AppMethodBeat.i(57531);
            if ((this.Toi & (1 << aVar.ordinal())) != 0) {
                AppMethodBeat.o(57531);
                return true;
            }
            AppMethodBeat.o(57531);
            return false;
        }
    }

    public final kotlin.l.b.a.b.b.a.c d(kotlin.l.b.a.b.b.a.c cVar) {
        AppMethodBeat.i(57535);
        p.h(cVar, "annotationDescriptor");
        if (this.Tob.hLT()) {
            AppMethodBeat.o(57535);
            return null;
        }
        e l = kotlin.l.b.a.b.j.d.a.l(cVar);
        if (l == null) {
            AppMethodBeat.o(57535);
            return null;
        } else if (b.r(l)) {
            AppMethodBeat.o(57535);
            return cVar;
        } else if (l.hzB() != f.ANNOTATION_CLASS) {
            AppMethodBeat.o(57535);
            return null;
        } else {
            kotlin.l.b.a.b.b.a.c invoke = this.Toa.invoke(l);
            AppMethodBeat.o(57535);
            return invoke;
        }
    }

    public final b e(kotlin.l.b.a.b.b.a.c cVar) {
        Object obj;
        boolean z;
        v vVar;
        AppMethodBeat.i(57536);
        p.h(cVar, "annotationDescriptor");
        if (this.Tob.hLT()) {
            AppMethodBeat.o(57536);
            return null;
        }
        e l = kotlin.l.b.a.b.j.d.a.l(cVar);
        if (l != null) {
            e eVar = l.hzL().h(b.hDo()) ? l : null;
            if (eVar != null) {
                e l2 = kotlin.l.b.a.b.j.d.a.l(cVar);
                if (l2 == null) {
                    p.hyc();
                }
                kotlin.l.b.a.b.b.a.c g2 = l2.hzL().g(b.hDo());
                if (g2 == null) {
                    p.hyc();
                }
                Map<kotlin.l.b.a.b.f.f, g<?>> hBO = g2.hBO();
                ArrayList<EnumC2281a> arrayList = new ArrayList();
                for (Map.Entry<kotlin.l.b.a.b.f.f, g<?>> entry : hBO.entrySet()) {
                    g<?> value = entry.getValue();
                    if (p.j(entry.getKey(), p.Tpl)) {
                        vVar = a(value);
                    } else {
                        vVar = v.SXr;
                    }
                    kotlin.a.j.a((Collection) arrayList, (Iterable) vVar);
                }
                int i2 = 0;
                for (EnumC2281a aVar : arrayList) {
                    i2 = (1 << aVar.ordinal()) | i2;
                }
                Iterator it = eVar.hzL().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object next = it.next();
                    if (d((kotlin.l.b.a.b.b.a.c) next) != null) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        obj = next;
                        break;
                    }
                }
                kotlin.l.b.a.b.b.a.c cVar2 = (kotlin.l.b.a.b.b.a.c) obj;
                if (cVar2 == null) {
                    AppMethodBeat.o(57536);
                    return null;
                }
                b bVar = new b(cVar2, i2);
                AppMethodBeat.o(57536);
                return bVar;
            }
        }
        AppMethodBeat.o(57536);
        return null;
    }

    public final kotlin.l.b.a.b.o.g f(kotlin.l.b.a.b.b.a.c cVar) {
        AppMethodBeat.i(57537);
        p.h(cVar, "annotationDescriptor");
        kotlin.l.b.a.b.o.g g2 = g(cVar);
        if (g2 != null) {
            AppMethodBeat.o(57537);
            return g2;
        }
        kotlin.l.b.a.b.o.g gVar = this.Tob.TRK;
        AppMethodBeat.o(57537);
        return gVar;
    }

    public final kotlin.l.b.a.b.o.g g(kotlin.l.b.a.b.b.a.c cVar) {
        String str;
        AppMethodBeat.i(57538);
        p.h(cVar, "annotationDescriptor");
        Map<String, kotlin.l.b.a.b.o.g> map = this.Tob.TRM;
        kotlin.l.b.a.b.f.b hBk = cVar.hBk();
        if (hBk != null) {
            str = hBk.sG();
        } else {
            str = null;
        }
        kotlin.l.b.a.b.o.g gVar = map.get(str);
        if (gVar != null) {
            AppMethodBeat.o(57538);
            return gVar;
        }
        e l = kotlin.l.b.a.b.j.d.a.l(cVar);
        if (l != null) {
            kotlin.l.b.a.b.o.g q = q(l);
            AppMethodBeat.o(57538);
            return q;
        }
        AppMethodBeat.o(57538);
        return null;
    }

    private final kotlin.l.b.a.b.o.g q(e eVar) {
        AppMethodBeat.i(57539);
        kotlin.l.b.a.b.b.a.c g2 = eVar.hzL().g(b.hDp());
        g<?> m = g2 != null ? kotlin.l.b.a.b.j.d.a.m(g2) : null;
        if (!(m instanceof kotlin.l.b.a.b.j.b.j)) {
            m = null;
        }
        kotlin.l.b.a.b.j.b.j jVar = (kotlin.l.b.a.b.j.b.j) m;
        if (jVar == null) {
            AppMethodBeat.o(57539);
            return null;
        }
        kotlin.l.b.a.b.o.g gVar = this.Tob.TRL;
        if (gVar != null) {
            AppMethodBeat.o(57539);
            return gVar;
        }
        String sG = jVar.TIy.sG();
        switch (sG.hashCode()) {
            case -2137067054:
                if (sG.equals("IGNORE")) {
                    kotlin.l.b.a.b.o.g gVar2 = kotlin.l.b.a.b.o.g.IGNORE;
                    AppMethodBeat.o(57539);
                    return gVar2;
                }
                break;
            case -1838656823:
                if (sG.equals("STRICT")) {
                    kotlin.l.b.a.b.o.g gVar3 = kotlin.l.b.a.b.o.g.STRICT;
                    AppMethodBeat.o(57539);
                    return gVar3;
                }
                break;
            case 2656902:
                if (sG.equals("WARN")) {
                    kotlin.l.b.a.b.o.g gVar4 = kotlin.l.b.a.b.o.g.WARN;
                    AppMethodBeat.o(57539);
                    return gVar4;
                }
                break;
        }
        AppMethodBeat.o(57539);
        return null;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private final List<EnumC2281a> a(g<?> gVar) {
        EnumC2281a aVar;
        AppMethodBeat.i(57540);
        if (gVar instanceof kotlin.l.b.a.b.j.b.b) {
            ArrayList arrayList = new ArrayList();
            for (g<?> gVar2 : (Iterable) ((kotlin.l.b.a.b.j.b.b) gVar).getValue()) {
                kotlin.a.j.a((Collection) arrayList, (Iterable) a(gVar2));
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(57540);
            return arrayList2;
        } else if (gVar instanceof kotlin.l.b.a.b.j.b.j) {
            String identifier = ((kotlin.l.b.a.b.j.b.j) gVar).TIy.getIdentifier();
            switch (identifier.hashCode()) {
                case -2024225567:
                    if (identifier.equals("METHOD")) {
                        aVar = EnumC2281a.METHOD_RETURN_TYPE;
                        break;
                    }
                    aVar = null;
                    break;
                case 66889946:
                    if (identifier.equals("FIELD")) {
                        aVar = EnumC2281a.FIELD;
                        break;
                    }
                    aVar = null;
                    break;
                case 107598562:
                    if (identifier.equals("TYPE_USE")) {
                        aVar = EnumC2281a.TYPE_USE;
                        break;
                    }
                    aVar = null;
                    break;
                case 446088073:
                    if (identifier.equals("PARAMETER")) {
                        aVar = EnumC2281a.VALUE_PARAMETER;
                        break;
                    }
                    aVar = null;
                    break;
                default:
                    aVar = null;
                    break;
            }
            List<EnumC2281a> eR = kotlin.a.j.eR(aVar);
            AppMethodBeat.o(57540);
            return eR;
        } else {
            v vVar = v.SXr;
            AppMethodBeat.o(57540);
            return vVar;
        }
    }

    public static final /* synthetic */ kotlin.l.b.a.b.b.a.c a(a aVar, e eVar) {
        AppMethodBeat.i(57542);
        if (eVar.hzL().h(b.hDn())) {
            for (kotlin.l.b.a.b.b.a.c cVar : eVar.hzL()) {
                kotlin.l.b.a.b.b.a.c d2 = aVar.d(cVar);
                if (d2 != null) {
                    AppMethodBeat.o(57542);
                    return d2;
                }
            }
        }
        AppMethodBeat.o(57542);
        return null;
    }
}
