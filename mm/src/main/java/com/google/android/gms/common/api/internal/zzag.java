package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzag implements zzbc {
    private final zzbd zzhf;
    private boolean zzhg = false;

    public zzag(zzbd zzbd) {
        this.zzhf = zzbd;
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    public final void begin() {
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    public final void connect() {
        AppMethodBeat.i(11207);
        if (this.zzhg) {
            this.zzhg = false;
            this.zzhf.zza(new zzai(this, this));
        }
        AppMethodBeat.o(11207);
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    public final boolean disconnect() {
        AppMethodBeat.i(11206);
        if (this.zzhg) {
            AppMethodBeat.o(11206);
            return false;
        } else if (this.zzhf.zzfq.zzba()) {
            this.zzhg = true;
            for (zzch zzch : this.zzhf.zzfq.zziq) {
                zzch.zzcc();
            }
            AppMethodBeat.o(11206);
            return false;
        } else {
            this.zzhf.zzf(null);
            AppMethodBeat.o(11206);
            return true;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        AppMethodBeat.i(11204);
        T t2 = (T) execute(t);
        AppMethodBeat.o(11204);
        return t2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: T extends com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl<? extends com.google.android.gms.common.api.Result, A> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.zzbc
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        AppMethodBeat.i(11205);
        try {
            this.zzhf.zzfq.zzir.zzb(t);
            zzav zzav = this.zzhf.zzfq;
            Api.Client client = zzav.zzil.get(t.getClientKey());
            Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
            if (client.isConnected() || !this.zzhf.zzjb.containsKey(t.getClientKey())) {
                boolean z = client instanceof SimpleClientAdapter;
                Object obj = client;
                if (z) {
                    obj = ((SimpleClientAdapter) client).getClient();
                }
                t.run(obj == 1 ? 1 : 0);
                AppMethodBeat.o(11205);
                return t;
            }
            t.setFailedResult(new Status(17));
            AppMethodBeat.o(11205);
            return t;
        } catch (DeadObjectException e2) {
            this.zzhf.zza(new zzah(this, this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    public final void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    public final void onConnectionSuspended(int i2) {
        AppMethodBeat.i(11208);
        this.zzhf.zzf(null);
        this.zzhf.zzjf.zzb(i2, this.zzhg);
        AppMethodBeat.o(11208);
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    /* access modifiers changed from: package-private */
    public final void zzap() {
        AppMethodBeat.i(11209);
        if (this.zzhg) {
            this.zzhg = false;
            this.zzhf.zzfq.zzir.release();
            disconnect();
        }
        AppMethodBeat.o(11209);
    }
}
