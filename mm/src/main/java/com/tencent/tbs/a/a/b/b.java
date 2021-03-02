package com.tencent.tbs.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private long f2304a = 604800000;

    @Override // com.tencent.tbs.a.a.b.a
    public final boolean a(File file) {
        AppMethodBeat.i(174289);
        if (file == null) {
            AppMethodBeat.o(174289);
            return false;
        } else if (System.currentTimeMillis() - file.lastModified() > this.f2304a) {
            AppMethodBeat.o(174289);
            return true;
        } else {
            AppMethodBeat.o(174289);
            return false;
        }
    }
}
