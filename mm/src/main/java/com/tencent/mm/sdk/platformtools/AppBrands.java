package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

public final class AppBrands {
    private static Callable<AppBrandAppInfo> sAppBrandInfoGetterSupplier = new Callable<AppBrandAppInfo>() {
        /* class com.tencent.mm.sdk.platformtools.AppBrands.AnonymousClass1 */

        @Override // java.util.concurrent.Callable
        public final AppBrandAppInfo call() {
            return null;
        }
    };

    public static final class AppBrandAppInfo {
        public String appId;
        public String appName;
        public int appType;
        public int appVersion;
    }

    static {
        AppMethodBeat.i(200837);
        AppMethodBeat.o(200837);
    }

    public static boolean isAppBrandProc() {
        AppMethodBeat.i(200835);
        boolean isAppBrandProcess = MMApplicationContext.isAppBrandProcess();
        AppMethodBeat.o(200835);
        return isAppBrandProcess;
    }

    public static AppBrandAppInfo getAppBrandInfo() {
        AppMethodBeat.i(200836);
        try {
            AppBrandAppInfo call = sAppBrandInfoGetterSupplier.call();
            AppMethodBeat.o(200836);
            return call;
        } catch (Exception e2) {
            AppMethodBeat.o(200836);
            return null;
        }
    }

    public static void setAppBrandInfoGetterSupplier(Callable<AppBrandAppInfo> callable) {
        sAppBrandInfoGetterSupplier = callable;
    }
}
