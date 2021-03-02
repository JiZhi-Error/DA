package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.HashMap;
import java.util.Map;

public final class ba {
    private static Map<String, String> Jao = new HashMap();

    static {
        AppMethodBeat.i(79101);
        AppMethodBeat.o(79101);
    }

    public static void mb(String str, String str2) {
        AppMethodBeat.i(79098);
        Log.i("MicroMsg.WebviewSharedUrlCache", "rawurl:[%s], shareUrl:[%s]", str, str2);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.WebviewSharedUrlCache", "rawurl is null or share url is null");
            AppMethodBeat.o(79098);
        } else if (Jao.containsKey(str)) {
            Log.i("MicroMsg.WebviewSharedUrlCache", "has add this rawurl");
            AppMethodBeat.o(79098);
        } else {
            Jao.put(str, str2);
            AppMethodBeat.o(79098);
        }
    }

    public static String aZj(String str) {
        String substring;
        AppMethodBeat.i(79099);
        Log.i("MicroMsg.WebviewSharedUrlCache", "rawUrl:[%s]", str);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.WebviewSharedUrlCache", "rawUrl is null");
            AppMethodBeat.o(79099);
            return null;
        }
        String str2 = Jao.get(str);
        if (Util.isNullOrNil(str2)) {
            int indexOf = str.indexOf("#");
            if (indexOf < 0) {
                substring = str;
            } else {
                substring = str.substring(0, indexOf);
            }
            str2 = Jao.get(substring);
        }
        if (Util.isNullOrNil(str2) && str.startsWith(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + FilePathGenerator.ANDROID_DIR_SEP)) {
            str2 = Jao.get(str.replaceFirst(HttpWrapperBase.PROTOCAL_HTTPS, HttpWrapperBase.PROTOCAL_HTTP));
        }
        if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(79099);
            return str;
        }
        AppMethodBeat.o(79099);
        return str2;
    }

    public static void clear() {
        AppMethodBeat.i(79100);
        Jao.clear();
        AppMethodBeat.o(79100);
    }
}
