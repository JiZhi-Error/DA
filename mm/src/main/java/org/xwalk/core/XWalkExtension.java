package org.xwalk.core;

import java.util.ArrayList;

public abstract class XWalkExtension {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkExtension.class.desiredAssertionStatus());
    private Object bridge;
    private ReflectMethod broadcastMessageStringMethod;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod onBinaryMessageintbyteArrayMethod;
    private ReflectMethod onInstanceCreatedintMethod;
    private ReflectMethod onInstanceDestroyedintMethod;
    private ReflectMethod postBinaryMessageintbyteArrayMethod;
    private ReflectMethod postMessageintStringMethod;
    private ReflectMethod postWrapperMethod;

    public abstract void onMessage(int i2, String str);

    public abstract String onSyncMessage(int i2, String str);

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkExtension(String str, String str2) {
        this.postMessageintStringMethod = new ReflectMethod((Class<?>) null, "postMessage", (Class<?>[]) new Class[0]);
        this.postBinaryMessageintbyteArrayMethod = new ReflectMethod((Class<?>) null, "postBinaryMessage", (Class<?>[]) new Class[0]);
        this.broadcastMessageStringMethod = new ReflectMethod((Class<?>) null, "broadcastMessage", (Class<?>[]) new Class[0]);
        this.onInstanceCreatedintMethod = new ReflectMethod((Class<?>) null, "onInstanceCreated", (Class<?>[]) new Class[0]);
        this.onInstanceDestroyedintMethod = new ReflectMethod((Class<?>) null, "onInstanceDestroyed", (Class<?>[]) new Class[0]);
        this.onBinaryMessageintbyteArrayMethod = new ReflectMethod((Class<?>) null, "onBinaryMessage", (Class<?>[]) new Class[0]);
        this.constructorTypes = new ArrayList<>();
        this.constructorTypes.add(String.class);
        this.constructorTypes.add(String.class);
        this.constructorParams = new ArrayList<>();
        this.constructorParams.add(str);
        this.constructorParams.add(str2);
        reflectionInit();
    }

    public XWalkExtension(String str, String str2, String[] strArr) {
        this.postMessageintStringMethod = new ReflectMethod((Class<?>) null, "postMessage", (Class<?>[]) new Class[0]);
        this.postBinaryMessageintbyteArrayMethod = new ReflectMethod((Class<?>) null, "postBinaryMessage", (Class<?>[]) new Class[0]);
        this.broadcastMessageStringMethod = new ReflectMethod((Class<?>) null, "broadcastMessage", (Class<?>[]) new Class[0]);
        this.onInstanceCreatedintMethod = new ReflectMethod((Class<?>) null, "onInstanceCreated", (Class<?>[]) new Class[0]);
        this.onInstanceDestroyedintMethod = new ReflectMethod((Class<?>) null, "onInstanceDestroyed", (Class<?>[]) new Class[0]);
        this.onBinaryMessageintbyteArrayMethod = new ReflectMethod((Class<?>) null, "onBinaryMessage", (Class<?>[]) new Class[0]);
        this.constructorTypes = new ArrayList<>();
        this.constructorTypes.add(String.class);
        this.constructorTypes.add(String.class);
        this.constructorTypes.add(String[].class);
        this.constructorParams = new ArrayList<>();
        this.constructorParams.add(str);
        this.constructorParams.add(str2);
        this.constructorParams.add(strArr);
        reflectionInit();
    }

    public void postMessage(int i2, String str) {
        try {
            this.postMessageintStringMethod.invoke(Integer.valueOf(i2), str);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
        }
    }

    public void postBinaryMessage(int i2, byte[] bArr) {
        try {
            this.postBinaryMessageintbyteArrayMethod.invoke(Integer.valueOf(i2), bArr);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
        }
    }

    public void broadcastMessage(String str) {
        try {
            this.broadcastMessageStringMethod.invoke(str);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
        }
    }

    public void onInstanceCreated(int i2) {
        try {
            this.onInstanceCreatedintMethod.invoke(Integer.valueOf(i2));
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
        }
    }

    public void onInstanceDestroyed(int i2) {
        try {
            this.onInstanceDestroyedintMethod.invoke(Integer.valueOf(i2));
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
        }
    }

    public void onBinaryMessage(int i2, byte[] bArr) {
        try {
            this.onBinaryMessageintbyteArrayMethod.invoke(Integer.valueOf(i2), bArr);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
        }
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
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkExtensionBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.postMessageintStringMethod.init(this.bridge, null, "postMessageSuper", Integer.TYPE, String.class);
            this.postBinaryMessageintbyteArrayMethod.init(this.bridge, null, "postBinaryMessageSuper", Integer.TYPE, byte[].class);
            this.broadcastMessageStringMethod.init(this.bridge, null, "broadcastMessageSuper", String.class);
            this.onInstanceCreatedintMethod.init(this.bridge, null, "onInstanceCreatedSuper", Integer.TYPE);
            this.onInstanceDestroyedintMethod.init(this.bridge, null, "onInstanceDestroyedSuper", Integer.TYPE);
            this.onBinaryMessageintbyteArrayMethod.init(this.bridge, null, "onBinaryMessageSuper", Integer.TYPE, byte[].class);
        } catch (UnsupportedOperationException e2) {
        }
    }
}
