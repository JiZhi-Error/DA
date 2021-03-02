package com.tencent.mm.plugin.appbrand.ac;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b {
    public static PackageInfo getPackageInfo(Context context, String str) {
        PackageInfo packageInfo = null;
        AppMethodBeat.i(140800);
        if (str == null) {
            Log.e("Luggage.AndroidPackageUtil", "getPackageInfo fail, packageName is null");
            AppMethodBeat.o(140800);
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                AppMethodBeat.o(140800);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.w("Luggage.AndroidPackageUtil", e2.getMessage());
                AppMethodBeat.o(140800);
            }
        }
        return packageInfo;
    }

    public static String eM(String str, String str2) {
        AppMethodBeat.i(221346);
        try {
            str2 = MMApplicationContext.getContext().getPackageManager().getApplicationInfo(MMApplicationContext.getContext().getPackageName(), 128).metaData.getString(str, str2);
            AppMethodBeat.o(221346);
        } catch (PackageManager.NameNotFoundException e2) {
            Log.printDebugStack("Luggage.AndroidPackageUtil", "", e2);
            AppMethodBeat.o(221346);
        }
        return str2;
    }
}
