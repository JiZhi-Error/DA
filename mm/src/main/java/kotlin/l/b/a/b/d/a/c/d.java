package kotlin.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.EnumMap;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.a;
import kotlin.l.b.a.b.d.a.f.h;

public final class d {
    final EnumMap<a.EnumC2281a, h> Trl;

    public d(EnumMap<a.EnumC2281a, h> enumMap) {
        p.h(enumMap, "nullabilityQualifiers");
        AppMethodBeat.i(57746);
        this.Trl = enumMap;
        AppMethodBeat.o(57746);
    }

    public final kotlin.l.b.a.b.d.a.f.d b(a.EnumC2281a aVar) {
        AppMethodBeat.i(57745);
        h hVar = this.Trl.get(aVar);
        if (hVar == null) {
            AppMethodBeat.o(57745);
            return null;
        }
        p.g(hVar, "nullabilityQualifiers[ap…ilityType] ?: return null");
        kotlin.l.b.a.b.d.a.f.d dVar = new kotlin.l.b.a.b.d.a.f.d(hVar.TtX, null, false, hVar.TtY);
        AppMethodBeat.o(57745);
        return dVar;
    }
}
