package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m;
import kotlinx.a.c.a;
import kotlinx.a.c.b;
import kotlinx.a.c.f;
import kotlinx.a.c.o;
import kotlinx.a.c.s;
import kotlinx.a.c.v;
import kotlinx.a.e;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0000¢\u0006\u0002\u0010\u0007¨\u0006\b"}, hxF = {"readJson", "T", "Lkotlinx/serialization/json/Json;", "element", "Lkotlinx/serialization/json/JsonElement;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "kotlinx-serialization-runtime"})
public final class q {
    public static final <T> T a(a aVar, f fVar, kotlinx.a.f<T> fVar2) {
        e eVar;
        AppMethodBeat.i(225703);
        p.h(aVar, "$this$readJson");
        p.h(fVar, "element");
        p.h(fVar2, "deserializer");
        if (fVar instanceof s) {
            eVar = new h(aVar, (s) fVar);
        } else if (fVar instanceof b) {
            eVar = new i(aVar, (b) fVar);
        } else if ((fVar instanceof o) || p.j(fVar, kotlinx.a.c.q.TZU)) {
            eVar = new e(aVar, (v) fVar);
        } else {
            m mVar = new m();
            AppMethodBeat.o(225703);
            throw mVar;
        }
        T t = (T) e.c(eVar, fVar2);
        AppMethodBeat.o(225703);
        return t;
    }
}
