package com.tencent.mm.plugin.appbrand.ac;

import android.content.Context;
import android.os.Build;
import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;
import org.xwalk.core.XWalkEnvironment;

public final class p {

    public interface a extends b {
        String Nv();

        String version();
    }

    private static boolean bZo() {
        AppMethodBeat.i(140850);
        if (Build.VERSION.SDK_INT < 21) {
            AppMethodBeat.o(140850);
            return false;
        }
        for (String str : Build.SUPPORTED_64_BIT_ABIS) {
            if (XWalkEnvironment.RUNTIME_ABI_ARM64_STR.equalsIgnoreCase(str)) {
                AppMethodBeat.o(140850);
                return true;
            }
        }
        AppMethodBeat.o(140850);
        return false;
    }

    public static <T extends a> String a(Context context, String str, T t) {
        String str2;
        AppMethodBeat.i(140851);
        Assert.assertTrue("Luggage.UserAgentUtil, appendUserAgent fail, context is null, stack = " + Util.getStack(), context != null);
        if (str == null) {
            str2 = t.Nv();
        } else {
            str2 = str + t.Nv();
        }
        String str3 = (((str2 + t.version()) + " NetType/" + NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())) + " Language/" + LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext())) + " ABI/" + (bZo() ? "arm64" : "arm32");
        Log.i("Luggage.UserAgentUtil", "appendUserAgent, uaStr = ".concat(String.valueOf(str3)));
        AppMethodBeat.o(140851);
        return str3;
    }
}
