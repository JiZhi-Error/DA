package org.xwalk.core;

import android.net.http.SslError;
import android.webkit.ValueCallback;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

public class XWalkResourceClient {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkResourceClient.class.desiredAssertionStatus());
    public static final int ERROR_AUTHENTICATION = -4;
    public static final int ERROR_BAD_URL = -12;
    public static final int ERROR_CONNECT = -6;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    public static final int ERROR_FILE = -13;
    public static final int ERROR_FILE_NOT_FOUND = -14;
    public static final int ERROR_HOST_LOOKUP = -2;
    public static final int ERROR_IO = -7;
    public static final int ERROR_OK = 0;
    public static final int ERROR_PROXY_AUTHENTICATION = -5;
    public static final int ERROR_REDIRECT_LOOP = -9;
    public static final int ERROR_TIMEOUT = -8;
    public static final int ERROR_TOO_MANY_REQUESTS = -15;
    public static final int ERROR_UNKNOWN = -1;
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes = new ArrayList<>();
    private XWalkCoreWrapper coreWrapper;
    private LazyReflectMethod createXWalkWebResourceResponseStringStringInputStreamMethod = new LazyReflectMethod((Class<?>) null, "createXWalkWebResourceResponse", (Class<?>[]) new Class[0]);
    private LazyReflectMethod createXWalkWebResourceResponseStringStringInputStreamintStringMapMethod = new LazyReflectMethod((Class<?>) null, "createXWalkWebResourceResponse", (Class<?>[]) new Class[0]);
    private LazyReflectMethod doUpdateVisitedHistoryXWalkViewInternalStringbooleanMethod = new LazyReflectMethod((Class<?>) null, "doUpdateVisitedHistory", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onDocumentLoadedInFrameXWalkViewInternallongMethod = new LazyReflectMethod((Class<?>) null, "onDocumentLoadedInFrame", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onLoadFinishedXWalkViewInternalStringMethod = new LazyReflectMethod((Class<?>) null, "onLoadFinished", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onLoadStartedXWalkViewInternalStringMethod = new LazyReflectMethod((Class<?>) null, "onLoadStarted", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onProgressChangedXWalkViewInternalintMethod = new LazyReflectMethod((Class<?>) null, "onProgressChanged", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onReceivedClientCertRequestXWalkViewInternalClientCertRequestInternalMethod = new LazyReflectMethod((Class<?>) null, "onReceivedClientCertRequest", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onReceivedHttpAuthRequestXWalkViewInternalXWalkHttpAuthHandlerInternalStringStringMethod = new LazyReflectMethod((Class<?>) null, "onReceivedHttpAuthRequest", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onReceivedLoadErrorXWalkViewInternalintStringStringMethod = new LazyReflectMethod((Class<?>) null, "onReceivedLoadError", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onReceivedResponseHeadersXWalkViewInternalXWalkWebResourceRequestInternalXWalkWebResourceResponseInternalMethod = new LazyReflectMethod((Class<?>) null, "onReceivedResponseHeaders", (Class<?>[]) new Class[0]);
    private LazyReflectMethod onReceivedSslErrorXWalkViewInternalValueCallbackSslErrorMethod = new LazyReflectMethod((Class<?>) null, "onReceivedSslError", (Class<?>[]) new Class[0]);
    private LazyReflectMethod postWrapperMethod;
    private LazyReflectMethod shouldInterceptLoadRequestXWalkViewInternalStringMethod = new LazyReflectMethod((Class<?>) null, "shouldInterceptLoadRequest", (Class<?>[]) new Class[0]);
    private LazyReflectMethod shouldInterceptLoadRequestXWalkViewInternalXWalkWebResourceRequestInternalMethod = new LazyReflectMethod((Class<?>) null, "shouldInterceptLoadRequest", (Class<?>[]) new Class[0]);
    private LazyReflectMethod shouldOverrideUrlLoadingXWalkViewInternalStringMethod = new LazyReflectMethod((Class<?>) null, "shouldOverrideUrlLoading", (Class<?>[]) new Class[0]);

    static {
        AppMethodBeat.i(154858);
        AppMethodBeat.o(154858);
    }

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkResourceClient(XWalkView xWalkView) {
        AppMethodBeat.i(154841);
        this.constructorTypes.add("XWalkViewBridge");
        this.constructorParams = new ArrayList<>();
        this.constructorParams.add(xWalkView);
        reflectionInit();
        AppMethodBeat.o(154841);
    }

    public void onDocumentLoadedInFrame(XWalkView xWalkView, long j2) {
        AppMethodBeat.i(154842);
        try {
            this.onDocumentLoadedInFrameXWalkViewInternallongMethod.invoke(xWalkView.getBridge(), Long.valueOf(j2));
            AppMethodBeat.o(154842);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154842);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154842);
        }
    }

    public void onLoadStarted(XWalkView xWalkView, String str) {
        AppMethodBeat.i(154843);
        try {
            this.onLoadStartedXWalkViewInternalStringMethod.invoke(xWalkView.getBridge(), str);
            AppMethodBeat.o(154843);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154843);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154843);
        }
    }

    public void onLoadFinished(XWalkView xWalkView, String str) {
        AppMethodBeat.i(154844);
        try {
            this.onLoadFinishedXWalkViewInternalStringMethod.invoke(xWalkView.getBridge(), str);
            AppMethodBeat.o(154844);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154844);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154844);
        }
    }

    public void onProgressChanged(XWalkView xWalkView, int i2) {
        AppMethodBeat.i(154845);
        try {
            this.onProgressChangedXWalkViewInternalintMethod.invoke(xWalkView.getBridge(), Integer.valueOf(i2));
            AppMethodBeat.o(154845);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154845);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154845);
        }
    }

    public WebResourceResponse shouldInterceptLoadRequest(XWalkView xWalkView, String str) {
        AppMethodBeat.i(154846);
        try {
            WebResourceResponse webResourceResponse = (WebResourceResponse) this.shouldInterceptLoadRequestXWalkViewInternalStringMethod.invoke(xWalkView.getBridge(), str);
            AppMethodBeat.o(154846);
            return webResourceResponse;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154846);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154846);
            return null;
        }
    }

    public XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView xWalkView, XWalkWebResourceRequest xWalkWebResourceRequest) {
        AppMethodBeat.i(154847);
        try {
            XWalkWebResourceResponse xWalkWebResourceResponse = (XWalkWebResourceResponse) this.coreWrapper.getWrapperObject(this.shouldInterceptLoadRequestXWalkViewInternalXWalkWebResourceRequestInternalMethod.invoke(xWalkView.getBridge(), ((XWalkWebResourceRequestHandler) xWalkWebResourceRequest).getBridge()));
            AppMethodBeat.o(154847);
            return xWalkWebResourceResponse;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154847);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154847);
            return null;
        }
    }

    public void onReceivedLoadError(XWalkView xWalkView, int i2, String str, String str2) {
        AppMethodBeat.i(154848);
        try {
            this.onReceivedLoadErrorXWalkViewInternalintStringStringMethod.invoke(xWalkView.getBridge(), Integer.valueOf(i2), str, str2);
            AppMethodBeat.o(154848);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154848);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154848);
        }
    }

    public boolean shouldOverrideUrlLoading(XWalkView xWalkView, String str) {
        AppMethodBeat.i(154849);
        try {
            boolean booleanValue = ((Boolean) this.shouldOverrideUrlLoadingXWalkViewInternalStringMethod.invoke(xWalkView.getBridge(), str)).booleanValue();
            AppMethodBeat.o(154849);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154849);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154849);
            return false;
        }
    }

    public boolean shouldOverrideUrlLoading(XWalkView xWalkView, String str, boolean z, boolean z2, boolean z3) {
        return false;
    }

    public void onReceivedSslError(XWalkView xWalkView, ValueCallback<Boolean> valueCallback, SslError sslError) {
        AppMethodBeat.i(154850);
        try {
            this.onReceivedSslErrorXWalkViewInternalValueCallbackSslErrorMethod.invoke(xWalkView.getBridge(), valueCallback, sslError);
            AppMethodBeat.o(154850);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154850);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154850);
        }
    }

    public void onReceivedHttpError(XWalkView xWalkView, XWalkWebResourceRequest xWalkWebResourceRequest, XWalkWebResourceResponse xWalkWebResourceResponse) {
    }

    public void onReceivedClientCertRequest(XWalkView xWalkView, ClientCertRequest clientCertRequest) {
        AppMethodBeat.i(154851);
        try {
            this.onReceivedClientCertRequestXWalkViewInternalClientCertRequestInternalMethod.invoke(xWalkView.getBridge(), ((ClientCertRequestHandler) clientCertRequest).getBridge());
            AppMethodBeat.o(154851);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154851);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154851);
        }
    }

    public void onReceivedResponseHeaders(XWalkView xWalkView, XWalkWebResourceRequest xWalkWebResourceRequest, XWalkWebResourceResponse xWalkWebResourceResponse) {
        AppMethodBeat.i(154852);
        try {
            this.onReceivedResponseHeadersXWalkViewInternalXWalkWebResourceRequestInternalXWalkWebResourceResponseInternalMethod.invoke(xWalkView.getBridge(), ((XWalkWebResourceRequestHandler) xWalkWebResourceRequest).getBridge(), xWalkWebResourceResponse.getBridge());
            AppMethodBeat.o(154852);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154852);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154852);
        }
    }

    public void doUpdateVisitedHistory(XWalkView xWalkView, String str, boolean z) {
        AppMethodBeat.i(154853);
        try {
            this.doUpdateVisitedHistoryXWalkViewInternalStringbooleanMethod.invoke(xWalkView.getBridge(), str, Boolean.valueOf(z));
            AppMethodBeat.o(154853);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154853);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154853);
        }
    }

    public void onReceivedHttpAuthRequest(XWalkView xWalkView, XWalkHttpAuthHandler xWalkHttpAuthHandler, String str, String str2) {
        AppMethodBeat.i(154854);
        try {
            this.onReceivedHttpAuthRequestXWalkViewInternalXWalkHttpAuthHandlerInternalStringStringMethod.invoke(xWalkView.getBridge(), xWalkHttpAuthHandler.getBridge(), str, str2);
            AppMethodBeat.o(154854);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154854);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154854);
        }
    }

    public XWalkWebResourceResponse createXWalkWebResourceResponse(String str, String str2, InputStream inputStream) {
        AppMethodBeat.i(154855);
        try {
            XWalkWebResourceResponse xWalkWebResourceResponse = (XWalkWebResourceResponse) this.coreWrapper.getWrapperObject(this.createXWalkWebResourceResponseStringStringInputStreamMethod.invoke(str, str2, inputStream));
            AppMethodBeat.o(154855);
            return xWalkWebResourceResponse;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154855);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154855);
            return null;
        }
    }

    public XWalkWebResourceResponse createXWalkWebResourceResponse(String str, String str2, InputStream inputStream, int i2, String str3, Map<String, String> map) {
        AppMethodBeat.i(154856);
        try {
            XWalkWebResourceResponse xWalkWebResourceResponse = (XWalkWebResourceResponse) this.coreWrapper.getWrapperObject(this.createXWalkWebResourceResponseStringStringInputStreamintStringMapMethod.invoke(str, str2, inputStream, Integer.valueOf(i2), str3, map));
            AppMethodBeat.o(154856);
            return xWalkWebResourceResponse;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154856);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154856);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(154857);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(154857);
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
                AppMethodBeat.o(154857);
                throw assertionError;
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkResourceClientBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.onDocumentLoadedInFrameXWalkViewInternallongMethod.init(this.bridge, null, "onDocumentLoadedInFrameSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), Long.TYPE);
            this.onLoadStartedXWalkViewInternalStringMethod.init(this.bridge, null, "onLoadStartedSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class);
            this.onLoadFinishedXWalkViewInternalStringMethod.init(this.bridge, null, "onLoadFinishedSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class);
            this.onProgressChangedXWalkViewInternalintMethod.init(this.bridge, null, "onProgressChangedSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), Integer.TYPE);
            this.shouldInterceptLoadRequestXWalkViewInternalStringMethod.init(this.bridge, null, "shouldInterceptLoadRequestSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class);
            this.shouldInterceptLoadRequestXWalkViewInternalXWalkWebResourceRequestInternalMethod.init(this.bridge, null, "shouldInterceptLoadRequestSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkWebResourceRequestHandlerBridge"));
            this.onReceivedLoadErrorXWalkViewInternalintStringStringMethod.init(this.bridge, null, "onReceivedLoadErrorSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), Integer.TYPE, String.class, String.class);
            this.shouldOverrideUrlLoadingXWalkViewInternalStringMethod.init(this.bridge, null, "shouldOverrideUrlLoadingSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class);
            this.onReceivedSslErrorXWalkViewInternalValueCallbackSslErrorMethod.init(this.bridge, null, "onReceivedSslErrorSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), ValueCallback.class, SslError.class);
            this.onReceivedClientCertRequestXWalkViewInternalClientCertRequestInternalMethod.init(this.bridge, null, "onReceivedClientCertRequestSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("ClientCertRequestHandlerBridge"));
            this.onReceivedResponseHeadersXWalkViewInternalXWalkWebResourceRequestInternalXWalkWebResourceResponseInternalMethod.init(this.bridge, null, "onReceivedResponseHeadersSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkWebResourceRequestHandlerBridge"), this.coreWrapper.getBridgeClass("XWalkWebResourceResponseBridge"));
            this.doUpdateVisitedHistoryXWalkViewInternalStringbooleanMethod.init(this.bridge, null, "doUpdateVisitedHistorySuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Boolean.TYPE);
            this.onReceivedHttpAuthRequestXWalkViewInternalXWalkHttpAuthHandlerInternalStringStringMethod.init(this.bridge, null, "onReceivedHttpAuthRequestSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkHttpAuthHandlerBridge"), String.class, String.class);
            this.createXWalkWebResourceResponseStringStringInputStreamMethod.init(this.bridge, null, "createXWalkWebResourceResponseSuper", String.class, String.class, InputStream.class);
            this.createXWalkWebResourceResponseStringStringInputStreamintStringMapMethod.init(this.bridge, null, "createXWalkWebResourceResponseSuper", String.class, String.class, InputStream.class, Integer.TYPE, String.class, Map.class);
            AppMethodBeat.o(154857);
        } catch (UnsupportedOperationException e2) {
            AppMethodBeat.o(154857);
        }
    }
}
