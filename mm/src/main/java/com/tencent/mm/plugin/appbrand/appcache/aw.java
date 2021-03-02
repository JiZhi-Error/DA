package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import java.util.Locale;

public final class aw extends a {
    final int kMt;
    final int kMu;
    final bj.a kMv;

    static String B(String str, int i2, int i3) {
        AppMethodBeat.i(90590);
        String format = String.format(Locale.US, "WxaPkgDiff_%s_%d_%d", Integer.valueOf(str.hashCode()), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(90590);
        return format;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aw(String str, int i2, int i3, String str2, bj.a aVar) {
        super(B(str, i2, i3), az.bwm() + String.format(Locale.US, "_%s_%d_%d.wxapkg.diff", Integer.valueOf(str.hashCode()), Integer.valueOf(i2), Integer.valueOf(i3)), str2, str, 0, i3);
        boolean z = false;
        AppMethodBeat.i(90591);
        this.kMt = i2;
        this.kMu = i3;
        this.kMv = aVar;
        this.kOB = !"@LibraryAppId".equals(str) ? true : z;
        AppMethodBeat.o(90591);
    }

    public final String bwb() {
        AppMethodBeat.i(90592);
        String aT = ba.aT(this.appId, this.kMu);
        AppMethodBeat.o(90592);
        return aT;
    }
}
