package com.tencent.mm.plugin.zero.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;

public final class b extends a {
    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(g gVar) {
        AppMethodBeat.i(133036);
        getClass().getClassLoader();
        j.Ed("commonimgdec");
        getClass().getClassLoader();
        j.Ed("wechatcommon");
        AppMethodBeat.o(133036);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.a.c.a
    public final String name() {
        return "boot-load-wechatcommon-library";
    }
}
