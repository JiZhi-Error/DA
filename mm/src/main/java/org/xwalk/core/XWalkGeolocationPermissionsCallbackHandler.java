package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkGeolocationPermissionsCallbackHandler implements XWalkGeolocationPermissionsCallback {
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod invokeStringbooleanbooleanMethod = new ReflectMethod((Class<?>) null, "invoke", (Class<?>[]) new Class[0]);
    private ReflectMethod postWrapperMethod;

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkGeolocationPermissionsCallbackHandler(Object obj) {
        AppMethodBeat.i(154734);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.o(154734);
    }

    @Override // org.xwalk.core.XWalkGeolocationPermissionsCallback
    public void invoke(String str, boolean z, boolean z2) {
        AppMethodBeat.i(154735);
        try {
            this.invokeStringbooleanbooleanMethod.invoke(str, Boolean.valueOf(z), Boolean.valueOf(z2));
            AppMethodBeat.o(154735);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154735);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154735);
        }
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(154736);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(154736);
            return;
        }
        this.invokeStringbooleanbooleanMethod.init(this.bridge, null, "invokeSuper", String.class, Boolean.TYPE, Boolean.TYPE);
        AppMethodBeat.o(154736);
    }
}
