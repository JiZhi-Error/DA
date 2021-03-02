package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface IStatusCallback extends IInterface {

    public static abstract class Stub extends zzb implements IStatusCallback {

        public static class zza extends com.google.android.gms.internal.stable.zza implements IStatusCallback {
            zza(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.api.internal.IStatusCallback");
            }

            @Override // com.google.android.gms.common.api.internal.IStatusCallback
            public final void onResult(Status status) {
                AppMethodBeat.i(11130);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, status);
                transactOneway(1, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(11130);
            }
        }

        public Stub() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        public static IStatusCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
            return queryLocalInterface instanceof IStatusCallback ? (IStatusCallback) queryLocalInterface : new zza(iBinder);
        }

        @Override // com.google.android.gms.internal.stable.zzb
        public boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 != 1) {
                return false;
            }
            onResult((Status) zzc.zza(parcel, Status.CREATOR));
            return true;
        }
    }

    void onResult(Status status);
}
