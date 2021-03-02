package com.google.android.gms.auth;

import android.accounts.Account;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.URISyntaxException;
import java.util.List;

public final class GoogleAuthUtil extends zzg {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    private static final String KEY_ANDROID_PACKAGE_NAME = zzg.KEY_ANDROID_PACKAGE_NAME;
    private static final String KEY_CALLER_UID = zzg.KEY_CALLER_UID;
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    public static final String WORK_ACCOUNT_TYPE = "com.google.work";

    private GoogleAuthUtil() {
    }

    public static void clearToken(Context context, String str) {
        AppMethodBeat.i(10609);
        zzg.clearToken(context, str);
        AppMethodBeat.o(10609);
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, int i2, String str) {
        AppMethodBeat.i(10610);
        List<AccountChangeEvent> accountChangeEvents = zzg.getAccountChangeEvents(context, i2, str);
        AppMethodBeat.o(10610);
        return accountChangeEvents;
    }

    public static String getAccountId(Context context, String str) {
        AppMethodBeat.i(10611);
        String accountId = zzg.getAccountId(context, str);
        AppMethodBeat.o(10611);
        return accountId;
    }

    public static String getToken(Context context, Account account, String str) {
        AppMethodBeat.i(10606);
        String token = zzg.getToken(context, account, str);
        AppMethodBeat.o(10606);
        return token;
    }

    public static String getToken(Context context, Account account, String str, Bundle bundle) {
        AppMethodBeat.i(10607);
        String token = zzg.getToken(context, account, str, bundle);
        AppMethodBeat.o(10607);
        return token;
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2) {
        AppMethodBeat.i(10604);
        String token = zzg.getToken(context, str, str2);
        AppMethodBeat.o(10604);
        return token;
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2, Bundle bundle) {
        AppMethodBeat.i(10605);
        String token = zzg.getToken(context, str, str2, bundle);
        AppMethodBeat.o(10605);
        return token;
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle) {
        AppMethodBeat.i(10600);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("handle_notification", true);
        String zze = zzd(context, account, str, bundle).zze();
        AppMethodBeat.o(10600);
        return zze;
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle, Intent intent) {
        AppMethodBeat.i(10601);
        if (intent == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Callback cannot be null.");
            AppMethodBeat.o(10601);
            throw illegalArgumentException;
        }
        try {
            Intent.parseUri(intent.toUri(1), 1);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putParcelable("callback_intent", intent);
            bundle.putBoolean("handle_notification", true);
            String zze = zzd(context, account, str, bundle).zze();
            AppMethodBeat.o(10601);
            return zze;
        } catch (URISyntaxException e2) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
            AppMethodBeat.o(10601);
            throw illegalArgumentException2;
        }
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle, String str2, Bundle bundle2) {
        AppMethodBeat.i(10602);
        Preconditions.checkNotEmpty(str2, "Authority cannot be empty or null.");
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        ContentResolver.validateSyncExtrasBundle(bundle2);
        bundle.putString("authority", str2);
        bundle.putBundle("sync_extras", bundle2);
        bundle.putBoolean("handle_notification", true);
        String zze = zzd(context, account, str, bundle).zze();
        AppMethodBeat.o(10602);
        return zze;
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle) {
        AppMethodBeat.i(10597);
        String tokenWithNotification = getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle);
        AppMethodBeat.o(10597);
        return tokenWithNotification;
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle, Intent intent) {
        AppMethodBeat.i(10598);
        String tokenWithNotification = getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle, intent);
        AppMethodBeat.o(10598);
        return tokenWithNotification;
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle, String str3, Bundle bundle2) {
        AppMethodBeat.i(10599);
        String tokenWithNotification = getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle, str3, bundle2);
        AppMethodBeat.o(10599);
        return tokenWithNotification;
    }

    @Deprecated
    public static void invalidateToken(Context context, String str) {
        AppMethodBeat.i(10608);
        zzg.invalidateToken(context, str);
        AppMethodBeat.o(10608);
    }

    @TargetApi(23)
    public static Bundle removeAccount(Context context, Account account) {
        AppMethodBeat.i(10612);
        Bundle removeAccount = zzg.removeAccount(context, account);
        AppMethodBeat.o(10612);
        return removeAccount;
    }

    @TargetApi(26)
    public static Boolean requestGoogleAccountsAccess(Context context) {
        AppMethodBeat.i(10613);
        Boolean requestGoogleAccountsAccess = zzg.requestGoogleAccountsAccess(context);
        AppMethodBeat.o(10613);
        return requestGoogleAccountsAccess;
    }

    private static TokenData zzd(Context context, Account account, String str, Bundle bundle) {
        AppMethodBeat.i(10603);
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            TokenData zze = zzg.zze(context, account, str, bundle);
            GooglePlayServicesUtil.cancelAvailabilityErrorNotifications(context);
            AppMethodBeat.o(10603);
            return zze;
        } catch (GooglePlayServicesAvailabilityException e2) {
            GooglePlayServicesUtil.showErrorNotification(e2.getConnectionStatusCode(), context);
            UserRecoverableNotifiedException userRecoverableNotifiedException = new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
            AppMethodBeat.o(10603);
            throw userRecoverableNotifiedException;
        } catch (UserRecoverableAuthException e3) {
            GooglePlayServicesUtil.cancelAvailabilityErrorNotifications(context);
            UserRecoverableNotifiedException userRecoverableNotifiedException2 = new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
            AppMethodBeat.o(10603);
            throw userRecoverableNotifiedException2;
        }
    }
}
