package com.tencent.xweb.skia_canvas.external_texture;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePlugin;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate extends SkiaCanvasExternalTexturePlugin {
    private static final String TAG = "SETPluginWithSTDelegate";
    private Map<String, Map<Integer, InstanceDep>> mDepMap = new ConcurrentHashMap();

    /* access modifiers changed from: protected */
    public abstract void replaceDisplaySurface(int i2, String str, SurfaceTexture surfaceTexture);

    private Map<Integer, InstanceDep> getInstanceMapForCanvas(String str) {
        if (!this.mDepMap.containsKey(str)) {
            this.mDepMap.put(str, new ConcurrentHashMap());
        }
        return this.mDepMap.get(str);
    }

    /* access modifiers changed from: protected */
    public void registerInstance(int i2, String str, int i3, int i4, SurfaceTexture surfaceTexture) {
        getInstanceMapForCanvas(str).put(Integer.valueOf(i2), new InstanceDep(i3, i4, surfaceTexture));
    }

    /* access modifiers changed from: protected */
    public synchronized void onOriginSurfaceChanged(int i2, String str, SurfaceTexture surfaceTexture) {
        InstanceDep instanceDep = getInstanceMapForCanvas(str).get(Integer.valueOf(i2));
        if (!(instanceDep == null || instanceDep.delegate == null)) {
            instanceDep.delegate.removeDownStreamSurfaceTexture(instanceDep.originDisplaySurface);
            if (surfaceTexture != null) {
                instanceDep.delegate.addDownStreamSurfaceTexture(surfaceTexture);
                instanceDep.originDisplaySurface = surfaceTexture;
            }
        }
    }

    @Override // com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePlugin
    public synchronized SkiaCanvasExternalTexturePlugin.PluginLoadResult onPluginInstanceLoad(ISkiaCanvasExternalTextureHandler iSkiaCanvasExternalTextureHandler, String str, final int i2, final String str2) {
        SkiaCanvasExternalTexturePlugin.PluginLoadResult pluginLoadResult;
        final InstanceDep instanceDep = getInstanceMapForCanvas(str2).get(Integer.valueOf(i2));
        if (instanceDep == null) {
            pluginLoadResult = new SkiaCanvasExternalTexturePlugin.PluginLoadResult(null, -1, -1);
        } else {
            if (instanceDep.delegate == null) {
                initDelegateChain(instanceDep);
                new StringBuilder("replaceDisplaySurface from origin ").append(instanceDep.originDisplaySurface).append(" with id ").append(i2).append(" appTag ").append(str2);
                replaceDisplaySurface(i2, str2, instanceDep.delegatedUpStreamSurface);
                instanceDep.originDisplaySurface.setDefaultBufferSize(instanceDep.width, instanceDep.height);
                instanceDep.delegate.addReleaseCallback(new Runnable() {
                    /* class com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate.AnonymousClass1 */

                    public void run() {
                        AppMethodBeat.i(4328);
                        new StringBuilder("replaceDisplaySurface to origin ").append(instanceDep.originDisplaySurface).append(" with id ").append(i2).append(" appTag ").append(str2);
                        SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate.this.replaceDisplaySurface(i2, str2, instanceDep.originDisplaySurface);
                        for (ISkiaCanvasExternalTextureHandler iSkiaCanvasExternalTextureHandler : instanceDep.delegatedClonedDownStreamSurfaceMap.keySet()) {
                            SurfaceTexture surfaceTexture = instanceDep.delegatedClonedDownStreamSurfaceMap.get(iSkiaCanvasExternalTextureHandler);
                            if (surfaceTexture != null) {
                                surfaceTexture.release();
                            }
                        }
                        instanceDep.delegatedUpStreamSurface.release();
                        AppMethodBeat.o(4328);
                    }
                });
            }
            SurfaceTexture surfaceTexture = new SurfaceTexture(0);
            surfaceTexture.detachFromGLContext();
            new StringBuilder("add one more downstream surface ").append(surfaceTexture).append(" with id ").append(i2).append(" appTag ").append(str2);
            instanceDep.delegate.addDownStreamSurfaceTexture(surfaceTexture);
            instanceDep.delegatedClonedDownStreamSurfaceMap.put(iSkiaCanvasExternalTextureHandler, surfaceTexture);
            pluginLoadResult = new SkiaCanvasExternalTexturePlugin.PluginLoadResult(surfaceTexture, instanceDep.width, instanceDep.height);
        }
        return pluginLoadResult;
    }

    @Override // com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePlugin
    public synchronized void onPluginInstanceDestroy(ISkiaCanvasExternalTextureHandler iSkiaCanvasExternalTextureHandler, int i2, String str) {
        SurfaceTexture surfaceTexture;
        InstanceDep instanceDep = getInstanceMapForCanvas(str).get(Integer.valueOf(i2));
        if (!(instanceDep == null || (surfaceTexture = instanceDep.delegatedClonedDownStreamSurfaceMap.get(iSkiaCanvasExternalTextureHandler)) == null)) {
            instanceDep.delegate.removeDownStreamSurfaceTexture(surfaceTexture);
            int availableDownStreamCount = instanceDep.delegate.getAvailableDownStreamCount();
            new StringBuilder("last ").append(availableDownStreamCount).append(" downstream surface.");
            if (availableDownStreamCount == 1) {
                instanceDep.delegate.destroy();
                instanceDep.delegate = null;
            }
        }
    }

    private void initDelegateChain(InstanceDep instanceDep) {
        instanceDep.delegatedUpStreamSurface = new SurfaceTexture(0);
        instanceDep.delegatedUpStreamSurface.detachFromGLContext();
        instanceDep.delegate = new SurfaceTextureRenderDelegate(instanceDep.delegatedUpStreamSurface, instanceDep.originDisplaySurface);
    }

    /* access modifiers changed from: package-private */
    public static class InstanceDep {
        SurfaceTextureRenderDelegate delegate;
        Map<ISkiaCanvasExternalTextureHandler, SurfaceTexture> delegatedClonedDownStreamSurfaceMap = new HashMap();
        SurfaceTexture delegatedUpStreamSurface;
        final int height;
        SurfaceTexture originDisplaySurface;
        final int width;

        InstanceDep(int i2, int i3, SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(4329);
            this.width = i2;
            this.height = i3;
            this.originDisplaySurface = surfaceTexture;
            AppMethodBeat.o(4329);
        }
    }
}
