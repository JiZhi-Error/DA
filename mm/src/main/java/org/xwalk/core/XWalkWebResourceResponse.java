package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

public class XWalkWebResourceResponse {
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod getDataMethod = new ReflectMethod((Class<?>) null, "getData", (Class<?>[]) new Class[0]);
    private ReflectMethod getEncodingMethod = new ReflectMethod((Class<?>) null, "getEncoding", (Class<?>[]) new Class[0]);
    private ReflectMethod getMimeTypeMethod = new ReflectMethod((Class<?>) null, "getMimeType", (Class<?>[]) new Class[0]);
    private ReflectMethod getReasonPhraseMethod = new ReflectMethod((Class<?>) null, "getReasonPhrase", (Class<?>[]) new Class[0]);
    private ReflectMethod getResponseHeadersMethod = new ReflectMethod((Class<?>) null, "getResponseHeaders", (Class<?>[]) new Class[0]);
    private ReflectMethod getStatusCodeMethod = new ReflectMethod((Class<?>) null, "getStatusCode", (Class<?>[]) new Class[0]);
    private ReflectMethod postWrapperMethod;
    private ReflectMethod setDataInputStreamMethod = new ReflectMethod((Class<?>) null, "setData", (Class<?>[]) new Class[0]);
    private ReflectMethod setEncodingStringMethod = new ReflectMethod((Class<?>) null, "setEncoding", (Class<?>[]) new Class[0]);
    private ReflectMethod setMimeTypeStringMethod = new ReflectMethod((Class<?>) null, "setMimeType", (Class<?>[]) new Class[0]);
    private ReflectMethod setResponseHeadersMapMethod = new ReflectMethod((Class<?>) null, "setResponseHeaders", (Class<?>[]) new Class[0]);
    private ReflectMethod setStatusCodeAndReasonPhraseintStringMethod = new ReflectMethod((Class<?>) null, "setStatusCodeAndReasonPhrase", (Class<?>[]) new Class[0]);

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkWebResourceResponse(Object obj) {
        AppMethodBeat.i(155170);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.o(155170);
    }

    public void setMimeType(String str) {
        AppMethodBeat.i(155171);
        try {
            this.setMimeTypeStringMethod.invoke(str);
            AppMethodBeat.o(155171);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155171);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155171);
        }
    }

    public String getMimeType() {
        AppMethodBeat.i(155172);
        try {
            String str = (String) this.getMimeTypeMethod.invoke(new Object[0]);
            AppMethodBeat.o(155172);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155172);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155172);
            return null;
        }
    }

    public void setEncoding(String str) {
        AppMethodBeat.i(155173);
        try {
            this.setEncodingStringMethod.invoke(str);
            AppMethodBeat.o(155173);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155173);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155173);
        }
    }

    public String getEncoding() {
        AppMethodBeat.i(155174);
        try {
            String str = (String) this.getEncodingMethod.invoke(new Object[0]);
            AppMethodBeat.o(155174);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155174);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155174);
            return null;
        }
    }

    public void setData(InputStream inputStream) {
        AppMethodBeat.i(155175);
        try {
            this.setDataInputStreamMethod.invoke(inputStream);
            AppMethodBeat.o(155175);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155175);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155175);
        }
    }

    public InputStream getData() {
        AppMethodBeat.i(155176);
        try {
            InputStream inputStream = (InputStream) this.getDataMethod.invoke(new Object[0]);
            AppMethodBeat.o(155176);
            return inputStream;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155176);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155176);
            return null;
        }
    }

    public void setStatusCodeAndReasonPhrase(int i2, String str) {
        AppMethodBeat.i(155177);
        try {
            this.setStatusCodeAndReasonPhraseintStringMethod.invoke(Integer.valueOf(i2), str);
            AppMethodBeat.o(155177);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155177);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155177);
        }
    }

    public int getStatusCode() {
        AppMethodBeat.i(155178);
        try {
            int intValue = ((Integer) this.getStatusCodeMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(155178);
            return intValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155178);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155178);
            return 0;
        }
    }

    public String getReasonPhrase() {
        AppMethodBeat.i(155179);
        try {
            String str = (String) this.getReasonPhraseMethod.invoke(new Object[0]);
            AppMethodBeat.o(155179);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155179);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155179);
            return null;
        }
    }

    public void setResponseHeaders(Map<String, String> map) {
        AppMethodBeat.i(155180);
        try {
            this.setResponseHeadersMapMethod.invoke(map);
            AppMethodBeat.o(155180);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155180);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155180);
        }
    }

    public Map<String, String> getResponseHeaders() {
        AppMethodBeat.i(155181);
        try {
            Map<String, String> map = (Map) this.getResponseHeadersMethod.invoke(new Object[0]);
            AppMethodBeat.o(155181);
            return map;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155181);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155181);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(155182);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(155182);
            return;
        }
        this.setMimeTypeStringMethod.init(this.bridge, null, "setMimeTypeSuper", String.class);
        this.getMimeTypeMethod.init(this.bridge, null, "getMimeTypeSuper", new Class[0]);
        this.setEncodingStringMethod.init(this.bridge, null, "setEncodingSuper", String.class);
        this.getEncodingMethod.init(this.bridge, null, "getEncodingSuper", new Class[0]);
        this.setDataInputStreamMethod.init(this.bridge, null, "setDataSuper", InputStream.class);
        this.getDataMethod.init(this.bridge, null, "getDataSuper", new Class[0]);
        this.setStatusCodeAndReasonPhraseintStringMethod.init(this.bridge, null, "setStatusCodeAndReasonPhraseSuper", Integer.TYPE, String.class);
        this.getStatusCodeMethod.init(this.bridge, null, "getStatusCodeSuper", new Class[0]);
        this.getReasonPhraseMethod.init(this.bridge, null, "getReasonPhraseSuper", new Class[0]);
        this.setResponseHeadersMapMethod.init(this.bridge, null, "setResponseHeadersSuper", Map.class);
        this.getResponseHeadersMethod.init(this.bridge, null, "getResponseHeadersSuper", new Class[0]);
        AppMethodBeat.o(155182);
    }
}
