package org.xwalk.core;

import java.util.ArrayList;
import java.util.List;

public abstract class WebViewExtensionInterface {
    static final /* synthetic */ boolean $assertionsDisabled = (!WebViewExtensionInterface.class.desiredAssertionStatus());
    private Object bridge;
    private ArrayList<Object> constructorParams = new ArrayList<>();
    private ArrayList<Object> constructorTypes = new ArrayList<>();
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod postWrapperMethod;

    public abstract int getHostByName(String str, List<String> list);

    public abstract Object onMiscCallBack(String str, Object... objArr);

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public WebViewExtensionInterface() {
        reflectionInit();
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
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
                throw new AssertionError();
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("WebViewExtensionInterfaceBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
        } catch (UnsupportedOperationException e2) {
        }
    }
}
