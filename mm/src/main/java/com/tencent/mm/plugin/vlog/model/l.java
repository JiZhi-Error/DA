package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/Filter;", "", "(Ljava/lang/String;I)V", "NO_FILTER", "plugin-vlog_release"})
public enum l {
    NO_FILTER;

    static {
        AppMethodBeat.i(110920);
        AppMethodBeat.o(110920);
    }

    public static l valueOf(String str) {
        AppMethodBeat.i(110922);
        l lVar = (l) Enum.valueOf(l.class, str);
        AppMethodBeat.o(110922);
        return lVar;
    }
}
