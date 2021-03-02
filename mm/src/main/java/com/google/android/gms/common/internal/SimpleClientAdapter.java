package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SimpleClientAdapter<T extends IInterface> extends GmsClient<T> {
    private final Api.SimpleClient<T> zzva;

    public SimpleClientAdapter(Context context, Looper looper, int i2, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings, Api.SimpleClient<T> simpleClient) {
        super(context, looper, i2, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzva = simpleClient;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public T createServiceInterface(IBinder iBinder) {
        AppMethodBeat.i(11880);
        T createServiceInterface = this.zzva.createServiceInterface(iBinder);
        AppMethodBeat.o(11880);
        return createServiceInterface;
    }

    public Api.SimpleClient<T> getClient() {
        return this.zzva;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.GmsClient
    public int getMinApkVersion() {
        AppMethodBeat.i(11882);
        int minApkVersion = super.getMinApkVersion();
        AppMethodBeat.o(11882);
        return minApkVersion;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public String getServiceDescriptor() {
        AppMethodBeat.i(11879);
        String serviceDescriptor = this.zzva.getServiceDescriptor();
        AppMethodBeat.o(11879);
        return serviceDescriptor;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public String getStartServiceAction() {
        AppMethodBeat.i(11878);
        String startServiceAction = this.zzva.getStartServiceAction();
        AppMethodBeat.o(11878);
        return startServiceAction;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public void onSetConnectState(int i2, T t) {
        AppMethodBeat.i(11881);
        this.zzva.setState(i2, t);
        AppMethodBeat.o(11881);
    }
}
