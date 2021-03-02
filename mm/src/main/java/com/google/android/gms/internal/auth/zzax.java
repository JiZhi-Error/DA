package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzax extends GmsClient<zzbc> {
    private final Auth.AuthCredentialsOptions zzdv;

    public zzax(Context context, Looper looper, ClientSettings clientSettings, Auth.AuthCredentialsOptions authCredentialsOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 68, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzdv = authCredentialsOptions;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        AppMethodBeat.i(88382);
        if (iBinder == null) {
            AppMethodBeat.o(88382);
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        if (queryLocalInterface instanceof zzbc) {
            zzbc zzbc = (zzbc) queryLocalInterface;
            AppMethodBeat.o(88382);
            return zzbc;
        }
        zzbd zzbd = new zzbd(iBinder);
        AppMethodBeat.o(88382);
        return zzbd;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        AppMethodBeat.i(88381);
        if (this.zzdv == null) {
            Bundle bundle = new Bundle();
            AppMethodBeat.o(88381);
            return bundle;
        }
        Bundle bundle2 = this.zzdv.toBundle();
        AppMethodBeat.o(88381);
        return bundle2;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.GmsClient
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    /* access modifiers changed from: package-private */
    public final Auth.AuthCredentialsOptions zzk() {
        return this.zzdv;
    }
}
