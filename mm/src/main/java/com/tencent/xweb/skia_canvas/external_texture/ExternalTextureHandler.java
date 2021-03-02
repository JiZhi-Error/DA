package com.tencent.xweb.skia_canvas.external_texture;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ExternalTextureHandler implements ISkiaCanvasExternalTextureHandler {
    private volatile boolean mIsDestroyed;
    private volatile long mNativePeer;

    private native void nativeOnFrameAvailable(long j2);

    private native void nativeOnLoad(long j2, SurfaceTexture surfaceTexture, int i2, int i3);

    public static ExternalTextureHandler create(long j2) {
        AppMethodBeat.i(4313);
        ExternalTextureHandler externalTextureHandler = new ExternalTextureHandler(j2);
        AppMethodBeat.o(4313);
        return externalTextureHandler;
    }

    private ExternalTextureHandler(long j2) {
        this.mNativePeer = j2;
    }

    @Override // com.tencent.xweb.skia_canvas.external_texture.ISkiaCanvasExternalTextureHandler
    public synchronized void onFrameAvailable() {
        AppMethodBeat.i(4314);
        if (isValid()) {
            nativeOnFrameAvailable(this.mNativePeer);
        }
        AppMethodBeat.o(4314);
    }

    @Override // com.tencent.xweb.skia_canvas.external_texture.ISkiaCanvasExternalTextureHandler
    public void onLoad(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(4315);
        if (isValid()) {
            nativeOnLoad(this.mNativePeer, surfaceTexture, i2, i3);
        }
        AppMethodBeat.o(4315);
    }

    private boolean load(String str, int i2, String str2) {
        AppMethodBeat.i(174305);
        boolean load = SkiaCanvasExternalTextureManager.getInstance().load(this, str, i2, str2);
        AppMethodBeat.o(174305);
        return load;
    }

    private float[] updateImage(int i2, String str, int i3, String str2) {
        AppMethodBeat.i(174306);
        float[] updateImage = SkiaCanvasExternalTextureManager.getInstance().updateImage(this, i2, str, i3, str2);
        AppMethodBeat.o(174306);
        return updateImage;
    }

    private void onDestroy(String str, int i2, String str2) {
        AppMethodBeat.i(174307);
        SkiaCanvasExternalTextureManager.getInstance().onDestroy(this, str, i2, str2);
        AppMethodBeat.o(174307);
    }

    private boolean isValid() {
        return !this.mIsDestroyed;
    }

    private synchronized void notifyDestroyed(String str, int i2, String str2) {
        AppMethodBeat.i(174308);
        onDestroy(str, i2, str2);
        this.mIsDestroyed = true;
        AppMethodBeat.o(174308);
    }
}
