package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.x5.export.external.extension.proxy.a;
import java.util.ArrayList;

public class XWalkProxyWebViewClientExtension extends a {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkProxyWebViewClientExtension.class.desiredAssertionStatus());
    private static final String TAG = "XWalkProxyWebViewClientExtension";
    private Object bridge;
    private ArrayList<Object> constructorParams = new ArrayList<>();
    private ArrayList<Object> constructorTypes = new ArrayList<>();
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod postWrapperMethod;

    static {
        AppMethodBeat.i(154840);
        AppMethodBeat.o(154840);
    }

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkProxyWebViewClientExtension() {
        AppMethodBeat.i(154838);
        reflectionInit();
        AppMethodBeat.o(154838);
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(154839);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(154839);
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
                AppMethodBeat.o(154839);
                throw assertionError;
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkProxyWebViewClientExtensionBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            AppMethodBeat.o(154839);
        } catch (UnsupportedOperationException e2) {
            AppMethodBeat.o(154839);
        }
    }
}
