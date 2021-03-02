package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface ICertData extends IInterface {

    public static abstract class Stub extends zzb implements ICertData {

        public static class Proxy extends zza implements ICertData {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.ICertData");
            }

            @Override // com.google.android.gms.common.internal.ICertData
            public IObjectWrapper getBytesWrapped() {
                AppMethodBeat.i(4690);
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                AppMethodBeat.o(4690);
                return asInterface;
            }

            @Override // com.google.android.gms.common.internal.ICertData
            public int getHashCode() {
                AppMethodBeat.i(4691);
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                AppMethodBeat.o(4691);
                return readInt;
            }
        }

        public Stub() {
            super("com.google.android.gms.common.internal.ICertData");
        }

        public static ICertData asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
            return queryLocalInterface instanceof ICertData ? (ICertData) queryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.gms.internal.stable.zzb
        public boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    IObjectWrapper bytesWrapped = getBytesWrapped();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, bytesWrapped);
                    break;
                case 2:
                    int hashCode = getHashCode();
                    parcel2.writeNoException();
                    parcel2.writeInt(hashCode);
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    IObjectWrapper getBytesWrapped();

    int getHashCode();
}
