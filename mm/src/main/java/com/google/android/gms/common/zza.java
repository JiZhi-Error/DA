package com.google.android.gms.common;

import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final class zza implements Continuation<Map<zzh<?>, String>, Void> {
    zza(GoogleApiAvailability googleApiAvailability) {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.tasks.Task] */
    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Void then(Task<Map<zzh<?>, String>> task) {
        AppMethodBeat.i(12126);
        task.getResult();
        AppMethodBeat.o(12126);
        return null;
    }
}
