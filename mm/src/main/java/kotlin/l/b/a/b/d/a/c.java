package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.d.b.t;
import kotlin.l.b.a.b.d.b.v;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.e.d;
import kotlin.o;
import kotlin.s;

public final class c {
    private static final r Top;
    private static final Map<r, f> Toq;
    private static final Map<String, f> Tor;
    private static final List<f> Tos;
    private static final Map<f, List<f>> Tot;
    public static final c Tou = new c();

    /* access modifiers changed from: package-private */
    public static final class a extends q implements b<kotlin.l.b.a.b.b.b, Boolean> {
        final /* synthetic */ am Tov;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(am amVar) {
            super(1);
            this.Tov = amVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(kotlin.l.b.a.b.b.b bVar) {
            AppMethodBeat.i(57545);
            p.h(bVar, LocaleUtil.ITALIAN);
            c cVar = c.Tou;
            Map map = c.Tor;
            String c2 = t.c(this.Tov);
            if (map == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                AppMethodBeat.o(57545);
                throw tVar;
            }
            Boolean valueOf = Boolean.valueOf(map.containsKey(c2));
            AppMethodBeat.o(57545);
            return valueOf;
        }
    }

    static {
        AppMethodBeat.i(57551);
        String desc = d.INT.getDesc();
        p.g(desc, "JvmPrimitiveType.INT.desc");
        Top = t.H("java/util/List", "removeAt", desc, "Ljava/lang/Object;");
        v vVar = v.TvS;
        String btR = v.btR("Number");
        String desc2 = d.BYTE.getDesc();
        p.g(desc2, "JvmPrimitiveType.BYTE.desc");
        String btR2 = v.btR("Number");
        String desc3 = d.SHORT.getDesc();
        p.g(desc3, "JvmPrimitiveType.SHORT.desc");
        String btR3 = v.btR("Number");
        String desc4 = d.INT.getDesc();
        p.g(desc4, "JvmPrimitiveType.INT.desc");
        String btR4 = v.btR("Number");
        String desc5 = d.LONG.getDesc();
        p.g(desc5, "JvmPrimitiveType.LONG.desc");
        String btR5 = v.btR("Number");
        String desc6 = d.FLOAT.getDesc();
        p.g(desc6, "JvmPrimitiveType.FLOAT.desc");
        String btR6 = v.btR("Number");
        String desc7 = d.DOUBLE.getDesc();
        p.g(desc7, "JvmPrimitiveType.DOUBLE.desc");
        String btR7 = v.btR("CharSequence");
        String desc8 = d.INT.getDesc();
        p.g(desc8, "JvmPrimitiveType.INT.desc");
        String desc9 = d.CHAR.getDesc();
        p.g(desc9, "JvmPrimitiveType.CHAR.desc");
        Map<r, f> e2 = ae.e(s.U(t.H(btR, "toByte", "", desc2), f.btY("byteValue")), s.U(t.H(btR2, "toShort", "", desc3), f.btY("shortValue")), s.U(t.H(btR3, "toInt", "", desc4), f.btY("intValue")), s.U(t.H(btR4, "toLong", "", desc5), f.btY("longValue")), s.U(t.H(btR5, "toFloat", "", desc6), f.btY("floatValue")), s.U(t.H(btR6, "toDouble", "", desc7), f.btY("doubleValue")), s.U(Top, f.btY("remove")), s.U(t.H(btR7, "get", desc8, desc9), f.btY("charAt")));
        Toq = e2;
        LinkedHashMap linkedHashMap = new LinkedHashMap(ae.atJ(e2.size()));
        for (T t : e2.entrySet()) {
            linkedHashMap.put(((r) t.getKey()).signature, t.getValue());
        }
        Tor = linkedHashMap;
        Set<r> keySet = Toq.keySet();
        ArrayList arrayList = new ArrayList(j.a(keySet, 10));
        Iterator<T> it = keySet.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().TjT);
        }
        Tos = arrayList;
        Set<Map.Entry<r, f>> entrySet = Toq.entrySet();
        ArrayList arrayList2 = new ArrayList(j.a(entrySet, 10));
        for (T t2 : entrySet) {
            arrayList2.add(new o(((r) t2.getKey()).TjT, t2.getValue()));
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj : arrayList2) {
            B b2 = ((o) obj).second;
            Object obj2 = linkedHashMap2.get(b2);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap2.put(b2, obj2);
            }
            ((List) obj2).add(((o) obj).first);
        }
        Tot = linkedHashMap2;
        AppMethodBeat.o(57551);
    }

    private c() {
    }

    public static List<f> hDr() {
        return Tos;
    }

    public static boolean e(f fVar) {
        AppMethodBeat.i(57546);
        p.h(fVar, "$this$sameAsRenamedInJvmBuiltin");
        boolean contains = Tos.contains(fVar);
        AppMethodBeat.o(57546);
        return contains;
    }

    public static f a(am amVar) {
        AppMethodBeat.i(57547);
        p.h(amVar, "functionDescriptor");
        Map<String, f> map = Tor;
        String c2 = t.c(amVar);
        if (c2 == null) {
            AppMethodBeat.o(57547);
            return null;
        }
        f fVar = map.get(c2);
        AppMethodBeat.o(57547);
        return fVar;
    }

    public static boolean b(am amVar) {
        AppMethodBeat.i(57548);
        p.h(amVar, "functionDescriptor");
        if (!g.c(amVar) || kotlin.l.b.a.b.j.d.a.b(amVar, new a(amVar)) == null) {
            AppMethodBeat.o(57548);
            return false;
        }
        AppMethodBeat.o(57548);
        return true;
    }

    public static List<f> f(f fVar) {
        AppMethodBeat.i(57549);
        p.h(fVar, "name");
        kotlin.a.v vVar = Tot.get(fVar);
        if (vVar == null) {
            vVar = kotlin.a.v.SXr;
        }
        AppMethodBeat.o(57549);
        return vVar;
    }

    public static boolean c(am amVar) {
        AppMethodBeat.i(57550);
        p.h(amVar, "$this$isRemoveAtByIndex");
        if (!p.j(amVar.hAH().sG(), "removeAt") || !p.j(t.c(amVar), Top.signature)) {
            AppMethodBeat.o(57550);
            return false;
        }
        AppMethodBeat.o(57550);
        return true;
    }
}
