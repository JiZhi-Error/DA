package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.m;

/* access modifiers changed from: package-private */
public interface r extends q {
    String UX(String str);

    <T> T f(String str, Class<T> cls);

    public static class a {
        static r kKL = ((r) m.g("IWxaPkgRuntimeReaderEx.DUMMY", r.class));

        static {
            AppMethodBeat.i(178520);
            AppMethodBeat.o(178520);
        }
    }
}
