package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzh extends GmsClient<zzv> {
    private final GoogleSignInOptions zzev;

    public zzh(Context context, Looper looper, ClientSettings clientSettings, GoogleSignInOptions googleSignInOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 91, clientSettings, connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.i(88327);
        googleSignInOptions = googleSignInOptions == null ? new GoogleSignInOptions.Builder().build() : googleSignInOptions;
        if (!clientSettings.getAllRequestedScopes().isEmpty()) {
            GoogleSignInOptions.Builder builder = new GoogleSignInOptions.Builder(googleSignInOptions);
            for (Scope scope : clientSettings.getAllRequestedScopes()) {
                builder.requestScopes(scope, new Scope[0]);
            }
            googleSignInOptions = builder.build();
        }
        this.zzev = googleSignInOptions;
        AppMethodBeat.o(88327);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        AppMethodBeat.i(88329);
        if (iBinder == null) {
            AppMethodBeat.o(88329);
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        if (queryLocalInterface instanceof zzv) {
            zzv zzv = (zzv) queryLocalInterface;
            AppMethodBeat.o(88329);
            return zzv;
        }
        zzw zzw = new zzw(iBinder);
        AppMethodBeat.o(88329);
        return zzw;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.GmsClient
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final Intent getSignInIntent() {
        AppMethodBeat.i(88328);
        Intent zzd = zzi.zzd(getContext(), this.zzev);
        AppMethodBeat.o(88328);
        return zzd;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean providesSignIn() {
        return true;
    }

    public final GoogleSignInOptions zzn() {
        return this.zzev;
    }
}
