package com.bumptech.glide.manager;

import com.bumptech.glide.g.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* access modifiers changed from: package-private */
public final class a implements h {
    private final Set<i> aMm = Collections.newSetFromMap(new WeakHashMap());
    private boolean aMn;
    private boolean isStarted;

    a() {
        AppMethodBeat.i(77540);
        AppMethodBeat.o(77540);
    }

    @Override // com.bumptech.glide.manager.h
    public final void a(i iVar) {
        AppMethodBeat.i(77541);
        this.aMm.add(iVar);
        if (this.aMn) {
            iVar.onDestroy();
            AppMethodBeat.o(77541);
        } else if (this.isStarted) {
            iVar.onStart();
            AppMethodBeat.o(77541);
        } else {
            iVar.onStop();
            AppMethodBeat.o(77541);
        }
    }

    @Override // com.bumptech.glide.manager.h
    public final void b(i iVar) {
        AppMethodBeat.i(77542);
        this.aMm.remove(iVar);
        AppMethodBeat.o(77542);
    }

    /* access modifiers changed from: package-private */
    public final void onStart() {
        AppMethodBeat.i(77543);
        this.isStarted = true;
        for (i iVar : k.c(this.aMm)) {
            iVar.onStart();
        }
        AppMethodBeat.o(77543);
    }

    /* access modifiers changed from: package-private */
    public final void onStop() {
        AppMethodBeat.i(77544);
        this.isStarted = false;
        for (i iVar : k.c(this.aMm)) {
            iVar.onStop();
        }
        AppMethodBeat.o(77544);
    }

    /* access modifiers changed from: package-private */
    public final void onDestroy() {
        AppMethodBeat.i(77545);
        this.aMn = true;
        for (i iVar : k.c(this.aMm)) {
            iVar.onDestroy();
        }
        AppMethodBeat.o(77545);
    }
}
