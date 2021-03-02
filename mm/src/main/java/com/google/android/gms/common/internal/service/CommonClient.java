package com.google.android.gms.common.internal.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.service.ICommonService;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CommonClient extends GmsClient<ICommonService> {
    public static final String START_SERVICE_ACTION = "com.google.android.gms.common.service.START";

    public CommonClient(Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 39, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public ICommonService createServiceInterface(IBinder iBinder) {
        AppMethodBeat.i(11886);
        ICommonService asInterface = ICommonService.Stub.asInterface(iBinder);
        AppMethodBeat.o(11886);
        return asInterface;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.GmsClient
    public int getMinApkVersion() {
        AppMethodBeat.i(11887);
        int minApkVersion = super.getMinApkVersion();
        AppMethodBeat.o(11887);
        return minApkVersion;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public String getServiceDescriptor() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public String getStartServiceAction() {
        return START_SERVICE_ACTION;
    }
}
