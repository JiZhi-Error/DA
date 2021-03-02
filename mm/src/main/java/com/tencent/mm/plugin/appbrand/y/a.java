package com.tencent.mm.plugin.appbrand.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.c.d;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.storage.c;

public final class a {
    public static boolean bVo() {
        boolean z;
        AppMethodBeat.i(48237);
        c Fu = d.aXu().Fu("100159");
        if (!Fu.isValid() || !"1".equals(Fu.gzz().get("isCloseWeappSearch"))) {
            z = false;
        } else {
            z = true;
        }
        if (z || (((b) g.af(b.class)).Vt() && ((b) g.af(b.class)).fvp() != 1)) {
            AppMethodBeat.o(48237);
            return false;
        }
        AppMethodBeat.o(48237);
        return true;
    }
}
