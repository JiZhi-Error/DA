package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import java.util.LinkedList;
import java.util.List;

final class a {
    static final List<DebuggerShell.a> lhz;

    static {
        AppMethodBeat.i(44936);
        LinkedList linkedList = new LinkedList();
        lhz = linkedList;
        linkedList.add(new d());
        lhz.add(new e());
        lhz.add(new g());
        lhz.add(new h());
        AppMethodBeat.o(44936);
    }
}
