package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.regex.Pattern;

public final class a {
    public static final Pattern IJn = Pattern.compile("(http|https)://" + WeChatHosts.domainString(R.string.e20) + ".*");
    public static final String IJo = (b.aKJ() + "vproxy");

    static {
        AppMethodBeat.i(77805);
        AppMethodBeat.o(77805);
    }
}
