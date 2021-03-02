package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;

@SuppressLint({"DefaultLocale"})
public class ba extends a {
    public static String aT(String str, int i2) {
        AppMethodBeat.i(90621);
        String str2 = az.bwm() + String.format("_%d_%d.wxapkg", Integer.valueOf(str.hashCode()), Integer.valueOf(i2));
        AppMethodBeat.o(90621);
        return str2;
    }

    static String Vh(String str) {
        AppMethodBeat.i(90622);
        String str2 = az.bwm() + String.format("_%s.wxapkg", str);
        AppMethodBeat.o(90622);
        return str2;
    }

    ba(String str, int i2, int i3, String str2) {
        this(String.format("WxaPkg_%s_%d", str, Integer.valueOf(i3)), aT(str, i3), str2, str, i3, i2);
        AppMethodBeat.i(90623);
        AppMethodBeat.o(90623);
    }

    private ba(String str, String str2, String str3, String str4, int i2, int i3) {
        super(str, str2, str3, str4, i2, i3);
    }
}
