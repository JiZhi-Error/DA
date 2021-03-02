package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.c.a;
import kotlinx.a.j;
import kotlinx.a.n;
import kotlinx.a.w;
import kotlinx.a.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aP\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\b\b\u0001\u0010\u0002*\u0002H\u0001\"\b\b\u0002\u0010\u0003*\u0002H\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00030\bH\b¢\u0006\u0002\u0010\n\u001a\u0014\u0010\u000b\u001a\u00020\f*\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0000¨\u0006\u000e"}, hxF = {"selectMapMode", "T", "R1", "R2", "Lkotlinx/serialization/json/Json;", "mapDescriptor", "Lkotlinx/serialization/SerialDescriptor;", "ifMap", "Lkotlin/Function0;", "ifList", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/SerialDescriptor;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "switchMode", "Lkotlinx/serialization/json/internal/WriteMode;", "desc", "kotlinx-serialization-runtime"})
public final class s {
    public static final r a(a aVar, n nVar) {
        AppMethodBeat.i(225711);
        p.h(aVar, "$this$switchMode");
        p.h(nVar, "desc");
        kotlinx.a.s hOA = nVar.hOA();
        if (hOA instanceof j) {
            r rVar = r.POLY_OBJ;
            AppMethodBeat.o(225711);
            return rVar;
        } else if (p.j(hOA, w.b.TXT)) {
            r rVar2 = r.LIST;
            AppMethodBeat.o(225711);
            return rVar2;
        } else if (p.j(hOA, w.c.TXU)) {
            n awd = nVar.awd(0);
            kotlinx.a.s hOA2 = awd.hOA();
            if ((hOA2 instanceof kotlinx.a.l) || p.j(hOA2, x.c.TXZ)) {
                r rVar3 = r.MAP;
                AppMethodBeat.o(225711);
                return rVar3;
            } else if (aVar.TZf.TZu) {
                r rVar4 = r.LIST;
                AppMethodBeat.o(225711);
                return rVar4;
            } else {
                kotlinx.a.c.j f2 = kotlinx.a.c.l.f(awd);
                AppMethodBeat.o(225711);
                throw f2;
            }
        } else {
            r rVar5 = r.OBJ;
            AppMethodBeat.o(225711);
            return rVar5;
        }
    }
}
