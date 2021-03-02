package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class XWalkPreferences {
    public static final String ALLOW_UNIVERSAL_ACCESS_FROM_FILE = "allow-universal-access-from-file";
    public static final String ANIMATABLE_XWALK_VIEW = "animatable-xwalk-view";
    public static final String ENABLE_EXTENSIONS = "enable-extensions";
    public static final String ENABLE_JAVASCRIPT = "enable-javascript";
    public static final String ENABLE_THEME_COLOR = "enable-theme-color";
    public static final String JAVASCRIPT_CAN_OPEN_WINDOW = "javascript-can-open-window";
    public static final String PROFILE_NAME = "profile-name";
    public static final String REMOTE_DEBUGGING = "remote-debugging";
    public static final String SPATIAL_NAVIGATION = "enable-spatial-navigation";
    public static final String SUPPORT_MULTIPLE_WINDOWS = "support-multiple-windows";
    public static final String XWEBSDK_VERSION = "xwebsdk-version";
    public static final String XWEB_VERSION = "xweb-version";
    private static XWalkCoreWrapper coreWrapper;
    private static ReflectMethod getBooleanValueStringMethod = new ReflectMethod((Class<?>) null, "getBooleanValue", (Class<?>[]) new Class[0]);
    private static ReflectMethod getIntegerValueStringMethod = new ReflectMethod((Class<?>) null, "getIntegerValue", (Class<?>[]) new Class[0]);
    private static ReflectMethod getStringValueStringMethod = new ReflectMethod((Class<?>) null, "getStringValue", (Class<?>[]) new Class[0]);
    private static ReflectMethod getValueStringMethod = new ReflectMethod((Class<?>) null, "getValue", (Class<?>[]) new Class[0]);
    private static ReflectMethod setValueStringStringMethod = new ReflectMethod((Class<?>) null, "setValue", (Class<?>[]) new Class[0]);
    private static ReflectMethod setValueStringbooleanMethod = new ReflectMethod((Class<?>) null, "setValue", (Class<?>[]) new Class[0]);
    private static ReflectMethod setValueStringintMethod = new ReflectMethod((Class<?>) null, "setValue", (Class<?>[]) new Class[0]);

    public static void setValue(String str, boolean z) {
        AppMethodBeat.i(154829);
        reflectionInit();
        try {
            setValueStringbooleanMethod.invoke(str, Boolean.valueOf(z));
            AppMethodBeat.o(154829);
        } catch (UnsupportedOperationException e2) {
            if (coreWrapper == null) {
                setValueStringbooleanMethod.setArguments(str, Boolean.valueOf(z));
                XWalkCoreWrapper.reserveReflectMethod(setValueStringbooleanMethod);
                AppMethodBeat.o(154829);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154829);
        }
    }

    static {
        AppMethodBeat.i(154837);
        AppMethodBeat.o(154837);
    }

    public static void setValue(String str, int i2) {
        AppMethodBeat.i(154830);
        reflectionInit();
        try {
            setValueStringintMethod.invoke(str, Integer.valueOf(i2));
            AppMethodBeat.o(154830);
        } catch (UnsupportedOperationException e2) {
            if (coreWrapper == null) {
                setValueStringintMethod.setArguments(str, Integer.valueOf(i2));
                XWalkCoreWrapper.reserveReflectMethod(setValueStringintMethod);
                AppMethodBeat.o(154830);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154830);
        }
    }

    public static void setValue(String str, String str2) {
        AppMethodBeat.i(154831);
        reflectionInit();
        try {
            setValueStringStringMethod.invoke(str, str2);
            AppMethodBeat.o(154831);
        } catch (UnsupportedOperationException e2) {
            if (coreWrapper == null) {
                setValueStringStringMethod.setArguments(str, str2);
                XWalkCoreWrapper.reserveReflectMethod(setValueStringStringMethod);
                AppMethodBeat.o(154831);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154831);
        }
    }

    public static boolean getValue(String str) {
        AppMethodBeat.i(154832);
        reflectionInit();
        try {
            boolean booleanValue = ((Boolean) getValueStringMethod.invoke(str)).booleanValue();
            AppMethodBeat.o(154832);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154832);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154832);
            return false;
        }
    }

    public static boolean getBooleanValue(String str) {
        AppMethodBeat.i(154833);
        reflectionInit();
        try {
            boolean booleanValue = ((Boolean) getBooleanValueStringMethod.invoke(str)).booleanValue();
            AppMethodBeat.o(154833);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154833);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154833);
            return false;
        }
    }

    public static int getIntegerValue(String str) {
        AppMethodBeat.i(154834);
        reflectionInit();
        try {
            int intValue = ((Integer) getIntegerValueStringMethod.invoke(str)).intValue();
            AppMethodBeat.o(154834);
            return intValue;
        } catch (UnsupportedOperationException e2) {
            if (coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154834);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154834);
            return 0;
        }
    }

    public static String getStringValue(String str) {
        AppMethodBeat.i(154835);
        reflectionInit();
        try {
            String str2 = (String) getStringValueStringMethod.invoke(str);
            AppMethodBeat.o(154835);
            return str2;
        } catch (UnsupportedOperationException e2) {
            if (coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154835);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154835);
            return null;
        }
    }

    static void reflectionInit() {
        AppMethodBeat.i(154836);
        if (coreWrapper != null) {
            AppMethodBeat.o(154836);
            return;
        }
        XWalkCoreWrapper.initEmbeddedMode();
        XWalkCoreWrapper instance = XWalkCoreWrapper.getInstance();
        coreWrapper = instance;
        if (instance == null) {
            XWalkCoreWrapper.reserveReflectClass(XWalkPreferences.class);
            AppMethodBeat.o(154836);
            return;
        }
        Class<?> bridgeClass = coreWrapper.getBridgeClass("XWalkPreferencesBridge");
        setValueStringbooleanMethod.init(null, bridgeClass, "setValue", String.class, Boolean.TYPE);
        setValueStringintMethod.init(null, bridgeClass, "setValue", String.class, Integer.TYPE);
        setValueStringStringMethod.init(null, bridgeClass, "setValue", String.class, String.class);
        getValueStringMethod.init(null, bridgeClass, "getValue", String.class);
        getBooleanValueStringMethod.init(null, bridgeClass, "getBooleanValue", String.class);
        getIntegerValueStringMethod.init(null, bridgeClass, "getIntegerValue", String.class);
        getStringValueStringMethod.init(null, bridgeClass, "getStringValue", String.class);
        AppMethodBeat.o(154836);
    }
}
