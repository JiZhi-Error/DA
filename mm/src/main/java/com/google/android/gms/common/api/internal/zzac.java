package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzac implements OnCompleteListener<TResult> {
    private final /* synthetic */ zzaa zzgz;
    private final /* synthetic */ TaskCompletionSource zzha;

    zzac(zzaa zzaa, TaskCompletionSource taskCompletionSource) {
        this.zzgz = zzaa;
        this.zzha = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<TResult> task) {
        AppMethodBeat.i(11176);
        this.zzgz.zzgx.remove(this.zzha);
        AppMethodBeat.o(11176);
    }
}
