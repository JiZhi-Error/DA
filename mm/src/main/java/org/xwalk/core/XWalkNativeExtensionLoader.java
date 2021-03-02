package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkNativeExtensionLoader {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkNativeExtensionLoader.class.desiredAssertionStatus());
    private Object bridge;
    private ArrayList<Object> constructorParams = new ArrayList<>();
    private ArrayList<Object> constructorTypes = new ArrayList<>();
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod postWrapperMethod;
    private ReflectMethod registerNativeExtensionsInPathStringMethod = new ReflectMethod((Class<?>) null, "registerNativeExtensionsInPath", (Class<?>[]) new Class[0]);

    static {
        AppMethodBeat.i(154808);
        AppMethodBeat.o(154808);
    }

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkNativeExtensionLoader() {
        AppMethodBeat.i(154805);
        reflectionInit();
        AppMethodBeat.o(154805);
    }

    public void registerNativeExtensionsInPath(String str) {
        AppMethodBeat.i(154806);
        try {
            this.registerNativeExtensionsInPathStringMethod.invoke(str);
            AppMethodBeat.o(154806);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154806);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154806);
        }
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(154807);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(154807);
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
                AppMethodBeat.o(154807);
                throw assertionError;
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkNativeExtensionLoaderBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.registerNativeExtensionsInPathStringMethod.init(this.bridge, null, "registerNativeExtensionsInPathSuper", String.class);
            AppMethodBeat.o(154807);
        } catch (UnsupportedOperationException e2) {
            AppMethodBeat.o(154807);
        }
    }
}
