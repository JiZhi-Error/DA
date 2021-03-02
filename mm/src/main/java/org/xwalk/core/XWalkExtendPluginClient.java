package org.xwalk.core;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;

public class XWalkExtendPluginClient {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkExtendPluginClient.class.desiredAssertionStatus());
    public static final String NATIVE_VIEW_TYPE = "native_view";
    private static final String TAG = "XWalkExtendPluginClient";
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes = new ArrayList<>();
    private XWalkCoreWrapper coreWrapper;
    private HashMap<Integer, XWalkExtendPluginNativeViewClient> mNativeViewClientMap = new HashMap<>();
    private ReflectMethod postWrapperMethod;
    private ReflectMethod setPluginTextureScaleStringintfloatfloatMethod = new ReflectMethod((Class<?>) null, "setPluginTextureScale", (Class<?>[]) new Class[0]);
    private ReflectMethod takePluginScreenshotStringintMethod = new ReflectMethod((Class<?>) null, "takePluginScreenshot", (Class<?>[]) new Class[0]);

    static {
        AppMethodBeat.i(154724);
        AppMethodBeat.o(154724);
    }

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkExtendPluginClient(XWalkView xWalkView) {
        AppMethodBeat.i(154721);
        this.constructorTypes.add("XWalkViewBridge");
        this.constructorParams = new ArrayList<>();
        this.constructorParams.add(xWalkView);
        reflectionInit();
        AppMethodBeat.o(154721);
    }

    public void onPluginManagerDestroy() {
        AppMethodBeat.i(183750);
        Log.i(TAG, "onPluginManagerDestroy");
        for (XWalkExtendPluginNativeViewClient xWalkExtendPluginNativeViewClient : this.mNativeViewClientMap.values()) {
            xWalkExtendPluginNativeViewClient.dispose();
        }
        this.mNativeViewClientMap.clear();
        AppMethodBeat.o(183750);
    }

    public XWalkExtendPluginNativeViewDelegate onNativeViewReady(int i2) {
        return null;
    }

    public void onPluginReady(String str, int i2, SurfaceTexture surfaceTexture) {
    }

    public void onPluginSizeChanged(String str, int i2, int i3, int i4, SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(183751);
        if (NATIVE_VIEW_TYPE.equals(str)) {
            if (!this.mNativeViewClientMap.containsKey(Integer.valueOf(i2))) {
                XWalkExtendPluginNativeViewDelegate onNativeViewReady = onNativeViewReady(i2);
                if (onNativeViewReady != null) {
                    XWalkExtendPluginNativeViewClient xWalkExtendPluginNativeViewClient = new XWalkExtendPluginNativeViewClient(null, surfaceTexture, i3, i4);
                    this.mNativeViewClientMap.put(Integer.valueOf(i2), xWalkExtendPluginNativeViewClient);
                    onNativeViewReady.setClient(xWalkExtendPluginNativeViewClient);
                    xWalkExtendPluginNativeViewClient.setDelegate(onNativeViewReady);
                } else {
                    Log.e(TAG, "onPluginSizeChanged onNativeViewReady return null");
                    AppMethodBeat.o(183751);
                    return;
                }
            }
            this.mNativeViewClientMap.get(Integer.valueOf(i2)).onSizeChanged(i3, i4);
        }
        AppMethodBeat.o(183751);
    }

    public void onPluginDestroy(String str, int i2) {
        AppMethodBeat.i(183752);
        if (NATIVE_VIEW_TYPE.equals(str) && this.mNativeViewClientMap.containsKey(Integer.valueOf(i2))) {
            this.mNativeViewClientMap.get(Integer.valueOf(i2)).dispose();
            this.mNativeViewClientMap.remove(Integer.valueOf(i2));
        }
        AppMethodBeat.o(183752);
    }

    public void onPluginTouch(String str, int i2, String str2) {
    }

    public void onPluginTouch(String str, int i2, MotionEvent motionEvent) {
        AppMethodBeat.i(183753);
        if (NATIVE_VIEW_TYPE.equals(str) && this.mNativeViewClientMap.containsKey(Integer.valueOf(i2))) {
            this.mNativeViewClientMap.get(Integer.valueOf(i2)).getRootView().dispatchTouchEvent(motionEvent);
        }
        AppMethodBeat.o(183753);
    }

    public void onPluginScreenshotTaken(String str, int i2, Bitmap bitmap) {
    }

    public void setPluginTextureScale(String str, int i2, float f2, float f3) {
        AppMethodBeat.i(154722);
        try {
            Log.i(TAG, "setPluginTextureScale embed_type:" + str + ",embed_id:" + i2 + ",xScale:" + f2 + ",yScale:" + f3);
            this.setPluginTextureScaleStringintfloatfloatMethod.invoke(str, Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3));
            AppMethodBeat.o(154722);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154722);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154722);
        }
    }

    public void takePluginScreenshot(String str, int i2) {
        AppMethodBeat.i(183754);
        try {
            this.takePluginScreenshotStringintMethod.invoke(str, Integer.valueOf(i2));
            AppMethodBeat.o(183754);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(183754);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(183754);
        }
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(154723);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(154723);
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
                AppMethodBeat.o(154723);
                throw assertionError;
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkExtendPluginClientBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.setPluginTextureScaleStringintfloatfloatMethod.init(this.bridge, null, "setPluginTextureScale", String.class, Integer.TYPE, Float.TYPE, Float.TYPE);
            this.takePluginScreenshotStringintMethod.init(this.bridge, null, "takePluginScreenshot", String.class, Integer.TYPE);
            AppMethodBeat.o(154723);
        } catch (UnsupportedOperationException e2) {
            AppMethodBeat.o(154723);
        }
    }
}
