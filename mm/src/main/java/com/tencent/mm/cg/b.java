package com.tencent.mm.cg;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class b {
    private final a<?>[] NME;
    private final HashMap<String, a<?>> NMF = new HashMap<>();

    public interface a<T> {
        T get();

        String name();
    }

    public b(Context context) {
        AppMethodBeat.i(133216);
        c cVar = new c(context);
        this.NME = new a[]{cVar.NMG, cVar.NMH};
        AppMethodBeat.o(133216);
    }
}
