package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AccountAccessor extends IAccountAccessor.Stub {
    private Context mContext;
    private int zzqu = -1;
    private Account zzs;

    public AccountAccessor(Context context, Account account) {
        AppMethodBeat.i(4579);
        this.mContext = context.getApplicationContext();
        this.zzs = account;
        AppMethodBeat.o(4579);
    }

    public static AccountAccessor fromGoogleAccountName(Context context, String str) {
        AppMethodBeat.i(4577);
        AccountAccessor accountAccessor = new AccountAccessor(context, TextUtils.isEmpty(str) ? null : new Account(str, "com.google"));
        AppMethodBeat.o(4577);
        return accountAccessor;
    }

    public static Account getAccountBinderSafe(IAccountAccessor iAccountAccessor) {
        AppMethodBeat.i(4578);
        Account account = null;
        if (iAccountAccessor != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = iAccountAccessor.getAccount();
                Binder.restoreCallingIdentity(clearCallingIdentity);
            } catch (RemoteException e2) {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            } catch (Throwable th) {
                Binder.restoreCallingIdentity(clearCallingIdentity);
                AppMethodBeat.o(4578);
                throw th;
            }
        }
        AppMethodBeat.o(4578);
        return account;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(4581);
        if (this == obj) {
            AppMethodBeat.o(4581);
            return true;
        } else if (!(obj instanceof AccountAccessor)) {
            AppMethodBeat.o(4581);
            return false;
        } else {
            boolean equals = this.zzs.equals(((AccountAccessor) obj).zzs);
            AppMethodBeat.o(4581);
            return equals;
        }
    }

    @Override // com.google.android.gms.common.internal.IAccountAccessor
    public Account getAccount() {
        AppMethodBeat.i(4580);
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.zzqu) {
            Account account = this.zzs;
            AppMethodBeat.o(4580);
            return account;
        } else if (GooglePlayServicesUtilLight.isGooglePlayServicesUid(this.mContext, callingUid)) {
            this.zzqu = callingUid;
            Account account2 = this.zzs;
            AppMethodBeat.o(4580);
            return account2;
        } else {
            SecurityException securityException = new SecurityException("Caller is not GooglePlayServices");
            AppMethodBeat.o(4580);
            throw securityException;
        }
    }
}
