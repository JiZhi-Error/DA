package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzam extends zzbb {
    @Override // com.google.android.gms.internal.auth.zzba
    public void zzd(Status status, Credential credential) {
        AppMethodBeat.i(88363);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(88363);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.internal.auth.zzba
    public final void zzd(Status status, String str) {
        AppMethodBeat.i(88365);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(88365);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.internal.auth.zzba
    public void zze(Status status) {
        AppMethodBeat.i(88364);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(88364);
        throw unsupportedOperationException;
    }
}
