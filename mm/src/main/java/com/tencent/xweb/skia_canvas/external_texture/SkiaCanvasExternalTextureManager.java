package com.tencent.xweb.skia_canvas.external_texture;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SkiaCanvasExternalTextureManager implements ISkiaCanvasExternalTextureController {
    private static final String TAG = "ExternalTextureManager";
    private List<SkiaCanvasExternalTexturePlugin> mPluginList;

    public static SkiaCanvasExternalTextureManager getInstance() {
        return Holder.INSTANCE;
    }

    public synchronized void registerPlugin(SkiaCanvasExternalTexturePlugin skiaCanvasExternalTexturePlugin) {
        AppMethodBeat.i(4321);
        this.mPluginList.add(skiaCanvasExternalTexturePlugin);
        AppMethodBeat.o(4321);
    }

    @Override // com.tencent.xweb.skia_canvas.external_texture.ISkiaCanvasExternalTextureController
    public boolean load(ISkiaCanvasExternalTextureHandler iSkiaCanvasExternalTextureHandler, String str, int i2, String str2) {
        AppMethodBeat.i(174309);
        SkiaCanvasExternalTexturePlugin findPlugin = findPlugin(str);
        if (findPlugin != null) {
            boolean load = findPlugin.load(iSkiaCanvasExternalTextureHandler, str, i2, str2);
            AppMethodBeat.o(174309);
            return load;
        }
        AppMethodBeat.o(174309);
        return false;
    }

    @Override // com.tencent.xweb.skia_canvas.external_texture.ISkiaCanvasExternalTextureController
    public float[] updateImage(ISkiaCanvasExternalTextureHandler iSkiaCanvasExternalTextureHandler, int i2, String str, int i3, String str2) {
        AppMethodBeat.i(174310);
        SkiaCanvasExternalTexturePlugin findPlugin = findPlugin(str);
        if (findPlugin != null) {
            float[] updateImage = findPlugin.updateImage(iSkiaCanvasExternalTextureHandler, i2, str, i3, str2);
            AppMethodBeat.o(174310);
            return updateImage;
        }
        float[] fArr = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        AppMethodBeat.o(174310);
        return fArr;
    }

    @Override // com.tencent.xweb.skia_canvas.external_texture.ISkiaCanvasExternalTextureController
    public void onDestroy(ISkiaCanvasExternalTextureHandler iSkiaCanvasExternalTextureHandler, String str, int i2, String str2) {
        AppMethodBeat.i(174311);
        SkiaCanvasExternalTexturePlugin findPlugin = findPlugin(str);
        if (findPlugin != null) {
            findPlugin.onDestroy(iSkiaCanvasExternalTextureHandler, str, i2, str2);
        }
        AppMethodBeat.o(174311);
    }

    private synchronized SkiaCanvasExternalTexturePlugin findPlugin(String str) {
        SkiaCanvasExternalTexturePlugin skiaCanvasExternalTexturePlugin;
        AppMethodBeat.i(4325);
        Iterator<SkiaCanvasExternalTexturePlugin> it = this.mPluginList.iterator();
        while (true) {
            if (!it.hasNext()) {
                skiaCanvasExternalTexturePlugin = null;
                AppMethodBeat.o(4325);
                break;
            }
            skiaCanvasExternalTexturePlugin = it.next();
            if (skiaCanvasExternalTexturePlugin.supportType(str)) {
                AppMethodBeat.o(4325);
                break;
            }
        }
        return skiaCanvasExternalTexturePlugin;
    }

    private SkiaCanvasExternalTextureManager() {
        AppMethodBeat.i(4326);
        this.mPluginList = new ArrayList();
        AppMethodBeat.o(4326);
    }

    /* access modifiers changed from: package-private */
    public static final class Holder {
        static SkiaCanvasExternalTextureManager INSTANCE = new SkiaCanvasExternalTextureManager();

        private Holder() {
        }

        static {
            AppMethodBeat.i(4320);
            AppMethodBeat.o(4320);
        }
    }
}
