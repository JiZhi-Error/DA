package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.sdk.platformtools.Util;

/* access modifiers changed from: package-private */
@SuppressLint({"DefaultLocale"})
public class av extends a {
    av(String str, String str2, int i2) {
        super(String.format("WxaDebugPkg_%s_%d_%d", str, Integer.valueOf(i2), Integer.valueOf(str2.hashCode())), az.bwm() + String.format("debug_%d_%d_%d.wxapkg", Integer.valueOf(str.hashCode()), Integer.valueOf(i2), Integer.valueOf(str2.hashCode())), str2, str, String.format("%d-%s", Integer.valueOf(i2), str2).hashCode(), i2);
        AppMethodBeat.i(90588);
        AppMethodBeat.o(90588);
    }

    av(String str, String str2, int i2, a.AbstractC0542a aVar) {
        super(String.format("WxaDebugPkg_%s_%d_%s", str, Integer.valueOf(i2), Util.nullAsNil(aVar.bvJ())), az.bwm() + String.format("debug_%d_%d_%d", Integer.valueOf(str.hashCode()), Integer.valueOf(i2), Integer.valueOf(Util.nullAsNil(aVar.bvJ()).hashCode())), str2, str, String.format("%s_%d_%s", str, Integer.valueOf(i2), Util.nullAsNil(aVar.bvJ())).hashCode(), i2);
        AppMethodBeat.i(90589);
        AppMethodBeat.o(90589);
    }
}
