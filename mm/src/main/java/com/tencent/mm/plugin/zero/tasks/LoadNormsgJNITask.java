package com.tencent.mm.plugin.zero.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;

public final class LoadNormsgJNITask extends a {
    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(g gVar) {
        AppMethodBeat.i(133030);
        getClass().getClassLoader();
        j.Ed("stlport_shared");
        getClass().getClassLoader();
        j.Ed("wechatxlog");
        getClass().getClassLoader();
        j.Ed("wechatnormsg");
        AppMethodBeat.o(133030);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.a.c.a
    public final String name() {
        return "boot-load-wechatnormsg-library";
    }
}
