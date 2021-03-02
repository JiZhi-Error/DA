package com.tencent.mm.plugin.card.ui.v4;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v4/FetchCardListState;", "", "msg", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "IDLE", "LOADING", "DELETING", "INCOMPLETE", "UP_TO_DATE", "FAILED", "plugin-card_release"})
public enum e {
    IDLE(""),
    LOADING(""),
    DELETING(""),
    INCOMPLETE(""),
    UP_TO_DATE(""),
    FAILED("");
    
    String msg;

    public static e valueOf(String str) {
        AppMethodBeat.i(201682);
        e eVar = (e) Enum.valueOf(e.class, str);
        AppMethodBeat.o(201682);
        return eVar;
    }

    private e(String str) {
        this.msg = str;
    }

    public final void ajT(String str) {
        AppMethodBeat.i(201680);
        p.h(str, "<set-?>");
        this.msg = str;
        AppMethodBeat.o(201680);
    }

    static {
        AppMethodBeat.i(201679);
        AppMethodBeat.o(201679);
    }
}
