package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.appcache.WABSPatch;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;

public class BSPatchJNIWrapper implements IBSPatchJNIService {
    static {
        AppMethodBeat.i(44127);
        BSPatchJNIWrapper.class.getClassLoader();
        j.Ed("appbrandcommon");
        AppMethodBeat.o(44127);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService
    public int bspatch(String str, String str2, String str3) {
        AppMethodBeat.i(44126);
        int bspatch = WABSPatch.bspatch(str, str2, str3);
        AppMethodBeat.o(44126);
        return bspatch;
    }
}
