package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.zzf;
import com.google.android.gms.auth.api.zzh;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzbh extends GmsClient<zzbk> {
    private final Bundle zzcf;

    public zzbh(Context context, Looper looper, ClientSettings clientSettings, zzh zzh, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 16, clientSettings, connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.i(10762);
        if (zzh == null) {
            this.zzcf = new Bundle();
            AppMethodBeat.o(10762);
            return;
        }
        NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
        AppMethodBeat.o(10762);
        throw noSuchMethodError;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        AppMethodBeat.i(10764);
        if (iBinder == null) {
            AppMethodBeat.o(10764);
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        if (queryLocalInterface instanceof zzbk) {
            zzbk zzbk = (zzbk) queryLocalInterface;
            AppMethodBeat.o(10764);
            return zzbk;
        }
        zzbl zzbl = new zzbl(iBinder);
        AppMethodBeat.o(10764);
        return zzbl;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        return this.zzcf;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.GmsClient
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresSignIn() {
        AppMethodBeat.i(10763);
        ClientSettings clientSettings = getClientSettings();
        if (TextUtils.isEmpty(clientSettings.getAccountName()) || clientSettings.getApplicableScopes(zzf.API).isEmpty()) {
            AppMethodBeat.o(10763);
            return false;
        }
        AppMethodBeat.o(10763);
        return true;
    }
}
