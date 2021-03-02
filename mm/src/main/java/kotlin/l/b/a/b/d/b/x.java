package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.m.ab;

public final class x implements w<k> {
    public static final x TvU = new x();

    static {
        AppMethodBeat.i(58268);
        AppMethodBeat.o(58268);
    }

    private x() {
    }

    @Override // kotlin.l.b.a.b.d.b.w
    public final ab V(ab abVar) {
        AppMethodBeat.i(58270);
        p.h(abVar, "kotlinType");
        p.h(abVar, "kotlinType");
        AppMethodBeat.o(58270);
        return null;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.l.b.a.b.d.b.w
    public final /* synthetic */ k t(e eVar) {
        AppMethodBeat.i(58265);
        p.h(eVar, "classDescriptor");
        AppMethodBeat.o(58265);
        return null;
    }

    @Override // kotlin.l.b.a.b.d.b.w
    public final String v(e eVar) {
        AppMethodBeat.i(58269);
        p.h(eVar, "classDescriptor");
        p.h(eVar, "classDescriptor");
        AppMethodBeat.o(58269);
        return null;
    }

    @Override // kotlin.l.b.a.b.d.b.w
    public final ab y(Collection<? extends ab> collection) {
        AppMethodBeat.i(58264);
        p.h(collection, "types");
        AssertionError assertionError = new AssertionError("There should be no intersection type in existing descriptors, but found: " + j.a(collection, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 63));
        AppMethodBeat.o(58264);
        throw assertionError;
    }

    @Override // kotlin.l.b.a.b.d.b.w
    public final String u(e eVar) {
        AppMethodBeat.i(58266);
        p.h(eVar, "classDescriptor");
        AppMethodBeat.o(58266);
        return null;
    }

    @Override // kotlin.l.b.a.b.d.b.w
    public final void a(ab abVar, e eVar) {
        AppMethodBeat.i(58267);
        p.h(abVar, "kotlinType");
        p.h(eVar, "descriptor");
        AppMethodBeat.o(58267);
    }
}
