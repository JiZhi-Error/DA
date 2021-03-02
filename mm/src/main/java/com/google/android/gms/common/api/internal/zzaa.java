package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzaa {
    private final Map<BasePendingResult<?>, Boolean> zzgw = Collections.synchronizedMap(new WeakHashMap());
    private final Map<TaskCompletionSource<?>, Boolean> zzgx = Collections.synchronizedMap(new WeakHashMap());

    public zzaa() {
        AppMethodBeat.i(11168);
        AppMethodBeat.o(11168);
    }

    private final void zza(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        AppMethodBeat.i(11174);
        synchronized (this.zzgw) {
            try {
                hashMap = new HashMap(this.zzgw);
            } finally {
                AppMethodBeat.o(11174);
            }
        }
        synchronized (this.zzgx) {
            try {
                hashMap2 = new HashMap(this.zzgx);
            } finally {
                AppMethodBeat.o(11174);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).zzb(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new ApiException(status));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(BasePendingResult<? extends Result> basePendingResult, boolean z) {
        AppMethodBeat.i(11169);
        this.zzgw.put(basePendingResult, Boolean.valueOf(z));
        basePendingResult.addStatusListener(new zzab(this, basePendingResult));
        AppMethodBeat.o(11169);
    }

    /* access modifiers changed from: package-private */
    public final <TResult> void zza(TaskCompletionSource<TResult> taskCompletionSource, boolean z) {
        AppMethodBeat.i(11170);
        this.zzgx.put(taskCompletionSource, Boolean.valueOf(z));
        taskCompletionSource.getTask().addOnCompleteListener(new zzac(this, taskCompletionSource));
        AppMethodBeat.o(11170);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaj() {
        AppMethodBeat.i(11171);
        if (!this.zzgw.isEmpty() || !this.zzgx.isEmpty()) {
            AppMethodBeat.o(11171);
            return true;
        }
        AppMethodBeat.o(11171);
        return false;
    }

    public final void zzak() {
        AppMethodBeat.i(11172);
        zza(false, GoogleApiManager.zzjj);
        AppMethodBeat.o(11172);
    }

    public final void zzal() {
        AppMethodBeat.i(11173);
        zza(true, zzck.zzmm);
        AppMethodBeat.o(11173);
    }
}
