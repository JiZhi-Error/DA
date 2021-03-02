package com.tencent.mm.plugin.sns.ad.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.j;

public final class k {

    public interface b {
        String eYo();

        String eYp();

        String eYq();
    }

    public static abstract class a implements b {
        @Override // com.tencent.mm.plugin.sns.ad.i.k.b
        public final String eYo() {
            return "";
        }
    }

    public static void a(b bVar) {
        AppMethodBeat.i(202364);
        if (bVar == null) {
            AppMethodBeat.o(202364);
            return;
        }
        j.b(bVar.eYp(), bVar.eYq(), 0, 0, bVar.eYo());
        AppMethodBeat.o(202364);
    }
}
