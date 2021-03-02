package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzf<ResultT> extends zzb {
    private final TaskCompletionSource<ResultT> zzdu;
    private final TaskApiCall<Api.AnyClient, ResultT> zzdy;
    private final StatusExceptionMapper zzdz;

    public zzf(int i2, TaskApiCall<Api.AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        super(i2);
        this.zzdu = taskCompletionSource;
        this.zzdy = taskApiCall;
        this.zzdz = statusExceptionMapper;
    }

    public final Feature[] getRequiredFeatures() {
        AppMethodBeat.i(11404);
        Feature[] zzca = this.zzdy.zzca();
        AppMethodBeat.o(11404);
        return zzca;
    }

    public final boolean shouldAutoResolveMissingFeatures() {
        AppMethodBeat.i(11405);
        boolean shouldAutoResolveMissingFeatures = this.zzdy.shouldAutoResolveMissingFeatures();
        AppMethodBeat.o(11405);
        return shouldAutoResolveMissingFeatures;
    }

    @Override // com.google.android.gms.common.api.internal.zzb
    public final void zza(Status status) {
        AppMethodBeat.i(11401);
        this.zzdu.trySetException(this.zzdz.getException(status));
        AppMethodBeat.o(11401);
    }

    @Override // com.google.android.gms.common.api.internal.zzb
    public final void zza(GoogleApiManager.zza<?> zza) {
        AppMethodBeat.i(11400);
        try {
            this.zzdy.doExecute(zza.zzae(), this.zzdu);
            AppMethodBeat.o(11400);
        } catch (DeadObjectException e2) {
            AppMethodBeat.o(11400);
            throw e2;
        } catch (RemoteException e3) {
            zza(zzb.zza(e3));
            AppMethodBeat.o(11400);
        } catch (RuntimeException e4) {
            zza(e4);
            AppMethodBeat.o(11400);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzb
    public final void zza(zzaa zzaa, boolean z) {
        AppMethodBeat.i(11403);
        zzaa.zza(this.zzdu, z);
        AppMethodBeat.o(11403);
    }

    @Override // com.google.android.gms.common.api.internal.zzb
    public final void zza(RuntimeException runtimeException) {
        AppMethodBeat.i(11402);
        this.zzdu.trySetException(runtimeException);
        AppMethodBeat.o(11402);
    }
}
