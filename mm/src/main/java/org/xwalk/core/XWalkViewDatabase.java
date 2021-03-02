package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class XWalkViewDatabase {
    private static ReflectMethod clearFormDataMethod = new ReflectMethod((Class<?>) null, "clearFormData", (Class<?>[]) new Class[0]);
    private static XWalkCoreWrapper coreWrapper;
    private static ReflectMethod hasFormDataMethod = new ReflectMethod((Class<?>) null, "hasFormData", (Class<?>[]) new Class[0]);

    public static boolean hasFormData() {
        AppMethodBeat.i(155159);
        reflectionInit();
        try {
            boolean booleanValue = ((Boolean) hasFormDataMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(155159);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155159);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155159);
            return false;
        }
    }

    static {
        AppMethodBeat.i(155162);
        AppMethodBeat.o(155162);
    }

    public static void clearFormData() {
        AppMethodBeat.i(155160);
        reflectionInit();
        try {
            clearFormDataMethod.invoke(new Object[0]);
            AppMethodBeat.o(155160);
        } catch (UnsupportedOperationException e2) {
            if (coreWrapper == null) {
                clearFormDataMethod.setArguments(new Object[0]);
                XWalkCoreWrapper.reserveReflectMethod(clearFormDataMethod);
                AppMethodBeat.o(155160);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155160);
        }
    }

    static void reflectionInit() {
        AppMethodBeat.i(155161);
        if (coreWrapper != null) {
            AppMethodBeat.o(155161);
            return;
        }
        XWalkCoreWrapper.initEmbeddedMode();
        XWalkCoreWrapper instance = XWalkCoreWrapper.getInstance();
        coreWrapper = instance;
        if (instance == null) {
            XWalkCoreWrapper.reserveReflectClass(XWalkViewDatabase.class);
            AppMethodBeat.o(155161);
            return;
        }
        Class<?> bridgeClass = coreWrapper.getBridgeClass("XWalkViewDatabaseBridge");
        hasFormDataMethod.init(null, bridgeClass, "hasFormData", new Class[0]);
        clearFormDataMethod.init(null, bridgeClass, "clearFormData", new Class[0]);
        AppMethodBeat.o(155161);
    }
}
