package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface ISignInButtonCreator extends IInterface {

    public static abstract class Stub extends zzb implements ISignInButtonCreator {

        public static class Proxy extends zza implements ISignInButtonCreator {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
            }

            @Override // com.google.android.gms.common.internal.ISignInButtonCreator
            public IObjectWrapper newSignInButton(IObjectWrapper iObjectWrapper, int i2, int i3) {
                AppMethodBeat.i(11844);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
                obtainAndWriteInterfaceToken.writeInt(i2);
                obtainAndWriteInterfaceToken.writeInt(i3);
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                AppMethodBeat.o(11844);
                return asInterface;
            }

            @Override // com.google.android.gms.common.internal.ISignInButtonCreator
            public IObjectWrapper newSignInButtonFromConfig(IObjectWrapper iObjectWrapper, SignInButtonConfig signInButtonConfig) {
                AppMethodBeat.i(11845);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
                zzc.zza(obtainAndWriteInterfaceToken, signInButtonConfig);
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken);
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                AppMethodBeat.o(11845);
                return asInterface;
            }
        }

        public Stub() {
            super("com.google.android.gms.common.internal.ISignInButtonCreator");
        }

        public static ISignInButtonCreator asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            return queryLocalInterface instanceof ISignInButtonCreator ? (ISignInButtonCreator) queryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.gms.internal.stable.zzb
        public boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    IObjectWrapper newSignInButton = newSignInButton(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    zzc.zza(parcel2, newSignInButton);
                    break;
                case 2:
                    IObjectWrapper newSignInButtonFromConfig = newSignInButtonFromConfig(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (SignInButtonConfig) zzc.zza(parcel, SignInButtonConfig.CREATOR));
                    parcel2.writeNoException();
                    zzc.zza(parcel2, newSignInButtonFromConfig);
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    IObjectWrapper newSignInButton(IObjectWrapper iObjectWrapper, int i2, int i3);

    IObjectWrapper newSignInButtonFromConfig(IObjectWrapper iObjectWrapper, SignInButtonConfig signInButtonConfig);
}
