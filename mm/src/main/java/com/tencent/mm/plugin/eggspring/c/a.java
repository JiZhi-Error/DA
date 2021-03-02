package com.tencent.mm.plugin.eggspring.c;

import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/model/AcceptEvent;", "", "(Ljava/lang/String;I)V", "Succeed", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Denied", "FatalError", "plugin-eggspring_release"})
public enum a {
    Succeed,
    qUZ,
    Denied,
    FatalError;

    static {
        AppMethodBeat.i(194568);
        AppMethodBeat.o(194568);
    }

    public static a valueOf(String str) {
        AppMethodBeat.i(194570);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(194570);
        return aVar;
    }
}
