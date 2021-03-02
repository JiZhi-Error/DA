package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.concurrent.GuardedBy;

public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver {
    private static boolean bLo = false;
    @GuardedBy("FirebaseInstanceIdReceiver.class")
    private static y bLp;
    @GuardedBy("FirebaseInstanceIdReceiver.class")
    private static y bLq;

    private final void a(Context context, Intent intent, String str) {
        String str2 = null;
        boolean z = false;
        int i2 = -1;
        AppMethodBeat.i(4144);
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (Build.VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        if ("google.com/iid".equals(intent.getStringExtra("from")) || "com.google.firebase.INSTANCE_ID_EVENT".equals(str)) {
            str2 = "com.google.firebase.INSTANCE_ID_EVENT";
        } else if ("com.google.android.c2dm.intent.RECEIVE".equals(str) || "com.google.firebase.MESSAGING_EVENT".equals(str)) {
            str2 = "com.google.firebase.MESSAGING_EVENT";
        }
        if (str2 != null) {
            if (PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26) {
                z = true;
            }
            if (z) {
                if (isOrderedBroadcast()) {
                    setResultCode(-1);
                }
                i(context, str2).a(intent, goAsync());
            } else {
                i2 = o.yr().a(context, str2, intent);
            }
        }
        if (isOrderedBroadcast()) {
            setResultCode(i2);
        }
        AppMethodBeat.o(4144);
    }

    private static synchronized y i(Context context, String str) {
        y yVar;
        synchronized (FirebaseInstanceIdReceiver.class) {
            AppMethodBeat.i(4145);
            if ("com.google.firebase.MESSAGING_EVENT".equals(str)) {
                if (bLq == null) {
                    bLq = new y(context, str);
                }
                yVar = bLq;
                AppMethodBeat.o(4145);
            } else {
                if (bLp == null) {
                    bLp = new y(context, str);
                }
                yVar = bLp;
                AppMethodBeat.o(4145);
            }
        }
        return yVar;
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(4143);
        if (intent == null) {
            AppMethodBeat.o(4143);
            return;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
        if (parcelableExtra instanceof Intent) {
            a(context, (Intent) parcelableExtra, intent.getAction());
            AppMethodBeat.o(4143);
            return;
        }
        a(context, intent, intent.getAction());
        AppMethodBeat.o(4143);
    }
}
