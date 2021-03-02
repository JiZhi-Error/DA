package com.tencent.mm.plugin.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;

public final class b extends a {
    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(g gVar) {
        AppMethodBeat.i(22633);
        getClass().getClassLoader();
        j.Ed("FFmpeg");
        getClass().getClassLoader();
        j.Ed("wechatpack");
        AppMethodBeat.o(22633);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.a.c.a
    public final String name() {
        return "boot-load-FFmpeg-and-wechatpack-libraries";
    }
}
