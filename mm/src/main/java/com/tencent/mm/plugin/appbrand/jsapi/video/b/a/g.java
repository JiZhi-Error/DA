package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.net.MalformedURLException;
import java.net.URL;

public final class g implements e {
    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.a.e
    public final String generate(String str) {
        URL url;
        AppMethodBeat.i(234688);
        if (!URLUtil.isNetworkUrl(str)) {
            AppMethodBeat.o(234688);
            return str;
        }
        if (str != null && str.startsWith("http://mpvideo.qpic.cn")) {
            str = str.substring(0, str.indexOf("?"));
        }
        try {
            url = new URL(str);
        } catch (MalformedURLException e2) {
            h.log(6, "DefaultCacheKeyGenerator", h.i(e2));
            url = null;
        }
        if (url != null) {
            String substring = MD5Util.getMD5String(str).substring(0, 20);
            AppMethodBeat.o(234688);
            return substring;
        }
        AppMethodBeat.o(234688);
        return null;
    }
}
