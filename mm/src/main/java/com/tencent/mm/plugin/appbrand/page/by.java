package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;

/* access modifiers changed from: package-private */
public final class by {
    static boolean c(bx bxVar) {
        return (bxVar == bx.APP_LAUNCH || bxVar == bx.SWITCH_TAB || bxVar == bx.REDIRECT_TO || bxVar == bx.REWRITE_ROUTE || bxVar == bx.RE_LAUNCH || bxVar == bx.AUTO_RE_LAUNCH) ? false : true;
    }

    static boolean d(bx bxVar) {
        return bxVar == bx.REDIRECT_TO || bxVar == bx.REWRITE_ROUTE || bxVar == bx.SWITCH_TAB || bxVar == bx.RE_LAUNCH || bxVar == bx.AUTO_RE_LAUNCH;
    }

    static boolean e(bx bxVar) {
        AppMethodBeat.i(219459);
        boolean contains = a.contains(new bx[]{bx.SWITCH_TAB, bx.RE_LAUNCH, bx.AUTO_RE_LAUNCH}, bxVar);
        AppMethodBeat.o(219459);
        return contains;
    }
}
