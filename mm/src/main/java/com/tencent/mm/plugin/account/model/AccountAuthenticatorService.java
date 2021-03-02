package com.tencent.mm.plugin.account.model;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.ui.ContactsSyncUI;
import com.tencent.mm.sdk.platformtools.Log;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class AccountAuthenticatorService extends Service {
    private static a kif = null;

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(127806);
        if (intent == null) {
            AppMethodBeat.o(127806);
            return null;
        } else if (intent.getAction() == null || !intent.getAction().equals("android.accounts.AccountAuthenticator")) {
            AppMethodBeat.o(127806);
            return null;
        } else {
            if (kif == null) {
                kif = new a(this);
            }
            IBinder iBinder = kif.getIBinder();
            AppMethodBeat.o(127806);
            return iBinder;
        }
    }

    static class a extends AbstractAccountAuthenticator {
        private Context mContext;

        public a(Context context) {
            super(context);
            this.mContext = context;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public final Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) {
            AppMethodBeat.i(127799);
            Bundle bundle2 = new Bundle();
            Intent intent = new Intent(this.mContext, ContactsSyncUI.class);
            intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
            intent.putExtra("contact_sync_scene", 1);
            bundle2.putParcelable("intent", intent);
            AppMethodBeat.o(127799);
            return bundle2;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public final Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) {
            AppMethodBeat.i(127800);
            Log.i("MicroMsg.AccountAuthenticatorService", "confirmCredentials");
            AppMethodBeat.o(127800);
            return null;
        }

        public final Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
            AppMethodBeat.i(127801);
            Log.i("MicroMsg.AccountAuthenticatorService", "editProperties");
            AppMethodBeat.o(127801);
            return null;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public final Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
            AppMethodBeat.i(127802);
            Log.i("MicroMsg.AccountAuthenticatorService", "getAuthToken");
            AppMethodBeat.o(127802);
            return null;
        }

        public final String getAuthTokenLabel(String str) {
            AppMethodBeat.i(127803);
            Log.i("MicroMsg.AccountAuthenticatorService", "getAuthTokenLabel");
            AppMethodBeat.o(127803);
            return null;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public final Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) {
            AppMethodBeat.i(127804);
            Log.i("MicroMsg.AccountAuthenticatorService", "hasFeatures: ".concat(String.valueOf(strArr)));
            AppMethodBeat.o(127804);
            return null;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public final Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
            AppMethodBeat.i(127805);
            Log.i("MicroMsg.AccountAuthenticatorService", "updateCredentials");
            AppMethodBeat.o(127805);
            return null;
        }
    }
}
