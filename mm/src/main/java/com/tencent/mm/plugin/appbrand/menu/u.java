package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum u {
    CopyPath,
    BackToHome,
    splitScreen,
    ShareAppMsg,
    ShareToTimeLine,
    EnableDebug,
    ShowPkgInfo,
    EnablePerformancePanel,
    OpenGamePreload,
    Exit,
    StickInWeChat,
    SendToDesktop,
    ModifyCollection,
    AboutUs,
    AppId,
    DebugRestart,
    DumpPerformanceTrace,
    SendRed,
    ReceiveRed,
    GameCpuProfiler,
    GameHeapProfiler,
    GameForceGc,
    Minimize,
    Setting,
    Complaint,
    GrowthCare,
    DevTools,
    Restart,
    Fav,
    ShareToWork,
    SendHandoff,
    CopyShortLink;

    public static u valueOf(String str) {
        AppMethodBeat.i(147328);
        u uVar = (u) Enum.valueOf(u.class, str);
        AppMethodBeat.o(147328);
        return uVar;
    }

    static {
        AppMethodBeat.i(147329);
        AppMethodBeat.o(147329);
    }
}
