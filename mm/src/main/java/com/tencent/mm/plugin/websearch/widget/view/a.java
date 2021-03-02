package com.tencent.mm.plugin.websearch.widget.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.ui.widget.a.e;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static final a IIv = new a();
    public Map<Integer, e> IIt = new HashMap();
    private c IIu;

    static {
        AppMethodBeat.i(116674);
        AppMethodBeat.o(116674);
    }

    public static a fYZ() {
        return IIv;
    }

    private a() {
        AppMethodBeat.i(116672);
        c.a aVar = new c.a();
        aVar.jbf = true;
        aVar.jbe = true;
        this.IIu = aVar.bdv();
        AppMethodBeat.o(116672);
    }
}
