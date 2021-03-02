package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/ScaleType;", "", "(Ljava/lang/String;I)V", "CENTER_CROP", "CENTER_INSIDE", "VERTICAL_DISPLAY", "NOT_SCALE", "plugin-vlog_release"})
public enum y {
    CENTER_CROP,
    CENTER_INSIDE,
    VERTICAL_DISPLAY,
    NOT_SCALE;

    static {
        AppMethodBeat.i(110928);
        AppMethodBeat.o(110928);
    }

    public static y valueOf(String str) {
        AppMethodBeat.i(110930);
        y yVar = (y) Enum.valueOf(y.class, str);
        AppMethodBeat.o(110930);
        return yVar;
    }
}
