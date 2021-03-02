package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import kotlin.l.b.a.b.b.d.b.w;
import kotlin.l.b.a.b.d.a.e.n;
import kotlin.l.b.a.b.d.a.e.v;

public final class p extends r implements n {
    public final Field Tnr;

    public p(Field field) {
        kotlin.g.b.p.h(field, "member");
        AppMethodBeat.i(57484);
        this.Tnr = field;
        AppMethodBeat.o(57484);
    }

    @Override // kotlin.l.b.a.b.d.a.e.n
    public final boolean hDa() {
        AppMethodBeat.i(57482);
        boolean isEnumConstant = this.Tnr.isEnumConstant();
        AppMethodBeat.o(57482);
        return isEnumConstant;
    }

    @Override // kotlin.l.b.a.b.d.a.e.n
    public final /* synthetic */ v hDb() {
        AppMethodBeat.i(57483);
        w.a aVar = w.Tnu;
        Type genericType = this.Tnr.getGenericType();
        kotlin.g.b.p.g(genericType, "member.genericType");
        w b2 = w.a.b(genericType);
        AppMethodBeat.o(57483);
        return b2;
    }

    @Override // kotlin.l.b.a.b.b.d.b.r
    public final /* bridge */ /* synthetic */ Member hyV() {
        return this.Tnr;
    }
}
