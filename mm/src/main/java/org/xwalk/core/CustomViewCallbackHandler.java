package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class CustomViewCallbackHandler implements CustomViewCallback {
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod onCustomViewHiddenMethod = new ReflectMethod((Class<?>) null, "onCustomViewHidden", (Class<?>[]) new Class[0]);
    private ReflectMethod postWrapperMethod;

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public CustomViewCallbackHandler(Object obj) {
        AppMethodBeat.i(154599);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.o(154599);
    }

    @Override // org.xwalk.core.CustomViewCallback
    public void onCustomViewHidden() {
        AppMethodBeat.i(154600);
        try {
            this.onCustomViewHiddenMethod.invoke(new Object[0]);
            AppMethodBeat.o(154600);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154600);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154600);
        }
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(154601);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(154601);
            return;
        }
        this.onCustomViewHiddenMethod.init(this.bridge, null, "onCustomViewHiddenSuper", new Class[0]);
        AppMethodBeat.o(154601);
    }
}
