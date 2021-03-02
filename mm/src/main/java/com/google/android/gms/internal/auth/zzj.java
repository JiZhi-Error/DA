package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzj extends zzd implements zzh {
    zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.auth.IAuthManagerService");
    }

    @Override // com.google.android.gms.internal.auth.zzh
    public final Bundle zzd(Account account) {
        AppMethodBeat.i(10787);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, account);
        Parcel transactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken);
        Bundle bundle = (Bundle) zzf.zzd(transactAndReadException, Bundle.CREATOR);
        transactAndReadException.recycle();
        AppMethodBeat.o(10787);
        return bundle;
    }

    @Override // com.google.android.gms.internal.auth.zzh
    public final Bundle zzd(Account account, String str, Bundle bundle) {
        AppMethodBeat.i(10786);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, account);
        obtainAndWriteInterfaceToken.writeString(str);
        zzf.zzd(obtainAndWriteInterfaceToken, bundle);
        Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken);
        Bundle bundle2 = (Bundle) zzf.zzd(transactAndReadException, Bundle.CREATOR);
        transactAndReadException.recycle();
        AppMethodBeat.o(10786);
        return bundle2;
    }

    @Override // com.google.android.gms.internal.auth.zzh
    public final Bundle zzd(String str) {
        AppMethodBeat.i(10788);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        Parcel transactAndReadException = transactAndReadException(8, obtainAndWriteInterfaceToken);
        Bundle bundle = (Bundle) zzf.zzd(transactAndReadException, Bundle.CREATOR);
        transactAndReadException.recycle();
        AppMethodBeat.o(10788);
        return bundle;
    }

    @Override // com.google.android.gms.internal.auth.zzh
    public final Bundle zzd(String str, Bundle bundle) {
        AppMethodBeat.i(10784);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzf.zzd(obtainAndWriteInterfaceToken, bundle);
        Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken);
        Bundle bundle2 = (Bundle) zzf.zzd(transactAndReadException, Bundle.CREATOR);
        transactAndReadException.recycle();
        AppMethodBeat.o(10784);
        return bundle2;
    }

    @Override // com.google.android.gms.internal.auth.zzh
    public final AccountChangeEventsResponse zzd(AccountChangeEventsRequest accountChangeEventsRequest) {
        AppMethodBeat.i(10785);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, accountChangeEventsRequest);
        Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken);
        AccountChangeEventsResponse accountChangeEventsResponse = (AccountChangeEventsResponse) zzf.zzd(transactAndReadException, AccountChangeEventsResponse.CREATOR);
        transactAndReadException.recycle();
        AppMethodBeat.o(10785);
        return accountChangeEventsResponse;
    }
}
