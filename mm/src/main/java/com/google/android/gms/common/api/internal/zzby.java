package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignIn;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.BaseSignInCallbacks;
import com.google.android.gms.signin.internal.SignInResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public final class zzby extends BaseSignInCallbacks implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> zzlv = SignIn.CLIENT_BUILDER;
    private final Context mContext;
    private final Handler mHandler;
    private Set<Scope> mScopes;
    private final Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> zzby;
    private ClientSettings zzgf;
    private SignInClient zzhn;
    private zzcb zzlw;

    public zzby(Context context, Handler handler, ClientSettings clientSettings) {
        this(context, handler, clientSettings, zzlv);
    }

    public zzby(Context context, Handler handler, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder) {
        AppMethodBeat.i(11356);
        this.mContext = context;
        this.mHandler = handler;
        this.zzgf = (ClientSettings) Preconditions.checkNotNull(clientSettings, "ClientSettings must not be null");
        this.mScopes = clientSettings.getRequiredScopes();
        this.zzby = abstractClientBuilder;
        AppMethodBeat.o(11356);
    }

    static /* synthetic */ void zza(zzby zzby2, SignInResponse signInResponse) {
        AppMethodBeat.i(11364);
        zzby2.zzb(signInResponse);
        AppMethodBeat.o(11364);
    }

    private final void zzb(SignInResponse signInResponse) {
        AppMethodBeat.i(11363);
        ConnectionResult connectionResult = signInResponse.getConnectionResult();
        if (connectionResult.isSuccess()) {
            ResolveAccountResponse resolveAccountResponse = signInResponse.getResolveAccountResponse();
            ConnectionResult connectionResult2 = resolveAccountResponse.getConnectionResult();
            if (!connectionResult2.isSuccess()) {
                String valueOf = String.valueOf(connectionResult2);
                Log.wtf("SignInCoordinator", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                this.zzlw.zzg(connectionResult2);
                this.zzhn.disconnect();
                AppMethodBeat.o(11363);
                return;
            }
            this.zzlw.zza(resolveAccountResponse.getAccountAccessor(), this.mScopes);
        } else {
            this.zzlw.zzg(connectionResult);
        }
        this.zzhn.disconnect();
        AppMethodBeat.o(11363);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        AppMethodBeat.i(11359);
        this.zzhn.signIn(this);
        AppMethodBeat.o(11359);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        AppMethodBeat.i(11361);
        this.zzlw.zzg(connectionResult);
        AppMethodBeat.o(11361);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i2) {
        AppMethodBeat.i(11360);
        this.zzhn.disconnect();
        AppMethodBeat.o(11360);
    }

    @Override // com.google.android.gms.signin.internal.BaseSignInCallbacks, com.google.android.gms.signin.internal.ISignInCallbacks
    public final void onSignInComplete(SignInResponse signInResponse) {
        AppMethodBeat.i(11362);
        this.mHandler.post(new zzca(this, signInResponse));
        AppMethodBeat.o(11362);
    }

    public final void zza(zzcb zzcb) {
        AppMethodBeat.i(11357);
        if (this.zzhn != null) {
            this.zzhn.disconnect();
        }
        this.zzgf.setClientSessionId(Integer.valueOf(System.identityHashCode(this)));
        this.zzhn = (SignInClient) this.zzby.buildClient(this.mContext, this.mHandler.getLooper(), this.zzgf, this.zzgf.getSignInOptions(), this, this);
        this.zzlw = zzcb;
        if (this.mScopes == null || this.mScopes.isEmpty()) {
            this.mHandler.post(new zzbz(this));
            AppMethodBeat.o(11357);
            return;
        }
        this.zzhn.connect();
        AppMethodBeat.o(11357);
    }

    public final SignInClient zzbt() {
        return this.zzhn;
    }

    public final void zzbz() {
        AppMethodBeat.i(11358);
        if (this.zzhn != null) {
            this.zzhn.disconnect();
        }
        AppMethodBeat.o(11358);
    }
}
