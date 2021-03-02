package com.tencent.mm.plugin.appbrand.ae.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class g implements c {
    private byte[] content;
    private TreeMap<String, String> ojw = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    public g() {
        AppMethodBeat.i(156665);
        AppMethodBeat.o(156665);
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.e.f
    public final Iterator<String> bZO() {
        AppMethodBeat.i(156666);
        Iterator<String> it = Collections.unmodifiableSet(this.ojw.keySet()).iterator();
        AppMethodBeat.o(156666);
        return it;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.e.f
    public final String afQ(String str) {
        AppMethodBeat.i(156667);
        String str2 = this.ojw.get(str);
        if (str2 == null) {
            AppMethodBeat.o(156667);
            return "";
        }
        AppMethodBeat.o(156667);
        return str2;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.e.f
    public final byte[] getContent() {
        return this.content;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.e.c
    public final void put(String str, String str2) {
        AppMethodBeat.i(156668);
        this.ojw.put(str, str2);
        AppMethodBeat.o(156668);
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.e.f
    public final boolean afR(String str) {
        AppMethodBeat.i(156669);
        boolean containsKey = this.ojw.containsKey(str);
        AppMethodBeat.o(156669);
        return containsKey;
    }
}
