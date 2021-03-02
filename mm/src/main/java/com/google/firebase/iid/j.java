package com.google.firebase.iid;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final /* synthetic */ class j implements l {
    private final TaskCompletionSource bLA;

    j(TaskCompletionSource taskCompletionSource) {
        this.bLA = taskCompletionSource;
    }

    @Override // com.google.firebase.iid.l
    public final String zzp() {
        AppMethodBeat.i(4169);
        String a2 = i.a(this.bLA);
        AppMethodBeat.o(4169);
        return a2;
    }
}
