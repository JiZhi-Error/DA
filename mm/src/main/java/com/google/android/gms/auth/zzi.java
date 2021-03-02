package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzi implements zzm<Void> {
    private final /* synthetic */ Bundle val$extras;
    private final /* synthetic */ String zzt;

    zzi(String str, Bundle bundle) {
        this.zzt = str;
        this.val$extras = bundle;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.auth.zzm
    public final /* synthetic */ Void zze(IBinder iBinder) {
        AppMethodBeat.i(10734);
        Bundle bundle = (Bundle) zzg.zze(com.google.android.gms.internal.auth.zzi.zzd(iBinder).zzd(this.zzt, this.val$extras));
        String string = bundle.getString("Error");
        if (!bundle.getBoolean("booleanResult")) {
            GoogleAuthException googleAuthException = new GoogleAuthException(string);
            AppMethodBeat.o(10734);
            throw googleAuthException;
        }
        AppMethodBeat.o(10734);
        return null;
    }
}
