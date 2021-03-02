package com.google.android.gms.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* access modifiers changed from: package-private */
public abstract class zzz<T> {
    final int what;
    final int zzck;
    final TaskCompletionSource<T> zzcl = new TaskCompletionSource<>();
    final Bundle zzcm;

    zzz(int i2, int i3, Bundle bundle) {
        this.zzck = i2;
        this.what = i3;
        this.zzcm = bundle;
    }

    public String toString() {
        int i2 = this.what;
        int i3 = this.zzck;
        zzu();
        return new StringBuilder(55).append("Request { what=").append(i2).append(" id=").append(i3).append(" oneWay=false}").toString();
    }

    /* access modifiers changed from: package-private */
    public final void zzd(zzaa zzaa) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(zzaa);
            new StringBuilder(String.valueOf(valueOf).length() + 14 + String.valueOf(valueOf2).length()).append("Failing ").append(valueOf).append(" with ").append(valueOf2);
        }
        this.zzcl.setException(zzaa);
    }

    /* access modifiers changed from: package-private */
    public abstract void zzh(Bundle bundle);

    /* access modifiers changed from: package-private */
    public abstract boolean zzu();
}
