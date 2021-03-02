package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* access modifiers changed from: package-private */
public abstract class c<T> {
    final int bLs;
    final TaskCompletionSource<T> bLt = new TaskCompletionSource<>();
    final Bundle bLu;
    final int what;

    c(int i2, int i3, Bundle bundle) {
        this.bLs = i2;
        this.what = i3;
        this.bLu = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void a(d dVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(dVar);
            new StringBuilder(String.valueOf(valueOf).length() + 14 + String.valueOf(valueOf2).length()).append("Failing ").append(valueOf).append(" with ").append(valueOf2);
        }
        this.bLt.setException(dVar);
    }

    /* access modifiers changed from: package-private */
    public final void p(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            new StringBuilder(String.valueOf(valueOf).length() + 16 + String.valueOf(valueOf2).length()).append("Finishing ").append(valueOf).append(" with ").append(valueOf2);
        }
        this.bLt.setResult(t);
    }

    public String toString() {
        int i2 = this.what;
        int i3 = this.bLs;
        return new StringBuilder(55).append("Request { what=").append(i2).append(" id=").append(i3).append(" oneWay=").append(zzw()).append("}").toString();
    }

    /* access modifiers changed from: package-private */
    public abstract void zzb(Bundle bundle);

    /* access modifiers changed from: package-private */
    public abstract boolean zzw();
}
