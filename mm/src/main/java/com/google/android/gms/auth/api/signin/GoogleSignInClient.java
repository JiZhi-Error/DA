package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.internal.zzi;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions> {
    private static final zzd zzef = new zzd(null);
    @VisibleForTesting
    private static int zzeg = zze.zzei;

    static class zzd implements PendingResultUtil.ResultConverter<GoogleSignInResult, GoogleSignInAccount> {
        private zzd() {
        }

        /* synthetic */ zzd(zzd zzd) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Result] */
        @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
        public final /* synthetic */ GoogleSignInAccount convert(GoogleSignInResult googleSignInResult) {
            AppMethodBeat.i(88281);
            GoogleSignInAccount signInAccount = googleSignInResult.getSignInAccount();
            AppMethodBeat.o(88281);
            return signInAccount;
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public static final class zze {
        public static final int zzei = 1;
        public static final int zzej = 2;
        public static final int zzek = 3;
        public static final int zzel = 4;
        private static final /* synthetic */ int[] zzem = {zzei, zzej, zzek, zzel};

        public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FC5N68SJFD5I2UPRDECNM2TBKD0NM2S395TPMIPRED5N2UHRFDTJMOPAJD5JMSIBE8DM6IPBEEGI4IRBGDHIMQPBEEHGN8QBFDOTG____0() {
            AppMethodBeat.i(88282);
            int[] iArr = (int[]) zzem.clone();
            AppMethodBeat.o(88282);
            return iArr;
        }
    }

    static {
        AppMethodBeat.i(88290);
        AppMethodBeat.o(88290);
    }

    GoogleSignInClient(Activity activity, GoogleSignInOptions googleSignInOptions) {
        super(activity, (Api) Auth.GOOGLE_SIGN_IN_API, (Api.ApiOptions) googleSignInOptions, (StatusExceptionMapper) new ApiExceptionMapper());
        AppMethodBeat.i(88284);
        AppMethodBeat.o(88284);
    }

    GoogleSignInClient(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, Auth.GOOGLE_SIGN_IN_API, googleSignInOptions, new ApiExceptionMapper());
        AppMethodBeat.i(88283);
        AppMethodBeat.o(88283);
    }

    private final synchronized int zzl() {
        int i2;
        AppMethodBeat.i(88285);
        if (zzeg == zze.zzei) {
            Context applicationContext = getApplicationContext();
            GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
            int isGooglePlayServicesAvailable = instance.isGooglePlayServicesAvailable(applicationContext, 12451000);
            if (isGooglePlayServicesAvailable == 0) {
                zzeg = zze.zzel;
            } else if (instance.getErrorResolutionIntent(applicationContext, isGooglePlayServicesAvailable, null) != null || DynamiteModule.getLocalVersion(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) {
                zzeg = zze.zzej;
            } else {
                zzeg = zze.zzek;
            }
        }
        i2 = zzeg;
        AppMethodBeat.o(88285);
        return i2;
    }

    public Intent getSignInIntent() {
        AppMethodBeat.i(88286);
        Context applicationContext = getApplicationContext();
        switch (zzd.zzeh[zzl() - 1]) {
            case 1:
                Intent zze2 = zzi.zze(applicationContext, (GoogleSignInOptions) getApiOptions());
                AppMethodBeat.o(88286);
                return zze2;
            case 2:
                Intent zzd2 = zzi.zzd(applicationContext, (GoogleSignInOptions) getApiOptions());
                AppMethodBeat.o(88286);
                return zzd2;
            default:
                Intent zzf = zzi.zzf(applicationContext, (GoogleSignInOptions) getApiOptions());
                AppMethodBeat.o(88286);
                return zzf;
        }
    }

    public Task<Void> revokeAccess() {
        AppMethodBeat.i(88289);
        Task<Void> voidTask = PendingResultUtil.toVoidTask(zzi.zze(asGoogleApiClient(), getApplicationContext(), zzl() == zze.zzek));
        AppMethodBeat.o(88289);
        return voidTask;
    }

    public Task<Void> signOut() {
        AppMethodBeat.i(88288);
        Task<Void> voidTask = PendingResultUtil.toVoidTask(zzi.zzd(asGoogleApiClient(), getApplicationContext(), zzl() == zze.zzek));
        AppMethodBeat.o(88288);
        return voidTask;
    }

    public Task<GoogleSignInAccount> silentSignIn() {
        AppMethodBeat.i(88287);
        Task<GoogleSignInAccount> task = PendingResultUtil.toTask(zzi.zzd(asGoogleApiClient(), getApplicationContext(), (GoogleSignInOptions) getApiOptions(), zzl() == zze.zzek), zzef);
        AppMethodBeat.o(88287);
        return task;
    }
}
