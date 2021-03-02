package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class UidVerifier {
    private UidVerifier() {
    }

    public static boolean isGooglePlayServicesUid(Context context, int i2) {
        AppMethodBeat.i(5297);
        if (!uidHasPackageName(context, i2, "com.google.android.gms")) {
            AppMethodBeat.o(5297);
            return false;
        }
        try {
            boolean isGooglePublicSignedPackage = GoogleSignatureVerifier.getInstance(context).isGooglePublicSignedPackage(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
            AppMethodBeat.o(5297);
            return isGooglePublicSignedPackage;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.isLoggable("UidVerifier", 3);
            AppMethodBeat.o(5297);
            return false;
        }
    }

    @TargetApi(19)
    public static boolean uidHasPackageName(Context context, int i2, String str) {
        AppMethodBeat.i(5298);
        boolean uidHasPackageName = Wrappers.packageManager(context).uidHasPackageName(i2, str);
        AppMethodBeat.o(5298);
        return uidHasPackageName;
    }
}
