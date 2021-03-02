package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/voip/model/VoipForegroundIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markForegroundServiceCallInAccountUninit", "", "markForegroundServiceDestroyByKilled", "markForegroundServiceOnCreate", "markForegroundServiceOnDestroy", "markForegroundServiceOnStartCommand", "markForegroundServiceReCalled", "markForegroundServiceStopCall", "markUseStartForegroundService", "markUseStartService", "markVoipForegroundServiceStartCalled", "plugin-voip_release"})
public final class q {
    public static final q GXY = new q();

    static {
        AppMethodBeat.i(115937);
        AppMethodBeat.o(115937);
    }

    private q() {
    }

    public static void fHa() {
        AppMethodBeat.i(115927);
        Log.i("MicroMsg.VoipForegroundIDKeyStat", "markVoipForegroundServiceCalled");
        h.INSTANCE.n(1081, 0, 1);
        AppMethodBeat.o(115927);
    }

    public static void fHb() {
        AppMethodBeat.i(115928);
        Log.i("MicroMsg.VoipForegroundIDKeyStat", "markUseStartService");
        h.INSTANCE.n(1081, 1, 1);
        AppMethodBeat.o(115928);
    }

    public static void fHc() {
        AppMethodBeat.i(115929);
        Log.i("MicroMsg.VoipForegroundIDKeyStat", "markUseStartForegroundService");
        h.INSTANCE.n(1081, 2, 1);
        AppMethodBeat.o(115929);
    }

    public static void fHd() {
        AppMethodBeat.i(115930);
        Log.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceOnCreate");
        h.INSTANCE.n(1081, 3, 1);
        AppMethodBeat.o(115930);
    }

    public static void fHe() {
        AppMethodBeat.i(115931);
        Log.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceOnStartCommand");
        h.INSTANCE.n(1081, 4, 1);
        AppMethodBeat.o(115931);
    }

    public static void fHf() {
        AppMethodBeat.i(115932);
        Log.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceOnDestroy");
        h.INSTANCE.n(1081, 5, 1);
        AppMethodBeat.o(115932);
    }

    public static void fHg() {
        AppMethodBeat.i(115933);
        Log.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceStopCall");
        h.INSTANCE.n(1081, 6, 1);
        AppMethodBeat.o(115933);
    }

    public static void fHh() {
        AppMethodBeat.i(115934);
        Log.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceDestroyByKilled");
        h.INSTANCE.n(1081, 7, 1);
        AppMethodBeat.o(115934);
    }

    public static void fHi() {
        AppMethodBeat.i(115935);
        Log.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceReCalled");
        h.INSTANCE.n(1081, 8, 1);
        AppMethodBeat.o(115935);
    }

    public static void fHj() {
        AppMethodBeat.i(115936);
        Log.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceCallInAccountUninit");
        h.INSTANCE.n(1081, 9, 1);
        AppMethodBeat.o(115936);
    }
}
