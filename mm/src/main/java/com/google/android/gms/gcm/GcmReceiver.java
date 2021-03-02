package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.iid.zzk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;

@Deprecated
public class GcmReceiver extends WakefulBroadcastReceiver {
    private static boolean zzq = false;
    private static zzk zzr;
    private static zzk zzs;

    private final synchronized zzk zzd(Context context, String str) {
        zzk zzk;
        AppMethodBeat.i(3629);
        if ("com.google.android.c2dm.intent.RECEIVE".equals(str)) {
            if (zzs == null) {
                zzs = new zzk(context, str);
            }
            zzk = zzs;
            AppMethodBeat.o(3629);
        } else {
            if (zzr == null) {
                zzr = new zzk(context, str);
            }
            zzk = zzr;
            AppMethodBeat.o(3629);
        }
        return zzk;
    }

    private final void zzd(Context context, Intent intent) {
        AppMethodBeat.i(3630);
        if (isOrderedBroadcast()) {
            setResultCode(500);
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (!(resolveService == null || resolveService.serviceInfo == null)) {
            ServiceInfo serviceInfo = resolveService.serviceInfo;
            if (!context.getPackageName().equals(serviceInfo.packageName) || serviceInfo.name == null) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                new StringBuilder(String.valueOf(str).length() + 94 + String.valueOf(str2).length()).append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ").append(str).append(FilePathGenerator.ANDROID_DIR_SEP).append(str2);
            } else {
                String str3 = serviceInfo.name;
                if (str3.startsWith(".")) {
                    String valueOf = String.valueOf(context.getPackageName());
                    String valueOf2 = String.valueOf(str3);
                    str3 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                }
                if (Log.isLoggable("GcmReceiver", 3)) {
                    String valueOf3 = String.valueOf(str3);
                    if (valueOf3.length() != 0) {
                        "Restricting intent to a specific service: ".concat(valueOf3);
                    } else {
                        new String("Restricting intent to a specific service: ");
                    }
                }
                intent.setClassName(context.getPackageName(), str3);
            }
        }
        try {
            if ((context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0 ? startWakefulService(context, intent) : context.startService(intent)) == null) {
                if (isOrderedBroadcast()) {
                    setResultCode(404);
                    AppMethodBeat.o(3630);
                    return;
                }
            } else if (isOrderedBroadcast()) {
                setResultCode(-1);
            }
            AppMethodBeat.o(3630);
        } catch (SecurityException e2) {
            if (isOrderedBroadcast()) {
                setResultCode(401);
            }
            AppMethodBeat.o(3630);
        }
    }

    public void onReceive(Context context, Intent intent) {
        boolean z = false;
        AppMethodBeat.i(3628);
        Log.isLoggable("GcmReceiver", 3);
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (Build.VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        if ("google.com/iid".equals(intent.getStringExtra("from"))) {
            intent.setAction("com.google.android.gms.iid.InstanceID");
        }
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        if (PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26) {
            z = true;
        }
        if (z) {
            if (isOrderedBroadcast()) {
                setResultCode(-1);
            }
            zzd(context, intent.getAction()).zzd(intent, goAsync());
            AppMethodBeat.o(3628);
            return;
        }
        "com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction());
        zzd(context, intent);
        if (isOrderedBroadcast() && getResultCode() == 0) {
            setResultCode(-1);
        }
        AppMethodBeat.o(3628);
    }
}
