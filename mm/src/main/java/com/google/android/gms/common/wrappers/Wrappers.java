package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Wrappers {
    private static Wrappers zzabb = new Wrappers();
    private PackageManagerWrapper zzaba = null;

    static {
        AppMethodBeat.i(5351);
        AppMethodBeat.o(5351);
    }

    public static PackageManagerWrapper packageManager(Context context) {
        AppMethodBeat.i(5350);
        PackageManagerWrapper packageManagerWrapper = zzabb.getPackageManagerWrapper(context);
        AppMethodBeat.o(5350);
        return packageManagerWrapper;
    }

    @VisibleForTesting
    public static void resetForTests() {
        AppMethodBeat.i(5349);
        zzabb = new Wrappers();
        AppMethodBeat.o(5349);
    }

    public static void setWrappers(Wrappers wrappers) {
        zzabb = wrappers;
    }

    @VisibleForTesting
    public synchronized PackageManagerWrapper getPackageManagerWrapper(Context context) {
        PackageManagerWrapper packageManagerWrapper;
        AppMethodBeat.i(5348);
        if (this.zzaba == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzaba = new PackageManagerWrapper(context);
        }
        packageManagerWrapper = this.zzaba;
        AppMethodBeat.o(5348);
        return packageManagerWrapper;
    }
}
