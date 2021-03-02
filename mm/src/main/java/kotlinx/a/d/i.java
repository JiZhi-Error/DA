package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ae;
import kotlin.g.b.aa;
import kotlin.g.b.ac;
import kotlin.g.b.f;
import kotlin.g.b.o;
import kotlin.g.b.p;
import kotlin.g.b.r;
import kotlin.l;
import kotlin.l.b;
import kotlin.s;
import kotlin.x;
import kotlinx.a.a.c;
import kotlinx.a.a.d;
import kotlinx.a.a.e;
import kotlinx.a.b.am;
import kotlinx.a.b.bi;
import kotlinx.a.b.w;
import kotlinx.a.b.y;
import kotlinx.a.h;
import kotlinx.a.k;
import kotlinx.a.u;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u000bJ\u001b\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\u000eR\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lkotlinx/serialization/modules/StandardSubtypesOfAny;", "", "()V", "deserializingMap", "", "", "Lkotlinx/serialization/KSerializer;", "map", "Lkotlin/reflect/KClass;", "getDefaultDeserializer", "serializedClassName", "getDefaultDeserializer$kotlinx_serialization_runtime", "getSubclassSerializer", "objectToCheck", "getSubclassSerializer$kotlinx_serialization_runtime", "kotlinx-serialization-runtime"})
public final class i {
    private static final Map<String, h<?>> UaN;
    public static final i UaO = new i();
    private static final Map<b<?>, h<?>> map;

    static {
        AppMethodBeat.i(225864);
        b bp = aa.bp(Map.Entry.class);
        h a2 = c.a(new k(aa.bp(Object.class)));
        h a3 = c.a(new k(aa.bp(Object.class)));
        p.h(a2, "keySerializer");
        p.h(a3, "valueSerializer");
        Map<b<?>, h<?>> e2 = ae.e(s.U(aa.bp(List.class), d.b(c.a(new k(aa.bp(Object.class))))), s.U(aa.bp(LinkedHashSet.class), d.c(c.a(new k(aa.bp(Object.class))))), s.U(aa.bp(HashSet.class), new y(c.a(new k(aa.bp(Object.class))))), s.U(aa.bp(Set.class), d.c(c.a(new k(aa.bp(Object.class))))), s.U(aa.bp(LinkedHashMap.class), new kotlinx.a.b.ae(c.a(new k(aa.bp(Object.class))), c.a(new k(aa.bp(Object.class))))), s.U(aa.bp(HashMap.class), new w(c.a(new k(aa.bp(Object.class))), c.a(new k(aa.bp(Object.class))))), s.U(aa.bp(Map.class), new kotlinx.a.b.ae(c.a(new k(aa.bp(Object.class))), c.a(new k(aa.bp(Object.class))))), s.U(bp, new am(a2, a3)), s.U(aa.bp(String.class), e.a(kotlin.g.b.ae.SYK)), s.U(aa.bp(Character.TYPE), e.a(f.SYo)), s.U(aa.bp(Integer.TYPE), e.a(o.SYy)), s.U(aa.bp(Byte.TYPE), e.a(kotlin.g.b.d.SYj)), s.U(aa.bp(Short.TYPE), e.a(ac.SYJ)), s.U(aa.bp(Long.TYPE), e.a(r.SYz)), s.U(aa.bp(Double.TYPE), e.a(kotlin.g.b.k.SYw)), s.U(aa.bp(Float.TYPE), e.a(kotlin.g.b.l.SYx)), s.U(aa.bp(Boolean.TYPE), e.a(kotlin.g.b.c.SYi)), s.U(aa.bp(x.class), bi.TZa));
        map = e2;
        LinkedHashMap linkedHashMap = new LinkedHashMap(ae.atJ(e2.size()));
        for (T t : e2.entrySet()) {
            linkedHashMap.put(((h) t.getValue()).fWv().hOz(), t.getValue());
        }
        UaN = linkedHashMap;
        AppMethodBeat.o(225864);
    }

    private i() {
    }

    public static h<?> gA(Object obj) {
        AppMethodBeat.i(225862);
        p.h(obj, "objectToCheck");
        for (Map.Entry<b<?>, h<?>> entry : map.entrySet()) {
            h<?> value = entry.getValue();
            if (u.a(obj, entry.getKey())) {
                AppMethodBeat.o(225862);
                return value;
            }
        }
        AppMethodBeat.o(225862);
        return null;
    }

    public static h<?> buU(String str) {
        AppMethodBeat.i(225863);
        p.h(str, "serializedClassName");
        h<?> hVar = UaN.get(str);
        AppMethodBeat.o(225863);
        return hVar;
    }
}
