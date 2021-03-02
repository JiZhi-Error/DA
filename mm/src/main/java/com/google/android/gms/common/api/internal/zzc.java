package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;

/* access modifiers changed from: package-private */
public abstract class zzc<T> extends zzb {
    protected final TaskCompletionSource<T> zzdu;

    public zzc(int i2, TaskCompletionSource<T> taskCompletionSource) {
        super(i2);
        this.zzdu = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.zzb
    public void zza(Status status) {
        this.zzdu.trySetException(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zzb
    public final void zza(GoogleApiManager.zza<?> zza) {
        try {
            zzb(zza);
        } catch (DeadObjectException e2) {
            zza(zzb.zza(e2));
            throw e2;
        } catch (RemoteException e3) {
            zza(zzb.zza(e3));
        } catch (RuntimeException e4) {
            zza(e4);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzb
    public void zza(zzaa zzaa, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zzb
    public void zza(RuntimeException runtimeException) {
        this.zzdu.trySetException(runtimeException);
    }

    /* access modifiers changed from: protected */
    public abstract void zzb(GoogleApiManager.zza<?> zza);
}
