package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g {
    int MAX_RETRY_COUNT = 5;

    public interface a {
    }

    public interface b {
        void dV(String str, int i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x008f A[SYNTHETIC, Splitter:B:27:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ab A[SYNTHETIC, Splitter:B:35:0x00ab] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String axW(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 206
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.model.g.axW(java.lang.String):java.lang.String");
    }

    static /* synthetic */ void b(String str, int i2, Intent intent) {
        AppMethodBeat.i(24804);
        Log.i("MicroMsg.FreeWifi.FreeWifiNetwork", "update ssid  : %s to new state : %d", str, Integer.valueOf(i2));
        if (i2 == 3) {
            Log.e("MicroMsg.FreeWifi.FreeWifiNetwork", "new state is connect failed, update local freewifiinfo expired time to now");
            c axZ = j.dNn().axZ(str);
            if (axZ != null) {
                axZ.field_expiredTime = Util.nowSecond() - 10;
                Log.i("MicroMsg.FreeWifi.FreeWifiNetwork", "update local freewifi info expired time : ssid is : %s, now time is : %d, update ret : %b", str, Long.valueOf(axZ.field_expiredTime), Boolean.valueOf(j.dNn().update(axZ, new String[0])));
            }
        }
        d.a(str, i2, intent);
        AppMethodBeat.o(24804);
    }

    static /* synthetic */ String ht(String str, String str2) {
        String[] strArr;
        AppMethodBeat.i(24805);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.FreeWifi.FreeWifiNetwork", "null or nil header");
        } else {
            String[] split = str.split("\\?");
            if (str2.length() > 0) {
                strArr = split[1].split("&");
            } else {
                strArr = split;
            }
            if (strArr != null && strArr.length > 0) {
                for (String str3 : strArr) {
                    if (str3.startsWith(str2)) {
                        String substring = str3.substring(str2.length());
                        AppMethodBeat.o(24805);
                        return substring;
                    }
                }
            }
        }
        AppMethodBeat.o(24805);
        return null;
    }
}
