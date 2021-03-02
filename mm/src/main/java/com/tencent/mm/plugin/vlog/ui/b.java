package com.tencent.mm.plugin.vlog.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/MultiEditStatus;", "", "(Ljava/lang/String;I)V", "DEFAULT", "GLOBAL_EDIT", "SINGLE_EDIT", "plugin-vlog_release"})
public enum b {
    DEFAULT,
    GLOBAL_EDIT,
    SINGLE_EDIT;

    static {
        AppMethodBeat.i(190943);
        AppMethodBeat.o(190943);
    }

    public static b valueOf(String str) {
        AppMethodBeat.i(190945);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(190945);
        return bVar;
    }
}
