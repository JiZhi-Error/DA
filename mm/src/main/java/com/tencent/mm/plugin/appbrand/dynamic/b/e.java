package com.tencent.mm.plugin.appbrand.dynamic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e {
    private static volatile e lmX;
    private Map<String, SoftReference<WxaPkgWrappingInfo>> mMap = new ConcurrentHashMap();

    private static e bBY() {
        AppMethodBeat.i(121270);
        if (lmX == null) {
            synchronized (e.class) {
                try {
                    if (lmX == null) {
                        lmX = new e();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(121270);
                    throw th;
                }
            }
        }
        e eVar = lmX;
        AppMethodBeat.o(121270);
        return eVar;
    }

    private e() {
        AppMethodBeat.i(121271);
        AppMethodBeat.o(121271);
    }

    public static boolean b(String str, WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        AppMethodBeat.i(121272);
        if (str == null || str.length() == 0 || wxaPkgWrappingInfo == null) {
            AppMethodBeat.o(121272);
            return false;
        }
        bBY().mMap.put(str, new SoftReference<>(wxaPkgWrappingInfo));
        AppMethodBeat.o(121272);
        return true;
    }

    public static WxaPkgWrappingInfo Yu(String str) {
        AppMethodBeat.i(121273);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(121273);
            return null;
        }
        SoftReference<WxaPkgWrappingInfo> softReference = bBY().mMap.get(str);
        if (softReference != null) {
            WxaPkgWrappingInfo wxaPkgWrappingInfo = softReference.get();
            AppMethodBeat.o(121273);
            return wxaPkgWrappingInfo;
        }
        AppMethodBeat.o(121273);
        return null;
    }

    public static void removeAll() {
        AppMethodBeat.i(121274);
        bBY().mMap.clear();
        AppMethodBeat.o(121274);
    }
}
