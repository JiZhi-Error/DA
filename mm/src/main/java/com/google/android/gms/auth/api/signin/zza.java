package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zza implements Comparator {
    static final Comparator zzq = new zza();

    static {
        AppMethodBeat.i(10900);
        AppMethodBeat.o(10900);
    }

    private zza() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        AppMethodBeat.i(10899);
        int zza = GoogleSignInAccount.zza((Scope) obj, (Scope) obj2);
        AppMethodBeat.o(10899);
        return zza;
    }
}
