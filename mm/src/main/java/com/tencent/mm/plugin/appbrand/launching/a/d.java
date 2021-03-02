package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.protocal.protobuf.fds;
import com.tencent.mm.protocal.protobuf.fez;

public final class d {
    public static fez b(AppBrandLaunchReferrer appBrandLaunchReferrer) {
        fez fez = null;
        AppMethodBeat.i(147319);
        if (appBrandLaunchReferrer == null) {
            AppMethodBeat.o(147319);
        } else {
            if (2 == appBrandLaunchReferrer.leo) {
                fez = new fez();
                fez.KGX = appBrandLaunchReferrer.appId;
                fez.Url = appBrandLaunchReferrer.url;
            }
            AppMethodBeat.o(147319);
        }
        return fez;
    }

    public static fds c(AppBrandLaunchReferrer appBrandLaunchReferrer) {
        fds fds = null;
        AppMethodBeat.i(147320);
        if (appBrandLaunchReferrer == null) {
            AppMethodBeat.o(147320);
        } else {
            if (1 == appBrandLaunchReferrer.leo) {
                fds = new fds();
                fds.MjN = appBrandLaunchReferrer.appId;
                fds.LEg = appBrandLaunchReferrer.sourceType;
                fds.Nzn = appBrandLaunchReferrer.leq;
            }
            if (appBrandLaunchReferrer.sourceType != 0) {
                if (fds == null) {
                    fds = new fds();
                }
                fds.LEg = appBrandLaunchReferrer.sourceType;
            }
            AppMethodBeat.o(147320);
        }
        return fds;
    }
}
