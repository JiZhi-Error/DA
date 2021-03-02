package com.bumptech.glide.manager;

import com.bumptech.glide.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class n {
    public final Set<c> aMG = Collections.newSetFromMap(new WeakHashMap());
    public final List<c> aMH = new ArrayList();
    public boolean isPaused;

    public n() {
        AppMethodBeat.i(77577);
        AppMethodBeat.o(77577);
    }

    public final boolean a(c cVar, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(77578);
        if (cVar == null) {
            AppMethodBeat.o(77578);
        } else {
            boolean remove = this.aMG.remove(cVar);
            if (!this.aMH.remove(cVar) && !remove) {
                z2 = false;
            }
            if (z2) {
                cVar.clear();
                if (z) {
                    cVar.recycle();
                }
            }
            AppMethodBeat.o(77578);
        }
        return z2;
    }

    public final String toString() {
        AppMethodBeat.i(77579);
        String str = super.toString() + "{numRequests=" + this.aMG.size() + ", isPaused=" + this.isPaused + "}";
        AppMethodBeat.o(77579);
        return str;
    }
}
