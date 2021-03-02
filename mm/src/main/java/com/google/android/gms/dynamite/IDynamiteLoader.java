package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface IDynamiteLoader extends IInterface {

    public static abstract class Stub extends zzb implements IDynamiteLoader {

        public static class Proxy extends zza implements IDynamiteLoader {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
            }

            @Override // com.google.android.gms.dynamite.IDynamiteLoader
            public IObjectWrapper createModuleContext(IObjectWrapper iObjectWrapper, String str, int i2) {
                AppMethodBeat.i(5465);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
                obtainAndWriteInterfaceToken.writeString(str);
                obtainAndWriteInterfaceToken.writeInt(i2);
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken);
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                AppMethodBeat.o(5465);
                return asInterface;
            }

            @Override // com.google.android.gms.dynamite.IDynamiteLoader
            public int getModuleVersion(IObjectWrapper iObjectWrapper, String str) {
                AppMethodBeat.i(5464);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
                obtainAndWriteInterfaceToken.writeString(str);
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                AppMethodBeat.o(5464);
                return readInt;
            }

            @Override // com.google.android.gms.dynamite.IDynamiteLoader
            public int getModuleVersion2(IObjectWrapper iObjectWrapper, String str, boolean z) {
                AppMethodBeat.i(5466);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
                obtainAndWriteInterfaceToken.writeString(str);
                zzc.zza(obtainAndWriteInterfaceToken, z);
                Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken);
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                AppMethodBeat.o(5466);
                return readInt;
            }
        }

        public Stub() {
            super("com.google.android.gms.dynamite.IDynamiteLoader");
        }

        public static IDynamiteLoader asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
            return queryLocalInterface instanceof IDynamiteLoader ? (IDynamiteLoader) queryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.gms.internal.stable.zzb
        public boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    int moduleVersion = getModuleVersion(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(moduleVersion);
                    break;
                case 2:
                    IObjectWrapper createModuleContext = createModuleContext(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    zzc.zza(parcel2, createModuleContext);
                    break;
                case 3:
                    int moduleVersion2 = getModuleVersion2(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzc.zza(parcel));
                    parcel2.writeNoException();
                    parcel2.writeInt(moduleVersion2);
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    IObjectWrapper createModuleContext(IObjectWrapper iObjectWrapper, String str, int i2);

    int getModuleVersion(IObjectWrapper iObjectWrapper, String str);

    int getModuleVersion2(IObjectWrapper iObjectWrapper, String str, boolean z);
}
