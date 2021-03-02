package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzao implements CredentialsApi {
    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public final PendingResult<Status> delete(GoogleApiClient googleApiClient, Credential credential) {
        AppMethodBeat.i(88370);
        Preconditions.checkNotNull(googleApiClient, "client must not be null");
        Preconditions.checkNotNull(credential, "credential must not be null");
        BaseImplementation.ApiMethodImpl execute = googleApiClient.execute(new zzas(this, googleApiClient, credential));
        AppMethodBeat.o(88370);
        return execute;
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public final PendingResult<Status> disableAutoSignIn(GoogleApiClient googleApiClient) {
        AppMethodBeat.i(88371);
        Preconditions.checkNotNull(googleApiClient, "client must not be null");
        BaseImplementation.ApiMethodImpl execute = googleApiClient.execute(new zzat(this, googleApiClient));
        AppMethodBeat.o(88371);
        return execute;
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public final PendingIntent getHintPickerIntent(GoogleApiClient googleApiClient, HintRequest hintRequest) {
        AppMethodBeat.i(88368);
        Preconditions.checkNotNull(googleApiClient, "client must not be null");
        Preconditions.checkNotNull(hintRequest, "request must not be null");
        PendingIntent zzd = zzaw.zzd(googleApiClient.getContext(), ((zzax) googleApiClient.getClient(Auth.zzaj)).zzk(), hintRequest);
        AppMethodBeat.o(88368);
        return zzd;
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public final PendingResult<CredentialRequestResult> request(GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
        AppMethodBeat.i(88367);
        Preconditions.checkNotNull(googleApiClient, "client must not be null");
        Preconditions.checkNotNull(credentialRequest, "request must not be null");
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzap(this, googleApiClient, credentialRequest));
        AppMethodBeat.o(88367);
        return enqueue;
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public final PendingResult<Status> save(GoogleApiClient googleApiClient, Credential credential) {
        AppMethodBeat.i(88369);
        Preconditions.checkNotNull(googleApiClient, "client must not be null");
        Preconditions.checkNotNull(credential, "credential must not be null");
        BaseImplementation.ApiMethodImpl execute = googleApiClient.execute(new zzar(this, googleApiClient, credential));
        AppMethodBeat.o(88369);
        return execute;
    }
}
