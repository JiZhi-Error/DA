package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.k;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

public final class CacheManager extends z {
    @Deprecated
    public static File getCacheFileBaseDir() {
        AppMethodBeat.i(55083);
        if (isX5Core()) {
            File cacheFileBaseDir = getCacheManagerImpl().getCacheFileBaseDir();
            AppMethodBeat.o(55083);
            return cacheFileBaseDir;
        }
        File file = (File) k.a("android.webkit.CacheManager", "getCacheFileBaseDir");
        AppMethodBeat.o(55083);
        return file;
    }

    @Deprecated
    public static boolean cacheDisabled() {
        AppMethodBeat.i(55084);
        if (isX5Core()) {
            boolean cacheDisabled = getCacheManagerImpl().cacheDisabled();
            AppMethodBeat.o(55084);
            return cacheDisabled;
        }
        Object a2 = k.a("android.webkit.CacheManager", "cacheDisabled");
        if (a2 == null) {
            AppMethodBeat.o(55084);
            return false;
        }
        boolean booleanValue = ((Boolean) a2).booleanValue();
        AppMethodBeat.o(55084);
        return booleanValue;
    }

    public static Object getCacheFile(String str, Map<String, String> map) {
        AppMethodBeat.i(55085);
        if (isX5Core()) {
            File cacheFileBaseDir = getCacheManagerImpl().getCacheFileBaseDir();
            AppMethodBeat.o(55085);
            return cacheFileBaseDir;
        }
        try {
            Object a2 = k.a(Class.forName("android.webkit.CacheManager"), "getCacheFile", (Class<?>[]) new Class[]{String.class, Map.class}, str, map);
            AppMethodBeat.o(55085);
            return a2;
        } catch (Exception e2) {
            AppMethodBeat.o(55085);
            return null;
        }
    }

    public static InputStream getCacheFile(String str, boolean z) {
        AppMethodBeat.i(55086);
        if (isX5Core()) {
            InputStream cacheFile = getCacheManagerImpl().getCacheFile(str, z);
            AppMethodBeat.o(55086);
            return cacheFile;
        }
        AppMethodBeat.o(55086);
        return null;
    }
}
