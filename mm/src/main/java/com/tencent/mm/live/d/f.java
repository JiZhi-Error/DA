package com.tencent.mm.live.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\b\u0010\n\u001a\u00020\bH\u0007J\b\u0010\u000b\u001a\u00020\bH\u0007J\b\u0010\f\u001a\u00020\bH\u0007J\b\u0010\r\u001a\u00020\bH\u0007J\b\u0010\u000e\u001a\u00020\bH\u0007J\b\u0010\u000f\u001a\u00020\bH\u0007J\b\u0010\u0010\u001a\u00020\bH\u0007J\b\u0010\u0011\u001a\u00020\bH\u0007J\b\u0010\u0012\u001a\u00020\bH\u0007J\b\u0010\u0013\u001a\u00020\bH\u0007J\b\u0010\u0014\u001a\u00020\bH\u0007J\b\u0010\u0015\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/live/report/LiveVisitorIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markClickAnchorAvatar", "", "markClickOnlineUserList", "markComplaintAnchor", "markVisitorChangeScreenLandscape", "markVisitorChangeScreenPortrait", "markVisitorClickComment", "markVisitorClickEmojiComment", "markVisitorClickLike", "markVisitorClickSysMsgEnterLive", "markVisitorClickTipbarEnterLive", "markVisitorMaximumView", "markVisitorMinimumView", "markVisitorPlayUseCdn", "markVisitorPlayUseTRTC", "plugin-logic_release"})
public final class f {
    public static final f hTQ = new f();

    static {
        AppMethodBeat.i(208365);
        AppMethodBeat.o(208365);
    }

    private f() {
    }

    public static final void aIL() {
        AppMethodBeat.i(208351);
        Log.i("MicroMsg.LiveVisitorIDKeyStat", "markVisitorClickSysMsgEnterLive");
        h.INSTANCE.n(1381, 0, 1);
        AppMethodBeat.o(208351);
    }

    public static final void aIM() {
        AppMethodBeat.i(208352);
        Log.i("MicroMsg.LiveVisitorIDKeyStat", "markVisitorClickTipbarEnterLive");
        h.INSTANCE.n(1381, 1, 1);
        AppMethodBeat.o(208352);
    }

    public static final void aIN() {
        AppMethodBeat.i(208353);
        Log.i("MicroMsg.LiveVisitorIDKeyStat", "markClickOnlineUserList");
        h.INSTANCE.n(1381, 2, 1);
        AppMethodBeat.o(208353);
    }

    public static final void aIO() {
        AppMethodBeat.i(208354);
        Log.i("MicroMsg.LiveVisitorIDKeyStat", "markClickAnchorAvatar");
        h.INSTANCE.n(1381, 3, 1);
        AppMethodBeat.o(208354);
    }

    public static final void aIP() {
        AppMethodBeat.i(208355);
        Log.i("MicroMsg.LiveVisitorIDKeyStat", "markComplaintAnchor");
        h.INSTANCE.n(1381, 4, 1);
        AppMethodBeat.o(208355);
    }

    public static final void aIQ() {
        AppMethodBeat.i(208356);
        Log.i("MicroMsg.LiveVisitorIDKeyStat", "markVisitorMinimumView");
        h.INSTANCE.n(1381, 5, 1);
        AppMethodBeat.o(208356);
    }

    public static final void aIR() {
        AppMethodBeat.i(208357);
        Log.i("MicroMsg.LiveVisitorIDKeyStat", "markVisitorMaximumView");
        h.INSTANCE.n(1381, 6, 1);
        AppMethodBeat.o(208357);
    }

    public static final void aIS() {
        AppMethodBeat.i(208358);
        Log.i("MicroMsg.LiveVisitorIDKeyStat", "markVisitorClickLike");
        h.INSTANCE.n(1381, 7, 1);
        AppMethodBeat.o(208358);
    }

    public static final void aIT() {
        AppMethodBeat.i(208359);
        Log.i("MicroMsg.LiveVisitorIDKeyStat", "markVisitorClickComment");
        h.INSTANCE.n(1381, 8, 1);
        AppMethodBeat.o(208359);
    }

    public static final void aIU() {
        AppMethodBeat.i(208360);
        Log.i("MicroMsg.LiveVisitorIDKeyStat", "markVisitorClickEmojiComment");
        h.INSTANCE.n(1381, 9, 1);
        AppMethodBeat.o(208360);
    }

    public static final void aIV() {
        AppMethodBeat.i(208361);
        Log.i("MicroMsg.LiveVisitorIDKeyStat", "markVisitorChangeScreenLandscape");
        h.INSTANCE.n(1381, 10, 1);
        AppMethodBeat.o(208361);
    }

    public static final void aIW() {
        AppMethodBeat.i(208362);
        Log.i("MicroMsg.LiveVisitorIDKeyStat", "markVisitorChangeScreenPortrait");
        h.INSTANCE.n(1381, 11, 1);
        AppMethodBeat.o(208362);
    }

    public static final void aIX() {
        AppMethodBeat.i(208363);
        Log.i("MicroMsg.LiveVisitorIDKeyStat", "markVisitorPlayUseCdn");
        h.INSTANCE.n(1381, 12, 1);
        AppMethodBeat.o(208363);
    }

    public static final void aIY() {
        AppMethodBeat.i(208364);
        Log.i("MicroMsg.LiveVisitorIDKeyStat", "markVisitorPlayUseTRTC");
        h.INSTANCE.n(1381, 13, 1);
        AppMethodBeat.o(208364);
    }
}
