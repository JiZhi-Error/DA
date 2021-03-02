package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.d.a.e.u;
import kotlin.l.b.a.b.j.e.d;

public final class v extends w implements u {
    private final Class<?> Tnt;

    public v(Class<?> cls) {
        p.h(cls, "reflectType");
        AppMethodBeat.i(57503);
        this.Tnt = cls;
        AppMethodBeat.o(57503);
    }

    @Override // kotlin.l.b.a.b.d.a.e.u
    public final h hDh() {
        AppMethodBeat.i(57502);
        if (p.j(this.Tnt, Void.TYPE)) {
            AppMethodBeat.o(57502);
            return null;
        }
        d buk = d.buk(this.Tnt.getName());
        p.g(buk, "JvmPrimitiveType.get(reflectType.name)");
        h hKJ = buk.hKJ();
        AppMethodBeat.o(57502);
        return hKJ;
    }

    @Override // kotlin.l.b.a.b.b.d.b.w
    public final /* bridge */ /* synthetic */ Type hCJ() {
        return this.Tnt;
    }
}
