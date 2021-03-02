package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkExtendCanvasClient {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkExtendCanvasClient.class.desiredAssertionStatus());
    private static final String TAG = "XWalkExtendCanvasClient";
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes = new ArrayList<>();
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod postWrapperMethod;
    private ReflectMethod sendAsyncMethodsMethod = new ReflectMethod((Class<?>) null, "sendAsyncMethods", (Class<?>[]) new Class[0]);

    static {
        AppMethodBeat.i(154720);
        AppMethodBeat.o(154720);
    }

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkExtendCanvasClient(XWalkView xWalkView) {
        AppMethodBeat.i(154716);
        this.constructorTypes.add("XWalkViewBridge");
        this.constructorParams = new ArrayList<>();
        this.constructorParams.add(xWalkView);
        reflectionInit();
        AppMethodBeat.o(154716);
    }

    public void onCanvasTouch(String str, int i2, String str2) {
    }

    public void onAsycResultCallback(int i2, int i3, String str) {
    }

    public void onSendJsonMessage(String str) {
    }

    public void sendAsyncMethods(String str) {
        AppMethodBeat.i(154717);
        sendAsyncMethods(str, 0);
        AppMethodBeat.o(154717);
    }

    public void sendAsyncMethods(String str, int i2) {
        AppMethodBeat.i(154718);
        Log.d(TAG, "sendAsyncMethods called! methods:" + str + ",reply_id:" + i2);
        try {
            this.sendAsyncMethodsMethod.invoke(str, Integer.valueOf(i2));
            AppMethodBeat.o(154718);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154718);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154718);
        }
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(154719);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(154719);
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
                AppMethodBeat.o(154719);
                throw assertionError;
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkExtendCanvasClientBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.sendAsyncMethodsMethod.init(this.bridge, null, "sendAsyncMethods", String.class, Integer.TYPE);
            AppMethodBeat.o(154719);
        } catch (UnsupportedOperationException e2) {
            AppMethodBeat.o(154719);
        }
    }
}
