package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e {
    PIP_CLICKED,
    PIP_CLOSE_BUTTON_CLICKED,
    OTHER_VIDEO_AUTO_PLAY,
    OTHER_VIDEO_PLAY,
    PAGE_RE_LAUNCH,
    EXIT_PIP_CALLED,
    OTHERS;

    public static e valueOf(String str) {
        AppMethodBeat.i(219510);
        e eVar = (e) Enum.valueOf(e.class, str);
        AppMethodBeat.o(219510);
        return eVar;
    }

    static {
        AppMethodBeat.i(219511);
        AppMethodBeat.o(219511);
    }
}
