package com.tencent.mm.plugin.finder.report.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/HELL_SCROLL_EVENT;", "", "(Ljava/lang/String;I)V", "EVENT_INVALIDATE", "EVENT_ON_SCROLL", "EVENT_ON_RESUME", "EVENT_ON_PAUSE", "EVENT_ON_REFRESH", "EVENT_ON_CREATE", "EVENT_ON_LOADMORE", "EVENT_ON_SCROLL_HORIZONTAL", "EVENT_ON_DESTROY", "plugin-finder_release"})
public enum c {
    EVENT_INVALIDATE,
    EVENT_ON_SCROLL,
    EVENT_ON_RESUME,
    EVENT_ON_PAUSE,
    EVENT_ON_REFRESH,
    EVENT_ON_CREATE,
    EVENT_ON_LOADMORE,
    EVENT_ON_SCROLL_HORIZONTAL,
    EVENT_ON_DESTROY;

    static {
        AppMethodBeat.i(250902);
        AppMethodBeat.o(250902);
    }

    public static c valueOf(String str) {
        AppMethodBeat.i(250904);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(250904);
        return cVar;
    }
}
