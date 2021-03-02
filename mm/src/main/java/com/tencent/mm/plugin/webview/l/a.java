package com.tencent.mm.plugin.webview.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import kotlin.g.b.p;
import kotlin.l;
import org.apache.commons.b.f;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0004"}, hxF = {"htmlEncode", "", "kotlin.jvm.PlatformType", "toJsString", "webview-sdk_release"})
public final class a {
    public static final String htmlEncode(String str) {
        AppMethodBeat.i(82769);
        p.h(str, "$this$htmlEncode");
        String encode = q.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        AppMethodBeat.o(82769);
        return encode;
    }

    public static final String bbs(String str) {
        AppMethodBeat.i(82770);
        p.h(str, "$this$toJsString");
        String str2 = "'" + f.bve(str) + '\'';
        AppMethodBeat.o(82770);
        return str2;
    }
}
