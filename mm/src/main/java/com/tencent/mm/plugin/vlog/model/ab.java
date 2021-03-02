package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/TransitionType;", "", "(Ljava/lang/String;I)V", "NONE", "FADE", "plugin-vlog_release"})
public enum ab {
    NONE,
    FADE;

    static {
        AppMethodBeat.i(110931);
        AppMethodBeat.o(110931);
    }

    public static ab valueOf(String str) {
        AppMethodBeat.i(110933);
        ab abVar = (ab) Enum.valueOf(ab.class, str);
        AppMethodBeat.o(110933);
        return abVar;
    }
}
