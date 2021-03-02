package org.tensorflow.lite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.tensorflow.lite.a.a;

public final class TensorFlowLite {
    private static final Throwable Ujv;
    private static volatile boolean isInit = false;

    public static native String nativeRuntimeVersion();

    public static native String nativeSchemaVersion();

    static {
        AppMethodBeat.i(238988);
        if (!a.Ujx.value) {
            Ujv = new Throwable("Wechat is not ready for TensorFlow!!! it maybe load Library error");
            AppMethodBeat.o(238988);
            return;
        }
        Ujv = null;
        AppMethodBeat.o(238988);
    }

    private TensorFlowLite() {
    }

    public static String hQt() {
        AppMethodBeat.i(238986);
        init();
        String nativeRuntimeVersion = nativeRuntimeVersion();
        AppMethodBeat.o(238986);
        return nativeRuntimeVersion;
    }

    public static void init() {
        AppMethodBeat.i(238987);
        if (isInit) {
            AppMethodBeat.o(238987);
            return;
        }
        try {
            nativeRuntimeVersion();
            isInit = true;
            AppMethodBeat.o(238987);
        } catch (UnsatisfiedLinkError e2) {
            e = e2;
            if (Ujv != null) {
                e = Ujv;
            }
            UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Failed to load native TensorFlow Lite methods. Check that the correct native libraries are present, and, if using a custom native library, have been properly loaded via System.loadLibrary():\n  ".concat(String.valueOf(e)));
            AppMethodBeat.o(238987);
            throw unsatisfiedLinkError;
        }
    }
}
