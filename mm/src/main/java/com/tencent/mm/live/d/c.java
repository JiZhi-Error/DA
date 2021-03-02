package com.tencent.mm.live.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\b\u0010\n\u001a\u00020\bH\u0007J\b\u0010\u000b\u001a\u00020\bH\u0007J\b\u0010\f\u001a\u00020\bH\u0007J\b\u0010\r\u001a\u00020\bH\u0007J\b\u0010\u000e\u001a\u00020\bH\u0007J\b\u0010\u000f\u001a\u00020\bH\u0007J\b\u0010\u0010\u001a\u00020\bH\u0007J\b\u0010\u0011\u001a\u00020\bH\u0007J\b\u0010\u0012\u001a\u00020\bH\u0007J\b\u0010\u0013\u001a\u00020\bH\u0007J\b\u0010\u0014\u001a\u00020\bH\u0007J\b\u0010\u0015\u001a\u00020\bH\u0007J\b\u0010\u0016\u001a\u00020\bH\u0007J\b\u0010\u0017\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/live/report/LiveLinkMicIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markAnchorAllowLinkMic", "", "markAnchorForbidLinkMic", "markAnchorHangUpInAudioLink", "markAnchorHangUpInVideoLink", "markLinkMicFailed", "markVisitorChangeToAudioAfterLinkVideo", "markVisitorForgiveLinkBeforeConnect", "markVisitorForgiveLinkVideoBeforeConnect", "markVisitorHangUpInAudioLink", "markVisitorHangUpInVideoLink", "markVisitorHangUpLinkMicAfterLinkVideo", "markVisitorLinVideoMic", "markVisitorLinkMicSuccess", "markVisitorRequestLinkMic", "markVisitorSwitchCameraConnecting", "markVisitorSwitchCameraWhileWaitingConnect", "plugin-logic_release"})
public final class c {
    public static final c hTL = new c();

    static {
        AppMethodBeat.i(208322);
        AppMethodBeat.o(208322);
    }

    private c() {
    }

    public static final void aIh() {
        AppMethodBeat.i(208306);
        Log.i("MicroMsg.LiveLinkMicIDKeyStat", "markAnchorForbidLinkMic");
        h.INSTANCE.n(1386, 0, 1);
        AppMethodBeat.o(208306);
    }

    public static final void aIi() {
        AppMethodBeat.i(208307);
        Log.i("MicroMsg.LiveLinkMicIDKeyStat", "markAnchorAllowLinkMic");
        h.INSTANCE.n(1386, 1, 1);
        AppMethodBeat.o(208307);
    }

    public static final void aIj() {
        AppMethodBeat.i(208308);
        Log.i("MicroMsg.LiveLinkMicIDKeyStat", "markVisitorRequestLinkMic");
        h.INSTANCE.n(1386, 2, 1);
        AppMethodBeat.o(208308);
    }

    public static final void aIk() {
        AppMethodBeat.i(208309);
        Log.i("MicroMsg.LiveLinkMicIDKeyStat", "markVisitorForgiveLinkBeforeConnect");
        h.INSTANCE.n(1386, 3, 1);
        AppMethodBeat.o(208309);
    }

    public static final void aIl() {
        AppMethodBeat.i(208310);
        Log.i("MicroMsg.LiveLinkMicIDKeyStat", "markVisitorForgiveLinkVideoBeforeConnect");
        h.INSTANCE.n(1386, 4, 1);
        AppMethodBeat.o(208310);
    }

    public static final void aIm() {
        AppMethodBeat.i(208311);
        Log.i("MicroMsg.LiveLinkMicIDKeyStat", "markVisitorSwitchCameraWhileWaitingConnect");
        h.INSTANCE.n(1386, 5, 1);
        AppMethodBeat.o(208311);
    }

    public static final void aIn() {
        AppMethodBeat.i(208312);
        Log.i("MicroMsg.LiveLinkMicIDKeyStat", "markVisitorSwitchCameraWhileWaitingConnect");
        h.INSTANCE.n(1386, 6, 1);
        AppMethodBeat.o(208312);
    }

    public static final void aIo() {
        AppMethodBeat.i(208313);
        Log.i("MicroMsg.LiveLinkMicIDKeyStat", "markVisitorLinkMicSuccess");
        h.INSTANCE.n(1386, 7, 1);
        AppMethodBeat.o(208313);
    }

    public static final void aIp() {
        AppMethodBeat.i(208314);
        Log.i("MicroMsg.LiveLinkMicIDKeyStat", "markVisitorLinVideoMic");
        h.INSTANCE.n(1386, 8, 1);
        AppMethodBeat.o(208314);
    }

    public static final void aIq() {
        AppMethodBeat.i(208315);
        Log.i("MicroMsg.LiveLinkMicIDKeyStat", "markVisitorHangUpLinkMicAfterLinkVideo");
        h.INSTANCE.n(1386, 9, 1);
        AppMethodBeat.o(208315);
    }

    public static final void aIr() {
        AppMethodBeat.i(208316);
        Log.i("MicroMsg.LiveLinkMicIDKeyStat", "markVisitorChangeToAudioAfterLinkVideo");
        h.INSTANCE.n(1386, 10, 1);
        AppMethodBeat.o(208316);
    }

    public static final void aIs() {
        AppMethodBeat.i(208317);
        Log.i("MicroMsg.LiveLinkMicIDKeyStat", "markVisitorHangUpInAudioLink");
        h.INSTANCE.n(1386, 11, 1);
        AppMethodBeat.o(208317);
    }

    public static final void aIt() {
        AppMethodBeat.i(208318);
        Log.i("MicroMsg.LiveLinkMicIDKeyStat", "markVisitorHangUpInVideoLink");
        h.INSTANCE.n(1386, 12, 1);
        AppMethodBeat.o(208318);
    }

    public static final void aIu() {
        AppMethodBeat.i(208319);
        Log.i("MicroMsg.LiveLinkMicIDKeyStat", "markAnchorHangUpInAudioLink");
        h.INSTANCE.n(1386, 13, 1);
        AppMethodBeat.o(208319);
    }

    public static final void aIv() {
        AppMethodBeat.i(208320);
        Log.i("MicroMsg.LiveLinkMicIDKeyStat", "markAnchorHangUpInVideoLink");
        h.INSTANCE.n(1386, 14, 1);
        AppMethodBeat.o(208320);
    }

    public static final void aIw() {
        AppMethodBeat.i(208321);
        Log.i("MicroMsg.LiveLinkMicIDKeyStat", "markLinkMicFailed");
        h.INSTANCE.n(1386, 15, 1);
        AppMethodBeat.o(208321);
    }
}
