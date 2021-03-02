package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class zzap extends zzat {
    private final /* synthetic */ zzaj zzhv;
    private final ArrayList<Api.Client> zzib;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzap(zzaj zzaj, ArrayList<Api.Client> arrayList) {
        super(zzaj, null);
        this.zzhv = zzaj;
        this.zzib = arrayList;
    }

    @Override // com.google.android.gms.common.api.internal.zzat
    public final void zzaq() {
        AppMethodBeat.i(11247);
        zzaj.zzd(this.zzhv).zzfq.zzim = zzaj.zzg(this.zzhv);
        ArrayList<Api.Client> arrayList = this.zzib;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Api.Client client = arrayList.get(i2);
            i2++;
            client.getRemoteService(zzaj.zzh(this.zzhv), zzaj.zzd(this.zzhv).zzfq.zzim);
        }
        AppMethodBeat.o(11247);
    }
}
