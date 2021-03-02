package org.xwalk.core;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import java.util.ArrayList;

public class XWalkV8 {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkV8.class.desiredAssertionStatus());
    private ReflectMethod addJavascriptInterfaceObjectStringMethod = new ReflectMethod((Class<?>) null, "addJavascriptInterface", (Class<?>[]) new Class[0]);
    private Object bridge;
    private ReflectMethod cleanupMethod = new ReflectMethod((Class<?>) null, "cleanup", (Class<?>[]) new Class[0]);
    private ArrayList<Object> constructorParams = new ArrayList<>();
    private ArrayList<Object> constructorTypes = new ArrayList<>();
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod evaluateJavascriptStringValueCallbackMethod = new ReflectMethod((Class<?>) null, "evaluateJavascript", (Class<?>[]) new Class[0]);
    private ReflectMethod initintMethod = new ReflectMethod((Class<?>) null, APMidasPluginInfo.LAUNCH_INTERFACE_INIT, (Class<?>[]) new Class[0]);
    private ReflectMethod postWrapperMethod;

    static {
        AppMethodBeat.i(155042);
        AppMethodBeat.o(155042);
    }

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkV8() {
        AppMethodBeat.i(155036);
        reflectionInit();
        AppMethodBeat.o(155036);
    }

    public void init(int i2) {
        AppMethodBeat.i(155037);
        try {
            this.initintMethod.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(155037);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155037);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155037);
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(155038);
        try {
            this.evaluateJavascriptStringValueCallbackMethod.invoke(str, valueCallback);
            AppMethodBeat.o(155038);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155038);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155038);
        }
    }

    public void cleanup() {
        AppMethodBeat.i(155039);
        try {
            this.cleanupMethod.invoke(new Object[0]);
            AppMethodBeat.o(155039);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155039);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155039);
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(155040);
        try {
            this.addJavascriptInterfaceObjectStringMethod.invoke(obj, str);
            AppMethodBeat.o(155040);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155040);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155040);
        }
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(155041);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(155041);
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
                AppMethodBeat.o(155041);
                throw assertionError;
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkV8Bridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.initintMethod.init(this.bridge, null, "initSuper", Integer.TYPE);
            this.evaluateJavascriptStringValueCallbackMethod.init(this.bridge, null, "evaluateJavascriptSuper", String.class, ValueCallback.class);
            this.cleanupMethod.init(this.bridge, null, "cleanupSuper", new Class[0]);
            this.addJavascriptInterfaceObjectStringMethod.init(this.bridge, null, "addJavascriptInterfaceSuper", Object.class, String.class);
            AppMethodBeat.o(155041);
        } catch (UnsupportedOperationException e2) {
            AppMethodBeat.o(155041);
        }
    }
}
