package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.service.ICommonCallbacks;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface ICommonService extends IInterface {

    public static abstract class Stub extends zzb implements ICommonService {

        public static class Proxy extends zza implements ICommonService {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
            }

            @Override // com.google.android.gms.common.internal.service.ICommonService
            public void clearDefaultAccount(ICommonCallbacks iCommonCallbacks) {
                AppMethodBeat.i(11890);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, iCommonCallbacks);
                transactOneway(1, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(11890);
            }
        }

        public Stub() {
            super("com.google.android.gms.common.internal.service.ICommonService");
        }

        public static ICommonService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
            return queryLocalInterface instanceof ICommonService ? (ICommonService) queryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.gms.internal.stable.zzb
        public boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 != 1) {
                return false;
            }
            clearDefaultAccount(ICommonCallbacks.Stub.asInterface(parcel.readStrongBinder()));
            return true;
        }
    }

    void clearDefaultAccount(ICommonCallbacks iCommonCallbacks);
}
