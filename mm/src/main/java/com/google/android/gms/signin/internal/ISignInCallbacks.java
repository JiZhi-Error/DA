package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface ISignInCallbacks extends IInterface {

    public static abstract class Stub extends zzb implements ISignInCallbacks {

        public static class Proxy extends zza implements ISignInCallbacks {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.signin.internal.ISignInCallbacks");
            }

            @Override // com.google.android.gms.signin.internal.ISignInCallbacks
            public void onAuthAccountComplete(ConnectionResult connectionResult, AuthAccountResult authAccountResult) {
                AppMethodBeat.i(12158);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, connectionResult);
                zzc.zza(obtainAndWriteInterfaceToken, authAccountResult);
                transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(12158);
            }

            @Override // com.google.android.gms.signin.internal.ISignInCallbacks
            public void onGetCurrentAccountComplete(Status status, GoogleSignInAccount googleSignInAccount) {
                AppMethodBeat.i(12161);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, status);
                zzc.zza(obtainAndWriteInterfaceToken, googleSignInAccount);
                transactAndReadExceptionReturnVoid(7, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(12161);
            }

            @Override // com.google.android.gms.signin.internal.ISignInCallbacks
            public void onRecordConsentComplete(Status status) {
                AppMethodBeat.i(12160);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, status);
                transactAndReadExceptionReturnVoid(6, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(12160);
            }

            @Override // com.google.android.gms.signin.internal.ISignInCallbacks
            public void onSaveAccountToSessionStoreComplete(Status status) {
                AppMethodBeat.i(12159);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, status);
                transactAndReadExceptionReturnVoid(4, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(12159);
            }

            @Override // com.google.android.gms.signin.internal.ISignInCallbacks
            public void onSignInComplete(SignInResponse signInResponse) {
                AppMethodBeat.i(12162);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, signInResponse);
                transactAndReadExceptionReturnVoid(8, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(12162);
            }
        }

        public Stub() {
            super("com.google.android.gms.signin.internal.ISignInCallbacks");
        }

        public static ISignInCallbacks asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
            return queryLocalInterface instanceof ISignInCallbacks ? (ISignInCallbacks) queryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.gms.internal.stable.zzb
        public boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 3:
                    onAuthAccountComplete((ConnectionResult) zzc.zza(parcel, ConnectionResult.CREATOR), (AuthAccountResult) zzc.zza(parcel, AuthAccountResult.CREATOR));
                    break;
                case 4:
                    onSaveAccountToSessionStoreComplete((Status) zzc.zza(parcel, Status.CREATOR));
                    break;
                case 5:
                default:
                    return false;
                case 6:
                    onRecordConsentComplete((Status) zzc.zza(parcel, Status.CREATOR));
                    break;
                case 7:
                    onGetCurrentAccountComplete((Status) zzc.zza(parcel, Status.CREATOR), (GoogleSignInAccount) zzc.zza(parcel, GoogleSignInAccount.CREATOR));
                    break;
                case 8:
                    onSignInComplete((SignInResponse) zzc.zza(parcel, SignInResponse.CREATOR));
                    break;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onAuthAccountComplete(ConnectionResult connectionResult, AuthAccountResult authAccountResult);

    void onGetCurrentAccountComplete(Status status, GoogleSignInAccount googleSignInAccount);

    void onRecordConsentComplete(Status status);

    void onSaveAccountToSessionStoreComplete(Status status);

    void onSignInComplete(SignInResponse signInResponse);
}
