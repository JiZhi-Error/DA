package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface IDynamiteLoaderV2 extends IInterface {

    public static abstract class Stub extends zzb implements IDynamiteLoaderV2 {

        public static class Proxy extends zza implements IDynamiteLoaderV2 {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
            }

            @Override // com.google.android.gms.dynamite.IDynamiteLoaderV2
            public IObjectWrapper loadModule(IObjectWrapper iObjectWrapper, String str, byte[] bArr) {
                AppMethodBeat.i(5467);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
                obtainAndWriteInterfaceToken.writeString(str);
                obtainAndWriteInterfaceToken.writeByteArray(bArr);
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                AppMethodBeat.o(5467);
                return asInterface;
            }

            @Override // com.google.android.gms.dynamite.IDynamiteLoaderV2
            public IObjectWrapper loadModule2(IObjectWrapper iObjectWrapper, String str, int i2, IObjectWrapper iObjectWrapper2) {
                AppMethodBeat.i(5468);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
                obtainAndWriteInterfaceToken.writeString(str);
                obtainAndWriteInterfaceToken.writeInt(i2);
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper2);
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken);
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                AppMethodBeat.o(5468);
                return asInterface;
            }
        }

        public Stub() {
            super("com.google.android.gms.dynamite.IDynamiteLoaderV2");
        }

        public static IDynamiteLoaderV2 asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
            return queryLocalInterface instanceof IDynamiteLoaderV2 ? (IDynamiteLoaderV2) queryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.gms.internal.stable.zzb
        public boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    IObjectWrapper loadModule = loadModule(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    zzc.zza(parcel2, loadModule);
                    break;
                case 2:
                    IObjectWrapper loadModule2 = loadModule2(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    zzc.zza(parcel2, loadModule2);
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    IObjectWrapper loadModule(IObjectWrapper iObjectWrapper, String str, byte[] bArr);

    IObjectWrapper loadModule2(IObjectWrapper iObjectWrapper, String str, int i2, IObjectWrapper iObjectWrapper2);
}
