package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

/* access modifiers changed from: package-private */
public final class zzb implements Comparator<Scope> {
    zzb() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Scope scope, Scope scope2) {
        AppMethodBeat.i(10901);
        int compareTo = scope.getScopeUri().compareTo(scope2.getScopeUri());
        AppMethodBeat.o(10901);
        return compareTo;
    }
}
