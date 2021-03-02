package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.concurrent.GuardedBy;

public class MetadataValueReader {
    public static final String KEY_METADATA_APP_ID = "com.google.app.id";
    private static Object sLock = new Object();
    @GuardedBy("sLock")
    private static boolean zzui;
    private static String zzuj;
    private static int zzuk;

    static {
        AppMethodBeat.i(4704);
        AppMethodBeat.o(4704);
    }

    public static String getGoogleAppId(Context context) {
        AppMethodBeat.i(4701);
        zze(context);
        String str = zzuj;
        AppMethodBeat.o(4701);
        return str;
    }

    public static int getGooglePlayServicesVersion(Context context) {
        AppMethodBeat.i(4702);
        zze(context);
        int i2 = zzuk;
        AppMethodBeat.o(4702);
        return i2;
    }

    @VisibleForTesting
    public static void resetForTesting() {
        synchronized (sLock) {
            zzui = false;
        }
    }

    @VisibleForTesting
    public static void setValuesForTesting(String str, int i2) {
        synchronized (sLock) {
            zzuj = str;
            zzuk = i2;
            zzui = true;
        }
    }

    private static void zze(Context context) {
        AppMethodBeat.i(4703);
        synchronized (sLock) {
            try {
                if (!zzui) {
                    zzui = true;
                    try {
                        Bundle bundle = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
                        if (bundle == null) {
                            AppMethodBeat.o(4703);
                            return;
                        }
                        zzuj = bundle.getString(KEY_METADATA_APP_ID);
                        zzuk = bundle.getInt(GooglePlayServicesUtilLight.KEY_METADATA_GOOGLE_PLAY_SERVICES_VERSION);
                        AppMethodBeat.o(4703);
                    } catch (PackageManager.NameNotFoundException e2) {
                        Log.wtf("MetadataValueReader", "This should never happen.", e2);
                    }
                }
            } finally {
                AppMethodBeat.o(4703);
            }
        }
    }
}
