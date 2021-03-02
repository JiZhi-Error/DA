package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import java.util.Locale;

public final class br extends a {
    private static String b(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(90663);
        String format = String.format(Locale.US, "WxaPage_%s_%d_%d_%d", str2, Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(str.hashCode()));
        AppMethodBeat.o(90663);
        return format;
    }

    br(String str, String str2, int i2, int i3) {
        super(b(str, str2, i2, i3), ba.Vh(b(str, str2, i2, i3)), str, str2, i2, i3);
        AppMethodBeat.i(90664);
        AppMethodBeat.o(90664);
    }
}
