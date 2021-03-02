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
public final class zzy implements OnCompleteListener<Map<zzh<?>, String>> {
    private final /* synthetic */ zzw zzgu;

    private zzy(zzw zzw) {
        this.zzgu = zzw;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<Map<zzh<?>, String>> task) {
        AppMethodBeat.i(11498);
        this.zzgu.zzga.lock();
        try {
            if (this.zzgu.zzgp) {
                if (task.isSuccessful()) {
                    this.zzgu.zzgq = new a(this.zzgu.zzgg.size());
                    for (zzv zzv : this.zzgu.zzgg.values()) {
                        this.zzgu.zzgq.put(zzv.zzm(), ConnectionResult.RESULT_SUCCESS);
                    }
                } else if (task.getException() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) task.getException();
                    if (this.zzgu.zzgn) {
                        this.zzgu.zzgq = new a(this.zzgu.zzgg.size());
                        for (zzv zzv2 : this.zzgu.zzgg.values()) {
                            zzh zzm = zzv2.zzm();
                            ConnectionResult connectionResult = availabilityException.getConnectionResult(zzv2);
                            if (zzw.zza(this.zzgu, zzv2, connectionResult)) {
                                this.zzgu.zzgq.put(zzm, new ConnectionResult(16));
                            } else {
                                this.zzgu.zzgq.put(zzm, connectionResult);
                            }
                        }
                    } else {
                        this.zzgu.zzgq = availabilityException.zzl();
                    }
                    this.zzgu.zzgt = zzw.zzf(this.zzgu);
                } else {
                    task.getException();
                    this.zzgu.zzgq = Collections.emptyMap();
                    this.zzgu.zzgt = new ConnectionResult(8);
                }
                if (this.zzgu.zzgr != null) {
                    this.zzgu.zzgq.putAll(this.zzgu.zzgr);
                    this.zzgu.zzgt = zzw.zzf(this.zzgu);
                }
                if (this.zzgu.zzgt == null) {
                    zzw.zzi(this.zzgu);
                    zzw.zzj(this.zzgu);
                } else {
                    this.zzgu.zzgp = false;
                    this.zzgu.zzgj.zzc(this.zzgu.zzgt);
                }
                this.zzgu.zzgl.signalAll();
                this.zzgu.zzga.unlock();
                AppMethodBeat.o(11498);
            }
        } finally {
            this.zzgu.zzga.unlock();
            AppMethodBeat.o(11498);
        }
    }
}
