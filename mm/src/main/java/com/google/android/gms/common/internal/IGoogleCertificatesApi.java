package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.GoogleCertificatesQuery;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface IGoogleCertificatesApi extends IInterface {

    public static abstract class Stub extends zzb implements IGoogleCertificatesApi {

        public static class Proxy extends zza implements IGoogleCertificatesApi {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
            }

            @Override // com.google.android.gms.common.internal.IGoogleCertificatesApi
            public IObjectWrapper getGoogleCertificates() {
                AppMethodBeat.i(4696);
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                AppMethodBeat.o(4696);
                return asInterface;
            }

            @Override // com.google.android.gms.common.internal.IGoogleCertificatesApi
            public IObjectWrapper getGoogleReleaseCertificates() {
                AppMethodBeat.i(4697);
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                AppMethodBeat.o(4697);
                return asInterface;
            }

            @Override // com.google.android.gms.common.internal.IGoogleCertificatesApi
            public boolean isGoogleOrPlatformSigned(GoogleCertificatesQuery googleCertificatesQuery, IObjectWrapper iObjectWrapper) {
                AppMethodBeat.i(4700);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, googleCertificatesQuery);
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
                Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken);
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                AppMethodBeat.o(4700);
                return zza;
            }

            @Override // com.google.android.gms.common.internal.IGoogleCertificatesApi
            public boolean isGoogleReleaseSigned(String str, IObjectWrapper iObjectWrapper) {
                AppMethodBeat.i(4698);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeString(str);
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
                Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken);
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                AppMethodBeat.o(4698);
                return zza;
            }

            @Override // com.google.android.gms.common.internal.IGoogleCertificatesApi
            public boolean isGoogleSigned(String str, IObjectWrapper iObjectWrapper) {
                AppMethodBeat.i(4699);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeString(str);
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
                Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken);
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                AppMethodBeat.o(4699);
                return zza;
            }
        }

        public Stub() {
            super("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        }

        public static IGoogleCertificatesApi asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
            return queryLocalInterface instanceof IGoogleCertificatesApi ? (IGoogleCertificatesApi) queryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.gms.internal.stable.zzb
        public boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    IObjectWrapper googleCertificates = getGoogleCertificates();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, googleCertificates);
                    break;
                case 2:
                    IObjectWrapper googleReleaseCertificates = getGoogleReleaseCertificates();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, googleReleaseCertificates);
                    break;
                case 3:
                    boolean isGoogleReleaseSigned = isGoogleReleaseSigned(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    zzc.zza(parcel2, isGoogleReleaseSigned);
                    break;
                case 4:
                    boolean isGoogleSigned = isGoogleSigned(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    zzc.zza(parcel2, isGoogleSigned);
                    break;
                case 5:
                    boolean isGoogleOrPlatformSigned = isGoogleOrPlatformSigned((GoogleCertificatesQuery) zzc.zza(parcel, GoogleCertificatesQuery.CREATOR), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    zzc.zza(parcel2, isGoogleOrPlatformSigned);
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    IObjectWrapper getGoogleCertificates();

    IObjectWrapper getGoogleReleaseCertificates();

    boolean isGoogleOrPlatformSigned(GoogleCertificatesQuery googleCertificatesQuery, IObjectWrapper iObjectWrapper);

    boolean isGoogleReleaseSigned(String str, IObjectWrapper iObjectWrapper);

    boolean isGoogleSigned(String str, IObjectWrapper iObjectWrapper);
}
