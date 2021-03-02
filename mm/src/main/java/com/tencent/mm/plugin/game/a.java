package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;

public final class a {
    public static final String xtm = (WeChatHosts.domainString(R.string.e1h) + "/cgi-bin/h5/static/gamecenter/detail.html");
    public static final String xtn = WeChatPermissions.PERMISSION_MM_MESSAGE();
    public static final String xto = (b.c(b.a.ONE_WEEK) + "message/");

    static {
        AppMethodBeat.i(40810);
        AppMethodBeat.o(40810);
    }
}
