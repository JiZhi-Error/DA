package com.bumptech.glide.manager;

import com.bumptech.glide.e.a.e;
import com.bumptech.glide.g.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public final class o implements i {
    public final Set<e<?>> aML = Collections.newSetFromMap(new WeakHashMap());

    public o() {
        AppMethodBeat.i(77590);
        AppMethodBeat.o(77590);
    }

    @Override // com.bumptech.glide.manager.i
    public final void onStart() {
        AppMethodBeat.i(77592);
        for (e eVar : k.c(this.aML)) {
            eVar.onStart();
        }
        AppMethodBeat.o(77592);
    }

    @Override // com.bumptech.glide.manager.i
    public final void onStop() {
        AppMethodBeat.i(77593);
        for (e eVar : k.c(this.aML)) {
            eVar.onStop();
        }
        AppMethodBeat.o(77593);
    }

    @Override // com.bumptech.glide.manager.i
    public final void onDestroy() {
        AppMethodBeat.i(77594);
        for (e eVar : k.c(this.aML)) {
            eVar.onDestroy();
        }
        AppMethodBeat.o(77594);
    }
}
