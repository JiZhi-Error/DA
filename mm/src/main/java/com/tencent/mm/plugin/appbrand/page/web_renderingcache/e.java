package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "f", "Lcom/tencent/mm/vfs/VFSFile;", "accept"})
final class e implements q {
    public static final e nwm = new e();

    static {
        AppMethodBeat.i(50965);
        AppMethodBeat.o(50965);
    }

    e() {
    }

    @Override // com.tencent.mm.vfs.q
    public final boolean accept(o oVar) {
        AppMethodBeat.i(50964);
        p.h(oVar, "f");
        if (!oVar.exists() || !oVar.isFile()) {
            AppMethodBeat.o(50964);
            return false;
        }
        AppMethodBeat.o(50964);
        return true;
    }
}
