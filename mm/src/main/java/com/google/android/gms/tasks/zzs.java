package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzs implements OnTokenCanceledListener {
    private final /* synthetic */ TaskCompletionSource zzagc;

    zzs(TaskCompletionSource taskCompletionSource) {
        this.zzagc = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnTokenCanceledListener
    public final void onCanceled() {
        AppMethodBeat.i(13410);
        this.zzagc.zzafh.zzdp();
        AppMethodBeat.o(13410);
    }
}
