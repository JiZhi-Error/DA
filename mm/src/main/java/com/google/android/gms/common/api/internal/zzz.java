package com.google.android.gms.common.api.internal;

import android.support.v4.e.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzz implements OnCompleteListener<Map<zzh<?>, String>> {
    private final /* synthetic */ zzw zzgu;
    private SignInConnectionListener zzgv;

    zzz(zzw zzw, SignInConnectionListener signInConnectionListener) {
        this.zzgu = zzw;
        this.zzgv = signInConnectionListener;
    }

    /* access modifiers changed from: package-private */
    public final void cancel() {
        AppMethodBeat.i(11499);
        this.zzgv.onComplete();
        AppMethodBeat.o(11499);
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<Map<zzh<?>, String>> task) {
        AppMethodBeat.i(11500);
        this.zzgu.zzga.lock();
        try {
            if (!(this.zzgu.zzgp)) {
                this.zzgv.onComplete();
                return;
            }
            if (task.isSuccessful()) {
                this.zzgu.zzgr = new a(this.zzgu.zzgh.size());
                for (zzv zzv : this.zzgu.zzgh.values()) {
                    this.zzgu.zzgr.put(zzv.zzm(), ConnectionResult.RESULT_SUCCESS);
                }
            } else if (task.getException() instanceof AvailabilityException) {
                AvailabilityException availabilityException = (AvailabilityException) task.getException();
                if (this.zzgu.zzgn) {
                    this.zzgu.zzgr = new a(this.zzgu.zzgh.size());
                    for (zzv zzv2 : this.zzgu.zzgh.values()) {
                        zzh zzm = zzv2.zzm();
                        ConnectionResult connectionResult = availabilityException.getConnectionResult(zzv2);
                        if (zzw.zza(this.zzgu, zzv2, connectionResult)) {
                            this.zzgu.zzgr.put(zzm, new ConnectionResult(16));
                        } else {
                            this.zzgu.zzgr.put(zzm, connectionResult);
                        }
                    }
                } else {
                    this.zzgu.zzgr = availabilityException.zzl();
                }
            } else {
                task.getException();
                this.zzgu.zzgr = Collections.emptyMap();
            }
            if (this.zzgu.isConnected()) {
                this.zzgu.zzgq.putAll(this.zzgu.zzgr);
                if (zzw.zzf(this.zzgu) == null) {
                    zzw.zzi(this.zzgu);
                    zzw.zzj(this.zzgu);
                    this.zzgu.zzgl.signalAll();
                }
            }
            this.zzgv.onComplete();
            this.zzgu.zzga.unlock();
            AppMethodBeat.o(11500);
        } finally {
            this.zzgu.zzga.unlock();
            AppMethodBeat.o(11500);
        }
    }
}
