package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class ah {
    private static final Map<String, Integer> IEu = new HashMap();

    static {
        AppMethodBeat.i(117657);
        AppMethodBeat.o(117657);
    }

    public static void a(int i2, String str, String str2, String str3, int i3, boolean z, String str4, String str5, int i4) {
        AppMethodBeat.i(117644);
        a(i2, str, str2, str3, i3, z, str4, str5, i4, "");
        AppMethodBeat.o(117644);
    }

    public static void a(int i2, String str, String str2, String str3, int i3, boolean z, String str4, String str5, int i4, String str6) {
        AppMethodBeat.i(117645);
        a(4, i2, str, str2, str3, i3, z, str4, true, str5, str6, i4);
        AppMethodBeat.o(117645);
    }

    public static void a(int i2, String str, String str2, String str3, int i3, boolean z, String str4, boolean z2, String str5, int i4) {
        AppMethodBeat.i(117646);
        a(i2, str, str2, str3, i3, z, str4, z2, str5, i4, "");
        AppMethodBeat.o(117646);
    }

    public static void a(int i2, String str, String str2, String str3, int i3, boolean z, String str4, boolean z2, String str5, int i4, String str6) {
        AppMethodBeat.i(117647);
        a(7, i2, str, str2, str3, i3, z, str4, z2, str5, str6, i4);
        AppMethodBeat.o(117647);
    }

    public static void c(int i2, String str, String str2, String str3, String str4, int i3) {
        AppMethodBeat.i(187843);
        a(204, i2, str, str2, str3, 0, true, str4, true, null, "", i3);
        AppMethodBeat.o(187843);
    }

    public static void a(int i2, String str, String str2, String str3, String str4, boolean z, String str5, int i3) {
        AppMethodBeat.i(187844);
        a(207, i2, str, str2, str3, 0, true, str4, z, str5, "", i3);
        AppMethodBeat.o(187844);
    }

    public static void a(int i2, String str, String str2, boolean z, String str3, int i3, String str4, String str5) {
        AppMethodBeat.i(187845);
        if (i2 == 3 || i2 == 20) {
            a(300, i2, str, str2, str5, 0, z, "", true, str3, str4, i3, false);
        }
        AppMethodBeat.o(187845);
    }

    public static void a(int i2, String str, String str2, String str3, int i3, String str4, boolean z, String str5) {
        AppMethodBeat.i(187846);
        if (i2 == 3 || i2 == 20) {
            a(301, i2, str, str2, str5, 0, true, "", true, str3, str4, i3, z);
        }
        AppMethodBeat.o(187846);
    }

    public static void b(int i2, String str, String str2, String str3, int i3, String str4, boolean z, String str5) {
        AppMethodBeat.i(187847);
        if (i2 == 3 || i2 == 20) {
            a(302, i2, str, str2, str5, 0, true, "", true, str3, str4, i3, z);
        }
        AppMethodBeat.o(187847);
    }

    public static void a(int i2, String str, String str2, boolean z, String str3, int i3, String str4, boolean z2) {
        AppMethodBeat.i(117649);
        a(12, i2, str, str2, "", 0, z, "", true, str3, str4, i3, z2);
        AppMethodBeat.o(117649);
    }

    public static void a(int i2, String str, String str2, boolean z, String str3, int i3) {
        AppMethodBeat.i(117650);
        a(10, i2, str, str2, "", 0, z, "", true, str3, "", i3);
        AppMethodBeat.o(117650);
    }

    public static void fXT() {
    }

    public static void a(int i2, String str, String str2, boolean z, String str3, int i3, boolean z2) {
        AppMethodBeat.i(117651);
        a(14, i2, str, str2, "", 0, z, "", true, str3, "", i3, z2);
        if (i2 == 20) {
            a(214, i2, str, str2, "", 0, z, "", true, str3, "", i3, z2);
        }
        AppMethodBeat.o(117651);
    }

    private static void a(int i2, int i3, String str, String str2, String str3, int i4, boolean z, String str4, boolean z2, String str5, String str6, int i5) {
        AppMethodBeat.i(117652);
        a(i2, i3, str, str2, str3, i4, z, str4, z2, str5, str6, i5, false);
        AppMethodBeat.o(117652);
    }

    private static void a(int i2, int i3, String str, String str2, String str3, int i4, boolean z, String str4, boolean z2, String str5, String str6, int i5, boolean z3) {
        String str7;
        AppMethodBeat.i(117653);
        int i6 = z2 ? 1 : 2;
        if (i2 == 1 || i2 == 10 || i2 == 12) {
            i6 = 0;
        }
        Object[] objArr = new Object[1];
        Object[] objArr2 = new Object[16];
        objArr2[0] = Integer.valueOf(i2);
        objArr2[1] = Integer.valueOf(i3);
        objArr2[2] = Util.nullAs(str, "");
        objArr2[3] = Util.nullAs(str2, "");
        if (TextUtils.isEmpty(str3)) {
            str7 = "";
        } else {
            str7 = str3;
        }
        objArr2[4] = str7;
        objArr2[5] = Integer.valueOf(i4);
        objArr2[6] = Integer.valueOf(z ? 1 : 0);
        objArr2[7] = Util.nullAs(str4, "");
        objArr2[8] = Long.valueOf(System.currentTimeMillis());
        objArr2[9] = bUg();
        objArr2[10] = Integer.valueOf(i6);
        objArr2[11] = Util.nullAs(str5, "");
        objArr2[12] = TextUtils.isEmpty(str6) ? "" : str6;
        objArr2[13] = Integer.valueOf(i5);
        objArr2[14] = Integer.valueOf(afp(i3));
        objArr2[15] = Integer.valueOf(z3 ? 1 : 0);
        objArr[0] = u(objArr2);
        Log.i("MicroMsg.WebSearch.WebSearchActionTracer", "reporting 14904 %s ", objArr);
        e eVar = e.INSTANCE;
        Object[] objArr3 = new Object[16];
        objArr3[0] = Integer.valueOf(i2);
        objArr3[1] = Integer.valueOf(i3);
        objArr3[2] = Util.nullAs(str, "");
        objArr3[3] = Util.nullAs(str2, "");
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        objArr3[4] = str3;
        objArr3[5] = Integer.valueOf(i4);
        objArr3[6] = Integer.valueOf(z ? 1 : 0);
        objArr3[7] = Util.nullAs(str4, "");
        objArr3[8] = Long.valueOf(System.currentTimeMillis());
        objArr3[9] = bUg();
        objArr3[10] = Integer.valueOf(i6);
        objArr3[11] = Util.nullAs(str5, "");
        if (TextUtils.isEmpty(str6)) {
            str6 = "";
        }
        objArr3[12] = str6;
        objArr3[13] = Integer.valueOf(i5);
        objArr3[14] = Integer.valueOf(afp(i3));
        objArr3[15] = Integer.valueOf(z3 ? 1 : 0);
        eVar.a(14904, objArr3);
        AppMethodBeat.o(117653);
    }

    private static int afp(int i2) {
        AppMethodBeat.i(117654);
        switch (i2) {
            case 21:
                int aft = ai.aft(1);
                AppMethodBeat.o(117654);
                return aft;
            case 201:
                int fXV = ai.fXV();
                AppMethodBeat.o(117654);
                return fXV;
            default:
                int aft2 = ai.aft(0);
                AppMethodBeat.o(117654);
                return aft2;
        }
    }

    private static String bUg() {
        AppMethodBeat.i(117655);
        Context context = MMApplicationContext.getContext();
        if (!NetStatusUtil.isConnected(context)) {
            Log.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, not connected");
            AppMethodBeat.o(117655);
            return "fail";
        }
        Log.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, type = ".concat(String.valueOf(NetStatusUtil.getNetType(context))));
        if (NetStatusUtil.is2G(context)) {
            Log.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, 2g");
            AppMethodBeat.o(117655);
            return "2g";
        } else if (NetStatusUtil.is3G(context)) {
            Log.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, 3g");
            AppMethodBeat.o(117655);
            return "3g";
        } else if (NetStatusUtil.is4G(context)) {
            Log.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, 4g");
            AppMethodBeat.o(117655);
            return "4g";
        } else if (NetStatusUtil.isWifi(context)) {
            Log.v("MicroMsg.WebSearch.WebSearchActionTracer", "getNetworkType, wifi");
            AppMethodBeat.o(117655);
            return "wifi";
        } else {
            AppMethodBeat.o(117655);
            return "fail";
        }
    }

    private static String u(Object... objArr) {
        AppMethodBeat.i(117656);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 15; i2++) {
            sb.append(String.valueOf(objArr[i2]).replace(',', ' ')).append(',');
        }
        sb.append(String.valueOf(objArr[15]));
        String sb2 = sb.toString();
        AppMethodBeat.o(117656);
        return sb2;
    }

    public static void a(int i2, String str, String str2, boolean z, String str3, int i3, String str4, boolean z2, String str5) {
        AppMethodBeat.i(117648);
        a(1, i2, str, str2, str5, 0, z, "", true, str3, str4, i3, z2);
        AppMethodBeat.o(117648);
    }
}
