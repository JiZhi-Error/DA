package com.tencent.mm.plugin.appbrand.page.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/navigation/TypePageNavigateBackInterceptor;", "", "(Ljava/lang/String;I)V", "NONE", "SILENT", "WITH_CONFIRM_DIALOG", "luggage-wxa-app_release"})
public enum i {
    NONE,
    SILENT,
    WITH_CONFIRM_DIALOG;

    static {
        AppMethodBeat.i(219747);
        AppMethodBeat.o(219747);
    }

    public static i valueOf(String str) {
        AppMethodBeat.i(219749);
        i iVar = (i) Enum.valueOf(i.class, str);
        AppMethodBeat.o(219749);
        return iVar;
    }
}
