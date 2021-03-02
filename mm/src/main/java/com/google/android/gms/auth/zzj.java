package com.google.android.gms.auth;

import android.os.IBinder;
import com.google.android.gms.internal.auth.zzi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

/* access modifiers changed from: package-private */
public final class zzj implements zzm<List<AccountChangeEvent>> {
    private final /* synthetic */ String zzu;
    private final /* synthetic */ int zzv;

    zzj(String str, int i2) {
        this.zzu = str;
        this.zzv = i2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.auth.zzm
    public final /* synthetic */ List<AccountChangeEvent> zze(IBinder iBinder) {
        AppMethodBeat.i(10735);
        List<AccountChangeEvent> events = ((AccountChangeEventsResponse) zzg.zze(zzi.zzd(iBinder).zzd(new AccountChangeEventsRequest().setAccountName(this.zzu).setEventIndex(this.zzv)))).getEvents();
        AppMethodBeat.o(10735);
        return events;
    }
}
