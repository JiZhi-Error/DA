package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

final class ad implements Continuation<Bundle, String> {
    private final /* synthetic */ ab bMB;

    ad(ab abVar) {
        this.bMB = abVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.tasks.Task] */
    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ String then(Task<Bundle> task) {
        AppMethodBeat.i(4235);
        String j2 = this.bMB.j(task.getResult(IOException.class));
        AppMethodBeat.o(4235);
        return j2;
    }
}
