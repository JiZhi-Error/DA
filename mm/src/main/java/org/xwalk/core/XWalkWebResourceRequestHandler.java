package org.xwalk.core;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Map;

public class XWalkWebResourceRequestHandler implements XWalkWebResourceRequest {
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod getMethodMethod = new ReflectMethod((Class<?>) null, "getMethod", (Class<?>[]) new Class[0]);
    private ReflectMethod getRequestHeadersMethod = new ReflectMethod((Class<?>) null, "getRequestHeaders", (Class<?>[]) new Class[0]);
    private ReflectMethod getUrlMethod = new ReflectMethod((Class<?>) null, "getUrl", (Class<?>[]) new Class[0]);
    private ReflectMethod hasGestureMethod = new ReflectMethod((Class<?>) null, "hasGesture", (Class<?>[]) new Class[0]);
    private ReflectMethod isForMainFrameMethod = new ReflectMethod((Class<?>) null, "isForMainFrame", (Class<?>[]) new Class[0]);
    private ReflectMethod postWrapperMethod;

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkWebResourceRequestHandler(Object obj) {
        AppMethodBeat.i(155163);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.o(155163);
    }

    @Override // org.xwalk.core.XWalkWebResourceRequest
    public Uri getUrl() {
        AppMethodBeat.i(155164);
        try {
            Uri uri = (Uri) this.getUrlMethod.invoke(new Object[0]);
            AppMethodBeat.o(155164);
            return uri;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155164);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155164);
            return null;
        }
    }

    @Override // org.xwalk.core.XWalkWebResourceRequest
    public boolean isForMainFrame() {
        AppMethodBeat.i(155165);
        try {
            boolean booleanValue = ((Boolean) this.isForMainFrameMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(155165);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155165);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155165);
            return false;
        }
    }

    @Override // org.xwalk.core.XWalkWebResourceRequest
    public boolean hasGesture() {
        AppMethodBeat.i(155166);
        try {
            boolean booleanValue = ((Boolean) this.hasGestureMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(155166);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155166);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155166);
            return false;
        }
    }

    @Override // org.xwalk.core.XWalkWebResourceRequest
    public String getMethod() {
        AppMethodBeat.i(155167);
        try {
            String str = (String) this.getMethodMethod.invoke(new Object[0]);
            AppMethodBeat.o(155167);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155167);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155167);
            return null;
        }
    }

    @Override // org.xwalk.core.XWalkWebResourceRequest
    public Map<String, String> getRequestHeaders() {
        AppMethodBeat.i(155168);
        try {
            Map<String, String> map = (Map) this.getRequestHeadersMethod.invoke(new Object[0]);
            AppMethodBeat.o(155168);
            return map;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155168);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155168);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(155169);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(155169);
            return;
        }
        this.getUrlMethod.init(this.bridge, null, "getUrlSuper", new Class[0]);
        this.isForMainFrameMethod.init(this.bridge, null, "isForMainFrameSuper", new Class[0]);
        this.hasGestureMethod.init(this.bridge, null, "hasGestureSuper", new Class[0]);
        this.getMethodMethod.init(this.bridge, null, "getMethodSuper", new Class[0]);
        this.getRequestHeadersMethod.init(this.bridge, null, "getRequestHeadersSuper", new Class[0]);
        AppMethodBeat.o(155169);
    }
}
