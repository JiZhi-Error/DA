package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class aq extends Exception {
    public aq(String str) {
        super(String.format(Locale.US, "%s not found", str));
        AppMethodBeat.i(146931);
        AppMethodBeat.o(146931);
    }
}
