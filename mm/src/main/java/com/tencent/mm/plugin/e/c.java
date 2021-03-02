package com.tencent.mm.plugin.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;

public final class c extends a {
    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(g gVar) {
        AppMethodBeat.i(22634);
        getClass().getClassLoader();
        j.Ed("tencentlocsapp");
        AppMethodBeat.o(22634);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.a.c.a
    public final String name() {
        return "boot-load-tencentloc-library";
    }
}
