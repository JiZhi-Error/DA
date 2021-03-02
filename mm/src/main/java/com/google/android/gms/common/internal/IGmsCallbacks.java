package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface IGmsCallbacks extends IInterface {

    public static abstract class Stub extends zzb implements IGmsCallbacks {

        public static class Proxy extends zza implements IGmsCallbacks {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
            }

            @Override // com.google.android.gms.common.internal.IGmsCallbacks
            public void onAccountValidationComplete(int i2, Bundle bundle) {
                AppMethodBeat.i(4693);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i2);
                zzc.zza(obtainAndWriteInterfaceToken, bundle);
                transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(4693);
            }

            @Override // com.google.android.gms.common.internal.IGmsCallbacks
            public void onPostInitComplete(int i2, IBinder iBinder, Bundle bundle) {
                AppMethodBeat.i(4692);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i2);
                obtainAndWriteInterfaceToken.writeStrongBinder(iBinder);
                zzc.zza(obtainAndWriteInterfaceToken, bundle);
                transactAndReadExceptionReturnVoid(1, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(4692);
            }

            @Override // com.google.android.gms.common.internal.IGmsCallbacks
            public void onPostInitCompleteWithConnectionInfo(int i2, IBinder iBinder, ConnectionInfo connectionInfo) {
                AppMethodBeat.i(4694);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i2);
                obtainAndWriteInterfaceToken.writeStrongBinder(iBinder);
                zzc.zza(obtainAndWriteInterfaceToken, connectionInfo);
                transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(4694);
            }
        }

        public Stub() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        public static IGmsCallbacks asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
            return queryLocalInterface instanceof IGmsCallbacks ? (IGmsCallbacks) queryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.gms.internal.stable.zzb
        public boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    onPostInitComplete(parcel.readInt(), parcel.readStrongBinder(), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
                    break;
                case 2:
                    onAccountValidationComplete(parcel.readInt(), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
                    break;
                case 3:
                    onPostInitCompleteWithConnectionInfo(parcel.readInt(), parcel.readStrongBinder(), (ConnectionInfo) zzc.zza(parcel, ConnectionInfo.CREATOR));
                    break;
                default:
                    return false;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onAccountValidationComplete(int i2, Bundle bundle);

    void onPostInitComplete(int i2, IBinder iBinder, Bundle bundle);

    void onPostInitCompleteWithConnectionInfo(int i2, IBinder iBinder, ConnectionInfo connectionInfo);
}
