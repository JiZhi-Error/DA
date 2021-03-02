package com.tencent.tbs.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private long f2297a = 3145728;

    @Override // com.tencent.tbs.a.a.a.a
    public final boolean a(File file) {
        AppMethodBeat.i(174288);
        if (file == null) {
            AppMethodBeat.o(174288);
            return false;
        } else if (file.length() > this.f2297a) {
            AppMethodBeat.o(174288);
            return true;
        } else {
            AppMethodBeat.o(174288);
            return false;
        }
    }
}
