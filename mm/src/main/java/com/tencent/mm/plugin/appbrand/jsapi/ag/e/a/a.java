package com.tencent.mm.plugin.appbrand.jsapi.ag.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/EventType;", "", "(Ljava/lang/String;I)V", "ACTION_EMPTY", "ACTION_ADD_DEVICE", "ACTION_REMOVE_DEVICE", "ACTION_UPDATE_DEVICE", "ACTION_SET_VOLUME", "ACTION_PLAYING", "ACTION_PAUSED", "ACTION_STOPPED", "ACTION_VOLUME", "ACTION_MUTE", "ACTION_PROGRESS", "ACTION_ERROR", "luggage-xweb-ext_release"})
public enum a {
    ACTION_EMPTY,
    ACTION_ADD_DEVICE,
    ACTION_REMOVE_DEVICE,
    ACTION_UPDATE_DEVICE,
    ACTION_SET_VOLUME,
    ACTION_PLAYING,
    ACTION_PAUSED,
    ACTION_STOPPED,
    ACTION_VOLUME,
    ACTION_MUTE,
    ACTION_PROGRESS,
    ACTION_ERROR;

    static {
        AppMethodBeat.i(139679);
        AppMethodBeat.o(139679);
    }

    public static a valueOf(String str) {
        AppMethodBeat.i(139681);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(139681);
        return aVar;
    }
}
