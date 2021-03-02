package com.google.android.gms.auth.api.signin.internal;

import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzg implements GoogleSignInApi {
    private static GoogleSignInOptions zzd(GoogleApiClient googleApiClient) {
        AppMethodBeat.i(88326);
        GoogleSignInOptions zzn = ((zzh) googleApiClient.getClient(Auth.zzak)).zzn();
        AppMethodBeat.o(88326);
        return zzn;
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public final Intent getSignInIntent(GoogleApiClient googleApiClient) {
        AppMethodBeat.i(88321);
        Intent zzd = zzi.zzd(googleApiClient.getContext(), zzd(googleApiClient));
        AppMethodBeat.o(88321);
        return zzd;
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public final GoogleSignInResult getSignInResultFromIntent(Intent intent) {
        AppMethodBeat.i(88325);
        GoogleSignInResult signInResultFromIntent = zzi.getSignInResultFromIntent(intent);
        AppMethodBeat.o(88325);
        return signInResultFromIntent;
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public final PendingResult<Status> revokeAccess(GoogleApiClient googleApiClient) {
        AppMethodBeat.i(88324);
        PendingResult<Status> zze = zzi.zze(googleApiClient, googleApiClient.getContext(), false);
        AppMethodBeat.o(88324);
        return zze;
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public final PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        AppMethodBeat.i(88323);
        PendingResult<Status> zzd = zzi.zzd(googleApiClient, googleApiClient.getContext(), false);
        AppMethodBeat.o(88323);
        return zzd;
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public final OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient googleApiClient) {
        AppMethodBeat.i(88322);
        OptionalPendingResult<GoogleSignInResult> zzd = zzi.zzd(googleApiClient, googleApiClient.getContext(), zzd(googleApiClient), false);
        AppMethodBeat.o(88322);
        return zzd;
    }
}
