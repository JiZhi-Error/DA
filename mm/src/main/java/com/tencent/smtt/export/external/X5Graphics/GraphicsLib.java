package com.tencent.smtt.export.external.X5Graphics;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.LibraryLoader;
import com.tencent.smtt.export.external.X5Graphics.X5Graphics;
import java.io.File;
import java.util.HashMap;

public class GraphicsLib {
    public static final int LOAD_STATUS_FAIL = 1;
    public static final int LOAD_STATUS_GRAPHICS_LINK_ERR = 3;
    public static final int LOAD_STATUS_WEBP_LINK_ERR = 2;
    private static final String LOGTAG = "[X5Graphics]";
    private static String sGraphicsLibPath = null;
    private static boolean sHasSetGraphicsPath = false;
    private static String sSharpPLibPath = null;
    private static X5Graphics.SoThinker sThinker = null;
    private static boolean sWebpLibIsLoadSuccess = false;

    private static native void nativeSetGraphicsLibPath(String str);

    private static native void nativeSetSharpPLibPath(String str);

    public static boolean init(Context context, String str, X5Graphics.SoThinker soThinker, X5Graphics.IBeacon iBeacon) {
        boolean loadWepLibraryIfNeed;
        HashMap<String, String> hashMap;
        AppMethodBeat.i(53164);
        new StringBuilder("init()  path=").append(str).append(" ;thinker=").append(soThinker);
        if (!X5Graphics.isEnable()) {
            Error error = new Error("X5Graphics is diable");
            AppMethodBeat.o(53164);
            throw error;
        }
        sThinker = soThinker;
        if (str != null) {
            loadWepLibraryIfNeed = loadWepLibraryIfNeed(context, str);
        } else {
            str = LibraryLoader.getNativeLibraryDir(context);
            loadWepLibraryIfNeed = loadWepLibraryIfNeed(context);
        }
        if (loadWepLibraryIfNeed) {
            try {
                setGraphicsLibPath(str);
            } catch (Throwable th) {
                hashMap.put("status", Integer.toString(2));
            }
        } else {
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("status", Integer.toString(1));
            if (iBeacon != null) {
                iBeacon.report("X5Graphics", hashMap2);
            }
        }
        AppMethodBeat.o(53164);
        return loadWepLibraryIfNeed;
        if (iBeacon != null) {
            iBeacon.report("X5Graphics", hashMap);
        }
        AppMethodBeat.o(53164);
        throw th;
    }

    public static boolean init(Context context, String str) {
        AppMethodBeat.i(53165);
        boolean init = init(context, str, null, null);
        AppMethodBeat.o(53165);
        return init;
    }

    private static void setGraphicsLibPath(String str) {
        AppMethodBeat.i(53166);
        sGraphicsLibPath = str;
        if (X5Graphics.isEnable()) {
            nativeSetGraphicsLibPath(sGraphicsLibPath);
            sHasSetGraphicsPath = true;
            if (sSharpPLibPath != null && !sSharpPLibPath.isEmpty()) {
                nativeSetSharpPLibPath(sSharpPLibPath);
            }
        }
        AppMethodBeat.o(53166);
    }

    public static void setSharpPPath(String str) {
        AppMethodBeat.i(53167);
        sSharpPLibPath = str;
        if (str != null && !sSharpPLibPath.isEmpty() && sHasSetGraphicsPath) {
            new StringBuilder("setSharpPPath()  will  nativeSet  sSharpPLibPath=").append(sSharpPLibPath);
            nativeSetSharpPLibPath(sSharpPLibPath);
        }
        AppMethodBeat.o(53167);
    }

    public static String getGraphicsLibPath() {
        return sGraphicsLibPath;
    }

    public static String getThinkerLibPath(String str) {
        AppMethodBeat.i(53168);
        String str2 = null;
        if (sThinker != null) {
            str2 = sThinker.path(str + File.separator + "libwebp_base.so");
        }
        AppMethodBeat.o(53168);
        return str2;
    }

    public static boolean loadWepLibraryIfNeed(Context context, String str) {
        AppMethodBeat.i(53169);
        if (sWebpLibIsLoadSuccess) {
            boolean z = sWebpLibIsLoadSuccess;
            AppMethodBeat.o(53169);
            return z;
        }
        synchronized (GraphicsLib.class) {
            try {
                if (sWebpLibIsLoadSuccess) {
                    return sWebpLibIsLoadSuccess;
                }
                String str2 = null;
                try {
                    if (sThinker != null) {
                        str2 = sThinker.path(str + File.separator + "libwebp_base.so");
                    }
                    if (str2 == null || TextUtils.isEmpty(str2)) {
                        System.load(str + File.separator + "libwebp_base.so");
                    } else {
                        System.load(str2);
                    }
                    sWebpLibIsLoadSuccess = true;
                    if (getGraphicsLibPath() == null) {
                        setGraphicsLibPath(str);
                    }
                } catch (UnsatisfiedLinkError e2) {
                    new StringBuilder("Load WebP Library Error...: libwebp.java - loadWepLibraryIfNeed()").append(e2.getMessage());
                }
                boolean z2 = sWebpLibIsLoadSuccess;
                AppMethodBeat.o(53169);
                return z2;
            } finally {
                AppMethodBeat.o(53169);
            }
        }
    }

    public static boolean loadWepLibraryIfNeed(Context context) {
        AppMethodBeat.i(53170);
        if (sWebpLibIsLoadSuccess) {
            boolean z = sWebpLibIsLoadSuccess;
            AppMethodBeat.o(53170);
            return z;
        }
        synchronized (GraphicsLib.class) {
            try {
                if (sWebpLibIsLoadSuccess) {
                    return sWebpLibIsLoadSuccess;
                }
                try {
                    LibraryLoader.loadLibrary(context, "webp_base");
                    sWebpLibIsLoadSuccess = true;
                    if (getGraphicsLibPath() == null) {
                        setGraphicsLibPath(LibraryLoader.getNativeLibraryDir(context));
                    }
                } catch (UnsatisfiedLinkError e2) {
                }
                boolean z2 = sWebpLibIsLoadSuccess;
                AppMethodBeat.o(53170);
                return z2;
            } finally {
                AppMethodBeat.o(53170);
            }
        }
    }
}
