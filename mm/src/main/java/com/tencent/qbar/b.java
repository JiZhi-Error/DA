package com.tencent.qbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class b {
    private static int RJv = 6;
    private static List<String> RJw;
    private static List<String> RJx = new ArrayList();

    static {
        AppMethodBeat.i(91140);
        ArrayList arrayList = new ArrayList();
        RJw = arrayList;
        arrayList.add("weixin://wxpay/");
        RJw.add("wxp://");
        RJw.add("https://wx.tenpay.com/");
        RJw.add(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e26) + FilePathGenerator.ANDROID_DIR_SEP);
        RJw.add(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1c) + FilePathGenerator.ANDROID_DIR_SEP);
        AppMethodBeat.o(91140);
    }

    public static void hke() {
        AppMethodBeat.i(176203);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_scan_code_black_list_delay_frames, 6);
        if (a2 > 0) {
            RJv = a2;
        }
        RJx.clear();
        RJx.add("https://qr.alipay.com/");
        try {
            String a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_scan_code_black_list, "");
            if (!Util.isNullOrNil(a3)) {
                String[] split = a3.split(";");
                if (split.length > 0) {
                    Collections.addAll(RJx, split);
                }
            }
            Log.i("MicroMsg.QBarAIModHelper", "alvinluo updateBlackList config: %d, blackListDelayFrames: %d, blackListConfigValue: %s, blackListSize: %d", Integer.valueOf(a2), Integer.valueOf(RJv), a3, Integer.valueOf(RJx.size()));
            AppMethodBeat.o(176203);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.QBarAIModHelper", e2, "alvinluo updateBlackList exception", new Object[0]);
            AppMethodBeat.o(176203);
        }
    }

    public static int hkf() {
        return RJv;
    }

    public static boolean bpU(String str) {
        AppMethodBeat.i(194821);
        if (str == null) {
            AppMethodBeat.o(194821);
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (String str2 : RJw) {
            if (!Util.isNullOrNil(str2) && lowerCase.startsWith(str2)) {
                AppMethodBeat.o(194821);
                return true;
            }
        }
        AppMethodBeat.o(194821);
        return false;
    }

    public static boolean bpV(String str) {
        AppMethodBeat.i(194822);
        if (str == null) {
            AppMethodBeat.o(194822);
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (String str2 : RJx) {
            if (!Util.isNullOrNil(str2) && lowerCase.startsWith(str2)) {
                AppMethodBeat.o(194822);
                return true;
            }
        }
        AppMethodBeat.o(194822);
        return false;
    }

    public static void a(f fVar) {
        AppMethodBeat.i(91139);
        if (fVar == null) {
            Log.w("MicroMsg.QBarAIModHelper", "config wxQBar is null");
            AppMethodBeat.o(91139);
            return;
        }
        for (String str : RJw) {
            fVar.bpW(str);
        }
        for (String str2 : RJx) {
            fVar.bpX(str2);
        }
        fVar.aqy(6);
        AppMethodBeat.o(91139);
    }

    public static void a(f fVar, int i2) {
        AppMethodBeat.i(176204);
        if (fVar == null) {
            AppMethodBeat.o(176204);
            return;
        }
        Log.i("MicroMsg.QBarAIModHelper", "alvinluo setBlackInterval %d", Integer.valueOf(i2));
        if (i2 > 0) {
            fVar.aqy(i2);
        }
        AppMethodBeat.o(176204);
    }
}
