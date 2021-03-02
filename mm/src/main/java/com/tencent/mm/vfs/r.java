package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;

public final class r extends FilterInputStream {
    public r(String str) {
        super(s.openRead(str));
        AppMethodBeat.i(13262);
        AppMethodBeat.o(13262);
    }

    public r(o oVar) {
        super(s.b(oVar.mUri, oVar.heo()));
        AppMethodBeat.i(13263);
        AppMethodBeat.o(13263);
    }
}
