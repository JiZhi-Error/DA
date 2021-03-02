package com.tencent.mm.plugin.handoff.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, hxF = {"cdata", "", "", "api-handoff_release"})
public final class a {
    public static final String du(Object obj) {
        AppMethodBeat.i(121712);
        p.h(obj, "$this$cdata");
        String str = "<![CDATA[" + obj + "]]>";
        AppMethodBeat.o(121712);
        return str;
    }
}
