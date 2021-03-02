package com.tencent.xweb.skia_canvas.external_texture;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class SkiaCanvasExternalTexturePlugin implements ISkiaCanvasExternalTextureController {
    private Map<ISkiaCanvasExternalTextureHandler, PluginLoadResult> mLoadResultMap = new ConcurrentHashMap();
    private Map<ISkiaCanvasExternalTextureHandler, Boolean> mSurfaceTextureAttachedMap = new ConcurrentHashMap();

    public abstract void onPluginInstanceDestroy(ISkiaCanvasExternalTextureHandler iSkiaCanvasExternalTextureHandler, int i2, String str);

    public abstract PluginLoadResult onPluginInstanceLoad(ISkiaCanvasExternalTextureHandler iSkiaCanvasExternalTextureHandler, String str, int i2, String str2);

    public abstract boolean supportType(String str);

    public PluginUpdateResult onPluginInstanceImageUpdate(ISkiaCanvasExternalTextureHandler iSkiaCanvasExternalTextureHandler, int i2, int i3) {
        Boolean bool = this.mSurfaceTextureAttachedMap.get(iSkiaCanvasExternalTextureHandler);
        PluginLoadResult pluginLoadResult = this.mLoadResultMap.get(iSkiaCanvasExternalTextureHandler);
        if (bool == null || !bool.booleanValue()) {
            pluginLoadResult.surfaceTexture.attachToGLContext(i2);
            this.mSurfaceTextureAttachedMap.put(iSkiaCanvasExternalTextureHandler, Boolean.TRUE);
        }
        pluginLoadResult.surfaceTexture.updateTexImage();
        float[] fArr = new float[16];
        pluginLoadResult.surfaceTexture.getTransformMatrix(fArr);
        return new PluginUpdateResult(fArr);
    }

    @Override // com.tencent.xweb.skia_canvas.external_texture.ISkiaCanvasExternalTextureController
    public void onDestroy(ISkiaCanvasExternalTextureHandler iSkiaCanvasExternalTextureHandler, String str, int i2, String str2) {
        onPluginInstanceDestroy(iSkiaCanvasExternalTextureHandler, i2, str2);
        this.mLoadResultMap.remove(iSkiaCanvasExternalTextureHandler);
        this.mSurfaceTextureAttachedMap.remove(iSkiaCanvasExternalTextureHandler);
    }

    @Override // com.tencent.xweb.skia_canvas.external_texture.ISkiaCanvasExternalTextureController
    public boolean load(ISkiaCanvasExternalTextureHandler iSkiaCanvasExternalTextureHandler, String str, int i2, String str2) {
        PluginLoadResult onPluginInstanceLoad = onPluginInstanceLoad(iSkiaCanvasExternalTextureHandler, str, i2, str2);
        if (onPluginInstanceLoad.surfaceTexture == null || onPluginInstanceLoad.height < 0 || onPluginInstanceLoad.width < 0) {
            return false;
        }
        onPluginInstanceLoad.surfaceTexture.setOnFrameAvailableListener(new PluginFrameAvailableListener(iSkiaCanvasExternalTextureHandler));
        onPluginInstanceLoad.surfaceTexture.setDefaultBufferSize(onPluginInstanceLoad.width, onPluginInstanceLoad.height);
        iSkiaCanvasExternalTextureHandler.onLoad(onPluginInstanceLoad.surfaceTexture, onPluginInstanceLoad.width, onPluginInstanceLoad.height);
        this.mLoadResultMap.put(iSkiaCanvasExternalTextureHandler, onPluginInstanceLoad);
        this.mSurfaceTextureAttachedMap.put(iSkiaCanvasExternalTextureHandler, Boolean.FALSE);
        return true;
    }

    @Override // com.tencent.xweb.skia_canvas.external_texture.ISkiaCanvasExternalTextureController
    public float[] updateImage(ISkiaCanvasExternalTextureHandler iSkiaCanvasExternalTextureHandler, int i2, String str, int i3, String str2) {
        return onPluginInstanceImageUpdate(iSkiaCanvasExternalTextureHandler, i2, i3).transform;
    }

    /* access modifiers changed from: package-private */
    public static class PluginFrameAvailableListener implements SurfaceTexture.OnFrameAvailableListener {
        private ISkiaCanvasExternalTextureHandler mHandler;

        PluginFrameAvailableListener(ISkiaCanvasExternalTextureHandler iSkiaCanvasExternalTextureHandler) {
            this.mHandler = iSkiaCanvasExternalTextureHandler;
        }

        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(4327);
            this.mHandler.onFrameAvailable();
            AppMethodBeat.o(4327);
        }
    }

    public static class PluginLoadResult {
        int height;
        SurfaceTexture surfaceTexture;
        int width;

        public PluginLoadResult(SurfaceTexture surfaceTexture2, int i2, int i3) {
            this.surfaceTexture = surfaceTexture2;
            this.width = i2;
            this.height = i3;
        }
    }

    public static class PluginUpdateResult {
        float[] transform;

        public PluginUpdateResult(float[] fArr) {
            this.transform = fArr;
        }
    }
}
