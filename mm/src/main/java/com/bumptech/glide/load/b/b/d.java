package com.bumptech.glide.load.b.b;

import com.bumptech.glide.load.b.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class d implements a.AbstractC0068a {
    private final long aIU = 262144000;
    private final a aIV;

    public interface a {
        File ph();
    }

    public d(a aVar) {
        this.aIV = aVar;
    }

    @Override // com.bumptech.glide.load.b.b.a.AbstractC0068a
    public final a pf() {
        AppMethodBeat.i(77149);
        File ph = this.aIV.ph();
        if (ph == null) {
            AppMethodBeat.o(77149);
            return null;
        } else if (ph.mkdirs() || (ph.exists() && ph.isDirectory())) {
            e eVar = new e(ph, this.aIU);
            AppMethodBeat.o(77149);
            return eVar;
        } else {
            AppMethodBeat.o(77149);
            return null;
        }
    }
}
