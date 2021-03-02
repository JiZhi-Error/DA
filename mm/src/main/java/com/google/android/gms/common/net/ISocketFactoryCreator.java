package com.google.android.gms.common.net;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface ISocketFactoryCreator extends IInterface {

    public static abstract class Stub extends zzb implements ISocketFactoryCreator {

        public static class Proxy extends zza implements ISocketFactoryCreator {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.net.ISocketFactoryCreator");
            }

            @Override // com.google.android.gms.common.net.ISocketFactoryCreator
            public IObjectWrapper newSocketFactory(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, boolean z) {
                AppMethodBeat.i(4919);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper2);
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper3);
                zzc.zza(obtainAndWriteInterfaceToken, z);
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                AppMethodBeat.o(4919);
                return asInterface;
            }

            @Override // com.google.android.gms.common.net.ISocketFactoryCreator
            public IObjectWrapper newSocketFactoryWithCacheDir(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, String str) {
                AppMethodBeat.i(4920);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper2);
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper3);
                obtainAndWriteInterfaceToken.writeString(str);
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken);
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                AppMethodBeat.o(4920);
                return asInterface;
            }
        }

        public Stub() {
            super("com.google.android.gms.common.net.ISocketFactoryCreator");
        }

        public static ISocketFactoryCreator asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.net.ISocketFactoryCreator");
            return queryLocalInterface instanceof ISocketFactoryCreator ? (ISocketFactoryCreator) queryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.gms.internal.stable.zzb
        public boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    IObjectWrapper newSocketFactory = newSocketFactory(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzc.zza(parcel));
                    parcel2.writeNoException();
                    zzc.zza(parcel2, newSocketFactory);
                    break;
                case 2:
                    IObjectWrapper newSocketFactoryWithCacheDir = newSocketFactoryWithCacheDir(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    zzc.zza(parcel2, newSocketFactoryWithCacheDir);
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    IObjectWrapper newSocketFactory(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, boolean z);

    IObjectWrapper newSocketFactoryWithCacheDir(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, String str);
}
