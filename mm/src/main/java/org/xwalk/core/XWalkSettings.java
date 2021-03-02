package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Map;

public class XWalkSettings {
    public static final int InvokeChannel_func_id_log = 30002;
    public static final int InvokeChannel_func_native_trans = 30003;
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NO_CACHE = 2;
    private LazyReflectMethod InvokeChannelInternalMethod = new LazyReflectMethod((Class<?>) null, "InvokeChannel", (Class<?>[]) new Class[0]);
    private LazyReflectMethod SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod = new LazyReflectMethod((Class<?>) null, "SetJSExceptionCallBack", (Class<?>[]) new Class[0]);
    private LazyReflectMethod SetLogCallBackXWalkLogMessageListenerInternalMethod = new LazyReflectMethod((Class<?>) null, "SetLogCallBack", (Class<?>[]) new Class[0]);
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private LazyReflectMethod disableCustomizedLongPressTimeoutVoidMethod = new LazyReflectMethod((Class<?>) null, "disableCustomizedLongPressTimeout", (Class<?>[]) new Class[0]);
    private LazyReflectMethod enableCustomizedLongPressTimeoutIntMethod = new LazyReflectMethod((Class<?>) null, "enableCustomizedLongPressTimeout", (Class<?>[]) new Class[0]);
    private LazyReflectMethod enumLayoutAlgorithmClassValueOfMethod = new LazyReflectMethod();
    private LazyReflectMethod getAcceptLanguagesMethod = new LazyReflectMethod((Class<?>) null, "getAcceptLanguages", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getAllowContentAccessMethod = new LazyReflectMethod((Class<?>) null, "getAllowContentAccess", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getAllowFileAccessFromFileURLsMethod = new LazyReflectMethod((Class<?>) null, "getAllowFileAccessFromFileURLs", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getAllowFileAccessMethod = new LazyReflectMethod((Class<?>) null, "getAllowFileAccess", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getAllowUniversalAccessFromFileURLsMethod = new LazyReflectMethod((Class<?>) null, "getAllowUniversalAccessFromFileURLs", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getAppBrandInfoMethod = new LazyReflectMethod((Class<?>) null, "getAppBrandInfoSuper", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getAudioPlaybackRequiresUserGestureMethod = new LazyReflectMethod((Class<?>) null, "getAudioPlaybackRequiresUserGesture", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getBackgroundAudioPauseMethod = new LazyReflectMethod((Class<?>) null, "getBackgroundAudioPauseSuper", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getBlockNetworkImageMethod = new LazyReflectMethod((Class<?>) null, "getBlockNetworkImage", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getBlockNetworkLoadsMethod = new LazyReflectMethod((Class<?>) null, "getBlockNetworkLoads", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getBuiltInZoomControlsMethod = new LazyReflectMethod((Class<?>) null, "getBuiltInZoomControls", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getCacheModeMethod = new LazyReflectMethod((Class<?>) null, "getCacheMode", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getCursiveFontFamilyMethod = new LazyReflectMethod((Class<?>) null, "getCursiveFontFamily", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getDatabaseEnabledMethod = new LazyReflectMethod((Class<?>) null, "getDatabaseEnabled", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getDefaultFixedFontSizeMethod = new LazyReflectMethod((Class<?>) null, "getDefaultFixedFontSize", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getDefaultFontSizeMethod = new LazyReflectMethod((Class<?>) null, "getDefaultFontSize", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getDomStorageEnabledMethod = new LazyReflectMethod((Class<?>) null, "getDomStorageEnabled", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getFantasyFontFamilyMethod = new LazyReflectMethod((Class<?>) null, "getFantasyFontFamily", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getFixedFontFamilyMethod = new LazyReflectMethod((Class<?>) null, "getFixedFontFamily", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getForceDarkBehaviorMethod = new LazyReflectMethod((Class<?>) null, "getForceDarkBehavior", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getForceDarkModeMethod = new LazyReflectMethod((Class<?>) null, "getForceDarkMode", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getJavaScriptCanOpenWindowsAutomaticallyMethod = new LazyReflectMethod((Class<?>) null, "getJavaScriptCanOpenWindowsAutomatically", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getJavaScriptEnabledMethod = new LazyReflectMethod((Class<?>) null, "getJavaScriptEnabled", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getLayoutAlgorithmMethod = new LazyReflectMethod((Class<?>) null, "getLayoutAlgorithm", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getLoadWithOverviewModeMethod = new LazyReflectMethod((Class<?>) null, "getLoadWithOverviewMode", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getLoadsImagesAutomaticallyMethod = new LazyReflectMethod((Class<?>) null, "getLoadsImagesAutomatically", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getMediaPlaybackRequiresUserGestureMethod = new LazyReflectMethod((Class<?>) null, "getMediaPlaybackRequiresUserGesture", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getMinimumFontSizeMethod = new LazyReflectMethod((Class<?>) null, "getMinimumFontSize", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getMinimumLogicalFontSizeMethod = new LazyReflectMethod((Class<?>) null, "getMinimumLogicalFontSize", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getSansSerifFontFamilyMethod = new LazyReflectMethod((Class<?>) null, "getSansSerifFontFamily", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getSaveFormDataMethod = new LazyReflectMethod((Class<?>) null, "getSaveFormData", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getSerifFontFamilyMethod = new LazyReflectMethod((Class<?>) null, "getSerifFontFamily", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getStandardFontFamilyMethod = new LazyReflectMethod((Class<?>) null, "getStandardFontFamily", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getSupportQuirksModeMethod = new LazyReflectMethod((Class<?>) null, "getSupportQuirksMode", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getSupportSpatialNavigationMethod = new LazyReflectMethod((Class<?>) null, "getSupportSpatialNavigation", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getTextZoomMethod = new LazyReflectMethod((Class<?>) null, "getTextZoom", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getUseWideViewPortMethod = new LazyReflectMethod((Class<?>) null, "getUseWideViewPort", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getUserAgentStringMethod = new LazyReflectMethod((Class<?>) null, "getUserAgentString", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getUsingForAppBrandMethod = new LazyReflectMethod((Class<?>) null, "getUsingForAppBrand", (Class<?>[]) new Class[0]);
    private LazyReflectMethod getVideoPlaybackRequiresUserGestureMethod = new LazyReflectMethod((Class<?>) null, "getVideoPlaybackRequiresUserGesture", (Class<?>[]) new Class[0]);
    private LazyReflectMethod postWrapperMethod;
    private LazyReflectMethod setAcceptLanguagesStringMethod = new LazyReflectMethod((Class<?>) null, "setAcceptLanguages", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setAllowContentAccessbooleanMethod = new LazyReflectMethod((Class<?>) null, "setAllowContentAccess", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setAllowFileAccessFromFileURLsbooleanMethod = new LazyReflectMethod((Class<?>) null, "setAllowFileAccessFromFileURLs", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setAllowFileAccessbooleanMethod = new LazyReflectMethod((Class<?>) null, "setAllowFileAccess", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setAllowUniversalAccessFromFileURLsbooleanMethod = new LazyReflectMethod((Class<?>) null, "setAllowUniversalAccessFromFileURLs", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setAppBrandInfoMethod = new LazyReflectMethod((Class<?>) null, "setAppBrandInfo", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setAppCacheEnabledbooleanMethod = new LazyReflectMethod((Class<?>) null, "setAppCacheEnabled", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setAppCachePathStringMethod = new LazyReflectMethod((Class<?>) null, "setAppCachePath", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setAudioPlaybackRequiresUserGesturebooleanMethod = new LazyReflectMethod((Class<?>) null, "setAudioPlaybackRequiresUserGesture", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setBackgroundAudioPauseMethod = new LazyReflectMethod((Class<?>) null, "setBackgroundAudioPauseSuper", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setBlockNetworkImagebooleanMethod = new LazyReflectMethod((Class<?>) null, "setBlockNetworkImage", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setBlockNetworkLoadsbooleanMethod = new LazyReflectMethod((Class<?>) null, "setBlockNetworkLoads", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setBuiltInZoomControlsbooleanMethod = new LazyReflectMethod((Class<?>) null, "setBuiltInZoomControls", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setCacheModeintMethod = new LazyReflectMethod((Class<?>) null, "setCacheMode", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setCursiveFontFamilyStringMethod = new LazyReflectMethod((Class<?>) null, "setCursiveFontFamily", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setDatabaseEnabledbooleanMethod = new LazyReflectMethod((Class<?>) null, "setDatabaseEnabled", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setDefaultFixedFontSizeintMethod = new LazyReflectMethod((Class<?>) null, "setDefaultFixedFontSize", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setDefaultFontSizeintMethod = new LazyReflectMethod((Class<?>) null, "setDefaultFontSize", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setDomStorageEnabledbooleanMethod = new LazyReflectMethod((Class<?>) null, "setDomStorageEnabled", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setFantasyFontFamilyStringMethod = new LazyReflectMethod((Class<?>) null, "setFantasyFontFamily", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setFixedFontFamilyStringMethod = new LazyReflectMethod((Class<?>) null, "setFixedFontFamily", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setForceDarkBehaviorintMethod = new LazyReflectMethod((Class<?>) null, "setForceDarkBehavior", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setForceDarkModeintMethod = new LazyReflectMethod((Class<?>) null, "setForceDarkMode", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setInitialPageScalefloatMethod = new LazyReflectMethod((Class<?>) null, "setInitialPageScale", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setJavaScriptCanOpenWindowsAutomaticallybooleanMethod = new LazyReflectMethod((Class<?>) null, "setJavaScriptCanOpenWindowsAutomatically", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setJavaScriptEnabledbooleanMethod = new LazyReflectMethod((Class<?>) null, "setJavaScriptEnabled", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setLayoutAlgorithmLayoutAlgorithmInternalMethod = new LazyReflectMethod((Class<?>) null, "setLayoutAlgorithm", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setLoadWithOverviewModebooleanMethod = new LazyReflectMethod((Class<?>) null, "setLoadWithOverviewMode", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setLoadsImagesAutomaticallybooleanMethod = new LazyReflectMethod((Class<?>) null, "setLoadsImagesAutomatically", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setMediaPlaybackRequiresUserGesturebooleanMethod = new LazyReflectMethod((Class<?>) null, "setMediaPlaybackRequiresUserGesture", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setMinimumFontSizeIntMethod = new LazyReflectMethod((Class<?>) null, "setMinimumFontSize", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setMinimumLogicalFontSizeIntMethod = new LazyReflectMethod((Class<?>) null, "setMinimumLogicalFontSize", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setSansSerifFontFamilyStringMethod = new LazyReflectMethod((Class<?>) null, "setSansSerifFontFamily", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setSaveFormDatabooleanMethod = new LazyReflectMethod((Class<?>) null, "setSaveFormData", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setSerifFontFamilyStringMethod = new LazyReflectMethod((Class<?>) null, "setSerifFontFamily", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setStandardFontFamilyStringMethod = new LazyReflectMethod((Class<?>) null, "setStandardFontFamily", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setSupportMultipleWindowsbooleanMethod = new LazyReflectMethod((Class<?>) null, "setSupportMultipleWindows", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setSupportQuirksModebooleanMethod = new LazyReflectMethod((Class<?>) null, "setSupportQuirksMode", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setSupportSpatialNavigationbooleanMethod = new LazyReflectMethod((Class<?>) null, "setSupportSpatialNavigation", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setSupportZoombooleanMethod = new LazyReflectMethod((Class<?>) null, "setSupportZoom", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setTextZoomintMethod = new LazyReflectMethod((Class<?>) null, "setTextZoom", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setUseWideViewPortbooleanMethod = new LazyReflectMethod((Class<?>) null, "setUseWideViewPort", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setUserAgentStringStringMethod = new LazyReflectMethod((Class<?>) null, "setUserAgentString", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setUsingForAppBrandMethod = new LazyReflectMethod((Class<?>) null, "setUsingForAppBrand", (Class<?>[]) new Class[0]);
    private LazyReflectMethod setVideoPlaybackRequiresUserGesturebooleanMethod = new LazyReflectMethod((Class<?>) null, "setVideoPlaybackRequiresUserGesture", (Class<?>[]) new Class[0]);
    private LazyReflectMethod supportMultipleWindowsMethod = new LazyReflectMethod((Class<?>) null, "supportMultipleWindows", (Class<?>[]) new Class[0]);
    private LazyReflectMethod supportZoomMethod = new LazyReflectMethod((Class<?>) null, "supportZoom", (Class<?>[]) new Class[0]);
    private LazyReflectMethod supportsMultiTouchZoomForTestMethod = new LazyReflectMethod((Class<?>) null, "supportsMultiTouchZoomForTest", (Class<?>[]) new Class[0]);

    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS,
        TEXT_AUTOSIZING;

        public static LayoutAlgorithm valueOf(String str) {
            AppMethodBeat.i(154860);
            LayoutAlgorithm layoutAlgorithm = (LayoutAlgorithm) Enum.valueOf(LayoutAlgorithm.class, str);
            AppMethodBeat.o(154860);
            return layoutAlgorithm;
        }

        static {
            AppMethodBeat.i(154861);
            AppMethodBeat.o(154861);
        }
    }

    private Object ConvertLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        AppMethodBeat.i(154862);
        Object invoke = this.enumLayoutAlgorithmClassValueOfMethod.invoke(layoutAlgorithm.toString());
        AppMethodBeat.o(154862);
        return invoke;
    }

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkSettings(Object obj) {
        AppMethodBeat.i(154863);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.o(154863);
    }

    public void setCacheMode(int i2) {
        AppMethodBeat.i(154864);
        try {
            this.setCacheModeintMethod.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(154864);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154864);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154864);
        }
    }

    public int getCacheMode() {
        AppMethodBeat.i(154865);
        try {
            int intValue = ((Integer) this.getCacheModeMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(154865);
            return intValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154865);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154865);
            return 0;
        }
    }

    public void setForceDarkMode(int i2) {
        AppMethodBeat.i(154866);
        try {
            this.setForceDarkModeintMethod.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(154866);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154866);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154866);
        }
    }

    public int getForceDarkMode() {
        AppMethodBeat.i(154867);
        try {
            int intValue = ((Integer) this.getForceDarkModeMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(154867);
            return intValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154867);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154867);
            return 0;
        }
    }

    public void setForceDarkBehavior(int i2) {
        AppMethodBeat.i(154868);
        try {
            this.setForceDarkBehaviorintMethod.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(154868);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154868);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154868);
        }
    }

    public int getForceDarkBehavior() {
        AppMethodBeat.i(154869);
        try {
            int intValue = ((Integer) this.getForceDarkBehaviorMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(154869);
            return intValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154869);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154869);
            return 0;
        }
    }

    public void setBlockNetworkLoads(boolean z) {
        AppMethodBeat.i(154870);
        try {
            this.setBlockNetworkLoadsbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154870);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154870);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154870);
        }
    }

    public boolean getBlockNetworkLoads() {
        AppMethodBeat.i(154871);
        try {
            boolean booleanValue = ((Boolean) this.getBlockNetworkLoadsMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154871);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154871);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154871);
            return false;
        }
    }

    public void setAllowFileAccess(boolean z) {
        AppMethodBeat.i(154872);
        try {
            this.setAllowFileAccessbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154872);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154872);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154872);
        }
    }

    public boolean getAllowFileAccess() {
        AppMethodBeat.i(154873);
        try {
            boolean booleanValue = ((Boolean) this.getAllowFileAccessMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154873);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154873);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154873);
            return false;
        }
    }

    public void setAllowContentAccess(boolean z) {
        AppMethodBeat.i(154874);
        try {
            this.setAllowContentAccessbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154874);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154874);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154874);
        }
    }

    public boolean getAllowContentAccess() {
        AppMethodBeat.i(154875);
        try {
            boolean booleanValue = ((Boolean) this.getAllowContentAccessMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154875);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154875);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154875);
            return false;
        }
    }

    public void setJavaScriptEnabled(boolean z) {
        AppMethodBeat.i(154876);
        try {
            this.setJavaScriptEnabledbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154876);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154876);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154876);
        }
    }

    public void setStandardFontFamily(String str) {
        AppMethodBeat.i(154877);
        try {
            this.setStandardFontFamilyStringMethod.invoke(str);
            AppMethodBeat.o(154877);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154877);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154877);
        }
    }

    public void setFixedFontFamily(String str) {
        AppMethodBeat.i(154878);
        try {
            this.setFixedFontFamilyStringMethod.invoke(str);
            AppMethodBeat.o(154878);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154878);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154878);
        }
    }

    public void setSansSerifFontFamily(String str) {
        AppMethodBeat.i(154879);
        try {
            this.setSansSerifFontFamilyStringMethod.invoke(str);
            AppMethodBeat.o(154879);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154879);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154879);
        }
    }

    public void setSerifFontFamily(String str) {
        AppMethodBeat.i(154880);
        try {
            this.setSerifFontFamilyStringMethod.invoke(str);
            AppMethodBeat.o(154880);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154880);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154880);
        }
    }

    public void setCursiveFontFamily(String str) {
        AppMethodBeat.i(154881);
        try {
            this.setCursiveFontFamilyStringMethod.invoke(str);
            AppMethodBeat.o(154881);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154881);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154881);
        }
    }

    public void setFantasyFontFamily(String str) {
        AppMethodBeat.i(154882);
        try {
            this.setFantasyFontFamilyStringMethod.invoke(str);
            AppMethodBeat.o(154882);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154882);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154882);
        }
    }

    public void setMinimumFontSize(int i2) {
        AppMethodBeat.i(154883);
        try {
            this.setMinimumFontSizeIntMethod.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(154883);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154883);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154883);
        }
    }

    public void setMinimumLogicalFontSize(int i2) {
        AppMethodBeat.i(154884);
        try {
            this.setMinimumLogicalFontSizeIntMethod.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(154884);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154884);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154884);
        }
    }

    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        AppMethodBeat.i(154885);
        try {
            this.setAllowUniversalAccessFromFileURLsbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154885);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154885);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154885);
        }
    }

    public void setAllowFileAccessFromFileURLs(boolean z) {
        AppMethodBeat.i(154886);
        try {
            this.setAllowFileAccessFromFileURLsbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154886);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154886);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154886);
        }
    }

    public void setLoadsImagesAutomatically(boolean z) {
        AppMethodBeat.i(154887);
        try {
            this.setLoadsImagesAutomaticallybooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154887);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154887);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154887);
        }
    }

    public boolean getLoadsImagesAutomatically() {
        AppMethodBeat.i(154888);
        try {
            boolean booleanValue = ((Boolean) this.getLoadsImagesAutomaticallyMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154888);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154888);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154888);
            return false;
        }
    }

    public void setBlockNetworkImage(boolean z) {
        AppMethodBeat.i(154889);
        try {
            this.setBlockNetworkImagebooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154889);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154889);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154889);
        }
    }

    public boolean getBlockNetworkImage() {
        AppMethodBeat.i(154890);
        try {
            boolean booleanValue = ((Boolean) this.getBlockNetworkImageMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154890);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154890);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154890);
            return false;
        }
    }

    public boolean getJavaScriptEnabled() {
        AppMethodBeat.i(154891);
        try {
            boolean booleanValue = ((Boolean) this.getJavaScriptEnabledMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154891);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154891);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154891);
            return false;
        }
    }

    public String getStandardFontFamily() {
        AppMethodBeat.i(154892);
        try {
            String str = (String) this.getStandardFontFamilyMethod.invoke(new Object[0]);
            AppMethodBeat.o(154892);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154892);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154892);
            return "";
        }
    }

    public String getFixedFontFamily() {
        AppMethodBeat.i(154893);
        try {
            String str = (String) this.getFixedFontFamilyMethod.invoke(new Object[0]);
            AppMethodBeat.o(154893);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154893);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154893);
            return "";
        }
    }

    public String getSansSerifFontFamily() {
        AppMethodBeat.i(154894);
        try {
            String str = (String) this.getSansSerifFontFamilyMethod.invoke(new Object[0]);
            AppMethodBeat.o(154894);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154894);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154894);
            return "";
        }
    }

    public String getSerifFontFamily() {
        AppMethodBeat.i(154895);
        try {
            String str = (String) this.getSerifFontFamilyMethod.invoke(new Object[0]);
            AppMethodBeat.o(154895);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154895);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154895);
            return "";
        }
    }

    public String getCursiveFontFamily() {
        AppMethodBeat.i(154896);
        try {
            String str = (String) this.getCursiveFontFamilyMethod.invoke(new Object[0]);
            AppMethodBeat.o(154896);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154896);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154896);
            return "";
        }
    }

    public String getFantasyFontFamily() {
        AppMethodBeat.i(154897);
        try {
            String str = (String) this.getFantasyFontFamilyMethod.invoke(new Object[0]);
            AppMethodBeat.o(154897);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154897);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154897);
            return "";
        }
    }

    public int getMinimumFontSize() {
        AppMethodBeat.i(154898);
        try {
            int intValue = ((Integer) this.getMinimumFontSizeMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(154898);
            return intValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154898);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154898);
            return 0;
        }
    }

    public int getMinimumLogicalFontSize() {
        AppMethodBeat.i(154899);
        try {
            int intValue = ((Integer) this.getMinimumLogicalFontSizeMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(154899);
            return intValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154899);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154899);
            return 0;
        }
    }

    public boolean getAllowUniversalAccessFromFileURLs() {
        AppMethodBeat.i(154900);
        try {
            boolean booleanValue = ((Boolean) this.getAllowUniversalAccessFromFileURLsMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154900);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154900);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154900);
            return false;
        }
    }

    public boolean getAllowFileAccessFromFileURLs() {
        AppMethodBeat.i(154901);
        try {
            boolean booleanValue = ((Boolean) this.getAllowFileAccessFromFileURLsMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154901);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154901);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154901);
            return false;
        }
    }

    public void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        AppMethodBeat.i(154902);
        try {
            this.setJavaScriptCanOpenWindowsAutomaticallybooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154902);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154902);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154902);
        }
    }

    public boolean getJavaScriptCanOpenWindowsAutomatically() {
        AppMethodBeat.i(154903);
        try {
            boolean booleanValue = ((Boolean) this.getJavaScriptCanOpenWindowsAutomaticallyMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154903);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154903);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154903);
            return false;
        }
    }

    public void setSupportMultipleWindows(boolean z) {
        AppMethodBeat.i(154904);
        try {
            this.setSupportMultipleWindowsbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154904);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154904);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154904);
        }
    }

    public boolean supportMultipleWindows() {
        AppMethodBeat.i(154905);
        try {
            boolean booleanValue = ((Boolean) this.supportMultipleWindowsMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154905);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154905);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154905);
            return false;
        }
    }

    public void setUseWideViewPort(boolean z) {
        AppMethodBeat.i(154906);
        try {
            this.setUseWideViewPortbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154906);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154906);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154906);
        }
    }

    public boolean getUseWideViewPort() {
        AppMethodBeat.i(154907);
        try {
            boolean booleanValue = ((Boolean) this.getUseWideViewPortMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154907);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154907);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154907);
            return false;
        }
    }

    public void setAppCacheEnabled(boolean z) {
        AppMethodBeat.i(154908);
        try {
            this.setAppCacheEnabledbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154908);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154908);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154908);
        }
    }

    public void setAppCachePath(String str) {
        AppMethodBeat.i(154909);
        try {
            this.setAppCachePathStringMethod.invoke(str);
            AppMethodBeat.o(154909);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154909);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154909);
        }
    }

    public void setDomStorageEnabled(boolean z) {
        AppMethodBeat.i(154910);
        try {
            this.setDomStorageEnabledbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154910);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154910);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154910);
        }
    }

    public boolean getDomStorageEnabled() {
        AppMethodBeat.i(154911);
        try {
            boolean booleanValue = ((Boolean) this.getDomStorageEnabledMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154911);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154911);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154911);
            return false;
        }
    }

    public void setDatabaseEnabled(boolean z) {
        AppMethodBeat.i(154912);
        try {
            this.setDatabaseEnabledbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154912);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154912);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154912);
        }
    }

    public boolean getDatabaseEnabled() {
        AppMethodBeat.i(154913);
        try {
            boolean booleanValue = ((Boolean) this.getDatabaseEnabledMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154913);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154913);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154913);
            return false;
        }
    }

    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        AppMethodBeat.i(154914);
        try {
            this.setMediaPlaybackRequiresUserGesturebooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154914);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154914);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154914);
        }
    }

    public boolean getMediaPlaybackRequiresUserGesture() {
        AppMethodBeat.i(154915);
        try {
            boolean booleanValue = ((Boolean) this.getMediaPlaybackRequiresUserGestureMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154915);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154915);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154915);
            return false;
        }
    }

    public void setAudioPlaybackRequiresUserGesture(boolean z) {
        AppMethodBeat.i(183764);
        try {
            this.setAudioPlaybackRequiresUserGesturebooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(183764);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(183764);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(183764);
        }
    }

    public boolean getAudioPlaybackRequiresUserGesture() {
        AppMethodBeat.i(183765);
        try {
            boolean booleanValue = ((Boolean) this.getAudioPlaybackRequiresUserGestureMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(183765);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(183765);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(183765);
            return false;
        }
    }

    public void setVideoPlaybackRequiresUserGesture(boolean z) {
        AppMethodBeat.i(154916);
        try {
            this.setVideoPlaybackRequiresUserGesturebooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154916);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154916);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154916);
        }
    }

    public void enableCustomizedLongPressTimeout(int i2) {
        AppMethodBeat.i(207387);
        try {
            this.enableCustomizedLongPressTimeoutIntMethod.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(207387);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(207387);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(207387);
        }
    }

    public void disableCustomizedLongPressTimeout() {
        AppMethodBeat.i(207388);
        try {
            this.disableCustomizedLongPressTimeoutVoidMethod.invoke(new Object[0]);
            AppMethodBeat.o(207388);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(207388);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(207388);
        }
    }

    public boolean getVideoPlaybackRequiresUserGesture() {
        AppMethodBeat.i(154917);
        try {
            boolean booleanValue = ((Boolean) this.getVideoPlaybackRequiresUserGestureMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154917);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154917);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154917);
            return false;
        }
    }

    public void setUsingForAppBrand(int i2) {
        AppMethodBeat.i(154918);
        try {
            this.setUsingForAppBrandMethod.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(154918);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154918);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154918);
        }
    }

    public int getUsingForAppBrand() {
        AppMethodBeat.i(154919);
        try {
            int intValue = ((Integer) this.getUsingForAppBrandMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(154919);
            return intValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154919);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154919);
            return 0;
        }
    }

    public void setUserAgentString(String str) {
        AppMethodBeat.i(154920);
        try {
            this.setUserAgentStringStringMethod.invoke(str);
            AppMethodBeat.o(154920);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154920);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154920);
        }
    }

    public String getUserAgentString() {
        AppMethodBeat.i(154921);
        try {
            String str = (String) this.getUserAgentStringMethod.invoke(new Object[0]);
            AppMethodBeat.o(154921);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154921);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154921);
            return null;
        }
    }

    public void setAcceptLanguages(String str) {
        AppMethodBeat.i(154922);
        try {
            this.setAcceptLanguagesStringMethod.invoke(str);
            AppMethodBeat.o(154922);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154922);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154922);
        }
    }

    public String getAcceptLanguages() {
        AppMethodBeat.i(154923);
        try {
            String str = (String) this.getAcceptLanguagesMethod.invoke(new Object[0]);
            AppMethodBeat.o(154923);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154923);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154923);
            return null;
        }
    }

    public void setSaveFormData(boolean z) {
        AppMethodBeat.i(154924);
        try {
            this.setSaveFormDatabooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154924);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154924);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154924);
        }
    }

    public boolean getSaveFormData() {
        AppMethodBeat.i(154925);
        try {
            boolean booleanValue = ((Boolean) this.getSaveFormDataMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154925);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154925);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154925);
            return false;
        }
    }

    public void setInitialPageScale(float f2) {
        AppMethodBeat.i(154926);
        try {
            this.setInitialPageScalefloatMethod.invoke(Float.valueOf(f2));
            AppMethodBeat.o(154926);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154926);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154926);
        }
    }

    public void setTextZoom(int i2) {
        AppMethodBeat.i(154927);
        try {
            this.setTextZoomintMethod.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(154927);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154927);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154927);
        }
    }

    public int getTextZoom() {
        AppMethodBeat.i(154928);
        try {
            int intValue = ((Integer) this.getTextZoomMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(154928);
            return intValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154928);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154928);
            return 0;
        }
    }

    public void setDefaultFontSize(int i2) {
        AppMethodBeat.i(154929);
        try {
            this.setDefaultFontSizeintMethod.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(154929);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154929);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154929);
        }
    }

    public int getDefaultFontSize() {
        AppMethodBeat.i(154930);
        try {
            int intValue = ((Integer) this.getDefaultFontSizeMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(154930);
            return intValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154930);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154930);
            return 0;
        }
    }

    public void setDefaultFixedFontSize(int i2) {
        AppMethodBeat.i(154931);
        try {
            this.setDefaultFixedFontSizeintMethod.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(154931);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154931);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154931);
        }
    }

    public int getDefaultFixedFontSize() {
        AppMethodBeat.i(154932);
        try {
            int intValue = ((Integer) this.getDefaultFixedFontSizeMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(154932);
            return intValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154932);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154932);
            return 0;
        }
    }

    public void setSupportZoom(boolean z) {
        AppMethodBeat.i(154933);
        try {
            this.setSupportZoombooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154933);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154933);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154933);
        }
    }

    public boolean supportZoom() {
        AppMethodBeat.i(154934);
        try {
            boolean booleanValue = ((Boolean) this.supportZoomMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154934);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154934);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154934);
            return false;
        }
    }

    public void setBuiltInZoomControls(boolean z) {
        AppMethodBeat.i(154935);
        try {
            this.setBuiltInZoomControlsbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154935);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154935);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154935);
        }
    }

    public boolean getBuiltInZoomControls() {
        AppMethodBeat.i(154936);
        try {
            boolean booleanValue = ((Boolean) this.getBuiltInZoomControlsMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154936);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154936);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154936);
            return false;
        }
    }

    public boolean supportsMultiTouchZoomForTest() {
        AppMethodBeat.i(154937);
        try {
            boolean booleanValue = ((Boolean) this.supportsMultiTouchZoomForTestMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154937);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154937);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154937);
            return false;
        }
    }

    public void setSupportSpatialNavigation(boolean z) {
        AppMethodBeat.i(154938);
        try {
            this.setSupportSpatialNavigationbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154938);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154938);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154938);
        }
    }

    public boolean getSupportSpatialNavigation() {
        AppMethodBeat.i(154939);
        try {
            boolean booleanValue = ((Boolean) this.getSupportSpatialNavigationMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154939);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154939);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154939);
            return false;
        }
    }

    public void setSupportQuirksMode(boolean z) {
        AppMethodBeat.i(154940);
        try {
            this.setSupportQuirksModebooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154940);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154940);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154940);
        }
    }

    public boolean getSupportQuirksMode() {
        AppMethodBeat.i(154941);
        try {
            boolean booleanValue = ((Boolean) this.getSupportQuirksModeMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154941);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154941);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154941);
            return false;
        }
    }

    public void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        AppMethodBeat.i(154942);
        try {
            this.setLayoutAlgorithmLayoutAlgorithmInternalMethod.invoke(ConvertLayoutAlgorithm(layoutAlgorithm));
            AppMethodBeat.o(154942);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154942);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154942);
        }
    }

    public LayoutAlgorithm getLayoutAlgorithm() {
        AppMethodBeat.i(154943);
        try {
            LayoutAlgorithm valueOf = LayoutAlgorithm.valueOf(this.getLayoutAlgorithmMethod.invoke(new Object[0]).toString());
            AppMethodBeat.o(154943);
            return valueOf;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154943);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154943);
            return null;
        }
    }

    public void setLoadWithOverviewMode(boolean z) {
        AppMethodBeat.i(154944);
        try {
            this.setLoadWithOverviewModebooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154944);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154944);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154944);
        }
    }

    public boolean getLoadWithOverviewMode() {
        AppMethodBeat.i(154945);
        try {
            boolean booleanValue = ((Boolean) this.getLoadWithOverviewModeMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154945);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154945);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154945);
            return false;
        }
    }

    public void SetLogCallBack(XWalkLogMessageListener xWalkLogMessageListener) {
        AppMethodBeat.i(154946);
        try {
            this.SetLogCallBackXWalkLogMessageListenerInternalMethod.invoke(xWalkLogMessageListener.getBridge());
            AppMethodBeat.o(154946);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                this.SetLogCallBackXWalkLogMessageListenerInternalMethod.setArguments(new LazyReflectMethod(xWalkLogMessageListener, "getBridge", new Class[0]));
                XWalkCoreWrapper.reserveReflectMethod(this.SetLogCallBackXWalkLogMessageListenerInternalMethod);
                AppMethodBeat.o(154946);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154946);
        }
    }

    public void SetJSExceptionCallBack(XWalkJSExceptionListener xWalkJSExceptionListener) {
        AppMethodBeat.i(154947);
        try {
            this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod.invoke(xWalkJSExceptionListener.getBridge());
            AppMethodBeat.o(154947);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod.setArguments(new LazyReflectMethod(xWalkJSExceptionListener, "getBridge", new Class[0]));
                XWalkCoreWrapper.reserveReflectMethod(this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod);
                AppMethodBeat.o(154947);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154947);
        }
    }

    public void setAppBrandInfo(Map<String, String> map) {
        AppMethodBeat.i(207389);
        try {
            this.setAppBrandInfoMethod.invoke(map);
            AppMethodBeat.o(207389);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(207389);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(207389);
        }
    }

    public Map<String, String> getAppBrandInfo() {
        AppMethodBeat.i(207390);
        try {
            Map<String, String> map = (Map) this.getAppBrandInfoMethod.invoke(new Object[0]);
            AppMethodBeat.o(207390);
            return map;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(207390);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(207390);
            return null;
        }
    }

    public void setBackgroundAudioPause(boolean z) {
        AppMethodBeat.i(207391);
        try {
            this.setBackgroundAudioPauseMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(207391);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(207391);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(207391);
        }
    }

    public boolean getBackgroundAudioPause() {
        AppMethodBeat.i(207392);
        try {
            boolean booleanValue = ((Boolean) this.getBackgroundAudioPauseMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(207392);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(207392);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(207392);
            return false;
        }
    }

    public void InvokeChannel(int i2, Object[] objArr) {
        AppMethodBeat.i(161641);
        try {
            this.InvokeChannelInternalMethod.invoke(Integer.valueOf(i2), objArr);
            AppMethodBeat.o(161641);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(161641);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(161641);
        }
    }

    public void bindNativeTrans(long j2) {
        AppMethodBeat.i(161642);
        InvokeChannel(30003, new String[]{String.valueOf(j2)});
        AppMethodBeat.o(161642);
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(154948);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(154948);
            return;
        }
        this.enumLayoutAlgorithmClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkSettingsInternal$LayoutAlgorithmInternal"), "valueOf", String.class);
        this.setCacheModeintMethod.init(this.bridge, null, "setCacheModeSuper", Integer.TYPE);
        this.getCacheModeMethod.init(this.bridge, null, "getCacheModeSuper", new Class[0]);
        this.setForceDarkModeintMethod.init(this.bridge, null, "setForceDarkModeSuper", Integer.TYPE);
        this.getForceDarkModeMethod.init(this.bridge, null, "getForceDarkModeSuper", new Class[0]);
        this.setForceDarkBehaviorintMethod.init(this.bridge, null, "setForceDarkBehaviorSuper", Integer.TYPE);
        this.getForceDarkBehaviorMethod.init(this.bridge, null, "getForceDarkBehaviorSuper", new Class[0]);
        this.setBlockNetworkLoadsbooleanMethod.init(this.bridge, null, "setBlockNetworkLoadsSuper", Boolean.TYPE);
        this.getBlockNetworkLoadsMethod.init(this.bridge, null, "getBlockNetworkLoadsSuper", new Class[0]);
        this.setAllowFileAccessbooleanMethod.init(this.bridge, null, "setAllowFileAccessSuper", Boolean.TYPE);
        this.getAllowFileAccessMethod.init(this.bridge, null, "getAllowFileAccessSuper", new Class[0]);
        this.setAllowContentAccessbooleanMethod.init(this.bridge, null, "setAllowContentAccessSuper", Boolean.TYPE);
        this.getAllowContentAccessMethod.init(this.bridge, null, "getAllowContentAccessSuper", new Class[0]);
        this.setJavaScriptEnabledbooleanMethod.init(this.bridge, null, "setJavaScriptEnabledSuper", Boolean.TYPE);
        this.setAllowUniversalAccessFromFileURLsbooleanMethod.init(this.bridge, null, "setAllowUniversalAccessFromFileURLsSuper", Boolean.TYPE);
        this.setAllowFileAccessFromFileURLsbooleanMethod.init(this.bridge, null, "setAllowFileAccessFromFileURLsSuper", Boolean.TYPE);
        this.setLoadsImagesAutomaticallybooleanMethod.init(this.bridge, null, "setLoadsImagesAutomaticallySuper", Boolean.TYPE);
        this.getLoadsImagesAutomaticallyMethod.init(this.bridge, null, "getLoadsImagesAutomaticallySuper", new Class[0]);
        this.setBlockNetworkImagebooleanMethod.init(this.bridge, null, "setBlockNetworkImageSuper", Boolean.TYPE);
        this.getBlockNetworkImageMethod.init(this.bridge, null, "getBlockNetworkImageSuper", new Class[0]);
        this.getJavaScriptEnabledMethod.init(this.bridge, null, "getJavaScriptEnabledSuper", new Class[0]);
        this.getAllowUniversalAccessFromFileURLsMethod.init(this.bridge, null, "getAllowUniversalAccessFromFileURLsSuper", new Class[0]);
        this.getAllowFileAccessFromFileURLsMethod.init(this.bridge, null, "getAllowFileAccessFromFileURLsSuper", new Class[0]);
        this.setJavaScriptCanOpenWindowsAutomaticallybooleanMethod.init(this.bridge, null, "setJavaScriptCanOpenWindowsAutomaticallySuper", Boolean.TYPE);
        this.getJavaScriptCanOpenWindowsAutomaticallyMethod.init(this.bridge, null, "getJavaScriptCanOpenWindowsAutomaticallySuper", new Class[0]);
        this.setSupportMultipleWindowsbooleanMethod.init(this.bridge, null, "setSupportMultipleWindowsSuper", Boolean.TYPE);
        this.supportMultipleWindowsMethod.init(this.bridge, null, "supportMultipleWindowsSuper", new Class[0]);
        this.setUseWideViewPortbooleanMethod.init(this.bridge, null, "setUseWideViewPortSuper", Boolean.TYPE);
        this.getUseWideViewPortMethod.init(this.bridge, null, "getUseWideViewPortSuper", new Class[0]);
        this.setAppCacheEnabledbooleanMethod.init(this.bridge, null, "setAppCacheEnabledSuper", Boolean.TYPE);
        this.setAppCachePathStringMethod.init(this.bridge, null, "setAppCachePathSuper", String.class);
        this.setDomStorageEnabledbooleanMethod.init(this.bridge, null, "setDomStorageEnabledSuper", Boolean.TYPE);
        this.getDomStorageEnabledMethod.init(this.bridge, null, "getDomStorageEnabledSuper", new Class[0]);
        this.setDatabaseEnabledbooleanMethod.init(this.bridge, null, "setDatabaseEnabledSuper", Boolean.TYPE);
        this.getDatabaseEnabledMethod.init(this.bridge, null, "getDatabaseEnabledSuper", new Class[0]);
        this.setMediaPlaybackRequiresUserGesturebooleanMethod.init(this.bridge, null, "setMediaPlaybackRequiresUserGestureSuper", Boolean.TYPE);
        this.getMediaPlaybackRequiresUserGestureMethod.init(this.bridge, null, "getMediaPlaybackRequiresUserGestureSuper", new Class[0]);
        this.setAudioPlaybackRequiresUserGesturebooleanMethod.init(this.bridge, null, "setAudioPlaybackRequiresUserGestureSuper", Boolean.TYPE);
        this.getAudioPlaybackRequiresUserGestureMethod.init(this.bridge, null, "getAudioPlaybackRequiresUserGestureSuper", new Class[0]);
        this.setVideoPlaybackRequiresUserGesturebooleanMethod.init(this.bridge, null, "setVideoPlaybackRequiresUserGestureSuper", Boolean.TYPE);
        this.getVideoPlaybackRequiresUserGestureMethod.init(this.bridge, null, "getVideoPlaybackRequiresUserGestureSuper", new Class[0]);
        this.enableCustomizedLongPressTimeoutIntMethod.init(this.bridge, null, "enableCustomizedLongPressTimeoutSuper", Integer.TYPE);
        this.disableCustomizedLongPressTimeoutVoidMethod.init(this.bridge, null, "disableCustomizedLongPressTimeoutSuper", new Class[0]);
        this.setUsingForAppBrandMethod.init(this.bridge, null, "setUsingForAppBrandSuper", Integer.TYPE);
        this.getUsingForAppBrandMethod.init(this.bridge, null, "getUsingForAppBrandSuper", new Class[0]);
        this.setUserAgentStringStringMethod.init(this.bridge, null, "setUserAgentStringSuper", String.class);
        this.getUserAgentStringMethod.init(this.bridge, null, "getUserAgentStringSuper", new Class[0]);
        this.setAcceptLanguagesStringMethod.init(this.bridge, null, "setAcceptLanguagesSuper", String.class);
        this.getAcceptLanguagesMethod.init(this.bridge, null, "getAcceptLanguagesSuper", new Class[0]);
        this.setSaveFormDatabooleanMethod.init(this.bridge, null, "setSaveFormDataSuper", Boolean.TYPE);
        this.getSaveFormDataMethod.init(this.bridge, null, "getSaveFormDataSuper", new Class[0]);
        this.setInitialPageScalefloatMethod.init(this.bridge, null, "setInitialPageScaleSuper", Float.TYPE);
        this.setTextZoomintMethod.init(this.bridge, null, "setTextZoomSuper", Integer.TYPE);
        this.getTextZoomMethod.init(this.bridge, null, "getTextZoomSuper", new Class[0]);
        this.setDefaultFontSizeintMethod.init(this.bridge, null, "setDefaultFontSizeSuper", Integer.TYPE);
        this.getDefaultFontSizeMethod.init(this.bridge, null, "getDefaultFontSizeSuper", new Class[0]);
        this.setDefaultFixedFontSizeintMethod.init(this.bridge, null, "setDefaultFixedFontSizeSuper", Integer.TYPE);
        this.getDefaultFixedFontSizeMethod.init(this.bridge, null, "getDefaultFixedFontSizeSuper", new Class[0]);
        this.setSupportZoombooleanMethod.init(this.bridge, null, "setSupportZoomSuper", Boolean.TYPE);
        this.supportZoomMethod.init(this.bridge, null, "supportZoomSuper", new Class[0]);
        this.setBuiltInZoomControlsbooleanMethod.init(this.bridge, null, "setBuiltInZoomControlsSuper", Boolean.TYPE);
        this.getBuiltInZoomControlsMethod.init(this.bridge, null, "getBuiltInZoomControlsSuper", new Class[0]);
        this.supportsMultiTouchZoomForTestMethod.init(this.bridge, null, "supportsMultiTouchZoomForTestSuper", new Class[0]);
        this.setSupportSpatialNavigationbooleanMethod.init(this.bridge, null, "setSupportSpatialNavigationSuper", Boolean.TYPE);
        this.getSupportSpatialNavigationMethod.init(this.bridge, null, "getSupportSpatialNavigationSuper", new Class[0]);
        this.setSupportQuirksModebooleanMethod.init(this.bridge, null, "setSupportQuirksModeSuper", Boolean.TYPE);
        this.getSupportQuirksModeMethod.init(this.bridge, null, "getSupportQuirksModeSuper", new Class[0]);
        this.setLayoutAlgorithmLayoutAlgorithmInternalMethod.init(this.bridge, null, "setLayoutAlgorithmSuper", this.coreWrapper.getBridgeClass("XWalkSettingsInternal$LayoutAlgorithmInternal"));
        this.getLayoutAlgorithmMethod.init(this.bridge, null, "getLayoutAlgorithmSuper", new Class[0]);
        this.setLoadWithOverviewModebooleanMethod.init(this.bridge, null, "setLoadWithOverviewModeSuper", Boolean.TYPE);
        this.getLoadWithOverviewModeMethod.init(this.bridge, null, "getLoadWithOverviewModeSuper", new Class[0]);
        this.SetLogCallBackXWalkLogMessageListenerInternalMethod.init(this.bridge, null, "SetLogCallBackSuper", this.coreWrapper.getBridgeClass("XWalkLogMessageListenerBridge"));
        this.setStandardFontFamilyStringMethod.init(this.bridge, null, "setStandardFontFamilySuper", String.class);
        this.setFixedFontFamilyStringMethod.init(this.bridge, null, "setFixedFontFamilySuper", String.class);
        this.setSansSerifFontFamilyStringMethod.init(this.bridge, null, "setSansSerifFontFamilySuper", String.class);
        this.setSerifFontFamilyStringMethod.init(this.bridge, null, "setSerifFontFamilySuper", String.class);
        this.setCursiveFontFamilyStringMethod.init(this.bridge, null, "setCursiveFontFamilySuper", String.class);
        this.setFantasyFontFamilyStringMethod.init(this.bridge, null, "setFantasyFontFamilySuper", String.class);
        this.setMinimumFontSizeIntMethod.init(this.bridge, null, "setMinimumFontSizeSuper", Integer.TYPE);
        this.setMinimumLogicalFontSizeIntMethod.init(this.bridge, null, "setMinimumLogicalFontSizeSuper", Integer.TYPE);
        this.getStandardFontFamilyMethod.init(this.bridge, null, "getStandardFontFamilySuper", new Class[0]);
        this.getFixedFontFamilyMethod.init(this.bridge, null, "getFixedFontFamilySuper", new Class[0]);
        this.getSansSerifFontFamilyMethod.init(this.bridge, null, "getSansSerifFontFamilySuper", new Class[0]);
        this.getSerifFontFamilyMethod.init(this.bridge, null, "getSerifFontFamilySuper", new Class[0]);
        this.getCursiveFontFamilyMethod.init(this.bridge, null, "getCursiveFontFamilySuper", new Class[0]);
        this.getFantasyFontFamilyMethod.init(this.bridge, null, "getFantasyFontFamilySuper", new Class[0]);
        this.getMinimumFontSizeMethod.init(this.bridge, null, "getMinimumFontSizeSuper", new Class[0]);
        this.getMinimumLogicalFontSizeMethod.init(this.bridge, null, "getMinimumLogicalFontSizeSuper", new Class[0]);
        this.getAppBrandInfoMethod.init(this.bridge, null, "getAppBrandInfoSuper", new Class[0]);
        this.setAppBrandInfoMethod.init(this.bridge, null, "setAppBrandInfoSuper", Map.class);
        this.getBackgroundAudioPauseMethod.init(this.bridge, null, "getBackgroundAudioPauseSuper", new Class[0]);
        this.setBackgroundAudioPauseMethod.init(this.bridge, null, "setBackgroundAudioPauseSuper", Boolean.TYPE);
        this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod.init(this.bridge, null, "SetJSExceptionCallBackSuper", this.coreWrapper.getBridgeClass("XWalkJSExceptionListenerBridge"));
        this.InvokeChannelInternalMethod.init(this.bridge, null, "InvokeChannel", Integer.TYPE, Object[].class);
        AppMethodBeat.o(154948);
    }
}
