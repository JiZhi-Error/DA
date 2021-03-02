package com.tencent.mm.live.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\b\u0010\n\u001a\u00020\bH\u0007J\b\u0010\u000b\u001a\u00020\bH\u0007J\b\u0010\f\u001a\u00020\bH\u0007J\b\u0010\r\u001a\u00020\bH\u0007J\b\u0010\u000e\u001a\u00020\bH\u0007J\b\u0010\u000f\u001a\u00020\bH\u0007J\b\u0010\u0010\u001a\u00020\bH\u0007J\b\u0010\u0011\u001a\u00020\bH\u0007J\b\u0010\u0012\u001a\u00020\bH\u0007J\b\u0010\u0013\u001a\u00020\bH\u0007J\b\u0010\u0014\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/live/report/LiveReplayIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markAnchorChangeReplayEveryOne", "", "markAnchorChangeReplayOnlySelf", "markAnchorClickToPlay", "markAnchorDragTimeLineWhilePlaying", "markAnchorEnterReplayAfterLive", "markAnchorEnterReplayFromAppMsg", "markAnchorEnterReplayFromMsgCard", "markAnchorSetReplayEveryOne", "markAnchorSetReplayOnlySelf", "markVisitorClickToPlay", "markVisitorDragTimeLineWhilePlaying", "markVisitorEnterReplayFromAppMsg", "markVisitorEnterReplayFromMsgCard", "plugin-logic_release"})
public final class d {
    public static final d hTM = new d();

    static {
        AppMethodBeat.i(208336);
        AppMethodBeat.o(208336);
    }

    private d() {
    }

    public static final void aIx() {
        AppMethodBeat.i(208323);
        Log.i("MicroMsg.LiveReplayIDKeyStat", "markAnchorSetReplayOnlySelf");
        h.INSTANCE.n(1385, 0, 1);
        AppMethodBeat.o(208323);
    }

    public static final void aIy() {
        AppMethodBeat.i(208324);
        Log.i("MicroMsg.LiveReplayIDKeyStat", "markAnchorSetReplayEveryOne");
        h.INSTANCE.n(1385, 1, 1);
        AppMethodBeat.o(208324);
    }

    public static final void aIz() {
        AppMethodBeat.i(208325);
        Log.i("MicroMsg.LiveReplayIDKeyStat", "markAnchorClickToPlay");
        h.INSTANCE.n(1385, 2, 1);
        AppMethodBeat.o(208325);
    }

    public static final void aIA() {
        AppMethodBeat.i(208326);
        Log.i("MicroMsg.LiveReplayIDKeyStat", "markAnchorDragTimeLineWhilePlaying");
        h.INSTANCE.n(1385, 3, 1);
        AppMethodBeat.o(208326);
    }

    public static final void aIB() {
        AppMethodBeat.i(208327);
        Log.i("MicroMsg.LiveReplayIDKeyStat", "markAnchorChangeReplayOnlySelf");
        h.INSTANCE.n(1385, 4, 1);
        AppMethodBeat.o(208327);
    }

    public static final void aIC() {
        AppMethodBeat.i(208328);
        Log.i("MicroMsg.LiveReplayIDKeyStat", "markAnchorChangeReplayEveryOne");
        h.INSTANCE.n(1385, 5, 1);
        AppMethodBeat.o(208328);
    }

    public static final void aID() {
        AppMethodBeat.i(208329);
        Log.i("MicroMsg.LiveReplayIDKeyStat", "markAnchorEnterReplayAfterLive");
        h.INSTANCE.n(1385, 6, 1);
        AppMethodBeat.o(208329);
    }

    public static final void aIE() {
        AppMethodBeat.i(208330);
        Log.i("MicroMsg.LiveReplayIDKeyStat", "markAnchorEnterReplayFromAppMsg");
        h.INSTANCE.n(1385, 7, 1);
        AppMethodBeat.o(208330);
    }

    public static final void aIF() {
        AppMethodBeat.i(208331);
        Log.i("MicroMsg.LiveReplayIDKeyStat", "markAnchorEnterReplayFromTipBar");
        h.INSTANCE.n(1385, 8, 1);
        AppMethodBeat.o(208331);
    }

    public static final void aIG() {
        AppMethodBeat.i(208332);
        Log.i("MicroMsg.LiveReplayIDKeyStat", "markVisitorEnterReplayFromSysMsg");
        h.INSTANCE.n(1385, 9, 1);
        AppMethodBeat.o(208332);
    }

    public static final void aIH() {
        AppMethodBeat.i(208333);
        Log.i("MicroMsg.LiveReplayIDKeyStat", "markVisitorEnterReplayFromTipBar");
        h.INSTANCE.n(1385, 10, 1);
        AppMethodBeat.o(208333);
    }

    public static final void aII() {
        AppMethodBeat.i(208334);
        Log.i("MicroMsg.LiveReplayIDKeyStat", "markVisitorClickToPlay");
        h.INSTANCE.n(1385, 11, 1);
        AppMethodBeat.o(208334);
    }

    public static final void aIJ() {
        AppMethodBeat.i(208335);
        Log.i("MicroMsg.LiveReplayIDKeyStat", "markVisitorDragTimeLineWhilePlaying");
        h.INSTANCE.n(1385, 12, 1);
        AppMethodBeat.o(208335);
    }
}
