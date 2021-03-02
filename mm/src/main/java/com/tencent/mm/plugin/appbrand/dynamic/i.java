package com.tencent.mm.plugin.appbrand.dynamic;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class i {
    private static final i lmg = new i();
    private Map<String, String> lmf = new HashMap();

    static {
        AppMethodBeat.i(121183);
        AppMethodBeat.o(121183);
    }

    public static i bBL() {
        return lmg;
    }

    public i() {
        AppMethodBeat.i(121178);
        AppMethodBeat.o(121178);
    }

    public final void cZ(String str, String str2) {
        AppMethodBeat.i(121179);
        if (TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(121179);
            return;
        }
        this.lmf.put(str, str2);
        AppMethodBeat.o(121179);
    }

    public final String Yn(String str) {
        AppMethodBeat.i(121180);
        String str2 = this.lmf.get(str);
        AppMethodBeat.o(121180);
        return str2;
    }

    public final void Yo(String str) {
        AppMethodBeat.i(121181);
        this.lmf.remove(str);
        AppMethodBeat.o(121181);
    }

    public final Collection<String> bBM() {
        AppMethodBeat.i(121182);
        Collection<String> values = this.lmf.values();
        AppMethodBeat.o(121182);
        return values;
    }
}
