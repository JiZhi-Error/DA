package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzff extends BaseGmsClient<zzey> {
    public zzff(Context context, Looper looper, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(context, looper, 93, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
    }

    /* Return type fixed from 'android.os.IInterface' to match base method */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ zzey createServiceInterface(IBinder iBinder) {
        AppMethodBeat.i(1392);
        if (iBinder == null) {
            AppMethodBeat.o(1392);
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        if (queryLocalInterface instanceof zzey) {
            zzey zzey = (zzey) queryLocalInterface;
            AppMethodBeat.o(1392);
            return zzey;
        }
        zzfa zzfa = new zzfa(iBinder);
        AppMethodBeat.o(1392);
        return zzfa;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.measurement.START";
    }
}
