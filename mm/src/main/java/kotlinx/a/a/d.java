package kotlinx.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.b.ae;
import kotlinx.a.b.ag;
import kotlinx.a.b.e;
import kotlinx.a.h;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\u001a&\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\u001a@\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e0\f0\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\r0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0001\u001a&\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00070\u0001\"\u0004\b\u0000\u0010\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"-\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00018F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"-\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00070\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00018F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005¨\u0006\u0012"}, hxF = {"list", "Lkotlinx/serialization/KSerializer;", "", "T", "getList", "(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "set", "", "getSet", "ListSerializer", "elementSerializer", "MapSerializer", "", "K", "V", "keySerializer", "valueSerializer", "SetSerializer", "kotlinx-serialization-runtime"})
public final class d {
    public static final <T> h<List<T>> b(h<T> hVar) {
        AppMethodBeat.i(225618);
        p.h(hVar, "elementSerializer");
        e eVar = new e(hVar);
        AppMethodBeat.o(225618);
        return eVar;
    }

    public static final <T> h<Set<T>> c(h<T> hVar) {
        AppMethodBeat.i(225619);
        p.h(hVar, "elementSerializer");
        ag agVar = new ag(hVar);
        AppMethodBeat.o(225619);
        return agVar;
    }

    public static final <K, V> h<Map<K, V>> a(h<K> hVar, h<V> hVar2) {
        AppMethodBeat.i(225620);
        p.h(hVar, "keySerializer");
        p.h(hVar2, "valueSerializer");
        ae aeVar = new ae(hVar, hVar2);
        AppMethodBeat.o(225620);
        return aeVar;
    }
}
