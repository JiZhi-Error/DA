package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkHttpAuthHandler implements XWalkHttpAuth {
    private Object bridge;
    private ReflectMethod cancelMethod = new ReflectMethod((Class<?>) null, "cancel", (Class<?>[]) new Class[0]);
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod isFirstAttemptMethod = new ReflectMethod((Class<?>) null, "isFirstAttempt", (Class<?>[]) new Class[0]);
    private ReflectMethod postWrapperMethod;
    private ReflectMethod proceedStringStringMethod = new ReflectMethod((Class<?>) null, "proceed", (Class<?>[]) new Class[0]);

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkHttpAuthHandler(Object obj) {
        AppMethodBeat.i(154745);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.o(154745);
    }

    @Override // org.xwalk.core.XWalkHttpAuth
    public void proceed(String str, String str2) {
        AppMethodBeat.i(154746);
        try {
            this.proceedStringStringMethod.invoke(str, str2);
            AppMethodBeat.o(154746);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154746);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154746);
        }
    }

    @Override // org.xwalk.core.XWalkHttpAuth
    public void cancel() {
        AppMethodBeat.i(154747);
        try {
            this.cancelMethod.invoke(new Object[0]);
            AppMethodBeat.o(154747);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154747);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154747);
        }
    }

    @Override // org.xwalk.core.XWalkHttpAuth
    public boolean isFirstAttempt() {
        AppMethodBeat.i(154748);
        try {
            boolean booleanValue = ((Boolean) this.isFirstAttemptMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154748);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154748);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154748);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(154749);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(154749);
            return;
        }
        this.proceedStringStringMethod.init(this.bridge, null, "proceedSuper", String.class, String.class);
        this.cancelMethod.init(this.bridge, null, "cancelSuper", new Class[0]);
        this.isFirstAttemptMethod.init(this.bridge, null, "isFirstAttemptSuper", new Class[0]);
        AppMethodBeat.o(154749);
    }
}
