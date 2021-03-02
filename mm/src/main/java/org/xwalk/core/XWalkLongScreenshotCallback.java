package org.xwalk.core;

import android.graphics.Bitmap;
import com.tencent.xweb.q;
import java.io.File;

public abstract class XWalkLongScreenshotCallback implements q {
    private Object bridge;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod getCacheFileDirMethod = new ReflectMethod((Class<?>) null, "", (Class<?>[]) new Class[0]);
    private ReflectMethod getMaxHeightSupportedMethod = new ReflectMethod((Class<?>) null, "", (Class<?>[]) new Class[0]);
    private ReflectMethod getResultFileDirMethod = new ReflectMethod((Class<?>) null, "", (Class<?>[]) new Class[0]);
    private ReflectMethod onLongScreenshotFinishedIntStringMethod = new ReflectMethod((Class<?>) null, "", (Class<?>[]) new Class[0]);
    private ReflectMethod overrideScreenshotBitmapMethod = new ReflectMethod((Class<?>) null, "", (Class<?>[]) new Class[0]);

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkLongScreenshotCallback() {
        reflectionInit();
    }

    @Override // com.tencent.xweb.q
    public void onLongScreenshotFinished(int i2, String str) {
        try {
            this.onLongScreenshotFinishedIntStringMethod.invoke(Integer.valueOf(i2), str);
        } catch (RuntimeException e2) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
        }
    }

    @Override // com.tencent.xweb.q
    public File getCacheFileDir() {
        try {
            return (File) this.getCacheFileDirMethod.invoke(new Object[0]);
        } catch (RuntimeException e2) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            return null;
        }
    }

    @Override // com.tencent.xweb.q
    public File getResultFileDir() {
        try {
            return (File) this.getResultFileDirMethod.invoke(new Object[0]);
        } catch (RuntimeException e2) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            return null;
        }
    }

    @Override // com.tencent.xweb.q
    public Bitmap overrideScreenshot(Bitmap bitmap) {
        try {
            return (Bitmap) this.overrideScreenshotBitmapMethod.invoke(bitmap);
        } catch (RuntimeException e2) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            return null;
        }
    }

    @Override // com.tencent.xweb.q
    public int getMaxHeightSupported() {
        try {
            return ((Integer) this.getMaxHeightSupportedMethod.invoke(new Object[0])).intValue();
        } catch (RuntimeException e2) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            return;
        }
        Class<?> bridgeClass = this.coreWrapper.getBridgeClass("XWalkLongScreenshotCallbackBridge");
        if (bridgeClass != null) {
            ReflectConstructor reflectConstructor = new ReflectConstructor(bridgeClass, Object.class);
            try {
                this.bridge = reflectConstructor.newInstance(this);
                this.onLongScreenshotFinishedIntStringMethod.init(this.bridge, null, "onLongScreenshotFinishedSuper", Integer.TYPE, String.class);
                this.getCacheFileDirMethod.init(this.bridge, null, "getCacheFileDirMethodSuper", new Class[0]);
                this.getResultFileDirMethod.init(this.bridge, null, "getResultFileDirMethodSuper", new Class[0]);
                this.overrideScreenshotBitmapMethod.init(this.bridge, null, "overrideScreenshotBitmapMethodSuper", Bitmap.class);
                this.getMaxHeightSupportedMethod.init(this.bridge, null, "getMaxHeightSupported", new Class[0]);
            } catch (UnsupportedOperationException e2) {
            }
        }
    }
}
