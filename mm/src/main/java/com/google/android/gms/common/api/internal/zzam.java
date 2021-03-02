package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Map;

final class zzam extends zzat {
    final /* synthetic */ zzaj zzhv;
    private final Map<Api.Client, zzal> zzhx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzam(zzaj zzaj, Map<Api.Client, zzal> map) {
        super(zzaj, null);
        this.zzhv = zzaj;
        this.zzhx = map;
    }

    @Override // com.google.android.gms.common.api.internal.zzat
    public final void zzaq() {
        int i2 = 0;
        AppMethodBeat.i(11244);
        GoogleApiAvailabilityCache googleApiAvailabilityCache = new GoogleApiAvailabilityCache(zzaj.zzb(this.zzhv));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client client : this.zzhx.keySet()) {
            if (!client.requiresGooglePlayServices() || (this.zzhx.get(client).zzfo)) {
                arrayList2.add(client);
            } else {
                arrayList.add(client);
            }
        }
        int i3 = -1;
        if (arrayList.isEmpty()) {
            ArrayList arrayList3 = arrayList2;
            int size = arrayList3.size();
            while (i2 < size) {
                Object obj = arrayList3.get(i2);
                i2++;
                i3 = googleApiAvailabilityCache.getClientAvailability(zzaj.zza(this.zzhv), (Api.Client) obj);
                if (i3 == 0) {
                    break;
                }
            }
        } else {
            ArrayList arrayList4 = arrayList;
            int size2 = arrayList4.size();
            int i4 = 0;
            while (i4 < size2) {
                Object obj2 = arrayList4.get(i4);
                i4++;
                i3 = googleApiAvailabilityCache.getClientAvailability(zzaj.zza(this.zzhv), (Api.Client) obj2);
                if (i3 != 0) {
                    break;
                }
            }
        }
        if (i3 != 0) {
            zzaj.zzd(this.zzhv).zza(new zzan(this, this.zzhv, new ConnectionResult(i3, null)));
            AppMethodBeat.o(11244);
            return;
        }
        if (zzaj.zze(this.zzhv)) {
            zzaj.zzf(this.zzhv).connect();
        }
        for (Api.Client client2 : this.zzhx.keySet()) {
            zzal zzal = this.zzhx.get(client2);
            if (!client2.requiresGooglePlayServices() || googleApiAvailabilityCache.getClientAvailability(zzaj.zza(this.zzhv), client2) == 0) {
                client2.connect(zzal);
            } else {
                zzaj.zzd(this.zzhv).zza(new zzao(this, this.zzhv, zzal));
            }
        }
        AppMethodBeat.o(11244);
    }
}
