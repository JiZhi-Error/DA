package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkHitTestResult {
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod enumtypeClassValueOfMethod = new ReflectMethod();
    private ReflectMethod getExtraMethod = new ReflectMethod((Class<?>) null, "getExtra", (Class<?>[]) new Class[0]);
    private ReflectMethod getTypeMethod = new ReflectMethod((Class<?>) null, "getType", (Class<?>[]) new Class[0]);
    private ReflectMethod postWrapperMethod;

    public enum type {
        UNKNOWN_TYPE,
        ANCHOR_TYPE,
        PHONE_TYPE,
        GEO_TYPE,
        EMAIL_TYPE,
        IMAGE_TYPE,
        IMAGE_ANCHOR_TYPE,
        SRC_ANCHOR_TYPE,
        SRC_IMAGE_ANCHOR_TYPE,
        EDIT_TEXT_TYPE;

        public static type valueOf(String str) {
            AppMethodBeat.i(154738);
            type type = (type) Enum.valueOf(type.class, str);
            AppMethodBeat.o(154738);
            return type;
        }

        static {
            AppMethodBeat.i(154739);
            AppMethodBeat.o(154739);
        }
    }

    private Object Converttype(type type2) {
        AppMethodBeat.i(154740);
        Object invoke = this.enumtypeClassValueOfMethod.invoke(type2.toString());
        AppMethodBeat.o(154740);
        return invoke;
    }

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkHitTestResult(Object obj) {
        AppMethodBeat.i(154741);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.o(154741);
    }

    public type getType() {
        AppMethodBeat.i(154742);
        try {
            type valueOf = type.valueOf(this.getTypeMethod.invoke(new Object[0]).toString());
            AppMethodBeat.o(154742);
            return valueOf;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154742);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154742);
            return null;
        }
    }

    public String getExtra() {
        AppMethodBeat.i(154743);
        try {
            String str = (String) this.getExtraMethod.invoke(new Object[0]);
            AppMethodBeat.o(154743);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154743);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154743);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(154744);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(154744);
            return;
        }
        this.enumtypeClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkHitTestResultInternal$type"), "valueOf", String.class);
        this.getTypeMethod.init(this.bridge, null, "getTypeSuper", new Class[0]);
        this.getExtraMethod.init(this.bridge, null, "getExtraSuper", new Class[0]);
        AppMethodBeat.o(154744);
    }
}
