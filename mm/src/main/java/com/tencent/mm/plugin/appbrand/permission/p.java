package com.tencent.mm.plugin.appbrand.permission;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Util;

public final class p extends d {
    private static final boolean nxK = (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE);

    @SuppressLint({"WrongConstant"})
    public p(AppBrandRuntime appBrandRuntime) {
        super(appBrandRuntime, -Util.getInt(ac.jOx, 0), nxK);
        AppMethodBeat.i(47998);
        AppMethodBeat.o(47998);
    }
}
