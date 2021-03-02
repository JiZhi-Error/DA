package com.google.android.gms.auth.api.accounttransfer;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzw;
import com.google.android.gms.internal.auth.zzx;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AccountTransfer {
    public static final String ACTION_ACCOUNT_EXPORT_DATA_AVAILABLE = "com.google.android.gms.auth.ACCOUNT_EXPORT_DATA_AVAILABLE";
    public static final String ACTION_ACCOUNT_IMPORT_DATA_AVAILABLE = "com.google.android.gms.auth.ACCOUNT_IMPORT_DATA_AVAILABLE";
    public static final String ACTION_START_ACCOUNT_EXPORT = "com.google.android.gms.auth.START_ACCOUNT_EXPORT";
    public static final String KEY_EXTRA_ACCOUNT_TYPE = "key_extra_account_type";
    private static final Api.ClientKey<zzx> zzau = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzx, zzq> zzav = new zzd();
    private static final Api<zzq> zzaw = new Api<>("AccountTransfer.ACCOUNT_TRANSFER_API", zzav, zzau);
    @Deprecated
    private static final zze zzax = new zzw();
    private static final zzt zzay = new zzw();

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.gms.internal.auth.zzw, com.google.android.gms.auth.api.accounttransfer.zze] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.google.android.gms.auth.api.accounttransfer.zzt, com.google.android.gms.internal.auth.zzw] */
    static {
        AppMethodBeat.i(10636);
        AppMethodBeat.o(10636);
    }

    private AccountTransfer() {
    }

    public static AccountTransferClient getAccountTransferClient(Activity activity) {
        AppMethodBeat.i(10634);
        AccountTransferClient accountTransferClient = new AccountTransferClient(activity);
        AppMethodBeat.o(10634);
        return accountTransferClient;
    }

    public static AccountTransferClient getAccountTransferClient(Context context) {
        AppMethodBeat.i(10635);
        AccountTransferClient accountTransferClient = new AccountTransferClient(context);
        AppMethodBeat.o(10635);
        return accountTransferClient;
    }
}
