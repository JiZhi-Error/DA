package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkJavascriptResultHandler implements XWalkJavascriptResult {
    private Object bridge;
    private ReflectMethod cancelMethod = new ReflectMethod((Class<?>) null, "cancel", (Class<?>[]) new Class[0]);
    private ReflectMethod confirmMethod = new ReflectMethod((Class<?>) null, "confirm", (Class<?>[]) new Class[0]);
    private ReflectMethod confirmWithResultStringMethod = new ReflectMethod((Class<?>) null, "confirmWithResult", (Class<?>[]) new Class[0]);
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod postWrapperMethod;

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkJavascriptResultHandler(Object obj) {
        AppMethodBeat.i(154761);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.o(154761);
    }

    @Override // org.xwalk.core.XWalkJavascriptResult
    public void confirm() {
        AppMethodBeat.i(154762);
        try {
            this.confirmMethod.invoke(new Object[0]);
            AppMethodBeat.o(154762);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154762);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154762);
        }
    }

    @Override // org.xwalk.core.XWalkJavascriptResult
    public void confirmWithResult(String str) {
        AppMethodBeat.i(154763);
        try {
            this.confirmWithResultStringMethod.invoke(str);
            AppMethodBeat.o(154763);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154763);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154763);
        }
    }

    @Override // org.xwalk.core.XWalkJavascriptResult
    public void cancel() {
        AppMethodBeat.i(154764);
        try {
            this.cancelMethod.invoke(new Object[0]);
            AppMethodBeat.o(154764);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154764);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154764);
        }
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(154765);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(154765);
            return;
        }
        this.confirmMethod.init(this.bridge, null, "confirmSuper", new Class[0]);
        this.confirmWithResultStringMethod.init(this.bridge, null, "confirmWithResultSuper", String.class);
        this.cancelMethod.init(this.bridge, null, "cancelSuper", new Class[0]);
        AppMethodBeat.o(154765);
    }
}
