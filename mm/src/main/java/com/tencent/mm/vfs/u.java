package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStreamReader;

public final class u extends InputStreamReader {
    public u(String str) {
        super(s.openRead(str));
        AppMethodBeat.i(13317);
        AppMethodBeat.o(13317);
    }

    public u(o oVar) {
        super(s.b(oVar.mUri, oVar.heo()));
        AppMethodBeat.i(13318);
        AppMethodBeat.o(13318);
    }
}
