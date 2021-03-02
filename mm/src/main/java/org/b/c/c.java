package org.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import org.b.d.e;
import org.b.g.d;

public final class c implements b {
    @Override // org.b.c.b
    public final String a(org.b.d.c cVar) {
        AppMethodBeat.i(40510);
        d.j(cVar, "Cannot extract base string from null object");
        if (cVar.Uik == null || cVar.Uik.size() <= 0) {
            org.b.b.c cVar2 = new org.b.b.c(cVar);
            AppMethodBeat.o(40510);
            throw cVar2;
        }
        String encode = org.b.g.c.encode(cVar.hQc().name());
        String encode2 = org.b.g.c.encode(cVar.hQh());
        e eVar = new e();
        eVar.a(cVar.hQb());
        eVar.a(cVar.hQg());
        eVar.a(new e(cVar.Uik));
        e eVar2 = new e(eVar.Uil);
        Collections.sort(eVar2.Uil);
        String format = String.format("%s&%s&%s", encode, encode2, org.b.g.c.encode(eVar2.hQj()));
        AppMethodBeat.o(40510);
        return format;
    }
}
