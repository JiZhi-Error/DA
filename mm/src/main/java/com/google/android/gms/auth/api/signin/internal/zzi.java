package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.logging.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzi {
    private static Logger zzer = new Logger("GoogleSignInCommon", new String[0]);

    static {
        AppMethodBeat.i(88338);
        AppMethodBeat.o(88338);
    }

    public static GoogleSignInResult getSignInResultFromIntent(Intent intent) {
        AppMethodBeat.i(88337);
        if (intent == null || (!intent.hasExtra("googleSignInStatus") && !intent.hasExtra("googleSignInAccount"))) {
            AppMethodBeat.o(88337);
            return null;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
        Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
        if (googleSignInAccount != null) {
            status = Status.RESULT_SUCCESS;
        }
        GoogleSignInResult googleSignInResult = new GoogleSignInResult(googleSignInAccount, status);
        AppMethodBeat.o(88337);
        return googleSignInResult;
    }

    public static Intent zzd(Context context, GoogleSignInOptions googleSignInOptions) {
        AppMethodBeat.i(88330);
        zzer.d("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        AppMethodBeat.o(88330);
        return intent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.common.api.OptionalPendingResult<com.google.android.gms.auth.api.signin.GoogleSignInResult> zzd(com.google.android.gms.common.api.GoogleApiClient r6, android.content.Context r7, com.google.android.gms.auth.api.signin.GoogleSignInOptions r8, boolean r9) {
        /*
        // Method dump skipped, instructions count: 213
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.zzi.zzd(com.google.android.gms.common.api.GoogleApiClient, android.content.Context, com.google.android.gms.auth.api.signin.GoogleSignInOptions, boolean):com.google.android.gms.common.api.OptionalPendingResult");
    }

    public static PendingResult<Status> zzd(GoogleApiClient googleApiClient, Context context, boolean z) {
        AppMethodBeat.i(88334);
        zzer.d("Signing out", new Object[0]);
        zzd(context);
        if (z) {
            PendingResult<Status> immediatePendingResult = PendingResults.immediatePendingResult(Status.RESULT_SUCCESS, googleApiClient);
            AppMethodBeat.o(88334);
            return immediatePendingResult;
        }
        BaseImplementation.ApiMethodImpl execute = googleApiClient.execute(new zzl(googleApiClient));
        AppMethodBeat.o(88334);
        return execute;
    }

    private static void zzd(Context context) {
        AppMethodBeat.i(88336);
        zzq.zze(context).clear();
        for (GoogleApiClient googleApiClient : GoogleApiClient.getAllClients()) {
            googleApiClient.maybeSignOut();
        }
        GoogleApiManager.reportSignOut();
        AppMethodBeat.o(88336);
    }

    public static Intent zze(Context context, GoogleSignInOptions googleSignInOptions) {
        AppMethodBeat.i(88331);
        zzer.d("getFallbackSignInIntent()", new Object[0]);
        Intent zzd = zzd(context, googleSignInOptions);
        zzd.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
        AppMethodBeat.o(88331);
        return zzd;
    }

    public static PendingResult<Status> zze(GoogleApiClient googleApiClient, Context context, boolean z) {
        AppMethodBeat.i(88335);
        zzer.d("Revoking access", new Object[0]);
        String savedRefreshToken = Storage.getInstance(context).getSavedRefreshToken();
        zzd(context);
        if (z) {
            PendingResult<Status> zzg = zze.zzg(savedRefreshToken);
            AppMethodBeat.o(88335);
            return zzg;
        }
        BaseImplementation.ApiMethodImpl execute = googleApiClient.execute(new zzn(googleApiClient));
        AppMethodBeat.o(88335);
        return execute;
    }

    public static Intent zzf(Context context, GoogleSignInOptions googleSignInOptions) {
        AppMethodBeat.i(88332);
        zzer.d("getNoImplementationSignInIntent()", new Object[0]);
        Intent zzd = zzd(context, googleSignInOptions);
        zzd.setAction("com.google.android.gms.auth.NO_IMPL");
        AppMethodBeat.o(88332);
        return zzd;
    }
}
