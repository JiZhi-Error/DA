package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static final Object sLock = new Object();
    private static final GoogleApiAvailabilityLight zzacw = GoogleApiAvailabilityLight.getInstance();
    private static Method zzacx = null;

    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i2, Intent intent);

        void onProviderInstalled();
    }

    static {
        AppMethodBeat.i(5526);
        AppMethodBeat.o(5526);
    }

    public static void installIfNeeded(Context context) {
        AppMethodBeat.i(5524);
        Preconditions.checkNotNull(context, "Context must not be null");
        zzacw.verifyGooglePlayServicesIsAvailable(context, 11925000);
        try {
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext == null) {
                Log.isLoggable("ProviderInstaller", 6);
                GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException = new GooglePlayServicesNotAvailableException(8);
                AppMethodBeat.o(5524);
                throw googlePlayServicesNotAvailableException;
            }
            synchronized (sLock) {
                try {
                    if (zzacx == null) {
                        zzacx = remoteContext.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", Context.class);
                    }
                    zzacx.invoke(null, remoteContext);
                    try {
                    } catch (Throwable th) {
                        AppMethodBeat.o(5524);
                        throw th;
                    }
                } catch (Exception e2) {
                    Throwable cause = e2.getCause();
                    if (Log.isLoggable("ProviderInstaller", 6)) {
                        String valueOf = String.valueOf(cause == null ? e2.getMessage() : cause.getMessage());
                        if (valueOf.length() != 0) {
                            "Failed to install provider: ".concat(valueOf);
                        } else {
                            new String("Failed to install provider: ");
                        }
                    }
                    GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException2 = new GooglePlayServicesNotAvailableException(8);
                    AppMethodBeat.o(5524);
                    throw googlePlayServicesNotAvailableException2;
                }
            }
            AppMethodBeat.o(5524);
        } catch (Resources.NotFoundException e3) {
            Log.isLoggable("ProviderInstaller", 6);
            GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException3 = new GooglePlayServicesNotAvailableException(8);
            AppMethodBeat.o(5524);
            throw googlePlayServicesNotAvailableException3;
        }
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener providerInstallListener) {
        AppMethodBeat.i(5525);
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(providerInstallListener, "Listener must not be null");
        Preconditions.checkMainThread("Must be called on the UI thread");
        new zza(context, providerInstallListener).execute(new Void[0]);
        AppMethodBeat.o(5525);
    }
}
