package com.tencent.xweb.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class c implements f {
    @Override // com.tencent.xweb.b.f
    public final d bst(String str) {
        AppMethodBeat.i(183509);
        a aVar = new a(new File(str));
        AppMethodBeat.o(183509);
        return aVar;
    }

    @Override // com.tencent.xweb.b.f
    public final d aj(File file) {
        AppMethodBeat.i(183510);
        a aVar = new a(file);
        AppMethodBeat.o(183510);
        return aVar;
    }

    @Override // com.tencent.xweb.b.f
    public final e hts() {
        AppMethodBeat.i(183511);
        b bVar = new b();
        AppMethodBeat.o(183511);
        return bVar;
    }
}
