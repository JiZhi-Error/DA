package org.xwalk.core;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Map;

public class XWalkUIClient {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkUIClient.class.desiredAssertionStatus());
    private LazyReflectMethod OnGetSampleStringXWalkViewInternalMapCallbackMethod = new LazyReflectMethod((Class<?>) null, "OnGetSampleString", (Class<?>[]) new Class[0]);
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes = new ArrayList<>();
    private XWalkCoreWrapper coreWrapper;
    private LazyReflectMethod enumConsoleMessageTypeClassValueOfMethod = new LazyReflectMethod();
    private LazyReflectMethod enumInitiateByClassValueOfMethod = new LazyReflectMethod();
    private LazyReflectMethod enumJavascriptMessageTypeClassValueOfMethod = new LazyReflectMethod();
    private LazyReflectMethod enumLoadStatusClassValueOfMethod = new LazyReflectMethod();
    private LazyReflectMethod getVideoLoadingProgressViewMethod = new LazyReflectMethod((Class<?>) null, "getVideoLoadingProgressView", (Class<?>[]) new Class[0]);
    private LazyReflectMethod isSearchableMethod = new LazyReflectMethod((Class<?>) null, "isSearchable", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod = new LazyReflectMethod((Class<?>) null, "onConsoleMessage", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod = new LazyReflectMethod((Class<?>) null, "onCreateWindowRequested", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onDidChangeThemeColorXWalkViewInternalStringMessageMethod = new LazyReflectMethod((Class<?>) null, "onDidChangeThemeColor", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onFullscreenToggledXWalkViewInternalbooleanMethod = new LazyReflectMethod((Class<?>) null, "onFullscreenToggled", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onGeolocationPermissionsHidePromptMethod = new LazyReflectMethod((Class<?>) null, "onGeolocationPermissionsHidePrompt", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onGeolocationPermissionsShowPromptStringXWalkGeolocationPermissionsCallbackInternalMethod = new LazyReflectMethod((Class<?>) null, "onGeolocationPermissionsShowPrompt", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onGetTranslateStringXWalkViewInternalMapCallbackMethod = new LazyReflectMethod((Class<?>) null, "onGetTranslateString", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onHideCustomViewMethod = new LazyReflectMethod((Class<?>) null, "onHideCustomView", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onIconAvailableXWalkViewInternalStringMessageMethod = new LazyReflectMethod((Class<?>) null, "onIconAvailable", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onJavascriptCloseWindowXWalkViewInternalMethod = new LazyReflectMethod((Class<?>) null, "onJavascriptCloseWindow", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod = new LazyReflectMethod((Class<?>) null, "onJavascriptModalDialog", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod = new LazyReflectMethod((Class<?>) null, "onJsAlert", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod = new LazyReflectMethod((Class<?>) null, "onJsConfirm", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod = new LazyReflectMethod((Class<?>) null, "onJsPrompt", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onPageCommitVisibleXWalkViewInternalStringMethod = new LazyReflectMethod((Class<?>) null, "onPageCommitVisible", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onPageLoadStartedXWalkViewInternalStringMethod = new LazyReflectMethod((Class<?>) null, "onPageLoadStarted", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod = new LazyReflectMethod((Class<?>) null, "onPageLoadStopped", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onReceivedIconXWalkViewInternalStringBitmapMethod = new LazyReflectMethod((Class<?>) null, "onReceivedIcon", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onReceivedTitleXWalkViewInternalStringMethod = new LazyReflectMethod((Class<?>) null, "onReceivedTitle", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onRequestFocusXWalkViewInternalMethod = new LazyReflectMethod((Class<?>) null, "onRequestFocus", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onScaleChangedXWalkViewInternalfloatfloatMethod = new LazyReflectMethod((Class<?>) null, "onScaleChanged", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onSearchWordXWalkViewInternalStringStringStringCallbackMethod = new LazyReflectMethod((Class<?>) null, "onSearchWord", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onSelectInfoChangedXWalkViewInternallongStringStringStringCallbackMethod = new LazyReflectMethod((Class<?>) null, "onSelectInfoChanged", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onShowCustomViewViewCustomViewCallbackInternalMethod = new LazyReflectMethod((Class<?>) null, "onShowCustomView", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onShowCustomViewViewintCustomViewCallbackInternalMethod = new LazyReflectMethod((Class<?>) null, "onShowCustomView", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onShowFileChooserXWalkViewInternalValueCallbackStringStringMethod = new LazyReflectMethod((Class<?>) null, "onShowFileChooser", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onShowSosMethod = new LazyReflectMethod((Class<?>) null, "onShowSos", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onUnhandledKeyEventXWalkViewInternalKeyEventMethod = new LazyReflectMethod((Class<?>) null, "onUnhandledKeyEvent", (Class<?>[]) new Class[0]);
    private LazyReflectMethod openFileChooserXWalkViewInternalValueCallbackStringStringMethod = new LazyReflectMethod((Class<?>) null, "openFileChooser", (Class<?>[]) new Class[0]);
    private LazyReflectMethod postWrapperMethod;
    private LazyReflectMethod shouldOverrideKeyEventXWalkViewInternalKeyEventMethod = new LazyReflectMethod((Class<?>) null, "shouldOverrideKeyEvent", (Class<?>[]) new Class[0]);

    static {
        AppMethodBeat.i(154999);
        AppMethodBeat.o(154999);
    }

    public enum JavascriptMessageType {
        JAVASCRIPT_ALERT,
        JAVASCRIPT_CONFIRM,
        JAVASCRIPT_PROMPT,
        JAVASCRIPT_BEFOREUNLOAD;

        public static JavascriptMessageType valueOf(String str) {
            AppMethodBeat.i(154956);
            JavascriptMessageType javascriptMessageType = (JavascriptMessageType) Enum.valueOf(JavascriptMessageType.class, str);
            AppMethodBeat.o(154956);
            return javascriptMessageType;
        }

        static {
            AppMethodBeat.i(154957);
            AppMethodBeat.o(154957);
        }
    }

    private Object ConvertJavascriptMessageType(JavascriptMessageType javascriptMessageType) {
        AppMethodBeat.i(154961);
        Object invoke = this.enumJavascriptMessageTypeClassValueOfMethod.invoke(javascriptMessageType.toString());
        AppMethodBeat.o(154961);
        return invoke;
    }

    public enum ConsoleMessageType {
        DEBUG,
        ERROR,
        LOG,
        INFO,
        WARNING;

        public static ConsoleMessageType valueOf(String str) {
            AppMethodBeat.i(154950);
            ConsoleMessageType consoleMessageType = (ConsoleMessageType) Enum.valueOf(ConsoleMessageType.class, str);
            AppMethodBeat.o(154950);
            return consoleMessageType;
        }

        static {
            AppMethodBeat.i(154951);
            AppMethodBeat.o(154951);
        }
    }

    private Object ConvertConsoleMessageType(ConsoleMessageType consoleMessageType) {
        AppMethodBeat.i(154962);
        Object invoke = this.enumConsoleMessageTypeClassValueOfMethod.invoke(consoleMessageType.toString());
        AppMethodBeat.o(154962);
        return invoke;
    }

    public enum InitiateBy {
        BY_USER_GESTURE,
        BY_JAVASCRIPT;

        public static InitiateBy valueOf(String str) {
            AppMethodBeat.i(154953);
            InitiateBy initiateBy = (InitiateBy) Enum.valueOf(InitiateBy.class, str);
            AppMethodBeat.o(154953);
            return initiateBy;
        }

        static {
            AppMethodBeat.i(154954);
            AppMethodBeat.o(154954);
        }
    }

    private Object ConvertInitiateBy(InitiateBy initiateBy) {
        AppMethodBeat.i(154963);
        Object invoke = this.enumInitiateByClassValueOfMethod.invoke(initiateBy.toString());
        AppMethodBeat.o(154963);
        return invoke;
    }

    public enum LoadStatus {
        FINISHED,
        FAILED,
        CANCELLED;

        public static LoadStatus valueOf(String str) {
            AppMethodBeat.i(154959);
            LoadStatus loadStatus = (LoadStatus) Enum.valueOf(LoadStatus.class, str);
            AppMethodBeat.o(154959);
            return loadStatus;
        }

        static {
            AppMethodBeat.i(154960);
            AppMethodBeat.o(154960);
        }
    }

    private Object ConvertLoadStatus(LoadStatus loadStatus) {
        AppMethodBeat.i(154964);
        Object invoke = this.enumLoadStatusClassValueOfMethod.invoke(loadStatus.toString());
        AppMethodBeat.o(154964);
        return invoke;
    }

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkUIClient(XWalkView xWalkView) {
        AppMethodBeat.i(154965);
        this.constructorTypes.add("XWalkViewBridge");
        this.constructorParams = new ArrayList<>();
        this.constructorParams.add(xWalkView);
        reflectionInit();
        AppMethodBeat.o(154965);
    }

    public boolean onSelectInfoChanged(XWalkView xWalkView, long j2, String str, String str2, String str3) {
        AppMethodBeat.i(154966);
        try {
            boolean booleanValue = ((Boolean) this.onSelectInfoChangedXWalkViewInternallongStringStringStringCallbackMethod.invoke(xWalkView.getBridge(), Long.valueOf(j2), str, str2, str3)).booleanValue();
            AppMethodBeat.o(154966);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154966);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154966);
            return false;
        }
    }

    public boolean isSearchable() {
        AppMethodBeat.i(154967);
        try {
            boolean booleanValue = ((Boolean) this.isSearchableMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154967);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154967);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154967);
            return false;
        }
    }

    public void onShowSos() {
        AppMethodBeat.i(154968);
        try {
            this.onShowSosMethod.invoke(new Object[0]);
            AppMethodBeat.o(154968);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154968);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154968);
        }
    }

    public boolean onSearchWord(XWalkView xWalkView, String str, String str2, String str3) {
        AppMethodBeat.i(154969);
        try {
            boolean booleanValue = ((Boolean) this.onSearchWordXWalkViewInternalStringStringStringCallbackMethod.invoke(xWalkView.getBridge(), str, str2, str3)).booleanValue();
            AppMethodBeat.o(154969);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154969);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154969);
            return false;
        }
    }

    public boolean onCreateWindowRequested(XWalkView xWalkView, InitiateBy initiateBy, ValueCallback<XWalkView> valueCallback) {
        AppMethodBeat.i(154970);
        try {
            boolean booleanValue = ((Boolean) this.onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod.invoke(xWalkView.getBridge(), ConvertInitiateBy(initiateBy), valueCallback)).booleanValue();
            AppMethodBeat.o(154970);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154970);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154970);
            return false;
        }
    }

    public void onDidChangeThemeColor(XWalkView xWalkView, int i2) {
        AppMethodBeat.i(154971);
        try {
            this.onDidChangeThemeColorXWalkViewInternalStringMessageMethod.invoke(xWalkView.getBridge(), Integer.valueOf(i2));
            AppMethodBeat.o(154971);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154971);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154971);
        }
    }

    public boolean shouldDiscardCurrentPage() {
        return false;
    }

    public void onClearCurrentPage() {
    }

    public void onIconAvailable(XWalkView xWalkView, String str, Message message) {
        AppMethodBeat.i(154972);
        try {
            this.onIconAvailableXWalkViewInternalStringMessageMethod.invoke(xWalkView.getBridge(), str, message);
            AppMethodBeat.o(154972);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154972);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154972);
        }
    }

    public void onReceivedIcon(XWalkView xWalkView, String str, Bitmap bitmap) {
        AppMethodBeat.i(154973);
        try {
            this.onReceivedIconXWalkViewInternalStringBitmapMethod.invoke(xWalkView.getBridge(), str, bitmap);
            AppMethodBeat.o(154973);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154973);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154973);
        }
    }

    public void onRequestFocus(XWalkView xWalkView) {
        AppMethodBeat.i(154974);
        try {
            this.onRequestFocusXWalkViewInternalMethod.invoke(xWalkView.getBridge());
            AppMethodBeat.o(154974);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154974);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154974);
        }
    }

    public void onJavascriptCloseWindow(XWalkView xWalkView) {
        AppMethodBeat.i(154975);
        try {
            this.onJavascriptCloseWindowXWalkViewInternalMethod.invoke(xWalkView.getBridge());
            AppMethodBeat.o(154975);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154975);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154975);
        }
    }

    public boolean onJavascriptModalDialog(XWalkView xWalkView, JavascriptMessageType javascriptMessageType, String str, String str2, String str3, XWalkJavascriptResult xWalkJavascriptResult) {
        AppMethodBeat.i(154976);
        try {
            boolean booleanValue = ((Boolean) this.onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod.invoke(xWalkView.getBridge(), ConvertJavascriptMessageType(javascriptMessageType), str, str2, str3, ((XWalkJavascriptResultHandler) xWalkJavascriptResult).getBridge())).booleanValue();
            AppMethodBeat.o(154976);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154976);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154976);
            return false;
        }
    }

    public void onFullscreenToggled(XWalkView xWalkView, boolean z) {
        AppMethodBeat.i(154977);
        try {
            this.onFullscreenToggledXWalkViewInternalbooleanMethod.invoke(xWalkView.getBridge(), Boolean.valueOf(z));
            AppMethodBeat.o(154977);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154977);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154977);
        }
    }

    public void openFileChooser(XWalkView xWalkView, ValueCallback<Uri> valueCallback, String str, String str2) {
        AppMethodBeat.i(154978);
        try {
            this.openFileChooserXWalkViewInternalValueCallbackStringStringMethod.invoke(xWalkView.getBridge(), valueCallback, str, str2);
            AppMethodBeat.o(154978);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154978);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154978);
        }
    }

    public boolean onShowFileChooser(XWalkView xWalkView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        AppMethodBeat.i(207393);
        try {
            boolean booleanValue = ((Boolean) this.onShowFileChooserXWalkViewInternalValueCallbackStringStringMethod.invoke(xWalkView.getBridge(), valueCallback, fileChooserParams)).booleanValue();
            AppMethodBeat.o(207393);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(207393);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(207393);
            return false;
        }
    }

    public void onScaleChanged(XWalkView xWalkView, float f2, float f3) {
        AppMethodBeat.i(154979);
        try {
            this.onScaleChangedXWalkViewInternalfloatfloatMethod.invoke(xWalkView.getBridge(), Float.valueOf(f2), Float.valueOf(f3));
            AppMethodBeat.o(154979);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154979);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154979);
        }
    }

    public boolean shouldOverrideKeyEvent(XWalkView xWalkView, KeyEvent keyEvent) {
        AppMethodBeat.i(154980);
        try {
            boolean booleanValue = ((Boolean) this.shouldOverrideKeyEventXWalkViewInternalKeyEventMethod.invoke(xWalkView.getBridge(), keyEvent)).booleanValue();
            AppMethodBeat.o(154980);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154980);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154980);
            return false;
        }
    }

    public void onUnhandledKeyEvent(XWalkView xWalkView, KeyEvent keyEvent) {
        AppMethodBeat.i(154981);
        try {
            this.onUnhandledKeyEventXWalkViewInternalKeyEventMethod.invoke(xWalkView.getBridge(), keyEvent);
            AppMethodBeat.o(154981);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154981);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154981);
        }
    }

    public boolean onConsoleMessage(XWalkView xWalkView, String str, int i2, String str2, ConsoleMessageType consoleMessageType) {
        AppMethodBeat.i(154982);
        try {
            boolean booleanValue = ((Boolean) this.onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod.invoke(xWalkView.getBridge(), str, Integer.valueOf(i2), str2, ConvertConsoleMessageType(consoleMessageType))).booleanValue();
            AppMethodBeat.o(154982);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154982);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154982);
            return false;
        }
    }

    public void onReceivedTitle(XWalkView xWalkView, String str) {
        AppMethodBeat.i(154983);
        try {
            this.onReceivedTitleXWalkViewInternalStringMethod.invoke(xWalkView.getBridge(), str);
            AppMethodBeat.o(154983);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154983);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154983);
        }
    }

    public void onPageLoadStarted(XWalkView xWalkView, String str) {
        AppMethodBeat.i(154984);
        try {
            this.onPageLoadStartedXWalkViewInternalStringMethod.invoke(xWalkView.getBridge(), str);
            AppMethodBeat.o(154984);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154984);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154984);
        }
    }

    public void onPageLoadStopped(XWalkView xWalkView, String str, LoadStatus loadStatus) {
        AppMethodBeat.i(154985);
        try {
            this.onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod.invoke(xWalkView.getBridge(), str, ConvertLoadStatus(loadStatus));
            AppMethodBeat.o(154985);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154985);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154985);
        }
    }

    public void onPageCommitVisible(XWalkView xWalkView, String str) {
        AppMethodBeat.i(154986);
        try {
            this.onPageCommitVisibleXWalkViewInternalStringMethod.invoke(xWalkView.getBridge(), str);
            AppMethodBeat.o(154986);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154986);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154986);
        }
    }

    public boolean onJsAlert(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
        AppMethodBeat.i(154987);
        try {
            boolean booleanValue = ((Boolean) this.onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.invoke(xWalkView.getBridge(), str, str2, ((XWalkJavascriptResultHandler) xWalkJavascriptResult).getBridge())).booleanValue();
            AppMethodBeat.o(154987);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154987);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154987);
            return false;
        }
    }

    public boolean onJsConfirm(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
        AppMethodBeat.i(154988);
        try {
            boolean booleanValue = ((Boolean) this.onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.invoke(xWalkView.getBridge(), str, str2, ((XWalkJavascriptResultHandler) xWalkJavascriptResult).getBridge())).booleanValue();
            AppMethodBeat.o(154988);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154988);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154988);
            return false;
        }
    }

    public boolean onJsPrompt(XWalkView xWalkView, String str, String str2, String str3, XWalkJavascriptResult xWalkJavascriptResult) {
        AppMethodBeat.i(154989);
        try {
            boolean booleanValue = ((Boolean) this.onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod.invoke(xWalkView.getBridge(), str, str2, str3, ((XWalkJavascriptResultHandler) xWalkJavascriptResult).getBridge())).booleanValue();
            AppMethodBeat.o(154989);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154989);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154989);
            return false;
        }
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        AppMethodBeat.i(154990);
        try {
            this.onShowCustomViewViewCustomViewCallbackInternalMethod.invoke(view, ((CustomViewCallbackHandler) customViewCallback).getBridge());
            AppMethodBeat.o(154990);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154990);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154990);
        }
    }

    public void onShowCustomView(View view, int i2, CustomViewCallback customViewCallback) {
        AppMethodBeat.i(154991);
        try {
            this.onShowCustomViewViewintCustomViewCallbackInternalMethod.invoke(view, Integer.valueOf(i2), ((CustomViewCallbackHandler) customViewCallback).getBridge());
            AppMethodBeat.o(154991);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154991);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154991);
        }
    }

    public void onHideCustomView() {
        AppMethodBeat.i(154992);
        try {
            this.onHideCustomViewMethod.invoke(new Object[0]);
            AppMethodBeat.o(154992);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154992);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154992);
        }
    }

    public void onExitFullscreenVideo(Bitmap bitmap) {
    }

    public void onGeolocationPermissionsShowPrompt(String str, XWalkGeolocationPermissionsCallback xWalkGeolocationPermissionsCallback) {
        AppMethodBeat.i(154993);
        try {
            this.onGeolocationPermissionsShowPromptStringXWalkGeolocationPermissionsCallbackInternalMethod.invoke(str, ((XWalkGeolocationPermissionsCallbackHandler) xWalkGeolocationPermissionsCallback).getBridge());
            AppMethodBeat.o(154993);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154993);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154993);
        }
    }

    public void onGeolocationPermissionsHidePrompt() {
        AppMethodBeat.i(154994);
        try {
            this.onGeolocationPermissionsHidePromptMethod.invoke(new Object[0]);
            AppMethodBeat.o(154994);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154994);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154994);
        }
    }

    public View getVideoLoadingProgressView() {
        AppMethodBeat.i(154995);
        try {
            View view = (View) this.getVideoLoadingProgressViewMethod.invoke(new Object[0]);
            AppMethodBeat.o(154995);
            return view;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154995);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154995);
            return null;
        }
    }

    public boolean onGetTranslateString(XWalkView xWalkView, Map<String, String> map) {
        AppMethodBeat.i(154996);
        try {
            boolean booleanValue = ((Boolean) this.onGetTranslateStringXWalkViewInternalMapCallbackMethod.invoke(xWalkView.getBridge(), map)).booleanValue();
            AppMethodBeat.o(154996);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154996);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154996);
            return false;
        }
    }

    public boolean OnGetSampleString(XWalkView xWalkView, Map<String, String> map) {
        AppMethodBeat.i(154997);
        try {
            boolean booleanValue = ((Boolean) this.OnGetSampleStringXWalkViewInternalMapCallbackMethod.invoke(xWalkView.getBridge(), map)).booleanValue();
            AppMethodBeat.o(154997);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154997);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154997);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(154998);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(154998);
            return;
        }
        int size = this.constructorTypes.size();
        Class[] clsArr = new Class[(size + 1)];
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = this.constructorTypes.get(i2);
            if (obj instanceof String) {
                clsArr[i2] = this.coreWrapper.getBridgeClass((String) obj);
                this.constructorParams.set(i2, this.coreWrapper.getBridgeObject(this.constructorParams.get(i2)));
            } else if (obj instanceof Class) {
                clsArr[i2] = (Class) obj;
            } else if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(154998);
                throw assertionError;
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkUIClientBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.enumJavascriptMessageTypeClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$JavascriptMessageTypeInternal"), "valueOf", String.class);
            this.enumConsoleMessageTypeClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$ConsoleMessageType"), "valueOf", String.class);
            this.enumInitiateByClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$InitiateByInternal"), "valueOf", String.class);
            this.enumLoadStatusClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$LoadStatusInternal"), "valueOf", String.class);
            this.onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod.init(this.bridge, null, "onCreateWindowRequestedSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkUIClientInternal$InitiateByInternal"), ValueCallback.class);
            this.onDidChangeThemeColorXWalkViewInternalStringMessageMethod.init(this.bridge, null, "onDidChangeThemeColorSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), Integer.TYPE);
            this.onIconAvailableXWalkViewInternalStringMessageMethod.init(this.bridge, null, "onIconAvailableSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Message.class);
            this.onReceivedIconXWalkViewInternalStringBitmapMethod.init(this.bridge, null, "onReceivedIconSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Bitmap.class);
            this.onRequestFocusXWalkViewInternalMethod.init(this.bridge, null, "onRequestFocusSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"));
            this.onJavascriptCloseWindowXWalkViewInternalMethod.init(this.bridge, null, "onJavascriptCloseWindowSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"));
            this.onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, null, "onJavascriptModalDialogSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkUIClientInternal$JavascriptMessageTypeInternal"), String.class, String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge"));
            this.onFullscreenToggledXWalkViewInternalbooleanMethod.init(this.bridge, null, "onFullscreenToggledSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), Boolean.TYPE);
            this.openFileChooserXWalkViewInternalValueCallbackStringStringMethod.init(this.bridge, null, "openFileChooserSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), ValueCallback.class, String.class, String.class);
            this.onShowFileChooserXWalkViewInternalValueCallbackStringStringMethod.init(this.bridge, null, "onShowFileChooser", this.coreWrapper.getBridgeClass("XWalkViewBridge"), ValueCallback.class, WebChromeClient.FileChooserParams.class);
            this.onScaleChangedXWalkViewInternalfloatfloatMethod.init(this.bridge, null, "onScaleChangedSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), Float.TYPE, Float.TYPE);
            this.shouldOverrideKeyEventXWalkViewInternalKeyEventMethod.init(this.bridge, null, "shouldOverrideKeyEventSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), KeyEvent.class);
            this.onUnhandledKeyEventXWalkViewInternalKeyEventMethod.init(this.bridge, null, "onUnhandledKeyEventSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), KeyEvent.class);
            this.onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod.init(this.bridge, null, "onConsoleMessageSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Integer.TYPE, String.class, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$ConsoleMessageType"));
            this.onReceivedTitleXWalkViewInternalStringMethod.init(this.bridge, null, "onReceivedTitleSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class);
            this.onPageLoadStartedXWalkViewInternalStringMethod.init(this.bridge, null, "onPageLoadStartedSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class);
            this.onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod.init(this.bridge, null, "onPageLoadStoppedSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$LoadStatusInternal"));
            this.onPageCommitVisibleXWalkViewInternalStringMethod.init(this.bridge, null, "onPageCommitVisibleSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class);
            this.onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, null, "onJsAlertSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge"));
            this.onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, null, "onJsConfirmSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge"));
            this.onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, null, "onJsPromptSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge"));
            this.onShowCustomViewViewCustomViewCallbackInternalMethod.init(this.bridge, null, "onShowCustomViewSuper", View.class, this.coreWrapper.getBridgeClass("CustomViewCallbackHandlerBridge"));
            this.onShowCustomViewViewintCustomViewCallbackInternalMethod.init(this.bridge, null, "onShowCustomViewSuper", View.class, Integer.TYPE, this.coreWrapper.getBridgeClass("CustomViewCallbackHandlerBridge"));
            this.onHideCustomViewMethod.init(this.bridge, null, "onHideCustomViewSuper", new Class[0]);
            this.onGeolocationPermissionsShowPromptStringXWalkGeolocationPermissionsCallbackInternalMethod.init(this.bridge, null, "onGeolocationPermissionsShowPromptSuper", String.class, this.coreWrapper.getBridgeClass("XWalkGeolocationPermissionsCallbackHandlerBridge"));
            this.onGeolocationPermissionsHidePromptMethod.init(this.bridge, null, "onGeolocationPermissionsHidePromptSuper", new Class[0]);
            this.getVideoLoadingProgressViewMethod.init(this.bridge, null, "getVideoLoadingProgressView", new Class[0]);
            this.onSelectInfoChangedXWalkViewInternallongStringStringStringCallbackMethod.init(this.bridge, null, "onSelectInfoChanged", this.coreWrapper.getBridgeClass("XWalkViewBridge"), Long.TYPE, String.class, String.class, String.class);
            this.isSearchableMethod.init(this.bridge, null, "isSearchable", new Class[0]);
            this.onShowSosMethod.init(this.bridge, null, "onShowSos", new Class[0]);
            this.onSearchWordXWalkViewInternalStringStringStringCallbackMethod.init(this.bridge, null, "onSearchWord", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, String.class);
            this.onGetTranslateStringXWalkViewInternalMapCallbackMethod.init(this.bridge, null, "onGetTranslateString", this.coreWrapper.getBridgeClass("XWalkViewBridge"), Map.class);
            this.OnGetSampleStringXWalkViewInternalMapCallbackMethod.init(this.bridge, null, "OnGetSampleString", this.coreWrapper.getBridgeClass("XWalkViewBridge"), Map.class);
            AppMethodBeat.o(154998);
        } catch (UnsupportedOperationException e2) {
            AppMethodBeat.o(154998);
        }
    }
}
