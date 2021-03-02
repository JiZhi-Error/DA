package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzck {
    public static final Status zzmm = new Status(8, "The connection to Google Play services was lost");
    private static final BasePendingResult<?>[] zzmn = new BasePendingResult[0];
    private final Map<Api.AnyClientKey<?>, Api.Client> zzil;
    @VisibleForTesting
    final Set<BasePendingResult<?>> zzmo = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final zzcn zzmp = new zzcl(this);

    static {
        AppMethodBeat.i(11387);
        AppMethodBeat.o(11387);
    }

    public zzck(Map<Api.AnyClientKey<?>, Api.Client> map) {
        AppMethodBeat.i(11383);
        this.zzil = map;
        AppMethodBeat.o(11383);
    }

    public final void release() {
        zzc zzc = null;
        AppMethodBeat.i(11385);
        BasePendingResult[] basePendingResultArr = (BasePendingResult[]) this.zzmo.toArray(zzmn);
        for (BasePendingResult basePendingResult : basePendingResultArr) {
            basePendingResult.zza((zzcn) null);
            if (basePendingResult.zzo() != null) {
                basePendingResult.setResultCallback(null);
                IBinder serviceBrokerBinder = this.zzil.get(((BaseImplementation.ApiMethodImpl) basePendingResult).getClientKey()).getServiceBrokerBinder();
                if (basePendingResult.isReady()) {
                    basePendingResult.zza(new zzcm(basePendingResult, null, serviceBrokerBinder, null));
                } else if (serviceBrokerBinder == null || !serviceBrokerBinder.isBinderAlive()) {
                    basePendingResult.zza((zzcn) null);
                    basePendingResult.cancel();
                    zzc.remove(basePendingResult.zzo().intValue());
                } else {
                    zzcm zzcm = new zzcm(basePendingResult, null, serviceBrokerBinder, null);
                    basePendingResult.zza(zzcm);
                    try {
                        serviceBrokerBinder.linkToDeath(zzcm, 0);
                    } catch (RemoteException e2) {
                        basePendingResult.cancel();
                        zzc.remove(basePendingResult.zzo().intValue());
                    }
                }
                this.zzmo.remove(basePendingResult);
            } else if (basePendingResult.zzw()) {
                this.zzmo.remove(basePendingResult);
            }
        }
        AppMethodBeat.o(11385);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(BasePendingResult<? extends Result> basePendingResult) {
        AppMethodBeat.i(11384);
        this.zzmo.add(basePendingResult);
        basePendingResult.zza(this.zzmp);
        AppMethodBeat.o(11384);
    }

    public final void zzce() {
        AppMethodBeat.i(11386);
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.zzmo.toArray(zzmn)) {
            basePendingResult.zzb(zzmm);
        }
        AppMethodBeat.o(11386);
    }
}
