package com.tencent.mm.plugin.appbrand.game.f.a;

import android.opengl.EGLContext;
import com.tencent.mm.media.widget.camerarecordview.preview.f;
import kotlin.g.a.b;
import kotlin.x;

public interface d extends f {

    public interface a {
    }

    com.tencent.mm.media.j.a getAbsSurfaceRenderer();

    EGLContext getEGLContext();

    int getPreviewTextureId();

    int getSurfaceHeight();

    int getSurfaceWidth();

    boolean isAvailable();

    void setOnSurfaceTextureAvailableDelegate(a aVar);

    void setOnTextureDrawFinishDelegate(b<com.tencent.mm.media.g.d, x> bVar);

    void setPreviewRenderer(com.tencent.mm.media.j.a aVar);
}
