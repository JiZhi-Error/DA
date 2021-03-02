package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.appcache.bj;

public class bs extends a {
    final bj.a kMv;
    final int pkgVersion;

    public bs(String str, String str2, int i2, int i3, bj.a aVar) {
        super(String.format("WxaPkgZstd_%s_%d", str2, Integer.valueOf(i2)), az.bwm() + String.format("_%d_%d.wxapkg.zstd", Integer.valueOf(str2.hashCode()), Integer.valueOf(i2)), str, str2, i2, i3);
        AppMethodBeat.i(90665);
        this.pkgVersion = i2;
        this.kMv = aVar;
        AppMethodBeat.o(90665);
    }

    public final String bwC() {
        AppMethodBeat.i(90666);
        String aT = ba.aT(this.appId, this.pkgVersion);
        AppMethodBeat.o(90666);
        return aT;
    }
}
