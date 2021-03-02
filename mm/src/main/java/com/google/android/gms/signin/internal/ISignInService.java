package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.IResolveAccountCallbacks;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.google.android.gms.signin.internal.ISignInCallbacks;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface ISignInService extends IInterface {

    public static abstract class Stub extends zzb implements ISignInService {

        public static class Proxy extends zza implements ISignInService {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
            }

            @Override // com.google.android.gms.signin.internal.ISignInService
            public void authAccount(AuthAccountRequest authAccountRequest, ISignInCallbacks iSignInCallbacks) {
                AppMethodBeat.i(12163);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, authAccountRequest);
                zzc.zza(obtainAndWriteInterfaceToken, iSignInCallbacks);
                transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(12163);
            }

            @Override // com.google.android.gms.signin.internal.ISignInService
            public void clearAccountFromSessionStore(int i2) {
                AppMethodBeat.i(12167);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i2);
                transactAndReadExceptionReturnVoid(7, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(12167);
            }

            @Override // com.google.android.gms.signin.internal.ISignInService
            public void getCurrentAccount(ISignInCallbacks iSignInCallbacks) {
                AppMethodBeat.i(12171);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, iSignInCallbacks);
                transactAndReadExceptionReturnVoid(11, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(12171);
            }

            @Override // com.google.android.gms.signin.internal.ISignInService
            public void onCheckServerAuthorization(CheckServerAuthResult checkServerAuthResult) {
                AppMethodBeat.i(12164);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, checkServerAuthResult);
                transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(12164);
            }

            @Override // com.google.android.gms.signin.internal.ISignInService
            public void onUploadServerAuthCode(boolean z) {
                AppMethodBeat.i(12165);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(4, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(12165);
            }

            @Override // com.google.android.gms.signin.internal.ISignInService
            public void recordConsent(RecordConsentRequest recordConsentRequest, ISignInCallbacks iSignInCallbacks) {
                AppMethodBeat.i(12170);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, recordConsentRequest);
                zzc.zza(obtainAndWriteInterfaceToken, iSignInCallbacks);
                transactAndReadExceptionReturnVoid(10, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(12170);
            }

            @Override // com.google.android.gms.signin.internal.ISignInService
            public void resolveAccount(ResolveAccountRequest resolveAccountRequest, IResolveAccountCallbacks iResolveAccountCallbacks) {
                AppMethodBeat.i(12166);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, resolveAccountRequest);
                zzc.zza(obtainAndWriteInterfaceToken, iResolveAccountCallbacks);
                transactAndReadExceptionReturnVoid(5, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(12166);
            }

            @Override // com.google.android.gms.signin.internal.ISignInService
            public void saveAccountToSessionStore(int i2, Account account, ISignInCallbacks iSignInCallbacks) {
                AppMethodBeat.i(12168);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i2);
                zzc.zza(obtainAndWriteInterfaceToken, account);
                zzc.zza(obtainAndWriteInterfaceToken, iSignInCallbacks);
                transactAndReadExceptionReturnVoid(8, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(12168);
            }

            @Override // com.google.android.gms.signin.internal.ISignInService
            public void saveDefaultAccountToSharedPref(IAccountAccessor iAccountAccessor, int i2, boolean z) {
                AppMethodBeat.i(12169);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, iAccountAccessor);
                obtainAndWriteInterfaceToken.writeInt(i2);
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(9, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(12169);
            }

            @Override // com.google.android.gms.signin.internal.ISignInService
            public void setGamesHasBeenGreeted(boolean z) {
                AppMethodBeat.i(12173);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(13, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(12173);
            }

            @Override // com.google.android.gms.signin.internal.ISignInService
            public void signIn(SignInRequest signInRequest, ISignInCallbacks iSignInCallbacks) {
                AppMethodBeat.i(12172);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, signInRequest);
                zzc.zza(obtainAndWriteInterfaceToken, iSignInCallbacks);
                transactAndReadExceptionReturnVoid(12, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(12172);
            }
        }

        public Stub() {
            super("com.google.android.gms.signin.internal.ISignInService");
        }

        public static ISignInService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
            return queryLocalInterface instanceof ISignInService ? (ISignInService) queryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.gms.internal.stable.zzb
        public boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 2:
                    authAccount((AuthAccountRequest) zzc.zza(parcel, AuthAccountRequest.CREATOR), ISignInCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                case 3:
                    onCheckServerAuthorization((CheckServerAuthResult) zzc.zza(parcel, CheckServerAuthResult.CREATOR));
                    break;
                case 4:
                    onUploadServerAuthCode(zzc.zza(parcel));
                    break;
                case 5:
                    resolveAccount((ResolveAccountRequest) zzc.zza(parcel, ResolveAccountRequest.CREATOR), IResolveAccountCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                case 6:
                default:
                    return false;
                case 7:
                    clearAccountFromSessionStore(parcel.readInt());
                    break;
                case 8:
                    saveAccountToSessionStore(parcel.readInt(), (Account) zzc.zza(parcel, Account.CREATOR), ISignInCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                case 9:
                    saveDefaultAccountToSharedPref(IAccountAccessor.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), zzc.zza(parcel));
                    break;
                case 10:
                    recordConsent((RecordConsentRequest) zzc.zza(parcel, RecordConsentRequest.CREATOR), ISignInCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                case 11:
                    getCurrentAccount(ISignInCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                case 12:
                    signIn((SignInRequest) zzc.zza(parcel, SignInRequest.CREATOR), ISignInCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                case 13:
                    setGamesHasBeenGreeted(zzc.zza(parcel));
                    break;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void authAccount(AuthAccountRequest authAccountRequest, ISignInCallbacks iSignInCallbacks);

    void clearAccountFromSessionStore(int i2);

    void getCurrentAccount(ISignInCallbacks iSignInCallbacks);

    void onCheckServerAuthorization(CheckServerAuthResult checkServerAuthResult);

    void onUploadServerAuthCode(boolean z);

    void recordConsent(RecordConsentRequest recordConsentRequest, ISignInCallbacks iSignInCallbacks);

    void resolveAccount(ResolveAccountRequest resolveAccountRequest, IResolveAccountCallbacks iResolveAccountCallbacks);

    void saveAccountToSessionStore(int i2, Account account, ISignInCallbacks iSignInCallbacks);

    void saveDefaultAccountToSharedPref(IAccountAccessor iAccountAccessor, int i2, boolean z);

    void setGamesHasBeenGreeted(boolean z);

    void signIn(SignInRequest signInRequest, ISignInCallbacks iSignInCallbacks);
}
