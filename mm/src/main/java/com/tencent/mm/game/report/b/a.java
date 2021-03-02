package com.tencent.mm.game.report.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public static String c(int i2, Map map) {
        AppMethodBeat.i(108271);
        if (map == null) {
            map = new HashMap();
        }
        switch (i2) {
            case 2:
                map.put(TPDownloadProxyEnum.USER_SSID, 10);
                break;
            case 3:
                map.put(TPDownloadProxyEnum.USER_SSID, 9);
                break;
            case 4:
                map.put(TPDownloadProxyEnum.USER_SSID, 11);
                break;
            case 5:
                map.put(TPDownloadProxyEnum.USER_SSID, 8);
                break;
            case 6:
                map.put(TPDownloadProxyEnum.USER_SSID, 12);
                break;
            case 7:
                map.put(TPDownloadProxyEnum.USER_SSID, 13);
                break;
        }
        String u = com.tencent.mm.game.report.e.a.u(map);
        AppMethodBeat.o(108271);
        return u;
    }

    public static void a(Context context, int i2, int i3, int i4, int i5, String str) {
        AppMethodBeat.i(190325);
        f.a(context, 87, i2, i3, i4, i5, str);
        AppMethodBeat.o(190325);
    }

    public static void a(Context context, int i2, int i3, int i4, String str, int i5, String str2) {
        AppMethodBeat.i(190326);
        f.a(context, 87, i2, i3, i4, str, i5, str2);
        AppMethodBeat.o(190326);
    }
}
