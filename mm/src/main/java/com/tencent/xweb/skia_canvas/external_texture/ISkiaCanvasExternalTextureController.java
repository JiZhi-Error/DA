package com.tencent.xweb.skia_canvas.external_texture;

public interface ISkiaCanvasExternalTextureController {
    boolean load(ISkiaCanvasExternalTextureHandler iSkiaCanvasExternalTextureHandler, String str, int i2, String str2);

    void onDestroy(ISkiaCanvasExternalTextureHandler iSkiaCanvasExternalTextureHandler, String str, int i2, String str2);

    float[] updateImage(ISkiaCanvasExternalTextureHandler iSkiaCanvasExternalTextureHandler, int i2, String str, int i3, String str2);
}
