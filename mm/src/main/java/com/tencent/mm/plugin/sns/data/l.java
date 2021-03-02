package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dzo;
import java.util.concurrent.ConcurrentHashMap;

public final class l {
    public ConcurrentHashMap<String, CharSequence> DEn = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, String> DEo = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, CharSequence> DEp = new ConcurrentHashMap<>();

    public l() {
        AppMethodBeat.i(95082);
        AppMethodBeat.o(95082);
    }

    public final void a(dzo dzo, CharSequence charSequence) {
        AppMethodBeat.i(95083);
        this.DEn.put(dzo.MYT + "-" + dzo.MYV + "-" + dzo.iAc, charSequence);
        AppMethodBeat.o(95083);
    }

    public final void a(dzo dzo, String str) {
        AppMethodBeat.i(95084);
        this.DEo.put(dzo.MYT + "-" + dzo.MYV + "-" + dzo.iAc, str);
        AppMethodBeat.o(95084);
    }

    public final void b(dzo dzo, CharSequence charSequence) {
        AppMethodBeat.i(202617);
        this.DEp.put(dzo.MYT + "-" + dzo.MYV + "-" + dzo.iAc, charSequence);
        AppMethodBeat.o(202617);
    }
}
