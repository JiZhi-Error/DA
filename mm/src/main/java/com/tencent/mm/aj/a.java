package com.tencent.mm.aj;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.cache.g;
import com.tencent.mm.memory.a.c;

public final class a {
    f<String, Bitmap> iJX;

    public a(int i2) {
        AppMethodBeat.i(150193);
        this.iJX = new c(i2);
        AppMethodBeat.o(150193);
    }

    public final void c(String str, Bitmap bitmap) {
        AppMethodBeat.i(150194);
        if (this.iJX != null) {
            this.iJX.x(str, bitmap);
            AppMethodBeat.o(150194);
            return;
        }
        g.a.a("avatar_cache", str, bitmap);
        AppMethodBeat.o(150194);
    }
}
