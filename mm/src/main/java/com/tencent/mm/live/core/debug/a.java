package com.tencent.mm.live.core.debug;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/live/core/debug/LiveDebugViewMonitor;", "", "()V", "debugView", "Lcom/tencent/mm/live/core/debug/LiveDebugView;", "printDebugInfo", "", "debugText", "", "printDebugTagInfo", "tag", "printErrorInfo", "printLiveInfo", "info", "release", "setup", "plugin-core_release"})
public final class a {
    public static final a hCA = new a();
    private static LiveDebugView hCz;

    static {
        AppMethodBeat.i(196569);
        AppMethodBeat.o(196569);
    }

    private a() {
    }

    public static void c(LiveDebugView liveDebugView) {
        AppMethodBeat.i(196564);
        p.h(liveDebugView, "debugView");
        hCz = liveDebugView;
        AppMethodBeat.o(196564);
    }

    public static void GA(String str) {
        AppMethodBeat.i(196565);
        p.h(str, "debugText");
        Log.i("MicroMsg.LiveCore", str);
        LiveDebugView liveDebugView = hCz;
        if (liveDebugView != null) {
            liveDebugView.GA(str);
            AppMethodBeat.o(196565);
            return;
        }
        AppMethodBeat.o(196565);
    }

    public static void au(String str, String str2) {
        AppMethodBeat.i(196566);
        p.h(str, "tag");
        p.h(str2, "debugText");
        Log.i(str, str2);
        LiveDebugView liveDebugView = hCz;
        if (liveDebugView != null) {
            liveDebugView.GA(str2);
            AppMethodBeat.o(196566);
            return;
        }
        AppMethodBeat.o(196566);
    }

    public static void GB(String str) {
        AppMethodBeat.i(196567);
        p.h(str, "debugText");
        Log.i("MicroMsg.LiveCoreError", str);
        LiveDebugView liveDebugView = hCz;
        if (liveDebugView != null) {
            liveDebugView.GA(str);
            AppMethodBeat.o(196567);
            return;
        }
        AppMethodBeat.o(196567);
    }

    public static void GC(String str) {
        AppMethodBeat.i(196568);
        p.h(str, "info");
        Log.i("MicroMsg.LiveCoreNet", str);
        LiveDebugView liveDebugView = hCz;
        if (liveDebugView != null) {
            p.h(str, "liveInfo");
            liveDebugView.hCx.setText(str);
            AppMethodBeat.o(196568);
            return;
        }
        AppMethodBeat.o(196568);
    }

    public static void release() {
        hCz = null;
    }
}
