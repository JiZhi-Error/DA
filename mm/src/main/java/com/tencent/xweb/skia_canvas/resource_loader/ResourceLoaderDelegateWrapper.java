package com.tencent.xweb.skia_canvas.resource_loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.skia_canvas.resource_loader.IResourceLoader;

public class ResourceLoaderDelegateWrapper {
    private static final String TAG = "ResourceLoaderDelegateW";
    private final IResourceLoader mDelegate;
    private final Thread mThread = Thread.currentThread();

    private native void nativeCreatePeer();

    private native void nativeNotifyResourceLoad(int i2, byte[] bArr);

    static /* synthetic */ void access$000(ResourceLoaderDelegateWrapper resourceLoaderDelegateWrapper) {
        AppMethodBeat.i(217618);
        resourceLoaderDelegateWrapper.checkRunningThread();
        AppMethodBeat.o(217618);
    }

    static /* synthetic */ void access$100(ResourceLoaderDelegateWrapper resourceLoaderDelegateWrapper, int i2, byte[] bArr) {
        AppMethodBeat.i(217619);
        resourceLoaderDelegateWrapper.nativeNotifyResourceLoad(i2, bArr);
        AppMethodBeat.o(217619);
    }

    ResourceLoaderDelegateWrapper(IResourceLoader iResourceLoader) {
        AppMethodBeat.i(217614);
        this.mDelegate = iResourceLoader;
        nativeCreatePeer();
        AppMethodBeat.o(217614);
    }

    private void checkRunningThread() {
        AppMethodBeat.i(217615);
        if (Thread.currentThread() != this.mThread) {
            IllegalStateException illegalStateException = new IllegalStateException("Any method should be run at thread " + this.mThread);
            AppMethodBeat.o(217615);
            throw illegalStateException;
        }
        AppMethodBeat.o(217615);
    }

    public byte[] loadResource(String str, String str2) {
        AppMethodBeat.i(217616);
        String.format("loadResource path:%s, referrerPolicy:%s, delegate: %s", str, str2, this.mDelegate);
        byte[] loadResource = this.mDelegate.loadResource(str, str2);
        if (loadResource == null) {
            byte[] bArr = new byte[0];
            AppMethodBeat.o(217616);
            return bArr;
        }
        AppMethodBeat.o(217616);
        return loadResource;
    }

    public void loadResourceAsync(final int i2, String str, String str2) {
        AppMethodBeat.i(217617);
        String.format("loadResourceAsync path:%s, referrerPolicy:%s, requestId: %d, delegate: %s", str, str2, Integer.valueOf(i2), this.mDelegate);
        this.mDelegate.loadResourceAsync(str, str2, new IResourceLoader.ResourceLoadCallback() {
            /* class com.tencent.xweb.skia_canvas.resource_loader.ResourceLoaderDelegateWrapper.AnonymousClass1 */

            @Override // com.tencent.xweb.skia_canvas.resource_loader.IResourceLoader.ResourceLoadCallback
            public void onResourceLoaded(byte[] bArr) {
                AppMethodBeat.i(217613);
                ResourceLoaderDelegateWrapper.access$000(ResourceLoaderDelegateWrapper.this);
                if (bArr == null) {
                    ResourceLoaderDelegateWrapper.access$100(ResourceLoaderDelegateWrapper.this, i2, new byte[0]);
                    AppMethodBeat.o(217613);
                    return;
                }
                ResourceLoaderDelegateWrapper.access$100(ResourceLoaderDelegateWrapper.this, i2, bArr);
                AppMethodBeat.o(217613);
            }
        });
        AppMethodBeat.o(217617);
    }
}
