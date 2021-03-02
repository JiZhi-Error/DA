package org.xwalk.core;

import android.content.Context;
import java.util.ArrayList;

public abstract class XWalkDownloadListener {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkDownloadListener.class.desiredAssertionStatus());
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes = new ArrayList<>();
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod postWrapperMethod;

    public abstract void onDownloadStart(String str, String str2, String str3, String str4, long j2);

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkDownloadListener(Context context) {
        this.constructorTypes.add(Context.class);
        this.constructorParams = new ArrayList<>();
        this.constructorParams.add(context);
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
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkDownloadListenerBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
        } catch (UnsupportedOperationException e2) {
        }
    }
}
