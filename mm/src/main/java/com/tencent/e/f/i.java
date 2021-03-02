package com.tencent.e.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.e.e.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i {
    public static a cU(Context context, String str) {
        AppMethodBeat.i(138484);
        a aVar = new a();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            aVar.pkgName = str;
            aVar.versionName = packageInfo.versionName;
            aVar.versionCode = packageInfo.versionCode;
        } catch (Throwable th) {
        }
        AppMethodBeat.o(138484);
        return aVar;
    }
}
