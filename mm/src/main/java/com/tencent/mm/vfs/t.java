package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterOutputStream;

public final class t extends FilterOutputStream {
    public t(String str) {
        super(s.dw(str, false));
        AppMethodBeat.i(13305);
        AppMethodBeat.o(13305);
    }
}
