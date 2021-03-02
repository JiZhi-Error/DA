package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.plugin.appbrand.service.l;
import com.tencent.mm.vfs.s;

public final class h implements l {
    @Override // com.tencent.mm.plugin.appbrand.service.l
    public final boolean cq(String str, String str2) {
        AppMethodBeat.i(226308);
        boolean nativeBrotliDecompress = AppBrandCommonBindingJni.nativeBrotliDecompress(s.k(str, false), s.k(str2, true));
        AppMethodBeat.o(226308);
        return nativeBrotliDecompress;
    }
}
