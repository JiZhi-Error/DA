package com.google.firebase.iid;

import android.util.Pair;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final /* synthetic */ class k implements l {
    private final i bLB;
    private final l bLC;
    private final TaskCompletionSource bLD;
    private final Pair bLE;

    k(i iVar, l lVar, TaskCompletionSource taskCompletionSource, Pair pair) {
        this.bLB = iVar;
        this.bLC = lVar;
        this.bLD = taskCompletionSource;
        this.bLE = pair;
    }

    @Override // com.google.firebase.iid.l
    public final String zzp() {
        AppMethodBeat.i(4170);
        String a2 = this.bLB.a(this.bLC, this.bLD, this.bLE);
        AppMethodBeat.o(4170);
        return a2;
    }
}
