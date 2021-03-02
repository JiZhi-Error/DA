package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.PrivilegedAction;

public final class h implements PrivilegedAction {
    private String gLo;
    private String gLp;

    public h(String str) {
        this.gLo = str;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        AppMethodBeat.i(155902);
        String property = System.getProperty(this.gLo);
        if (property == null) {
            String str = this.gLp;
            AppMethodBeat.o(155902);
            return str;
        }
        AppMethodBeat.o(155902);
        return property;
    }
}
