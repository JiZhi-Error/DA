package com.google.android.gms.auth.api.credentials;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.internal.auth.zzaw;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CredentialsClient extends GoogleApi<Auth.AuthCredentialsOptions> {
    CredentialsClient(Activity activity, Auth.AuthCredentialsOptions authCredentialsOptions) {
        super(activity, (Api) Auth.CREDENTIALS_API, (Api.ApiOptions) authCredentialsOptions, (StatusExceptionMapper) new ApiExceptionMapper());
        AppMethodBeat.i(88229);
        AppMethodBeat.o(88229);
    }

    CredentialsClient(Context context, Auth.AuthCredentialsOptions authCredentialsOptions) {
        super(context, Auth.CREDENTIALS_API, authCredentialsOptions, new ApiExceptionMapper());
        AppMethodBeat.i(88228);
        AppMethodBeat.o(88228);
    }

    public Task<Void> delete(Credential credential) {
        AppMethodBeat.i(88233);
        Task<Void> voidTask = PendingResultUtil.toVoidTask(Auth.CredentialsApi.delete(asGoogleApiClient(), credential));
        AppMethodBeat.o(88233);
        return voidTask;
    }

    public Task<Void> disableAutoSignIn() {
        AppMethodBeat.i(88234);
        Task<Void> voidTask = PendingResultUtil.toVoidTask(Auth.CredentialsApi.disableAutoSignIn(asGoogleApiClient()));
        AppMethodBeat.o(88234);
        return voidTask;
    }

    public PendingIntent getHintPickerIntent(HintRequest hintRequest) {
        AppMethodBeat.i(88231);
        PendingIntent zzd = zzaw.zzd(getApplicationContext(), (Auth.AuthCredentialsOptions) getApiOptions(), hintRequest);
        AppMethodBeat.o(88231);
        return zzd;
    }

    public Task<CredentialRequestResponse> request(CredentialRequest credentialRequest) {
        AppMethodBeat.i(88230);
        Task<CredentialRequestResponse> responseTask = PendingResultUtil.toResponseTask(Auth.CredentialsApi.request(asGoogleApiClient(), credentialRequest), new CredentialRequestResponse());
        AppMethodBeat.o(88230);
        return responseTask;
    }

    public Task<Void> save(Credential credential) {
        AppMethodBeat.i(88232);
        Task<Void> voidTask = PendingResultUtil.toVoidTask(Auth.CredentialsApi.save(asGoogleApiClient(), credential));
        AppMethodBeat.o(88232);
        return voidTask;
    }
}
