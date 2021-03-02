package com.tencent.mm.plugin.appbrand.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import java.net.InetAddress;

public final class f {
    private static int lkW = TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR;
    InetAddress lkX;
    int lkY;
    int port;

    private f(InetAddress inetAddress, int i2) {
        this.lkX = inetAddress;
        this.port = 1900;
        this.lkY = i2;
    }

    public f(String str) {
        this(InetAddress.getByName(str), lkW);
        AppMethodBeat.i(158987);
        AppMethodBeat.o(158987);
    }
}
