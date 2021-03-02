package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

final /* synthetic */ class ac implements Runnable {
    private final TaskCompletionSource bLD;
    private final Bundle bMA;
    private final ab bMz;

    ac(ab abVar, Bundle bundle, TaskCompletionSource taskCompletionSource) {
        this.bMz = abVar;
        this.bMA = bundle;
        this.bLD = taskCompletionSource;
    }

    public final void run() {
        AppMethodBeat.i(4234);
        ab abVar = this.bMz;
        Bundle bundle = this.bMA;
        TaskCompletionSource taskCompletionSource = this.bLD;
        try {
            taskCompletionSource.setResult(abVar.bMx.h(bundle));
            AppMethodBeat.o(4234);
        } catch (IOException e2) {
            taskCompletionSource.setException(e2);
            AppMethodBeat.o(4234);
        }
    }
}
