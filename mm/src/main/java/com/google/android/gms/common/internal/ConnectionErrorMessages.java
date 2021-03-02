package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.support.v4.e.n;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import javax.annotation.concurrent.GuardedBy;

public final class ConnectionErrorMessages {
    @GuardedBy("sCache")
    private static final n<String, String> zzse = new n<>();

    static {
        AppMethodBeat.i(11825);
        AppMethodBeat.o(11825);
    }

    private ConnectionErrorMessages() {
    }

    public static String getAppName(Context context) {
        AppMethodBeat.i(11821);
        String packageName = context.getPackageName();
        try {
            String charSequence = Wrappers.packageManager(context).getApplicationLabel(packageName).toString();
            AppMethodBeat.o(11821);
            return charSequence;
        } catch (PackageManager.NameNotFoundException | NullPointerException e2) {
            String str = context.getApplicationInfo().name;
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(11821);
                return packageName;
            }
            AppMethodBeat.o(11821);
            return str;
        }
    }

    public static String getDefaultNotificationChannelName(Context context) {
        AppMethodBeat.i(11824);
        String string = context.getResources().getString(R.string.common_google_play_services_notification_channel_name);
        AppMethodBeat.o(11824);
        return string;
    }

    public static String getErrorDialogButtonMessage(Context context, int i2) {
        AppMethodBeat.i(11820);
        Resources resources = context.getResources();
        switch (i2) {
            case 1:
                String string = resources.getString(R.string.common_google_play_services_install_button);
                AppMethodBeat.o(11820);
                return string;
            case 2:
                String string2 = resources.getString(R.string.common_google_play_services_update_button);
                AppMethodBeat.o(11820);
                return string2;
            case 3:
                String string3 = resources.getString(R.string.common_google_play_services_enable_button);
                AppMethodBeat.o(11820);
                return string3;
            default:
                String string4 = resources.getString(17039370);
                AppMethodBeat.o(11820);
                return string4;
        }
    }

    public static String getErrorMessage(Context context, int i2) {
        AppMethodBeat.i(11818);
        Resources resources = context.getResources();
        String appName = getAppName(context);
        switch (i2) {
            case 1:
                String string = resources.getString(R.string.common_google_play_services_install_text, appName);
                AppMethodBeat.o(11818);
                return string;
            case 2:
                if (DeviceProperties.isWearableWithoutPlayStore(context)) {
                    String string2 = resources.getString(R.string.common_google_play_services_wear_update_text);
                    AppMethodBeat.o(11818);
                    return string2;
                }
                String string3 = resources.getString(R.string.common_google_play_services_update_text, appName);
                AppMethodBeat.o(11818);
                return string3;
            case 3:
                String string4 = resources.getString(R.string.common_google_play_services_enable_text, appName);
                AppMethodBeat.o(11818);
                return string4;
            case 4:
            case 6:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                String string5 = resources.getString(R.string.common_google_play_services_unknown_issue, appName);
                AppMethodBeat.o(11818);
                return string5;
            case 5:
                String zza = zza(context, "common_google_play_services_invalid_account_text", appName);
                AppMethodBeat.o(11818);
                return zza;
            case 7:
                String zza2 = zza(context, "common_google_play_services_network_error_text", appName);
                AppMethodBeat.o(11818);
                return zza2;
            case 9:
                String string6 = resources.getString(R.string.common_google_play_services_unsupported_text, appName);
                AppMethodBeat.o(11818);
                return string6;
            case 16:
                String zza3 = zza(context, "common_google_play_services_api_unavailable_text", appName);
                AppMethodBeat.o(11818);
                return zza3;
            case 17:
                String zza4 = zza(context, "common_google_play_services_sign_in_failed_text", appName);
                AppMethodBeat.o(11818);
                return zza4;
            case 18:
                String string7 = resources.getString(R.string.common_google_play_services_updating_text, appName);
                AppMethodBeat.o(11818);
                return string7;
            case 20:
                String zza5 = zza(context, "common_google_play_services_restricted_profile_text", appName);
                AppMethodBeat.o(11818);
                return zza5;
        }
    }

    public static String getErrorNotificationMessage(Context context, int i2) {
        AppMethodBeat.i(11819);
        if (i2 == 6) {
            String zza = zza(context, "common_google_play_services_resolution_required_text", getAppName(context));
            AppMethodBeat.o(11819);
            return zza;
        }
        String errorMessage = getErrorMessage(context, i2);
        AppMethodBeat.o(11819);
        return errorMessage;
    }

    public static String getErrorNotificationTitle(Context context, int i2) {
        AppMethodBeat.i(11817);
        String zzb = i2 == 6 ? zzb(context, "common_google_play_services_resolution_required_title") : getErrorTitle(context, i2);
        if (zzb == null) {
            zzb = context.getResources().getString(R.string.common_google_play_services_notification_ticker);
        }
        AppMethodBeat.o(11817);
        return zzb;
    }

    public static String getErrorTitle(Context context, int i2) {
        AppMethodBeat.i(11816);
        Resources resources = context.getResources();
        switch (i2) {
            case 1:
                String string = resources.getString(R.string.common_google_play_services_install_title);
                AppMethodBeat.o(11816);
                return string;
            case 2:
                String string2 = resources.getString(R.string.common_google_play_services_update_title);
                AppMethodBeat.o(11816);
                return string2;
            case 3:
                String string3 = resources.getString(R.string.common_google_play_services_enable_title);
                AppMethodBeat.o(11816);
                return string3;
            case 4:
            case 6:
            case 18:
                AppMethodBeat.o(11816);
                return null;
            case 5:
                String zzb = zzb(context, "common_google_play_services_invalid_account_title");
                AppMethodBeat.o(11816);
                return zzb;
            case 7:
                String zzb2 = zzb(context, "common_google_play_services_network_error_title");
                AppMethodBeat.o(11816);
                return zzb2;
            case 8:
                AppMethodBeat.o(11816);
                return null;
            case 9:
                AppMethodBeat.o(11816);
                return null;
            case 10:
                AppMethodBeat.o(11816);
                return null;
            case 11:
                AppMethodBeat.o(11816);
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                new StringBuilder(33).append("Unexpected error code ").append(i2);
                AppMethodBeat.o(11816);
                return null;
            case 16:
                AppMethodBeat.o(11816);
                return null;
            case 17:
                String zzb3 = zzb(context, "common_google_play_services_sign_in_failed_title");
                AppMethodBeat.o(11816);
                return zzb3;
            case 20:
                String zzb4 = zzb(context, "common_google_play_services_restricted_profile_title");
                AppMethodBeat.o(11816);
                return zzb4;
        }
    }

    private static String zza(Context context, String str, String str2) {
        AppMethodBeat.i(11822);
        Resources resources = context.getResources();
        String zzb = zzb(context, str);
        if (zzb == null) {
            zzb = resources.getString(R.string.common_google_play_services_unknown_issue);
        }
        String format = String.format(resources.getConfiguration().locale, zzb, str2);
        AppMethodBeat.o(11822);
        return format;
    }

    private static String zzb(Context context, String str) {
        AppMethodBeat.i(11823);
        synchronized (zzse) {
            try {
                String str2 = zzse.get(str);
                if (str2 != null) {
                    return str2;
                }
                Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
                if (remoteResource == null) {
                    AppMethodBeat.o(11823);
                    return null;
                }
                int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
                if (identifier == 0) {
                    String valueOf = String.valueOf(str);
                    if (valueOf.length() != 0) {
                        "Missing resource: ".concat(valueOf);
                    } else {
                        new String("Missing resource: ");
                    }
                    AppMethodBeat.o(11823);
                    return null;
                }
                String string = remoteResource.getString(identifier);
                if (TextUtils.isEmpty(string)) {
                    String valueOf2 = String.valueOf(str);
                    if (valueOf2.length() != 0) {
                        "Got empty resource: ".concat(valueOf2);
                    } else {
                        new String("Got empty resource: ");
                    }
                    AppMethodBeat.o(11823);
                    return null;
                }
                zzse.put(str, string);
                AppMethodBeat.o(11823);
                return string;
            } finally {
                AppMethodBeat.o(11823);
            }
        }
    }
}
