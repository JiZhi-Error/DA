package com.tencent.mm.plugin.appbrand.message;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public enum h implements p {
    INSTANCE;

    public static h valueOf(String str) {
        AppMethodBeat.i(47742);
        h hVar = (h) Enum.valueOf(h.class, str);
        AppMethodBeat.o(47742);
        return hVar;
    }

    static {
        AppMethodBeat.i(47746);
        AppMethodBeat.o(47746);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.p
    public final h.b a(String str, Map<String, String> map, h.a aVar) {
        boolean z;
        String str2;
        AppMethodBeat.i(47743);
        if ("WeAppPushCommand".equals(str)) {
            String str3 = ".sysmsg.WeAppPushCommand.weapp";
            int i2 = 0;
            while (true) {
                String str4 = map.get(str3 + ".$cmdtype");
                String str5 = map.get(str3 + ".$appid");
                String str6 = map.get(str3 + ".expireSeconds");
                if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5) || TextUtils.isEmpty(str6) || !TextUtils.isDigitsOnly(str6)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    char c2 = 65535;
                    switch (str4.hashCode()) {
                        case -505130726:
                            if (str4.equals("copypath")) {
                                c2 = 0;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            n.NL().cN(ew(str5, "copypath"), String.valueOf((Long.valueOf(str6).longValue() * 1000) + System.currentTimeMillis()));
                            break;
                    }
                }
                Log.i("MicroMsg.WxaWeAppPushCommandMgr", "[consumeNewXml] index = %d, appId =%s, cmdType=%s, expireSeconds = %s", Integer.valueOf(i2), str5, str4, str6);
                int i3 = i2 + 1;
                if (i3 == 0) {
                    str2 = ".sysmsg.WeAppPushCommand.weapp";
                } else {
                    str2 = ".sysmsg.WeAppPushCommand.weapp" + i3;
                }
                if (map.containsKey(str2)) {
                    str3 = str2;
                    i2 = i3;
                }
            }
        }
        AppMethodBeat.o(47743);
        return null;
    }

    public static Long ev(String str, String str2) {
        AppMethodBeat.i(47744);
        String str3 = n.NL().get(ew(str, str2), "");
        if (TextUtils.isEmpty(str3)) {
            AppMethodBeat.o(47744);
            return null;
        }
        if (Long.valueOf(str3).longValue() < System.currentTimeMillis()) {
            n.NL().gC(ew(str, str2));
            Log.i("MicroMsg.WxaWeAppPushCommandMgr", "delete data app id=".concat(String.valueOf(str)));
        }
        Long valueOf = Long.valueOf(str3);
        AppMethodBeat.o(47744);
        return valueOf;
    }

    private static String ew(String str, String str2) {
        AppMethodBeat.i(47745);
        String str3 = str + "#WxaWeAppPushCommandMgr#" + str2;
        AppMethodBeat.o(47745);
        return str3;
    }
}
